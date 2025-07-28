package sur.softsurena.vistas;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.ToolTipManager;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.entidades.Categoria;
import sur.softsurena.entidades.Doctor;
import sur.softsurena.entidades.Medicamento;
import sur.softsurena.entidades.Paciente;
import static sur.softsurena.metodos.M_Motivo_Consulta.agregarMotivo;
import static sur.softsurena.metodos.M_Motivo_Consulta.getMotivo;
import sur.softsurena.utilidades.Utilidades;

/**
 *
 * @author jhironsel
 */
public final class VistaConsultas extends javax.swing.JInternalFrame {

    private static VistaConsultas consulta;
    private static final long serialVersionUID = 1L;
    private int idPaciente;
    private int registro;
//    private Object[] reg;
    private DefaultTableModel miTablaMedicamento;

    public VistaConsultas() {

        initComponents();
        dcConsulta.setDate(new Date());
        dcReferimiento.setDate(new Date());
        jtGuiaVigilanciaDesarrollo.setVisible(false);
        dcVigilanciaDesarrollo.setVisible(false);
        btnAplicarFecha.setVisible(false);
        txtNombres.requestFocus();

        nuevaTabla();
    }

    public static synchronized VistaConsultas getConsultas() {
        if (consulta == null) {
            consulta = new VistaConsultas();
        }
        return consulta;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpmEnfermedades = new javax.swing.JPopupMenu();
        jmiSeleccionarTodo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiCopiar = new javax.swing.JMenuItem();
        jmiCortar = new javax.swing.JMenuItem();
        jmiPegar = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jmiCambiarFuente = new javax.swing.JMenuItem();
        jmiCambiarFondoEnfermedades = new javax.swing.JMenuItem();
        jpmHallazgosPositivos = new javax.swing.JPopupMenu();
        jmiSeleccionarTodo1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmiCopiar1 = new javax.swing.JMenuItem();
        jmiCortar1 = new javax.swing.JMenuItem();
        jmiPegar1 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jmiCambiarFuente1 = new javax.swing.JMenuItem();
        jmiCambiarFondoHAllazgos = new javax.swing.JMenuItem();
        jspPadre = new javax.swing.JScrollPane();
        jtpVisor = new javax.swing.JTabbedPane();
        jpListadoConsulta = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtPacientes = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtGuiaVigilanciaDesarrollo = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                if(colIndex == 2 & jcbOpcionesVigilanciaDesarrollo.getSelectedIndex() == 1) return true;
                return false; //Las celdas no son editables. 
            }
        };
        jcbOpcionesVigilanciaDesarrollo = new javax.swing.JComboBox<>();
        dcVigilanciaDesarrollo = new com.toedter.calendar.JDateChooser();
        btnAplicarFecha = new javax.swing.JButton();
        jpMotivo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpMotivos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jlEliminarMotivo = new javax.swing.JLabel();
        jlAgregarMotivo = new javax.swing.JLabel();
        jpDetenciones = new javax.swing.JPanel();
        jpEnfermedades = new javax.swing.JPanel();
        jspEnfermedades = new javax.swing.JScrollPane();
        txtEnfermedades = new javax.swing.JTextArea();
        jpHallazgosPositivos = new javax.swing.JPanel();
        jspHallazgosPositivos = new javax.swing.JScrollPane();
        txtHallazgos = new javax.swing.JTextArea();
        jpMetricas = new javax.swing.JPanel();
        jsPeso = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jsLongitud = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jsPCefalico = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jsEstatura = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        jpEnfermedades1 = new javax.swing.JPanel();
        jspEnfermedades1 = new javax.swing.JScrollPane();
        txtID = new javax.swing.JTextArea();
        jpEnfermedades2 = new javax.swing.JPanel();
        jspEnfermedades2 = new javax.swing.JScrollPane();
        txtTx = new javax.swing.JTextArea();
        jpEnfermedades3 = new javax.swing.JPanel();
        jspEnfermedades3 = new javax.swing.JScrollPane();
        txtComplemento = new javax.swing.JTextArea();
        jpEnfermedades4 = new javax.swing.JPanel();
        jspEnfermedades4 = new javax.swing.JScrollPane();
        txtReferimiento = new javax.swing.JTextArea();
        dcReferimiento = new com.toedter.calendar.JDateChooser();
        cbDoctores = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jcbIncluirReceta = new javax.swing.JCheckBox();
        jcbMedicamentos = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReceta = new javax.swing.JTable();
        txtFiltroMedicamentos = new javax.swing.JTextField();
        btnAgregarMedicamento = new javax.swing.JButton();
        jpMetricasGraficas = new javax.swing.JPanel();
        jpTipoGrafica = new javax.swing.JPanel();
        cbOpcionGrafica = new javax.swing.JComboBox<>();
        jpGrafica = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        dcConsulta = new com.toedter.calendar.JDateChooser();
        txtArs = new javax.swing.JTextField();
        txtNoArs = new javax.swing.JTextField();
        btnTerminarConsulta = new javax.swing.JButton();
        btnMensajes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jmiSeleccionarTodo.setText("Seleccionar Todo");
        jmiSeleccionarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSeleccionarTodoActionPerformed(evt);
            }
        });
        jpmEnfermedades.add(jmiSeleccionarTodo);

        jSeparator1.setBackground(new java.awt.Color(255, 245, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 245, 0));
        jSeparator1.setToolTipText("");
        jpmEnfermedades.add(jSeparator1);

        jmiCopiar.setText("Copiar");
        jmiCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCopiarActionPerformed(evt);
            }
        });
        jpmEnfermedades.add(jmiCopiar);

        jmiCortar.setText("Cortar");
        jmiCortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCortarActionPerformed(evt);
            }
        });
        jpmEnfermedades.add(jmiCortar);

        jmiPegar.setText("Pegar");
        jmiPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPegarActionPerformed(evt);
            }
        });
        jpmEnfermedades.add(jmiPegar);

        jSeparator3.setBackground(new java.awt.Color(255, 245, 0));
        jSeparator3.setForeground(new java.awt.Color(255, 245, 0));
        jpmEnfermedades.add(jSeparator3);

        jmiCambiarFuente.setText("Cambiar Fuente");
        jmiCambiarFuente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCambiarFuenteActionPerformed(evt);
            }
        });
        jpmEnfermedades.add(jmiCambiarFuente);

        jmiCambiarFondoEnfermedades.setText("Cambiar Fondo");
        jmiCambiarFondoEnfermedades.setEnabled(false);
        jmiCambiarFondoEnfermedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCambiarFondoEnfermedadesActionPerformed(evt);
            }
        });
        jpmEnfermedades.add(jmiCambiarFondoEnfermedades);

        jmiSeleccionarTodo1.setText("Seleccionar Todo");
        jmiSeleccionarTodo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSeleccionarTodo1ActionPerformed(evt);
            }
        });
        jpmHallazgosPositivos.add(jmiSeleccionarTodo1);

        jSeparator2.setBackground(new java.awt.Color(255, 245, 0));
        jSeparator2.setForeground(new java.awt.Color(255, 245, 0));
        jpmHallazgosPositivos.add(jSeparator2);

        jmiCopiar1.setText("Copiar");
        jmiCopiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCopiar1ActionPerformed(evt);
            }
        });
        jpmHallazgosPositivos.add(jmiCopiar1);

        jmiCortar1.setText("Cortar");
        jmiCortar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCortar1ActionPerformed(evt);
            }
        });
        jpmHallazgosPositivos.add(jmiCortar1);

        jmiPegar1.setText("Pegar");
        jmiPegar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPegar1ActionPerformed(evt);
            }
        });
        jpmHallazgosPositivos.add(jmiPegar1);

        jSeparator4.setBackground(new java.awt.Color(255, 245, 0));
        jSeparator4.setForeground(new java.awt.Color(255, 245, 0));
        jpmHallazgosPositivos.add(jSeparator4);

        jmiCambiarFuente1.setText("Cambiar Fuente");
        jmiCambiarFuente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCambiarFuente1ActionPerformed(evt);
            }
        });
        jpmHallazgosPositivos.add(jmiCambiarFuente1);

        jmiCambiarFondoHAllazgos.setText("Cambiar Fondo");
        jmiCambiarFondoHAllazgos.setEnabled(false);
        jmiCambiarFondoHAllazgos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCambiarFondoHAllazgosActionPerformed(evt);
            }
        });
        jpmHallazgosPositivos.add(jmiCambiarFondoHAllazgos);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion de consulta medica");
        setToolTipText("Control de los paciente ");
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

        jtpVisor.setBackground(new java.awt.Color(49, 163, 217));
        jtpVisor.setMaximumSize(new java.awt.Dimension(200, 200));
        jtpVisor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtpVisorMouseClicked(evt);
            }
        });
        jtpVisor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtpVisorKeyReleased(evt);
            }
        });

        jpListadoConsulta.setFocusable(false);
        jpListadoConsulta.setPreferredSize(new java.awt.Dimension(0, 0));
        jpListadoConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jpListadoConsultaKeyReleased(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(49, 163, 217));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de pacientes disponible hasta la fecha."));
        jScrollPane2.setFocusable(false);

        jtPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nombres", "Apellidos", "Ultima consulta", "Estado"
            }
        ));
        jtPacientes.setFocusable(false);
        jtPacientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPacientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtPacientes);

        javax.swing.GroupLayout jpListadoConsultaLayout = new javax.swing.GroupLayout(jpListadoConsulta);
        jpListadoConsulta.setLayout(jpListadoConsultaLayout);
        jpListadoConsultaLayout.setHorizontalGroup(
            jpListadoConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
        );
        jpListadoConsultaLayout.setVerticalGroup(
            jpListadoConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListadoConsultaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jtpVisor.addTab("Listado de consultas", jpListadoConsulta);

        jScrollPane4.setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel5.setBackground(new java.awt.Color(49, 163, 217));

        jtGuiaVigilanciaDesarrollo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtGuiaVigilanciaDesarrollo.setEnabled(false);
        jtGuiaVigilanciaDesarrollo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtGuiaVigilanciaDesarrollo.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jtGuiaVigilanciaDesarrollo);
        jtGuiaVigilanciaDesarrollo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jcbOpcionesVigilanciaDesarrollo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija una opcion", "Edad de 0 meses", "Edad diferentes a 0 meses" }));
        jcbOpcionesVigilanciaDesarrollo.setEnabled(false);
        jcbOpcionesVigilanciaDesarrollo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbOpcionesVigilanciaDesarrolloActionPerformed(evt);
            }
        });

        btnAplicarFecha.setText("Aplicar fecha");
        btnAplicarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jcbOpcionesVigilanciaDesarrollo, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcVigilanciaDesarrollo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAplicarFecha)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbOpcionesVigilanciaDesarrollo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcVigilanciaDesarrollo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAplicarFecha))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel5);

        jtpVisor.addTab("Vigilancia del Desarrollo", jScrollPane4);

        jpMotivo.setFocusable(false);
        jpMotivo.setPreferredSize(new java.awt.Dimension(0, 0));

        jpMotivos.setBackground(new java.awt.Color(49, 163, 217));
        jpMotivos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(1, 1, 1)), "Motivo de la consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(1, 1, 1))); // NOI18N
        jpMotivos.setMinimumSize(new java.awt.Dimension(588, 241));
        jpMotivos.setPreferredSize(new java.awt.Dimension(588, 241));
        jpMotivos.setLayout(new java.awt.GridLayout(0, 4));

        jPanel1.setPreferredSize(new java.awt.Dimension(70, 30));

        jlEliminarMotivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlEliminarMotivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-eliminar-32.png"))); // NOI18N
        jlEliminarMotivo.setToolTipText("Eliminar Motivos");
        jlEliminarMotivo.setFocusTraversalPolicyProvider(true);
        jlEliminarMotivo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlEliminarMotivo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlEliminarMotivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlEliminarMotivoMouseClicked(evt);
            }
        });

        jlAgregarMotivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAgregarMotivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-más-32.png"))); // NOI18N
        jlAgregarMotivo.setToolTipText("Agregue mas Motivos");
        jlAgregarMotivo.setFocusTraversalPolicyProvider(true);
        jlAgregarMotivo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlAgregarMotivo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlAgregarMotivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlAgregarMotivoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jlAgregarMotivo)
                .addGap(0, 0, 0)
                .addComponent(jlEliminarMotivo)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlAgregarMotivo)
                    .addComponent(jlEliminarMotivo))
                .addGap(0, 0, 0))
        );

        jpMotivos.add(jPanel1);

        jScrollPane1.setViewportView(jpMotivos);

        javax.swing.GroupLayout jpMotivoLayout = new javax.swing.GroupLayout(jpMotivo);
        jpMotivo.setLayout(jpMotivoLayout);
        jpMotivoLayout.setHorizontalGroup(
            jpMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMotivoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE))
        );
        jpMotivoLayout.setVerticalGroup(
            jpMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMotivoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
        );

        jtpVisor.addTab("Motivos", jpMotivo);

        jpDetenciones.setPreferredSize(new java.awt.Dimension(0, 0));

        jpEnfermedades.setBackground(new java.awt.Color(49, 163, 217));
        jpEnfermedades.setBorder(javax.swing.BorderFactory.createTitledBorder("Enfermedades Detectadas"));

        jspEnfermedades.setOpaque(false);

        txtEnfermedades.setFont(new java.awt.Font("Courier New", 1, 28)); // NOI18N
        txtEnfermedades.setLineWrap(true);
        txtEnfermedades.setTabSize(3);
        txtEnfermedades.setWrapStyleWord(true);
        txtEnfermedades.setComponentPopupMenu(jpmEnfermedades);
        txtEnfermedades.setEnabled(false);
        txtEnfermedades.setOpaque(false);
        jspEnfermedades.setViewportView(txtEnfermedades);

        javax.swing.GroupLayout jpEnfermedadesLayout = new javax.swing.GroupLayout(jpEnfermedades);
        jpEnfermedades.setLayout(jpEnfermedadesLayout);
        jpEnfermedadesLayout.setHorizontalGroup(
            jpEnfermedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnfermedadesLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jspEnfermedades)
                .addGap(0, 0, 0))
        );
        jpEnfermedadesLayout.setVerticalGroup(
            jpEnfermedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnfermedadesLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jspEnfermedades, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jpHallazgosPositivos.setBackground(new java.awt.Color(49, 163, 217));
        jpHallazgosPositivos.setBorder(javax.swing.BorderFactory.createTitledBorder("Hallazgos Positivos"));

        jspHallazgosPositivos.setOpaque(false);

        txtHallazgos.setFont(new java.awt.Font("Courier New", 1, 28)); // NOI18N
        txtHallazgos.setLineWrap(true);
        txtHallazgos.setTabSize(3);
        txtHallazgos.setWrapStyleWord(true);
        txtHallazgos.setComponentPopupMenu(jpmHallazgosPositivos);
        txtHallazgos.setEnabled(false);
        txtHallazgos.setOpaque(false);
        txtHallazgos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHallazgosKeyReleased(evt);
            }
        });
        jspHallazgosPositivos.setViewportView(txtHallazgos);

        javax.swing.GroupLayout jpHallazgosPositivosLayout = new javax.swing.GroupLayout(jpHallazgosPositivos);
        jpHallazgosPositivos.setLayout(jpHallazgosPositivosLayout);
        jpHallazgosPositivosLayout.setHorizontalGroup(
            jpHallazgosPositivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHallazgosPositivosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jspHallazgosPositivos)
                .addGap(0, 0, 0))
        );
        jpHallazgosPositivosLayout.setVerticalGroup(
            jpHallazgosPositivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpHallazgosPositivosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jspHallazgosPositivos)
                .addGap(0, 0, 0))
        );

        jpMetricas.setBackground(new java.awt.Color(49, 163, 217));
        jpMetricas.setBorder(javax.swing.BorderFactory.createTitledBorder("Medidas fisicas"));

        jsPeso.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(13.3f), Float.valueOf(2.0f), Float.valueOf(29.0f), Float.valueOf(1.0f)));
        jsPeso.setToolTipText("Registre el peso del paciente");
        jsPeso.setEnabled(false);

        jLabel6.setText("Peso Kg");

        jLabel7.setText("Longitud cm");

        jsLongitud.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(92.0f), Float.valueOf(43.0f), Float.valueOf(125.0f), Float.valueOf(1.0f)));
        jsLongitud.setToolTipText("Registre la talla o estatura del paciente");
        jsLongitud.setEnabled(false);

        jLabel8.setText("<html>Perimetro <br>Cefálico cm</html>");

        jsPCefalico.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(47.4f), Float.valueOf(30.0f), Float.valueOf(54.0f), Float.valueOf(1.0f)));
        jsPCefalico.setToolTipText("Registre el perimetro cefalico o craneal del paciente");
        jsPCefalico.setEnabled(false);

        jLabel10.setText("Estatura cm");

        jsEstatura.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(92.0f), Float.valueOf(43.0f), Float.valueOf(125.0f), Float.valueOf(1.0f)));
        jsEstatura.setToolTipText("Registre la talla o estatura del paciente");
        jsEstatura.setEnabled(false);

        javax.swing.GroupLayout jpMetricasLayout = new javax.swing.GroupLayout(jpMetricas);
        jpMetricas.setLayout(jpMetricasLayout);
        jpMetricasLayout.setHorizontalGroup(
            jpMetricasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMetricasLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jpMetricasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jsPeso)
                    .addComponent(jsLongitud)
                    .addComponent(jsEstatura)
                    .addComponent(jsPCefalico)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jpMetricasLayout.setVerticalGroup(
            jpMetricasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMetricasLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addComponent(jsPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(0, 0, 0)
                .addComponent(jsLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(0, 0, 0)
                .addComponent(jsEstatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jsPCefalico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jpDetencionesLayout = new javax.swing.GroupLayout(jpDetenciones);
        jpDetenciones.setLayout(jpDetencionesLayout);
        jpDetencionesLayout.setHorizontalGroup(
            jpDetencionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpEnfermedades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpDetencionesLayout.createSequentialGroup()
                .addComponent(jpMetricas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpHallazgosPositivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpDetencionesLayout.setVerticalGroup(
            jpDetencionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDetencionesLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpEnfermedades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(jpDetencionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpMetricas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpHallazgosPositivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jtpVisor.addTab("Detenciones", jpDetenciones);

        jPanel4.setPreferredSize(new java.awt.Dimension(0, 0));

        jpEnfermedades1.setBackground(new java.awt.Color(49, 163, 217));
        jpEnfermedades1.setBorder(javax.swing.BorderFactory.createTitledBorder("I.D.:"));
        jpEnfermedades1.setPreferredSize(new java.awt.Dimension(255, 126));

        jspEnfermedades1.setOpaque(false);

        txtID.setFont(new java.awt.Font("Courier New", 1, 28)); // NOI18N
        txtID.setLineWrap(true);
        txtID.setTabSize(3);
        txtID.setWrapStyleWord(true);
        txtID.setComponentPopupMenu(jpmEnfermedades);
        txtID.setEnabled(false);
        txtID.setOpaque(false);
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
            }
        });
        jspEnfermedades1.setViewportView(txtID);

        javax.swing.GroupLayout jpEnfermedades1Layout = new javax.swing.GroupLayout(jpEnfermedades1);
        jpEnfermedades1.setLayout(jpEnfermedades1Layout);
        jpEnfermedades1Layout.setHorizontalGroup(
            jpEnfermedades1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnfermedades1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jspEnfermedades1)
                .addGap(0, 0, 0))
        );
        jpEnfermedades1Layout.setVerticalGroup(
            jpEnfermedades1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnfermedades1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jspEnfermedades1)
                .addGap(0, 0, 0))
        );

        jpEnfermedades2.setBackground(new java.awt.Color(49, 163, 217));
        jpEnfermedades2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tx.:"));
        jpEnfermedades2.setPreferredSize(new java.awt.Dimension(255, 126));

        jspEnfermedades2.setOpaque(false);

        txtTx.setFont(new java.awt.Font("Courier New", 1, 28)); // NOI18N
        txtTx.setLineWrap(true);
        txtTx.setTabSize(3);
        txtTx.setWrapStyleWord(true);
        txtTx.setComponentPopupMenu(jpmEnfermedades);
        txtTx.setEnabled(false);
        txtTx.setOpaque(false);
        txtTx.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTxKeyReleased(evt);
            }
        });
        jspEnfermedades2.setViewportView(txtTx);

        javax.swing.GroupLayout jpEnfermedades2Layout = new javax.swing.GroupLayout(jpEnfermedades2);
        jpEnfermedades2.setLayout(jpEnfermedades2Layout);
        jpEnfermedades2Layout.setHorizontalGroup(
            jpEnfermedades2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspEnfermedades2)
        );
        jpEnfermedades2Layout.setVerticalGroup(
            jpEnfermedades2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspEnfermedades2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jpEnfermedades3.setBackground(new java.awt.Color(49, 163, 217));
        jpEnfermedades3.setBorder(javax.swing.BorderFactory.createTitledBorder("Complemento.:"));

        jspEnfermedades3.setOpaque(false);

        txtComplemento.setFont(new java.awt.Font("Courier New", 1, 28)); // NOI18N
        txtComplemento.setLineWrap(true);
        txtComplemento.setTabSize(3);
        txtComplemento.setWrapStyleWord(true);
        txtComplemento.setComponentPopupMenu(jpmEnfermedades);
        txtComplemento.setEnabled(false);
        txtComplemento.setOpaque(false);
        txtComplemento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtComplementoKeyReleased(evt);
            }
        });
        jspEnfermedades3.setViewportView(txtComplemento);

        javax.swing.GroupLayout jpEnfermedades3Layout = new javax.swing.GroupLayout(jpEnfermedades3);
        jpEnfermedades3.setLayout(jpEnfermedades3Layout);
        jpEnfermedades3Layout.setHorizontalGroup(
            jpEnfermedades3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspEnfermedades3)
        );
        jpEnfermedades3Layout.setVerticalGroup(
            jpEnfermedades3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspEnfermedades3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        jpEnfermedades4.setBackground(new java.awt.Color(49, 163, 217));
        jpEnfermedades4.setBorder(javax.swing.BorderFactory.createTitledBorder("Referimiento.:"));
        jpEnfermedades4.setPreferredSize(new java.awt.Dimension(740, 127));

        jspEnfermedades4.setOpaque(false);

        txtReferimiento.setFont(new java.awt.Font("Courier New", 1, 28)); // NOI18N
        txtReferimiento.setLineWrap(true);
        txtReferimiento.setTabSize(3);
        txtReferimiento.setWrapStyleWord(true);
        txtReferimiento.setComponentPopupMenu(jpmEnfermedades);
        txtReferimiento.setEnabled(false);
        txtReferimiento.setOpaque(false);
        txtReferimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtReferimientoKeyReleased(evt);
            }
        });
        jspEnfermedades4.setViewportView(txtReferimiento);

        dcReferimiento.setEnabled(false);

        cbDoctores.setEnabled(false);

        javax.swing.GroupLayout jpEnfermedades4Layout = new javax.swing.GroupLayout(jpEnfermedades4);
        jpEnfermedades4.setLayout(jpEnfermedades4Layout);
        jpEnfermedades4Layout.setHorizontalGroup(
            jpEnfermedades4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspEnfermedades4)
            .addGroup(jpEnfermedades4Layout.createSequentialGroup()
                .addComponent(dcReferimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cbDoctores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpEnfermedades4Layout.setVerticalGroup(
            jpEnfermedades4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnfermedades4Layout.createSequentialGroup()
                .addGroup(jpEnfermedades4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbDoctores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcReferimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jspEnfermedades4, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
        );

        dcReferimiento.getDateEditor().addPropertyChangeListener(
            new PropertyChangeListener(){
                public void propertyChange(PropertyChangeEvent e) {
                    if(isShowing() & e.getPropertyName().equals("date")){
                        llenarComboxDoctores(true);
                    }
                }
            });

            javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
            jPanel4.setLayout(jPanel4Layout);
            jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jpEnfermedades4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
                        .addComponent(jpEnfermedades3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jpEnfermedades1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                            .addGap(0, 0, 0)
                            .addComponent(jpEnfermedades2, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)))
                    .addGap(0, 0, 0))
            );
            jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jpEnfermedades1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addComponent(jpEnfermedades2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                    .addComponent(jpEnfermedades3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)
                    .addComponent(jpEnfermedades4, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addGap(0, 0, 0))
            );

            jtpVisor.addTab("Diagnoticos y recetas", jPanel4);

            jLabel9.setFont(new java.awt.Font("Century Schoolbook L", 2, 24)); // NOI18N
            jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel9.setText("Recetario de pacientes.");

            jcbIncluirReceta.setText("Incluir receta");
            jcbIncluirReceta.setEnabled(false);
            jcbIncluirReceta.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jcbIncluirRecetaActionPerformed(evt);
                }
            });

            jcbMedicamentos.setEnabled(false);
            jcbMedicamentos.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jcbMedicamentosActionPerformed(evt);
                }
            });

            tblReceta.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Linea", "Descripcion", "Uso o Docis", "Cantidad"
                }
            ));
            tblReceta.setEnabled(false);
            jScrollPane3.setViewportView(tblReceta);

            txtFiltroMedicamentos.setEnabled(false);
            txtFiltroMedicamentos.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtFiltroMedicamentosActionPerformed(evt);
                }
            });
            txtFiltroMedicamentos.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    txtFiltroMedicamentosKeyReleased(evt);
                }
            });

            btnAgregarMedicamento.setText("Agregar");
            btnAgregarMedicamento.setEnabled(false);
            btnAgregarMedicamento.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnAgregarMedicamentoActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jcbMedicamentos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnAgregarMedicamento)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtFiltroMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jcbIncluirReceta)
                    .addGap(0, 0, Short.MAX_VALUE))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel9)
                    .addGap(0, 0, 0)
                    .addComponent(jcbIncluirReceta)
                    .addGap(0, 0, 0)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFiltroMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarMedicamento))
                    .addGap(0, 0, 0)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE))
            );

            jtpVisor.addTab("Receta", jPanel2);

            jpMetricasGraficas.setPreferredSize(new java.awt.Dimension(0, 0));

            jpTipoGrafica.setBackground(new java.awt.Color(49, 163, 217));
            jpTipoGrafica.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de graficas"));

            cbOpcionGrafica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciones una opcion", "Perímetro cefálico \"Nacimiento a 3 años\"", "Peso para la edad \"Nacimiento a 5 años\"", "Longitud/Estatura para la edad \"Nacimiento a 5 años\"", "Peso para la Longitud \"Nacimiento a 2 años\"", "Peso para la estatura \"2 a 5 años\"" }));
            cbOpcionGrafica.setEnabled(false);
            cbOpcionGrafica.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    cbOpcionGraficaItemStateChanged(evt);
                }
            });

            javax.swing.GroupLayout jpTipoGraficaLayout = new javax.swing.GroupLayout(jpTipoGrafica);
            jpTipoGrafica.setLayout(jpTipoGraficaLayout);
            jpTipoGraficaLayout.setHorizontalGroup(
                jpTipoGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpTipoGraficaLayout.createSequentialGroup()
                    .addComponent(cbOpcionGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0))
            );
            jpTipoGraficaLayout.setVerticalGroup(
                jpTipoGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpTipoGraficaLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(cbOpcionGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            );

            jpGrafica.setBackground(new java.awt.Color(49, 163, 217));
            jpGrafica.setBorder(javax.swing.BorderFactory.createTitledBorder("Grafica del paciente"));
            jpGrafica.setPreferredSize(new java.awt.Dimension(0, 0));

            javax.swing.GroupLayout jpGraficaLayout = new javax.swing.GroupLayout(jpGrafica);
            jpGrafica.setLayout(jpGraficaLayout);
            jpGraficaLayout.setHorizontalGroup(
                jpGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
            );
            jpGraficaLayout.setVerticalGroup(
                jpGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 515, Short.MAX_VALUE)
            );

            javax.swing.GroupLayout jpMetricasGraficasLayout = new javax.swing.GroupLayout(jpMetricasGraficas);
            jpMetricasGraficas.setLayout(jpMetricasGraficasLayout);
            jpMetricasGraficasLayout.setHorizontalGroup(
                jpMetricasGraficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpTipoGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
            );
            jpMetricasGraficasLayout.setVerticalGroup(
                jpMetricasGraficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpMetricasGraficasLayout.createSequentialGroup()
                    .addComponent(jpTipoGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jpGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                    .addGap(0, 0, 0))
            );

            jtpVisor.addTab("Graficas metricas", jpMetricasGraficas);

            jspPadre.setViewportView(jtpVisor);

            jPanel3.setBackground(new java.awt.Color(49, 163, 217));

            txtNombres.setEditable(false);
            txtNombres.setBackground(new java.awt.Color(49, 163, 217));

            txtApellidos.setEditable(false);

            dcConsulta.setBackground(new java.awt.Color(49, 163, 217));
            dcConsulta.setOpaque(false);

            txtArs.setEditable(false);

            txtNoArs.setEditable(false);

            btnTerminarConsulta.setText("Terminar Consulta");
            btnTerminarConsulta.setEnabled(false);
            btnTerminarConsulta.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnTerminarConsultaActionPerformed(evt);
                }
            });

            btnMensajes.setText("Mensajes");
            btnMensajes.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnMensajesActionPerformed(evt);
                }
            });

            jLabel1.setForeground(new java.awt.Color(254, 254, 254));
            jLabel1.setText("Nombres");

            jLabel2.setForeground(new java.awt.Color(254, 254, 254));
            jLabel2.setText("Apellidos");

            jLabel4.setForeground(new java.awt.Color(254, 254, 254));
            jLabel4.setText("Fecha:");

            jLabel3.setForeground(new java.awt.Color(254, 254, 254));
            jLabel3.setText("Ars");

            jLabel5.setForeground(new java.awt.Color(254, 254, 254));
            jLabel5.setText("No. Ars");

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(txtArs, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNoArs)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dcConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnTerminarConsulta)
                    .addContainerGap(358, Short.MAX_VALUE))
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(0, 0, 0)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(0, 0, 0)
                            .addComponent(dcConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5))
                    .addGap(0, 0, 0)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(btnTerminarConsulta)
                        .addComponent(txtArs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNoArs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMensajes))
                    .addContainerGap())
            );

            dcConsulta.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener(){
                    public void propertyChange(PropertyChangeEvent e) {
                        if(isShowing() & e.getPropertyName().equals("date")){
                            jtPacientes.setSelectionMode(0);
                            //llenarTabla(Utilidades.formatDate(dcConsulta.getDate(), "");
                                btnTerminarConsulta.doClick();
                            }
                        }
                    });

                    jScrollPane6.setViewportView(jPanel3);

                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                    getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jspPadre)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    );
                    layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jspPadre)
                            .addGap(0, 0, 0))
                    );

                    pack();
                }// </editor-fold>//GEN-END:initComponents

    private void jpListadoConsultaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpListadoConsultaKeyReleased
        teclas(evt);
    }//GEN-LAST:event_jpListadoConsultaKeyReleased

    private void jlEliminarMotivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarMotivoMouseClicked
        VistaEliminarMotivo e = new VistaEliminarMotivo(null, true, jpMotivos);
        e.setLocationRelativeTo(null);
        e.setVisible(true);
    }//GEN-LAST:event_jlEliminarMotivoMouseClicked

    private void jlAgregarMotivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAgregarMotivoMouseClicked
        String motivo = JOptionPane.showInternalInputDialog(
                this,
                "Agregue nuevo motivo de consultas",
                "Nuevo motivo",
                JOptionPane.INFORMATION_MESSAGE
        );

        if (motivo == null || motivo.isEmpty() || motivo.equals("null")) {
            return;
        }

        if (agregarMotivo(motivo)) {
            JOptionPane.showInternalMessageDialog(this,
                    "Motivo agregado correctamente");
        } else {
            JOptionPane.showInternalMessageDialog(this,
                    "Error al insertar paciente...");
            return;
        }

        JCheckBox jCheckBox1 = new JCheckBox(motivo);
        jCheckBox1.setName(motivo);
        jpMotivos.remove(jlAgregarMotivo);
        jpMotivos.remove(jlEliminarMotivo);
        jpMotivos.add(jCheckBox1);
        jpMotivos.add(jlAgregarMotivo);
        jpMotivos.add(jlEliminarMotivo);
        jlAgregarMotivo.requestFocus();
        pack();
    }//GEN-LAST:event_jlAgregarMotivoMouseClicked

    private void jtpVisorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtpVisorMouseClicked

        if (jtpVisor.getSelectedIndex() == 6) {

            cbOpcionGrafica.setSelectedIndex(0);
            nuevaGrafica();
            updateGrafica();
        }
        if (jtpVisor.getSelectedIndex() == 5) {

            llenarComboxMedicamentos();
            ordenarTablaReceta();
        }
    }//GEN-LAST:event_jtpVisorMouseClicked

    private void jtpVisorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtpVisorKeyReleased
        teclas(evt);
    }//GEN-LAST:event_jtpVisorKeyReleased

    private void txtHallazgosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHallazgosKeyReleased
        teclas(evt);
    }//GEN-LAST:event_txtHallazgosKeyReleased

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        ResultSet rs = getMotivo();
        jpMotivos.removeAll();
        JCheckBox b;
        try {
            while (rs.next()) {
                b = new JCheckBox(rs.getString("DESCRIPCION"));
                b.setName(rs.getString("IDMCONSULTA"));
                b.setForeground(new Color(255, 255, 255));
                b.setToolTipText(rs.getString("DEFENICION"));
                b.addMouseListener(new MouseAdapter() {
                    final int defaultDismissTimeout = ToolTipManager.sharedInstance().getDismissDelay();
                    final int dismissDelayMinutes = (int) TimeUnit.MINUTES.toMillis(2); // 10 minutes

                    @Override
                    public void mouseEntered(MouseEvent me) {
                        ToolTipManager.sharedInstance().setDismissDelay(dismissDelayMinutes);
                    }

                    @Override
                    public void mouseExited(MouseEvent me) {
                        ToolTipManager.sharedInstance().setDismissDelay(defaultDismissTimeout);
                    }
                });
                b.setEnabled(false);
                jpMotivos.add(b);
            }

            jlAgregarMotivo.setEnabled(false);
            jlEliminarMotivo.setEnabled(false);

            jpMotivos.add(jlAgregarMotivo);
            jpMotivos.add(jlEliminarMotivo);
            jScrollPane1.getViewport().revalidate();
            //pack();
        } catch (SQLException ex) {
            //Instalar Logger
        }

