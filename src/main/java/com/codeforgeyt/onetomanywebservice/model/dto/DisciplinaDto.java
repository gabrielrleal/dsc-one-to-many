package com.codeforgeyt.onetomanywebservice.model.dto;

import com.codeforgeyt.onetomanywebservice.model.Disciplina;
import com.codeforgeyt.onetomanywebservice.model.Comentario;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DisciplinaDto {
    private Long id;
    private String name;
    private List<ComentarioDto> comentariosDto = new ArrayList<>();

    public static DisciplinaDto from(Disciplina disciplina){
        DisciplinaDto disciplinaDto = new DisciplinaDto();
        disciplinaDto.setId(disciplina.getId());
        disciplinaDto.setName(disciplina.getName());
        disciplinaDto.setComentariosDto(disciplina.getComentarios().stream().map(ComentarioDto::from).collect(Collectors.toList()));
        return disciplinaDto;
    }
}
