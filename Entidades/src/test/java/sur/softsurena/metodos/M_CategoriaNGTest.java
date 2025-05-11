package sur.softsurena.metodos;

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
import static sur.softsurena.metodos.M_Categoria.SE_MODIFICO_LA_CATEGORIA_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Producto.generarCodigoBarra;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_CategoriaNGTest {

    public static int idCategoria;

    public M_CategoriaNGTest() {
        System.out.println("sur.softsurena.metodos.M_CategoriaNGTest.<init>()");
    }

    @BeforeClass
    public void setUpClass() throws Exception {
//        Conexion.getInstance(
//                "sysdba",
//                "1",
//                "SoftSurena.db",
//                "localhost",
//                "3050",
//                "None"
//        );
//        assertTrue(
//                Conexion.verificar().getEstado(),
//                "Error al conectarse..."
//        );
    }

    @AfterClass
    public void tearDownClass() throws Exception {
//        Conexion.getCnn().close();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(
            enabled = true,
            description = "Pruebas de consultas a las categorias con o sin fotos.",
            alwaysRun = true
    )
    public void testSqlSelect() {
        assertEquals(
                M_Categoria.sqlSelect(
                        Categoria
                                .builder()
                                .build()
                ),
                """
                SELECT ID, DESCRIPCION, FECHA_CREACION, ESTADO
                FROM V_CATEGORIAS
                ORDER BY 1;
                """.trim().strip()
        );

        assertEquals(
                M_Categoria.sqlSelect(
                        Categoria
                                .builder()
                                .id_categoria(0)
                                .build()
                ),
                """
                SELECT ID, DESCRIPCION, FECHA_CREACION, ESTADO
                FROM V_CATEGORIAS
                WHERE ID = 0 
                ORDER BY 1;
                """.trim().strip()
        );

        assertEquals(
                M_Categoria.sqlSelect(
                        Categoria
                                .builder()
                                .estado(Boolean.TRUE)
                                .build()
                ),
                """
                SELECT ID, DESCRIPCION, FECHA_CREACION, ESTADO
                FROM V_CATEGORIAS
                WHERE ESTADO
                ORDER BY 1;
                """.trim().strip()
        );

        assertEquals(
                M_Categoria.sqlSelect(
                        Categoria
                                .builder()
                                .estado(Boolean.FALSE)
                                .build()
                ),
                """
                SELECT ID, DESCRIPCION, FECHA_CREACION, ESTADO
                FROM V_CATEGORIAS
                WHERE ESTADO IS FALSE
                ORDER BY 1;
                """.trim().strip()
        );

        assertEquals(
                M_Categoria.sqlSelect(
                        Categoria
                                .builder()
                                .descripcion("PRUEBA")
                                .build()
                ),
                """
                SELECT ID, DESCRIPCION, FECHA_CREACION, ESTADO
                FROM V_CATEGORIAS
                WHERE DESCRIPCION STARTING WITH 'PRUEBA'
                ORDER BY 1;
                """.trim().strip()
        );
    }

    @Test(
            enabled = true,
            description = "Pruebas de consultas a las categorias con o sin fotos.",
            dependsOnMethods = "testSqlSelect"
    )
    public void testSelect() {
        
        assertNotNull(
                M_Categoria.select(
                        Categoria
                                .builder()
                                .build()
                ),
                "Error al consultar."
        );
        
        assertNotNull(
                M_Categoria.select(
                        Categoria
                                .builder()
                                .id_categoria(0)
                                .build()
                ),
                "Error al consultar."
        );
        
        assertNotNull(
                M_Categoria.select(
                        Categoria
                                .builder()
                                .estado(Boolean.TRUE)
                                .build()
                ),
                "Error al consultar."
        );

        assertNotNull(
                M_Categoria.select(
                        Categoria
                                .builder()
                                .estado(Boolean.FALSE)
                                .build()
                ),
                "Error al consultar."
        );
        assertNotNull(
                M_Categoria.select(
                        Categoria
                                .builder()
                                .descripcion("PRUEBA")
                                .build()
                ),
                "Error al consultar."
        );

    }

    @Test(
            enabled = true,
            description = "Permite registrar una categoria al sistema.",
            dependsOnMethods = "testSelect"
    )
    public static void testInsert() {
        Resultado result = M_Categoria.insert(
                Categoria
                        .builder()
                        .descripcion(generarCodigoBarra())
                        .estado(Boolean.TRUE)
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(M_Categoria.CATEGORIA_AGREGADA_CON_EXITO)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                "Problemas en el registro de la categoria."
        );

        assertTrue(
                result.getId() > 0,
                "Identificador de la categoria es menor que cero!!!"
        );

        idCategoria = result.getId();
    }

    @Test(
            enabled = true,
            description = "Permite modificar una categoria del sistema.",
            dependsOnMethods = "testInsert"
    )
    public void testUpdate() {
        assertEquals(
                M_Categoria.update(
                        Categoria
                                .builder()
                                .id_categoria(idCategoria)
                                .descripcion(generarCodigoBarra())
                                .estado(Boolean.FALSE)
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(SE_MODIFICO_LA_CATEGORIA_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            enabled = true,
            description = "Permite eliminar una gategoria del sistema.",
            dependsOnMethods = {"testInsert", "testUpdate"}
    )
    public static void testDelete() {
        assertEquals(
                M_Categoria.delete(idCategoria),
                Resultado
                        .builder()
                        .mensaje(M_Categoria.CATEGORIA__BORRADO__CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }
}