//        llenarTabla(
//                Utilidades.formatDate(dcConsulta.getDate(), ""),
//                "gestion.VistaConsultas.formInternalFrameOpened()"
//        );

    }//GEN-LAST:event_formInternalFrameOpened

    private void jtPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPacientesMouseClicked
        if (evt.getClickCount() == 2 & jtPacientes.isEnabled()) {
            registro = jtPacientes.getSelectedRow();
            String nombre = ((Categoria) jtPacientes.getValueAt(registro, 1)).getDescripcion();
            String apellidos = ((Categoria) jtPacientes.getValueAt(registro, 2)).getDescripcion();

            int r = JOptionPane.showInternalConfirmDialog(this,
                    "Desea abrir la consulta de " + nombre
                    + " "
                    + apellidos,
                    "Validacion de proceso",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (r == JOptionPane.NO_OPTION) {
                return;
            }
            jtpVisor.setSelectedIndex(1);

            txtNombres.setText(nombre);
            txtApellidos.setText(apellidos);
            txtArs.setText(jtPacientes.getValueAt(registro, 3).toString());
            txtNoArs.setText(jtPacientes.getValueAt(registro, 4).toString());

            habilitarConsulta(true, false);

            idPaciente = ((Paciente) jtPacientes.getValueAt(registro, 1)).getId();

//            getDetalleMotivo(
//                    ((Paciente) jtPacientes.getValueAt(registro, 2)).getId(),
//                    (Integer) jtPacientes.getValueAt(registro, 0)
//            );
//
//            ((JCheckBox) jpMotivos.getComponents()[rs.getInt(1)]).setSelected(true);

            jpMotivo.validate();
            jpMotivo.revalidate();
            jpMotivo.updateUI();
            jtPacientes.setEnabled(false);
        }
    }//GEN-LAST:event_jtPacientesMouseClicked

    private void jmiSeleccionarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSeleccionarTodoActionPerformed
        txtEnfermedades.selectAll();
    }//GEN-LAST:event_jmiSeleccionarTodoActionPerformed

    private void jmiCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCopiarActionPerformed
        txtEnfermedades.copy();
    }//GEN-LAST:event_jmiCopiarActionPerformed

    private void jmiCortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCortarActionPerformed
        txtEnfermedades.cut();
    }//GEN-LAST:event_jmiCortarActionPerformed

    private void jmiPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPegarActionPerformed
        txtEnfermedades.paste();
    }//GEN-LAST:event_jmiPegarActionPerformed

    private void jmiCambiarFuenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCambiarFuenteActionPerformed
        VistaFuentes f = new VistaFuentes(null, true, txtEnfermedades.getFont(),
                txtEnfermedades.getForeground());
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        if (f.getFuente() != null) {
            txtEnfermedades.setFont(f.getFuente());
            txtEnfermedades.setForeground(f.getColor());
        }
    }//GEN-LAST:event_jmiCambiarFuenteActionPerformed

    private void jmiCambiarFondoEnfermedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCambiarFondoEnfermedadesActionPerformed
        VistaFondo f = new VistaFondo(null, true);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }//GEN-LAST:event_jmiCambiarFondoEnfermedadesActionPerformed

    private void jmiSeleccionarTodo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSeleccionarTodo1ActionPerformed
        txtHallazgos.selectAll();
    }//GEN-LAST:event_jmiSeleccionarTodo1ActionPerformed

    private void jmiCopiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCopiar1ActionPerformed
        txtHallazgos.copy();
    }//GEN-LAST:event_jmiCopiar1ActionPerformed

    private void jmiCortar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCortar1ActionPerformed
        txtHallazgos.cut();
    }//GEN-LAST:event_jmiCortar1ActionPerformed

    private void jmiPegar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPegar1ActionPerformed
        txtHallazgos.paste();
    }//GEN-LAST:event_jmiPegar1ActionPerformed

    private void jmiCambiarFuente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCambiarFuente1ActionPerformed
        VistaFuentes f = new VistaFuentes(null, true, txtHallazgos.getFont(),
                txtHallazgos.getForeground());
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        if (f.getFuente() != null) {
            txtHallazgos.setFont(f.getFuente());
            txtHallazgos.setForeground(f.getColor());
        }
    }//GEN-LAST:event_jmiCambiarFuente1ActionPerformed

    private void jmiCambiarFondoHAllazgosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCambiarFondoHAllazgosActionPerformed
        VistaFondo f = new VistaFondo(null, true);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }//GEN-LAST:event_jmiCambiarFondoHAllazgosActionPerformed

    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased
        teclas(evt);
    }//GEN-LAST:event_txtIDKeyReleased

    private void txtTxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTxKeyReleased
        teclas(evt);
    }//GEN-LAST:event_txtTxKeyReleased

    private void txtComplementoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComplementoKeyReleased
        teclas(evt);
    }//GEN-LAST:event_txtComplementoKeyReleased

    private void txtReferimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReferimientoKeyReleased
        teclas(evt);
    }//GEN-LAST:event_txtReferimientoKeyReleased

    private void btnTerminarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarConsultaActionPerformed
