package sur.softsurena.metodos;

import java.sql.SQLException;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Metrica;
import sur.softsurena.utilidades.FiltroBusqueda;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_MetricaNGTest {

    public M_MetricaNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws SQLException {
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
    public void tearDownClass() throws SQLException{
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
                          Test que realiza las consultas a la tabla de metrica.
                          """
    )
    public void testSqlSelect() {
        String expResult = """
                           SELECT ID, ID_CONSULTA, FECHA, PESOKG, ESTATURAMETRO, ESCEFALO,
                            ENF_DETECT, HALLAZGOS_POS, ID_DIAG, TX, COMPLEMENTO,
                            IMAGEN_TEXTO, USER_NAME
                           FROM V_METRICAS
                           """;

        assertEquals(
                M_Metrica.sqlSelect(
                        FiltroBusqueda
                                .builder()
                                .build()
                ),
                expResult.trim().strip()
        );

        expResult = """
                    SELECT ID, ID_CONSULTA, FECHA, PESOKG, ESTATURAMETRO, ESCEFALO,
                     ENF_DETECT, HALLAZGOS_POS, ID_DIAG, TX, COMPLEMENTO,
                     IMAGEN_TEXTO, USER_NAME
                    FROM V_METRICAS
                    WHERE ID_CONSULTA = -1
                    """;

        assertEquals(
                M_Metrica.sqlSelect(
                        FiltroBusqueda
                                .builder()
                                .id(-1)
                                .build()
                ),
                expResult.trim().strip()
        );
    }
    
//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 1,
            description = ""
    )
    public void testSelect() {

        assertNotNull(
                M_Metrica.sqlSelect(
                        FiltroBusqueda
                                .builder()
                                .build()
                ),
                "Error al consultar la tabla de Metricas.");
    }
    
//------------------------------------------------------------------------------
    @Test(
            enabled = false,
            priority = 2,
            description = ""
    )
    public void testInsert() {
        //TODO 12/12/2024 agregar los datos a este objecto metrica
        M_Metrica.insert(
                Metrica
                        .builder()
                        .build()
        );
    }
    
//------------------------------------------------------------------------------
    @Test(
            enabled = false,
            priority = 3,
            description = """
                          """
    )
    public void testUdapte() {
        Metrica metrica = null;
        Resultado expResult = null;
        Resultado result = M_Metrica.udapte(metrica);
        assertEquals(result, expResult);
    }
    
//------------------------------------------------------------------------------
    @Test(
            enabled = false,
            priority = 4,
            description = ""
    )
    public void testDelete() {
        Metrica metrica = null;
        Resultado expResult = null;
        Resultado result = M_Metrica.delete(metrica);
        assertEquals(result, expResult);
    }
    
//------------------------------------------------------------------------------
    @Test(
            enabled = false,
            priority = 5,
            description = """
                          """
    )
    public void testDeleteByIdConsulta() {
        Metrica metrica = null;
        Resultado expResult = null;
        Resultado result = M_Metrica.deleteByIdConsulta(metrica);
        assertEquals(result, expResult);
    }
}
