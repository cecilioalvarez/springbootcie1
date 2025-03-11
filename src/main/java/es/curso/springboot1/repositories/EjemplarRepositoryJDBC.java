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
    public Ejemplar buscarUno(String isbn, int numero) {
      
        return plantilla.queryForObject("select * from Ejemplares where isbn=? and numero=?", new EjemplarRowMapper(),isbn, numero);
    }

    

    @Override
    public void insertar(Ejemplar ejemplar) {
        plantilla.update("insert into Ejemplares values (?,?,?)", ejemplar.getIsbn(), ejemplar.getNumero(), ejemplar.isDisponible());
    }


    @Override
    public List<Ejemplar> disponibilidad(boolean disponible) {
        
        return plantilla.query(
            "select * from Ejemplares where disponible = ?", 
            new EjemplarRowMapper(), 
            disponible
        );
    

    }

    @Override
    public List<Ejemplar> buscarTodos() {
        return plantilla.query("select * from Ejemplares", new EjemplarRowMapper());
    }




    @Override
    public void eliminar(String isbn, int numero) {
        String sql = "DELETE FROM Ejemplares WHERE isbn = ? AND numero = ?";
        plantilla.update(sql, isbn, numero);
    }
    
}
