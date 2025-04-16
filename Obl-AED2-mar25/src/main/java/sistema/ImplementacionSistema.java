package sistema;

import interfaz.*;

public class ImplementacionSistema implements Sistema  {
    @Override
    public Retorno inicializarSistema(int maxCiudades) {
        if(maxCiudades <= 4){
            return Retorno.error1("Error en max ciudades");
        }

        // esto es una prueba
        // esta es otra prueba
        // esta es una prueba nueva pq la anterior valio madre
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarViajero(String cedula, String nombre, String correo, int edad, Categoria categoria) {
        if(cedula == null || cedula.isBlank() || nombre ==null || nombre.isBlank() || correo == null || correo.isBlank()
                || categoria == null ){
            return Retorno.error1("Los parametros no pueden estar vacios 02.");
        }else if(edad < 0 || edad > 139){
            return Retorno.error4("La edad del viajero tiene que estar dentro de los parametros permitidos");
        }
        return Retorno.noImplementada();
    }

    @Override
    public Retorno buscarViajeroPorCedula(String cedula) {
        if(cedula == null || cedula.isBlank()){
            return Retorno.error1("La cedula es obligatoria.");
        }
        return Retorno.noImplementada();
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

        int posArroba = 0;
        int posPunto = 0;

        for (int i = 0; i < correo.length(); i++) {
            if (correo.charAt(i) == '@') {
                posArroba = correo.charAt(i);
            }
            if(correo.charAt(i) == '.'){
                posPunto = correo.charAt(i);
            }
        }

        if(posArroba == 0 || posPunto == 0 || posArroba == correo.length() || posPunto == correo.length()){ //Para validar que el corre no arraque ni termine con @ o .
            return false;
        }
        return true;
    }

}
