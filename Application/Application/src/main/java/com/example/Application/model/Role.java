package com.example.Application.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
  ADMINISTRATOR,
  USER;

  //    https://stackoverflow.com/a/19542316/548473
  @Override
  public String getAuthority() {
    return "ROLE_" + name();
  }

}
