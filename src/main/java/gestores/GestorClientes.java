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

  public void actualizarCliente(Scanner teclado) {

    ArchivoUtils.limpiarPantalla1();

    System.out.println("===== ACTUALIZAR CLIENTE =====");

    System.out.print("Ingrese el ID del cliente: ");
    int id = teclado.nextInt();
    teclado.nextLine();

    Cliente cliente = clienteDAO.buscarPorId(id);

    if (cliente == null) {
      System.out.println("Cliente no encontrado.");
      ArchivoUtils.pausarPantalla(teclado);
      return;
    }

    System.out.println("Datos actuales:");
    System.out.println(cliente);
    System.out.println();

    System.out.print("Nuevo nombre: ");
    String nombre = teclado.nextLine();

    System.out.print("Nuevo apellido: ");
    String apellido = teclado.nextLine();

    System.out.print("Nueva identificación: ");
    String identificacion = teclado.nextLine();

    System.out.print("Nuevo correo: ");
    String correo = teclado.nextLine();

    System.out.print("Nuevo teléfono: ");
    String telefono = teclado.nextLine();

    cliente.setNombre(nombre);
    cliente.setApellido(apellido);
    cliente.setIdentificacion(identificacion);
    cliente.setCorreo(correo);
    cliente.setTelefono(telefono);

    clienteDAO.actualizarCliente(cliente);

    ArchivoUtils.pausarPantalla(teclado);
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
          // Lógica para consultar cliente por Identificación
          System.out.print("Ingrese la Identificación: ");
          String identificacion = teclado.next();

          Cliente clienteIdentificacion = clienteDAO.buscarPorIdentificacion(identificacion);

          if (clienteIdentificacion != null) {
            System.out.println(clienteIdentificacion);
          } else {
            System.out.println("Cliente no encontrado.");
          }
          teclado.nextLine(); // Limpiar el buffer del teclado
          ArchivoUtils.pausarPantalla(teclado);
          break;
        case 4:
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
