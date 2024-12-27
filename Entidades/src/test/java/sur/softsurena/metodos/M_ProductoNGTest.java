package sur.softsurena.metodos;

import java.io.File;
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
import sur.softsurena.entidades.Categoria;
import sur.softsurena.entidades.Imagen;
import sur.softsurena.entidades.Paginas;
import sur.softsurena.entidades.Producto;
import static sur.softsurena.metodos.M_Producto.ERROR_AL__INSERTAR__PRODUCTO;
import static sur.softsurena.metodos.M_Producto.ERROR_AL__MODIFICAR__PRODUCTO;
import static sur.softsurena.metodos.M_Producto.OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_EL__PR;
import static sur.softsurena.metodos.M_Producto.PRODUCTO_AGREGADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Producto.PRODUCTO__BORRADO__CORRECTAMENTE;
import static sur.softsurena.metodos.M_Producto.PRODUCTO__MODIFICADO__CORRECTAMENTE;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.imagenEncode64;

@Getter
public class M_ProductoNGTest {

    private static Integer id_producto;
    private static Producto producto, producto2;

    public M_ProductoNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        Conexion.getInstance(
                "sysdba",
                "1",
                "SoftSurena.db",
                "localhost",
                "3050"
        );
        assertTrue(
                Conexion.verificar().getEstado(),
                "Error al conectarse..."
        );

        M_CategoriaNGTest.testAgregarCategoria();
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        Conexion.getCnn().close();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        producto = Producto
                .builder()
                .id(id_producto)
                .categoria(
                        Categoria
                                .builder()
                                .id_categoria(
                                        M_CategoriaNGTest.idCategoria1
                                )
                                .build()
                )
                .codigo(
                        M_ContactoTel.generarTelMovil().substring(8, 16)
                )
                .descripcion(
                        "Descripcion Prueba %s".formatted(
                                M_ContactoTel.generarTelMovil().substring(8, 16)
                        )
                )
                .imagen(
                        Imagen
                                .builder()
                                .imagen64(
                                        imagenEncode64(
                                                new File("Imagenes/ImagenPrueba.png")
                                        )
                                )
                                .build()
                )
                .nota("Esta es una prueba del sistema.")
                .estado(Boolean.TRUE)
                .build();

