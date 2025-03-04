package es.curso.springboot1.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.curso.springboot1.negocio.Libro;
import es.curso.springboot1.repositories.LibroRepository;
@RestController
@RequestMapping("/webapi/libros")
public class LibroRestController {

    @Autowired
    @Qualifier("jdbc")
    private LibroRepository libroRepository;

    @GetMapping
    public List<Libro> buscarTodos() {

        return libroRepository.buscarTodos();

    }
}
