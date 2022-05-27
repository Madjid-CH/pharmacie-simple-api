package pharmacie.usecases.client.showsales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pharmacie.entities.Medicament;
import pharmacie.entities.Sale;
import pharmacie.entities.User;
import pharmacie.gateways.SalesGateway;
import pharmacie.gateways.mysql.MySQLSaleGateway;
import pharmacie.usecases.Controller;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/sales")
public class ShowSalesController implements Controller {

    private final SalesGateway gateway;

    public ShowSalesController() {
      this.gateway = new MySQLSaleGateway();
    }

    @GetMapping
    public List<Sale> findAllByUser(@RequestBody User user) {
      return gateway.findAllSalesByUser(user);
    }

    @GetMapping("/med")
    public List<Sale> findAllByMedicament(@RequestBody Medicament medicament) {
      return gateway.findAllSaleByMadicament(medicament);
    }

}

