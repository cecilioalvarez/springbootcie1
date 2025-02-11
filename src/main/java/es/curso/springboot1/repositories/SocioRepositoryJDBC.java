package es.curso.springboot1.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import es.curso.springboot1.negocio.Socio;

@Repository
@Qualifier("jdbc")
public class SocioRepositoryJDBC  implements SocioRepository{

    @Override
    public void borrarSocio(String nombre) {
        
    }

    @Override
    public void insertarSocio(Socio socio) {
      
      
    }

    @Override
    public List<Socio> buscarTodos() {
       
    }

    @Override
    public Optional<Socio> buscarUno(String nombre) {
      
    
    }

    @Override
    public List<Socio> buscarTodosOrdenados(String orden) {
       
      

    
    }
}
