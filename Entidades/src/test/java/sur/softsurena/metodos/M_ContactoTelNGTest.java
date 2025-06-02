package sur.softsurena.metodos;

import java.util.List;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.ContactoTel;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init",
        groups = "contactoTel"
)
public class M_ContactoTelNGTest {

    public static Integer idContactoTel, idPersona;
    
    @Test(
            groups = "contactoTel.insert"
    )
    public void persona() {
        M_PersonaNGTest.testInsert();
        idPersona = M_PersonaNGTest.idPersona;
    }

    @Test(
            groups = "contactoTel.insert",
            dependsOnMethods = "persona"
    )
    public void testInsert() {
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
            dependsOnMethods = "testInsert"
    )
    public void testUpdate() {
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
            dependsOnMethods = {"testInsert", "testUpdate"}
    )
    public void testSelectByID() {
        List result = M_ContactoTel.selectByID(idPersona);

        assertFalse(
                result.isEmpty(),
                M_ContactoTel.ERROR_AL_CONSULTAR_LA_VISTA_V_CONTACTOS_T
        );
    }

    @Test(
            dependsOnMethods = {"testInsert", "testUpdate", "testSelectByID"}
    )
    public void testDetele() {
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
        
    }
    
    @Test(
            dependsOnMethods = {"testDetele"}
    )
    public void testDetele2() {
        M_PersonaNGTest.idPersona = idPersona;
        M_PersonaNGTest.testDelete();
    }

    @Test
    public void testGenerarTelMovil() {
        assertTrue(
                M_ContactoTel.telefono(M_ContactoTel.generarTelMovil()),
                "Numero generado no es correcto."
        );
    }

    @Test
    public void testTelefono() {}

    private ContactoTel telefono() {
        return ContactoTel
                .builder()
                .id(idContactoTel)
                .idPersona(idPersona)
                .telefono(M_ContactoTel.generarTelMovil())
                .tipo("Telefono")
                .porDefecto(Boolean.TRUE)
                .estado(Boolean.TRUE)
                .build();
    }

}
