package com.codeforgeyt.onetomanywebservice.model;
import com.codeforgeyt.onetomanywebservice.model.dto.LikeDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Like")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Like;
    @ManyToOne
    private Disciplina disciplina;

    public static Like from(LikeDto likeDto){
        Like like = new Like();
        like.setLike(likeDto.getLike());
        return like;
    }
}
