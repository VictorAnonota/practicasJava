package mundopc;

import mundopc.modelo.Computadora;
import mundopc.modelo.Monitor;
import mundopc.modelo.Raton;
import mundopc.modelo.Teclado;
import mundopc.servicio.Orden;

public class VentaComputadorasApp {
    public static void main(String[] args) {
        //Crear objeto
        Raton ratronLenovo = new Raton("USB","Lenovo");
        //System.out.println(ratronLenovo);
        Teclado tecladoLenovo = new Teclado("Bluetoohth","Lenovo");
        //System.out.println(tecladoLenovo);
        Monitor monitorLenovo = new Monitor("Lenovo",27);
        //System.out.println(monitorLenovo);
        //Crear objeto tipo Computadora
        Computadora computadoraLenovo = new Computadora("Lenovo",monitorLenovo,tecladoLenovo,ratronLenovo );
        System.out.println(computadoraLenovo);

        // Objeto computadora
        Monitor monitorDell = new Monitor("Dell",15);
        Teclado tecladoDell = new Teclado("usb", "Dell");
        Raton ratonDell = new Raton("usb", "Dell");
        Computadora computadoraDell = new Computadora("Dell", monitorDell, tecladoDell, ratonDell);

        //Creamos una orden
        Orden orden1 = new Orden();
        orden1.agregarComputadora(computadoraLenovo);
        orden1.agregarComputadora(computadoraDell);
        orden1.mostrarOrden();

        //Computadora Mac
        Monitor monitorMac = new Monitor("Mac",27);
        Teclado tecladoMac = new Teclado("Bluetooth", "Mac");
        Raton ratonMac = new Raton("Bluetooth", "iMac");
        Computadora computadoraMac = new Computadora("iMac", monitorMac, tecladoMac, ratonMac);

        //Orden 2
        Orden orden2 = new Orden();
        orden2.agregarComputadora(computadoraMac);
        orden2.agregarComputadora(computadoraDell);
        orden2.agregarComputadora(computadoraLenovo);
        System.out.println();
        orden2.mostrarOrden();
    }
}
