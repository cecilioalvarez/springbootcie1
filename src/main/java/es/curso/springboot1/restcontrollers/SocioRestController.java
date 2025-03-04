package es.curso.springboot1.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import es.curso.springboot1.negocio.Socio;
import es.curso.springboot1.repositories.SocioRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/webapi/socios")
public class SocioRestController {

    @Autowired
    @Qualifier("jdbc")
    private SocioRepository socioRepository;
    public SocioRestController() {
   
    } 
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Socio> buscarTodos() {

        return socioRepository.buscarTodos();
    }
}
