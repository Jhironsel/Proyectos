package sur.softsurena.utilidades;

import java.util.Objects;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(
        priority = 2
)
public class ParametrosConexionNGTest {

    private ParametrosConexion parametros;
    private boolean parametrosNulo;

    @Test(
            enabled = true
    )
    public void testGetInstance() {
        
        this.parametros = new ParametrosConexion();
        assertNotNull(
                this.parametros,
                "No puede realizarse la instancia de la clase."
        );
    }

    @Test(
            enabled = true,
            priority = 1,
            description = """
                          Cargando los datos....
                          """
    )
    public void testCargarParamentos() {
        Servidor result = parametros.cargarParamentos();

        if (Objects.nonNull(result)) {
            parametrosNulo = false;
            return;
        }
        parametrosNulo = true;
    }

    @Test(
            enabled = false,
            priority = 2,
            description = """
                          Escribiendo los datos.
                          """
    )
    public void testEscribirParametros() {
        
        if (parametrosNulo) {

            parametros.escribirParametros(
                    Servidor
                    .builder()
                    .host("localhost")
                    .puerto("3050")
                    .pathBaseDatos("SoftSurena.db")
                    .build()
            );
        }
        assertTrue(
                parametrosNulo,
                "No pudo escribirse los parametros."
        );
    }

}
