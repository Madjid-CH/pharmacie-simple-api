package pharmacie.usecases.admin.deletemedicament;

import pharmacie.Context;
import pharmacie.entities.User;

public class DeleteMedicamentUsecase implements DeleteMedicamentInputBoundary {
  @Override
  public void deleteMedicament(User loggedInUser,
                               DeleteMedicamentRequestModel requestModel,
                               DeleteMedicamentOutputBoundary presenter) {
    Context.medicamentGateway.delete(requestModel.medicament);
    var responseModel = new DeleteMedicamentResponseModel();
    responseModel.medicamentDeleted = true;
    presenter.present(responseModel);
  }
}
