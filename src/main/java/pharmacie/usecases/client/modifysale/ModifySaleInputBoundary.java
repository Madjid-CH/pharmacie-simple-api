package pharmacie.usecases.client.modifysale;

import pharmacie.entities.User;

public interface ModifySaleInputBoundary {
  void modifySale(User loggedInUser, ModifySaleRequestModel requestModel, ModifySaleOutputBoundary presenter);
}
