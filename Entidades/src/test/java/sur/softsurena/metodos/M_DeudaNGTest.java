package sur.softsurena.metodos;

import java.math.BigDecimal;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Deuda;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_DeudaNGTest {

    public static Integer idDeuda, idPersona;

    @Test(
            enabled = true,
            alwaysRun = true,
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
                                .idPersona(0)
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
                          """,
            dependsOnMethods = "testSqlGetDeudas"
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
                                .idPersona(0)
                                .build()
                ),
                "La tabla de deuda esta vacia."
        );
    }
//------------------------------------------------------------------------------

    @Test(
            enabled = true,
            description = """
                          Prueba que realiza una insersion a la tabla de deuda.
                          """
    )
    public void testInsert() {
        M_PersonaNGTest.testInsert();
        idPersona = M_PersonaNGTest.idPersona;

        Resultado result = M_Deuda.insert(
                Deuda
                        .builder()
                        .idPersona(idPersona)
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
            description = """
                          """,
            dependsOnMethods = "testInsert"
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
    @Test(
            enabled = true,
            priority = 4,
            description = """
                          """,
            dependsOnMethods = {
                "testInsert",
                "testUpdate"
            }
    )
    public void testDelete() {

        assertEquals(
                M_Deuda.delete(
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
        
        M_PersonaNGTest.idPersona = idPersona;
        M_PersonaNGTest.testDelete();
    }

}
