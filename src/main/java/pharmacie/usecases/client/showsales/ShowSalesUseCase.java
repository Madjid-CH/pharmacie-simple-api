package pharmacie.usecases.client.showsales;

import pharmacie.Context;
import pharmacie.entities.*;

import java.util.List;

public class ShowSalesUseCase implements ShowSalesInputBoundary {

  public void summarizeSales(User loggedInUser, ShowSalesOutputBoundary presenter)
  {
    ShowSalesResponseModel responseModel = new ShowSalesResponseModel();
    List<Sale> allSalesByUser = Context.salesGateway.findAllSalesByUser(loggedInUser);

    for (Sale sale : allSalesByUser)
      responseModel.addSaleSummary(summarizeSale(sale, loggedInUser));

    presenter.present(responseModel);
  }

  private SaleSummary summarizeSale(Sale sale, User user) {
    SaleSummary summary = new SaleSummary();
    summary.medicamentName = sale.getMedicamentName();
    summary.sellingDate = sale.getSellingDate();
    summary.price = sale.getPrice() * sale.getQuantity();
    return summary;
  }

}

