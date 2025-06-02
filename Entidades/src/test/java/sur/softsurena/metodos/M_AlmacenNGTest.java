package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Almacen;
import static sur.softsurena.metodos.M_Almacen.ALMACEN_AGREGADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Almacen.ALMACEN_ELIMINADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Almacen.ERROR_AL_ELIMINAR_ALMACEN;
import sur.softsurena.utilidades.Resultado;

@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_AlmacenNGTest {

    private static int idAlmacen;

    @Test
    public void testSqlSelect() {
        assertEquals(
                M_Almacen.sqlSelect(
                        Almacen
                                .builder()
                                .build()
                ), 
                """
                SELECT ID, NOMBRE, UBICACION, ESTADO
                FROM V_ALMACENES
                """.strip()
        );
        
        assertEquals(
                M_Almacen.sqlSelect(
                        Almacen
                                .builder()
                                .id(1)
                                .build()
                ), 
                """
                SELECT ID, NOMBRE, UBICACION, ESTADO
                FROM V_ALMACENES
                WHERE ID = 1
                """.strip()
        );
        
        assertEquals(
                M_Almacen.sqlSelect(
                        Almacen
                                .builder()
                                .nombre("PRUEBA")
                                .build()
                ), 
                """
                SELECT ID, NOMBRE, UBICACION, ESTADO
                FROM V_ALMACENES
                WHERE NOMBRE STARTING WITH 'PRUEBA'
                """.strip()
        );
        
        assertEquals(
                M_Almacen.sqlSelect(
                        Almacen
                                .builder()
                                .estado(Boolean.TRUE)
                                .build()
                ), 
                """
                SELECT ID, NOMBRE, UBICACION, ESTADO
                FROM V_ALMACENES
                WHERE ESTADO IS true
                """.strip()
        );
        
        assertEquals(
                M_Almacen.sqlSelect(
                        Almacen
                                .builder()
                                .estado(Boolean.FALSE)
                                .build()
                ), 
                """
                SELECT ID, NOMBRE, UBICACION, ESTADO
                FROM V_ALMACENES
                WHERE ESTADO IS false
                """.strip()
        );
    }

    @Test(
            dependsOnMethods = "testSqlSelect"
    )
    public static void testSelect() {
        assertNotNull(
                M_Almacen.select(
                        Almacen
                                .builder()
                                .build()
                ),
                "Error al consutar la tabla de almacen [1]"
        );
        
        assertFalse(
                M_Almacen.select(
                        Almacen
                                .builder()
                                .id(0)
                                .build()
                ).isEmpty(),
                "Error al consutar la tabla de almacen [2]"
        );
        
        assertNotNull(
                M_Almacen.select(
                        Almacen
                                .builder()
                                .id(1)
                                .build()
                ),
                "Error al consutar la tabla de almacen [3]"
        );
        
        assertNotNull(
                M_Almacen.select(
                        Almacen
                                .builder()
                                .nombre("PRUEBA")
                                .build()
                ),
                "Error al consutar la tabla de almacen [4]"
        );
        
        assertNotNull(
                M_Almacen.select(
                        Almacen
                                .builder()
                                .estado(Boolean.TRUE)
                                .build()
                ),
                "Error al consutar la tabla de almacen [5]"
        );
        
        assertNotNull(
                M_Almacen.select(
                        Almacen
                                .builder()
                                .estado(Boolean.FALSE)
                                .build()
                ),
                "Error al consutar la tabla de almacen [6]"
        );
        
        
    }

    @Test(
            dependsOnMethods = "testSelect"
    )
    public static void testAlmacenGeneral() {
        if (M_Almacen.select(
                Almacen
                        .builder()
                        .id(0)
                        .build()
        ).isEmpty()) {
            M_Almacen.updateOrInsert(
                    Almacen
                            .builder()
                            .id(0)
                            .nombre("Almacen general")
                            .ubicacion("Almacen generico del sistema.")
                            .estado(Boolean.TRUE)
                            .build()
            );
        }
    }
    
    @Test(
            dependsOnMethods = "testAlmacenGeneral"
    )
    public static void testInsert() {
        
        Resultado result = M_Almacen.updateOrInsert(
                Almacen
                        .builder()
                        .nombre("Registro prueba")
                        .ubicacion("Debe de describir la ubicacion del almacen.")
                        .estado(Boolean.TRUE)
                        .build()
        );
        
        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(ALMACEN_AGREGADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                M_Almacen.ERROR_AL_INSERTAR__ALMACEN
        );

        assertTrue(
                result.getId() > 0,
                "Error al insertar almacen."
        );

        idAlmacen = result.getId();

        result = M_Almacen.updateOrInsert(
                Almacen
                        .builder()
                        .id(idAlmacen)
                        .nombre("Texto de prueba")
                        .ubicacion("Debe de describir la ubicacion del almacen.")
                        .estado(Boolean.FALSE)
                        .build()
        );
        
        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(ALMACEN_AGREGADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                M_Almacen.ERROR_AL_INSERTAR__ALMACEN
        );

    }

    @Test(
            
            dependsOnMethods = {"testInsert"}
    )
    public static void testDelete() {
        Resultado result = M_Almacen.delete(idAlmacen);
        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(ALMACEN_ELIMINADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_ELIMINAR_ALMACEN
        );
    }
    
    public static Almacen getAlmacen(){
        return Almacen
                .builder()
                .id(idAlmacen)
                .nombre("Almacen generado")
                .ubicacion("Ubicacion generada.")
                .estado(Boolean.TRUE)
                .build();
    }
}
