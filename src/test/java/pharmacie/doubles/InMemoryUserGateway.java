package pharmacie.doubles;

import pharmacie.entities.User;
import pharmacie.gateways.UserGateway;
import pharmacie.usecases.authentication.login.SignUpInformation;

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

  @Override
  public User register(SignUpInformation info) {
    return null;
  }
}
