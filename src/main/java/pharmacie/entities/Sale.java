package pharmacie.entities;

import lombok.*;

import java.time.LocalDate;

@Data
public class Sale extends Entity {
  private final String clientId;
  private final String medicamentName;
  private final int quantity;
  private final int price;
  private final LocalDate sellingDate;
}