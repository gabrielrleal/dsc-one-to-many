package com.codeforgeyt.onetomanywebservice.model.dto;

import com.codeforgeyt.onetomanywebservice.model.Comentario;
import lombok.Data;

import java.util.Objects;

@Data
public class ComentarioDto {
    private Long id;
    private String comentario;
    private PlainDisciplinaDto plainDisciplinaDto;

    public static ComentarioDto from(Comentario comentario){
        ComentarioDto comentarioDto = new ComentarioDto();
        comentarioDto.setId(comentario.getId());
        comentarioDto.setComentario(comentario.getComentario());
        if(Objects.nonNull(comentario.getDisciplina())){
            comentarioDto.setPlainDisciplinaDto(PlainDisciplinaDto.from(comentario.getDisciplina()));
        }
        return comentarioDto;
    }
}
