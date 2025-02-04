package es.curso.springboot1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.springboot1.negocio.Socio;

@Controller
public class SocioController {

    List<Socio> socios = new ArrayList<Socio>();

    public SocioController() {
        socio.add(new Socio("pepe", "perez", 10));
        socio.add(new Socio("pepe2", "pereza", 11));
        socio.add(new Socio("pepe3", "perezb", 9));
        socio.add(new Socio("pepe4", "perezc", 18));
    }

    @GetMapping("/socios")
    public String socios() {
        return "plantillasocio";
    }

    @GetMapping("/versocio")
    public String verSocio(@RequestParam String nombre, Model modelo) {

        System.out.println(nombre);
        modelo.addAttribute("nombre", nombre);
        return "plantillaversocio";
    }

}
