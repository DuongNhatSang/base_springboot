package com.base.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FieldErrorResource {
    private final String resource;
    private final String field;
    private final String code;
    private final String message;
}
