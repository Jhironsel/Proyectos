 package Clases;

import java.util.logging.Level;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class Sonido {
    public void reproducirAudio(String archivo) {
        try {
            Player player = new Player(getClass().getResourceAsStream(archivo));
            player.play();
            player.close();
        } catch (JavaLayerException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
