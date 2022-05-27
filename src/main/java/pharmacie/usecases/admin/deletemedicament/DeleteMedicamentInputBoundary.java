package pharmacie.usecases.admin.deletemedicament;

import pharmacie.entities.User;

public interface DeleteMedicamentInputBoundary {
  void deleteMedicament(User loggedInUser,
                        DeleteMedicamentRequestModel requestModel,
                        DeleteMedicamentOutputBoundary presenter);
}
