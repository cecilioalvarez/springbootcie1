package es.trabajolibro.demo.repositories;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.trabajolibro.demo.negocio.Libro;

@Repository
public class LibroRepositoryMemoria {

    List<Libro> libros = new ArrayList<Libro>();

    public LibroRepositoryMemoria() {
        libros.add(new Libro("caminando", "pedro", 20));
        libros.add(new Libro("conduciendo", "jaime", 40));
        libros.add(new Libro("jugando", "alberto", 60));
        libros.add(new Libro("bailando", "juan", 80));

    }

    public void borrarlibro(String titulo) {

        Libro l = new Libro(titulo);
        libros.remove(l);

    }

    public void insertarLibro(Libro libro) {
        libros.add(libro);
    }

    public List<Libro> buscarTodos() {
        return libros;
    }

    public Optional<Libro> buscarUno(String titulo) {
        return libros.stream().filter((s) -> s.getTitulo().equals(titulo)).findFirst();

    }

    public List<Libro> buscarTodosOrdenados(String orden) {

        List<Libro> listaOrdenada = new ArrayList<>();
        if (orden.equals("titulo")) {

            listaOrdenada = libros.stream().sorted(Comparator.comparing(Libro::getTitulo)).toList();
        } else if (orden.equals("autor")) {
            listaOrdenada = libros.stream().sorted(Comparator.comparing(Libro::getAutor)).toList();
        } else {
            listaOrdenada = libros.stream().sorted(Comparator.comparing(Libro::getIsbn)).toList();
        }

        return listaOrdenada;

    }

}
