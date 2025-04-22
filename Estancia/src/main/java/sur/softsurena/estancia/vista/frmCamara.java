package sur.softsurena.estancia.vista;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryEvent;
import com.github.sarxos.webcam.WebcamDiscoveryListener;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamPicker;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class frmCamara extends javax.swing.JDialog implements
        WebcamListener, WindowListener, Thread.UncaughtExceptionHandler, ItemListener,
        WebcamDiscoveryListener {

    private static final long serialVersionUID = 1L;
    private Webcam webcam = null;
    private WebcamPanel panel = null;
    private WebcamPicker picker = null;

    private JLabel l;
    private boolean listo;
    private String cedula, ruta;

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public boolean isListo() {
        return listo;
    }

    public void setListo(boolean listo) {
        this.listo = listo;
    }

    public frmCamara(java.awt.Frame parent, boolean modal, JLabel l, String cedula) {
        super(parent, modal);
        running();
        this.l = l;
        this.cedula = cedula;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public final void running() {
        Webcam.addDiscoveryListener(this);
        addWindowListener(this);
        setTitle("Captura de imagen de empleado");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        picker = new WebcamPicker();
        picker.addItemListener(this);

        webcam = picker.getSelectedWebcam();
        if (webcam == null) {
            JOptionPane.showMessageDialog(null, "Camara no encontrada...");
            setListo(false);
            this.setVisible(false);
            this.dispose();
            return;
        }

        webcam.setViewSize(WebcamResolution.VGA.getSize());
        webcam.addWebcamListener(frmCamara.this);

        panel = new WebcamPanel(webcam, true);
        panel.setFPSDisplayed(true);

        JButton button = new JButton(new AbstractAction("Tomar Foto") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {

                setRuta("foto/Empleado_" + cedula + ".JPG");
                File f = new File(getRuta());
                for (int i = 1; true; i++) {
                    if (f.exists()) {
                        setRuta("foto/Empleado_" + cedula + "_" + i + ".JPG");
                        f = new File(getRuta());
                    } else {
                        break;
                    }
                }

                try {
                    ImageIO.write(webcam.getImage(), "JPG", f);
                } catch (IOException t) {
                    t.printStackTrace();
                }
                l.setIcon(
                        new ImageIcon(webcam.getImage().getScaledInstance(l.getWidth(), l.getHeight(),
                                Image.SCALE_SMOOTH)));
                dispose();
            }
        });

        add(button, BorderLayout.SOUTH);
        add(picker, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        pack();
        Thread t = new Thread() {

            @Override
            public void run() {
                panel.start();
            }
        };
        t.setName("example-starter");
        t.setDaemon(true);
        t.setUncaughtExceptionHandler(this);
        t.start();
    }

    @Override
    public void webcamOpen(WebcamEvent we) {
        System.out.println("archivos.frmCamara.webcamOpen()");
    }

    @Override
    public void webcamClosed(WebcamEvent we) {
        System.out.println("archivos.frmCamara.webcamClosed()");
    }

    @Override
    public void webcamDisposed(WebcamEvent we) {
        System.out.println("archivos.frmCamara.webcamDisposed()");
    }

    @Override
    public void webcamImageObtained(WebcamEvent we) {
        System.out.println("archivos.frmCamara.webcamImageObtained()");
        setListo(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("archivos.frmCamara.windowOpened()");
        if (webcam == null) {
            dispose();
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("archivos.frmCamara.windowClosing()");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("archivos.frmCamara.windowClosed()");
        if (webcam != null) {
            webcam.close();
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("archivos.frmCamara.windowIconified()");
        panel.pause();
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        panel.resume();
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("archivos.frmCamara.windowActivated()");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("archivos.frmCamara.windowDeactivated()");
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.err.println(String.format("Exception in thread %s", t.getName()));
        e.printStackTrace();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("archivos.WebcamViewerExample.itemStateChanged()");
        if (e.getItem() != webcam && webcam != null) {
            panel.stop();
            remove(panel);

            webcam.removeWebcamListener(this);
            webcam.close();

            webcam = (Webcam) e.getItem();
            webcam.setViewSize(WebcamResolution.VGA.getSize());
            webcam.addWebcamListener(this);

            System.out.println("selected " + webcam.getName());

            panel = new WebcamPanel(webcam, false);
            panel.setFPSDisplayed(true);

            add(panel, BorderLayout.CENTER);
            pack();

            Thread t = new Thread() {

                @Override
                public void run() {
                    panel.start();
                }
            };
            t.setName("example-stoper");
            t.setDaemon(true);
            t.setUncaughtExceptionHandler(this);
            t.start();
        }
    }

    @Override
    public void webcamFound(WebcamDiscoveryEvent event) {
        if (picker != null) {
            picker.addItem(event.getWebcam());
        }
    }

    @Override
    public void webcamGone(WebcamDiscoveryEvent wde) {
        if (picker != null) {
            picker.removeItem(wde.getWebcam());
        }
    }
}
