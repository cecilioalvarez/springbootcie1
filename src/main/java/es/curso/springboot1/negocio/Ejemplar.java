package es.curso.springboot1.negocio;

public class Ejemplar {
    private String ISBN;
    private int numero;
    private boolean disponible;
    
    public Ejemplar() {
    }
    public Ejemplar(String iSBN, int numero) {
        ISBN = iSBN;
        this.numero = numero;
    }
    public Ejemplar(String iSBN, int numero, boolean disponible) {
        ISBN = iSBN;
        this.numero = numero;
        this.disponible = disponible;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

}

