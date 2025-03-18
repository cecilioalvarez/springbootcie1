package es.curso.springboot1.repositories;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.curso.springboot1.negocio.Usuario;


public class UsuarioRowMapper implements RowMapper<Usuario>{

    @Override
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
      
        return new Usuario(rs.getString("nombre"),rs.getString("email"),rs.getString("rol"));
    }

}
