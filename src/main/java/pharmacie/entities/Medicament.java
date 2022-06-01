package pharmacie.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.GregorianCalendar;

@AllArgsConstructor
public class Medicament extends Entity {
  @Getter
  final private String name;
  @Getter
  final private int quantity;
  @Getter
  final private LocalDate experationDate;
  @Getter
  final private Dosage dosage;
  @Getter
  private int price;

  public record Dosage(double quantity, String unit) { }
}
