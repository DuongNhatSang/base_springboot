package com.base.enums.util;

import com.base.enums.CodeEnum;

import java.util.Arrays;
import java.util.function.Supplier;

public final class CodeEnumHelper {

    public static <T, R extends Enum<R> & CodeEnum<T>> R fromCodeToEnum(final Class<R> clazz, final T value) {
        return Arrays.stream(clazz.getEnumConstants())
                .filter(e -> e.getCode().equals(value))
                .findFirst()
                .orElse(null);
    }

    public static <T, R extends Enum<R> & CodeEnum<T>> R fromCodeToEnum(final Class<R> clazz,
                                                                        final T value,
                                                                        final R fallback) {
        return Arrays.stream(clazz.getEnumConstants())
                .filter(e -> e.getCode().equals(value))
                .findFirst()
                .orElse(fallback);
    }

    public static <T, R extends Enum<R> & CodeEnum<T>> R fromCodeToEnum(final Class<R> clazz,
                                                                        final T value,
                                                                        final Supplier<R> fallback) {
        return Arrays.stream(clazz.getEnumConstants())
                .filter(e -> e.getCode().equals(value))
                .findFirst()
                .orElse(fallback.get());
    }

    private CodeEnumHelper() {

    }
}
