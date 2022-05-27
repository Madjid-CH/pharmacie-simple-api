package pharmacie.usecases.admin.showmedicaments;

import java.util.ArrayList;
import java.util.List;

public class ShowMedicamentResponseModel
{
  private final List<MedicamentSummary> medicamentSummaries;

  public ShowMedicamentResponseModel() {
    medicamentSummaries = new ArrayList<>();
  }

  public List<MedicamentSummary> getMedicamentSummaries() {
    return medicamentSummaries;
  }

  public void addMedicamentSummary(MedicamentSummary summary) {
    medicamentSummaries.add(summary);
  }

}
