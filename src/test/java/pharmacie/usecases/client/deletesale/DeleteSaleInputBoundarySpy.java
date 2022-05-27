package pharmacie.usecases.client.deletesale;

import pharmacie.entities.User;

public class DeleteSaleInputBoundarySpy implements DeleteSaleInputBoundary {
    public boolean deleteSaleWasCalled = false;
    public User requestedUser;
    public DeleteSaleOutputBoundary outputBoundary;

  @Override
  public void deleteSale(User loggedInUser, DeleteSaleRequestModel requestModel, DeleteSaleOutputBoundary presenter) {
    deleteSaleWasCalled = true;
    requestedUser = loggedInUser;
    outputBoundary = presenter;
  }

}
