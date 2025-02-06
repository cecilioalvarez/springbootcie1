package es.curso.springboot1.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.springboot1.negocio.Socio;



@Controller
public class SocioController {

    List<Socio> socios = new ArrayList<Socio>();
    public SocioController(){

        socios.add (new Socio("pepe","perez",10));
        socios.add (new Socio("maria","gomez",20));
        socios.add (new Socio("juan","martin",30));
    }

    //al formulario
    @GetMapping("/formulariosocio")
    public String formulariosocio() {
        
        return "formulariosocio";
    }

    //insertar nuevo
    @PostMapping("/insertarsocio")
    public String insertarsocio(@ModelAttribute Socio socio) {
        
        socios.add(socio);
        
        return "redirect:listasocios";
    }

    //borrar existentente
    @GetMapping("/borrar")
    public String borrarSocio(@RequestParam("nombre")String nombre) {
        Socio s=new Socio(nombre);
        socios.remove(s);
        
        return "redirect:listasocios";
    }

    @GetMapping("/detalle")
    public String detalleSocio(@RequestParam ("nombre") String nombre,Model modelo) {
        Optional<Socio>oSocio=
        socios.stream().filter((s)->s.getNombre().equals(nombre)).findFirst();

        if(oSocio.isPresent()){
            modelo.addAttribute("socio",oSocio.get());
        }
        return "detallesocio";
    }

    @GetMapping("/editar")
    public String editarSocio(@RequestParam ("nombre") String nombre,Model modelo) {
        Optional<Socio>oSocio=
        socios.stream().filter((s)->s.getNombre().equals(nombre)).findFirst();

        if(oSocio.isPresent()){
            modelo.addAttribute("socio",oSocio.get());
        }
        return "formularioeditarsocio";
    }
    
    @PostMapping("/salvarsocio")
    public String salvarSocio(@ModelAttribute Socio socio) {
        
        Optional<Socio>oSocio=
        socios.stream().filter((s)->s.getNombre().equals(socio.getNombre())).findFirst();
        
        if(oSocio.isPresent()){
            Socio socioActual=oSocio.get();
            socioActual.setApellidos(socio.getApellidos());
            socioActual.setEdad(socio.getEdad());
        }
        return "redirect:listasocios";
    }

    
    //mostrar la lista
    @GetMapping("/listasocios")
    public String listasocios(Model modelo) {
        modelo.addAttribute("listasocios",socios);
        return "listasocios";
    }
    
    //ordenar
    @GetMapping(value="/listasocios",params="orden")
    public String listasocios(Model modelo, @RequestParam String orden) {

        List <Socio> listaOrdenada = new ArrayList<>();
        if (orden.equals("nombre")){

            listaOrdenada = socios.stream().sorted(Comparator.comparing(Socio::getNombre)).toList();

        }else if (orden.equals("apellidos")){

            listaOrdenada = socios.stream().sorted(Comparator.comparing(Socio::getApellidos)).toList();

        }else{
            listaOrdenada = socios.stream().sorted(Comparator.comparing(Socio::getEdad)).toList();
        }

        modelo.addAttribute("listasocios",listaOrdenada);
        return "listasocios";
    }

    //
    @GetMapping("/socios")
    public String socios() {
        return "plantillasocio";
    }

    //
    @GetMapping("/versocio")
    public String verSocio(@RequestParam String nombre, Model modelo) {

        System.out.println(nombre);
        modelo.addAttribute("nombre", nombre);
        return "plantillaversocio";
    }

}
