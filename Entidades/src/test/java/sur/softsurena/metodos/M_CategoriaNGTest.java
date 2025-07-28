package sur.softsurena.metodos;

import java.util.List;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Categoria;
import sur.softsurena.entidades.FotoCategoria;
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

    public static Integer idCategoria;

    @Test
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
            dependsOnMethods = "testSelect"
    )
    public static void testInsert() {
        var descripcion = generarCodigoBarra();
        
        List<Categoria> lista = M_Categoria.select(
                Categoria
                        .builder()
                        .descripcion(descripcion)
                        .build()
        );
        
        if(lista.isEmpty()){
            Resultado result = M_Categoria.insert(
                    Categoria
                            .builder()
                            .descripcion(descripcion)
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
        }else{
            idCategoria = lista.stream().findFirst().orElseThrow().getId_categoria();
        }
        
        
    }

    @Test(
            dependsOnMethods = "testInsert"
    )
    public void testUpdate() {
        assertEquals(
                M_Categoria.update(
                        Categoria
                                .builder()
                                .id_categoria(idCategoria)
                                .descripcion(generarCodigoBarra())
                                .estado(Boolean.TRUE)
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
            dependsOnMethods = {"testInsert", "testUpdate"}
    )
    public static void testDelete() {
        
        M_Foto_Categoria.deleteById_categoria(
                FotoCategoria
                        .builder()
                        .idCategoria(idCategoria)
                        .build()
        );
        
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
