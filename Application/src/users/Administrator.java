package users;

class Administrator extends User {

  public Administrator(String username, String password, String email) {
    super(username, password, email);
    this.position = Position.ADMINISTRATOR;
  }

  @Override
  public String getType() {
    return "users.Administrator";
  }

  public void addSupplier(Supplier supplier) {
    // code to add a supplier to the app
  }

  public void removeSupplier(Supplier supplier) {
    // code to remove a supplier from the app
  }
}