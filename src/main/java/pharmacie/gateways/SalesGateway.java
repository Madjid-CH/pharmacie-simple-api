package pharmacie.gateways;

import pharmacie.entities.Medicament;
import pharmacie.entities.Sale;
import pharmacie.entities.User;

import java.util.List;

public interface SalesGateway {
  List<Sale> findAllSalesByUser(User user);

  void delete(Sale sale);

  Sale save(Sale sale);

  List<Sale> findAllSaleByMadicament(Medicament medicament);

  void modify(Sale sale);
}
