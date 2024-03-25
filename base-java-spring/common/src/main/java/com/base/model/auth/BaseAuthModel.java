package com.base.model.auth;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseAuthModel {
        @Id
        @Column
        private String id;

        @CreationTimestamp
        @Column(nullable = false, updatable = false,
                columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
        private Instant createdAt;

        @UpdateTimestamp
        @Column(nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
        private Instant updatedAt;
}
