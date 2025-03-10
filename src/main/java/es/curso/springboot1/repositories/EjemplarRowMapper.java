package es.curso.springboot1.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.curso.springboot1.negocio.Ejemplar;

public class EjemplarRowMapper implements RowMapper <Ejemplar> {

    @Override
    public Ejemplar mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        return new Ejemplar(rs.getString("isbn"), rs.getInt("numero"), rs.getBoolean("disponible"));
    }

}
