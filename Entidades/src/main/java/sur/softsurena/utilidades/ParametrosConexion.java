package sur.softsurena.utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class ParametrosConexion {

    private final Properties propiedades;
    private File filePropertie = null;

    public static ParametrosConexion getInstance() {
        return NewSingletonHolder.INSTANCE;
    }

    private static class NewSingletonHolder {

        private static final ParametrosConexion INSTANCE = new ParametrosConexion();
    }
    
    private ParametrosConexion(){
         propiedades = new Properties();

        try {
            filePropertie = new File("properties/propiedades.properties");
            propiedades.load(new FileReader(filePropertie));
        } catch (FileNotFoundException ex) {
            LOG.log(Level.SEVERE, "Archivo no encotrado", ex);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Error de entrada o salida del archivo propiedades.", ex);
        }
    }
    
    public Servidor cargarParamentos() {
        Servidor servidor = Servidor
                .builder()
                .host(propiedades.getProperty("Nombre_del_Servidor", "localhost"))
                .puerto(propiedades.getProperty("Puerto_del_Servidor", "3050"))
                .pathBaseDatos(propiedades.getProperty("PathBaseDatos", "SoftSurena.db"))
                .build();
        return servidor;
    }
    
    public void escribirParametros(Servidor servidor) {
        propiedades.setProperty("Nombre_del_Servidor", servidor.getHost());
        propiedades.setProperty("Puerto_del_Servidor", servidor.getPuerto());
        propiedades.setProperty("PathBaseDatos", servidor.getPathBaseDatos());

        try {
            propiedades.store(
                    new FileWriter(filePropertie),
                    "Parametros del Servidor actual"
            );
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Error al leer la propiedades del archivo.", ex);
        }
    }
}
