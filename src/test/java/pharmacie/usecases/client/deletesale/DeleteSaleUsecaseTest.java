package pharmacie.usecases.client.deletesale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pharmacie.Context;
import pharmacie.TestSetup;
import pharmacie.entities.Sale;
import pharmacie.entities.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteSaleUsecaseTest {
  private User user;
  private DeleteSaleUsecase useCase;
  private DeleteSaleRequestModel requestModel;
  private DeleteSaleOutputBoundarySpy presenterSpy;

  @BeforeEach
  public void setUp() {
    TestSetup.setupContext();
    user = Context.userGateway.save(new User("User", "client"));
    useCase = new DeleteSaleUsecase();
    requestModel = new DeleteSaleRequestModel();
    presenterSpy = new DeleteSaleOutputBoundarySpy();
  }

  @Test
  public void useCaseWiring()
  {
    requestModel.sale = new Sale("", "", 0, 0, LocalDate.now());
    useCase.deleteSale(user, requestModel, presenterSpy);
    assertNotNull(presenterSpy.responseModel);
  }

  @Nested
  public class DeletingOneSale {
    private Sale sale;

    @BeforeEach
    public void setupSale() {
      sale = new Sale(user.getId(), "med1", 1, 100, LocalDate.now());
      Context.salesGateway.save(sale);
    }

    @Test
    public void shouldDeleteOneSaleInGateway() {
      var requestModel = new DeleteSaleRequestModel();
      requestModel.sale = sale;
      var sales = Context.salesGateway.findAllSalesByUser(user);

     assertEquals(1, sales.size());
      System.out.println(sales.size());
      useCase.deleteSale(user, requestModel, presenterSpy);
      sales = Context.salesGateway.findAllSalesByUser(user);
      assertEquals(0, sales.size());
      System.out.println(sales.size());
    }
  }

}
