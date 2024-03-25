package com.base.config.security;

import org.springframework.security.core.context.SecurityContextHolder;

import com.base.config.security.jwt.service.UserInfoDetails;

public final class SecurityContextProvider {
    private SecurityContextProvider() {
    }

    public static String getToken() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            return null;
        }
        return SecurityContextHolder.getContext().getAuthentication().getCredentials().toString();
    }

    public static String getUserWalletId() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            return null;
        }
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public static UserInfoDetails getUserPrincipal() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        return (UserInfoDetails) auth.getPrincipal();
    }

    public static String getUserId() {
        var principal = getUserPrincipal();
        return principal.getId();
    }
}
