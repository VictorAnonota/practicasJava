package biblioteca;

public class Libro {
    private String titulo;
    private String autor;
    private int publicacion;
    private boolean disponible;

    public Libro(String titulo, String autor, int publicacion){
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.disponible = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void presentarse(){
        if (disponible){
            disponible = false;
            System.out.println("El libro "+titulo+" ha sido prestado");
        }else{
            System.out.println("El libro "+titulo+" no esta disponible");
        }
    }
    public void dvolver(){
        if (!disponible){
            disponible = true;
            System.out.println("El libro "+titulo+" ha sido devuelto");
        }else {
            System.out.println("El libro "+titulo+" ya esta disponible");
        }
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", publicacion=" + publicacion +
                ", disponible=" + (disponible ? "si" : "no") + '}';
    }
}
