package sur.softsurena.metodos;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import lombok.NonNull;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Categoria;
import sur.softsurena.entidades.Imagen;
import sur.softsurena.entidades.Producto;
import sur.softsurena.interfaces.IProducto;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Producto implements IProducto {

    /**
     * Metodo que permite recuperar las propiedades de los productos del
     * sistema. Devolviendo asi un Listado de productos con todas sus
     * propiedades.
     *
     *
     * Fecha de Actualización el 19/05/2022.
     *
     * @param producto
     * @return Devuelve un conjunto de datos de la tabla de los productos del
     * sistema.
     */
    public synchronized static List<Producto> select(
            @NonNull Producto producto
    ) {
        List<Producto> listaProducto = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlProductos(producto),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    listaProducto.add(
                            Producto
                                    .builder()
                                    .id(rs.getInt("ID"))
                                    .descripcion(rs.getString("DESCRIPCION"))
                                    .categoria(
                                            Categoria
                                                    .builder()
                                                    .id_categoria(rs.getInt("ID_CATEGORIA"))
                                                    .descripcion(rs.getString("DESC_CATEGORIA"))
                                                    .image_texto(rs.getString("IMAGEN_CATEGORIA"))
                                                    .build()
                                    )
                                    .codigo(rs.getString("CODIGO"))
                                    .nota(rs.getString("NOTA"))
                                    .fechaCreacion(rs.getDate("FECHA_CREACION"))
                                    .imagen(
                                            Imagen
                                                    .builder()
                                                    .imagen64(rs.getString("IMAGEN_PRODUCTO"))
                                                    .build()
                                    )
                                    .estado(rs.getBoolean("ESTADO"))
                                    .existencia(rs.getBigDecimal("EXISTENCIA"))
                                    .build()
                    );
                }
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_CONSULTAR_LA_BASE_DE_DATOS_CON_L,
                    ex
            );
        }
        return listaProducto;
    }
    public static final String ERROR_AL_CONSULTAR_LA_BASE_DE_DATOS_CON_L
            = "Error al consultar la base de datos con la vista GET_PRODUCTOS del sistema.";

    protected static String sqlProductos(Producto producto) {
        Boolean f_id = Objects.isNull(producto.getId());
        Boolean f_estado = Objects.isNull(producto.getEstado());

        Boolean f_codigo = Objects.isNull(producto.getCodigo());
        Boolean f_descripcion = Objects.isNull(producto.getDescripcion());
        Boolean f_descripcionCategoria = Objects.isNull(producto.getCategoria());

        Boolean f_criterio = f_codigo && f_descripcion && f_descripcionCategoria;

        Boolean f_where = (f_id && f_estado && f_criterio);
        Boolean f_row = Objects.isNull(producto.getPagina());

        String r1 = (f_where ? "" : "WHERE ");
        String r2 = (f_id ? "" : "ID = %d ".formatted(producto.getId()));
        String r3 = (f_id ? "" : (f_estado ? "" : "AND "));
        String r4 = (f_estado ? "" : producto.getEstado() ? "ESTADO " : "ESTADO IS FALSE ");
        String r5 = (f_criterio ? "" : """
                                       %sTRIM(CODIGO) STARTING WITH TRIM('%s') OR
                                                              TRIM(CODIGO) CONTAINING TRIM('%s') OR
                                                              TRIM(DESCRIPCION) STARTING WITH TRIM('%s') OR
                                                              TRIM(DESCRIPCION) CONTAINING TRIM('%s') OR
                                                              ID_CATEGORIA IN(
                                                                             SELECT ID
                                                                             FROM VS_CATEGORIAS
                                                                             WHERE UPPER(TRIM(DESCRIPCION)) STARTING WITH UPPER(TRIM('%s'))
                                                              ) 
                                       """.formatted(
                f_id && f_estado ? "" : "OR ",
                producto.getCodigo(),
                producto.getCodigo(),
                producto.getDescripcion(),
                producto.getDescripcion(),
                producto.getCategoria().getDescripcion()
        ));

        final String sql = """
                SELECT ID, ID_CATEGORIA, DESC_CATEGORIA, CODIGO, DESCRIPCION, EXISTENCIA, 
                NOTA, FECHA_CREACION, IMAGEN_CATEGORIA, IMAGEN_PRODUCTO, 
                ESTADO 
                FROM GET_PRODUCTOS
                %S%S%S%S%S
                """.strip().trim().formatted(r1, r2, r3, r4, r5).strip().trim()
                .concat("\nORDER BY ID").strip().trim()
                .concat(
                        f_row ? "" : "\nROWS (%d - 1) * %d + 1 TO (%d + (1 - 1)) * %d;"
                                        .formatted(
                                                producto.getPagina().getNPaginaNro(),
                                                producto.getPagina().getNCantidadFilas(),
                                                producto.getPagina().getNPaginaNro(),
                                                producto.getPagina().getNCantidadFilas()
                                        )
                ).strip().trim();

        return sql;
    }

