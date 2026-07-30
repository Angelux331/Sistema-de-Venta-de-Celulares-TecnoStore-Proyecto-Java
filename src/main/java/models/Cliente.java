package models;

public class Cliente {

  private int id;
  private String nombre;
  private String apellido;
  private String identificacion;
  private String correo;
  private String telefono;


  //Contructor
  public Cliente(String nombre, String apellido, String identificacion, String correo, String telefono) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.identificacion = identificacion;
    this.correo = correo;
    this.telefono = telefono;
  }

  @Override
  public String toString() { return id + " | " + nombre + " " + apellido + " | CC: " + identificacion + " | " + correo + " | " + telefono;}

  //Gets
  public int getId() { return id; }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() { return apellido; }

  public String getIdentificacion() { return identificacion; }

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

  public void setApellido(String apellido) { this.apellido = apellido; }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
}

