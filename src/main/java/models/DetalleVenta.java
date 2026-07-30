package models;

import java.math.BigDecimal;

public class DetalleVenta {

  private int id;
  private int idVenta;
  private int idCelular;
  private int cantidad;
  private BigDecimal precioUnitarioCongelado;

  public DetalleVenta(int idVenta, int idCelular, int cantidad, BigDecimal precioUnitarioCongelado) {
    this.idVenta = idVenta;
    this.idCelular = idCelular;
    this.cantidad = cantidad;
    this.precioUnitarioCongelado = precioUnitarioCongelado;
  }

  public DetalleVenta() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdVenta() {
    return idVenta;
  }

  public void setIdVenta(int idVenta) {
    this.idVenta = idVenta;
  }

  public int getIdCelular() {
    return idCelular;
  }

  public void setIdCelular(int idCelular) {
    this.idCelular = idCelular;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public BigDecimal getPrecioUnitarioCongelado() {
    return precioUnitarioCongelado;
  }

  public void setPrecioUnitarioCongelado(BigDecimal precioUnitarioCongelado) {
    this.precioUnitarioCongelado = precioUnitarioCongelado;
  }

  @Override
  public String toString() {
    return "DetalleVenta{" +
      "id=" + id +
      ", idVenta=" + idVenta +
      ", idCelular=" + idCelular +
      ", cantidad=" + cantidad +
      ", precioUnitarioCongelado=" + precioUnitarioCongelado +
      '}';
  }
}