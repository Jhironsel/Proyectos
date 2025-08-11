package sur.softsurena.vista;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import sur.softsurena.clases.PadreMadres;

public final class VistaModificarPadre extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;
    private Integer idPadre;
    
    public void setIdPadre(Integer idPadre) {
        this.idPadre = idPadre;
    }
    public Integer getIdPadre() {
        return idPadre;
    }
    
    public VistaModificarPadre() {
        initComponents();
    }
    private void cerrar() {
        VistaPrincipal miPrincipal = new VistaPrincipal();
        miPrincipal.dpnEscritorio.getDesktopManager().closeFrame(this);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jcbSexo = new javax.swing.JComboBox();
        txtTelefono = new javax.swing.JTextField();
        txtMovil = new javax.swing.JTextField();
        jcbEstado = new javax.swing.JComboBox();
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
        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtCorreo = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Modificar Registro de Padre");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
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

        txtCedula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCedula.setToolTipText("");
        txtCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCedulaFocusLost(evt);
            }
        });
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

        jcbSexo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "F", "M" }));
        jcbSexo.setSelectedIndex(-1);

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

        jcbEstado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "INACTIVO", "ACTIVO" }));
        jcbEstado.setSelectedIndex(-1);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("*Cedula:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("*Nombre:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Apellidos:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("*Sexo:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Movil:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Telefono:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("*Direccion:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Estado:");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("*Sugerencias:");

        lSugenrencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lSugenrencia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lSugenrencia.setText("dd");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Correo:");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(0, 0, 0))
        );

        txtCorreo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lSugenrencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(128, 128, 128))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtMovil)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jcbEstado, 0, 150, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(jLabel2)
                                            .addComponent(txtNombre))
                                        .addComponent(jLabel1))
                                    .addGap(10, 10, 10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jcbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(109, 109, 109))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(lSugenrencia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtMovil, txtNombre, txtTelefono});

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
            lSugenrencia.setText("Debe Digitar por lo Menos un numero de Contacto...!");
            txtMovil.requestFocus();
            return;
        }else if (txtMovil.getText().equals("")) {
            lSugenrencia.setText("Debe Digitar por lo Menos un numero de Contacto...!");
            txtMovil.requestFocus();
            return;
        }        
        if (jcbEstado.getSelectedIndex() == -1) {
            lSugenrencia.setText("Selecione Tipo de Estado del Padre...!");
            jcbEstado.requestFocus();
            return;
        }
        PadreMadres miPadre = new PadreMadres(getIdPadre(),
                txtCedula.getText(),
                txtNombre.getText(),
                txtApellidos.getText(),
                jcbSexo.getSelectedItem().toString(),
                txtTelefono.getText(),
                txtMovil.getText(),
                txtDireccion.getText(),
                jcbEstado.getSelectedIndex()+"",
                txtCorreo.getText(), 
                null
        );
//        String dime = misFb.modificarPadreMadre(miPadre);
        String dime = "";
        if (dime.equals("Padre NO Modificado :( ...!")){
            int dime2 = JOptionPane.showOptionDialog(this,
                "Desea Cerrar el Formulario?", "Retornar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                frameIcon, new Object[]{"Si", "No"}, "No");
            if(dime2 == 1)return;
        }
        cerrar();
    }//GEN-LAST:event_btnGuardarActionPerformed
    private void txtCedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCedulaFocusLost
        if (txtCedula.getText().length() <= 10) {
            txtCedula.setToolTipText("Cedula Incorrecta...!");
            lSugenrencia.setText(txtCedula.getToolTipText());
        } else {
            txtCedula.setToolTipText("");
            lSugenrencia.setText(txtCedula.getToolTipText());
        }
    }//GEN-LAST:event_txtCedulaFocusLost
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
            txtNombre.setToolTipText(
                    "Nombre muy largo...! Solo se Permite 25 Caracteres, Ultimos Caracteres "
                    + txtNombre.getText().substring(20, 25));
            lSugenrencia.setText(txtNombre.getToolTipText());
        } else {
            txtNombre.setToolTipText("");
            lSugenrencia.setText(txtNombre.getToolTipText());
        }
    }//GEN-LAST:event_txtNombreFocusLost
    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 65 && k <= 90 || k >= 97 && k <= 122 || k == 8 || k == 32) {
            lSugenrencia.setText("");
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugenrencia.setText("No puede ingresar Numeros!!!");
        }
    }//GEN-LAST:event_txtApellidosKeyTyped
    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 48 && k <= 57 || k == 8) {
            lSugenrencia.setText("");
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugenrencia.setText("No puede ingresar letras!!!");
        }
        if (txtTelefono.getText().length() >= 11) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugenrencia.setText("Limite de Digitos, Solo 11 son permitido...");
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped
    private void txtMovilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMovilKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 48 && k <= 57 || k == 8) {
            lSugenrencia.setText("");
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugenrencia.setText("No puede ingresar letras!!!");
        }
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
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        jcbSexo.setSelectedIndex(-1);
        txtTelefono.setText("");
        txtMovil.setText("");
        jcbEstado.setSelectedIndex(-1);
    }//GEN-LAST:event_formInternalFrameClosed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
