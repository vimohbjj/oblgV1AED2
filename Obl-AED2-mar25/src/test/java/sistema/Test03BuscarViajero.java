
package sistema;

import interfaz.Categoria;
import interfaz.Retorno;
import interfaz.Sistema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test03BuscarViajero {
    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @BeforeEach
    public void setUp() {
        s.inicializarSistema(10);
    }

    @Test
    void buscarViajeroOk() {
        s.registrarViajero("1.914.689-5", "Guillermo", "guille@ort.edu.uy", 35, Categoria.ESTANDAR);
        retorno = s.buscarViajeroPorCedula("1.914.689-5");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals(1, Retorno.ok().getValorInteger());
        assertEquals("1.914.689-5;Guillermo;guille@ort.edu.uy;35;Estándar", Retorno.ok().getValorString());
    }

}
