package pharmacie.usecases.admin.addmedicament;

import org.springframework.web.bind.annotation.*;
import pharmacie.entities.Medicament;
import pharmacie.entities.User;
import pharmacie.gateways.MedicamentGateway;
import pharmacie.gateways.mysql.MySQLMedicamentGateway;
import pharmacie.usecases.Controller;

import java.util.List;

@RestController
@RequestMapping("/medicament")
public class AddMedicamentController implements Controller {
  private final MedicamentGateway gateway;
  private final AddMedicamentUsecase usecase;

  public AddMedicamentController() {
    this.gateway = new MySQLMedicamentGateway();
    this.usecase = new AddMedicamentUsecase();
  }

  @PostMapping
  public User addMedicament(@RequestBody User user) {
//      var requestModel = new AddMedicamentRequestModel();
//      requestModel.medicament = medicament;
//    System.out.println(medicament);
//
////      usecase.addMedicament(null, requestModel,null);
//      gateway.save(medicament);
    user.setId("lkmsdjqlkmdqsqsdjklmf");

    return user;
  }
}
