package es.curso.springboot1.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Libro> buscarTodos() {

        return libroRepository.buscarTodos();
    }

    @PostMapping
    
    public void insertar(@RequestBody Libro libro) {

        libroRepository.insertar(libro);
    }
    
    @DeleteMapping("/{isbn}")
    @CrossOrigin(origins = "http://localhost:4200")

    public void borrar(@PathVariable String isbn) {

        libroRepository.borrar(new Libro(isbn));
    }
    @GetMapping(params = {"titulo"})
    public List<Libro> buscarTodosPorTitulo(@RequestParam String titulo) {
        return libroRepository.buscarTodosPorTitulo(titulo);
    }
    @GetMapping(params = {"autor"})
    public List<Libro> buscarPorAutor(@RequestParam String autor) {
        return libroRepository.buscarTodosPorAutor(autor); 
   
   
   }
   @GetMapping("/{isbn}")
   @CrossOrigin(origins="http://localhost:4200")
   public Libro buscarUno(@PathVariable String isbn) {
     return libroRepository.buscarUno(isbn);
   }
   
   @GetMapping("titulo")
   public List<Libro> buscarPorTitulo(@RequestParam String titulo) {
       return libroRepository.buscarTodosPorTitulo(titulo);
   }
   
   
   //  /webapi/libros?titulo=mititulo
   ///webapi/libros/123//path variable
}
