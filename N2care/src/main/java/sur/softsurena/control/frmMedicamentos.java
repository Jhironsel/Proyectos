package sur.softsurena.control;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.entidades.Proveedor;
import sur.softsurena.formularios.frmPrincipal;
import static sur.softsurena.formularios.frmPrincipal.dpnEscritorio;
import sur.softsurena.metodos.M_Medicamento;
import sur.softsurena.metodos.M_Persona;
import sur.softsurena.metodos.M_Proveedor;
import sur.softsurena.utilidades.JComboExp;
import sur.softsurena.utilidades.Resultado;

public class frmMedicamentos extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    private static frmMedicamentos medicamentos;

    private Object resp;

    private File fichero;

    private ImageIcon img = null;

    private JComboExp miCombo;

    public frmMedicamentos() {

        initComponents();
        jpbFoto.setVisible(false);

        miCombo = new JComboExp();
        cbProveedores.setUI(miCombo);
    }

    public synchronized static frmMedicamentos getMedicamentos() {

        if (medicamentos == null) {
            medicamentos = new frmMedicamentos();
        }
        return medicamentos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jlFoto = new javax.swing.JLabel();
        jpbFoto = new javax.swing.JProgressBar();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jpDetalles = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedicamentos = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        cbEstadosMedicamentos = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        cbEstadoMedicamento = new javax.swing.JCheckBox();
        txtNombreMedicamentos = new javax.swing.JTextField();
        btnImagenBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtCodigoProveedor = new javax.swing.JTextField();
        cbProveedores = new javax.swing.JComboBox<>();
        cbEstadoProveedor = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Control y matenimiento de medicamentos");
        setToolTipText("");
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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Foto Medicamento"));

        jlFoto.setToolTipText("Imagen del medicamento seleccionado");

        jpbFoto.setStringPainted(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpbFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jlFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jpbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), " Controles "));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        btnNuevo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(1, 1, 1));
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
        btnModificar.setMnemonic('m');
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Modificar Registro Actual");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel6.add(btnModificar);

        btnBuscar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(1, 1, 1));
        btnBuscar.setMnemonic('r');
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Buscar el Registro");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel6.add(btnBuscar);

        btnGuardar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(1, 1, 1));
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

        jpDetalles.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Detalles de medicamentos"));

        tblMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Linea", "Codigo Proveedor", "Nombre Medicamento", "Estado"
            }
        ));
        tblMedicamentos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblMedicamentos.getTableHeader().setReorderingAllowed(false);
        tblMedicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMedicamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMedicamentos);
        tblMedicamentos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        cbEstadosMedicamentos.setSelected(true);
        cbEstadosMedicamentos.setText("Activos");
        cbEstadosMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadosMedicamentosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpDetallesLayout = new javax.swing.GroupLayout(jpDetalles);
        jpDetalles.setLayout(jpDetallesLayout);
        jpDetallesLayout.setHorizontalGroup(
            jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDetallesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbEstadosMedicamentos)
                .addContainerGap())
        );
        jpDetallesLayout.setVerticalGroup(
            jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbEstadosMedicamentos)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));

        cbEstadoMedicamento.setText("Inactivo");
        cbEstadoMedicamento.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));
        cbEstadoMedicamento.setBorderPainted(true);
        cbEstadoMedicamento.setBorderPaintedFlat(true);
        cbEstadoMedicamento.setEnabled(false);
        cbEstadoMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoMedicamentoActionPerformed(evt);
            }
        });

        txtNombreMedicamentos.setEditable(false);
        txtNombreMedicamentos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Nombre"));

        btnImagenBuscar.setText("Buscar Imagen");
        btnImagenBuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));
        btnImagenBuscar.setEnabled(false);
        btnImagenBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreMedicamentos)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbEstadoMedicamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImagenBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombreMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImagenBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstadoMedicamento))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnImagenBuscar, cbEstadoMedicamento});

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255))));

        txtCodigoProveedor.setEditable(false);
        txtCodigoProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Codigo proveedor"));
        txtCodigoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoProveedorActionPerformed(evt);
            }
        });

        cbProveedores.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Nombre proveedor"));
        cbProveedores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProveedoresItemStateChanged(evt);
            }
        });
        cbProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbProveedoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbProveedoresMouseExited(evt);
            }
        });
        cbProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProveedoresActionPerformed(evt);
            }
        });

        cbEstadoProveedor.setText("Inactivo");
        cbEstadoProveedor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));
        cbEstadoProveedor.setBorderPainted(true);
        cbEstadoProveedor.setBorderPaintedFlat(true);
        cbEstadoProveedor.setEnabled(false);
        cbEstadoProveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cbEstadoProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cbEstadoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbProveedores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEstadoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstadoProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbProveedores, txtCodigoProveedor});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        if (!isShowing()) {
            return;
        }

        resp = null;

        cbEstadosMedicamentos.setSelected(true);
        cbEstadosMedicamentosActionPerformed(null);

        String[] options = {"Crear Medicamento", "Crear Proveedor"};
        resp = JOptionPane.showInternalInputDialog(
                this,
                "Necesitará agregar un proveedor nuevo?",
                "Procedimiento de creacion de medicamento",
                JOptionPane.QUESTION_MESSAGE,
                frameIcon,
                options,
                "Crear Medicamento");

        if (resp == null) {
            return;
        }

        txtNombreMedicamentos.setText("");
        cbEstadoMedicamento.setSelected(false);
        cbEstadoMedicamentoActionPerformed(null);

        cbProveedores.setSelectedIndex(0);
        setDatosComboBox();

        if (resp.equals("Crear Medicamento")) {
            txtNombreMedicamentos.setEditable(true);
            txtNombreMedicamentos.requestFocus();

            JComboExp.miBoton.setVisible(true);

            cbEstadoMedicamento.setEnabled(true);

            jlFoto.setIcon(new ImageIcon(getClass().getResource("/imagenes/icons8-pill-180.png")));

            btnImagenBuscar.setEnabled(true);
        }

        if (resp.equals("Crear Proveedor")) {
            txtCodigoProveedor.setText("");
            txtCodigoProveedor.setEditable(true);

            cbEstadoProveedor.setEnabled(true);
            cbEstadoProveedor.setSelected(false);
            cbEstadoProveedorActionPerformed(null);

            cbProveedores.setSelectedIndex(-1);
            cbProveedores.setEditable(true);
            cbProveedores.requestFocus();
            JComboExp.miBoton.setVisible(false);
            JComboExp.miBoton.setEnabled(false);
        }
        //Funcion que habilita y deshabilita los botones de navegacion.
        navegador(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (!isShowing()) {
            return;
        }

        String[] options = {"Modificar Medicamento", "Modificar Proveedor"};
        resp = null;
        resp = JOptionPane.showInternalInputDialog(
                this,
                "Necesitará agregar un proveedor nuevo?",
                "Procedimiento de creacion de medicamento",
                JOptionPane.QUESTION_MESSAGE,
                frameIcon,
                options,
                "Modificar Medicamento");

        if (resp == null) {
            return;
        }

        if (resp.equals("Modificar Proveedor")) {
            cbProveedores.setEditable(true);
            cbProveedores.requestFocus();
            txtCodigoProveedor.setEditable(true);
            cbEstadoProveedor.setEnabled(true);
            JComboExp.miBoton.setVisible(false);
        }

        if (resp.equals("Modificar Medicamento")) {
            txtNombreMedicamentos.setEditable(true);
            txtNombreMedicamentos.requestFocus();

            btnImagenBuscar.setEnabled(true);

            cbEstadoMedicamento.setEnabled(true);
            JComboExp.miBoton.setVisible(true);
        }

        navegador(false);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (resp.toString().equals("Crear Proveedor")//Crear o Midificar Proveedor
                | resp.toString().equals("Modificar Proveedor")) {
            if (cbProveedores.getSelectedItem() == null) {
                JOptionPane.showInternalMessageDialog(this,
                        "Debe digitar el nombre del proveedor");
                cbProveedores.requestFocus();
                return;
            }

            if (txtCodigoProveedor.getText().isEmpty()) {
                JOptionPane.showInternalMessageDialog(this,
                        "Debe digitar el codigo del proveedor");
                txtCodigoProveedor.requestFocus();
                return;
            }

            if (!cbEstadoProveedor.isSelected()) {
                int resp = JOptionPane.showInternalConfirmDialog(this,
                        "Desea dejar proveedor Inactivo?",
                        "Validacion de proceso de registro de proveedor",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.NO_OPTION) {
                    cbEstadoProveedor.requestFocus();
                    return;
                }

            }

            if (resp.toString().equals("Crear Proveedor")) {
                //TODO 06/12/2024 Estos campos faltan
                /*
                cbProveedores.getSelectedItem().toString(),
                                        txtTelefono.getText(),
                                        cbEstadoProveedor.isSelected()
                 */
                JOptionPane.showInternalMessageDialog(
                        this,
                        M_Proveedor.insert(
                                Proveedor
                                        .builder()
                                        .id(WIDTH)
                                        .codigoProveedor(txtCodigoProveedor.getText())
                                        .build()
                        )
                );
            }

            if (resp.toString().equals("Modificar Proveedor")) {
                //TODO 06/12/2024 Estos campos faltan
                /*
                ,
                                        ,
                                        cbProveedores.getSelectedItem().toString(),
                                        txtTelefono.getText(),
                                        cbEstadoProveedor.isSelected()
                 */
                JOptionPane.showInternalMessageDialog(
                        this,
                        M_Proveedor.update(
                                Proveedor
                                        .builder()
                                        .id(((Proveedor) cbProveedores.getSelectedItem()).getId())
                                        .codigoProveedor(txtCodigoProveedor.getText())
                                        .build()
                        )
                );
            }

            llenarCombox();
        }//Crear o Modificar Proveedor

        if (resp.toString().equals("Crear Medicamento")//Crear o Modificar Medicamento
                || resp.toString().equals("Modificar Medicamento")) {

            if (txtNombreMedicamentos.getText().isEmpty()) { //Validando nombre de Medicamento
                JOptionPane.showInternalMessageDialog(this,
                        "Debe digitar el nombre del medicamento");
                txtNombreMedicamentos.requestFocus();
                return;
            }

            if (cbProveedores.getSelectedIndex() <= 0) {//Validando un proveedor Seleccionado
                JOptionPane.showInternalMessageDialog(this,
                        "Debe seleccionar un proveedor de la lista.");
                cbProveedores.requestFocus();
                cbProveedores.showPopup();
                return;
            }

            if (!cbEstadoMedicamento.isSelected()) {//Validando el estado del medicamento
                int resp = JOptionPane.showInternalConfirmDialog(this,
                        "Desea crear/modificar medicamento en estado Inactivo?",
                        "Proceso de validacion de medicamento",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.NO_OPTION) {
                    cbEstadoMedicamento.setSelected(true);
                }
            }

            if (fichero == null) {
                int resp = JOptionPane.showInternalConfirmDialog(this,
                        "Desea crear medicamento sin imagen",
                        "Proceso de validacion de medicamento",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (resp == JOptionPane.NO_OPTION) {
                    btnImagenBuscar.requestFocus();
                    return;
                }
            }

            if (resp.toString().equals("Crear Medicamento")) {
                String sql = "insert into T_MEDICAMENTOS (IDPROVEEDOR, "
                        + "DESCRIPCION, FOTO, ESTADO) "
                        + "values(?, '" + txtNombreMedicamentos.getText() + "',"
                        + " ?, " + cbEstadoMedicamento.isSelected() + ")";

                /*
                (guardarImagen(
                                fichero,
                                "" + ((Proveedor) cbProveedores.getSelectedItem()).getPersona().getId_persona(),
                                sql
                        ).equals("Foto Insertada")
                        ? "Medicamento Insertado" : "Error al Insertar Medicamento")
                 */
                JOptionPane.showInternalMessageDialog(
                        this,
                        "",
                        "",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

            if (resp.toString().equals("Modificar Medicamento")) {
                if (!cbEstadoProveedor.isSelected() & cbEstadoMedicamento.isSelected()) {
                    JOptionPane.showInternalMessageDialog(this,
                            "No puede ser modificado porque el proveedor esta inactivo");
                    return;
                }
                /*
                new Medicamentos(
                ((Proveedor) tblMedicamentos.getValueAt(tblMedicamentos.getSelectedRow(), 1)).getId(),
                ((Proveedor) cbProveedores.getSelectedItem()).getId(),
                txtNombreMedicamentos.getText(),
                fichero,
                null,
                cbEstadoMedicamento.isSelected(),
                null
                )
                 */
                Resultado resultado = M_Medicamento.update(
                        null
                );
                JOptionPane.showInternalMessageDialog(
                        this,
                        resultado.getMensaje(),
                        "",
                        resultado.getIcono()
                );
            }

            llenarTabla(cbEstadosMedicamentos.isSelected());
        }//Fin Crear o Modificar Imagenes

        btnCancelarActionPerformed(null);

        cbEstadosMedicamentos.setSelected(true);
        cbEstadosMedicamentosActionPerformed(null);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (!isShowing()) {
            return;
        }

        resp = null;
        navegador(true);

        cbEstadoMedicamento.setEnabled(false);
        txtNombreMedicamentos.setEditable(false);
        btnImagenBuscar.setEnabled(false);
        JComboExp.miBoton.setVisible(false);
        cbEstadoProveedor.setEnabled(false);
        txtCodigoProveedor.setEditable(false);
        cbProveedores.setEditable(false);

        setDatosComboBox();
        mostrarRegistro();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String preg = JOptionPane.showInternalInputDialog(this,
                "Puede buscar Codigo del provedor o Nombre Medicamento",
                "Buscando en la tabla",
                JOptionPane.PLAIN_MESSAGE);

        tblMedicamentos.setRowSelectionInterval(0, 0);

        for (int i = 0; i < tblMedicamentos.getRowCount(); i++) {
            if (tblMedicamentos.getValueAt(i, 2).toString().toLowerCase().
                    contains(preg.toLowerCase()) || tblMedicamentos.
                    getValueAt(i, 1).toString().toLowerCase().contains(
                    preg.toLowerCase())) {
                mostrarRegistro();
                break;
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblMedicamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMedicamentosMouseClicked
        if (resp != null) {
            return;
        }

        mostrarRegistro();
    }//GEN-LAST:event_tblMedicamentosMouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

        llenarCombox();
        llenarTabla(true);

        tblMedicamentos.setRowSelectionInterval(0, 0);
        JComboExp.miBoton.setVisible(false);
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtCodigoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProveedorActionPerformed
        int resp = JOptionPane.showInternalConfirmDialog(this,
                "Seguro que desea guardar el proveedor?",
                "Validacion de proveedor",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (resp == JOptionPane.NO_OPTION) {
            btnCancelarActionPerformed(null);
            return;
        }
        if (this.resp.equals("Crear Proveedor")) {
            btnGuardar.doClick();
        }

    }//GEN-LAST:event_txtCodigoProveedorActionPerformed

    private void cbProveedoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProveedoresItemStateChanged

    }//GEN-LAST:event_cbProveedoresItemStateChanged

    private void btnImagenBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenBuscarActionPerformed
        JFileChooser fc = new JFileChooser();

        fc.setFileFilter(
                new FileNameExtensionFilter(
                        "*.PNG, *.JPEG, *.JPG",
                        "png",
                        "jpeg",
                        "jpg"
                )
        );

        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int seleccion = fc.showDialog(this, "Tomar Imagen");

        if (seleccion == JFileChooser.CANCEL_OPTION) {
            return;
        }

        fichero = fc.getSelectedFile();

        if (!fichero.isFile()) {
            return;
        }

        BufferedImage image = new BufferedImage(0, 0, 0);

        try {
            image = ImageIO.read(fichero.getAbsoluteFile());
        } catch (IOException ex) {
            //Instalar Logger
        }

        jlFoto.setIcon(
                new javax.swing.ImageIcon(
                        image.getScaledInstance(180, 180, Image.SCALE_SMOOTH)
                )
        );
    }//GEN-LAST:event_btnImagenBuscarActionPerformed

    private void cbProveedoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbProveedoresMouseEntered
        if (resp == null) {

            cbProveedores.setEnabled(false);
        }
    }//GEN-LAST:event_cbProveedoresMouseEntered

    private void cbProveedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbProveedoresMouseExited
        if (resp == null) {

            cbProveedores.setEnabled(true);
        }
    }//GEN-LAST:event_cbProveedoresMouseExited

    private void cbEstadosMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadosMedicamentosActionPerformed
        if (!isShowing()) {
            return;
        }

        if (cbEstadosMedicamentos.isSelected()) {
            cbEstadosMedicamentos.setText("Activos");
        } else {
            cbEstadosMedicamentos.setText("Inactivos");
        }

        llenarCombox();
        llenarTabla(cbEstadosMedicamentos.isSelected());
    }//GEN-LAST:event_cbEstadosMedicamentosActionPerformed

    private void cbEstadoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoProveedorActionPerformed
        if (!isShowing()) {
            return;
        }

        if (cbEstadoProveedor.isSelected()) {
            cbEstadoProveedor.setText("Activo");
        } else {
            cbEstadoProveedor.setText("Inactivo");
        }
    }//GEN-LAST:event_cbEstadoProveedorActionPerformed

    private void cbEstadoMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoMedicamentoActionPerformed
        if (!isShowing()) {
            return;
        }

        if (cbEstadoMedicamento.isSelected()) {
            cbEstadoMedicamento.setText("Activo");
        } else {
            cbEstadoMedicamento.setText("Inactivo");
        }
    }//GEN-LAST:event_cbEstadoMedicamentoActionPerformed

    private void cbProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProveedoresActionPerformed
        if (!isShowing() | !btnGuardar.isEnabled()) {
            return;
        }

        setDatosComboBox();
    }//GEN-LAST:event_cbProveedoresActionPerformed

    public void centralizar() {

        setBounds((dpnEscritorio.getWidth() - this.getWidth()) / 2,
                (dpnEscritorio.getHeight() - this.getHeight()) / 2,
                720,
                500);
        pack();
        medicamentos.setVisible(true);
    }

    private void mostrarRegistro() {
        if (tblMedicamentos.getRowCount() == 0
                || tblMedicamentos.getSelectedRow() == -1) {
            return;
        }

        txtNombreMedicamentos.setText(
                tblMedicamentos.getValueAt(
                        tblMedicamentos.getSelectedRow(),
                        2
                ).toString()
        );

//        for (int i = 0; i < cbProveedores.getItemCount(); i++) {
//            if (
//                    ((Proveedor) cbProveedores.getItemAt(i)).getCodigo().equals(
//                    ((Proveedor) tblMedicamentos.getValueAt(tblMedicamentos.getSelectedRow(), 1)).getNombre())) {
//                cbProveedores.setSelectedIndex(i);
//                setDatosComboBox();
//                break;
//            }
//        }
        cbEstadoMedicamento.setSelected(
                tblMedicamentos.getValueAt(
                        tblMedicamentos.getSelectedRow(),
                        3
                ).toString().equals("Activo"));

//        SwingWorker<?, ?> w = new SwingWorker<>() {
//            @Override
//            protected Integer doInBackground() throws Exception {
//                jpbFoto.setVisible(true);
//                frmPrincipal.jpEstado.setVisible(true);
//                dpnEscritorio.setCursor(new Cursor(Cursor.WAIT_CURSOR));
//                publish(10);
//                if (!map.containsKey(((Proveedor) tblMedicamentos.getValueAt(
//                        tblMedicamentos.getSelectedRow(), 1)).getPersona().getId_persona())) {
//                    publish(12);

//                    img = getImagenes(
//                            "select FOTO "
//                            + "from T_Medicamentos "
//                            + "where idMedicamento = "
//                            + ((Proveedor) tblMedicamentos.getValueAt(tblMedicamentos.getSelectedRow(), 1)).getPersona().getId_persona());
//                    publish(37);
//
//                    if (img != null) {
//                        publish(40);
//                        map.put(((Proveedor) tblMedicamentos.getValueAt(
//                                tblMedicamentos.getSelectedRow(), 1)).getPersona().
//                                getId_persona(), img.getImage());
//                        publish(55);
//                        jlFoto.setIcon(new ImageIcon(
//                                map.get(((Proveedor) tblMedicamentos.getValueAt(
//                                        tblMedicamentos.getSelectedRow(), 1)).getPersona().
//                                        getId_persona()).
//                                        getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
//                        publish(90);
//                    } else {
//                        publish(80);
//                        jlFoto.setIcon(new ImageIcon(
//                                getClass().getResource("/imagenes/icons8-pill-180.png")));
//                        publish(90);
//                    }
//                } else {
//                    publish(40);
//
//                    jlFoto.setIcon(new ImageIcon(
//                            map.get(((Proveedor) tblMedicamentos.getValueAt(
//                                    tblMedicamentos.getSelectedRow(), 1)).getPersona().
//                                    getId_persona()).getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
//                    publish(83);
//                }
//                return 100;
//            }

//            @Override
//            protected void done() {
//                super.done();
//                jpbFoto.setVisible(false);
//                frmPrincipal.jpEstado.setVisible(false);
//                dpnEscritorio.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//            }
//
//            @Override
//            protected void process(List<Object> chunks) {
//                super.process(chunks);
//                jpbFoto.setValue((Integer) chunks.get(0));
//                frmPrincipal.jpbEstado.setValue((Integer) chunks.get(0));
//            }
//        };
//        w.execute();
    }

    private void llenarTabla(boolean estado) {
        tblMedicamentos.removeAll();
        String titulos[] = {
            "Nombre proveedor","Codigo proveedor", "Nombre medicamento", "Estado"
        };
        DefaultTableModel miTabla = new DefaultTableModel(null, titulos);
        Object registro[] = new Object[4];
        
//        ResultSet rs = getMedicamento(estado); los medicamentos se buscan por estado.

        M_Proveedor.select().stream().forEach(
                proveedor ->{
                    registro[0] = proveedor;
                    registro[1] = proveedor.getCodigoProveedor();
                    
//                    registro[2] = rs.getString("NombreMedicamento");
//                    registro[3] = (rs.getBoolean("Estado") ? "Activo" : "Inactivo");

                    miTabla.addRow(registro);
                }
        );        

        tblMedicamentos.setModel(miTabla);
//            if (tblMedicamentos.getRowCount() != 0) {
//                mostrarRegistro();
//                ordenarTabla();
//            }
    }

    private void navegador(boolean b) {
        btnNuevo.setEnabled(b);
        btnModificar.setEnabled(b);
        btnBuscar.setEnabled(b);
        tblMedicamentos.setEnabled(b);

        btnGuardar.setEnabled(!b);
        btnCancelar.setEnabled(!b);
    }

    private void llenarCombox() {
        cbProveedores.removeAllItems();

        //TODO 05.04.2025 Revisar si recivimos la persona generica.
        cbProveedores.addItem(
                Persona
                        .builder()
                        .idPersona(0)
                        .build()
        );

        M_Proveedor.select().stream().forEach(
                proveedor -> {
                    cbProveedores.addItem(
                            M_Persona.select(
                                    Persona
                                            .builder()
                                            .idPersona(proveedor.getId())
                                            .build()
                            ).getFirst()
                    );
                }
        );
    }

    private void setDatosComboBox() {
//        if (cbProveedores.getItemCount() == 0 || cbProveedores.getSelectedIndex() == -1) {
//            return;
//        }
//
//        txtCodigoProveedor.setText(
//                cbProveedores.getItemAt(
//                        cbProveedores.getSelectedIndex()
//                ).getIdPersona()
//        );
//        cbEstadoProveedor.setSelected(
//                cbProveedores.getItemAt(
//                        cbProveedores.getSelectedIndex()
//                ).getEstado()
//        );
//        if (btnGuardar.isEnabled()) {
//            txtNombreMedicamentos.requestFocus();
//        }
    }

    private void ordenarTabla() {
        tblMedicamentos.getColumn(tblMedicamentos.getColumnName(0)).setMinWidth(40);
        tblMedicamentos.getColumn(tblMedicamentos.getColumnName(0)).setMaxWidth(70);
        tblMedicamentos.getColumn(tblMedicamentos.getColumnName(0)).setPreferredWidth(50);

        tblMedicamentos.getColumn(tblMedicamentos.getColumnName(1)).setMinWidth(115);
        tblMedicamentos.getColumn(tblMedicamentos.getColumnName(1)).setMaxWidth(145);
        tblMedicamentos.getColumn(tblMedicamentos.getColumnName(1)).setPreferredWidth(135);

        tblMedicamentos.getColumn(tblMedicamentos.getColumnName(3)).setMinWidth(115);
        tblMedicamentos.getColumn(tblMedicamentos.getColumnName(3)).setMaxWidth(130);
        tblMedicamentos.getColumn(tblMedicamentos.getColumnName(3)).setPreferredWidth(120);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImagenBuscar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JCheckBox cbEstadoMedicamento;
    private javax.swing.JCheckBox cbEstadoProveedor;
    private javax.swing.JCheckBox cbEstadosMedicamentos;
    public static javax.swing.JComboBox<Persona> cbProveedores;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlFoto;
    private javax.swing.JPanel jpDetalles;
    private javax.swing.JProgressBar jpbFoto;
    private javax.swing.JTable tblMedicamentos;
    public static javax.swing.JTextField txtCodigoProveedor;
    public static javax.swing.JTextField txtNombreMedicamentos;
    // End of variables declaration//GEN-END:variables
}
