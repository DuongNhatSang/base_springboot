package com.base.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = true)
public class CommonApplicationProperties {
    private Security security;
    private Root root;
    private Datasource datasource;

    @Getter
    @Setter
    public static class Security {
        private String secret;
        private long duration;
        private long durationRefreshToken;
        private String secretKeyPoint;
        private String crmKey;
    }

    @Getter
    @Setter
    public static class Root {
        private String email;
        private String password;
    }

    @Getter
    @Setter
    public static class Datasource {
        private String url;
        private String username;
        private String password;
    }

}
