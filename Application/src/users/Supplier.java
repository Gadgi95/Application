package users;

class Supplier extends User {

  public Supplier(String username, String password, String email) {
    super(username, password, email);
    this.position = Position.SUPPLIER;

  }

  @Override
  public String getType() {
    return "users.Supplier";
  }

  public void viewApplication(Application application) {
    // code to view an application
  }

  public void updateApplication(Application application) {
    // code to update an application
  }
}