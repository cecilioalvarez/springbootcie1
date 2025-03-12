package es.curso.springboot1.repositories;

import es.curso.springboot1.negocio.Ejemplar;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EjemplarRowMapper implements RowMapper<Ejemplar> {

    @Override
    public Ejemplar mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Ejemplar(
            resultSet.getString("ISBN"),
            resultSet.getInt("numero"),
            resultSet.getBoolean("disponible"));
        
    }

}
