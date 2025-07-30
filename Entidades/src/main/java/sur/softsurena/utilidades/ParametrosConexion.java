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

    private Properties propiedades;
    private File filePropertie = null;
    
    public ParametrosConexion(){
        propiedades = new Properties();
        filePropertie = new File("../properties/propiedades.properties");
        
        try (var fileReader = new FileReader(filePropertie)) {
            propiedades.load(fileReader);
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

        try (var fileReader = new FileWriter(filePropertie)) {
            propiedades.store(
                    fileReader,
                    "Parametros del Servidor actual"
            );
        } catch (IOException ex) {
            LOG.log(
                    Level.SEVERE, 
                    "Error al leer la propiedades del archivo.", 
                    ex
            );
        }
    }
}
