package dao;

import database.Conexion;
import models.Venta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VentaDAO {

  public ArrayList<Venta> buscarTodasLasVentas() {

    ArrayList<Venta> ventas = new ArrayList<>();

    Connection conexion = Conexion.conectar();

    String sql = "SELECT * FROM ventas";

    try {

      if (conexion == null) {
        System.out.println("No fue posible conectar con la base de datos.");
        return ventas;
      }

      PreparedStatement ps = conexion.prepareStatement(sql);

      ResultSet rs = ps.executeQuery();

      while (rs.next()) {

        Venta venta = new Venta(
          rs.getInt("id_cliente"),
          rs.getBigDecimal("sub_total"),
          rs.getBigDecimal("iva"),
          rs.getBigDecimal("total")
        );

        venta.setId(rs.getInt("id_venta"));
        venta.setFechaVenta(rs.getTimestamp("fecha_venta"));

        ventas.add(venta);

      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return ventas;

  }

  public int registrarVenta(Venta venta) {

    Connection conexion = Conexion.conectar();

    String sql = """
                INSERT INTO ventas
                (id_cliente, sub_total, iva, total)
                VALUES (?, ?, ?, ?)
                """;

    try {

      if (conexion == null) {
        System.out.println("No fue posible conectar con la base de datos.");
        return -1;
      }

      PreparedStatement ps = conexion.prepareStatement(
        sql,
        PreparedStatement.RETURN_GENERATED_KEYS
      );

      ps.setInt(1, venta.getIdCliente());
      ps.setBigDecimal(2, venta.getSubTotal());
      ps.setBigDecimal(3, venta.getIva());
      ps.setBigDecimal(4, venta.getTotal());

      ps.executeUpdate();

      ResultSet rs = ps.getGeneratedKeys();

      if (rs.next()) {
        return rs.getInt(1);
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return -1;
  }

  public Venta buscarVentaPorId(int id) {

    Connection conexion = Conexion.conectar();

    String sql = "SELECT * FROM ventas WHERE id_venta=?";

    try {

      if (conexion == null) {
        System.out.println("No fue posible conectar con la base de datos.");
        return null;
      }

      PreparedStatement ps = conexion.prepareStatement(sql);

      ps.setInt(1, id);

      ResultSet rs = ps.executeQuery();

      if (rs.next()) {

        Venta venta = new Venta(
          rs.getInt("id_cliente"),
          rs.getBigDecimal("sub_total"),
          rs.getBigDecimal("iva"),
          rs.getBigDecimal("total")
        );

        venta.setId(rs.getInt("id_venta"));
        venta.setFechaVenta(rs.getTimestamp("fecha_venta"));

        return venta;

      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return null;

  }


}