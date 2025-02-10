package es.trabajolibro.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.trabajolibro.demo.negocio.Libro;
import es.trabajolibro.demo.repositories.LibroRepositoryMemoria;



@Controller
public class LibroController {

    @Autowired
    private LibroRepositoryMemoria libroRepository;

    public LibroController() {

    }

    @GetMapping("/formulariolibro")
    public String formulariolibro() {
        return "formulariolibro";
    }

    @PostMapping("/insertarlibro")
    public String insertarLibro(@ModelAttribute Libro libro) {
        libroRepository.insertarLibro(libro);
        return "redirect:listalibro";
    }


    @GetMapping("/listalibro")
    public String listalibro(Model modelo) {
        modelo.addAttribute("listalibro", libroRepository.buscarTodos());
        return "listalibro";
    }

    @GetMapping("/borrar")
    public String borrarlibro(@RequestParam("titulo") String titulo) {
        libroRepository.borrarlibro(titulo);
        return "redirect:listalibro";
    }

    @GetMapping(value = "/listalibro", params = "orden")
    public String listalibro(Model modelo, @RequestParam String orden) {

        List<Libro> listaOrdenada = libroRepository.buscarTodosOrdenados(orden);
        modelo.addAttribute("listalibro", listaOrdenada);
        System.out.println(orden);
        return "listalibro";
    }
}
