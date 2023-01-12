package com.example.Application.model;

import java.util.Map;

public class Administrator extends Users {

  public Administrator(Integer id, String username, String password, String email) {
    super(id, username, password, email);
  }

  public Administrator(String username, String password, String email) {
    super(username, password, email);
    this.role = Role.ADMINISTRATOR;
    administratorMap.put(email, username);
  }

  @Override
  public String getType() {
    return "main.java.model.Administrator";
  }

  public void addSupplier(Supplier supplier) {
    //Проверка почты и имени науникальность значений, если такая почта или имя уже зареган - ошибка

    new Supplier(supplier.getUsername(), supplier.getPassword(), supplier.getEmail());
  }
  public void addForeman(Foreman foreman) {
    //Проверка почты и имени науникальность значений, если такая почта или имя уже зареган - ошибка


    new Supplier(foreman.getUsername(), foreman.getPassword(), foreman.getEmail());
  }

  public void removeUser(Users user) {
    for (Map.Entry<String, String> users : userMap.entrySet()) {
      String value = users.getValue();
      String key = users.getKey();
      if(user.getEmail().equalsIgnoreCase(value))
      {
        userMap.remove(value);
      }
    }
  }

  public void removeAdministrator(Administrator administrator) {
    for (Map.Entry<String, String> administrators : administratorMap.entrySet()) {
      String value = administrators.getValue();
      String key = administrators.getKey();
      if(administrator.getEmail().equalsIgnoreCase(value))
      {
        userMap.remove(value);
      }
    }
  }

}