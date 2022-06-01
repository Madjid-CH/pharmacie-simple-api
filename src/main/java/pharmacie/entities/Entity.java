package pharmacie.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Entity implements Cloneable {
  @Getter @Setter
  private String id;

  public boolean isSame(Entity entity) {
    return id != null && Objects.equals(id, entity.id);
  }


  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
