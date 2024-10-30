package sur.softsurena.gestion;

import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.control.frmHorario;
import sur.softsurena.entidades.Categoria;
import sur.softsurena.entidades.Usuario;
import static sur.softsurena.formularios.frmPrincipal.dpnEscritorio;
import sur.softsurena.hilos.hiloImpresionFactura;
import sur.softsurena.utilidades.Utilidades;

public class frmGestionConsultas extends javax.swing.JInternalFrame {

    private static frmGestionConsultas citas;

    public frmGestionConsultas() {
        
        initComponents();

        txtCosto.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(() -> {
                    txtCosto.setValue(0.0);
                    txtCosto.setSelectionStart(3);
                    txtCosto.setSelectionEnd(txtCosto.getText().length());
                });
            }
        });
        dcConsulta.setDate(new Date());
        btnReporte.setVisible(false);
        jPanel6.setVisible(false);
        jPanel7.setVisible(false);
    }

    public synchronized static frmGestionConsultas getCitas() {
        
        if (citas == null) {
            citas = new frmGestionConsultas();
        }

        return citas;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jtpFormularios = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistrosPacientes = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        btnRegistre = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGestionPacientes = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        cbAprobadoRechazado = new javax.swing.JCheckBox();
        btnReporte = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        txtCosto = new javax.swing.JFormattedTextField();
        btnVerificarCita = new javax.swing.JButton();
        txtCovertura = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCodigoVerificacion = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        cbReporteSexo = new javax.swing.JComboBox<>();
        btnReporteSexo = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        txtReporteCedula = new javax.swing.JFormattedTextField();
        btnReporteIdPaciente = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        cbReporteSeguro1 = new javax.swing.JComboBox();
        btnReporteAceptadoRechado = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        btnReporteSeguros = new javax.swing.JButton();
        cbReporteSeguro = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        btnIrHoy = new javax.swing.JButton();
        dchFecha = new com.toedter.calendar.JDateChooser();
        jlTurnoProximo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtNombreApellidosSeguro = new javax.swing.JTextField();
        btnLimpiarCampo = new javax.swing.JButton();
        rbCedula = new javax.swing.JRadioButton();
        rbNombre = new javax.swing.JRadioButton();
        rbApellidos = new javax.swing.JRadioButton();
        rbSeguro = new javax.swing.JRadioButton();
        jPanel14 = new javax.swing.JPanel();
        dcConsulta = new com.toedter.calendar.JDateChooser();
        cbFechaUsuario = new javax.swing.JComboBox();
        btnActualizarFechaUsuarios = new javax.swing.JButton();

        setBackground(new java.awt.Color(49, 163, 217));
        setClosable(true);
        setIconifiable(true);
        setTitle("Administrador de consultas de pacientes");
        setMaximumSize(new java.awt.Dimension(816, 646));
        setMinimumSize(new java.awt.Dimension(816, 646));
        setPreferredSize(new java.awt.Dimension(816, 646));
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

        jtpFormularios.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jtpFormulariosStateChanged(evt);
            }
        });
        jtpFormularios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtpFormulariosKeyReleased(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(624, 300));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Pacientes"));

        tblRegistrosPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblRegistrosPacientes.setToolTipText("Doble click para  seleccionar  paciente...");
        tblRegistrosPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegistrosPacientesMouseClicked(evt);
            }
        });
        tblRegistrosPacientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblRegistrosPacientesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblRegistrosPacientes);

        btnRegistre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Aceptar 32 x 32.png"))); // NOI18N
        btnRegistre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistreActionPerformed(evt);
            }
        });
        btnRegistre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnRegistreKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRegistre, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnRegistre)
                .addGap(0, 0, 0))
        );

        jtpFormularios.addTab("Registro de Consultas F1", new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-recordatorios-de-citas-32.png")), jPanel1); // NOI18N

        jPanel2.setPreferredSize(new java.awt.Dimension(624, 300));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de consulta"));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(1, 1, 1))); // NOI18N

        tblGestionPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblGestionPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGestionPacientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGestionPacientes);

        cbAprobadoRechazado.setText("Aprobados");
        cbAprobadoRechazado.setActionCommand("");
        cbAprobadoRechazado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAprobadoRechazadoActionPerformed(evt);
            }
        });

        btnReporte.setText("Imprimir Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(btnReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbAprobadoRechazado))
            .addComponent(jScrollPane2)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAprobadoRechazado)
                    .addComponent(btnReporte))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Evaluacion de la consulta"));

        txtCosto.setEditable(false);
        txtCosto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00;-¤#,##0.00"))));
        txtCosto.setSelectionEnd(txtCosto.getText().length());
        txtCosto.setSelectionStart(3);
        txtCosto.setValue(0.00);

        btnVerificarCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Aceptar 32 x 32.png"))); // NOI18N
        btnVerificarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarCitaActionPerformed(evt);
            }
        });

        txtCovertura.setEditable(false);
        txtCovertura.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##,##%"))));
        txtCovertura.setValue(0.00);

        jLabel5.setText("Covertura");

        jLabel4.setText("Costo");

        jLabel1.setText("Codigo de autorización");

        txtTotal.setEditable(false);
        txtTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtTotal.setValue(0.00);

        jLabel6.setText("Total");

        txtCodigoVerificacion.setEditable(false);
        try {
            txtCodigoVerificacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**********")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCodigoVerificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoVerificacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCosto)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCovertura)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTotal)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoVerificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(btnVerificarCita))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, txtCodigoVerificacion});

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel6, txtTotal});

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel5, txtCovertura});

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, txtCosto});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtCodigoVerificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCovertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(btnVerificarCita)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jtpFormularios.addTab("Gestion Cobro Citas F2", new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-boleta-de-calificaciones-32.png")), jPanel2); // NOI18N

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Criterios individuales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Generar reporte por sexo"));

        cbReporteSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione sexo", "Ambos", "Masculino", "Femenino" }));

        btnReporteSexo.setText("Generar");
        btnReporteSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteSexoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(cbReporteSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporteSexo)
                .addGap(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbReporteSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporteSexo))
                .addGap(0, 0, 0))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Generar reporte por paciente"));

        try {
            txtReporteCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtReporteCedula.setText("");
        txtReporteCedula.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        txtReporteCedula.setMinimumSize(new java.awt.Dimension(110, 27));
        txtReporteCedula.setPreferredSize(new java.awt.Dimension(133, 27));

        btnReporteIdPaciente.setText("Generar");
        btnReporteIdPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteIdPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtReporteCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporteIdPaciente))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReporteCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporteIdPaciente))
                .addGap(1, 1, 1))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultas Aprobadas o no"));

        cbReporteSeguro1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una opcion", "Ambas", "Consulta Aaprobadas", "Consulta Rechazadas" }));

        btnReporteAceptadoRechado.setText("Generar");
        btnReporteAceptadoRechado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteAceptadoRechadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(cbReporteSeguro1, 0, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporteAceptadoRechado))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReporteAceptadoRechado)
                    .addComponent(cbReporteSeguro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Generar reporte por seguros"));

        btnReporteSeguros.setText("Generar");
        btnReporteSeguros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteSegurosActionPerformed(evt);
            }
        });

        cbReporteSeguro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione seguro" }));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(cbReporteSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporteSeguros, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbReporteSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporteSeguros))
                .addGap(0, 0, 0))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Reporte por fecha"));

        btnIrHoy.setText("Ir Hoy");
        btnIrHoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrHoyActionPerformed(evt);
            }
        });

        dchFecha.setBackground(new java.awt.Color(49, 163, 217));
        dchFecha.setOpaque(false);
        dchFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dchFechaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(dchFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIrHoy)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnIrHoy)
                    .addComponent(dchFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 528, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jtpFormularios.addTab("tab3", jPanel6);

        jlTurnoProximo.setBackground(new java.awt.Color(49, 163, 217));
        jlTurnoProximo.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jlTurnoProximo.setForeground(new java.awt.Color(254, 254, 254));
        jlTurnoProximo.setText(" ");
        jlTurnoProximo.setOpaque(true);

        jPanel3.setBackground(new java.awt.Color(49, 163, 217));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros de Busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18), new java.awt.Color(254, 254, 254))); // NOI18N

        txtNombreApellidosSeguro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreApellidosSeguroFocusGained(evt);
            }
        });
        txtNombreApellidosSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreApellidosSeguroActionPerformed(evt);
            }
        });
        txtNombreApellidosSeguro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreApellidosSeguroKeyReleased(evt);
            }
        });

        btnLimpiarCampo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-símbolo-vaciar-32.png"))); // NOI18N
        btnLimpiarCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCampoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbCedula);
        rbCedula.setSelected(true);
        rbCedula.setText("Cedula");
        rbCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCedulaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbNombre);
        rbNombre.setText("Nombres");
        rbNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNombreActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbApellidos);
        rbApellidos.setText("Apellidos");
        rbApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbApellidosActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbSeguro);
        rbSeguro.setText("no. Seguro");
        rbSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSeguroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txtNombreApellidosSeguro)
                .addGap(0, 0, 0)
                .addComponent(btnLimpiarCampo))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(rbSeguro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbApellidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbCedula))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnLimpiarCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreApellidosSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCedula)
                    .addComponent(rbNombre)
                    .addComponent(rbApellidos)
                    .addComponent(rbSeguro)))
        );

        jPanel14.setBackground(new java.awt.Color(49, 163, 217));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18), new java.awt.Color(254, 254, 254))); // NOI18N

        cbFechaUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFechaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFechaUsuarioActionPerformed(evt);
            }
        });
        cbFechaUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbFechaUsuarioKeyReleased(evt);
            }
        });

        btnActualizarFechaUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-update-32.png"))); // NOI18N
        btnActualizarFechaUsuarios.setToolTipText("Actaulizar la lista de  Doctores Disponible en este mes.");
        btnActualizarFechaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarFechaUsuariosActionPerformed(evt);
            }
        });
        btnActualizarFechaUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnActualizarFechaUsuariosKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(dcConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cbFechaUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnActualizarFechaUsuarios)
                .addGap(0, 0, 0))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbFechaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarFechaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnActualizarFechaUsuarios, cbFechaUsuario, dcConsulta});

        dcConsulta.getDateEditor().addPropertyChangeListener(
            new PropertyChangeListener(){
                public void propertyChange(PropertyChangeEvent e) {
                    //Aquí agregaremos la funcionalidad que queremos
                    //por ejemplo al seleccionar una fecha le mostrare un diálogo con la fecha de hoy
                    if(isShowing() & e.getPropertyName().equals("date")){
                        llenarComboxUsuarios();
                        turno();
                    }
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jtpFormularios)
                .addComponent(jlTurnoProximo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jlTurnoProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jtpFormularios)
                    .addGap(0, 0, 0))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents
    /**
     * Al abrir gestion consultas llenamos los comboBox del modulo y las tablas.
     *
     * @see llenarCombox();
     */
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        
//        
        btnActualizarFechaUsuarios.doClick();
        
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                
//            }
//        });
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnActualizarFechaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarFechaUsuariosActionPerformed
        llenarComboxUsuarios();

        turno();
    }//GEN-LAST:event_btnActualizarFechaUsuariosActionPerformed

    private void jtpFormulariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtpFormulariosKeyReleased
        switch (evt.getExtendedKeyCode()) {
            case KeyEvent.VK_F1:
                jtpFormularios.setSelectedIndex(0);
                break;
            case KeyEvent.VK_F2:
                jtpFormularios.setSelectedIndex(1);
                break;
            case KeyEvent.VK_F3:
                jtpFormularios.setSelectedIndex(2);
                break;
        }
        //jtpFormulariosMouseClicked(null);
    }//GEN-LAST:event_jtpFormulariosKeyReleased

    private void btnReporteSegurosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteSegurosActionPerformed
        
