package pharmacie.gateways.mysql;

import pharmacie.entities.User;
import pharmacie.gateways.UserGateway;
import pharmacie.usecases.authentication.login.SignUpInformation;

import java.sql.*;
import java.util.UUID;

public class MySQLUserGateway implements UserGateway {
  private static final Connection connection = Connector.getConnection();

  @Override
  public User save(User user) {
    if (user.getId() == null)
      user.setId(UUID.randomUUID().toString());

    saveUserToDB(user);
    return user;
  }

  private void saveUserToDB(User user) {
    try (var stat = connection.createStatement()) {
      var query = "INSERT INTO user (`id`, `name`, `role`) " +
              "VALUES ('" + user.getId() + "','" + user.getUserName() + "','" + user.getRole() + "');";
      stat.executeUpdate(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public User findUserById(String id) {
    User user;
    try (var stat = connection.createStatement()) {
      user = getUserFromDB(id, stat);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return user;
  }

  @Override
  public User verifyUser(String username, String password) {
    User user;
    try (var stat = connection.createStatement()) {
      user = verifyUserFromDB(username, password, stat);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return user;
  }

  @Override
  public User register(SignUpInformation info) {
    var id = UUID.randomUUID().toString();
    try (var stat = connection.createStatement()) {
      var query = "INSERT INTO user (`id`, `name`, `role`, `password`) " +
              "VALUES ('" + id + "','" + info.username() + "','" + "client" + "','" + info.Password() + "');";
      stat.executeUpdate(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return findUserById(id);
  }

  private User verifyUserFromDB(String username, String password, Statement stat) {
    User user = null;
    var query = "SELECT * FROM pharmacie.user WHERE" +
            " name = '" + username + "' AND password = '" + password + "';";
    try (ResultSet rs = stat.executeQuery(query)) {
      if (rs.next())
        user = constructUserEntity(rs);
    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }
    return user;
  }

  private User getUserFromDB(String id, Statement stat) {
    User user = null;
    var query = "SELECT * FROM pharmacie.user WHERE id = '" + id + "';";
    try (ResultSet rs = stat.executeQuery(query)) {
      if (rs.next())
        user = constructUserEntity(rs);
    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }
    return user;
  }

  private User constructUserEntity(ResultSet rs) throws SQLException {
    var user = new User(rs.getString("name"), rs.getString("role"));
    user.setId(rs.getString("id"));
    return user;
  }

}
