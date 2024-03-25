package com.base.dto.v1.response;

import com.base.util.constants.Constants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


/**
 * DataResponse
 *
 */
@Getter
@Setter
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataResponse<T> {

    private Integer code;
    private String error;
    private String message;
    private Boolean status = false;

    private T data;

    public static <T> DataResponse<T> okStatus() {
        return new DataResponse<T>(HttpStatus.OK.value(), null, Constants.MSG_DONE, true, null);
    }

    public static <T> DataResponse<T> okStatus(final T data) {
        return new DataResponse<T>(HttpStatus.OK.value(), null, Constants.MSG_DONE, true, data);
    }

    public static <T> DataResponse<T> build(final HttpStatus status, final String message, final T data) {
        return new DataResponse<>(status.value(), null, message, HttpStatus.OK.value() == status.value(), data);
    }

    public static <T> DataResponse<T> build(final boolean status, final String message, final T data) {
        return new DataResponse<>(HttpStatus.OK.value(), null, message, status, data);
    }

    public static <T> DataResponse<T> badRequest(final String error, final String message, final T data) {
        return new DataResponse<>(HttpStatus.BAD_REQUEST.value(), error, message, false, data);
    }
}
