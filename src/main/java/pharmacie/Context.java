package pharmacie;

import pharmacie.gateways.MedicamentGateway;
import pharmacie.gateways.SalesGateway;
import pharmacie.gateways.UserGateway;

public class Context {
  public static UserGateway userGateway;
  public static MedicamentGateway medicamentGateway;
  public static SalesGateway salesGateway;
  public static GateKeeper gateKeeper;
}
