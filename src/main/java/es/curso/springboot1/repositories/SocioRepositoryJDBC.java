package es.curso.springboot1.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.curso.springboot1.negocio.Socio;

@Repository
@Qualifier("jdbc")
public class SocioRepositoryJDBC implements SocioRepository {

    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public void borrarSocio(String nombre) {

        throw new UnsupportedOperationException("Unimplemented method 'borrarSocio'");
    }

    @Override
    public void insertarSocio(Socio socio) {

        throw new UnsupportedOperationException("Unimplemented method 'insertarSocio'");
    }

    @Override
    public List<Socio> buscarTodos() {

        return plantilla.query("select * from socios", new SocioRowMapper());

    }

    @Override
    public Optional<Socio> buscarUno(String nombre) {

        throw new UnsupportedOperationException("Unimplemented method 'buscarUno'");
    }

    @Override
    public List<Socio> buscarTodosOrdenados(String orden) {

        throw new UnsupportedOperationException("Unimplemented method 'buscarTodosOrdenados'");
    }

}
