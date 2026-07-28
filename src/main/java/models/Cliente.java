package models;

public class Cliente {

  private int id;
  private String nombre;
  private int identificacion;
  private String correo;
  private String telefono;


  //Contructor
  public Cliente(int id, String nombre, int identificacion, String correo, String telefono) {
    this.id = id;
    this.nombre = nombre;
    this.identificacion = identificacion;
    this.correo = correo;
    this.telefono = telefono;
  }

  @Override
  public String toString() {
    return nombre + " " + identificacion + " " + correo + " " + telefono;
  }

  //Gets
  public int getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public int getIdentificacion() {
    return identificacion;
  }

  public String getCorreo() {
    return correo;
  }

  public String getTelefono() {
    return telefono;
  }


  //Sets
  public void setId(int id) {
    this.id = id;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setIdentificacion(int identificacion) {
    this.identificacion = identificacion;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
}

