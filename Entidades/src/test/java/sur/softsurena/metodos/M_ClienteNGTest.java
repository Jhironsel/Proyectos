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
import static sur.softsurena.metodos.M_Cliente.CLIENTE_BORRADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Cliente.CLIENTE_NO_PUEDE_SER_BORRADO;
import static sur.softsurena.metodos.M_Cliente.CLIENTE__AGREGADO__CORRECTAMENTE;
import static sur.softsurena.metodos.M_Cliente.ERROR_AL_INSERTAR__CLIENTE;
import static sur.softsurena.metodos.M_Cliente.agregarClienteById;
import static sur.softsurena.metodos.M_Cliente.borrarCliente;
import sur.softsurena.utilidades.FiltroBusqueda;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_ClienteNGTest {

    private final M_PersonaNGTest persona;

    public M_ClienteNGTest() {
        persona = new M_PersonaNGTest();
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
        persona.testAgregarEntidad();

        Resultado result = agregarClienteById(
                M_PersonaNGTest.persona().getId_persona()
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
        Resultado result = borrarCliente(
                M_PersonaNGTest.persona().getId_persona()
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

        persona.testEliminarEntidad();
    }

    @Test(
            enabled = false,
            priority = 1,
            description = """
                          Eliminamos registros del cliente de la tabla PERSONAS_CLIENTES
                          """
    )
    public void testGetPersonasClientes() {
        System.out.println("getPersonasClientes");
        FiltroBusqueda filtro = null;
        List expResult = null;
        List result = M_Cliente.getPersonasClientes(filtro);
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
    public void testSqlPersonaClientes() {
        String expResult = """
                    SELECT
                        ID, CEDULA, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS,
                        SEXO, FECHA_NACIMIENTO, ESTADO_CIVIL,
                        FECHA_INGRESO, ESTADO
                    FROM GET_PERSONA_CLIENTES
                    WHERE ID = 32  
                    """;

        String result = M_Cliente.sqlPersonaClientes(
                FiltroBusqueda
                        .builder()
                        .id(Integer.SIZE)
                        .build()
        );
        assertEquals(result.strip().trim(), expResult.strip().trim());
//------------------------------------------------------------------------------
        expResult = """
                           SELECT
                               ID, CEDULA, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS,
                               SEXO, FECHA_NACIMIENTO, ESTADO_CIVIL,
                               FECHA_INGRESO, ESTADO
                           FROM GET_PERSONA_CLIENTES
                           WHERE ID = 32 AND ESTADO IS FALSE
                           """;
        result = M_Cliente.sqlPersonaClientes(
                FiltroBusqueda
                        .builder()
                        .id(Integer.SIZE)
                        .estado(Boolean.FALSE)
                        .build()
        );
        assertEquals(result.strip().trim(), expResult.strip().trim());

//------------------------------------------------------------------------------
        expResult = """
                    SELECT
                        ID, CEDULA, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS,
                        SEXO, FECHA_NACIMIENTO, ESTADO_CIVIL,
                        FECHA_INGRESO, ESTADO
                    FROM GET_PERSONA_CLIENTES
                    WHERE ID = 32 AND ESTADO
                    """;

        result = M_Cliente.sqlPersonaClientes(
                FiltroBusqueda
                        .builder()
                        .id(Integer.SIZE)
                        .estado(Boolean.TRUE)
                        .build()
        );
        assertEquals(result.strip().trim(), expResult.strip().trim());

//------------------------------------------------------------------------------
        expResult = """
                    SELECT
                        ID, CEDULA, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS,
                        SEXO, FECHA_NACIMIENTO, ESTADO_CIVIL,
                        FECHA_INGRESO, ESTADO
                    FROM GET_PERSONA_CLIENTES
                    """;

        result = M_Cliente.sqlPersonaClientes(
                FiltroBusqueda
                        .builder()
                        .build()
        );
        assertEquals(result.strip().trim(), expResult.strip().trim());
        
//------------------------------------------------------------------------------
        expResult = """
                    SELECT
                        ID, CEDULA, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS,
                        SEXO, FECHA_NACIMIENTO, ESTADO_CIVIL,
                        FECHA_INGRESO, ESTADO
                    FROM GET_PERSONA_CLIENTES
                    """;

        result = M_Cliente.sqlPersonaClientes(
                FiltroBusqueda
                        .builder()
                        .filas(Boolean.FALSE)
                        .build()
        );
        assertEquals(result.strip().trim(), expResult.strip().trim());
        
//------------------------------------------------------------------------------
        expResult = """
                    SELECT
                        ID, CEDULA, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS,
                        SEXO, FECHA_NACIMIENTO, ESTADO_CIVIL,
                        FECHA_INGRESO, ESTADO
                    FROM GET_PERSONA_CLIENTES
                    ROWS (1 - 1) * 20 + 1 TO (1 + (1 - 1)) * 20;
                    """;

        result = M_Cliente.sqlPersonaClientes(
                FiltroBusqueda
                        .builder()
                        .filas(Boolean.TRUE)
                        .nPaginaNro(1)
                        .nCantidadFilas(20)
                        .build()
        );
        assertEquals(result.strip().trim(), expResult.strip().trim());
        
//------------------------------------------------------------------------------
        expResult = """
                    SELECT
                        ID, CEDULA, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS,
                        SEXO, FECHA_NACIMIENTO, ESTADO_CIVIL,
                        FECHA_INGRESO, ESTADO
                    FROM GET_PERSONA_CLIENTES
                    WHERE ESTADO ROWS (1 - 1) * 20 + 1 TO (1 + (1 - 1)) * 20;
                    """;

        result = M_Cliente.sqlPersonaClientes(
                FiltroBusqueda
                        .builder()
                        .estado(Boolean.TRUE)
                        .filas(Boolean.TRUE)
                        .nPaginaNro(1)
                        .nCantidadFilas(20)
                        .build()
        );
        assertEquals(result.strip().trim(), expResult.strip().trim());
        
//------------------------------------------------------------------------------
        expResult = """
                    SELECT
                        ID, CEDULA, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS,
                        SEXO, FECHA_NACIMIENTO, ESTADO_CIVIL,
                        FECHA_INGRESO, ESTADO
                    FROM GET_PERSONA_CLIENTES
                    WHERE CEDULA LIKE '00' 
                    OR PNOMBRE LIKE '00'
                    OR SNOMBRE LIKE '00'
                    OR APELLIDOS LIKE '00'
                    """;

        result = M_Cliente.sqlPersonaClientes(
                FiltroBusqueda
                        .builder()
                        .criterioBusqueda("00")
                        .build()
        );
        assertEquals(result.strip().trim(), expResult.strip().trim());
//------------------------------------------------------------------------------
        expResult = """
                    SELECT
                        ID, CEDULA, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS,
                        SEXO, FECHA_NACIMIENTO, ESTADO_CIVIL,
                        FECHA_INGRESO, ESTADO
                    FROM GET_PERSONA_CLIENTES
                    WHERE ESTADO AND CEDULA LIKE '00' 
                    OR PNOMBRE LIKE '00'
                    OR SNOMBRE LIKE '00'
                    OR APELLIDOS LIKE '00'
                    """;

        result = M_Cliente.sqlPersonaClientes(
                FiltroBusqueda
                        .builder()
                        .estado(Boolean.TRUE)
                        .criterioBusqueda("00")
                        .build()
        );
        assertEquals(result.strip().trim(), expResult.strip().trim());

//------------------------------------------------------------------------------
        expResult = """
                    SELECT
                        ID, CEDULA, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS,
                        SEXO, FECHA_NACIMIENTO, ESTADO_CIVIL,
                        FECHA_INGRESO, ESTADO
                    FROM GET_PERSONA_CLIENTES
                    WHERE ESTADO IS FALSE AND CEDULA LIKE '00' 
                    OR PNOMBRE LIKE '00'
                    OR SNOMBRE LIKE '00'
                    OR APELLIDOS LIKE '00'
                    """;

        result = M_Cliente.sqlPersonaClientes(
                FiltroBusqueda
                        .builder()
                        .estado(Boolean.FALSE)
                        .criterioBusqueda("00")
                        .build()
        );
        assertEquals(result.strip().trim(), expResult.strip().trim());
    }
}
