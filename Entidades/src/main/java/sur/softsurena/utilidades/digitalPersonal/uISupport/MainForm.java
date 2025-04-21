package sur.softsurena.utilidades.digitalPersonal.uISupport;

import com.digitalpersona.onetouch.*;
import com.digitalpersona.onetouch.verification.DPFPVerification;

import javax.swing.*;
import javax.swing.text.DefaultFormatter;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.util.*;

/**
 * Enrollment control test console
 */
public class MainForm extends JFrame {

    private EnumMap<DPFPFingerIndex, DPFPTemplate> templates = new EnumMap<>(DPFPFingerIndex.class);
    private final EnumMap<DPFPFingerIndex, JCheckBox> checkBoxes = new EnumMap<>(DPFPFingerIndex.class);

    private static final DPFPTemplate fakeTemplate;
    private SpinnerNumberModel maxCount = new SpinnerNumberModel(DPFPFingerIndex.values().length, 0, DPFPFingerIndex.values().length, 1);
    private final JSpinner maxCountSpinner;

    private final JButton enrollButton = new JButton("Inscribir huellas dactilares");
    private final JButton verifyButton = new JButton("Verificar huella dactilares");
    private SpinnerNumberModel farRequested
            = new SpinnerNumberModel(DPFPVerification.MEDIUM_SECURITY_FAR, 1, DPFPVerification.PROBABILITY_ONE, 100);
    private JSpinner farRequestedSpinner;
    private JTextField farAchieved;
    JCheckBox fingerMatched;

