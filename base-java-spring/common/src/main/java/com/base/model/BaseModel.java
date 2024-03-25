package com.base.model;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
        @Id
        @Column
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String id;

        @CreationTimestamp
        @Column(nullable = false, updatable = false,
                columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
        private Instant createdAt;

        @UpdateTimestamp
        @Column(nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
        private Instant updatedAt;

        private Instant deletedAt;
}
