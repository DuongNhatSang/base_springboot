package com.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccessTokenStatusEnum implements CodeEnum<Integer> {
    IS_CREATED(0, "IS_CREATED"),
    IS_USING(1, "IS_USING"),
    IS_DELETE(2, "IS_DELETE");

    private final Integer code;
    private final String display;
}
