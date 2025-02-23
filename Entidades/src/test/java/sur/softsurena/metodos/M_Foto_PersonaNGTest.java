package sur.softsurena.metodos;

import java.io.File;
import javax.swing.JOptionPane;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.FotoPersona;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;

/**
 *
 * @author jhironsel
 */
public class M_Foto_PersonaNGTest {

    private Integer idfoto;
    private Integer idPersona;
    private Integer idPersona2;

    public M_Foto_PersonaNGTest() {
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
            enabled = true,
            priority = 1,
            description = """
                          """
    )
    public void testSelect() {
        assertNotNull(
                M_Foto_Persona.select(
                        FotoPersona
                                .builder()
                                .build()
                ),
                "Error en la consulta de foto de persona."
        );
    }

    @Test(
            enabled = true,
            priority = 2,
            description = """
                          """
    )
    public void testInsert() {
        Resultado resultado = M_Persona.insert(M_PersonaNGTest.persona(Boolean.TRUE));

        Resultado result = M_Foto_Persona.insert(
                FotoPersona
                        .builder()
                        .idPersona(resultado.getId())
                        .foto(
                                Utilidades.imagenEncode64(
                                        new File("ejemplo.png")
                                )
                        )
                        .actual(Boolean.TRUE)
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje("Registro realizado correctamente.!!!")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );

        result = M_Foto_Persona.insert(
                FotoPersona
                        .builder()
                        .idPersona(resultado.getId())
                        .foto(
                                Utilidades.imagenEncode64(
                                        new File("ejemplo.png")
                                )
                        )
                        .actual(Boolean.TRUE)
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje("Registro realizado correctamente.!!!")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );

        idPersona = resultado.getId();
//------------------------------------------------------------------------------
        resultado = M_Persona.insert(M_PersonaNGTest.persona(Boolean.TRUE));

        result = M_Foto_Persona.insert(
                FotoPersona
                        .builder()
                        .idPersona(resultado.getId())
                        .foto(
                                Utilidades.imagenEncode64(
                                        new File("ejemplo.png")
                                )
                        )
                        .actual(Boolean.FALSE)
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje("Registro realizado correctamente.!!!")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
        idfoto = result.getId();
        idPersona2 = resultado.getId();
    }

    @Test(
            enabled = true,
            priority = 3,
            description = """
                          """
    )
    public void testUpdate() {
        Resultado result = M_Foto_Persona.update(
                FotoPersona
                        .builder()
                        .id(idfoto)
                        .idPersona(idPersona2)
                        .foto("")
                        .actual(Boolean.TRUE)
                        .build()
        );
        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje("Registro actualizado del sistema.")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            enabled = true,
            priority = 4,
            description = """
                          """
    )
    public void testDelete() {
        assertEquals(
                M_Foto_Persona.delete(
                        FotoPersona
                                .builder()
                                .id(idfoto)
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje("Registro eliminado del sistema.")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            enabled = true,
            priority = 5,
            description = """
                          """
    )
    public void testDeleteById_persona() {
        assertEquals(
                M_Foto_Persona.deleteById_persona(
                        FotoPersona
                                .builder()
                                .idPersona(idPersona)
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje("Registros eliminados del sistema.")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
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
                M_Foto_Persona.sqlSelect(
                        FotoPersona
                                .builder()
                                .build()
                ),
                """
                SELECT ID, ID_PERSONA, FOTO, FECHA_HORA_CREACION, ACTUAL
                FROM V_FOTO_PERSONA
                """.strip()
        );

        assertEquals(
                M_Foto_Persona.sqlSelect(
                        FotoPersona
                                .builder()
                                .id(1)
                                .build()
                ),
                """
                SELECT ID, ID_PERSONA, FOTO, FECHA_HORA_CREACION, ACTUAL
                FROM V_FOTO_PERSONA
                WHERE ID = 1
                """.strip()
        );

        assertEquals(
                M_Foto_Persona.sqlSelect(
                        FotoPersona
                                .builder()
                                .idPersona(1)
                                .build()
                ),
                """
                SELECT ID, ID_PERSONA, FOTO, FECHA_HORA_CREACION, ACTUAL
                FROM V_FOTO_PERSONA
                WHERE ID_PERSONA = 1
                """.strip()
        );

        assertEquals(
                M_Foto_Persona.sqlSelect(
                        FotoPersona
                                .builder()
                                .id(1)
                                .idPersona(1)
                                .build()
                ),
                """
                SELECT ID, ID_PERSONA, FOTO, FECHA_HORA_CREACION, ACTUAL
                FROM V_FOTO_PERSONA
                WHERE ID = 1 AND ID_PERSONA = 1
                """.strip()
        );
    }
}
