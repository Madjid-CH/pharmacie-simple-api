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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Sale sale)) return false;

    if (getQuantity() != sale.getQuantity()) return false;
    if (getPrice() != sale.getPrice()) return false;
    if (!getClientId().equals(sale.getClientId())) return false;
    if (getMedicamentName() != null ?
            !getMedicamentName().equals(sale.getMedicamentName()) :
            sale.getMedicamentName() != null)
      return false;
    return getSellingDate() != null ?
            getSellingDate().equals(sale.getSellingDate()) : sale.getSellingDate() == null;
  }

  @Override
  public int hashCode() {
    int result = getClientId().hashCode();
    result = 31 * result + (getMedicamentName() != null ? getMedicamentName().hashCode() : 0);
    result = 31 * result + getQuantity();
    result = 31 * result + getPrice();
    result = 31 * result + (getSellingDate() != null ? getSellingDate().hashCode() : 0);
    return result;
  }
}