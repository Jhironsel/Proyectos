package sur.softsurena.metodos;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Generales;
import sur.softsurena.entidades.Padre;
import static sur.softsurena.metodos.M_Padre.BORRADO_DE_REGISTRO_CORRECTAMENTE;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_PadreNGTest {

    public M_PadreNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        Conexion.getInstance(
                "sysdba",
                "1",
                "SoftSurena.db",
                "localhost",
                "3050"
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
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testGetPadres() {

        assertNotNull(
                M_Padre.getList(
                        Padre
                                .builder()
                                .build()
                ).isEmpty(),
                "Error al consultar la lista de padres."
        );
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testAgregarPadreMadre() {
        Padre p = null;
        Resultado expResult = null;
        Resultado result = M_Padre.insert(p);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testModificarPadre() {
        Padre p = null;
        String expResult = "";
        Resultado result = M_Padre.update(p);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = true,
            priority = 0,
            description = ""
    )
    public void testBorrarPadre() {

        assertEquals(
                M_Padre.delete(-1),
                Resultado
                        .builder()
                        .mensaje(BORRADO_DE_REGISTRO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testGetPadreMadres() {
        int idPadre = 0;
        ResultSet expResult = null;
        ResultSet result = M_Padre.getPadreMadres(idPadre);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testValidarPadreMadre() {
        String cedula = "";
        boolean expResult = false;
        boolean result = M_Padre.validarPadreMadre(cedula);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testGetPadresActivoID() {
        int idPadre = 0;
        ResultSet expResult = null;
        ResultSet result = M_Padre.getPadresActivoID(idPadre);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testGetPadresActivo_String_String() {
        String cedula = "";
        String sexo = "";
        ResultSet expResult = null;
        ResultSet result = M_Padre.getPadresActivo(cedula, sexo);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testGetPadresActivo_boolean() {
        boolean estado = false;
        ResultSet expResult = null;
        ResultSet result = M_Padre.getPadresActivo(estado);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testGetIdMadrePadre() {
        String cedula = "";
        M_Padre instance = new M_Padre();
        int expResult = 0;
        int result = instance.getIdMadrePadre(cedula);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testExistePadre() {
        String cedula = "";
        boolean estado = false;
        boolean expResult = false;
        boolean result = M_Padre.existePadre(cedula, estado);
        assertEquals(result, expResult);
    }

    @Test
    public void testSqlGetPadres() {
        String expResult = """
                           SELECT ID, PNOMBRE, SNOMBRE, APELLIDOS, SEXO,
                                FECHA_NACIMIENTO, ESTADO_PERSONA,
                                ID_TIPO_SANGREE, CEDULA, ESTADO_CIVIL, ID_ARS,
                                NO_NSS, ESTADO_SEGURO
                           FROM GET_PERSONAS_PADRES
                           """;

        String result = M_Padre.sqlGetList(
                Padre
                        .builder()
                        .persona(Persona.builder().build())
                        .build()
        );

        assertEquals(result.strip().trim(), expResult.strip().trim());

        expResult = """
                           SELECT ID, PNOMBRE, SNOMBRE, APELLIDOS, SEXO,
                                FECHA_NACIMIENTO, ESTADO_PERSONA,
                                ID_TIPO_SANGREE, CEDULA, ESTADO_CIVIL, ID_ARS,
                                NO_NSS, ESTADO_SEGURO
                           FROM GET_PERSONAS_PADRES
                           WHERE CEDULA LIKE '000-0000000-0'
                           """;

        result = M_Padre.sqlGetList(
                Padre
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .generales(
                                                Generales
                                                        .builder()
                                                        .cedula("000-0000000-0")
                                                        .build()
                                        )
                                        .build()
                        )
                        .build()
        );

        assertEquals(result.strip().trim(), expResult.strip().trim());

        expResult = """
                           SELECT ID, PNOMBRE, SNOMBRE, APELLIDOS, SEXO,
                                FECHA_NACIMIENTO, ESTADO_PERSONA,
                                ID_TIPO_SANGREE, CEDULA, ESTADO_CIVIL, ID_ARS,
                                NO_NSS, ESTADO_SEGURO
                           FROM GET_PERSONAS_PADRES
                           WHERE ESTADO_PERSONA
                           """;

        result = M_Padre.sqlGetList(
                Padre
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .estado(Boolean.TRUE)
                                        .build()
                        )
                        .build()
        );

        assertEquals(result.strip().trim(), expResult.strip().trim());
        
        expResult = """
                           SELECT ID, PNOMBRE, SNOMBRE, APELLIDOS, SEXO,
                                FECHA_NACIMIENTO, ESTADO_PERSONA,
                                ID_TIPO_SANGREE, CEDULA, ESTADO_CIVIL, ID_ARS,
                                NO_NSS, ESTADO_SEGURO
                           FROM GET_PERSONAS_PADRES
                           WHERE ESTADO_PERSONA IS FALSE
                           """;

        result = M_Padre.sqlGetList(
                Padre
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .estado(Boolean.FALSE)
                                        .build()
                        )
                        .build()
        );

        assertEquals(result.strip().trim(), expResult.strip().trim());
        
        expResult = """
                           SELECT ID, PNOMBRE, SNOMBRE, APELLIDOS, SEXO,
                                FECHA_NACIMIENTO, ESTADO_PERSONA,
                                ID_TIPO_SANGREE, CEDULA, ESTADO_CIVIL, ID_ARS,
                                NO_NSS, ESTADO_SEGURO
                           FROM GET_PERSONAS_PADRES
                           WHERE ID = -1
                           """;

        result = M_Padre.sqlGetList(
                Padre
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .id_persona(-1)
                                        .build()
                        )
                        .build()
        );

        assertEquals(result.strip().trim(), expResult.strip().trim());
    }
}
