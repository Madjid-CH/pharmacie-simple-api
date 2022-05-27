package pharmacie.doubles;

import pharmacie.entities.User;
import pharmacie.gateways.UserGateway;

public class InMemoryUserGateway extends GatewayUtilities<User> implements UserGateway {
  public User findUserById(String username) {
    for (User user : getEntities())
      if (user.getUserName().equals(username))
        return user;
    return null;
  }

  @Override
  public User verifyUser(String username, String password) {
    return null;
  }
}
