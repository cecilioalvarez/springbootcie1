package es.curso.springboot1.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.curso.springboot1.negocio.Usuario;
@Repository
public class UsuarioRepositoryJDBC implements UsuarioRepository {

    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public Optional<Usuario> validar(Usuario usuario) {

         try {

            Usuario u=plantilla.queryForObject("select * from Usuarios where nombre=? and clave=?", 
            new UsuarioRowMapper(), usuario.getNombre(),usuario.getClave());
            return Optional.of(u);

            
         } catch (Exception e) {

            return Optional.empty();
         }
     
     
        
         
    }




}
