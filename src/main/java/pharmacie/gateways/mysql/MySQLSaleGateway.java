package pharmacie.gateways.mysql;

import pharmacie.entities.*;
import pharmacie.gateways.SalesGateway;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class MySQLSaleGateway implements SalesGateway {
  private static final Connection connection = Connector.getConnection();


  @Override
  public List<Sale> findAllSalesByUser(User user) {
    List<Sale> sales;
    try (var stat = connection.createStatement()) {
      sales = getSalesFromDBByClientId(user.getId(), stat);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return sales;
  }

  private List<Sale> getSalesFromDBByClientId(String clientId, Statement stat) {
    List<Sale> sales = new ArrayList<>();
    var query = "SELECT * FROM pharmacie.sale WHERE clientId = '" + clientId + "';";
    try (ResultSet rs = stat.executeQuery(query)) {
      while (rs.next())
        sales.add(constructSaleEntity(rs));
    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }
    return sales;
  }

  private Sale constructSaleEntity(ResultSet rs) throws SQLException {
    var sale = new Sale(rs.getString("clientId"), rs.getString("medicament_name"),
            rs.getInt("quantity"), rs.getInt("price"),
            LocalDate.parse(rs.getString("selling_date")));
    sale.setId(rs.getString("id"));
    return sale;
  }

  @Override
  public void delete(Sale sale) {
    try (var stat = connection.createStatement()) {
      var query = "DELETE FROM `pharmacie`.`sale` WHERE (`id` = '" + sale.getId() + "');";
      stat.executeUpdate(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Sale save(Sale sale) {
    if (sale.getId() == null)
      sale.setId(UUID.randomUUID().toString());

    saveSaleToDB(sale);
    return sale;
  }

  private void saveSaleToDB(Sale sale) {
    try (var stat = connection.createStatement()) {
      var query = "INSERT INTO sale (`id`, `medicament_name`, `clientId`, `quantity`, `price`, `selling_date`) " +
              "VALUES ('" + sale.getId() + "','" + sale.getMedicamentName() + "','" + sale.getClientId() +
              "','" + sale.getQuantity() + "','" + sale.getPrice() + "','" + sale.getSellingDate() + "');";
      stat.executeUpdate(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


  @Override
  public List<Sale> findAllSaleByMadicament(Medicament medicament) {
    List<Sale> sales;
    try (var stat = connection.createStatement()) {
      sales = getSalesFromDBByMedicamentName(medicament.getName(), stat);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return sales;
  }

  private List<Sale> getSalesFromDBByMedicamentName(String medicamentName, Statement stat) {
    List<Sale> sales = new ArrayList<>();
    var query = "SELECT * FROM pharmacie.sale WHERE medicament_name = '" + medicamentName + "';";
    try (ResultSet rs = stat.executeQuery(query)) {
      while (rs.next())
        sales.add(constructSaleEntity(rs));
    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }
    return sales;
  }

  @Override
  public void modify(Sale sale) {
    delete(sale);
    save(sale);
  }
}
