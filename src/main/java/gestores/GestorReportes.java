package gestores;

import dao.ReporteDAO;
import utils.ArchivoUtils;
import utils.Menus;

import java.util.Scanner;

public class GestorReportes {

  private static ReporteDAO reporteDAO = new ReporteDAO();

  public void gestionReportes(Scanner teclado){

    while(true){

      ArchivoUtils.limpiarPantalla1();

      Menus.menuReportes();

      System.out.print("Ingrese opción: ");
      int opcion = teclado.nextInt();

      switch(opcion){

        case 1:
          ArchivoUtils.limpiarPantalla1();
          reporteDAO.ingresosTotales();
          teclado.nextLine();
          ArchivoUtils.pausarPantalla(teclado);
          break;
        case 2:
          ArchivoUtils.limpiarPantalla1();
          reporteDAO.celularMasVendido();
          teclado.nextLine();
          ArchivoUtils.pausarPantalla(teclado);
          break;
        case 3:
          ArchivoUtils.limpiarPantalla1();
          reporteDAO.clienteMasCompras();
          teclado.nextLine();
          ArchivoUtils.pausarPantalla(teclado);
          break;
        case 4:
          ArchivoUtils.limpiarPantalla1();
          System.out.println("Volviendo...");
          return;
        default:
          ArchivoUtils.manejoErrores(teclado);
      }
    }
  }
}