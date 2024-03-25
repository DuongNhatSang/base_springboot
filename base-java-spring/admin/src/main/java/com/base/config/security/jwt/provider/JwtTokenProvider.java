package com.base.config.security.jwt.provider;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.base.config.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.base.config.security.jwt.service.UserInfoDetails;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

@Service
public class JwtTokenProvider implements Serializable {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer";

    @Autowired
    private ApplicationProperties properties;

    public String generatedJwt(String id, String username) {
        Date date = new Date();
        String encodeSecret = TextCodec.BASE64.encode(properties.getSecurity().getSecret());
        return Jwts.builder()
                .setId(id)
                .setSubject(username)
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime() + properties.getSecurity().getDuration()))
                .signWith(SignatureAlgorithm.HS512, encodeSecret)
                .compact();
    }

    public String generatedRefreshJwt(String id, String username) {
        Date date = new Date();
        String encodeSecret = TextCodec.BASE64.encode(properties.getSecurity().getSecret());
        return Jwts.builder()
                .setId(id)
                .setSubject(username)
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime() + properties.getSecurity().getDurationRefreshToken()))
                .signWith(SignatureAlgorithm.HS512, encodeSecret)
                .compact();
    }

    public boolean validRefreshToken(String refreshToken) {
        return this.validateToken(refreshToken);
    }

    public String getUserId(String token) {
        String encodeSecret = TextCodec.BASE64.encode(properties.getSecurity().getSecret());
        return Jwts.parser()
                .setSigningKey(encodeSecret)
                .parseClaimsJws(token)
                .getBody()
                .getId();
    }

    public boolean validateToken(String token) {
        try {
            String encodeSecret = TextCodec.BASE64.encode(properties.getSecurity().getSecret());
            Jwts.parser().setSigningKey(encodeSecret).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Get token from header
     *
     */
    public String getToken(HttpServletRequest request) {
        final String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER);
        if (authorizationHeader != null && authorizationHeader.startsWith(TOKEN_PREFIX + " ")) {
            return authorizationHeader.substring(7);
        }
        return null;
    }

    public static Optional<UserInfoDetails> getCurrentUserInfo() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication()).map(authentication -> {
            if (authentication.getPrincipal() instanceof UserInfoDetails) {
                return (UserInfoDetails) authentication.getPrincipal();
            }
            return null;
        });
    }
}
