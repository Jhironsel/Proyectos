package sur.softsurena.vistas;

import RSMaterialComponent.RSButtonMaterialIconOne;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.conexion.VistaParametros;
import sur.softsurena.metodos.Imagenes;
import sur.softsurena.utilidades.Utilidades;

public final class VistaLoginFacturacion extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    private boolean txtUsuarioKeyPress = true;

    private static ResourceBundle bundle = null;

    private static String sistema;

    public RSButtonMaterialIconOne getBtnAceptar() {
        return btnAceptar;
    }

    public JPasswordField getTxtClave() {
        return txtPassword;
    }

    public JTextField getTxtUsuario() {
        return txtUser;
    }

    public VistaLoginFacturacion(String language) {
        bundle = ResourceBundle.getBundle(
                "sur.softsurena.idioma.mensaje",
                Locale.forLanguageTag(language)
        );
        initComponents();
        cargarIconos();
        btnParametros.setVisible(false);//Boton parametros Invisible
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lamina = new RSMaterialComponent.RSPanelMaterialImage();
        JLSystema = new javax.swing.JLabel();
        jlLogoSistema = new javax.swing.JLabel();
        jpDatos = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelIcon1 = new necesario.LabelIcon();
        txtUser = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        labelIcon2 = new necesario.LabelIcon();
        txtPassword = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnAceptar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnParametros = new RSMaterialComponent.RSButtonMaterialIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(bundle.getString("frmLogin.jlTitle"));
        setFocusTraversalPolicyProvider(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JLSystema.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        JLSystema.setForeground(new java.awt.Color(255, 255, 255));
        JLSystema.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jlLogoSistema.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlLogoSistema.setForeground(new java.awt.Color(1, 1, 1));
        jlLogoSistema.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlLogoSistema.setMaximumSize(new java.awt.Dimension(128, 128));
        jlLogoSistema.setMinimumSize(new java.awt.Dimension(128, 128));
        jlLogoSistema.setPreferredSize(new java.awt.Dimension(128, 128));

        jpDatos.setBackground(new java.awt.Color(255, 153, 255));
        jpDatos.setOpaque(false);
        jpDatos.setLayout(new java.awt.GridLayout(4, 1, 5, 5));

        labelIcon1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelIcon1.setOpaque(true);

        txtUser.setFont(new java.awt.Font("FreeMono", 1, 24)); // NOI18N
        txtUser.setForeground(new java.awt.Color(51, 51, 255));
        txtUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtUser.setName("txtUser"); // NOI18N
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(labelIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUser)))
        );

        jpDatos.add(jPanel2);

        labelIcon2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelIcon2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LOCK);
        labelIcon2.setOpaque(true);

        txtPassword.setFont(new java.awt.Font("FreeMono", 1, 24)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(51, 51, 255));
        txtPassword.setName("txtPassword"); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(labelIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelIcon2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtPassword)
        );

        jpDatos.add(jPanel3);

        jPanel1.setMaximumSize(new java.awt.Dimension(216, 40));
        jPanel1.setMinimumSize(new java.awt.Dimension(216, 40));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        btnCancelar.setBackground(new java.awt.Color(204, 0, 51));
        btnCancelar.setText(bundle.getString("frmLogin.btnCancelar"));
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setIconTextGap(0);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setMaximumSize(new java.awt.Dimension(216, 40));
        btnCancelar.setMinimumSize(new java.awt.Dimension(216, 40));
        btnCancelar.setName("btnCancelar"); // NOI18N
        btnCancelar.setPreferredSize(new java.awt.Dimension(216, 40));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);

        btnAceptar.setText(bundle.getString("frmLogin.btnInicio"));
        btnAceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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

        jpDatos.add(jPanel1);

        btnParametros.setBackground(new java.awt.Color(0, 204, 51));
        btnParametros.setText(bundle.getString("frmLogin.btnOpcionPanel"));
        btnParametros.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DASHBOARD);
        btnParametros.setMaximumSize(new java.awt.Dimension(216, 40));
        btnParametros.setMinimumSize(new java.awt.Dimension(216, 40));
        btnParametros.setName("btnParametros"); // NOI18N
        btnParametros.setPreferredSize(new java.awt.Dimension(216, 40));
        btnParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParametrosActionPerformed(evt);
            }
        });
        jpDatos.add(btnParametros);

        javax.swing.GroupLayout laminaLayout = new javax.swing.GroupLayout(lamina);
        lamina.setLayout(laminaLayout);
        laminaLayout.setHorizontalGroup(
            laminaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laminaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(laminaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLSystema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlLogoSistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        laminaLayout.setVerticalGroup(
            laminaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laminaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLSystema, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlLogoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lamina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lamina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        btnCancelarActionPerformed(null);
    }//GEN-LAST:event_formWindowClosing

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (!Conexion.validarUsuario(txtUser, txtPassword, this)) {
            return;
        }
        new FirebirdEventos(
                txtUser.getText(),
                new String(txtPassword.getPassword())
        );

        VistaPrincipalFacturacion principal = new VistaPrincipalFacturacion();
        principal.setVisible(true);
        principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        principal.requestFocusInWindow(FocusEvent.Cause.ROLLBACK);

        txtPassword.setText("");
        txtUser.setText("");
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Utilidades.limpiarDiretorio("Logs/");
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParametrosActionPerformed
        VistaParametros miParametros = new VistaParametros();
        miParametros.setLocationRelativeTo(null);
        miParametros.setVisible(true);
    }//GEN-LAST:event_btnParametrosActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        txtPassword.requestFocus();
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL) {
            txtUsuarioKeyPress = true;
        } else if (txtUsuarioKeyPress && evt.getKeyCode() == KeyEvent.VK_DOWN) {
            if (btnParametros.isVisible()) {
                btnParametros.setVisible(false);
            } else {
                btnParametros.setVisible(true);
            }
            txtUsuarioKeyPress = false;
        }//Habilitar y Deshabilitar el boton del Parametros en el formulario Login
    }//GEN-LAST:event_txtUserKeyPressed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        btnAceptarActionPerformed(null);
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        JLSystema.setText("Usted se encuentra en el SO: " + sistema);
    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {
        Utilidades.beep();
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info
//                    : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("GTK+".equals(info.getName())) {
//                    //GTK+, Nimbus, Metal, CDE/Motif
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException
//                | InstantiationException
//                | IllegalAccessException
//                | javax.swing.UnsupportedLookAndFeelException ex) {
//            LOG.log(Level.SEVERE, "Error al iniciar el main", ex);
//        }

//        FlatLaf.registerCustomDefaultsSource( "sur.softsurena.themes" );
//        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            VistaLoginFacturacion frmLogin = new VistaLoginFacturacion("es");
            frmLogin.setVisible(true);
            frmLogin.setLocationRelativeTo(null);
        }
        );
        sistema = System.getProperty("os.name").strip();
    }

    private void cargarIconos() {
        jlLogoSistema.setIcon(new Imagenes("Panel de Control 128 x 128.png").getIcono());
        lamina.setImagen(new Imagenes("FondoLogin 626 x 386.jpg").getIcono());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel JLSystema;
    private static RSMaterialComponent.RSButtonMaterialIconOne btnAceptar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnParametros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jlLogoSistema;
    private javax.swing.JPanel jpDatos;
    private necesario.LabelIcon labelIcon1;
    private necesario.LabelIcon labelIcon2;
    private RSMaterialComponent.RSPanelMaterialImage lamina;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
