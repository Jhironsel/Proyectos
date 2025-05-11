package sur.softsurena.estancia.vista;

import static clases.Datos.getDatos;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.entidades.Cargo;
import sur.softsurena.entidades.ContactoDireccion;
import sur.softsurena.entidades.ContactoEmail;
import sur.softsurena.entidades.ContactoTel;
import sur.softsurena.entidades.Departamento;
import sur.softsurena.entidades.DistritoMunicipal;
import sur.softsurena.entidades.Empleado;
import sur.softsurena.entidades.EstadoCivil;
import sur.softsurena.entidades.Generales;
import sur.softsurena.entidades.Municipio;
import sur.softsurena.entidades.Provincia;
import sur.softsurena.entidades.Sexo;
import sur.softsurena.entidades.TipoPersona;
import static sur.softsurena.interfaces.ICliente.TITULOS_CORREO;
import static sur.softsurena.interfaces.ICliente.TITULOS_DIRECCION;
import static sur.softsurena.interfaces.ICliente.TITULOS_TELEFONO;
import sur.softsurena.metodos.Imagenes;
import sur.softsurena.metodos.M_Cliente;
import sur.softsurena.metodos.M_ContactoDireccion;
import sur.softsurena.metodos.M_ContactoEmail;
import sur.softsurena.metodos.M_ContactoTel;
import sur.softsurena.metodos.M_DistritoMunicipal;
import sur.softsurena.metodos.M_Empleado;
import sur.softsurena.metodos.M_EstadoCivil;
import sur.softsurena.metodos.M_Generales;
import sur.softsurena.metodos.M_Municipio;
import sur.softsurena.metodos.M_Persona;
import sur.softsurena.metodos.M_Provincia;
import sur.softsurena.metodos.M_Sexo;
import sur.softsurena.metodos.M_TipoPersona;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.LOG;
import sur.softsurena.utilidades.digitalPersonal.enrollment.MainForm;

public class frmEmpleado extends javax.swing.JInternalFrame {

    private static frmEmpleado empleado;
    private boolean nuevo;
    private JTextFieldDateEditor editor;
    private final JButton dchFechaNacimientoButton;
    private TableRowSorter<TableModel> modeloOrdenado;
    private final Map<String, Image> fotoMap;
    private String componente;
    private File fichero;

    private Integer idEmpleado;
    private static DefaultTableModel v_dtmTelefono, v_dtmCorreo, v_dtmDireccion;
    private static List<ContactoDireccion> v_direccionesList;

    private static List<ContactoEmail> v_contactosCorreosList;

    private static List<ContactoTel> v_contactosTelsList;
    private Object[] registro;
    private DPFPTemplate template;

    public frmEmpleado() {
        initComponents();
        
        fotoMap = new HashMap<>();
        //dchFechaNamiento Personalizar
        editor = (JTextFieldDateEditor) dchFechaNacimiento.getDateEditor();

        dchFechaNacimientoButton = dchFechaNacimiento.getCalendarButton();
        editor.setEditable(false);
        dchFechaNacimientoButton.setEnabled(false);

        dchFechaNacimiento.getDateEditor().addPropertyChangeListener(
                (java.beans.PropertyChangeEvent evt) -> {
                    if (evt.getPropertyName().equals("date")
                    && editor.isEditable()) {
                        jcbSexo.requestFocusInWindow();
                        jcbSexo.showPopup();
                    }
                }
        );//Tomando control del dchFechaNamiento

//        new TextPrompt("Filtro de busqueda", txtFiltroBusqueda);

    }

    public synchronized static frmEmpleado getEmpleados() {
        if (empleado == null) {
            empleado = new frmEmpleado();
        }
        return empleado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        miJPopUpMenu = new javax.swing.JPopupMenu();
        jmSeleccionarTodo1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmCopia = new javax.swing.JMenuItem();
        jmCortar = new javax.swing.JMenuItem();
        jmPegar = new javax.swing.JMenuItem();
        jpmVistaPrevia = new javax.swing.JPopupMenu();
        jmiVistaPrevia = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtpGeneral = new javax.swing.JTabbedPane();
        jpEmpleados = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jpFiltro = new javax.swing.JPanel();
        txtFiltroBusqueda = new RSMaterialComponent.RSTextFieldMaterialIcon();
        cbEstadoEmpleados = new RSMaterialComponent.RSCheckBoxMaterial();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtEmpleados = new RSMaterialComponent.RSTableMetroCustom();
        jspMantenimiento = new javax.swing.JScrollPane();
        jpMantenimiento = new javax.swing.JPanel();
        rSPanelMaterialGradient1 = new RSMaterialComponent.RSPanelMaterialGradient();
        jtpGeneralesDireccionContactos = new javax.swing.JTabbedPane();
        jpGenerales = new javax.swing.JPanel();
        jcbSexo = new javax.swing.JComboBox<>();
        txtSNombre = new javax.swing.JTextField();
        jcbPersona = new javax.swing.JComboBox<>();
        cbEstado = new javax.swing.JCheckBox();
        txtCedula = new javax.swing.JFormattedTextField();
        dchFechaNacimiento = new com.toedter.calendar.JDateChooser();
        btnCedulaValidad = new RSMaterialComponent.RSButtonMaterialIconOne();
        txtApellidos = new javax.swing.JTextField();
        jcbEstadoCivil = new javax.swing.JComboBox<>();
        txtPNombre = new javax.swing.JTextField();
        rSButtonGradientIcon_new1 = new newscomponents.RSButtonGradientIcon_new();
        jcbDepartamentos = new javax.swing.JComboBox<>();
        jcbCargos = new javax.swing.JComboBox<>();
        jpFoto = new javax.swing.JPanel();
        rSPanelEffect1 = new newscomponents.RSPanelEffect();
        btnAgregarFoto = new javax.swing.JButton();
        btnBorrarFoto = new javax.swing.JButton();
        jlFoto = new javax.swing.JLabel();
        jpDireccion = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jcbProvincias = new javax.swing.JComboBox<>();
        jcbMunicipios = new javax.swing.JComboBox<>();
        jcbDistritoMunicipal = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
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
        jPanel11 = new javax.swing.JPanel();
        txtTelelfonoMovil = new javax.swing.JFormattedTextField();
        btnAgregarTelefonoMovil = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrarTelefono = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEditarTelefono = new RSMaterialComponent.RSButtonMaterialIconOne();
        jPanel2 = new javax.swing.JPanel();
        jrbResidencial = new javax.swing.JRadioButton();
        jrbMovil = new javax.swing.JRadioButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblTelefonos = new rojerusan.RSTableMetro1(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jpCorreos = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnAgregarCorreo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrarCorreo = new RSMaterialComponent.RSButtonMaterialIconOne();
        txtCorreo = new javax.swing.JTextField();
        btnEditarCorreo = new RSMaterialComponent.RSButtonMaterialIconOne();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCorreos = new rojerusan.RSTableMetro1(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jlFechaCreacion = new javax.swing.JLabel();
        jpNavegacion = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        miJPopUpMenu.setName("miJPopUpMenu"); // NOI18N

        jmSeleccionarTodo1.setText("Seleccionar Todo");
        jmSeleccionarTodo1.setName("jmSeleccionarTodo1"); // NOI18N
        jmSeleccionarTodo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSeleccionarTodo1ActionPerformed(evt);
            }
        });
        miJPopUpMenu.add(jmSeleccionarTodo1);

