package es.curso.springboot1.repositories;

import java.util.Optional;

import es.curso.springboot1.negocio.Usuario;

public interface UsuarioRepository {

    Optional<Usuario> validar(Usuario usuario);
}
