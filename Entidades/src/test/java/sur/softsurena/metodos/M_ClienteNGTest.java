package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Cliente;
import static sur.softsurena.metodos.M_Cliente.CLIENTE_BORRADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Cliente.CLIENTE_NO_PUEDE_SER_BORRADO;
import static sur.softsurena.metodos.M_Cliente.CLIENTE__AGREGADO__CORRECTAMENTE;
import static sur.softsurena.metodos.M_Cliente.ERROR_AL_INSERTAR__CLIENTE;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_ClienteNGTest {

    public static Integer idPersona;

    @Test
    public void testSqlSelect() {
        assertEquals(
                M_Cliente.sqlSelect(
                        Cliente
                                .builder()
                                .build()
                ),
                """
                SELECT ID
                FROM V_PERSONAS_CLIENTES
                """.strip()
        );
    }

    @Test(
            dependsOnMethods = "testSqlSelect"
    )
    public void testSelect() {

        assertNotNull(
                M_Cliente.select(
                        Cliente
                                .builder()
                                .build()
                ),
                "Error al consultar la lista de clientes."
        );
    }

    @Test(
            groups = "cliente.insert"
    )
    public static void testInsert() {
        M_PersonaNGTest.testInsert();
        idPersona = M_PersonaNGTest.idPersona;

        Resultado result = M_Cliente.insert(
                Cliente
                        .builder()
                        .id(idPersona)
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(CLIENTE__AGREGADO__CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_INSERTAR__CLIENTE
        );
    }

    //--------------------------------------------------------------------------
    @Test(
            dependsOnMethods = "testInsert"
    )
    public static void testDelete() {
        Resultado result = M_Cliente.delete(
                Cliente
                        .builder()
                        .id(idPersona)
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(CLIENTE_BORRADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                CLIENTE_NO_PUEDE_SER_BORRADO
        );

        M_PersonaNGTest.idPersona = idPersona;
        M_PersonaNGTest.testDelete();
    }
}
