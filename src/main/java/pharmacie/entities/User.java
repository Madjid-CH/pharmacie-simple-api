package pharmacie.entities;


public class User extends Entity {
  final private String userName;
  final private String role;

  public User(String userName, String role) {
    this.userName = userName;
    this.role = role;
  }

  public String getUserName() {
    return userName;
  }

  public String getRole() { return role; }
}