package com.transact.mapping;

import com.transact.entity.UserEntity;
import com.transact.entity.UserStatus;
import com.transact.security.UserSecurity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserMapping {

    public static UserSecurity toUserSecurity(UserEntity entity) {
        return UserSecurity.builder()
            .username(entity.getUsername())
            .password(entity.getPassword())
            .authorities(Stream.of(entity)
                .flatMap(it -> Stream.concat(
                    Stream.of(new SimpleGrantedAuthority(it.getUserRole().getRoleName())),
                    it.getUserRole().getAuthorities().stream()
                ))
                .collect(Collectors.toSet())
            )
            .active(UserStatus.ACTIVE.equals(entity.getStatus()))
            .build();
    }
}
