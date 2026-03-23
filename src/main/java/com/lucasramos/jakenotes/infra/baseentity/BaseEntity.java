package com.lucasramos.jakenotes.infra.baseentity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@MappedSuperclass
public class BaseEntity {

    @Column(nullable = false, name = "created_at", updatable = false)
    private OffsetDateTime createdAt;

    @Column(nullable = false, name = "updated_at")
    private OffsetDateTime updatedAt;

    @PrePersist
    public void addCreatedAt() {
        createdAt = OffsetDateTime.now();
    }

    @PreUpdate
    public void updateUpdatedAt() {
        updatedAt = OffsetDateTime.now();
    }
}