        jSeparator2.setName("jSeparator2"); // NOI18N
        miJPopUpMenu.add(jSeparator2);

        jmCopia.setText("Copiar");
        jmCopia.setName("jmCopia"); // NOI18N
        jmCopia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCopiaActionPerformed(evt);
            }
        });
        miJPopUpMenu.add(jmCopia);

        jmCortar.setText("Cortar");
        jmCortar.setName("jmCortar"); // NOI18N
        jmCortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCortarActionPerformed(evt);
            }
        });
        miJPopUpMenu.add(jmCortar);

        jmPegar.setText("Pegar");
        jmPegar.setName("jmPegar"); // NOI18N
        jmPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPegarActionPerformed(evt);
            }
        });
        miJPopUpMenu.add(jmPegar);

        jpmVistaPrevia.setName("jpmVistaPrevia"); // NOI18N

        jmiVistaPrevia.setText("Vista Previa");
        jmiVistaPrevia.setName("jmiVistaPrevia"); // NOI18N
        jmiVistaPrevia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVistaPreviaActionPerformed(evt);
            }
        });
        jpmVistaPrevia.add(jmiVistaPrevia);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento de empleados");
        setMinimumSize(new java.awt.Dimension(0, 0));
        setName("Form"); // NOI18N
        setNormalBounds(null);
        setPreferredSize(new java.awt.Dimension(824, 662));
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
                formInternalFrameOpened(evt);
            }
        });

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jtpGeneral.setName("jtpGeneral"); // NOI18N

        jpEmpleados.setName("jpEmpleados"); // NOI18N

        jScrollPane6.setName("jScrollPane6"); // NOI18N

        jpFiltro.setName("jpFiltro"); // NOI18N

        txtFiltroBusqueda.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FIND_IN_PAGE);
        txtFiltroBusqueda.setName("txtFiltroBusqueda"); // NOI18N
        txtFiltroBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroBusquedaKeyReleased(evt);
            }
        });

        cbEstadoEmpleados.setText("Activo");
        cbEstadoEmpleados.setName("cbEstadoEmpleados"); // NOI18N
        cbEstadoEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoEmpleadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFiltroLayout = new javax.swing.GroupLayout(jpFiltro);
        jpFiltro.setLayout(jpFiltroLayout);
        jpFiltroLayout.setHorizontalGroup(
            jpFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFiltroLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtFiltroBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbEstadoEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpFiltroLayout.setVerticalGroup(
            jpFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFiltroLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jpFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltroBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstadoEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        jScrollPane6.setViewportView(jpFiltro);

        jScrollPane7.setName("jScrollPane7"); // NOI18N

        jtEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        jtEmpleados.setName("jtEmpleados"); // NOI18N
        jtEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jtEmpleados);

        javax.swing.GroupLayout jpEmpleadosLayout = new javax.swing.GroupLayout(jpEmpleados);
        jpEmpleados.setLayout(jpEmpleadosLayout);
        jpEmpleadosLayout.setHorizontalGroup(
            jpEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEmpleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpEmpleadosLayout.setVerticalGroup(
            jpEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEmpleadosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpGeneral.addTab("Empleados", jpEmpleados);

        jspMantenimiento.setName("jspMantenimiento"); // NOI18N

        jpMantenimiento.setName("jpMantenimiento"); // NOI18N

        rSPanelMaterialGradient1.setName("rSPanelMaterialGradient1"); // NOI18N

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

        jcbSexo.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jcbSexo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 1, true), "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
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

        txtSNombre.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        txtSNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 1, true), "Segundo nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
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

        jcbPersona.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jcbPersona.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 1, true), "Tipo persona", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        jcbPersona.setName("jcbPersona"); // NOI18N
        jcbPersona.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbPersonaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

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

        txtCedula.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 1, true), "Cedula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        try {
            txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula.setText("012-0089344-8");
        txtCedula.setToolTipText("Cedula del Cliente");
        txtCedula.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtCedula.setFocusTraversalPolicyProvider(true);
        txtCedula.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        txtCedula.setName("txtCedula"); // NOI18N
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

        dchFechaNacimiento.setDateFormatString("dd.MM.yyyy");
        dchFechaNacimiento.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        dchFechaNacimiento.setName("dchFechaNacimiento"); // NOI18N

        btnCedulaValidad.setBackground(new java.awt.Color(0, 255, 75));
        btnCedulaValidad.setToolTipText("Verifica la cedula del cliente.");
        btnCedulaValidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCedulaValidad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCedulaValidad.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SYNC);
        btnCedulaValidad.setName("btnCedulaValidad"); // NOI18N
        btnCedulaValidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCedulaValidadActionPerformed(evt);
            }
        });

        txtApellidos.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        txtApellidos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellidos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 1, true), "Apellidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
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

        jcbEstadoCivil.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jcbEstadoCivil.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 1, true), "Estado civil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
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

        txtPNombre.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        txtPNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 1, true), "Primer nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
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

        rSButtonGradientIcon_new1.setText("Enrrolar huella");
        rSButtonGradientIcon_new1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FINGERPRINT);
        rSButtonGradientIcon_new1.setName("rSButtonGradientIcon_new1"); // NOI18N
        rSButtonGradientIcon_new1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonGradientIcon_new1ActionPerformed(evt);
            }
        });

        jcbDepartamentos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(37, 45, 223)), "Departamentos"));
        jcbDepartamentos.setName("jcbDepartamentos"); // NOI18N

        jcbCargos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(37, 45, 223)), "Cargos"));
        jcbCargos.setName("jcbCargos"); // NOI18N

        javax.swing.GroupLayout jpGeneralesLayout = new javax.swing.GroupLayout(jpGenerales);
        jpGenerales.setLayout(jpGeneralesLayout);
        jpGeneralesLayout.setHorizontalGroup(
            jpGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGeneralesLayout.createSequentialGroup()
                        .addComponent(txtPNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpGeneralesLayout.createSequentialGroup()
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCedulaValidad, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGeneralesLayout.createSequentialGroup()
                        .addGroup(jpGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dchFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpGeneralesLayout.createSequentialGroup()
                                .addComponent(jcbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbEstadoCivil, 0, 191, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpGeneralesLayout.createSequentialGroup()
                                .addComponent(jcbCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rSButtonGradientIcon_new1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jpGeneralesLayout.setVerticalGroup(
            jpGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCedulaValidad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(dchFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jcbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonGradientIcon_new1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpGeneralesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dchFechaNacimiento, jcbEstadoCivil, jcbPersona, jcbSexo});

        jtpGeneralesDireccionContactos.addTab("Generales", jpGenerales);

        jpFoto.setMaximumSize(new java.awt.Dimension(697, 450));
        jpFoto.setMinimumSize(new java.awt.Dimension(0, 0));
        jpFoto.setName(""); // NOI18N

        rSPanelEffect1.setName("rSPanelEffect1"); // NOI18N

        btnAgregarFoto.setFont(new java.awt.Font("FreeMono", 0, 14)); // NOI18N
        btnAgregarFoto.setIcon(new Imagenes("Agregar foto 32 x 32.png").getIcono());
        btnAgregarFoto.setText("Tomar Foto");
        btnAgregarFoto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAgregarFoto.setName("btnAgregarFoto"); // NOI18N
        btnAgregarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFotoActionPerformed(evt);
            }
        });

        btnBorrarFoto.setFont(new java.awt.Font("FreeMono", 0, 14)); // NOI18N
        btnBorrarFoto.setIcon(new Imagenes("Borrar 32 x 32.png").getIcono());
        btnBorrarFoto.setText("Borrar foto");
        btnBorrarFoto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBorrarFoto.setName("btnBorrarFoto"); // NOI18N
        btnBorrarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarFotoActionPerformed(evt);
            }
        });

        jlFoto.setFont(new java.awt.Font("FreeMono", 0, 14)); // NOI18N
        jlFoto.setForeground(new java.awt.Color(153, 153, 153));
        jlFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFoto.setText("Click para agregar foto");
        jlFoto.setToolTipText("Click para buscar imagen o tomar una foto.");
        jlFoto.setAlignmentY(0.0F);
        jlFoto.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto del empleado"));
        jlFoto.setComponentPopupMenu(jpmVistaPrevia);
        jlFoto.setIconTextGap(0);
        jlFoto.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jlFoto.setMinimumSize(new java.awt.Dimension(0, 0));
        jlFoto.setName("jlFoto"); // NOI18N
        jlFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlFotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout rSPanelEffect1Layout = new javax.swing.GroupLayout(rSPanelEffect1);
        rSPanelEffect1.setLayout(rSPanelEffect1Layout);
        rSPanelEffect1Layout.setHorizontalGroup(
            rSPanelEffect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelEffect1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rSPanelEffect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregarFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        rSPanelEffect1Layout.setVerticalGroup(
            rSPanelEffect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelEffect1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelEffect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(rSPanelEffect1Layout.createSequentialGroup()
                        .addComponent(btnAgregarFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrarFoto)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpFotoLayout = new javax.swing.GroupLayout(jpFoto);
        jpFoto.setLayout(jpFotoLayout);
        jpFotoLayout.setHorizontalGroup(
            jpFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFotoLayout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(rSPanelEffect1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(215, 215, 215))
        );
        jpFotoLayout.setVerticalGroup(
            jpFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFotoLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(rSPanelEffect1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(91, 91, 91))
        );

        jtpGeneralesDireccionContactos.addTab("Foto emplado", jpFoto);

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

        jPanel9.setName("jPanel9"); // NOI18N

        jPanel10.setName("jPanel10"); // NOI18N
        jPanel10.setLayout(new java.awt.GridLayout(1, 5, 5, 0));

        btnAgregarDirecciones.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PLUS_ONE);
        btnAgregarDirecciones.setName("btnAgregarDirecciones"); // NOI18N
        btnAgregarDirecciones.setPositionIcon(null);
        btnAgregarDirecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDireccionesActionPerformed(evt);
            }
        });
        jPanel10.add(btnAgregarDirecciones);

        btnEditarDireccion.setEnabled(false);
        btnEditarDireccion.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarDireccion.setName("btnEditarDireccion"); // NOI18N
        btnEditarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDireccionActionPerformed(evt);
            }
        });
        jPanel10.add(btnEditarDireccion);

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
        jPanel10.add(btnBorrarDirrecion);

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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jpDireccionLayout.setVerticalGroup(
            jpDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDireccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jtpGeneralesDireccionContactos.addTab("Dirección", jpDireccion);

        jpContactos.setToolTipText("Acceso con Control + 3");
        jpContactos.setName("jpContactos"); // NOI18N

        jtpContactos.setName("jtpContactos"); // NOI18N

        jpTelefonos.setName("jpTelefonos"); // NOI18N

        jPanel11.setName("jPanel11"); // NOI18N

        txtTelelfonoMovil.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Número"));
        try {
            txtTelelfonoMovil.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+1(###) ###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelelfonoMovil.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        txtTelelfonoMovil.setName("txtTelelfonoMovil"); // NOI18N
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

        btnAgregarTelefonoMovil.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PLUS_ONE);
        btnAgregarTelefonoMovil.setName("btnAgregarTelefonoMovil"); // NOI18N
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
        btnEditarTelefono.setName("btnEditarTelefono"); // NOI18N
        btnEditarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTelefonoActionPerformed(evt);
            }
        });

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jrbResidencial.setText("Telefono");
        jrbResidencial.setName("jrbResidencial"); // NOI18N
        jPanel2.add(jrbResidencial);

        jrbMovil.setSelected(true);
        jrbMovil.setText("Movil");
        jrbMovil.setName("jrbMovil"); // NOI18N
        jPanel2.add(jrbMovil);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(txtTelelfonoMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarTelefonoMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(307, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelelfonoMovil)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAgregarTelefonoMovil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBorrarTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpTelefonosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jpTelefonosLayout.setVerticalGroup(
            jpTelefonosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTelefonosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jtpContactos.addTab("Teléfonico", jpTelefonos);

        jpCorreos.setName("jpCorreos"); // NOI18N

        jPanel12.setName("jPanel12"); // NOI18N

        btnAgregarCorreo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PLUS_ONE);
        btnAgregarCorreo.setName("btnAgregarCorreo"); // NOI18N
        btnAgregarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCorreoActionPerformed(evt);
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

        btnEditarCorreo.setEnabled(false);
        btnEditarCorreo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarCorreo.setName("btnEditarCorreo"); // NOI18N
        btnEditarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCorreoActionPerformed(evt);
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpCorreosLayout.setVerticalGroup(
            jpCorreosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCorreosLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jtpContactos.addTab("Correos", jpCorreos);

        javax.swing.GroupLayout jpContactosLayout = new javax.swing.GroupLayout(jpContactos);
        jpContactos.setLayout(jpContactosLayout);
        jpContactosLayout.setHorizontalGroup(
            jpContactosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContactosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jtpContactos)
                .addGap(0, 0, 0))
        );
        jpContactosLayout.setVerticalGroup(
            jpContactosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContactosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jtpContactos)
                .addGap(0, 0, 0))
        );

        jtpGeneralesDireccionContactos.addTab("Contactos", jpContactos);

        jlFechaCreacion.setText("Fecha de creacion: ");
        jlFechaCreacion.setName("jlFechaCreacion"); // NOI18N

        javax.swing.GroupLayout rSPanelMaterialGradient1Layout = new javax.swing.GroupLayout(rSPanelMaterialGradient1);
        rSPanelMaterialGradient1.setLayout(rSPanelMaterialGradient1Layout);
        rSPanelMaterialGradient1Layout.setHorizontalGroup(
            rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelMaterialGradient1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelMaterialGradient1Layout.createSequentialGroup()
                        .addComponent(jlFechaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jtpGeneralesDireccionContactos))
                .addContainerGap())
        );
        rSPanelMaterialGradient1Layout.setVerticalGroup(
            rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelMaterialGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlFechaCreacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtpGeneralesDireccionContactos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpMantenimientoLayout = new javax.swing.GroupLayout(jpMantenimiento);
        jpMantenimiento.setLayout(jpMantenimientoLayout);
        jpMantenimientoLayout.setHorizontalGroup(
            jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantenimientoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSPanelMaterialGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpMantenimientoLayout.setVerticalGroup(
            jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMantenimientoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(rSPanelMaterialGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 149, Short.MAX_VALUE))
        );

        jspMantenimiento.setViewportView(jpMantenimiento);

        jtpGeneral.addTab("Mantenimiento", jspMantenimiento);

        jScrollPane2.setViewportView(jtpGeneral);

        jpNavegacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles"));
        jpNavegacion.setName("jpNavegacion"); // NOI18N

        jPanel6.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel6.setName("jPanel6"); // NOI18N
        jPanel6.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        btnNuevo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(1, 1, 1));
        btnNuevo.setIcon(new Imagenes("Documento nuevo 32 x 32.png").getIcono());
        btnNuevo.setMnemonic('n');
        btnNuevo.setText("Nuevo");
        btnNuevo.setToolTipText("Crear un nuevo Registro");
        btnNuevo.setName("btnNuevo"); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel6.add(btnNuevo);

        btnModificar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(1, 1, 1));
        btnModificar.setIcon(new Imagenes("Editar Documento 32 x 32.png").getIcono());
        btnModificar.setMnemonic('m');
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Modificar Registro Actual");
        btnModificar.setName("btnModificar"); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel6.add(btnModificar);

        btnBorrar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(1, 1, 1));
        btnBorrar.setIcon(new Imagenes("Borrar 32 x 32.png").getIcono());
        btnBorrar.setMnemonic('b');
        btnBorrar.setText("Borrar");
        btnBorrar.setToolTipText("Borrar Registro Actual");
        btnBorrar.setName("btnBorrar"); // NOI18N
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel6.add(btnBorrar);

        btnGuardar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(1, 1, 1));
        btnGuardar.setIcon(new Imagenes("Guardar 32 x 32.png").getIcono());
        btnGuardar.setMnemonic('g');
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Guardar Registro Actual");
        btnGuardar.setEnabled(false);
        btnGuardar.setName("btnGuardar"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel6.add(btnGuardar);

        btnCancelar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(1, 1, 1));
        btnCancelar.setIcon(new Imagenes("Cancelar 32 x 32.png").getIcono());
        btnCancelar.setMnemonic('c');
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancela la Operacion del Registro");
        btnCancelar.setEnabled(false);
        btnCancelar.setName("btnCancelar"); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel6.add(btnCancelar);

        javax.swing.GroupLayout jpNavegacionLayout = new javax.swing.GroupLayout(jpNavegacion);
        jpNavegacion.setLayout(jpNavegacionLayout);
        jpNavegacionLayout.setHorizontalGroup(
            jpNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpNavegacionLayout.setVerticalGroup(
            jpNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNavegacionLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpNavegacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jpNavegacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo = true;
        jtpGeneral.add(jspMantenimiento);
        jtpGeneral.setSelectedComponent(jspMantenimiento);
        limpiarCampos();
        navegador(false);
        controlesEditable(false);
        btnGuardar.setEnabled(false);
        btnCedulaValidad.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jtEmpleados.getRowCount() == 0) {
            JOptionPane.showInternalMessageDialog(null,
                    "No se encuentra datos en la tabla. Registre un empleado",
                    "Proceso de validacion de datos",
                    JOptionPane.DEFAULT_OPTION);
            return;
        }//Validamos que tenga registro la tabla
        
        if (jtEmpleados.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(null,
                    "Debe seleccionar un registro de la tabla",
                    "Proceso de validacion de datos",
                    JOptionPane.DEFAULT_OPTION);
            jtEmpleados.requestFocusInWindow();
            return;
        }//Nos aseguramos que tengas un registro seleccionado
        
        controlesEditable(true);
        nuevo = false;
        mostrarRegistro();
        navegador(false);
        btnCedulaValidad.setEnabled(false);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Validaciones de datos...
        if (txtCedula.getValue() == null) {
            JOptionPane.showInternalConfirmDialog(null,
                    "Inserte la cedula!!!", "Olvida algo!",
                    JOptionPane.DEFAULT_OPTION);
            txtCedula.requestFocusInWindow();
            return;
        }

        if (txtPNombre.getText().equals("")) {
            JOptionPane.showInternalConfirmDialog(null,
                    "Inserte el Nombre!!!", "Olvida algo!",
                    JOptionPane.DEFAULT_OPTION);
            txtPNombre.requestFocusInWindow();
            return;
        }

        if (txtApellidos.getText().equals("")) {
            JOptionPane.showInternalConfirmDialog(null,
                    "Inserte el Apellido...", "Olvida algo!",
                    JOptionPane.DEFAULT_OPTION);
            txtApellidos.requestFocusInWindow();
            return;
        }

        if (dchFechaNacimiento.getDate() == null) {
            JOptionPane.showInternalConfirmDialog(null,
                    "Debe indicar una fecha de nacimiento...",
                    "Olvida algo!", JOptionPane.DEFAULT_OPTION);
            dchFechaNacimiento.requestFocusInWindow();
            return;
        }

        if (dchFechaNacimiento.getDate().after(new Date())) {
            JOptionPane.showInternalConfirmDialog(null,
                    "La Fecha de Nacimiento debe ser Anterior a la Fecha Actual",
                    "Olvida algo!", JOptionPane.DEFAULT_OPTION);
            dchFechaNacimiento.requestFocusInWindow();
            return;
        }

        if (!cbEstado.isSelected()) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    "Desea dejar empleado inactivo?",
                    "Proceso de validacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.NO_OPTION) {
                cbEstado.setSelected(true);
                return;
            }
        }
        
        if(Objects.isNull(template)){
            int respuesta = JOptionPane.showInternalConfirmDialog(
                    this, 
                    """
                    Empleado no ha registrado su huella en el sistema.
                    Desea continuar con el registro?
                    """, 
                    "", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );
            
            if(respuesta == JOptionPane.NO_OPTION){
                return;
            }
        }

