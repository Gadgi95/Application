package com.example.Application.model;

import com.example.Application.core.Application;
import com.example.Application.to.UserTo;

import java.util.Date;

public class Foreman extends UserTo {

  Role role;

  public Foreman(String username, String password, String email) {
    super(username, password, email);
    this.role = Role.USER;

  }

  public void createApplication(Application application) {
    new Application(application.getName(), application.getMaterials());
  }

  public void viewApplication(Application application) {
    System.out.println(application.toString());
  }

  public void closeApplication(Application application) {
    application.setClosed(true);
  }

  public void detectFactoryMarriage(Application application, String description) {
    application.setHasFactoryMarriage(true);
    application.setMarriageDetectionDate(new Date());
    application.setMarriageDetectedBy(getName());
    application.setMarriageDescription(description);
  }
}