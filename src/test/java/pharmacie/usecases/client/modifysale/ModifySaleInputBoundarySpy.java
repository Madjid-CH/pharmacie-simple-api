package pharmacie.usecases.client.modifysale;

import pharmacie.entities.User;

public class ModifySaleInputBoundarySpy implements ModifySaleInputBoundary {
    public boolean ModifySaleWasCalled = false;
    public User requestedUser;
    public ModifySaleOutputBoundary outputBoundary;

  @Override
  public void modifySale(User loggedInUser, ModifySaleRequestModel requestModel, ModifySaleOutputBoundary presenter) {
    ModifySaleWasCalled = true;
    requestedUser = loggedInUser;
    outputBoundary = presenter;
  }

}
