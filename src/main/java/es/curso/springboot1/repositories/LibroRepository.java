package es.curso.springboot1.repositories;

import java.util.List;

import es.curso.springboot1.negocio.Libro;

public interface LibroRepository {

    List <Libro> buscarTodos();
    Libro buscarUno (String isbn);
    List <Libro> buscarTodosPorTitulo(String titulo);
    List <Libro> buscarTodosPorAutor(String autor);
    List <Libro> buscarTodosPorPaginas(Number paginas);
    void insertar(Libro libro);
    void borrar (Libro libro);
}
