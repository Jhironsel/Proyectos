package sur.softsurena.metodos;

import java.io.File;
import javax.swing.JOptionPane;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.FotoPersona;
import sur.softsurena.entidades.Persona;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.javaDateToSqlDate;
import static sur.softsurena.utilidades.Utilidades.stringToDate;

/**
 *
 * @author jhironsel
 */
@Test(
        dependsOnGroups = "init"
)
public class M_Foto_PersonaNGTest {

    private int idfoto;
    private int idPersona;

    @Test
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

    @Test(
            dependsOnMethods = "testSqlSelect"
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
            dependsOnMethods = "testSelect"
    )
    public void testInsert() {
        M_PersonaNGTest.persona = Persona
                        .builder()
                        .persona('J')
                        .pnombre("MFotoPersona")
                        .snombre("MFotoPersona")
                        .apellidos("MFotoPersona")
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

        Resultado result = M_Foto_Persona.insert(
                FotoPersona
                        .builder()
                        .idPersona(idPersona)
                        .foto(
                                Utilidades.imagenEncode64(
                                        new File("Imagenes/ImagenPrueba.png")
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
                        .idPersona(idPersona)
                        .foto(
                                Utilidades.imagenEncode64(
                                        new File("Imagenes/ImagenPrueba.png")
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
//------------------------------------------------------------------------------
        result = M_Foto_Persona.insert(
                FotoPersona
                        .builder()
                        .idPersona(idPersona)
                        .foto(
                                Utilidades.imagenEncode64(
                                        new File("Imagenes/ImagenPrueba.png")
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
    }

    @Test(
            dependsOnMethods = "testInsert"
    )
    public void testUpdate() {
        Resultado result = M_Foto_Persona.update(
                FotoPersona
                        .builder()
                        .id(idfoto)
                        .idPersona(idPersona)
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
            dependsOnMethods = "testUpdate"
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
            dependsOnMethods = "testDelete"
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
        M_PersonaNGTest.idPersona = idPersona;
        M_PersonaNGTest.testDelete();
    }
}
