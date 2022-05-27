package pharmacie.usecases.admin.showmedicaments;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pharmacie.entities.Medicament;
import pharmacie.gateways.MedicamentGateway;
import pharmacie.gateways.mysql.MySQLMedicamentGateway;
import pharmacie.usecases.Controller;

import java.util.List;

@RestController
@RequestMapping("/medicament")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShowMedicamentController implements Controller {

  private final MedicamentGateway gateway;

  public ShowMedicamentController() {
    this.gateway = new MySQLMedicamentGateway();
  }

  @GetMapping
  public List<Medicament> findAll() {
    return gateway.findAllMedicaments();
  }
}

