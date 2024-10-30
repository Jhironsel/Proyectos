package sur.softsurena.archivos;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import static sur.softsurena.datos.alter.AlterMetodos.borrarUsuario;
import static sur.softsurena.datos.select.SelectMetodos.*;
import sur.softsurena.entidades.Usuario;
import sur.softsurena.formularios.frmPerfiles;
import static sur.softsurena.formularios.frmPrincipal.dpnEscritorio;

public class frmUsuarios extends javax.swing.JInternalFrame {

    private static frmUsuarios usuario;
    private int cliUsuario = 0;
    private boolean nuevo;
    private String rolAnterior;
    private final Map<String, Image> map;
    private ImageIcon img = null;
    private int numeroUsuarios;

    public frmUsuarios() {
        
        this.map = new HashMap<>();
        initComponents();
        tblUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jpbFoto.setVisible(false);
    }

    public synchronized static frmUsuarios getUsuarios() {
        
        if (usuario == null) {
            usuario = new frmUsuarios();
        }
        return usuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpDetalles = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        cbEstadosUsuarios = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtClaveRepetir = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JFormattedTextField();
        txtClave = new javax.swing.JPasswordField();
        btnValidaLoginName = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jcbAdministrador = new javax.swing.JCheckBox();
        cbPerfil = new javax.swing.JComboBox();
        btnPerfiles = new javax.swing.JButton();
        jcbPrimerNombre = new javax.swing.JCheckBox();
        jcbDelegarRol = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        txtContacto = new javax.swing.JFormattedTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtContactos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtEspecialidad = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtExequatur = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jlFoto = new javax.swing.JLabel();
        jpbFoto = new javax.swing.JProgressBar();
        jlAgregarFoto1 = new javax.swing.JLabel();
        jlCreador3 = new javax.swing.JLabel();
        jlCreador1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        cbEstado = new javax.swing.JCheckBox();
        txtApellidos = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPNombre = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSNombre = new javax.swing.JFormattedTextField();
        jPanel13 = new javax.swing.JPanel();
        jrbMasculino = new javax.swing.JRadioButton();
        jrbFemenino = new javax.swing.JRadioButton();
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
        btnBorrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Mantenimiento de Usuarios");
        setToolTipText("Ventana principal del mantenimientos de los usuarios del sistema.");
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

        jpDetalles.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpDetalles.setToolTipText("Para el mantenimiento de los usuarios del sistema");

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        cbEstadosUsuarios.setSelected(true);
        cbEstadosUsuarios.setText("Usuarios Activos");
        cbEstadosUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadosUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpDetallesLayout = new javax.swing.GroupLayout(jpDetalles);
        jpDetalles.setLayout(jpDetallesLayout);
        jpDetallesLayout.setHorizontalGroup(
            jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jpDetallesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbEstadosUsuarios))
        );
        jpDetallesLayout.setVerticalGroup(
            jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDetallesLayout.createSequentialGroup()
                .addComponent(cbEstadosUsuarios)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registros", jpDetalles);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jTabbedPane2.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel5.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Clave:");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel6.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Repetir:");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        txtClaveRepetir.setToolTipText("Al salir, Mostrará un cuadro de dialogo preguntando otra vez por la clave.");
        txtClaveRepetir.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtClaveRepetirFocusGained(evt);
            }
        });
        txtClaveRepetir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveRepetirActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Login: ");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        try {
            txtUserName.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("********************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserNameFocusGained(evt);
            }
        });
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });

        txtClave.setToolTipText("Al salir, Mostrará un cuadro de dialogo preguntando otra vez por la clave.");
        txtClave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtClaveFocusGained(evt);
            }
        });
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });

        btnValidaLoginName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-casilla-de-verificación-2-32.png"))); // NOI18N
        btnValidaLoginName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidaLoginNameActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Roles: ");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jcbAdministrador.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jcbAdministrador.setText("Administrador");
        jcbAdministrador.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jcbAdministradorStateChanged(evt);
            }
        });
        jcbAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAdministradorActionPerformed(evt);
            }
        });

        cbPerfil.setFont(new java.awt.Font("FreeMono", 0, 14)); // NOI18N
        cbPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Perfil", "DOCTOR", "SECRETARIA" }));
        cbPerfil.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbPerfilPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        btnPerfiles.setText("...");
        btnPerfiles.setToolTipText("Administrador de Perfiles.");
        btnPerfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilesActionPerformed(evt);
            }
        });

        jcbPrimerNombre.setFont(new java.awt.Font("FreeSans", 0, 12)); // NOI18N
        jcbPrimerNombre.setText("Primer nombre");
        jcbPrimerNombre.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jcbPrimerNombreStateChanged(evt);
            }
        });

        jcbDelegarRol.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jcbDelegarRol.setText("Delegar Rol");
        jcbDelegarRol.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(210, 210, 210))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jcbPrimerNombre))
                                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtClave)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtClaveRepetir)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jcbAdministrador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcbDelegarRol))
                            .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPerfiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnValidaLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcbPrimerNombre))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUserName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClaveRepetir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnValidaLoginName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerfiles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbDelegarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(145, 145, 145))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel4, jLabel5, jLabel6});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnValidaLoginName, txtClave, txtClaveRepetir, txtUserName});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnPerfiles, cbPerfil});

        jTabbedPane2.addTab("Acceso", jPanel3);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jRadioButton3.setText("Redes sociales");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jRadioButton2.setText("Correo");

        try {
            txtContacto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###) ###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtContacto.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Teléfono");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contactos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 14))); // NOI18N
        jScrollPane2.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N

        jtContactos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tel / Email", "Contacto"
            }
        ));
        jScrollPane2.setViewportView(jtContactos);

        jButton1.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jButton1.setText("Agregar");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtContacto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContacto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, txtContacto});

        jTabbedPane2.addTab("Contactos", jPanel7);

        jLabel10.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Especialidad: ");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        try {
            txtEspecialidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("********************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtEspecialidad.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        txtEspecialidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEspecialidadFocusGained(evt);
            }
        });
        txtEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEspecialidadActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Exequátur:");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        try {
            txtExequatur.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("********************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtExequatur.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        txtExequatur.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtExequaturFocusGained(evt);
            }
        });
        txtExequatur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExequaturActionPerformed(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(" Foto "));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jlFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user180x180.png"))); // NOI18N

        jpbFoto.setStringPainted(true);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jpbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jlAgregarFoto1.setBackground(new java.awt.Color(11, 157, 235));
        jlAgregarFoto1.setFont(new java.awt.Font("URW Palladio L", 1, 36)); // NOI18N
        jlAgregarFoto1.setForeground(new java.awt.Color(1, 1, 1));
        jlAgregarFoto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAgregarFoto1.setText("+");
        jlAgregarFoto1.setOpaque(true);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlAgregarFoto1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlAgregarFoto1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jlCreador3.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jlCreador3.setText("Creador por: ");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCreador3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlCreador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtExequatur, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtEspecialidad)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 209, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(txtExequatur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlCreador3)
                        .addGap(0, 0, 0)
                        .addComponent(jlCreador1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );

        jTabbedPane2.addTab("Atributos especiales", jPanel12);

        cbEstado.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        cbEstado.setText("Inactivo");
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });

        try {
            txtApellidos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("****************************************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtApellidos.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        txtApellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellidosFocusGained(evt);
            }
        });
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Primer nombre:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        try {
            txtPNombre.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("****************************************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtPNombre.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        txtPNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPNombreFocusGained(evt);
            }
        });
        txtPNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPNombreActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Apellidos:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel8.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Segundo nombre:");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        try {
            txtSNombre.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("****************************************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtSNombre.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        txtSNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSNombreFocusGained(evt);
            }
        });
        txtSNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtApellidos)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                            .addComponent(txtSNombre))))
                .addGap(0, 0, 0))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(" Sexo "));

        buttonGroup2.add(jrbMasculino);
        jrbMasculino.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jrbMasculino.setText("Masculino");

        buttonGroup2.add(jrbFemenino);
        jrbFemenino.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jrbFemenino.setText("Femenino");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbMasculino)
                    .addComponent(jrbFemenino)))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrbMasculino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbFemenino)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel11, jPanel13});

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mantenimiento", jPanel8);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 14))); // NOI18N
        jPanel1.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N

        jPanel5.setLayout(new java.awt.GridLayout(1, 4, 4, 0));

        btnPrimero.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
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

        btnAnterior.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
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

        btnSiguiente.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
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

        btnUltimo.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
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

        btnNuevo.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
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

        btnModificar.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
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

        btnGuardar.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
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

        btnCancelar.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
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

        btnBorrar.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
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

        btnBuscar.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1)))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane4.setViewportView(jPanel14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane4)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroActionPerformed
        if (!isShowing()) {
            return;
        }
        
        if (!tblUsuarios.isEnabled()) {
            return;
        }
        cliUsuario = 0;
        mostrarRegistro();
        btnPrimero.requestFocusInWindow();
    }//GEN-LAST:event_btnPrimeroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        //Se está mostrando el jframe
        if (!isShowing()) {
            return;
        }
        
        //La tabla de usuario está habilitada.
        if (!tblUsuarios.isEnabled()) {
            return;
        }
        
        cliUsuario--;
        
        if (cliUsuario == -1) {
            cliUsuario = numeroUsuarios - 1;
        }
        mostrarRegistro();
        btnAnterior.requestFocusInWindow();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        if (!isShowing()) {
            return;
        }
        
        if (!tblUsuarios.isEnabled()) {
            return;
        }
        cliUsuario++;
        if (cliUsuario == numeroUsuarios) {
            cliUsuario = 0;
        }
        mostrarRegistro();
        btnSiguiente.requestFocusInWindow();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        if (!isShowing()) {
            return;
        }
        
        if (!tblUsuarios.isEnabled()) {
            return;
        }
        cliUsuario = numeroUsuarios - 1;
        mostrarRegistro();
        btnUltimo.requestFocusInWindow();
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        if (!isShowing()) {
            return;
        }
        
        //Activamos el Flag de registro Nuevo
        nuevo = true;
        cbEstadosUsuarios.setSelected(true);
        cbEstadosUsuariosActionPerformed(null);
        navegador(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (!isShowing()) {
            return;
        }
        
        if (txtUserName.getText().trim().isEmpty()
                || tblUsuarios.getRowCount() == 0) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe contener un registro",
                    "Ventana de validacion",
                    JOptionPane.DEFAULT_OPTION);
            return;
        }
        
        rolAnterior = ((String) cbPerfil.getSelectedItem()).trim();

        nuevo = false;
        
        //Botones Para Deshabilitar:
        navegador(false);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!isShowing()) {
            return;
        }
        
        if (txtPNombre.getText().trim().equals("")) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe Digitar un Nombre...",
                    "Ventana de validacion",
                    JOptionPane.DEFAULT_OPTION);
            txtPNombre.requestFocusInWindow();
            return;
        }
        if (txtApellidos.getText().trim().equals("")) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe Digitar Apellidos...",
                    "Ventana de validacion",
                    JOptionPane.DEFAULT_OPTION);
            txtApellidos.requestFocusInWindow();
            return;
        }
        if (txtUserName.getText().trim().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe Digitar Login del Usuario...",
                    "Ventana de validacion",
                    JOptionPane.DEFAULT_OPTION);
            txtUserName.requestFocusInWindow();
            return;
        }
        if (cbPerfil.getSelectedIndex() == 0) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe seleccionar un Perfil!",
                    "Ventana de validacion",
                    JOptionPane.DEFAULT_OPTION);
            cbPerfil.requestFocusInWindow();
            return;
        }
        
        if (!cbEstado.isSelected()) {
            int opc = JOptionPane.showInternalConfirmDialog(this,
                    "Dejara el usuario Inactivo",
                    "Ventana de validacion",
                    JOptionPane.YES_NO_OPTION);
            if (opc == JOptionPane.NO_OPTION) {
                cbEstado.setSelected(true);
                btnGuardar.requestFocusInWindow();
                return;
            }
        }

        if (txtClave.getPassword().length != 0
                || txtClaveRepetir.getPassword().length != 0
                || !nuevo) {
            if (txtClave.getPassword().length == 0) {
                JOptionPane.showInternalMessageDialog(this,
                        "Debe Digitar la Clave del usuario...",
                        "Ventana de validacion",
                        JOptionPane.DEFAULT_OPTION);
                txtClave.requestFocusInWindow();
                return;
            }

            if (txtClaveRepetir.getPassword().length == 0) {
                JOptionPane.showInternalMessageDialog(this,
                        "Debe Digitar la Clave del usuario...",
                        "Verifique la clave, por favor!",
                        JOptionPane.DEFAULT_OPTION);
                txtClaveRepetir.requestFocusInWindow();
                return;
            }

            if (!(new String(txtClave.getPassword()).equals(
                    new String(txtClaveRepetir.getPassword())))) {
                JOptionPane.showInternalMessageDialog(this,
                        "Las claves no coinciden!!",
                        "Ventana de validacion",
                        JOptionPane.DEFAULT_OPTION);
                txtClave.setText("");
                txtClaveRepetir.setText("");
                txtClave.requestFocusInWindow();
                return;
            }
        }

        if (txtSNombre.getText().isEmpty() || txtSNombre.getText() == null) {
            txtSNombre.setText("-");
        }

        Usuario u = Usuario.builder().
                userName(txtUserName.getText().trim().toUpperCase()).
                clave(new String(txtClaveRepetir.getPassword()).trim()).
                administrador(jcbAdministrador.isSelected()).
                especialidad(txtEspecialidad.getText().trim()).
                cod_Exequatur(txtExequatur.getText().trim()).
                pNombre(txtPNombre.getText().trim()).
                sNombre(txtSNombre.getText().trim()).
                apellidos(txtApellidos.getText().trim()).
                estado(cbEstado.isSelected()).build();
        
        //(String) cbPerfil.getSelectedItem()).trim()
                
        
        if (nuevo) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    agregarUsuario(u),
                    "Resultado de la Operacion",
                    JOptionPane.DEFAULT_OPTION);
        } else {
            JOptionPane.showInternalMessageDialog(
                    this,
                    modificarUsuario(u, rolAnterior),
                    "Resultado de la Operacion",
                    JOptionPane.DEFAULT_OPTION);
        }
        //El valor true es utilizado para indicar que se necesitan usuarios 
        //activos
        llenarTabla(true, "1) Boton Guardar");
        btnCancelarActionPerformed(null);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (!isShowing()) {
            return;
        }
        nuevo = false;
        navegador(true);
        txtClave.setText("");
        txtClaveRepetir.setText("");
        btnPrimeroActionPerformed(null);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        
        if (tblUsuarios.getRowCount() <= 0) {
            JOptionPane.showInternalMessageDialog(this,
                    "No existe informacion en la tabla, Agregue Usuarios",
                    "Ventana de validacion",
                    JOptionPane.DEFAULT_OPTION);
            return;
        }

        int opc = JOptionPane.showInternalConfirmDialog(this,
                "Desea borrar el usuario " + txtUserName.getText().trim().toUpperCase()
                + " del sistema!!",
                "Confirmacion del sistema.",
                JOptionPane.YES_NO_OPTION);
        if (opc == JOptionPane.YES_OPTION) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    borrarUsuario(txtUserName.getText().trim().toUpperCase(), false),
                    "Operacion de eliminacion",
                    JOptionPane.DEFAULT_OPTION);
        }
        
        
        llenarTabla(cbEstadosUsuarios.isSelected(),
                "btnBorrar hemos borrado el usuario, Numero de Usuario actual: "
                + numeroUsuarios);
        
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        if (tblUsuarios.getRowCount() <= 0) {
            JOptionPane.showInternalMessageDialog(this,
                    "No existe informacion en la tabla, Agregue Usuarios",
                    "Ventana de validacion",
                    JOptionPane.DEFAULT_OPTION);
            return;
        }
        String cliente = JOptionPane.showInternalInputDialog(this,
                "Ingrese Nombre, Apellido o Login del usuario",
                "Busqueda de informacion", JOptionPane.INFORMATION_MESSAGE);
        if (cliente == null || cliente.equals("") || cliente.equals("null")) {
            return;
        }

        int num = tblUsuarios.getRowCount();
        for (int i = 0; i < num; i++) {
            if (tblUsuarios.getValueAt(i, 0).toString().equalsIgnoreCase(cliente)) {
                cliUsuario = i;
                break;
            }
            if (tblUsuarios.getValueAt(i, 1).toString().contains(cliente)) {
                cliUsuario = i;
                break;
            }
            if (tblUsuarios.getValueAt(i, 2).toString().contains(cliente)) {
                cliUsuario = i;
                break;
            }
            if (cliente.equals("")) {
                return;
            }
        }
        mostrarRegistro();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        
    }//GEN-LAST:event_formInternalFrameOpened

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        if (!tblUsuarios.isEnabled()) {
            return;
        }
        cliUsuario = tblUsuarios.getSelectedRow();
        mostrarRegistro();
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void btnPerfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilesActionPerformed
        if (cbPerfil.getSelectedIndex() == 0 || !cbPerfil.isEnabled()) {
            return;
        }
        frmPerfiles p = new frmPerfiles(null, true,
                ((String) cbPerfil.getSelectedItem()).trim());
        p.setLocationRelativeTo(null);
        p.setVisible(true);
        formInternalFrameOpened(null);
    }//GEN-LAST:event_btnPerfilesActionPerformed

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        if (btnGuardar.isEnabled()) {
            btnGuardar.requestFocusInWindow();
        }
    }//GEN-LAST:event_cbEstadoActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        if (btnGuardar.isEnabled()) {
            txtClaveRepetir.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtClaveActionPerformed

    private void txtClaveRepetirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveRepetirActionPerformed
        
    }//GEN-LAST:event_txtClaveRepetirActionPerformed

    private void cbEstadosUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadosUsuariosActionPerformed
        if (!isShowing()) {
            return;
        }
        if (cbEstadosUsuarios.isSelected()) {
            cbEstadosUsuarios.setText("Usuarios Activos");
            llenarTabla(true, "Si cbEstadosUsuario esta Activo");
        } else {
            cbEstadosUsuarios.setText("Usuarios Inactivos");
            llenarTabla(false, "Si cbEstadosUsuario no esta Activo");
        }
    }//GEN-LAST:event_cbEstadosUsuariosActionPerformed

    private void jcbAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAdministradorActionPerformed
        if (btnGuardar.isEnabled()) {
            btnGuardar.requestFocusInWindow();
        }
    }//GEN-LAST:event_jcbAdministradorActionPerformed

    private void cbPerfilPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbPerfilPopupMenuWillBecomeInvisible
        if (btnGuardar.isEnabled()) {
            
            txtExequatur.setValue(null);
            txtExequatur.requestFocusInWindow();
        }
    }//GEN-LAST:event_cbPerfilPopupMenuWillBecomeInvisible

    private void txtExequaturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExequaturActionPerformed
        if (btnGuardar.isEnabled()) {
            txtUserName.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtExequaturActionPerformed

    private void txtPNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPNombreActionPerformed
        if (btnGuardar.isEnabled()) {
            txtSNombre.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtPNombreActionPerformed

    private void txtSNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSNombreActionPerformed
        if (btnGuardar.isEnabled()) {
            txtApellidos.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtSNombreActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        if (btnGuardar.isEnabled()) {
            txtEspecialidad.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEspecialidadActionPerformed
        if (btnGuardar.isEnabled()) {
            cbPerfil.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtEspecialidadActionPerformed

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void btnValidaLoginNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidaLoginNameActionPerformed
        if (btnGuardar.isEnabled() && nuevo) {
            if (txtUserName.getText().isEmpty()) {
                JOptionPane.showInternalMessageDialog(this, "Debe ingresar Login Name del usuario!");
                return;
            }

            for (int i = 0; i < tblUsuarios.getRowCount(); i++) {
                if (txtUserName.getText().equalsIgnoreCase(
                        (String) tblUsuarios.getValueAt(i, 0))) {

                    int resp = JOptionPane.showInternalConfirmDialog(this,
                            "Usuario ya esta registrado!!!\nDesea cargar los datos de la tabla",
                            "Confirmacion de Usuario",
                            JOptionPane.DEFAULT_OPTION);

                    if (resp == JOptionPane.NO_OPTION) {
                        txtUserName.requestFocusInWindow();
                        txtUserName.setSelectionStart(0);
                        txtUserName.setSelectionEnd(txtUserName.getText().length());
                        return;
                    }
                }
            }

            if (existeUsuario(txtUserName.getText().trim().toUpperCase())) {

                int opc = JOptionPane.showInternalConfirmDialog(this,
                        "-Usuario ya esta registrado!!! "
                        + "\n--Se Encuentra Inactivo."
                        + "\n---Desea activarlo",
                        "Confirmacion de Usuario",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);

                if (opc == JOptionPane.YES_OPTION) {
                    borrarUsuario(txtUserName.getText().trim().toUpperCase(), true);
                } else {
                    txtUserName.requestFocusInWindow();
                    txtUserName.setSelectionStart(0);
                    txtUserName.setSelectionEnd(txtUserName.getText().length());
                    return;
                }
            }
        }
    }//GEN-LAST:event_btnValidaLoginNameActionPerformed

    private void txtUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusGained
        if (btnGuardar.isEnabled()) {
            txtUserName.setText("");
        }

    }//GEN-LAST:event_txtUserNameFocusGained

    private void txtExequaturFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtExequaturFocusGained
        if (btnGuardar.isEnabled()) {
            txtExequatur.setText("");
        }
    }//GEN-LAST:event_txtExequaturFocusGained

    private void txtPNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPNombreFocusGained
        if (btnGuardar.isEnabled()) {
            txtPNombre.setText("");
        }
    }//GEN-LAST:event_txtPNombreFocusGained

    private void txtSNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSNombreFocusGained
        if (btnGuardar.isEnabled()) {
            txtSNombre.setText("");
        }
    }//GEN-LAST:event_txtSNombreFocusGained

    private void txtApellidosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidosFocusGained
        if (btnGuardar.isEnabled()) {
            txtApellidos.setText("");
        }
    }//GEN-LAST:event_txtApellidosFocusGained

    private void txtEspecialidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEspecialidadFocusGained
        if (btnGuardar.isEnabled()) {
            txtEspecialidad.setText("");
        }
    }//GEN-LAST:event_txtEspecialidadFocusGained

    private void txtClaveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClaveFocusGained
        if (btnGuardar.isEnabled()) {
            txtClave.setText("");
        }
    }//GEN-LAST:event_txtClaveFocusGained

    private void txtClaveRepetirFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClaveRepetirFocusGained
        if (btnGuardar.isEnabled()) {
            txtClaveRepetir.setText("");
        }
    }//GEN-LAST:event_txtClaveRepetirFocusGained

    private void jcbPrimerNombreStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jcbPrimerNombreStateChanged

    }//GEN-LAST:event_jcbPrimerNombreStateChanged

    private void jcbAdministradorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jcbAdministradorStateChanged
        jcbDelegarRol.setEnabled(jcbAdministrador.isSelected());
    }//GEN-LAST:event_jcbAdministradorStateChanged

    private synchronized void mostrarRegistro() {
        try {
            if (tblUsuarios.getRowCount() == 0) {
                limpiarCampo();
                return;
            }
            txtUserName.setText(String.valueOf(tblUsuarios.getValueAt(cliUsuario, 0)).trim());
            txtPNombre.setText(String.valueOf(tblUsuarios.getValueAt(cliUsuario, 1)).trim());
            txtSNombre.setText(String.valueOf(tblUsuarios.getValueAt(cliUsuario, 2)).trim());
            txtApellidos.setText(String.valueOf(tblUsuarios.getValueAt(cliUsuario, 3)).trim());

            txtEspecialidad.setText(String.valueOf(tblUsuarios.getValueAt(cliUsuario, 7)).trim());

            for (int i = 1; i < cbPerfil.getItemCount(); i++) {
                cbPerfil.setSelectedIndex(i);
                if (((String) cbPerfil.getSelectedItem()).equals(
                        (String) tblUsuarios.getValueAt(cliUsuario, 8))) {
                    break;
                }
            }
            txtExequatur.setText(String.valueOf(tblUsuarios.getValueAt(cliUsuario, 9)).trim());
            jcbAdministrador.setSelected(((String) tblUsuarios.getValueAt(cliUsuario, 10)).equals("Activo"));
            cbEstado.setSelected(((String) tblUsuarios.getValueAt(cliUsuario, 11)).equals("Activo"));
            tblUsuarios.setRowSelectionInterval(cliUsuario, cliUsuario);
        } catch (Exception e) {
            System.err.println("Eror mostrando el registro" + e.getMessage());
            e.printStackTrace();
        } finally {
            //Segundo hilo para que busque la foto.
            final SwingWorker<Integer, Integer> w = new SwingWorker() {
                @Override
                protected Integer doInBackground() throws Exception {
                    jpbFoto.setVisible(true);
                    if (!map.containsKey(txtUserName.getText().trim().toUpperCase())) {
                        publish(10);
                        img = getImagenes("select FOTO "
                                + "from T_FOTO_USUARIO "
                                + "where TRIM(idUsuario) = '"
                                + txtUserName.getText().trim().toUpperCase() + "';");
                        publish(40);
                        if (img != null) {
                            publish(53);
                            map.put(txtUserName.getText().trim().toUpperCase(), img.getImage());
                            publish(78);
                            jlFoto.setIcon(new ImageIcon(
                                    map.get(txtUserName.getText().trim().toUpperCase())
                                            .getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
                            publish(82);
                        } else {
                            publish(79);
                            jlFoto.setIcon(new ImageIcon(
                                    getClass().getResource("/imagenes/user180x180.png")));
                            publish(95);
                        }
                    } else {
                        publish(60);
                        jlFoto.setIcon(new ImageIcon(
                                map.get(txtUserName.getText().trim().toUpperCase())
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
    }

    public synchronized void llenarTabla(boolean estado, String d) {
        
        cliUsuario = 0;
        numeroUsuarios = 0;
        tblUsuarios.removeAll();
        String titulos[] = {"Usuarios", "Primer Nombres", "Segundo Nombres",
            "Apellidos", "Movil", "Telefono", "Correo", "Especialidad", "Rol del sistema",
            "Exequátur", "Super Usuario", "Estado"};
        Object registro[] = new Object[12];
        ResultSet rs = getUsuario(estado);
        DefaultTableModel miTabla = new DefaultTableModel(null, titulos);
        try {
            while (rs.next()) {
                registro[0] = rs.getString("LOGINUSER").trim();
                registro[1] = rs.getString("P_NOMBRE").trim();
                registro[2] = rs.getString("S_NOMBRE").trim();
                registro[3] = rs.getString("APELLIDOS").trim();
                registro[4] = rs.getString("Movil").trim();
                registro[5] = rs.getString("TELEFONO").trim();
                registro[6] = rs.getString("Correo").trim();
                registro[7] = rs.getString("Especialidad").trim();
                registro[8] = rs.getString("ROL").trim();
                registro[9] = rs.getString("SQ").trim();
                registro[10] = (rs.getBoolean("SuperUsuario") ? "Activo" : "Inactivo");
                registro[11] = (rs.getBoolean("ESTADO") ? "Activo" : "Inactivo");
                miTabla.addRow(registro);
                numeroUsuarios++;
            }
            tblUsuarios.setModel(miTabla);
        } catch (SQLException ex) {
            //Instalar Logger
        } finally {
            mostrarRegistro();
            ordenarTabla();
        }
    }

    public void centralizar() {
        
        setBounds((dpnEscritorio.getWidth() - this.getWidth()) / 2,
                (dpnEscritorio.getHeight() - this.getHeight()) / 2,
                720,
                500);
        pack();
        usuario.setVisible(true);
    }

    private void navegador(boolean b) {
        
        btnPrimero.setEnabled(b);
        btnAnterior.setEnabled(b);
        btnSiguiente.setEnabled(b);
        btnUltimo.setEnabled(b);
        btnNuevo.setEnabled(b);
        btnModificar.setEnabled(b);
        btnBorrar.setEnabled(b);
        btnBuscar.setEnabled(b);
        tblUsuarios.setEnabled(b);
        cbEstadosUsuarios.setEnabled(b);

        //Caja de Texto Habilitado
        btnGuardar.setEnabled(!b);
        btnCancelar.setEnabled(!b);

        //Caja de Textos
        txtPNombre.setEditable(!b);
        txtSNombre.setEditable(!b);
        txtApellidos.setEditable(!b);
        txtExequatur.setEditable(!b);
        txtEspecialidad.setEditable(!b);
        txtClave.setEditable(!b);
        txtClaveRepetir.setEditable(!b);
        jcbAdministrador.setEnabled(!b);
        cbEstado.setEnabled(!b);
        cbPerfil.setEnabled(!b);

        if (nuevo) {
            jlFoto.setIcon(new ImageIcon(
                    getClass().getResource("/imagenes/user180x180.png")));
            txtUserName.setEditable(true);
            limpiarCampo();
        } else {
            txtUserName.setEditable(false);
        }

    }

    private void limpiarCampo() {
        txtPNombre.setText("");
        txtSNombre.setText("");
        txtApellidos.setText("");
        txtUserName.setText("");
        txtExequatur.setText("");
        txtClave.setText("");
        txtClaveRepetir.setText("");
        txtEspecialidad.setText("");
        cbEstado.setSelected(false);
        jcbAdministrador.setSelected(false);
        cbPerfil.setSelectedIndex(0);
        txtPNombre.requestFocusInWindow();
    }

    private synchronized void ordenarTabla() {
        //Cedula
        tblUsuarios.getColumn(tblUsuarios.getColumnName(0)).setMinWidth(80);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(0)).setMaxWidth(130);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(0)).setPreferredWidth(90);
        //Cedula
        tblUsuarios.getColumn(tblUsuarios.getColumnName(1)).setMinWidth(130);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(1)).setMaxWidth(160);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(1)).setPreferredWidth(130);
        //Cedula Paciente
        tblUsuarios.getColumn(tblUsuarios.getColumnName(2)).setMinWidth(150);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(2)).setMaxWidth(180);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(2)).setPreferredWidth(150);
        //Nombre Paciente
        tblUsuarios.getColumn(tblUsuarios.getColumnName(3)).setMinWidth(115);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(3)).setMaxWidth(170);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(3)).setPreferredWidth(150);
        //Apellidos Paciente
        tblUsuarios.getColumn(tblUsuarios.getColumnName(4)).setMinWidth(105);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(4)).setMaxWidth(105);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(4)).setPreferredWidth(105);
        //Sexo
        tblUsuarios.getColumn(tblUsuarios.getColumnName(5)).setMinWidth(105);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(5)).setMaxWidth(105);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(5)).setPreferredWidth(105);
        //Sangre
        tblUsuarios.getColumn(tblUsuarios.getColumnName(6)).setMinWidth(160);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(6)).setMaxWidth(180);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(6)).setPreferredWidth(160);
        //Seguro
        tblUsuarios.getColumn(tblUsuarios.getColumnName(7)).setMinWidth(100);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(7)).setMaxWidth(150);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(7)).setPreferredWidth(110);
        //NumeroSeguro
        tblUsuarios.getColumn(tblUsuarios.getColumnName(8)).setMinWidth(110);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(8)).setMaxWidth(150);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(8)).setPreferredWidth(120);
        //Estado
        tblUsuarios.getColumn(tblUsuarios.getColumnName(9)).setMinWidth(110);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(9)).setMaxWidth(150);
        tblUsuarios.getColumn(tblUsuarios.getColumnName(9)).setPreferredWidth(120);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPerfiles;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JButton btnValidaLoginName;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox cbEstado;
    private javax.swing.JCheckBox cbEstadosUsuarios;
    private javax.swing.JComboBox cbPerfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JCheckBox jcbAdministrador;
    private javax.swing.JCheckBox jcbDelegarRol;
    private javax.swing.JCheckBox jcbPrimerNombre;
    private javax.swing.JLabel jlAgregarFoto1;
    private javax.swing.JLabel jlCreador1;
    private javax.swing.JLabel jlCreador3;
    private javax.swing.JLabel jlFoto;
    private javax.swing.JPanel jpDetalles;
    private javax.swing.JProgressBar jpbFoto;
    private javax.swing.JRadioButton jrbFemenino;
    private javax.swing.JRadioButton jrbMasculino;
    private javax.swing.JTable jtContactos;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JFormattedTextField txtApellidos;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JPasswordField txtClaveRepetir;
    private javax.swing.JFormattedTextField txtContacto;
    private javax.swing.JFormattedTextField txtEspecialidad;
    private javax.swing.JFormattedTextField txtExequatur;
    private javax.swing.JFormattedTextField txtPNombre;
    private javax.swing.JFormattedTextField txtSNombre;
    private javax.swing.JFormattedTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
