package com.codeforgeyt.onetomanywebservice.service;

import com.codeforgeyt.onetomanywebservice.model.Comentario;
import com.codeforgeyt.onetomanywebservice.model.exception.ComentarioNotFoundException;
import com.codeforgeyt.onetomanywebservice.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    @Autowired
    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public Comentario addComentario(Comentario comentario){
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> getComentarios(){
        return StreamSupport
                .stream(comentarioRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Comentario getComentario(Long id){
        return comentarioRepository.findById(id).orElseThrow(() ->
                new ComentarioNotFoundException(id));
    }

    public Comentario deleteComentario(Long id){
        Comentario comentario = getComentario(id);
        comentarioRepository.delete(comentario);
        return comentario;
    }

    @Transactional
    public Comentario editComentario(Long id, Comentario comentario){
        Comentario comentarioToEdit = getComentario(id);
        comentarioToEdit.setComentario(comentario.getComentario());
        return comentarioToEdit;
    }
}
