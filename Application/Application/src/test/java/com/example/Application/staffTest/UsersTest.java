package com.example.Application.staffTest;

import com.example.Application.model.Users;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UsersTest {

  @Test
  public void testValidUserCreation() {
    String username = "john";
    String password = "password";
    String email = "john@example.com";
    Users user = new Users(username, password, email) {
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
    Users user = new Users(username, password, email) {
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
    Users user = new Users(username, password, email) {
      @Override
      public String getType() {
        return null;
      }
    };
    Assert.assertTrue(user.userMap.isEmpty());
    email = "john@example.com";
    user = new Users(username, password, email) {
      @Override
      public String getType() {
        return null;
      }
    };
    Assert.assertFalse(user.userMap.isEmpty());
  }
}