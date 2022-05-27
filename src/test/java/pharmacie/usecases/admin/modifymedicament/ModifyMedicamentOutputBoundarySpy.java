package pharmacie.usecases.admin.modifymedicament;

public class ModifyMedicamentOutputBoundarySpy implements ModifyMedicamentOutputBoundary {
  public ModifyMedicamentResponseModel responseModel;

  @Override
  public void present(ModifyMedicamentResponseModel responseModel) {
    this.responseModel = responseModel;
  }
}
