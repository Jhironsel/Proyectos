package sur.softsurena.formularios;

public class frmDiasConsultas extends javax.swing.JDialog {
    
    public frmDiasConsultas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbLunes = new javax.swing.JCheckBox();
        cbMartes = new javax.swing.JCheckBox();
        cbMiercoles = new javax.swing.JCheckBox();
        cbJueves = new javax.swing.JCheckBox();
        cbViernes = new javax.swing.JCheckBox();
        cbSabados = new javax.swing.JCheckBox();
        cbDomingos = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cbLunes.setText("Lunes");
        cbLunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLunesActionPerformed(evt);
            }
        });

        cbMartes.setText("Martes");
        cbMartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMartesActionPerformed(evt);
            }
        });

        cbMiercoles.setText("Miercoles");
        cbMiercoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMiercolesActionPerformed(evt);
            }
        });

        cbJueves.setText("Jueves");
        cbJueves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJuevesActionPerformed(evt);
            }
        });

        cbViernes.setText("Viernes");
        cbViernes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbViernesActionPerformed(evt);
            }
        });

        cbSabados.setText("Sabados");
        cbSabados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSabadosActionPerformed(evt);
            }
        });

        cbDomingos.setText("Domingos");
        cbDomingos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDomingosActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(195, 226, 252));
        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("Seleccione los dias laborables");
        jLabel1.setOpaque(true);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbLunes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMartes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMiercoles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbJueves)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbViernes))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbSabados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbDomingos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbLunes)
                    .addComponent(cbMartes)
                    .addComponent(cbMiercoles)
                    .addComponent(cbJueves)
                    .addComponent(cbViernes))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbSabados)
                        .addComponent(cbDomingos))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAceptar)
                            .addComponent(btnCancelar))
                        .addGap(0, 0, 0))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbLunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLunesActionPerformed
        if (cbLunes.isSelected()) {
            frmHora hora = new frmHora(null, true);
            hora.setLocationRelativeTo(null);
            hora.setVisible(true);
            cbLunes.setSelected(hora.aceptar);
        } else {
        }
        
    }//GEN-LAST:event_cbLunesActionPerformed

    private void cbMartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMartesActionPerformed
        if (cbMartes.isSelected()) {
            frmHora hora = new frmHora(null, true);
            hora.setLocationRelativeTo(null);
            hora.setVisible(true);
        } else {
        }
        
    }//GEN-LAST:event_cbMartesActionPerformed

    private void cbMiercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMiercolesActionPerformed
        if (cbMiercoles.isSelected()) {
            frmHora hora = new frmHora(null, true);
            hora.setLocationRelativeTo(null);
            hora.setVisible(true);
        } else {
        }
        
    }//GEN-LAST:event_cbMiercolesActionPerformed

    private void cbJuevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJuevesActionPerformed
        if (cbJueves.isSelected()) {
            frmHora hora = new frmHora(null, true);
            hora.setLocationRelativeTo(null);
            hora.setVisible(true);
        } else {
        }
        
    }//GEN-LAST:event_cbJuevesActionPerformed

    private void cbViernesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbViernesActionPerformed
        if (cbViernes.isSelected()) {
            frmHora hora = new frmHora(null, true);
            hora.setLocationRelativeTo(null);
            hora.setVisible(true);
        } else {
        }
        
    }//GEN-LAST:event_cbViernesActionPerformed

    private void cbSabadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSabadosActionPerformed
        if (cbSabados.isSelected()) {
            frmHora hora = new frmHora(null, true);
            hora.setLocationRelativeTo(null);
            hora.setVisible(true);
        } else {
        }
        
    }//GEN-LAST:event_cbSabadosActionPerformed

    private void cbDomingosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDomingosActionPerformed
        if (cbDomingos.isSelected()) {
            frmHora hora = new frmHora(null, true);
            hora.setLocationRelativeTo(null);
            hora.setVisible(true);
        } else {
        }
        
    }//GEN-LAST:event_cbDomingosActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
       
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JCheckBox cbDomingos;
    private javax.swing.JCheckBox cbJueves;
    private javax.swing.JCheckBox cbLunes;
    private javax.swing.JCheckBox cbMartes;
    private javax.swing.JCheckBox cbMiercoles;
    private javax.swing.JCheckBox cbSabados;
    private javax.swing.JCheckBox cbViernes;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
