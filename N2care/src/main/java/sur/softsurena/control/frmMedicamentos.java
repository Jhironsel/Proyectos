package sur.softsurena.control;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import static sur.softsurena.datos.insert.InsertMetodos.*;
import static sur.softsurena.datos.select.SelectMetodos.*;
import static sur.softsurena.datos.update.UpdateMetodos.*;
import sur.softsurena.entidades.JComboExp;
import sur.softsurena.entidades.Medicamentos;
import sur.softsurena.entidades.Proveedores;
import sur.softsurena.formularios.frmPrincipal;
import static sur.softsurena.formularios.frmPrincipal.dpnEscritorio;

public class frmMedicamentos extends javax.swing.JInternalFrame {

    private static frmMedicamentos medicamentos;
    private int cliMedicamento;
    private int numeroMedicamentos;
    private Object resp;
    private File fichero;
    private final Map<Integer, Image> map;
    private ImageIcon img = null;
    private JComboExp miCombo;

    public frmMedicamentos() {
        
        initComponents();
        this.map = new HashMap<>();
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
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnPrimero = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
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
        jLabel2 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JFormattedTextField();
        cbProveedores = new javax.swing.JComboBox();
        cbEstadoProveedor = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();

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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto Medicamento"));

        jlFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-pill-180.png"))); // NOI18N
        jlFoto.setToolTipText("Imagen del medicamento seleccionado");

        jpbFoto.setStringPainted(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlFoto)
            .addComponent(jpbFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jlFoto)
                .addGap(0, 0, 0)
                .addComponent(jpbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles"));

        jPanel5.setLayout(new java.awt.GridLayout(1, 4, 4, 0));

        btnPrimero.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnPrimero.setForeground(new java.awt.Color(1, 1, 1));
        btnPrimero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Anterior 32 x 32.png"))); // NOI18N
        btnPrimero.setMnemonic('p');
        btnPrimero.setText("Primero");
        btnPrimero.setToolTipText("Va al Primer Registro");
        btnPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroActionPerformed(evt);
            }
        });
        jPanel5.add(btnPrimero);

        btnAnterior.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnAnterior.setForeground(new java.awt.Color(1, 1, 1));
        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Flecha Izquierda 32 x 32.png"))); // NOI18N
        btnAnterior.setMnemonic('a');
        btnAnterior.setText("Anterior");
        btnAnterior.setToolTipText("Va al Anterior Registro");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        jPanel5.add(btnAnterior);

        btnSiguiente.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(1, 1, 1));
        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Flecha Derecha 32 x 32.png"))); // NOI18N
        btnSiguiente.setMnemonic('s');
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setToolTipText("Va al Siguiente Registro");
        btnSiguiente.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanel5.add(btnSiguiente);

        btnUltimo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnUltimo.setForeground(new java.awt.Color(1, 1, 1));
        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Siguiente 32 x 32.png"))); // NOI18N
        btnUltimo.setMnemonic('u');
        btnUltimo.setText("Ultimo");
        btnUltimo.setToolTipText("Va al Ultimo Registro");
        btnUltimo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });
        jPanel5.add(btnUltimo);

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

        btnBuscar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(1, 1, 1));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Buscar3 32 x 32.png"))); // NOI18N
        btnBuscar.setMnemonic('r');
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Buscar el Registro");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel6.add(btnBuscar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jpDetalles.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de medicamentos"));

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
        tblMedicamentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblMedicamentosKeyReleased(evt);
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
            .addGroup(jpDetallesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbEstadosMedicamentos))
        );
        jpDetallesLayout.setVerticalGroup(
            jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDetallesLayout.createSequentialGroup()
                .addComponent(cbEstadosMedicamentos)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Medicamento"));

        cbEstadoMedicamento.setText("Inactivo");
        cbEstadoMedicamento.setEnabled(false);
        cbEstadoMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoMedicamentoActionPerformed(evt);
            }
        });

        txtNombreMedicamentos.setEditable(false);

        btnImagenBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-pill-32_Buscar.png"))); // NOI18N
        btnImagenBuscar.setText("Imagen");
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnImagenBuscar)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNombreMedicamentos, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap(364, Short.MAX_VALUE)
                            .addComponent(cbEstadoMedicamento))))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(cbEstadoMedicamento)
                .addGap(3, 3, 3)
                .addComponent(txtNombreMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImagenBuscar))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre del Proveedor"));

        txtCodigoProveedor.setEditable(false);
        txtCodigoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoProveedorActionPerformed(evt);
            }
        });

        jLabel2.setText("Codigo Proveedor");

        txtTelefono.setEditable(false);
        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###) ###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefono.setText("(000) 000-0000");
        txtTelefono.setToolTipText("Contacto con el proveedor del producto seleccionado");
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        cbProveedores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProveedoresItemStateChanged(evt);
            }
        });
        cbProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbProveedoresMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbProveedoresMouseEntered(evt);
            }
        });
        cbProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProveedoresActionPerformed(evt);
            }
        });

        cbEstadoProveedor.setText("Inactivo");
        cbEstadoProveedor.setEnabled(false);
        cbEstadoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoProveedorActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Telefono");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(cbEstadoProveedor))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstadoProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbEstadoProveedor, cbProveedores});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroActionPerformed
        if (!isShowing()) {
            return;
        }
        
        if (!tblMedicamentos.isEnabled()) {
            return;
        }
        cliMedicamento = 0;
        mostrarRegistro();
        btnPrimero.requestFocusInWindow();
    }//GEN-LAST:event_btnPrimeroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        if (!isShowing()) {
            return;
        }
        
        if (!tblMedicamentos.isEnabled()) {
            return;
        }
        cliMedicamento--;
        if (cliMedicamento == -1) {
            cliMedicamento = numeroMedicamentos - 1;
        }
        mostrarRegistro();
        if (evt != null) {
            btnAnterior.requestFocusInWindow();
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        if (!isShowing()) {
            return;
        }
        
        if (!tblMedicamentos.isEnabled()) {
            return;
        }
        cliMedicamento++;
        if (cliMedicamento == numeroMedicamentos) {
            cliMedicamento = 0;
        }
        mostrarRegistro();
        if (evt != null) {
            btnSiguiente.requestFocusInWindow();
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        if (!isShowing()) {
            return;
        }
        
        if (!tblMedicamentos.isEnabled()) {
            return;
        }
        cliMedicamento = numeroMedicamentos - 1;
        mostrarRegistro();
        btnUltimo.requestFocusInWindow();
    }//GEN-LAST:event_btnUltimoActionPerformed

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
            txtNombreMedicamentos.requestFocusInWindow();

            JComboExp.miBoton.setVisible(true);

            cbEstadoMedicamento.setEnabled(true);

            jlFoto.setIcon(new ImageIcon(getClass().getResource("/imagenes/icons8-pill-180.png")));

            btnImagenBuscar.setEnabled(true);
        }

        if (resp.equals("Crear Proveedor")) {
            txtTelefono.setValue(null);
            txtTelefono.setEditable(true);

            txtCodigoProveedor.setText("");
            txtCodigoProveedor.setEditable(true);

            cbEstadoProveedor.setEnabled(true);
            cbEstadoProveedor.setSelected(false);
            cbEstadoProveedorActionPerformed(null);

            cbProveedores.setSelectedIndex(-1);
            cbProveedores.setEditable(true);
            cbProveedores.requestFocusInWindow();
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
            cbProveedores.requestFocusInWindow();
            txtTelefono.setEditable(true);
            txtCodigoProveedor.setEditable(true);
            cbEstadoProveedor.setEnabled(true);
            JComboExp.miBoton.setVisible(false);
        }

        if (resp.equals("Modificar Medicamento")) {
            txtNombreMedicamentos.setEditable(true);
            txtNombreMedicamentos.requestFocusInWindow();

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
                cbProveedores.requestFocusInWindow();
                return;
            }

            if (txtTelefono.getValue() == null) {
                JOptionPane.showInternalMessageDialog(this,
                        "Debe digitar un telefono correctamnte");
                txtTelefono.setValue(null);
                txtTelefono.requestFocusInWindow();
                txtTelefono.setEditable(true);
                return;
            }

            if (txtCodigoProveedor.getText().isEmpty()) {
                JOptionPane.showInternalMessageDialog(this,
                        "Debe digitar el codigo del proveedor");
                txtCodigoProveedor.requestFocusInWindow();
                return;
            }

            if (!cbEstadoProveedor.isSelected()) {
                int resp = JOptionPane.showInternalConfirmDialog(this,
                        "Desea dejar proveedor Inactivo?",
                        "Validacion de proceso de registro de proveedor",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.NO_OPTION) {
                    cbEstadoProveedor.requestFocusInWindow();
                    return;
                }

            }

            if (resp.toString().equals("Crear Proveedor")) {
                JOptionPane.showInternalMessageDialog(this,
                        agregarProveedor(new Proveedores(0,
                                txtCodigoProveedor.getText(),
                                cbProveedores.getSelectedItem().toString(),
                                txtTelefono.getText(),
                                cbEstadoProveedor.isSelected())));
            }

            if (resp.toString().equals("Modificar Proveedor")) {
                JOptionPane.showInternalMessageDialog(this,
                        modificarProveedor(new Proveedores(
                                ((Proveedores) cbProveedores.getSelectedItem()).getId(),
                                txtCodigoProveedor.getText(),
                                cbProveedores.getSelectedItem().toString(),
                                txtTelefono.getText(),
                                cbEstadoProveedor.isSelected())));
            }

            llenarCombox();
        }//Crear o Modificar Proveedor

        if (resp.toString().equals("Crear Medicamento")//Crear o Modificar Medicamento
                || resp.toString().equals("Modificar Medicamento")) {

            if (txtNombreMedicamentos.getText().isEmpty()) { //Validando nombre de Medicamento
                JOptionPane.showInternalMessageDialog(this,
                        "Debe digitar el nombre del medicamento");
                txtNombreMedicamentos.requestFocusInWindow();
                return;
            }

            if (cbProveedores.getSelectedIndex() <= 0) {//Validando un proveedor Seleccionado
                JOptionPane.showInternalMessageDialog(this,
                        "Debe seleccionar un proveedor de la lista.");
                cbProveedores.requestFocusInWindow();
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
                    btnImagenBuscar.requestFocusInWindow();
                    return;
                }
            }

            if (resp.toString().equals("Crear Medicamento")) {
                String sql = "insert into T_MEDICAMENTOS (IDPROVEEDOR, "
                        + "DESCRIPCION, FOTO, ESTADO) "
                        + "values(?, '" + txtNombreMedicamentos.getText() + "',"
                        + " ?, " + cbEstadoMedicamento.isSelected() + ")";

                

                JOptionPane.showInternalMessageDialog(this,
                        (guardarImagen(fichero, "" + ((Proveedores) cbProveedores.getSelectedItem()).
                                getId(),
                                sql).equals("Foto Insertada")
                        ? "Medicamento Insertado" : "Error al Insertar Medicamento"),
                        "Proceso de insercion de Datos",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            if (resp.toString().equals("Modificar Medicamento")) {
                if (!cbEstadoProveedor.isSelected() & cbEstadoMedicamento.isSelected()) {
                    JOptionPane.showInternalMessageDialog(this,
                            "No puede ser modificado porque el proveedor esta inactivo");
                    return;
                }
                JOptionPane.showInternalMessageDialog(this,
                        modificarMedicamento(new Medicamentos(
                                ((Proveedores) tblMedicamentos.getValueAt(tblMedicamentos.getSelectedRow(), 1)).getId(),
                                ((Proveedores) cbProveedores.getSelectedItem()).getId(),
                                txtNombreMedicamentos.getText(),
                                fichero,
                                null,
                                cbEstadoMedicamento.isSelected(),
                                null)),
                        "Proceso de modificación de medicamentos",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            llenarTabla(cbEstadosMedicamentos.isSelected());
        }//Fin Crear o Modificar Imagenes

        map.remove(((Proveedores) tblMedicamentos.getValueAt(
                tblMedicamentos.getSelectedRow(), 1)).getId());
        map.clear();

        btnCancelarActionPerformed(null);

        cbEstadosMedicamentos.setSelected(true);
        cbEstadosMedicamentosActionPerformed(null);

        numeroMedicamentos = numeroMedicamentos(cbEstadosMedicamentos.isSelected());
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
        txtTelefono.setEditable(false);
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
                cliMedicamento = i;
                mostrarRegistro();
                break;
            }

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblMedicamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMedicamentosMouseClicked
        if (resp != null) {
            return;
        }
        
        cliMedicamento = tblMedicamentos.getSelectedRow();
        mostrarRegistro();
    }//GEN-LAST:event_tblMedicamentosMouseClicked

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        
        txtCodigoProveedor.requestFocusInWindow();
        if (btnGuardar.isEnabled() && resp.equals("Crear Proveedor")) {
            txtCodigoProveedor.setEditable(true);
            txtCodigoProveedor.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        
        llenarCombox();
        llenarTabla(true);
        numeroMedicamentos = numeroMedicamentos(cbEstadosMedicamentos.isSelected());
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
        fc.setFileFilter(new FileNameExtensionFilter("*.PNG, *.JPEG, *.JPG",
                "png", "jpeg", "jpg"));
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int seleccion = fc.showDialog(this, "Tomar Imagen");

        fichero = null;

        if (seleccion == JFileChooser.CANCEL_OPTION) {
            return;
        }

        fichero = fc.getSelectedFile();

        BufferedImage image = null;
        try {
            image = ImageIO.read(fichero.getAbsoluteFile());
        } catch (IOException ex) {
            //Instalar Logger
        }
        jlFoto.setIcon(new javax.swing.ImageIcon(image.
                getScaledInstance(180, 180, Image.SCALE_SMOOTH)));

        map.remove(((Proveedores) tblMedicamentos.getValueAt(cliMedicamento, 1))
                .getId());
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

        cliMedicamento = numeroMedicamentos = numeroMedicamentos(cbEstadosMedicamentos.isSelected());

        

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
        
        if (btnGuardar.isEnabled() & resp.equals("Crear Proveedor")) {
            txtTelefono.requestFocusInWindow();
            txtTelefono.setEditable(true);
        }
        setDatosComboBox();
    }//GEN-LAST:event_cbProveedoresActionPerformed

    private void tblMedicamentosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblMedicamentosKeyReleased
        if (evt.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
            btnSiguienteActionPerformed(null);
        }
        if (evt.getExtendedKeyCode() == KeyEvent.VK_UP) {
            btnAnteriorActionPerformed(null);
        }
    }//GEN-LAST:event_tblMedicamentosKeyReleased
    public void centralizar() {
        
        setBounds((dpnEscritorio.getWidth() - this.getWidth()) / 2,
                (dpnEscritorio.getHeight() - this.getHeight()) / 2,
                720,
                500);
        pack();
        medicamentos.setVisible(true);
    }
