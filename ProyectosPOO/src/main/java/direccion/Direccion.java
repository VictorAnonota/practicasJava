package direccion;

public class Direccion{
    private String calle;
    private String ciudad;
    private String pais;

    public Direccion(String calle, String ciudad, String pais){
        this.calle = calle;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    @Override
    public String toString(){
        return " vive en calle "+calle+" en la Cd."+ciudad+" en el pais "+pais;
    }
}