//        if (dchFecha.getDate() == null) {
//            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fecha.");
//            dchFecha.requestFocusInWindow();
//            btnFecha.doClick();
//            return;
//        }
    }//GEN-LAST:event_btnReporteSegurosActionPerformed

    private void btnReporteAceptadoRechadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteAceptadoRechadoActionPerformed
        
//        if (dchFecha.getDate() == null) {
//            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fecha.");
//            dchFecha.requestFocusInWindow();
//            btnFecha.doClick();
//            return;
//        }
    }//GEN-LAST:event_btnReporteAceptadoRechadoActionPerformed

    private void btnReporteIdPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteIdPacienteActionPerformed
//        if (dchFecha.getDate() == null) {
//            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fecha.");
//            dchFecha.requestFocusInWindow();
//            btnFecha.doClick();
//            return;
//        }
    }//GEN-LAST:event_btnReporteIdPacienteActionPerformed

    private void btnReporteSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteSexoActionPerformed
//        if (dchFecha.getDate() == null) {
//            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fecha.");
//            dchFecha.requestFocusInWindow();
//            btnFecha.doClick();
//            return;
//        }
    }//GEN-LAST:event_btnReporteSexoActionPerformed

    private void btnVerificarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarCitaActionPerformed
        if (txtCodigoVerificacion.getText().trim().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe digitar el codigo de verificacion.");
            txtCodigoVerificacion.requestFocusInWindow();
            return;
        }

        if (txtNombreApellidosSeguro.getText().trim().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe seleccionar un paciente.");
            txtNombreApellidosSeguro.requestFocusInWindow();
            return;
        }

        int resp = JOptionPane.showInternalConfirmDialog(this,
                "Codigo de Verificación: " + txtCodigoVerificacion.getText()
                + "\n"
                + txtNombreApellidosSeguro.getText()
                + "\nCon el doctor y fecha: "
                + ((Usuario) cbFechaUsuario.getSelectedItem()).getVentana(),
                "Proceso de validacion del sistema...",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        if (!cbAprobadoRechazado.isSelected()) {
            //Los datos los busco de llenarTabla2(...)
            JOptionPane.showInternalMessageDialog(this,
                    agregarConsultaVerificada(new Consultas_aprobadas(
                        ((Categoria) tblGestionPacientes.getValueAt(tblGestionPacientes.getSelectedRow(), 2)).getId(),
                        txtCodigoVerificacion.getText(),
                        new BigDecimal(txtCosto.getValue().toString()),
                        new BigDecimal(txtCovertura.getValue().toString()),
                    null, null)),
                    "Proceso de verificación de consultas",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        btnLimpiarCampoActionPerformed(null);
        llenarTabla2("");
    }//GEN-LAST:event_btnVerificarCitaActionPerformed

    private void cbAprobadoRechazadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAprobadoRechazadoActionPerformed
        
        if (cbAprobadoRechazado.isSelected()) {
            cbAprobadoRechazado.setText("No Aprobado");
            btnVerificarCita.setEnabled(false);
            txtCodigoVerificacion.setEditable(false);
            txtCosto.setEditable(false);
            btnReporte.setVisible(true);
        } else {
            cbAprobadoRechazado.setText("Aprobado");
            btnVerificarCita.setEnabled(true);
            txtCodigoVerificacion.setEditable(true);
            txtCosto.setEditable(true);
            btnReporte.setVisible(false);
        }
        llenarTabla2("");
    }//GEN-LAST:event_cbAprobadoRechazadoActionPerformed

    private void tblGestionPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGestionPacientesMouseClicked
        if (cbAprobadoRechazado.isSelected()
                & tblGestionPacientes.getRowCount() != 0
                & evt.getClickCount() == 2) {

            txtNombreApellidosSeguro.setText("-NOMBRES Y APELLIDOS: "
                    + tblGestionPacientes.getValueAt(tblGestionPacientes.getSelectedRow(), 2)
                    + " "
                    + tblGestionPacientes.getValueAt(tblGestionPacientes.getSelectedRow(), 3)
                    + " Codigo Verificación: " + tblGestionPacientes.getValueAt(tblGestionPacientes.getSelectedRow(), 4));

            txtCosto.setValue(
                    Double.parseDouble(tblGestionPacientes.getValueAt(
                            tblGestionPacientes.getSelectedRow(), 5).toString()));
            txtCovertura.setValue(
                    Double.parseDouble(tblGestionPacientes.getValueAt(
                            tblGestionPacientes.getSelectedRow(), 6).toString()));
            txtTotal.setValue(
                    Double.parseDouble(tblGestionPacientes.getValueAt(
                            tblGestionPacientes.getSelectedRow(), 7).toString()));
            txtCodigoVerificacion.setText(tblGestionPacientes.getValueAt(
                    tblGestionPacientes.getSelectedRow(), 4).toString());
        } else if (!(cbAprobadoRechazado.isSelected())
                & tblGestionPacientes.getRowCount() != 0
                & evt.getClickCount() == 2) {
            txtNombreApellidosSeguro.setText("-NOMBRES Y APELLIDOS: "
                    + (Categoria) tblGestionPacientes.getValueAt(
                            tblGestionPacientes.getSelectedRow(), 2)
                    + " "
                    + (Categoria) tblGestionPacientes.getValueAt(
                            tblGestionPacientes.getSelectedRow(), 3)
                    + " SEGURO: " + tblGestionPacientes.getValueAt(
                            tblGestionPacientes.getSelectedRow(), 5)
                    + " NUMERO: "
                    + (String) tblGestionPacientes.getValueAt(
                            tblGestionPacientes.getSelectedRow(), 6)
            );
            txtCovertura.setValue(((Categoria) tblGestionPacientes.getValueAt(
                            tblGestionPacientes.getSelectedRow(), 5)).getCovertura());
            
            txtCosto.setValue(1000.00d);

            Double covertura = (Double) txtCovertura.getValue();

            Double total = 1000.00d - (1000.00d * (covertura / 100));

            txtTotal.setValue(total);

            txtCodigoVerificacion.requestFocusInWindow();
        }
    }//GEN-LAST:event_tblGestionPacientesMouseClicked

    private void btnRegistreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistreActionPerformed
        
        /*Verificamos que no este vacio, esto garantiza el usuario selecciono 
          un registro, se devuelve si la condicion se cumple. */
        if (txtNombreApellidosSeguro.getText().trim().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un paciente.");
            txtNombreApellidosSeguro.requestFocusInWindow();
            return;
        }

        if (cbFechaUsuario.getSelectedItem() == null) {
            JOptionPane.showInternalMessageDialog(this,
                    "No existe una consulta pre-programada en esta fecha "
                    + Utilidades.formatDate(dcConsulta.getDate(), ""));
            cbFechaUsuario.requestFocusInWindow();
            return;
        }

        int opc = JOptionPane.showInternalConfirmDialog(this,
                "\nPaciente: "
                + tblRegistrosPacientes.getValueAt(tblRegistrosPacientes.getSelectedRow(), 1)
                + " "
                + tblRegistrosPacientes.getValueAt(tblRegistrosPacientes.getSelectedRow(), 2)
                + "\nDoctor: " + ((Usuario) cbFechaUsuario.getSelectedItem()).getVentana(),
                "Verificacion de informacion de Consulta Medica!",
                JOptionPane.YES_NO_OPTION);
        if (opc == JOptionPane.NO_OPTION) {
            return;
        }

        int turno =getTurnoCita(
                ((Usuario) cbFechaUsuario.getSelectedItem()).getIdControlConsulta(),
                Utilidades.formatDate(dcConsulta.getDate(), ""));

        JOptionPane.showInternalMessageDialog(this, agregarConsulta(((Usuario) cbFechaUsuario.getSelectedItem()).getIdControlConsulta(),
                        Utilidades.formatDate(dcConsulta.getDate(), ""),
                        turno,
                        ((Categoria) tblRegistrosPacientes.getValueAt(
                                tblRegistrosPacientes.getSelectedRow(), 0)).getIdCategoria()),
                "Resultado de la operacion",
                JOptionPane.INFORMATION_MESSAGE);

        btnLimpiarCampoActionPerformed(null);
        llenarTabla("");
    }//GEN-LAST:event_btnRegistreActionPerformed

    private void tblRegistrosPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegistrosPacientesMouseClicked
        if (tblRegistrosPacientes.getRowCount() != 0 & evt.getClickCount() == 2) {
            
            txtNombreApellidosSeguro.setText("-NOMBRES Y APELLIDOS: "
                    + tblRegistrosPacientes.getValueAt(tblRegistrosPacientes.getSelectedRow(), 1)
                    + " "
                    + tblRegistrosPacientes.getValueAt(tblRegistrosPacientes.getSelectedRow(), 2)
                    + " SEGURO: " + (String) tblRegistrosPacientes.getValueAt(tblRegistrosPacientes.getSelectedRow(), 4)
                    + " NUMERO: "
                    + (String) tblRegistrosPacientes.getValueAt(tblRegistrosPacientes.getSelectedRow(), 5)
            );
        }
    }//GEN-LAST:event_tblRegistrosPacientesMouseClicked

    private void cbFechaUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbFechaUsuarioKeyReleased
        jtpFormulariosKeyReleased(evt);
    }//GEN-LAST:event_cbFechaUsuarioKeyReleased

    private void btnActualizarFechaUsuariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarFechaUsuariosKeyReleased
        jtpFormulariosKeyReleased(evt);
    }//GEN-LAST:event_btnActualizarFechaUsuariosKeyReleased

    private void tblRegistrosPacientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblRegistrosPacientesKeyReleased
        jtpFormulariosKeyReleased(evt);
    }//GEN-LAST:event_tblRegistrosPacientesKeyReleased

    private void btnRegistreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRegistreKeyReleased
        jtpFormulariosKeyReleased(evt);
    }//GEN-LAST:event_btnRegistreKeyReleased

    private void btnIrHoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrHoyActionPerformed
        dchFecha.setDate(new Date());
    }//GEN-LAST:event_btnIrHoyActionPerformed

    private void dchFechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dchFechaKeyReleased
        jtpFormulariosKeyReleased(evt);
    }//GEN-LAST:event_dchFechaKeyReleased

    private void txtNombreApellidosSeguroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreApellidosSeguroFocusGained
        if (!txtNombreApellidosSeguro.getText().isEmpty()) {
            txtNombreApellidosSeguro.setSelectionStart(0);
            txtNombreApellidosSeguro.setSelectionEnd(
                    txtNombreApellidosSeguro.getText().length());
        }
    }//GEN-LAST:event_txtNombreApellidosSeguroFocusGained

    private void txtNombreApellidosSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreApellidosSeguroActionPerformed
        if (jtpFormularios.getSelectedIndex() == 0) {
            btnRegistre.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtNombreApellidosSeguroActionPerformed

    private void txtNombreApellidosSeguroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreApellidosSeguroKeyReleased
        
        jtpFormulariosKeyReleased(evt);
        switch (jtpFormularios.getSelectedIndex()) {
            case 0:
                llenarTabla(txtNombreApellidosSeguro.getText().trim());
                break;
            case 1:
                llenarTabla2(txtNombreApellidosSeguro.getText().trim());
                break;
            default:
        }
    }//GEN-LAST:event_txtNombreApellidosSeguroKeyReleased

    private void btnLimpiarCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCampoActionPerformed
        txtNombreApellidosSeguro.setText("");
        txtNombreApellidosSeguro.requestFocusInWindow();
        llenarTabla("");
    }//GEN-LAST:event_btnLimpiarCampoActionPerformed

    private void rbSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSeguroActionPerformed
        txtNombreApellidosSeguro.requestFocusInWindow();
    }//GEN-LAST:event_rbSeguroActionPerformed

    private void rbApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbApellidosActionPerformed
        txtNombreApellidosSeguro.requestFocusInWindow();
    }//GEN-LAST:event_rbApellidosActionPerformed

    private void rbNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNombreActionPerformed
        txtNombreApellidosSeguro.requestFocusInWindow();
    }//GEN-LAST:event_rbNombreActionPerformed

    private void rbCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCedulaActionPerformed
        txtNombreApellidosSeguro.requestFocusInWindow();
    }//GEN-LAST:event_rbCedulaActionPerformed

    private void cbFechaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFechaUsuarioActionPerformed
        if (isShowing()) {
            
            turno();
        }
    }//GEN-LAST:event_cbFechaUsuarioActionPerformed

    private void jtpFormulariosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jtpFormulariosStateChanged
        if (isShowing()) {
            
            btnActualizarFechaUsuarios.doClick();
            turno();
        }
    }//GEN-LAST:event_jtpFormulariosStateChanged

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        Map parametros = new HashMap();
        parametros.clear();
        //el nombre que se dio al parametro en JasperReport fue "p1", y se debe llamar desde Java con
        //ese mismo nombre, a su lado se pasa el valor del parametro
        parametros.put("idControlConsulta",
                ((Usuario) cbFechaUsuario.getSelectedItem()).getIdControlConsulta());
        parametros.put("fecha", dcConsulta.getDate());
        File i = new File("n2careReporte.jasper");
        new hiloImpresionFactura(true, false, i.getAbsolutePath(), parametros).start();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void txtCodigoVerificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoVerificacionActionPerformed
        
        btnVerificarCita.requestFocusInWindow();
    }//GEN-LAST:event_txtCodigoVerificacionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarFechaUsuarios;
    private javax.swing.JButton btnIrHoy;
    private javax.swing.JButton btnLimpiarCampo;
    private javax.swing.JButton btnRegistre;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnReporteAceptadoRechado;
    private javax.swing.JButton btnReporteIdPaciente;
    private javax.swing.JButton btnReporteSeguros;
    private javax.swing.JButton btnReporteSexo;
    private javax.swing.JButton btnVerificarCita;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbAprobadoRechazado;
    private javax.swing.JComboBox cbFechaUsuario;
    private javax.swing.JComboBox cbReporteSeguro;
    private javax.swing.JComboBox cbReporteSeguro1;
    private javax.swing.JComboBox<String> cbReporteSexo;
    private com.toedter.calendar.JDateChooser dcConsulta;
    private com.toedter.calendar.JDateChooser dchFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlTurnoProximo;
    private javax.swing.JTabbedPane jtpFormularios;
    private javax.swing.JRadioButton rbApellidos;
    private javax.swing.JRadioButton rbCedula;
    private javax.swing.JRadioButton rbNombre;
    private javax.swing.JRadioButton rbSeguro;
    private javax.swing.JTable tblGestionPacientes;
    private javax.swing.JTable tblRegistrosPacientes;
    private javax.swing.JFormattedTextField txtCodigoVerificacion;
    private javax.swing.JFormattedTextField txtCosto;
    private javax.swing.JFormattedTextField txtCovertura;
    private javax.swing.JTextField txtNombreApellidosSeguro;
    private javax.swing.JFormattedTextField txtReporteCedula;
    private javax.swing.JFormattedTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    public void centralizar() {
        
        setBounds((dpnEscritorio.getWidth() - this.getWidth()) / 2,
                (dpnEscritorio.getHeight() - this.getHeight()) / 2,
                720,
                500);
        pack();
        citas.setVisible(true);
    }

    private synchronized void llenarTabla(String filtro) {
        
        String titulos[] = {
            "<html><b>Paciente</b></html>",
            "<html><b>Nombres</b></html>",
            "<html><b>Apellidos</b></html>",
            "<html><b>Sexo</b></html>",
            "<html><b>Seguro</b></html>",
            "<html><b>Numero Seguro</b></html>"};
        Object registro[] = new Object[6];

        DefaultTableModel miTabla = new DefaultTableModel(null, titulos);
        tblRegistrosPacientes.setModel(miTabla);
        tblRegistrosPacientes.removeAll();

        if (cbFechaUsuario.getItemCount() == 0) {
            return;
        }

        if (rbCedula.isSelected()) {
            filtro = "and a.CEDULAPACIENTE STARTING '" + filtro + "'";
        }
        if (rbNombre.isSelected()) {
            filtro = "and a.nombres STARTING '" + filtro + "'";
        }
        if (rbApellidos.isSelected()) {
            filtro = "and a.apellidos STARTING '" + filtro + "'";
        }
        if (rbSeguro.isSelected()) {
            filtro = "and a.nonss STARTING '" + filtro + "'";
        }

        ResultSet rs = getPacienteActivo(filtro, Utilidades.formatDate(dcConsulta.getDate(), ""),
                ((Usuario) cbFechaUsuario.getSelectedItem()).getIdControlConsulta());
        try {
            while (rs.next()) {
                registro[0] = new Categoria(rs.getInt("IDPACIENTE"),
                        rs.getString("CEDULAPACIENTE").trim());
                registro[1] = rs.getString("NOMBRES").trim();
                registro[2] = rs.getString("APELLIDOS").trim();
                registro[3] = rs.getString("SEXO").trim();
                registro[4] = rs.getString("IDARS").trim();
                registro[5] = rs.getString("NONSS").trim();
                miTabla.addRow(registro);
            }
        } catch (SQLException ex) {
            //Instalar Logger
        }
        tblRegistrosPacientes.setModel(miTabla);
    }

    private synchronized void llenarTabla2(String filtro) {
        
        txtCodigoVerificacion.setText("");
        txtCosto.setValue(0.0);
        txtCovertura.setValue(0.0);

        ResultSet rs = null;
        DefaultTableModel miTabla = null;

        if (!cbAprobadoRechazado.isSelected()) {
            Object registro[] = new Object[7];
            String titulos[] = {
                "<html><b>Turno</b></html>",
                "<html><b>Paciente</b></html>",
                "<html><b>Nombres</b></html>",
                "<html><b>Apellidos</b></html>",
                "<html><b>Sexo</b></html>",
                "<html><b>Seguro</b></html>",
                "<html><b>Numero Seguro</b></html>"
            };
            miTabla = new DefaultTableModel(null, titulos);
            tblGestionPacientes.setModel(miTabla);
            tblGestionPacientes.removeAll();
            if (cbFechaUsuario.getItemCount() == 0) {
                return;
            }
            if (rbCedula.isSelected()) {
                filtro = "and p.CEDULAPACIENTE STARTING '" + filtro + "'";
            }
            if (rbNombre.isSelected()) {
                filtro = "and p.nombres STARTING '" + filtro + "'";
            }
            if (rbApellidos.isSelected()) {
                filtro = "and p.apellidos STARTING '" + filtro + "'";
            }
            if (rbSeguro.isSelected()) {
                filtro = "and p.nonss STARTING '" + filtro + "'";
            }
            rs = getPacienteActivo2(filtro, Utilidades.formatDate(dcConsulta.getDate(), ""),
                    ((Usuario) cbFechaUsuario.getSelectedItem()).getIdControlConsulta());
            try {

                while (rs.next()) {
                    registro[0] = rs.getInt("TURNO");
                    registro[1] = new Categorias(rs.getInt("IDPACIENTE"),
                            rs.getString("CEDULAPACIENTE").trim());
                    registro[2] = new Categorias(rs.getInt("IDCONSULTA"),
                            rs.getString("NOMBRES").trim());
                    registro[3] = new Categorias(rs.getInt("turno"),
                            rs.getString("APELLIDOS").trim());
                    registro[4] = rs.getString("SEXO").trim();
                    registro[5] = new Categorias(rs.getDouble("COVER"),
                            rs.getString("IDARS").trim());
                    registro[6] = rs.getString("NONSS").trim();
                    miTabla.addRow(registro);
                }

            } catch (SQLException ex) {
                //Instalar Logger
            }
        } else {
            Object registro2[] = new Object[8];
            String titulos2[] = {
                "<html><b>Turno</center></b></html>",
                "<html><b>Cedula</center></b></html>",
                "<html><b>Nombres</center></b></html>",
                "<html><b>Apellidos</center></b></html>",
                "<html><b>Autorización</center></b></html>",
                "<html><b>Costo</center></b></html>",
                "<html><b>Descuento</center></b></html>",
                "<html><b>Total de Costo</center></b></html>"};
            miTabla = new DefaultTableModel(null, titulos2);
            tblGestionPacientes.setModel(miTabla);
            tblGestionPacientes.removeAll();
            if (cbFechaUsuario.getItemCount() == 0) {
                return;
            }
            rs = getPacienteActivo3(filtro, Utilidades.formatDate(dcConsulta.getDate(), ""),
                    ((Usuario) cbFechaUsuario.getSelectedItem()).getIdControlConsulta());
            try {
                while (rs.next()) {
                    registro2[0] = rs.getInt("TURNO");
                    registro2[1] = rs.getString("CEDULAPACIENTE").trim();
                    registro2[2] = rs.getString("NOMBRES").trim();
                    registro2[3] = rs.getString("APELLIDOS").trim();
                    registro2[4] = rs.getString("COD_AUTORIZACION").trim();
                    registro2[5] = rs.getDouble("COSTO");
                    registro2[6] = rs.getDouble("DESCUENTO");
                    registro2[7] = rs.getDouble("TOTALCOSTO");
                    miTabla.addRow(registro2);
                }
            } catch (SQLException ex) {
                //Instalar Logger
            }
        }
        tblGestionPacientes.setModel(miTabla);
    }

    private synchronized void llenarComboxSeguro() {
        
        ResultSet obj = getTipoSeguro();
        cbReporteSeguro.removeAllItems();
        try {
            while (obj.next()) {
                cbReporteSeguro.addItem(new Categorias(obj.getShort("IDARS"),
                        obj.getString("DESCRIPCION").trim(), "Seguro"));
            }
        } catch (SQLException ex) {
            //Instalar Logger
        }
    }

    private synchronized void llenarComboxUsuarios() {
        boolean actual = true;

        if (jtpFormularios.getSelectedIndex() == 1) {
            actual = false;
        }

        ResultSet rs = getFechaDoctores(Utilidades.formatDate(dcConsulta.getDate(), ""), actual);
        cbFechaUsuario.removeAllItems();
        try {
            while (rs.next()) {
                cbFechaUsuario.addItem(
                        new Doctor(
                                rs.getInt("IDCONTROLCONSULTA"),
                                rs.getString("loginName").trim(),
                                "<html> <b>" + rs.getString("nombreCompleto").trim() + "</b> <br> " + 
                                        frmHorario.dia(rs.getString("DIA")) + ":"+
                                        " Hora: " + rs.getString("INICIAL").substring(0, 5) + 
                                        " hasta "+ rs.getString("FINAL").substring(0, 5) + 
                                "</html>",
                                rs.getString("nombreCompleto").trim() + 
                                        " \nDia: " + frmHorario.dia(rs.getString("DIA")) + " "
                        + Utilidades.formatDate(dcConsulta.getDate(), "dd/MM/yyyy")
                        + " \nHora: " + rs.getString("INICIAL").substring(0, 5)
                        + " hasta " + rs.getString("FINAL").substring(0, 5),
                        rs.getInt("CANTIDAD_PACIENTE")));
            }
            rs.close();
        } catch (SQLException ex) {
            //Instalar Logger
        }
    }

    private synchronized void turno() {
        
        switch (jtpFormularios.getSelectedIndex()) {
            case 0:
                Object obj = cbFechaUsuario.getSelectedItem();
                int cantPaciente = 0,
                 cantMaxima = 1;

                if (obj != null) {
                    cantPaciente = getTurnoCita(((Usuario) obj).getIdControlConsulta(),
                            Utilidades.formatDate(dcConsulta.getDate(), ""));
                    cantMaxima = ((Usuario) obj).getCantidad();
                }

                String valor;

                if (cantPaciente < cantMaxima) {
                    valor = cantPaciente + " de " + cantMaxima;
                } else {
                    valor = "No disponible";
                }
                jlTurnoProximo.setText("Proximo turno " + (obj == null ? 0 : valor));
                llenarTabla("");
                break;
            case 1:
                llenarTabla2("");
                jlTurnoProximo.setText(" ");
                break;
            case 2:
                llenarComboxSeguro();
                jlTurnoProximo.setText(" ");
                break;
            default:
        }
    }
}
