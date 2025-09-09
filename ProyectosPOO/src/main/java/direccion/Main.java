package direccion;

public class Main {
    public static void main(String[] args) {
        Direccion direccion = new Direccion("3","Nezahualcoyotl","Mexico");
        Persona persona = new Persona("Victor",30,direccion);
        System.out.println(persona.presentarse());
    }
}
