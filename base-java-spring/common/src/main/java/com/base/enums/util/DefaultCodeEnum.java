package com.base.enums.util;

import com.base.enums.CodeEnum;

public interface DefaultCodeEnum<T> extends CodeEnum<T> {
    @Override
    default String getDisplay() {
        return this.toString();
    }
}
