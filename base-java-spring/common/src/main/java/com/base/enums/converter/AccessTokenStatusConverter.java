package com.base.enums.converter;

import com.base.enums.AccessTokenStatusEnum;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class AccessTokenStatusConverter extends CodeEnumIntConverter<AccessTokenStatusEnum> {

    @Override
    protected Class<AccessTokenStatusEnum> enumClass() {
        return AccessTokenStatusEnum.class;
    }
}