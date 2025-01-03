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

public class MainForm extends JFrame {

    public static String TEMPLATE_PROPERTY = "template";
    private DPFPTemplate template;

    public class TemplateFileFilter extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File f) {
            return f.getName().endsWith(".fpt");
        }

        @Override
        public String getDescription() {
            return "Fingerprint Template File (*.fpt)";
        }
    }

    MainForm() {
        setState(Frame.NORMAL);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Fingerprint Enrollment and Verification Sample");
        setResizable(false);

        final JButton enroll = new JButton("Fingerprint Enrollment");
        enroll.addActionListener((ActionEvent e) -> {
            onEnroll();
        });

        final JButton verify = new JButton("Fingerprint Verification");
        verify.addActionListener((ActionEvent e) -> {
            onVerify();
        });

        final JButton save = new JButton("Save Fingerprint Template");
        save.addActionListener((ActionEvent e) -> {
            onSave();
        });

        final JButton load = new JButton("Read Fingerprint Template");
        load.addActionListener((ActionEvent e) -> {
            onLoad();
        });

        final JButton quit = new JButton("Close");
        quit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

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
                                "The fingerprint template is ready for fingerprint verification.", "Fingerprint Enrollment",
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
        center.add(save);
        center.add(load);

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
                                String.format("File \"%1$s\" already exists.\nDo you want to replace it?", file.toString()),
                                "Fingerprint saving",
                                JOptionPane.YES_NO_CANCEL_OPTION);
                        if (choice == JOptionPane.NO_OPTION) {
                            continue;
                        } else if (choice == JOptionPane.CANCEL_OPTION) {
                            break;
                        }
                    }
                    stream.write(getTemplate().serialize());
                    stream.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getLocalizedMessage(), "Fingerprint saving", JOptionPane.ERROR_MESSAGE);
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
                stream.close();
                DPFPTemplate t = DPFPGlobal.getTemplateFactory().createTemplate();
                t.deserialize(data);
                setTemplate(t);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getLocalizedMessage(), "Fingerprint loading", JOptionPane.ERROR_MESSAGE);
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
            new MainForm();
        });
    }

}