//------------------------------------------------------------------------------
    /**
     * Permite obtener los productos del sistema por una categoria identificada
     * por su ID y su estado definido por el sistema.
     *
     * TODO 25/12/2024 Mejorar creacion de sql, crear el metodo 
     * sqlSelect(categoria).
     * 
     * @param categoria
     * 
     * @return
     */
    public synchronized static List<Producto> selectByCategoria(
            @NonNull Categoria categoria
    ) {
        final String sql
                = "SELECT ID, DESCRIPCION, IMAGEN_PRODUCTO "
                + "FROM GET_PRODUCTOS "
                + "WHERE ID_CATEGORIA = ? " + (Objects.isNull(categoria.getEstado()) ? ";" : (
                categoria.getEstado() ? " AND ESTADO;" : " AND ESTADO IS FALSE;"));

        List<Producto> productosList = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, categoria.getId_categoria());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                productosList.add(
                        Producto
                                .builder()
                                .id(rs.getInt("ID"))
                                .descripcion(rs.getString("DESCRIPCION"))
                                .imagen(
                                        Imagen
                                                .builder()
                                                .imagen64(rs.getString("IMAGEN_PRODUCTO"))
                                                .build()
                                )
                                .build()
                );
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error al consultar la vista GET_PRODUCTOS del sistema.",
                    ex
            );
        }
        return productosList;
    }


//------------------------------------------------------------------------------
    /**
     * Agregar producto a la base de datos en la tabla productos.
     *
     * @test agregarProducto() metodo que realiza la prueba unitaria del metodo.
     *
     * @param producto Objecto de la clase producto que permite obtener los
     * valos de del producto agregar.
     *
     * @return Devuelve un mensaje que notifica si el producto fue agregado
     * correctamente o no.
     */
    public synchronized static Resultado insert(Producto producto) {
        final String sql
                = "SELECT O_ID FROM SP_I_PRODUCTO(?,?,?,?,?,?)";

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, producto.getCategoria().getId_categoria());
            ps.setString(2, producto.getCodigo());
            ps.setString(3, producto.getDescripcion());
            ps.setString(4, producto.getImagen().getImagen64());
            ps.setString(5, producto.getNota());
            ps.setBoolean(6, producto.getEstado());

            ResultSet rs = ps.executeQuery();

            rs.next();

            return Resultado
                    .builder()
                    .id(rs.getInt("O_ID"))
                    .mensaje(PRODUCTO_AGREGADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL__INSERTAR__PRODUCTO,
                    ex
            );

            return Resultado
                    .builder()
                    .id(-1)
                    .mensaje(ERROR_AL__INSERTAR__PRODUCTO)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL__INSERTAR__PRODUCTO
            = "Error al Insertar Producto.";
    public static final String PRODUCTO_AGREGADO_CORRECTAMENTE
            = "Producto agregado correctamente.";

