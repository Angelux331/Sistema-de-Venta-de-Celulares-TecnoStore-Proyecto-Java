package dao;

import database.Conexion;
import models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {
  public void registrarCliente(Cliente cliente){

    Connection conexion = Conexion.conectar();
    String sql =
      "INSERT INTO clientes (nombre, apellido, identificacion, correo, telefono) " + "VALUES (?, ?, ?, ?, ?)";

    try {
      if (conexion == null) {
        System.out.println("No fue posible conectar con la base de datos.");
        return;
      }

      PreparedStatement ps = conexion.prepareStatement(sql);
      ps.setString(1, cliente.getNombre());
      ps.setString(2, cliente.getApellido());
      ps.setString(3, cliente.getIdentificacion());
      ps.setString(4, cliente.getCorreo());
      ps.setString(5, cliente.getTelefono());
      ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public ArrayList<Cliente> buscarTodosLosClientes() {

    ArrayList<Cliente> clientes = new ArrayList<>();

    Connection conexion = Conexion.conectar();
    String sql = "SELECT * FROM clientes";

    try {
      if (conexion == null) {
        System.out.println("No fue posible conectar con la base de datos.");
        return clientes;
      }
      PreparedStatement ps = conexion.prepareStatement(sql);
      var rs = ps.executeQuery();

      while (rs.next()) {
        Cliente cliente = new Cliente(
          rs.getString("nombre"),
          rs.getString("apellido"),
          rs.getString("identificacion"),
          rs.getString("correo"),
          rs.getString("telefono")
        );

        cliente.setId(rs.getInt("id_cliente"));
        clientes.add(cliente);
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return clientes;
  }


  public Cliente buscarPorId(int id) {

    Connection conexion = Conexion.conectar();
    String sql = "SELECT * FROM clientes WHERE id_cliente = ?";

    try {

      if (conexion == null) {
        System.out.println("No fue posible conectar con la base de datos.");
        return null;
      }

      PreparedStatement ps = conexion.prepareStatement(sql);
      ps.setInt(1, id);

      var rs = ps.executeQuery();

      if (rs.next()) {

        Cliente cliente = new Cliente(
          rs.getString("nombre"),
          rs.getString("apellido"),
          rs.getString("identificacion"),
          rs.getString("correo"),
          rs.getString("telefono")
        );

        cliente.setId(rs.getInt("id_cliente"));

        return cliente;
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return null;
  }

  public void eliminarCliente(int id) {

    Connection conexion = Conexion.conectar();
    String sql = "DELETE FROM clientes WHERE id_cliente = ?";

    try {

      if (conexion == null) {
        System.out.println("No fue posible conectar con la base de datos.");
        return;
      }

      PreparedStatement ps = conexion.prepareStatement(sql);
      ps.setInt(1, id);

      int filas = ps.executeUpdate();

      if (filas > 0) {
        System.out.println("Cliente eliminado correctamente.");
      } else {
        System.out.println("No existe un cliente con ese ID.");
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public Cliente buscarPorIdentificacion(String identificacion) {
    Connection conexion = Conexion.conectar();
    String sql = "SELECT * FROM clientes WHERE identificacion = ?";

    try {
      if (conexion == null) {
        System.out.println("No fue posible conectar con la base de datos.");
        return null;
      }

      PreparedStatement ps = conexion.prepareStatement(sql);
      ps.setString(1, identificacion);
      var rs = ps.executeQuery();

      if (rs.next()) {
        Cliente cliente = new Cliente(
          rs.getString("nombre"),
          rs.getString("apellido"),
          rs.getString("identificacion"),
          rs.getString("correo"),
          rs.getString("telefono")
        );
        cliente.setId(rs.getInt("id_cliente"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setApellido(rs.getString("apellido"));
        cliente.setIdentificacion(rs.getString("identificacion"));
        cliente.setCorreo(rs.getString("correo"));
        cliente.setTelefono(rs.getString("telefono"));
        return cliente;
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return null;
  }


  public void actualizarCliente(Cliente cliente) {

    Connection conexion = Conexion.conectar();

    String sql = """
            UPDATE clientes
            SET nombre=?,
                apellido=?,
                identificacion=?,
                correo=?,
                telefono=?
            WHERE id_cliente=?
            """;
    try {
      if (conexion == null) {
        System.out.println("No fue posible conectar con la base de datos.");
        return;
      }

      PreparedStatement ps = conexion.prepareStatement(sql);

      ps.setString(1, cliente.getNombre());
      ps.setString(2, cliente.getApellido());
      ps.setString(3, cliente.getIdentificacion());
      ps.setString(4, cliente.getCorreo());
      ps.setString(5, cliente.getTelefono());
      ps.setInt(6, cliente.getId());

      int filas = ps.executeUpdate();

      if (filas > 0) {
        System.out.println("Cliente actualizado correctamente.");
      } else {
        System.out.println("No existe un cliente con ese ID.");
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
