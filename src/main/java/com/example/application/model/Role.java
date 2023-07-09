package com.example.application.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,

    SUPPLIER,

    FOREMAN;

    //    https://stackoverflow.com/a/19542316/548473
    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
