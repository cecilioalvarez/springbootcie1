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

    public SocioController() {

        socios.add(new Socio("pepe", "perez", 10));
        socios.add(new Socio("pepe1", "perez", 10));
        socios.add(new Socio("pepe2", "perez", 10));
        socios.add(new Socio("pepe3", "perez", 10));
    }

    @GetMapping("/listasocios")
    public String listasocios(Model modelo) {
        System.out.println(socios);
        modelo.addAttribute("listasocios", socios);
        return "listasocios";
    }

    @GetMapping(value = "/listasocios", params = "orden")
    public String listasocios(Model modelo, @RequestParam String orden) {

        List<Socio> listaordenada = new ArrayList<>();
        if (orden.equals("nombre")) {
            listaordenada = socios.stream().sorted(Comparator.comparing(Socio::getNombre)).toList();
        } else if (orden.equals("apellidos")) {
            listaordenada = socios.stream().sorted(Comparator.comparing(Socio::getApellidos)).toList();
        } else {
            listaordenada = socios.stream().sorted(Comparator.comparing(Socio::getEdad)).toList();
        }
        modelo.addAttribute("listasocios", listaordenada);
        System.out.println(orden);
        return "listasocios";
    }

    @PostMapping("/insertarsocio")
    public String insertarSocio(@ModelAttribute Socio socio) {
        socios.add(socio);
        return "redirect:listasocios";
    }

    @GetMapping("/borrar")
    public String borrarSocio(@RequestParam("nombre") String nombre) {
        Socio s = new Socio(nombre);
        socios.remove(s);
        return "redirect:listasocios";
    }

    @GetMapping("/detalle")
    public String detalleSocio(@RequestParam("nombre") String nombre, Model modelo) {
        Optional<Socio> oSocio = socios.stream().filter((s) -> s.getNombre().equals(nombre)).findFirst();
        if (oSocio.isPresent()) {
            modelo.addAttribute("socio", oSocio.get());
        }
        return "detallesocio";
    }

    @GetMapping("/editar")
    public String editarSocio(@RequestParam("nombre") String nombre, Model modelo) {
        Optional<Socio> oSocio = socios.stream().filter((s) -> s.getNombre().equals(nombre)).findFirst();

        if (oSocio.isPresent()) {
            modelo.addAttribute("socio", oSocio.get());
        }
        return "formularioeditarsocio";
    }

    @PostMapping("/salvarsocio")
    public String salvarSocio(@ModelAttribute Socio socio, @RequestParam String nombreAntiguo) {

        Optional<Socio> oSocio = socios.stream().filter((s) -> s.getNombre().equals(nombreAntiguo)).findFirst();
        if (oSocio.isPresent()) {
            Socio socioActual = oSocio.get();
            socioActual.setNombre(socio.getNombre());
            socioActual.setApellidos(socio.getApellidos());
            socioActual.setEdad(socio.getEdad());
        }
        return "redirect:listasocios";
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
        modelo.addAttribute("nombre", nombre);
        return "plantillaversocio";
    }

}
