package pharmacie.usecases.admin.showmedicaments;


import pharmacie.usecases.admin.showmedicaments.ShowMedicamentViewModel.ViewableMedicamentSummary;

import java.text.SimpleDateFormat;

public class ShowMedicamentPresenter implements ShowMedicamentOutputBoundary {

  public static SimpleDateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");
  public ShowMedicamentViewModel viewModel;

  @Override
  public ShowMedicamentViewModel getViewModel() {
    return viewModel;
  }

  @Override
  public void present(ShowMedicamentResponseModel responseModel) {
    viewModel = new ShowMedicamentViewModel();
    for(MedicamentSummary medicamentSummary : responseModel.getMedicamentSummaries()) {
      viewModel.addModel(makeViewable(medicamentSummary));
    }
  }

  private ViewableMedicamentSummary makeViewable(MedicamentSummary medicamentSummary) {
    final var summary = new ViewableMedicamentSummary();
    summary.title = medicamentSummary.medicamentName;
    return summary;
  }

}