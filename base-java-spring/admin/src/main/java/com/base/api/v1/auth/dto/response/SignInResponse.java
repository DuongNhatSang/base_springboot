package com.base.api.v1.auth.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInResponse {

    private String accessToken;
    private String refreshToken;
    private Long expiredAt;
    private String userId;
}
