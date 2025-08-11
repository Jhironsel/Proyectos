package sur.softsurena.vista;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import static sur.softsurena.utilidades.Utilidades.LOG;

public final class VistaAjustePerfil extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    ResultSet rs = null;

    public VistaAjustePerfil() {
        initComponents();
    }

    private void rebobinar() {
        cmbPerfiles.removeAllItems();
        txtCrearPerfil.setText("");
        try {
            //rs = getPerfiles();
            while (rs.next()) {
                cmbPerfiles.addItem(rs.getString(2));
            }
            cmbPerfiles.setSelectedIndex(-1);
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE, 
                    ex.getMessage(), 
                    ex
            );
        }
        cbPadres.setSelected(false);
        cbPadresRegistro.setSelected(false);
        cbPadresModificar.setSelected(false);
        cbPadresBorrar.setSelected(false);

        cbEstudiantes.setSelected(false);
        cbEstudiantesRegistro.setSelected(false);
        cbEstudiantesModificar.setSelected(false);
        cbEstudiantesConsultar.setSelected(false);

        cbUsuarios.setSelected(false);
        cbUsuariosRegistro.setSelected(false);
        cbUsuariosModificar.setSelected(false);
        cbUsuariosBorrar.setSelected(false);

        cbPagos.setSelected(false);
        cbAbonos.setSelected(false);
        cbReportes.setSelected(false);
        cbAjusteTanda.setSelected(false);
        cbAjustePerfil.setSelected(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbPerfiles = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cbPadres = new javax.swing.JCheckBox();
        cbPadresRegistro = new javax.swing.JCheckBox();
        cbPadresModificar = new javax.swing.JCheckBox();
        cbPadresBorrar = new javax.swing.JCheckBox();
        cbEstudiantes = new javax.swing.JCheckBox();
        cbEstudiantesRegistro = new javax.swing.JCheckBox();
        cbEstudiantesModificar = new javax.swing.JCheckBox();
        cbEstudiantesConsultar = new javax.swing.JCheckBox();
        cbUsuarios = new javax.swing.JCheckBox();
        cbUsuariosRegistro = new javax.swing.JCheckBox();
        cbUsuariosModificar = new javax.swing.JCheckBox();
        cbUsuariosBorrar = new javax.swing.JCheckBox();
        cbPagos = new javax.swing.JCheckBox();
        cbReportes = new javax.swing.JCheckBox();
        cbAjustePerfil = new javax.swing.JCheckBox();
        cbAbonos = new javax.swing.JCheckBox();
        cbAjusteTanda = new javax.swing.JCheckBox();
        btnCrear = new javax.swing.JButton();
        txtCrearPerfil = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Administrador de Perfiles del Sistema");
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

        cmbPerfiles.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel1.setText("Tipo de Perfil:");

        btnConsultar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buscar3 32 x 32.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Perfiles de acceso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        cbPadres.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbPadres.setText("Padres");

        cbPadresRegistro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbPadresRegistro.setText("Registro de Padres");

        cbPadresModificar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbPadresModificar.setText("Modificar Padre");

        cbPadresBorrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbPadresBorrar.setText("Borrar Padre");

        cbEstudiantes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbEstudiantes.setText("Estudiantes");

        cbEstudiantesRegistro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbEstudiantesRegistro.setText("Registro de Estudiantes");

        cbEstudiantesModificar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbEstudiantesModificar.setText("Modificar Estudiante");

        cbEstudiantesConsultar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbEstudiantesConsultar.setText("Consultar Estudiante");

        cbUsuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbUsuarios.setText("Usuarios");

        cbUsuariosRegistro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbUsuariosRegistro.setText("Registro de Usuarios");

        cbUsuariosModificar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbUsuariosModificar.setText("Modificar Usuario");

        cbUsuariosBorrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbUsuariosBorrar.setText("Borrar Usuario");

        cbPagos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbPagos.setText("Pagos");

        cbReportes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbReportes.setText("Reportes");

        cbAjustePerfil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbAjustePerfil.setText("Ajuste Perfil Usuario");
        cbAjustePerfil.setEnabled(false);

        cbAbonos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbAbonos.setText("Abonos");

        cbAjusteTanda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbAjusteTanda.setText("Ajuste Tanda");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbAbonos)
                        .addGap(145, 145, 145)
                        .addComponent(cbAjustePerfil)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbPadresModificar)
                                            .addComponent(cbPadresRegistro)
                                            .addComponent(cbPadresBorrar)))
                                    .addComponent(cbPadres)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbPagos)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbReportes)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbEstudiantesModificar)
                                            .addComponent(cbEstudiantesRegistro)
                                            .addComponent(cbEstudiantesConsultar)))
                                    .addComponent(cbEstudiantes))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbUsuarios)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbUsuariosModificar)
                                            .addComponent(cbUsuariosRegistro)
                                            .addComponent(cbUsuariosBorrar)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(cbAjusteTanda)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPadres)
                    .addComponent(cbUsuarios)
                    .addComponent(cbEstudiantes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbPadresRegistro)
                    .addComponent(cbEstudiantesRegistro)
                    .addComponent(cbUsuariosRegistro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbPadresModificar)
                    .addComponent(cbEstudiantesModificar)
                    .addComponent(cbUsuariosModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbPadresBorrar)
                    .addComponent(cbEstudiantesConsultar)
                    .addComponent(cbUsuariosBorrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbPagos)
                    .addComponent(cbReportes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbAbonos)
                    .addComponent(cbAjusteTanda)
                    .addComponent(cbAjustePerfil))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCrear.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Agregar 32 x 32.png"))); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        txtCrearPerfil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel2.setText("Crear Perfil:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Botones de Acciones...!", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Documento nuevo 32 x 32.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Salir 32 x 32.png"))); // NOI18N
        btnCancelar.setText("Salir");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Documento nuevo 32 x 32.png"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbPerfiles, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(txtCrearPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCrearPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbPerfiles, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCrear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnConsultar)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbPerfiles, txtCrearPerfil});

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

        rebobinar();
    }//GEN-LAST:event_formInternalFrameActivated
    private Integer Id_Perfil;
    private String Perfil;
    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        if (cmbPerfiles.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un Perfil");
            return;
        }
        Id_Perfil = null;
        Perfil = null;

        try {
//            rs = getPerfiles(cmbPerfiles.getSelectedItem().toString());
            while (rs.next()) {
                Id_Perfil = rs.getInt(1);
                Perfil = rs.getString(2);

                cbPadres.setSelected(rs.getBoolean(3));
                cbPadresRegistro.setSelected(rs.getBoolean(4));
                cbPadresModificar.setSelected(rs.getBoolean(5));
                cbPadresBorrar.setSelected(rs.getBoolean(6));

                cbEstudiantes.setSelected(rs.getBoolean(7));
                cbEstudiantesRegistro.setSelected(rs.getBoolean(8));
                cbEstudiantesModificar.setSelected(rs.getBoolean(9));
                cbEstudiantesConsultar.setSelected(rs.getBoolean(10));

                cbUsuarios.setSelected(rs.getBoolean(11));
                cbUsuariosRegistro.setSelected(rs.getBoolean(12));
                cbUsuariosModificar.setSelected(rs.getBoolean(13));
                cbUsuariosBorrar.setSelected(rs.getBoolean(14));

                cbPagos.setSelected(rs.getBoolean(15));
                cbAbonos.setSelected(rs.getBoolean(16));
                cbReportes.setSelected(rs.getBoolean(17));

                cbAjusteTanda.setSelected(rs.getBoolean(18));
                cbAjustePerfil.setSelected(rs.getBoolean(19));
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }//GEN-LAST:event_btnConsultarActionPerformed
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

//        Perfiles perfil = new Perfiles(
//                Id_Perfil, 
//                cmbPerfiles.getSelectedItem().toString(),
//                cbPadres.isSelected(), 
//                cbPadresRegistro.isSelected(),
//                cbPadresModificar.isSelected(), 
//                cbPadresBorrar.isSelected(),
//                cbEstudiantes.isSelected(), 
//                cbEstudiantesRegistro.isSelected(),
//                cbEstudiantesModificar.isSelected(), 
//                cbEstudiantesConsultar.isSelected(),
//                cbUsuarios.isSelected(), 
//                cbUsuariosRegistro.isSelected(),
//                cbUsuariosModificar.isSelected(), 
//                cbUsuariosBorrar.isSelected(),
//                cbPagos.isSelected(), 
//                cbAbonos.isSelected(),
//                cbReportes.isSelected(), 
//                cbAjusteTanda.isSelected(), 
//                cbAjustePerfil.isSelected());

//        JOptionPane.showMessageDialog(this, modificarPerfil(perfil));
        rebobinar();
    }//GEN-LAST:event_btnGuardarActionPerformed
    private void cerrar() {
        VistaPrincipal miPrincipal = new VistaPrincipal();
        miPrincipal.dpnEscritorio.getDesktopManager().closeFrame(this);
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cerrar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        //JOptionPane.showMessageDialog(this, borrarPerfil(cmbPerfiles.getSelectedItem().toString()));
        rebobinar();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        //JOptionPane.showMessageDialog(this, agregarPerfil(txtCrearPerfil.getText()));
        rebobinar();
    }//GEN-LAST:event_btnCrearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox cbAbonos;
    private javax.swing.JCheckBox cbAjustePerfil;
    private javax.swing.JCheckBox cbAjusteTanda;
    private javax.swing.JCheckBox cbEstudiantes;
    private javax.swing.JCheckBox cbEstudiantesConsultar;
    private javax.swing.JCheckBox cbEstudiantesModificar;
    private javax.swing.JCheckBox cbEstudiantesRegistro;
    private javax.swing.JCheckBox cbPadres;
    private javax.swing.JCheckBox cbPadresBorrar;
    private javax.swing.JCheckBox cbPadresModificar;
    private javax.swing.JCheckBox cbPadresRegistro;
    private javax.swing.JCheckBox cbPagos;
    private javax.swing.JCheckBox cbReportes;
    private javax.swing.JCheckBox cbUsuarios;
    private javax.swing.JCheckBox cbUsuariosBorrar;
    private javax.swing.JCheckBox cbUsuariosModificar;
    private javax.swing.JCheckBox cbUsuariosRegistro;
    private javax.swing.JComboBox cmbPerfiles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtCrearPerfil;
    // End of variables declaration//GEN-END:variables
}
