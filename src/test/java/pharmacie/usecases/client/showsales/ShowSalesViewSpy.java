package pharmacie.usecases.client.showsales;

public class ShowSalesViewSpy implements ShowSalesView
{
  public boolean generateViewWasCalled = false;
  public ShowSalesViewModel viewModel;

  public String generateView(ShowSalesViewModel viewModel)
  {
    this.viewModel = viewModel;
    generateViewWasCalled = true;
    return null;
  }
}
