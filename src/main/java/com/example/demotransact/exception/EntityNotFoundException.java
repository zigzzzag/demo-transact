package com.example.demotransact.exception;

import com.example.demotransact.entity.EntityType;

public class EntityNotFoundException extends RuntimeException {

    private final EntityType entityType;
    private final Long id;

    public EntityNotFoundException(EntityType entityType, Long id) {
        this.entityType = entityType;
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Entity " + entityType.name() + " not found by id " + id;
    }
}
