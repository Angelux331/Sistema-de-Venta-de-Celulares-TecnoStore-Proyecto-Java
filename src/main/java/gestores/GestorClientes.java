package gestores;

import utils.ArchivoUtils;
import utils.Menus;

import java.util.Scanner;

public class GestorClientes {
  public static void gestionClientes(Scanner teclado) {

    while (true) {
      ArchivoUtils.limpiarPantalla1();
      Menus.menuGestionClientes();
      System.out.print("Ingrese Opcion: ");
      int opcion = teclado.nextInt();

      switch (opcion) {
        case 1:
          // Lógica para registrar clientes
          break;
        case 2:
          consultarClientes(teclado);
          break;
        case 3:
          // Lógica para actualizar información de clientes
          break;
        case 4:
          // Lógica para eliminar clientes
          break;
        case 5:
          // volver al menu principal
          ArchivoUtils.limpiarPantalla1();
          System.out.println("Volviendo...");
          return;
        default:
          // manejo de errores
          teclado.nextLine();
          System.out.print("Opcion no valida, vuelva a intentarlo");
          teclado.nextLine();
          break;
      }
    }
  }

  public static void consultarClientes(Scanner teclado) {

    while (true) {
      ArchivoUtils.limpiarPantalla1();
      System.out.println("===== CONSULTAR CLIENTES =====");
      System.out.println("1. Consultar todos los clientes\n2. Consultar cliente por ID\n3. Volver");
      System.out.print("Ingrese Opcion: ");
      int opcion = teclado.nextInt();
      switch (opcion) {
        case 1:
          // Lógica para consultar todos los clientes
          break;
        case 2:
          // Lógica para consultar cliente por ID
          break;
        case 3:
          // volver al menu de gestión de clientes
          ArchivoUtils.limpiarPantalla1();
          System.out.println("Volviendo...");
          return;
        default:
          // manejo de errores
          teclado.nextLine();
          System.out.print("Opcion no valida, vuelva a intentarlo");
          teclado.nextLine();
          break;
      }

    }
  }
}
