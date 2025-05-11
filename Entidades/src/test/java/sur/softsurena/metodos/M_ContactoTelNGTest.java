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
import sur.softsurena.entidades.ContactoTel;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_ContactoTelNGTest {

    public static Integer idContactoTel;

    public M_ContactoTelNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
    }

    @AfterClass
    public void tearDownClass() throws Exception {
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
                          Test que permite agregar un telefono de contacto de 
                          una persona.
                          """,
            groups = "contactoTel.insert"
    )
    public void testInsert() {
        M_PersonaNGTest.testInsert();

        Resultado result = M_ContactoTel.insert(
                telefono()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .mensaje(M_ContactoTel.CONTACTO_TELEFONICO_AGREGADO_CORRECTAMENT)
                        .estado(Boolean.TRUE)
                        .build(),
                M_ContactoTel.ERROR_AL_EJECUTAR_EL_SP_I_CONTACTO_TEL_EN
        );

        assertTrue(
                result.getId() > 0,
                M_ContactoTel.ERROR_AL_EJECUTAR_EL_SP_I_CONTACTO_TEL_EN
        );

        idContactoTel = result.getId();
    }

    @Test(
            enabled = true,
            priority = 1,
            description = """
                          Test que permite actualizar uno numero telefonico en
                          el sistema.
                          """
    )
    public void testModificarContactoTel() {
        Resultado result = M_ContactoTel.update(
                telefono()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(
                                M_ContactoTel.CONTACTO_TELEFONICO_ACTUALIZADO_CORRECTAM
                        )
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                M_ContactoTel.ERROR_AL_EJECUTAR_EL_SP_U_CONTACTO_TEL_DE
        );
    }

    @Test(
            enabled = true,
            priority = 2,
            description = """
                          Test que localiza un numero telefonico de una persona
                          en el sistema.
                          """
    )
    public void testGetTelefonoByID() {
        List result = M_ContactoTel.selectByID(
                M_PersonaNGTest.getPersona(Boolean.FALSE).getIdPersona()
        );

        assertFalse(
                result.isEmpty(),
                M_ContactoTel.ERROR_AL_CONSULTAR_LA_VISTA_V_CONTACTOS_T
        );
    }

    @Test(
            enabled = true,
            priority = 5,
            description = """
                          Test que permite eliminar un contacto telefonico del 
                          sistema.
                          """
    )
    public void testEliminarContactoTel() {
        Resultado result = M_ContactoTel.delete(idContactoTel);
        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(M_ContactoTel.CONTACTO_TELEFONICO_ELIMINADO_CORRECTAMEN)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                M_ContactoTel.ERROR_AL_ELIMINAR_CONTACTO_TELEFONICO_EN
        );
        M_PersonaNGTest.testDelete();
    }

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testGenerarTelMovil() {
        String result = M_ContactoTel.generarTelMovil();
        assertTrue(
                M_ContactoTel.telefono(result),
                "Numero generado no es correcto."
        );
    }

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testTelefono() {
        String tel = M_ContactoTel.generarTelMovil();
        boolean expResult = true;
        boolean result = M_ContactoTel.telefono(tel);
        assertEquals(
                result,
                expResult,
                "Metodo de validar telefono captura numero incorrecto."
        );
    }

    private ContactoTel telefono() {
        return ContactoTel
                .builder()
                .id(idContactoTel)
                .idPersona(
                        M_PersonaNGTest
                                .getPersona(Boolean.FALSE)
                                .getIdPersona()
                )
                .telefono(M_ContactoTel.generarTelMovil())
                .tipo("Telefono")
                .porDefecto(Boolean.TRUE)
                .estado(Boolean.TRUE)
                .build();
    }

}
