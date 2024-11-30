package sur.softsurena.formularios;

import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sur.softsurena.conexion.Conexion;
import static sur.softsurena.metodos.M_BaseDeDatos.GET_GUID;
import static sur.softsurena.metodos.M_BaseDeDatos.setLicencia;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class frmRegistros extends javax.swing.JDialog {

    public frmRegistros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        frmParametros p = new frmParametros();
        String dominio = "localhost", puerto = "3050";

        if (p.cargarParamentos("").getConIpServidor()) {
            dominio = p.cargarParamentos("").getIpServidor1() + "."
                    + p.cargarParamentos("").getIpServidor2() + "."
                    + p.cargarParamentos("").getIpServidor3() + "."
                    + p.cargarParamentos("").getIpServidor4();
        }

        if (p.cargarParamentos("").getConServidor()) {
            dominio = p.cargarParamentos("").getUriServidor();
        }

        if (p.cargarParamentos("").getConPuerto()) {
            puerto = p.cargarParamentos("").getPuerto();
        }
        Conexion.getInstance(
                "GET_GUID",
                "1",
                p.cargarParamentos("").getPathBaseDatos(),
                dominio,
                puerto);

        Conexion.verificar();

        txtIdMaquina.setText(GET_GUID());
        try {
            Conexion.getCnn().close();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error al cerrar conexion.", ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdMaquina = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        dchFecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar1 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnAceptar = new RSMaterialComponent.RSButtonMaterialIconOne();
        txtUsuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registros del sistema en PC");

        jLabel2.setText("Identificador de la Maquina:");

        txtIdMaquina.setEditable(false);

        jLabel3.setText("Clave: ");

        dchFecha.setForeground(new java.awt.Color(1, 1, 1));
        dchFecha.setAutoscrolls(true);
        dchFecha.setDateFormatString("dd.MM.yyyy");
        dchFecha.setFocusTraversalPolicyProvider(true);
        dchFecha.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        dchFecha.setMinimumSize(new java.awt.Dimension(0, 0));
        dchFecha.setPreferredSize(new java.awt.Dimension(0, 25));
        dchFecha.setVerifyInputWhenFocusTarget(false);

        jLabel5.setText("Fecha de Expiración: ");

        btnCancelar1.setBackground(new java.awt.Color(204, 0, 51));
        btnCancelar1.setText("Cancelar");
        btnCancelar1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar1.setMaximumSize(new java.awt.Dimension(216, 40));
        btnCancelar1.setMinimumSize(new java.awt.Dimension(216, 40));
        btnCancelar1.setPreferredSize(new java.awt.Dimension(216, 40));
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnAceptar.setMaximumSize(new java.awt.Dimension(216, 40));
        btnAceptar.setMinimumSize(new java.awt.Dimension(216, 40));
        btnAceptar.setPreferredSize(new java.awt.Dimension(216, 40));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel7.setText("Usuario: ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Obtenen usuario de registro...");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtIdMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtClave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dchFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel7, txtClave});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dchFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel5, jLabel7});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dchFecha, txtClave, txtUsuario});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        txtIdMaquina.setText("cancelado");
        dispose();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (txtIdMaquina.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Codigo de la Maquina vacio, Rellenar...!!!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtIdMaquina.requestFocus();
            return;
        }
        if (txtClave.getPassword().length == 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Clave 1 vacia, Rellenar...!!!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtClave.requestFocus();
            return;
        }

        if (dchFecha.getDate() == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "fecha vacia, Rellenar...!!!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            dchFecha.requestFocus();
            return;
        }

        //----------------------------------------------------------------------
        // TODO Obtener un dominio para la base de datos de registros.
        String dominio = "localhost", puerto = "3050";

        Conexion.getInstance(
                txtUsuario.getText(),
                new String(txtClave.getPassword()),
                "registros.db",
                dominio,
                puerto);

        if (Conexion.verificar().getEstado()) {
            if (setLicencia(
                    new Date(dchFecha.getDate().getTime()),
                    txtIdMaquina.getText().trim()
            )) {
                JOptionPane.showMessageDialog(
                        this,
                        "Maquina Registradas",
                        "",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        }

        try {
            Conexion.getCnn().close();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error al cerrar conexion.", ex);
        }

        this.setVisible(false);
    }//GEN-LAST:event_btnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAceptar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar1;
    public com.toedter.calendar.JDateChooser dchFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JPasswordField txtClave;
    public javax.swing.JTextField txtIdMaquina;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
