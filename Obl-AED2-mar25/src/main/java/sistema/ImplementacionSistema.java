package sistema;

import dominio.Viajero;
import dominio.abb.ABB;
import dominio.abb.Nodo;
import interfaz.*;

public class ImplementacionSistema implements Sistema  {

    private ABB<Viajero> viajeros;
    private ABB<Viajero> viajerosPlatino;
    private ABB<Viajero> viajerosFrecuente;
    private ABB<Viajero> viajerosEstandar;
    private ABB<Viajero> viajerosRango0;
    private ABB<Viajero> viajerosRango1;
    private ABB<Viajero> viajerosRango2;
    private ABB<Viajero> viajerosRango3;
    private ABB<Viajero> viajerosRango4;
    private ABB<Viajero> viajerosRango5;
    private ABB<Viajero> viajerosRango6;
    private ABB<Viajero> viajerosRango7;
    private ABB<Viajero> viajerosRango8;
    private ABB<Viajero> viajerosRango9;
    private ABB<Viajero> viajerosRango10;
    private ABB<Viajero> viajerosRango11;
    private ABB<Viajero> viajerosRango12;
    private ABB<Viajero> viajerosRango13;
    private ABB<Viajero> viajerosRango14;

    @Override
    public Retorno inicializarSistema(int maxCiudades) {
        if(maxCiudades <= 4){
            return Retorno.error1("Error en max ciudades");
        }
            viajeros = new ABB(new Nodo(null));
            viajerosPlatino = new ABB(new Nodo(null));
            viajerosFrecuente = new ABB(new Nodo(null));
            viajerosEstandar = new ABB(new Nodo(null));
            viajerosRango0 = new ABB(new Nodo(null));
            viajerosRango1 = new ABB(new Nodo(null));
            viajerosRango2 = new ABB(new Nodo(null));
            viajerosRango3 = new ABB(new Nodo(null));
            viajerosRango4 = new ABB(new Nodo(null));
            viajerosRango5 = new ABB(new Nodo(null));
            viajerosRango6 = new ABB(new Nodo(null));
            viajerosRango7 = new ABB(new Nodo(null));
            viajerosRango8 = new ABB(new Nodo(null));
            viajerosRango9 = new ABB(new Nodo(null));
            viajerosRango10 = new ABB(new Nodo(null));
            viajerosRango11 = new ABB(new Nodo(null));
            viajerosRango12 = new ABB(new Nodo(null));
            viajerosRango13 = new ABB(new Nodo(null));
            viajerosRango14 = new ABB(new Nodo(null));

        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarViajero(String cedula, String nombre, String correo, int edad, Categoria categoria) {
        if(cedula == null || cedula.isBlank() || nombre ==null || nombre.isBlank() || correo == null || correo.isBlank()
                || categoria == null ) {
            return Retorno.error1("Los parametros no pueden estar vacios");
        } else if(!correoValido(correo)) {
            return Retorno.error3("El correo es invalido");
        }else if(edad < 0 || edad > 139){
            return Retorno.error4("La edad del viajero tiene que estar dentro de los parametros permitidos");
        } else if(viajeros.existe(new Viajero(cedula))){
            return Retorno.error5("La cedula ya existe");
        }
        return Retorno.noImplementada();
    }

    @Override
    public Retorno buscarViajeroPorCedula(String cedula) {
        if(cedula == null || cedula.isBlank()) return Retorno.error1("La cedula es obligatoria.");

        Viajero v = viajeros.traer(new Viajero(cedula));

        if(v == null) return Retorno.error3("No existe un viajero con ese cedula");

        return Retorno.ok(v.toString());
    }

    @Override
    public Retorno buscarViajeroPorCorreo(String correo) {
        if(correo == null || correo.isBlank()){
            return Retorno.error1("El correo es obligatoria.");
        }
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarViajerosPorCedulaAscendente() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarViajerosPorCedulaDescendente() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarViajerosPorCorreoAscendente() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarViajerosPorCategoria(Categoria unaCategoria) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarViajerosDeUnRangoAscendente(int rango) {
        if(rango < 0){
            return Retorno.error1("El rango no puede ser menor a 0");
        }else if(rango > 13){
            return Retorno.error2("El rango no puede ser mayor a 13.");
        }
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarCiudad(String codigo, String nombre) {
        if(codigo == null || codigo.isBlank() || nombre == null || nombre.isBlank()){
            return Retorno.error2("El nombre y el codio no pueden ser nulos");
        }
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarConexion(String codigoCiudadOrigen, String codigoCiudadDestino) {
        if(codigoCiudadOrigen == null || codigoCiudadOrigen.isBlank() || codigoCiudadDestino == null || codigoCiudadDestino.isBlank()){
            return Retorno.error1("Los codigos de la ciudad de origen y destino no pueden ser nulos");
        }
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarVuelo(String codigoCiudadOrigen, String codigoCiudadDestino, String codigoDeVuelo, double combustible, double minutos, double costoEnDolares, TipoVuelo tipoDeVuelo) {
        if(combustible <= 0 || minutos <= 0 || costoEnDolares <= 0){
            return Retorno.error1("Los parametros double no pueden ser menor a 0");
        }else if(codigoCiudadOrigen == null || codigoCiudadOrigen.isBlank() || codigoCiudadDestino == null || codigoCiudadDestino.isBlank() || codigoDeVuelo == null || codigoDeVuelo.isBlank()){
            return Retorno.error2("Los codigos de la ciudad no pueden ser nulos");
        }
        return Retorno.noImplementada();
    }

    @Override
    public Retorno actualizarVuelo(String codigoCiudadOrigen, String codigoCiudadDestino, String codigoDeVuelo, double combustible, double minutos, double costoEnDolares, TipoVuelo tipoDeVuelo) {
        if(combustible <= 0 || minutos <= 0 || costoEnDolares <= 0){
            return Retorno.error1("Los parametros double no pueden ser menor a 0");
        }else if(codigoCiudadOrigen == null || codigoCiudadOrigen.isBlank() || codigoCiudadDestino == null || codigoCiudadDestino.isBlank() || codigoDeVuelo == null || codigoDeVuelo.isBlank()){
            return Retorno.error2("Los codigos de la ciudad no pueden ser nulos");
        }
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listadoCiudadesCantDeEscalas(String codigoCiudadOrigen, int cantidad) {
        if(cantidad < 0){
            return Retorno.error1("La cantidad no puede ser menos a 0");
        }else if(codigoCiudadOrigen == null || codigoCiudadOrigen.isBlank()){
            return Retorno.error2("El codigo de la ciudad de origen es obligatorio");
        }
        return Retorno.noImplementada();
    }

    @Override
    public Retorno viajeCostoMinimoMinutos(String codigoCiudadOrigen, String codigoCiudadDestino, TipoVueloPermitido tipoVueloPermitido) {
        if(codigoCiudadOrigen == null || codigoCiudadOrigen.isBlank() || codigoCiudadDestino == null || codigoCiudadDestino.isBlank() || tipoVueloPermitido == null){
            return Retorno.error1("Todos los parametros son obligatorios");
        }
        return Retorno.noImplementada();
    }

    @Override
    public Retorno viajeCostoMinimoDolares(String codigoCiudadOrigen, String codigoCiudadDestino, TipoVueloPermitido tipoVueloPermitido) {
        if(codigoCiudadOrigen == null || codigoCiudadOrigen.isBlank() || codigoCiudadDestino == null || codigoCiudadDestino.isBlank() || tipoVueloPermitido == null){
            return Retorno.error1("Todos los parametros son obligatorios");
        }
        return Retorno.noImplementada();
    }


    private boolean correoValido(String correo){
        if (correo == null || correo.isBlank()) {
            return false;
        }

        int posArroba = -1;
        int posPunto = -1;

        for (int i = 0; i < correo.length(); i++) {
            if (correo.charAt(i) == '@') {
                posArroba = i;
            }
            if(correo.charAt(i) == '.'){
                posPunto = i;
            }
        }

        //Para validar que el corre no arraque ni termine con @ o
        return posArroba > 0 && posPunto > 0 && posArroba != correo.length()-1 && posPunto != correo.length()-1;
    }

}
