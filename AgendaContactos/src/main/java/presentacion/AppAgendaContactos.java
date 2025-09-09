package presentacion;

import datos.ContactoDao;
import dominio.Contacto;

import java.util.List;
import java.util.Scanner;

public class AppAgendaContactos {
    public static void main(String[] args) {
        var consola = new Scanner(System.in);
        ContactoDao dao = new ContactoDao();

        int opcion;
        do {
            System.out.print("""
                    \n*** Menu Agenda de Contactos ***
                    1. Listar contactos
                    2. Agregar contacto
                    3. Actualizar contacto
                    4. Eliminar contacto
                    5. Salir
                    Elige una opcion:""");
            opcion = Integer.parseInt(consola.nextLine());
            switch(opcion){
                case 1 ->{
                    List<Contacto> lista = dao.obtenerContactos();
                    for (Contacto contacto: lista ){
                        System.out.println(contacto);
                    }
                }
                case 2 -> {
                    System.out.println("Nombre: ");
                    String nombre = consola.nextLine();
                    System.out.println("Telefono: ");
                    String telefono = consola.nextLine();
                    System.out.println("Email: ");
                    String email = consola.nextLine();
                    dao.insertarContacto(new Contacto(nombre,telefono,email));
                }
                case 3 ->{
                    System.out.println("Ingressa el id del contacto: ");
                    int id = Integer.parseInt((consola.nextLine()));
                    System.out.println("Nuevo ombre: ");
                    String nombre = consola.nextLine();
                    System.out.println("Nuevo Telefono: ");
                    String telefono = consola.nextLine();
                    System.out.println("Nuevo Email: ");
                    String email = consola.nextLine();
                    dao.actualzarContacto(new Contacto(id, nombre,telefono,email));
                }
                case 4 ->{
                    System.out.println("Id del contacto a eliminar");
                    int id = Integer.parseInt(consola.nextLine());
                    dao.eliminarContacto(new Contacto(id));
                }
                case 5 -> System.out.print("Has salido de agenda");
                    default -> System.out.print("Opcion invalida.");

            }
        }while (opcion != 5);
    }
}
