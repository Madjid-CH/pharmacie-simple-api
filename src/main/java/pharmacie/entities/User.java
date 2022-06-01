package pharmacie.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class User extends Entity {
  @Getter
  final private String userName;
  @Getter
  final private String role;
}