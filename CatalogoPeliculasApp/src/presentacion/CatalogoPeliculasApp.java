package presentacion;

import dominio.Pelicula;
import servicio.ServicioPeliculasArchivo;
import servicio.ServicioPeliculasLista;
import servicio.iServicioPeliculas;

import java.util.Scanner;

public class CatalogoPeliculasApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        //Agregar implementacion del servicio
        //iServicioPeliculas servicioPelicula = new ServicioPeliculasLista();
        iServicioPeliculas servicioPelicula = new ServicioPeliculasArchivo();
        while (!salir){
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, servicioPelicula);
            } catch (Exception e){
                System.out.println("Ocurrio un error: "+e.getMessage());
            }
            System.out.println();
        }//fin while
    }

    private static void mostrarMenu(){
        System.out.print("""
                **** Catalogo de peliculas ****
                1. Agregar pelicula
                2. Listar pelicula
                3. Buscar pelicula
                4. Salir 
                """);
        System.out.print("Escoje una opcion: ");
    }

    private static boolean ejecutarOpciones(Scanner consola,
                                            iServicioPeliculas servicioPeliculas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false; // 👈 ahora empieza en false
        switch (opcion){
            case 1 -> {
                System.out.print("Introduce el nombre de la pelicula: ");
                var nombrePelicula = consola.nextLine();
                servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula));
            }
            case 2 -> servicioPeliculas.listarPeliculas();
            case 3 -> {
                System.out.print("Introduce la pelicula a buscar: ");
                var buscar = consola.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(buscar));
            }
            case 4 -> {
                System.out.println("Hasta pronto...");
                salir = true; // 👈 aquí sí se marca para salir
            }
            default -> System.out.println("Opcion no reconocida... "+opcion);
        }
        return salir;
    }
}
