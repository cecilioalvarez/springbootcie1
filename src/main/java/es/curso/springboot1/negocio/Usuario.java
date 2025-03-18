package es.curso.springboot1.negocio;

public class Usuario {

    private String nombre;
    private String clave;
    private String email;
    private String rol;

    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public Usuario(String nombre, String clave, String email, String rol) {
        this.nombre = nombre;
        this.clave = clave;
        this.email = email;
        this.rol = rol;
    }
    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    public Usuario() {
    }
    public Usuario(String nombre, String email, String rol) {
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    

}
