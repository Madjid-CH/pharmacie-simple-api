package pharmacie.usecases.client.savesale;

import pharmacie.entities.User;

public interface AddSaleInputBoundary {
  void addSale(User loggedInUser, AddSaleRequestModel requestModel, AddSaleOutputBoundary presenter);
}
