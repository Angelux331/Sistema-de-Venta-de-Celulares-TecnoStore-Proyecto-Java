package gestores;

import dao.ClienteDAO;
import models.Celular;
import models.Cliente;
import utils.ArchivoUtils;
import utils.Menus;

import java.util.Scanner;

public class GestorClientes {
  private static ClienteDAO clienteDAO = new ClienteDAO();

  public void gestionClientes(Scanner teclado) {

    while (true) {
      ArchivoUtils.limpiarPantalla1();
      Menus.menuGestionClientes();
      System.out.print("Ingrese Opcion: ");
      int opcion = teclado.nextInt();

      switch (opcion) {
        case 1:
          // Lógica para registrar clientes
          agregarClientes(teclado);
          break;
        case 2:
          // consultar clientes
          consultarClientes(teclado);
          break;
        case 3:
          // Lógica para actualizar información de clientes
          actualizarCliente(teclado);
          break;
        case 4:
          // Lógica para eliminar clientes
          eliminarCliente(teclado);
          break;
        case 5:
          // volver al menu principal
          ArchivoUtils.limpiarPantalla1();
          System.out.println("Volviendo...");
          return;
        default:
          // manejo de errores
          ArchivoUtils.manejoErrores(teclado);
          break;
      }
    }
  }

  public void agregarClientes(Scanner teclado){
    ArchivoUtils.limpiarPantalla1();

    System.out.println("===== NUEVO CLIENTE =====");

    teclado.nextLine();
    System.out.print("Nombre: ");
    String nombre = teclado.nextLine();

    System.out.print("Apellido: ");
    String apellido = teclado.nextLine();

    System.out.print("Identificación: ");
    String identificacion = teclado.nextLine();

    System.out.print("Correo: ");
    String correo = teclado.nextLine();

    System.out.print("Telefono: ");
    String telefono = teclado.nextLine();


    Cliente nuevoCliente = new Cliente(nombre, apellido, identificacion, correo, telefono);

    clienteDAO.registrarCliente(nuevoCliente);

    System.out.println("Cliente agregado correctamente.");

    ArchivoUtils.pausarPantalla(teclado);
  }

  public static void actualizarCliente(Scanner teclado) {
    ArchivoUtils.limpiarPantalla1();
    Menus.menuActualizarCliente();

    System.out.print("Ingrese Opcion: ");
    int opcion = teclado.nextInt();


    switch (opcion){
      case 1:
        break;
      case 2:
        break;
      case 3:
        ArchivoUtils.limpiarPantalla1();
        System.out.println("Volviendo...");
        return;
      default:
        ArchivoUtils.manejoErrores(teclado);
        break;
    }
  }

  public void eliminarCliente(Scanner teclado) {

    ArchivoUtils.limpiarPantalla1();

    System.out.println("===== ELIMINAR CLIENTE =====");

    System.out.print("Ingrese el ID: ");
    int id = teclado.nextInt();

    Cliente cliente = clienteDAO.buscarPorId(id);

    System.out.println("Cliente a eliminar: " + cliente);
    System.out.println("¿Está seguro que desea eliminar este cliente? (S/N)");
    String confirmacion = teclado.next();

    if (cliente != null && confirmacion.equalsIgnoreCase("S")) {
      clienteDAO.eliminarCliente(id);
    } else {
      System.out.println("Operación cancelada o cliente no encontrado.");
    }
    teclado.nextLine(); // Limpiar el buffer del teclado
    ArchivoUtils.pausarPantalla(teclado);
  }

  public static void consultarClientes(Scanner teclado) {

    while (true) {
      ArchivoUtils.limpiarPantalla1();
      System.out.println("===== CONSULTAR CLIENTES =====");
      System.out.println("1. Consultar todos los clientes\n2. Consultar cliente por ID\n3. Consultar cliente por Identificación\n4. Volver");
      System.out.print("Ingrese Opcion: ");
      int opcion = teclado.nextInt();
      switch (opcion) {
        case 1:
          // Lógica para consultar todos los clientes
          for (Cliente cliente : clienteDAO.buscarTodosLosClientes()) {
            System.out.println(cliente);
          }
          teclado.nextLine(); // Limpiar el buffer del teclado
          ArchivoUtils.pausarPantalla(teclado);
          break;
        case 2:
          // Lógica para consultar cliente por ID
          System.out.print("Ingrese el ID: ");
          int id = teclado.nextInt();

          Cliente cliente = clienteDAO.buscarPorId(id);

          if (cliente != null) {
            System.out.println(cliente);
          } else {
            System.out.println("Cliente no encontrado.");
          }
          teclado.nextLine(); // Limpiar el buffer del teclado
          ArchivoUtils.pausarPantalla(teclado);
          break;
        case 3:
          // volver al menu de gestión de clientes
          ArchivoUtils.limpiarPantalla1();
          System.out.println("Volviendo...");
          return;
        default:
          // manejo de errores
          ArchivoUtils.manejoErrores(teclado);
          break;
      }
    }
  }

}
