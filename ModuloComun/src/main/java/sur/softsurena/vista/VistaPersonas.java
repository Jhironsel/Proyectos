package sur.softsurena.vista;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.PopupMenuEvent;
import javax.swing.table.DefaultTableModel;
import rojerusan.RSTableMetro1;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.entidades.ContactoDireccion;
import sur.softsurena.entidades.ContactoEmail;
import sur.softsurena.entidades.ContactoTel;
import sur.softsurena.entidades.DistritoMunicipal;
import sur.softsurena.entidades.Empleado;
import sur.softsurena.entidades.Entidades;
import sur.softsurena.entidades.EstadoCivil;
import sur.softsurena.entidades.Estudiante;
import sur.softsurena.entidades.Generales;
import sur.softsurena.entidades.Municipio;
import sur.softsurena.entidades.Paciente;
import sur.softsurena.entidades.Padre;
import sur.softsurena.entidades.Paginas;
import sur.softsurena.entidades.Persona;
import sur.softsurena.entidades.Privilegio;
import sur.softsurena.entidades.Proveedor;
import sur.softsurena.entidades.Provincia;
import sur.softsurena.entidades.Sexo;
import sur.softsurena.entidades.TipoPersona;
import sur.softsurena.metodos.M_Cliente;
import sur.softsurena.metodos.M_ContactoDireccion;
import sur.softsurena.metodos.M_ContactoEmail;
import sur.softsurena.metodos.M_ContactoTel;
import sur.softsurena.metodos.M_DistritoMunicipal;
import sur.softsurena.metodos.M_Empleado;
import sur.softsurena.metodos.M_EstadoCivil;
import sur.softsurena.metodos.M_Estudiante;
import sur.softsurena.metodos.M_Generales;
import sur.softsurena.metodos.M_Municipio;
import sur.softsurena.metodos.M_Paciente;
import sur.softsurena.metodos.M_Padre;
import sur.softsurena.metodos.M_Persona;
import sur.softsurena.metodos.M_Privilegio;
import sur.softsurena.metodos.M_Proveedor;
import sur.softsurena.metodos.M_Provincia;
import sur.softsurena.metodos.M_Sexo;
import sur.softsurena.metodos.M_TipoPersona;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;

