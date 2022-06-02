package pharmacie.gateways.mysql;

import pharmacie.entities.Medicament;
import pharmacie.gateways.MedicamentGateway;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MySQLMedicamentGateway implements MedicamentGateway {
  private static final Connection connection = Connector.getConnection();

  @Override
  public List<Medicament> findAllMedicaments() {
    List<Medicament> medicaments;
    try (var stat = connection.createStatement()) {
      medicaments = getAllMedicamentsFromDB(stat);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return medicaments;
  }

    private List<Medicament> getAllMedicamentsFromDB(Statement stat) {
      List<Medicament> medicaments = new ArrayList<>();
      var query = "SELECT * FROM pharmacie.medicament;";
      try (ResultSet rs = stat.executeQuery(query)) {
        while (rs.next())
          medicaments.add(constructMedicamantEntity(rs));
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }
      return medicaments;
    }

  private Medicament constructMedicamantEntity(ResultSet rs) throws SQLException {
    var medicamant = new Medicament(rs.getString("name"),
            rs.getInt("quantity"),
            LocalDate.parse(rs.getString("experation_date")),
            new Medicament.Dosage(rs.getDouble("dosage"), "ml/g"),
            rs.getInt("price"));

    medicamant.setId(rs.getString("id"));
    return medicamant;
  }

  @Override
  public void delete(Medicament medicament) {
    try (var stat = connection.createStatement()) {
      var query = "DELETE FROM `pharmacie`.`medicament` WHERE (`id` = '" + medicament.getId() + "');";
      stat.executeUpdate(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Medicament save(Medicament medicament) {
    if (medicament.getId() == null)
      medicament.setId(UUID.randomUUID().toString());

    saveMedicamentToDB(medicament);
    return medicament;
  }

  private void saveMedicamentToDB(Medicament medicament) {
    try (var stat = connection.createStatement()) {
      var query = "INSERT INTO `pharmacie`.`medicament` " +
              "(`id`, `name`, `quantity`, `experation_date`, `dosage`, `price`) " +
              "VALUES ('"+ medicament.getId() +"', '"+ medicament.getName() +"', '"+ medicament.getQuantity() +"'," +
              " '"+ medicament.getExpirationDate() +"', '"+ medicament.getDosage().quantity() +"', " +
              "'"+ medicament.getPrice()+"');";
      stat.executeUpdate(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Medicament findMedicamentByName(String medicamentName) {
    Medicament medicament;
    try (var stat = connection.createStatement()) {
      medicament = getMedicamantFromDBByName(medicamentName, stat);
    } catch (SQLException e) { throw new RuntimeException(e); }
    return medicament;
  }

  private Medicament getMedicamantFromDBByName(String medicamentName, Statement stat) {
    Medicament medicament = null;
    var query = "SELECT * FROM pharmacie.medicament WHERE name = '" + medicamentName + "';";
    try (ResultSet rs = stat.executeQuery(query)) {
      if (rs.next())
        medicament = constructMedicamantEntity(rs);
    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }
    return medicament;
  }

  public void modify(Medicament newMedicament) {
    delete(newMedicament);
    save(newMedicament);
  }
}
