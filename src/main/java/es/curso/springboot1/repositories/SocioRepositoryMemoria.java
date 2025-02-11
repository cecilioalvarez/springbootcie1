package es.curso.springboot1.repositories;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import es.curso.springboot1.negocio.Socio;

@Repository
@Qualifier("memoria")
public class SocioRepositoryMemoria implements SocioRepository {

    //USAMOS EL REPOSITORY PARA DIVIDIR LAS RESPONSABILIDADES ENTRE ESTE Y EL CONTROLLER

    List<Socio> socios = new ArrayList<Socio>();

    public SocioRepositoryMemoria() {

        socios.add(new Socio("pepe", "perez", 10));
        socios.add(new Socio("maria", "gomez", 20));
        socios.add(new Socio("juan", "martin", 30));

    }

    //esto es una "accion"
    @Override
    public void borrarSocio (String nombre) {
        Socio s=new Socio(nombre);
        socios.remove(s);

    }

    //esto es una "accion"
    @Override
    public void insertarsocio( Socio socio) {
        socios.add(socio);
    }

    //esto es una lista
    @Override
    public List<Socio> buscarTodos(){
        return socios;
    }

    @Override
    public Optional<Socio> buscarUno (String nombre){
        return socios.stream().filter((s)->s.getNombre().equals(nombre)).findFirst();

    }

    @Override
    public List<Socio> buscarTodosOrdenados(String orden){

         List <Socio> listaOrdenada = new ArrayList<>();
        if (orden.equals("nombre")){

            listaOrdenada = socios.stream().sorted(Comparator.comparing(Socio::getNombre)).toList();

        }else if (orden.equals("apellidos")){

            listaOrdenada = socios.stream().sorted(Comparator.comparing(Socio::getApellidos)).toList();

        }else{
            listaOrdenada = socios.stream().sorted(Comparator.comparing(Socio::getEdad)).toList();
        }

        return listaOrdenada;

    }
}