    static {
        fakeTemplate = DPFPGlobal.getTemplateFactory().createTemplate();
        try {
            fakeTemplate.deserialize(new byte[0]);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public MainForm() {
        super("Sistema de huellas");

        setState(Frame.NORMAL);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        //// Enrollment Panel
        JPanel enrollmentConfigPanel = new JPanel();
        enrollmentConfigPanel.setBorder(BorderFactory.createTitledBorder("Inscripción"));
        enrollmentConfigPanel.setLayout(new BoxLayout(enrollmentConfigPanel, BoxLayout.Y_AXIS));

        ///// Count
        maxCountSpinner = new JSpinner(maxCount);
        JSpinner.DefaultEditor maxEditor = (JSpinner.DefaultEditor) maxCountSpinner.getEditor();
        DefaultFormatter maxFormatter = (DefaultFormatter) (maxEditor.getTextField().getFormatter());
        maxFormatter.setAllowsInvalid(false);

        JPanel maxcountPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        maxcountPanel.add(new JLabel("Recuento máximo de huellas dactilares registradas"));
        maxcountPanel.add(maxCountSpinner);

        ///// Fingers
        JPanel fingersPanel = new JPanel(new GridBagLayout());
        fingersPanel.setBorder(BorderFactory.createTitledBorder("Inscribir huellas dactilares"));
        for (DPFPFingerIndex finger : DPFPFingerIndex.values()) {
            JCheckBox jCheckBox = new JCheckBox(Utilities.fingerName(finger));
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            final int rows = DPFPFingerIndex.values().length / 2;
            gridBagConstraints.gridx = finger.ordinal() / rows;
            gridBagConstraints.gridy = rows - 1 - Math.abs(rows - 1 - finger.ordinal()) + gridBagConstraints.gridx;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            fingersPanel.add(jCheckBox, gridBagConstraints);
            checkBoxes.put(finger, jCheckBox);

            final DPFPFingerIndex dummyFinger = finger;
            jCheckBox.addActionListener(new ActionListener() {
                DPFPFingerIndex index;

                {
                    index = dummyFinger;
                }

                @Override
                public void actionPerformed(ActionEvent e) {
                    JCheckBox cb = (JCheckBox) e.getSource();
                    if (cb.isSelected()) {
                        JOptionPane.showMessageDialog(
                                MainForm.this,
                                "Para inscribir el dedo, haga clic en Inscribir huellas dactilares.", 
                                "Inscripción de huellas dactilares",
                                JOptionPane.INFORMATION_MESSAGE);
                        cb.setSelected(false);
//                      templates.put(index, fakeTemplate);
                    } else {
                        if (JOptionPane.showConfirmDialog(
                                MainForm.this,
                                "¿Estás seguro de que quieres eliminar el" + Utilities.fingerprintName(index) + "?", 
                                "Inscripción de huellas dactilares",
                                JOptionPane.YES_NO_OPTION
                        ) == JOptionPane.YES_OPTION) {
                            templates.remove(index);
                        } else {
                            cb.setSelected(true);
                        }
                    }
                    UpdateUI();
                }
            });
        }

        final JCheckBox enforceFailure = new JCheckBox("Hacer cumplir la inscripción o cancelar la inscripción en caso de fallo");
        enforceFailure.setAlignmentX(CENTER_ALIGNMENT);
        enforceFailure.setHorizontalTextPosition(SwingConstants.LEADING);

        /*        final JCheckBox continueCapture = new JCheckBox("Don't stop capture");
        continueCapture.setAlignmentX(CENTER_ALIGNMENT);
        continueCapture.setHorizontalTextPosition(SwingConstants.LEADING);
         */
        ///// Button
        enrollButton.addActionListener(
                (ActionEvent e) -> {
                    new EnrollmentDialog(
                            MainForm.this,
                            maxCount.getNumber().intValue(),
                            enforceFailure.isSelected() ? "Sólo porque no estoy en modo." : null,
                            templates
                    ).setVisible(true);
                    UpdateUI();
                }
        );
        enrollButton.setAlignmentX(CENTER_ALIGNMENT);

        enrollmentConfigPanel.add(maxcountPanel);
        enrollmentConfigPanel.add(fingersPanel);
        enrollmentConfigPanel.add(enforceFailure);
        enrollmentConfigPanel.add(Box.createVerticalStrut(4));
        enrollmentConfigPanel.add(enrollButton);
        enrollmentConfigPanel.add(Box.createVerticalStrut(4));

        //// Verification Panel
        JPanel verificationConfigPanel = new JPanel();
        verificationConfigPanel.setBorder(BorderFactory.createTitledBorder("Verificación"));
        verificationConfigPanel.setLayout(new BoxLayout(verificationConfigPanel, BoxLayout.Y_AXIS));

        ///// False Accept Rate
        JPanel farPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints;

        // FAR requested
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 4, 0, 0);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        farPanel.add(new JLabel("Tasa de aceptación falsa (FAR) solicitada: "), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 4);
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        farRequestedSpinner = new JSpinner(farRequested);
        farRequestedSpinner.setPreferredSize(new Dimension(100, 20));
        JSpinner.DefaultEditor farEditor = (JSpinner.DefaultEditor) farRequestedSpinner.getEditor();
        DefaultFormatter farFormatter = (DefaultFormatter) (farEditor.getTextField().getFormatter());
        farFormatter.setAllowsInvalid(false);

        farPanel.add(farRequestedSpinner, gridBagConstraints);

        // FAR achieved
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 4, 0, 0);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        farPanel.add(new JLabel("Tasa de aceptación falsa (FAR) lograda: "), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 0, 0, 4);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        farAchieved = new JTextField();
        farAchieved.setEditable(false);
        farAchieved.setPreferredSize(new Dimension(100, 20));
        farPanel.add(farAchieved, gridBagConstraints);

        fingerMatched = new JCheckBox("Huella dactilar coincidente");
        fingerMatched.setEnabled(false);
        fingerMatched.setAlignmentX(CENTER_ALIGNMENT);
        fingerMatched.setHorizontalTextPosition(SwingConstants.LEADING);

        ///// Button
        verifyButton.addActionListener(
                (ActionEvent e) -> {
                    try {
                        VerificationDialog dlg = new VerificationDialog(MainForm.this, templates, farRequested.getNumber().intValue());
                        dlg.addPropertyChangeListener(
                                (final PropertyChangeEvent e1) -> {
                                    String name1 = e1.getPropertyName();
                                    if (VerificationDialog.FAR_PROPERTY.equals(name1)) {
                                        farAchieved.setText("" + (Integer) e1.getNewValue());
                                    } else if (VerificationDialog.MATCHED_PROPERTY.equals(name1)) {
                                        fingerMatched.setSelected((Boolean) e1.getNewValue());
                                    }
                                }
                        );
                        dlg.setVisible(true);
                    } catch (Exception ex) {
                        farRequestedSpinner.requestFocus();
                    }
                });
        verifyButton.setAlignmentX(CENTER_ALIGNMENT);

        verificationConfigPanel.add(farPanel);
        verificationConfigPanel.add(fingerMatched);
        verificationConfigPanel.add(Box.createVerticalStrut(4));
        verificationConfigPanel.add(verifyButton);
        verificationConfigPanel.add(Box.createVerticalStrut(4));

        //// Main frame
        JPanel dummy = new JPanel();
        dummy.setLayout(new BoxLayout(dummy, BoxLayout.Y_AXIS));
        dummy.add(Box.createVerticalStrut(4));
        dummy.add(enrollmentConfigPanel);
        dummy.add(verificationConfigPanel);
        dummy.add(Box.createVerticalStrut(4));

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(Box.createHorizontalStrut(4));
        add(dummy);
        add(Box.createHorizontalStrut(4));

        pack();
        setLocationRelativeTo(null);
        UpdateUI();
        setVisible(true);

        enrollButton.requestFocus();
    }

    private void UpdateUI() {
        // update enrolled fingers checkboxes
        for (DPFPFingerIndex finger : DPFPFingerIndex.values()) {
            checkBoxes.get(finger).setSelected(templates.containsKey(finger));
        }
        // update verification button
        verifyButton.setEnabled(!templates.isEmpty());
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(
                () -> {
                    new MainForm();
                }
        );
    }

}
