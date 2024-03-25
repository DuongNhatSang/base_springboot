package com.base.api.v1.auth.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SignInRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
