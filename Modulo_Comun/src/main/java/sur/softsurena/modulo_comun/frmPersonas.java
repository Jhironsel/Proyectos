package sur.softsurena.modulo_comun;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.PopupMenuEvent;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.entidades.ContactoEmail;
import sur.softsurena.entidades.ContactoTel;
import sur.softsurena.entidades.ContactoDireccion;
import sur.softsurena.entidades.DistritoMunicipal;
import sur.softsurena.entidades.EstadoCivil;
import sur.softsurena.entidades.Generales;
import sur.softsurena.entidades.Municipio;
import sur.softsurena.entidades.Paginas;
import sur.softsurena.entidades.Privilegio;
import sur.softsurena.entidades.Provincia;
import sur.softsurena.entidades.Sexo;
import sur.softsurena.entidades.TipoPersona;
import sur.softsurena.metodos.M_ContactoEmail;
import sur.softsurena.metodos.M_ContactoTel;
import sur.softsurena.metodos.M_ContactoDireccion;
import sur.softsurena.metodos.M_DistritoMunicipal;
import sur.softsurena.metodos.M_EstadoCivil;
import sur.softsurena.metodos.M_Generales;
import sur.softsurena.metodos.M_Municipio;
import sur.softsurena.metodos.M_Persona;
import sur.softsurena.metodos.M_Privilegio;
import sur.softsurena.metodos.M_Provincia;
import sur.softsurena.metodos.M_Sexo;
import sur.softsurena.metodos.M_TipoPersona;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;

