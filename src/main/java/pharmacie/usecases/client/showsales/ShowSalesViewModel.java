package pharmacie.usecases.client.showsales;

import java.util.ArrayList;
import java.util.List;

public class ShowSalesViewModel
{

  public ArrayList<ViewableSaleSummary> viewableSaleSummaries = new ArrayList<>();

  public void addModel(ViewableSaleSummary viewableSaleSummary) {
    viewableSaleSummaries.add(viewableSaleSummary);
  }

  public List<ViewableSaleSummary> getViewableCodecasts() {
    return viewableSaleSummaries;
  }

  public static class ViewableSaleSummary {
    public String title;
    public String permalink;
    public String publicationDate;
  }
}
