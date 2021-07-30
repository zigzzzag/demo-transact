package com.transact.entity;

import lombok.Getter;

@Getter
public enum Permission {
    AGREEMENTS_GET("AGREEMENTS:GET"),
    AGREEMENTS_CREATE("AGREEMENTS:CREATE");

    private final String value;

    Permission(String value) {
        this.value = value;
    }
}
