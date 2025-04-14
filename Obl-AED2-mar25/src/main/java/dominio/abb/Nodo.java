package dominio.abb;

public class Nodo <T extends Comparable<T> > {
    private T dato;
    private Nodo <T>  izq;
    private Nodo <T> der;

    public Nodo(T dato) {
        this.dato = dato;
    }

    public Nodo(T dato, Nodo<T>  izq, Nodo<T>  der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
}