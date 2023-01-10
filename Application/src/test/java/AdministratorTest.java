package test.java;

import main.java.Administrator;
import main.java.Supplier;
import org.junit.Assert;
import org.junit.Test;

public class AdministratorTest {

  @Test
  public void testAddSupplier() {
    String username = "john";
    String password = "password";
    String email = "john@example.com";
    Administrator admin = new Administrator(username, password, email);
    String supplierUsername = "supplier";
    String supplierPassword = "password";
    String supplierEmail = "supplier@example.com";
    Supplier supplier = new Supplier(supplierUsername, supplierPassword, supplierEmail) {
    };
    admin.addSupplier(supplier);
    Assert.assertTrue(admin.userMap.containsKey(supplierEmail));
  }

  @Test
  public void testRemoveUser() {
    String username = "john";
    String password = "password";
    String email = "john@example.com";
    Administrator admin = new Administrator(username, password, email);
    String supplierUsername = "supplier";
    String supplierPassword = "password";
    String supplierEmail = "supplier@example.com";
    Supplier supplier = new Supplier(supplierUsername, supplierPassword, supplierEmail);
    admin.addSupplier(supplier);
    admin.removeUser(supplier);
    Assert.assertFalse(admin.userMap.containsKey(supplierEmail));
  }

  @Test
  public void testRemoveAdministrator() {
    String username = "john";
    String password = "password";
    String email = "john@example.com";
    Administrator admin = new Administrator(username, password, email);
    String adminUsername = "admin";
    String adminPassword = "password";
    String adminEmail = "admin@example.com";
    Administrator adminToRemove = new Administrator(adminUsername, adminPassword, adminEmail);
    admin.removeAdministrator(adminToRemove);
    Assert.assertFalse(admin.administratorMap.containsKey(adminEmail));
  }
}