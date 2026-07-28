package models;

import enums.SistemaOperativo;
import enums.Gama;

public class Celular {

  private int id;
  private String marca;
  private String modelo;
  private double precio;
  private int stock;
  private SistemaOperativo sistemaOperativo;
  private Gama gama;


  //Contructor
  public Celular(int id, String marca, String modelo, double precio, int stock, SistemaOperativo sistemaOperativo, Gama gama) {
    this.id = id;
    this.marca = marca;
    this.modelo = modelo;
    this.precio = precio;
    this.stock = stock;
    this.sistemaOperativo = sistemaOperativo;
    this.gama = gama;
  }

  @Override
  public String toString() {
    return id + " " + marca + " " + modelo + " " + precio + " " + sistemaOperativo + " " + gama;
  }

  //Gets
  public int getId(){
    return id;
  }

  public String getMarca(){
    return marca;
  }

  public String getModelo(){
    return modelo;
  }

  public double getPrecio(){
    return precio;
  }

  public int getStock(){
    return stock;
  }

  public SistemaOperativo getSistemaOperativo() {
    return sistemaOperativo;
  }

  public Gama getGama() {
    return gama;
  }

  //Sets
  public void setId(int id) {
    this.id = id;
  }

  public void setMarca(String marca){
    this.marca = marca;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public void setPrecio(double precio){
    if(precio >= 0){
      this.precio = precio;
    }
  }

  public void setStock(int stock) {
    if(stock >= 0){
      this.stock = stock;
    }
  }

  public void setSistemaOperativo(SistemaOperativo sistemaOperativo) {
    this.sistemaOperativo = sistemaOperativo;
  }

  public void setGama(Gama gama) {
    this.gama = gama;
  }
}


