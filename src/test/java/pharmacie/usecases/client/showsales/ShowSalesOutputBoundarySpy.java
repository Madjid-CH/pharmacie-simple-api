package pharmacie.usecases.client.showsales;

public class ShowSalesOutputBoundarySpy implements ShowSalesOutputBoundary
{
  public ShowSalesViewModel viewModel;
  public ShowSalesResponseModel responseModel;

  @Override
  public ShowSalesViewModel getViewModel()
  {
    return viewModel;
  }

  @Override
  public void present(ShowSalesResponseModel responseModel) { this.responseModel = responseModel; }

}