        producto2 = Producto
                .builder()
                .id(id_producto)
                .categoria(
                        Categoria
                                .builder()
                                .id_categoria(
                                        M_CategoriaNGTest.idCategoria2
                                )
                                .build()
                )
                .codigo(
                        M_ContactoTel.generarTelMovil().substring(8, 16)
                )
                .descripcion(
                        "Descripcion Prueba %s".formatted(
                                M_ContactoTel.generarTelMovil().substring(8, 16)
                        )
                )
                .imagen(
                        Imagen
                                .builder()
                                .imagen64(
                                        imagenEncode64(
                                                new File("Imagenes/ImagenPrueba.png")
                                        )
                                )
                                .build()
                )
                .nota("Esta es una prueba del sistema.")
                .estado(Boolean.TRUE)
                .build();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        producto = null;
    }

    //TODO Documentar o describir bien esta prueba.
    @Test(
            enabled = true,
            description = """
                          Test que verifica si el registro de seleccion de 
                          producto existentes.
                          """,
            priority = 0
    )
    public void testGetProductos() {
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
            description = """
                          Test que verifica que se puede obtener la descripcion 
                          y la imagen de una categoria.
                          """,
            priority = 1
    )
    public void testGetProductosByCategoria() {
        assertNotNull(M_Producto.selectByCategoria(
                Categoria
                        .builder()
                        .id_categoria(-1)
                        .build()
        ), ERROR_AL_CONSULTAR_LA_BASE_DE_DATOS);

        assertNotNull(
                M_Producto.selectByCategoria(
                        Categoria
                                .builder()
                                .id_categoria(0)
                                .estado(Boolean.TRUE)
                                .build()
                ),
                ERROR_AL_CONSULTAR_LA_BASE_DE_DATOS
        );
    }
    public static final String ERROR_AL_CONSULTAR_LA_BASE_DE_DATOS
            = "Error al consultar la base de datos.";

    @Test(
            enabled = true,
            description = "Test encargada de agregar producto al sistema.",
            priority = 2
    )
    public void testAgregarProducto() {
        Resultado resultado = M_Producto.insert(producto);

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

        try {
            resultado = M_Producto.insert(producto2);
        } catch (Exception e) {
            assertEquals(
                    resultado,
                    Resultado
                            .builder()
                            .id(-1)
                            .mensaje(ERROR_AL__INSERTAR__PRODUCTO)
                            .icono(JOptionPane.ERROR_MESSAGE)
                            .estado(Boolean.FALSE)
                            .build()
            );
        }
    }

    @Test(
            enabled = true,
            description = """
                          Test que verifica que se puede obtener la descripcion 
                          y la imagen de una categoria.
                          """,
            priority = 3
    )
    public void testGetProductosByCategoria2() {
        List<Producto> result = M_Producto.selectByCategoria(
                Categoria
                        .builder()
                        .id_categoria(M_CategoriaNGTest.idCategoria1)
                        .build()
        );

        assertNotNull(
                result,
                "Error al consultar la base de datos."
        );

        result = M_Producto.selectByCategoria(
                Categoria
                        .builder()
                        .id_categoria(M_CategoriaNGTest.idCategoria1)
                        .estado(Boolean.TRUE)
                        .build()
        );
        assertNotNull(
                result,
                "Se obtuvo resultados en la consulta."
        );

        result = M_Producto.selectByCategoria(
                Categoria
                        .builder()
                        .id_categoria(M_CategoriaNGTest.idCategoria1)
                        .estado(Boolean.FALSE)
                        .build()
        );

        assertNotNull(
                result,
                "Se obtuvo resultados en la consulta."
        );

        result = M_Producto.selectByCategoria(
                Categoria
                        .builder()
                        .id_categoria(M_CategoriaNGTest.idCategoria2)
                        .build()
        );

        assertNotNull(
                result.isEmpty(),
                "Se obtuvo resultados en la consulta."
        );

        result = M_Producto.selectByCategoria(
                Categoria
                        .builder()
                        .id_categoria(M_CategoriaNGTest.idCategoria2)
                        .estado(Boolean.TRUE)
                        .build()
        );

        assertNotNull(
                result.isEmpty(),
                "Se obtuvo resultados en la consulta."
        );

        result = M_Producto.selectByCategoria(
                Categoria
                        .builder()
                        .id_categoria(M_CategoriaNGTest.idCategoria2)
                        .estado(Boolean.FALSE)
                        .build()
        );

        assertNotNull(
                result,
                "Se obtuvo resultados en la consulta."
        );
    }

    @Test(
            enabled = true,
            description = "Test encargado de modificar el producto del sistema. ",
            priority = 3
    )
    public void testModificarProducto() {
        Resultado result = M_Producto.update(producto);

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
    public void testBorrarProductoPorID() {
        Resultado result = M_Producto.deleteByID(id_producto);
        
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

        M_Categoria.borrarCategoria(
                M_CategoriaNGTest.idCategoria1
        );

        M_Categoria.borrarCategoria(
                M_CategoriaNGTest.idCategoria2
        );
    }

    @Test(
            enabled = true,
            priority = 10,
            description = """
                          
                          """
    )
    public void testSqlProductos() {
        String expResult;

        expResult = """
                    SELECT ID, ID_CATEGORIA, DESC_CATEGORIA, CODIGO, DESCRIPCION, EXISTENCIA, 
                    NOTA, FECHA_CREACION, IMAGEN_CATEGORIA, IMAGEN_PRODUCTO, 
                    ESTADO 
                    FROM GET_PRODUCTOS 
                    ORDER BY ID 
                    """;
        String result = M_Producto.sqlProductos(
                Producto
                        .builder()
                        .build()
        );
        assertEquals(result.trim().strip(), expResult.strip().trim());
//------------------------------------------------------------------------------
        expResult = """
                    SELECT ID, ID_CATEGORIA, DESC_CATEGORIA, CODIGO, DESCRIPCION, EXISTENCIA,
                    NOTA, FECHA_CREACION, IMAGEN_CATEGORIA, IMAGEN_PRODUCTO,
                    ESTADO
                    FROM GET_PRODUCTOS
                    WHERE ID = 0
                    ORDER BY ID
                    """;

        result = M_Producto.sqlProductos(
                Producto
                        .builder()
                        .id(0)
                        .build()
        );
        assertEquals(result.trim().strip(), expResult.strip().trim());
//------------------------------------------------------------------------------
        expResult = """
                    SELECT ID, ID_CATEGORIA, DESC_CATEGORIA, CODIGO, DESCRIPCION, EXISTENCIA,
                    NOTA, FECHA_CREACION, IMAGEN_CATEGORIA, IMAGEN_PRODUCTO,
                    ESTADO
                    FROM GET_PRODUCTOS
                    WHERE ID = 0 AND ESTADO
                    ORDER BY ID
                    """;

        result = M_Producto.sqlProductos(
                Producto
                        .builder()
                        .id(0)
                        .estado(Boolean.TRUE)
                        .build()
        );
        assertEquals(result.trim().strip(), expResult.strip().trim());//aqui
//------------------------------------------------------------------------------
        expResult = """
                    SELECT ID, ID_CATEGORIA, DESC_CATEGORIA, CODIGO, DESCRIPCION, EXISTENCIA,
                    NOTA, FECHA_CREACION, IMAGEN_CATEGORIA, IMAGEN_PRODUCTO,
                    ESTADO
                    FROM GET_PRODUCTOS
                    WHERE ID = 0 AND ESTADO IS FALSE
                    ORDER BY ID
                    """;

        result = M_Producto.sqlProductos(
                Producto
                        .builder()
                        .id(0)
                        .estado(Boolean.FALSE)
                        .build()
        );
        assertEquals(result.trim().strip(), expResult.strip().trim());
//------------------------------------------------------------------------------
        expResult = """
                    SELECT ID, ID_CATEGORIA, DESC_CATEGORIA, CODIGO, DESCRIPCION, EXISTENCIA,
                    NOTA, FECHA_CREACION, IMAGEN_CATEGORIA, IMAGEN_PRODUCTO,
                    ESTADO
                    FROM GET_PRODUCTOS
                    WHERE ID = 0 AND ESTADO IS FALSE OR TRIM(CODIGO) STARTING WITH TRIM('0') OR
                                           TRIM(CODIGO) CONTAINING TRIM('0') OR
                                           TRIM(DESCRIPCION) STARTING WITH TRIM('0') OR
                                           TRIM(DESCRIPCION) CONTAINING TRIM('0') OR
                                           ID_CATEGORIA IN(
                                                          SELECT ID
                                                          FROM VS_CATEGORIAS
                                                          WHERE UPPER(TRIM(DESCRIPCION)) STARTING WITH UPPER(TRIM('0'))
                                           )
                    ORDER BY ID
                    """;

        result = M_Producto.sqlProductos(
                Producto
                        .builder()
                        .id(0)
                        .estado(Boolean.FALSE)
                        .codigo("0")
                        .descripcion("0")
                        .categoria(
                                Categoria
                                        .builder()
                                        .descripcion("0")
                                        .build()
                        )
                        .build()
        );
        assertEquals(result.trim().strip(), expResult.strip().trim());
//------------------------------------------------------------------------------
        expResult = """
                    SELECT ID, ID_CATEGORIA, DESC_CATEGORIA, CODIGO, DESCRIPCION, EXISTENCIA,
                    NOTA, FECHA_CREACION, IMAGEN_CATEGORIA, IMAGEN_PRODUCTO,
                    ESTADO
                    FROM GET_PRODUCTOS
                    WHERE ID = 0 AND ESTADO IS FALSE OR TRIM(CODIGO) STARTING WITH TRIM('0') OR
                                           TRIM(CODIGO) CONTAINING TRIM('0') OR
                                           TRIM(DESCRIPCION) STARTING WITH TRIM('0') OR
                                           TRIM(DESCRIPCION) CONTAINING TRIM('0') OR
                                           ID_CATEGORIA IN(
                                                          SELECT ID
                                                          FROM VS_CATEGORIAS
                                                          WHERE UPPER(TRIM(DESCRIPCION)) STARTING WITH UPPER(TRIM('0'))
                                           )
                    ORDER BY ID
                    """;

        result = M_Producto.sqlProductos(
                Producto
                        .builder()
                        .id(0)
                        .estado(Boolean.FALSE)
                        .codigo("0")
                        .descripcion("0")
                        .categoria(
                                Categoria
                                        .builder()
                                        .descripcion("0")
                                        .build()
                        )
                        .build()
        );
        assertEquals(result.trim().strip(), expResult.strip().trim());
//------------------------------------------------------------------------------
        expResult = """
                    SELECT ID, ID_CATEGORIA, DESC_CATEGORIA, CODIGO, DESCRIPCION, EXISTENCIA,
                    NOTA, FECHA_CREACION, IMAGEN_CATEGORIA, IMAGEN_PRODUCTO,
                    ESTADO
                    FROM GET_PRODUCTOS
                    WHERE ID = 0 AND ESTADO IS FALSE OR TRIM(CODIGO) STARTING WITH TRIM('0') OR
                                           TRIM(CODIGO) CONTAINING TRIM('0') OR
                                           TRIM(DESCRIPCION) STARTING WITH TRIM('0') OR
                                           TRIM(DESCRIPCION) CONTAINING TRIM('0') OR
                                           ID_CATEGORIA IN(
                                                          SELECT ID
                                                          FROM VS_CATEGORIAS
                                                          WHERE UPPER(TRIM(DESCRIPCION)) STARTING WITH UPPER(TRIM('0'))
                                           )
                    ORDER BY ID
                    ROWS (1 - 1) * 20 + 1 TO (1 + (1 - 1)) * 20;
                    """;

        result = M_Producto.sqlProductos(
                Producto
                        .builder()
                        .id(0)
                        .estado(Boolean.FALSE)
                        .codigo("0")
                        .descripcion("0")
                        .categoria(
                                Categoria
                                        .builder()
                                        .descripcion("0")
                                        .build()
                        )
                        .pagina(
                                Paginas
                                        .builder()
                                        .nPaginaNro(1)
                                        .nCantidadFilas(20)
                                        .build()
                        )
                        .build()
        );
        assertEquals(result.trim().strip(), expResult.strip().trim());
//------------------------------------------------------------------------------

        expResult = """
                    SELECT ID, ID_CATEGORIA, DESC_CATEGORIA, CODIGO, DESCRIPCION, EXISTENCIA,
                    NOTA, FECHA_CREACION, IMAGEN_CATEGORIA, IMAGEN_PRODUCTO,
                    ESTADO
                    FROM GET_PRODUCTOS
                    WHERE ESTADO IS FALSE OR TRIM(CODIGO) STARTING WITH TRIM('0') OR
                                           TRIM(CODIGO) CONTAINING TRIM('0') OR
                                           TRIM(DESCRIPCION) STARTING WITH TRIM('0') OR
                                           TRIM(DESCRIPCION) CONTAINING TRIM('0') OR
                                           ID_CATEGORIA IN(
                                                          SELECT ID
                                                          FROM VS_CATEGORIAS
                                                          WHERE UPPER(TRIM(DESCRIPCION)) STARTING WITH UPPER(TRIM('0'))
                                           )
                    ORDER BY ID
                    ROWS (1 - 1) * 20 + 1 TO (1 + (1 - 1)) * 20;
                    """;

        result = M_Producto.sqlProductos(
                Producto
                        .builder()
                        .estado(Boolean.FALSE)
                        .codigo("0")
                        .descripcion("0")
                        .categoria(
                                Categoria
                                        .builder()
                                        .descripcion("0")
                                        .build()
                        )
                        .pagina(
                                Paginas
                                        .builder()
                                        .nPaginaNro(1)
                                        .nCantidadFilas(20)
                                        .build()
                        )
                        .build()
        );
        assertEquals(result.trim().strip(), expResult.strip().trim());
//------------------------------------------------------------------------------

        expResult = """
                    SELECT ID, ID_CATEGORIA, DESC_CATEGORIA, CODIGO, DESCRIPCION, EXISTENCIA,
                    NOTA, FECHA_CREACION, IMAGEN_CATEGORIA, IMAGEN_PRODUCTO,
                    ESTADO
                    FROM GET_PRODUCTOS
                    WHERE ESTADO OR TRIM(CODIGO) STARTING WITH TRIM('0') OR
                                           TRIM(CODIGO) CONTAINING TRIM('0') OR
                                           TRIM(DESCRIPCION) STARTING WITH TRIM('0') OR
                                           TRIM(DESCRIPCION) CONTAINING TRIM('0') OR
                                           ID_CATEGORIA IN(
                                                          SELECT ID
                                                          FROM VS_CATEGORIAS
                                                          WHERE UPPER(TRIM(DESCRIPCION)) STARTING WITH UPPER(TRIM('0'))
                                           )
                    ORDER BY ID
                    ROWS (1 - 1) * 20 + 1 TO (1 + (1 - 1)) * 20;
                    """;

        result = M_Producto.sqlProductos(
                Producto
                        .builder()
                        .estado(Boolean.TRUE)
                        .codigo("0")
                        .descripcion("0")
                        .categoria(
                                Categoria
                                        .builder()
                                        .descripcion("0")
                                        .build()
                        )
                        .pagina(
                                Paginas
                                        .builder()
                                        .nPaginaNro(1)
                                        .nCantidadFilas(20)
                                        .build()
                        )
                        .build()
        );
        assertEquals(result.trim().strip(), expResult.strip().trim());
//------------------------------------------------------------------------------

        expResult = """
                    SELECT ID, ID_CATEGORIA, DESC_CATEGORIA, CODIGO, DESCRIPCION, EXISTENCIA,
                    NOTA, FECHA_CREACION, IMAGEN_CATEGORIA, IMAGEN_PRODUCTO,
                    ESTADO
                    FROM GET_PRODUCTOS
                    WHERE TRIM(CODIGO) STARTING WITH TRIM('0') OR
                                           TRIM(CODIGO) CONTAINING TRIM('0') OR
                                           TRIM(DESCRIPCION) STARTING WITH TRIM('0') OR
                                           TRIM(DESCRIPCION) CONTAINING TRIM('0') OR
                                           ID_CATEGORIA IN(
                                                          SELECT ID
                                                          FROM VS_CATEGORIAS
                                                          WHERE UPPER(TRIM(DESCRIPCION)) STARTING WITH UPPER(TRIM('0'))
                                           )
                    ORDER BY ID
                    ROWS (1 - 1) * 20 + 1 TO (1 + (1 - 1)) * 20;
                    """;

        result = M_Producto.sqlProductos(
                Producto
                        .builder()
                        .codigo("0")
                        .descripcion("0")
                        .categoria(
                                Categoria
                                        .builder()
                                        .descripcion("0")
                                        .build()
                        )
                        .pagina(
                                Paginas
                                        .builder()
                                        .nPaginaNro(1)
                                        .nCantidadFilas(20)
                                        .build()
                        )
                        .build()
        );
        assertEquals(result.trim().strip(), expResult.strip().trim());
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
}
