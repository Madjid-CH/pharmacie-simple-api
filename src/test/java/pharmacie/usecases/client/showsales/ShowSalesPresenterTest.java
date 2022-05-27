package pharmacie.usecases.client.showsales;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShowSalesPresenterTest {

  @Test
  public void validateViewModel() {
    var responseModel = new ShowSalesResponseModel();
    var summary = new SaleSummary();
    summary.medicamentName = "Title";
    summary.sellingDate = LocalDate.now();
    responseModel.addSaleSummary(summary);

    var presenter = new ShowSalesPresenter();
    presenter.present(responseModel);

    var viewModel = presenter.getViewModel();
    ShowSalesViewModel.ViewableSaleSummary viewableSummary = viewModel.viewableSaleSummaries.get(0);
    assertEquals(summary.medicamentName, viewableSummary.title);
  }

}
