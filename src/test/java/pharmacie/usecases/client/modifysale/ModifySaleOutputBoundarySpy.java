package pharmacie.usecases.client.modifysale;


public class ModifySaleOutputBoundarySpy implements ModifySaleOutputBoundary {
  public ModifySaleResponseModel responseModel;

  @Override
  public void present(ModifySaleResponseModel responseModel) {
    this.responseModel = responseModel;
  }
}