//        ByteArrayInputStream temp = null;
//        int tam = 0;
//        if (template != null) {
//            temp = new ByteArrayInputStream(template.serialize());
//            tam = template.serialize().length;
//        }
        var persona = Persona
                .builder()
                .persona('F')
                .pnombre(txtPNombre.getText())
                .snombre(txtSNombre.getText())
                .apellidos(txtApellidos.getText())
                .fecha_nacimiento((java.sql.Date) dchFechaNacimiento.getDate())
                .build();

        if (nuevo) {
            M_Persona.insert(persona);
        } else {

        }

        Empleado e = Empleado
                .builder()
                .id(0)
                .idCargo(jcbCargos.getItemAt(jcbCargos.getSelectedIndex()).getId())
                .idDepartamento(jcbCargos.getItemAt(jcbCargos.getSelectedIndex()).getId())
                .build();
//Esperando esto...
//getDatos("Agregar empleado al sistema").
//                        agregarEmpleado(e, foto, huella, borrarFoto, borrarHuella)
        JOptionPane.showInternalConfirmDialog(
                this,
                " ",
                "",
                JOptionPane.DEFAULT_OPTION
        );

        llenarTabla(cbEstadoEmpleados.isSelected());
        btnCancelarActionPerformed(null);
        fichero = null;
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //Desactivamos el Flag de registro Nuevo
        int resp = JOptionPane.showInternalConfirmDialog(
                this,
                "Desea cancelar el regiistro actual?",
                "",
                JOptionPane.YES_NO_OPTION
        );

        if (JOptionPane.NO_OPTION == resp) {
            return;
        }
        nuevo = false;
        navegador(true);
        jlFoto.setIcon(null);

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (jtEmpleados.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(null,
                    "Debe de seleccionar un registro de la tabla!!!",
                    "Proceso de validación",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int resp = JOptionPane.showInternalConfirmDialog(null,
                "Desea borrar el empleado "
                + (String) jtEmpleados.getValueAt(jtEmpleados.getSelectedRow(), 1) + " "
                + (String) jtEmpleados.getValueAt(jtEmpleados.getSelectedRow(), 2)
                + "\nDesea Continuar?",
                "Proceso de validacion de registros",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        //Actualizamos los cambios en la Tabla
        llenarTabla(cbEstadoEmpleados.isSelected());
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void jmSeleccionarTodo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSeleccionarTodo1ActionPerformed
        if (componente.equals("txtCedula")) {
            txtCedula.setSelectionStart(0);
            txtCedula.setSelectionEnd(txtCedula.getText().length());
        }
        if (componente.equals("txtNombres")) {
            txtPNombre.setSelectionStart(0);
            txtPNombre.setSelectionEnd(txtPNombre.getText().length());
        }
        if (componente.equals("txtApellidos")) {
            txtApellidos.setSelectionStart(0);
            txtApellidos.setSelectionEnd(txtApellidos.getText().length());
        }

        componente = "";
    }//GEN-LAST:event_jmSeleccionarTodo1ActionPerformed

    private void jmCopiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCopiaActionPerformed
        if (componente.equals("txtCedula")) {
            txtCedula.copy();
        }
        if (componente.equals("txtNombres")) {
            txtPNombre.copy();
        }
        if (componente.equals("txtApellidos")) {
            txtApellidos.copy();
        }
        componente = "";
    }//GEN-LAST:event_jmCopiaActionPerformed

    private void jmCortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCortarActionPerformed
        if (componente.equals("txtCedula")) {
            txtCedula.cut();
        }
        if (componente.equals("txtNombres")) {
            txtPNombre.cut();
        }
        if (componente.equals("txtApellidos")) {
            txtApellidos.cut();
        }
        componente = "";
    }//GEN-LAST:event_jmCortarActionPerformed

    private void jmPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPegarActionPerformed
        if (componente.equals("txtCedula")) {
            txtCedula.paste();
        }
        if (componente.equals("txtNombres")) {
            txtPNombre.paste();
        }
        if (componente.equals("txtApellidos")) {
            txtApellidos.paste();
        }
        componente = "";
    }//GEN-LAST:event_jmPegarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        llenarTabla(true);
        llenarComboBox();
        jtpGeneral.remove(jspMantenimiento);
    }//GEN-LAST:event_formInternalFrameOpened

    private void jlFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlFotoMouseClicked

    }//GEN-LAST:event_jlFotoMouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
