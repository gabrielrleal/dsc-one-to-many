package com.codeforgeyt.onetomanywebservice.controller;

import com.codeforgeyt.onetomanywebservice.model.Disciplina;
import com.codeforgeyt.onetomanywebservice.model.dto.DisciplinaDto;
import com.codeforgeyt.onetomanywebservice.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @Autowired
    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @PostMapping
    public ResponseEntity<DisciplinaDto> addDisciplina(@RequestBody final DisciplinaDto disciplinaDto){
        Disciplina disciplina = disciplinaService.addDisciplina(Disciplina.from(disciplinaDto));
        return new ResponseEntity<>(DisciplinaDto.from(disciplina), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaDto>> getDisciplinas(){
        List<Disciplina> disciplinas = disciplinaService.getDisciplinas();
        List<DisciplinaDto> disciplinasDto = disciplinas.stream().map(DisciplinaDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(disciplinasDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<DisciplinaDto> getDisciplina(@PathVariable final Long id){
        Disciplina disciplina = disciplinaService.getDisciplina(id);
        return new ResponseEntity<>(DisciplinaDto.from(disciplina), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<DisciplinaDto> deleteDisciplina(@PathVariable final Long id){
        Disciplina disciplina = disciplinaService.deleteDisciplina(id);
        return new ResponseEntity<>(DisciplinaDto.from(disciplina), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<DisciplinaDto> editDisciplina(@PathVariable final Long id,
                                                  @RequestBody final DisciplinaDto disciplinaDto){
        Disciplina disciplina = disciplinaService.editDisciplina(id, Disciplina.from(disciplinaDto));
        return new ResponseEntity<>(DisciplinaDto.from(disciplina), HttpStatus.OK);
    }

    @PostMapping(value = "{disciplinaId}/comentarios/{comentarioId}/add")
    public ResponseEntity<DisciplinaDto> addComentarioToDisciplina(@PathVariable final Long disciplinaId,
                                                       @PathVariable final Long comentarioId){
        Disciplina disciplina = disciplinaService.addComentarioToDisciplina(disciplinaId, comentarioId);
        return new ResponseEntity<>(DisciplinaDto.from(disciplina), HttpStatus.OK);
    }

    @DeleteMapping(value = "{disciplinaId}/comentarios/{comentarioId}/remove")
    public ResponseEntity<DisciplinaDto> removeComentarioFromDisciplina(@PathVariable final Long disciplinaId,
                                                            @PathVariable final Long comentarioId){
        Disciplina disciplina = disciplinaService.removeComentarioFromDisciplina(disciplinaId, comentarioId);
        return new ResponseEntity<>(DisciplinaDto.from(disciplina), HttpStatus.OK);
    }
}
