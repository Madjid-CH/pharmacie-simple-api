package pharmacie.usecases.admin.showmedicaments;

import pharmacie.Context;
import pharmacie.entities.Medicament;
import pharmacie.entities.Sale;
import pharmacie.entities.User;

import java.util.List;

public class ShowMedicamentUseCase implements ShowMedicamentInputBoundary {

  public void summarizeMedicaments(User loggedInUser, ShowMedicamentOutputBoundary presenter)
  {
    ShowMedicamentResponseModel responseModel = new ShowMedicamentResponseModel();
    List<Medicament> medicaments = Context.medicamentGateway.findAllMedicaments();

    for (var m : medicaments)
      responseModel.addMedicamentSummary(summarizeMedicament(m));

    presenter.present(responseModel);
  }

  private MedicamentSummary summarizeMedicament(Medicament medicament) {
    var summary = new MedicamentSummary();
    summary.medicamentName = medicament.getName();
    summary.experationDate = medicament.getExperationDate();
    summary.price = medicament.getPrice();
    return summary;
  }

}

