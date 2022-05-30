package pharmacie.usecases.client.savesale;

import org.springframework.web.bind.annotation.*;
import pharmacie.entities.Sale;

@RestController
@RequestMapping("/sales")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AddSaleController {

  private final AddSaleUsecase usecase;

  public AddSaleController() {
    usecase = new AddSaleUsecase();
  }

  @PostMapping
  public boolean findAllByUser(@RequestBody Sale sale) {
    var requestModel = new AddSaleRequestModel();
    requestModel.sale = sale;
    usecase.addSale(null, requestModel, null);
    return true;
  }
}
