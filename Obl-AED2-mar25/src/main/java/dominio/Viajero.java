package dominio;
import interfaz.Categoria;

public class Viajero implements Comparable<Viajero> {
    private String Nombre;
    private int Edad;
    private String Cedula;
    private String Correo;
    private Categoria Categoria;
    public Viajero(String cedula) {
        this.Cedula = cedula;
    }

    public String toString() {
        return Cedula + ";" + Nombre + ";" + Correo + ";" + Edad + ";" + Categoria ;
    }



    @Override
    public int compareTo(Viajero o) {
        return this.Nombre.compareTo(o.Nombre);
    }

}
