package com.example.Application.model;

import java.util.TreeMap;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

public abstract class Users {
  private Integer id = 1;
  private String username;
  private String password;
  private String email;
  Role role;

  public TreeMap<String, String> administratorMap = new TreeMap<>();
  public TreeMap<String, String> userMap = new TreeMap<>();
  String VALID_EMAIL_ADDRESS_REGEX = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";

  public Users(Integer id, String username, String password, String email) {
    this.id = id;
    this.email = email;
    this.username = username;
    this.password = password;
  }

  public Users(String username, String password, String email) {
    if(email.matches((VALID_EMAIL_ADDRESS_REGEX))){
      int id = this.id++;
      this.email = email;
      this.username = username;
      this.password = password;
      userMap.put(email, username);
    }
    else {
      System.out.println("Неверный формат email");
    }
  }
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Secured("ROLE_ADMIN")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Secured("ROLE_ADMIN")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public abstract String getType();

  @PreAuthorize("hasRole('ROLE_USER')")
  public TreeMap<String, String> getUserMap() {
    return userMap;
  }

  @Override
  public String toString() {
    return "Users{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", email='" + email + '\'' +
        ", role=" + role +
        '}';
  }
}
