package com.example.airline_systems.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TokenClaims {

    JWT_ID("jti"),
    TYPE("typ"),
    USER_ID("userId"),
    USERNAME("Username"),

    ROLE_NAME("roleName"),

    ALGORITHM("alg");

    private final String value;
}
