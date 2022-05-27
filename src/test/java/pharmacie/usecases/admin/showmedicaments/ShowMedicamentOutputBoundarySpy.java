package pharmacie.usecases.admin.showmedicaments;

public class ShowMedicamentOutputBoundarySpy implements ShowMedicamentOutputBoundary{
  public ShowMedicamentResponseModel responseModel;
  @Override
  public ShowMedicamentViewModel getViewModel() {
    return null;
  }

  @Override
  public void present(ShowMedicamentResponseModel responseModel) {
    this.responseModel = responseModel;
  }
}
