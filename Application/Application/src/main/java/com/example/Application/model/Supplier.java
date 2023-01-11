package com.example.Application.model;

import com.example.Application.core.Application;
import com.example.Application.core.ApplicationStatus;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Supplier extends Users {

  public Supplier(String username, String password, String email) {
    super(username, password, email);
    this.role = Role.SUPPLIER;

  }

  @Override
  public String getType() {
    return "main.java.Supplier";
  }

  public void viewApplication(Application application) {
    System.out.println(application.toString());
  }

  public void updateApplication(Application application, String deliveryDate) {
    application.setStatus(ApplicationStatus.IN_PROGRESS);
    application.setStatusChangeDate(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()));
    application.setDeliveryDate(deliveryDate);
    application.setResponsibleSupplier(getUsername());
  }
}