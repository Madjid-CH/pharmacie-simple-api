package pharmacie.usecases.client.savesale;

import org.springframework.web.bind.annotation.*;
import pharmacie.entities.Sale;

@RestController
@RequestMapping("/sales")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AddSaleController {

  private final AddSaleUsecase useCase;

  public AddSaleController() {
    useCase = new AddSaleUsecase();
  }

  @PostMapping
  public boolean findAllSalesByUser(@RequestBody Sale sale) {
    var requestModel = new AddSaleRequestModel();
    requestModel.sale = sale;
    useCase.addSale(null, requestModel, null);
    return true;
  }

}
