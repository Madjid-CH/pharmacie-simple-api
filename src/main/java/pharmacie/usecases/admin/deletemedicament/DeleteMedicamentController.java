package pharmacie.usecases.admin.deletemedicament;

import org.springframework.web.bind.annotation.*;
import pharmacie.entities.Medicament;
import pharmacie.gateways.MedicamentGateway;
import pharmacie.gateways.mysql.MySQLMedicamentGateway;

@RestController
@RequestMapping("/medicament")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DeleteMedicamentController {
  private final DeleteMedicamentUsecase usecase;


  public DeleteMedicamentController() {
    this.usecase = new DeleteMedicamentUsecase();
  }

  @DeleteMapping("/{id}")
  public boolean deleteMedicament(@PathVariable String id) {
    var requestModel = handleRequest(id);
    usecase.deleteMedicament(null, requestModel,null);
    return true;
  }

  private DeleteMedicamentRequestModel handleRequest(String id) {
    var medicament = new Medicament(null, 0, null, null, 0);
    medicament.setId(id);
    var requestModel = new DeleteMedicamentRequestModel();
    requestModel.medicament = medicament;
    return requestModel;
  }
}
