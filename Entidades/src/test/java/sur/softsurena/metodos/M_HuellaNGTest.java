package sur.softsurena.metodos;

import com.digitalpersona.onetouch.DPFPTemplate;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Huella;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.digitalPersonal.enrollment.VerificationForm;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_HuellaNGTest {

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
            description = """
                          """,
            alwaysRun = true
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