package pharmacie.usecases.client.deletesale;

import pharmacie.entities.User;

public interface DeleteSaleInputBoundary {
  void deleteSale(User loggedInUser, DeleteSaleRequestModel requestModel, DeleteSaleOutputBoundary presenter);
}
