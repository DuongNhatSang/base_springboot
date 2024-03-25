package com.base.enums.converter;

import com.base.enums.AuthMethodEnum;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class AuthMethodConverter extends CodeEnumIntConverter<AuthMethodEnum> {

    @Override
    protected Class<AuthMethodEnum> enumClass() {
        return AuthMethodEnum.class;
    }
}