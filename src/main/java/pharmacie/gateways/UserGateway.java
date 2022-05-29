package pharmacie.gateways;

import pharmacie.entities.User;
import pharmacie.usecases.authentication.login.SignUpInformation;

public interface UserGateway {
  User save(User user);
  User findUserById(String username);

  User verifyUser(String username, String password);

  User register(SignUpInformation info);
}
