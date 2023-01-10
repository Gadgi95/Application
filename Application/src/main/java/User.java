package main.java;

import java.util.TreeMap;

public abstract class User {
  private String username;
  private String password;
  private String email;
  Position position;

  public TreeMap<String, String> administratorMap = new TreeMap<>();
  public TreeMap<String, String> userMap = new TreeMap<>();
  String VALID_EMAIL_ADDRESS_REGEX = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";


  public User(String username, String password, String email) {
    if(email.matches((VALID_EMAIL_ADDRESS_REGEX))){
      this.email = email;
      this.username = username;
      this.password = password;
      userMap.put(email, username);
    }
    else {
      System.out.println("Неверный формат email");
    }
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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

  public abstract String getType();

  public TreeMap<String, String> getUserMap() {
    return userMap;
  }

  @Override
  public String toString() {
    return "User{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", email='" + email + '\'' +
        ", position=" + position +
        '}';
  }
}