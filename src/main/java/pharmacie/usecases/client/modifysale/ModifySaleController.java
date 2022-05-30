package pharmacie.usecases.client.modifysale;

import org.springframework.web.bind.annotation.*;
import pharmacie.entities.Medicament;
import pharmacie.entities.Sale;
import pharmacie.usecases.admin.addmedicament.MedicamentInfo;
import pharmacie.usecases.admin.modifymedicament.ModifyMedicamentRequestModel;

import java.time.LocalDate;

@RestController
@RequestMapping("/sales")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ModifySaleController {

  private final ModifySaleUsecase usecase;

  public ModifySaleController() {
    this.usecase = new ModifySaleUsecase();
  }

  @PatchMapping
  public boolean modifySale(@RequestBody SaleInfo sale) {
    var requestModel = handleRequest(sale);
    usecase.modifySale(null, requestModel, null);
    return true;
  }

  private ModifySaleRequestModel handleRequest(SaleInfo info) {
    var sale = new Sale(info.clientId(), info.medicamentName(), info.quantity(), info.price(), LocalDate.now());
    sale.setId(info.id());
    var requestModel = new ModifySaleRequestModel();
    requestModel.sale = sale;
    return requestModel;
  }
}
