package com.base.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.NumberUtils;

@Slf4j
public final class StringUtils
        extends org.springframework.util.StringUtils {

    public static final String EMPTY = "";

    private StringUtils() {
    }

    public static <T extends Number> T convertToNumber(final String value, final Class<T> targetClass) {
        if (isBlank(value)) {
            return null;
        }

        try {
            return NumberUtils.parseNumber(value, targetClass);
        } catch (IllegalArgumentException ex) {
            log.warn(ex.getMessage());
            return null;
        }
    }

    public static boolean isNotBlank(final String value) {
        return hasText(value);
    }

    public static boolean isBlank(final String value) {
        return !hasText(value);
    }
}