//        stop();
    }//GEN-LAST:event_formInternalFrameClosed

    private void btnBorrarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarFotoActionPerformed
        if (!btnBorrarFoto.isEnabled()) {
            return;
        }
        btnBorrarFoto.setEnabled(false);
        jlFoto.setText("Click para agregar foto");
        jlFoto.setIcon(null);


    }//GEN-LAST:event_btnBorrarFotoActionPerformed

    private void btnAgregarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFotoActionPerformed
        if (btnCedulaValidad.isEnabled()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe validar una cedula!!!",
                    "Proceso de validación de empleado",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        String[] opr = new String[]{
            "Seleccione una opcion",
            "Desde un Archivo",
            "Desde una Camara"};

        String resp = (String) JOptionPane.showInternalInputDialog(
                this,
                "Elija una acción para realizar",
                "Proceso de acciones",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opr,
                opr[0]);

        if (resp == null) {
            return;
        }

        switch (resp) {
            case "Desde un Archivo":
                /*
                    El objeto img se inserta dentro del fc para mostrar las imagenes
                    cuando sean seleccionadas en el cuadro de FileChooser.
                 */
                JLabel img = new JLabel();
                img.setHorizontalAlignment(JLabel.CENTER);
                JFileChooser fc = new JFileChooser();
                fc.setFileFilter(new FileNameExtensionFilter("*.PNG, *.JPEG, *.JPG", "png",
                        "jpeg", "jpg"));
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.setAccessory(img);
                fc.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
                    try {
                        if (evt1.getPropertyName().equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)) {
                            img.setText("");
                            ImageIcon icon = new ImageIcon(fc.getSelectedFile().getPath());
                            img.setIcon(new ImageIcon(icon.getImage().getScaledInstance(200, 200,
                                    Image.SCALE_SMOOTH)));
                        }
                    } catch (Exception e) {
                        img.setText("Seleccionar Imagen");
                        img.setIcon(null);
                    }
                });
                int seleccion = fc.showDialog(null, "Tomar Imagen");
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    if (fc.getSelectedFile().getName().length() > 40) {
                        JOptionPane.showInternalMessageDialog(null,
                                "Renombre el archivo a menos de 40 caracteres.",
                                "Validación de proceso",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    fichero = fc.getSelectedFile();

                    ImageIcon icon = new ImageIcon(fichero.getAbsolutePath());

                    String cedula = "Empleado_" + txtCedula.getText().trim() + ".JPG";

                    File f = new File(fichero.getAbsolutePath());
                    for (int i = 1; true; i++) {
                        if (f.exists()) {
                            f = new File("foto/Empleado_" + cedula + "_" + i + ".JPG");
                        } else {
                            break;
                        }
                    }

//                    try {
//                        ImageIO.write(PanelConFondo.carga(
//                                icon.getImage(), jlFoto), "JPG", new File("foto/" + cedula));
//                    } catch (IOException t) {
//                        LOG.log(
//                                Level.SEVERE,
//                                "Error al escribir imagen.",
//                                t
//                        );
//                    }
                    jlFoto.setText("");
                    jlFoto.setIcon(new ImageIcon(icon.getImage().getScaledInstance(
                            180, 180, Image.SCALE_SMOOTH)));

                    fotoMap.remove(txtCedula.getText().trim(), null);
                    btnBorrarFoto.setEnabled(true);
                }

                break;
            case "Desde una Camara":
                frmCamara c = new frmCamara(null, true, jlFoto,
                        txtCedula.getText().trim());
                c.setLocationRelativeTo(null);
                c.setVisible(true);
                if (c.isListo()) {
                    fichero = new File(c.getRuta());
                    ImageIcon icon = new ImageIcon(fichero.getAbsolutePath());
                    jlFoto.setText("");
                    jlFoto.setIcon(new ImageIcon(icon.getImage().getScaledInstance(
                            180, 180, Image.SCALE_SMOOTH)));
                    fotoMap.remove(txtCedula.getText().trim(), null);
                    fotoMap.put(txtCedula.getText().trim(), icon.getImage());

                    btnBorrarFoto.setEnabled(true);
                } else {
                    c.dispose();
                }
                break;
        }
    }//GEN-LAST:event_btnAgregarFotoActionPerformed

    private void jmiVistaPreviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVistaPreviaActionPerformed
