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
import sur.softsurena.entidades.ContactoDireccion;
import static sur.softsurena.metodos.M_ContactoDireccion.DIRECCION_AGREGADA_CORRECTAMENTE;
import static sur.softsurena.metodos.M_ContactoDireccion.DIRECCION_DE_CONTACTO_ACTUALIZADA_CORRECT;
import static sur.softsurena.metodos.M_ContactoDireccion.ERROR_AL_ACTUALIZAR_LA_DIRECCION_DEL_CONT;
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

    public M_ContactoDireccionNGTest() {}

    @BeforeClass
    public void setUpClass() throws Exception {}

    @AfterClass
    public void tearDownClass() throws Exception {}

    @BeforeMethod
    public void setUpMethod() throws Exception {}

    @AfterMethod
    public void tearDownMethod() throws Exception {}

    
    //--------------------------------------------------------------------------

    @Test(
            enabled = true,
            description = """
                          Metodo que permite agregar un direcion de una persona.
                          """,
            dependsOnMethods = "testSelectByID",
            groups = "contactoDir.insert"
    )
    public void testInsert() {

        M_PersonaNGTest.testInsert();

        idPersona = M_PersonaNGTest
                .getPersona(Boolean.FALSE)
                .getIdPersona();

        Resultado result = M_ContactoDireccion.insert(
                ContactoDireccion
                        .builder()
                        .idPersona(
                                idPersona
                        )
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
            enabled = true,
            description = """
                          Permite consulta las direcciones de una personas del 
                          sistema.
                          """,
            dependsOnMethods = "testInsert"
    )
    public void testSelectByID() {
        List result = M_ContactoDireccion.selectByID(idPersona);
        assertFalse(
                result.isEmpty(),
                "La lista contiene datos"
        );
    }//----------------------------------------------------------------------FIN

    @Test(
            enabled = true,
            description = """
                          """,
            dependsOnMethods = "testInsert"
    )
    public void testUpdate() {

        Resultado result = M_ContactoDireccion.update(ContactoDireccion
                .builder()
                .id(idDireccion)
                .idPersona(
                        idPersona
                )
                .idProvincia(2)
                .idMunicipio(12)
                .idDistritoMunicipal(23)
                .idCodigoPostal(0)
                .direccion("Insercion de prueba 2.")
                .porDefecto(Boolean.TRUE)
                .estado(Boolean.FALSE)
                .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(DIRECCION_DE_CONTACTO_ACTUALIZADA_CORRECT)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_ACTUALIZAR_LA_DIRECCION_DEL_CONT
        );
    }

    @Test(
            enabled = true,
            description = """
                          Test que realiza la eliminacion de un registros de 
                          direccion de un contacto del sistema.
                          """,
            dependsOnMethods = {"testInsert", "testUpdate"}
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

        M_PersonaNGTest.testDelete();
    }
}
