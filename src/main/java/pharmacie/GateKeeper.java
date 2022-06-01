package pharmacie;


import lombok.Getter;
import lombok.Setter;
import pharmacie.entities.User;

public class GateKeeper {
  @Setter @Getter
  private User loggedInUser;
}
