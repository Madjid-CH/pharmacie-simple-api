package pharmacie.usecases.client.deletesale;


public class DeleteSaleOutputBoundarySpy implements DeleteSaleOutputBoundary {
  public DeleteSaleResponseModel responseModel;

  @Override
  public void present(DeleteSaleResponseModel responseModel) {
    this.responseModel = responseModel;
  }
}
