package sur.softsurena.metodos;

import java.util.List;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.DistritoMunicipal;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_DistritoMunicipalNGTest {

    public M_DistritoMunicipalNGTest() {
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
                          Permite verificar la consultas a la bd de los datos de
                          los distritos municipales de rd. 
                          """
    )
    public void testGetDistritosMunicipales() {
        List result = M_DistritoMunicipal.select(
                DistritoMunicipal
                        .builder()
                        .id(0)
                        .build()
        );
        assertFalse(
                result.isEmpty(),
                "Registro principal no existe."
        );

        result = M_DistritoMunicipal.select(
                DistritoMunicipal
                        .builder()
                        .idMunicipio(27)
                        .build()
        );
        assertFalse(
                result.isEmpty(),
                "Registros Distritos municipales de San Juan no encontrado."
        );
    }

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testSqlSelect() {
        assertEquals(
                M_DistritoMunicipal.sqlSelect(
                        DistritoMunicipal
                                .builder()
                                .build()
                ), 
                """
                SELECT ID, ID_MUNICIPIO, NOMBRE
                FROM V_T_DISTRITOS_MUNICIPALES
                ORDER BY 1;
                """.strip()
        );
        assertEquals(
                M_DistritoMunicipal.sqlSelect(
                        DistritoMunicipal
                                .builder()
                                .id(-1)
                                .build()
                ), 
                """
                SELECT ID, ID_MUNICIPIO, NOMBRE
                FROM V_T_DISTRITOS_MUNICIPALES
                WHERE ID IN(0, -1)
                ORDER BY 1;
                """.strip()
        );
        assertEquals(
                M_DistritoMunicipal.sqlSelect(
                        DistritoMunicipal
                                .builder()
                                .idMunicipio(0)
                                .build()
                ), 
                """
                SELECT ID, ID_MUNICIPIO, NOMBRE
                FROM V_T_DISTRITOS_MUNICIPALES
                WHERE ID_MUNICIPIO = 0
                ORDER BY 1;
                """.strip()
        );
        assertEquals(
                M_DistritoMunicipal.sqlSelect(
                        DistritoMunicipal
                                .builder()
                                .id(-1)
                                .idMunicipio(0)
                                .build()
                ), 
                """
                SELECT ID, ID_MUNICIPIO, NOMBRE
                FROM V_T_DISTRITOS_MUNICIPALES
                WHERE ID IN(0, -1) OR ID_MUNICIPIO = 0
                ORDER BY 1;
                """.strip()
        );
    }

}
