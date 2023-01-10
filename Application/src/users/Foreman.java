package users;

class Foreman extends User {

  public Foreman(String username, String password, String email) {
    super(username, password, email);
    this.position = Position.FOREMAN;

  }

  @Override
  public String getType() {
    return "users.Foreman";
  }

  public void createApplication(Application application) {
    // code to create an application
  }

  public void viewApplication(Application application) {
    // code to view an application
  }

  public void updateApplication(Application application) {
    // code to update an application
  }

  public void closeApplication(Application application) {
    // code to close an application
  }

  public void detectFactoryMarriage(Application application, String description, String photoUrl) {
    // code to detect a factory marriage
  }
}