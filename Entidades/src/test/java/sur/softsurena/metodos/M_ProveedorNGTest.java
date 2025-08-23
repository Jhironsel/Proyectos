package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Proveedor;
import static sur.softsurena.metodos.M_Proveedor.CONSULTA_MODIFICADO_CORRECTAMENTE;
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
public class M_ProveedorNGTest {

    public static Integer idPersona;

    @Test
    public void testSqlProveedor() {
        assertEquals(
                M_Proveedor.sqlProveedor(Proveedor.builder().build()),
                """
                SELECT ID, CODIGO
                FROM V_PERSONAS_PROVEEDORES_ATR"""
        );
        assertEquals(
                M_Proveedor.sqlProveedor(
                        Proveedor
                                .builder()
                                .idPersona(-1)
                                .build()
                ),
                """
                SELECT ID, CODIGO
                FROM V_PERSONAS_PROVEEDORES_ATR
                WHERE ID = -1"""
        );
        assertEquals(
                M_Proveedor.sqlProveedor(
                        Proveedor
                                .builder()
                                .codigoProveedor("000-0000")
                                .build()
                ),
                """
                SELECT ID, CODIGO
                FROM V_PERSONAS_PROVEEDORES_ATR
                WHERE CODIGO STARTING WITH '000-0000'"""
        );
    }

    @Test(
            dependsOnMethods = "testSqlProveedor"
    )
    public void testSelectATR() {
        assertNotNull(
                M_Proveedor.selectATR(
                        Proveedor
                                .builder()
                                .build()
                ),
                "Error al consultar los proveedores."
        );

        assertNotNull(
                M_Proveedor.selectATR(
                        Proveedor
                                .builder()
                                .idPersona(0)
                                .build()
                ),
                "Error al consultar los proveedores."
        );

        assertNotNull(
                M_Proveedor.selectATR(
                        Proveedor
                                .builder()
                                .codigoProveedor("000-0000")
                                .build()
                ),
                "Error al consultar los proveedores."
        );
    }

    @Test
    public void testSelect() {
        assertNotNull(
                M_Proveedor.select(
                        Proveedor.builder().build()
                ),
                "Error a consultar la lista de proveedores."
        );
    }

//------------------------------------------------------------------------------
    @Test(
            groups = "proveedor.insert"
    )
    public void testInsert() {
        M_PersonaNGTest.persona = Proveedor
                .builder()
                .persona('J')
                .pnombre("MProveedor")
                .snombre("MProveedor")
                .apellidos("MProveedor")
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

        Resultado result = M_Proveedor.insert(
                Proveedor
                        .builder()
                        .idPersona(idPersona)
                        .codigoProveedor(M_ContactoTel.generarTelMovil())
                        .build()
        );

        assertTrue(
                result.getEstado(),
                "Error al registrar el proveedor."
        );
    }

//------------------------------------------------------------------------------
    @Test(
            dependsOnMethods = "testInsert"
    )
    public void testUpdate() {
        assertEquals(
                M_Proveedor.update(
                        Proveedor
                                .builder()
                                .idPersona(idPersona)
                                .codigoProveedor(
                                        M_ContactoTel
                                                .generarTelMovil()
                                )
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(CONSULTA_MODIFICADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

//------------------------------------------------------------------------------
    @Test(
            dependsOnMethods = {"testInsert", "testUpdate"}
    )
    public void testDelete() {
        assertTrue(
                M_Proveedor.delete(
                        Proveedor
                                .builder()
                                .idPersona(idPersona)
                                .build()
                ).getEstado(),
                "Error al eliminar el proveedor."
        );

        M_PersonaNGTest.idPersona = idPersona;
        M_PersonaNGTest.testDelete();
    }

}
