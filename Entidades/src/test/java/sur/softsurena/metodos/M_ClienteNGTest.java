package sur.softsurena.metodos;

import java.util.List;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.entidades.Generales;
import sur.softsurena.entidades.Paginas;
import static sur.softsurena.metodos.M_Cliente.CLIENTE_BORRADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Cliente.CLIENTE_NO_PUEDE_SER_BORRADO;
import static sur.softsurena.metodos.M_Cliente.CLIENTE__AGREGADO__CORRECTAMENTE;
import static sur.softsurena.metodos.M_Cliente.ERROR_AL_INSERTAR__CLIENTE;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_ClienteNGTest {

    public M_ClienteNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        Conexion.getInstance(
                "sysdba",
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
            description = ""
    )
    public void testAgregarClienteById() {
        M_PersonaNGTest.testInsert();

        Resultado result = M_Cliente.insertById(
                M_PersonaNGTest.persona(Boolean.FALSE).getIdPersona()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(CLIENTE__AGREGADO__CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_INSERTAR__CLIENTE
        );

    }

    @Test(
            enabled = true,
            priority = 1,
            description = """
                          Eliminamos registros del cliente de la tabla PERSONAS_CLIENTES
                          """
    )
    public void testBorrarCliente() {
        Resultado result = M_Cliente.delete(
                M_PersonaNGTest.persona(Boolean.FALSE).getIdPersona()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(CLIENTE_BORRADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                CLIENTE_NO_PUEDE_SER_BORRADO
        );

        M_PersonaNGTest.testDelete();
    }

    @Test(
            enabled = false,
            priority = 1,
            description = """
                          Eliminamos registros del cliente de la tabla PERSONAS_CLIENTES
                          """
    )
    public void testGetPersonasClientes() {
        List expResult = null;

        List result = M_Cliente.select(
                Cliente
                        .builder()
                        .build()
        );

        assertEquals(result, expResult);
    }

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Test que me permite crear distintas consultas a la 
                          Base de Datos sobre los cliente del sistema.
                          """
    )
    public void testSqlSelect() {
        assertEquals(
                M_Cliente.sqlSelect(
                        Cliente
                                .builder()
                                .build()
                ),
                """
                SELECT ID
                FROM V_PERSONAS_CLIENTES
                """.strip().trim());
//------------------------------------------------------------------------------

    }
}
