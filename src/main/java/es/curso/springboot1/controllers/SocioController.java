package es.curso.springboot1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
//Model
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.springboot1.negocio.Socio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SocioController {

    List<Socio> socios = new ArrayList<Socio>();

    public SocioController() {
        socios.add(new Socio("pepe", "perez", 10));
        socios.add(new Socio("pepe2", "pereza", 11));
        socios.add(new Socio("pepe3", "perezb", 9));
        socios.add(new Socio("pepe4", "perezc", 18));
    }

    @GetMapping("/listasocios")

    public String listasocios(Model modelo) {
        modelo.addAttribute("listasocios", socios);
        return "listasocios";
    }

    @GetMapping("/formulariosocio")

    public String formulariosocio() {

        return "formulariosocio";
    }

    @PostMapping("/insertarsocio")
    public String insertarSocio(@ModelAttribute Socio socio, Model modelo) {
        // TODO: process POST request
        socios.add(socio);
        modelo.addAttribute("listasocios", socios);
        return "listasocios";
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
