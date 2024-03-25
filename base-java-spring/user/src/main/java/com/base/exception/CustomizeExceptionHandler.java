package com.base.exception;

import com.base.dto.v1.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@RestControllerAdvice
public class CustomizeExceptionHandler
        extends ResponseEntityExceptionHandler {

    /**
     * Handler unknown exception.
     *
     * @param e exception
     * @return error response
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(final Exception e) {
        //-- Not trace log
//        if (!ERROR_NOT_TRACE_LOG.contains(e.getMessage())) {
//            log.error(e.getMessage(), e);
//            log.error("[ERROR]: " + (e.getStackTrace().length > 0 ? e.getStackTrace()[0].toString() : ""));
//        }

        ErrorResponse error = ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .error(e.getMessage())
                .message(e.getCause() != null ? e.getCause().getMessage() : e.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidRequestException.class})
    public ResponseEntity<Object> handleInvalidRequest(final InvalidRequestException ex, final WebRequest request) {

        List<FieldErrorResource> errorResources =
                ex.getErrors().getFieldErrors().stream()
                        .map(
                                fieldError ->
                                        new FieldErrorResource(
                                                fieldError.getObjectName(),
                                                fieldError.getField(),
                                                fieldError.getCode(),
                                                fieldError.getDefaultMessage()))
                        .collect(Collectors.toList());

        ErrorResponse error = ErrorResponse.builder()
                .code(UNPROCESSABLE_ENTITY.value())
                .error(ex.getMessage())
                .message(ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage())
                .data(errorResources)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            final MethodArgumentNotValidException e, final HttpHeaders headers,
            final HttpStatus status, final WebRequest request) {

        List<FieldErrorResource> errorResources =
                e.getBindingResult().getFieldErrors().stream()
                        .map(
                                fieldError ->
                                        new FieldErrorResource(
                                                fieldError.getObjectName(),
                                                fieldError.getField(),
                                                fieldError.getCode(),
                                                fieldError.getDefaultMessage()))
                        .collect(Collectors.toList());

        ErrorResponse error = ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .error("ARGUMENT_NOT_VALID")
                .message("Argument Not Valid")
                .data(errorResources)
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ResponseStatus(UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorResource handleConstraintViolation(final ConstraintViolationException ex) {
        List<FieldErrorResource> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            FieldErrorResource fieldErrorResource =
                    new FieldErrorResource(
                            violation.getRootBeanClass().getName(),
                            getParam(violation.getPropertyPath().toString()),
                            violation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName(),
                            violation.getMessage());
            errors.add(fieldErrorResource);
        }

        return new ErrorResource(errors);
    }

    private String getParam(final String s) {
        String[] splits = s.split("\\.");
        if (splits.length == 1) {
            return s;
        } else {
            return String.join(".", Arrays.copyOfRange(splits, 2, splits.length));
        }
    }
}
