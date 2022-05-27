package pharmacie.usecases.admin.modifymedicament;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pharmacie.Context;
import pharmacie.TestSetup;
import pharmacie.entities.Medicament;
import pharmacie.entities.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ModifyMedicamentUsecaseTest {

    private User user;
    private ModifyMedicamentUsecase useCase;
    private ModifyMedicamentRequestModel requestModel;
    private ModifyMedicamentOutputBoundarySpy presenterSpy;

    @BeforeEach
    public void setUp() {
      TestSetup.setupContext();
      user = Context.userGateway.save(new User("User", "admin"));
      useCase = new ModifyMedicamentUsecase();
      requestModel = new ModifyMedicamentRequestModel();
      presenterSpy = new ModifyMedicamentOutputBoundarySpy();
    }

    @Test
    public void useCaseWiring()
    {
      requestModel.medicament = new Medicament("", 0,LocalDate.now(),null);
      useCase.modifyMedicament(user, requestModel, presenterSpy);
      assertNotNull(presenterSpy.responseModel);
    }

    @Nested
    public class ModifyingOneMedicament {
      private Medicament medicament;

      @BeforeEach
      public void setupSale() {
        medicament = new Medicament("", 0,LocalDate.now(),null);
        Context.medicamentGateway.save(medicament);
      }

      @Test
      public void shouldAddOneMedicamentToGateway() {
        var requestModel = new ModifyMedicamentRequestModel();
        var modifiedMedicament = new Medicament("med-name", 0,medicament.getExperationDate(),null);
        modifiedMedicament.setId(medicament.getId());
        requestModel.medicament = modifiedMedicament;
        useCase.modifyMedicament(user, requestModel, presenterSpy);

        var savedMedicament = Context.medicamentGateway.findMedicamentByName(modifiedMedicament.getName());
        assertTrue(medicament.isSame(savedMedicament));
        assertEquals(medicament.getExperationDate(), savedMedicament.getExperationDate());
        assertNotEquals(modifiedMedicament.getName(), medicament.getName());
      }
    }

  }