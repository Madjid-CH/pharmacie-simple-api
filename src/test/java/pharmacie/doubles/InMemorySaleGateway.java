package pharmacie.doubles;

import pharmacie.entities.Medicament;
import pharmacie.entities.Sale;
import pharmacie.entities.User;
import pharmacie.gateways.SalesGateway;

import java.util.ArrayList;
import java.util.List;

public class InMemorySaleGateway extends GatewayUtilities<Sale> implements SalesGateway {
  public List<Sale> findAllSalesByUser(User user) {
    var results = new ArrayList<Sale>();
    for (Sale sale : getEntities())
      if (sale.getClientId().equals(user.getId())) results.add(sale);
    return results;
  }


  public List<Sale> findAllSaleByMadicament(Medicament medicament) {
    var results = new ArrayList<Sale>();
    for (Sale sale : getEntities())
      if (sale.getMedicamentName().equals(medicament.getName())) results.add(sale);
    return results;
  }

}
