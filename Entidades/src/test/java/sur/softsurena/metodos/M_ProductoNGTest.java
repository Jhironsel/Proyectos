package sur.softsurena.metodos;

import java.util.List;
import javax.swing.JOptionPane;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Paginas;
import sur.softsurena.entidades.Producto;
import static sur.softsurena.metodos.M_Producto.ERROR_AL__MODIFICAR__PRODUCTO;
import static sur.softsurena.metodos.M_Producto.OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_EL__PR;
import static sur.softsurena.metodos.M_Producto.PRODUCTO_AGREGADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Producto.PRODUCTO__BORRADO__CORRECTAMENTE;
import static sur.softsurena.metodos.M_Producto.PRODUCTO__MODIFICADO__CORRECTAMENTE;
import sur.softsurena.utilidades.Resultado;

@Test(
        dependsOnGroups = "init"
)
public class M_ProductoNGTest {

    public static Integer idProducto, idCategoria;
    
    @Test
    public void testSqlSelect() {
        assertEquals(
                M_Producto.sqlSelect(
                        Producto
                                .builder()
                                .build()
                ),
                """
                SELECT ID, ID_CATEGORIA, CODIGO, DESCRIPCION,
                 EXISTENCIA, FECHA_CREACION, ESTADO, NOTA
                FROM V_PRODUCTOS
                ORDER BY ID 
                """.strip().trim()
        );
//------------------------------------------------------------------------------
        assertEquals(
                M_Producto.sqlSelect(
                        Producto
                                .builder()
                                .id(0)
                                .build()
                ),
                """
                SELECT ID, ID_CATEGORIA, CODIGO, DESCRIPCION,
                 EXISTENCIA, FECHA_CREACION, ESTADO, NOTA
                FROM V_PRODUCTOS
                WHERE ID = 0
                ORDER BY ID
                """.strip().trim()
        );

//------------------------------------------------------------------------------
        assertEquals(
                M_Producto.sqlSelect(
                        Producto
                                .builder()
                                .idCategoria(0)
                                .build()
                ),
                """
                SELECT ID, ID_CATEGORIA, CODIGO, DESCRIPCION,
                 EXISTENCIA, FECHA_CREACION, ESTADO, NOTA
                FROM V_PRODUCTOS
                WHERE ID_CATEGORIA = 0
                ORDER BY ID
                """.strip().trim()
        );

//------------------------------------------------------------------------------
        assertEquals(
                M_Producto.sqlSelect(
                        Producto
                                .builder()
                                .idCategoria(0)
                                .estado(Boolean.TRUE)
                                .build()
                ),
                """
                SELECT ID, ID_CATEGORIA, CODIGO, DESCRIPCION,
                 EXISTENCIA, FECHA_CREACION, ESTADO, NOTA
                FROM V_PRODUCTOS
                WHERE ESTADO AND ID_CATEGORIA = 0
                ORDER BY ID
                """.strip().trim()
        );

//------------------------------------------------------------------------------
        assertEquals(
                M_Producto.sqlSelect(
                        Producto
                                .builder()
                                .idCategoria(0)
                                .estado(Boolean.FALSE)
                                .build()
                ),
                """
                SELECT ID, ID_CATEGORIA, CODIGO, DESCRIPCION,
                 EXISTENCIA, FECHA_CREACION, ESTADO, NOTA
                FROM V_PRODUCTOS
                WHERE ESTADO IS FALSE AND ID_CATEGORIA = 0
                ORDER BY ID
                """.strip().trim()
        );

//------------------------------------------------------------------------------
        assertEquals(
                M_Producto.sqlSelect(
                        Producto
                                .builder()
                                .id(0)
                                .estado(Boolean.TRUE)
                                .build()
                ),
                """
                SELECT ID, ID_CATEGORIA, CODIGO, DESCRIPCION,
                 EXISTENCIA, FECHA_CREACION, ESTADO, NOTA
                FROM V_PRODUCTOS
                WHERE ID = 0 AND ESTADO
                ORDER BY ID
                """.strip().trim()
        );
//------------------------------------------------------------------------------
        assertEquals(
                M_Producto.sqlSelect(
                        Producto
                                .builder()
                                .id(0)
                                .estado(Boolean.FALSE)
                                .build()
                ),
                """
                SELECT ID, ID_CATEGORIA, CODIGO, DESCRIPCION,
                 EXISTENCIA, FECHA_CREACION, ESTADO, NOTA
                FROM V_PRODUCTOS
                WHERE ID = 0 AND ESTADO IS FALSE
                ORDER BY ID
                """.strip().trim()
        );
//------------------------------------------------------------------------------
        assertEquals(
                M_Producto.sqlSelect(
                        Producto
                                .builder()
                                .id(0)
                                .estado(Boolean.TRUE)
                                .codigo("0")
                                .descripcion("0")
                                .build()
                ),
                """
                SELECT ID, ID_CATEGORIA, CODIGO, DESCRIPCION,
                 EXISTENCIA, FECHA_CREACION, ESTADO, NOTA
                FROM V_PRODUCTOS
                WHERE ID = 0 AND ESTADO OR TRIM(CODIGO) STARTING WITH TRIM('0') OR
                                       TRIM(CODIGO) CONTAINING TRIM('0') OR
                                       TRIM(DESCRIPCION) STARTING WITH TRIM('0') OR
                                       TRIM(DESCRIPCION) CONTAINING TRIM('0')
                ORDER BY ID
                """.strip().trim()
        );
//------------------------------------------------------------------------------
        assertEquals(
                M_Producto.sqlSelect(
                        Producto
                                .builder()
                                .id(0)
                                .estado(Boolean.FALSE)
                                .codigo("0")
                                .descripcion("0")
                                .build()
                ),
                """
                SELECT ID, ID_CATEGORIA, CODIGO, DESCRIPCION,
                 EXISTENCIA, FECHA_CREACION, ESTADO, NOTA
                FROM V_PRODUCTOS
                WHERE ID = 0 AND ESTADO IS FALSE OR TRIM(CODIGO) STARTING WITH TRIM('0') OR
                                       TRIM(CODIGO) CONTAINING TRIM('0') OR
                                       TRIM(DESCRIPCION) STARTING WITH TRIM('0') OR
                                       TRIM(DESCRIPCION) CONTAINING TRIM('0')
                ORDER BY ID
                """.strip().trim()
        );
//------------------------------------------------------------------------------
        assertEquals(
                M_Producto.sqlSelect(
                        Producto
                                .builder()
                                .estado(Boolean.TRUE)
                                .codigo("0")
                                .descripcion("0")
                                .build()
                ),
                """
                SELECT ID, ID_CATEGORIA, CODIGO, DESCRIPCION,
                 EXISTENCIA, FECHA_CREACION, ESTADO, NOTA
                FROM V_PRODUCTOS
                WHERE ESTADO OR TRIM(CODIGO) STARTING WITH TRIM('0') OR
                                       TRIM(CODIGO) CONTAINING TRIM('0') OR
                                       TRIM(DESCRIPCION) STARTING WITH TRIM('0') OR
                                       TRIM(DESCRIPCION) CONTAINING TRIM('0')
                ORDER BY ID
                """.strip().trim()
        );
//------------------------------------------------------------------------------
        assertEquals(
                M_Producto.sqlSelect(
                        Producto
                                .builder()
                                .id(0)
                                .estado(Boolean.FALSE)
                                .codigo("0")
                                .descripcion("0")
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
                SELECT ID, ID_CATEGORIA, CODIGO, DESCRIPCION,
                 EXISTENCIA, FECHA_CREACION, ESTADO, NOTA
                FROM V_PRODUCTOS
                WHERE ID = 0 AND ESTADO IS FALSE OR TRIM(CODIGO) STARTING WITH TRIM('0') OR
                                       TRIM(CODIGO) CONTAINING TRIM('0') OR
                                       TRIM(DESCRIPCION) STARTING WITH TRIM('0') OR
                                       TRIM(DESCRIPCION) CONTAINING TRIM('0')
                ORDER BY ID
                ROWS (1 - 1) * 20 + 1 TO (1 + (1 - 1)) * 20;
                """.strip().trim()
        );
//------------------------------------------------------------------------------
        assertEquals(
                M_Producto.sqlSelect(
                        Producto
                                .builder()
                                .estado(Boolean.FALSE)
                                .codigo("0")
                                .descripcion("0")
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
                SELECT ID, ID_CATEGORIA, CODIGO, DESCRIPCION,
                 EXISTENCIA, FECHA_CREACION, ESTADO, NOTA
                FROM V_PRODUCTOS
                WHERE ESTADO IS FALSE OR TRIM(CODIGO) STARTING WITH TRIM('0') OR
                                       TRIM(CODIGO) CONTAINING TRIM('0') OR
                                       TRIM(DESCRIPCION) STARTING WITH TRIM('0') OR
                                       TRIM(DESCRIPCION) CONTAINING TRIM('0')
                ORDER BY ID
                ROWS (1 - 1) * 20 + 1 TO (1 + (1 - 1)) * 20;
                """.strip().trim()
        );
//------------------------------------------------------------------------------
        assertEquals(
                M_Producto.sqlSelect(
                        Producto
                                .builder()
                                .estado(Boolean.TRUE)
                                .codigo("0")
                                .descripcion("0")
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
                SELECT ID, ID_CATEGORIA, CODIGO, DESCRIPCION,
                 EXISTENCIA, FECHA_CREACION, ESTADO, NOTA
                FROM V_PRODUCTOS
                WHERE ESTADO OR TRIM(CODIGO) STARTING WITH TRIM('0') OR
                                       TRIM(CODIGO) CONTAINING TRIM('0') OR
                                       TRIM(DESCRIPCION) STARTING WITH TRIM('0') OR
                                       TRIM(DESCRIPCION) CONTAINING TRIM('0')
                ORDER BY ID
                ROWS (1 - 1) * 20 + 1 TO (1 + (1 - 1)) * 20;
                """.strip().trim()
        );
//------------------------------------------------------------------------------

        assertEquals(
                M_Producto.sqlSelect(
                        Producto
                                .builder()
                                .codigo("0")
                                .descripcion("0")
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
                SELECT ID, ID_CATEGORIA, CODIGO, DESCRIPCION,
                 EXISTENCIA, FECHA_CREACION, ESTADO, NOTA
                FROM V_PRODUCTOS
                WHERE TRIM(CODIGO) STARTING WITH TRIM('0') OR
                                       TRIM(CODIGO) CONTAINING TRIM('0') OR
                                       TRIM(DESCRIPCION) STARTING WITH TRIM('0') OR
                                       TRIM(DESCRIPCION) CONTAINING TRIM('0')
                ORDER BY ID
                ROWS (1 - 1) * 20 + 1 TO (1 + (1 - 1)) * 20;
                """.strip().trim()
        );
    }

    @Test(
            dependsOnMethods = "testSqlSelect"
    )
    public void testSelect() {
        List<Producto> productos = M_Producto.select(
                Producto
                        .builder()
                        .build()
        );

        assertNotNull(
                productos.isEmpty(),
                "No se encontraron registros en la tabla de productos."
        );

        //----------------------------------------------------------------------
        productos = M_Producto.select(
                Producto
                        .builder()
                        .estado(Boolean.TRUE)
                        .build()
        );
        assertNotNull(
                productos.isEmpty(),
                "No se encontraron registros en la tabla de productos."
        );

        //----------------------------------------------------------------------
        productos = M_Producto.select(
                Producto
                        .builder()
                        .estado(Boolean.FALSE)
                        .build()
        );
        assertNotNull(
                productos.isEmpty(),
                "No se encontraron registros en la tabla de productos."
        );

        //----------------------------------------------------------------------
        productos = M_Producto.select(
                Producto
                        .builder()
                        .pagina(
                                Paginas
                                        .builder()
                                        .nPaginaNro(1)
                                        .nCantidadFilas(20)
                                        .build()
                        )
                        .build()
        );
        assertNotNull(
                productos.isEmpty(),
                "No se encontraron registros en la tabla de producto."
        );
    }

    @Test
    public static void testInsert() {
        M_CategoriaNGTest.testInsert();
        idCategoria = M_CategoriaNGTest.idCategoria;
        
        Resultado resultado = M_Producto.insert(
                producto(Boolean.TRUE)
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

        idProducto = resultado.getId();
    }

    @Test(
            dependsOnMethods = {"testInsert"}
    )
    public void testUpdate() {
        Resultado result = M_Producto.update(
                producto(Boolean.TRUE)
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(PRODUCTO__MODIFICADO__CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL__MODIFICAR__PRODUCTO
        );
    }
    
    @Test(
            dependsOnMethods = {"testInsert", "testUpdate"}
    )
    public static void testDeleteProducto(){
        M_PrecioNGTest.idProducto = idProducto;
        M_PrecioNGTest.testDelete2();
    }

    @Test(
            dependsOnMethods = "testDeleteProducto"
    )
    public static void testDeleteByID() {
        
        Resultado result = M_Producto.delete(idProducto);

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(PRODUCTO__BORRADO__CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_EL__PR
        );
    }
    
    @Test(
            dependsOnMethods = "testDeleteByID"
    )
    public static void testDeleteCategoria(){
        M_CategoriaNGTest.idCategoria = idCategoria;
        M_CategoriaNGTest.testDelete();
    }

    @Test
    public static void testGenerarProducto() {
        assertNotNull(
                M_Producto.generarProducto(),
                "Producto NO Genereado"
        );
    }

    @Test
    public void testGenerarCodigoBarra() {
        assertNotNull(
                M_Producto.generarCodigoBarra(),
                "Codigo Barra No generado"
        );
    }

    public synchronized static Producto producto(Boolean estado) {
        return Producto
                .builder()
                .id(idProducto)
                .idCategoria(idCategoria)
                .codigo(
                        M_ContactoTel.generarTelMovil().substring(8, 16)
                )
                .descripcion(
                        "Descripcion Prueba %s".formatted(
                                M_ContactoTel.generarTelMovil().substring(8, 16)
                        )
                )
                .nota("Esta es una prueba del sistema.")
                .estado(estado)
                .build();
    }
}
