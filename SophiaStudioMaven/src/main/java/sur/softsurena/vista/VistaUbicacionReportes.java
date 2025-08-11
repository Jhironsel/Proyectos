package sur.softsurena.vista;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import static sur.softsurena.utilidades.Utilidades.LOG;

public final class VistaUbicacionReportes extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;


    public VistaUbicacionReportes() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnBuscarAlumnosAgrupados = new javax.swing.JButton();
        btnBuscarAlumnos = new javax.swing.JButton();
        btnRecibo = new javax.swing.JButton();
        btnDeuda = new javax.swing.JButton();
        btnImagenReporte = new javax.swing.JButton();
        txtBuscarAlumnos = new javax.swing.JTextField();
        txtBuscarAlumnosAgrupados = new javax.swing.JTextField();
        txtRecibo = new javax.swing.JTextField();
        txtDeuda = new javax.swing.JTextField();
        txtImagenReporte = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtMensualidadAlumno = new javax.swing.JTextField();
        txtPagoInscripcion = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ubicacion de Reportes");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
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
            }
        });

        btnGuardar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Guardar 32 x 32.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnBuscarAlumnosAgrupados.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscarAlumnosAgrupados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buscar32x32.png"))); // NOI18N
        btnBuscarAlumnosAgrupados.setText("Buscar...");
        btnBuscarAlumnosAgrupados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAlumnosAgrupadosActionPerformed(evt);
            }
        });

        btnBuscarAlumnos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscarAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buscar32x32.png"))); // NOI18N
        btnBuscarAlumnos.setText("Buscar...");
        btnBuscarAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAlumnosActionPerformed(evt);
            }
        });

        btnRecibo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnRecibo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buscar32x32.png"))); // NOI18N
        btnRecibo.setText("Buscar...");
        btnRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReciboActionPerformed(evt);
            }
        });

        btnDeuda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDeuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buscar32x32.png"))); // NOI18N
        btnDeuda.setText("Buscar...");
        btnDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeudaActionPerformed(evt);
            }
        });

        btnImagenReporte.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnImagenReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buscar32x32.png"))); // NOI18N
        btnImagenReporte.setText("Buscar...");
        btnImagenReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenReporteActionPerformed(evt);
            }
        });

        txtBuscarAlumnos.setEditable(false);
        txtBuscarAlumnos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtBuscarAlumnos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Reportes de alumnos"));

        txtBuscarAlumnosAgrupados.setEditable(false);
        txtBuscarAlumnosAgrupados.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtBuscarAlumnosAgrupados.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Reportes de Alumnos Agrupados "));

        txtRecibo.setEditable(false);
        txtRecibo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtRecibo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Recibo"));

        txtDeuda.setEditable(false);
        txtDeuda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDeuda.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Deuda"));

        txtImagenReporte.setEditable(false);
        txtImagenReporte.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtImagenReporte.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Imagen del reporte"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscarAlumnos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(txtBuscarAlumnosAgrupados, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarAlumnos)
                            .addComponent(btnBuscarAlumnosAgrupados, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtRecibo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRecibo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDeuda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeuda))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtImagenReporte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImagenReporte)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarAlumnos)
                    .addComponent(txtBuscarAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtBuscarAlumnosAgrupados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarAlumnosAgrupados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRecibo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeuda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImagenReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImagenReporte))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBuscarAlumnosAgrupados, txtBuscarAlumnosAgrupados});

        jTabbedPane1.addTab("Reportes", new javax.swing.ImageIcon(getClass().getResource("/Images/Reportes.png")), jPanel1); // NOI18N

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtMensualidadAlumno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtMensualidadAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Mensualidad general"));
        txtMensualidadAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMensualidadAlumnoKeyTyped(evt);
            }
        });

        txtPagoInscripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPagoInscripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Pago de Inscripcion"));
        txtPagoInscripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagoInscripcionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMensualidadAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPagoInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMensualidadAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPagoInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Otros", new javax.swing.ImageIcon(getClass().getResource("/Images/Movimiento 72 x 72.png")), jPanel2); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private String buscar() {
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filtro
                = new FileNameExtensionFilter("jasper", "jasper");
        file.setFileFilter(filtro);
        int dime = file.showOpenDialog(this);

        if (!(dime == JFileChooser.APPROVE_OPTION)) {
            return "";
        } else {
            return file.getSelectedFile().getPath();
        }
    }
    private void btnBuscarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAlumnosActionPerformed
        txtBuscarAlumnos.setText(buscar());
    }//GEN-LAST:event_btnBuscarAlumnosActionPerformed

    private void btnBuscarAlumnosAgrupadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAlumnosAgrupadosActionPerformed
        txtBuscarAlumnosAgrupados.setText(buscar());
    }//GEN-LAST:event_btnBuscarAlumnosAgrupadosActionPerformed
    private void cerrar() {
        VistaPrincipal miPrincipal = new VistaPrincipal();
        miPrincipal.dpnEscritorio.getDesktopManager().closeFrame(this);
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cerrar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
//        ResultSet rs = getUbicaciones();
        ResultSet rs = null;
        int opc = 1;
        try {
            while (rs.next()) {
                if (opc == 1) {
                    txtBuscarAlumnos.setText(rs.getString("Patch"));
                }
                if (opc == 2) {
                    txtBuscarAlumnosAgrupados.setText(rs.getString("Patch"));
                }
                if (opc == 3) {
                    txtMensualidadAlumno.setText(rs.getString("Dinero"));
                }
                if (opc == 4) {
                    txtPagoInscripcion.setText(rs.getString("Dinero"));
                }
                if (opc == 5) {
                    txtRecibo.setText(rs.getString("Patch"));
                }
                if (opc == 6) {
                    txtDeuda.setText(rs.getString("Patch"));
                }
                opc++;
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE, 
                    ex.getMessage(), 
                    ex
            );
        }
    }//GEN-LAST:event_formInternalFrameActivated

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String[] patch = new String[5];
        patch[0] = txtBuscarAlumnos.getText();
        patch[1] = txtBuscarAlumnosAgrupados.getText();
        patch[2] = txtMensualidadAlumno.getText();
        patch[3] = txtPagoInscripcion.getText();
        patch[4] = txtRecibo.getText();
        patch[5] = txtDeuda.getText();

        //JOptionPane.showMessageDialog(this, modificarUbicaciones(patch));

        cerrar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReciboActionPerformed
        txtRecibo.setText(buscar());
    }//GEN-LAST:event_btnReciboActionPerformed

    private void txtMensualidadAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMensualidadAlumnoKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 48 && k <= 57 || k == 8) {
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(this, "No puede ingresar letras!!!",
                    "Ventana Error Datos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtMensualidadAlumnoKeyTyped

    private void txtPagoInscripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoInscripcionKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 48 && k <= 57 || k == 8) {
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(this, "No puede ingresar letras!!!",
                    "Ventana Error Datos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtPagoInscripcionKeyTyped

    private void btnDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeudaActionPerformed
        txtDeuda.setText(buscar());
    }//GEN-LAST:event_btnDeudaActionPerformed

    private void btnImagenReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenReporteActionPerformed
        txtImagenReporte.setText(buscar());
    }//GEN-LAST:event_btnImagenReporteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarAlumnos;
    private javax.swing.JButton btnBuscarAlumnosAgrupados;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDeuda;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImagenReporte;
    private javax.swing.JButton btnRecibo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtBuscarAlumnos;
    private javax.swing.JTextField txtBuscarAlumnosAgrupados;
    private javax.swing.JTextField txtDeuda;
    private javax.swing.JTextField txtImagenReporte;
    private javax.swing.JTextField txtMensualidadAlumno;
    private javax.swing.JTextField txtPagoInscripcion;
    private javax.swing.JTextField txtRecibo;
    // End of variables declaration//GEN-END:variables
}
