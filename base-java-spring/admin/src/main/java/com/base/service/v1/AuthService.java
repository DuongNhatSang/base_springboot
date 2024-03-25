package com.base.service.v1;

import com.base.api.v1.auth.dto.request.SignInRequest;
import com.base.api.v1.auth.dto.response.SignInResponse;
import com.base.config.security.jwt.provider.JwtTokenProvider;
import com.base.exception.ExceptionBuilder;
import com.base.model.User;
import com.base.repository.CommonUserRepository;
import com.base.util.constants.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final CommonUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    public SignInResponse signIn(SignInRequest request) throws Exception {
        this.isEmail(request.getEmail());
        User user = userRepository.findByEmailAndDeletedAtIsNull(request.getEmail()).orElseThrow(
                () -> ExceptionBuilder.notFound("User not found"));

        boolean valid = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if (!valid) {
            throw ExceptionBuilder.invalidState("Password doesn't matched!");
        }

        SignInResponse dto = new SignInResponse();
        dto.setUserId(user.getId());
        dto.setExpiredAt(new Date().getTime());
        dto.setAccessToken(jwtTokenProvider.generatedJwt(user.getId(), user.getEmail()));
        dto.setRefreshToken(jwtTokenProvider.generatedRefreshJwt(user.getId(), user.getEmail()));
        return dto;
    }

    /**
     * Check email in right format
     *
     * @param email email
     */
    public void isEmail(String email) throws Exception {
        String regex = Constants.EMAIL_PATTERN;
        if (!email.matches(regex)) {
            throw ExceptionBuilder.badRequest(Constants.MSG_EMAIL_INVALID_FORMAT);
        }
    }
}
