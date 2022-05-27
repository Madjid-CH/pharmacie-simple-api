package pharmacie.usecases.client.showsales;

import pharmacie.entities.User;

public interface ShowSalesInputBoundary
{
  void summarizeSales(User loggedInUser, ShowSalesOutputBoundary presenter);
}
