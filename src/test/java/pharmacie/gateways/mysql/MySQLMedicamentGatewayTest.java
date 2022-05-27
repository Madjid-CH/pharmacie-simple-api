package pharmacie.gateways.mysql;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pharmacie.entities.Medicament;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MySQLMedicamentGatewayTest {

  private MySQLMedicamentGateway gateway = new MySQLMedicamentGateway();
  private Medicament medicament;

  @BeforeEach
  void setUp() {
    var dosage = new Medicament.Dosage(78, "ml/g");
    medicament = new Medicament("medName", 78, LocalDate.EPOCH, dosage);
    medicament.setId("med-id");
  }

  @Test
  void shouldGetAllMedicamentFromDB() {
    var medicamantsList = gateway.findAllMedicaments();

    assertTrue(medicamantsList.size() > 0);
  }

  @Test
  void canFindMedicamentByName() {
    var medicament = gateway.findMedicamentByName("med1");

    assertEquals("med1",medicament.getName());
  }

  @Test
  void canSaveMedicamentToDB() {
    gateway.save(medicament);

    var sameMedicament = gateway.findMedicamentByName(medicament.getName());

    assertTrue(medicament.isSame(sameMedicament));
  }

  @Test
  void canDeleteMedicamentFromDB() {
    gateway.delete(medicament);

    var nullMedicament=  gateway.findMedicamentByName(medicament.getName());
    assertNull(nullMedicament);
  }

  @Test
  void canModifyAMedicament() {
    var newMedicament = new Medicament("new med_name", 79, LocalDate.of(2000,5,5), medicament.getDosage());
    newMedicament.setId(medicament.getId());
    gateway.modify(newMedicament);

    var modifiedMedicament = gateway.findMedicamentByName(newMedicament.getName());


    assertTrue(modifiedMedicament.isSame(medicament));
  }
}
