package dao;

import conexion.Conexion;
import models.Celular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CelularDAO {
  public void registrarCelular(Celular celular){

    Connection conexion = Conexion.conectar();
    String sql =
      "INSERT INTO celulares (marca, modelo, precio, stock, sistema_operativo, gama) " + "VALUES (?, ?, ?, ?, ?, ?)";

    try {
      PreparedStatement ps = conexion.prepareStatement(sql);
      ps.setString(1, celular.getMarca());
      ps.setString(2, celular.getModelo());
      ps.setBigDecimal(3, celular.getPrecio());
      ps.setInt(4, celular.getStock());
      ps.setString(5, celular.getSistemaOperativo().name());
      ps.setString(6, celular.getGama().name());
      ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
