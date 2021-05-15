package com.codeforgeyt.onetomanywebservice.model;

import com.codeforgeyt.onetomanywebservice.model.dto.ComentarioDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comentario;
    @ManyToOne
    private Disciplina disciplina;

    public static Comentario from(ComentarioDto comentarioDto){
        Comentario comentario = new Comentario();
        comentario.setComentario(comentarioDto.getComentario());
        return comentario;
    }
}
