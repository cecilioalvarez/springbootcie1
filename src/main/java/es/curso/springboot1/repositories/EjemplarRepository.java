package es.curso.springboot1.repositories;

import java.util.List;

import es.curso.springboot1.negocio.Ejemplar;

public interface EjemplarRepository {

    List <Ejemplar> buscarTodos();
    Ejemplar buscarUno(String isbn, int numero);
    void insertar(Ejemplar ejemplar);
    void borrar (String isbn,int numero);
}
