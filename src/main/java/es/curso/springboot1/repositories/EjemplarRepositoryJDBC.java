package es.curso.springboot1.repositories;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.curso.springboot1.negocio.Ejemplar;

@Repository
@Qualifier("jdbc")
public class EjemplarRepositoryJDBC implements EjemplarRepository{
    
    @Autowired
    private JdbcTemplate plantilla;
    
    @Override
    public List<Ejemplar> buscarTodos() {

       
        return plantilla.query ("select * from ejemplares",new EjemplarRowMapper());
    }

    @Override
    public Ejemplar buscarUno(String isbn, int numero) {
        return plantilla.queryForObject("select * from ejemplares where isbn=? AND numero=?",new EjemplarRowMapper(),isbn, numero);
    }

    @Override
    public void insertar(Ejemplar ejemplar) {
        plantilla.update("insert into ejemplares values (?,?,?)",
       ejemplar.getIsbn(),ejemplar.getNumero(),ejemplar.isDisponible());
    }

    @Override
    public void borrar(String isbn,int numero) {
        plantilla.update("delete from ejemplares where isbn=? AND numero=?",isbn,numero);
    }

}
