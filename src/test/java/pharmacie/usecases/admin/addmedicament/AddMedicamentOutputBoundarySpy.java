package pharmacie.usecases.admin.addmedicament;

public class AddMedicamentOutputBoundarySpy implements AddMedicamentOutputBoundary {
  public AddMedicamentResponseModel responseModel;

  @Override
  public void present(AddMedicamentResponseModel responseModel) {
    this.responseModel = responseModel;
  }
}
