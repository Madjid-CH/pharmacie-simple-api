package pharmacie.usecases.client.modifysale;

import pharmacie.Context;
import pharmacie.entities.User;

public class ModifySaleUsecase implements ModifySaleInputBoundary {
  public void modifySale(User user, ModifySaleRequestModel requestModel, ModifySaleOutputBoundary outputBoundary) {
    Context.salesGateway.modify(requestModel.sale);
    var responseModel = new ModifySaleResponseModel();
    responseModel.saleModified = true;
    outputBoundary.present(responseModel);
  }
}
