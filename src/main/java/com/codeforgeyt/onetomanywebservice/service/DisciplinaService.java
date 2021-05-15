package com.codeforgeyt.onetomanywebservice.service;

import com.codeforgeyt.onetomanywebservice.model.Disciplina;
import com.codeforgeyt.onetomanywebservice.model.Comentario;
import com.codeforgeyt.onetomanywebservice.model.exception.DisciplinaNotFoundException;
import com.codeforgeyt.onetomanywebservice.model.exception.DisciplinaIsAlreadyAssignedException;
import com.codeforgeyt.onetomanywebservice.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;
    private final ComentarioService comentarioService;

    @Autowired
    public DisciplinaService(DisciplinaRepository disciplinaRepository, ComentarioService comentarioService) {
        this.disciplinaRepository = disciplinaRepository;
        this.comentarioService = comentarioService;
    }

    public Disciplina addDisciplina(Disciplina disciplina){
        return disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> getDisciplinas(){
        return StreamSupport
                .stream(disciplinaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Disciplina getDisciplina(Long id){
        return disciplinaRepository.findById(id).orElseThrow(() ->
                new DisciplinaNotFoundException(id));
    }

    public Disciplina deleteDisciplina(Long id){
        Disciplina disciplina = getDisciplina(id);
        disciplinaRepository.delete(disciplina);
        return disciplina;
    }

    @Transactional
    public Disciplina editDisciplina(Long id, Disciplina disciplina){
        Disciplina disciplinaToEdit = getDisciplina(id);
        disciplinaToEdit.setName(disciplina.getName());
        return disciplinaToEdit;
    }

    @Transactional
    public Disciplina addComentarioToDisciplina(Long disciplinaId, Long comentarioId){
        Disciplina disciplina = getDisciplina(disciplinaId);
        Comentario comentario = comentarioService.getComentario(comentarioId);
        if(Objects.nonNull(comentario.getDisciplina())){
            throw new DisciplinaIsAlreadyAssignedException(comentarioId,
                    comentario.getDisciplina().getId());
        }
        disciplina.addComentario(comentario);
        comentario.setDisciplina(disciplina);
        return disciplina;
    }

    @Transactional
    public Disciplina removeComentarioFromDisciplina(Long disciplinaId, Long comentarioId){
        Disciplina disciplina = getDisciplina(disciplinaId);
        Comentario comentario = comentarioService.getComentario(comentarioId);
        disciplina.removeComentario(comentario);
        return disciplina;
    }
}
