package com.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.base.util.constants.Constants;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
@ResponseStatus(HttpStatus.FORBIDDEN)
public class NoAuthorizationException extends RuntimeException {
    private String code;
    private String message;

    public static NoAuthorizationException userBlocked() {
        return new NoAuthorizationException(Constants.ERR_USER_BLOCKED, Constants.MSG_USER_IS_BLOCKED);
    }

    public static NoAuthorizationException userInActive() {
        return new NoAuthorizationException(Constants.ERR_USER_INACTIVE, Constants.MSG_USER_IS_INACTIVE);
    }
}
