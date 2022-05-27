package pharmacie.usecases.admin.addmedicament;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pharmacie.Context;
import pharmacie.TestSetup;
import pharmacie.entities.Medicament;
import pharmacie.entities.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddMedicamentUsecaseTest {
  private User user;
  private AddMedicamentUsecase useCase;
  private AddMedicamentRequestModel requestModel;
  private AddMedicamentOutputBoundarySpy presenterSpy;

  @BeforeEach
  public void setUp() {
    TestSetup.setupContext();
    user = Context.userGateway.save(new User("User", "admin"));
    useCase = new AddMedicamentUsecase();
    requestModel = new AddMedicamentRequestModel();
    presenterSpy = new AddMedicamentOutputBoundarySpy();
  }

  @Test
  public void useCaseWiring()
  {
    requestModel.medicament = new Medicament("medicament", 5, LocalDate.now(), null, 87);
    useCase.addMedicament(user, requestModel, presenterSpy);
    assertNotNull(presenterSpy.responseModel);
  }

  @Nested
  public class AddingOneSaleToSaleGateway {
    private Medicament medicament;

    @BeforeEach
    public void setupSale() {
      var experationDate = LocalDate.of(2025,11,1);
      var dosage = new Medicament.Dosage(0.5, "ml/g");
      medicament = Context.medicamentGateway.save(
              new Medicament("medicament-name", 15, experationDate, dosage, 100));
    }

    @Test
    public void shouldAddOneSaleToGateway() {
      var requestModel = new AddMedicamentRequestModel();
      requestModel.medicament = medicament;
      useCase.addMedicament(user, requestModel, presenterSpy);

      var savedmedicament = Context.medicamentGateway.findMedicamentByName(medicament.getName());
      assertTrue(medicament.isSame(savedmedicament));
    }
  }

}