//        int r = JOptionPane.showInternalConfirmDialog(this,
//                "Desea Terminar la consulta?",
//                "Proceso de validacion",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE);
//        if (r == JOptionPane.NO_OPTION) {
//            return;
//        }
//
//        Integer turno = (Integer) jtPacientes.getValueAt(registro, 0);
//        Integer idConsulta = ((Categorias) jtPacientes.getValueAt(registro, 2)).getId();
//
//        BigDecimal peso = new BigDecimal(jsPeso.getValue().toString());
//        BigDecimal estatura = new BigDecimal(jsLongitud.getValue().toString());
//        BigDecimal cefalo = new BigDecimal(jsPCefalico.getValue().toString());
//
//        if (peso.compareTo(BigDecimal.ZERO) <= 0.0
//                || estatura.compareTo(BigDecimal.ZERO) <= 0.0
//                || cefalo.compareTo(BigDecimal.ZERO) <= 0.0) {
//            JOptionPane.showInternalMessageDialog(this,
//                    "Metricas no estan completa Peso: " + peso + " Estatura: "
//                    + estatura + " Cefalo: " + cefalo);
//            return;
//        }
//
//        for (Component component : jpMotivos.getComponents()) {
//
//            if (((JCheckBox) component).isSelected()) {
//                M_D_MotivoConsulta.agregarDetallleConsulta(
//                        D_Motivo_Consulta
//                                .builder()
//                                .id_consulta(-1)
//                                .id_motivo_consulta(0)
//                                .build()
//                );
//            } else {
//                //TODO 13/12/2024 Faltan los atributos aqui.
//                M_Motivo_Consulta.borrarMotivoConsulta(
//                        Motivo_Consulta
//                                .builder()
//                                .build()
//                );
//            }
//        }
//
//        if (jcbIncluirReceta.isSelected()) {
//            int idReceta = agregarReceta(idPaciente, idConsulta);
//            for (int i = 0; i < tblReceta.getRowCount(); i++) {
//                agregarRecetaDetalle(new D_Recetas(
//                        idReceta,
//                        i + 1,
//                        ((Categorias) tblReceta.getValueAt(i, 1)).getId(),
//                        new BigDecimal(tblReceta.getValueAt(i, 3).toString()),
//                        tblReceta.getValueAt(i, 2).toString()
//                ));
//            }
//
//            //el nombre que se dio al parametro en JasperReport fue "p1", y se debe llamar desde Java con
//            //ese mismo nombre, a su lado se pasa el valor del parametro
//            Map<String, Object> parametros = new HashMap<>();
//            
//            parametros.put(
//                    "idReceta", 
//                    idReceta
//            );
//
//            File i = new File("n2careReceta.jasper");
//
//            new hiloImpresionFactura(
//                    true,
//                    false,
//                    i.getAbsolutePath(),
//                    parametros,
//                    VistaPrincipal.jpEstado,
//                    VistaPrincipal.jpbEstado).start();
//
//        }
//
//        M_Metrica.insert(
//                Metrica
//                        .builder()
//                        .consulta(
//                                Consulta
//                                        .builder()
//                                        .id(idConsulta)
//                                        .build()
//                        )
//                        .pesoKG(peso)
//                        .estaturaM(estatura)
//                        .escefalo(cefalo)
//                        .enf_detect(txtEnfermedades.getText())
//                        .hallazgosPositivo(txtHallazgos.getText())
//                        .idDiagnostico(txtID.getText())
//                        .tx(txtTx.getText())
//                        .complemento(txtComplemento.getText())
//                        .build()
//        );
//
//        habilitarConsulta(false, true);
//        jtPacientes.setEnabled(true);
//        jtpVisor.setSelectedIndex(0);
    }//GEN-LAST:event_btnTerminarConsultaActionPerformed

    private void cbOpcionGraficaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbOpcionGraficaItemStateChanged
