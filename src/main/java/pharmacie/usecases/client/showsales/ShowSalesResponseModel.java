package pharmacie.usecases.client.showsales;

import java.util.ArrayList;
import java.util.List;

public class ShowSalesResponseModel
{
  private final List<SaleSummary> saleSummaries;

  public ShowSalesResponseModel() {
    saleSummaries = new ArrayList<>();
  }

  public List<SaleSummary> getSaleSummaries() {
    return saleSummaries;
  }

  public void addSaleSummary(SaleSummary summary) {
    saleSummaries.add(summary);
  }

  public int getTotal() {
    int total = 0;
    for (SaleSummary saleSummary : saleSummaries)
      total += saleSummary.price;
    return total;
  }
}
