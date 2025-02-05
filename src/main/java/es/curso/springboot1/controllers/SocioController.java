package es.curso.springboot1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.springboot1.negocio.Socio;


@Controller
public class SocioController {

    List<Socio> socios= new ArrayList<Socio>();

    public SocioController() {

        socios.add(new Socio("pepe", "Perez", 30));
        socios.add(new Socio("Juan", "Rodriguez", 25));
        socios.add(new Socio("José", "Ruiz", 20));
        socios.add(new Socio("Carlota", "Castañeda", 15));
        
    }

    @GetMapping("/listasocios")
    public String listasocios(Model modelo) {
        modelo.addAttribute("listasocios", socios);
        System.out.println(socios.size());
        return "listasocios";
    }    

    @GetMapping("/socios")
    public String socios() {
        return "plantillasocio";
    }

    @GetMapping("/formulariosocio")
    public String formulariosocio() {
        return "formulariosocio";
    }

    @GetMapping("/versocio")
    public String verSocio(@RequestParam String nombre, Model modelo) {

        System.out.println(nombre);
        modelo.addAttribute("nombre",nombre);
        return "plantillaversocio";
    } 
    @PostMapping("/insertarsocio")
    public String insertarsocio(@ModelAttribute Socio socio, Model modelo) {
        //añadir un socio
        socios.add(socio);
        //A el modelo, le paso la nueva lista 
        modelo.addAttribute("listasocios", socios);
        return "listasocios";
    }
}
