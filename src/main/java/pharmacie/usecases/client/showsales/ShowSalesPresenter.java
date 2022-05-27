package pharmacie.usecases.client.showsales;

import pharmacie.usecases.client.showsales.ShowSalesViewModel.ViewableSaleSummary;

import java.text.SimpleDateFormat;

public class ShowSalesPresenter implements ShowSalesOutputBoundary {

  public static SimpleDateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");
  public ShowSalesViewModel viewModel;

  @Override
  public ShowSalesViewModel getViewModel() {
    return viewModel;
  }

  @Override
  public void present(ShowSalesResponseModel responseModel) {
    viewModel = new ShowSalesViewModel();
    for(SaleSummary codecastSummary : responseModel.getSaleSummaries()) {
      viewModel.addModel(makeViewable(codecastSummary));
    }
  }

  private ViewableSaleSummary makeViewable(SaleSummary saleSummary) {
    final ViewableSaleSummary summary = new ViewableSaleSummary();
    summary.title = saleSummary.medicamentName;
    return summary;
  }
}