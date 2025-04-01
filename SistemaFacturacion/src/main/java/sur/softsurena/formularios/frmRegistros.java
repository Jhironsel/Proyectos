package sur.softsurena.formularios;

import java.awt.Frame;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sur.softsurena.conexion.Conexion;
import static sur.softsurena.metodos.M_BaseDeDatos.GET_GUID;
import static sur.softsurena.metodos.M_BaseDeDatos.setLicencia;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class frmRegistros extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;
    private static Frame parent;
    private static boolean modal;

    public static frmRegistros getInstance(Frame parent, boolean modal) {
        frmRegistros.parent = parent;
        frmRegistros.modal = modal;
        return NewSingletonHolder.INSTANCE;
    }

    private static class NewSingletonHolder {

        private static final frmRegistros INSTANCE = new frmRegistros(
                frmRegistros.parent,
                frmRegistros.modal
        );
    }

    private frmRegistros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ((JTextField) dchFecha.getDateEditor()).setBorder(
                javax.swing.BorderFactory.createTitledBorder(
                        javax.swing.BorderFactory.createMatteBorder(
                                0,
                                0,
                                1,
                                0,
                                new java.awt.Color(0, 0, 255)
                        ),
                        "Fecha expiración"
                )
        );
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIdMaquina = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        dchFecha = new com.toedter.calendar.JDateChooser();
        btnCancelar1 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnAceptar = new RSMaterialComponent.RSButtonMaterialIconOne();
        txtUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnObtenerId = new RSMaterialComponent.RSButtonMaterialIconOne();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtClaveRemoto = new javax.swing.JPasswordField();
        txtUsuarioRemoto = new javax.swing.JTextField();
        txtNombreEmpresa = new javax.swing.JTextField();
        txtTelefonoEmpresa = new javax.swing.JFormattedTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registros del sistema en PC");

        txtIdMaquina.setEditable(false);
        txtIdMaquina.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Identificador del sistema"));

        txtClave.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Clave"));

        dchFecha.setForeground(new java.awt.Color(1, 1, 1));
        dchFecha.setAutoscrolls(true);
        dchFecha.setDateFormatString("dd.MM.yyyy");
        dchFecha.setFocusTraversalPolicyProvider(true);
        dchFecha.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        dchFecha.setMinimumSize(new java.awt.Dimension(0, 0));
        dchFecha.setPreferredSize(new java.awt.Dimension(0, 25));
        dchFecha.setVerifyInputWhenFocusTarget(false);

        btnCancelar1.setBackground(new java.awt.Color(204, 0, 51));
        btnCancelar1.setText("  Cancelar");
        btnCancelar1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar1.setMaximumSize(new java.awt.Dimension(216, 40));
        btnCancelar1.setMinimumSize(new java.awt.Dimension(216, 40));
        btnCancelar1.setPreferredSize(new java.awt.Dimension(216, 40));
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        btnAceptar.setText("  Aceptar");
        btnAceptar.setEnabled(false);
        btnAceptar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnAceptar.setMaximumSize(new java.awt.Dimension(216, 40));
        btnAceptar.setMinimumSize(new java.awt.Dimension(216, 40));
        btnAceptar.setPreferredSize(new java.awt.Dimension(216, 40));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        txtUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Usuario"));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Obtenen usuario de registro...");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        btnObtenerId.setText("   Obtener ID");
        btnObtenerId.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.INFO);
        btnObtenerId.setMaximumSize(new java.awt.Dimension(216, 40));
        btnObtenerId.setMinimumSize(new java.awt.Dimension(216, 40));
        btnObtenerId.setPreferredSize(new java.awt.Dimension(216, 40));
        btnObtenerId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerIdActionPerformed(evt);
            }
        });

        jLabel2.setText("Ingrese el usuario local de la base de datos.");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));

        jLabel3.setText("Ingrese el usuario remoto pre-autorizado.");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));

        txtClaveRemoto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Clave"));

        txtUsuarioRemoto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Usuario"));

        txtNombreEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Nombre de empresa"));

        txtTelefonoEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Ingrese telefono empresa"));
        try {
            txtTelefonoEmpresa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+1(###) ###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtDireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Direccion de empresa"));

        jLabel5.setText("Ingrese los datos de la empresa.");
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtIdMaquina, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dchFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnObtenerId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefonoEmpresa))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUsuarioRemoto, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtClaveRemoto, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtClave, txtUsuario});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnObtenerId, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dchFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUsuarioRemoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtClaveRemoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                    "Codigo de la Maquina vacio, Obtenga el identificador...!!!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            btnObtenerId.requestFocus();
            return;
        }

        if (txtUsuarioRemoto.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese contraseña!!!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtUsuarioRemoto.requestFocus();
            return;
        }

        if (txtClaveRemoto.getPassword().length == 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese contraseña!!!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtClaveRemoto.requestFocus();
            return;
        }

        if (dchFecha.getDate() == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese la fecha!!!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            dchFecha.requestFocus();
            return;
        }

        //----------------------------------------------------------------------
        // TODO Obtener un dominio para la base de datos de registros.
        String dominio = "40.233.25.79", puerto = "3050";

        Conexion.getInstance(
                txtUsuarioRemoto.getText(),
                new String(txtClaveRemoto.getPassword()),
                "registros.db",
                dominio,
                puerto,
                "NONE"
        );

        if (!Conexion.verificar().getEstado()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error al conectarse al servidor de SoftSureña.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        Resultado resultado = setLicencia(
                new Date(
                        dchFecha.getDate().getTime()
                ),
                txtIdMaquina.getText().trim(),
                txtNombreEmpresa.getText(),
                txtTelefonoEmpresa.getValue().toString(),
                txtDireccion.getText()
        );
        
        JOptionPane.showMessageDialog(
                this,
                resultado.getMensaje(),
                "",
                resultado.getIcono()
        );

        try {
            Conexion.getCnn().close();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error al cerrar conexion.",
                    ex
            );
        }
        
        if(resultado.getEstado()){
            dispose();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        //Utilidades.abrirURL("https://wa.me/message/KGWBJYPYA3SNK1");
        Utilidades.abrirURL("https://wa.me/18292972015");
    }//GEN-LAST:event_jLabel4MouseClicked

    private void btnObtenerIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerIdActionPerformed
        frmParametros parametros = frmParametros.getInstance();

        Conexion.getInstance(
                txtUsuario.getText(),
                new String(txtClave.getPassword()),
                parametros.cargarParamentos().getPathBaseDatos(),
                parametros.cargarParamentos().getHost(),
                parametros.cargarParamentos().getPuerto(),
                "RRR_SOFTSURENA"
        );

        Resultado resultado = Conexion.verificar();

        if (!resultado.getEstado()) {
            JOptionPane.showMessageDialog(
                    this,
                    resultado.getMensaje(),
                    "",
                    resultado.getIcono()
            );
            return;
        }

        txtIdMaquina.setText(GET_GUID());

        btnAceptar.setEnabled(true);

        txtUsuario.setEnabled(false);
        txtClave.setEnabled(false);

        try {
            Conexion.getCnn().close();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error al cerrar conexion.",
                    ex
            );
        }

        Conexion.setInstanceNull();
    }//GEN-LAST:event_btnObtenerIdActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAceptar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar1;
    private RSMaterialComponent.RSButtonMaterialIconOne btnObtenerId;
    public com.toedter.calendar.JDateChooser dchFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JPasswordField txtClave;
    public javax.swing.JPasswordField txtClaveRemoto;
    private javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtIdMaquina;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JFormattedTextField txtTelefonoEmpresa;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtUsuarioRemoto;
    // End of variables declaration//GEN-END:variables
}
