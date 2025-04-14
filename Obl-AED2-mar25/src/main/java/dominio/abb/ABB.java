package dominio.abb;

public class ABB<T extends Comparable<T>>  {
    private Nodo<T>  raiz;

    public ABB(Nodo<T>  raiz) {
        this.raiz = raiz;
    }

    public void agregar(T dato) {
        if(this.raiz == null) {
            this.raiz = new Nodo<T> (dato);
        } else {
            agregar(this.raiz, dato);
        }
    }

    public void agregar(Nodo <T> nodo, T dato){
        if(nodo.getDato().compareTo(dato) < 0){ // Derecha
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

        if(nodo.getDato().compareTo(dato) < 0){
            return existe(nodo.getDer(), dato);
        } else {
            return existe(nodo.getIzq(), dato);
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
}