//        if (!isShowing()) {
//            return;
//        }
//        if (evt.getStateChange() == 1) {
//
//            nuevaGrafica();
//            switch (cbOpcionGrafica.getSelectedIndex()) {
//                case 1:
//                    PCefalicoChicoChica q = new PCefalicoChicoChica(idPaciente, 0);
//                    jpGrafica.add(q.createDemoPanel());
//                    break;
//                case 2:
//                    PesoParaEdadChicoChica p = new PesoParaEdadChicoChica(idPaciente, 0);
//                    jpGrafica.add(p.createDemoPanel());
//                    break;
//                case 3:
//                    LongitudAlturaParaEdadNino0a5anno l
//                            = new LongitudAlturaParaEdadNino0a5anno(idPaciente, 0);
//                    jpGrafica.add(l.createDemoPanel());
//                    break;
//                case 4:
//                    PesoParaLongitud u
//                            = new PesoParaLongitud(idPaciente, 0);
//                    jpGrafica.add(u.createDemoPanel());
//                    break;
//                case 5:
//                    PesoParaEstatura r
//                            = new PesoParaEstatura(idPaciente, 0);
//                    jpGrafica.add(r.createDemoPanel());
//                    break;
//            }
//            updateGrafica();
//        }
    }//GEN-LAST:event_cbOpcionGraficaItemStateChanged

    private void jcbOpcionesVigilanciaDesarrolloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbOpcionesVigilanciaDesarrolloActionPerformed

        switch (jcbOpcionesVigilanciaDesarrollo.getSelectedIndex()) {
            case 1 -> {
                dcVigilanciaDesarrollo.setVisible(false);
                btnAplicarFecha.setVisible(false);
                llenarTablaGuia(idPaciente);
            }
            case 2 -> {
                dcVigilanciaDesarrollo.setVisible(true);
                dcVigilanciaDesarrollo.setDate(new Date());
                btnAplicarFecha.setVisible(true);
                llenarTablaGuia2(idPaciente);
            }
            default -> {
                dcVigilanciaDesarrollo.setVisible(false);
                jtGuiaVigilanciaDesarrollo.removeAll();
                String titulos[] = {""};
                DefaultTableModel miTabla = new DefaultTableModel(null, titulos);
                jtGuiaVigilanciaDesarrollo.setModel(miTabla);
                btnAplicarFecha.setVisible(false);
            }
        }
    }//GEN-LAST:event_jcbOpcionesVigilanciaDesarrolloActionPerformed

    private void btnAplicarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarFechaActionPerformed
        if (jtGuiaVigilanciaDesarrollo.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe seleccionar un registro", "Validacion de proceso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int resp = JOptionPane.showConfirmDialog(this,
                "Desea aplicar control de vigilancia para la fecha: "
                + Utilidades.formatDate(dcVigilanciaDesarrollo.getDate(), ""),
                "Validacion de fecha para la vigilancia de paciente",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

//        JOptionPane.showInternalMessageDialog(
//                this,
//                agregarGuiaVigilancia(((Categorias) jtGuiaVigilanciaDesarrollo.getValueAt(jtGuiaVigilanciaDesarrollo.getSelectedRow(), 0)).getId(),
//                        idPaciente));
        jcbOpcionesVigilanciaDesarrolloActionPerformed(null);
    }//GEN-LAST:event_btnAplicarFechaActionPerformed

    private void btnMensajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMensajesActionPerformed
        var w = new SwingWorker<>() {
            @Override
            protected Object doInBackground() throws Exception {
                VistaMensajes m = new VistaMensajes();
                VistaPrincipal.dpnEscritorio.remove(m);
                VistaPrincipal.dpnEscritorio.add(m);

                m.setMaximum(true);
                m.setVisible(true);
                return null;
            }
        };
        w.execute();
    }//GEN-LAST:event_btnMensajesActionPerformed

    private void jcbIncluirRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbIncluirRecetaActionPerformed
        if (!isShowing()) {
            return;
        }
        if (jcbIncluirReceta.isSelected()) {
            jcbMedicamentos.setEnabled(true);
            txtFiltroMedicamentos.setEnabled(true);
            tblReceta.setEnabled(true);
            btnAgregarMedicamento.setEnabled(true);
            txtFiltroMedicamentos.requestFocus();
        } else {
            jcbMedicamentos.setEnabled(false);
            txtFiltroMedicamentos.setEnabled(false);
            tblReceta.setEnabled(false);
            btnAgregarMedicamento.setEnabled(false);
        }
    }//GEN-LAST:event_jcbIncluirRecetaActionPerformed

    private void txtFiltroMedicamentosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroMedicamentosKeyReleased
