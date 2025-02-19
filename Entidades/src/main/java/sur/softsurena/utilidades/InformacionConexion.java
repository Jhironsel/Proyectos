package sur.softsurena.utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class InformacionConexion {

    public static String informacion() {
        StringBuffer content = new StringBuffer();
        try {
            URL url = new URI("https://api.ipquery.io/?format=yaml").toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine).append("\n");
                }
            }
            connection.disconnect();
        } catch (IOException | URISyntaxException e) {
            LOG.log(Level.SEVERE, "No tiene conexion a internet.", e);
        }
        return content.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(informacion());
    }
}
