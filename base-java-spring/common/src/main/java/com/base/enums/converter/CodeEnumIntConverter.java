package com.base.enums.converter;

import com.base.enums.CodeEnum;
import com.base.enums.CodeEnumIntUtils;

import javax.persistence.AttributeConverter;
import java.util.Objects;

public abstract class CodeEnumIntConverter<X extends CodeEnum<Integer>>
        implements AttributeConverter<X, Integer> {

    @Override
    public Integer convertToDatabaseColumn(final X attribute) {
        if (Objects.isNull(attribute)) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public X convertToEntityAttribute(final Integer dbData) {
        if (Objects.isNull(dbData)) {
            return null;
        }
        return CodeEnumIntUtils.fromCodeQuietly(enumClass(), dbData);
    }

    protected abstract Class<X> enumClass();
}