//        new ImageIcon("foto/Empleado_" + txtCedula.getText() + ".JPG").
//                getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);

        if (txtCedula.getText().replace("-", "").trim().isEmpty()) {
            return;
        }
        frmImagen obj = new frmImagen(null, true, new ImageIcon(
                (fotoMap.containsKey(txtCedula.getText().trim())
                ? fotoMap.get(txtCedula.getText().trim()).
                        getScaledInstance(600, 600, Image.SCALE_DEFAULT)
                : getDatos("Buscar imagen del empleado a la base de datos").
                        getImagenes("select FOTO "
                                + "from T_EMPLEADOS "
                                + "where Cedula = '" + txtCedula.getText().trim() + "';"))));
        //Al tirar la foto y ver la vista previa la foto no esta aun ni en fotoMap
        //Ni en la base de datos....
        //La foto esta en la carbeta de foto...

        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
    }//GEN-LAST:event_jmiVistaPreviaActionPerformed

    private void jcbSexoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbSexoPopupMenuWillBecomeInvisible
        if (jcbSexo.getSelectedIndex() > 0) {
            jtpGeneralesDireccionContactos.setSelectedIndex(
                    jtpGeneralesDireccionContactos.indexOfComponent(jpDireccion)
            );
        }
    }//GEN-LAST:event_jcbSexoPopupMenuWillBecomeInvisible

    private void txtSNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSNombreActionPerformed
        if (txtPNombre.getText().isBlank() && !txtSNombre.getText().isEmpty()) {
            txtPNombre.setText(txtSNombre.getText());
            txtSNombre.setText("");
        }
        txtApellidos.requestFocus();
    }//GEN-LAST:event_txtSNombreActionPerformed

    private void jcbPersonaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbPersonaPopupMenuWillBecomeInvisible
        dchFechaNacimiento.requestFocus();
        //v_editor.requestFocus();
    }//GEN-LAST:event_jcbPersonaPopupMenuWillBecomeInvisible

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        if (cbEstado.isSelected()) {
            cbEstado.setText("Activo");
        } else {
            cbEstado.setText("Inactivo");
        }
        btnGuardar.requestFocus();
    }//GEN-LAST:event_cbEstadoActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        btnCedulaValidad.requestFocus();
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyPressed
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

    private void btnCedulaValidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCedulaValidadActionPerformed
        if (txtCedula.getValue().toString().equals("000-0000000-0")) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    """
                Cedula GENERICA del sistema.
                Modifique la cedula del cliente.
                """,
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtCedula.setValue(null);
            txtCedula.requestFocus();
            return;
        }

        if (Utilidades.validarCampo(txtCedula)) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Error en el campo de la cedula, Vuelva a digitarla de nuevo",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtCedula.setValue(null);
            txtCedula.requestFocus();
            return;
        }

        Generales cedula = M_Generales.select(
                Generales
                        .builder()
                        .cedula(txtCedula.getValue().toString())
                        .build()
        ).getFirst();

        if (cedula.getIdPersona() < 0) {

            JOptionPane.showInternalMessageDialog(
                    this,
                    "Cedula valida, puede continuar.",
                    "",
                    JOptionPane.INFORMATION_MESSAGE
            );
            txtPNombre.requestFocus();
        } else {
            idEmpleado = cedula.getIdPersona();

            if (nuevo) {
                if (idEmpleado > 0 && !M_Persona.select(
                        Persona
                                .builder()
                                .idPersona(idEmpleado)
                                .build()
                ).getFirst().getEstado()) {
                    int resp = JOptionPane.showInternalConfirmDialog(
                            this,
                            """
                    Esta cedula está registrada.
                    Procede a habilitar el cliente?
                    """,
                            "",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );

                    //Preguntamos si desea cargar la informacion del cliente.
                    if (resp == JOptionPane.NO_OPTION) {
                        btnCancelarActionPerformed(evt);
                        return;
                    }

                    /**
                     * Al insertar un cliente ya registrado el siguiente metodo
                     * devuelve falso, es por ello se valida la negacion de
                     * false, para obtener true.
                     */
                    Resultado resultado = M_Cliente.insertById(idEmpleado);

                    //!resultado.getEstado();
                    JOptionPane.showInternalMessageDialog(
                            this,
                            resultado.getMensaje(),
                            "",
                            resultado.getIcono()
                    );
                } else {
                    int respuesta = JOptionPane.showInternalConfirmDialog(
                            this,
                            """
                    Este usuario esta registrado y activo.
                    Desea activar usuario?
                    """,
                            "Id Cliente: ".concat(idEmpleado.toString()),
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );

                    if (respuesta == JOptionPane.NO_OPTION) {
                        return;
                    }

                    Resultado resultado = M_Cliente.insertById(idEmpleado);

                    JOptionPane.showInternalMessageDialog(
                            this,
                            resultado.getMensaje(),
                            "",
                            resultado.getIcono()
                    );

                    btnCancelarActionPerformed(evt);
                }
            }
        }
    }//GEN-LAST:event_btnCedulaValidadActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        jcbPersona.requestFocus();
        jcbPersona.showPopup();
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void jcbEstadoCivilPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbEstadoCivilPopupMenuWillBecomeInvisible
        jcbSexo.requestFocus();
        jcbSexo.showPopup();
    }//GEN-LAST:event_jcbEstadoCivilPopupMenuWillBecomeInvisible

    private void txtPNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPNombreActionPerformed
        txtSNombre.requestFocus();
    }//GEN-LAST:event_txtPNombreActionPerformed

    private void jcbProvinciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProvinciasActionPerformed
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
            ).forEach(
                    municipio -> jcbMunicipios.addItem(municipio)
            );
            jcbMunicipios.setEnabled(true);
            jcbMunicipios.requestFocus();
        } else {
            jcbMunicipios.setEnabled(false);
        }
    }//GEN-LAST:event_jcbProvinciasActionPerformed

    private void jcbProvinciasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbProvinciasKeyPressed
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

    private void jcbMunicipiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMunicipiosActionPerformed
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

    private void jcbMunicipiosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbMunicipiosKeyPressed
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

    private void jcbDistritoMunicipalPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbDistritoMunicipalPopupMenuWillBecomeInvisible
        txtDireccion.requestFocus();
    }//GEN-LAST:event_jcbDistritoMunicipalPopupMenuWillBecomeInvisible

    private void jcbDistritoMunicipalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbDistritoMunicipalKeyPressed
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

    private void btnAgregarDireccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDireccionesActionPerformed
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

        //preguntamos si es la direccion por defecto.
        Boolean porDefecto = true;
        if (tblDireccion.getRowCount() > 0) {
            //Se pregunta si la direccion es por defecto.
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                Es la dirección por defecto del cliente?
                """,
                    """
                """,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            porDefecto = resp == JOptionPane.YES_OPTION;
        }

        //Se preparan la provincia, municipio y el distrito municipal.
        Integer id_direccion = -1;

        if (!nuevo && tblDireccion.getSelectedRow() >= 0) {
            id_direccion = ((ContactoDireccion) tblDireccion.getValueAt(
                    tblDireccion.getSelectedRow(),
                    3
            )).getId();
        }

        ContactoDireccion direccion = ContactoDireccion
                .builder()
                .id(id_direccion)
                .idPersona(idEmpleado)
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

        if (nuevo) {
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
            M_ContactoDireccion.insert(direccion);
        }

        LimpiarComboBoxProMuniDistr();

    }//GEN-LAST:event_btnAgregarDireccionesActionPerformed

    private void btnEditarDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDireccionActionPerformed
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

    private void btnBorrarDirrecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarDirrecionActionPerformed
        Utilidades.eliminarRegistroTabla(
                tblDireccion,
                v_dtmDireccion,
                v_direccionesList
        );

        btnDireccionEnable(false);

        LimpiarComboBoxProMuniDistr();
    }//GEN-LAST:event_btnBorrarDirrecionActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        btnAgregarDirecciones.doClick();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void tblDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDireccionMouseClicked
        btnDireccionEnable(true);
    }//GEN-LAST:event_tblDireccionMouseClicked

    private void txtTelelfonoMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelelfonoMovilActionPerformed
        btnAgregarTelefonoMovil.doClick();
    }//GEN-LAST:event_txtTelelfonoMovilActionPerformed

    private void txtTelelfonoMovilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelelfonoMovilKeyPressed
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

    private void btnAgregarTelefonoMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTelefonoMovilActionPerformed
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

        //Esta validacion deberia de ser si el cliente en nacional
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
        Boolean por_defecto = true;
        if (tblTelefonos.getRowCount() > 0) {
            //Se pregunta si la direccion es por defecto.
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                Es el telefono por defecto del cliente?
                """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            por_defecto = resp == JOptionPane.YES_OPTION;
        }

        Integer id_telefono = -1;

        if (!nuevo && tblTelefonos.getSelectedRow() >= 0) {
            id_telefono = ((ContactoDireccion) tblTelefonos.getValueAt(
                    tblTelefonos.getSelectedRow(),
                    0)).getId();
        }

        ContactoTel contactoTel = ContactoTel
                .builder()
                .id(id_telefono)
                .idPersona(idEmpleado)
                .telefono(txtTelelfonoMovil.getValue().toString())
                .tipo((jrbMovil.isSelected() ? "Movil" : "Telefono"))
                .fecha(new java.sql.Date(Calendar.getInstance().getTimeInMillis()))
                .estado(Boolean.TRUE)
                .porDefecto(por_defecto)
                .build();

        if (nuevo) {
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
        }

        limpiarTxtTelefonoMovil();

    }//GEN-LAST:event_btnAgregarTelefonoMovilActionPerformed

    private void btnBorrarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTelefonoActionPerformed

        if (nuevo) {

        } else {

        }

        Utilidades.eliminarRegistroTabla(tblTelefonos, v_dtmTelefono, v_contactosTelsList);

        btnBorrarTelefono.setEnabled(false);
        btnTelefonoEnable(false);
    }//GEN-LAST:event_btnBorrarTelefonoActionPerformed

    private void btnEditarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTelefonoActionPerformed
        btnTelefonoEnable(false);
    }//GEN-LAST:event_btnEditarTelefonoActionPerformed

    private void tblTelefonosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTelefonosMouseClicked
        btnTelefonoEnable(true);
    }//GEN-LAST:event_tblTelefonosMouseClicked

    private void btnAgregarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCorreoActionPerformed
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

        Boolean por_defecto = true;

        if (tblCorreos.getRowCount() > 0) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                Es el correo por defecto del cliente?
                """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            por_defecto = resp == JOptionPane.YES_OPTION;
        }

        Integer id_correo = -1;

        if (!nuevo && tblCorreos.getSelectedRow() >= 0) {
            id_correo = ((ContactoEmail) tblCorreos.getValueAt(
                    tblCorreos.getSelectedRow(), 0
            )).getId();
        }

        ContactoEmail contactoEmail = ContactoEmail
                .builder()
                .id(id_correo)
                .idPersona(idEmpleado)
                .email(txtCorreo.getText())
                .estado(Boolean.TRUE)
                .fecha(
                        new java.sql.Date(
                                Calendar.getInstance().getTimeInMillis()
                        )
                )
                .porDefecto(por_defecto)
                .build();

        if (nuevo) {
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
        }

        txtCorreo.setText("");
        txtCorreo.requestFocus();
    }//GEN-LAST:event_btnAgregarCorreoActionPerformed

    private void btnBorrarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCorreoActionPerformed

        if (nuevo) {

        } else {

        }

        Utilidades.eliminarRegistroTabla(
                tblCorreos,
                v_dtmCorreo,
                v_contactosCorreosList
        );
        btnCorreoEnable(false);
    }//GEN-LAST:event_btnBorrarCorreoActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        btnAgregarCorreo.doClick();
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtCorreoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyPressed
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

    private void btnEditarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCorreoActionPerformed
        btnCorreoEnable(false);
    }//GEN-LAST:event_btnEditarCorreoActionPerformed

    private void tblCorreosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCorreosMouseClicked
        btnCorreoEnable(true);
    }//GEN-LAST:event_tblCorreosMouseClicked

    private void jtpGeneralesDireccionContactosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtpGeneralesDireccionContactosKeyPressed
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

    private void txtFiltroBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroBusquedaKeyReleased
        modeloOrdenado.setRowFilter(RowFilter.regexFilter(
                "(?i)" + txtFiltroBusqueda.getText(), 0, 1, 2, 3, 4, 5, 6, 7, 8,
                9));
    }//GEN-LAST:event_txtFiltroBusquedaKeyReleased

    private void cbEstadoEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoEmpleadosActionPerformed
        if (!isShowing()) {
            return;
        }
        if (cbEstadoEmpleados.isSelected()) {
            cbEstadoEmpleados.setText("Empleado Activos");
        } else {
            cbEstadoEmpleados.setText("Empleado Inactivos");
        }
        llenarTabla(cbEstadoEmpleados.isSelected());
    }//GEN-LAST:event_cbEstadoEmpleadosActionPerformed

    private void jtEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEmpleadosMouseClicked
        if (evt.getClickCount() == 2) {
            btnModificarActionPerformed(null);
        }
    }//GEN-LAST:event_jtEmpleadosMouseClicked

    private void rSButtonGradientIcon_new1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonGradientIcon_new1ActionPerformed
        MainForm dedo = new MainForm(false);

        template = dedo.getTemplate();
    }//GEN-LAST:event_rSButtonGradientIcon_new1ActionPerformed

    private synchronized void mostrarRegistro() {
        if (jtEmpleados.getRowCount() == 0) {//Debe de haber un empleado seleccionado
            limpiarCampos();
            return;
        }

        verificarFotoHuella(txtCedula.getText().trim());
    }

    public synchronized void llenarTabla(boolean estado) {
        jtEmpleados.removeAll();
        String titulos[] = {
            "<html><b>Cedula</b></html>",
            "<html><b>Nombres y Apellidos</b></html>"
        };
        Object[] registro = new Object[titulos.length];

        DefaultTableModel dtmEmpleado = new DefaultTableModel(null, titulos);

        M_Empleado.select(
                Empleado
                        .builder()
                        .build()
        ).stream().forEach(
                empleado -> {
                    var general = M_Generales.select(
                            Generales
                                    .builder()
                                    .idPersona(empleado.getId())
                                    .build()
                    ).getLast();

                    registro[0] = general;
                    registro[1] = Empleado
                            .builder()
                            .id(empleado.getId())
                            .build();

                    dtmEmpleado.addRow(registro);
                }
        );

        jtEmpleados.setModel(dtmEmpleado);
        modeloOrdenado = new TableRowSorter<>(dtmEmpleado);
        jtEmpleados.setRowSorter(modeloOrdenado);

        //adjustColumnPreferredWidths(jtEmpleados);
    }

    public void limpiarCampos() {
        txtCedula.setValue(null);
        txtPNombre.setText("");
        txtSNombre.setText("");
        txtApellidos.setText("");
        
        dchFechaNacimiento.setDate(null);
        
        jcbPersona.setSelectedIndex(0);
        jcbEstadoCivil.setSelectedIndex(0);
        jcbSexo.setSelectedIndex(0);
        jcbDepartamentos.setSelectedIndex(0);
        jcbCargos.setSelectedIndex(0);
        
        jcbProvincias.setSelectedIndex(0);
        jcbMunicipios.removeAllItems();
        jcbDistritoMunicipal.removeAllItems();
        txtDireccion.setText("");
        tblDireccion.setModel(null);
        
        template = null;


        btnBorrarFoto.setEnabled(false);

        jlFoto.setText("Click para agregar foto");
        jlFoto.setIcon(null);
        
        txtCedula.requestFocusInWindow();
        Utilidades.showTooltip(txtCedula);
    }

    private void navegador(boolean b) {
        if (!nuevo) {
            txtCedula.setEditable(false);
            txtPNombre.requestFocusInWindow();
        }

        btnNuevo.setEnabled(b);
        btnModificar.setEnabled(b);
        btnBorrar.setEnabled(b);

        //Caja de Texto Habilitado
        btnCancelar.setEnabled(!b);
        btnGuardar.setEnabled(!b);
        btnCedulaValidad.setEnabled(!b);
    }

    private synchronized void controlesEditable(boolean b) {
        txtPNombre.setEditable(b);
        txtSNombre.setEditable(b);
        txtApellidos.setEditable(b);
        dchFechaNacimientoButton.setEnabled(b);
        jcbSexo.setEnabled(b);
        editor.setEditable(b);
        cbEstado.setEnabled(b);

        btnCedulaValidad.setEnabled(!b);
        txtCedula.setEditable(!b);
    }


    private void btnDireccionEnable(boolean valor) {
        btnEditarDireccion.setEnabled(valor);
        btnBorrarDirrecion.setEnabled(valor);
        txtDireccion.requestFocus();
    }

    private void verificarFotoHuella(String cedula) {
        if (fotoMap.containsKey(cedula)) {
            jlFoto.setText("");
            jlFoto.setIcon(new ImageIcon(fotoMap.get(cedula)
                    .getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
            btnBorrarFoto.setEnabled(true);
        } else {

            //Aqui deberia de buscar la ultima foto del empleado en la 
            //Carpeta de foto antes de ir a la base de datos.
            ResultSet p = getDatos("Obteniendo path de imagen de la ruta ed una foto Local").getPathFoto(cedula);
            File f = null;
            try {
                while (p.next()) {
                    f = new File("foto/" + p.getString("NOMBRE_ARCHIVO"));
                }
            } catch (SQLException ex) {
                LOG.log(
                        Level.SEVERE,
                        null,
                        ex
                );
            }

            try {
                jlFoto.setIcon(new ImageIcon(f.getAbsolutePath()));
            } catch (NullPointerException e) {
                LOG.log(
                        Level.SEVERE,
                        "",
                        e
                );

            }

            if (jlFoto.getIcon() != null) {
                return;
            }

            Image img = getDatos("Obteniendo una imagen del usuario").
                    getImagenes("select FOTO "
                            + "from T_EMPLEADOS "
                            + "where Cedula = '" + cedula + "';");
            if (img != null) {
                fotoMap.put(cedula, img);
                jlFoto.setText("");
                jlFoto.setIcon(new ImageIcon(fotoMap.get(cedula)
                        .getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
                btnBorrarFoto.setEnabled(true);
            } else {
                jlFoto.setText("Click para agregar foto");
                jlFoto.setIcon(null);
                btnBorrarFoto.setEnabled(false);
            }
        }

//        if (getDatos("Investigando si el empleado tiene huella").tieneHuella(
//                cedula)) {
//            btnBorrarHuella.setEnabled(true);
//            stop();
//            estadoHuellas();
//        } else {
//            btnBorrarHuella.setEnabled(false);
//            start();
//            estadoHuellas();
//        }
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
        limpiarTxtTelefonoMovil();
    }

    private void limpiarTxtTelefonoMovil() {
        txtTelelfonoMovil.setValue("");
        txtTelelfonoMovil.requestFocus();
        jrbMovil.setSelected(true);
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

    private void llenarComboBox() {
        jcbSexo.removeAllItems();
        M_Sexo.getSexoList().forEach(
                sexo -> {
                    jcbSexo.addItem(sexo);
                }
        );

        jcbEstadoCivil.removeAllItems();
        M_EstadoCivil.getEstadoCivilList().forEach(
                estado -> {
                    jcbEstadoCivil.addItem(estado);
                }
        );

        jcbPersona.removeAllItems();
        M_TipoPersona.getTipoPersonaList().forEach(
                tipo -> {
                    jcbPersona.addItem(tipo);
                }
        );

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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarCorreo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarDirecciones;
    private javax.swing.JButton btnAgregarFoto;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarTelefonoMovil;
    private javax.swing.JButton btnBorrar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarCorreo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarDirrecion;
    private javax.swing.JButton btnBorrarFoto;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarTelefono;
    private javax.swing.JButton btnCancelar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCedulaValidad;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditarCorreo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditarDireccion;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditarTelefono;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JCheckBox cbEstado;
    private RSMaterialComponent.RSCheckBoxMaterial cbEstadoEmpleados;
    private com.toedter.calendar.JDateChooser dchFechaNacimiento;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JComboBox<Cargo> jcbCargos;
    private javax.swing.JComboBox<Departamento> jcbDepartamentos;
    private javax.swing.JComboBox<sur.softsurena.entidades.DistritoMunicipal> jcbDistritoMunicipal;
    private static javax.swing.JComboBox<EstadoCivil> jcbEstadoCivil;
    private javax.swing.JComboBox<Municipio> jcbMunicipios;
    private static javax.swing.JComboBox<TipoPersona> jcbPersona;
    private static javax.swing.JComboBox<Provincia> jcbProvincias;
    private static javax.swing.JComboBox<Sexo> jcbSexo;
    private javax.swing.JLabel jlFechaCreacion;
    private javax.swing.JLabel jlFoto;
    private javax.swing.JMenuItem jmCopia;
    private javax.swing.JMenuItem jmCortar;
    private javax.swing.JMenuItem jmPegar;
    private javax.swing.JMenuItem jmSeleccionarTodo1;
    private javax.swing.JMenuItem jmiVistaPrevia;
    private javax.swing.JPanel jpContactos;
    private javax.swing.JPanel jpCorreos;
    private javax.swing.JPanel jpDireccion;
    private javax.swing.JPanel jpEmpleados;
    private javax.swing.JPanel jpFiltro;
    private javax.swing.JPanel jpFoto;
    private javax.swing.JPanel jpGenerales;
    private javax.swing.JPanel jpMantenimiento;
    private javax.swing.JPanel jpNavegacion;
    private javax.swing.JPanel jpTelefonos;
    private javax.swing.JPopupMenu jpmVistaPrevia;
    private javax.swing.JRadioButton jrbMovil;
    private javax.swing.JRadioButton jrbResidencial;
    private javax.swing.JScrollPane jspMantenimiento;
    private RSMaterialComponent.RSTableMetroCustom jtEmpleados;
    private javax.swing.JTabbedPane jtpContactos;
    private javax.swing.JTabbedPane jtpGeneral;
    private javax.swing.JTabbedPane jtpGeneralesDireccionContactos;
    private javax.swing.JPopupMenu miJPopUpMenu;
    private newscomponents.RSButtonGradientIcon_new rSButtonGradientIcon_new1;
    private newscomponents.RSPanelEffect rSPanelEffect1;
    private RSMaterialComponent.RSPanelMaterialGradient rSPanelMaterialGradient1;
    private static rojerusan.RSTableMetro1 tblCorreos;
    private static rojerusan.RSTableMetro1 tblDireccion;
    private static rojerusan.RSTableMetro1 tblTelefonos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private RSMaterialComponent.RSTextFieldMaterialIcon txtFiltroBusqueda;
    private javax.swing.JTextField txtPNombre;
    private javax.swing.JTextField txtSNombre;
    private javax.swing.JFormattedTextField txtTelelfonoMovil;
    // End of variables declaration//GEN-END:variables
}
