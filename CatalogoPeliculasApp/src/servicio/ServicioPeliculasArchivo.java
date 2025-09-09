package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements iServicioPeliculas{

    private final String NOMBRE_ARCHIVO  = "peliculas.txt";

    public ServicioPeliculasArchivo(){
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            //Si ya existe el archivo no se vuelve a crear
            if (archivo.exists()){
                System.out.println("El archivo ya existe");
            }else {
                //SI no existe de crea el archivo vacio
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creqado el archivp");
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error al abrir el archivo: "+e.getMessage());
        }
    }


    @Override
    public void listarPeliculas() {
        //Volver abrir archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            System.out.println("Listado de peliculas");
            var entrada = new BufferedReader(new FileReader(archivo));
            //Leemos line a lina el archivo
            String linea;
            linea = entrada.readLine();
            //Leeemos todas las lineas
            while (linea != null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                //Antes de terminar el ciclo volvemos a leer la siguiente linea
                linea= entrada.readLine();
            }
            //Cerrar el archivo
            entrada.close();
        }catch (Exception e){
            System.out.println("Ocurrio un error al abrir el archivo... "+e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            //Revisamos si existe el archivo
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            // Agregar la plicula (yiString)
            salida.println(pelicula);
            salida.close();
            System.out.println("Se agrego al archico la pelicula: "+pelicula.getNombre());
        }catch (Exception e){
            System.out.println("Erroor all ageregar la pelicula: "+pelicula);
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            //Arimos el archivo para lectura linea por linea
            var entrada= new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto = entrada.readLine();
            var indice = 1;
            var encontrar = false;
            var peliculaBuscar = pelicula.getNombre();
            while (lineaTexto != null){
                //Buscamos sin importar mayusculas minusculas
                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    encontrar = true;
                    break;
                }
                //Leemos la siguente linea antes de la siguiente iteracion
                lineaTexto = entrada.readLine();
                indice++;
            }
            //Imprimimos los resultados de la busqueda
            if(encontrar){
                System.out.println("Pelicula "+lineaTexto+" Encontradad linea "+indice);
            }else
                System.out.println("No se encontro la pelicula: "+pelicula.getNombre());
            entrada.close();
        } catch (Exception e){
            System.out.println("Ocurrio un error al busar pelicula: "+e.getMessage());
        }
    }
}