private void mostrarRegistro() {
        if (tblMedicamentos.getRowCount() == 0) {
            return;
        }

        

        tblMedicamentos.setRowSelectionInterval(cliMedicamento, cliMedicamento);

        txtNombreMedicamentos.setText(tblMedicamentos.getValueAt(cliMedicamento, 2).toString());

        for (int i = 0; i < cbProveedores.getItemCount(); i++) {
            if (((Proveedores) cbProveedores.getItemAt(i)).getCodigo().equals(
                    ((Proveedores) tblMedicamentos.getValueAt(cliMedicamento, 1)).getNombre())) {
                cbProveedores.setSelectedIndex(i);
                setDatosComboBox();
                break;
            }
        }

        cbEstadoMedicamento.setSelected(tblMedicamentos.getValueAt(cliMedicamento, 3).toString().equals("Activo"));

        SwingWorker<Integer, Integer> w = new SwingWorker() {
            @Override
            protected Integer doInBackground() throws Exception {
                jpbFoto.setVisible(true);
                frmPrincipal.jpEstado.setVisible(true);
                dpnEscritorio.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                publish(10);
                if (!map.containsKey(((Proveedores) tblMedicamentos.getValueAt(
                        cliMedicamento, 1)).getId())) {
                    publish(12);

                    img = getImagenes("select FOTO "
                            + "from T_Medicamentos "
                            + "where idMedicamento = "
                            + ((Proveedores) tblMedicamentos.getValueAt(cliMedicamento, 1)).getId());
                    
                    publish(37);
                    
                    if (img != null) {
                        publish(40);
                        map.put(((Proveedores) tblMedicamentos.getValueAt(
                                cliMedicamento, 1)).
                                getId(), img.getImage());
                        publish(55);
                        jlFoto.setIcon(new ImageIcon(
                                map.get(((Proveedores) tblMedicamentos.getValueAt(
                                        cliMedicamento, 1)).
                                        getId()).
                                        getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
                        publish(90);
                    } else {
                        publish(80);
                        jlFoto.setIcon(new ImageIcon(
                                getClass().getResource("/imagenes/icons8-pill-180.png")));
                        publish(90);
                    }
                } else {
                    publish(40);
                    
                    jlFoto.setIcon(new ImageIcon(
                            map.get(((Proveedores) tblMedicamentos.getValueAt(
                                    cliMedicamento, 1)).
                                    getId()).getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
                    publish(83);
                }
                return 100;
            }

            @Override
            protected void done() {
                super.done();
                jpbFoto.setVisible(false);
                frmPrincipal.jpEstado.setVisible(false);
                dpnEscritorio.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            protected void process(List chunks) {
                super.process(chunks);
                jpbFoto.setValue((Integer) chunks.get(0));
                frmPrincipal.jpbEstado.setValue((Integer) chunks.get(0));
            }
        };
        w.execute();
    }

    private void llenarTabla(boolean estado) {
        
        cliMedicamento = 0;
        tblMedicamentos.removeAll();
        String titulos[] = {"no.", "Codigo Proveedor", "Nombre Medicamento", "Estado"};
        Object registro[] = new Object[4];

        ResultSet rs = getMedicamento(estado);
        DefaultTableModel miTabla = new DefaultTableModel(null, titulos);
        int linea = 1;

        try {
            while (rs.next()) {
                registro[0] = linea;
                registro[1] = new Proveedores(rs.getInt("idMedicamento"),
                        rs.getString("Codigo_Proveedor"));
                registro[2] = rs.getString("NombreMedicamento");
                registro[3] = (rs.getBoolean("Estado") ? "Activo" : "Inactivo");
                miTabla.addRow(registro);
                linea++;
            }
            tblMedicamentos.setModel(miTabla);
        } catch (SQLException ex) {
            //Instalar Logger
        } finally {
            if (tblMedicamentos.getRowCount() != 0) {
                mostrarRegistro();
                ordenarTabla();
            }
        }
    }

    private void navegador(boolean b) {
        
        btnPrimero.setEnabled(b);
        btnAnterior.setEnabled(b);
        btnSiguiente.setEnabled(b);
        btnUltimo.setEnabled(b);
        btnNuevo.setEnabled(b);
        btnModificar.setEnabled(b);
        btnBuscar.setEnabled(b);
        tblMedicamentos.setEnabled(b);

        btnGuardar.setEnabled(!b);
        btnCancelar.setEnabled(!b);
    }

    private void llenarCombox() {
        
        cbProveedores.removeAllItems();
        ResultSet rs = getProveedor();
        cbProveedores.addItem(new Proveedores(
                0,
                "000000-0",
                "Seleccione una proveedor",
                "(000) 000-0000",
                false));
        try {
            while (rs.next()) {
                cbProveedores.addItem(new Proveedores(
                        rs.getInt("IDPROVEEDOR"),
                        rs.getString("CODIGO_PROVEEDOR"),
                        rs.getString("NOMBRE_PROVEEDOR"),
                        rs.getString("TELEFONO_PROVEEDOR"),
                        rs.getBoolean("ESTADO")));
            }
        } catch (SQLException ex) {
            //Instalar Logger
        } finally {
//            setDatosComboBox("Vengo de llenar tabla");
        }
    }

    private void setDatosComboBox() {
        if (cbProveedores.getItemCount() == 0 || cbProveedores.getSelectedIndex() == -1) {
            return;
        }

        

        txtTelefono.setValue(
                ((Proveedores) cbProveedores.getItemAt(
                        cbProveedores.getSelectedIndex())).getTelefono()
        );
        txtCodigoProveedor.setText(
                ((Proveedores) cbProveedores.getItemAt(
                        cbProveedores.getSelectedIndex())).getCodigo()
        );
        cbEstadoProveedor.setSelected(
                ((Proveedores) cbProveedores.getItemAt(cbProveedores.
                        getSelectedIndex())).isEstado()
        );
        if (btnGuardar.isEnabled()) {
            txtNombreMedicamentos.requestFocusInWindow();
        }
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
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImagenBuscar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JCheckBox cbEstadoMedicamento;
    private javax.swing.JCheckBox cbEstadoProveedor;
    private javax.swing.JCheckBox cbEstadosMedicamentos;
    public static javax.swing.JComboBox cbProveedores;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlFoto;
    private javax.swing.JPanel jpDetalles;
    private javax.swing.JProgressBar jpbFoto;
    private javax.swing.JTable tblMedicamentos;
    public static javax.swing.JTextField txtCodigoProveedor;
    public static javax.swing.JTextField txtNombreMedicamentos;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
