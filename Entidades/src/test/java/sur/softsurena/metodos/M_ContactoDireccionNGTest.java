package sur.softsurena.metodos;

import java.util.List;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.ContactoDireccion;
import static sur.softsurena.metodos.M_ContactoDireccion.DIRECCION_AGREGADA_CORRECTAMENTE;
import static sur.softsurena.metodos.M_ContactoDireccion.ERROR_AL_BORRAR_EL_REGISTRO_DE_LA_DIRECCI;
import static sur.softsurena.metodos.M_ContactoDireccion.ERROR_AL_INSERTAR_DIRECCION;
import static sur.softsurena.metodos.M_ContactoDireccion.REGISTRO_DE_LA_DIRECCION_BORRADO_CORRECTA;
import sur.softsurena.utilidades.Resultado;

@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_ContactoDireccionNGTest {

    private int idDireccion, idPersona, idProvincia, idMunicipio,
            idDistritoMunicipal, idCodigoPostal;
    
    
    @Test
    public void testUpdateOrInsert() {
        M_PersonaNGTest.testInsert();
        idPersona = M_PersonaNGTest.idPersona;

        Resultado result = M_ContactoDireccion.updateOrInsert(
                ContactoDireccion
                        .builder()
                        .id(null)
                        .idPersona(idPersona)
                        .idProvincia(0)
                        .idMunicipio(0)
                        .idDistritoMunicipal(0)
                        .direccion("Insercion de prueba.")
                        .porDefecto(Boolean.TRUE)
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(DIRECCION_AGREGADA_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_INSERTAR_DIRECCION
        );

        assertTrue(
                result.getId() > 0,
                ERROR_AL_INSERTAR_DIRECCION
        );

        idDireccion = result.getId();
    }//----------------------------------------------------------------------FIN
    
    @Test(
            dependsOnMethods = "testUpdateOrInsert"
    )
    public void testSelectByID() {
        assertNotNull(
                M_ContactoDireccion.selectByID(idPersona),
                "La lista contiene datos"
        );
    }//----------------------------------------------------------------------FIN

    @Test(
            dependsOnMethods = {"testUpdateOrInsert"}
    )
    public void testDelete() {

        Resultado result = M_ContactoDireccion.delete(idDireccion);

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(REGISTRO_DE_LA_DIRECCION_BORRADO_CORRECTA)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_BORRAR_EL_REGISTRO_DE_LA_DIRECCI
        );

        M_PersonaNGTest.idPersona = idPersona;
        M_PersonaNGTest.testDelete();
    }
}
