package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
  private static final String URL = "jdbc:mysql://localhost:3306/TecnoStore";

  private static final String USUARIO = "tecnostore";

  private static final String PASSWORD = "TecnoStore123!";

  public static Connection conectar() {

    try {
      return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      return null;
    }
  }
}