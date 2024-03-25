package com.base.exception;

import com.base.enums.ExceptionEnum;

public final class ExceptionBuilder {

    private ExceptionBuilder() {
    }

    public static RuntimeException notFound(String message) {
        return new RuntimeException(ExceptionEnum.ErrorCode.NOT_FOUND.getCode(), new Throwable(message));
    }

    public static Exception invalidState(String message) {
        return new RuntimeException(ExceptionEnum.ErrorCode.INVALID_STATE.getCode(), new Throwable(message));
    }

    public static RuntimeException forHttpRequestError(String message) {
        return new RuntimeException(ExceptionEnum.ErrorCode.HTTP_REQUEST_ERROR.getCode(), new Throwable(message));
    }

    public static RuntimeException errorSystem(String message) {
        return new RuntimeException(ExceptionEnum.ErrorCode.ERROR_SYSTEM.getCode(), new Throwable(message));
    }

    public static RuntimeException build(String code, String message) {
        return new RuntimeException(code, new Throwable(message));
    }

    public static Exception badRequest(String message) {
        return new RuntimeException(ExceptionEnum.ErrorCode.BAD_REQUEST.getCode(), new Throwable(message));
    }

    public static RuntimeException forInvalidEnumValue(final String enumValue) {
        return new RuntimeException(ExceptionEnum.ErrorCode.INVALID_ENUM_VALUE.getCode(), new Throwable(enumValue));
    }

    public static RuntimeException forInvalidData(final String message) {
        return new RuntimeException(ExceptionEnum.ErrorCode.INVALID_DATA.getCode(), new Throwable(message));
    }

    public static RuntimeException forResourceBusy(final String message) {
        return new RuntimeException(ExceptionEnum.ErrorCode.RESOURCE_TEMPORARY_OUT.getCode(), new Throwable(message));
    }
}
