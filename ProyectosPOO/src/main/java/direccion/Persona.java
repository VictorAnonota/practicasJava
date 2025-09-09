package direccion;

public class Persona {
    private String nombre;
    private int edad;
    private Direccion direccion;

    public Persona(String nombre, int edad, Direccion direccion){
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }
    public String presentarse(){
        return "Hola me llamo "+nombre+" mi edad es "+edad+" el"+direccion;
    }
}
