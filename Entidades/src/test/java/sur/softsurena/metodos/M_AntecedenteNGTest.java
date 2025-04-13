package sur.softsurena.metodos;

import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Antecedente;
import sur.softsurena.entidades.Consulta;
import sur.softsurena.entidades.Paciente;
import static sur.softsurena.metodos.M_Antecedente.ANTECEDENTE_AGREGADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Antecedente.ANTECEDENTE_MODIFICADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Antecedente.BORRADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Antecedente.ERROR_AL_BORRAR_PACIENTE;
import static sur.softsurena.metodos.M_Antecedente.ERROR_AL_MODIFICAR_ANTECEDENTE;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
public class M_AntecedenteNGTest {

    private Integer id_antecedente;
    private Integer idConsulta;
    private Integer idPaciente;
    
    public M_AntecedenteNGTest() {
    }
//------------------------------------------------------------------------------

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
//------------------------------------------------------------------------------

    @AfterClass
    public void tearDownClass() throws Exception {
        Conexion.getCnn().close();
    }
//------------------------------------------------------------------------------

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }
//------------------------------------------------------------------------------

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testSqlSelect() {
        String expResult = """
                           SELECT ID, ID_CONSULTA, DESCRIPCION 
                           FROM V_ANTECEDENTES
                           """;
        assertEquals(
                M_Antecedente.sqlSelect(
                        Antecedente
                                .builder()
                                .build()
                ),
                expResult.trim().strip()
        );

        expResult = """
                    SELECT ID, ID_CONSULTA, DESCRIPCION 
                    FROM V_ANTECEDENTES
                    WHERE ID = -1
                    """;

        assertEquals(
                M_Antecedente.sqlSelect(
                        Antecedente
                                .builder()
                                .id(-1)
                                .build()
                ),
                expResult.trim().strip()
        );

        expResult = """
                    SELECT ID, ID_CONSULTA, DESCRIPCION 
                    FROM V_ANTECEDENTES
                    WHERE ID_CONSULTA = -1
                    """;

        assertEquals(
                M_Antecedente.sqlSelect(
                        Antecedente
                                .builder()
                                .idConsulta(-1)
                                .build()
                ),
                expResult.trim().strip()
        );

        expResult = """
                    SELECT ID, ID_CONSULTA, DESCRIPCION 
                    FROM V_ANTECEDENTES
                    WHERE ID = -1 AND ID_CONSULTA = -1
                    """;

        assertEquals(
                M_Antecedente.sqlSelect(
                        Antecedente
                                .builder()
                                .id(-1)
                                .idConsulta(-1)
                                .build()
                ),
                expResult.trim().strip()
        );
    }
//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 1,
            description = """
                          """
    )
    public void testSelect() {
        int idPadre = -1;
        List<Antecedente> result = M_Antecedente.select(
                Antecedente
                        .builder()
                        .id(idPadre)
                        .build()
        );

        assertTrue(
                result.isEmpty(),
                "La tabla de antecedentes contiene informacion."
        );

        //Consultado el registro
        List<Antecedente> lista = M_Antecedente.select(
                Antecedente
                        .builder()
                        .id(id_antecedente)
                        .build()
        );

        assertNotNull(
                lista,
                "La tabla de antecedentes NO contiene informacion."
        );
    }

//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 2,
            description = """
                          Agrega un antecedente de un paciente al sistema.
                          """
    )
    public void testInsert() {
        M_ConsultaNGTest.testInsert();
        
        Resultado result = M_Antecedente.insert(
                Antecedente
                        .builder()
                        .idConsulta(M_ConsultaNGTest.getIdConsulta())
                        .descripcion("Prueba de antecendetes")
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(ANTECEDENTE_AGREGADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                "No puede ser agregado el registro."
        );
        
        assertTrue(
                result.getId() > 0,
                result.getMensaje()
                );

        id_antecedente = result.getId();
    }
    
//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            description = "",
            priority = 3
    )
    public void testUpdate() {
        assertEquals(
                M_Antecedente.update(
                        Antecedente
                                .builder()
                                .id(id_antecedente)
                                .descripcion("Actualizado")
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(ANTECEDENTE_MODIFICADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_MODIFICAR_ANTECEDENTE
        );
    }
//------------------------------------------------------------------------------

    @Test(
            enabled = true,
            priority = 4,
            description = """
                          """
    )
    public void testDelete() {
        assertEquals(
                M_Antecedente.delete(
                        Antecedente
                                .builder()
                                .id(id_antecedente)
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(BORRADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_BORRAR_PACIENTE
        );
        M_ConsultaNGTest.testDelete();
    }
}
