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

import es.curso.springboot1.negocio.Ejemplar;
import es.curso.springboot1.repositories.EjemplarRepository;



@RestController
@RequestMapping("/webapi/ejemplar")
public class EjemplarRestController {

    @Autowired
    @Qualifier("jdbc")
    private EjemplarRepository ejemplarRepository;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Ejemplar> buscarTodos() {

        return ejemplarRepository.buscarTodos();
    }

    @PostMapping
    
    public void insertar(@RequestBody Ejemplar ejemplar) {

        ejemplarRepository.insertar(ejemplar);
    }
    
    @DeleteMapping("/isbn/{isbn}/numero/{numero}")
    public void borrar(@PathVariable String isbn,@PathVariable int numero) {

        ejemplarRepository.borrar(isbn,numero);
    }
    
   
   
   
   @GetMapping("/isbn/{isbn}/numero/{numero}")
   @CrossOrigin(origins="http://localhost:4200")
   public Ejemplar buscarUno(@PathVariable String isbn, @PathVariable int numero) {
     return ejemplarRepository.buscarUno(isbn,numero);
   }
   
   
   
   
   //  /webapi/libros?titulo=mititulo
   ///webapi/libros/123//path variable
}
