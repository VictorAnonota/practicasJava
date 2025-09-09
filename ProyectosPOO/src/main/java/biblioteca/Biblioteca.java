package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
   private List<Libro> libros;

   public Biblioteca(){
       this.libros = new ArrayList<>();
   }

   public void agregarLibros(Libro libro){
       libros.add(libro);
       System.out.println("Libro agrgado: "+libro.getTitulo());
    }
    
    public void mostrarLibros(){
       if (libros.isEmpty()){
           System.out.println("La biblioteca no tiene libros registrados.");
       }else {
           System.out.println("Lista de libros en la biblioteca:");
           for (Libro libro : libros);
       }
        System.out.println(libros);
    }

}
