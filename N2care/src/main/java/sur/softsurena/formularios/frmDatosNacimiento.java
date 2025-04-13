package sur.softsurena.formularios;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import sur.softsurena.utilidades.FechaHora;

public class frmDatosNacimiento extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;

    public frmDatosNacimiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCedula = new javax.swing.JFormattedTextField();
        dchFechaNacimiento = new com.toedter.calendar.JDateChooser();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtPesoNacer = new javax.swing.JFormattedTextField();
        txtEstaturaNacer = new javax.swing.JFormattedTextField();
        txtPC = new javax.swing.JFormattedTextField();
        txtTiempoGestacion = new javax.swing.JSpinner();
        cbCesarea = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Datos de nacimientos del paciente");
        setAlwaysOnTop(true);
        setModal(true);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtCedula.setEditable(false);
        txtCedula.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Cedula"));
        txtCedula.setForeground(new java.awt.Color(1, 1, 1));
        try {
            txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N

        dchFechaNacimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Fecha Nacimiento"));
        dchFechaNacimiento.setForeground(new java.awt.Color(1, 1, 1));
        dchFechaNacimiento.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(1, 1, 1));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Guardar 32 x 32.png"))); // NOI18N
        btnGuardar.setMnemonic('g');
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Guardar Registro Actual");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(1, 1, 1));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setMnemonic('c');
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancela la Operacion del Registro");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtPesoNacer.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Peso Kilogramos"));
        txtPesoNacer.setForeground(new java.awt.Color(1, 1, 1));
        txtPesoNacer.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        txtEstaturaNacer.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Talla CM"));
        txtEstaturaNacer.setForeground(new java.awt.Color(1, 1, 1));
        txtEstaturaNacer.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        txtPC.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Perimetro Cefalico"));
        txtPC.setForeground(new java.awt.Color(1, 1, 1));
        txtPC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        txtTiempoGestacion.setModel(new javax.swing.SpinnerNumberModel(4.0d, 3.0d, 12.0d, 1.0d));
        txtTiempoGestacion.setToolTipText("Tiempo de gestacion del infante al nacer.");
        txtTiempoGestacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Tiempo Gestación"));

        cbCesarea.setForeground(new java.awt.Color(0, 0, 255));
        cbCesarea.setText("Cesarea->");
        cbCesarea.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));
        cbCesarea.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCedula)
                    .addComponent(dchFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPesoNacer, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPC, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbCesarea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEstaturaNacer, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(txtTiempoGestacion))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dchFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesoNacer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstaturaNacer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPC)
                    .addComponent(txtTiempoGestacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCesarea, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelar, btnGuardar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Hacer algunas validaciones en base a los datos obtenidos
        if (dchFechaNacimiento.getDate() == null) {
            JOptionPane.showInternalConfirmDialog(this,
                    "Fecha vacia, debe insertar la fecha nacimiento");
            return;
        }

        FechaHora f = new FechaHora(dchFechaNacimiento.getDate());
//        JOptionPane.showMessageDialog(
//                this,
//                agregarDatosNacimiento(
//                        new DatosNacimiento(
//                                ((Categorias) txtCedula.getValue()).getId(), 
//                                f.getFecha(),
//                                txtPesoNacer.getValue().toString(),
//                                txtEstaturaNacer.getValue().toString(),
//                                cbCesarea.isSelected(),
//                                txtTiempoGestacion.getValue().toString(),
//                                txtPC.getValue().toString()
//                        )
//                ),
//                "Resultados de la operacion",
//                JOptionPane.DEFAULT_OPTION
//        );
        dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        ResultSet d = getDatosNacimiento(
//                ((Categorias) txtCedula.getValue()).getId()
//        );
//
//        dchFechaNacimiento.setDate(d.getDate("FECHANACIMIENTO"));
//        txtPesoNacer.setValue(d.getObject("PESONACIMIENTOKG"));
//        txtEstaturaNacer.setValue(d.getDouble("ALTURA") * 100);
//        jlResultado.setText("IMC: " + d.getString("MC"));
//        txtTiempoGestacion.setValue(d.getDouble("TIEMPOGESTACION"));
//        cbCesarea.setSelected(d.getBoolean("CESAREA"));
//        txtPC.setValue(d.getObject("PC"));
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox cbCesarea;
    private com.toedter.calendar.JDateChooser dchFechaNacimiento;
    public javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JFormattedTextField txtEstaturaNacer;
    private javax.swing.JFormattedTextField txtPC;
    private javax.swing.JFormattedTextField txtPesoNacer;
    private javax.swing.JSpinner txtTiempoGestacion;
    // End of variables declaration//GEN-END:variables
}
