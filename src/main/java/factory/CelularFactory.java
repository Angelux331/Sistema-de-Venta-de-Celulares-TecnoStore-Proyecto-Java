package factory;

import enums.Gama;
import enums.SistemaOperativo;
import models.Celular;

import java.math.BigDecimal;

public class CelularFactory {

  public static Celular crearCelular(
    String marca,
    String modelo,
    BigDecimal precio,
    int stock,
    SistemaOperativo so,
    Gama gama
  ){

    return new Celular(
      marca,
      modelo,
      precio,
      stock,
      so,
      gama,
      stock>0
    );
  }
}