package pharmacie.usecases.admin.deletemedicament;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pharmacie.Context;
import pharmacie.TestSetup;
import pharmacie.entities.Medicament;
import pharmacie.entities.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DeleteMedicamentUsecaseTest {
  private User user;
  private DeleteMedicamentUsecase useCase;
  private DeleteMedicamentRequestModel requestModel;
  private DeleteMedicamentOutputBoundarySpy presenterSpy;

  @BeforeEach
  public void setUp() {
    TestSetup.setupContext();
    user = Context.userGateway.save(new User("admin", "admin"));
    useCase = new DeleteMedicamentUsecase();
    requestModel = new DeleteMedicamentRequestModel();
    presenterSpy = new DeleteMedicamentOutputBoundarySpy();
  }

  @Test
  public void useCaseWiring()
  {
    requestModel.medicament = new Medicament("", 0, LocalDate.now(), null, 0);
    useCase.deleteMedicament(user, requestModel, presenterSpy);
    assertNotNull(presenterSpy.responseModel);
  }

  @Nested
  public class DeletingOneMedicament {
    private Medicament medicament;

    @BeforeEach
    public void setupMedicament() {
      medicament = new Medicament(user.getId(), 0, LocalDate.now(), null, 0);
      Context.medicamentGateway.save(medicament);
    }

    @Test
    public void shouldDeleteOneSaleInGateway() {
      var requestModel = new DeleteMedicamentRequestModel();
      requestModel.medicament = medicament;
      useCase.deleteMedicament(user, requestModel, presenterSpy);

      var nullMedicament = Context.medicamentGateway.findMedicamentByName(medicament.getName());
      assertNull(nullMedicament);
    }
  }

}
