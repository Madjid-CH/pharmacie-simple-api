package pharmacie.usecases.admin.deletemedicament;


public class DeleteMedicamentOutputBoundarySpy implements DeleteMedicamentOutputBoundary {
  public DeleteMedicamentResponseModel responseModel;

  @Override
  public void present(DeleteMedicamentResponseModel responseModel) {
    this.responseModel = responseModel;
  }
}
