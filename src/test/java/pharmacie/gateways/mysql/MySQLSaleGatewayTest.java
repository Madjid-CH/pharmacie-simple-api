package pharmacie.gateways.mysql;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pharmacie.entities.Medicament;
import pharmacie.entities.Sale;
import pharmacie.entities.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MySQLSaleGatewayTest {

  private Sale s1;
  private Sale s2;
  private Sale s3;
  private MySQLSaleGateway gateway;
  private User lynda;

  @BeforeEach
  void setUp() {
    lynda = new User("lynda", "client");
    lynda.setId("id");
    gateway = new MySQLSaleGateway();
    var date = LocalDate.now();
    s1 = gateway.save(new Sale("id","med1",  2, 500, date) );
    s2 = gateway.save(new Sale("id","med2",  2, 500, date));
    s3 = gateway.save(new Sale("another id","med1",  3, 750, date));

  }

  @AfterEach
  void tearDown() {
    gateway.delete(s1);
    gateway.delete(s2);
    gateway.delete(s3);
  }

  @Test
  public void RetriveSalesByClient() {
    var salesList = gateway.findAllSalesByUser(lynda);

    assertEquals(2, salesList.size());
    assertTrue(salesList.contains(s1));
    assertTrue(salesList.contains(s2));
  }

  @Test
  void RetriveSalesByMedicament() {
    var medicament = new Medicament("med2", 3, null, null, 8);
    var salesList = gateway.findAllSaleByMadicament(medicament);

    assertEquals(1, salesList.size());
    var retrievedMedicament = salesList.get(0);
    assertEquals(medicament.getName(), retrievedMedicament.getMedicamentName());
  }

  @Test
  void canModifyASaleFromDB() {
    var modifiedSale = new Sale(s3.getClientId(), s3.getMedicamentName(), 55, 9789, s3.getSellingDate());
    modifiedSale.setId(s3.getId());
    var medicament = new Medicament(s3.getMedicamentName(), 3, null, null, 5);
    gateway.modify(modifiedSale);

    var newSalesList = gateway.findAllSaleByMadicament(medicament);

    assertTrue(newSalesList.contains(modifiedSale));

  }
}