package dao;

import conexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReporteDAO {
  public void ingresosTotales(){

    Connection conexion = Conexion.conectar();

    String sql = """
            SELECT
            SUM(total) AS ingresos,
            COUNT(*) AS ventas
            FROM ventas
            """;

    try{

      if(conexion == null){
        return;
      }

      PreparedStatement ps = conexion.prepareStatement(sql);

      ResultSet rs = ps.executeQuery();

      if(rs.next()){

        System.out.println("===== INGRESOS =====");
        System.out.println("Ventas realizadas: " + rs.getInt("ventas"));
        System.out.println("Ingresos totales: $" + rs.getBigDecimal("ingresos"));

      }

    }catch(SQLException e){

      System.out.println(e.getMessage());

    }

  }

  public void celularMasVendido(){

    Connection conexion = Conexion.conectar();

    String sql = """
            SELECT
            c.marca,
            c.modelo,
            SUM(d.cantidad) vendidos

            FROM detalle_ventas d

            INNER JOIN celulares c
            ON c.id_celular=d.id_celular

            GROUP BY c.id_celular

            ORDER BY vendidos DESC

            LIMIT 1
            """;

    try{

      if(conexion == null){
        return;
      }

      PreparedStatement ps = conexion.prepareStatement(sql);

      ResultSet rs = ps.executeQuery();

      if(rs.next()){

        System.out.println("===== CELULAR MÁS VENDIDO =====");
        System.out.println(rs.getString("marca") + " " + rs.getString("modelo"));
        System.out.println("Unidades vendidas: " + rs.getInt("vendidos"));

      }

    }catch(SQLException e){

      System.out.println(e.getMessage());

    }

  }

  public void clienteMasCompras(){

    Connection conexion = Conexion.conectar();

    String sql = """
            SELECT
            c.nombre,
            c.apellido,
            COUNT(*) compras

            FROM ventas v

            INNER JOIN clientes c
            ON c.id_cliente=v.id_cliente

            GROUP BY c.id_cliente

            ORDER BY compras DESC

            LIMIT 1
            """;

    try{

      if(conexion == null){
        return;
      }

      PreparedStatement ps = conexion.prepareStatement(sql);

      ResultSet rs = ps.executeQuery();

      if(rs.next()){

        System.out.println("===== CLIENTE MÁS FRECUENTE =====");
        System.out.println(rs.getString("nombre")+" "+rs.getString("apellido"));
        System.out.println("Compras: "+rs.getInt("compras"));

      }

    }catch(SQLException e){

      System.out.println(e.getMessage());

    }

  }
}