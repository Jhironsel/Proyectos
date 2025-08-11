package sur.softsurena.vista;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.entidades.Persona;
import sur.softsurena.entidades.Role;
import sur.softsurena.entidades.Usuario;
import sur.softsurena.metodos.M_Etiqueta;
import sur.softsurena.metodos.M_Role;
import static sur.softsurena.metodos.M_Role.quitarRolesUsuario;
import sur.softsurena.metodos.M_Usuario;
import sur.softsurena.utilidades.PalabrasReservadasFirebird;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.columnasCheckBox;
import static sur.softsurena.utilidades.Utilidades.repararColumnaTable;
import static sur.softsurena.utilidades.Utilidades.showTooltip;

public final class VistaUsuariosAgregar extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;

    private boolean newRecord;//Si el suario es nuevo o no

    private transient final Usuario usuario;

    /*Este constructor es utilizado para agregar nuevos usuarios*/
    public VistaUsuariosAgregar(Frame parent, boolean modal, boolean newRecord, Usuario usuario) {
        super(parent, modal);
        this.newRecord = newRecord;
        this.usuario = usuario;
        initComponents();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        txtUserName = new rojeru_san.rsfield.RSTextFullRound();
        txtPNombre = new rojeru_san.rsfield.RSTextFullRound();
        txtSNombre = new rojeru_san.rsfield.RSTextFullRound();
        txtApellidos = new rojeru_san.rsfield.RSTextFullRound();
        txtClave1 = new rojeru_san.rsfield.RSPassViewRound();
        txtClave2 = new rojeru_san.rsfield.RSPassViewRound();
        jPanel7 = new javax.swing.JPanel();
        cbAdministrador = new RSMaterialComponent.RSCheckBoxMaterial();
        cbEstado = new RSMaterialComponent.RSCheckBoxMaterial();
        jPanel6 = new javax.swing.JPanel();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnAceptar = new RSMaterialComponent.RSButtonMaterialIconOne();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRoles = new rojerusan.RSTableMetro();
        btnAgregarRol = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrarRol = new RSMaterialComponent.RSButtonMaterialIconOne();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEtiquetas = new rojerusan.RSTableMetro();
        btnAgregarTag = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrarTag = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEditarTag = new RSMaterialComponent.RSButtonMaterialIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar nuevo usuario");
        setIconImage(null);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(" Datos "));

        jPanel9.setLayout(new java.awt.GridLayout(7, 0, 0, 10));

        txtUserName.setToolTipText("Identificador del usuario en el sistema.\n\nNOTA: No colocar nombres de roles en este campo. ");
        txtUserName.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        txtUserName.setMayusculas(true);
        txtUserName.setMinimumSize(new java.awt.Dimension(150, 0));
        txtUserName.setName("txtUserName"); // NOI18N
        txtUserName.setPlaceholder("ID Usuario");
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        jPanel9.add(txtUserName);

        txtPNombre.setToolTipText("Nombres del usuario");
        txtPNombre.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        txtPNombre.setMinimumSize(new java.awt.Dimension(150, 0));
        txtPNombre.setName("txtPNombre"); // NOI18N
        txtPNombre.setPlaceholder("Primer Nombre");
        txtPNombre.setPreferredSize(new java.awt.Dimension(150, 0));
        txtPNombre.setSoloLetras(true);
        txtPNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPNombreActionPerformed(evt);
            }
        });
        jPanel9.add(txtPNombre);

        txtSNombre.setToolTipText("Nombres del usuario");
        txtSNombre.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        txtSNombre.setMinimumSize(new java.awt.Dimension(150, 0));
        txtSNombre.setName("txtSNombre"); // NOI18N
        txtSNombre.setPlaceholder("Segundo Nombre");
        txtSNombre.setPreferredSize(new java.awt.Dimension(150, 0));
        txtSNombre.setSoloLetras(true);
        txtSNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSNombreActionPerformed(evt);
            }
        });
        jPanel9.add(txtSNombre);

        txtApellidos.setToolTipText("Apellidos del usuario");
        txtApellidos.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        txtApellidos.setMinimumSize(new java.awt.Dimension(150, 0));
        txtApellidos.setName("txtApellidos"); // NOI18N
        txtApellidos.setPlaceholder("Apellidos");
        txtApellidos.setPreferredSize(new java.awt.Dimension(150, 0));
        txtApellidos.setSoloLetras(true);
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel9.add(txtApellidos);

        txtClave1.setToolTipText("Clave del suario para el sistema");
        txtClave1.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        txtClave1.setMinimumSize(new java.awt.Dimension(150, 0));
        txtClave1.setName("txtClave1"); // NOI18N
        txtClave1.setPlaceholder("Ingrese clave");
        txtClave1.setPreferredSize(new java.awt.Dimension(150, 0));
        txtClave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClave1ActionPerformed(evt);
            }
        });
        jPanel9.add(txtClave1);

        txtClave2.setToolTipText("Confirme la clave del usuario ");
        txtClave2.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        txtClave2.setMinimumSize(new java.awt.Dimension(150, 0));
        txtClave2.setName("txtClave2"); // NOI18N
        txtClave2.setPlaceholder("Confirmación");
        txtClave2.setPreferredSize(new java.awt.Dimension(150, 0));
        txtClave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClave2ActionPerformed(evt);
            }
        });
        jPanel9.add(txtClave2);

        jPanel7.setMinimumSize(new java.awt.Dimension(150, 0));
        jPanel7.setPreferredSize(new java.awt.Dimension(150, 0));
        jPanel7.setLayout(new java.awt.BorderLayout());

        cbAdministrador.setText("No Administrador");
        cbAdministrador.setName("cbAdministrador"); // NOI18N
        cbAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAdministradorActionPerformed(evt);
            }
        });
        jPanel7.add(cbAdministrador, java.awt.BorderLayout.PAGE_END);

        cbEstado.setText("Inactivo");
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });
        jPanel7.add(cbEstado, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setLayout(new java.awt.GridLayout(1, 0, 10, 10));

        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setName("btnCancelar"); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel6.add(btnCancelar);

        btnAceptar.setText("Aceptar");
        btnAceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnAceptar.setName("btnAceptar"); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel6.add(btnAceptar);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setPreferredSize(new java.awt.Dimension(486, 0));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(" Descripción "));
        jPanel3.setPreferredSize(new java.awt.Dimension(266, 0));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setName("txtDescripcion"); // NOI18N
        jScrollPane1.setViewportView(txtDescripcion);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Roles"));
        jPanel8.setPreferredSize(new java.awt.Dimension(480, 0));

        tblRoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rol de usuario", "Descripcion"
            }
        ));
        tblRoles.setToolTipText("Roles que el usuario tiene registrado.");
        tblRoles.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblRoles.setName("tblRoles"); // NOI18N
        tblRoles.setPreferredScrollableViewportSize(new java.awt.Dimension(450, 0));
        tblRoles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblRoles.setShowGrid(true);
        tblRoles.getTableHeader().setResizingAllowed(false);
        tblRoles.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblRoles);

        btnAgregarRol.setText("Agregar");
        btnAgregarRol.setToolTipText("Es necesario un rol de usuario.");
        btnAgregarRol.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAgregarRol.setName("btnAgregarRol"); // NOI18N
        btnAgregarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRolActionPerformed(evt);
            }
        });

        btnBorrarRol.setText("Borrar");
        btnBorrarRol.setToolTipText("Elimina el rol de usuario seleccionado en la tabla.");
        btnBorrarRol.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrarRol.setName("btnBorrarRol"); // NOI18N
        btnBorrarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarRolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAgregarRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrarRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(" Etiquetas "));
        jPanel4.setPreferredSize(new java.awt.Dimension(480, 0));

        jScrollPane2.setMaximumSize(new java.awt.Dimension(32767, 0));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(27, 0));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(458, 0));

        tblEtiquetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Valor"
            }
        ));
        tblEtiquetas.setToolTipText("Las etiquetas son atributos que pueden usar los usuario del sistema.");
        tblEtiquetas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblEtiquetas.setName("tblEtiquetas"); // NOI18N
        tblEtiquetas.setPreferredScrollableViewportSize(new java.awt.Dimension(450, 0));
        tblEtiquetas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblEtiquetas.setShowGrid(true);
        tblEtiquetas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblEtiquetas);

        btnAgregarTag.setText("Agregar");
        btnAgregarTag.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAgregarTag.setName("btnAgregarTag"); // NOI18N
        btnAgregarTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTagActionPerformed(evt);
            }
        });

        btnBorrarTag.setText("Borrar");
        btnBorrarTag.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrarTag.setName("btnBorrarTag"); // NOI18N
        btnBorrarTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarTagActionPerformed(evt);
            }
        });

        btnEditarTag.setText("Editar");
        btnEditarTag.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarTag.setName("btnAgregarTag"); // NOI18N
        btnEditarTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTagActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditarTag, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(btnBorrarTag, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnAgregarTag, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrarTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel3, jPanel4, jPanel8});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        txtPNombre.requestFocus();
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void txtPNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPNombreActionPerformed
        txtSNombre.requestFocus();
    }//GEN-LAST:event_txtPNombreActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        txtClave1.requestFocus();
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtClave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClave1ActionPerformed
        txtClave2.requestFocus();
    }//GEN-LAST:event_txtClave1ActionPerformed

    private void txtClave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClave2ActionPerformed
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_txtClave2ActionPerformed

    private void txtSNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSNombreActionPerformed
        txtApellidos.requestFocus();
    }//GEN-LAST:event_txtSNombreActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //Se valida que el userName no este en blanco.
        if (txtUserName.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe Digitar un ID o nombre de usuario.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtUserName.requestFocus();
            return;
        }
        
        // Se valida que el primer nombre no este en blanco.
        if (txtPNombre.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe Digitar un nombre.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtPNombre.requestFocus();
            return;
        }
        
        //Se valida que el apellido no este en blanco.
        if (txtApellidos.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe Digitar un apellidos.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtApellidos.requestFocus();
            return;
        }

