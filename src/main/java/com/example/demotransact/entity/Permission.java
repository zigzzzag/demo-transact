package com.example.demotransact.entity;

import lombok.Getter;

@Getter
public enum Permission {
    AGREEMENTS_GET("AGREEMENTS:GET"),
    AGREEMENTS_CREATE("AGREEMENTS:CREATE");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }
}
