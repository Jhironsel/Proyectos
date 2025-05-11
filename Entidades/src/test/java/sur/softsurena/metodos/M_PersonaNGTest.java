package sur.softsurena.metodos;

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
import static sur.softsurena.metodos.M_Persona.ERROR_ACTUALIZAR_PERSONA_EN_EL_SISTEMA;
import static sur.softsurena.metodos.M_Persona.ERROR_AL_ELIMINAR_REGISTROS_CODIGO_S;
import static sur.softsurena.metodos.M_Persona.ERROR_AL_REGISTRAR_PERSONA_AL_SISTEMA;
import static sur.softsurena.metodos.M_Persona.PERSONA_ACTUALIZADA_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Persona.REGISTRO_DE_PERSONA_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Persona.REGISTRO_DE_PERSONA_ELIMINADO_CORRECTAMEN;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.javaDateToSqlDate;
import static sur.softsurena.utilidades.Utilidades.stringToDate;

/**
 * Es la clase encargada de gestionar las operaciones de las personas en el
 * sistema.
 *
 * Ya sea: Clientes. Proveedores. Padres. Estudiantes. Pacientes.
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_PersonaNGTest {

    private static Integer idPersona;

    public M_PersonaNGTest() {}

    @BeforeClass(
            alwaysRun = true
    )
    public void setUpClass() throws Exception {}

    @AfterClass
    public void tearDownClass() throws Exception {}

    @BeforeMethod
    public void setUpMethod() throws Exception {}

    @AfterMethod
    public void tearDownMethod() throws Exception {}

    //--------------------------------------------------------------------------
    @Test(
            alwaysRun = true,
            enabled = true
    )
    public static void testSqlSelect() {
        assertEquals(
                M_Persona.sqlSelect(
                        Persona
                                .builder()
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, 
                    FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, 
                    ESTADO, USER_NAME, ROL_USUARIO
                FROM V_PERSONAS
                """.strip().trim()
        );

        assertEquals(
                M_Persona.sqlSelect(
                        Persona
                                .builder()
                                .idPersona(0)
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, 
                    FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, 
                    ESTADO, USER_NAME, ROL_USUARIO
                FROM V_PERSONAS
                WHERE ID = 0
                """.strip().trim()
        );
        
        assertEquals(
                M_Persona.sqlSelect(
                        Persona
                                .builder()
                                .persona('F')
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, 
                    FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, 
                    ESTADO, USER_NAME, ROL_USUARIO
                FROM V_PERSONAS
                WHERE PERSONA STARTING WITH 'F'
                """.strip().trim()
        );
        
        assertEquals(
                M_Persona.sqlSelect(
                        Persona
                                .builder()
                                .pnombre("GENERICO")
                                .snombre("GENERICO")
                                .apellidos("GENERICO")
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, 
                    FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, 
                    ESTADO, USER_NAME, ROL_USUARIO
                FROM V_PERSONAS
                WHERE PNOMBRE STARTING WITH 'GENERICO' OR SNOMBRE STARTING WITH 'GENERICO' OR APELLIDOS STARTING WITH 'GENERICO'
                """.strip().trim()
        );
        
        assertEquals(
                M_Persona.sqlSelect(
                        Persona
                                .builder()
                                .estado(Boolean.TRUE)
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, 
                    FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, 
                    ESTADO, USER_NAME, ROL_USUARIO
                FROM V_PERSONAS
                WHERE ESTADO IS TRUE
                """.strip().trim()
        );
        
        
        assertEquals(
                M_Persona.sqlSelect(
                        Persona
                                .builder()
                                .estado(Boolean.FALSE)
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, 
                    FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, 
                    ESTADO, USER_NAME, ROL_USUARIO
                FROM V_PERSONAS
                WHERE ESTADO IS FALSE
                """.strip().trim()
        );
    }

    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            dependsOnMethods = {"testSqlSelect"},
            description = """
                          Test que permite obtener un registro de la base de 
                          datos del sistema.
                          """
    )
    public static void testSelect() {
        Persona result = M_Persona.select(
                Persona
                        .builder()
                        .idPersona(0)
                        .build()
        ).getFirst();

        assertNotNull(
                result,
                "Registros de CLIENTE GENERICO NO ENCONTRADO."
        );
    }

    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            description = """
                          Prueba que permite insertar una persona al sistema.
                          y obtener su ID en la variable idPersona.
                          """, 
            groups = "persona.insert"
    )
    public static void testInsert() {

        Resultado result = M_Persona.insert(
                getPersona(true)
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(REGISTRO_DE_PERSONA_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_REGISTRAR_PERSONA_AL_SISTEMA
        );

        assertTrue(
                result.getId() > 0,
                ERROR_AL_REGISTRAR_PERSONA_AL_SISTEMA.formatted(result.getId())
        );

        idPersona = result.getId();

        var persona = M_Persona.select(
                Persona
                        .builder()
                        .idPersona(idPersona)
                        .build()
        ).getFirst();
        
        assertNotNull(
                persona,
                "Registros no encontrado en el sistema. CODIGO: [ %s ]".formatted(idPersona)
        );
    }

    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            description = """
                          Prueba que permite actualizar un registros del sistema
                          previamente insertado.
                          """,
            dependsOnMethods = "testInsert"
    )
    public static void testUpdate() {

        Resultado result = M_Persona.update(
                getPersona(false)
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(PERSONA_ACTUALIZADA_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_ACTUALIZAR_PERSONA_EN_EL_SISTEMA
        );
    }

    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            description = """
                          Test que permite eliminar el registro del sistema de 
                          la tabla de Persona.
                          """,
            dependsOnMethods = {"testInsert", "testUpdate"}
    )
    public static void testDelete() {
        
        assertTrue(
                idPersona > 0,
                "Identificador de persona incorrecto, ID = %d ".formatted(idPersona)
        );

        Resultado result = M_Persona.delete(idPersona);

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(REGISTRO_DE_PERSONA_ELIMINADO_CORRECTAMEN)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_ELIMINAR_REGISTROS_CODIGO_S.formatted(idPersona)
        );
    }

    public static Persona getPersona(Boolean estado) {
        return Persona
                .builder()
                .idPersona(idPersona)
                .persona('J')
                .pnombre("Jhadiel")
                .snombre("Jhoandry")
                .apellidos("Diaz Paniagua")
                .sexo('M')
                .fecha_nacimiento(
                        javaDateToSqlDate(
                                stringToDate("23.06.2017", "dd.MM.yyyy")
                        )
                )
                .estado(estado)
                .build();
    }
}
