package com.codeforgeyt.onetomanywebservice.model.exception;

import java.text.MessageFormat;

public class DisciplinaNotFoundException extends RuntimeException {

    public DisciplinaNotFoundException(final Long id){
        super(MessageFormat.format("Could not find disciplina with id: {0}", id));
    }

}