public final class VistaPersonas extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Es utilizada para definir los cabezales de las tablas de direcciones.
     */
    final static String[] TITULOS_PERSONA = {
        "Relaccion", "Cedulas", "Persona", "Nombres y Apellidos", "Sexo",
        "Fecha nacimiento", "Fecha Ingreso", "Estado"
    };

    final static String[] TITULOS_DIRECCION = {
        "Provincia", "Municipio", "Distrito M.", "Calle y No. Casa", "Fecha",
        "Estado", "Por defecto"
    };

    /**
     * Es utilizada para definir los cabezales de las tablas de correo.
     */
    final static String[] TITULOS_CORREO = {
        "Correo", "Fecha", "Estado", "Por defecto"
    };

    /**
     * Es utilizada para definir los cabezales de las tablas de telefono.
     */
    final static String[] TITULOS_TELEFONO = {
        "Numero", "Tipo", "Fecha", "Estado", "Por defecto"
    };

    private Boolean v_nuevo = false;

    private JTextFieldDateEditor v_editor = null;

    private static DefaultTableModel v_dtmTelefono, v_dtmCorreo, v_dtmDireccion;

    private static Integer idPersona;

    private void btnDireccionEnable(boolean valor) {
        btnEditarDireccion.setEnabled(valor);
        btnBorrarDirrecion.setEnabled(valor);
        txtDireccion.requestFocus();
    }

    private void mensajeResultado(Resultado resultado) {
        JOptionPane.showMessageDialog(
                this,
                resultado.getMensaje(),
                "",
                resultado.getIcono()
        );
    }

    public VistaPersonas(Entidades entidades) {
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

        //Metodo encargado de inicializar los componentes del formulario.
        initComponents();

        jcbEstadosActionPerformed(null);

        combosEntidades(entidades);

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
        jtpGeneralesDireccionContactos.remove(jpCliente);
        jtpGeneralesDireccionContactos.remove(jpEmpleado);
        jtpGeneralesDireccionContactos.remove(jpEstudiante);
        jtpGeneralesDireccionContactos.remove(jpPaciente);
        jtpGeneralesDireccionContactos.remove(jpPadre);
        jtpGeneralesDireccionContactos.remove(jpProveedor);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGMovilTelefono = new javax.swing.ButtonGroup();
        txtCedula1 = new javax.swing.JFormattedTextField();
        btnGTipoPersona = new javax.swing.ButtonGroup();
        jspGeneral = new javax.swing.JScrollPane();
        jpGeneral = new javax.swing.JPanel();
        jtpPrincipal = new javax.swing.JTabbedPane();
        jspPersonas = new javax.swing.JScrollPane();
        jpPersonas = new javax.swing.JPanel();
        javax.swing.JPanel jPanel11 = new javax.swing.JPanel();
        jsCantidadFilas = new javax.swing.JSpinner();
        jsPaginaNro = new javax.swing.JSpinner();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPersonas = new rojerusan.RSTableMetro1(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
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
        jpCliente = new javax.swing.JPanel();
        jpEmpleado = new javax.swing.JPanel();
        jpEstudiante = new javax.swing.JPanel();
        jpPaciente = new javax.swing.JPanel();
        jpPadre = new javax.swing.JPanel();
        jpProveedor = new javax.swing.JPanel();
        jlFechaCreacion = new javax.swing.JLabel();
        javax.swing.JPanel jpBotones = new javax.swing.JPanel();
        btnNuevaPersona = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificarPersona = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrarPersona = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBuscarPersona = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnGuardarRegistro = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelarRegistro = new RSMaterialComponent.RSButtonMaterialIconOne();
        jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        javax.swing.JMenu jMenu2 = new javax.swing.JMenu();
        jmiActualizar = new javax.swing.JMenuItem();
        javax.swing.JMenu jMenu3 = new javax.swing.JMenu();
        jcbMostrarGenerico = new javax.swing.JCheckBoxMenuItem();
        javax.swing.JMenu jMenu4 = new javax.swing.JMenu();
        jcbEstados = new javax.swing.JCheckBoxMenuItem();
        jcbAmbos = new javax.swing.JCheckBoxMenuItem();
        javax.swing.JMenu jMenu5 = new javax.swing.JMenu();
        jcbFiltroTodos = new javax.swing.JCheckBoxMenuItem();
        jcbFiltroClientes = new javax.swing.JCheckBoxMenuItem();
        jcbFiltroEmpleados = new javax.swing.JCheckBoxMenuItem();
        jcbFiltroEstudiantes = new javax.swing.JCheckBoxMenuItem();
        jcbFiltroPacientes = new javax.swing.JCheckBoxMenuItem();
        jcbFiltroPadres = new javax.swing.JCheckBoxMenuItem();
        jcbFiltroProveedores = new javax.swing.JCheckBoxMenuItem();

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

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 712, Short.MAX_VALUE)
                .addComponent(jsCantidadFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jsPaginaNro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
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
                "Cedula", "Persona", "Nombres y apellidos", "Sexo",
                "Fecha de nacimiento", "Fecha de Ingreso", "Estado"
            }
        ) {
            Class<?>[] types = new Class<?>[] {
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Boolean.class
            };

            public Class<?> getColumnClass(int columnIndex) {
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

        javax.swing.GroupLayout jpPersonasLayout = new javax.swing.GroupLayout(jpPersonas);
        jpPersonas.setLayout(jpPersonasLayout);
        jpPersonasLayout.setHorizontalGroup(
            jpPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPersonasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpPersonasLayout.setVerticalGroup(
            jpPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPersonasLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
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
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5);
        flowLayout1.setAlignOnBaseline(true);
        jPanel14.setLayout(flowLayout1);

        txtCedula.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(37, 45, 223)), "Cedula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
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
        txtCedula.setMaximumSize(new java.awt.Dimension(160, 2147483647));
        txtCedula.setMinimumSize(new java.awt.Dimension(100, 43));
        txtCedula.setName("txtCedula"); // NOI18N
        txtCedula.setPreferredSize(new java.awt.Dimension(150, 43));
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
        txtPNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(37, 45, 223)), "Primer nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
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
        txtSNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(37, 45, 223)), "Segundo nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
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
        txtApellidos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(37, 45, 223)), "Apellidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
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
        jcbPersona.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(37, 45, 223)), "Tipo persona", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
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
        jcbEstadoCivil.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(37, 45, 223)), "Estado civil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
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
        jcbSexo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(37, 45, 223)), "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
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
        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jcbCliente.setText("Cliente");
        jcbCliente.setMaximumSize(new java.awt.Dimension(100, 20));
        jcbCliente.setName("jcbCliente"); // NOI18N
        jcbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClienteActionPerformed(evt);
            }
        });
        jPanel13.add(jcbCliente);

        jcbEmpleado.setText("Empleado");
        jcbEmpleado.setName("jcbEmpleado"); // NOI18N
        jcbEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEmpleadoActionPerformed(evt);
            }
        });
        jPanel13.add(jcbEmpleado);

        jcbEstudiante.setText("Estudiante");
        jcbEstudiante.setName("jcbEstudiante"); // NOI18N
        jcbEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstudianteActionPerformed(evt);
            }
        });
        jPanel13.add(jcbEstudiante);

        jcbPaciente.setText("Paciente");
        jcbPaciente.setName("jcbPaciente"); // NOI18N
        jcbPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPacienteActionPerformed(evt);
            }
        });
        jPanel13.add(jcbPaciente);

        jcbPadre.setText("Padre");
        jcbPadre.setName("jcbPadre"); // NOI18N
        jcbPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPadreActionPerformed(evt);
            }
        });
        jPanel13.add(jcbPadre);

        jcbProveedor.setText("Proveedor");
        jcbProveedor.setName("jcbProveedor"); // NOI18N
        jcbProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProveedorActionPerformed(evt);
            }
        });
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
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
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
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

        jpCliente.setName("jpCliente"); // NOI18N

        javax.swing.GroupLayout jpClienteLayout = new javax.swing.GroupLayout(jpCliente);
        jpCliente.setLayout(jpClienteLayout);
        jpClienteLayout.setHorizontalGroup(
            jpClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpClienteLayout.setVerticalGroup(
            jpClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jtpGeneralesDireccionContactos.addTab("Cliente", jpCliente);

        jpEmpleado.setName("jpEmpleado"); // NOI18N

        javax.swing.GroupLayout jpEmpleadoLayout = new javax.swing.GroupLayout(jpEmpleado);
        jpEmpleado.setLayout(jpEmpleadoLayout);
        jpEmpleadoLayout.setHorizontalGroup(
            jpEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpEmpleadoLayout.setVerticalGroup(
            jpEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jtpGeneralesDireccionContactos.addTab("Empleado", jpEmpleado);

        jpEstudiante.setName("jpEstudiante"); // NOI18N

        javax.swing.GroupLayout jpEstudianteLayout = new javax.swing.GroupLayout(jpEstudiante);
        jpEstudiante.setLayout(jpEstudianteLayout);
        jpEstudianteLayout.setHorizontalGroup(
            jpEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpEstudianteLayout.setVerticalGroup(
            jpEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jtpGeneralesDireccionContactos.addTab("Estudiante", jpEstudiante);

        jpPaciente.setName("jpPaciente"); // NOI18N

        javax.swing.GroupLayout jpPacienteLayout = new javax.swing.GroupLayout(jpPaciente);
        jpPaciente.setLayout(jpPacienteLayout);
        jpPacienteLayout.setHorizontalGroup(
            jpPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpPacienteLayout.setVerticalGroup(
            jpPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jtpGeneralesDireccionContactos.addTab("Paciente", jpPaciente);

        jpPadre.setName("jpPadre"); // NOI18N

        javax.swing.GroupLayout jpPadreLayout = new javax.swing.GroupLayout(jpPadre);
        jpPadre.setLayout(jpPadreLayout);
        jpPadreLayout.setHorizontalGroup(
            jpPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpPadreLayout.setVerticalGroup(
            jpPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jtpGeneralesDireccionContactos.addTab("Padre", jpPadre);

        jpProveedor.setName("jpProveedor"); // NOI18N

        javax.swing.GroupLayout jpProveedorLayout = new javax.swing.GroupLayout(jpProveedor);
        jpProveedor.setLayout(jpProveedorLayout);
        jpProveedorLayout.setHorizontalGroup(
            jpProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpProveedorLayout.setVerticalGroup(
            jpProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jtpGeneralesDireccionContactos.addTab("Proveedor", jpProveedor);

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
                .addComponent(jtpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jspGeneral.setViewportView(jpGeneral);

        jMenuBar1.setName("jMenuBar1"); // NOI18N

        jMenu1.setText("Archivos");
        jMenu1.setName("jMenu1"); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenu2.setName("jMenu2"); // NOI18N

        jmiActualizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiActualizar.setText("Actualizar");
        jmiActualizar.setName("jmiActualizar"); // NOI18N
        jmiActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiActualizarActionPerformed(evt);
            }
        });
        jMenu2.add(jmiActualizar);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Acciones");
        jMenu3.setName("jMenu3"); // NOI18N

        jcbMostrarGenerico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jcbMostrarGenerico.setText("Mostrar generico");
        jcbMostrarGenerico.setName("jcbMostrarGenerico"); // NOI18N
        jcbMostrarGenerico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMostrarGenericoActionPerformed(evt);
            }
        });
        jMenu3.add(jcbMostrarGenerico);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Estados");
        jMenu4.setName("jMenu4"); // NOI18N

        jcbEstados.setSelected(true);
        jcbEstados.setText("Activos");
        jcbEstados.setName("jcbEstados"); // NOI18N
        jcbEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadosActionPerformed(evt);
            }
        });
        jMenu4.add(jcbEstados);

        jcbAmbos.setText("Ambos");
        jcbAmbos.setName("jcbAmbos"); // NOI18N
        jcbAmbos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAmbosActionPerformed(evt);
            }
        });
        jMenu4.add(jcbAmbos);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Filtros de registros");
        jMenu5.setName("jMenu5"); // NOI18N

        btnGTipoPersona.add(jcbFiltroTodos);
        jcbFiltroTodos.setSelected(true);
        jcbFiltroTodos.setText("Todos");
        jcbFiltroTodos.setName("jcbFiltroTodos"); // NOI18N
        jcbFiltroTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltroTodosActionPerformed(evt);
            }
        });
        jMenu5.add(jcbFiltroTodos);

        btnGTipoPersona.add(jcbFiltroClientes);
        jcbFiltroClientes.setText("Clientes");
        jcbFiltroClientes.setName("jcbFiltroClientes"); // NOI18N
        jcbFiltroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltroClientesActionPerformed(evt);
            }
        });
        jMenu5.add(jcbFiltroClientes);

        btnGTipoPersona.add(jcbFiltroEmpleados);
        jcbFiltroEmpleados.setText("Empleados");
        jcbFiltroEmpleados.setName("jcbFiltroEmpleados"); // NOI18N
        jcbFiltroEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltroEmpleadosActionPerformed(evt);
            }
        });
        jMenu5.add(jcbFiltroEmpleados);

        btnGTipoPersona.add(jcbFiltroEstudiantes);
        jcbFiltroEstudiantes.setText("Estudiantes");
        jcbFiltroEstudiantes.setName("jcbFiltroEstudiantes"); // NOI18N
        jcbFiltroEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltroEstudiantesActionPerformed(evt);
            }
        });
        jMenu5.add(jcbFiltroEstudiantes);

        btnGTipoPersona.add(jcbFiltroPacientes);
        jcbFiltroPacientes.setText("Pacientes");
        jcbFiltroPacientes.setName("jcbFiltroPacientes"); // NOI18N
        jcbFiltroPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltroPacientesActionPerformed(evt);
            }
        });
        jMenu5.add(jcbFiltroPacientes);

        btnGTipoPersona.add(jcbFiltroPadres);
        jcbFiltroPadres.setText("Padres");
        jcbFiltroPadres.setName("jcbFiltroPadres"); // NOI18N
        jcbFiltroPadres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltroPadresActionPerformed(evt);
            }
        });
        jMenu5.add(jcbFiltroPadres);

        btnGTipoPersona.add(jcbFiltroProveedores);
        jcbFiltroProveedores.setText("Proveedores");
        jcbFiltroProveedores.setName("jcbFiltroProveedores"); // NOI18N
        jcbFiltroProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltroProveedoresActionPerformed(evt);
            }
        });
        jMenu5.add(jcbFiltroProveedores);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jspGeneral)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jspGeneral)
                .addGap(0, 0, 0))
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
        v_nuevo = false;
        cambioBoton(true);
        limpiarTablasDirTelCorr();

        mostrarRegistro();
    }//GEN-LAST:event_btnModificarPersonaActionPerformed

    private void btnBorrarPersonaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnBorrarPersonaActionPerformed
        //Validamos que está correcto en la tabla.
        //Si el metodo devuelve true devolvemos el proceso.
        if (validarRegistro("eliminar.")) {
            return;
        }

        if (validarEntidades(idPersona)) {
            return;
        }

        //Mostramos un mensaje de advertencia si el usuario desea continuar con
        //la eliminación del registro.
        if (JOptionPane.showInternalConfirmDialog(
                this,
                "¿Esta Seguro de eliminar registro de la persona?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.NO_OPTION) {
            return;
        }

        //Mandamos a borrar la persona y obtenemos el resultado de la operacion
        //y almacenamos en una variable.
        Resultado resultados = M_Persona.delete(
                Persona
                        .builder()
                        .idPersona(idPersona)
                        .build()
        );

        JOptionPane.showInternalMessageDialog(
                this,
                resultados,
                "",
                resultados.getIcono()
        );

        llenarTablaPersonas();
    }//GEN-LAST:event_btnBorrarPersonaActionPerformed

    private void btnBuscarPersonaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnBuscarPersonaActionPerformed
        txtCedula1.setValue(null);
        //Utilidades.showTooltip(txtCedula1);
        JOptionPane.showInternalMessageDialog(
                this,
                txtCedula1,
                "Ingresa cedula de la persona.",
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

        Generales generales = M_Generales.select(
                Generales
                        .builder()
                        .cedula(txtCedula1.getValue().toString())
                        .build()
        ).stream().findFirst().orElseThrow();

        if (generales.getIdPersona() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "No se encontro registros.",
                    "",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        llenarTablaPersonas(
                Persona
                        .builder()
                        .idPersona(generales.getIdPersona())
                        .build()
        );
    }//GEN-LAST:event_btnBuscarPersonaActionPerformed

    private void btnGuardarRegistroActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnGuardarRegistroActionPerformed
        var guardarCedula = validarCampoCedula();
        if (guardarCedula) {
            return;
        }

        if (validarRegistroPersona()) {
            return;
        }

        if (mensajeRegistro()) {
            return;
        }

        Persona persona = Persona
                .builder()
                .idPersona(idPersona)
                .persona(
                        ((TipoPersona) jcbPersona.getSelectedItem()).getAbreviatura()
                )
                .sexo(
                        ((Sexo) jcbSexo.getSelectedItem()).getAbreviatura()
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

        //Si hubo un error al insertar la persona, se muestra el mensaje.
        if (!resultadoIUPersona.getEstado()) {
            mensajeResultado(
                    resultadoIUPersona
            );
            return;
        }

        //Insertar o eliminar las entidades de la persona.
        registroEntidades(resultadoIUPersona.getId());

        if (!guardarCedula) {
            if (!txtCedula.getValue().toString().equals("000-0000000-0")
                    && !Utilidades.validarCampo(txtCedula)) {
                var general = Generales
                        .builder()
                        .idPersona(resultadoIUPersona.getId())
                        .cedula(txtCedula.getValue().toString())
                        .estado_civil(
                                ((EstadoCivil) jcbEstadoCivil.getSelectedItem())
                                        .getAbreviatura()
                        )
                        .idTipoSangre(0)
                        .build();

                //Insertamos o actualizamos las generales en el sistema.
                Resultado resultado = M_Generales.insert(general);

                if (!resultado.getEstado()) {
                    mensajeResultado(
                            resultado
                    );
                    return;
                }
            }
        }

        if (v_nuevo) {
            insertarDirecciones(resultadoIUPersona.getId());
            insertarTelefonos(resultadoIUPersona.getId());
            insertarCorreos(resultadoIUPersona.getId());
        }

        JOptionPane.showInternalMessageDialog(
                this,
                resultadoIUPersona,
                "",
                resultadoIUPersona.getIcono()
        );
        btnCancelarRegistroActionPerformed(evt);
        v_nuevo = null;
    }//GEN-LAST:event_btnGuardarRegistroActionPerformed

    private void btnCancelarRegistroActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelarRegistroActionPerformed
        cambioBoton(false);
        limpiarTablasDirTelCorr();
    }//GEN-LAST:event_btnCancelarRegistroActionPerformed

    private void txtCedulaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        btnCedulaValidad.requestFocus();
        btnCedulaValidad.doClick();
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtCedulaKeyPressed(KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        txtCedula.setText(
                                M_Generales.generarCedula()
                        );
                        Utilidades.validarCampo(txtCedula);
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
        if (validacionDireccion()) {
            return;
        }

        //Se pregunta si la direccion es por defecto.
        boolean porDefecto = JOptionPane.showInternalConfirmDialog(
                this,
                """
                        Es la dirección por defecto de la persona?
                        """,
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION;

        //Se preparan la provincia, municipio y el distrito municipal.
        //Modificando el registro.
        if (v_nuevo) {
            agregarDireccion(porDefecto);
        } else {
            if (M_Persona.select(
                    Persona
                            .builder()
                            .idPersona(idPersona)
                            .build()
            ).stream().findFirst().get().getEstado()) {
                M_ContactoDireccion.insert(
                        ContactoDireccion
                                .builder()
                                .idPersona(idPersona)
                                .idProvincia(
                                        ((Provincia) jcbProvincias.getSelectedItem()).getId()
                                )
                                .idMunicipio(
                                        ((Municipio) jcbMunicipios.getSelectedItem()).getId()
                                )
                                .idDistritoMunicipal(
                                        ((DistritoMunicipal) jcbDistritoMunicipal.getSelectedItem()).getId()
                                )
                                .idCodigoPostal(0)
                                .direccion(txtDireccion.getText())
                                .estado(Boolean.TRUE)
                                .porDefecto(porDefecto)
                                .fecha(new java.sql.Date(Calendar.getInstance().getTimeInMillis()))
                                .build()
                );
            } else {
                agregarDireccion(porDefecto);
            }
        }

        LimpiarComboBoxProMuniDistr();
    }//GEN-LAST:event_btnAgregarDireccionesActionPerformed

    private void btnBorrarDirrecionActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnBorrarDirrecionActionPerformed
        Utilidades.eliminarRegistroTabla(
                tblDireccion,
                v_dtmDireccion
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
        if (validacionTelefono()) {
            return;
        }
        //Se pregunta si la direccion es por defecto.
        boolean por_defecto = JOptionPane.showInternalConfirmDialog(
                this,
                """
                Es el telefono por defecto de la persona?
                """,
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION;

        if (v_nuevo) {
            agregarTelefono(por_defecto);
        } else {
            if (M_Persona.select(
                    Persona
                            .builder()
                            .idPersona(idPersona)
                            .build()
            ).stream().findFirst().get().getEstado()) {
                M_ContactoTel.insert(
                        ContactoTel
                                .builder()
                                .idPersona(idPersona)
                                .telefono(txtTelelfonoMovil.getValue().toString())
                                .tipo((jrbMovil.isSelected() ? "Movil" : "Telefono"))
                                .fecha(new java.sql.Date(Calendar.getInstance().getTimeInMillis()))
                                .estado(Boolean.TRUE)
                                .porDefecto(por_defecto)
                                .build()
                );
            } else {
                agregarTelefono(por_defecto);
            }
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

        Utilidades.eliminarRegistroTabla(tblTelefonos, v_dtmTelefono);

        btnBorrarTelefono.setEnabled(false);
        btnTelefonoEnable(false);
    }//GEN-LAST:event_btnBorrarTelefonoActionPerformed

    private void btnAgregarCorreoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnAgregarCorreoActionPerformed
        if (validacionCorreo()) {
            return;
        }

        boolean por_defecto = JOptionPane.showInternalConfirmDialog(
                this,
                """
                Es el correo por defecto de la persona?
                """,
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION;

        if (v_nuevo) {
            agregarCorreo(por_defecto);
        } else {
            if (M_Persona.select(
                    Persona
                            .builder()
                            .idPersona(idPersona)
                            .build()
            ).stream().findFirst().get().getEstado()) {
                M_ContactoEmail.insert(
                        ContactoEmail
                                .builder()
                                .idPersona(idPersona)
                                .email(txtCorreo.getText())
                                .estado(Boolean.TRUE)
                                .fecha(
                                        new java.sql.Date(
                                                Calendar.getInstance().getTimeInMillis()
                                        )
                                )
                                .porDefecto(por_defecto)
                                .build()
                );
            } else {
                agregarCorreo(por_defecto);
            }
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
                v_dtmCorreo
        );
        btnCorreoEnable(false);

    }//GEN-LAST:event_btnBorrarCorreoActionPerformed

    private void btnCedulaValidadActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCedulaValidadActionPerformed
        if (validarCampoCedula()) {
            return;
        }

        var listaCedula = M_Generales.select(
                Generales
                        .builder()
                        .cedula(txtCedula.getValue().toString())
                        .build()
        );

        if (listaCedula.getFirst().getIdPersona() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Cedula valida, puede continuar.",
                    "",
                    JOptionPane.INFORMATION_MESSAGE
            );
            txtPNombre.requestFocus();
        } else {

            Persona persona = M_Persona.select(
                    Persona
                            .builder()
                            .idPersona(listaCedula.getLast().getIdPersona())
                            .build()
            ).getLast();

            if (persona.getEstado()) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        """
                        Esta cedula se encuentra registrada en el sistema.
                        """,
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                //Preguntamos si desea cargar la informacion de la persona.
                if (JOptionPane.showInternalConfirmDialog(
                        this,
                        """
                        Esta persona está registrada y de estado inactivo.
                        Procede a habilitar a la persona?
                        """,
                        "",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                ) == JOptionPane.YES_OPTION) {

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
                }
                btnCancelarRegistroActionPerformed(evt);
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
                        int randon = (int) (Math.random() * tblPersonas.getRowCount());
                        tblPersonas.setRowSelectionInterval(randon, randon);
                    }
                }
            }
        }
    }//GEN-LAST:event_tblPersonasKeyPressed

    private void jmiActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiActualizarActionPerformed
        llenarTablaPersonas();
    }//GEN-LAST:event_jmiActualizarActionPerformed

    private void jcbFiltroTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFiltroTodosActionPerformed
        llenarTablaPersonas();
    }//GEN-LAST:event_jcbFiltroTodosActionPerformed

    private void jcbFiltroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFiltroClientesActionPerformed
        llenarTablaPersonas();
    }//GEN-LAST:event_jcbFiltroClientesActionPerformed

    private void jcbFiltroEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFiltroEmpleadosActionPerformed
        llenarTablaPersonas();
    }//GEN-LAST:event_jcbFiltroEmpleadosActionPerformed

    private void jcbFiltroEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFiltroEstudiantesActionPerformed
        llenarTablaPersonas();
    }//GEN-LAST:event_jcbFiltroEstudiantesActionPerformed

    private void jcbFiltroPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFiltroPacientesActionPerformed
        llenarTablaPersonas();
    }//GEN-LAST:event_jcbFiltroPacientesActionPerformed

    private void jcbFiltroPadresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFiltroPadresActionPerformed
        llenarTablaPersonas();
    }//GEN-LAST:event_jcbFiltroPadresActionPerformed

    private void jcbFiltroProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFiltroProveedoresActionPerformed
        llenarTablaPersonas();
    }//GEN-LAST:event_jcbFiltroProveedoresActionPerformed

    private void jcbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClienteActionPerformed
        if (jcbCliente.isSelected()) {
            jtpGeneralesDireccionContactos.add(jpCliente);
        } else {
            jtpGeneralesDireccionContactos.remove(jpCliente);
        }
    }//GEN-LAST:event_jcbClienteActionPerformed

    private void jcbEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEmpleadoActionPerformed
        if (jcbEmpleado.isSelected()) {
            jtpGeneralesDireccionContactos.add(jpEmpleado);
        } else {
            jtpGeneralesDireccionContactos.remove(jpEmpleado);
        }
    }//GEN-LAST:event_jcbEmpleadoActionPerformed

    private void jcbEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstudianteActionPerformed
        if (jcbEstudiante.isSelected()) {
            jtpGeneralesDireccionContactos.add(jpEstudiante);
        } else {
            jtpGeneralesDireccionContactos.remove(jpEstudiante);
        }
    }//GEN-LAST:event_jcbEstudianteActionPerformed

    private void jcbPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPacienteActionPerformed
        if (jcbPaciente.isSelected()) {
            jtpGeneralesDireccionContactos.add(jpPaciente);
        } else {
            jtpGeneralesDireccionContactos.remove(jpPaciente);
        }
    }//GEN-LAST:event_jcbPacienteActionPerformed

    private void jcbPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPadreActionPerformed
        if (jcbPadre.isSelected()) {
            jtpGeneralesDireccionContactos.add(jpPadre);
        } else {
            jtpGeneralesDireccionContactos.remove(jpPadre);
        }
    }//GEN-LAST:event_jcbPadreActionPerformed

    private void jcbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProveedorActionPerformed
        if (jcbProveedor.isSelected()) {
            jtpGeneralesDireccionContactos.add(jpProveedor);
        } else {
            jtpGeneralesDireccionContactos.remove(jpProveedor);
        }
    }//GEN-LAST:event_jcbProveedorActionPerformed

    private void jcbAmbosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAmbosActionPerformed
        if (jcbAmbos.isSelected()) {
            jcbEstados.setEnabled(false);
        } else {
            jcbEstados.setEnabled(true);
        }
        llenarTablaPersonas();
    }//GEN-LAST:event_jcbAmbosActionPerformed

    private void jcbEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadosActionPerformed
        jcbEstados.setText(jcbEstados.isSelected() ? "Activos" : "Inactivos");
        llenarTablaPersonas();
    }//GEN-LAST:event_jcbEstadosActionPerformed

    private void jcbMostrarGenericoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMostrarGenericoActionPerformed
        llenarTablaPersonas();
    }//GEN-LAST:event_jcbMostrarGenericoActionPerformed

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
        if (((Persona) tblPersonas.getValueAt(
                tblPersonas.getSelectedRow(),
                3
        )).getIdPersona() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Persona GENERICO no puede ser %s".formatted(accion),
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }

        idPersona = ((Persona) tblPersonas.getValueAt(
                tblPersonas.getSelectedRow(),
                3
        )).getIdPersona();

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
        mostrarGenerales(jpGenerales);

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
                    """
                    Persona no encontrado.!!!
                    CODIGO ID=[%d]
                    """.formatted(idPersona),
                    "",
                    JOptionPane.INFORMATION_MESSAGE
            );
            btnCancelarRegistro.doClick();
            return;
        }

        marcarEntidades();

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
        ).getLast();
        txtCedula.setValue(listaGenerales.getCedula());

        for (int i = 0; i < jcbEstadoCivil.getItemCount(); i++) {
            if (listaGenerales.getEstado_civil().equals(
                    jcbEstadoCivil.getItemAt(i).getAbreviatura()
            )) {
                jcbEstadoCivil.setSelectedIndex(i);
                break;
            }
        }

        llenarTablaDirreciones(idPersona);
        llenarTablaTelefonos(idPersona);
        llenarTablaCorreos(idPersona);
    }

    /**
     *
     * @return
     */
    private static Paginas paginas() {
        return Paginas
                .builder()
                .nCantidadFilas((int) jsCantidadFilas.getValue())
                .nPaginaNro((int) jsPaginaNro.getValue())
                .build();
    }

    /**
     *
     */
    public static void llenarTablaPersonas() {
        llenarTablaPersonas(
                Persona
                        .builder()
                        .pagina(paginas())
                        .build()
        );
    }

    /**
     * Muestra las entidades del sistema.
     *
     * @param persona
     */
    private static void llenarTablaPersonas(Persona persona) {

        DefaultTableModel dtmPersonas = new DefaultTableModel(null, TITULOS_PERSONA) {

            Class<?>[] types = new Class<?>[]{
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Boolean.class
            };

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
        Predicate<Cliente> pCliente = (p) -> p.getId() > 0;
        Predicate<Empleado> pEmpleado = (p) -> p.getId() > 0;
        Predicate<Estudiante> pEstudiante = (p) -> p.getId() > 0;
        Predicate<Paciente> pPaciente = (p) -> p.getId() > 0;
        Predicate<Padre> pPadre = (p) -> p.getId() > 0;
        Predicate<Proveedor> pProveedor = (p) -> p.getId() > 0;
        if (jcbMostrarGenerico.isSelected()) {
            pCliente = (p) -> p.getId() >= 0;
            pEmpleado = (p) -> p.getId() >= 0;
            pEstudiante = (p) -> p.getId() >= 0;
            pPaciente = (p) -> p.getId() >= 0;
            pPadre = (p) -> p.getId() >= 0;
            pProveedor = (p) -> p.getId() >= 0;
        }

        if (jcbFiltroClientes.isVisible()) {
            if (jcbFiltroClientes.isSelected() || jcbFiltroTodos.isSelected()) {
                M_Cliente.select(
                        Cliente
                                .builder()
                                .id(persona.getIdPersona())
                                .pagina(paginas())
                                .build()
                ).stream().filter(pCliente).forEach(
                        cliente -> {
                            Object[] bPersona = buscarPersona(cliente.getId(), "Cliente");
                            if (!Objects.isNull(bPersona[3])) {
                                dtmPersonas.addRow(bPersona);
                            }
                        }
                );
            }
        }
        if (jcbFiltroEmpleados.isVisible()) {
            if (jcbFiltroEmpleados.isSelected() || jcbFiltroTodos.isSelected()) {
                M_Empleado.select(
                        Empleado
                                .builder()
                                .id(persona.getIdPersona())
                                .pagina(paginas())
                                .build()
                ).stream().filter(pEmpleado).forEach(
                        empleado -> {
                            Object[] bPersona = buscarPersona(empleado.getId(), "Empleado");
                            if (!Objects.isNull(bPersona[3])) {
                                dtmPersonas.addRow(bPersona);
                            }
                        }
                );
            }
        }
        if (jcbFiltroEstudiantes.isVisible()) {
            if (jcbFiltroEstudiantes.isSelected() || jcbFiltroTodos.isSelected()) {
                M_Estudiante.select(
                        Estudiante
                                .builder()
                                .id(persona.getIdPersona())
                                .pagina(paginas())
                                .build()
                ).stream().filter(pEstudiante).forEach(
                        estudiante -> {
                            Object[] bPersona = buscarPersona(estudiante.getId(), "Estudiante");
                            if (!Objects.isNull(bPersona[3])) {
                                dtmPersonas.addRow(bPersona);
                            }
                        }
                );
            }
        }
        if (jcbFiltroPacientes.isVisible()) {
            if (jcbFiltroPacientes.isSelected() || jcbFiltroTodos.isSelected()) {
                M_Paciente.select(
                        Paciente
                                .builder()
                                .id(persona.getIdPersona())
                                .pagina(paginas())
                                .build()
                ).stream().filter(pPaciente).forEach(
                        paciente -> {
                            Object[] bPersona = buscarPersona(paciente.getId(), "Paciente");
                            if (!Objects.isNull(bPersona[3])) {
                                dtmPersonas.addRow(bPersona);
                            }
                        }
                );
            }
        }
        if (jcbFiltroPadres.isVisible()) {
            if (jcbFiltroPadres.isSelected() || jcbFiltroTodos.isSelected()) {
                M_Padre.select(
                        Padre
                                .builder()
                                .id(persona.getIdPersona())
                                .pagina(paginas())
                                .build()
                ).stream().filter(pPadre).forEach(
                        padre -> {
                            Object[] bPersona = buscarPersona(padre.getId(), "Padre");
                            if (!Objects.isNull(bPersona[3])) {
                                dtmPersonas.addRow(bPersona);
                            }
                        }
                );
            }
        }
        if (jcbFiltroProveedores.isVisible()) {
            if (jcbFiltroProveedores.isSelected() || jcbFiltroTodos.isSelected()) {
                M_Proveedor.select(
                        Proveedor
                                .builder()
                                .id(persona.getIdPersona())
                                .pagina(paginas())
                                .build()
                ).stream().filter(pProveedor).forEach(
                        proveedor -> {
                            Object[] bPersona = buscarPersona(proveedor.getId(), "Proveedor");
                            if (!Objects.isNull(bPersona[3])) {
                                dtmPersonas.addRow(bPersona);
                            }
                        }
                );
            }
        }
        tblPersonas.removeAll();
        tblPersonas.setModel(dtmPersonas);
    }

    public static JTable llenarTablaCorreos(Integer idPersona) {
        if (Objects.isNull(idPersona)) {
            idPersona = VistaPersonas.idPersona;
        }
        var registro = new Object[TITULOS_CORREO.length];
        limpiarTablaCorreo();
        M_ContactoEmail.selectByID(idPersona).stream().forEach(
                p_correo -> {
                    registro[0] = p_correo;
                    registro[1] = p_correo.getFecha();
                    registro[2] = p_correo.getEstado();
                    registro[3] = p_correo.getPorDefecto();
                    v_dtmCorreo.addRow(registro);
                }
        );
        tblCorreos.setModel(v_dtmCorreo);
        return tblCorreos;
    }

    public static synchronized JTable llenarTablaTelefonos(Integer idPersona) {
        if (Objects.isNull(idPersona)) {
            idPersona = VistaPersonas.idPersona;
        }
        var registro = new Object[TITULOS_TELEFONO.length];
        limpiarTablaTelefono();
        M_ContactoTel.selectByID(idPersona).stream().forEach(
                p_telefono -> {
                    registro[0] = p_telefono;
                    registro[1] = p_telefono.getTipo();
                    registro[2] = p_telefono.getFecha();
                    registro[3] = p_telefono.getEstado();
                    registro[4] = p_telefono.getPorDefecto();

                    v_dtmTelefono.addRow(registro);
                }
        );
        tblTelefonos.setModel(v_dtmTelefono);
        return tblTelefonos;
    }

    private static Object[] buscarPersona(Integer idPersona, String relacion) {
        var registro = new Object[TITULOS_PERSONA.length];
        M_Persona.select(
                Persona
                        .builder()
                        .idPersona(idPersona)
                        .estado(jcbAmbos.isSelected() ? null : jcbEstados.isSelected())
                        .build()
        ).stream().forEach(
                persona -> {
                    registro[0] = relacion;
                    registro[1] = M_Generales.select(
                            Generales
                                    .builder()
                                    .idPersona(
                                            persona.getIdPersona()
                                    )
                                    .build()
                    ).getFirst();
                    registro[2] = String.valueOf(
                            persona.getPersona()
                    ).equalsIgnoreCase("j") ? "JURÍDICA" : "FÍSICA";
                    registro[3] = persona;
                    registro[4] = String.valueOf(
                            persona.getSexo()
                    ).equalsIgnoreCase("M") ? "MASCULINO" : "FEMENINO";
                    registro[5] = Utilidades.formatDate(
                            persona.getFecha_nacimiento(),
                            "dd/MM/yyyy"
                    );
                    registro[6] = Utilidades.formatDate(
                            persona.getFecha_ingreso(),
                            "dd/MM/yyyy"
                    );
                    registro[7] = persona.getEstado();
                }
        );
        return registro;
    }

    public static void llenarTablaDirreciones(Integer idPersona) {

        if (Objects.isNull(idPersona)) {
            idPersona = VistaPersonas.idPersona;
        }

        limpiarTablaDireccion();

        var registro = new Object[TITULOS_DIRECCION.length];

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
                    v_dtmDireccion.addRow(registro);
                }
        );

        tblDireccion.setModel(v_dtmDireccion);
    }

    private boolean validarCampoCedula() {
        if (Utilidades.validarCampo(txtCedula)) {
            if (JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                    Campo de la cedula no valido.
                    Desea continuar?
                    """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null
            ) == JOptionPane.NO_OPTION) {
                mostrarGenerales(jpGenerales);
                seleccionarCampoCedula();
                return true;
            }
        }

        if (txtCedula.getValue().toString().equals("000-0000000-0")) {
            if (JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                    Cedula GENERICA del sistema.
                    Desea continuar?
                    """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null
            ) == JOptionPane.NO_OPTION) {
                mostrarGenerales(jpGenerales);
                seleccionarCampoCedula();
                return true;
            }
        }

        if (!M_Generales.cedula(txtCedula.getValue().toString())) {
            if (JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                    La cedula %s no pasa la prueba de validación.
                    Desea continuar?
                    """.formatted(txtCedula.getValue().toString()),
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null
            ) == JOptionPane.NO_OPTION) {
                mostrarGenerales(jpGenerales);
                seleccionarCampoCedula();
                return true;
            }
        }
        return false;
    }

    private void seleccionarCampoCedula() {
        txtCedula.requestFocus();
        txtCedula.setSelectionStart(0);
        txtCedula.setSelectionEnd(
                txtCedula.getValue().toString().length()
        );
    }

    private boolean validarRegistroPersona() {

        //Validar que haya escrito el nombre de la persona.
        if (txtPNombre.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar un nombre...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );

            mostrarGenerales(jpGenerales);
            txtPNombre.requestFocus();
            return true;
        }

        //Validamos que haya escrito el apellido.
        if (txtApellidos.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar un apellido...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );

            mostrarGenerales(jpGenerales);

            txtApellidos.requestFocus();

            return true;
        }

        //Validacion de la fecha de nacimiento.
        if (Objects.isNull(dchFechaNacimiento.getDate())) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe indicar una fecha de nacimiento.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            mostrarGenerales(jpGenerales);
            dchFechaNacimiento.requestFocus();
            return true;
        }

        //Validamos que la fecha de nacimiento no sea superior a la fecha actual.
        if (dchFechaNacimiento.getDate().after(new Date())) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Fecha de nacimiento incorrecta!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            mostrarGenerales(jpGenerales);
            dchFechaNacimiento.requestFocus();
            return true;
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
                mostrarGenerales(jpDireccion);
                txtDireccion.requestFocus();
                return true;
            }
        }
        //----------------------------------------------------------------------

        if (tblCorreos.getRowCount() + tblTelefonos.getRowCount() == 0) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                    No existe forma de contactar a la persona.
                    Desea agregar un numero de telefono o correo electronico?
                    """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null
            );

            if (resp == JOptionPane.YES_OPTION) {
                mostrarGenerales(jpContactos);
                jtpContactos.setSelectedComponent(jpTelefonos);
                return true;
            }

        }
        return false;
    }

    public void mostrarGenerales(Component component) {
        jtpGeneralesDireccionContactos.setSelectedComponent(component);
    }

    private void registroEntidades(Integer id) {
        var cliente = Cliente.builder().id(id).build();
        if (jcbCliente.isSelected()) {
            M_Cliente.insert(cliente);
        } else {
            M_Cliente.delete(cliente);
        }

        var empleado = Empleado.builder().id(id).build();
        if (jcbEmpleado.isSelected()) {
            M_Empleado.insert(empleado);
        } else {
            M_Empleado.delete(empleado);
        }

        var estudiante = Estudiante.builder().id(id).build();
        if (jcbEstudiante.isSelected()) {
            M_Estudiante.insert(estudiante);
        } else {
            M_Estudiante.delete(estudiante);
        }

        var paciente = Paciente.builder().id(id).build();
        if (jcbPaciente.isSelected()) {
            M_Paciente.insert(paciente);
        } else {
            M_Paciente.delete(paciente);
        }

        var padre = Padre.builder().id(id).build();
        if (jcbPadre.isSelected()) {
            M_Padre.insert(padre);
        } else {
            M_Padre.delete(padre);
        }

        var proveedor = Proveedor.builder().id(id).build();
        if (jcbProveedor.isSelected()) {
            M_Proveedor.insert(proveedor);
        } else {
            M_Proveedor.delete(proveedor);
        }
    }

    private boolean validacionDireccion() {
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
            return true;
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
            return true;
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
            return true;
        }

        return false;
    }

    private boolean validarEntidades(Integer idPersona) {
        if (!M_Cliente.select(
                Cliente
                        .builder()
                        .id(idPersona)
                        .build()
        ).isEmpty()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "La persona es un cliente del sistema.",
                    "",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return true;
        }

        if (!M_Empleado.select(
                Empleado
                        .builder()
                        .id(idPersona)
                        .build()
        ).isEmpty()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "La persona es un empleado del sistema.",
                    "",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return true;
        }

        if (!M_Estudiante.select(
                Estudiante
                        .builder()
                        .id(idPersona)
                        .build()
        ).isEmpty()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "La persona es un estudiante del sistema.",
                    "",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return true;
        }

        if (!M_Paciente.select(
                Paciente
                        .builder()
                        .id(idPersona)
                        .build()
        ).isEmpty()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "La persona es un paciente del sistema.",
                    "",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return true;
        }

        if (!M_Padre.select(
                Padre
                        .builder()
                        .id(idPersona)
                        .build()
        ).isEmpty()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "La persona es un padre del sistema.",
                    "",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return true;
        }

        if (!M_Proveedor.select(
                Proveedor
                        .builder()
                        .id(idPersona)
                        .build()
        ).isEmpty()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "La persona es un proveedor del sistema.",
                    "",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return true;
        }

        return false;
    }

    private boolean mensajeRegistro() {
        // si es nuevo validamos que la persona no exista
        String accion = "editar";
        if (v_nuevo) {
            accion = "crear";

            //Buscar la cedula en la base de datos.
            idPersona = M_Generales.select(
                    Generales
                            .builder()
                            .cedula(txtCedula.getValue().toString())
                            .build()
            ).getFirst().getIdPersona();
            if (idPersona > 0) {
                //Preguntar si desea carga la data desde la base de datos.
                if (JOptionPane.showInternalConfirmDialog(
                        this,
                        """
                        Persona se encuentra en la base de datos.
                        Desea cargar el registro?
                        """,
                        "",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                ) == JOptionPane.YES_OPTION) {
                    v_nuevo = false;
                    mostrarRegistro();
                }
                return true;
            }
        }

        return JOptionPane.showInternalConfirmDialog(
                this,
                """
                                <html>
                                    <b>Se va a %s la persona: </b>%s%s%s <br>
                                    <b>Cedula no.: </b>%s <br>
                                    <b>Fecha Nacimiento: </b>%s <br>
                                    <b>Estado de la persona: </b>%s <br>
                                    <b>Desea continuar? </b>
                                </html>
                                """.formatted(
                        accion,
                        txtPNombre.getText(),
                        (txtSNombre.getText().isBlank() ? "" : " %s".formatted(txtSNombre.getText())),
                        " %s".formatted(txtApellidos.getText()),
                        txtCedula.getText(),
                        Utilidades.formatDate(dchFechaNacimiento.getDate(), "dd-MM-yyyy"),
                        cbEstado.getText()
                ),
                """
                                """,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.NO_OPTION;
    }

    private void setFalseColumnTable(RSTableMetro1 tabla, int column) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            tabla.setValueAt(Boolean.FALSE, i, column);
        }
    }

    private boolean validacionTelefono() {
        if (Utilidades.validarCampo(txtTelelfonoMovil)) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar numero telefonico valido!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            limpiarTxtTelefonoMovil();
            return true;
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
            return true;
        }

        return false;
    }

    private boolean validacionCorreo() {
        //Validamos que el correo no esté vacio.
        if (txtCorreo.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar correo electronico.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtCorreo.requestFocus();
            return true;
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
            return true;
        }
        return false;
    }

    private void insertarDirecciones(Integer idPersona) {
        for (int i = 0; i < tblDireccion.getRowCount(); i++) {
            var _direccion = M_ContactoDireccion.insert(
                    ContactoDireccion
                            .builder()
                            .idPersona(idPersona)
                            .idProvincia(
                                    ((Provincia) tblDireccion.getValueAt(i, 0)).getId()
                            )
                            .idMunicipio(
                                    ((Municipio) tblDireccion.getValueAt(i, 1)).getId()
                            )
                            .idDistritoMunicipal(
                                    ((DistritoMunicipal) tblDireccion.getValueAt(i, 2)).getId()
                            )
                            .idCodigoPostal(0)
                            .direccion(
                                    ((ContactoDireccion) tblDireccion.getValueAt(i, 3)).getDireccion()
                            )
                            .estado(Boolean.TRUE)
                            .porDefecto(
                                    (Boolean) tblDireccion.getValueAt(i, 6)
                            )
                            .build()
            );
            mensajeResultado(_direccion);
            if (!_direccion.getEstado()) {
                break;
            }
        }
    }

    private void insertarTelefonos(Integer idPersona) {
        for (int i = 0; i < tblTelefonos.getRowCount(); i++) {
            var _telefono = M_ContactoTel.insert(
                    ContactoTel
                            .builder()
                            .idPersona(idPersona)
                            .telefono(
                                    tblTelefonos.getValueAt(i, 0).toString()
                            )
                            .tipo(
                                    tblTelefonos.getValueAt(i, 1).toString()
                            )
                            .porDefecto(
                                    (boolean) tblTelefonos.getValueAt(i, 4)
                            )
                            .build()
            );
            mensajeResultado(_telefono);
            if (!_telefono.getEstado()) {
                break;
            }
        }
    }

    private void insertarCorreos(Integer idPersona) {
        for (int i = 0; i < tblCorreos.getRowCount(); i++) {
            var _correo = M_ContactoEmail.insert(
                    ContactoEmail
                            .builder()
                            .idPersona(idPersona)
                            .email(
                                    tblCorreos.getValueAt(i, 0).toString()
                            )
                            .porDefecto(
                                    (boolean) tblCorreos.getValueAt(i, 3)
                            )
                            .build()
            );
            mensajeResultado(_correo);
            if (!_correo.getEstado()) {
                break;
            }
        }
    }

    private void combosEntidades(Entidades entidades) {
        jcbCliente.setVisible(entidades.isCliente());
        jcbFiltroClientes.setVisible(entidades.isCliente());

        jcbEmpleado.setVisible(entidades.isEmpleado());
        jcbFiltroEmpleados.setVisible(entidades.isEmpleado());

        jcbEstudiante.setVisible(entidades.isEstudiante());
        jcbFiltroEstudiantes.setVisible(entidades.isEstudiante());

        jcbPaciente.setVisible(entidades.isPaciente());
        jcbFiltroPacientes.setVisible(entidades.isPaciente());

        jcbPadre.setVisible(entidades.isPadre());
        jcbFiltroPadres.setVisible(entidades.isPadre());

        jcbProveedor.setVisible(entidades.isProveedor());
        jcbFiltroProveedores.setVisible(entidades.isProveedor());
    }

    private void marcarEntidades() {
        jcbCliente.setSelected(
                !M_Cliente.select(
                        Cliente
                                .builder()
                                .id(idPersona)
                                .build()
                ).isEmpty()
        );
        jcbClienteActionPerformed(null);

        jcbEmpleado.setSelected(
                !M_Empleado.select(
                        Empleado
                                .builder()
                                .id(idPersona)
                                .build()
                ).isEmpty()
        );
        jcbEmpleadoActionPerformed(null);

        jcbEstudiante.setSelected(
                !M_Estudiante.select(
                        Estudiante
                                .builder()
                                .id(idPersona)
                                .build()
                ).isEmpty()
        );
        jcbEstudianteActionPerformed(null);

        jcbPaciente.setSelected(
                !M_Paciente.select(
                        Paciente
                                .builder()
                                .id(idPersona)
                                .build()
                ).isEmpty()
        );
        jcbPacienteActionPerformed(null);

        jcbPadre.setSelected(
                !M_Padre.select(
                        Padre
                                .builder()
                                .id(idPersona)
                                .build()
                ).isEmpty()
        );
        jcbPadreActionPerformed(null);

        jcbProveedor.setSelected(
                !M_Proveedor.select(
                        Proveedor
                                .builder()
                                .id(idPersona)
                                .build()
                ).isEmpty()
        );
        jcbProveedorActionPerformed(null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private static javax.swing.ButtonGroup btnGTipoPersona;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardarRegistro;
    private static RSMaterialComponent.RSButtonMaterialIconOne btnModificarPersona;
    private static RSMaterialComponent.RSButtonMaterialIconOne btnNuevaPersona;
    private javax.swing.JCheckBox cbEstado;
    private com.toedter.calendar.JDateChooser dchFechaNacimiento;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private static javax.swing.JCheckBoxMenuItem jcbAmbos;
    private static javax.swing.JCheckBox jcbCliente;
    private javax.swing.JComboBox<DistritoMunicipal> jcbDistritoMunicipal;
    private javax.swing.JCheckBox jcbEmpleado;
    private static javax.swing.JComboBox<EstadoCivil> jcbEstadoCivil;
    private static javax.swing.JCheckBoxMenuItem jcbEstados;
    private javax.swing.JCheckBox jcbEstudiante;
    private static javax.swing.JCheckBoxMenuItem jcbFiltroClientes;
    private static javax.swing.JCheckBoxMenuItem jcbFiltroEmpleados;
    private static javax.swing.JCheckBoxMenuItem jcbFiltroEstudiantes;
    private static javax.swing.JCheckBoxMenuItem jcbFiltroPacientes;
    private static javax.swing.JCheckBoxMenuItem jcbFiltroPadres;
    private static javax.swing.JCheckBoxMenuItem jcbFiltroProveedores;
    private static javax.swing.JCheckBoxMenuItem jcbFiltroTodos;
    private static javax.swing.JCheckBoxMenuItem jcbMostrarGenerico;
    private static javax.swing.JComboBox<Municipio> jcbMunicipios;
    private javax.swing.JCheckBox jcbPaciente;
    private javax.swing.JCheckBox jcbPadre;
    private static javax.swing.JComboBox<TipoPersona> jcbPersona;
    private javax.swing.JCheckBox jcbProveedor;
    private static javax.swing.JComboBox<Provincia> jcbProvincias;
    private static javax.swing.JComboBox<Sexo> jcbSexo;
    private javax.swing.JLabel jlFechaCreacion;
    private javax.swing.JMenuItem jmiActualizar;
    private javax.swing.JPanel jpCliente;
    private javax.swing.JPanel jpContactos;
    private javax.swing.JPanel jpCorreos;
    private javax.swing.JPanel jpDireccion;
    private javax.swing.JPanel jpEmpleado;
    private javax.swing.JPanel jpEstudiante;
    private javax.swing.JPanel jpGeneral;
    private javax.swing.JPanel jpGenerales;
    private javax.swing.JPanel jpMantenimiento;
    private javax.swing.JPanel jpPaciente;
    private javax.swing.JPanel jpPadre;
    private javax.swing.JPanel jpPersonas;
    private javax.swing.JPanel jpProveedor;
    private javax.swing.JPanel jpTelefonos;
    private javax.swing.JRadioButton jrbMovil;
    private javax.swing.JRadioButton jrbResidencial;
    public static javax.swing.JSpinner jsCantidadFilas;
    public static javax.swing.JSpinner jsPaginaNro;
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

    private void agregarDireccion(boolean porDefecto) {
        if (porDefecto) {
            setFalseColumnTable(tblDireccion, 6);
        }
        var registro = new Object[TITULOS_DIRECCION.length];
        registro[0] = (Provincia) jcbProvincias.getSelectedItem();
        registro[1] = (Municipio) jcbMunicipios.getSelectedItem();
        registro[2] = (DistritoMunicipal) jcbDistritoMunicipal.getSelectedItem();
        registro[3] = ContactoDireccion
                .builder()
                .idPersona(idPersona)
                .direccion(txtDireccion.getText())
                .build();
        registro[4] = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        registro[5] = Boolean.TRUE;
        registro[6] = porDefecto;
        v_dtmDireccion.addRow(registro);
        tblDireccion.setModel(v_dtmDireccion);
    }

    private void agregarTelefono(boolean por_defecto) {
        if (por_defecto) {
            setFalseColumnTable(tblTelefonos, 4);
        }

        var registro = new Object[TITULOS_TELEFONO.length];
        registro[0] = txtTelelfonoMovil.getValue().toString();
        registro[1] = jrbMovil.isSelected() ? "Movil" : "Telefono";
        registro[2] = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        registro[3] = Boolean.TRUE;
        registro[4] = por_defecto;
        v_dtmTelefono.addRow(registro);
        tblTelefonos.setModel(v_dtmTelefono);
    }

    private void agregarCorreo(boolean por_defecto) {
        if (por_defecto) {
            setFalseColumnTable(tblCorreos, 3);
        }

        var registro = new Object[TITULOS_CORREO.length];
        registro[0] = txtCorreo.getText();
        registro[1] = new java.sql.Date(
                Calendar.getInstance().getTimeInMillis()
        );
        registro[2] = Boolean.TRUE;
        registro[3] = por_defecto;
        v_dtmCorreo.addRow(registro);
        tblCorreos.setModel(v_dtmCorreo);
    }
}
