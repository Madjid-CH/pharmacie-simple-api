package pharmacie.doubles;

import pharmacie.entities.Medicament;
import pharmacie.gateways.MedicamentGateway;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMedicamentGateway extends GatewayUtilities<Medicament> implements MedicamentGateway {
  public List<Medicament> findAllMedicaments() {
    return new ArrayList<Medicament>(getEntities());
  }

  public Medicament findMedicamentByName(String medicamentName) {
    for (Medicament medicament : getEntities())
      if (medicament.getName().equals(medicamentName))
        return medicament;
    return null;
  }

}