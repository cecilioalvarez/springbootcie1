package es.curso.springboot1.repositories;

import java.util.List;

import es.curso.springboot1.negocio.Libro;

public interface LibroRepository {

    Libro buscarUno (String isbn);
    List<Libro> buscarTodos();
    List<Libro> buscarTodosPorTitulo(String titulo);
    List<Libro> buscarTodosPorAutor(String autor);
    List<Libro> buscarPorRango (int inicio, int fin);
    void insertar(Libro libro);
    void borrar(Libro libro);
}
