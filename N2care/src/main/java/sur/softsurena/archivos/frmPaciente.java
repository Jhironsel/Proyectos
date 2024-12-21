package sur.softsurena.archivos;

import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.event.TableModelEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.entidades.ARS;
import sur.softsurena.entidades.Asegurado;
import sur.softsurena.entidades.Categoria;
import sur.softsurena.entidades.Generales;
import sur.softsurena.entidades.Paciente;
import sur.softsurena.entidades.TipoSangre;
import sur.softsurena.formularios.frmDatosNacimiento;
import static sur.softsurena.formularios.frmPrincipal.dpnEscritorio;
import sur.softsurena.metodos.M_Generales;
import sur.softsurena.metodos.M_Paciente;
import static sur.softsurena.metodos.M_Paciente.existePaciente;
import sur.softsurena.metodos.M_TiposSangres;
import sur.softsurena.utilidades.FiltroBusqueda;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;
import utilidades.frmBuscarCedula;
import utilidades.frmBuscarCedulaSinDatos;
import utilidades.frmImagen;

public class frmPaciente extends javax.swing.JInternalFrame {

    private static frmPaciente paciente;
    private boolean nuevo;
    private final Map<Integer, Image> map;
    private ImageIcon img = null;

    public frmPaciente() {
        initComponents();
        this.map = new HashMap<>();
        tblPacientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jpbFoto.setVisible(false);
    }

    public synchronized static frmPaciente getPadres() {
        if (paciente == null) {
            paciente = new frmPaciente();
        }
        return paciente;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mCopiar = new javax.swing.JMenuItem();
        mPegar = new javax.swing.JMenuItem();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jpDetalles = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacientes = new javax.swing.JTable();
        cbEstadoTabla = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cbEstado = new javax.swing.JCheckBox();
        txtCedula = new javax.swing.JFormattedTextField();
        btnValidaCedulaPaciente = new javax.swing.JButton();
        cbSangre = new javax.swing.JComboBox<>();
        txtPNombre = new javax.swing.JTextField();
        txtSNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        cbSexo = new javax.swing.JComboBox<>();
        cbSeguro = new javax.swing.JComboBox();
        txtNoSeguro = new javax.swing.JFormattedTextField();
        txtCedulaMadre = new javax.swing.JFormattedTextField();
        btnBuscarMadre = new javax.swing.JButton();
        txtCedulaPadre = new javax.swing.JFormattedTextField();
        btnBuscarPadre = new javax.swing.JButton();
        btnAntecedentes = new javax.swing.JButton();
        btnDatosNacimiento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlFoto = new javax.swing.JLabel();
        jpbFoto = new javax.swing.JProgressBar();
        jlAgregarFoto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        mCopiar.setText("Copiar");
        mCopiar.setToolTipText("");
        mCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCopiarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mCopiar);

        mPegar.setText("Pegar");
        mPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mPegarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mPegar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento de Pacientes");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setNormalBounds(new java.awt.Rectangle(0, 0, 745, 0));
        setPreferredSize(new java.awt.Dimension(800, 600));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
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

        jpDetalles.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
        jpDetalles.setPreferredSize(new java.awt.Dimension(800, 421));

