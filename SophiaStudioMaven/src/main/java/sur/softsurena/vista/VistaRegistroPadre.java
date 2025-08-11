package sur.softsurena.vista;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import sur.softsurena.clases.PadreMadres;
import sur.softsurena.correoPack.Controlador;

public final class VistaRegistroPadre extends javax.swing.JInternalFrame {

    private void cerrar() {
        VistaPrincipal miPrincipal = new VistaPrincipal();
        miPrincipal.dpnEscritorio.getDesktopManager().closeFrame(this);
    }

    public VistaRegistroPadre() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtMovil = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jcbSexo = new javax.swing.JComboBox();
        jcbEstado = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lSugenrencia = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro de Padre [Sistema de Ballet]");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
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
                formInternalFrameOpened(evt);
            }
        });

        txtCedula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCedula.setToolTipText("");
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellidos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        txtDireccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtMovil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtMovil.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMovilFocusLost(evt);
            }
        });
        txtMovil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMovilKeyTyped(evt);
            }
        });

        txtCorreo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jcbSexo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "F", "M" }));
        jcbSexo.setSelectedIndex(-1);

        jcbEstado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "INACTIVO", "ACTIVO" }));
        jcbEstado.setSelectedIndex(-1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Botones del Formulario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap(273, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnGuardar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("*Cedula:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("*Nombre:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Apellidos:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("*Sexo:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Movil:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Telefono:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("*Direccion:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Estado:");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("*Sugerencias:");

        lSugenrencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lSugenrencia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Correo:");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Cedula Sin Guiones...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(lSugenrencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                    .addComponent(txtNombre)
                                    .addComponent(txtDireccion))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addGap(4, 4, 4)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6))
                            .addComponent(jLabel5))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lSugenrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cerrar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 48 && k <= 57 || k == 8) {
            lSugenrencia.setText("");
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugenrencia.setText("No puede ingresar letras!!!");
        }
        if (txtCedula.getText().length() == 11) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugenrencia.setText("Limite de Caracteres!!! \nCantidad permitida 11");
        }
    }//GEN-LAST:event_txtCedulaKeyTyped
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtCedula.getText().equals("")) {
            lSugenrencia.setText("Cedula en Blanco, Digite Numero de Cedula...!");
            txtCedula.requestFocus();
            return;
        }
        if (txtNombre.getText().equals("")) {
            lSugenrencia.setText("Digite el Nombre...!");
            txtNombre.requestFocus();
            return;
        }
        if (txtApellidos.getText().equals("")) {
            lSugenrencia.setText("Digite el Apellido...!");
            txtApellidos.requestFocus();
            return;
        }
        if (txtDireccion.getText().equals("")) {
            lSugenrencia.setText("Digite la Direccion");
            txtDireccion.requestFocus();
            return;
        }
        if (jcbSexo.getSelectedIndex() == -1) {
            lSugenrencia.setText("Selecione Tipo de Sexo del Padre...!");
            jcbSexo.requestFocus();
            return;
        }
        if (txtTelefono.getText().equals("")) {
            if (txtMovil.getText().equals("")) {
                lSugenrencia.setText("Debe Digitar por lo Menos un numero de Contacto...!");
                txtMovil.requestFocus();
                return;
            }
        }
        if (jcbEstado.getSelectedIndex() == -1) {
            lSugenrencia.setText("Selecione un Estado para Padre...!");
            jcbEstado.requestFocus();
            return;
        }
        PadreMadres miPadre = new PadreMadres(
                null, 
                txtCedula.getText(),
                txtNombre.getText(),
                txtApellidos.getText(),
                jcbSexo.getSelectedItem().toString(),
                txtTelefono.getText(),
                txtMovil.getText(),
                txtDireccion.getText(),
                jcbEstado.getSelectedIndex() + "",
                txtCorreo.getText(), 
                null
        );
        String dime1 = "";
        //dime1 = agregarPadreMadre(miPadre);

        if (dime1.equals("Padre no Agregado :( ...!")) {
            cerrar();
            return;
        }
        
        JOptionPane.showMessageDialog(this, dime1);

        if (!(txtCorreo.getText().equals(""))) {
            
            int dime = JOptionPane.showOptionDialog(this,
                    "Desea enviar correo al Padre o Madre del Alumno?", "Desea Enviar Correo?",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    frameIcon, new Object[]{"Si", "No"}, "Si");
            
            if (dime == 1) {
                cerrar();
            } else {
//                Correo c = new Correo();
//                c.setUsuarioCorreo("Jhironseld@gmail.com");
//                c.setContrasena("hqqqccgwcajgnile");
//                c.setAsunto("Usuario Registrado en el Sistema de SophiaEstudio");
//                c.setMensaje("Cedula del Padre: " + txtCedula.getText()
//                        + "\nNombre del Padre: " + txtNombre.getText()
//                        + "\nApellido: " + txtApellidos.getText()
//                        + "\nSexo: " + jcbSexo.getSelectedItem().toString()
//                        + "\nTelefeno: " + txtTelefono.getText()
//                        + "\nMovil: " + txtMovil.getText()
//                        + "\nDireccion: " + txtDireccion.getText()
//                        + "\nEstado: " + jcbEstado.getSelectedItem().toString());
//
//                c.setDestino(txtCorreo.getText());
//                c.setNombreArchivo("");
//                c.setRutaArchivo("");
                Controlador co = new Controlador();

                //if (co.enviarCorreo(c)) {
                if (co.enviarCorreo(null)) {
                    JOptionPane.showMessageDialog(
                            this, 
                            "Mensaje Enviado"
                    );
                } else {
                    JOptionPane.showMessageDialog(this, "Mensaje NO Enviado");
                }                
            }
        }
        
        cerrar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 65 && k <= 90 || k >= 97 && k <= 122 || k == 8 || k == 32) {
            lSugenrencia.setText("");
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugenrencia.setText("No puede ingresar Numeros!!!");
        }

    }//GEN-LAST:event_txtNombreKeyTyped
    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        if (txtNombre.getText().length() >= 25) {
            txtNombre.setToolTipText("Nombre muy largo...! Solo se Permite 25 Caracteres, Ultimos Caracteres " + txtNombre.getText().substring(20, 25));
            lSugenrencia.setText(txtNombre.getToolTipText());
            txtNombre.setText("");
        } else {
            txtCedula.setToolTipText("");
            lSugenrencia.setText(txtCedula.getToolTipText());
        }
    }//GEN-LAST:event_txtNombreFocusLost
    private void limpliarCampo() {
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        jcbSexo.setSelectedIndex(-1);
        txtTelefono.setText("");
        txtMovil.setText("");
        jcbEstado.setSelectedIndex(-1);
        txtCorreo.setText("");
    }
    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 65 && k <= 90 || k >= 97 && k <= 122 || k == 8 || k == 32) {
            lSugenrencia.setText("");
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugenrencia.setText("No puede ingresar Numeros!!!");
        }
    }//GEN-LAST:event_txtApellidosKeyTyped
    private void numero(java.awt.event.KeyEvent evt) {
        int k = (int) evt.getKeyChar();
        if (k >= 48 && k <= 57 || k == 8) {
            lSugenrencia.setText("");
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugenrencia.setText("No puede ingresar letras!!!");
        }
    }
    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        numero(evt);
        if (txtTelefono.getText().length() >= 11) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugenrencia.setText("Limite de Digitos, Solo 11 son permitido...");
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped
    private void txtMovilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMovilKeyTyped
        numero(evt);
        if (txtMovil.getText().length() >= 11) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugenrencia.setText("Limite de Digitos, Solo 11 son permitido...");
        }
    }//GEN-LAST:event_txtMovilKeyTyped
    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost
        if (txtTelefono.getText().length() < 11) {
            lSugenrencia.setText("Limite de Digitos, Solo 11 son permitido...");
        }
    }//GEN-LAST:event_txtTelefonoFocusLost
    private void txtMovilFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMovilFocusLost
        if (txtMovil.getText().length() < 11) {
            lSugenrencia.setText("Limite de Digitos, Solo 11 son permitido...");
        }
    }//GEN-LAST:event_txtMovilFocusLost

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        limpliarCampo();
    }//GEN-LAST:event_formInternalFrameOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JComboBox jcbEstado;
    public javax.swing.JComboBox jcbSexo;
    private javax.swing.JLabel lSugenrencia;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtCedula;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtMovil;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
