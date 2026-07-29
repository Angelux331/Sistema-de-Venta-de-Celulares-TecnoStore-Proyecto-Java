package gestores;

import enums.Gama;
import models.Celular;
import utils.ArchivoUtils;

import enums.SistemaOperativo;
import utils.Menus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorCelulares {

  public static void gestionCelulares(ArrayList<Celular> celulares, Scanner teclado){
    boolean programaActivo = true;
    while (programaActivo) {
      ArchivoUtils.limpiarPantalla1();
      Menus.menuGestionCelulares();
      System.out.print("Ingrese Opcion: ");
      int opcion = teclado.nextInt();

      switch (opcion) {
        case 1:
          // registrar celular
            agregarCelular(celulares, teclado);
          break;
        case 2:
          // actualizar informacion
          break;
        case 3:
          // eliminar celular
          break;
        case 4:
          // consultar catalogo
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

  public static void agregarCelular(ArrayList<Celular> celulares, Scanner teclado) {
    ArchivoUtils.limpiarPantalla1();

    System.out.println("===== NUEVO CELULAR =====");

    System.out.print("Marca: ");
    String marca = teclado.nextLine();

    System.out.print("Modelo: ");
    String modelo = teclado.nextLine();

    System.out.print("Precio: ");
    BigDecimal precio = teclado.nextBigDecimal();

    System.out.print("Stock: ");
    int stock = teclado.nextInt();
    teclado.nextLine();

    boolean seleccionValidaSO = true;

    SistemaOperativo sistemaOperativo = null;

    while (seleccionValidaSO) {
      ArchivoUtils.limpiarPantalla1();

      System.out.print("Sistema Operativo:\n1.Android\n2.IOS");
      int opcion = teclado.nextInt();

      switch (opcion) {
        case 1:
          sistemaOperativo = SistemaOperativo.ANDROID;
          seleccionValidaSO = false;
          break;
        case 2:
          sistemaOperativo = SistemaOperativo.IOS;
          seleccionValidaSO = false;
          break;
        default:
          teclado.nextLine();
          System.out.print("Opcion no valida, vuelva a intentarlo");
          teclado.nextLine();
          break;
      }
    }

    boolean seleccionValidaGama = true;

    Gama gama = null;

    while (seleccionValidaGama) {
      ArchivoUtils.limpiarPantalla1();

      System.out.print("Gama:\n1.BAJA\n2.MEDIA\n3.ALTA");
      int opcion = teclado.nextInt();

      switch (opcion) {
        case 1:
          gama = Gama.BAJA;
          seleccionValidaGama = false;
          break;
        case 2:
          gama = Gama.MEDIA;
          seleccionValidaGama = false;
          break;
        case 3:
          gama = Gama.ALTA;
          seleccionValidaGama = false;
          break;
        default:
          teclado.nextLine();
          System.out.print("Opcion no valida, vuelva a intentarlo");
          teclado.nextLine();
          break;
      }
    }


      int idGuardarCelulares;

      if (celulares.isEmpty()) {
        idGuardarCelulares = 1;
      } else {
        Celular ultimoCelular = celulares.get(celulares.size() - 1);

        idGuardarCelulares = ultimoCelular.getId() + 1;
      }

      Celular nuevoCelular = new Celular(idGuardarCelulares, marca, modelo, precio, stock, sistemaOperativo, gama);

      celulares.add(nuevoCelular);

      System.out.println("Celular agregado correctamente.");

      System.out.println("Presione Enter para continuar...");
      teclado.nextLine();
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
}


