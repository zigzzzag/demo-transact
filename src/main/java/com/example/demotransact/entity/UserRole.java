package com.example.demotransact.entity;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.demotransact.entity.Permission.AGREEMENTS_CREATE;
import static com.example.demotransact.entity.Permission.AGREEMENTS_GET;

@Getter
public enum UserRole {
    USER(Set.of(AGREEMENTS_GET)),
    ADMIN(Set.of(AGREEMENTS_GET, AGREEMENTS_CREATE));

    private static final String ROLE_PREFIX = "ROLE_";
    private final Set<Permission> permissions;

    UserRole(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public String getRoleName() {
        return ROLE_PREFIX + name();
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
            .map(it -> new SimpleGrantedAuthority(UserRole.ROLE_PREFIX + it.getPermission()))
            .collect(Collectors.toSet());
    }
}
