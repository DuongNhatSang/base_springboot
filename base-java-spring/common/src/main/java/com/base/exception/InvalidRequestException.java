package com.base.exception;

import org.springframework.validation.Errors;

public class InvalidRequestException
    extends RuntimeException {

    private final Errors errors;

    public InvalidRequestException(final Errors errors) {
        super("");
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
