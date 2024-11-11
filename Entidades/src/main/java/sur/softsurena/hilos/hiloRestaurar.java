package sur.softsurena.hilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import static sur.softsurena.metodos.M_BaseDeDatos.pathBaseDeDatos;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 * TODO 10/11/2024 No puedes realizarse BackUps. 
 * @author jhironsel
 */
public class hiloRestaurar extends Thread {

    private final String BD, BDR, log;

    private String usuarioMaster, claveMaster;

    public hiloRestaurar() {
        super();

        BD = pathBaseDeDatos();

        BDR = """
              Backups\\softSurena %s.FBK
              """.formatted(new Date().toString().replace(":", "."));

        log = """
              Logs\\Respaldo %s.Log
              """.formatted(new Date().toString().replace(":", "."));;

    }

    @Override
    public void run() {
        correr();

        Process p;
        BufferedReader stdInput;
        String comando = """
                             gbak -c -v -USER %s -PASSWORD %s %s %s
                             """.formatted(
                                     usuarioMaster, 
                                     claveMaster, 
                                     BD, 
                                     BDR
                             );
        try {
            p = Runtime.getRuntime().exec(new String[]{comando});

            stdInput = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));

            String linea;

            do {
                linea = stdInput.readLine();
            } while (stdInput.ready());

            if (Objects.isNull(linea)) {
                JOptionPane.showMessageDialog(
                        null,
                        "Usuario no valido o no puede realizarse el backup.",
                        "",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (IOException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
            return;
        }

        JOptionPane.showMessageDialog(
                null,
                "Base de Datos restaurada",
                "",
                JOptionPane.INFORMATION_MESSAGE
        );

    }

    /**
     * Este metodo prepara el ambiente para hacer un respaldo de la base de
     * datos.
     *
     * 1) Obtemos el usuario que va a realizar el BackUp. Si el usuario es nulo
     * detenemos el proceso.
     *
     * 2) Obtenemos la clave del usuario. Si el usuario ingresa una clave en
     * blanco detenemos el proceso.
     *
     *
     *
     */
    public boolean correr() {
        usuarioMaster = JOptionPane.showInputDialog(
                null,
                "Inserte el nombre de Usuario: ",
                "",
                JOptionPane.INFORMATION_MESSAGE
        );

        if (usuarioMaster.isBlank()) {
            return true;
        }
//-----------------------------------------------------------------------------1

        JPasswordField pf = new JPasswordField();

        claveMaster = "" + JOptionPane.showConfirmDialog(
                null,
                pf,
                "Inserte la clave del Usuario: ",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE
        );

        pf.requestFocusInWindow();

        if (claveMaster.isBlank()) {
            return true;
        }
//-----------------------------------------------------------------------------2
        Process p;
        BufferedReader stdInput;
        try {
            String comando = "gbak -b -nodbtriggers -l -nt -v -user %s -password %s -y %s %s %s"
                    .formatted(
                            usuarioMaster,
                            new String(pf.getPassword()),
                            log,
                            BD,
                            BDR
                    );

            p = Runtime.getRuntime().exec(
                    new String[]{comando}
            );

            stdInput = new BufferedReader(
                    new InputStreamReader(
                            p.getInputStream()
                    )
            );
            String linea;
            
            do {
                linea = stdInput.readLine();

                if (linea != null) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Usuario no valido o no puede realizarse elbackup...",
                            "",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

            } while (stdInput.ready());
            
        } catch (IOException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
        return false;
    }
}
