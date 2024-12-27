package sur.softsurena.metodos;

import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Antecedente;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
public class M_AntecedenteNGTest {

    public M_AntecedenteNGTest() {
    }
//------------------------------------------------------------------------------
    @BeforeClass
    public void setUpClass() throws Exception {
    }
//------------------------------------------------------------------------------
    @AfterClass
    public void tearDownClass() throws Exception {
    }
//------------------------------------------------------------------------------
    @BeforeMethod
    public void setUpMethod() throws Exception {
    }
//------------------------------------------------------------------------------
    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
//------------------------------------------------------------------------------    
    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testSqlSelect() {
        String expResult = """
                           SELECT ID, ID_CONSULTA, DESCRIPCION 
                           FROM V_ANTECEDENTES
                           """;
        assertEquals(
                M_Antecedente.sqlSelect(
                        Antecedente
                                .builder()
                                .build()
                ),
                expResult.trim().strip()
        );

        expResult = """
                    SELECT ID, ID_CONSULTA, DESCRIPCION 
                    FROM V_ANTECEDENTES
                    WHERE ID = -1
                    """;

        assertEquals(
                M_Antecedente.sqlSelect(
                        Antecedente
                                .builder()
                                .id(-1)
                                .build()
                ),
                expResult.trim().strip()
        );

        expResult = """
                    SELECT ID, ID_CONSULTA, DESCRIPCION 
                    FROM V_ANTECEDENTES
                    WHERE ID_CONSULTA = -1
                    """;

        assertEquals(
                M_Antecedente.sqlSelect(
                        Antecedente
                                .builder()
                                .id_consulta(-1)
                                .build()
                ),
                expResult.trim().strip()
        );

        expResult = """
                    SELECT ID, ID_CONSULTA, DESCRIPCION 
                    FROM V_ANTECEDENTES
                    WHERE ID = -1 AND ID_CONSULTA = -1
                    """;

        assertEquals(
                M_Antecedente.sqlSelect(
                        Antecedente
                                .builder()
                                .id(-1)
                                .id_consulta(-1)
                                .build()
                ),
                expResult.trim().strip()
        );
    }
//------------------------------------------------------------------------------
    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testSelect() {
        List expResult = null;
        List result = M_Antecedente.select(
                Antecedente
                        .builder()
                        .build()
        );
        assertEquals(result, expResult);
    }
//------------------------------------------------------------------------------

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testInsert() {
        Antecedente antecedente = null;
        Resultado expResult = null;
        Resultado result = M_Antecedente.insert(antecedente);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testUpdate() {
        Antecedente antecedente = null;
        Resultado expResult = null;
        Resultado result = M_Antecedente.update(antecedente);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testDelete() {
        Antecedente antecedente = null;
        Resultado expResult = null;
        Resultado result = M_Antecedente.delete(antecedente);
        assertEquals(result, expResult);
    }

}
