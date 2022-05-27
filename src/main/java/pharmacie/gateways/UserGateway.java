package pharmacie.gateways;

import pharmacie.entities.User;

public interface UserGateway {
  User save(User user);
  User findUserById(String username);

  User verifyUser(String username, String password);
}
