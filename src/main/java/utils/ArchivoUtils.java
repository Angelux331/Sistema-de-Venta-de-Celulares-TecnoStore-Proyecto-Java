package utils;

import java.util.Scanner;

public class ArchivoUtils {
  public static void limpiarPantalla() {
    try {
      String os = System.getProperty("os.name").toLowerCase();

      if (os.contains("win")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
      }
    } catch (Exception e) {
      System.out.print("\033[H\033[2J");
      System.out.flush();
    }
  }

  public static void limpiarPantalla1() {
    for (int i = 0; i < 50; i++) {
      System.out.println();
    }
  }
}


