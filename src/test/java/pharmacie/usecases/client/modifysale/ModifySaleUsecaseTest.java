package pharmacie.usecases.client.modifysale;

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

public class ModifySaleUsecaseTest {
  private User user;
  private ModifySaleUsecase useCase;
  private ModifySaleRequestModel requestModel;
  private ModifySaleOutputBoundarySpy presenterSpy;

  @BeforeEach
  public void setUp() {
    TestSetup.setupContext();
    user = Context.userGateway.save(new User("User", "client"));
    useCase = new ModifySaleUsecase();
    requestModel = new ModifySaleRequestModel();
    presenterSpy = new ModifySaleOutputBoundarySpy();
  }

  @Test
  public void useCaseWiring()
  {
    requestModel.sale = new Sale("", "", 0, 0, LocalDate.now());
    useCase.modifySale(user, requestModel, presenterSpy);
    assertNotNull(presenterSpy.responseModel);
  }

  @Nested
  public class ModifyingOneSale {
    private Medicament medicament;
    private Sale sale;

    @BeforeEach
    public void setupSale() {
      sale = new Sale(user.getId(), "med1", 1, 100, LocalDate.now());
      Context.salesGateway.save(sale);
    }

    @Test
    public void shouldAddOneSaleToGateway() {
      var requestModel = new ModifySaleRequestModel();
      Sale modifiedSale = new Sale(user.getId(), "med2", 2, 50, LocalDate.now());
      modifiedSale.setId(sale.getId());
      requestModel.sale = modifiedSale;
      useCase.modifySale(user, requestModel, presenterSpy);

      var savedSale = Context.salesGateway.findAllSalesByUser(user).get(0);
      assertTrue(sale.isSame(savedSale));
      assertEquals(sale.getClientId(), savedSale.getClientId());
      assertNotEquals(sale.getMedicamentName(), savedSale.getMedicamentName());
      assertNotEquals(sale.getQuantity(), savedSale.getQuantity());
      assertNotEquals(sale.getPrice(), savedSale.getPrice());
    }
  }

}
