import java.util.TreeMap;

abstract class User {
  private String username;
  private String password;
  private String email;
  Position position;

  TreeMap<String, String> administratorMap = new TreeMap<>();
  TreeMap<String, String> userMap = new TreeMap<>();

  public User(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
    userMap.put(email, username);
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
}
