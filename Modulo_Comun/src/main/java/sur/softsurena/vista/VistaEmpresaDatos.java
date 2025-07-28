package sur.softsurena.vista;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import static sur.softsurena.utilidades.Utilidades.LOG;

public final class VistaEmpresaDatos extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    private final File file;

    public VistaEmpresaDatos() {
        initComponents();
        file = new File("ArchivosConfiguracion/Empresa.ini");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        txtPorCiento = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTipoEmpresa = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtRNC = new javax.swing.JTextField();
        txtTelefonoEmpresa = new javax.swing.JTextField();
        txtNombreEmpresa = new javax.swing.JTextField();
        btnAceptar1 = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();
        txtMensaje = new javax.swing.JTextPane();

        setClosable(true);
        setTitle("Atributos basicos del sistema");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        txtPorCiento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPorCiento.setForeground(new java.awt.Color(1, 1, 1));
        txtPorCiento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), " %Ganancina Productos "));

        txtDireccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(1, 1, 1));
        txtDireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), " Direcciòn "));

        txtTipoEmpresa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTipoEmpresa.setForeground(new java.awt.Color(1, 1, 1));
        txtTipoEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), " Tipo de Empresa "));

        txtCorreo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(1, 1, 1));
        txtCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Correo electrónico"));

        txtRNC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtRNC.setForeground(new java.awt.Color(1, 1, 1));
        txtRNC.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), " RNC "));

        txtTelefonoEmpresa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTelefonoEmpresa.setForeground(new java.awt.Color(1, 1, 1));
        txtTelefonoEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), " Telefono/s "));

        txtNombreEmpresa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombreEmpresa.setForeground(new java.awt.Color(1, 1, 1));
        txtNombreEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), " Nombre de la empresa "));

        btnAceptar1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAceptar1.setForeground(new java.awt.Color(1, 1, 1));
        btnAceptar1.setText("Aceptar");
        btnAceptar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptar1MouseExited(evt);
            }
        });
        btnAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar1ActionPerformed(evt);
            }
        });

        btnCancelar1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelar1.setForeground(new java.awt.Color(1, 1, 1));
        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        txtMensaje.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), " Mensaje de Tickes "));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTelefonoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtRNC, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTipoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPorCiento, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefonoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRNC, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTipoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPorCiento, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar1)
                    .addComponent(btnAceptar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        cargarConfiguracion();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void btnAceptar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptar1MouseEntered
        btnAceptar1.setForeground(Color.BLUE);
    }//GEN-LAST:event_btnAceptar1MouseEntered

    private void btnAceptar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptar1MouseExited
        btnAceptar1.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnAceptar1MouseExited

    private void btnAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar1ActionPerformed
        grabarConfiguracion(
                txtNombreEmpresa.getText(),
                txtTelefonoEmpresa.getText(),
                txtCorreo.getText(),
                txtRNC.getText(),
                txtDireccion.getText(),
                txtTipoEmpresa.getText(),
                txtPorCiento.getText(),
                txtMensaje.getText()
        );
        dispose();
    }//GEN-LAST:event_btnAceptar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar1;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    public javax.swing.JTextPane txtMensaje;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtPorCiento;
    private javax.swing.JTextField txtRNC;
    private javax.swing.JTextField txtTelefonoEmpresa;
    private javax.swing.JTextField txtTipoEmpresa;
    // End of variables declaration//GEN-END:variables

    private void cargarConfiguracion() {

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
               LOG.log(
                        Level.SEVERE, 
                        "No puede leerse el archivo Empresa.ini", 
                        ex
                );
            }
        }
        
        try (FileReader fr = new FileReader(file); 
                BufferedReader br = new BufferedReader(fr);) {

            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Nombre =")) {
                    txtNombreEmpresa.setText(new String(linea.substring(8)));
                }
                if (linea.startsWith("Telefono =")) {
                    txtTelefonoEmpresa.setText(new String(linea.substring(10)));
                }
                if (linea.startsWith("Correo =")) {
                    txtCorreo.setText(new String(linea.substring(8)));
                }
                if (linea.startsWith("RNC =")) {
                    txtRNC.setText(new String(linea.substring(5)));
                }
                if (linea.startsWith("Direccion =")) {
                    txtDireccion.setText(new String(linea.substring(11)));
                }
                if (linea.startsWith("TipoEmpresa =")) {
                    txtTipoEmpresa.setText(new String(linea.substring(13)));
                }
                if (linea.startsWith("PorCiento =")) {
                    txtPorCiento.setText(new String(linea.substring(11)));
                }
                if (linea.startsWith("Mensaje =")) {
                    txtMensaje.setText(new String(linea.substring(9)));
                }
            }
        } catch (IOException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error al no encontrar el archivo de entrada o salida.",
                    ex
            );
        }
    }

    /**
     *
     * @param nombre
     * @param telefono
     * @param correo
     * @param RNC
     * @param direccion
     * @param tipoEmpresa
     * @param porCiento
     */
    private void grabarConfiguracion(
            String nombre,
            String telefono,
            String correo,
            String RNC,
            String direccion,
            String tipoEmpresa,
            String porCiento,
            String mensaje
    ) {
        try (FileWriter fw = new FileWriter(file); PrintWriter pw = new PrintWriter(fw);) {
            pw.println("[General]");
            pw.println("Nombre =" + nombre);
            pw.println("Telefono =" + telefono);
            pw.println("Correo =" + correo);
            pw.println("RNC =" + RNC);
            pw.println("Direccion =" + direccion);
            pw.println("TipoEmpresa =" + tipoEmpresa);
            pw.println("PorCiento =" + porCiento);
            pw.println("Mensaje =" + mensaje);
        } catch (Exception e1) {
            LOG.log(
                    Level.SEVERE,
                    e1.getMessage(),
                    e1
            );
        }
    }
}
