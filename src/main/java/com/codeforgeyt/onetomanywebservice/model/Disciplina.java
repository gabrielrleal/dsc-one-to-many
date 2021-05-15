package com.codeforgeyt.onetomanywebservice.model;

import com.codeforgeyt.onetomanywebservice.model.dto.DisciplinaDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Disciplina")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "disciplina_id")
    private List<Comentario> comentarios = new ArrayList<>();

    public void addComentario(Comentario comentario){
        comentarios.add(comentario);
    }

    public void removeComentario(Comentario comentario){
        comentarios.remove(comentario);
    }

    public static Disciplina from(DisciplinaDto disciplinaDto){
        Disciplina disciplina = new Disciplina();
        disciplina.setName(disciplinaDto.getName());
        return disciplina;
    }
}
