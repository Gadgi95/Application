package com.example.Application.staffTest;

import com.example.Application.to.UserTo;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UsersTest {

  @Test
  public void testValidUserCreation() {
    String username = "john";
    String password = "password";
    String email = "john@example.com";
    UserTo user = new UserTo(username, password, email);
    Assert.assertEquals(username, user.getName());
    Assert.assertEquals(password, user.getPassword());
    Assert.assertEquals(email, user.getEmail());
  }

  @Test
  public void testInvalidEmailFormat() {
    String username = "john";
    String password = "password";
    String email = "john_example.com";
    UserTo user = new UserTo(username, password, email) {
    };
    Assert.assertNull(user.getEmail());
  }
}