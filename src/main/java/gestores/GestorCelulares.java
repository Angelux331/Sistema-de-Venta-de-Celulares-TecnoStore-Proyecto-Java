package gestores;

import dao.CelularDAO;
import enums.Gama;
import models.Celular;
import utils.ArchivoUtils;

import enums.SistemaOperativo;
import utils.Menus;

import java.math.BigDecimal;
import java.util.Scanner;

public class GestorCelulares {
  private CelularDAO celularDAO = new CelularDAO();

  public void gestionCelulares(Scanner teclado) {
    boolean programaActivo = true;
    while (programaActivo) {
      ArchivoUtils.limpiarPantalla1();
      Menus.menuGestionCelulares();
      System.out.print("Ingrese Opcion: ");
      int opcion = teclado.nextInt();

      switch (opcion) {
        case 1:
          // registrar celular
          agregarCelular(teclado);
          break;
        case 2:
          // actualizar informacion
          break;
        case 3:
          // eliminar celular
          eliminarCelular(teclado);
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

  public void agregarCelular(Scanner teclado) {
    ArchivoUtils.limpiarPantalla1();

    boolean disponible = true;

    System.out.println("===== NUEVO CELULAR =====");

    teclado.nextLine();
    System.out.print("Marca: ");
    String marca = teclado.nextLine();

    System.out.print("Modelo: ");
    String modelo = teclado.nextLine();

    System.out.print("Precio: ");
    BigDecimal precio = teclado.nextBigDecimal();

    if (precio.compareTo(BigDecimal.ZERO) < 0) {
      System.out.println("El stock no puede ser negativo. Se establecerá en 0.");

      disponible = false;
      precio = BigDecimal.ZERO;
    }

    System.out.print("Stock: ");
    int stock = teclado.nextInt();
    teclado.nextLine();

    if (stock <= 0) {
      System.out.println("El stock no puede ser negativo. Se establecerá en 0.");
      if (disponible) disponible = false;
      stock = 0;
      teclado.nextLine();
    }

    boolean seleccionValidaSO = true;

    SistemaOperativo sistemaOperativo = null;

    while (seleccionValidaSO) {
      ArchivoUtils.limpiarPantalla1();

      System.out.println("Sistema Operativo:\n1.Android\n2.IOS");
      System.out.print("Ingrese Opcion: ");
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

      System.out.println("Gama:\n1.BAJA\n2.MEDIA\n3.ALTA");
      System.out.print("Ingrese Opcion: ");
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

    Celular nuevoCelular = new Celular(marca, modelo, precio, stock, sistemaOperativo, gama, disponible);

    celularDAO.registrarCelular(nuevoCelular);

    System.out.println("Celular agregado correctamente.");

    System.out.println("Presione Enter para continuar...");
    teclado.nextLine();
  }

  public void eliminarCelular(Scanner teclado){
    ArchivoUtils.limpiarPantalla1();

    System.out.print("Ingrese un ID: ");
    int id = teclado.nextInt();

    // Aquí deberías implementar la lógica para eliminar el celular de la base de datos
    // usando el id proporcionado. Por ejemplo, podrías tener un método en CelularDAO
    // que se encargue de eliminar el registro correspondiente.

    System.out.println("Celular con el ID: " + id + " ha sido eliminado (simulado).");

    teclado.nextLine();
    System.out.println("Presione Enter para continuar...");
    teclado.nextLine();
  }
}


//  public void buscarCelularPorID(Scanner teclado){
//    ArchivoUtils.limpiarPantalla1();
//
//    System.out.print("Ingrese un ID: ");
//
//    int id = teclado.nextInt();
//
//    boolean encontrado = false;
//
//    for (Celular celular : celulares) {
//      if (celular.getId() == id) {
//        System.out.println(celular);
//        encontrado = true;
//        break;
//      }
//    }
//    if (!encontrado) {
//      System.out.println("Celular con el ID: " + id + " no fue encontrado");
//    }
//
//    teclado.nextLine();
//    System.out.println("Presione Enter para continuar...");
//    teclado.nextLine();
//  }


//  public static void listarCelulares(Scanner teclado){
//    ArchivoUtils.limpiarPantalla1();
//
//    System.out.println("===== INVENTARIO =====");
//
//    for (Celular celular : celulares) {
//      System.out.println(celular);
//    }
//
//    teclado.nextLine();
//    System.out.println("Presione Enter para continuar...");
//    teclado.nextLine();
//  }



