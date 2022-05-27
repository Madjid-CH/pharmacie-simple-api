package pharmacie.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntityTest {
  @Test
  public void twoDifferentEntitysAreNotTheSame() {
    Entity e1 = new Entity();
    Entity e2 = new Entity();

    e1.setId("e1ID");
    e2.setId("e2ID");

    assertFalse(e1.isSame(e2));
  }

  @Test
  public void oneEntityIsTheSameAsItself() throws Exception {
    Entity e1 = new Entity();
    e1.setId("e1ID");

    assertTrue(e1.isSame(e1));
  }

  @Test
  public void EntitysWithTheSameIdAreTheSame() throws Exception {
    Entity e1 = new Entity();
    Entity e2 = new Entity();
    e1.setId("e1ID");
    e2.setId("e1ID");

    assertTrue(e1.isSame(e2));
  }

  @Test
  public void EntitysWithNullIdsAreNeverSame() throws Exception {
    Entity e1 = new Entity();
    Entity e2 = new Entity();

    assertNull(e1.getId());
    assertNull(e2.getId());
    assertFalse(e1.isSame(e2));
  }
}
