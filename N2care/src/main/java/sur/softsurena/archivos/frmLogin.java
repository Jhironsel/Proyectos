package sur.softsurena.archivos;

import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.formularios.frmPrincipal;
import sur.softsurena.metodos.Imagenes;
import sur.softsurena.utilidades.AnimationClass;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class frmLogin extends javax.swing.JFrame {

    private SwingWorker swinWorker;

    public frmLogin() {
        initComponents();
        btnMostrarLoginMouseClicked(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpLogin = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        btnMostrarLogin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema de pedíatria n2care");
        setBackground(new java.awt.Color(0, 153, 255));
        setMinimumSize(new java.awt.Dimension(670, 367));
        setUndecorated(true);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpLogin.setBackground(new java.awt.Color(255, 255, 255));
        jpLogin.setOpaque(false);
        jpLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setBackground(new java.awt.Color(0, 153, 255));
        btnCancelar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setAutoscrolls(true);
        btnCancelar.setPreferredSize(new java.awt.Dimension(70, 70));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jpLogin.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 120, 43));

        btnAceptar.setBackground(new java.awt.Color(0, 153, 255));
        btnAceptar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setAutoscrolls(true);
        btnAceptar.setPreferredSize(new java.awt.Dimension(70, 70));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jpLogin.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 120, 43));

        txtUsuario.setEditable(false);
        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtUsuario.setToolTipText("");
        txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 5));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jpLogin.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 260, 30));

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jpLogin.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 260, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Clave: ");
        jpLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, -1));

        txtClave.setEditable(false);
        txtClave.setToolTipText("");
        txtClave.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 5));
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        jpLogin.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 260, 30));

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jpLogin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 260, 10));

        btnMostrarLogin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnMostrarLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Flecha Derecha 32 x 32.png"))); // NOI18N
        btnMostrarLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMostrarLoginMouseClicked(evt);
            }
        });
        jpLogin.add(btnMostrarLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 40, 190));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Usuario: ");
        jpLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 120, -1));

        getContentPane().add(jpLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(-380, 20, 430, 190));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setIcon(new Imagenes("/sur/softsurena/imagenes/Fondo 800 x 600.jpg").getIcono());
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-130, -200, 800, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (Conexion.getCnn() != null) {
            try {
                Conexion.getCnn().close();
            } catch (SQLException ex) {
                LOG.getLogger(
                        frmLogin.class.getName()
                ).log(Level.SEVERE, "Error al cerrar la conexion.", ex);
            }
        }

        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnMostrarLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarLoginMouseClicked
        if (jpLogin.getX() == -380) {//Rev. 02-08-2018
            AnimationClass.jPanelMove("Right", -380, 0, 100, 20, jpLogin);
            btnMostrarLogin.setIcon(new javax.swing.ImageIcon(
                    getClass().getResource(
                            "/imagenes/Flecha Izquierda 32 x 32.png")));
            txtUsuario.setEditable(true);
            txtClave.setEditable(true);
        } else {
            AnimationClass.jPanelMove("Left", 0, -380, 100, 20, jpLogin);
            btnMostrarLogin.setIcon(new javax.swing.ImageIcon(
                    getClass().getResource(
                            "/imagenes/Flecha Derecha 32 x 32.png")));
            txtUsuario.setEditable(false);
            txtClave.setEditable(false);
        }
        txtUsuario.requestFocus();
    }//GEN-LAST:event_btnMostrarLoginMouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        swinWorker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                /*Empezamos validando los dos campos si estan vacios*/
                if (txtUsuario.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Inserte un Usuario");
                    txtUsuario.requestFocus();
                    swinWorker = null;
                    return null;
                }
                if (txtClave.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(null, "Inserte una clave");
                    txtClave.requestFocus();
                    swinWorker = null;
                    return null;
                }

                Conexion.getInstance(
                        txtUsuario.getText(),
                        new String(txtClave.getPassword()),
                        "SoftSurena.db",
                        "localhost",
                        "3050"
                );
                
                if (Conexion.getCnn() != null) {
                    txtClave.setText("");
                    new frmPrincipal().setExtendedState(JFrame.MAXIMIZED_BOTH);
                    dispose();
                } else {

                    JOptionPane.showMessageDialog(null,
                            "Contraseña incorrecta o no hay conectividad",
                            "Validacion de proceso",
                            JOptionPane.PLAIN_MESSAGE);

                    if (!txtUsuario.getText().equals("sysdba")) {
                        txtUsuario.setText("");
                    }

                    txtClave.setText("");

                    swinWorker = null;
                }
                return swinWorker;
            }
        };
        swinWorker.execute();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        btnAceptarActionPerformed(null);
    }//GEN-LAST:event_txtClaveActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        txtClave.requestFocus();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    public static void main(String[] args) {
        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException
                | ClassNotFoundException
                | InstantiationException
                | IllegalAccessException e) {
            //Instalar Logger
        }

        frmLogin miUsuario = new frmLogin();//Rev. 02-08-2018
        miUsuario.setVisible(true);
        miUsuario.setLocationRelativeTo(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel btnMostrarLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel jpLogin;
    private javax.swing.JPasswordField txtClave;
    public static javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
