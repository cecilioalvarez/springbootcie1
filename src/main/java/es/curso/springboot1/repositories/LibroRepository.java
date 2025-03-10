package es.curso.springboot1.repositories;

import java.util.List;
import es.curso.springboot1.negocio.Libro;

public interface LibroRepository {

    List <Libro> buscarTodos();
    List <Libro> buscarPorTitulo (String titulo);
    List <Libro> buscarPorAutor (String autor);
    //Enseña solo uno
    Libro buscarUno(String isbn);
    void insertar(Libro libro);
    void borrar (Libro libro);
}
