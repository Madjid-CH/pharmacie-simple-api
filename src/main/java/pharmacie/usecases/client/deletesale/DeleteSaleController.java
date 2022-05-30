package pharmacie.usecases.client.deletesale;

import org.springframework.web.bind.annotation.*;
import pharmacie.entities.Sale;

@RestController
@RequestMapping("/sales")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DeleteSaleController {

  public final DeleteSaleUsecase usecase;

  public DeleteSaleController() {
    this.usecase = new DeleteSaleUsecase();
  }

  @DeleteMapping("/{id}")
  public boolean deleteSale(@PathVariable String id) {
    var requestModel = handleRequest(id);
    usecase.deleteSale(null, requestModel,null);
    return true;
  }

  private DeleteSaleRequestModel handleRequest(String id) {
    var sale = new Sale("", "", 0, 0, null);
    sale.setId(id);
    var requestModel = new DeleteSaleRequestModel();
    requestModel.sale = sale;
    return requestModel;
  }
}
