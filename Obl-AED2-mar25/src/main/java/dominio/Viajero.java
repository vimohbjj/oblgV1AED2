package dominio;
import interfaz.Categoria;

public class Viajero implements Comparable<Viajero> {
    private String nombre;
    private int edad;
    private String cedula;
    private String correo;
    private Categoria categoria;

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Viajero(String cedula, String correo) {
        this.cedula = cedula;
        this.correo = correo;
    }

    public Viajero(int edad, String cedula, String correo, Categoria categoria, String nombre) {
        this.edad = edad;
        this.cedula = cedula;
        this.correo = correo;
        this.categoria = categoria;
        this.nombre = nombre;
    }

    public String toString() {
        return cedula + ";" + nombre + ";" + correo + ";" + edad + ";" + categoria ;
    }

    @Override
    public int compareTo(Viajero o) {
        return this.cedula.compareTo(o.cedula);
    }

}
