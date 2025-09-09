import java.util.Scanner;

public class CalculadoraApp {
    public static void main(String[]args){
        Scanner sca = new Scanner(System.in);

        while (true) {
            System.out.println("**** Aplicacion calculadora ****");
            //Mustra de menu
            mostrarMenu();
            try {
                var operacion = Integer.parseInt(sca.nextLine());
                //Revisar que ste dentro de las opciones
                if (operacion >= 1 && operacion <= 4) {
                    //Ejecutar la operacion
                    ejecutarOperacion(operacion, sca);
                } else if (operacion == 5) {
                    System.out.println("Hasta pronto");
                    break;

                } else {
                    System.out.println("Opcion erronea: " + operacion);
                }
                System.out.println();

            } catch (Exception e){
                System.out.println("Ocurrio un error: "+e.getMessage());
            }

        }
        sca.close();

    }
    private static void mostrarMenu(){
        System.out.print("""
                           1.Suma
                           2.Resta
                           3.Multiplicacion
                           4.Division
                           5.Salir
                       """);
        System.out.print("Operacion a realizar: ");
    }
    private static void ejecutarOperacion(int operacion, Scanner sca){
        System.out.print("Proporciona el valor de operando 1: ");
        var operando1 = Integer.parseInt(sca.nextLine());
        System.out.print("Proporciona el valor de operando 2: ");
        var operando2 = Integer.parseInt(sca.nextLine());
        double resultado;
        switch (operacion) {
            case 1 -> {
                resultado = operando1 + operando2;
                System.out.println("Resultado de la suma: " + resultado);
            }
            case 2 -> {
                resultado = operando1 - operando2;
                System.out.println("Resultado de la resta: " + resultado);
            }
            case 3 -> {
                resultado = operando1 * operando2;
                System.out.println("Resultado de la multiplicacion: " + resultado);
            }
            case 4 -> {
                if (operando2 == 0){
                    System.out.println("No se puede divir entre 0...");
                }else {
                    resultado = operando1 / operando2;
                    System.out.println("El resultado de la division en: " + resultado);
                }
            }
            default -> {
                System.out.println("Opcion erronea: " + operacion);
            }
        }
    }
}