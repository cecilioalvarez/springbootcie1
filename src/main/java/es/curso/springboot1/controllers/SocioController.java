package es.curso.springboot1.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.springboot1.negocio.Socio;
import es.curso.springboot1.repositories.SocioRepositoryMemoria;

@Controller
public class SocioController {

    @Autowired
    private SocioRepositoryMemoria socioRepository;

    public SocioController() {

    }

    @GetMapping("/listasocios")
    public String listasocios(Model modelo) {
        modelo.addAttribute("listasocios", socioRepository.buscarTodos());
        return "listasocios";
    }

    // funcion ordenar socios
    @GetMapping(value = "/listasocios", params = "orden")
    public String listasocios(Model modelo, @RequestParam String orden) {
        List<Socio> listaOrdenada = socioRepository.buscarTodosOrdenados(orden);
        modelo.addAttribute("listasocios", listaOrdenada);
        return "listasocios";
    }

    @GetMapping("/formulariosocio")
    public String formulariosocio() {
        return "formulariosocio";
    }

    // funcion añadir socio
    @PostMapping("/insertarsocio")
    public String insertarsocio(@ModelAttribute Socio socio) {
        socioRepository.insertarsocio(socio);
        return "redirect:listasocios";
    }

    // funcion borrar socio
    @GetMapping("/borrar")
    public String borrarsocio(@RequestParam("nombre") String nombre) {
        socioRepository.borrarsocio(nombre);
        return "redirect:listasocios";
    }

    @GetMapping("/detallesocio")
    public String detalleSocio(@RequestParam("nombre") String nombre, Model modelo) {
        Optional<Socio> oSocio = socioRepository.BuscarUno(nombre);
        if (oSocio.isPresent()) {
            modelo.addAttribute("socio", oSocio.get());
        }
        return "detallesocio";
    }

    @GetMapping("/editar")
    public String editarSocio(@RequestParam("nombre") String nombre, Model modelo) {
        Optional<Socio> oSocio = socioRepository.BuscarUno(nombre);
        if (oSocio.isPresent()) {
            modelo.addAttribute("socio", oSocio.get());
        }
        return "formularioeditarsocio";
    }

    @PostMapping("/salvarsocio")
    public String salvarsocio(@ModelAttribute Socio socio, @RequestParam String nombreAntiguo) {
        Optional<Socio> oSocio = socioRepository.BuscarUno(nombreAntiguo);
        if (oSocio.isPresent()) {
            Socio socioActual = oSocio.get();
            socioActual.setNombre(socio.getNombre());
            socioActual.setApellidos(socio.getApellidos());
            socioActual.setEdad(socio.getEdad());
        }
        return "redirect:listasocios";
    }
}
