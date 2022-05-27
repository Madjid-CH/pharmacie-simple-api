package pharmacie.usecases.client.addsale;

import pharmacie.entities.User;
import pharmacie.usecases.client.savesale.AddSaleInputBoundary;
import pharmacie.usecases.client.savesale.AddSaleOutputBoundary;
import pharmacie.usecases.client.savesale.AddSaleRequestModel;

public class AddSaleInputBoundarySpy implements AddSaleInputBoundary {
    public boolean addSaleWasCalled = false;
    public User requestedUser;
    public AddSaleOutputBoundary outputBoundary;

  @Override
  public void addSale(User loggedInUser, AddSaleRequestModel requestModel, AddSaleOutputBoundary presenter) {
    addSaleWasCalled = true;
    requestedUser = loggedInUser;
    outputBoundary = presenter;
  }
}
