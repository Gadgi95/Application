package com.example.Application.staffTest;


import com.example.Application.model.Administrator;
import com.example.Application.model.Foreman;
import com.example.Application.model.Supplier;
import com.example.Application.model.Users;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class AdministratorTest {

  @Test
  public void testValidAdministratorCreation() {
    String username = "admin";
    String password = "password";
    String email = "admin@example.com";
    Administrator administrator = new Administrator(username, password, email);
    Assert.assertEquals(username, administrator.getUsername());
    Assert.assertEquals(password, administrator.getPassword());
    Assert.assertEquals(email, administrator.getEmail());
  }

  @Test
  public void testAddSupplier() {
    Administrator administrator = new Administrator("admin", "password", "admin@example.com");
    Supplier supplier = new Supplier("john", "password", "john@example.com");
    administrator.addSupplier(supplier);
    Assert.assertTrue(administrator.userMap.containsKey("john@example.com"));
  }

  @Test
  public void testAddForeman() {
    Administrator administrator = new Administrator("admin", "password", "admin@example.com");
    Foreman foreman = new Foreman("james", "password", "james@example.com");
    administrator.addForeman(foreman);
    Assert.assertTrue(administrator.userMap.containsKey("james@example.com"));
  }

  @Test
  public void testRemoveUser() {
    Administrator administrator = new Administrator("admin", "password", "admin@example.com");
    Users user = new Users("john", "password", "john@example.com") {
      @Override
      public String getType() {
        return "User";
      }
    };
    administrator.userMap.put(user.getEmail(), user.getUsername());
    int initialSize = administrator.userMap.size();
    administrator.removeUser(user);
    int finalSize = administrator.userMap.size();
    Assert.assertNotEquals(initialSize, finalSize);
    Assert.assertFalse(administrator.userMap.containsKey("john@example.com"));
  }
}