package pharmacie.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
public class Medicament extends Entity {
  @Getter
  final private String name;
  @Getter
  final private int quantity;
  @Getter
  final private LocalDate expirationDate;
  @Getter
  final private Dosage dosage;
  @Getter
  private int price;

  public record Dosage(double quantity, String unit) { }
}
