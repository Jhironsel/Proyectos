package sur.softsurena.control;

import java.sql.Time;
import sur.softsurena.entidades.ControlConsulta;
import sur.softsurena.metodos.M_ControlConsulta;

public class frmDiasConsultas extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;

    protected String idUsuario;

    public frmDiasConsultas(java.awt.Frame parent, boolean modal,
            String idUsuario) {
        super(parent, modal);
        this.idUsuario = idUsuario;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnLunes = new javax.swing.JButton();
        btnMartes = new javax.swing.JButton();
        btnMiercoles = new javax.swing.JButton();
        btnJueves = new javax.swing.JButton();
        btnViernes = new javax.swing.JButton();
        btnSabados = new javax.swing.JButton();
        btnDomingos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        btnLunes.setText("Agrega lunes");
        btnLunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLunesActionPerformed(evt);
            }
        });

        btnMartes.setText("Agrega martes");
        btnMartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMartesActionPerformed(evt);
            }
        });

        btnMiercoles.setText("Agrega miercoles");
        btnMiercoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiercolesActionPerformed(evt);
            }
        });

        btnJueves.setText("Agrega jueves");
        btnJueves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJuevesActionPerformed(evt);
            }
        });

        btnViernes.setText("Agrega viernes");
        btnViernes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViernesActionPerformed(evt);
            }
        });

        btnSabados.setText("Agrega sabados");
        btnSabados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSabadosActionPerformed(evt);
            }
        });

        btnDomingos.setText("Agrega domingos");
        btnDomingos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDomingosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnDomingos)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnLunes)
                                .addComponent(btnJueves))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnMartes)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnMiercoles))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnViernes)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSabados))))))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDomingos, btnJueves, btnLunes, btnMartes, btnMiercoles, btnSabados, btnViernes});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLunes)
                    .addComponent(btnMartes)
                    .addComponent(btnMiercoles))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJueves)
                    .addComponent(btnViernes)
                    .addComponent(btnSabados))
                .addGap(0, 0, 0)
                .addComponent(btnDomingos)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(0, 0, 0))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDomingos, btnJueves, btnLunes, btnMartes, btnMiercoles, btnSabados, btnViernes});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnLunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLunesActionPerformed
        diasConsultas("Lu");
    }//GEN-LAST:event_btnLunesActionPerformed

    private void btnMartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMartesActionPerformed
        diasConsultas("Ma");
    }//GEN-LAST:event_btnMartesActionPerformed

    private void btnMiercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiercolesActionPerformed
        diasConsultas("Mi");
    }//GEN-LAST:event_btnMiercolesActionPerformed

    private void btnJuevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJuevesActionPerformed
        diasConsultas("Ju");
    }//GEN-LAST:event_btnJuevesActionPerformed

    private void btnViernesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViernesActionPerformed
        diasConsultas("Vi");
    }//GEN-LAST:event_btnViernesActionPerformed

    private void btnSabadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSabadosActionPerformed
        diasConsultas("Sa");
    }//GEN-LAST:event_btnSabadosActionPerformed

    private void btnDomingosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDomingosActionPerformed
        diasConsultas("Do");
    }//GEN-LAST:event_btnDomingosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnDomingos;
    private javax.swing.JButton btnJueves;
    private javax.swing.JButton btnLunes;
    private javax.swing.JButton btnMartes;
    private javax.swing.JButton btnMiercoles;
    private javax.swing.JButton btnSabados;
    private javax.swing.JButton btnViernes;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void diasConsultas(String dia) {
        
        frmHora hora = new frmHora(this, true);
        hora.setLocationRelativeTo(null);
        hora.setVisible(true);
        
        if (frmHora.aceptar) {
            M_ControlConsulta.insert(
                    ControlConsulta
                            .builder()
                            .build()
            );
            
            
//new ControlConsulta(
//                            -1,
//                            idUsuario,
//                            Integer.parseInt(frmHora.jsCantPaciente.getValue().toString()),
//                            dia,
//                            new Time(frmHora.jInicio.getDateWithTime(null).getTime()),
//                            new Time(frmHora.jFinal.getDateWithTime(null).getTime()),
//                            true
//                    )
            frmHorario.llenarTabla();
        }
    }
}
