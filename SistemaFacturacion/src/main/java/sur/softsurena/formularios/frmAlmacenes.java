package sur.softsurena.formularios;

import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.entidades.Almacen;
import sur.softsurena.entidades.Privilegio;
import sur.softsurena.metodos.M_Almacen;
import static sur.softsurena.metodos.M_Almacen.agregarAlmacen;
import static sur.softsurena.metodos.M_Almacen.getAlmacenesList;
import static sur.softsurena.metodos.M_Privilegio.privilegio;
import sur.softsurena.utilidades.FiltroBusqueda;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.columnasCheckBox;
import static sur.softsurena.utilidades.Utilidades.repararColumnaTable;

/**
 * Formulario que administra los registros de los almacenes del sistema.
 * 
 * Queda pediente varias tareas, el formulario hace las 
 * funciones basicas como registrar, borrar, modificar y buscar registros en el 
 * sistema.
 * 
 * TODO 01/12/2024 Queda pendiente agregar las opciones de jpOpcionesAlmacen,
 * en la base de datos agregar estos campos booleando del almacen. 
 * 
 * @author jhironsel
 */
public class frmAlmacenes extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;
    private static boolean v_nuevo;

    public static frmAlmacenes getInstance() {
        if (!privilegio(
                Privilegio
                        .builder()
                        .privilegio(
                                Privilegio.PRIVILEGIO_SELECT
                        )
                        .nombre_relacion("V_ALMACENES")
                        .build()
        )) {

            final String mensaje = """
                                   No cuenta con permisos para ver la información de
                                   este módulo.
                                   """;

            JOptionPane.showInternalMessageDialog(
                    null,
                    mensaje,
                    "",
                    JOptionPane.WARNING_MESSAGE
            );

            throw new ExceptionInInitializerError(mensaje);
        }
        return NewSingletonHolder.INSTANCE;
    }

    private int idAlmacen() {
        if(tblAlmacenes.getRowCount() == 0) return -1;
        if(tblAlmacenes.getSelectedRow() == -1) return -1;
        
        return ((Almacen) tblAlmacenes.getValueAt(
                tblAlmacenes.getSelectedRow(),
                0
        )).getId();
    }

    private static class NewSingletonHolder {

        private static final frmAlmacenes INSTANCE = new frmAlmacenes();
    }

    private frmAlmacenes() {
        initComponents();
        
        //TODO Esperando implementacion.
        jpOpcionesAlmacen.setVisible(false);
        
        jtpPrincipal.remove(RSPGMantenimiento);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBotones = new javax.swing.JPanel();
        jpBotones2 = new javax.swing.JPanel();
        btnNuevo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBuscar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();
        jtpPrincipal = new javax.swing.JTabbedPane();
        jpAlmacenesTbl = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAlmacenes = new javax.swing.JTable();
        RSPGMantenimiento = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetalleUbicacion = new javax.swing.JTextArea();
        rsEstado = new javax.swing.JCheckBox();
        txtNombreAlmacen = new javax.swing.JTextField();
        jpOpcionesAlmacen = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Almacenes");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
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

        jpBotones.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), " Botones de Acción ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        jpBotones.setMaximumSize(new java.awt.Dimension(787, 81));
        jpBotones.setMinimumSize(new java.awt.Dimension(787, 81));
        jpBotones.setName("jpBotones"); // NOI18N
        jpBotones.setPreferredSize(new java.awt.Dimension(800, 80));

        jpBotones2.setName("jpBotones2"); // NOI18N
        jpBotones2.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        btnNuevo.setText("Nuevo");
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevo.setName("btnNuevo"); // NOI18N
        btnNuevo.setRound(40);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jpBotones2.add(btnNuevo);

        btnModificar.setText("Modificar");
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
        btnModificar.setName("btnModificar"); // NOI18N
        btnModificar.setRound(40);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jpBotones2.add(btnModificar);

        btnBorrar.setText("Borrar");
        btnBorrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrar.setName("btnBorrar"); // NOI18N
        btnBorrar.setRound(40);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jpBotones2.add(btnBorrar);

        btnBuscar.setText("Buscar");
        btnBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FIND_IN_PAGE);
        btnBuscar.setName("btnBuscar"); // NOI18N
        btnBuscar.setRound(40);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jpBotones2.add(btnBuscar);

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.setName("btnGuardar"); // NOI18N
        btnGuardar.setRound(40);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jpBotones2.add(btnGuardar);

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setName("btnCancelar"); // NOI18N
        btnCancelar.setRound(40);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jpBotones2.add(btnCancelar);

        javax.swing.GroupLayout jpBotonesLayout = new javax.swing.GroupLayout(jpBotones);
        jpBotones.setLayout(jpBotonesLayout);
        jpBotonesLayout.setHorizontalGroup(
            jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBotones2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jpBotonesLayout.setVerticalGroup(
            jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotonesLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpBotones2, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jtpPrincipal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));

        jpAlmacenesTbl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));

        tblAlmacenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblAlmacenes);

        javax.swing.GroupLayout jpAlmacenesTblLayout = new javax.swing.GroupLayout(jpAlmacenesTbl);
        jpAlmacenesTbl.setLayout(jpAlmacenesTblLayout);
        jpAlmacenesTblLayout.setHorizontalGroup(
            jpAlmacenesTblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAlmacenesTblLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        jpAlmacenesTblLayout.setVerticalGroup(
            jpAlmacenesTblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAlmacenesTblLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        jtpPrincipal.addTab("Lista de Almacenes", jpAlmacenesTbl);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), " Almacen ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(37, 45, 223))); // NOI18N

        txtDetalleUbicacion.setColumns(20);
        txtDetalleUbicacion.setLineWrap(true);
        txtDetalleUbicacion.setRows(5);
        txtDetalleUbicacion.setToolTipText("Descripcion breve de la ubica");
        txtDetalleUbicacion.setWrapStyleWord(true);
        txtDetalleUbicacion.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 1, true), " Detalle de la ubicacion ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 255))); // NOI18N
        jScrollPane2.setViewportView(txtDetalleUbicacion);

        rsEstado.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        rsEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rsEstado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtNombreAlmacen.setForeground(new java.awt.Color(0, 0, 204));
        txtNombreAlmacen.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), " Ingrese nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        txtNombreAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAlmacenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNombreAlmacen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rsEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rsEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombreAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jpOpcionesAlmacen.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), " Opciones del almacen ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(37, 45, 223))); // NOI18N

        jCheckBox1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(0, 0, 255));
        jCheckBox1.setText("Se permite hacer facturas");

        jCheckBox2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(0, 0, 255));
        jCheckBox2.setText("Se permite cantidades negativas");

        javax.swing.GroupLayout jpOpcionesAlmacenLayout = new javax.swing.GroupLayout(jpOpcionesAlmacen);
        jpOpcionesAlmacen.setLayout(jpOpcionesAlmacenLayout);
        jpOpcionesAlmacenLayout.setHorizontalGroup(
            jpOpcionesAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOpcionesAlmacenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpOpcionesAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jpOpcionesAlmacenLayout.setVerticalGroup(
            jpOpcionesAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOpcionesAlmacenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addContainerGap(200, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout RSPGMantenimientoLayout = new javax.swing.GroupLayout(RSPGMantenimiento);
        RSPGMantenimiento.setLayout(RSPGMantenimientoLayout);
        RSPGMantenimientoLayout.setHorizontalGroup(
            RSPGMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RSPGMantenimientoLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpOpcionesAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        RSPGMantenimientoLayout.setVerticalGroup(
            RSPGMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RSPGMantenimientoLayout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addGroup(RSPGMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpOpcionesAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Mantenimiento", RSPGMantenimiento);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                    .addComponent(jtpPrincipal, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtpPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        v_nuevo = true;
        cambioBoton(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //Se valida que exista un campo seleccionado
        if (validarRegistro()) {
            return;
        }

        //Se hace false para indicar que es una modificacion de registro.
        v_nuevo = false;

        //Se agrega el panel de manteniento y se muestra.
        cambioBoton(true);
        
        M_Almacen.getAlmacenesList(
                FiltroBusqueda
                        .builder()
                        .id(idAlmacen())
                        .criterioBusqueda("")
                        .build()
        ).stream().forEach(
                almacen -> {
                    txtNombreAlmacen.setText(almacen.getNombre());
                    txtDetalleUbicacion.setText(almacen.getUbicacion());
                    rsEstado.setSelected(almacen.getEstado());
                }
        );
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        //Validamos que está correcto en la tabla.
        //Si el metodo devuelve true devolvemos el proceso.
        if (validarRegistro()) {
            return;
        }

        //Mostramos un mensaje de advertencia si el usuario desea continuar con
        //la eliminación del registro.
        int rta = JOptionPane.showConfirmDialog(this,
                "¿Esta seguro de eliminar el registro del sistema?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        //Si el usuario responde a que no a las opciones entonces devolvemos el
        //proceso.
        if (rta == JOptionPane.NO_OPTION) {
            return;
        }

        //Para eliminar un registro de un cliente obtenemos el ID y su estado
        Resultado resultado = M_Almacen.eliminarAlmacen(idAlmacen());

        JOptionPane.showInternalMessageDialog(
                this,
                resultado.getMensaje(),
                "",
                resultado.getIcono()
        );
        repararColumnaTable(tblAlmacenes);
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String resp = JOptionPane.showInternalInputDialog(
                this,
                "Ingrese su criterio de busqueda.\n[Nombre]",
                "",
                JOptionPane.QUESTION_MESSAGE
        );

        if (Objects.isNull(resp) || resp.isBlank()) {
            resp = "";
        }

        llenarTabla(
                FiltroBusqueda
                        .builder()
                        .id(-1)
                        .criterioBusqueda(resp)
                        .build()
        );
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtNombreAlmacen.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar el nombre del almacen...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtNombreAlmacen.requestFocus();
            return;
        }//Validacion 1

        if (txtDetalleUbicacion.getText().isBlank()) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                    Es importante agregar un detalle de la ubicacion del almacen.
                    Desea continuar?
                    """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (resp == JOptionPane.NO_OPTION) {
                txtDetalleUbicacion.requestFocus();
                return;
            }
        }//Validacion 2

        if (!rsEstado.isSelected()) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                    Se esta creando un almacen de estado inactivo.
                    Desea continuar?
                    """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            rsEstado.setSelected(resp == JOptionPane.NO_OPTION);
        }


        //Creamos objeto del almacen.
        var almacen = Almacen
                .builder()
                .id(idAlmacen())
                .nombre(txtNombreAlmacen.getText())
                .ubicacion(txtDetalleUbicacion.getText())
                .estado(rsEstado.isSelected())
                .build();

        Resultado resultado;
        if (v_nuevo) {
            resultado = agregarAlmacen(almacen);
        } else {
            resultado = M_Almacen.actualizarAlmacen(almacen);
        }

        JOptionPane.showInternalMessageDialog(
                this,
                resultado,
                "",
                resultado.getIcono()
        );

        btnCancelarActionPerformed(evt);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //Botones Para habilitar:
        cambioBoton(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        llenarTabla(
                FiltroBusqueda
                        .builder()
                        .id(-1)
                        .criterioBusqueda("")
                        .build()
        );
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        btnNuevo.setEnabled(
                privilegio(
                        Privilegio
                                .builder()
                                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
                                .nombre_relacion("SP_I_ALMACEN")
                                .nombre_campo("^")
                                .build()
                )
        );

        btnModificar.setEnabled(
                privilegio(
                        Privilegio
                                .builder()
                                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
                                .nombre_relacion("SP_U_ALMACEN")
                                .nombre_campo("^")
                                .build()
                )
        );

        btnBorrar.setEnabled(
                privilegio(
                        Privilegio
                                .builder()
                                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
                                .nombre_relacion("SP_D_ALMACEN")
                                .nombre_campo("^")
                                .build()
                )
        );
    }//GEN-LAST:event_formInternalFrameActivated

    private void txtNombreAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAlmacenActionPerformed
        txtDetalleUbicacion.requestFocus();
    }//GEN-LAST:event_txtNombreAlmacenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel RSPGMantenimiento;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBuscar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevo;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpAlmacenesTbl;
    private javax.swing.JPanel jpBotones;
    private javax.swing.JPanel jpBotones2;
    private javax.swing.JPanel jpOpcionesAlmacen;
    private javax.swing.JTabbedPane jtpPrincipal;
    private javax.swing.JCheckBox rsEstado;
    public static javax.swing.JTable tblAlmacenes;
    private javax.swing.JTextArea txtDetalleUbicacion;
    private javax.swing.JTextField txtNombreAlmacen;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param activo
     */
    private void cambioBoton(boolean activo) {
        /*
            Aqui pasan los JScrollPane se alternan con el valor de activo,
        true selecciona el mantenimiento y false selecciona los registros de 
        clientes.
         */
        if (activo) {
            jtpPrincipal.addTab("Mantenimiento", RSPGMantenimiento);
            jtpPrincipal.setSelectedComponent(RSPGMantenimiento);
        } else {
            jtpPrincipal.setSelectedComponent(jpAlmacenesTbl);
            jtpPrincipal.remove(RSPGMantenimiento);
        }

        /*
            Si el valor de activo es true, quiere decir que se va a insertar o 
        modificar un registro. Por ende, los botones nuevo, modificar, borrar y 
        buscar se deshabilitan.
        
            En caso contrario si el valor de activo es falso, los botones nuevo,
        modificar, borrar y buscar se habilitan.
         */
        btnNuevo.setEnabled(!activo);
        btnModificar.setEnabled(!activo);
        btnBorrar.setEnabled(!activo);
        btnBuscar.setEnabled(!activo);

        //Botones de guardar y cancelar
        btnGuardar.setEnabled(activo);
        btnCancelar.setEnabled(activo);

        rsEstado.setSelected(activo);
        txtNombreAlmacen.setText("");
        txtDetalleUbicacion.setText("");

    }

    /**
     *
     * @return
     */
    private boolean validarRegistro() {
        //Si la tabla de registro de los cliente está vacia devolvemos true
        //para que el proceso no continue.
        if (tblAlmacenes.getRowCount() <= 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe contar con registros de almacen, agregue nuevo almacen.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }

        //Si no existe un registro seleccionado devolvemos true para que el 
        //proceso no continue
        if (tblAlmacenes.getSelectedRow() < 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe de seleccionar un cliente",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }
        return false;
    }

    /**
     * Metodo encargado de llenar el sistema de los almacenes registrados.
     *
     * @param filtro
     * @return
     */
    public synchronized static JTable llenarTabla(FiltroBusqueda filtro) {

        final String titulos[] = {"Nombre", "Ubicacion", "Estado"};

        if (filtro.getCriterioBusqueda().equalsIgnoreCase("evento")) {
            //criterioBusqueda = frmClientes.criterioBusqueda;
        }

        DefaultTableModel dtm = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            Class<?>[] types = new Class<?>[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };

        Object registro[] = new Object[titulos.length];
        getAlmacenesList(filtro).stream().forEach(
                almacen -> {
                    registro[0] = almacen;
                    registro[1] = almacen.getUbicacion();
                    registro[2] = almacen.getEstado();
                    dtm.addRow(registro);
                }
        );

        tblAlmacenes.removeAll();

        tblAlmacenes.setModel(dtm);

        int[] indices = {2};

        columnasCheckBox(tblAlmacenes, indices);

        repararColumnaTable(tblAlmacenes);

        return tblAlmacenes;
    }
}
