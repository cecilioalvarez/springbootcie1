package es.curso.springboot1.negocio;

public class Ejemplar {

    private String isbn;
    private int numero;
    private boolean disponible;
    
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public Ejemplar() {
    }
    public Ejemplar(String isbn, int numero, boolean disponible) {
       
        this.isbn = isbn;
        this.numero = numero;
        this.disponible = disponible;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Ejemplar(String isbn) {
        this.isbn = isbn;
    }

}
