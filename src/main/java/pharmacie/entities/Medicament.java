package pharmacie.entities;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Medicament extends Entity {
  final private String name;
  final private int quantity;
  final private LocalDate experationDate;
  final private Dosage dosage;
  private int price = 0;


  public Medicament(String name, int quantity, LocalDate experationDate, Dosage dosage) {
    this.name = name;
    this.quantity = quantity;
    this.experationDate = experationDate;
    this.dosage = dosage;
  }


  public Medicament(String name, int quantity, LocalDate experationDate, Dosage dosage, int price) {
    this.name = name;
    this.quantity = quantity;
    this.experationDate = experationDate;
    this.dosage = dosage;
    this.price = price;
  }

  public String getName() { return name; }

  public int getQuantity() { return quantity; }

  public LocalDate getExperationDate() { return experationDate; }
  public int getPrice() { return price; }

  public Dosage getDosage() { return dosage; }

  public record Dosage(double quantity, String unit) { }
}
