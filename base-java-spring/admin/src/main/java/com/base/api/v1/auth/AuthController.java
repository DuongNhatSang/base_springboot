package com.base.api.v1.auth;

import com.base.api.v1.auth.dto.request.SignInRequest;
import com.base.service.v1.AuthService;
import com.base.dto.v1.response.DataResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @ApiOperation("Sign In")
    @PostMapping("/sign-in")
    public DataResponse signIn(@Valid @RequestBody SignInRequest request) throws Exception {
        return DataResponse.okStatus(authService.signIn(request));
    }
}

