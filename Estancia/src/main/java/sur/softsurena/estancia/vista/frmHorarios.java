package sur.softsurena.estancia.vista;

import static clases.Datos.getDatos;
import clases.TextPrompt;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sur.softsurena.entidades.Horario;
import sur.softsurena.metodos.M_Horario;
import sur.softsurena.utilidades.Utilidades;

public class frmHorarios extends javax.swing.JInternalFrame {

    private static frmHorarios horarios;
    private TableRowSorter<TableModel> modeloOrdenado;

    public frmHorarios() {
        initComponents();
        mostrarDetalle(true);
        new TextPrompt("Filtro de busqueda", txtFiltroBusqueda);
    }

    public synchronized static frmHorarios getHorarios() {
        if (horarios == null) {
            horarios = new frmHorarios();
        }
        return horarios;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpHorariosGestion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JCheckBox();
        btnValidaNombre = new javax.swing.JButton();
        jsToleranciaMinutos = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jsHora = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jsMinuto = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jsSegundo = new javax.swing.JSpinner();
        jpDetalleHorario = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jcbEstadosHorarios = new javax.swing.JCheckBox();
        txtFiltroBusqueda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtHorarios = new RSMaterialComponent.RSTableMetroCustom();
        jpNavegacion = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setClosable(true);
        setIconifiable(true);
        setTitle("Control de horarios");
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

        jpHorariosGestion.setBorder(javax.swing.BorderFactory.createTitledBorder("Horarios Gestion"));
        jpHorariosGestion.setToolTipText("Limite del nombre es de 40 caracteres.");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nombre:");

        txtNombre.setToolTipText("Ingrese un nombre unico para el horario");
        txtNombre.setEnabled(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Ingreso:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Tolerancia:");

        jcbEstado.setSelected(true);
        jcbEstado.setText("Activo");
        jcbEstado.setEnabled(false);
        jcbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEstadoItemStateChanged(evt);
            }
        });

        btnValidaNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Aceptar 16 x 16.png"))); // NOI18N
        btnValidaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidaNombreActionPerformed(evt);
            }
        });

        jsToleranciaMinutos.setModel(new javax.swing.SpinnerNumberModel(1, 1, 59, 1));

        jLabel8.setText("minutos");

        jsHora.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        jLabel9.setText("hora");

        jsMinuto.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        jLabel10.setText("minutos");

        jLabel11.setText("segundo");

        jsSegundo.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        javax.swing.GroupLayout jpHorariosGestionLayout = new javax.swing.GroupLayout(jpHorariosGestion);
        jpHorariosGestion.setLayout(jpHorariosGestionLayout);
        jpHorariosGestionLayout.setHorizontalGroup(
            jpHorariosGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHorariosGestionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpHorariosGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpHorariosGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpHorariosGestionLayout.createSequentialGroup()
                        .addGroup(jpHorariosGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addGroup(jpHorariosGestionLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jcbEstado)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnValidaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpHorariosGestionLayout.createSequentialGroup()
                        .addGroup(jpHorariosGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpHorariosGestionLayout.createSequentialGroup()
                                .addComponent(jsHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jsMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jsSegundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))
                            .addGroup(jpHorariosGestionLayout.createSequentialGroup()
                                .addComponent(jsToleranciaMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jpHorariosGestionLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel6});

        jpHorariosGestionLayout.setVerticalGroup(
            jpHorariosGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHorariosGestionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbEstado)
                .addGap(2, 2, 2)
                .addGroup(jpHorariosGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnValidaNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpHorariosGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jsHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jsSegundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpHorariosGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsToleranciaMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jpHorariosGestionLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, txtNombre});

        jpHorariosGestionLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel6, jLabel8, jsToleranciaMinutos});

        jpDetalleHorario.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de horarios"));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros y estados"));

        jcbEstadosHorarios.setSelected(true);
        jcbEstadosHorarios.setText("Activos");
        jcbEstadosHorarios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEstadosHorariosItemStateChanged(evt);
            }
        });

        txtFiltroBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroBusquedaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(txtFiltroBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                .addComponent(jcbEstadosHorarios)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbEstadosHorarios)
                    .addComponent(txtFiltroBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jtHorarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jtHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtHorariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtHorarios);

        javax.swing.GroupLayout jpDetalleHorarioLayout = new javax.swing.GroupLayout(jpDetalleHorario);
        jpDetalleHorario.setLayout(jpDetalleHorarioLayout);
        jpDetalleHorarioLayout.setHorizontalGroup(
            jpDetalleHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDetalleHorarioLayout.createSequentialGroup()
                .addGroup(jpDetalleHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDetalleHorarioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpDetalleHorarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jpDetalleHorarioLayout.setVerticalGroup(
            jpDetalleHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDetalleHorarioLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpNavegacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles"));

        jPanel6.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        btnNuevo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(1, 1, 1));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Documento nuevo 32 x 32.png"))); // NOI18N
        btnNuevo.setMnemonic('n');
        btnNuevo.setText("Nuevo");
        btnNuevo.setToolTipText("Crear un nuevo Registro");
        btnNuevo.setMaximumSize(new java.awt.Dimension(104, 44));
        btnNuevo.setMinimumSize(new java.awt.Dimension(104, 44));
        btnNuevo.setPreferredSize(new java.awt.Dimension(104, 44));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel6.add(btnNuevo);

        btnModificar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(1, 1, 1));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Editar Documento 32 x 32.png"))); // NOI18N
        btnModificar.setMnemonic('m');
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Modificar Registro Actual");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel6.add(btnModificar);

        btnGuardar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(1, 1, 1));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Guardar 32 x 32.png"))); // NOI18N
        btnGuardar.setMnemonic('g');
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Guardar Registro Actual");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel6.add(btnGuardar);

        btnCancelar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(1, 1, 1));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setMnemonic('c');
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancela la Operacion del Registro");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel6.add(btnCancelar);

        btnBorrar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(1, 1, 1));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Borrar 32 x 32.png"))); // NOI18N
        btnBorrar.setMnemonic('b');
        btnBorrar.setText("Borrar");
        btnBorrar.setToolTipText("Borrar Registro Actual");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel6.add(btnBorrar);

        javax.swing.GroupLayout jpNavegacionLayout = new javax.swing.GroupLayout(jpNavegacion);
        jpNavegacion.setLayout(jpNavegacionLayout);
        jpNavegacionLayout.setHorizontalGroup(
            jpNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNavegacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpNavegacionLayout.setVerticalGroup(
            jpNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNavegacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpHorariosGestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpDetalleHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpNavegacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpHorariosGestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpDetalleHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jpNavegacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        mostrarDetalle(false);

        datosDetalles(true);

        navegador(false);

        jsEnabled(false);

        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(false);

        btnValidaNombre.setEnabled(true);

        txtNombre.setEnabled(true);
        txtNombre.requestFocusInWindow();
        txtNombre.setText("");
        Utilidades.showTooltip(txtNombre);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jtHorarios.getRowCount() == 0) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "No se encuentra datos en la tabla. Registre un horario",
                    "",
                    JOptionPane.DEFAULT_OPTION
            );
            btnNuevo.requestFocus();
            return;
        }
        if (jtHorarios.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Debe seleccionar un registro de la tabla",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            jtHorarios.requestFocus();
            return;
        }
        jsEnabled(true);
        mostrarRegistro(true);
        mostrarDetalle(false);
        navegador(false);
        btnValidaNombre.setEnabled(false);
        var idHorario = ((Horario) jtHorarios.getValueAt(
                jtHorarios.getSelectedRow(),
                0
        )).getId();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Validaciones de datos...

        if (txtNombre.getText().equals("")) {
            JOptionPane.showInternalConfirmDialog(null,
                    "Inserte el Nombre!!!", "Olvida algo!",
                    JOptionPane.DEFAULT_OPTION);
            txtNombre.requestFocusInWindow();
            return;
        }

        if (!jcbEstado.isSelected()) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    "Desea dejar horario inactivo?",
                    "Proceso de validacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.NO_OPTION) {
                jcbEstado.setSelected(true);
                return;
            }
        }
        //FIN de las Validaciones..........................

        var hora = GregorianCalendar.getInstance();
        hora.add(Calendar.HOUR_OF_DAY, (int) jsHora.getValue());
        hora.add(Calendar.MINUTE, (int) jsMinuto.getValue());
        hora.add(Calendar.SECOND, (int) jsSegundo.getValue());
        
        var idHorario = ((Horario) jtHorarios.getValueAt(
                jtHorarios.getSelectedRow(),
                0
        )).getId();
        
        var resultado = M_Horario.insert(
                Horario
                        .builder()
                        .id(idHorario)
                        .descripcion(txtNombre.getText())
                        .hora(new Time(hora.getTimeInMillis()))
                        .tolerancia((int) jsToleranciaMinutos.getValue())
                        .estado(jcbEstado.isSelected())
                        .build()
        );

        JOptionPane.showInternalConfirmDialog(
                this,
                resultado,
                "",
                resultado.getIcono()
        );

        llenarTabla(jcbEstadosHorarios.isSelected());
        btnCancelarActionPerformed(null);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //Desactivamos el Flag de registro Nuevo
        jcbEstadosHorariosItemStateChanged(null);
        datosDetalles(false);
        jsEnabled(false);
        mostrarDetalle(true);
        navegador(true);
        btnCancelar.requestFocusInWindow();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (jtHorarios.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe de seleccionar un registro de la tabla!!!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        int resp = JOptionPane.showInternalConfirmDialog(
                this,
                """
                Desea borrar el Horario Seleccionado?
                """,
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        var idHorario = ((Horario) jtHorarios.getValueAt(
                jtHorarios.getSelectedRow(),
                0
        )).getId();

        var resultado = M_Horario.delete(
                Horario
                        .builder()
                        .id(idHorario)
                        .build()
        );

        JOptionPane.showMessageDialog(
                this,
                resultado,
                "",
                resultado.getIcono()
        );

        //Actualizamos los cambios en la Tabla
        llenarTabla(jcbEstado.isSelected());
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnValidaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidaNombreActionPerformed
        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe ingresar el nombre del horario a registrar.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        var horario = M_Horario.select(
                Horario
                        .builder()
                        .descripcion(txtNombre.getText())
                        .build()
        );

        if (!horario.isEmpty()) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Este perfil de horario ya existe",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtNombre.setText("");
            return;
        }

        jsEnabled(true);
        mostrarDetalle(false);

        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnValidaNombreActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        btnValidaNombreActionPerformed(evt);
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        if (txtNombre.getText().length() >= 40) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void jcbEstadosHorariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbEstadosHorariosItemStateChanged
        if (jcbEstadosHorarios.isSelected()) {
            jcbEstadosHorarios.setText("Activo");
        } else {
            jcbEstadosHorarios.setText("Inactivo");
        }
        llenarTabla(jcbEstadosHorarios.isSelected());
    }//GEN-LAST:event_jcbEstadosHorariosItemStateChanged

    private void jcbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbEstadoItemStateChanged
        if (jcbEstado.isSelected()) {
            jcbEstado.setText("Activo");
        } else {
            jcbEstado.setText("Inactivo");
        }
    }//GEN-LAST:event_jcbEstadoItemStateChanged

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        llenarTabla(jcbEstadosHorarios.isSelected());
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtFiltroBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroBusquedaKeyReleased
        modeloOrdenado.setRowFilter(
                RowFilter.regexFilter(
                        "(?i)" + txtFiltroBusqueda.getText(),
                        0
                )
        );
    }//GEN-LAST:event_txtFiltroBusquedaKeyReleased

    private void jtHorariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtHorariosMouseClicked
        if (!jtHorarios.isEnabled()) {
            return;
        }
        if (evt.getClickCount() == 2) {
            btnModificarActionPerformed(null);
        }
    }//GEN-LAST:event_jtHorariosMouseClicked

    private void mostrarRegistro(boolean b) {
        if (jtHorarios.getRowCount() == 0) {
            datosDetalles(true);
            return;
        }
        txtNombre.setText(
                ((Horario) jtHorarios.getValueAt(jtHorarios.getSelectedRow(), 0)).getDescripcion());

        jsToleranciaMinutos.setValue(
                jtHorarios.getValueAt(jtHorarios.getSelectedRow(), 5)
        );

        jcbEstado.setSelected(jcbEstadosHorarios.isSelected());
    }

    private void llenarTabla(boolean b) {
        jtHorarios.removeAll();

        String titulos[] = {
            "<html><b>Nombres</b></html>",
            "<html><b>Hora</b></html>",
            "<html><b>Tolerancia</b></html>",
            "<html><b>Estado</b></html>"
        };

        DefaultTableModel dtmHorario = new DefaultTableModel(null, titulos);;

        Object registro[] = new Object[titulos.length];

        M_Horario.select(Horario.builder().build()).stream().forEach(
                horario -> {
                    registro[0] = horario;
                    registro[1] = horario.getHora();
                    registro[2] = horario.getTolerancia();
                    registro[3] = horario.getEstado();
                    dtmHorario.addRow(registro);
                }
        );
        jtHorarios.setModel(dtmHorario);
//        modeloOrdenado = new TableRowSorter<TableModel>(dtmHorario);
//        jtHorarios.setRowSorter(modeloOrdenado);

//        adjustColumnPreferredWidths(jtHorarios);
    }

    private void navegador(boolean b) {
        txtNombre.requestFocusInWindow();
        btnNuevo.setEnabled(b);
        btnModificar.setEnabled(b);
        btnBorrar.setEnabled(b);

        //Caja de Texto Habilitado
        btnGuardar.setEnabled(!b);
        btnCancelar.setEnabled(!b);
        btnValidaNombre.setEnabled(!b);
    }

    private void datosDetalles(boolean b) {
        if (b) {
            txtNombre.setText("");
            jsToleranciaMinutos.setValue(0);
            jcbEstado.setSelected(true);
        }
    }

    private void jsEnabled(boolean b) {
        txtNombre.setEnabled(b);
        jsToleranciaMinutos.setEnabled(b);
        jcbEstado.setEnabled(b);
    }

    private void mostrarDetalle(boolean b) {
        jpDetalleHorario.setVisible(b);
        jpHorariosGestion.setVisible(!b);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnValidaNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox jcbEstado;
    private javax.swing.JCheckBox jcbEstadosHorarios;
    private javax.swing.JPanel jpDetalleHorario;
    private javax.swing.JPanel jpHorariosGestion;
    private javax.swing.JPanel jpNavegacion;
    private javax.swing.JSpinner jsHora;
    private javax.swing.JSpinner jsMinuto;
    private javax.swing.JSpinner jsSegundo;
    private javax.swing.JSpinner jsToleranciaMinutos;
    private RSMaterialComponent.RSTableMetroCustom jtHorarios;
    private javax.swing.JTextField txtFiltroBusqueda;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
