package sur.softsurena.formularios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import sur.softsurena.utilidades.Servidor;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class frmParametros extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    private final Properties propiedades;
    private File filePropertie = null;

    public static frmParametros getInstance() {
        return NewSingletonHolder.INSTANCE;
    }

    private static class NewSingletonHolder {

        private static final frmParametros INSTANCE = new frmParametros();
    }

    private frmParametros() {
        initComponents();
        propiedades = new Properties();

        try {
            filePropertie = new File("properties/propiedades.properties");
            propiedades.load(new FileReader(filePropertie));
        } catch (FileNotFoundException ex) {
            LOG.log(Level.SEVERE, "Archivo no encotrado", ex);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Error de entrada o salida del archivo propiedades.", ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPuerto = new javax.swing.JTextField();
        txtHost = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnAceptar = new RSMaterialComponent.RSButtonMaterialIconOne();
        txtPathBaseDatos = new RSMaterialComponent.RSTextFieldMaterialIcon();
        btnBuscarDB = new RSMaterialComponent.RSButtonMaterialIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Parametros del Sistema");
        setAlwaysOnTop(true);
        setSize(new java.awt.Dimension(439, 210));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtPuerto.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtPuerto.setText("3050");
        txtPuerto.setToolTipText("");
        txtPuerto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Puerto"));
        txtPuerto.setName("txtPuerto"); // NOI18N
        txtPuerto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPuertoKeyReleased(evt);
            }
        });

        txtHost.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtHost.setText("localhost");
        txtHost.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Servidor"));
        txtHost.setName("txtHost"); // NOI18N

        jPanel1.setMaximumSize(new java.awt.Dimension(216, 40));
        jPanel1.setMinimumSize(new java.awt.Dimension(216, 40));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 2, 5, 5));

        btnCancelar.setBackground(new java.awt.Color(204, 0, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setMaximumSize(new java.awt.Dimension(216, 40));
        btnCancelar.setMinimumSize(new java.awt.Dimension(216, 40));
        btnCancelar.setPreferredSize(new java.awt.Dimension(216, 40));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);

        btnAceptar.setText("Aceptar");
        btnAceptar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnAceptar.setMaximumSize(new java.awt.Dimension(216, 40));
        btnAceptar.setMinimumSize(new java.awt.Dimension(216, 40));
        btnAceptar.setName("btnAceptar"); // NOI18N
        btnAceptar.setPreferredSize(new java.awt.Dimension(216, 40));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar);

        txtPathBaseDatos.setForeground(new java.awt.Color(187, 187, 187));
        txtPathBaseDatos.setToolTipText("Ingresa el alias o la ruta de la base de datos.");
        txtPathBaseDatos.setColorIcon(new java.awt.Color(187, 187, 187));
        txtPathBaseDatos.setColorMaterial(new java.awt.Color(187, 187, 187));
        txtPathBaseDatos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ARCHIVE);
        txtPathBaseDatos.setName("txtPathBaseDatos"); // NOI18N
        txtPathBaseDatos.setPhColor(new java.awt.Color(187, 187, 187));
        txtPathBaseDatos.setPlaceholder("Alias o Ruta BD");

        btnBuscarDB.setText("Buscar");
        btnBuscarDB.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnBuscarDB.setMaximumSize(new java.awt.Dimension(216, 40));
        btnBuscarDB.setMinimumSize(new java.awt.Dimension(216, 40));
        btnBuscarDB.setPreferredSize(new java.awt.Dimension(216, 40));
        btnBuscarDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtPathBaseDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPuerto, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(btnBuscarDB, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPathBaseDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarDB, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtHost, txtPuerto});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBuscarDB, txtPathBaseDatos});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPuertoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPuertoKeyReleased
        char caracter = evt.getKeyChar();
        if (caracter < '0' || (caracter > '9')) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtPuertoKeyReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        if (txtHost.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Nombre del servidor vacio",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtHost.requestFocus();
            return;
        }
        int valor;
        try {
            valor = Integer.parseInt(txtPuerto.getText());
        } catch (NumberFormatException e) {
            valor = -1;
        }
        if (valor < 0 || valor > 65535) {
            JOptionPane.showMessageDialog(
                    this,
                    "Este Puerto no es valido",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtPuerto.setText("");
            txtPuerto.requestFocus();
            return;
        }

        escribirParametros();
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnBuscarDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDBActionPerformed
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Base de datos Firebird", "FDB", "fdb");
        jfc.setFileFilter(filter);

        int returnVal = jfc.showOpenDialog(null);

        if (returnVal == JFileChooser.CANCEL_OPTION) {
            return;
        }

        txtPathBaseDatos.setText(jfc.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_btnBuscarDBActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarParamentos();
    }//GEN-LAST:event_formWindowOpened


    public Servidor cargarParamentos() {
        Servidor servidor = Servidor
                .builder()
                .host(propiedades.getProperty("Nombre_del_Servidor", "localhost"))
                .puerto(propiedades.getProperty("Puerto_del_Servidor", "3050"))
                .pathBaseDatos(propiedades.getProperty("PathBaseDatos", "SoftSurena.db"))
                .build();
        txtHost.setText(servidor.getHost());
        txtPuerto.setText(servidor.getPuerto());
        txtPathBaseDatos.setText(servidor.getPathBaseDatos());
        return servidor;
    }

    private void escribirParametros() {
        propiedades.setProperty("Nombre_del_Servidor", txtHost.getText());
        propiedades.setProperty("Puerto_del_Servidor", txtPuerto.getText());
        propiedades.setProperty("PathBaseDatos", txtPathBaseDatos.getText());

        try {
            propiedades.store(
                    new FileWriter(filePropertie),
                    "Parametros del Servidor actual"
            );
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Error al leer la propiedades del archivo.", ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAceptar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBuscarDB;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtHost;
    private RSMaterialComponent.RSTextFieldMaterialIcon txtPathBaseDatos;
    private javax.swing.JTextField txtPuerto;
    // End of variables declaration//GEN-END:variables
}
