package com.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class AuthUserEnum {

    @Getter
    @AllArgsConstructor
    public enum Status {
        ASYNCHRONOUS(-1, "ASYNCHRONOUS"),
        INACTIVE(0, "INACTIVE"),
        ACTIVE(1, "ACTIVE"),
        BLOCKED(2, "BLOCKED");

        private final Integer code;
        private final String display;
    }
}
