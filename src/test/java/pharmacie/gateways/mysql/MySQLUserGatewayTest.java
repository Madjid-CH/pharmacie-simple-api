package pharmacie.gateways.mysql;

import org.junit.jupiter.api.Test;
import pharmacie.entities.User;

import static org.junit.jupiter.api.Assertions.*;

class MySQLUserGatewayTest {

  @Test
  void saveUserToDBAndRetrieveIt() {
    var gateway = new MySQLUserGateway();
    var user = gateway.save(new User("madjid", "client"));

    var sameUser = gateway.findUserById(user.getId());

    assertAll(
            () -> assertTrue(user.isSame(sameUser)),
            () -> assertEquals(user.getUserName(), sameUser.getUserName()),
            () -> assertEquals(user.getRole(), sameUser.getRole()));
  }
}