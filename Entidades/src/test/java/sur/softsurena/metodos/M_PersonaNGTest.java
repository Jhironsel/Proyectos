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
public class M_PersonaNGTest {

    private static Integer idPersona;

    public M_PersonaNGTest() {
    }

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

    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Prueba que permite insertar una persona al sistema.
                          y obtener su ID en la variable idPersona.
                          """
    )
    public static void testInsert() {

        Resultado result = M_Persona.insert(
                persona(true)
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
    }

    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 1,
            description = """
                          Prueba que permite actualizar un registros del sistema
                          previamente insertado.
                          """
    )
    public static void testUpdate() {

        Resultado result = M_Persona.update(
                persona(false)
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
            priority = 2,
            description = """
                          Test que permite obtener un registro de la base de 
                          datos del sistema.
                          """
    )
    public static void testSelect() {
        Persona result = M_Persona.select(
                Persona
                        .builder()
                        .idPersona(idPersona)
                        .build()
        ).getFirst();
        assertNotNull(
                result,
                "Registros no encontrado en el sistema. CODIGO: [ %s ]".formatted(idPersona)
        );

        result = M_Persona.select(
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
            priority = 4,
            description = """
                          Test que permite eliminar el registro del sistema de 
                          la tabla de Persona.
                          """
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

    public static Persona persona(Boolean estado) {
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

    @Test
    public void testSqlList() {
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
                                .idPersona(-1)
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, 
                    FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, 
                    ESTADO, USER_NAME, ROL_USUARIO
                FROM V_PERSONAS
                WHERE ID = -1
                """.strip().trim()
        );
        
        assertEquals(
                M_Persona.sqlSelect(
                        Persona
                                .builder()
                                .idPersona(-1)
                                .estado(Boolean.TRUE)
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, 
                    FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, 
                    ESTADO, USER_NAME, ROL_USUARIO
                FROM V_PERSONAS
                WHERE ID = -1 AND ESTADO IS true
                """.strip().trim()
        );
        
        assertEquals(
                M_Persona.sqlSelect(
                        Persona
                                .builder()
                                .idPersona(-1)
                                .estado(Boolean.FALSE)
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, 
                    FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, 
                    ESTADO, USER_NAME, ROL_USUARIO
                FROM V_PERSONAS
                WHERE ID = -1 AND ESTADO IS false
                """.strip().trim()
        );
        
        assertEquals(
                M_Persona.sqlSelect(
                        Persona
                                .builder()
                                .idPersona(-1)
                                .pnombre("JHIRONSEL")
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, 
                    FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, 
                    ESTADO, USER_NAME, ROL_USUARIO
                FROM V_PERSONAS
                WHERE ID = -1 OR PNOMBRE STARTING WITH 'JHIRONSEL'
                """.strip().trim()
        );
        
        assertEquals(
                M_Persona.sqlSelect(
                        Persona
                                .builder()
                                .idPersona(-1)
                                .pnombre("JHIRONSEL")
                                .estado(Boolean.TRUE)
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, 
                    FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, 
                    ESTADO, USER_NAME, ROL_USUARIO
                FROM V_PERSONAS
                WHERE ID = -1 OR PNOMBRE STARTING WITH 'JHIRONSEL' AND ESTADO IS true
                """.strip().trim()
        );
        
        assertEquals(
                M_Persona.sqlSelect(
                        Persona
                                .builder()
                                .idPersona(-1)
                                .snombre("JHIRONSEL")
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, 
                    FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, 
                    ESTADO, USER_NAME, ROL_USUARIO
                FROM V_PERSONAS
                WHERE ID = -1 OR SNOMBRE STARTING WITH 'JHIRONSEL'
                """.strip().trim()
        );
        
        assertEquals(
                M_Persona.sqlSelect(
                        Persona
                                .builder()
                                .idPersona(-1)
                                .apellidos("JHIRONSEL")
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, 
                    FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, 
                    ESTADO, USER_NAME, ROL_USUARIO
                FROM V_PERSONAS
                WHERE ID = -1 OR APELLIDOS STARTING WITH 'JHIRONSEL'
                """.strip().trim()
        );
        
        assertEquals(
                M_Persona.sqlSelect(
                        Persona
                                .builder()
                                .idPersona(-1)
                                .apellidos("JHIRONSEL")
                                .pnombre("JHIRONSEL")
                                .snombre("JHIRONSEL")
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, 
                    FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, 
                    ESTADO, USER_NAME, ROL_USUARIO
                FROM V_PERSONAS
                WHERE ID = -1 OR PNOMBRE STARTING WITH 'JHIRONSEL' OR SNOMBRE STARTING WITH 'JHIRONSEL' OR APELLIDOS STARTING WITH 'JHIRONSEL'
                """.strip().trim()
        );
    }
}
