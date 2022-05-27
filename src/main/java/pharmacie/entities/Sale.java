package pharmacie.entities;

import java.time.LocalDate;

public class Sale extends Entity {
  final private String clientId;
  final private String MedicamentName;
  final private int quantity;
  final private int price;
  private final LocalDate sellingDate;

  public Sale(String clientId, String medicamentName, int quantity, int price, LocalDate sellingDate) {
    this.clientId = clientId;
    MedicamentName = medicamentName;
    this.quantity = quantity;
    this.price = price;
    this.sellingDate = sellingDate;
  }

  public String getClientId() { return clientId; }

  public String getMedicamentName() { return MedicamentName; }

  public int getQuantity() { return quantity; }

  public int getPrice() { return price; }

  public LocalDate getSellingDate() { return sellingDate; }

  @Override
  public boolean equals(Object obj) {
    return super.isSame((Entity) obj);
  }
}
