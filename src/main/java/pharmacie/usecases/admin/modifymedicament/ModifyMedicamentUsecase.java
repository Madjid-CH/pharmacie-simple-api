package pharmacie.usecases.admin.modifymedicament;

import pharmacie.Context;
import pharmacie.entities.User;

public class ModifyMedicamentUsecase implements ModifyMedicamentInputBoundary {
  public void modifyMedicament(User user, ModifyMedicamentRequestModel requestModel, ModifyMedicamentOutputBoundary outputBoundary) {
    Context.medicamentGateway.modify(requestModel.medicament);
    var responseModel = new ModifyMedicamentResponseModel();
    responseModel.MedicamentModified = true;
    outputBoundary.present(responseModel);
  }
}