//        for (int i = 0; i < jcbMedicamentos.getItemCount(); i++) {
//            if (((Categorias) jcbMedicamentos.getItemAt(i)).getDescripcion().
//                    startsWith(txtFiltroMedicamentos.getText())) {
//                jcbMedicamentos.setSelectedIndex(i);
//                break;
//            }
//        }
    }//GEN-LAST:event_txtFiltroMedicamentosKeyReleased

    private void txtFiltroMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroMedicamentosActionPerformed

//        if (jcbMedicamentos.getSelectedIndex() == 0) {
//            JOptionPane.showMessageDialog(this, "Debe seleccionar un Medicamento");
//            return;
//        }
//
//        Float cantidad = null;
//        String usoDosis = null;
//        int linea = tblReceta.getRowCount() + 1;
//
//        String producto = ((Medicamento) jcbMedicamentos.getSelectedItem()).getDescripcion();
//
//        int idProducto = ((Medicamento) jcbMedicamentos.getSelectedItem()).getId();
//
//        reg = new Object[4];
//
//        do {
//            try {
//                if (cantidad == null) {
//                    cantidad = Float.parseFloat(JOptionPane.showInternalInputDialog(this,
//                            "Ingrese la cantidad del medicamento",
//                            "Proceso de validación de medicamento",
//                            JOptionPane.QUESTION_MESSAGE));
//                }
//                break;
//            } catch (Exception e) {
//
//                if (e.getMessage() == null) {
//                    jcbMedicamentos.setSelectedIndex(0);
//                    txtFiltroMedicamentos.requestFocus();
//
//                    return;
//                }
//            }
//        } while (true);
//
//        if (cantidad == null) {
//            jcbMedicamentos.setSelectedIndex(0);
//            txtFiltroMedicamentos.setText("");
//            return;
//        }
//
//        do {
//            try {
//                if (usoDosis == null) {
//                    usoDosis = JOptionPane.showInternalInputDialog(this,
//                            "Ingrese ahora la docis o uso del este medicamento.",
//                            "Proceso de validación de medicamento",
//                            JOptionPane.INFORMATION_MESSAGE);
//                }
//                break;
//            } catch (Exception e) {
//
//                if (e.getMessage() == null) {
//                    jcbMedicamentos.setSelectedIndex(0);
//                    txtFiltroMedicamentos.requestFocus();
//                    return;
//                }
//            }
//        } while (true);
//
//        if (usoDosis == null) {
//            jcbMedicamentos.setSelectedIndex(0);
//            txtFiltroMedicamentos.setText("");
//            return;
//        }
//
//        new Categorias(idProducto, producto);
//        reg[0] = linea;
//        reg[1] = Categorias.builder().build();
//        reg[2] = usoDosis;
//        reg[3] = cantidad;
//
//        miTablaMedicamento.addRow(reg);
//        tblReceta.setModel(miTablaMedicamento);
//        ordenarTablaReceta();
//        jcbMedicamentos.setSelectedIndex(0);
//        txtFiltroMedicamentos.setText("");
//        txtFiltroMedicamentos.requestFocus();
    }//GEN-LAST:event_txtFiltroMedicamentosActionPerformed

    private void btnAgregarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMedicamentoActionPerformed
        txtFiltroMedicamentosActionPerformed(null);
    }//GEN-LAST:event_btnAgregarMedicamentoActionPerformed

    private void jcbMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMedicamentosActionPerformed
        if (!isShowing()) {
            return;
        }
        if (jcbIncluirReceta.isSelected()) {
            txtFiltroMedicamentos.requestFocus();
        }
    }//GEN-LAST:event_jcbMedicamentosActionPerformed
    private void updateGrafica() {

        jpGrafica.validate();
        jpGrafica.revalidate();
        jpGrafica.updateUI();

        jspPadre.validate();
        jspPadre.revalidate();
        jspPadre.updateUI();

        jpTipoGrafica.validate();
        jpTipoGrafica.revalidate();
        jpTipoGrafica.updateUI();
    }

    private void nuevaGrafica() {

        jpGrafica.removeAll();
        jpGrafica.setLayout(new java.awt.BorderLayout());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarMedicamento;
    private javax.swing.JButton btnAplicarFecha;
    private javax.swing.JButton btnMensajes;
    private javax.swing.JButton btnTerminarConsulta;
    private javax.swing.JComboBox<Doctor> cbDoctores;
    private javax.swing.JComboBox<String> cbOpcionGrafica;
    private com.toedter.calendar.JDateChooser dcConsulta;
    private com.toedter.calendar.JDateChooser dcReferimiento;
    private com.toedter.calendar.JDateChooser dcVigilanciaDesarrollo;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JCheckBox jcbIncluirReceta;
    private javax.swing.JComboBox<Medicamento> jcbMedicamentos;
    private javax.swing.JComboBox<String> jcbOpcionesVigilanciaDesarrollo;
    private javax.swing.JLabel jlAgregarMotivo;
    private javax.swing.JLabel jlEliminarMotivo;
    private javax.swing.JMenuItem jmiCambiarFondoEnfermedades;
    private javax.swing.JMenuItem jmiCambiarFondoHAllazgos;
    private javax.swing.JMenuItem jmiCambiarFuente;
    private javax.swing.JMenuItem jmiCambiarFuente1;
    private javax.swing.JMenuItem jmiCopiar;
    private javax.swing.JMenuItem jmiCopiar1;
    private javax.swing.JMenuItem jmiCortar;
    private javax.swing.JMenuItem jmiCortar1;
    private javax.swing.JMenuItem jmiPegar;
    private javax.swing.JMenuItem jmiPegar1;
    private javax.swing.JMenuItem jmiSeleccionarTodo;
    private javax.swing.JMenuItem jmiSeleccionarTodo1;
    private static javax.swing.JPanel jpDetenciones;
    private static javax.swing.JPanel jpEnfermedades;
    private static javax.swing.JPanel jpEnfermedades1;
    private static javax.swing.JPanel jpEnfermedades2;
    private static javax.swing.JPanel jpEnfermedades3;
    private static javax.swing.JPanel jpEnfermedades4;
    private javax.swing.JPanel jpGrafica;
    private static javax.swing.JPanel jpHallazgosPositivos;
    private static javax.swing.JPanel jpListadoConsulta;
    private javax.swing.JPanel jpMetricas;
    private javax.swing.JPanel jpMetricasGraficas;
    private javax.swing.JPanel jpMotivo;
    private javax.swing.JPanel jpMotivos;
    private javax.swing.JPanel jpTipoGrafica;
    private javax.swing.JPopupMenu jpmEnfermedades;
    private javax.swing.JPopupMenu jpmHallazgosPositivos;
    private javax.swing.JSpinner jsEstatura;
    private javax.swing.JSpinner jsLongitud;
    private javax.swing.JSpinner jsPCefalico;
    private javax.swing.JSpinner jsPeso;
    private static javax.swing.JScrollPane jspEnfermedades;
    private static javax.swing.JScrollPane jspEnfermedades1;
    private static javax.swing.JScrollPane jspEnfermedades2;
    private static javax.swing.JScrollPane jspEnfermedades3;
    private static javax.swing.JScrollPane jspEnfermedades4;
    private static javax.swing.JScrollPane jspHallazgosPositivos;
    private javax.swing.JScrollPane jspPadre;
    private javax.swing.JTable jtGuiaVigilanciaDesarrollo;
    private javax.swing.JTable jtPacientes;
    private static javax.swing.JTabbedPane jtpVisor;
    private javax.swing.JTable tblReceta;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtArs;
    private static javax.swing.JTextArea txtComplemento;
    private static javax.swing.JTextArea txtEnfermedades;
    private javax.swing.JTextField txtFiltroMedicamentos;
    private static javax.swing.JTextArea txtHallazgos;
    private static javax.swing.JTextArea txtID;
    private javax.swing.JTextField txtNoArs;
    private javax.swing.JTextField txtNombres;
    private static javax.swing.JTextArea txtReferimiento;
    private static javax.swing.JTextArea txtTx;
    // End of variables declaration//GEN-END:variables

    private void teclas(KeyEvent evt) {
        switch (evt.getExtendedKeyCode()) {
            case KeyEvent.VK_F1 -> jtpVisor.setSelectedIndex(0);
            case KeyEvent.VK_F2 -> jtpVisor.setSelectedIndex(1);
            case KeyEvent.VK_F3 -> jtpVisor.setSelectedIndex(2);
            case KeyEvent.VK_F4 -> jtpVisor.setSelectedIndex(3);
            case KeyEvent.VK_F5 -> jtpVisor.setSelectedIndex(4);
            default -> {
            }
        }
    }

    public synchronized void llenarTabla(Date fecha, String d) {

//        jtPacientes.removeAll();
//
//        String titulos[] = {
//            "<html><b>Turno</b></html>",
//            "<html><b>Nombre Completo</b></html>",
//            "<html><b>Ars</b></html>",
//            "<html><b>Noº Ars</b></html>"
//        };
//
//        DefaultTableModel miTabla = new DefaultTableModel(null, titulos);
//
//        Object fila[] = new Object[titulos.length];
//
//        List<Consulta> listaConsulta = M_Consulta.getConsulta(Utilidades.javaDateToSqlDate(fecha));
//
//        listaConsulta.stream().forEach(
//                dato -> {
//                    fila[0] = dato;
//                    fila[1] = dato.getPaciente();
//                    fila[2] = dato.getPaciente().getArs();
//                    fila[3] = dato.getPaciente().getAsegurado();
//                    miTabla.addRow(fila);
//                }
//        );
//
//        jtPacientes.setModel(miTabla);
    }

    public synchronized void llenarTablaGuia(int idPaciente) {
//        jtGuiaVigilanciaDesarrollo.removeAll();
//        String titulos[] = {"Edad", "Caracteristica del desarrollo a evualar",
//            "Marque la eventualidad"};
//        Object reg1[] = new Object[3];
//        rs = getGuiaDesarrollo(idPaciente, true);
//
//        DefaultTableModel miTabla = new DefaultTableModel(null, titulos) {
//            Class[] types = new Class[]{
//                Object.class, Object.class, Boolean.class
//            };
//
//            @Override
//            public Class getColumnClass(int columnIndex) {
//                return types[columnIndex];
//            }
//        };
//
//        try {
//            while (rs.next()) {
//                reg1[0] = new Categorias(rs.getInt("ID_GVD"), rs.getString("EDAD"));
//                reg1[1] = rs.getString("CARACT_DESARR_EVALUAR");
//                reg1[2] = rs.getBoolean("resultado");
//                miTabla.addRow(reg1);
//            }
//            jtGuiaVigilanciaDesarrollo.setModel(miTabla);
//            miTabla.addTableModelListener((TableModelEvent e) -> {
//                if (e.getType() == TableModelEvent.UPDATE) {
//                    if (e.getColumn() == 2) {
//                        agregarGuiaVigilancia(((Categorias) jtGuiaVigilanciaDesarrollo.getValueAt(
//                                jtGuiaVigilanciaDesarrollo.getSelectedRow(), 0)).getId(),
//                                idPaciente);
////                        , (Boolean) jtGuiaVigilanciaDesarrollo.getValueAt(
////                                        jtGuiaVigilanciaDesarrollo.getSelectedRow(), 2)
//                    }
//                }
//            });
//        } catch (SQLException ex) {
//            //Instalar Logger
//        }
//        ordenarTabla();
    }

    public synchronized void llenarTablaGuia2(int idPaciente) {
//        jtGuiaVigilanciaDesarrollo.removeAll();
//        String titulos[] = {"Edad", "Caracteristica del desarrollo a evualar",
//            "Registro de fecha"};
//        
//        Object reg2[] = new Object[titulos.length];
//        
//        //TODO 13/12/2024 Esta lista me parece que no es la que corresponde 
//        //con la tabla.
//        List<GuiaVigilanciaDesarrollo> lista = M_Guia_Vigilancia_Desarrollo.select(
//                FiltroBusqueda
//                        .builder()
//                        .id(idPaciente)
//                        .estado(false)
//                        .build()
//        );
//
//        DefaultTableModel miTabla = new DefaultTableModel(null, titulos);
////        {
////            @Override
////            Class<?>[] types = new Class<>[]{
////                Object.class, Object.class, String.class
////            };
////
////            @Override
////            public Class<?>[] getColumnClass(int columnIndex) {
////                return types[columnIndex];
////            }
////        };
//
//        while (rs.next()) {
//            reg2[0] = new Categorias(rs.getInt("ID_GVD"), rs.getString("EDAD"));
//            reg2[1] = rs.getString("CARACT_DESARR_EVALUAR");
//            reg2[2] = rs.getString("resultado");
//            miTabla.addRow(reg2);
//        }
//        jtGuiaVigilanciaDesarrollo.setModel(miTabla);
//        ordenarTabla();
    }

//    private synchronized void ordenarTabla() {
//        jtGuiaVigilanciaDesarrollo.getColumn(jtGuiaVigilanciaDesarrollo.getColumnName(0)).setMinWidth(50);
//        jtGuiaVigilanciaDesarrollo.getColumn(jtGuiaVigilanciaDesarrollo.getColumnName(0)).setMaxWidth(50);
//        jtGuiaVigilanciaDesarrollo.getColumn(jtGuiaVigilanciaDesarrollo.getColumnName(0)).setPreferredWidth(50);
//
//        jtGuiaVigilanciaDesarrollo.getColumn(jtGuiaVigilanciaDesarrollo.getColumnName(2)).setMinWidth(170);
//        jtGuiaVigilanciaDesarrollo.getColumn(jtGuiaVigilanciaDesarrollo.getColumnName(2)).setMaxWidth(170);
//        jtGuiaVigilanciaDesarrollo.getColumn(jtGuiaVigilanciaDesarrollo.getColumnName(2)).setPreferredWidth(170);
//    }

    private synchronized void ordenarTablaReceta() {
        tblReceta.getColumn(tblReceta.getColumnName(0)).setMinWidth(90);
        tblReceta.getColumn(tblReceta.getColumnName(0)).setMaxWidth(90);
        tblReceta.getColumn(tblReceta.getColumnName(0)).setPreferredWidth(90);

        tblReceta.getColumn(tblReceta.getColumnName(3)).setMinWidth(90);
        tblReceta.getColumn(tblReceta.getColumnName(3)).setMaxWidth(90);
        tblReceta.getColumn(tblReceta.getColumnName(3)).setPreferredWidth(90);
    }

    private synchronized void habilitarConsulta(boolean b, boolean l) {
        if (l) {
            txtNombres.setText("");
            txtApellidos.setText("");
            txtArs.setText("");
            txtNoArs.setText("");
        }
        for (Component component : jpMotivos.getComponents()) {
            try {
                ((JCheckBox) component).setSelected(false);
                ((JCheckBox) component).setEnabled(b);
            } catch (java.lang.ClassCastException e) {
            }
        }

        txtEnfermedades.setText("");
        txtEnfermedades.setEnabled(b);

        txtHallazgos.setText("");
        txtHallazgos.setEnabled(b);

        //Habilitar o deshabilitar spinnners.
        jsPeso.setModel(
                new javax.swing.SpinnerNumberModel(
                        Float.valueOf(13.3f),
                        Float.valueOf(2.0f),
                        Float.valueOf(29.0f),
                        Float.valueOf(1.0f))
        );
        jsPeso.setEnabled(b);

        jsLongitud.setModel(
                new javax.swing.SpinnerNumberModel(
                        Float.valueOf(92.0f),
                        Float.valueOf(43.0f),
                        Float.valueOf(125.0f),
                        Float.valueOf(1.0f))
        );
        jsLongitud.setEnabled(b);

        jsEstatura.setModel(
                new javax.swing.SpinnerNumberModel(
                        Float.valueOf(92.0f),
                        Float.valueOf(43.0f),
                        Float.valueOf(125.0f),
                        Float.valueOf(1.0f))
        );
        jsEstatura.setEnabled(true);

        jsPCefalico.setModel(
                new javax.swing.SpinnerNumberModel(
                        Float.valueOf(47.4f),
                        Float.valueOf(30.0f),
                        Float.valueOf(54.0f),
                        Float.valueOf(1.0f))
        );
        jsPCefalico.setEnabled(b);//Fin de habilitar spinners

        txtID.setEnabled(b);
        txtID.setText("");

        txtTx.setEnabled(b);
        txtTx.setText("");

        txtComplemento.setEnabled(b);
        txtComplemento.setText("");

        txtReferimiento.setEnabled(b);
        txtReferimiento.setText("");

        cbDoctores.setEnabled(b);
        dcReferimiento.setEnabled(b);

        btnTerminarConsulta.setEnabled(b);

        jtGuiaVigilanciaDesarrollo.setEnabled(b);
        jtGuiaVigilanciaDesarrollo.setVisible(b);

        jcbOpcionesVigilanciaDesarrollo.setEnabled(b);
        jcbOpcionesVigilanciaDesarrollo.setSelectedIndex(0);

        cbOpcionGrafica.setSelectedIndex(0);
        cbOpcionGrafica.setEnabled(b);

        dcReferimiento.setEnabled(b);
        dcReferimiento.setDate(new Date());

        jcbIncluirReceta.setEnabled(b);

        jcbMedicamentos.setEnabled(false);
        jcbMedicamentos.setSelectedIndex(0);

        btnAgregarMedicamento.setEnabled(false);

        txtFiltroMedicamentos.setEnabled(false);

        nuevaTabla();
    }

    private synchronized void llenarComboxDoctores(boolean actual) {
//
//        getFechaDoctores(
//                Utilidades.formatDate(
//                        dcReferimiento.getDate(),
//                        ""
//                ),
//                actual
//        );
//
//        cbDoctores.removeAllItems();
//
//        cbDoctores.addItem(
//                Usuario
//                        .builder()
//                        .id_persona(0)
//                        .pnombre("N/A")
//                        .apellidos("Seleccione un doctor")
//                        .build()
//        );
        
//                "<html><b>" + rs.getString("nombreCompleto").trim() + "</b> <br> "
//                + frmHorario.dia(rs.getString("DIA")) + ": Hora: "
//                + rs.getString("INICIAL").substring(0, 5) + " hasta "
//                + rs.getString("FINAL").substring(0, 5) + "</html>"
//                
//                rs.getString("nombreCompleto").trim()
//                + " \nDia: " + frmHorario.dia(rs.getString("DIA")) + " "
//                + Utilidades.formatDate(dcReferimiento.getDate(), "dd/MM/yyyy")
//                + " \nHora: " + rs.getString("INICIAL").substring(0, 5)
//                + " hasta "
//                + rs.getString("FINAL").substring(0, 5), 0) 
//                
//                
//
//                Usuario.Builder.id(rs.getInt("ID")).build();
//                
//                
//                
//                u.setUserName(rs.getString("loginName").trim());
//                        
//                cbDoctores.addItem(u);
//                
    }

    /**
     * Metodo para rellenar la lista de productos de medicamentos del sistema.
     *
     * Actualizado el Lunes 30 de enero 2023.
     */
    private synchronized void llenarComboxMedicamentos() {
//        List<Medicamento> medicamentosList = getMedicamentoActivo();
//
//        jcbMedicamentos.removeAllItems();
//
//        jcbMedicamentos.addItem(
//                Medicamento
//                        .builder()
//                        .id(-1)
//                        .descripcion("Seleccione un medicamento.")
//                        .build()
//        );
//
//        medicamentosList.stream().forEach(
//                medicamento -> {
//                    jcbMedicamentos.addItem(
//                            Medicamento
//                                    .builder()
//                                    .id(medicamento.getId())
//                                    .descripcion(
//                                            medicamento.getDescripcion()
//                                    )
//                                    .build()
//                    );
//                }
//        );
    }

    private void nuevaTabla() {
        String titulosMedicamentos[] = {
            "<html><b>Linea</b></html>",
            "<html><b>Descripción</b></html>",
            "<html><b>Uso o Docis</b></html>",
            "<html><b>Cantidad</b></html>"
        };

        miTablaMedicamento = new DefaultTableModel(null, titulosMedicamentos);

        tblReceta.setModel(miTablaMedicamento);
    }
}