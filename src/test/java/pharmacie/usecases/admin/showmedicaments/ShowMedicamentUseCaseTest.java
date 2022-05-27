package pharmacie.usecases.admin.showmedicaments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pharmacie.Context;
import pharmacie.TestSetup;
import pharmacie.entities.Medicament;
import pharmacie.entities.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ShowMedicamentUseCaseTest {
  private User user;
  private ShowMedicamentUseCase useCase;
  public ShowMedicamentOutputBoundarySpy presenterSpy;

  @BeforeEach
  public void setUp() {
    TestSetup.setupContext();
    user = Context.userGateway.save(new User("User", "admin"));
    useCase = new ShowMedicamentUseCase();
    presenterSpy = new ShowMedicamentOutputBoundarySpy();
  }

  @Test
  public void useCaseWiring() {
    useCase.summarizeMedicaments(user, presenterSpy);
    assertNotNull(presenterSpy.responseModel);
  }

  @Nested
  public class GivenNoMedicaments {
    @Test
    public void noneArePresented() {
      useCase.summarizeMedicaments(user, presenterSpy);

      assertEquals(0, presenterSpy.responseModel.getMedicamentSummaries().size());
    }
  }

  @Nested
  public class GivenOneMedicament {
    private Medicament medicament;

    @BeforeEach
    public void setupCodecast() {
      medicament = Context.medicamentGateway.save(new Medicament("med", 15, LocalDate.EPOCH, null));
    }

    @Test
    public void oneIsPresented() {
      Context.medicamentGateway.save(medicament);
      presenterSpy = new ShowMedicamentOutputBoundarySpy();

      useCase.summarizeMedicaments(user, presenterSpy);
      var MedicamentSummary = presenterSpy.responseModel.getMedicamentSummaries().get(0);

      assertEquals(1, presenterSpy.responseModel.getMedicamentSummaries().size());
      assertEquals(medicament.getName(), MedicamentSummary.medicamentName);
    }
  }
}