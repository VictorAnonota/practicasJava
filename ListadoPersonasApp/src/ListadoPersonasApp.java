import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        //Se define fuera del ciclo while
        List<Persona> personas = new ArrayList<>();
        //Empezar menu
        var salir = false;
        while (!salir){
            mostrarMenu();
            try {
                salir = ejecutarOperacion(sca, personas);
            }catch (Exception e){
                System.out.println("Ocurrio un error: "+e.getMessage());
            }


            System.out.println();
        }
    }
    private static void mostrarMenu(){
        //Mostrar opciones
        System.out.print(""" 
                **** Listado de personas ****
                1.Agregar
                2.Listar
                3.Salir
                """);
        System.out.print("Proporciona la opcion: ");
    }

    private static boolean ejecutarOperacion(Scanner sca, List<Persona> personas){
        var opcion = Integer.parseInt(sca.nextLine());
        var salir = false;
        //Revisamos la opcion proporcionada
        switch (opcion){
            case 1 -> {
                //Agregar persona a la lista
                System.out.print("Proporciona el nombre: ");
                var nombre = sca.nextLine();
                System.out.print("Ingresa el telefono: ");
                var telefoo = sca.nextLine();
                System.out.print("Ingresa el email: ");
                var email =  sca.nextLine();
                //Crear objet persona
                var persona = new Persona(nombre,telefoo,email);
                //Se agtrega a la lista
                personas.add(persona);
                System.out.println("La lista tiene: "+ personas.size()+" elementos");
            }
            case 2 -> {
                System.out.println("Listado de personas: ");
                // Mejora usando lambda y metodo de referencia
                //personas.forEach((persona) -> System.out.println(persona));
                personas.forEach(System.out::println);
            }

            case 3 -> {
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default -> System.out.println("Opcion erronea: "+opcion);
        }return salir;
    }
}
