package com.codeforgeyt.onetomanywebservice.model.exception;

import java.text.MessageFormat;

public class DisciplinaIsAlreadyAssignedException extends RuntimeException{
    public DisciplinaIsAlreadyAssignedException(final Long comentarioId, final Long disciplinaId){
        super(MessageFormat.format("Comentario: {0} is already assigned to disciplina: {1}", comentarioId, disciplinaId));
    }
}
