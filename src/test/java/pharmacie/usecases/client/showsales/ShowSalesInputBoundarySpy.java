package pharmacie.usecases.client.showsales;

import pharmacie.entities.User;

public class ShowSalesInputBoundarySpy implements ShowSalesInputBoundary
{
  public boolean summarizeSalesWasCalled = false;
  public User requestedUser;
  public ShowSalesOutputBoundary outputBoundary;

  @Override
  public void summarizeSales(User loggedInUser, ShowSalesOutputBoundary presenter) {
    summarizeSalesWasCalled = true;
    requestedUser = loggedInUser;
    outputBoundary = presenter;
  }
}
