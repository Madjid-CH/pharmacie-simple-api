package pharmacie.usecases.client.deletesale;

import pharmacie.Context;
import pharmacie.entities.User;
import pharmacie.usecases.admin.deletemedicament.DeleteMedicamentInputBoundary;
import pharmacie.usecases.admin.deletemedicament.DeleteMedicamentOutputBoundary;
import pharmacie.usecases.admin.deletemedicament.DeleteMedicamentRequestModel;
import pharmacie.usecases.admin.deletemedicament.DeleteMedicamentResponseModel;

public class DeleteSaleUsecase implements DeleteSaleInputBoundary {
  @Override
  public void deleteSale(User loggedInUser,
                         DeleteSaleRequestModel requestModel,
                         DeleteSaleOutputBoundary presenter) {
    Context.salesGateway.delete(requestModel.sale);
    var responseModel = new DeleteSaleResponseModel();
    responseModel.saleDeleted = true;
    presenter.present(responseModel);
  }
}
