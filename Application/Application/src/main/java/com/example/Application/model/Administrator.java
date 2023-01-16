package com.example.Application.model;

import com.example.Application.to.UserTo;

import java.util.Map;

public class Administrator extends UserTo {

  Role role;

  public Administrator(Integer id, String username, String password, String email, Role role) {
    super(id, username, password, email, role);
  }

  public Administrator(String username, String password, String email) {
    super(username, password, email);
    this.role = Role.ADMINISTRATOR;
  }

  public void addSupplier(Supplier supplier) {
    //Проверка почты и имени науникальность значений, если такая почта или имя уже зареган - ошибка

    new Supplier(supplier.getName(), supplier.getPassword(), supplier.getEmail());
  }
  public void addForeman(Foreman foreman) {
    //Проверка почты и имени науникальность значений, если такая почта или имя уже зареган - ошибка


    new Supplier(foreman.getName(), foreman.getPassword(), foreman.getEmail());
  }
}