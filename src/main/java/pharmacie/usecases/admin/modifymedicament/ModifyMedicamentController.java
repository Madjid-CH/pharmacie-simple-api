package pharmacie.usecases.admin.modifymedicament;

import lombok.val;
import org.springframework.web.bind.annotation.*;
import pharmacie.entities.Medicament;
import pharmacie.usecases.admin.addmedicament.MedicamentInfo;

import java.time.LocalDate;

@RestController
@RequestMapping("/medicament")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ModifyMedicamentController {

  private final ModifyMedicamentUsecase usecase;

  public ModifyMedicamentController() {
    this.usecase = new ModifyMedicamentUsecase();
  }

  @PatchMapping("/{id}")
  public boolean modifyMedicament(@RequestBody MedicamentInfo info, @PathVariable String id) {
    val requestModel = handleRequest(info, id);
    usecase.modifyMedicament(null, requestModel,null);
    return true;
  }

  private ModifyMedicamentRequestModel handleRequest(MedicamentInfo info, String id) {
    val dosage = new Medicament.Dosage(98, "ml");
    val medicament = new Medicament(info.name(), info.quantity(), LocalDate.now(), dosage, info.price());
    medicament.setId(id);
    val requestModel = new ModifyMedicamentRequestModel();
    requestModel.medicament = medicament;
    return requestModel;
  }
}
