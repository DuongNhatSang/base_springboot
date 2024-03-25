package com.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AuthMethodEnum implements CodeEnum<Integer> {
    EMAIL_PASSWORD(0, "EMAIL_PASSWORD"),
    WALLET(1, "WALLET"),
    WEB3_AUTH(2, "WEB3_AUTH"),
    AUTH_SERVER(3, "AUTH_SERVER");

    private final Integer code;
    private final String display;
}
