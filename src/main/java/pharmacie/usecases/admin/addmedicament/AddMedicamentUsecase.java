package pharmacie.usecases.admin.addmedicament;

import pharmacie.Context;
import pharmacie.entities.User;

public class AddMedicamentUsecase implements AddMedicamentInputBoundary {
  public void addMedicament(User user, AddMedicamentRequestModel requestModel, AddMedicamentOutputBoundary outputBoundary) {
    Context.medicamentGateway.save(requestModel.medicament);
    var responseModel = new AddMedicamentResponseModel();
    responseModel.medicamentSaved = true;
    outputBoundary.present(responseModel);
  }
}
