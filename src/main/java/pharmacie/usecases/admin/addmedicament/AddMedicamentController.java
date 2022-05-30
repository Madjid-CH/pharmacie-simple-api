package pharmacie.usecases.admin.addmedicament;

import org.springframework.web.bind.annotation.*;
import pharmacie.entities.Medicament;
import pharmacie.gateways.MedicamentGateway;
import pharmacie.gateways.mysql.MySQLMedicamentGateway;
import pharmacie.usecases.Controller;

import java.time.LocalDate;

@RestController
@RequestMapping("/medicament")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AddMedicamentController implements Controller {
  private final MedicamentGateway gateway;
  private final AddMedicamentUsecase usecase;

  public AddMedicamentController() {
    this.gateway = new MySQLMedicamentGateway();
    this.usecase = new AddMedicamentUsecase();
  }

  @PostMapping
  public boolean addMedicament(@RequestBody MedicamentInfo medicament) {
    var requestModel = new AddMedicamentRequestModel();
    var dosage = new Medicament.Dosage(8, "ml");
    requestModel.medicament = new Medicament(medicament.name(), medicament.quantity(),
            LocalDate.now(), dosage, medicament.price());
    gateway.save(requestModel.medicament);
    return true;
  }
}
