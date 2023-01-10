package com.example.Application;

import java.util.Date;

class Foreman extends User {

  public Foreman(String username, String password, String email) {
    super(username, password, email);
    this.position = Position.FOREMAN;

  }

  @Override
  public String getType() {
    return "main.java.Foreman";
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
    application.setMarriageDetectedBy(getUsername());
    application.setMarriageDescription(description);
  }
}