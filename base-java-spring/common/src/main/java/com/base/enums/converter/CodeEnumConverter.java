package com.base.enums.converter;

import com.base.enums.CodeEnum;
import com.base.enums.CodeEnumUtils;

import javax.persistence.AttributeConverter;
import java.util.Objects;

public abstract class CodeEnumConverter<X extends CodeEnum<String>>
        implements AttributeConverter<X, String> {

    @Override
    public String convertToDatabaseColumn(final X attribute) {
        if (Objects.isNull(attribute)) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public X convertToEntityAttribute(final String dbData) {
        if (Objects.isNull(dbData)) {
            return null;
        }
        return CodeEnumUtils.fromCodeQuietly(enumClass(), dbData);
    }

    protected abstract Class<X> enumClass();
}
