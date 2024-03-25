package com.base.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.util.List;

@Data
@JsonRootName("data")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResource {
    private final List<FieldErrorResource> errors;
}
