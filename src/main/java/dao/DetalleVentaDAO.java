package dao;

import conexion.Conexion;
import models.DetalleVenta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DetalleVentaDAO {

  public void registrarDetalleVenta(DetalleVenta detalle) {

    Connection conexion = Conexion.conectar();

    String sql = """
                INSERT INTO detalle_ventas
                (id_venta, id_celular, cantidad, precio_unitario_congelado)
                VALUES (?, ?, ?, ?)
                """;
    try {

      if (conexion == null) {
        System.out.println("No fue posible conectar con la base de datos.");
        return;
      }

      PreparedStatement ps = conexion.prepareStatement(sql);

      ps.setInt(1, detalle.getIdVenta());
      ps.setInt(2, detalle.getIdCelular());
      ps.setInt(3, detalle.getCantidad());
      ps.setBigDecimal(4, detalle.getPrecioUnitarioCongelado());

      ps.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

  }

}