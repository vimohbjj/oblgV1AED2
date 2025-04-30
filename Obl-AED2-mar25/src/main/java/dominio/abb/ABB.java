package dominio.abb;

import java.util.Comparator;

public class ABB<T extends Comparable<T>>  {
    private Nodo<T>  raiz;
    private final Comparator<T> comparador;

    public ABB(){
        raiz = null;
        comparador = null;
    }

    public ABB(Comparator<T> comparador){
        raiz = null;
        this.comparador = comparador;
    }

    public ABB(Nodo<T>  raiz) {
        this.raiz = raiz;
        this.comparador = null;
    }

    public ABB(Nodo<T>  raiz, Comparator<T> comparador) {
        this.raiz = raiz;
        this.comparador = comparador;
    }

    public void agregar(T dato) {
        if(this.raiz == null) {
            this.raiz = new Nodo<T> (dato);
        } else {
            agregar(this.raiz, dato);
        }
    }

    public void agregar(Nodo <T> nodo, T dato){
        if(comparar(nodo.getDato(), dato) < 0){ // Derecha
            if(nodo.getDer() == null){ // Puedo agregar?
                nodo.setDer(new Nodo(dato));
            } else {
                agregar(nodo.getDer(), dato);
            }
        } else {
            if(nodo.getIzq() == null){ // Izquierda
                nodo.setIzq(new Nodo(dato));
            } else {
                agregar(nodo.getIzq(), dato);
            }
        }
    }

    public int comparar(T dato1, T dato2){
        if(comparador != null){
            return comparador.compare(dato1, dato2);
        }
        return dato1.compareTo(dato2);
    }

    public boolean existe(T dato){
        if(this.raiz == null) {
            return false;
        } else {
            return existe(this.raiz, dato);
        }
    }

    public boolean existe(Nodo<T>  nodo, T dato){
        if(nodo == null) {
            return false;
        }

        if(nodo.getDato().equals(dato)){
            return true;
        }

        if(comparar(nodo.getDato(), dato) < 0){
            return existe(nodo.getDer(), dato);
        } else {
            return existe(nodo.getIzq(), dato);
        }

    }

    public T obtener(T dato){
        if(this.raiz == null) {
            return null;
        } else {
            return obtenerRec(this.raiz, dato);
        }
    }

    public T obtenerRec(Nodo<T>  nodo, T dato){
        if(nodo == null) {
            return null;
        }

        if(nodo.getDato().equals(dato)){
            return nodo.getDato();
        }

        if(comparar(nodo.getDato(), dato) < 0){
            return (T) obtenerRec(nodo.getDer(), dato);
        } else {
            return (T) obtenerRec(nodo.getIzq(), dato);
        }

    }

    public void mostrarDesc(){
        mostrarDesc(this.raiz);
    }

    public void mostrarDesc(Nodo<T>  nodo){
        if(nodo != null) {
            mostrarDesc(nodo.getDer());
            System.out.println(nodo.getDato().toString() + " ");
            mostrarDesc(nodo.getIzq());
        }

    }

    public void mostrarAsc(){
        mostrarAsc(this.raiz);
    }

    public void mostrarAsc(Nodo<T>  nodo){
        if(nodo != null) {
            mostrarAsc(nodo.getIzq());
            System.out.println(nodo.getDato().toString() + " ");
            mostrarAsc(nodo.getDer());
        }
    }

    public void mostrarPorNivel(){
        mostrarPorNivelRec(this.raiz);
    }

    public void mostrarPorNivelRec(Nodo<T> nodo){
        if(nodo != null){

        }
    }
}
