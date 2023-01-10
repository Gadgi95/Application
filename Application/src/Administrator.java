import java.util.Map;

class Administrator extends User {

  public Administrator(String username, String password, String email) {
    super(username, password, email);
    this.position = Position.ADMINISTRATOR;
    administratorMap.put(email, username);
  }

  @Override
  public String getType() {
    return "Administrator";
  }

  public void addSupplier(Supplier supplier) {
    new Supplier(supplier.getUsername(), supplier.getPassword(), supplier.getEmail());
  }
  public void addForeman(Foreman foreman) {
    new Supplier(foreman.getUsername(), foreman.getPassword(), foreman.getEmail());
  }

  public void removeUser(User user) {
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