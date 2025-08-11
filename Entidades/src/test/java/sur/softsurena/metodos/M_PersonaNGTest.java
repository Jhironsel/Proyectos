package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Persona;
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
        dependsOnGroups = "init",
        groups = "persona"
)
public class M_PersonaNGTest {

    public static Integer idPersona;
    public static Persona persona;

    @Test
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
            dependsOnMethods = {"testSqlSelect"}
    )
    public static void testSelect() {

        assertNotNull(
                M_Persona.select(
                        Persona
                                .builder()
                                .idPersona(0)
                                .build()
                ).getFirst(),
                "Registros de CLIENTE GENERICO NO ENCONTRADO."
        );

        persona = Persona
                .builder()
                .idPersona(idPersona)
                .persona('J')
                .pnombre("MPersona")
                .snombre("MPersona")
                .apellidos("MPersona")
                .sexo('M')
                .fecha_nacimiento(
                        javaDateToSqlDate(
                                stringToDate("23.06.2017", "dd.MM.yyyy")
                        )
                )
                .estado(Boolean.TRUE)
                .build();
    }

    //--------------------------------------------------------------------------
    @Test(
            dependsOnMethods = "testSelect"
    )
    public static void testInsert() {

        Resultado result = M_Persona.insert(persona);

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

        assertNotNull(
                M_Persona.select(
                        Persona
                                .builder()
                                .idPersona(idPersona)
                                .build()
                ).getFirst(),
                "Registros no encontrado en el sistema. CODIGO: [ %s ]".formatted(idPersona)
        );
    }

    //--------------------------------------------------------------------------
    @Test(
            dependsOnMethods = "testInsert"
    )
    public static void testUpdate() {

        persona = Persona
                .builder()
                .idPersona(idPersona)
                .persona('J')
                .pnombre("MPersona")
                .snombre("MPersona")
                .apellidos("Actualizado")
                .sexo('M')
                .fecha_nacimiento(
                        javaDateToSqlDate(
                                stringToDate("23.06.2017", "dd.MM.yyyy")
                        )
                )
                .estado(Boolean.TRUE)
                .build();

        Resultado result = M_Persona.update(persona);

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
            dependsOnMethods = {"testInsert", "testUpdate"}
    )
    public synchronized static void testDelete() {

        assertTrue(
                idPersona > 0,
                "Identificador de persona incorrecto, ID = %d ".formatted(idPersona)
        );

        assertEquals(
                M_Persona.delete(
                        Persona
                                .builder()
                                .idPersona(idPersona)
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(REGISTRO_DE_PERSONA_ELIMINADO_CORRECTAMEN)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_ELIMINAR_REGISTROS_CODIGO_S.formatted(idPersona)
        );
    }

    /**
     * Metodo que contiene los atributos basicos de una persona.
     *
     * @return
     */
}
