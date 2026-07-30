package models;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Venta {

  private int id;
  private int idCliente;
  private Timestamp fechaVenta;
  private BigDecimal subTotal;
  private BigDecimal iva;
  private BigDecimal total;

  public Venta(int idCliente, BigDecimal subTotal, BigDecimal iva, BigDecimal total) {
    this.idCliente = idCliente;
    this.subTotal = subTotal;
    this.iva = iva;
    this.total = total;
  }

  public Venta() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  public Timestamp getFechaVenta() {
    return fechaVenta;
  }

  public void setFechaVenta(Timestamp fechaVenta) {
    this.fechaVenta = fechaVenta;
  }

  public BigDecimal getSubTotal() {
    return subTotal;
  }

  public void setSubTotal(BigDecimal subTotal) {
    this.subTotal = subTotal;
  }

  public BigDecimal getIva() {
    return iva;
  }

  public void setIva(BigDecimal iva) {
    this.iva = iva;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  @Override
  public String toString() {
    return "Venta{" +
      "id=" + id +
      ", idCliente=" + idCliente +
      ", fechaVenta=" + fechaVenta +
      ", subTotal=" + subTotal +
      ", iva=" + iva +
      ", total=" + total +
      '}';
  }
}