package sur.softsurena.metodos;

import java.util.List;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Paginas;
import sur.softsurena.entidades.Producto;
import static sur.softsurena.metodos.M_Producto.ERROR_AL__MODIFICAR__PRODUCTO;
import static sur.softsurena.metodos.M_Producto.OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_EL__PR;
import static sur.softsurena.metodos.M_Producto.PRODUCTO_AGREGADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Producto.PRODUCTO__BORRADO__CORRECTAMENTE;
import static sur.softsurena.metodos.M_Producto.PRODUCTO__MODIFICADO__CORRECTAMENTE;
import sur.softsurena.utilidades.Resultado;

@Getter
public class M_ProductoNGTest {

    private static Integer id_producto;

    public M_ProductoNGTest() {
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
    
    @Test(
            enabled = true,
            priority = 0,
            description = """
                          
                          """
    )
    public void testSqlProductos() {
        assertEquals(
                M_Producto.sqlProductos(
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
                M_Producto.sqlProductos(
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
                M_Producto.sqlProductos(
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
                M_Producto.sqlProductos(
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
                M_Producto.sqlProductos(
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
                M_Producto.sqlProductos(
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
                M_Producto.sqlProductos(
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
                M_Producto.sqlProductos(
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
                M_Producto.sqlProductos(
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
                M_Producto.sqlProductos(
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
                M_Producto.sqlProductos(
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
                M_Producto.sqlProductos(
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
                M_Producto.sqlProductos(
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
            enabled = true,
            description = """
                          Test que verifica si el registro de seleccion de 
                          producto existentes.
                          """,
            priority = 0
    )
    public void testSelect() {
        List<Producto> productos = M_Producto.select(
                Producto
                        .builder()
                        .build()
        );

        assertFalse(
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
        assertFalse(
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
        assertFalse(
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
        assertFalse(
                productos.isEmpty(),
                "No se encontraron registros en la tabla de producto."
        );
    }


    @Test(
            enabled = true,
            description = "Test encargada de agregar producto al sistema.",
            priority = 2
    )
    public static void testInsert() {
        M_CategoriaNGTest.testInsert();
        Resultado resultado = M_Producto.insert(producto(Boolean.TRUE));

        assertEquals(
                resultado,
                Resultado
                        .builder()
                        .mensaje(PRODUCTO_AGREGADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );

        id_producto = resultado.getId();
    }

    @Test(
            enabled = true,
            description = "Test encargado de modificar el producto del sistema. ",
            priority = 3
    )
    public void testUpdate() {
        Resultado result = M_Producto.update(producto(Boolean.TRUE));

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
            enabled = false,
            description = "",
            priority = 1
    )
    public void testExisteCategoriaProductos() {
        int idCategoria = 0;
        boolean expResult = false;
        boolean result = M_Producto.existeCategoriaProductos(idCategoria);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            description = """
                          """,
            priority = 1
    )
    public void testExisteProducto() {
        String criterio = "";
        boolean expResult = false;
        boolean result = M_Producto.existeProducto(criterio);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = true,
            description = "",
            priority = 10
    )
    public static void testDeleteByID() {
        Resultado result = M_Producto.delete(id_producto);

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

        M_Categoria.delete(
                M_CategoriaNGTest.idCategoria
        );
    }

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Metodo que genera Productos aleatorio.
                          """
    )
    public void testGenerarProducto() {
        assertNotNull(
                M_Producto.generarProducto(),
                "Producto NO Genereado"
        );
    }

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Metodo que genera codigo de barra aleatorio.
                          """
    )
    public void testGenerarCodigoBarra() {
        assertNotNull(
                M_Producto.generarCodigoBarra(),
                "Codigo Barra No generado");
    }
    
    public synchronized static Producto producto(Boolean estado) {
        return Producto
                .builder()
                .id(id_producto)
                .idCategoria(M_CategoriaNGTest.idCategoria)
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
