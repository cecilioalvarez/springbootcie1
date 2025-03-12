package es.curso.springboot1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.curso.springboot1.negocio.Ejemplar;

@Repository
@Qualifier("jdbc")
public class EjemplarRepositoryJDBC implements EjemplarRepository {

    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public List<Ejemplar> buscarTodos() {
        return plantilla.query("select * from ejemplares", new EjemplarRowMapper());
    }

    @Override
    public Ejemplar buscarUnEjemplar(String ISBN, int numero) {
        return plantilla.queryForObject("select * from ejemplares where ISBN=? and numero=?", new EjemplarRowMapper(),ISBN,numero);
    }

    @Override
    public void insertar(Ejemplar ejemplar) {
        plantilla.update("insert into ejemplares values (?,?,?)",
        ejemplar.getISBN(),ejemplar.getNumero(),ejemplar.isDisponible());
    }

    @Override
    public void borrar(String ISBN, int numero) {
        plantilla.update("delete from ejemplares where ISBN=? and numero=?",ISBN,numero);
    }

}