package sur.softsurena.metodos;

import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Huella;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.digitalPersonal.enrollment.VerificationForm;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_HuellaNGTest {

    public M_HuellaNGTest() {
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
    public void setUpMethod() throws Exception {}

    @AfterMethod
    public void tearDownMethod() throws Exception {}

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testSelect() {
        assertNotNull(
                M_Huella.select(Huella.builder().build()), 
                "Error al consulta la tabla de huellas."
        );
        assertNotNull(
                M_Huella.select(
                        Huella
                                .builder()
                                .id(-1)
                                .build()
                ), 
                "Error al consulta la tabla de huellas."
        );
        assertNotNull(
                M_Huella.select(
                        Huella
                                .builder()
                                .idPersona(-1)
                                .build()
                ), 
                "Error al consulta la tabla de huellas."
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
                M_Huella.sqlSelect(Huella.builder().build()),
                """
                SELECT ID, ID_PERSONA, TIPO_DEDO, HUELLA
                FROM V_HUELLAS
                """.strip()
        );
        
        assertEquals(
                M_Huella.sqlSelect(Huella
                        .builder()
                        .id(11)
                        .build()
                ),
                """
                SELECT ID, ID_PERSONA, TIPO_DEDO, HUELLA
                FROM V_HUELLAS
                WHERE ID = 11
                """.strip()
        );
        
        assertEquals(
                M_Huella.sqlSelect(Huella
                        .builder()
                        .idPersona(11)
                        .build()
                ),
                """
                SELECT ID, ID_PERSONA, TIPO_DEDO, HUELLA
                FROM V_HUELLAS
                WHERE ID_PERSONA = 11
                """.strip()
        );
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testInsert() {
        Huella huella = null;
        Resultado expResult = null;
        Resultado result = M_Huella.insert(huella);
        assertEquals(result, expResult);
        
        
        M_Huella.select(
                Huella.builder().build()
        ).forEach(
                huellaRegistrada ->{
                    DPFPTemplate template = null;
                    template.deserialize(huellaRegistrada.getHuella());
                    VerificationForm verificador = new VerificationForm(null, template);
                }
        );
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testUpdate() {
        Huella huella = null;
        Resultado expResult = null;
        Resultado result = M_Huella.update(huella);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testDelete() {
        Huella huella = null;
        Resultado expResult = null;
        Resultado result = M_Huella.delete(huella);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testDeleteByIDPersona() {
        Huella huella = null;
        Resultado expResult = null;
        Resultado result = M_Huella.deleteByIDPersona(huella);
        assertEquals(result, expResult);
    }


}