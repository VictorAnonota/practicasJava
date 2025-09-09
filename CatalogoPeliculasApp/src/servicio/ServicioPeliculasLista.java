package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements iServicioPeliculas{

    private final List<Pelicula> peliculas;

    public ServicioPeliculasLista(){
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("****Listado de peliculas****");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: "+pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        //Regresa el indice de la pelicula encontrada de la lista
        var indice = peliculas.indexOf(pelicula);
        if (indice == -1)
            System.out.println("Pelicula no encontrada en el indice: "+indice);
        else System.out.println("Pelicula encontrada: "+indice);
    }

    public static void main(String[] args) {
        // Creamos objetos de tipo pelicula
        var pelicula1 =  new Pelicula("Batman");
        var pelicula2 = new Pelicula("Superman");
        //Creamos el servicio (Paton de diseño service)
        iServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        // Agregamos peliculas a la lista
        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);
        //Listar peliculas
        servicioPeliculas.listarPeliculas();
        //Buscamos una pelicula
        //Se debe implemetar el metodo equal y hashcode
        //servicioPeliculas.buscarPelicula(new Pelicula("Superman"));
    }
}
