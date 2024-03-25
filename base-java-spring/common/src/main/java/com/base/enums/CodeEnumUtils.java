package com.base.enums;

import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode
public final class CodeEnumUtils {

    private CodeEnumUtils() {

    }

    public static <T extends Enum<T>> T fromEnum(final Class<T> clazz, String e) {
        return Enum.valueOf(clazz, e.toUpperCase());
    }

    public static <T extends CodeEnum> List<T> toList(final Class<T> clazz) {
        T[] enums = clazz.getEnumConstants();
        List<T> result = new ArrayList<T>(enums.length);

        Collections.addAll(result, enums);

        return result;
    }

    public static <T extends CodeEnum> T fromCode(final Class<T> clazz, final String code) {
        if (Objects.isNull(code)) {
            return null;
        }

        T[] values = clazz.getEnumConstants();
        for (T t : values) {
            if (t.getCode().equals(code)) {
                return t;
            }
        }
        throw new IllegalArgumentException("IllegalArgumentException:"
                + code
                + " "
                + clazz.getCanonicalName());
    }

    public static <T extends CodeEnum> boolean hasCode(final Class<T> clazz, final String code) {
        T[] values = clazz.getEnumConstants();
        for (T t : values) {
            if (t.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    public static <T extends CodeEnum> T fromCodeQuietly(final Class<T> clazz, final String code) {
        if (Objects.isNull(code)) {
            return null;
        }

        T[] values = clazz.getEnumConstants();
        for (T t : values) {
            if (t.getCode().equals(code)) {
                return t;
            }
        }
        return null;
    }

    public static <T extends CodeEnum> T fromDisplay(final Class<T> clazz, final String display) {

        if (StringUtils.isEmpty(display)) {
            return null;
        }

        T[] values = clazz.getEnumConstants();
        for (T t : values) {
            if (StringUtils.equals(t.getDisplay(), display)) {
                return t;
            }
        }
        throw new IllegalArgumentException("IllegalArgumentException:"
                + display
                + " "
                + clazz.getCanonicalName());
    }

    public static <T extends CodeEnum> T fromDisplayIgnorecase(final Class<T> clazz, final String display) {

        if (StringUtils.isEmpty(display)) {
            return null;
        }

        T[] values = clazz.getEnumConstants();
        for (T t : values) {
            if (StringUtils.equalsIgnoreCase(t.getDisplay(), display)) {
                return t;
            }
        }
        throw new IllegalArgumentException("IllegalArgumentException:"
                + display
                + " "
                + clazz.getCanonicalName());
    }

    public static <T extends CodeEnum> boolean hasDisplay(final Class<T> clazz, final String display) {
        T[] values = clazz.getEnumConstants();
        for (T t : values) {
            if (StringUtils.equals(t.getDisplay(), display)) {
                return true;
            }
        }
        return false;
    }

    public static <T extends CodeEnum> T fromDisplayQuietly(final Class<T> clazz, final String display) {

        if (StringUtils.isEmpty(display)) {
            return null;
        }

        T[] values = clazz.getEnumConstants();
        for (T t : values) {
            if (StringUtils.equals(t.getDisplay(), display)) {
                return t;
            }
        }
        return null;
    }

    public static <T extends CodeEnum> boolean isCodeEnum(final Class<T> clazz, final String code) {
        if (code == null) {
            return false;
        }

        boolean ret = false;
        T[] codeEnums = clazz.getEnumConstants();
        for (CodeEnum codeEnum : codeEnums) {
            if (code.equals(codeEnum.getCode())) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    public static <T extends CodeEnum> boolean isDisplayCodeEnum(final Class<T> clazz, final String display) {
        if (display == null) {
            return false;
        }

        boolean ret = false;
        T[] codeEnums = clazz.getEnumConstants();
        for (CodeEnum codeEnum : codeEnums) {
            if (display.equals(codeEnum.getDisplay())) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    public static <T extends CodeEnum> boolean isValidEnum(final Class<T> clazz, final String code) {
        if (Objects.isNull(code)) {
            return true;
        }
        return isCodeEnum(clazz, code);
    }

    public static <T> List<T> valueList(final Class<T> clazz) {
        T[] codeEnums = clazz.getEnumConstants();
        List<T> resultList = new ArrayList<T>();
        Collections.addAll(resultList, codeEnums);
        return resultList;
    }

    public static <T extends CodeEnum> List<T> valueList(final Class<T> clazz, final String[] codes) {
        if (Objects.isNull(codes)) {
            return Collections.emptyList();
        }
        List<T> resultList = new ArrayList<T>();
        for (String code : codes) {
            resultList.add(fromCode(clazz, code));
        }
        return resultList;
    }

    public static <T extends CodeEnum> boolean equals(final T t, final String code) {
        if (Objects.isNull(t) || Objects.isNull(code)) {
            return false;
        }
        return t.getCode().equals(code);
    }

    public static <T extends CodeEnum> boolean contains(final List<T> list, final String code) {
        if (list == null || code == null) {
            return false;
        }
        for (T t : list) {
            if (t.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }
}
