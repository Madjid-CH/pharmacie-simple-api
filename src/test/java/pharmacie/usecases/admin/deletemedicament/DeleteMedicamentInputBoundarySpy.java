package pharmacie.usecases.admin.deletemedicament;

import pharmacie.entities.User;

public class DeleteMedicamentInputBoundarySpy implements DeleteMedicamentInputBoundary {
    public boolean deleteMedicamentWasCalled = false;
    public User requestedUser;
    public DeleteMedicamentOutputBoundary outputBoundary;

  @Override
  public void deleteMedicament(User loggedInUser, DeleteMedicamentRequestModel requestModel, DeleteMedicamentOutputBoundary presenter) {
    deleteMedicamentWasCalled = true;
    requestedUser = loggedInUser;
    outputBoundary = presenter;
  }

}
