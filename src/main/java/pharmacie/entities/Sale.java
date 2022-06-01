package pharmacie.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
public class Sale extends Entity {
  @Getter
  final private String clientId;
  @Getter
  final private String MedicamentName;
  @Getter
  final private int quantity;
  @Getter
  final private int price;
  @Getter
  private final LocalDate sellingDate;


  @Override
  public boolean equals(Object obj) {
    return super.isSame((Entity) obj);
  }
}
