package com.base.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableConfigurationProperties({CommonApplicationProperties.class})
@EnableJpaRepositories(basePackages = {"com.base.repository"})
@EntityScan(basePackages = {"com.base.model"})
@EnableJpaAuditing
public class ApplicationConfig {
}
