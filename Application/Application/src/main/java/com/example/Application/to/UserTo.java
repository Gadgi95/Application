package com.example.Application.to;

import java.io.Serializable;
import com.example.Application.HasId;
import com.example.Application.ValidEmailAddress;
import com.example.Application.model.Role;
import com.example.Application.to.util.validation.NoHtml;
import org.springframework.security.access.annotation.Secured;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserTo extends BaseTo implements HasId, Serializable, ValidEmailAddress {

  @NotBlank
  @Size(min = 2, max = 100)
  @NoHtml
  private String name;

  @Email
  @NotBlank
  @Size(max = 100)
  @NoHtml // https://stackoverflow.com/questions/17480809
  private String email;

  @NotBlank
  @Size(min = 5, max = 32)
  private String password;

  private Role role;

  public UserTo(Integer id, String username, String password, String email, Role role) {
    if(isValidEmailAddress(email)) {
      this.id = id;
      this.email = email;
      this.name = username;
      this.password = password;
      this.role = role;
    }
    else {
      System.out.println("Неверный формат email");
    }
  }

  public UserTo(String username, String password, String email) {
    if(isValidEmailAddress(email)) {
      int id = this.id++;
      this.email = email;
      this.name = username;
      this.password = password;
      this.role = role;
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
  public String getName() {
    return name;
  }

  public void setName(String username) {
    this.name = name;
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

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "Users{" +
        "username='" + name + '\'' +
        ", password='" + password + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
