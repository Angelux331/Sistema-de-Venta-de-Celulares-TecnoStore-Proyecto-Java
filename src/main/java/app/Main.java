package app;

import java.util.ArrayList;
import java.util.Scanner;

import gestores.GestorCelulares;
import models.Celular;
import utils.ArchivoUtils;

public class Main {

  public static void main(String[] args) {

//    Celular samsung = new Celular(1, "Samsung", "S24 Ultra", 1200.00, 5, "Android", "ALTA");
//
//    Celular iphone = new Celular(2, "Iphone", "17 Pro Max", 1500.00, 5, "IOS", "ALTA");
//
//    Celular xiaomi = new Celular(3, "Xiaomi", "17 Pro Max", 1000.00, 5, "Android", "ALTA");
//
    ArrayList<Celular> celulares = new ArrayList<>();
//
//    celulares.add(samsung);
//
//    celulares.add(iphone);
//
//    celulares.add(xiaomi);
//
//    for (Celular celular : celulares) {
//      System.out.println(celular.getMarca());
//    }

    Scanner teclado = new Scanner(System.in);

    boolean programaActivo = true;

    ArchivoUtils.limpiarPantalla1();

    while (programaActivo) {
      ArchivoUtils.limpiarPantalla1();
      System.out.println("===== TECNOSTORE =====\n1.Gestionar Celulares\n2.Gestionar Clientes\n3.Hacer Venta\n4.Gestionar Ventas\n5.Reportes\n6.Salir");
      System.out.print("Ingrese Opcion: ");
      int opcion = teclado.nextInt();

      switch (opcion) {
        case 1:
          GestorCelulares.gertionCelulares(teclado);
          break;
        case 2:
          GestorCelulares.buscarCelularPorID(celulares, teclado);
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
