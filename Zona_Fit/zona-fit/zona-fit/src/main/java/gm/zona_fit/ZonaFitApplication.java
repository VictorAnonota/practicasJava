package gm.zona_fit;

import gm.zona_fit.modelo.Cliente;
import gm.zona_fit.servicio.ClienteServicio;
import gm.zona_fit.servicio.IClienteServicio;
import org.hibernate.boot.archive.scan.spi.ScanEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

//@SpringBootApplication
public class ZonaFitApplication {

	@Autowired
	private IClienteServicio clienteServicio;

	public static void main(String[] args) {
		var contexto = SpringApplication.run(ZonaFitApplication.class,args);
		//System.out.println("Fabrica de spring inicializada... "+contexto);
		var app = contexto.getBean(ZonaFitApplication.class);
		app.ejecutarMenu();
	}

	public void ejecutarMenu(){
		Scanner scanner = new Scanner(System.in);
		var opcion = -1;

		do {
			System.out.println("\n*** Aplicacion Zona Fit (GYM) ****");
			System.out.println("1. Listar clientes");
			System.out.println("2. Buscar clientes");
			System.out.println("3. Agregar cliente");
			System.out.println("4. Modificar cliente");
			System.out.println("5. Eliminar cliente");
			System.out.println("6. Salir");
			System.out.print("Elige una opcion: ");

			opcion = Integer.parseInt(scanner.nextLine());

			switch (opcion){
				case 1 -> listarClientes();
				case 2 -> buscarCliente(scanner);
				case 3 -> agregarCliente(scanner);
				case 4 -> modificarCliente(scanner);
				case 5 -> eliminarCliente(scanner);
				case 6 -> System.out.println("Hasta pronto");
				default -> System.out.println("Opcion no valida");
			}
		}while (opcion!= 6);
	}

	private void listarClientes(){
		System.out.println("\n---- listado de Clientes ----");
		var clientes = clienteServicio.listarClientes();
		clientes.forEach(System.out::println);
	}

	private void buscarCliente(Scanner scanner){
		System.out.print("\n---- Buscar Cliente por Id ----\nId Cliente a Buscar: ");
		var id = Integer.parseInt(scanner.nextLine());
		var cliente = clienteServicio.buscarClientePorId(id);
		if (cliente != null){
			System.out.println("Cliente encontado: "+cliente);
		}else {
			System.out.println("Elemento no encontraddo");
		}
	}

	private void agregarCliente(Scanner scanner){
		System.out.println("\n---- Agregar Cliente ----");
		var cliente = leerDatosCliente(scanner);
		clienteServicio.guardarCliente(cliente);
		System.out.println("Cliente guardado correctamenete");
	}

	private void modificarCliente(Scanner scanner){
		System.out.print("\n---- Modificar Cliente ----\n Cliente a modificar: ");
		var id = Integer.parseInt(scanner.nextLine());
		var cliente = clienteServicio.buscarClientePorId(id);
		if (cliente != null){
			System.out.println("Cliente a modificar: "+cliente);
			var clienteModificado = leerDatosCliente(scanner);
			clienteModificado.setId(id);
			clienteServicio.guardarCliente(clienteModificado);
			System.out.println("Ciente modoficado correctamente.");
		}else {
			System.out.println("Cliente no encontrado");
		}
	}

	private void eliminarCliente(Scanner scanner){
		System.out.print("---- Eliminar Cliente ----\nIndica el id del cliente: ");
		var id = Integer.parseInt(scanner.nextLine());
		var cliente = clienteServicio.buscarClientePorId(id);
		if (cliente != null){
			clienteServicio.eliminarCliente(cliente);
			System.out.println("Cliente eliminado correctamete");
		}else {
			System.out.println("Cliente no encontrado");
		}
	}

	private Cliente leerDatosCliente(Scanner scanner){
		System.out.print("Nombre: ");
		var nombre = scanner.nextLine();
		System.out.print("Apellido: ");
		var apellido = scanner.nextLine();
		System.out.print("Email: ");
		var email = scanner.nextLine();
		System.out.print("Membresia: ");
		var membresia = Integer.parseInt(scanner.nextLine());
		return new Cliente(nombre, apellido, email, membresia);

	}

	//public static void main(String[] args) {
		//SpringApplication.run(ZonaFitApplication.class, args);
	//}

}
