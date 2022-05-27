package pharmacie.usecases.admin.modifymedicament;

import pharmacie.entities.User;

public interface ModifyMedicamentInputBoundary {
  void modifyMedicament(User loggedInUser,
                        ModifyMedicamentRequestModel requestModel,
                        ModifyMedicamentOutputBoundary presenter);
}
