package gestores;

import models.Celular;
import utils.ArchivoUtils;

import enums.SistemaOperativo;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorCelulares {

  public static void gertionCelulares(Scanner teclado){
    boolean programaActivo = true;
    while (programaActivo) {
      ArchivoUtils.limpiarPantalla1();
      System.out.println("===== GESTIÓN DE CELULARES =====\n1.Registrar Celular\n2.Actualizar Información\n3.Eliminar Celular\n4.Consultar Catálogo\n5.Volver");
      System.out.print("Ingrese Opcion: ");
      int opcion = teclado.nextInt();

      switch (opcion) {
        case 1:

          break;
        case 2:

          break;
        case 3:

          break;
        case 4:
          break;
        case 5:
          break;
        case 6:
          ArchivoUtils.limpiarPantalla1();
          System.out.println("Volviendo...");
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

  public static void buscarCelularPorID(ArrayList<Celular> celulares, Scanner teclado){
    ArchivoUtils.limpiarPantalla1();

    System.out.print("Ingrese un ID: ");

    int id = teclado.nextInt();

    boolean encontrado = false;

    for (Celular celular : celulares) {
      if (celular.getId() == id) {
        System.out.println(celular);
        encontrado = true;
        break;
      }
    }
    if (!encontrado) {
      System.out.println("Celular con el ID: " + id + " no fue encontrado");
    }

    teclado.nextLine();
    System.out.println("Presione Enter para continuar...");
    teclado.nextLine();
  }

  public static void listarCelulares(ArrayList<Celular> celulares, Scanner teclado){
    ArchivoUtils.limpiarPantalla1();

    System.out.println("===== INVENTARIO =====");

    for (Celular celular : celulares) {
      System.out.println(celular);
    }

    teclado.nextLine();
    System.out.println("Presione Enter para continuar...");
    teclado.nextLine();
  }

//  public static void agregarCelular(ArrayList<Celular> celulares, Scanner teclado){
//    ArchivoUtils.limpiarPantalla1();
//
//    System.out.println("===== NUEVO CELULAR =====");
//
//    teclado.nextLine();
//    System.out.print("Marca: ");
//    String marca = teclado.nextLine();
//
//    System.out.print("Modelo: ");
//    String modelo = teclado.nextLine();
//
//    System.out.print("Precio: ");
//    double precio = teclado.nextDouble();
//
//    System.out.print("Stock: ");
//    int stock = teclado.nextInt();
//    teclado.nextLine();
//
//    System.out.print("Sistema Operativo: ");
//    String sistemaOperativo = teclado.nextLine();
//
//    System.out.print("Gama: ");
//    String gama = teclado.nextLine();
//
//    int idGuardarCelulares;
//
//    if (celulares.isEmpty()) {
//      idGuardarCelulares = 1;
//    } else {
//      Celular ultimoCelular = celulares.get(celulares.size() - 1);
//
//      idGuardarCelulares = ultimoCelular.getId() + 1;
//    }
//
//    Celular nuevoCelular = new Celular(idGuardarCelulares, marca, modelo, precio, stock, sistemaOperativo, gama);
//
//    celulares.add(nuevoCelular);
//
//    System.out.println("Celular agregado correctamente.");
//
//    System.out.println("Presione Enter para continuar...");
//    teclado.nextLine();
//  }
}