//------------------------------------------------------------------------------
    /**
     * Metodo que permite modificar los productos del sistema como a la
     * categoria a la que pertenece el producto, su codigo de barra, la
     * descripcion, la imagen de este, la nota del producto y su estado.
     *
     * Metodo actualizado el dia 23 de abril, segun la vista productos.
     *
     * @param p perteneciente a la clase Producto, define los productos del
     * sistema.
     *
     * @return
     */
    public synchronized static Resultado update(Producto p) {
        final String sql
                = "EXECUTE PROCEDURE SP_U_PRODUCTO (?, ?, ?, ?, ?, ?, ?)";
        try (CallableStatement ps = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {
            ps.setInt(1, p.getId());
            ps.setInt(2, p.getCategoria().getId_categoria());
            ps.setString(3, p.getCodigo());
            ps.setString(4, p.getDescripcion());
            ps.setString(5, p.getImagen().getImagen64());
            ps.setString(6, p.getNota());
            ps.setBoolean(7, p.getEstado());

            ps.executeUpdate();
            return Resultado
                    .builder()
                    .mensaje(PRODUCTO__MODIFICADO__CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL__MODIFICAR__PRODUCTO,
                    ex
            );
        }
        return Resultado
                .builder()
                .mensaje(ERROR_AL__MODIFICAR__PRODUCTO)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();

    }
    public static final String ERROR_AL__MODIFICAR__PRODUCTO
            = "Error al Modificar Producto...";
    public static final String PRODUCTO__MODIFICADO__CORRECTAMENTE
            = "Producto Modificado Correctamente";

//------------------------------------------------------------------------------
    /**
     * Metodo que nos permite verificar si una categoria esta asociada a un
     * producto del sistema, la cual no se permite su eliminacion.
     *
     * @param idCategoria
     *
     * @return
     */
    public synchronized static boolean existeCategoriaProductos(int idCategoria) {
        final String sql = """
                           SELECT (1) 
                           FROM RDB$DATABASE 
                           WHERE EXISTS (
                                         SELECT (1) 
                                         FROM V_PRODUCTOS p 
                                         WHERE p.ID_CATEGORIA = ?
                                        )
                           """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, idCategoria);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
            return false;
        }
    }

//------------------------------------------------------------------------------
    /**
     * Metodo que verifica la existencia de un producto por su codigo de barra o
     * descripción. Metodo actualizado el 26 de abril 2022
     *
     * @param criterio este valor representa el valor del codigo de barra del
     * producto o nombre de 25 caracteres.
     * @return
     */
    public synchronized static boolean existeProducto(String criterio) {
        final String sql = """
                           SELECT (1) 
                           FROM RDB$DATABASE 
                           WHERE EXISTS(
                                        SELECT (1) 
                                        FROM V_PRODUCTOS 
                                        WHERE codigo STARTING WITH ? or 
                                              descripcion STARTING WITH ?
                           );
                           """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setString(1, criterio);
            ps.setString(2, criterio);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
            return false;
        }
    }
    
    //------------------------------------------------------------------------------
    /**
     * Metodo utilizado para eliminar los productos del sistema, este solo
     * necesita de su ID o codigo de barra para localizarlo en la vista de
     * V_PRODUCTOS.
     *
     * @param ID Identificador o codigo del Producto en la vista de V_PRODUCTOS.
     *
     *
     * @return Devuelve un mensaje que indica como resultado de la acción.
     */
    public synchronized static Resultado deleteByID(Integer ID) {
        final String sql
                = "EXECUTE PROCEDURE SP_D_PRODUCTO(?)";
        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT)) {
            cs.setInt(1, ID);

            cs.execute();

            return Resultado
                    .builder()
                    .mensaje(PRODUCTO__BORRADO__CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_EL__PR,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_EL__PR)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_EL__PR
            = "Ocurrio un error al intentar borrar el Producto...";

    public static final String PRODUCTO__BORRADO__CORRECTAMENTE
            = "Producto Borrado Correctamente.";

//------------------------------------------------------------------------------
    public static String generarProducto() {
        StringBuilder telefonoMovil = new StringBuilder();

        int num1 = (int) (Math.random() * 10);
        int num2 = (int) (Math.random() * 10);
        int num3 = (int) (Math.random() * 10);
        int num4 = (int) (Math.random() * 10);

        telefonoMovil.

                append("Producto de prueba ").
                append(num1).
                append(num2).
                append(num3).
                append(num4);

        return telefonoMovil.toString();
    }

//------------------------------------------------------------------------------
    public static String generarCodigoBarra() {
        StringBuilder telefonoMovil = new StringBuilder();

        int num1 = (int) (Math.random() * 10);
        int num2 = (int) (Math.random() * 10);
        int num3 = (int) (Math.random() * 10);
        int num4 = (int) (Math.random() * 10);

        telefonoMovil.
                append("CODE_BAR_TEST").
                append(num1).
                append(num2).
                append(num3).
                append(num4);

        return telefonoMovil.toString();
    }
}
