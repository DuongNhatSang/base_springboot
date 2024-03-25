package com.base.dto.v1.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonRootName("data")
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class ErrorResponse<T> {
    private int code;
    private String error;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
}
