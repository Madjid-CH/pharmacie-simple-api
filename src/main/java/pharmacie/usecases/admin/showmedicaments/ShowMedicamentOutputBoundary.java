package pharmacie.usecases.admin.showmedicaments;

public interface ShowMedicamentOutputBoundary
{
  ShowMedicamentViewModel getViewModel();

  void present(ShowMedicamentResponseModel responseModel);
}
