
package sistema;

import interfaz.Categoria;
import interfaz.Retorno;
import interfaz.Sistema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test03BuscarViajeroPorCedula {
    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @BeforeEach
    public void setUp() {
        s.inicializarSistema(10);
        s.registrarViajero("1.914.689-5", "Guillermo", "guille@ort.edu.uy", 35, Categoria.ESTANDAR);
    }

    @Test
    void buscarViajeroOk() {
        retorno = s.buscarViajeroPorCedula("1.914.689-5");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals(1, Retorno.ok().getValorInteger());
        assertEquals("1.914.689-5;Guillermo;guille@ort.edu.uy;35;Estándar", Retorno.ok().getValorString());
    }

    @Test
    public void buscarViajeroPorCedulaError1() {
        retorno = s.buscarViajeroPorCedula("");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.buscarViajeroPorCedula(null);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
    }

    @Test
    public void buscarViajeroPorCedulaError2() {
        retorno = s.buscarViajeroPorCedula("19146895");
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
    }

    @Test
    public void buscarViajeroPorCedulaError3() {
        retorno = s.buscarViajeroPorCedula("2.345.678-9");
        assertEquals(Retorno.Resultado.ERROR_3, retorno.getResultado());
    }
}
