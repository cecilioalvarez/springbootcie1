package es.curso.springboot1.negocio;

public class Socio {

    private String nombre;
    private String apellidos;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Socio(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Socio(String nombre) {
        this.nombre = nombre;
    }

    public Socio() {
    }

    @Override
    public String toString() {
        return "Socio [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + "]";
    }

}
