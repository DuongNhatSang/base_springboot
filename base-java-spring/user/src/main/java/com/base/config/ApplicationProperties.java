package com.base.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = true)
public class ApplicationProperties {
    private Security security;
    private Root root;

    @Getter
    @Setter
    public static class Security {
        private String secret;
        private long duration;
        private long durationRefreshToken;
    }

    @Getter
    @Setter
    public static class Root {
        private String email;
        private String password;
    }

}
