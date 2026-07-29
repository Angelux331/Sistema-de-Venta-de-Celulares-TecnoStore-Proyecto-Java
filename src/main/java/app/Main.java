package app;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import conexion.Conexion;
import gestores.GestorCelulares;
import gestores.GestorClientes;
import models.Celular;
import utils.ArchivoUtils;
import utils.Menus;

public class Main {

  public static void main(String[] args) {

    ArrayList<Celular> celulares = new ArrayList<>();

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
          GestorCelulares.gestionCelulares(celulares, teclado);
          break;
        case 2:
          GestorClientes.gestionClientes(teclado);
          //GestorCelulares.buscarCelularPorID(celulares, teclado);
          break;
        case 3:
//          GestorCelulares.agregarCelular(celulares, teclado);
          break;
        case 4:
          break;
        case 5:
          break;
        case 6:
          ArchivoUtils.limpiarPantalla1();
          System.out.println("Cerrando programa...");
          programaActivo = false;
          break;
        default:
          teclado.nextLine();
          System.out.print("Opcion no valida, vuelva a intentarlo");
          teclado.nextLine();
          break;
      }
    }
  }
}
