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
          actualizarCelular(teclado);
          break;
        case 3:
          // eliminar celular
          eliminarCelular(teclado);
          break;
        case 4:
          // consultar catalogo
          bucarCelular(teclado);
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
          ArchivoUtils.manejoErrores(teclado);
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
          ArchivoUtils.manejoErrores(teclado);
          break;
      }
    }

    Celular nuevoCelular = new Celular(marca, modelo, precio, stock, sistemaOperativo, gama, disponible);

    celularDAO.registrarCelular(nuevoCelular);

    System.out.println("Celular agregado correctamente.");

    ArchivoUtils.pausarPantalla(teclado);
    teclado.nextLine();
  }


  public void eliminarCelular(Scanner teclado) {

    ArchivoUtils.limpiarPantalla1();

    System.out.println("===== ELIMINAR CELULAR =====");

    System.out.print("Ingrese el ID: ");
    int id = teclado.nextInt();

    Celular celular = celularDAO.buscarPorId(id);

    System.out.println("Celular a eliminar: " + celular);
    System.out.println("¿Está seguro que desea eliminar este celular? (S/N)");
    String confirmacion = teclado.next();

    if (celular != null && confirmacion.equalsIgnoreCase("S")) {
      celularDAO.eliminarCelular(id);
    } else {
      System.out.println("Operación cancelada o celular no encontrado.");
    }
    teclado.nextLine(); // Limpiar el buffer del teclado
    ArchivoUtils.pausarPantalla(teclado);
  }


  public void bucarCelular(Scanner teclado){
    while (true) {
      ArchivoUtils.limpiarPantalla1();
      System.out.println("===== CONSULTAR CELULARES =====");
      System.out.println("1. Consultar todos los celulares\n2. Consultar celular por ID\n3. Volver");
      System.out.print("Ingrese Opcion: ");
      int opcion = teclado.nextInt();
      switch (opcion) {
        case 1:
          // Lógica para consultar todos los celulares
          celularDAO.buscarTodosLosCelulares()
            .stream()
            .filter(c -> c.getStock() >= 5)
            .forEach(System.out::println);

          System.out.println("");
          System.out.println("===== Celulares con Stock menor a 5 =====");
          celularDAO.buscarTodosLosCelulares()
            .stream()
            .filter(c -> c.getStock() < 5)
            .forEach(System.out::println);

          teclado.nextLine(); // Limpiar el buffer del teclado
          ArchivoUtils.pausarPantalla(teclado);
          break;
        case 2:
          // Lógica para consultar cliente por ID
          System.out.print("Ingrese el ID: ");
          int id = teclado.nextInt();

          Celular celular = celularDAO.buscarPorId(id);

          if (celular != null) {
            System.out.println(celular);
          } else {
            System.out.println("Celular no encontrado.");
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

  public void actualizarCelular(Scanner teclado) {

    ArchivoUtils.limpiarPantalla1();

    System.out.println("===== ACTUALIZAR CELULAR =====");

    System.out.print("Ingrese el ID del celular: ");
    int id = teclado.nextInt();
    teclado.nextLine();

    Celular celular = celularDAO.buscarPorId(id);

    if (celular == null) {
      System.out.println("Celular no encontrado.");
      ArchivoUtils.pausarPantalla(teclado);
      return;
    }

    System.out.println("Datos actuales:");
    System.out.println(celular);
    System.out.println();

    System.out.print("Nueva marca: ");
    String marca = teclado.nextLine();

    System.out.print("Nuevo modelo: ");
    String modelo = teclado.nextLine();

    System.out.print("Nuevo precio: ");
    BigDecimal precio = teclado.nextBigDecimal();

    System.out.print("Nuevo stock: ");
    int stock = teclado.nextInt();
    teclado.nextLine();

    SistemaOperativo sistemaOperativo;

    while (true) {
      System.out.println("Sistema Operativo:");
      System.out.println("1. ANDROID");
      System.out.println("2. IOS");
      System.out.print("Seleccione una opción: ");

      int opcion = teclado.nextInt();
      teclado.nextLine();

      if (opcion == 1) {
        sistemaOperativo = SistemaOperativo.ANDROID;
        break;
      } else if (opcion == 2) {
        sistemaOperativo = SistemaOperativo.IOS;
        break;
      } else {
        System.out.println("Opción inválida.");
      }
    }

    Gama gama;

    while (true) {
      System.out.println("Gama:");
      System.out.println("1. BAJA");
      System.out.println("2. MEDIA");
      System.out.println("3. ALTA");
      System.out.print("Seleccione una opción: ");

      int opcion = teclado.nextInt();
      teclado.nextLine();

      if (opcion == 1) {
        gama = Gama.BAJA;
        break;
      } else if (opcion == 2) {
        gama = Gama.MEDIA;
        break;
      } else if (opcion == 3) {
        gama = Gama.ALTA;
        break;
      } else {
        System.out.println("Opción inválida.");
      }
    }

    boolean disponible = stock > 0;

    celular.setMarca(marca);
    celular.setModelo(modelo);
    celular.setPrecio(precio);
    celular.setStock(stock);
    celular.setSistemaOperativo(sistemaOperativo);
    celular.setGama(gama);
    celular.setDisponible(disponible);

    celularDAO.actualizarCelular(celular);

    ArchivoUtils.pausarPantalla(teclado);
  }
}




