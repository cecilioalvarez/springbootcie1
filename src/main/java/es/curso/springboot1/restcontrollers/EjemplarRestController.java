package es.curso.springboot1.restcontrollers;
import es.curso.springboot1.negocio.Ejemplar;
import es.curso.springboot1.repositories.EjemplarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("webapi/ejemplares")
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
    @CrossOrigin(origins = "http://localhost:4200")
    public void insertar (@RequestBody Ejemplar ejemplar) {
        ejemplarRepository.insertar(ejemplar);
    }

    @DeleteMapping ("/ISBN/{ISBN}/numero/{numero}")
    public void borrar (@PathVariable String ISBN, @PathVariable int numero){
        ejemplarRepository.borrar(ISBN, numero);

    }
       
    @GetMapping("/ISBN/{ISBN}/numero/{numero}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Ejemplar buscarUnEjemplar (@PathVariable String ISBN, @PathVariable int numero){
        return ejemplarRepository.buscarUnEjemplar(ISBN,numero);
    }
    
}

 

    
