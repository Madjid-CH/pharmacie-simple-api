package pharmacie.usecases.admin.addmedicament;

import pharmacie.entities.User;

public interface AddMedicamentInputBoundary {
  void addMedicament(User loggedInUser, AddMedicamentRequestModel requestModel, AddMedicamentOutputBoundary presenter);
}
