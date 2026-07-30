package app;
import java.util.Scanner;

import gestores.GestorCelulares;
import gestores.GestorClientes;
import gestores.GestorReportes;
import gestores.GestorVentas;
import utils.ArchivoUtils;
import utils.Menus;

public class Main {

  public static void main(String[] args) {

    Scanner teclado = new Scanner(System.in);

    boolean programaActivo = true;

    ArchivoUtils.limpiarPantalla1();

    while (programaActivo) {
      ArchivoUtils.limpiarPantalla1();
      Menus.menuPrincipal();
      System.out.print("Ingrese Opcion: ");
      int opcion = teclado.nextInt();

      switch (opcion) {
        case 1:
          // Gestionar Celulares
          GestorCelulares gestorCelulares = new GestorCelulares();
          gestorCelulares.gestionCelulares(teclado);
          break;
        case 2:
          // Gestionar Clientes
          GestorClientes gestorClientes = new GestorClientes();
          gestorClientes.gestionClientes(teclado);
          break;
        case 3:
          // Hacer venta
          GestorVentas registrarVenta = new GestorVentas();
          registrarVenta.gestionVentas(teclado);
          break;
        case 4:
          // Gestionar Ventas
          GestorVentas gestorVentas = new GestorVentas();
          gestorVentas.gestionVentas(teclado);
          break;
        case 5:
          // Reportes
          GestorReportes gestorReportes = new GestorReportes();
          gestorReportes.gestionReportes(teclado);
          break;
        case 6:
          ArchivoUtils.limpiarPantalla1();
          System.out.println("Cerrando programa...");
          programaActivo = false;
          break;
        default:
          ArchivoUtils.manejoErrores(teclado);
          break;
      }
    }
  }
}