public class frmPersonas extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Es utilizada para definir los cabezales de las tablas de direcciones.
     */
    final static String[] TITULOS_DIRECCION = {"Provincia", "Municipio", "Distrito M.",
        "Calle y No. Casa", "Fecha", "Estado", "Por defecto"};

    /**
     * Es utilizada para definir los cabezales de las tablas de correo.
     */
    final static String[] TITULOS_CORREO = {"Correo", "Fecha", "Estado", "Por defecto"};

    /**
     * Es utilizada para definir los cabezales de las tablas de telefono.
     */
    final static String[] TITULOS_TELEFONO = {"Numero", "Tipo", "Fecha", "Estado", "Por defecto"};

    private Boolean v_nuevo = false;

    private JTextFieldDateEditor v_editor = null;

    private static DefaultTableModel v_dtmTelefono, v_dtmCorreo, v_dtmDireccion;

    private static List<ContactoDireccion> v_direccionesList;

    private static List<ContactoEmail> v_contactosCorreosList;

    private static List<ContactoTel> v_contactosTelsList;

    private static Integer idPersona;

    private static Object registro[];

    public static frmPersonas getInstance() {
        /*
            Si un permiso a las vistas consultada anteriormente es negado, se 
        lanza una excepcion y la venta no se iniciará.
         */
        if (!M_Privilegio.privilegio(
                Privilegio
                        .builder()
                        .privilegio(Privilegio.PRIVILEGIO_SELECT)
                        .nombre_relacion("V_PERSONAS")
                        .nombre_campo("^")
                        .build()
        )) {

            final String mensaje
                    = "No cuenta con permisos para ver la información de este módulo.";

            JOptionPane.showInternalMessageDialog(
                    null,
                    mensaje,
                    "",
                    JOptionPane.WARNING_MESSAGE
            );

            throw new ExceptionInInitializerError(mensaje);
        }

        if (!Objects.isNull(NewSingletonHolder.INSTANCE)) {
            btnBotonesPrivilegios();
        }

        return NewSingletonHolder.INSTANCE;
    }

    private void btnDireccionEnable(boolean valor) {
        btnEditarDireccion.setEnabled(valor);
        btnBorrarDirrecion.setEnabled(valor);
        txtDireccion.requestFocus();
    }

    private void mensajeResultado(Resultado resultado, boolean estado) {
        if (resultado.getEstado() == estado) {
            JOptionPane.showMessageDialog(
                    this,
                    resultado.getMensaje(),
                    "",
                    resultado.getIcono()
            );
        }
    }

    private static class NewSingletonHolder {

        private static final frmPersonas INSTANCE = new frmPersonas();
    }

    private frmPersonas() {
        //Metodo encargado de inicializar los componentes del formulario.
        initComponents();

        //Inicializando las listas.
        v_direccionesList = new ArrayList<>();
        v_contactosCorreosList = new ArrayList<>();
        v_contactosTelsList = new ArrayList<>();

        v_editor = (JTextFieldDateEditor) dchFechaNacimiento.getDateEditor();

        v_editor.setBorder(
                javax.swing.BorderFactory.createTitledBorder(
                        new javax.swing.border.LineBorder(
                                new java.awt.Color(37, 45, 223), 2, true),
                        "Fecha nacimiento",
                        javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION,
                        new java.awt.Font("FreeSans", 0, 12)));

        v_editor.addActionListener((ActionEvent e) -> {
            jcbEstadoCivil.requestFocus();
            jcbEstadoCivil.showPopup();
        });

        //Mantenimiento oculto por defecto.
        jtpPrincipal.remove(jspMantenimiento);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGMovilTelefono = new javax.swing.ButtonGroup();
        txtCedula1 = new javax.swing.JFormattedTextField();
        jspGeneral = new javax.swing.JScrollPane();
        jpGeneral = new javax.swing.JPanel();
        jtpPrincipal = new javax.swing.JTabbedPane();
        jspPersonas = new javax.swing.JScrollPane();
        jpPersonas = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jsCantidadFilas = new javax.swing.JSpinner();
        jsPaginaNro = new javax.swing.JSpinner();
        jPanel15 = new javax.swing.JPanel();
        jcbFiltroTodos = new javax.swing.JCheckBox();
        jcbFiltroCliente = new javax.swing.JCheckBox();
        jcbFiltroEmpleado = new javax.swing.JCheckBox();
        jcbFiltroEstudiante = new javax.swing.JCheckBox();
        jcbFiltroPaciente = new javax.swing.JCheckBox();
        jcbFiltroPadre = new javax.swing.JCheckBox();
        jcbFiltroProveedor = new javax.swing.JCheckBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPersonas = new rojerusan.RSTableMetro1(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jScrollPane2 = new javax.swing.JScrollPane();
        jpBotonesPrincipal = new javax.swing.JPanel();
        btnActualizarRegistrosPersona = new RSMaterialComponent.RSButtonMaterialIconOne();
        jspMantenimiento = new javax.swing.JScrollPane();
        jpMantenimiento = new javax.swing.JPanel();
        jtpGeneralesDireccionContactos = new javax.swing.JTabbedPane();
        jpGenerales = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        txtCedula = new javax.swing.JFormattedTextField();
        btnCedulaValidad = new RSMaterialComponent.RSButtonMaterialIconOne();
        cbEstado = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        txtPNombre = new javax.swing.JTextField();
        txtSNombre = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        txtApellidos = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jcbPersona = new javax.swing.JComboBox<>();
        dchFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jPanel9 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jcbEstadoCivil = new javax.swing.JComboBox<>();
        jcbSexo = new javax.swing.JComboBox<>();
        jPanel18 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jcbCliente = new javax.swing.JCheckBox();
        jcbEmpleado = new javax.swing.JCheckBox();
        jcbEstudiante = new javax.swing.JCheckBox();
        jcbPaciente = new javax.swing.JCheckBox();
        jcbPadre = new javax.swing.JCheckBox();
        jcbProveedor = new javax.swing.JCheckBox();
        jpDireccion = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jcbProvincias = new javax.swing.JComboBox<>();
        jcbMunicipios = new javax.swing.JComboBox<>();
        jcbDistritoMunicipal = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnAgregarDirecciones = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEditarDireccion = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrarDirrecion = new RSMaterialComponent.RSButtonMaterialIconOne();
        txtDireccion = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDireccion = new rojerusan.RSTableMetro1(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jpContactos = new javax.swing.JPanel();
        jtpContactos = new javax.swing.JTabbedPane();
        jpTelefonos = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        txtTelelfonoMovil = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jrbResidencial = new javax.swing.JRadioButton();
        jrbMovil = new javax.swing.JRadioButton();
        btnAgregarTelefonoMovil = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrarTelefono = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEditarTelefono = new RSMaterialComponent.RSButtonMaterialIconOne();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblTelefonos = new rojerusan.RSTableMetro1(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jpCorreos = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        txtCorreo = new javax.swing.JTextField();
        btnAgregarCorreo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEditarCorreo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrarCorreo = new RSMaterialComponent.RSButtonMaterialIconOne();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCorreos = new rojerusan.RSTableMetro1(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jlFechaCreacion = new javax.swing.JLabel();
        jpBotones = new javax.swing.JPanel();
        btnNuevaPersona = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificarPersona = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrarPersona = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBuscarPersona = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnGuardarRegistro = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelarRegistro = new RSMaterialComponent.RSButtonMaterialIconOne();

        txtCedula1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Cedula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        try {
            txtCedula1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula1.setText("012-0089344-8");
        txtCedula1.setToolTipText("Ingrese su criterio de busqueda.\\n[Cedula, nombres o apellidos]");
        txtCedula1.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtCedula1.setFocusTraversalPolicyProvider(true);
        txtCedula1.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        txtCedula1.setName("txtCedula"); // NOI18N

        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(37, 45, 223)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Personas");
        setToolTipText("Mantenimientos de los registros de persona del sistema.");
        setName("frmPersonas"); // NOI18N
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

        jspGeneral.setName("jspGeneral"); // NOI18N

        jpGeneral.setName("jpGeneral"); // NOI18N

        jtpPrincipal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));
        jtpPrincipal.setName("jtpPrincipal"); // NOI18N
        jtpPrincipal.setPreferredSize(new java.awt.Dimension(3011, 625));

        jspPersonas.setName("jspPersonas"); // NOI18N

        jpPersonas.setName("jpPersonas"); // NOI18N

        jPanel11.setName("jPanel11"); // NOI18N

        jsCantidadFilas.setModel(new javax.swing.SpinnerNumberModel(20, 10, null, 1));
        jsCantidadFilas.setBorder(javax.swing.BorderFactory.createTitledBorder("Registros"));
        jsCantidadFilas.setMaximumSize(new java.awt.Dimension(50, 27));
        jsCantidadFilas.setMinimumSize(new java.awt.Dimension(20, 27));
        jsCantidadFilas.setName("jsCantidadFilas"); // NOI18N
        jsCantidadFilas.setPreferredSize(new java.awt.Dimension(30, 27));
        jsCantidadFilas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsCantidadFilasStateChanged(evt);
            }
        });

        jsPaginaNro.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jsPaginaNro.setBorder(javax.swing.BorderFactory.createTitledBorder("Paginas"));
        jsPaginaNro.setMaximumSize(new java.awt.Dimension(50, 27));
        jsPaginaNro.setMinimumSize(new java.awt.Dimension(20, 27));
        jsPaginaNro.setName("jsPaginaNro"); // NOI18N
        jsPaginaNro.setPreferredSize(new java.awt.Dimension(30, 27));
        jsPaginaNro.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsPaginaNroStateChanged(evt);
            }
        });

        jPanel15.setName("jPanel15"); // NOI18N
        jPanel15.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jcbFiltroTodos.setText("Todos");
        jcbFiltroTodos.setMaximumSize(new java.awt.Dimension(100, 20));
        jcbFiltroTodos.setName("jcbFiltroTodos"); // NOI18N
        jPanel15.add(jcbFiltroTodos);

        jcbFiltroCliente.setText("Cliente");
        jcbFiltroCliente.setMaximumSize(new java.awt.Dimension(100, 20));
        jcbFiltroCliente.setName("jcbFiltroCliente"); // NOI18N
        jPanel15.add(jcbFiltroCliente);

        jcbFiltroEmpleado.setText("Empleado");
        jcbFiltroEmpleado.setName("jcbFiltroEmpleado"); // NOI18N
        jPanel15.add(jcbFiltroEmpleado);

        jcbFiltroEstudiante.setText("Estudiante");
        jcbFiltroEstudiante.setName("jcbFiltroEstudiante"); // NOI18N
        jPanel15.add(jcbFiltroEstudiante);

        jcbFiltroPaciente.setText("Paciente");
        jcbFiltroPaciente.setName("jcbFiltroPaciente"); // NOI18N
        jPanel15.add(jcbFiltroPaciente);

        jcbFiltroPadre.setText("Padre");
        jcbFiltroPadre.setName("jcbFiltroPadre"); // NOI18N
        jPanel15.add(jcbFiltroPadre);

        jcbFiltroProveedor.setText("Proveedor");
        jcbFiltroProveedor.setName("jcbFiltroProveedor"); // NOI18N
        jPanel15.add(jcbFiltroProveedor);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jsCantidadFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsPaginaNro, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jsCantidadFilas, jsPaginaNro});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jsCantidadFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jsPaginaNro, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jScrollPane6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));
        jScrollPane6.setName("jScrollPane6"); // NOI18N

        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Persona", "Nombres y apellidos", "Sexo", "Fecha de nacimiento", "Fecha de Ingreso", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPersonas.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblPersonas.setFontHead(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblPersonas.setFontRowHover(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblPersonas.setFontRowSelect(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblPersonas.setName("tblPersonas"); // NOI18N
        tblPersonas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblPersonasKeyPressed(evt);
            }
        });
        jScrollPane6.setViewportView(tblPersonas);

        jScrollPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));
        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jpBotonesPrincipal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(187, 187, 187), 1, true));
        jpBotonesPrincipal.setName("jpBotonesPrincipal"); // NOI18N
        jpBotonesPrincipal.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnActualizarRegistrosPersona.setText("Actualizar registros");
        btnActualizarRegistrosPersona.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UPDATE);
        btnActualizarRegistrosPersona.setName("btnHistorial"); // NOI18N
        btnActualizarRegistrosPersona.setRound(40);
        btnActualizarRegistrosPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarRegistrosPersonaActionPerformed(evt);
            }
        });
        jpBotonesPrincipal.add(btnActualizarRegistrosPersona);

        jScrollPane2.setViewportView(jpBotonesPrincipal);

        javax.swing.GroupLayout jpPersonasLayout = new javax.swing.GroupLayout(jpPersonas);
        jpPersonas.setLayout(jpPersonasLayout);
        jpPersonasLayout.setHorizontalGroup(
            jpPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPersonasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpPersonasLayout.setVerticalGroup(
            jpPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPersonasLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jspPersonas.setViewportView(jpPersonas);

        jtpPrincipal.addTab("Personas", jspPersonas);

        jspMantenimiento.setName("jspMantenimiento"); // NOI18N

        jpMantenimiento.setName("jpMantenimiento"); // NOI18N

        jtpGeneralesDireccionContactos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true)));
        jtpGeneralesDireccionContactos.setToolTipText("");
        jtpGeneralesDireccionContactos.setName("jtpGeneralesDireccionContactos"); // NOI18N
        jtpGeneralesDireccionContactos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtpGeneralesDireccionContactosKeyPressed(evt);
            }
        });

        jpGenerales.setToolTipText("Acceso con Control + 1");
        jpGenerales.setName("jpGenerales"); // NOI18N

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new java.awt.GridLayout(5, 0, 10, 10));

        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jPanel14.setName("jPanel14"); // NOI18N
        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        txtCedula.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Cedula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        try {
            txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula.setText("");
        txtCedula.setToolTipText("Cedula de la persona.");
        txtCedula.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtCedula.setFocusTraversalPolicyProvider(true);
        txtCedula.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        txtCedula.setMaximumSize(new java.awt.Dimension(50, 2147483647));
        txtCedula.setName("txtCedula"); // NOI18N
        txtCedula.setPreferredSize(new java.awt.Dimension(100, 43));
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaKeyPressed(evt);
            }
        });
        jPanel14.add(txtCedula);

        btnCedulaValidad.setBackground(new java.awt.Color(0, 255, 75));
        btnCedulaValidad.setToolTipText("Verifica la cedula de la persona.");
        btnCedulaValidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCedulaValidad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCedulaValidad.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SYNC);
        btnCedulaValidad.setName("btnCedulaValidad"); // NOI18N
        btnCedulaValidad.setPreferredSize(new java.awt.Dimension(40, 40));
        btnCedulaValidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCedulaValidadActionPerformed(evt);
            }
        });
        jPanel14.add(btnCedulaValidad);

        jPanel3.add(jPanel14);

        cbEstado.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbEstado.setSelected(true);
        cbEstado.setText("Activo");
        cbEstado.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 1, true), "Estado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        cbEstado.setFocusTraversalPolicyProvider(true);
        cbEstado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cbEstado.setMinimumSize(new java.awt.Dimension(0, 0));
        cbEstado.setName("cbEstado"); // NOI18N
        cbEstado.setPreferredSize(new java.awt.Dimension(0, 25));
        cbEstado.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });
        jPanel3.add(cbEstado);

        jPanel2.add(jPanel3);

        jPanel4.setName("jPanel4"); // NOI18N
        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        txtPNombre.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        txtPNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Primer nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        txtPNombre.setDoubleBuffered(true);
        txtPNombre.setFocusTraversalPolicyProvider(true);
        txtPNombre.setMinimumSize(new java.awt.Dimension(0, 0));
        txtPNombre.setName("txtPNombre"); // NOI18N
        txtPNombre.setPreferredSize(new java.awt.Dimension(0, 25));
        txtPNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPNombreActionPerformed(evt);
            }
        });
        jPanel4.add(txtPNombre);

        txtSNombre.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        txtSNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Segundo nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        txtSNombre.setDoubleBuffered(true);
        txtSNombre.setFocusTraversalPolicyProvider(true);
        txtSNombre.setMinimumSize(new java.awt.Dimension(0, 0));
        txtSNombre.setName("txtSNombre"); // NOI18N
        txtSNombre.setPreferredSize(new java.awt.Dimension(0, 25));
        txtSNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSNombreActionPerformed(evt);
            }
        });
        jPanel4.add(txtSNombre);

        jPanel2.add(jPanel4);

        jPanel10.setName("jPanel10"); // NOI18N
        jPanel10.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        txtApellidos.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        txtApellidos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellidos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Apellidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        txtApellidos.setDoubleBuffered(true);
        txtApellidos.setFocusTraversalPolicyProvider(true);
        txtApellidos.setMinimumSize(new java.awt.Dimension(0, 0));
        txtApellidos.setName("txtApellidos"); // NOI18N
        txtApellidos.setPreferredSize(new java.awt.Dimension(0, 25));
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel10.add(txtApellidos);

        jPanel16.setName("jPanel16"); // NOI18N
        jPanel16.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jcbPersona.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jcbPersona.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Tipo persona", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        jcbPersona.setName("jcbPersona"); // NOI18N
        jcbPersona.setPreferredSize(new java.awt.Dimension(200, 47));
        jcbPersona.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbPersonaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel16.add(jcbPersona);

        dchFechaNacimiento.setDateFormatString("dd.MM.yyyy");
        dchFechaNacimiento.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        dchFechaNacimiento.setName("jdcFechaNacimiento"); // NOI18N
        jPanel16.add(dchFechaNacimiento);

        jPanel10.add(jPanel16);

        jPanel2.add(jPanel10);

        jPanel9.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel9.setName("jPanel9"); // NOI18N
        jPanel9.setPreferredSize(new java.awt.Dimension(746, 50));
        jPanel9.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel17.setName("jPanel17"); // NOI18N
        jPanel17.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jcbEstadoCivil.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jcbEstadoCivil.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Estado civil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        jcbEstadoCivil.setName("jcbEstadoCivil"); // NOI18N
        jcbEstadoCivil.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbEstadoCivilPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel17.add(jcbEstadoCivil);

        jcbSexo.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jcbSexo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        jcbSexo.setName("jcbSexo"); // NOI18N
        jcbSexo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbSexoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel17.add(jcbSexo);

        jPanel9.add(jPanel17);

        jPanel18.setName("jPanel18"); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel18);

        jPanel2.add(jPanel9);

        jPanel13.setName("jPanel13"); // NOI18N
        jPanel13.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jcbCliente.setText("Cliente");
        jcbCliente.setMaximumSize(new java.awt.Dimension(100, 20));
        jcbCliente.setName("jcbCliente"); // NOI18N
        jPanel13.add(jcbCliente);

        jcbEmpleado.setText("Empleado");
        jcbEmpleado.setName("jcbEmpleado"); // NOI18N
        jPanel13.add(jcbEmpleado);

        jcbEstudiante.setText("Estudiante");
        jcbEstudiante.setName("jcbEstudiante"); // NOI18N
        jPanel13.add(jcbEstudiante);

        jcbPaciente.setText("Paciente");
        jcbPaciente.setName("jcbPaciente"); // NOI18N
        jPanel13.add(jcbPaciente);

        jcbPadre.setText("Padre");
        jcbPadre.setName("jcbPadre"); // NOI18N
        jPanel13.add(jcbPadre);

        jcbProveedor.setText("Proveedor");
        jcbProveedor.setName("jcbProveedor"); // NOI18N
        jPanel13.add(jcbProveedor);

        jPanel2.add(jPanel13);

        javax.swing.GroupLayout jpGeneralesLayout = new javax.swing.GroupLayout(jpGenerales);
        jpGenerales.setLayout(jpGeneralesLayout);
        jpGeneralesLayout.setHorizontalGroup(
            jpGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGeneralesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpGeneralesLayout.setVerticalGroup(
            jpGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGeneralesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jtpGeneralesDireccionContactos.addTab("Generales", jpGenerales);

        jpDireccion.setToolTipText("Acceso con Control + 2");
        jpDireccion.setName("jpDireccion"); // NOI18N

        jPanel5.setName("jPanel5"); // NOI18N
        jPanel5.setLayout(new java.awt.GridLayout(1, 3, 6, 0));

        jcbProvincias.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jcbProvincias.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Provincia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        jcbProvincias.setName("jcbProvincias"); // NOI18N
        jcbProvincias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProvinciasActionPerformed(evt);
            }
        });
        jcbProvincias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbProvinciasKeyPressed(evt);
            }
        });
        jPanel5.add(jcbProvincias);

        jcbMunicipios.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jcbMunicipios.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Municipio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        jcbMunicipios.setName("jcbMunicipios"); // NOI18N
        jcbMunicipios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMunicipiosActionPerformed(evt);
            }
        });
        jcbMunicipios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbMunicipiosKeyPressed(evt);
            }
        });
        jPanel5.add(jcbMunicipios);

        jcbDistritoMunicipal.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jcbDistritoMunicipal.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Distrito Municipal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        jcbDistritoMunicipal.setName("jcbDistritoMunicipal"); // NOI18N
        jcbDistritoMunicipal.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbDistritoMunicipalPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jcbDistritoMunicipal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbDistritoMunicipalKeyPressed(evt);
            }
        });
        jPanel5.add(jcbDistritoMunicipal);

        jPanel6.setName("jPanel6"); // NOI18N

        jPanel7.setName("jPanel7"); // NOI18N
        jPanel7.setLayout(new java.awt.GridLayout(1, 5, 5, 0));

        btnAgregarDirecciones.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PLUS_ONE);
        btnAgregarDirecciones.setName("btnAgregarDirecciones"); // NOI18N
        btnAgregarDirecciones.setPositionIcon(null);
        btnAgregarDirecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDireccionesActionPerformed(evt);
            }
        });
        jPanel7.add(btnAgregarDirecciones);

        btnEditarDireccion.setEnabled(false);
        btnEditarDireccion.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarDireccion.setName("btnAgregarDirecciones"); // NOI18N
        btnEditarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDireccionActionPerformed(evt);
            }
        });
        jPanel7.add(btnEditarDireccion);

        btnBorrarDirrecion.setEnabled(false);
        btnBorrarDirrecion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBorrarDirrecion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBorrarDirrecion.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrarDirrecion.setName("btnBorrarDirrecion"); // NOI18N
        btnBorrarDirrecion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarDirrecionActionPerformed(evt);
            }
        });
        jPanel7.add(btnBorrarDirrecion);

        txtDireccion.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Dirección", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        txtDireccion.setDoubleBuffered(true);
        txtDireccion.setFocusTraversalPolicyProvider(true);
        txtDireccion.setMinimumSize(new java.awt.Dimension(0, 0));
        txtDireccion.setName("txtDireccion"); // NOI18N
        txtDireccion.setPreferredSize(new java.awt.Dimension(0, 25));
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        tblDireccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Provincia", "Municipio", "Distrito Municipal", "Calle y No. Casa", "Fecha", "Estado", "Por defecto"
            }
        ) {
            Class<?>[] types = new Class<?>[] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class<?> getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDireccion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblDireccion.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblDireccion.setFontHead(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblDireccion.setFontRowHover(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblDireccion.setFontRowSelect(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblDireccion.setName("tblDireccion"); // NOI18N
        tblDireccion.setShowGrid(true);
        tblDireccion.setSurrendersFocusOnKeystroke(true);
        tblDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDireccionMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDireccion);

        javax.swing.GroupLayout jpDireccionLayout = new javax.swing.GroupLayout(jpDireccion);
        jpDireccion.setLayout(jpDireccionLayout);
        jpDireccionLayout.setHorizontalGroup(
            jpDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDireccionLayout.createSequentialGroup()
                .addGroup(jpDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDireccionLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpDireccionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))))
                .addContainerGap())
        );
        jpDireccionLayout.setVerticalGroup(
            jpDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDireccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
        );

        jtpGeneralesDireccionContactos.addTab("Dirección", jpDireccion);

        jpContactos.setToolTipText("Acceso con Control + 3");
        jpContactos.setName("jpContactos"); // NOI18N

        jtpContactos.setName("telefonoCorreos"); // NOI18N

        jpTelefonos.setName("jpTelefonos"); // NOI18N

        jPanel8.setName("jPanel8"); // NOI18N

        txtTelelfonoMovil.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Número"));
        try {
            txtTelelfonoMovil.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+1(###) ###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelelfonoMovil.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        txtTelelfonoMovil.setName("txtTelefonoMovil"); // NOI18N
        txtTelelfonoMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelelfonoMovilActionPerformed(evt);
            }
        });
        txtTelelfonoMovil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelelfonoMovilKeyPressed(evt);
            }
        });

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        btnGMovilTelefono.add(jrbResidencial);
        jrbResidencial.setText("Telefono");
        jrbResidencial.setName("jrbTelefonoResidencial"); // NOI18N
        jPanel1.add(jrbResidencial);

        btnGMovilTelefono.add(jrbMovil);
        jrbMovil.setSelected(true);
        jrbMovil.setText("Movil");
        jrbMovil.setName("jrbMovil"); // NOI18N
        jPanel1.add(jrbMovil);

        btnAgregarTelefonoMovil.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PLUS_ONE);
        btnAgregarTelefonoMovil.setName("btnAgregarTelefono"); // NOI18N
        btnAgregarTelefonoMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTelefonoMovilActionPerformed(evt);
            }
        });

        btnBorrarTelefono.setEnabled(false);
        btnBorrarTelefono.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrarTelefono.setName("btnBorrarTelefono"); // NOI18N
        btnBorrarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarTelefonoActionPerformed(evt);
            }
        });

        btnEditarTelefono.setEnabled(false);
        btnEditarTelefono.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarTelefono.setName("btnAgregarDirecciones"); // NOI18N
        btnEditarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTelefonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(txtTelelfonoMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarTelefonoMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTelelfonoMovil)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnEditarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregarTelefonoMovil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBorrarTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(3, 3, 3))
        );

        jScrollPane5.setName("jScrollPane5"); // NOI18N

        tblTelefonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Numero", "Tipo", "Fecha", "Estado", "Por defecto"
            }
        ) {
            Class<?>[] types = new Class<?>[] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class<?> getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblTelefonos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblTelefonos.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblTelefonos.setFontHead(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblTelefonos.setFontRowHover(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblTelefonos.setFontRowSelect(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblTelefonos.setName("tblTelefonos"); // NOI18N
        tblTelefonos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTelefonosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblTelefonos);

        javax.swing.GroupLayout jpTelefonosLayout = new javax.swing.GroupLayout(jpTelefonos);
        jpTelefonos.setLayout(jpTelefonosLayout);
        jpTelefonosLayout.setHorizontalGroup(
            jpTelefonosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpTelefonosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jpTelefonosLayout.setVerticalGroup(
            jpTelefonosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTelefonosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpContactos.addTab("Teléfonico", jpTelefonos);

        jpCorreos.setName("jpCorreos"); // NOI18N

        jPanel12.setName("jPanel12"); // NOI18N

        txtCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 1, true), "Ingrese correo"));
        txtCorreo.setName("txtCorreo"); // NOI18N
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCorreoKeyPressed(evt);
            }
        });

        btnAgregarCorreo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PLUS_ONE);
        btnAgregarCorreo.setName("btnAgregarCorreo"); // NOI18N
        btnAgregarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCorreoActionPerformed(evt);
            }
        });

        btnEditarCorreo.setEnabled(false);
        btnEditarCorreo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarCorreo.setName("btnAgregarDirecciones"); // NOI18N
        btnEditarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCorreoActionPerformed(evt);
            }
        });

        btnBorrarCorreo.setEnabled(false);
        btnBorrarCorreo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrarCorreo.setName("btnBorrarCorreo"); // NOI18N
        btnBorrarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarCorreoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreo)
                    .addComponent(btnBorrarCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(btnEditarCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        tblCorreos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", null, null}
            },
            new String [] {
                "Correo", "Fecha", "Estado", "Por defecto"
            }
        ) {
            Class<?>[] types = new Class<?>[] {
                java.lang.String.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class<?> getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblCorreos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblCorreos.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblCorreos.setFontHead(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblCorreos.setFontRowHover(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblCorreos.setFontRowSelect(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblCorreos.setName("tblCorreos"); // NOI18N
        tblCorreos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCorreosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblCorreos);

        javax.swing.GroupLayout jpCorreosLayout = new javax.swing.GroupLayout(jpCorreos);
        jpCorreos.setLayout(jpCorreosLayout);
        jpCorreosLayout.setHorizontalGroup(
            jpCorreosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpCorreosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpCorreosLayout.setVerticalGroup(
            jpCorreosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCorreosLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpContactos.addTab("Correos", jpCorreos);

        javax.swing.GroupLayout jpContactosLayout = new javax.swing.GroupLayout(jpContactos);
        jpContactos.setLayout(jpContactosLayout);
        jpContactosLayout.setHorizontalGroup(
            jpContactosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContactosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jtpContactos))
        );
        jpContactosLayout.setVerticalGroup(
            jpContactosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContactosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jtpContactos)
                .addContainerGap())
        );

        jtpGeneralesDireccionContactos.addTab("Contactos", jpContactos);

        jlFechaCreacion.setText("Fecha de creacion: ");
        jlFechaCreacion.setName("jlFechaCreacion"); // NOI18N

        javax.swing.GroupLayout jpMantenimientoLayout = new javax.swing.GroupLayout(jpMantenimiento);
        jpMantenimiento.setLayout(jpMantenimientoLayout);
        jpMantenimientoLayout.setHorizontalGroup(
            jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantenimientoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlFechaCreacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtpGeneralesDireccionContactos))
                .addContainerGap())
        );
        jpMantenimientoLayout.setVerticalGroup(
            jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantenimientoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlFechaCreacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtpGeneralesDireccionContactos)
                .addContainerGap())
        );

        jspMantenimiento.setViewportView(jpMantenimiento);

        jtpPrincipal.addTab("Mantenimiento", jspMantenimiento);

        jpBotones.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), " Botones de Acción ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 0, 14))); // NOI18N
        jpBotones.setMaximumSize(new java.awt.Dimension(787, 81));
        jpBotones.setMinimumSize(new java.awt.Dimension(787, 81));
        jpBotones.setName("jpBotones"); // NOI18N
        jpBotones.setPreferredSize(new java.awt.Dimension(800, 80));
        jpBotones.setLayout(new java.awt.GridLayout(1, 0, 6, 0));

        btnNuevaPersona.setText("Nuevo");
        btnNuevaPersona.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevaPersona.setName("btnNuevaPersona"); // NOI18N
        btnNuevaPersona.setRound(40);
        btnNuevaPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaPersonaActionPerformed(evt);
            }
        });
        jpBotones.add(btnNuevaPersona);

        btnModificarPersona.setText("Modificar");
        btnModificarPersona.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
        btnModificarPersona.setName("btnModificarPersona"); // NOI18N
        btnModificarPersona.setRound(40);
        btnModificarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPersonaActionPerformed(evt);
            }
        });
        jpBotones.add(btnModificarPersona);

        btnBorrarPersona.setText("Borrar");
        btnBorrarPersona.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrarPersona.setName("btnBorrarPersona"); // NOI18N
        btnBorrarPersona.setRound(40);
        btnBorrarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarPersonaActionPerformed(evt);
            }
        });
        jpBotones.add(btnBorrarPersona);

        btnBuscarPersona.setText("Buscar");
        btnBuscarPersona.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FIND_IN_PAGE);
        btnBuscarPersona.setName("btnBuscarPersona"); // NOI18N
        btnBuscarPersona.setRound(40);
        btnBuscarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPersonaActionPerformed(evt);
            }
        });
        jpBotones.add(btnBuscarPersona);

        btnGuardarRegistro.setText("Guardar");
        btnGuardarRegistro.setEnabled(false);
        btnGuardarRegistro.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardarRegistro.setName("btnGuardarRegistro"); // NOI18N
        btnGuardarRegistro.setRound(40);
        btnGuardarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarRegistroActionPerformed(evt);
            }
        });
        jpBotones.add(btnGuardarRegistro);

        btnCancelarRegistro.setText("Cancelar");
        btnCancelarRegistro.setEnabled(false);
        btnCancelarRegistro.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelarRegistro.setName("btnCancelarRegistro"); // NOI18N
        btnCancelarRegistro.setRound(40);
        btnCancelarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRegistroActionPerformed(evt);
            }
        });
        jpBotones.add(btnCancelarRegistro);

        javax.swing.GroupLayout jpGeneralLayout = new javax.swing.GroupLayout(jpGeneral);
        jpGeneral.setLayout(jpGeneralLayout);
        jpGeneralLayout.setHorizontalGroup(
            jpGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jpBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpGeneralLayout.setVerticalGroup(
            jpGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jspGeneral.setViewportView(jpGeneral);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspGeneral)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspGeneral)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaPersonaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNuevaPersonaActionPerformed
        v_nuevo = true;//Se va a ingresar un nuevo registro al sistema
        cambioBoton(true);
        limpiarTablasDirTelCorr();
    }//GEN-LAST:event_btnNuevaPersonaActionPerformed

    private void btnModificarPersonaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnModificarPersonaActionPerformed
        //Se valida que exista un campo seleccionado
        if (validarRegistro("modificar.")) {
            return;
        }

        //Se hace false para indicar que es una modificacion de registro.
        v_nuevo = false;

        //Se agrega el panel de manteniento y se muestra.
        cambioBoton(true);

        limpiarTablasDirTelCorr();

        idPersona = ((Persona) tblPersonas.getValueAt(
                tblPersonas.getSelectedRow(),
                2
        )).getIdPersona();

        mostrarRegistro();
    }//GEN-LAST:event_btnModificarPersonaActionPerformed

    private void btnBorrarPersonaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnBorrarPersonaActionPerformed
        //Validamos que está correcto en la tabla.
        //Si el metodo devuelve true devolvemos el proceso.
        if (validarRegistro("eliminar.")) {
            return;
        }

        //Mostramos un mensaje de advertencia si el usuario desea continuar con
        //la eliminación del registro.
        int rta = JOptionPane.showInternalConfirmDialog(
                this,
                "¿Esta Seguro de eliminar registro de la persona?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        //Si el usuario responde a que no a las opciones entonces devolvemos el
        //proceso.
        if (rta == JOptionPane.NO_OPTION) {
            return;
        }

        //Mandamos a borrar la persona y obtenemos el resultado de la operacion
        //y almacenamos en una variable.
        Resultado resultados = M_Persona.delete(
                ((Generales) tblPersonas.getValueAt(
                        tblPersonas.getSelectedRow(),
                        0
                )).getIdPersona()
        );

        JOptionPane.showInternalMessageDialog(
                this,
                resultados,
                "",
                resultados.getIcono()
        );
    }//GEN-LAST:event_btnBorrarPersonaActionPerformed

    private void btnBuscarPersonaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnBuscarPersonaActionPerformed
        txtCedula1.setValue(null);
        //Utilidades.showTooltip(txtCedula1);
        JOptionPane.showInternalMessageDialog(
                this,
                txtCedula1,
                "",
                JOptionPane.QUESTION_MESSAGE
        );

        if (Utilidades.validarCampo(txtCedula1)) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Error en el campo de la cedula, Vuelva a digitarla de nuevo",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        jsPaginaNro.setValue(1);

        llenarTablaPersonas();

        if (tblPersonas.getRowCount() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "No se encontro registros con dichos criterios.",
                    "",
                    JOptionPane.WARNING_MESSAGE
            );
            btnActualizarRegistrosPersona.doClick();
        }
    }//GEN-LAST:event_btnBuscarPersonaActionPerformed

    /**
     * Metodo para guardar los registros del sistema.
     *
     * 1) Se valida la cedula registrada en el campo del sistema. Mostramos un
     * mensaje de error si la cedula no cumple con el patron mostramos un
     * mensaje de advertencia, dicho patron debe ser 000-0000000-0.
     *
     * 2)Se valida que la cedula pase el algoritmo de cedulas dominicana, En
     * caso de que no sea valida, lanzamos advertencia. Si el usuario responde
     * que si, el flujo sigue, en caso contrario volvemos a la ventaja generales
     * se realiza peticion de focus al componente txtCedula. Y se deja el texto
     * de la cedula seleccionado.
     *
     * 3) Validamos el primer nombre de la persona que no este vacio. En caso de
     * ser necesario nos cambiamos a la ventana correspondiente...
     *
     * 4) Validamos que el campo apellidos no este vacio.
     *
     * 5) Validamos que el campo de la fecha no sea nulo.
     *
     * 6) Nos aseguramos que la fecha ingresada sea menor que la fecha actual.
     *
     * 7) Valida que la persona cuente con una direccion fisica. Si el usuario
     * indica que no se va a registrar una direccion, el flujo continua.
     *
     * 8) Valida que exista una forma de contactar a una persona por su correo o
     * telefono registrado en el sistema.
     *
     * Cuando es un nuevo registros.:
     *
     * Cuando se actualiza un registro.:
     *
     *
     * @param evt
     */
    private void btnGuardarRegistroActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnGuardarRegistroActionPerformed
        if (Utilidades.validarCampo(txtCedula)) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    """
                    Error en el campo de la cedula, Vuelva a digitarla de nuevo.
                    """,
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        //----------------------------------------------------------------------
        if (!M_Generales.cedula(txtCedula.getValue().toString())) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                    La cedula %s no pasa la prueba de validación.
                    Desea continuar?
                    """.formatted(txtCedula.getValue().toString()),
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null
            );

            if (resp == JOptionPane.NO_OPTION) {
                jtpGeneralesDireccionContactos.setSelectedComponent(jpGenerales);

                txtCedula.requestFocus();

                txtCedula.setSelectionStart(0);

                txtCedula.setSelectionEnd(
                        txtCedula.getValue().toString().length()
                );
                return;
            }
        }
        //----------------------------------------------------------------------
        if (txtPNombre.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar un nombre...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );

            jtpGeneralesDireccionContactos.setSelectedComponent(jpGenerales);

            txtPNombre.requestFocus();

            return;
        }
        //----------------------------------------------------------------------
        if (txtApellidos.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar un apellido...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );

            jtpGeneralesDireccionContactos.setSelectedComponent(jpGenerales);

            txtApellidos.requestFocus();

            return;
        }

        //----------------------------------------------------------------------
        if (Objects.isNull(dchFechaNacimiento.getDate())) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe indicar una fecha de nacimiento.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            jtpGeneralesDireccionContactos.setSelectedComponent(jpGenerales);
            dchFechaNacimiento.requestFocus();
            return;
        }

        //----------------------------------------------------------------------
        if (dchFechaNacimiento.getDate().after(new Date())) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Fecha de nacimiento incorrecta!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            jtpGeneralesDireccionContactos.setSelectedComponent(jpGenerales);
            dchFechaNacimiento.requestFocus();
            return;
        }

        //----------------------------------------------------------------------
        if (tblDireccion.getRowCount() < 1) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                    Persona no cuenta con una dirrecion.
                    Desea agregar una direccion?
                    """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null
            );
            if (resp == JOptionPane.YES_OPTION) {
                jtpGeneralesDireccionContactos.setSelectedComponent(jpDireccion);
                txtDireccion.requestFocus();
                return;
            }
        }

        //----------------------------------------------------------------------
        if (tblCorreos.getRowCount() == 1 || tblTelefonos.getRowCount() < 1) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                    No existe forma de contactar a la persona.
                    Desea agreguar un numero de telefono o correo electronico?
                    """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null
            );

            if (resp == JOptionPane.YES_OPTION) {
                jtpGeneralesDireccionContactos.setSelectedComponent(jpContactos);
                jtpContactos.setSelectedComponent(jpTelefonos);
                return;
            }

        }

        //----------------------------------------------------------------------
        //Buscar la cedula en la base de datos.
        var cedula = M_Generales.select(
                Generales
                        .builder()
                        .cedula(txtCedula.getValue().toString())
                        .build()
        );

        if (!cedula.isEmpty()) {
            idPersona = cedula.getLast().getIdPersona();
        } else {
            idPersona = -1;
        }

        // si es nuevo validamos que la persona no exista
        String accion = "editar";
        if (v_nuevo) {
            accion = "crear";
            if (idPersona > 0) {
                //Preguntar si desea carga la data desde la base de datos.
                int resp = JOptionPane.showInternalConfirmDialog(
                        this,
                        """
                        Persona se encuentra en la base de datos.
                        Desea cargar el registro?
                        """,
                        "",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (resp == JOptionPane.YES_OPTION) {
                    mostrarRegistro();
                    v_nuevo = false;
                }
                return;
            }
        } else {
            idPersona = ((Persona) tblPersonas.getValueAt(
                    tblPersonas.getSelectedRow(), 2
            )).getIdPersona();
        }

        int resp = JOptionPane.showInternalConfirmDialog(
                this,
                "<html><b>Se va a " + accion + " la persona: </b>"
                + txtPNombre.getText()
                + (txtSNombre.getText().isEmpty() || txtSNombre.getText().isBlank()
                ? "" : " " + txtSNombre.getText())
                + " " + txtApellidos.getText()
                + "<br><b>Cedula no.: </b> " + txtCedula.getText()
                + "<br><b>Fecha Nacimiento: </b>" + Utilidades.formatDate(
                        dchFechaNacimiento.getDate(),
                        "dd-MM-yyyy"
                )
                + "<br><b>Estado de la persona: </b>" + cbEstado.getText()
                + "<br><b>Desea continuar? </b></html>",
                """
                """,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        Persona persona = Persona
                .builder()
                .idPersona(idPersona)
                .persona(
                        ((TipoPersona) jcbPersona.getSelectedItem())
                                .getAbreviatura()
                )
                .sexo(
                        ((Sexo) jcbSexo.getSelectedItem())
                                .getAbreviatura()
                )
                .pnombre(txtPNombre.getText())
                .snombre(txtSNombre.getText())
                .apellidos(txtApellidos.getText())
                .fecha_nacimiento(
                        new java.sql.Date(
                                dchFechaNacimiento.getDate().getTime()
                        )
                )
                .estado(cbEstado.isSelected())
                .build();

        Resultado resultadoIUPersona = (v_nuevo ? M_Persona.insert(persona) : M_Persona.update(persona));

        if (!resultadoIUPersona.getEstado()) {
            mensajeResultado(
                    resultadoIUPersona,
                    false
            );
            return;
        }

        mensajeResultado(
                M_Generales.updateOrInsert(
                        Generales
                                .builder()
                                .idPersona(resultadoIUPersona.getId())
                                .cedula(txtCedula.getValue().toString())
                                .estado_civil(
                                        ((EstadoCivil) jcbEstadoCivil.getSelectedItem())
                                                .getAbreviatura()
                                )
                                .idTipoSangre(0)
                                .build()
                ),
                false
        );
        
        if (v_nuevo && resultadoIUPersona.getEstado()) {

            v_direccionesList.stream().forEach(
                    direccion -> {
                        mensajeResultado(
                                M_ContactoDireccion.updateOrInsert(
                                        ContactoDireccion
                                                .builder()
                                                .id(0)
                                                .idPersona(resultadoIUPersona.getId())
                                                .idProvincia(direccion.getIdProvincia())
                                                .idMunicipio(direccion.getIdMunicipio())
                                                .idDistritoMunicipal(direccion.getIdDistritoMunicipal())
                                                .idCodigoPostal(direccion.getIdCodigoPostal())
                                                .direccion(direccion.getDireccion())
                                                .porDefecto(direccion.getPorDefecto())
                                                .build()
                                ),
                                false
                        );
                    }
            );

            v_contactosTelsList.stream().forEach(
                    contacto -> {
                        mensajeResultado(
                                M_ContactoTel.insert(
                                        ContactoTel
                                                .builder()
                                                .idPersona(resultadoIUPersona.getId())
                                                .telefono(contacto.getTelefono())
                                                .tipo(contacto.getTipo())
                                                .porDefecto(contacto.getPorDefecto())
                                                .build()
                                ),
                                false
                        );
                    }
            );

            v_contactosCorreosList.stream().forEach(
                    contacto -> {
                        mensajeResultado(
                                M_ContactoEmail.insert(
                                        ContactoEmail
                                                .builder()
                                                .idPersona(resultadoIUPersona.getId())
                                                .email(contacto.getEmail())
                                                .porDefecto(contacto.getPorDefecto())
                                                .build()
                                ),
                                false
                        );
                    }
            );
        } else {

        }

        JOptionPane.showInternalMessageDialog(
                this,
                resultadoIUPersona,
                "",
                resultadoIUPersona.getIcono()
        );

        if (resultadoIUPersona.getEstado()) {
            btnCancelarRegistroActionPerformed(evt);
            limpiarListas();
            v_nuevo = null;
        }
    }//GEN-LAST:event_btnGuardarRegistroActionPerformed

    private void btnCancelarRegistroActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelarRegistroActionPerformed
        //Botones Para habilitar:
        cambioBoton(false);
        limpiarListas();
        limpiarTablasDirTelCorr();
    }//GEN-LAST:event_btnCancelarRegistroActionPerformed

    private void txtCedulaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        btnCedulaValidad.requestFocus();
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtCedulaKeyPressed(KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyPressed
        /**
         * El objectivo del siguiente codigo es generar una cedula valida para
         * fines de pruebas del sistema.
         */
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        txtCedula.setText(
                                M_Generales.generarCedula()
                        );

                        if (Utilidades.validarCampo(txtCedula)) {
                            System.out.println("Cedula OK.");
                        } else {
                            System.out.println("Cedula no cumple.");
                        }

                    }
                }
            }
        }
    }//GEN-LAST:event_txtCedulaKeyPressed

    private void jcbPersonaPopupMenuWillBecomeInvisible(PopupMenuEvent evt) {//GEN-FIRST:event_jcbPersonaPopupMenuWillBecomeInvisible
        dchFechaNacimiento.requestFocus();
        v_editor.requestFocus();
    }//GEN-LAST:event_jcbPersonaPopupMenuWillBecomeInvisible

    private void cbEstadoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        if (cbEstado.isSelected()) {
            cbEstado.setText("Activo");
        } else {
            cbEstado.setText("Inactivo");
        }
        btnGuardarRegistro.requestFocus();
    }//GEN-LAST:event_cbEstadoActionPerformed

    private void txtPNombreActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txtPNombreActionPerformed
        txtSNombre.requestFocus();
    }//GEN-LAST:event_txtPNombreActionPerformed

    private void txtSNombreActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txtSNombreActionPerformed
        if (txtPNombre.getText().isBlank() && !txtSNombre.getText().isEmpty()) {
            txtPNombre.setText(txtSNombre.getText());
            txtSNombre.setText("");
        }
        txtApellidos.requestFocus();
    }//GEN-LAST:event_txtSNombreActionPerformed

    private void txtApellidosActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        jcbPersona.requestFocus();
        jcbPersona.showPopup();

    }//GEN-LAST:event_txtApellidosActionPerformed

    private void jcbEstadoCivilPopupMenuWillBecomeInvisible(PopupMenuEvent evt) {//GEN-FIRST:event_jcbEstadoCivilPopupMenuWillBecomeInvisible
        jcbSexo.requestFocus();
        jcbSexo.showPopup();
    }//GEN-LAST:event_jcbEstadoCivilPopupMenuWillBecomeInvisible


    private void btnAgregarDireccionesActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnAgregarDireccionesActionPerformed
        //Nos aseguramos que exista una provincia seleccionada.
        if (jcbProvincias.getSelectedIndex() < 1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar una provincia.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            jcbProvincias.requestFocus();
            jcbProvincias.showPopup();
            return;
        }

        //Nos aseguramos que exiista un municipio seleccionado
        if (jcbMunicipios.getSelectedIndex() < 1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar un municipio.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            jcbMunicipios.requestFocus();
            jcbMunicipios.showPopup();
            return;
        }

        //La direccion residencia debe escribirse en la caja de texto de direccion.
        if (txtDireccion.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar dirección.!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtDireccion.requestFocus();
            return;
        }

        //Se pregunta si la direccion es por defecto.
        int resp = JOptionPane.showInternalConfirmDialog(
                this,
                """
                    Es la dirección por defecto de la persona?
                    """,
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        Boolean porDefecto = resp == JOptionPane.YES_OPTION;

        //Se preparan la provincia, municipio y el distrito municipal.
        Integer id_direccion = -1;

        if (!v_nuevo && tblDireccion.getSelectedRow() >= 0) {
            id_direccion = ((ContactoDireccion) tblDireccion.getValueAt(
                    tblDireccion.getSelectedRow(),
                    3
            )).getId();
        }

        ContactoDireccion direccion = ContactoDireccion
                .builder()
                .id(id_direccion)
                .idPersona(idPersona)
                .idProvincia(
                        ((Provincia) jcbProvincias.getSelectedItem()).getId()
                )
                .idMunicipio(
                        ((Municipio) jcbMunicipios.getSelectedItem()).getId()
                )
                .idDistritoMunicipal(((DistritoMunicipal) jcbDistritoMunicipal.getSelectedItem()).getId()
                )
                .direccion(txtDireccion.getText())
                .estado(Boolean.TRUE)
                .porDefecto(porDefecto)
                .fecha(new java.sql.Date(Calendar.getInstance().getTimeInMillis()))
                .build();

        if (v_nuevo) {
            if (porDefecto) {
                v_direccionesList = v_direccionesList.stream().map(
                        dir -> {
                            return ContactoDireccion
                                    .builder()
                                    .id(dir.getId())
                                    .idPersona(dir.getIdPersona())
                                    .idProvincia(dir.getIdProvincia())
                                    .idMunicipio(dir.getIdMunicipio())
                                    .idDistritoMunicipal(dir.getIdDistritoMunicipal())
                                    .direccion(dir.getDireccion())
                                    .estado(dir.getEstado())
                                    .porDefecto(Boolean.FALSE)
                                    .fecha(new java.sql.Date(
                                            Calendar.getInstance().getTimeInMillis())
                                    )
                                    .build();
                        }
                ).collect(Collectors.toList());
            }

            v_direccionesList.add(direccion);

            limpiarTablaDireccion();

            registro = new Object[TITULOS_DIRECCION.length];

            v_direccionesList.stream().forEach(
                    dir -> {

                        registro[0] = (M_Provincia.select(
                                Provincia
                                        .builder()
                                        .id(dir.getIdProvincia())
                                        .build()
                        ).getLast());

                        registro[1] = (M_Municipio.select(
                                Municipio
                                        .builder()
                                        .id(dir.getIdMunicipio())
                                        .build()
                        ).getLast());

                        registro[2] = (M_DistritoMunicipal.select(
                                DistritoMunicipal
                                        .builder()
                                        .id(dir.getIdDistritoMunicipal())
                                        .build()
                        ).getLast());

                        registro[3] = dir.getDireccion();
                        registro[4] = dir.getFecha();
                        registro[5] = dir.getEstado();
                        registro[6] = dir.getPorDefecto();
                        v_dtmDireccion.addRow(registro);
                    }
            );

            tblDireccion.setModel(v_dtmDireccion);
        } else {
            M_ContactoDireccion.updateOrInsert(direccion);
            llenarTablaDirreciones(idPersona);
        }

        LimpiarComboBoxProMuniDistr();
    }//GEN-LAST:event_btnAgregarDireccionesActionPerformed

    private void btnBorrarDirrecionActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnBorrarDirrecionActionPerformed
        Utilidades.eliminarRegistroTabla(
                tblDireccion,
                v_dtmDireccion,
                v_direccionesList
        );

        btnDireccionEnable(false);

        LimpiarComboBoxProMuniDistr();
    }//GEN-LAST:event_btnBorrarDirrecionActionPerformed

    private void txtDireccionActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        btnAgregarDirecciones.doClick();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtTelelfonoMovilActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txtTelelfonoMovilActionPerformed
        btnAgregarTelefonoMovil.doClick();
    }//GEN-LAST:event_txtTelelfonoMovilActionPerformed

    private void txtTelelfonoMovilKeyPressed(KeyEvent evt) {//GEN-FIRST:event_txtTelelfonoMovilKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        txtTelelfonoMovil.setText(
                                M_ContactoTel.generarTelMovil()
                        );
                        int numero = (int) (Math.random() * 10);
                        jrbMovil.setSelected((numero % 2) == 0);
                        jrbResidencial.setSelected((numero % 2) != 0);
                    }
                }
            }
        }
    }//GEN-LAST:event_txtTelelfonoMovilKeyPressed

    private void btnAgregarTelefonoMovilActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnAgregarTelefonoMovilActionPerformed
        if (Utilidades.validarCampo(txtTelelfonoMovil)) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar numero telefonico valido!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            limpiarTxtTelefonoMovil();
            return;
        }

        if (!M_ContactoTel.telefono(
                txtTelelfonoMovil.getValue().toString()
        )) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar numero telefonico valido!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            limpiarTxtTelefonoMovil();
            return;
        }
        //Se pregunta si la direccion es por defecto.
        int resp = JOptionPane.showInternalConfirmDialog(
                this,
                """
                    Es el telefono por defecto de la persona?
                    """,
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        Boolean por_defecto = resp == JOptionPane.YES_OPTION;

        Integer id_telefono = -1;

        if (!v_nuevo && tblTelefonos.getSelectedRow() >= 0) {
            id_telefono = ((ContactoDireccion) tblTelefonos.getValueAt(
                    tblTelefonos.getSelectedRow(),
                    0)).getId();
        }

        ContactoTel contactoTel = ContactoTel
                .builder()
                .id(id_telefono)
                .idPersona(idPersona)
                .telefono(txtTelelfonoMovil.getValue().toString())
                .tipo((jrbMovil.isSelected() ? "Movil" : "Telefono"))
                .fecha(new java.sql.Date(Calendar.getInstance().getTimeInMillis()))
                .estado(Boolean.TRUE)
                .porDefecto(por_defecto)
                .build();

        if (v_nuevo) {
            if (por_defecto) {
                v_contactosTelsList = v_contactosTelsList
                        .stream()
                        .map(tel -> {
                            return ContactoTel
                                    .builder()
                                    .id(tel.getId())
                                    .idPersona(tel.getIdPersona())
                                    .telefono(tel.getTelefono())
                                    .tipo(tel.getTipo())
                                    .fecha(tel.getFecha())
                                    .estado(tel.getEstado())
                                    .porDefecto(Boolean.FALSE)
                                    .build();
                        })
                        .collect(Collectors.toList());
            }

            v_contactosTelsList.add(
                    contactoTel
            );

            limpiarTablaTelefono();
            registro = new Object[TITULOS_TELEFONO.length];
            v_contactosTelsList.stream().forEach(telef -> {
                registro[0] = telef.getTelefono();
                registro[1] = telef.getTipo();
                registro[2] = telef.getFecha();
                registro[3] = telef.getEstado();
                registro[4] = telef.getPorDefecto();
                v_dtmTelefono.addRow(registro);
            });
            tblTelefonos.setModel(v_dtmTelefono);
        } else {
            M_ContactoTel.insert(contactoTel);
            llenarTablaTelefonos(idPersona);
        }

        limpiarTxtTelefonoMovil();
    }//GEN-LAST:event_btnAgregarTelefonoMovilActionPerformed

    private void limpiarTxtTelefonoMovil() {
        txtTelelfonoMovil.setValue("");
        txtTelelfonoMovil.requestFocus();
        jrbMovil.setSelected(true);
    }

    private void btnBorrarTelefonoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnBorrarTelefonoActionPerformed

        if (v_nuevo) {

        } else {

        }

        Utilidades.eliminarRegistroTabla(tblTelefonos, v_dtmTelefono, v_contactosTelsList);

        btnBorrarTelefono.setEnabled(false);
        btnTelefonoEnable(false);
    }//GEN-LAST:event_btnBorrarTelefonoActionPerformed

    private void btnAgregarCorreoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnAgregarCorreoActionPerformed
        //Validamos que el correo no esté vacio.
        if (txtCorreo.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar correo electronico.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtCorreo.requestFocus();
            return;
        }

        //Verificamos que sea un correo valido.
        if (!M_ContactoEmail.correo(
                txtCorreo.getText()
        )) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar correo electronico valido.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtCorreo.requestFocus();
            return;
        }

        int resp = JOptionPane.showInternalConfirmDialog(
                this,
                """
                Es el correo por defecto de la persona?
                """,
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        Boolean por_defecto = resp == JOptionPane.YES_OPTION;

        Integer id_correo = -1;

        if (!v_nuevo && tblCorreos.getSelectedRow() >= 0) {
            id_correo = ((ContactoEmail) tblCorreos.getValueAt(
                    tblCorreos.getSelectedRow(), 0
            )).getId();
        }

        ContactoEmail contactoEmail
                = ContactoEmail
                        .builder()
                        .id(id_correo)
                        .idPersona(idPersona)
                        .email(txtCorreo.getText())
                        .estado(Boolean.TRUE)
                        .fecha(
                                new java.sql.Date(
                                        Calendar.getInstance().getTimeInMillis()
                                )
                        )
                        .porDefecto(por_defecto)
                        .build();

        if (v_nuevo) {
            if (por_defecto) {
                v_contactosCorreosList = v_contactosCorreosList
                        .stream()
                        .map(
                                correo -> {
                                    return ContactoEmail
                                            .builder()
                                            .id(correo.getId())
                                            .idPersona(correo.getIdPersona())
                                            .email(correo.getEmail())
                                            .fecha(correo.getFecha())
                                            .estado(correo.getEstado())
                                            .porDefecto(Boolean.FALSE)
                                            .build();
                                }
                        )
                        .collect(Collectors.toList());
            }

            limpiarTablaCorreo();

            v_contactosCorreosList.add(contactoEmail);

            registro = new Object[TITULOS_CORREO.length];

            v_contactosCorreosList.stream().forEach(correo -> {
                registro[0] = correo.getEmail();
                registro[1] = correo.getFecha();
                registro[2] = correo.getEstado();
                registro[3] = correo.getPorDefecto();
                v_dtmCorreo.addRow(registro);
            });

            tblCorreos.setModel(v_dtmCorreo);
        } else {
            M_ContactoEmail.insert(contactoEmail);
            llenarTablaCorreos(idPersona);
        }

        txtCorreo.setText("");
        txtCorreo.requestFocus();
    }//GEN-LAST:event_btnAgregarCorreoActionPerformed

    private void btnBorrarCorreoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnBorrarCorreoActionPerformed

        if (v_nuevo) {

        } else {

        }

        Utilidades.eliminarRegistroTabla(
                tblCorreos,
                v_dtmCorreo,
                v_contactosCorreosList
        );
        btnCorreoEnable(false);

    }//GEN-LAST:event_btnBorrarCorreoActionPerformed

    private void btnCedulaValidadActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCedulaValidadActionPerformed

        if (Utilidades.validarCampo(txtCedula)) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    """
                    Digite una cedula valida.
                    """,
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtCedula.setValue(null);
            txtCedula.requestFocus();
            return;
        }

        if (txtCedula.getValue().toString().equals("000-0000000-0")) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    """
                    Cedula GENERICA del sistema.
                    Modifique la cedula de la persona.
                    """,
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtCedula.setValue(null);
            txtCedula.requestFocus();
            return;
        }

        var listaCedula = M_Generales.select(
                Generales
                        .builder()
                        .cedula(txtCedula.getValue().toString())
                        .build()
        );

        if (listaCedula.isEmpty()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Cedula valida, puede continuar.",
                    "",
                    JOptionPane.INFORMATION_MESSAGE
            );
            txtPNombre.requestFocus();
        } else {

            System.out.println("idPersona: %d".formatted(listaCedula.getLast().getIdPersona()));
            Persona persona = M_Persona.select(
                    Persona
                            .builder()
                            .idPersona(listaCedula.getLast().getIdPersona())
                            .build()
            ).getFirst();

            if (v_nuevo) {
                boolean valor = Boolean.logicalAnd(
                        listaCedula.getLast().getIdPersona() > 0,
                        !persona.getEstado()
                );

                if (valor) {
                    int resp = JOptionPane.showInternalConfirmDialog(
                            this,
                            """
                            Esta persona está registrada y de estado inactivo.
                            Procede a habilitar a la persona?
                            """,
                            "",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );

                    //Preguntamos si desea cargar la informacion de la persona.
                    if (resp == JOptionPane.NO_OPTION) {
                        btnCancelarRegistroActionPerformed(evt);
                        return;
                    }

                    //habilitando a la persona en el sistema.
                    M_Persona.update(
                            Persona
                                    .builder()
                                    .idPersona(persona.getIdPersona())
                                    .persona(persona.getPersona())
                                    .pnombre(persona.getPnombre())
                                    .snombre(persona.getSnombre())
                                    .apellidos(persona.getApellidos())
                                    .sexo(persona.getSexo())
                                    .fecha_nacimiento(persona.getFecha_nacimiento())
                                    .estado(Boolean.TRUE)
                                    .build()
                    );

                    btnCancelarRegistroActionPerformed(evt);
                }
            } else {
                JOptionPane.showInternalMessageDialog(
                        this,
                        """
                        Esta cedula se encuentra registrada en el sistema.
                        """,
                        "",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_btnCedulaValidadActionPerformed
    private void formInternalFrameOpened(InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        btnBotonesPrivilegios();
    }//GEN-LAST:event_formInternalFrameOpened

    private static void btnBotonesPrivilegios() {
        //1) Llenar la lista de personas en el sistema.
        llenarTablaPersonas();

        //2) Llenar los comboBox de las provincias.
        jcbProvincias.removeAllItems();
        M_Provincia.select(
                Provincia
                        .builder()
                        .build()
        ).forEach(
                provincia -> {
                    jcbProvincias.addItem(provincia);
                }
        );

        //3) Llenar los comboBox de las personas juridicas.
        jcbPersona.removeAllItems();
        M_TipoPersona.getTipoPersonaList().stream().forEach(
                tipoPersona -> jcbPersona.addItem(tipoPersona)
        );

        //4) Obtener la lista de sexo de personas.
        jcbSexo.removeAllItems();
        M_Sexo.getSexoList().stream().forEach(
                sexo -> jcbSexo.addItem(sexo)
        );

        //5) Obtener la lista de estado civil de las personas.
        jcbEstadoCivil.removeAllItems();
        M_EstadoCivil.getEstadoCivilList().stream().forEach(
                estadoCivil -> jcbEstadoCivil.addItem(estadoCivil)
        );

        //Validando los botones por consultas.
        //Permiso para el boton de nuevo
        btnNuevaPersona.setEnabled(
                M_Privilegio.privilegio(
                        Privilegio
                                .builder()
                                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
                                .nombre_relacion("SP_I_PERSONA")
                                .nombre_campo("^")
                                .build()
                )
        //                && M_Privilegio.privilegio(
        //                        Privilegio
        //                                .builder()
        //                                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
        //                                .nombre_relacion("SP_I_PERSONA_CLIENTE")
        //                                .nombre_campo("^")
        //                                .build()
        //                )
        );

        //Permiso para el boton de Borrar
        btnBorrarPersona.setEnabled(
                M_Privilegio.privilegio(
                        Privilegio
                                .builder()
                                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
                                .nombre_relacion("SP_D_PERSONA")
                                .nombre_campo("^")
                                .build()
                )
        );

        jcbCliente.setEnabled(
                M_Privilegio.privilegio(
                        Privilegio
                                .builder()
                                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
                                .nombre_relacion("SP_D_PERSONA_CLIENTE")
                                .nombre_campo("^")
                                .build()
                )
        );

        //Permiso para el boton de Modificar
        btnModificarPersona.setEnabled(
                M_Privilegio.privilegio(
                        Privilegio
                                .builder()
                                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
                                .nombre_relacion("SP_U_PERSONA")
                                .nombre_campo("^")
                                .build()
                )
        );
    }

    private void txtCorreoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        btnAgregarCorreo.doClick();
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtCorreoKeyPressed(KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        txtCorreo.setText(
                                M_ContactoEmail.generarCorreo()
                        );
                    }
                }
            }
        }
    }//GEN-LAST:event_txtCorreoKeyPressed
    /**
     * Para una direccion ser modificada debe cumplir lo siguente:
     *
     * 1) No contener ningun registros en facturas.
     *
     * 2) Al editar una factura se debe: 1) Deshabilitar el boton de borrar
     * registro.
     *
     * @param evt
     */
    private void btnEditarDireccionActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnEditarDireccionActionPerformed
        if (tblDireccion.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar un registro a modificar.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        int provinciaTbl = ((Provincia) tblDireccion.getValueAt(
                tblDireccion.getSelectedRow(), 0)).getId();

        int municipioTbl = ((Municipio) tblDireccion.getValueAt(
                tblDireccion.getSelectedRow(), 1)).getId();

        int distritoTbl = ((DistritoMunicipal) tblDireccion.getValueAt(
                tblDireccion.getSelectedRow(), 2)).getId();

        String direccion = tblDireccion.getValueAt(
                tblDireccion.getSelectedRow(), 3).toString();

//        int idRegistro = ((ContactoDireccion) tblDireccion.getValueAt(
//                tblDireccion.getSelectedRow(), 3)).getId();
        for (int i = 0; i < jcbProvincias.getItemCount(); i++) {
            int provinciaCombo = jcbProvincias.getItemAt(i).getId();
            if (provinciaCombo == provinciaTbl) {
                jcbProvincias.setSelectedIndex(i);
                break;
            }
        }

        for (int i = 0; i < jcbMunicipios.getItemCount(); i++) {
            int municipioCombo = jcbMunicipios.getItemAt(i).getId();
            if (municipioCombo == municipioTbl) {
                jcbMunicipios.setSelectedIndex(i);
                break;
            }
        }

        for (int i = 0; i < jcbDistritoMunicipal.getItemCount(); i++) {
            int distritoCombo = jcbDistritoMunicipal.getItemAt(i).getId();
            if (distritoCombo == distritoTbl) {
                jcbDistritoMunicipal.setSelectedIndex(i);
                break;
            }
        }

        txtDireccion.setText(direccion);

        btnDireccionEnable(false);

    }//GEN-LAST:event_btnEditarDireccionActionPerformed

    private void jtpGeneralesDireccionContactosKeyPressed(KeyEvent evt) {//GEN-FIRST:event_jtpGeneralesDireccionContactosKeyPressed
        if (evt.isControlDown()) {
            if (evt.getKeyCode() == KeyEvent.VK_1) {
                jtpGeneralesDireccionContactos.setSelectedIndex(
                        jtpGeneralesDireccionContactos.indexOfComponent(jpGenerales)
                );
            }
            if (evt.getKeyCode() == KeyEvent.VK_2) {
                jtpGeneralesDireccionContactos.setSelectedIndex(
                        jtpGeneralesDireccionContactos.indexOfComponent(jpDireccion)
                );
            }
            if (evt.getKeyCode() == KeyEvent.VK_3) {
                jtpGeneralesDireccionContactos.setSelectedIndex(
                        jtpGeneralesDireccionContactos.indexOfComponent(jpContactos)
                );
            }
        }
    }//GEN-LAST:event_jtpGeneralesDireccionContactosKeyPressed

    private void jsCantidadFilasStateChanged(ChangeEvent evt) {//GEN-FIRST:event_jsCantidadFilasStateChanged
        llenarTablaPersonas();
    }//GEN-LAST:event_jsCantidadFilasStateChanged

    private void jsPaginaNroStateChanged(ChangeEvent evt) {//GEN-FIRST:event_jsPaginaNroStateChanged
        llenarTablaPersonas();
    }//GEN-LAST:event_jsPaginaNroStateChanged

    private void btnActualizarRegistrosPersonaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnActualizarRegistrosPersonaActionPerformed
        llenarTablaPersonas();
    }//GEN-LAST:event_btnActualizarRegistrosPersonaActionPerformed

    private void formInternalFrameActivated(InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

    }//GEN-LAST:event_formInternalFrameActivated

    private void tblDireccionMouseClicked(MouseEvent evt) {//GEN-FIRST:event_tblDireccionMouseClicked
        btnDireccionEnable(true);
    }//GEN-LAST:event_tblDireccionMouseClicked

    private void btnEditarTelefonoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnEditarTelefonoActionPerformed
        btnTelefonoEnable(false);
    }//GEN-LAST:event_btnEditarTelefonoActionPerformed

    private void btnEditarCorreoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnEditarCorreoActionPerformed
        btnCorreoEnable(false);
    }//GEN-LAST:event_btnEditarCorreoActionPerformed

    private void tblTelefonosMouseClicked(MouseEvent evt) {//GEN-FIRST:event_tblTelefonosMouseClicked
        btnTelefonoEnable(true);
    }//GEN-LAST:event_tblTelefonosMouseClicked

    private void tblCorreosMouseClicked(MouseEvent evt) {//GEN-FIRST:event_tblCorreosMouseClicked
        btnCorreoEnable(true);
    }//GEN-LAST:event_tblCorreosMouseClicked

    private void jcbSexoPopupMenuWillBecomeInvisible(PopupMenuEvent evt) {//GEN-FIRST:event_jcbSexoPopupMenuWillBecomeInvisible
        if (jcbSexo.getSelectedIndex() > 0) {
            jtpGeneralesDireccionContactos.setSelectedIndex(
                    jtpGeneralesDireccionContactos.indexOfComponent(jpDireccion)
            );
        }
    }//GEN-LAST:event_jcbSexoPopupMenuWillBecomeInvisible

    private void jcbProvinciasActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jcbProvinciasActionPerformed
        jcbMunicipios.removeAllItems();

        if (jcbProvincias.getSelectedIndex() > 0) {
            M_Municipio.select(
                    Municipio
                            .builder()
                            .id(0)
                            .idProvincia(
                                    jcbProvincias.getItemAt(
                                            jcbProvincias.getSelectedIndex()
                                    ).getId()
                            )
                            .build()
            ).stream().forEach(
                    municipio -> jcbMunicipios.addItem(municipio)
            );
            jcbMunicipios.setEnabled(true);
            jcbMunicipios.requestFocus();
        } else {
            jcbMunicipios.setEnabled(false);
        }
    }//GEN-LAST:event_jcbProvinciasActionPerformed

    private void jcbProvinciasKeyPressed(KeyEvent evt) {//GEN-FIRST:event_jcbProvinciasKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        int cantidad = jcbProvincias.getItemCount();
                        if (cantidad != 0) {
                            int randon = (int) (Math.random() * cantidad);
                            if (randon == 0) {
                                randon++;
                            }
                            jcbProvincias.setSelectedIndex(randon);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jcbProvinciasKeyPressed

    private void jcbMunicipiosActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jcbMunicipiosActionPerformed
        jcbDistritoMunicipal.removeAllItems();

        if (jcbMunicipios.getSelectedIndex() > 0) {
            M_DistritoMunicipal.select(
                    DistritoMunicipal
                            .builder()
                            .id(0)
                            .idMunicipio(
                                    jcbMunicipios.getItemAt(
                                            jcbMunicipios.getSelectedIndex()
                                    ).getId()
                            )
                            .build()
            ).stream().forEach(
                    distrito -> {
                        jcbDistritoMunicipal.addItem(distrito);
                    }
            );
            jcbDistritoMunicipal.setEnabled(true);
            jcbDistritoMunicipal.requestFocus();
        } else {
            jcbDistritoMunicipal.setEnabled(false);
        }
    }//GEN-LAST:event_jcbMunicipiosActionPerformed

    private void jcbMunicipiosKeyPressed(KeyEvent evt) {//GEN-FIRST:event_jcbMunicipiosKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        int cantidad = jcbMunicipios.getItemCount();
                        if (cantidad != 0) {
                            int randon = (int) (Math.random() * cantidad);
                            if (randon == 0) {
                                randon++;
                            }
                            jcbMunicipios.setSelectedIndex(randon);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jcbMunicipiosKeyPressed

    private void jcbDistritoMunicipalPopupMenuWillBecomeInvisible(PopupMenuEvent evt) {//GEN-FIRST:event_jcbDistritoMunicipalPopupMenuWillBecomeInvisible
        txtDireccion.requestFocus();
    }//GEN-LAST:event_jcbDistritoMunicipalPopupMenuWillBecomeInvisible

    private void jcbDistritoMunicipalKeyPressed(KeyEvent evt) {//GEN-FIRST:event_jcbDistritoMunicipalKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        int cantidad = jcbDistritoMunicipal.getItemCount();
                        if (cantidad != 0) {
                            int randon = (int) (Math.random() * cantidad);
                            jcbDistritoMunicipal.setSelectedIndex(randon);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jcbDistritoMunicipalKeyPressed

    private void tblPersonasKeyPressed(KeyEvent evt) {//GEN-FIRST:event_tblPersonasKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        int cantidad = tblPersonas.getRowCount();
                        if (cantidad != 0) {
                            int randon = (int) (Math.random() * cantidad);

                            if (randon == 0) {
                                randon = 1;
                            }

                            tblPersonas.setRowSelectionInterval(randon, randon);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_tblPersonasKeyPressed

    /**
     * Este metodo valida que: <br>
     * 1) Que en la tabla de las personas del sistema deben de existir mas de un
     * registros.<br>
     * 2) Que en la tabla haya un elemento seleccionado. <br>
     * 3) Que la persona seleccionado no sea el GENERICO.<br>
     *
     * <hr>
     *
     * @return Devuelve un valor verdadero para indicar que existe una <br>
     * restriccion de las mensionadas, de lo contrario devuelve falso <br>
     * indicando que no existe restriciones.
     */
    private boolean validarRegistro(String accion) {
        //Si la tabla de registro de las personas está vacia devolvemos true
        //para que el proceso no continue.
        if (tblPersonas.getRowCount() <= 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    """
                    Debe contar con una persona registrada.
                    Registre una persona.
                    """,
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }

        //Si no existe un registro seleccionado devolvemos true para que el 
        //proceso no continue
        if (tblPersonas.getSelectedRow() < 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe de seleccionar una persona.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }

        //Verificamos que el registro no sea de una persona generica, de serlo lo 
        // devolvemos true para que el proceso no continue. 
        if (((Generales) tblPersonas.getValueAt(
                tblPersonas.getSelectedRow(),
                0
        )).getIdPersona() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Persona GENERICO no puede ser %s".formatted(accion),
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }
        //Devolvermos falso para que continue.
        return false;
    }

    /**
     * Este metodo debe cambiar el comportamiento de la ventana al pulsar sobre
     * nuevo o editar.<br>
     *
     * @param activo Este parametro es utilizado cuando se va a ingresar o
     * modificar registros a la base de datos.<br><br>
     *
     * <b>Si su valor es verdadero:</b><br>
     * 1) Los botones de nuevo, editar, borrar y buscar deben inhabilitarse.<br>
     * 2) Los botones de guardar y cancelar pasan habilitarse.<br>
     * <br>
     * <b>Si su valor es falso:</b>
     * Lo contrario de cuando su valor es verdadero. <br>
     * 1) Los botones de nuevo, editar, borrar y buscar deben habilitarse. <br>
     * 2) Los botones de guardar y cancelar pasan inhabilitarse.<br><br>
     *
     * Al presionar nuevo o editar debe cambiarse en la vista Mantenimiento.<br>
     *
     * Este metodo se llama desde el boton nuevo y modificar con el valor del
     * parametros true y desde cancelar con el valor del parametro false.
     */
    private void cambioBoton(boolean activo) {
        /*
            Aqui pasan los JScrollPane se alternan con el valor de activo,
        true selecciona el mantenimiento y false selecciona los registros de 
        personas.
         */
        if (activo) {
            jtpPrincipal.addTab("Mantenimiento", jspMantenimiento);
            jtpPrincipal.setSelectedComponent(jspMantenimiento);
            jtpPrincipal.setEnabledAt(jtpPrincipal.indexOfComponent(jspPersonas), false);
        } else {
            jtpPrincipal.setSelectedComponent(jspPersonas);
            jtpPrincipal.remove(jspMantenimiento);
            jtpPrincipal.setEnabledAt(jtpPrincipal.indexOfComponent(jspPersonas), true);
        }

        /*
            Seleccionamos las pestañas de direcciones por defecto.
         */
        jtpGeneralesDireccionContactos.setSelectedComponent(jpGenerales);

        /*
            Si el valor de activo es true, quiere decir que se va a insertar o 
        modificar un registro. Por ende, los botones nuevo, modificar, borrar y 
        buscar se deshabilitan.
        
            En caso contrario si el valor de activo es falso, los botones nuevo,
        modificar, borrar y buscar se habilitan.
         */
        btnNuevaPersona.setEnabled(!activo);
        btnModificarPersona.setEnabled(!activo);
        btnBorrarPersona.setEnabled(!activo);
        btnBuscarPersona.setEnabled(!activo);

        jlFechaCreacion.setVisible(!v_nuevo);

        //Botones de guardar y cancelar
        btnGuardarRegistro.setEnabled(activo);
        btnCancelarRegistro.setEnabled(activo);

        //txt Vaciar
        txtPNombre.setText("");
        txtSNombre.setText("");
        txtApellidos.setText("");
        txtCorreo.setText("");
        txtTelelfonoMovil.setText("");

        //Se setea la fecha actual en el campo.
        dchFechaNacimiento.setDate(new Date());

        cbEstado.setSelected(activo);
        cbEstado.setText(activo ? "Activo" : "Inactivo");

        if (jcbPersona.getItemCount() > 0) {
            jcbPersona.setSelectedIndex(0);
        }

        if (jcbEstadoCivil.getItemCount() > 0) {
            jcbEstadoCivil.setSelectedIndex(0);
        }

        if (jcbSexo.getItemCount() > 0) {
            jcbSexo.setSelectedIndex(0);
        }

        LimpiarComboBoxProMuniDistr();

        txtDireccion.setText("");

        jrbMovil.setSelected(true);

        if (v_nuevo) {
            txtCedula.setText("");
            txtCedula.requestFocus();
        } else {
            txtPNombre.requestFocus();
        }
        //nuevasTablasDirTelCor();
    }

    /**
     * Este metodo permite resetear todas las tablas del modulo a cero
     * registros.
     */
    private void limpiarTablasDirTelCorr() {
        limpiarTablaDireccion();
        limpiarTablaTelefono();
        limpiarTablaCorreo();
    }

    private static void limpiarTablaCorreo() {
        v_dtmCorreo = new DefaultTableModel(null, TITULOS_CORREO);
        tblCorreos.setModel(v_dtmCorreo);
        Utilidades.repararColumnaTable(tblCorreos);
        Utilidades.columnasCheckBox(tblCorreos, new int[]{2, 3});
    }

    private static void limpiarTablaDireccion() {
        v_dtmDireccion = new DefaultTableModel(null, TITULOS_DIRECCION);
        tblDireccion.setModel(v_dtmDireccion);
        Utilidades.repararColumnaTable(tblDireccion);
        Utilidades.columnasCheckBox(tblDireccion, new int[]{5, 6});
    }

    private static void limpiarTablaTelefono() {
        v_dtmTelefono = new DefaultTableModel(null, TITULOS_TELEFONO);
        tblTelefonos.setModel(v_dtmTelefono);
        Utilidades.repararColumnaTable(tblTelefonos);
        Utilidades.columnasCheckBox(tblTelefonos, new int[]{3, 4});
    }

    private void limpiarListas() {
        v_direccionesList.clear();
        v_contactosTelsList.clear();
        v_contactosCorreosList.clear();
    }

    private void btnCorreoEnable(boolean valor) {
        btnEditarCorreo.setEnabled(valor);
        btnBorrarCorreo.setEnabled(valor);
        txtCorreo.requestFocus();
    }

    private void btnTelefonoEnable(boolean valor) {
        btnEditarTelefono.setEnabled(valor);
        btnBorrarTelefono.setEnabled(valor);
        txtTelelfonoMovil.requestFocus();
    }

    private void LimpiarComboBoxProMuniDistr() {
        jcbProvincias.setSelectedIndex(0);
        if (jcbMunicipios.getItemCount() != 0) {
            jcbMunicipios.setSelectedIndex(0);
            jcbMunicipios.removeAllItems();
            jcbMunicipios.setEnabled(false);
        }

        if (jcbDistritoMunicipal.getItemCount() != 0) {
            jcbDistritoMunicipal.setSelectedIndex(0);
            jcbDistritoMunicipal.removeAllItems();
            jcbDistritoMunicipal.setEnabled(false);
        }

        txtDireccion.setText("");
        txtDireccion.requestFocus();
    }

    /**
     * Es el metodo encargado de llenar el formulario de la persona cuando este
     * se va a modificar en la base de datos.<br>
     *
     * El mismo idPersona es utilizado para obtener la lista de direcciones,
     * lista de correo y lista de telefonos del persona.<br\>
     */
    private void mostrarRegistro() {
        List<Persona> lista = M_Persona.select(
                Persona
                        .builder()
                        .idPersona(idPersona)
                        .build()
        );

        if (lista.isEmpty()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Persona no encontrado.!!!",
                    "",
                    JOptionPane.INFORMATION_MESSAGE
            );
            btnCancelarRegistro.doClick();
            return;
        }

        Persona persona = lista.getLast();

        txtPNombre.setText(persona.getPnombre());
        txtSNombre.setText(persona.getSnombre());
        txtApellidos.setText(persona.getApellidos());
        dchFechaNacimiento.setDate(
                Utilidades.sqlDateToUtilDate(
                        persona.getFecha_nacimiento()
                )
        );
        cbEstado.setSelected(persona.getEstado());
        cbEstado.setText(
                persona.getEstado() ? "Activo" : "Inactivo"
        );
        jlFechaCreacion.setText(
                "Fecha de Ingreso: ".concat(
                        persona.getFecha_ingreso().toString()
                )
        );

        //------BUSCAR TIPO DE PERSONA------------------------------------------
        for (int i = 0; i < jcbPersona.getItemCount(); i++) {
            if (persona.getPersona().equals(
                    jcbPersona.getItemAt(i).getAbreviatura()
            )) {
                jcbPersona.setSelectedIndex(i);
                break;
            }
        }

        //-----BUSCAR SEXO------------------------------------------------------
        for (int i = 0; i < jcbSexo.getItemCount(); i++) {
            if (persona.getSexo().equals(
                    jcbSexo.getItemAt(i).getAbreviatura()
            )) {
                jcbSexo.setSelectedIndex(i);
                break;
            }
        }

        //-----GENERALES--------------------------------------------------------
        var listaGenerales = M_Generales.select(
                Generales
                        .builder()
                        .idPersona(idPersona)
                        .build()
        );

        if (!listaGenerales.isEmpty()) {
            txtCedula.setValue(listaGenerales.getLast().getCedula());

            for (int i = 0; i < jcbEstadoCivil.getItemCount(); i++) {
                if (listaGenerales.getLast().getEstado_civil().equals(
                        jcbEstadoCivil.getItemAt(i).getAbreviatura()
                )) {
                    jcbEstadoCivil.setSelectedIndex(i);
                    break;
                }
            }
        } else {
            txtCedula.setValue(
                    Generales
                            .builder()
                            .id(-1)
                            .idPersona(-1)
                            .idTipoSangre(0)
                            .cedula("000-0000000-0")
                            .estado_civil('s')
                            .build()
            );
        }

        //----------------------------------------------------------------------
        limpiarListas();

        llenarTablaDirreciones(idPersona);
        llenarTablaTelefonos(idPersona);
        llenarTablaCorreos(idPersona);
    }

    /**
     * Metodo utilizado para llenar la tabla de personas del sistema.
     *
     * Nota: Este evento Debe ser publico porque este es llamado desde los
     * eventos de Firebird.
     */
    public synchronized static void llenarTablaPersonas() {

        final String[] TITULOS_PERSONA = {"Cedulas", "Persona", "Nombres y Apellidos", "Sexo", "Fecha nacimiento",
            "Fecha Ingreso", "Estado"
        };

        registro = new Object[TITULOS_PERSONA.length];

        DefaultTableModel dtmPersonas = new DefaultTableModel(null, TITULOS_PERSONA) {

            Class[] types = new Class[]{
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

        };

        M_Persona.select(
                Persona
                        .builder()
                        .pagina(
                                Paginas
                                        .builder()
                                        .nCantidadFilas((int) jsCantidadFilas.getValue())
                                        .nPaginaNro((int) jsPaginaNro.getValue())
                                        .build()
                        )
                        .build()
        ).stream().forEach(
                persona -> {

                    var listaCedula = M_Generales.select(
                            Generales
                                    .builder()
                                    .idPersona(persona.getIdPersona())
                                    .build()
                    );
                    Generales general;
                    if (listaCedula.isEmpty()) {
                        general = Generales
                                .builder()
                                .id(-1)
                                .idPersona(-1)
                                .idTipoSangre(0)
                                .cedula("000-0000000-0")
                                .estado_civil('s')
                                .build();
                    } else {
                        general = listaCedula.getLast();
                    }

                    registro[0] = general;
                    registro[1] = String.valueOf(
                            persona.getPersona()
                    ).equalsIgnoreCase("j") ? "JURÍDICA" : "FÍSICA";
                    registro[2] = persona;
                    registro[3] = String.valueOf(
                            persona.getSexo()
                    ).equalsIgnoreCase("M") ? "MASCULINO" : "FEMENINO";
                    registro[4] = Utilidades.formatDate(
                            persona.getFecha_nacimiento(),
                            "dd/MM/yyyy"
                    );
                    registro[5] = Utilidades.formatDate(
                            persona.getFecha_ingreso(),
                            "dd/MM/yyyy"
                    );
                    registro[6] = persona.getEstado();

                    dtmPersonas.addRow(registro);
                }
        );

        tblPersonas.removeAll();
        tblPersonas.setModel(dtmPersonas);
    }

    public static synchronized JTable llenarTablaCorreos(Integer idPersona) {
        if (Objects.isNull(idPersona)) {
            idPersona = frmPersonas.idPersona;
        }
        registro = new Object[TITULOS_CORREO.length];
        limpiarTablaCorreo();
        M_ContactoEmail.selectByID(idPersona).stream().forEach(
                p_correo -> {
                    registro[0] = p_correo;
                    registro[1] = p_correo.getFecha();
                    registro[2] = p_correo.getEstado();
                    registro[3] = p_correo.getPorDefecto();

                    v_contactosCorreosList.add(p_correo);

                    v_dtmCorreo.addRow(registro);
                }
        );
        tblCorreos.setModel(v_dtmCorreo);
        return tblCorreos;
    }

    public static synchronized JTable llenarTablaTelefonos(Integer idPersona) {
        if (Objects.isNull(idPersona)) {
            idPersona = frmPersonas.idPersona;
        }
        registro = new Object[TITULOS_TELEFONO.length];
        limpiarTablaTelefono();
        M_ContactoTel.selectByID(idPersona).stream().forEach(
                p_telefono -> {
                    registro[0] = p_telefono;
                    registro[1] = p_telefono.getTipo();
                    registro[2] = p_telefono.getFecha();
                    registro[3] = p_telefono.getEstado();
                    registro[4] = p_telefono.getPorDefecto();

                    v_contactosTelsList.add(p_telefono);

                    v_dtmTelefono.addRow(registro);
                }
        );
        tblTelefonos.setModel(v_dtmTelefono);
        return tblTelefonos;
    }

    public static synchronized JTable llenarTablaDirreciones(Integer idPersona) {
        if (Objects.isNull(idPersona)) {
            idPersona = frmPersonas.idPersona;
        }
        registro = new Object[TITULOS_DIRECCION.length];
        limpiarTablaDireccion();
        M_ContactoDireccion.selectByID(idPersona).stream().forEach(
                dir -> {
                    registro[0] = (M_Provincia.select(
                            Provincia
                                    .builder()
                                    .id(dir.getIdProvincia())
                                    .build()
                    ).getLast());
                    registro[1] = (M_Municipio.select(
                            Municipio
                                    .builder()
                                    .id(dir.getIdMunicipio())
                                    .build()
                    ).getLast());
                    registro[2] = (M_DistritoMunicipal.select(
                            DistritoMunicipal
                                    .builder()
                                    .id(
                                            dir.getIdDistritoMunicipal()
                                    )
                                    .build()
                    ).getLast());
                    registro[3] = ContactoDireccion
                            .builder()
                            .id(dir.getId())
                            .idPersona(dir.getIdPersona())
                            .direccion(dir.getDireccion())
                            .build();
                    registro[4] = dir.getFecha();
                    registro[5] = dir.getEstado();
                    registro[6] = dir.getPorDefecto();
                    v_direccionesList.add(dir);
                    v_dtmDireccion.addRow(registro);
                }
        );
        tblDireccion.setModel(v_dtmDireccion);
        return tblDireccion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnActualizarRegistrosPersona;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarCorreo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarDirecciones;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarTelefonoMovil;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarCorreo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarDirrecion;
    private static RSMaterialComponent.RSButtonMaterialIconOne btnBorrarPersona;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarTelefono;
    private static RSMaterialComponent.RSButtonMaterialIconOne btnBuscarPersona;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelarRegistro;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCedulaValidad;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditarCorreo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditarDireccion;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditarTelefono;
    private javax.swing.ButtonGroup btnGMovilTelefono;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardarRegistro;
    private static RSMaterialComponent.RSButtonMaterialIconOne btnModificarPersona;
    private static RSMaterialComponent.RSButtonMaterialIconOne btnNuevaPersona;
    private javax.swing.JCheckBox cbEstado;
    private com.toedter.calendar.JDateChooser dchFechaNacimiento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private static javax.swing.JCheckBox jcbCliente;
    private javax.swing.JComboBox<DistritoMunicipal> jcbDistritoMunicipal;
    private javax.swing.JCheckBox jcbEmpleado;
    private static javax.swing.JComboBox<EstadoCivil> jcbEstadoCivil;
    private javax.swing.JCheckBox jcbEstudiante;
    private javax.swing.JCheckBox jcbFiltroCliente;
    private javax.swing.JCheckBox jcbFiltroEmpleado;
    private javax.swing.JCheckBox jcbFiltroEstudiante;
    private javax.swing.JCheckBox jcbFiltroPaciente;
    private javax.swing.JCheckBox jcbFiltroPadre;
    private javax.swing.JCheckBox jcbFiltroProveedor;
    private javax.swing.JCheckBox jcbFiltroTodos;
    private static javax.swing.JComboBox<Municipio> jcbMunicipios;
    private javax.swing.JCheckBox jcbPaciente;
    private javax.swing.JCheckBox jcbPadre;
    private static javax.swing.JComboBox<TipoPersona> jcbPersona;
    private javax.swing.JCheckBox jcbProveedor;
    private static javax.swing.JComboBox<Provincia> jcbProvincias;
    private static javax.swing.JComboBox<Sexo> jcbSexo;
    private javax.swing.JLabel jlFechaCreacion;
    private javax.swing.JPanel jpBotones;
    private javax.swing.JPanel jpBotonesPrincipal;
    private javax.swing.JPanel jpContactos;
    private javax.swing.JPanel jpCorreos;
    private javax.swing.JPanel jpDireccion;
    private javax.swing.JPanel jpGeneral;
    private javax.swing.JPanel jpGenerales;
    private javax.swing.JPanel jpMantenimiento;
    private javax.swing.JPanel jpPersonas;
    private javax.swing.JPanel jpTelefonos;
    private javax.swing.JRadioButton jrbMovil;
    private javax.swing.JRadioButton jrbResidencial;
    private static javax.swing.JSpinner jsCantidadFilas;
    private static javax.swing.JSpinner jsPaginaNro;
    private javax.swing.JScrollPane jspGeneral;
    private javax.swing.JScrollPane jspMantenimiento;
    private javax.swing.JScrollPane jspPersonas;
    private javax.swing.JTabbedPane jtpContactos;
    private javax.swing.JTabbedPane jtpGeneralesDireccionContactos;
    private javax.swing.JTabbedPane jtpPrincipal;
    private static rojerusan.RSTableMetro1 tblCorreos;
    private static rojerusan.RSTableMetro1 tblDireccion;
    private static rojerusan.RSTableMetro1 tblPersonas;
    private static rojerusan.RSTableMetro1 tblTelefonos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JFormattedTextField txtCedula1;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtPNombre;
    private javax.swing.JTextField txtSNombre;
    private javax.swing.JFormattedTextField txtTelelfonoMovil;
    // End of variables declaration//GEN-END:variables
}
