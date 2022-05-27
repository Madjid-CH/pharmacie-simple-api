package pharmacie.usecases.admin.showmedicaments;

import java.util.ArrayList;
import java.util.List;

public class ShowMedicamentViewModel
{

  public ArrayList<ViewableMedicamentSummary> summaries = new ArrayList<>();

  public void addModel(ViewableMedicamentSummary viewableMedicamentSummary) {
    summaries.add(viewableMedicamentSummary);
  }

  public List<ViewableMedicamentSummary> getViewableMedicaments() {
    return summaries;
  }

  public static class ViewableMedicamentSummary {
    public String title;
    public String experationDate;
  }
}
