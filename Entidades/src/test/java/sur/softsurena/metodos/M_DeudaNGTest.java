package sur.softsurena.metodos;

import java.math.BigDecimal;
import java.sql.ResultSet;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Deuda;
import sur.softsurena.utilidades.FiltroBusqueda;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_DeudaNGTest {

    public M_DeudaNGTest() {
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
    
//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Por el momento la tabla de deudas contiene registros.
                          """
    )
    public void testGetDeudas() {
        assertFalse(
                M_Deuda.getDeudas(
                        FiltroBusqueda
                                .builder()
                                .build()
                ).isEmpty(),
                "La tabla de deuda esta vacia."
        );
    }
    
//------------------------------------------------------------------------------
    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testModificarDeuda() {
        
        Resultado expResult = null;
        Resultado result = M_Deuda.modificarDeuda(
                Deuda
                        .builder()
                        .id_deuda(0)
                        .concepto("")
                        .monto(BigDecimal.ONE)
                        .build()
        );
        assertEquals(result, expResult);
    }
//------------------------------------------------------------------------------
    //TODO 28/11/2024 terminar esta prueba en el sistema.
    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testInsertDeudas() {
        Deuda miDeuda = null;
        boolean expResult = false;
        Resultado result = M_Deuda.insertDeudas(miDeuda);
        assertEquals(result, expResult);
    }
//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testSqlGetDeudas() {
        String expResult = """
                           SELECT ID, ID_CLIENTE, CONCEPTO, MONTO, FECHA, HORA,
                           ESTADO, P_NOMBRE, S_NOMBRE, APELLIDOS, CEDULA
                           FROM GET_DEUDAS
                           """;
        String result = M_Deuda.sqlGetDeudas(
                FiltroBusqueda
                        .builder()
                        .build()
        );
        assertEquals(result, expResult.trim().strip());
        //----------------------------------------------------------------------
        expResult = """
                    SELECT ID, ID_CLIENTE, CONCEPTO, MONTO, FECHA, HORA,
                    ESTADO, P_NOMBRE, S_NOMBRE, APELLIDOS, CEDULA
                    FROM GET_DEUDAS
                    WHERE ID = 0
                    """;
        result = M_Deuda.sqlGetDeudas(
                FiltroBusqueda
                        .builder()
                        .id(0)
                        .build()
        );
        assertEquals(result, expResult.trim().strip());
        //----------------------------------------------------------------------        
        expResult = """
                    SELECT ID, ID_CLIENTE, CONCEPTO, MONTO, FECHA, HORA,
                    ESTADO, P_NOMBRE, S_NOMBRE, APELLIDOS, CEDULA
                    FROM GET_DEUDAS
                    WHERE CEDULA LIKE '012'
                    """;
        result = M_Deuda.sqlGetDeudas(
                FiltroBusqueda
                        .builder()
                        .criterioBusqueda("012")
                        .build()
        );
        assertEquals(result, expResult.trim().strip());
        //----------------------------------------------------------------------
    }

}
