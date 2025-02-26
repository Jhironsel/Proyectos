package sur.softsurena.metodos;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import static sur.softsurena.conexion.Conexion.getCnn;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_BaseDeDatos {

    /**
     * Metodo que nos devuelve la ruta donde se encuentra la base de datos.
     *
     * @return Devuelve un string de la ubicacion logica de la base de datos.
     */
    public synchronized static String pathBaseDeDatos() {
        final String sql = "SELECT MON$DATABASE_NAME FROM MON$DATABASE";
        try (PreparedStatement ps1 = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ResultSet rs1 = ps1.executeQuery();

            rs1.next();

            return rs1.getString(1);

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error al consultar MON$DATABASE para obtener la ruta de la base de datos.",
                    ex
            );
            return "";
        }
    }

    /**
     * Este metodo devuelve un entero que indica el periodo de duracion de la
     * licencia concedida.
     *
     * @return
     */
    public synchronized static int periodoMaquina() {
        final String sql
                = "SELECT DIAS_RESTANTES FROM V_T_E_S_SYS WHERE ID = 1";

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            return rs.getInt(1);
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error al consultar la vista V_E_S_SYS del sistema.",
                    ex
            );
            return -1;
        }
    }

    /**
     * Metodo utilizado para settear las fechas del sistema.
     *
     * @param fecha Fecha que tendra la licencia del sistema.
     *
     * @param idMaquina Identificador del equipo unico, UUID.
     *
     * @return Devuelve un valor booleano que indica si tuvo exito el proceso de
     * registro.
     */
    public synchronized static boolean setLicencia(
            Date fecha, 
            String idMaquina
    ) {
        final String sql = """
                           EXECUTE PROCEDURE SYSTEM_SET_LICENCIA(?,?)
                           """;

        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            cs.setDate(1, fecha);
            cs.setString(2, idMaquina);

            cs.execute();
            
            return true;
            
        } catch (SQLException ex) {
            
            LOG.log(
                    Level.SEVERE, 
                    ex.getMessage(), 
                    ex
            );
            
            return false;
        }
    }

    /**
     * Metodo de consulta que es utilizada para obtener el numero de registros
     * de una tabla del sistema.
     *
     * @param tabla nombre de la tabla para obtener las cantidad de registros.
     *
     * @return Devuelve la cantindad de registros que existe en una tabla dada
     * en el parametro.
     */
    public synchronized static int cantidadRegistros(String tabla) {
        final String sql = """
            SELECT COALESCE(cantidad, 0) as cantidad 
            FROM V_RECCOUNT 
            WHERE tabla = ?;
        """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setString(1, tabla);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return rs.getInt("cantidad");
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
        
        return 0;
    }
    
    /**
     * Metodo utilizado para obtener el identificador unico de la base de datos.
     * 
     * @return Devuelve un String con el identificador de la base de datos.
     */
    public synchronized static String GET_GUID() {
        final String sql = """
                           SELECT DB_GUID FROM GET_GUID
                           """;

        String id = "";
        
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                id = rs.getString("DB_GUID");
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
        
        return id;
    }
}
