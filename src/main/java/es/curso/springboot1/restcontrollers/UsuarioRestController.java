package es.curso.springboot1.restcontrollers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.curso.springboot1.negocio.Usuario;
import es.curso.springboot1.repositories.UsuarioRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/webapi/usuarios")
public class UsuarioRestController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/validar")
    @CrossOrigin(origins = "http://localhost:4200")
    public Usuario validar(@RequestBody Usuario usuario) {
        
        Optional<Usuario> oUsuario= usuarioRepository.validar(usuario);

        if (oUsuario.isPresent()) {

            return oUsuario.get();
        }else {

            return new Usuario();
        }


    }





}
