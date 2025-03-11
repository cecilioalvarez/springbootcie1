package es.curso.springboot1.repositories;

import java.util.List;

import es.curso.springboot1.negocio.Ejemplar;




public interface EjemplarRepository {
    List<Ejemplar> buscarTodos();
    Ejemplar buscarUno (String isbn, int numero);
    List<Ejemplar> disponibilidad(boolean disponible);
    void insertar(Ejemplar ejemplar);
    void eliminar (String isbn, int numero);
    

}
