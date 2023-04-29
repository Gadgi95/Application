package com.example.application.to;

import java.io.Serial;
import java.io.Serializable;

import com.example.application.util.validation.NoHtml;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserTo extends BaseTo implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @NotBlank
  @Size(min = 2, max = 100)
//  @NoHtml
  private String name;

  @Email
  @NotBlank
  @Size(max = 100)
//  @NoHtml // https://stackoverflow.com/questions/17480809
  private String email;

  @NotBlank
  @Size(min = 5, max = 32)
  private String password;

  public UserTo() {
  }

  public UserTo(Integer id, String username, String email, String password) {
      super(id);
      this.email = email;
      this.name = username;
      this.password = password;
  }
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

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
  @Override
  public String toString() {
    return "Users{" +
        "username='" + name + '\'' +
        ", password='" + password + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
