package sur.softsurena.utilidades;

import java.util.Objects;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

    public ParametrosConexionNGTest() {
        System.out.println("sur.softsurena.utilidades.ParametrosConexionNGTest.<init>()");
    }

    @BeforeClass
    public void setUpClass() throws Exception {
    }

    @AfterClass
    public void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Obteniendo la instancia de la clase.
                          """
    )
    public void testGetInstance() {
        System.out.println("sur.softsurena.utilidades.ParametrosConexionNGTest.testGetInstance()");
        
        this.parametros = ParametrosConexion.getInstance();
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
        System.out.println("sur.softsurena.utilidades.ParametrosConexionNGTest.testCargarParamentos()");
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
        System.out.println("sur.softsurena.utilidades.ParametrosConexionNGTest.testEscribirParametros()");
        
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
