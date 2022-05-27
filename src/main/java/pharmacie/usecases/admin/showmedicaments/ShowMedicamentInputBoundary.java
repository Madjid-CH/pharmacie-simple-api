package pharmacie.usecases.admin.showmedicaments;

import pharmacie.entities.User;

public interface ShowMedicamentInputBoundary
{
  void summarizeMedicaments(User loggedInUser, ShowMedicamentOutputBoundary presenter);
}
