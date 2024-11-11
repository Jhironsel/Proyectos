package sur.softsurena.formularios;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sur.softsurena.utilidades.FechaHora;

public class frmDatosNacimiento extends javax.swing.JDialog {

    public frmDatosNacimiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JFormattedTextField();
        cbCesarea = new javax.swing.JCheckBox();
        dchFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtPesoNacer = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEstaturaNacer = new javax.swing.JFormattedTextField();
        jlResultado = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPC = new javax.swing.JFormattedTextField();
        txtTiempoGestacion = new javax.swing.JSpinner();

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

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Cedula: ");

        txtCedula.setEditable(false);
        txtCedula.setForeground(new java.awt.Color(1, 1, 1));
        try {
            txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N

        cbCesarea.setForeground(new java.awt.Color(1, 1, 1));
        cbCesarea.setText("Cesarea");

        dchFechaNacimiento.setForeground(new java.awt.Color(1, 1, 1));
        dchFechaNacimiento.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Fecha de Nacimiento");

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

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Peso Kg");

        txtPesoNacer.setForeground(new java.awt.Color(1, 1, 1));
        txtPesoNacer.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("Talla Cm");

        txtEstaturaNacer.setForeground(new java.awt.Color(1, 1, 1));
        txtEstaturaNacer.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jlResultado.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jlResultado.setForeground(new java.awt.Color(1, 1, 1));
        jlResultado.setText("MC");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 1, 1));
        jLabel8.setText("Tiempo Gestacion");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("PC");

        txtPC.setForeground(new java.awt.Color(1, 1, 1));
        txtPC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        txtTiempoGestacion.setModel(new javax.swing.SpinnerNumberModel(4.0d, 3.0d, 12.0d, 1.0d));
        txtTiempoGestacion.setToolTipText("Tiempo de gestacion del infante al nacer.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, 0)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dchFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTiempoGestacion, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCesarea, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnCancelar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jlResultado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(txtPesoNacer, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEstaturaNacer, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPC, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))))
                    .addComponent(jLabel8)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtEstaturaNacer, txtPesoNacer});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dchFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)
                        .addComponent(txtPesoNacer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, 0)
                        .addComponent(txtEstaturaNacer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(txtPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlResultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCesarea)
                    .addComponent(txtTiempoGestacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelar, btnGuardar});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtEstaturaNacer, txtPesoNacer});

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
        JOptionPane.showMessageDialog(
                this,
                agregarDatosNacimiento(
                        new DatosNacimiento(
                                ((Categorias) txtCedula.getValue()).getId(), 
                                f.getFecha(),
                                txtPesoNacer.getValue().toString(),
                                txtEstaturaNacer.getValue().toString(),
                                cbCesarea.isSelected(),
                                txtTiempoGestacion.getValue().toString(),
                                txtPC.getValue().toString()
                        )
                ),
                "Resultados de la operacion",
                JOptionPane.DEFAULT_OPTION);
        dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ResultSet d = getDatosNacimiento(
                ((Categorias) txtCedula.getValue()).getId()
        );

        dchFechaNacimiento.setDate(d.getDate("FECHANACIMIENTO"));
        txtPesoNacer.setValue(d.getObject("PESONACIMIENTOKG"));
        txtEstaturaNacer.setValue(d.getDouble("ALTURA") * 100);
        jlResultado.setText("IMC: " + d.getString("MC"));
        txtTiempoGestacion.setValue(d.getDouble("TIEMPOGESTACION"));
        cbCesarea.setSelected(d.getBoolean("CESAREA"));
        txtPC.setValue(d.getObject("PC"));
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox cbCesarea;
    private com.toedter.calendar.JDateChooser dchFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jlResultado;
    public javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JFormattedTextField txtEstaturaNacer;
    private javax.swing.JFormattedTextField txtPC;
    private javax.swing.JFormattedTextField txtPesoNacer;
    private javax.swing.JSpinner txtTiempoGestacion;
    // End of variables declaration//GEN-END:variables
}
