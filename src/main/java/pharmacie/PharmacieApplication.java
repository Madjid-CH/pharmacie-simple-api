package pharmacie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pharmacie.gateways.mysql.MySQLMedicamentGateway;
import pharmacie.gateways.mysql.MySQLSaleGateway;
import pharmacie.gateways.mysql.MySQLUserGateway;

@SpringBootApplication
public class PharmacieApplication {

  public static void main(String[] args) {
    Context.medicamentGateway = new MySQLMedicamentGateway();
    Context.salesGateway = new MySQLSaleGateway();
    Context.userGateway = new MySQLUserGateway();
    Context.gateKeeper = new GateKeeper();

    SpringApplication.run(PharmacieApplication.class, args);
  }

}
