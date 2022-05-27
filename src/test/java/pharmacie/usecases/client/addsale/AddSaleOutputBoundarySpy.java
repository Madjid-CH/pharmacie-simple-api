package pharmacie.usecases.client.addsale;

import pharmacie.usecases.client.savesale.AddSaleOutputBoundary;
import pharmacie.usecases.client.savesale.AddSaleResponseModel;

public class AddSaleOutputBoundarySpy implements AddSaleOutputBoundary {
  public AddSaleResponseModel responseModel;

  @Override
  public void present(AddSaleResponseModel responseModel) {
    this.responseModel = responseModel;
  }
}