        tblPacientes.setAutoCreateRowSorter(true);
        tblPacientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPacientes.setMinimumSize(new java.awt.Dimension(400, 40));
        tblPacientes.setRowMargin(2);
        tblPacientes.setShowGrid(true);
        tblPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPacientes);

        javax.swing.GroupLayout jpDetallesLayout = new javax.swing.GroupLayout(jpDetalles);
        jpDetalles.setLayout(jpDetallesLayout);
        jpDetallesLayout.setHorizontalGroup(
            jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDetallesLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jpDetallesLayout.setVerticalGroup(
            jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

        cbEstadoTabla.setSelected(true);
        cbEstadoTabla.setText("Pacientes Activos");
        cbEstadoTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoTablaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbEstadoTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, 1039, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(cbEstadoTabla)
                .addGap(0, 0, 0)
                .addComponent(jpDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Registros", jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        cbEstado.setSelected(true);
        cbEstado.setText("Inactivo");
        cbEstado.setEnabled(false);
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });

        txtCedula.setEditable(false);
        try {
            txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula.setText("00000000000");
        txtCedula.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        txtCedula.setMinimumSize(new java.awt.Dimension(110, 27));
        txtCedula.setPreferredSize(new java.awt.Dimension(133, 27));
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        btnValidaCedulaPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-casilla-de-verificación-2-32.png"))); // NOI18N
        btnValidaCedulaPaciente.setEnabled(false);
        btnValidaCedulaPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidaCedulaPacienteActionPerformed(evt);
            }
        });

        cbSangre.setEnabled(false);
        cbSangre.setMaximumSize(new java.awt.Dimension(107, 27));
        cbSangre.setMinimumSize(new java.awt.Dimension(107, 27));
        cbSangre.setPreferredSize(new java.awt.Dimension(107, 27));
        cbSangre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSangreActionPerformed(evt);
            }
        });

        txtPNombre.setEditable(false);
        txtPNombre.setMaximumSize(new java.awt.Dimension(10, 27));
        txtPNombre.setPreferredSize(new java.awt.Dimension(205, 27));
        txtPNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPNombreActionPerformed(evt);
            }
        });

        txtSNombre.setEditable(false);
        txtSNombre.setMaximumSize(new java.awt.Dimension(10, 27));
        txtSNombre.setPreferredSize(new java.awt.Dimension(205, 27));
        txtSNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSNombreActionPerformed(evt);
            }
        });

        txtApellidos.setEditable(false);
        txtApellidos.setMaximumSize(new java.awt.Dimension(10, 27));
        txtApellidos.setPreferredSize(new java.awt.Dimension(205, 27));
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione  Sexo", "Masculino", "Femenino" }));
        cbSexo.setSelectedIndex(2);
        cbSexo.setEnabled(false);
        cbSexo.setMaximumSize(new java.awt.Dimension(107, 27));
        cbSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSexoActionPerformed(evt);
            }
        });

        cbSeguro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Autollena" }));
        cbSeguro.setEnabled(false);
        cbSeguro.setMaximumSize(new java.awt.Dimension(10, 27));
        cbSeguro.setMinimumSize(new java.awt.Dimension(10, 27));
        cbSeguro.setPreferredSize(new java.awt.Dimension(205, 27));
        cbSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSeguroActionPerformed(evt);
            }
        });

        txtNoSeguro.setEditable(false);
        try {
            txtNoSeguro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("********************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNoSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoSeguroActionPerformed(evt);
            }
        });

        txtCedulaMadre.setEditable(false);
        try {
            txtCedulaMadre.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedulaMadre.setText("00000000000");
        txtCedulaMadre.setComponentPopupMenu(jPopupMenu1);
        txtCedulaMadre.setMinimumSize(new java.awt.Dimension(110, 27));
        txtCedulaMadre.setPreferredSize(new java.awt.Dimension(133, 27));
        txtCedulaMadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaMadreActionPerformed(evt);
            }
        });

        btnBuscarMadre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Buscar3 32 x 32.png"))); // NOI18N
        btnBuscarMadre.setEnabled(false);
        btnBuscarMadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMadreActionPerformed(evt);
            }
        });

        txtCedulaPadre.setEditable(false);
        try {
            txtCedulaPadre.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedulaPadre.setText("00000000000");
        txtCedulaPadre.setMinimumSize(new java.awt.Dimension(110, 27));
        txtCedulaPadre.setPreferredSize(new java.awt.Dimension(133, 27));
        txtCedulaPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaPadreActionPerformed(evt);
            }
        });

        btnBuscarPadre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Buscar3 32 x 32.png"))); // NOI18N
        btnBuscarPadre.setEnabled(false);
        btnBuscarPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPadreActionPerformed(evt);
            }
        });

        btnAntecedentes.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnAntecedentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Salud32x32.png"))); // NOI18N
        btnAntecedentes.setToolTipText("Antecedentes del paciente");
        btnAntecedentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAntecedentesActionPerformed(evt);
            }
        });

        btnDatosNacimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nacido64x64.png"))); // NOI18N
        btnDatosNacimiento.setToolTipText("Datos de Nacimientos");
        btnDatosNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosNacimientoActionPerformed(evt);
            }
        });

        jLabel1.setText("Cedula");

        jLabel2.setText("Primer Nombre");

        jLabel3.setText("Apellidos");

        jLabel4.setText("Sexo");

        jLabel5.setText("Sangre");

        jLabel6.setText("Seguro");

        jLabel7.setText("<html><p>Cedula Madre </p></html> ");

        jLabel8.setText("<html><p>Cedula Padre</p></html> ");

        jLabel10.setText("Numero");

        jLabel9.setText("Segundo Nombre");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnValidaCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(cbSangre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnAntecedentes)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDatosNacimiento)
                                        .addGap(34, 34, 34))
                                    .addComponent(txtCedulaMadre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarMadre))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbSeguro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtCedulaPadre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnBuscarPadre))
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNoSeguro)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAntecedentes, btnDatosNacimiento});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbSeguro, cbSexo, jLabel2, jLabel3, jLabel4, jLabel6, jLabel9, txtApellidos, txtPNombre, txtSNombre});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbEstado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnValidaCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, 0)
                        .addComponent(cbSangre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(txtPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, 0)
                        .addComponent(txtSNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNoSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCedulaPadre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarPadre, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCedulaMadre, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(btnBuscarMadre))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDatosNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAntecedentes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbSangre, cbSexo});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAntecedentes, btnDatosNacimiento});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbSeguro, txtApellidos, txtNoSeguro, txtPNombre});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBuscarMadre, btnBuscarPadre, txtCedulaMadre, txtCedulaPadre});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbEstado, jLabel1});

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto Paciente"));

        jlFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nacido180x180.png"))); // NOI18N
        jlFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlFotoMouseClicked(evt);
            }
        });

        jpbFoto.setStringPainted(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpbFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jlAgregarFoto.setFont(new java.awt.Font("URW Palladio L", 1, 36)); // NOI18N
        jlAgregarFoto.setForeground(new java.awt.Color(0, 42, 255));
        jlAgregarFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAgregarFoto.setText("+");
        jlAgregarFoto.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jlAgregarFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlAgregarFotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlAgregarFoto))
                .addGap(0, 0, 0))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlAgregarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Campos", jPanel8);

        jScrollPane4.setViewportView(jTabbedPane1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles"));

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
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1031, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //Activamos el Flag de registro Nuevo        
        nuevo = true;
        navegador(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (((Generales) txtCedula.getValue()).getId() == 0) {
            JOptionPane.showInternalConfirmDialog(this,
                    "Paciente Generico no se puede modificar!!!",
                    "Validacion de proceso de modificacion",
                    JOptionPane.DEFAULT_OPTION);
            return;
        }
        nuevo = false;
        navegador(nuevo);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtCedula.getValue() == null) {
            JOptionPane.showInternalConfirmDialog(this,
                    "Digite cedula del paciente.",
                    "Proceso de validacion",
                    JOptionPane.DEFAULT_OPTION);
            txtCedula.requestFocus();
            return;
        }

        if (txtPNombre.getText().equals("")) {
            JOptionPane.showInternalConfirmDialog(this,
                    "Digite un Nombre.",
                    "Proceso de validacion",
                    JOptionPane.DEFAULT_OPTION);
            txtPNombre.requestFocus();
            return;
        }

        if (txtApellidos.getText().equals("")) {
            JOptionPane.showInternalConfirmDialog(this,
                    "Digite los Apellidos.",
                    "Proceso de validacion",
                    JOptionPane.DEFAULT_OPTION);
            txtApellidos.requestFocus();
            return;
        }

        if (cbSeguro.getSelectedIndex() == 0) {
            int resp = JOptionPane.showInternalConfirmDialog(this,
                    "Cuenta con Seguro?",
                    "Confirmacion de seguro!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                cbSeguro.requestFocus();
                cbSeguro.showPopup();
                return;
            }
        }

        if (cbSeguro.getSelectedIndex() != 0 && txtNoSeguro.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe de digitar el numero de seguro.!");
            txtNoSeguro.requestFocus();
            return;
        }

        if (!cbEstado.isSelected()) {
            int opc = JOptionPane.showInternalConfirmDialog(this,
                    "Desea dejar paciente inactivo",
                    "Proceso de validacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (opc == JOptionPane.NO_OPTION) {
                cbEstado.setSelected(true);
            }
        }

        // si es nuevo validamos que el Cliente no exista
        if (nuevo) {//Me parece que este caja de texto tendria problema cuando es un usuario nuevo
            if (existePaciente(
                    ((Persona) txtCedula.getValue()).getGenerales().getCedula()
            ).getEstado()) {
                JOptionPane.showInternalConfirmDialog(this,
                        "Cedula registrada en el sistema",
                        "Proceso de validacion",
                        JOptionPane.DEFAULT_OPTION);
                txtCedula.setValue(null);
                txtCedula.requestFocus();
                return;
            }
        } else if (!existePaciente(
                ((Persona) txtCedula.getValue()).getGenerales().getCedula()
        ).getEstado()) {
            JOptionPane.showInternalConfirmDialog(this,
                    "No puede modificar ese paciente con esa cedula",
                    "Proceso de validacion",
                    JOptionPane.DEFAULT_OPTION);

            txtCedula.requestFocus();
            txtCedula.setEditable(true);
            txtCedula.setValue(null);
            return;
        }
        //Revision de cumplimiento...

        int cedulaMadre, cedulaPadre;

        try {
            cedulaMadre = ((Persona) txtCedulaMadre.getValue()).getId_persona();

        } catch (Exception e) {
            cedulaMadre = 0;
        }

        try {
            cedulaPadre = ((Persona) txtCedulaPadre.getValue()).getId_persona();

        } catch (Exception e) {
            cedulaPadre = 0;
        }

        Generales g = Generales
                .builder()
                .cedula(txtCedula.getValue().toString())
                .tipoSangre((TipoSangre) cbSangre.getSelectedItem())
                .build();

        Asegurado a = Asegurado
                .builder()
                .id(((ARS) cbSeguro.getSelectedItem()).getId())
                .no_nss(txtNoSeguro.getValue().toString())
                .build();

        Paciente p = Paciente
                .builder()
                .persona(
                        Persona
                                .builder()
                                .id_persona(
                                        nuevo
                                                ? -1
                                                : ((Generales) txtCedula.getValue()).getPersona().getId_persona()
                                )
                                .pnombre(txtPNombre.getText())
                                .snombre(txtSNombre.getText())
                                .apellidos(txtApellidos.getText())
                                .sexo(cbSexo.getSelectedIndex() == 1 ? 'm' : 'f')
                                .generales(g)
                                .estado(cbEstado.isSelected())
                                .build()
                )
                .idMadre(cedulaMadre)
                .idPadre(cedulaPadre)
                .asegurado(a)
                .build();

        Resultado resultado = nuevo ? M_Paciente.insert(p) : M_Paciente.update(p);

        JOptionPane.showInternalConfirmDialog(
                this,
                resultado.getMensaje(),
                "",
                resultado.getIcono()
        );

        //Actualizamos los cambios en la Tabla
        llenarTabla();
        mostrarRegistro();

        btnCancelarActionPerformed(evt);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        nuevo = false;
        navegador(true);
        mostrarRegistro();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (tblPacientes.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe de seleccionar un registro de la tabla!!!",
                    "Proceso de validación",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int rta = JOptionPane.showConfirmDialog(
                this,
                """
                Los registros no pueden ser eliminado de la base de datos
                Ellos cambian de estado a Inactivo.
                Desea Continuar?
                """,
                "Proceso de eliminar paciente",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (rta == JOptionPane.NO_OPTION) {
            return;
        }

        JOptionPane.showInternalMessageDialog(this,
                borrarPaciente(((Categorias) txtCedula.getValue()).getDescripcion().trim()));
        //Actualizamos los cambios en la Tabla
        llenarTabla();
        mostrarRegistro();

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        frmBuscarCedulaSinDatos b = new frmBuscarCedulaSinDatos(null, true);
        b.setLocationRelativeTo(null);
        b.setVisible(true);
        String cliente = String.valueOf(b.txtCedula.getValue());

        if (cliente.isEmpty()) {
            int num = tblPacientes.getRowCount();
            for (int i = 0; i < num; i++) {
                if (cliente == null) {
                    break;
                }
                if (tblPacientes.getValueAt(i, 0).toString().contains(cliente)) {
                    break;
                }
                if (tblPacientes.getValueAt(i, 1).toString().contains(cliente)) {
                    break;
                }
                if (tblPacientes.getValueAt(i, 2).toString().contains(cliente)) {
                    break;
                }
                if (cliente.equals("")) {
                    break;
                }
                if (!existePaciente(cliente)) {
                    JOptionPane.showInternalConfirmDialog(this, "El Cliente No Existe");
                    break;
                }
            }
        }
        b.dispose();
        mostrarRegistro();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacientesMouseClicked
        if (!tblPacientes.isEnabled()) {
            return;
        }
        mostrarRegistro();
    }//GEN-LAST:event_tblPacientesMouseClicked

    private void mCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCopiarActionPerformed
        txtCedulaMadre.copy();
    }//GEN-LAST:event_mCopiarActionPerformed

    private void mPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mPegarActionPerformed
        txtCedulaMadre.paste();
    }//GEN-LAST:event_mPegarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        ordenarTabla();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnDatosNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosNacimientoActionPerformed
        if (txtCedula.getValue().equals("000-0000000-0")) {
            JOptionPane.showInternalMessageDialog(this,
                    "Este pacietne no permite esta accion");
            return;
        }

        frmDatosNacimiento n = new frmDatosNacimiento(null, true);

        n.txtCedula.setValue(
                txtCedula.getValue()
        );
        n.setLocationRelativeTo(null);
        n.setVisible(true);
    }//GEN-LAST:event_btnDatosNacimientoActionPerformed

    private void btnAntecedentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAntecedentesActionPerformed
        if (((Categorias) tblPacientes.getValueAt(tblPacientes.getSelectedRow(), 0)).getDescripcion().
                equals("000-0000000-0")) {
            JOptionPane.showInternalMessageDialog(this,
                    "No se permite antecedentes en genericos");
            return;
        }

        frmPacientesAntecedentes frm = new frmPacientesAntecedentes(null, true,
                ((Categorias) tblPacientes.getValueAt(tblPacientes.getSelectedRow(), 2)).getId());
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_btnAntecedentesActionPerformed

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        if (cbEstado.isSelected()) {
            cbEstado.setText("Activo");
        } else {
            cbEstado.setText("Inactivo");
        }
    }//GEN-LAST:event_cbEstadoActionPerformed

    private void cbEstadoTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoTablaActionPerformed

        if (cbEstadoTabla.isSelected()) {
            cbEstadoTabla.setText("Pacientes Activos");
        } else {
            cbEstadoTabla.setText("Pacientes Inactivos");
        }

        llenarTabla();
    }//GEN-LAST:event_cbEstadoTablaActionPerformed

    private void btnBuscarMadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMadreActionPerformed

        frmBuscarCedula b = new frmBuscarCedula(null, true, "f");
        b.setLocationRelativeTo(null);
        b.setVisible(true);
        txtCedulaMadre.setValue(b.txtCedula.getValue());
    }//GEN-LAST:event_btnBuscarMadreActionPerformed

    private void btnBuscarPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPadreActionPerformed

        frmBuscarCedula b = new frmBuscarCedula(null, true, "m");
        b.setLocationRelativeTo(null);
        b.setVisible(true);
        txtCedulaPadre.setValue(b.txtCedula.getValue());
    }//GEN-LAST:event_btnBuscarPadreActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed

        txtPNombre.requestFocus();
        Utilidades.showTooltip(txtPNombre);
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtPNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPNombreActionPerformed

        txtApellidos.requestFocus();
    }//GEN-LAST:event_txtPNombreActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        if (cbSeguro.isShowing() && btnGuardar.isEnabled()) {

            cbSeguro.requestFocus();
            cbSeguro.showPopup();
        }

    }//GEN-LAST:event_txtApellidosActionPerformed

    private void cbSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSeguroActionPerformed
        if (btnGuardar.isEnabled()) {

            txtNoSeguro.setValue(null);
            txtNoSeguro.requestFocus();
        }
    }//GEN-LAST:event_cbSeguroActionPerformed

    private void txtCedulaPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaPadreActionPerformed

        btnGuardar.requestFocus();
    }//GEN-LAST:event_txtCedulaPadreActionPerformed

    private void txtCedulaMadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaMadreActionPerformed

        txtCedulaPadre.requestFocus();
    }//GEN-LAST:event_txtCedulaMadreActionPerformed

    private void jlAgregarFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAgregarFotoMouseClicked
        int id = ((Categoria) txtCedula.getValue()).getId();

        if (id <= 0) {
            JOptionPane.showInternalMessageDialog(this,
                    "No se permite insertar foto al paciente generico");
            return;
        }

        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("*.PNG, *.JPEG, *.JPG", "png",
                "jpeg", "jpg"));
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int seleccion = fc.showDialog(this, "Tomar Imagen");

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getSelectedFile();

            guardarImagen(fichero,
                    ((Categorias) txtCedula.getValue()).getId() + "",
                    "update or insert into T_PACIENTES (IDPACIENTE, FOTO) "
                    + "values (?,?)");
        }
        map.remove(((Categorias) txtCedula.getValue()).getId());
        mostrarRegistro();
    }//GEN-LAST:event_jlAgregarFotoMouseClicked

    private void jlFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlFotoMouseClicked
        if (evt.getClickCount() == 2) {

            int id = ((Categorias) txtCedula.getValue()).getId();
            if (id <= 0) {
                JOptionPane.showInternalMessageDialog(this,
                        "Generico no contiene imagen");
                return;
            }//id, getDatos()
            frmImagen i = new frmImagen(null, true, new ImageIcon(
                    map.get(((Categorias) txtCedula.getValue()).getId())
                            .getScaledInstance(600, 600, Image.SCALE_SMOOTH)));
            i.setLocationRelativeTo(null);
            i.setVisible(true);
        }//Mostar la imagen mas grande 
    }//GEN-LAST:event_jlFotoMouseClicked

    private void txtNoSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoSeguroActionPerformed

        cbSexo.requestFocus();
    }//GEN-LAST:event_txtNoSeguroActionPerformed

    private void cbSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSexoActionPerformed
        if (btnGuardar.isEnabled()) {

            cbSangre.requestFocus();
        }
    }//GEN-LAST:event_cbSexoActionPerformed

    private void cbSangreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSangreActionPerformed
        if (btnGuardar.isEnabled()) {

            txtCedulaMadre.requestFocus();
        }
    }//GEN-LAST:event_cbSangreActionPerformed

    private void btnValidaCedulaPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidaCedulaPacienteActionPerformed
        txtCedulaActionPerformed(null);
    }//GEN-LAST:event_btnValidaCedulaPacienteActionPerformed

    private void txtSNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSNombreActionPerformed
        txtApellidos.requestFocus();
    }//GEN-LAST:event_txtSNombreActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAntecedentes;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarMadre;
    private javax.swing.JButton btnBuscarPadre;
    protected javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDatosNacimiento;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnValidaCedulaPaciente;
    private javax.swing.JCheckBox cbEstado;
    private javax.swing.JCheckBox cbEstadoTabla;
    private javax.swing.JComboBox<TipoSangre> cbSangre;
    private javax.swing.JComboBox cbSeguro;
    private javax.swing.JComboBox<String> cbSexo;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlAgregarFoto;
    private javax.swing.JLabel jlFoto;
    private javax.swing.JPanel jpDetalles;
    private javax.swing.JProgressBar jpbFoto;
    private javax.swing.JMenuItem mCopiar;
    private javax.swing.JMenuItem mPegar;
    private javax.swing.JTable tblPacientes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JFormattedTextField txtCedulaMadre;
    private javax.swing.JFormattedTextField txtCedulaPadre;
    private javax.swing.JFormattedTextField txtNoSeguro;
    private javax.swing.JTextField txtPNombre;
    private javax.swing.JTextField txtSNombre;
    // End of variables declaration//GEN-END:variables

    public synchronized void llenarTabla() {
        String titulos[] = {
            "<html><b>Madre</b></html>",
            "<html><b>Padre</b></html>",
            "<html><b>Cedula</b></html>",
            "<html><b>Nombres</b></html>",
            "<html><b>Apellidos</b></html>",
            "<html><b>Sexo</b></html>",
            "<html><b>Sangre</b></html>",
            "<html><b>Seguro</b></html>",
            "<html><b>Numero</b></html>",
            "<html><b>Estado</b></html>"};

        Object registro[] = new Object[10];
        tblPacientes.removeAll();

        List<Paciente> listaPaciente = M_Paciente.getList(
                FiltroBusqueda
                        .builder()
                        .estado(cbEstadoTabla.isSelected())
                        .build()
        );

        DefaultTableModel miTabla = new DefaultTableModel(null, titulos);

//        Persona madre = Persona.builder().
//                id_persona(rs.getInt("IDMADRE")).
//                pNombre(rs.getString("nombreMadre")).
//                cedula(rs.getString("CEDULAMADRE")).build();
//        registro[0] = madre;
//        Persona padre = Persona.builder().
//                id(rs.getInt("IDPADRE")).
//                nombres(rs.getString("nombrePadre")).
//                cedula(rs.getString("CEDULAPADRE")).build();
//
//        registro[1] = padre;
//                    registro[5] = rs.getString("IDARS").trim();
//                    registro[6] = rs.getString("NONSS").trim();
        listaPaciente.stream().forEach(
                paciente -> {
                    registro[0] = paciente;
                    registro[1] = paciente.getPersona().getSexo();
                    registro[2] = M_Generales.getEntidad(paciente.getPersona().getId_persona());
                    registro[3] = (paciente.getPersona().getEstado() ? "Activo" : "Inactivo");
                }
        );

        miTabla.addRow(registro);

        tblPacientes.setModel(miTabla);

        mostrarRegistro();
        ordenarTabla();

        //TODO 12/12/2024 Esto creo que se debe ejecutar una vez. 
        miTabla.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                System.out.println("Intentas actualizar. No es posible.");
            }
        });
    }

    private synchronized void mostrarRegistro() {
        try {
            if (tblPacientes.getRowCount() == 0) {
                limpiarCampo();
                return;
            }

            Persona madre = Persona.builder().
                    id(((Personas) tblPacientes.getValueAt(
                            tblPacientes.getSelectedRow(), 0)).getId()).
                    cedula(((Personas) tblPacientes.getValueAt(
                            tblPacientes.getSelectedRow(), 0)).getCedula()).
                    build();

            txtCedulaMadre.setValue(madre);

            Personas padre = Personas.builder().
                    id(((Personas) tblPacientes.getValueAt(
                            tblPacientes.getSelectedRow(), 1)).getId()).
                    cedula(((Personas) tblPacientes.getValueAt(
                            tblPacientes.getSelectedRow(), 1)).getCedula()).
                    build();

            txtCedulaPadre.setValue(padre);

            txtCedula.setValue(
                    tblPacientes.getValueAt(tblPacientes.getSelectedRow(), 2)
            );

            txtPNombre.setText(String.valueOf(tblPacientes.getValueAt(tblPacientes.getSelectedRow(), 3)));
            txtApellidos.setText(String.valueOf(tblPacientes.getValueAt(tblPacientes.getSelectedRow(), 4)));

            for (byte i = 0; i < cbSexo.getItemCount(); i++) {
                cbSexo.setSelectedIndex(i);
                if (String.valueOf(cbSexo.getSelectedItem()).equals(
                        tblPacientes.getValueAt(tblPacientes.getSelectedRow(), 5))) {
                    break;
                }
            }
            for (byte i = 0; i < cbSangre.getItemCount(); i++) {
                cbSangre.setSelectedIndex(i);
                if (((Categorias) cbSangre.getSelectedItem()).getDescripcion().equals(
                        tblPacientes.getValueAt(tblPacientes.getSelectedRow(), 6))) {
                    break;
                }
            }
            for (byte i = 0; i < cbSeguro.getItemCount(); i++) {
                cbSeguro.setSelectedIndex(i);
                if (((Categorias) cbSeguro.getSelectedItem()).getDescripcion().equals(
                        String.valueOf(tblPacientes.getValueAt(tblPacientes.getSelectedRow(), 7)))) {
                    break;
                }
            }

            txtNoSeguro.setValue(tblPacientes.getValueAt(tblPacientes.getSelectedRow(), 8));

            if (String.valueOf(tblPacientes.getValueAt(tblPacientes.getSelectedRow(), 9)).equals("Activo")) {
                cbEstado.setSelected(true);
                cbEstado.setText("Activo");
            } else {
                cbEstado.setSelected(false);
                cbEstado.setText("Inactivo");
            }
        } catch (Exception e) {
            System.err.println("Eror mostrando el registro" + e.getMessage());
        } finally {
            final SwingWorker<Integer, Integer> w = new SwingWorker() {
                @Override
                protected Integer doInBackground() throws Exception {
                    jpbFoto.setVisible(true);
                    if (!map.containsKey(((Categorias) txtCedula.getValue()).getId())) {
                        publish(10);
                        img = getImagenes("select FOTO "
                                + "from T_PACIENTES "
                                + "where idPaciente = "
                                + ((Categorias) txtCedula.getValue()).getId());
                        publish(40);
                        if (img != null) {
                            publish(53);
                            map.put((((Categorias) txtCedula.getValue()).getId()), img.getImage());
                            publish(78);
                            jlFoto.setIcon(new ImageIcon(
                                    map.get(((Categorias) txtCedula.getValue()).getId())
                                            .getScaledInstance(180, 180, Image.SCALE_DEFAULT)));
                            publish(82);
                        } else {
                            publish(79);
                            jlFoto.setIcon(new ImageIcon(
                                    getClass().getResource("/imagenes/nacido180x180.png")));
                            publish(95);
                        }
                    } else {
                        publish(60);
                        jlFoto.setIcon(new ImageIcon(
                                map.get(((Categorias) txtCedula.getValue()).getId())
                                        .getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
                        publish(84);
                    }
                    return 100;
                }

                @Override
                protected void done() {
                    super.done();
                    jpbFoto.setVisible(false);
                }

                @Override
                protected void process(List chunks) {
                    super.process(chunks);
                    jpbFoto.setValue((Integer) chunks.get(0));

                }

            };

            w.execute();

        }

        tblPacientes.setRowSelectionInterval(tblPacientes.getSelectedRow(),
                tblPacientes.getSelectedRow());
    }

    private void navegador(boolean valor) {
        //Botones Para Deshabilitar:
        btnNuevo.setEnabled(valor);
        btnModificar.setEnabled(valor);
        btnBorrar.setEnabled(valor);
        btnBuscar.setEnabled(valor);
        btnAntecedentes.setEnabled(valor);
        btnDatosNacimiento.setEnabled(valor);
        tblPacientes.setEnabled(valor);
        cbEstadoTabla.setEnabled(valor);

        //Botones Habilitado
        btnGuardar.setEnabled(!valor);
        btnCancelar.setEnabled(!valor);
        btnBuscarMadre.setEnabled(!valor);
        btnBuscarPadre.setEnabled(!valor);

        cbEstado.setEnabled(!valor);
        txtPNombre.setEditable(!valor);
        txtApellidos.setEditable(!valor);
        cbSeguro.setEnabled(!valor);
        txtNoSeguro.setEditable(!valor);
        cbSexo.setEnabled(!valor);
        cbSangre.setEnabled(!valor);

        ////
        txtCedula.setEditable(!valor);

        if (nuevo) {
            //Caja de Textos
            txtCedula.setEditable(!valor);
            //txt Vaciar
            limpiarCampo();
            txtCedula.grabFocus();
            txtCedula.requestFocus();
        }

    }

    private synchronized void limpiarCampo() {
        jlFoto.setIcon(new ImageIcon(
                getClass().getResource("/imagenes/nacido180x180.png"))
        );
        txtCedula.setValue(null);
        txtPNombre.setText("");
        txtApellidos.setText("");
        cbSeguro.setSelectedIndex(0);
        txtNoSeguro.setValue(null);
        txtCedulaMadre.setValue(null);
        txtCedulaPadre.setValue(null);
        cbSexo.setSelectedIndex(0);
        cbSangre.setSelectedIndex(0);
        cbEstado.setSelected(false);
        cbEstado.setText("Inactivo");
    }

    public void centralizar() {
        setBounds((dpnEscritorio.getWidth() - this.getWidth()) / 2,
                (dpnEscritorio.getHeight() - this.getHeight()) / 2,
                730,
                480);
        pack();
        paciente.setVisible(true);
    }

    public synchronized void llenarCombox() {
        List<TipoSangre> listaTipoSangre = M_TiposSangres.getList();
        cbSangre.removeAllItems();
        
        listaTipoSangre.stream().forEach(sangre -> {
            cbSangre.addItem(sangre);
        });
        

        M_Ti getTipoSeguro();
        cbSeguro.removeAllItems();
        try {
            while (obj.next()) {
                cbSeguro.addItem(new Categoria(obj.getShort("IDARS"), obj.getString("DESCRIPCION").trim()));
            }
        } catch (SQLException ex) {
            //Instalar Logger
        }
    }

    private void ordenarTabla() {
        //Cedula Madre
        tblPacientes.getColumn(tblPacientes.getColumnName(0)).setMinWidth(115);
        tblPacientes.getColumn(tblPacientes.getColumnName(0)).setMaxWidth(115);
        tblPacientes.getColumn(tblPacientes.getColumnName(0)).setPreferredWidth(115);
        //Cedula Padre
        tblPacientes.getColumn(tblPacientes.getColumnName(1)).setMinWidth(115);
        tblPacientes.getColumn(tblPacientes.getColumnName(1)).setMaxWidth(115);
        tblPacientes.getColumn(tblPacientes.getColumnName(1)).setPreferredWidth(115);
        //Cedula Paciente
        tblPacientes.getColumn(tblPacientes.getColumnName(2)).setMinWidth(115);
        tblPacientes.getColumn(tblPacientes.getColumnName(2)).setMaxWidth(125);
        tblPacientes.getColumn(tblPacientes.getColumnName(2)).setPreferredWidth(125);
        //Nombre Paciente
        tblPacientes.getColumn(tblPacientes.getColumnName(3)).setMinWidth(115);
        tblPacientes.getColumn(tblPacientes.getColumnName(3)).setMaxWidth(170);
        tblPacientes.getColumn(tblPacientes.getColumnName(3)).setPreferredWidth(150);
        //Apellidos Paciente
        tblPacientes.getColumn(tblPacientes.getColumnName(4)).setMinWidth(115);
        tblPacientes.getColumn(tblPacientes.getColumnName(4)).setMaxWidth(170);
        tblPacientes.getColumn(tblPacientes.getColumnName(4)).setPreferredWidth(150);
        //Sexo
        tblPacientes.getColumn(tblPacientes.getColumnName(5)).setMinWidth(80);
        tblPacientes.getColumn(tblPacientes.getColumnName(5)).setMaxWidth(80);
        tblPacientes.getColumn(tblPacientes.getColumnName(5)).setPreferredWidth(80);
        //Sangre
        tblPacientes.getColumn(tblPacientes.getColumnName(6)).setMinWidth(60);
        tblPacientes.getColumn(tblPacientes.getColumnName(6)).setMaxWidth(60);
        tblPacientes.getColumn(tblPacientes.getColumnName(6)).setPreferredWidth(60);
        //Seguro
        tblPacientes.getColumn(tblPacientes.getColumnName(7)).setMinWidth(80);
        tblPacientes.getColumn(tblPacientes.getColumnName(7)).setMaxWidth(100);
        tblPacientes.getColumn(tblPacientes.getColumnName(7)).setPreferredWidth(90);
        //NumeroSeguro
        tblPacientes.getColumn(tblPacientes.getColumnName(8)).setMinWidth(110);
        tblPacientes.getColumn(tblPacientes.getColumnName(8)).setMaxWidth(150);
        tblPacientes.getColumn(tblPacientes.getColumnName(8)).setPreferredWidth(140);
        //Estado
        tblPacientes.getColumn(tblPacientes.getColumnName(9)).setMinWidth(60);
        tblPacientes.getColumn(tblPacientes.getColumnName(9)).setMaxWidth(60);
        tblPacientes.getColumn(tblPacientes.getColumnName(9)).setPreferredWidth(60);
    }

}
