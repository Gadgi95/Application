package test.java;

import main.java.User;
import org.junit.Assert;
import org.junit.Test;

public class UserTest {

  @Test
  public void testValidUserCreation() {
    String username = "john";
    String password = "password";
    String email = "john@example.com";
    User user = new User(username, password, email) {
      @Override
      public String getType() {
        return null;
      }
    };
    Assert.assertEquals(username, user.getUsername());
    Assert.assertEquals(password, user.getPassword());
    Assert.assertEquals(email, user.getEmail());
  }

  @Test
  public void testInvalidEmailFormat() {
    String username = "john";
    String password = "password";
    String email = "john_example.com";
    User user = new User(username, password, email) {
      @Override
      public String getType() {
        return null;
      }
    };
    Assert.assertNull(user.getEmail());
  }
  @Test
  public void testTreeMap() {
    String username = "john";
    String password = "password";
    String email = "john_example.com";
    User user = new User(username, password, email) {
      @Override
      public String getType() {
        return null;
      }
    };
    Assert.assertTrue(user.userMap.isEmpty());
    email = "john@example.com";
    user = new User(username, password, email) {
      @Override
      public String getType() {
        return null;
      }
    };
    Assert.assertFalse(user.userMap.isEmpty());
  }
}