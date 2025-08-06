package sur.softsurena.hilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class hiloIp extends Thread {
    
    @Override
    public void run() {
        String ip = null;
        
        // 1: Usar HttpURLConnection (más confiable y multiplataforma)
        try {
            ip = obtenerIpConHttpConnection();
        } catch (Exception ex) {
            LOG.log(Level.WARNING, "Error general en HttpURLConnection: " + ex.getMessage(), ex);
        }
        
        // 2: Usar comandos del sistema como respaldo
        if (ip == null) {
            try {
                ip = obtenerIpConComandoSistema();
            } catch (Exception ex) {
                LOG.log(Level.WARNING, "Error general en comandos de sistema: " + ex.getMessage(), ex);
            }
        }
        
        // Mostrar resultado
        if (ip != null && !ip.trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Su IP pública es: " + ip.trim(),
                    "Dirección IP",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    """
                    No se pudo obtener la IP pública.
                    
                    Posibles causas:
                    • Sin conexión a Internet.
                    • Firewall bloqueando la conexión.
                    • Proxy corporativo.
                    • Servicios de IP temporalmente no disponibles.
                    """,
                    "Error de conexión",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    /**
     * Método principal usando HttpURLConnection (funciona en cualquier plataforma)
     */
    private String obtenerIpConHttpConnection() {
        // Lista de servicios alternativos para obtener IP
        String[] servicios = {
            "http://ipinfo.io/ip",
            "http://httpbin.org/ip",
            "http://icanhazip.com",
            "http://ifconfig.me/ip",
            "http://api.ipify.org"
        };
        
        for (String servicio : servicios) {
            try {
                URL url = URI.create(servicio).toURL();
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(10000); // 10 segundos timeout
                connection.setReadTimeout(10000);
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
                connection.setRequestProperty("Accept", "text/plain,*/*");
                connection.setInstanceFollowRedirects(true);
                
                // Configurar proxy del sistema si existe
                System.setProperty("java.net.useSystemProxies", "true");
                
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    String respuesta;
                    try (BufferedReader reader = new BufferedReader(
                            new InputStreamReader(connection.getInputStream())
                    )) {
                        respuesta = reader.readLine();
                    }
                    connection.disconnect();
                    
                    // Procesar respuesta (algunos servicios devuelven JSON)
                    String ip = extraerIpDeRespuesta(respuesta);
                    if (ip != null && esIpValida(ip)) {
                        return ip;
                    }
                }
                connection.disconnect();
                
            } catch (IOException ex) {
                LOG.log(
                        Level.INFO, 
                        "Servicio %s no disponible: ".formatted(servicio),
                        ex
                );
            }
        }
        
        LOG.log(Level.WARNING, "Todos los servicios HTTP fallaron");
        return null;
    }
    
    /**
     * Extrae la IP de diferentes formatos de respuesta
     */
    private String extraerIpDeRespuesta(String respuesta) {
        if (respuesta == null || respuesta.trim().isEmpty()) {
            return null;
        }
        
        respuesta = respuesta.trim();
        
        // Si es JSON (como httpbin.org)
        if (respuesta.startsWith("{") && respuesta.contains("origin")) {
            try {
                // Extraer IP de formato: {"origin": "123.456.789.0"}
                int start = respuesta.indexOf("\"origin\":") + 10;
                int end = respuesta.indexOf("\"", start);
                if (start > 9 && end > start) {
                    return respuesta.substring(start, end).trim();
                }
            } catch (Exception e) {
                // Si falla el parsing JSON, continuar
            }
        }
        
        // Si es texto plano, devolver directamente
        return respuesta;
    }
    
    /**
     * Método de respaldo usando comandos del sistema
     */
    private String obtenerIpConComandoSistema() {
        String[][] comandos = obtenerComandosSegunSO();
        
        for (String[] comando : comandos) {
            try {
                Process p = Runtime.getRuntime().exec(comando);
                String respuesta;
                try (BufferedReader stdInput = new BufferedReader(
                        new InputStreamReader(p.getInputStream())
                )) {
                    respuesta = stdInput.readLine();
                }
                
                // Esperar a que termine el proceso
                p.waitFor();
                
                if (respuesta != null && !respuesta.trim().isEmpty() && 
                    esIpValida(respuesta.trim())) {
                    return respuesta.trim();
                }
                
            } catch (IOException | InterruptedException ex) {
                LOG.log(
                        Level.WARNING, 
                        "Error ejecutando comando " + String.join(" ", comando) + ": " + ex.getMessage(), 
                        ex
                );
                Thread.currentThread().interrupt();
            }
        }
        return null;
    }
    
    /**
     * Obtiene los comandos apropiados según el sistema operativo
     */
    private String[][] obtenerComandosSegunSO() {
        String os = System.getProperty("os.name").toLowerCase();
        
        if (os.contains("win")) {
            // Windows: usar PowerShell o curl si está disponible
            return new String[][]{
                {"powershell", "-Command", "[System.Net.WebClient]::new().DownloadString('http://ipinfo.io/ip').Trim()"},
                {"powershell", "-Command", "(Invoke-WebRequest -Uri 'http://icanhazip.com' -UseBasicParsing).Content.Trim()"},
                {"curl", "-s", "--connect-timeout", "10", "http://ipinfo.io/ip"},
                {"curl", "-s", "--connect-timeout", "10", "http://icanhazip.com"},
                {"powershell", "-Command", "[System.Net.WebClient]::new().DownloadString('http://api.ipify.org').Trim()"}
            };
        } else {
            // Linux/Unix/macOS
            return new String[][]{
                {"curl", "-s", "--connect-timeout", "10", "http://ipinfo.io/ip"},
                {"curl", "-s", "--connect-timeout", "10", "http://icanhazip.com"},
                {"wget", "-qO-", "--timeout=10", "http://ipinfo.io/ip"},
                {"wget", "-qO-", "--timeout=10", "http://icanhazip.com"},
                {"curl", "-s", "--connect-timeout", "10", "http://api.ipify.org"}
            };
        }
    }
    
    /**
     * Validación básica de formato IP
     */
    private boolean esIpValida(String ip) {
        if (ip == null || ip.isEmpty()) {
            return false;
        }
        
        // Verificar formato básico de IPv4
        String ipv4Pattern = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
        return ip.matches(ipv4Pattern);
    }
}