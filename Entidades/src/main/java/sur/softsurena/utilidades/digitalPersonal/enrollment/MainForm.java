package sur.softsurena.utilidades.digitalPersonal.enrollment;

import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPTemplate;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public final class MainForm extends JFrame {

    private static final long serialVersionUID = 1L;
    
    public static String TEMPLATE_PROPERTY = "template";
    private transient DPFPTemplate template;

    public class TemplateFileFilter extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File f) {
            return f.getName().endsWith(".fpt");
        }

        @Override
        public String getDescription() {
            return "Archivo de plantilla de huellas dactilares (*.fpt)";
        }
    }

    public MainForm(boolean mostrarGuardarLeer) {
        setState(Frame.NORMAL);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setTitle("Sistema de huellas dactilares.");
        setResizable(false);

        final JButton enroll = new JButton("Inscripción de huellas dactilares");
        enroll.addActionListener(
                (ActionEvent e) -> {
                    onEnroll();
                }
        );

        final JButton verify = new JButton("Verificación de huellas dactilares");
        verify.addActionListener(
                (ActionEvent e) -> {
                    onVerify();
                }
        );

        final JButton save = new JButton("Guardar plantilla de huellas dactilares");
        save.addActionListener(
                (ActionEvent e) -> {
                    onSave();
                }
        );

        final JButton load = new JButton("Leer plantilla de huellas dactilares");
        load.addActionListener(
                (ActionEvent e) -> {
                    onLoad();
                }
        );

        final JButton quit = new JButton("Cierra");
        quit.addActionListener(
                (ActionEvent e) -> {
                    dispose();
                }
        );

        this.addPropertyChangeListener(
                TEMPLATE_PROPERTY,
                (PropertyChangeEvent evt) -> {
                    verify.setEnabled(template != null);
                    save.setEnabled(template != null);
                    if (evt.getNewValue() == evt.getOldValue()) {
                        return;
                    }
                    if (template != null) {
                        JOptionPane.showMessageDialog(
                                MainForm.this,
                                "La plantilla de huellas dactilares está lista para la verificación de huellas dactilares.",
                                "Inscripción de huellas dactilares",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
        );

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 1, 0, 5));
        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 5, 20));
        center.add(enroll);
        center.add(verify);
        if(mostrarGuardarLeer){
        center.add(save);
        center.add(load);
        }

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        bottom.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
        bottom.add(quit);

        setLayout(new BorderLayout());
        add(center, BorderLayout.CENTER);
        add(bottom, BorderLayout.PAGE_END);

        pack();
        setSize((int) (getSize().width * 1.6), getSize().height);
        setLocationRelativeTo(null);
        setTemplate(null);
        setVisible(true);
    }

    private void onEnroll() {
        EnrollmentForm form = new EnrollmentForm(this);
        form.setVisible(true);
    }

    private void onVerify() {
        VerificationForm form = new VerificationForm(this);
        form.setVisible(true);
    }

    private void onSave() {
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new TemplateFileFilter());
        while (true) {
            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try (FileOutputStream stream = new FileOutputStream(file)) {
                    if (!file.toString().toLowerCase().endsWith(".fpt")) {
                        file = new File(file.toString() + ".fpt");
                    }
                    if (file.exists()) {
                        int choice = JOptionPane.showConfirmDialog(this,
                                String.format("Archivo \"%1$s\" ya existe.\nQuieres remplazarlo?", file.toString()),
                                "Guardando huellas dactilares.",
                                JOptionPane.YES_NO_CANCEL_OPTION);
                        if (choice == JOptionPane.NO_OPTION) {
                            continue;
                        } else if (choice == JOptionPane.CANCEL_OPTION) {
                            break;
                        }
                    }
                    stream.write(getTemplate().serialize());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            this,
                            ex.getLocalizedMessage(),
                            "Guardando huellas dactilares.",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
            break;
        }
    }

    private void onLoad() {
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new TemplateFileFilter());
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (FileInputStream stream = new FileInputStream(chooser.getSelectedFile())) {
                byte[] data = new byte[stream.available()];
                stream.read(data);
                DPFPTemplate _template = DPFPGlobal.getTemplateFactory().createTemplate();
                _template.deserialize(data);
                setTemplate(_template);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this,
                        ex.getLocalizedMessage(),
                        "Cargando huella dactilares.",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public DPFPTemplate getTemplate() {
        return template;
    }

    public void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = this.template;
        this.template = template;
        firePropertyChange(TEMPLATE_PROPERTY, old, template);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainForm(false);
        });
    }

}
