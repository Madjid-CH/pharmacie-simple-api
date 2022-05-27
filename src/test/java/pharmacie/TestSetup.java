package pharmacie;

import pharmacie.doubles.InMemoryMedicamentGateway;
import pharmacie.doubles.InMemorySaleGateway;
import pharmacie.doubles.InMemoryUserGateway;
import pharmacie.entities.Medicament;
import pharmacie.entities.Sale;
import pharmacie.entities.User;

import java.time.LocalDate;

public class TestSetup {

  public static void setupContext() {
    Context.userGateway = new InMemoryUserGateway();
    Context.salesGateway = new InMemorySaleGateway();
    Context.medicamentGateway = new InMemoryMedicamentGateway();
    Context.gateKeeper = new GateKeeper();
  }

  public static void setupSampleData() {
    setupContext();

    User lynda = new User("lynda", "client");
    User madjid = new User("madjid", "client");

    Context.userGateway.save(lynda);
    Context.userGateway.save(madjid);

    var date = LocalDate.of(2023, 12, 12);
    var dosage = new Medicament.Dosage(0.02, "mg/ml");
    Medicament m1 = new Medicament("midicament1", 10, date, dosage);

    date = LocalDate.of(2023, 11, 11);
    dosage = new Medicament.Dosage(0.05, "mg/ml");
    Medicament m2 = new Medicament("midicament2", 10, date, dosage);

    Context.medicamentGateway.save(m1);
    Context.medicamentGateway.save(m2);

    Sale madjidS1 = new Sale(madjid.getId(), m1.getId(), 2, 100, LocalDate.now());
    Sale madjidS2 = new Sale(madjid.getId(), m2.getId(), 3, 200, LocalDate.now());

    Context.salesGateway.save(madjidS1);
    Context.salesGateway.save(madjidS2);

    Context.gateKeeper.setLoggedInUser(lynda);
  }
}
