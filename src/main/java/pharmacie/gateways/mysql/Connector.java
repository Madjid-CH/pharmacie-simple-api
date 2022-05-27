package pharmacie.gateways.mysql;

import java.sql.*;

public class Connector {

  public static Connection getConnection() {
    String url = "jdbc:mysql://localhost:3306/pharmacie";
    String username = "root";
    String password = "Beginning database design solutions";

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      return DriverManager.getConnection(url, username, password);
    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
