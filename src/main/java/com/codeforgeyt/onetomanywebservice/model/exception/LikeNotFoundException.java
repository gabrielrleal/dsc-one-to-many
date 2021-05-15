package com.codeforgeyt.onetomanywebservice.model.exception;

import java.text.MessageFormat;

public class LikeNotFoundException extends RuntimeException {

    public LikeNotFoundException(final Long id){
        super(MessageFormat.format("Could not find Like with id: {0}", id));
    }
}
