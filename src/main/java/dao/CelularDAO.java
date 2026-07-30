package dao;

import conexion.Conexion;
import enums.Gama;
import enums.SistemaOperativo;
import models.Celular;
import models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CelularDAO {
  public void registrarCelular(Celular celular){

    Connection conexion = Conexion.conectar();
    String sql =
      "INSERT INTO celulares (marca, modelo, precio, stock, sistema_operativo, gama, disponible) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    try {
      if (conexion == null) {
        System.out.println("No fue posible conectar con la base de datos.");
        return;
      }

      PreparedStatement ps = conexion.prepareStatement(sql);
      ps.setString(1, celular.getMarca());
      ps.setString(2, celular.getModelo());
      ps.setBigDecimal(3, celular.getPrecio());
      ps.setInt(4, celular.getStock());
      ps.setString(5, celular.getSistemaOperativo().name());
      ps.setString(6, celular.getGama().name());
      ps.setBoolean(7, celular.getDisponible());
      ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public ArrayList<Celular> buscarTodosLosCelulares() {

    ArrayList<Celular> celulares = new ArrayList<>();

    Connection conexion = Conexion.conectar();
    String sql = "SELECT * FROM celulares";

    try {

      if (conexion == null) {
        System.out.println("No fue posible conectar con la base de datos.");
        return celulares;
      }

      PreparedStatement ps = conexion.prepareStatement(sql);
      var rs = ps.executeQuery();

      while (rs.next()) {

        Celular celular = new Celular(
          rs.getString("marca"),
          rs.getString("modelo"),
          rs.getBigDecimal("precio"),
          rs.getInt("stock"),
          SistemaOperativo.valueOf(rs.getString("sistema_operativo")),
          Gama.valueOf(rs.getString("gama")),
          rs.getBoolean("disponible")
        );

        celular.setId(rs.getInt("id_celular"));

        celulares.add(celular);
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return celulares;
  }

  public Celular buscarPorId(int id) {

    Connection conexion = Conexion.conectar();
    String sql = "SELECT * FROM celulares WHERE id_celular = ?";

    try {

      if (conexion == null) {
        System.out.println("No fue posible conectar con la base de datos.");
        return null;
      }

      PreparedStatement ps = conexion.prepareStatement(sql);
      ps.setInt(1, id);

      var rs = ps.executeQuery();

      if (rs.next()) {

        Celular celular = new Celular(
          rs.getString("marca"),
          rs.getString("modelo"),
          rs.getBigDecimal("precio"),
          rs.getInt("stock"),
          SistemaOperativo.valueOf(rs.getString("sistema_operativo")),
          Gama.valueOf(rs.getString("gama")),
          rs.getBoolean("disponible")
        );

        celular.setId(rs.getInt("id_celular"));

        return celular;
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return null;
  }

  public void eliminarCelular(int id) {

    Connection conexion = Conexion.conectar();
    String sql = "DELETE FROM celulares WHERE id_celular = ?";

    try {

      if (conexion == null) {
        System.out.println("No fue posible conectar con la base de datos.");
        return;
      }

      PreparedStatement ps = conexion.prepareStatement(sql);
      ps.setInt(1, id);

      int filas = ps.executeUpdate();

      if (filas > 0) {
        System.out.println("Celular eliminado correctamente.");
      } else {
        System.out.println("No existe un celular con ese ID.");
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public void actualizarCelular(Celular celular) {

    Connection conexion = Conexion.conectar();

    String sql = """
            UPDATE celulares
            SET marca=?,
                modelo=?,
                precio=?,
                stock=?,
                sistema_operativo=?,
                gama=?,
                disponible=?
            WHERE id_celular=?
            """;
    try {
      if (conexion == null) {
        System.out.println("No fue posible conectar con la base de datos.");
        return;
      }

      PreparedStatement ps = conexion.prepareStatement(sql);

      ps.setString(1, celular.getMarca());
      ps.setString(2, celular.getModelo());
      ps.setBigDecimal(3, celular.getPrecio());
      ps.setInt(4, celular.getStock());
      ps.setString(5, celular.getSistemaOperativo().name());
      ps.setString(6, celular.getGama().name());
      ps.setBoolean(7, celular.getDisponible());
      ps.setInt(8, celular.getId());

      int filas = ps.executeUpdate();

      if (filas > 0) {
        System.out.println("Celular actualizado correctamente.");
      } else {
        System.out.println("No existe un celular con ese ID.");
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
