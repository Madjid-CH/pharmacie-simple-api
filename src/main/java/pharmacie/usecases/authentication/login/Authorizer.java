package pharmacie.usecases.authentication.login;

import org.springframework.web.bind.annotation.*;
import pharmacie.GateKeeper;
import pharmacie.entities.User;
import pharmacie.gateways.UserGateway;
import pharmacie.gateways.mysql.MySQLUserGateway;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Authorizer {
  private final UserGateway gateway;
  private final GateKeeper gateKeeper;

  public Authorizer() {
    this.gateway = new MySQLUserGateway();
    gateKeeper = new GateKeeper();
  }

  @PostMapping("/login")
  public User authorize(@RequestBody LoginInformation loginInformation) {
    User user = gateway.verifyUser(loginInformation.username(), loginInformation.password());
    gateKeeper.setLoggedInUser(user);
    return user;
  }
}
