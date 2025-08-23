package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.ContactoEmail;
import sur.softsurena.entidades.Cliente;
import static sur.softsurena.metodos.M_ContactoEmail.CONTACTO_BORRADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_ContactoEmail.CORREO_AGREGADO_O_MODIFICADO_CORRECTAMENT;
import static sur.softsurena.metodos.M_ContactoEmail.EL_CONTACTO_DE_CORREO_FUE_ACTUALIZADO;
import static sur.softsurena.metodos.M_ContactoEmail.ERROR_AL_AGREGAR_O_MODIFICAR_CORREO;
import static sur.softsurena.metodos.M_ContactoEmail.ERROR_AL_BORRAR_EL_CONTACTO_DE_CORREO_DEL;
import static sur.softsurena.metodos.M_ContactoEmail.ERROR_AL_CONSULTAR_LA_VISTA_DE_V_CONTACTO;
import static sur.softsurena.metodos.M_ContactoEmail.ERROR_AL_EJECUTAR_EL___DEL_SISTEMA;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.javaDateToSqlDate;
import static sur.softsurena.utilidades.Utilidades.stringToDate;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init",
        groups = "gContactoEmail"
)
public class M_ContactoEmailNGTest {

    public static int idCorreo, idPersona;

    public void testInsert() {
        M_PersonaNGTest.persona = Cliente
                .builder()
                .persona('J')
                .pnombre("MContactoEmail")
                .snombre("MContactoEmail")
                .apellidos("MContactoEmail")
                .sexo('M')
                .fecha_nacimiento(
                        javaDateToSqlDate(
                                stringToDate("23.06.2017", "dd.MM.yyyy")
                        )
                )
                .estado(Boolean.TRUE)
                .build();

        M_PersonaNGTest.testInsert();
        idPersona = M_PersonaNGTest.idPersona;

        Resultado result = M_ContactoEmail.insert(
                ContactoEmail
                        .builder()
                        .idPersona(idPersona)
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
            dependsOnMethods = "testUpdate"
    )
    public void testselectByID() {

        assertFalse(
                M_ContactoEmail.selectByID(
                        idPersona
                ).isEmpty(),
                ERROR_AL_CONSULTAR_LA_VISTA_DE_V_CONTACTO.formatted(idPersona)
        );

    }

    @Test(
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
            dependsOnMethods = {"testselectByID", "testUpdate"}
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
        M_PersonaNGTest.idPersona = idPersona;
        M_PersonaNGTest.testDelete();
    }

    @Test(
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
