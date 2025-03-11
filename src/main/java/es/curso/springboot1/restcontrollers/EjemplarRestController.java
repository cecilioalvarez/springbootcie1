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
import org.springframework.web.bind.annotation.RestController;

import es.curso.springboot1.negocio.Ejemplar;
import es.curso.springboot1.repositories.EjemplarRepository;



@RestController
@RequestMapping("webapi/ejemplares")
public class EjemplarRestController {

    @Autowired
    @Qualifier("jdbc")
    private EjemplarRepository ejemplarRepository;

     @GetMapping( "/isbn/{isbn}/numero/{numero}")
     @CrossOrigin(origins = "http://localhost:4200")
    public Ejemplar buscarUno(@PathVariable String isbn,@PathVariable int numero){

        return ejemplarRepository.buscarUno(isbn,numero);

    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")

    public void insertar(@RequestBody Ejemplar ejemplar){

        ejemplarRepository.insertar(ejemplar);

    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List <Ejemplar> buscarTodos() {

        return ejemplarRepository.buscarTodos();
        
    }

    @DeleteMapping("/isbn/{isbn}/numero/{numero}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void eliminar(@PathVariable String isbn, @PathVariable int numero) {
        ejemplarRepository.eliminar(isbn, numero);
    }


 }


