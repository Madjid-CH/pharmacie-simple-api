package pharmacie.usecases.client.addsale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pharmacie.Context;
import pharmacie.TestSetup;
import pharmacie.entities.Medicament;
import pharmacie.entities.Sale;
import pharmacie.entities.User;
import pharmacie.usecases.client.savesale.AddSaleRequestModel;
import pharmacie.usecases.client.savesale.AddSaleUsecase;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AddSaleUsecaseTest {
  private User user;
  private AddSaleUsecase useCase;
  private AddSaleRequestModel requestModel;
  private AddSaleOutputBoundarySpy presenterSpy;

  @BeforeEach
  public void setUp() {
    TestSetup.setupContext();
    user = Context.userGateway.save(new User("User", "client"));
    useCase = new AddSaleUsecase();
    requestModel = new AddSaleRequestModel();
    presenterSpy = new AddSaleOutputBoundarySpy();
  }

  @Test
  public void useCaseWiring()
  {
    requestModel.sale = new Sale("", "", 0, 0, LocalDate.now());
    useCase.addSale(user, requestModel, presenterSpy);
    assertNotNull(presenterSpy.responseModel,"testing the response model is set properly");
  }

  @Nested
  public class AddingOneSaleToSaleGateway {
    private Sale sale;

    @BeforeEach
    public void setupSale() {
      var experationDate = LocalDate.of(2025,11,1);
      var dosage = new Medicament.Dosage(0.5, "ml/g");
      var medicament = Context.medicamentGateway.save(new Medicament("med", 15, experationDate, dosage));
      sale = new Sale(user.getId(), medicament.getId(), 1, 100, LocalDate.now());
    }

    @Test
    public void shouldAddOneSaleToGateway() {
      var requestModel = new AddSaleRequestModel();
      requestModel.sale = sale;
      useCase.addSale(user, requestModel, presenterSpy);

      var savedSale = Context.salesGateway.findAllSalesByUser(user).get(0);
      assertTrue(sale.isSame(savedSale), "testing that the same object is retrived from DB");
    }
  }

}
