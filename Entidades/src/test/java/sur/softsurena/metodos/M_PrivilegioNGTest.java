package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Privilegio;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_PrivilegioNGTest {

    public M_PrivilegioNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        Conexion.getInstance(
                "jhironsel",
                "1",
                "SoftSurena.db",
                "localhost",
                "3050"
        );
        assertTrue(
                Conexion.verificar().getEstado(),
                "Error al conectarse..."
        );
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        Conexion.getCnn().close();
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
                          Metodo que realiza las pruebas de los privilegios del
                          sistema, este consulta todos los permisos que estan
                          siendo usado en el sistema.
                          """
    )
    public void testPrivilegio() {
        boolean result = M_Privilegio.privilegio(
                Privilegio
                                .builder()
                                .privilegio(
                                        Privilegio.PRIVILEGIO_SELECT
                                )
                                .nombre_relacion("V_PRODUCTOS")
                                .build()
        );
        assertTrue(result, "No se tiene acceso a V_PRODUCTOS");
        //----------------------------------------------------------------------
        result = M_Privilegio.privilegio(
                Privilegio
                        .builder()
                        .privilegio(
                                Privilegio.PRIVILEGIO_SELECT
                        )
                        .nombre_relacion("V_TURNOS")
                        .build()
        );
        assertTrue(result, "No se tiene acceso a V_TURNOS");
        //----------------------------------------------------------------------
        result = M_Privilegio.privilegio(
                Privilegio
                        .builder()
                        .privilegio(
                                Privilegio.PRIVILEGIO_SELECT
                        )
                        .nombre_relacion("V_PERSONAS_CLIENTES")
                        .build()
        );
        assertTrue(result, "No se tiene acceso a V_PERSONAS_CLIENTES");
        //----------------------------------------------------------------------
        result = M_Privilegio.privilegio(
                Privilegio
                        .builder()
                        .privilegio(
                                Privilegio.PRIVILEGIO_SELECT
                        )
                        .nombre_relacion("V_CATEGORIAS")
                        .build()
        );
        assertTrue(result, "No se tiene acceso a V_CATEGORIAS");
        //----------------------------------------------------------------------
        result = M_Privilegio.privilegio(
                Privilegio
                        .builder()
                        .privilegio(
                                Privilegio.PRIVILEGIO_SELECT
                        )
                        .nombre_relacion("V_M_FACTURAS")
                        .build()
        );
        assertTrue(result, "No se tiene acceso a V_M_FACTURAS");
        //----------------------------------------------------------------------
        result = M_Privilegio.privilegio(
                Privilegio
                        .builder()
                        .privilegio(
                                Privilegio.PRIVILEGIO_SELECT
                        )
                        .nombre_relacion("V_PRECIOS")
                        .build()
        );
        assertTrue(result, "No se tiene acceso a V_PRECIOS");
        //----------------------------------------------------------------------
        result = M_Privilegio.privilegio(
                Privilegio
                        .builder()
                        .privilegio(
                                Privilegio.PRIVILEGIO_SELECT
                        )
                        .nombre_relacion("V_TURNOS")
                        .build()
        );
        assertTrue(result, "No se tiene acceso a V_TURNOS");
        //----------------------------------------------------------------------
    }

}
