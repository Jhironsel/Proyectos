package sur.softsurena.utilidades;

import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class DesktopConFondo extends JDesktopPane {

    private Image imagen;

    public void setImagen(String nombreImagen) {
        if (nombreImagen != null) {
            imagen = new ImageIcon(
                    getClass().getResource(nombreImagen)).getImage();
        } else {
            imagen = null;
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
        } else {
            setOpaque(true);
        }

        try {
            super.paint(g);
        } catch (Exception e) {
            System.out.println("Reinicie la Aplicacion " + e.getLocalizedMessage());
            LOG.log(Level.SEVERE, "Error en la aplicacion.", e);
        }
    }
}
