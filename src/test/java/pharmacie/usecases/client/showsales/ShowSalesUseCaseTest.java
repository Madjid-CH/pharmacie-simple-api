package pharmacie.usecases.client.showsales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pharmacie.Context;
import pharmacie.TestSetup;
import pharmacie.entities.Medicament;
import pharmacie.entities.Sale;
import pharmacie.entities.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ShowSalesUseCaseTest {
  private User user;
  private ShowSalesUseCase useCase;
  public ShowSalesOutputBoundarySpy presenterSpy;

  @BeforeEach
  public void setUp() {
    TestSetup.setupContext();
    user = Context.userGateway.save(new User("User", "clinet"));
    useCase = new ShowSalesUseCase();
    presenterSpy = new ShowSalesOutputBoundarySpy();
  }

  @Test
  public void useCaseWiring()
  {
    useCase.summarizeSales(user, presenterSpy);
    assertNotNull(presenterSpy.responseModel);
  }

  @Nested
  public class GivenNoSales {
    @Test
    public void noneArePresented() {
      useCase.summarizeSales(user, presenterSpy);

      assertEquals(0, presenterSpy.responseModel.getSaleSummaries().size());
      assertEquals(0, presenterSpy.responseModel.getTotal());
    }
  }

  @Nested
  public class GivenOneSale {
    private Sale sale;
    private Medicament medicament;

    @BeforeEach
    public void setupCodecast() {
      var date = LocalDate.of(2022, 6, 9);
      var dosage = new Medicament.Dosage(0.5, "ml/g");
      medicament = Context.medicamentGateway.save(new Medicament("med", 15, date, dosage));
      sale = new Sale(user.getId(), medicament.getName(), 2, 100, LocalDate.now());
    }

    @Test
    public void oneIsPresented() throws Exception {
      Context.salesGateway.save(sale);
      presenterSpy = new ShowSalesOutputBoundarySpy();

      useCase.summarizeSales(user, presenterSpy);
      var saleSummary = presenterSpy.responseModel.getSaleSummaries().get(0);

      assertEquals(1, presenterSpy.responseModel.getSaleSummaries().size());
      assertEquals(medicament.getName(), saleSummary.medicamentName);
      assertEquals(200, presenterSpy.responseModel.getTotal());
    }
  }
}
