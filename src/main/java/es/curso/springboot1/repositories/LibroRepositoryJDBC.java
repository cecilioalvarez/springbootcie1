package es.curso.springboot1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.curso.springboot1.negocio.Libro;

@Repository
@Qualifier("jdbc")
public class LibroRepositoryJDBC implements LibroRepository{

    @Autowired
    private JdbcTemplate plantilla;
    
    @Override
    public List<Libro> buscarTodos() {
        return plantilla.query("select * from libros", new LibroRowMapper());
    }

    @Override
    public void insertar(Libro libro) {
        // TODO Auto-generated method stub
       plantilla.update("insert into Libros values (?,?,?,?)", 
       libro.getIsbn(),
       libro.getTitulo(),
       libro.getAutor(),
       libro.getPaginas());
    }

    @Override
    public void borrar(Libro libro) {
        plantilla.update("delete from Libros where isbn=?", libro.getIsbn());
    }

}
