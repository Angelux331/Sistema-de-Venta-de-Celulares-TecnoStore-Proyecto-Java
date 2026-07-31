package utils;

public class Menus {
  public static void menuPrincipal(){
    System.out.println("===== TECNOSTORE =====\n1.Gestionar Celulares\n2.Gestionar Clientes\n3.Hacer Venta\n4.Gestionar Ventas\n5.Reportes\n6.Salir");
  }

  public static void menuGestionCelulares(){
    System.out.println("===== GESTIÓN DE CELULARES =====\n1.Registrar Celular\n2.Actualizar Información\n3.Eliminar Celular\n4.Consultar Catálogo\n5.Volver");
  }

  public static void menuGestionClientes(){
    System.out.println("===== GESTIÓN DE CLIENTES =====\n1.Registrar clientes\n2.Consultar clientes\n3.Actualizar información\n4.Eliminar clientes\n5.Volver");
  }

  public static void menuActualizarCliente(){
    System.out.println("===== ACTUALIZAR CLIENTE =====\n1.Buscar por ID\n2.Buscar por Identificación\n3.Volver");
  }

  public static void menuGestionVentas(){

    System.out.println("===== GESTIÓN DE VENTAS =====");
    System.out.println("1. Registrar venta");
    System.out.println("2. Consultar ventas");
    System.out.println("3. Volver");



  }
  public static void menuConsultarVentas(){

    System.out.println("===== CONSULTAR VENTAS =====");
    System.out.println("1. Consultar todas las ventas");
    System.out.println("2. Buscar venta por ID");
    System.out.println("3. Volver");

  }

  public static void menuReportes() {
    System.out.println("===== REPORTES =====");
    System.out.println("1. Ingresos totales");
    System.out.println("2. Celular más vendido");
    System.out.println("3. Cliente con más compras");
    System.out.println("4. Generar reporte de ventas");
    System.out.println("5. Volver");
  }
}
