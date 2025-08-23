package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.entidades.Paginas;
import static sur.softsurena.metodos.M_Cliente.CLIENTE_BORRADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Cliente.CLIENTE_NO_PUEDE_SER_BORRADO;
import static sur.softsurena.metodos.M_Cliente.CLIENTE__AGREGADO__CORRECTAMENTE;
import static sur.softsurena.metodos.M_Cliente.ERROR_AL_INSERTAR__CLIENTE;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.javaDateToSqlDate;
import static sur.softsurena.utilidades.Utilidades.stringToDate;

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
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO,
                    FECHA_NACIMIENTO, FECHA_INGRESO, ESTADO, ID_TIPO_SANGRE,
                    CEDULA, ESTADO_CIVIL, TOTAL_FACTURADO, TOTAL_DEUDA,
                    CANTIDAD_FACTURA, FECHA_ULTIMA_COMPRA
                FROM V_PERSONAS_CLIENTES_GEN
                """.strip()
        );
        assertEquals(
                M_Cliente.sqlSelect(
                        Cliente
                                .builder()
                                .idPersona(1)
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO,
                    FECHA_NACIMIENTO, FECHA_INGRESO, ESTADO, ID_TIPO_SANGRE,
                    CEDULA, ESTADO_CIVIL, TOTAL_FACTURADO, TOTAL_DEUDA,
                    CANTIDAD_FACTURA, FECHA_ULTIMA_COMPRA
                FROM V_PERSONAS_CLIENTES_GEN
                WHERE ID = 1
                """.strip()
        );
        assertEquals(
                M_Cliente.sqlSelect(
                        Cliente
                                .builder()
                                .pagina(
                                        Paginas
                                                .builder()
                                                .nPaginaNro(1)
                                                .nCantidadFilas(20)
                                                .build()
                                )
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO,
                    FECHA_NACIMIENTO, FECHA_INGRESO, ESTADO, ID_TIPO_SANGRE,
                    CEDULA, ESTADO_CIVIL, TOTAL_FACTURADO, TOTAL_DEUDA,
                    CANTIDAD_FACTURA, FECHA_ULTIMA_COMPRA
                FROM V_PERSONAS_CLIENTES_GEN
                ROWS (1 - 1) * 20 + 1 TO (1 + (1 - 1)) * 20;
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
        assertNotNull(
                M_Cliente.select(
                        Cliente
                                .builder()
                                .idPersona(1)
                                .build()
                ),
                "Error al consultar la lista de clientes. Por ID"
        );
        assertNotNull(
                M_Cliente.select(
                        Cliente
                                .builder()
                                .pagina(
                                        Paginas
                                                .builder()
                                                .nPaginaNro(1)
                                                .nCantidadFilas(20)
                                                .build()
                                )
                                .build()
                ),
                "Error al consultar la lista de clientes. Por Row"
        );
    }

    @Test(
            groups = "cliente.insert"
    )
    public static void testInsert() {
        M_PersonaNGTest.persona = Cliente
                .builder()
                .persona('J')
                .pnombre("MCliente")
                .snombre("MCliente")
                .apellidos("MCliente")
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

        Resultado result = M_Cliente.insert(
                Cliente
                        .builder()
                        .idPersona(idPersona)
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
                        .idPersona(idPersona)
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
