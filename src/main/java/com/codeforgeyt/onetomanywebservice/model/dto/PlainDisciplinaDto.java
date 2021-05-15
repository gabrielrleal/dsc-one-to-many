package com.codeforgeyt.onetomanywebservice.model.dto;

import com.codeforgeyt.onetomanywebservice.model.Disciplina;
import lombok.Data;

@Data
public class PlainDisciplinaDto {
    private Long id;
    private String name;

    public static PlainDisciplinaDto from(Disciplina disciplina){
        PlainDisciplinaDto plainDisciplinaDto = new PlainDisciplinaDto();
        plainDisciplinaDto.setId(disciplina.getId());
        plainDisciplinaDto.setName(disciplina.getName());
        return plainDisciplinaDto;
    }
}