//      Se pregunta si desea dejar el usuario inactivo. Si el usuario responde
//      que no el usuario pasa a estar activo automaticamente, en caso contrario
//      prosigue con el registro.
        if (!cbEstado.isSelected()) {
            int resp = JOptionPane.showConfirmDialog(
                    this,
                    "¿Desea dejar el usuario inactivo?",
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (resp == JOptionPane.NO_OPTION) {
                cbEstado.setSelected(true);
                cbEstadoActionPerformed(null);
            }
        }

        //Se valida que las clave y la confirmacion no esten en blanco cuando se
        //procede a registrar un nuevo registro.
        String clave1 = new String(txtClave1.getPassword()),
                clave2 = new String(txtClave2.getPassword());

        if (newRecord) {
            //Si es nuevo se realizan las verificaciones de las claves..
            if (clave1.isBlank()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Debe Ingresar clave.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                txtClave1.requestFocus();
                return;
            }

            if (clave2.isBlank()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Debe Ingresar confirmacion.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                txtClave2.requestFocus();
                return;
            }
        } else {
            /*
            7) Se valida los registros de roles cuando se esta modificando un
            registro, si el usuario no agrego roles al registro de usuario cuando se
            modifica un registro en el sistema, se le pregunta si desea continuar con
            el registros de nuevo usuario sin registro.
            */
            
            if (tblRoles.getRowCount() <= 0) {
                int resp = JOptionPane.showConfirmDialog(
                        this,
                        "Desea eliminar todos los roles a este usuario?",
                        "",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (resp == JOptionPane.CANCEL_OPTION) {
                    return;
                }

                if (resp == JOptionPane.YES_OPTION) {
                    quitarRolesUsuario(txtUserName.getText().strip());
                }
            }
        }

        // Se procede a comprar la clave y la confirmacion de la clave.
        if (!clave1.equals(clave2)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Claves no coinciden.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtClave2.setText("");
            txtClave1.setText("");
            txtClave1.requestFocus();
            return;
        }

        //Si el usuario no tiene registros de en la tabla de roles se le
        //pregunta si desea continuar sin roles del usuario.
        if (tblRoles.getRowCount() <= 0) {
            int resp = JOptionPane.showConfirmDialog(
                    this,
                    "Desea registrar usuario sin rol?",
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (resp == JOptionPane.NO_OPTION) {
                btnAgregarRol.doClick();

                showTooltip(btnAgregarRol);

                return;
            }
        }

        //Se verifica que no exista un usuario con el mismo nombre de usuario en
        //el sistema. En caso de que se encuentre el usuario tendrá la opcion de
        //cargar el usuario nueve.
        if (!M_Usuario.select(
                Usuario
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .build()
                        )
                        .userName(txtUserName.getText().strip())
                        .build()
        ).isEmpty() && newRecord) {
            int respuesta = JOptionPane.showConfirmDialog(
                    this,
                    """
                    Usuario ya existe.
                    Desea recuperar el usuario?
                    """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (respuesta == JOptionPane.YES_OPTION) {
                cargarUsuario(
                        M_Usuario.select(
                                Usuario
                                        .builder()
                                        .userName(txtUserName.getText().strip())
                                        .persona(
                                                Persona
                                                        .builder()
                                                        .build()
                                        )
                                        .build()
                        ).getFirst()
                );
                newRecord = false;
                txtClave1.setText("");
                txtClave2.setText("");
                txtClave1.requestFocus();
                return;
            }

        }

        //Se muestra el mensaje con la informacion del usuario.
        String mensaje = """
                         <html>
                            <h1>Se va a agregar el usuario: %s </h1></br>
                            <h1>         Nombre y Apellido: %s %s%s</h1></br>
                            <h1>             Administrador: %s</h1></br>
                            <h1>                    Estado: %s</h1>
                            <h1>Desea continuar? </h1>
                         </html>
                         """.formatted(
                txtUserName.getText(),
                txtPNombre.getText(),
                txtSNombre.getText().isBlank() ? "" : txtSNombre.getText().concat(" "),
                txtApellidos.getText(),
                cbAdministrador.isSelected() ? "Activado" : "NO Activado",
                cbEstado.isSelected() ? "Activo" : "No Activo"
        );

        int resp = JOptionPane.showConfirmDialog(
                this,
                mensaje,
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }
//----------------------------------------------------------------------------10

        List<Role> rolesList = new ArrayList<>();

        for (int i = 0; i < tblRoles.getRowCount(); i++) {
            rolesList.add(
                    Role
                            .builder()
                            .roleName(
                                    tblRoles.getValueAt(i, 0).toString()
                            )
                            .conAdmin(
                                    Boolean.parseBoolean(tblRoles.getValueAt(i, 1).toString())
                            )
                            .build()
            );
        }

        //Se procesa las etiquetas del usuario.
        String etiquetas = "";
        for (int i = 0; i < tblEtiquetas.getRowCount(); i++) {
            if (tblEtiquetas.getValueAt(i, 0).toString().contains("DROP")) {
                etiquetas = etiquetas + tblEtiquetas.getValueAt(i, 0).toString() + ((i == tblEtiquetas.getRowCount() - 1) ? "" : ", ");
            } else {
                etiquetas = etiquetas
                        + tblEtiquetas.getValueAt(i, 0).toString() + " = " + "'"
                        + tblEtiquetas.getValueAt(i, 1).toString() + "'"
                        + ((i == tblEtiquetas.getRowCount() - 1) ? "" : ", ");
            }
        }


        /*
        Se procede crear el objeto usuario tomando el userName, PNombre,
        SNombre, Apellidos, la descripcion, la clave, lista la tags del
        usuario, el estado del registro, si es Administrador, la lista de roles.
        */
        Usuario usuarioSistema = Usuario
                .builder()
                .userName(txtUserName.getText())
                .persona(
                        Persona
                                .builder()
                                .pnombre(txtPNombre.getText())
                                .snombre(txtSNombre.getText())
                                .apellidos(txtApellidos.getText())
                                .estado(cbEstado.isSelected())
                                .build()
                )
                .descripcion(txtDescripcion.getText())
                .clave(clave1)
                .tags(etiquetas)
                .administrador(cbAdministrador.isSelected())
                .roles(rolesList)
                .build();


        /*
        Se envia el registro a la base de datos dependiendo del tipo, si es
        nuevo registro o modificando un registro a la base de datos.
        */
        Resultado resultado = (
                newRecord ? M_Usuario.insert(usuarioSistema) : 
                            M_Usuario.update(usuarioSistema)
                );


        //Se muestra un mensaje con los resultado de la operacion.
        JOptionPane.showMessageDialog(
                this,
                resultado,
                "",
                resultado.getIcono()
        );

        //Si el registro fue exitoso entonces 
        //se cierra el formulario en el sistema.
        if(resultado.getEstado()){
            dispose();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAdministradorActionPerformed
        if (cbAdministrador.isSelected()) {
            cbAdministrador.setText("Administrador");
        } else {
            cbAdministrador.setText("No Administrador");
        }
    }//GEN-LAST:event_cbAdministradorActionPerformed

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        if (cbEstado.isSelected()) {
            cbEstado.setText("Activo");
        } else {
            cbEstado.setText("Inactivo");
        }
    }//GEN-LAST:event_cbEstadoActionPerformed

    private void btnAgregarTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTagActionPerformed
        VistaEtiquetas etiqueta = new VistaEtiquetas(null, true);
        etiqueta.setLocationRelativeTo(etiqueta);
        etiqueta.setVisible(true);

        if (!etiqueta.aceptar) {
            return;
        }

        boolean palabra = PalabrasReservadasFirebird
                .palabrasReservadasFirebird()
                .contains(etiqueta.txtPropiedad.getText());

        if (palabra) {
            JOptionPane.showMessageDialog(
                    this,
                    "Esta propiedad no puede ser usada.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        //Evitar que se duplique las etiquetas.
        for (int i = 0; i < tblEtiquetas.getRowCount(); i++) {
            if (etiqueta.txtPropiedad.getText().equalsIgnoreCase(
                    tblEtiquetas.getValueAt(i, 0).toString())) {
                JOptionPane.showMessageDialog(
                        this,
                        "Esta propiedad ya se encuentra registrada.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        }

        Object registro[] = new Object[2];
        registro[0] = etiqueta.txtPropiedad.getText();
        registro[1] = etiqueta.txtValor.getText();

        DefaultTableModel miTabla = (DefaultTableModel) tblEtiquetas.getModel();

        miTabla.addRow(registro);

        tblEtiquetas.setModel(miTabla);

        Utilidades.repararColumnaTable(tblEtiquetas);
    }//GEN-LAST:event_btnAgregarTagActionPerformed

    private void btnBorrarTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTagActionPerformed
        DefaultTableModel miTabla = (DefaultTableModel) tblEtiquetas.getModel();

        if (newRecord) {
            miTabla.removeRow(tblEtiquetas.getSelectedRow());
        } else {
            miTabla.setValueAt(
                    "DROP ".concat(
                            miTabla.getValueAt(
                                    tblEtiquetas.getSelectedRow(),
                                    0
                            ).toString()
                    ),
                    tblEtiquetas.getSelectedRow(),
                    0
            );

            miTabla.setValueAt(
                    "",
                    tblEtiquetas.getSelectedRow(),
                    1
            );
        }

        tblEtiquetas.setModel(miTabla);
    }//GEN-LAST:event_btnBorrarTagActionPerformed

    private void btnAgregarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRolActionPerformed
        if (txtUserName.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Digita el nombre del usuario.",
                    "",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        Object[] roles = M_Role.selectDisponibles(
                        txtUserName.getText().strip(),
                        true
                ).toArray();

        Role rol = (Role) JOptionPane.showInputDialog(
                this,
                """
                Seleccione un rol para el usuario.
                """,
                "",
                JOptionPane.PLAIN_MESSAGE,
                null,
                roles,
                roles[0]
        );

        if (Objects.isNull(rol)) {
            return;
        }

        for (int i = 0; i < tblRoles.getRowCount(); i++) {
            if (rol.toString().equalsIgnoreCase(
                    tblRoles.getValueAt(i, 0).toString()
            )) {
                JOptionPane.showMessageDialog(
                        this,
                        "Este role ya se encuentra en la lista.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        }

        int resp = JOptionPane.showConfirmDialog(
                this,
                "Desea permitir administracion de rol al usuario?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (newRecord) {

            String cabeceras[] = {"Rol de usuario", "Con Admin", "Descripcion"};
            Object registro[] = new Object[cabeceras.length];

            DefaultTableModel miTabla = (DefaultTableModel) tblRoles.getModel();
            miTabla.setColumnIdentifiers(cabeceras);

            registro[0] = rol;
            registro[1] = (resp == JOptionPane.YES_OPTION);
            registro[2] = rol.getDescripcion();

            miTabla.addRow(registro);

            tblRoles.setModel(miTabla);

            repararColumnaTable(tblRoles);
            columnasCheckBox(tblRoles, new int[]{1});

        } else {
            var resultado = M_Role.asignarRolUsuario(
                    rol.getRoleName(), 
                    txtUserName.getText(), 
                    (resp == JOptionPane.YES_OPTION)
            );
            
            if(!resultado.getEstado()){
                JOptionPane.showMessageDialog(
                        this, 
                        resultado.getMensaje(), 
                        "", 
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            
            cargarRoles(usuario);
        }
    }//GEN-LAST:event_btnAgregarRolActionPerformed

    private void btnBorrarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarRolActionPerformed
        if (newRecord) {
            if (tblRoles.getSelectedRow() == -1) {
                return;
            }

            DefaultTableModel miTabla = (DefaultTableModel) tblRoles.getModel();

            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    "¿Desea borrar el rol al usuario?",
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (resp == JOptionPane.NO_OPTION) {
                return;
            }

            miTabla.removeRow(tblRoles.getSelectedRow());

            tblRoles.setModel(miTabla);

            repararColumnaTable(tblRoles);
            columnasCheckBox(tblRoles, new int[]{1});
        } else {
            //TODO 30/06/2025 esta parte necesita terminarse.
            
            if(tblRoles.getSelectedRow() == -1){
                return;
            }
            
            M_Role.quitarRolUsuario(
                    "R_"+tblRoles.getValueAt(
                            tblRoles.getSelectedRow(), 
                            0
                    ).toString(), 
                    txtUserName.getText()
            );
            
            cargarRoles(usuario);
        }


    }//GEN-LAST:event_btnBorrarRolActionPerformed

    private void btnEditarTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTagActionPerformed
        if (tblEtiquetas.getSelectedRow() == -1) {
            return;
        }

        var propiedad = tblEtiquetas.getValueAt(
                tblEtiquetas.getSelectedRow(), 0
        ).toString();

        var valor = tblEtiquetas.getValueAt(
                tblEtiquetas.getSelectedRow(), 1
        ).toString();

        VistaEtiquetas etiqueta = new VistaEtiquetas(null, true, propiedad, valor);
        etiqueta.setLocationRelativeTo(etiqueta);
        etiqueta.setVisible(true);

    }//GEN-LAST:event_btnEditarTagActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if (!newRecord) {
            cargarUsuario(usuario);
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void cargarUsuario(Usuario usuario) {
        if(newRecord){
            return;
        }
        txtUserName.setText(usuario.getUserName());
        txtUserName.setEditable(false);

        txtPNombre.setText(usuario.getPersona().getPnombre());
        txtSNombre.setText(usuario.getPersona().getSnombre());
        txtApellidos.setText(usuario.getPersona().getApellidos());

        cbEstado.setSelected(usuario.getPersona().getEstado());
        //cbEstadoActionPerformed(null);

        cbAdministrador.setSelected(usuario.getAdministrador());
        //cbAdministradorActionPerformed(null);

        txtDescripcion.setText(usuario.getDescripcion());

        //----------------------------------------------------------------------
        cargarRoles(usuario);

        //----------------------------------------------------------------------
        cargarEtiquetas(usuario);
    }

    private void cargarRoles(Usuario usuario) {
        String titulos2[] = {"Roles", "Con Admin", "Descripción"};
        Object registro2[] = new Object[titulos2.length];
        DefaultTableModel dtmRoles = new DefaultTableModel(null, titulos2);
        tblRoles.setModel(dtmRoles);

        tblRoles.removeAll();
        M_Role.selectDisponibles(
                usuario
                        .getUserName(),
                false
        ).stream().forEach(
                rol -> {
                    registro2[0] = rol;
                    registro2[1] = rol.getOpcionPermiso() == 2;
                    registro2[2] = rol.getDescripcion();

                    dtmRoles.addRow(registro2);
                }
        );

        tblRoles.setModel(dtmRoles);
        repararColumnaTable(tblRoles);
        columnasCheckBox(tblRoles, new int[]{1});
        tblRoles.setBackgoundHover(new java.awt.Color(102, 102, 255));
    }
    
    private void cargarEtiquetas(Usuario usuario) {
        String titulos[] = {"Propiedad", "Valor"};
        Object registro[] = new Object[titulos.length];
        DefaultTableModel dtmEtiquetas = new DefaultTableModel(null, titulos);

        tblEtiquetas.removeAll();
        M_Etiqueta.getEtiquetasUsuario(
                usuario
                        .getUserName()
        ).stream().forEach(
                etiqueta -> {
                    registro[0] = etiqueta.getPropiedad();
                    registro[1] = etiqueta.getValor();

                    dtmEtiquetas.addRow(registro);
                }
        );

        tblEtiquetas.setModel(dtmEtiquetas);
        repararColumnaTable(tblEtiquetas);
        tblEtiquetas.setBackgoundHover(new java.awt.Color(102, 102, 255));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAceptar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarRol;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarTag;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarRol;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarTag;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditarTag;
    private static RSMaterialComponent.RSCheckBoxMaterial cbAdministrador;
    private static RSMaterialComponent.RSCheckBoxMaterial cbEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private static rojerusan.RSTableMetro tblEtiquetas;
    private static rojerusan.RSTableMetro tblRoles;
    private static rojeru_san.rsfield.RSTextFullRound txtApellidos;
    private static rojeru_san.rsfield.RSPassViewRound txtClave1;
    private static rojeru_san.rsfield.RSPassViewRound txtClave2;
    private static javax.swing.JTextArea txtDescripcion;
    private static rojeru_san.rsfield.RSTextFullRound txtPNombre;
    private static rojeru_san.rsfield.RSTextFullRound txtSNombre;
    private static rojeru_san.rsfield.RSTextFullRound txtUserName;
    // End of variables declaration//GEN-END:variables
}
