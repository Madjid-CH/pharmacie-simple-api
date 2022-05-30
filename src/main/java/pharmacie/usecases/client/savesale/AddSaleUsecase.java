package pharmacie.usecases.client.savesale;

import pharmacie.Context;
import pharmacie.entities.User;

public class AddSaleUsecase implements AddSaleInputBoundary {
  public void addSale(User user, AddSaleRequestModel requestModel, AddSaleOutputBoundary outputBoundary) {
    Context.salesGateway.save(requestModel.sale);
    var responseModel = new AddSaleResponseModel();
    responseModel.saleSaved = true;
    if (outputBoundary != null)
      outputBoundary.present(responseModel);
  }
}
