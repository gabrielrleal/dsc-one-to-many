package com.codeforgeyt.onetomanywebservice.model.dto;

import com.codeforgeyt.onetomanywebservice.model.Like;
import lombok.Data;

import java.util.Objects;

@Data
public class LikeDto {
    private Long id;
    private String like;
    private PlainDisciplinaDto plainDisciplinaDto;

    public static LikeDto from(Like like){
        LikeDto likeDto = new LikeDto();
        likeDto.setId(like.getId());
        likeDto.setLike(like.getLike());
        if(Objects.nonNull(like.getDisciplina())){
            likeDto.setPlainDisciplinaDto(PlainDisciplinaDto.from(like.getDisciplina()));
        }
        return likeDto;
    }
}
