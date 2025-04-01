package sur.softsurena.metodos;

import java.math.BigDecimal;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Deuda;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_DeudaNGTest {

    private Integer idDeuda;

    public M_DeudaNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        Conexion.getInstance(
                "sysdba",
                "1",
                "SoftSurena.db",
                "localhost",
                "3050",
                "NONE"
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
                          """
    )
    public void testSqlGetDeudas() {
        assertEquals(
                M_Deuda.sqlGetDeudas(
                        Deuda
                                .builder()
                                .build()
                ),
                """
                SELECT ID, ID_CLIENTE, CONCEPTO, MONTO, FECHA, HORA, ESTADO
                FROM V_M_DEUDAS
                """.trim().strip()
        );
        //----------------------------------------------------------------------
        assertEquals(
                M_Deuda.sqlGetDeudas(
                        Deuda
                                .builder()
                                .id(0)
                                .build()
                ),
                """
                    SELECT ID, ID_CLIENTE, CONCEPTO, MONTO, FECHA, HORA, ESTADO
                    FROM V_M_DEUDAS
                    WHERE ID = 0
                    """.trim().strip()
        );
        //----------------------------------------------------------------------
        assertEquals(
                M_Deuda.sqlGetDeudas(
                        Deuda
                                .builder()
                                .idCliente(0)
                                .build()
                ),
                """
                    SELECT ID, ID_CLIENTE, CONCEPTO, MONTO, FECHA, HORA, ESTADO
                    FROM V_M_DEUDAS
                    WHERE ID_CLIENTE = 0
                    """.trim().strip()
        );
    }
    
//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 1,
            description = """
                          Por el momento la tabla de deudas contiene registros.
                          """
    )
    public void testSelect() {
        assertNotNull(
                M_Deuda.select(
                        Deuda
                                .builder()
                                .build()
                ),
                "La tabla de deuda esta vacia."
        );
        assertNotNull(
                M_Deuda.select(
                        Deuda
                                .builder()
                                .id(0)
                                .build()
                ),
                "La tabla de deuda esta vacia."
        );
        assertNotNull(
                M_Deuda.select(
                        Deuda
                                .builder()
                                .idCliente(0)
                                .build()
                ),
                "La tabla de deuda esta vacia."
        );
    }
//------------------------------------------------------------------------------

    @Test(
            enabled = true,
            priority = 2,
            description = """
                          Prueba que realiza una insersion a la tabla de deuda.
                          """
    )
    public void testInsert() {
        M_PersonaNGTest.testInsert();

        Resultado result = M_Deuda.insert(
                Deuda
                        .builder()
                        .idCliente(M_PersonaNGTest.persona(true).getIdPersona())
                        .concepto("Sistema de prueba de deuda en registros.")
                        .monto(
                                BigDecimal.valueOf(2300.55)
                        )
                        .build()
        );
        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje("Registro de deuda exitoso.")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                "Falla de prueba de Insercion de deuda."
        );

        idDeuda = result.getId();
    }

//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 3,
            description = ""
    )
    public void testUpdate() {

        assertEquals(M_Deuda.update(
                Deuda
                        .builder()
                        .id(idDeuda)
                        .concepto("Ha sido modificado el registro de la prueba de deuda.")
                        .monto(BigDecimal.valueOf(23000.55))
                        .build()
        ),
                Resultado
                        .builder()
                        .mensaje("Operación realizada correctamente.!!!")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                "Falla de prueba de actualizacion de deuda."
        );
    }
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 4,
            description = """
                          """
    )
    public void testDelete() {

        assertEquals(M_Deuda.delete(
                Deuda
                        .builder()
                        .id(idDeuda)
                        .build()
        ),
                Resultado
                        .builder()
                        .mensaje("Operación realizada correctamente.!!!")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

}
