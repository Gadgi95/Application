import java.util.Locale;
import java.util.TreeMap;

abstract class User {
  private String username;
  private String password;
  private String email;
  Position position;

  TreeMap<String, String> administratorMap = new TreeMap<>();
  TreeMap<String, String> userMap = new TreeMap<>();
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
}
