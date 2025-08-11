package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.EntradaProducto;
import sur.softsurena.entidades.Persona;
import static sur.softsurena.metodos.M_Entrada_Producto.ENTRADA_ELIMINADA_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Entrada_Producto.ENTRADA_REGISTRADA_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Entrada_Producto.PRODUCTO_AGREGADO_CORRECTAMENTE;
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
public class M_Entrada_ProductoNGTest {

    private static Resultado resultado;
    private static Integer idPersona;

    @Test
    public void testSqlSelect() {
        assertEquals(
                M_Entrada_Producto.sqlSelect(
                        EntradaProducto
                                .builder()
                                .build()
                ),
                """
                SELECT ID, ID_PROVEEDOR, ID_ALMACEN, COD_FACTURA, FECHA_ENTRADA
                FROM V_M_ENTRADA_PRODUCTOS
                """.strip()
        );

        assertEquals(
                M_Entrada_Producto.sqlSelect(
                        EntradaProducto
                                .builder()
                                .id(0)
                                .build()
                ),
                """
                SELECT ID, ID_PROVEEDOR, ID_ALMACEN, COD_FACTURA, FECHA_ENTRADA
                FROM V_M_ENTRADA_PRODUCTOS
                WHERE ID = 0
                """.strip()
        );

        assertEquals(
                M_Entrada_Producto.sqlSelect(
                        EntradaProducto
                                .builder()
                                .idProveedor(0)
                                .build()
                ),
                """
                SELECT ID, ID_PROVEEDOR, ID_ALMACEN, COD_FACTURA, FECHA_ENTRADA
                FROM V_M_ENTRADA_PRODUCTOS
                WHERE ID_PROVEEDOR = 0
                """.strip()
        );

        assertEquals(
                M_Entrada_Producto.sqlSelect(
                        EntradaProducto
                                .builder()
                                .idAlmacen(0)
                                .build()
                ),
                """
                SELECT ID, ID_PROVEEDOR, ID_ALMACEN, COD_FACTURA, FECHA_ENTRADA
                FROM V_M_ENTRADA_PRODUCTOS
                WHERE ID_ALMACEN = 0
                """.strip()
        );
    }

    @Test(
            dependsOnMethods = "testSqlSelect"
    )
    public void testSelect() {
        assertNotNull(
                M_Entrada_Producto.select(
                        EntradaProducto.builder().build()
                )
        );

        assertNotNull(
                M_Entrada_Producto.select(
                        EntradaProducto
                                .builder()
                                .id(0)
                                .build()
                )
        );

        assertNotNull(
                M_Entrada_Producto.select(
                        EntradaProducto
                                .builder()
                                .idProveedor(0)
                                .build()
                )
        );

        assertNotNull(
                M_Entrada_Producto.select(
                        EntradaProducto
                                .builder()
                                .idAlmacen(0)
                                .build()
                )
        );
    }

    @Test(
            dependsOnMethods = "testSelect"
    )
    public void testInsert() {
        M_PersonaNGTest.persona = Persona
                .builder()
                .persona('J')
                .pnombre("MEntradaProducto")
                .snombre("MEntradaProducto")
                .apellidos("MEntradaProducto")
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

        resultado = M_Entrada_Producto.insert(
                EntradaProducto
                        .builder()
                        .idProveedor(idPersona)
                        .idAlmacen(0)
                        .cod_factura(M_Generales.generarCedula())
                        .estado('t')
                        .build()
        );

        assertEquals(
                resultado,
                Resultado
                        .builder()
                        .mensaje(PRODUCTO_AGREGADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            dependsOnMethods = "testInsert"
    )
    public void testUpdate() {
        assertEquals(
                M_Entrada_Producto.update(
                        EntradaProducto
                                .builder()
                                .id(resultado.getId())
                                .idProveedor(idPersona)
                                .idAlmacen(0)
                                .cod_factura(M_Generales.generarCedula())
                                .estado('d')
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(ENTRADA_REGISTRADA_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            dependsOnMethods = {"testInsert", "testUpdate"}
    )
    public void testDelete() {
        assertEquals(
                M_Entrada_Producto.delete(
                        EntradaProducto
                                .builder()
                                .id(resultado.getId())
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(ENTRADA_ELIMINADA_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
        M_PersonaNGTest.idPersona = idPersona;
        M_PersonaNGTest.testDelete();
    }
}
