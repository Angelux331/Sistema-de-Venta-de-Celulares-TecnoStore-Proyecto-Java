package gestores;

import dao.CelularDAO;
import dao.ClienteDAO;
import dao.DetalleVentaDAO;
import dao.VentaDAO;

import models.Celular;
import models.Cliente;
import models.DetalleVenta;
import models.Venta;

import utils.ArchivoUtils;
import utils.Menus;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class GestorVentas {

  private static VentaDAO ventaDAO = new VentaDAO();
  private static DetalleVentaDAO detalleVentaDAO = new DetalleVentaDAO();
  private static ClienteDAO clienteDAO = new ClienteDAO();
  private static CelularDAO celularDAO = new CelularDAO();

  public void gestionVentas(Scanner teclado){

    while(true){

      ArchivoUtils.limpiarPantalla1();

      Menus.menuGestionVentas();

      System.out.print("Ingrese opción: ");
      int opcion = teclado.nextInt();

      switch(opcion){

        case 1:
          registrarVenta(teclado);
          break;

        case 2:
          consultarVentas(teclado);
          break;

        case 3:
          ArchivoUtils.limpiarPantalla1();
          System.out.println("Volviendo...");
          return;

        default:
          ArchivoUtils.manejoErrores(teclado);
      }

    }

  }

  public void registrarVenta(Scanner teclado){

    ArchivoUtils.limpiarPantalla1();

    teclado.nextLine();

    System.out.println("===== REGISTRAR VENTA =====");

    System.out.print("Ingrese la identificación del cliente: ");
    String identificacion = teclado.nextLine();

    Cliente cliente = clienteDAO.buscarPorIdentificacion(identificacion);

    if(cliente == null){

      System.out.println("Cliente no encontrado.");
      ArchivoUtils.pausarPantalla(teclado);
      return;

    }

    System.out.println();
    System.out.println(cliente);
    System.out.println();

    System.out.print("Ingrese el ID del celular: ");
    int idCelular = teclado.nextInt();

    Celular celular = celularDAO.buscarPorId(idCelular);

    if(celular == null){
      teclado.nextLine();
      System.out.println("Celular no encontrado.");
      ArchivoUtils.pausarPantalla(teclado);
      return;

    }

    System.out.println();
    System.out.println(celular);
    System.out.println();

    System.out.print("Cantidad: ");
    int cantidad = teclado.nextInt();

    if(cantidad <= 0){
      System.out.println("Cantidad inválida.");
      ArchivoUtils.pausarPantalla(teclado);
      return;

    }

    if(cantidad > celular.getStock()){

      System.out.println("Stock insuficiente.");
      teclado.nextLine();
      ArchivoUtils.pausarPantalla(teclado);
      return;

    }

    BigDecimal subtotal = celular.getPrecio().multiply(BigDecimal.valueOf(cantidad));

    BigDecimal iva = subtotal
      .multiply(new BigDecimal("0.19"))
      .setScale(2, RoundingMode.HALF_UP);

    BigDecimal total = subtotal.add(iva);

    Venta venta = new Venta(
      cliente.getId(),
      subtotal,
      iva,
      total
    );

    int idVenta = ventaDAO.registrarVenta(venta);

    if(idVenta == -1){

      System.out.println("No fue posible registrar la venta.");
      ArchivoUtils.pausarPantalla(teclado);
      return;

    }

    DetalleVenta detalle = new DetalleVenta(
      idVenta,
      celular.getId(),
      cantidad,
      celular.getPrecio()
    );

    detalleVentaDAO.registrarDetalleVenta(detalle);

    celular.setStock(celular.getStock() - cantidad);

    celular.setDisponible(celular.getStock() > 0);

    celularDAO.actualizarCelular(celular);

    System.out.println();
    System.out.println("==============================================");
    System.out.println("             FACTURA DE VENTA");
    System.out.println("==============================================");
    System.out.println("Venta No.: " + idVenta);
    System.out.println("Fecha     : " + java.time.LocalDateTime.now());
    System.out.println("----------------------------------------------");
    System.out.println("CLIENTE");
    System.out.println(cliente.getNombre() + " " + cliente.getApellido());
    System.out.println("ID: " + cliente.getIdentificacion());
    System.out.println("----------------------------------------------");
    System.out.println("PRODUCTO");
    System.out.println(celular.getMarca() + " " + celular.getModelo());
    System.out.println("Cantidad : " + cantidad);
    System.out.println("Precio U.: $" + celular.getPrecio());
    System.out.println("----------------------------------------------");
    System.out.printf("%-20s $%,.2f%n", "Subtotal:", subtotal.doubleValue());
    System.out.printf("%-20s $%,.2f%n", "IVA (19%):", iva.doubleValue());
    System.out.printf("%-20s $%,.2f%n", "TOTAL:", total.doubleValue());
    System.out.println("==============================================");
    System.out.println("     ¡Gracias por su compra!");
    System.out.println("==============================================");
    teclado.nextLine();
    ArchivoUtils.pausarPantalla(teclado);

  }

  public void consultarVentas(Scanner teclado){

    while(true){

      ArchivoUtils.limpiarPantalla1();

      Menus.menuConsultarVentas();

      System.out.print("Ingrese opción: ");
      int opcion = teclado.nextInt();

      switch(opcion){

        case 1:

          for(Venta venta : ventaDAO.buscarTodasLasVentas()){

            System.out.println(venta);

          }
          teclado.nextLine();
          ArchivoUtils.pausarPantalla(teclado);

          break;

        case 2:

          System.out.print("Ingrese ID: ");
          int id = teclado.nextInt();

          Venta venta = ventaDAO.buscarVentaPorId(id);

          if(venta != null){

            System.out.println(venta);

          }else{

            System.out.println("Venta no encontrada.");

          }

          ArchivoUtils.pausarPantalla(teclado);

          break;

        case 3:

          return;

        default:

          ArchivoUtils.manejoErrores(teclado);
      }
    }
  }
}