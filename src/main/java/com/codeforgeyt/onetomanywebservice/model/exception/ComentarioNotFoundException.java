package com.codeforgeyt.onetomanywebservice.model.exception;

import java.text.MessageFormat;

public class ComentarioNotFoundException extends RuntimeException {

    public ComentarioNotFoundException(final Long id){
        super(MessageFormat.format("Could not find comentario with id: {0}", id));
    }
}
