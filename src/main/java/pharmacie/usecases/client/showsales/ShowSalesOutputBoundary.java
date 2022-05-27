package pharmacie.usecases.client.showsales;

public interface ShowSalesOutputBoundary
{
  ShowSalesViewModel getViewModel();

  void present(ShowSalesResponseModel responseModel);
}
