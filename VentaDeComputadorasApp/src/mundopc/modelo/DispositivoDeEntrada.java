package mundopc.modelo;

public class DispositivoDeEntrada {
    private String tipoEntrada;
    private String marca;

    //Constructor
    public  DispositivoDeEntrada(String tipoEntrada, String marca){
        this.tipoEntrada = tipoEntrada;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "DispositivoDeEntrada{" +
                "tipoEntrada='" + tipoEntrada + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
