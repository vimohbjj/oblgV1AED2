package abb;
import java.util.Comparator;
    public class ABB<T extends Comparable<T>> {
        private Nodo<T> raiz;

        public ABB(){
            this.raiz = null;
        }

        public void agregar(T dato) {
            if (raiz == null) {
                raiz = new Nodo<>(dato);
            } else {
                agregarRec(raiz, dato);
            }
        }

        private void agregarRec(Nodo<T> nodo, T dato) {
            if (nodo.getDato().compareTo(dato) < 0) { //nodo.getDato < dato  --> Derecha
                if (nodo.getDer() == null) {
                    nodo.setDer(new Nodo<>(dato));
                } else {
                    agregarRec(nodo.getDer(), dato);
                }
            } else {
                if (nodo.getIzq() == null) {
                    nodo.setIzq(new Nodo<>(dato));
                } else {
                    agregarRec(nodo.getIzq(), dato);
                }
            }
        }

        public boolean existe(T dato){
            return existeRec(raiz,dato);
        }

        private boolean existeRec(Nodo<T> nodo, T dato){
            if(nodo == null){
                return false; //Ver si es true o false
            }

            if(nodo.getDato().equals(dato)){ //Si el nodo es el que estoy buscando
                return true;
            }

            if(nodo.getDato().compareTo(dato) < 0){ //Si el dato es mas grande que el .getDato
                return existeRec(nodo.getDer(), dato);
            }else{
                return existeRec(nodo.getIzq(), dato);
            }
        }

        public T obtener(T dato){
            return obtenerRec(raiz,dato);
        }

        private T obtenerRec(Nodo<T> nodo, T dato){
            if(nodo == null){
                return null; //Ver si es true o false
            }

            if(nodo.getDato().equals(dato)){ //Si el nodo es el que estoy buscando
                return nodo.getDato();
            }

            if(nodo.getDato().compareTo(dato) < 0){ //Si el dato es mas grande que el .getDato
                return obtenerRec(nodo.getDer(), dato);
            }else{
                return obtenerRec(nodo.getIzq(), dato);
            }
        }
/*
        public void mostrarCreciente() {
            mostrarCrecienteRec(raiz);
        }

        private void mostrarCrecienteRec(Nodo<T> nodo) {
            if(nodo != null){
                mostrarCrecienteRec(nodo.getIzq());
                System.out.println(nodo.getDato());
                mostrarCrecienteRec(nodo.getDer());
            }
        }
*/
        /*
        public Lista<T> aplanarCreciente(){
            Lista<T> lista = new ListaImp<>();
            aplanarRecCreciente(raiz, lista); //Este metodo recibe una lista por valor
            return lista;
        }

        public void aplanarRecCreciente(Nodo<T> nodo, Lista<T> listaAux){
            if(nodo != null){
                aplanarRecCreciente(nodo.getIzq(), listaAux);
                listaAux.insertar(nodo.getDato());//Para que sea creciente este
                aplanarRecCreciente(nodo.getDer(), listaAux);

            }
        }

        public Lista<T> aplanarDecreciente(){
            Lista<T> lista = new ListaImp<>();
            aplanarRecDecreciente(raiz, lista); //Este metodo recibe una lista por valor
            return lista;
        }

        public void aplanarRecDecreciente(Nodo<T> nodo, Lista<T> listaAux){
            if(nodo != null){
                aplanarRecDecreciente(nodo.getIzq(), listaAux);
                listaAux.insertar(nodo.getDato());//Para que sea creciente este
                aplanarRecDecreciente(nodo.getDer(), listaAux);

            }
        }*/
}
