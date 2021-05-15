package com.codeforgeyt.onetomanywebservice.controller;

import com.codeforgeyt.onetomanywebservice.model.Comentario;
import com.codeforgeyt.onetomanywebservice.model.dto.ComentarioDto;
import com.codeforgeyt.onetomanywebservice.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    @Autowired
    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    public ResponseEntity<ComentarioDto> addComentario(@RequestBody final ComentarioDto comentarioDto){
        Comentario comentario = comentarioService.addComentario(Comentario.from(comentarioDto));
        return new ResponseEntity<>(ComentarioDto.from(comentario), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ComentarioDto>> getComentarios(){
        List<Comentario> comentarios = comentarioService.getComentarios();
        List<ComentarioDto> comentariosDto = comentarios.stream().map(ComentarioDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(comentariosDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ComentarioDto> getComentario(@PathVariable final Long id){
        Comentario comentario = comentarioService.getComentario(id);
        return new ResponseEntity<>(ComentarioDto.from(comentario), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<ComentarioDto> deleteComentario(@PathVariable final Long id){
        Comentario comentario = comentarioService.deleteComentario(id);
        return new ResponseEntity<>(ComentarioDto.from(comentario), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<ComentarioDto> editComentario(@PathVariable final Long id,
                                                  @RequestBody final ComentarioDto comentarioDto){
        Comentario editedComentario = comentarioService.editComentario(id, Comentario.from(comentarioDto));
        return new ResponseEntity<>(ComentarioDto.from(editedComentario), HttpStatus.OK);
    }
}
