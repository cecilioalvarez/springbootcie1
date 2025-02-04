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

    List<Socio> socios = new ArrayList<>();

    public SocioController (){

        socios.add(new Socio ("pepe","perez",15));
        socios.add(new Socio ("pepe1","perez1", 15));
        socios.add(new Socio ("pepe2","perez2", 15));



        
    }

    @GetMapping("/listasocios")
    public String listasocios (Model modelo){
        modelo.addAttribute("listasocios",socios);
        return "listasocios";
    }

    @GetMapping("/socios")
    public String socios() {
        return "plantillasocio";
    }

    @GetMapping("/versocio")
    public String verSocio(@RequestParam String nombre, Model modelo) {

        System.out.println(nombre);
        modelo.addAttribute("nombre",nombre);
        return "plantillaversocio";
    }
    
     
}
