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
import sur.softsurena.entidades.ContactoEmail;
import static sur.softsurena.metodos.M_ContactoEmail.CONTACTO_BORRADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_ContactoEmail.CORREO_AGREGADO_O_MODIFICADO_CORRECTAMENT;
import static sur.softsurena.metodos.M_ContactoEmail.EL_CONTACTO_DE_CORREO_FUE_ACTUALIZADO;
import static sur.softsurena.metodos.M_ContactoEmail.ERROR_AL_AGREGAR_O_MODIFICAR_CORREO;
import static sur.softsurena.metodos.M_ContactoEmail.ERROR_AL_BORRAR_EL_CONTACTO_DE_CORREO_DEL;
import static sur.softsurena.metodos.M_ContactoEmail.ERROR_AL_CONSULTAR_LA_VISTA_DE_V_CONTACTO;
import static sur.softsurena.metodos.M_ContactoEmail.ERROR_AL_EJECUTAR_EL___DEL_SISTEMA;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_ContactoEmailNGTest {

    private static int idCorreo, idPersona;

    public M_ContactoEmailNGTest() {}

    @BeforeClass
    public void setUpClass() throws Exception {}

    @AfterClass
    public void tearDownClass() throws Exception {}

    @BeforeMethod
    public void setUpMethod() throws Exception {}

    @AfterMethod
    public void tearDownMethod() throws Exception {}

    @Test(
            enabled = true,
            description = "Permita agregar un contacto y su correo",
            dependsOnMethods = "testselectByID",
            groups = "contactoEmail.insert"
    )
    public void testInsert() {

        M_PersonaNGTest.testInsert();
        idPersona = M_PersonaNGTest.getPersona(Boolean.TRUE).getIdPersona();
        Resultado result = M_ContactoEmail.insert(
                ContactoEmail
                        .builder()
                        .idPersona(
                                idPersona
                        )
                        .email(M_ContactoEmail.generarCorreo())
                        .estado(Boolean.TRUE)
                        .porDefecto(Boolean.TRUE)
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(CORREO_AGREGADO_O_MODIFICADO_CORRECTAMENT)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_AGREGAR_O_MODIFICAR_CORREO
        );

        idCorreo = result.getId();

        assertTrue(
                idCorreo >= 0,
                ERROR_AL_AGREGAR_O_MODIFICAR_CORREO
        );
    }
    
    @Test(
            enabled = true,
            description = "Realizamos consulta y eliminamos cliente.",
            dependsOnMethods = "testInsert"
    )
    public void testselectByID() {
        List result = M_ContactoEmail.selectByID(
                idPersona
        );

        assertFalse(
                result.isEmpty(),
                ERROR_AL_CONSULTAR_LA_VISTA_DE_V_CONTACTO
        );

        assertNotNull(
                result,
                "Consulta no puede devolver nulo."
        );

    }

    @Test(
            enabled = true,
            description = """
                          Modifica los contactos del sistema.
                          """,
            dependsOnMethods = "testInsert"
    )
    public void testUpdate() {
        Resultado result = M_ContactoEmail.update(
                ContactoEmail
                        .builder()
                        .id(idCorreo)
                        .idPersona(idPersona)
                        .email(M_ContactoEmail.generarCorreo())
                        .estado(Boolean.TRUE)
                        .porDefecto(Boolean.FALSE)
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(EL_CONTACTO_DE_CORREO_FUE_ACTUALIZADO)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_EJECUTAR_EL___DEL_SISTEMA
        );
    }
    
    

    @Test(
            enabled = true,
            description = """
                          Verificamos si validan los correo correctamente.
                          """,
            dependsOnMethods = {"testInsert", "testUpdate"}
    )
    public void testDelete() {
        Resultado result = M_ContactoEmail.delete(idCorreo);

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(CONTACTO_BORRADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_BORRAR_EL_CONTACTO_DE_CORREO_DEL
        );
        M_PersonaNGTest.testDelete();
    }

    @Test(
            enabled = true,
            description = "Test que genera un correo y valida si es correcto.",
            alwaysRun = true
    )
    public void testGenerarCorreo() {
        String result = M_ContactoEmail.generarCorreo();
        assertTrue(
                M_ContactoEmail.correo(result),
                "Correo que causa el error %s".formatted(result)
        );
    }

    @Test(
            enabled = true,
            description = "Verificamos si validan los correo correctamente.",
            alwaysRun = true
    )
    public void testCorreo() {
        assertTrue(M_ContactoEmail.correo("correo@correo.com"));

        assertTrue(M_ContactoEmail.correo("correo111@correo.com"));

        assertTrue(M_ContactoEmail.correo("correo.123_123@correo.com"));

        assertFalse(M_ContactoEmail.correo("@correo111@correo.com"));

        assertFalse(M_ContactoEmail.correo("correo@correo.com123"));
    }
}
