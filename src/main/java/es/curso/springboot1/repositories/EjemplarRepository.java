package es.curso.springboot1.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.curso.springboot1.negocio.Ejemplar;

@Repository
public interface EjemplarRepository {

    List<Ejemplar>buscarTodos();
   
    Ejemplar buscarUnEjemplar(String ISBN, int numero);

    void insertar(Ejemplar ejemplar);

    void borrar(String ISBN, int numero);
}



