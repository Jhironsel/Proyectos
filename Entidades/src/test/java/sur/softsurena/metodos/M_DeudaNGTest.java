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
import sur.softsurena.abstracta.Persona;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.entidades.Deuda;
import sur.softsurena.entidades.Generales;
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
                                .cliente(
                                        Cliente
                                                .builder()
                                                .persona(
                                                        Persona.builder().build()
                                                )
                                                .build()
                                )
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
                        .cliente(
                                Cliente
                                        .builder()
                                        .persona(
                                                M_PersonaNGTest.persona(true)
                                        )
                                        .build()
                        )
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

        assertEquals(
                M_Deuda.update(
                        Deuda
                                .builder()
                                .id_deuda(idDeuda)
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
                Deuda
                        .builder()
                        .cliente(
                                Cliente
                                        .builder()
                                        .persona(
                                                Persona
                                                        .builder()
                                                        .build()
                                        )
                                        .build()
                        )
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
                Deuda
                        .builder()
                        .cliente(
                                Cliente
                                        .builder()
                                        .persona(
                                                Persona
                                                        .builder()
                                                        .build()
                                        )
                                        .build()
                        )
                        .id_deuda(0)
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
                Deuda
                        .builder()
                        .cliente(
                                Cliente
                                        .builder()
                                        .persona(
                                                Persona
                                                        .builder()
                                                        .generales(
                                                                Generales
                                                                        .builder()
                                                                        .cedula("012")
                                                                        .build())
                                                        .build()
                                        )
                                        .build()
                        )
                        .build()
        );
        assertEquals(result, expResult.trim().strip());
    }

//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 4,
            description = """
                          """
    )
    public void testDelete() {

        assertEquals(
                M_Deuda.delete(
                        Deuda
                                .builder()
                                .id_deuda(idDeuda)
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
