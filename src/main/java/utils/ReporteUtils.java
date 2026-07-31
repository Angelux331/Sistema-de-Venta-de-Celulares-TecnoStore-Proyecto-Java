package utils;

import dao.VentaDAO;
import models.Venta;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReporteUtils {

  public static void generarReporteVentas(Scanner teclado) {

    VentaDAO ventaDAO = new VentaDAO();

    ArrayList<Venta> ventas = ventaDAO.buscarTodasLasVentas();

    try (BufferedWriter bw = new BufferedWriter(new FileWriter("reporte_ventas.txt"))) {

      bw.write("=====================================");
      bw.newLine();
      bw.write("      REPORTE GENERAL DE VENTAS");
      bw.newLine();
      bw.write("=====================================");
      bw.newLine();
      bw.newLine();

      if (ventas.isEmpty()) {

        bw.write("No existen ventas registradas.");

      } else {

        for (Venta venta : ventas) {

          bw.write("ID Venta: " + venta.getId());
          bw.newLine();

          bw.write("Cliente ID: " + venta.getIdCliente());
          bw.newLine();

          bw.write("Fecha: " + venta.getFechaVenta());
          bw.newLine();

          bw.write("Subtotal: $" + venta.getSubTotal());
          bw.newLine();

          bw.write("IVA: $" + venta.getIva());
          bw.newLine();

          bw.write("TOTAL: $" + venta.getTotal());
          bw.newLine();

          bw.write("-------------------------------------");
          bw.newLine();

        }

      }

      System.out.println("Reporte generado correctamente.");
      teclado.nextLine();
      ArchivoUtils.pausarPantalla(teclado);

    } catch (IOException e) {

      System.out.println("Error al generar el reporte.");
      System.out.println(e.getMessage());

    }

  }

}