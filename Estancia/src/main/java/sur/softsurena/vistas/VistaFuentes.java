package sur.softsurena.vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import javax.swing.JColorChooser;
import static sur.softsurena.utilidades.Utilidades.LOG;

public final class VistaFuentes extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;

    private Font fuente;
    private Color color;

    public Font getFuente() {
        return fuente;
    }

    public void setFuente(Font fuente) {
        this.fuente = fuente;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public VistaFuentes(java.awt.Frame parent, boolean modal, Font fuente, Color color) {
        super(parent, modal);
        initComponents();

        jcbFuentes.removeAllItems();
        
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().
                getAvailableFontFamilyNames();

        for (String fontName : fontNames) {
            jcbFuentes.addItem(fontName);
        }

        jlFuente.setFont(fuente);
        jlFuente.setForeground(color);
        
        jsTamano.setValue(jlFuente.getFont().getSize());
        
        jtbNormalNegrita.setSelected(jlFuente.getFont().isBold());
        
        if(jlFuente.getFont().isBold()){
            jtbNormalNegrita.setFont(new Font("Ubuntu", Font.BOLD, 15));
            jtbNormalNegrita.setText("Negrita");
        }else{
            jtbNormalNegrita.setFont(new Font("Ubuntu", Font.PLAIN, 15));
            jtbNormalNegrita.setText("Normal");
        }
        
        jcbFuentes.setSelectedItem(fuente.getFontName());
        setLocationRelativeTo(null);
        pack();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpEnfermedades = new javax.swing.JPanel();
        jtbNormalNegrita = new javax.swing.JToggleButton();
        jlFuente4 = new javax.swing.JLabel();
        jlFuente1 = new javax.swing.JLabel();
        btnColor = new javax.swing.JButton();
        jsTamano = new javax.swing.JSpinner();
        jcbFuentes = new javax.swing.JComboBox<>();
        btnEnfermedades = new javax.swing.JButton();
        jlFuente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccion de fuentes");

        jpEnfermedades.setBorder(javax.swing.BorderFactory.createTitledBorder("Fuentes"));

        jtbNormalNegrita.setText("Normal");
        jtbNormalNegrita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbNormalNegritaActionPerformed(evt);
            }
        });

        jlFuente4.setText("Fuentes");

        jlFuente1.setText("Tamaño");

        btnColor.setText("Color Fuente");
        btnColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorActionPerformed(evt);
            }
        });

        jsTamano.setModel(new javax.swing.SpinnerNumberModel(12, 12, 50, 1));
        jsTamano.setValue(14);
        jsTamano.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsTamanoStateChanged(evt);
            }
        });

        jcbFuentes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbFuentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFuentesActionPerformed(evt);
            }
        });

        btnEnfermedades.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnEnfermedades.setText("Aplicar");
        btnEnfermedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnfermedadesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpEnfermedadesLayout = new javax.swing.GroupLayout(jpEnfermedades);
        jpEnfermedades.setLayout(jpEnfermedadesLayout);
        jpEnfermedadesLayout.setHorizontalGroup(
            jpEnfermedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jpEnfermedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpEnfermedadesLayout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(jpEnfermedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jcbFuentes, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlFuente4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(jpEnfermedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jpEnfermedadesLayout.createSequentialGroup()
                            .addComponent(jsTamano, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtbNormalNegrita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jlFuente1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(8, 8, 8)
                    .addComponent(btnColor)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnEnfermedades, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jpEnfermedadesLayout.setVerticalGroup(
            jpEnfermedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
            .addGroup(jpEnfermedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpEnfermedadesLayout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addGroup(jpEnfermedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlFuente1)
                        .addComponent(jlFuente4))
                    .addGroup(jpEnfermedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jtbNormalNegrita)
                        .addComponent(btnColor)
                        .addComponent(jsTamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbFuentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEnfermedades))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jlFuente.setText("Ejemplo de la fuente!!!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpEnfermedades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlFuente, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpEnfermedades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jlFuente, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbNormalNegritaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbNormalNegritaActionPerformed
        if (jtbNormalNegrita.isSelected()) {
            jtbNormalNegrita.setFont(new Font("Ubuntu", Font.BOLD, 15));
            jtbNormalNegrita.setText("Negrita");

        } else {
            jtbNormalNegrita.setFont(new Font("Ubuntu", Font.PLAIN, 15));
            jtbNormalNegrita.setText("Normal");
        }
        jcbFuentesActionPerformed(null);
    }//GEN-LAST:event_jtbNormalNegritaActionPerformed

    private void btnColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorActionPerformed
        jlFuente.setForeground(JColorChooser.showDialog(null,
                "Elige un color para la fuente", Color.BLACK));
    }//GEN-LAST:event_btnColorActionPerformed

    private void jsTamanoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsTamanoStateChanged
        if ((int) jsTamano.getValue() < 1) {
            jsTamano.setValue(0);

        }
        jcbFuentesActionPerformed(null);
    }//GEN-LAST:event_jsTamanoStateChanged

    private void jcbFuentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFuentesActionPerformed
        if (!jcbFuentes.isShowing()) {
            return;
        }

        jlFuente.setFont(new Font(jcbFuentes.getSelectedItem().toString(),
                (jtbNormalNegrita.isSelected() ? Font.BOLD : Font.PLAIN),
                (int) jsTamano.getValue()));
    }//GEN-LAST:event_jcbFuentesActionPerformed

    private void btnEnfermedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnfermedadesActionPerformed
        setFuente(new Font(jcbFuentes.getSelectedItem().toString(),
                (jtbNormalNegrita.isSelected() ? Font.BOLD : Font.PLAIN),
                (int) jsTamano.getValue()));
        setColor(jlFuente.getForeground());

        //Escribir en un archivo properties...
        Properties p = new Properties();
        p.setProperty("Fuente", jcbFuentes.getSelectedItem().toString());
        p.setProperty("NormalNegrita", ""
                + (jtbNormalNegrita.isSelected() ? Font.BOLD : Font.PLAIN));
        p.setProperty("Tamano", "" + ((int) jsTamano.getValue()));
        p.setProperty("ColorR", "" + jlFuente.getForeground().getRed());
        p.setProperty("ColorG", "" + jlFuente.getForeground().getGreen());
        p.setProperty("ColorB", "" + jlFuente.getForeground().getBlue());

        try {
            p.store(new FileWriter(System.getProperty("user.dir")
                    + "/properties/hojas.properties"),
                    "Archivos para la persistencias de las fuentes de frmConsultas");
        } catch (IOException ex) {
            LOG.getLogger(VistaFuentes.class.getName()).log(Level.SEVERE, null, ex);
        }

        dispose();
    }//GEN-LAST:event_btnEnfermedadesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnColor;
    private javax.swing.JButton btnEnfermedades;
    private javax.swing.JComboBox<String> jcbFuentes;
    private javax.swing.JLabel jlFuente;
    private javax.swing.JLabel jlFuente1;
    private javax.swing.JLabel jlFuente4;
    private javax.swing.JPanel jpEnfermedades;
    private javax.swing.JSpinner jsTamano;
    private javax.swing.JToggleButton jtbNormalNegrita;
    // End of variables declaration//GEN-END:variables
}
