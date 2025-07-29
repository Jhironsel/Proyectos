package sur.softsurena.clases;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class Datos {

    private Connection conn;
    private static Datos miDato;//Una variable propia del formulario
    private String sql;

    public synchronized static Datos getDatos(String operacion) {
        if (miDato == null) {
            miDato = new Datos();
        }
        return miDato;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public synchronized Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public synchronized void cerrarConexion() {
        if (getConn() == null) {
            return;
        }
        try {
            getConn().close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    //Metodos que devuelven entero.
    public synchronized int cantEmpleados(boolean estado) {
        try {
            setSql("SELECT COUNT(idEmpleado) "
                    + "FROM T_Empleados "
                    + "WHERE ESTADO IS " + estado + ";");
            PreparedStatement st = getConn().prepareStatement(getSql(),
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    public synchronized int cantHorarios(boolean estado) {
        try {
            setSql("SELECT COUNT(idHorario) "
                    + "FROM T_Horarios "
                    + "WHERE ESTADO IS " + estado + ";");
            PreparedStatement st = getConn().prepareStatement(getSql(),
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    /**
     * Verificamos si existe la cedula del paciente antes de realizar un
     * registro a la base de datos.
     *
     * @param cedula Es el identificador unico de cada persona cuando nace.
     * @return boolean si es verdadero el documento existe false puede
     * realizarse el registro a la base de datos.
     */
    public synchronized boolean existeEmpleado(String cedula) {
        try {
            setSql("SELECT (1) "
                    + "FROM T_EMPLEADOS "
                    + "WHERE cedula = '" + cedula + "' and ESTADO IS false");
            PreparedStatement st = getConn().prepareStatement(getSql(),
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            ResultSet rs = st.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public synchronized boolean existeHorario(String nombre) {
        nombre = nombre.toUpperCase();
        setSql("SELECT (1) "
                + "FROM T_HORARIOS h "
                + "WHERE upper(h.descripcion) = '"
                + nombre + "'");
        try {
            PreparedStatement st = getConn().prepareStatement(getSql(),
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            ResultSet rs = st.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public synchronized ResultSet getEmpleadoEstado(boolean estado) {
        try {
            setSql("SELECT IDEMPLEADO, CEDULA, NOMBRES, APELLIDOS, SEXO, "//5
                    + "coalesce(TELEFONO,'Sin Numero') as TELEFONO, "//6
                    + "coalesce(CARGO, 'Sin Cargo') as Cargo, "//7
                    + "coalesce(FECHANACIMIENTO, '01.01.00') as FECHANACIMIENTO, "//8
                    + "coalesce(CIUDAD, 'Sin Ciudad') as CIUDAD, "//9
                    + "coalesce(DIRECCION, 'Sin Direccion') as Direccion, "//10
                    + "coalesce(CORREO, 'Sin Correo') as CORREO "//11
                    + "FROM T_EMPLEADOS "
                    + "WHERE ESTADO IS " + estado + ";");
            PreparedStatement st = getConn().prepareStatement(getSql(),
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            return st.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public synchronized ResultSet getHorariosDisponibles(int idHorarios) {
        try {
            setSql("""
                   select a.idempleado, a.nombres||' '||a.apellidos as fullName, a.cargo
                   from t_empleados a
                   left join  t_asignacionhorarios b
                   on a.idempleado = b.idempleado
                   where b.idhorario is null or b.idhorario !=
                   """ + idHorarios);
            PreparedStatement st = getConn().prepareStatement(getSql(),
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            return st.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public synchronized ResultSet getHorariosIncluidos(int idHorarios) {
        try {
            setSql("select a.idempleado, a.nombres||' '||a.apellidos as fullName, a.cargo \n"
                    + "from t_empleados a\n"
                    + "left join  t_asignacionhorarios b\n"
                    + "on a.idempleado = b.idempleado\n"
                    + "where b.idhorario = " + idHorarios);
            PreparedStatement st = getConn().prepareStatement(getSql(),
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            return st.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public synchronized ResultSet getHorariosEstado(boolean estado) {//Metodo Verificado
        try {
            setSql("SELECT idhorario, descripcion, ingreso, almuerzo, "
                    + "reingreso, salida, tolerancia, estado "
                    + "FROM T_HORARIOS "
                    + "WHERE ESTADO IS " + estado + ";");
            PreparedStatement st = getConn().prepareStatement(getSql(),
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            return st.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public synchronized ResultSet getEmpleadoRecuperar(String cedula) {//Metodo verificado
        try {
            setSql("SELECT NOMBRES, APELLIDOS, SEXO, TELEFONO, "
                    + "CARGO, FECHANACIMIENTO, CIUDAD, DIRECCION, HUELLA, FOTO, "
                    + "ESTADO "
                    + "FROM T_Empleados "
                    + "WHERE CEDULA = '" + cedula + "' AND ESTADO IS FALSE;");
            PreparedStatement st = getConn().prepareStatement(getSql(),
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            return st.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public synchronized ResultSet getHorarios(boolean e) {//Metodo verificado
        try {
            setSql("SELECT IDHORARIO, DESCRIPCION "
                    + "FROM T_HORARIOS "
                    + "WHERE ESTADO IS " + e);
            PreparedStatement st = getConn().prepareStatement(getSql(),
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            return st.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public synchronized ResultSet getPathFoto(String cedula) {//Metodo verificado
        try {
            setSql("select IDFOTO, CEDULA, FECHA_ING, NOMBRE_ARCHIVO " +
                    "from T_FOTO_EMPLEADOS_SEL " +
                    "where Cedula  like '"+cedula+"' and NOMBRE_ARCHIVO is not null " + 
                            "order by 1 desc");
            PreparedStatement st = getConn().prepareStatement(getSql(),
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            return st.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public synchronized String ejecutarSQL(String sql) {
        setSql(sql);
        try {//Insertamos en la tablas no a la vista...
            PreparedStatement st = getConn().prepareStatement(getSql(),
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            st.executeUpdate();
            return "Cambios Guardados";
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
            return "No se pueden guardar los cambios";
        }
    }

    public synchronized void agregarAsignacionHorario(Integer e, int h) {
        try {
            setSql("update or insert into T_ASIGNACIONHORARIOS (idEmpleado, idHorario) "
                    + "values (?, ?) "
                    + "matching(idEmpleado)");
            try (PreparedStatement st = getConn().prepareStatement(getSql(),
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT)) {
                st.setInt(1, e);
                st.setInt(2, h);

                st.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    public synchronized String borrarEmpleado(String cedula) {//Metodo Verificado
        try {
            setSql("DELETE from T_EMPLEADOS "
                    + "WHERE "
                    + " CEDULA = '" + cedula + "'");
            PreparedStatement st = getConn().prepareStatement(getSql(),
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            st.executeUpdate();
            return "Borrado correctamente";
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
            return "Error al borrar Empleado...";
        }
    }

    public synchronized String borrarHorario(int idHorario) {//Metodo Verificado
        try {
            setSql("DELETE from T_Horarios "
                    + "WHERE "
                    + " idHorario = " + idHorario);
            PreparedStatement st = getConn().prepareStatement(getSql(),
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            st.executeUpdate();
            return "Horario borrado correctamente";
        } catch (SQLException ex) {
            if (ex.getMessage().contains("335544466")) {
                return "Horario palmado con unas asignaciones";
            }
            LOG.log(Level.SEVERE, null, ex);
            return "Error al borrar Horario...";
        }
    }

    public synchronized void borrarAsignacionEmpleado(int e) {//Metodo Verificado
        try {
            setSql("DELETE from T_Asignacionhorarios "
                    + "WHERE "
                    + " idEmpleado = " + e);
            PreparedStatement st = getConn().prepareStatement(getSql(),
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    public synchronized String guardarImagen(File file, String id, String query) {//Metodo Verificado
        // Reading a Image file from file system
        FileInputStream imageInFile = null;
        String imageDataString = null;
        try {
            if (file != null) {
                imageInFile = new FileInputStream(file);
                byte imageData[] = new byte[(int) file.length()];
                imageInFile.read(imageData);
                // Converting Image byte array into Base64 String
                imageDataString = Base64.encodeBase64URLSafeString(imageData);
            }
            PreparedStatement ps = null;
            ps = getConn().prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, imageDataString);

            ps.executeUpdate();

            return "Foto Insertada";
        } catch (FileNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

        return "Foto NO Insertada";
    }

    public synchronized Image getImagenes(String sql) {//Metodo Verificado
        try {
            PreparedStatement st = getConn().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            ResultSet rs = st.executeQuery();
            byte[] data = null;
            if (rs.next()) {
                data = Base64.decodeBase64(rs.getString(1));
            } else {
                if (rs.next()) {
                    data = Base64.decodeBase64(rs.getString(1));
                }
            }

            if (data == null) {
                return null;
            }

            BufferedImage img = null;
            try {
                img = ImageIO.read(new ByteArrayInputStream(data));
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, null, ex);
            }
            return img;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public synchronized boolean tieneHuella(String cedula) {//Metodo Verificado
        setSql("select (1) "
                + "from T_EMPLEADOS "
                + "where Cedula = '" + cedula + "' and huella is not null;");

        boolean tiene;
        try {
            PreparedStatement st = getConn().prepareStatement(getSql(),
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            ResultSet rs = st.executeQuery();
            tiene = rs.next();
            return tiene;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
