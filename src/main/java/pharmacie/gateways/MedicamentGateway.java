package pharmacie.gateways;

import pharmacie.entities.Medicament;

import java.util.List;

public interface MedicamentGateway {
  List<Medicament> findAllMedicaments();

  void delete(Medicament medicament);

  Medicament save(Medicament medicament);

  Medicament findMedicamentByName(String medicamentName);

  void modify(Medicament medicament);
}
