package pharmacie.usecases.admin.addmedicament;

import pharmacie.entities.User;

public class AddMedicamentInputBoundarySpy implements AddMedicamentInputBoundary {
    public boolean addMedicamentWasCalled = false;
    public User requestedUser;
    public AddMedicamentOutputBoundary outputBoundary;

  @Override
  public void addMedicament(User loggedInUser,
                            AddMedicamentRequestModel requestModel,
                            AddMedicamentOutputBoundary presenter) {
    addMedicamentWasCalled = true;
    requestedUser = loggedInUser;
    outputBoundary = presenter;
  }
}
