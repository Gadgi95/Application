package main.java;

import java.util.Date;

public class Supplier extends User {

  public Supplier(String username, String password, String email) {
    super(username, password, email);
    this.position = Position.SUPPLIER;

  }

  @Override
  public String getType() {
    return "main.java.Supplier";
  }

  public void viewApplication(Application application) {
    System.out.println(application.toString());
  }

  public void updateApplication(Application application, Date deliveryDate) {
    application.setStatus(ApplicationStatus.IN_PROGRESS);
    application.setStatusChangeDate(new Date());
    application.setDeliveryDate(deliveryDate);
    application.setResponsibleSupplier(getUsername());
  }
}