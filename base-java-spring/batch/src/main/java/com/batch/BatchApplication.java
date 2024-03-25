package com.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.base.config.CommonApplicationProperties;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableScheduling
@SpringBootApplication
@EnableConfigurationProperties({ CommonApplicationProperties.class })
@EnableBatchProcessing
@EntityScan(basePackages = { "com.base.model" })
@EnableJpaRepositories(basePackages = { "com.base.repository", "com.base.api" })
@ComponentScan(basePackages = { "com.base.service", "com.base.mapper", "com.base.util", "com.batch" })
public class BatchApplication {
    protected BatchApplication() {
    }

    public static void main(final String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }

    @PostConstruct
    public void init() {
        // Setting Spring Boot SetTimeZone
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}
