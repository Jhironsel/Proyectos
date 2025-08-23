package sur.softsurena.vistas;

import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sur.softsurena.abstractas.Persona;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.entidades.Deuda;
import sur.softsurena.entidades.Generales;
import sur.softsurena.entidades.Paginas;
import sur.softsurena.hilos.HiloImpresionFactura;
import sur.softsurena.metodos.M_Deuda;
import sur.softsurena.metodos.M_Generales;
import sur.softsurena.metodos.M_Persona;
import sur.softsurena.utilidades.DefaultTableCellHeaderRenderer;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 * TODO 29/11/2024 buscar la foto del cliente o deudor.
 *
 * @author jhironsel
 */
public final class VistaDeudas extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    private static boolean nuevo;
    private static Deuda deudaField;

    public VistaDeudas() {
        initComponents();
        jtpPrincipal.remove(jpRegistroDeuda);
        jtpPrincipal.remove(jpPagosDeuda);

        txtMonto.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(() -> {
                    txtMonto.setSelectionStart(3);
                    txtMonto.setSelectionEnd(
                            txtMonto.getText().length()
                    );
                });
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtCedula1 = new javax.swing.JFormattedTextField();
        jtpPrincipal = new javax.swing.JTabbedPane();
        jpListaDeuda = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonas = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jsPaginas = new javax.swing.JSpinner();
        jsRegistros = new javax.swing.JSpinner();
        jpRegistroDeuda = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtCedula = new javax.swing.JFormattedTextField();
        txtPNombre = new javax.swing.JTextField();
        txtSNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtMonto = new javax.swing.JFormattedTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtConcepto = new javax.swing.JTextArea();
        jlFoto = new javax.swing.JLabel();
        btnGetCliente = new javax.swing.JButton();
        jpPagosDeuda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDeudasPagas = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        jLabel2 = new javax.swing.JLabel();
        txtCedula2 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPNombre1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellidos1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMonto1 = new javax.swing.JFormattedTextField();
        txtMontoPagado = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdDeuda = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSNombre1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBuscar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();
        rSMenuBar1 = new rojerusan.RSMenuBar();
        jmFiltros = new javax.swing.JMenu();
        cbTodos = new javax.swing.JCheckBoxMenuItem();
        cbInicial = new javax.swing.JCheckBoxMenuItem();
        cbAbonada = new javax.swing.JCheckBoxMenuItem();
        cbPagada = new javax.swing.JCheckBoxMenuItem();
        cbNula = new javax.swing.JCheckBoxMenuItem();
        jmOpcionesPagos = new javax.swing.JMenu();
        jmiPagos = new javax.swing.JMenuItem();

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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Control de la deudas del negocio");
        setToolTipText("");
        setMaximumSize(new java.awt.Dimension(3000, 3000));
        setMinimumSize(new java.awt.Dimension(42, 42));
        setPreferredSize(new java.awt.Dimension(800, 600));
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

        jtpPrincipal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 255)));

        jpListaDeuda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de Deuda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N

        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class<?>[] types = new Class<?>[] {
                M_Deuda.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class<?> getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPersonas);

        jsPaginas.setToolTipText("");
        jsPaginas.setBorder(null);

        jsRegistros.setToolTipText("Cantidad de registros");
        jsRegistros.setBorder(null);

        javax.swing.GroupLayout jpListaDeudaLayout = new javax.swing.GroupLayout(jpListaDeuda);
        jpListaDeuda.setLayout(jpListaDeudaLayout);
        jpListaDeudaLayout.setHorizontalGroup(
            jpListaDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListaDeudaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpListaDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpListaDeudaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jsRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpListaDeudaLayout.setVerticalGroup(
            jpListaDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpListaDeudaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpListaDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsPaginas)
                    .addComponent(jsRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpPrincipal.addTab("Listado", jpListaDeuda);

        jpRegistroDeuda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Registro / Actualizacion ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        txtCedula.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), " Cedula ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 255))); // NOI18N
        try {
            txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula.setActionCommand("");
        txtCedula.setFont(new java.awt.Font("Ubuntu Mono", 1, 16)); // NOI18N
        txtCedula.setPreferredSize(new java.awt.Dimension(52, 21));
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

        txtPNombre.setEditable(false);
        txtPNombre.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtPNombre.setActionCommand("<Not Set>");
        txtPNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), " Primer Nombre ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 255))); // NOI18N
        txtPNombre.setDoubleBuffered(true);
        txtPNombre.setFocusTraversalPolicyProvider(true);
        txtPNombre.setPreferredSize(new java.awt.Dimension(52, 21));
        txtPNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPNombreActionPerformed(evt);
            }
        });
        txtPNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPNombreKeyReleased(evt);
            }
        });

        txtSNombre.setEditable(false);
        txtSNombre.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtSNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), " Segundo Nombre ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 255))); // NOI18N
        txtSNombre.setDoubleBuffered(true);
        txtSNombre.setFocusTraversalPolicyProvider(true);
        txtSNombre.setPreferredSize(new java.awt.Dimension(52, 21));
        txtSNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSNombreActionPerformed(evt);
            }
        });

        txtApellidos.setEditable(false);
        txtApellidos.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtApellidos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellidos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), " Apellidos ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 255))); // NOI18N
        txtApellidos.setDoubleBuffered(true);
        txtApellidos.setFocusTraversalPolicyProvider(true);
        txtApellidos.setPreferredSize(new java.awt.Dimension(52, 21));
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidosKeyReleased(evt);
            }
        });

        txtMonto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), " Monto ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 255))); // NOI18N
        txtMonto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtMonto.setToolTipText("Indique el limite de credito del Cliente");
        txtMonto.setDoubleBuffered(true);
        txtMonto.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtMonto.setFocusTraversalPolicyProvider(true);
        txtMonto.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtMonto.setPreferredSize(new java.awt.Dimension(52, 21));
        txtMonto.setValue(0);
        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });

        txtConcepto.setColumns(20);
        txtConcepto.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtConcepto.setLineWrap(true);
        txtConcepto.setToolTipText("Inserte el concepto de la deuda...");
        txtConcepto.setWrapStyleWord(true);
        txtConcepto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), " Concepto ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 255))); // NOI18N
        txtConcepto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConceptoKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(txtConcepto);

        jlFoto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), " Foto ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        btnGetCliente.setText("Clientes");
        btnGetCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));
        btnGetCliente.setEnabled(false);
        btnGetCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGetCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGetCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jlFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpRegistroDeudaLayout = new javax.swing.GroupLayout(jpRegistroDeuda);
        jpRegistroDeuda.setLayout(jpRegistroDeudaLayout);
        jpRegistroDeudaLayout.setHorizontalGroup(
            jpRegistroDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistroDeudaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpRegistroDeudaLayout.setVerticalGroup(
            jpRegistroDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistroDeudaLayout.createSequentialGroup()
                .addGap(0, 47, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Registro de Deuda", jpRegistroDeuda);

        jLabel1.setFont(new java.awt.Font("Ubuntu Light", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pagos del Deudor");
        jLabel1.setToolTipText("");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de Pagos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 14))); // NOI18N

        tblDeudasPagas.setFont(new java.awt.Font("Ubuntu Light", 0, 14)); // NOI18N
        tblDeudasPagas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo Pago", "Fecha", "Hora", "Monto Pago"
            }
        ));
        tblDeudasPagas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblDeudasPagas);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cedula:");
        jLabel2.setFocusable(false);
        jLabel2.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel2.setRequestFocusEnabled(false);
        jLabel2.setVerifyInputWhenFocusTarget(false);

        txtCedula2.setEditable(false);
        try {
            txtCedula2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula2.setToolTipText("Cedula del Cliente");
        txtCedula2.setDoubleBuffered(true);
        txtCedula2.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtCedula2.setFocusTraversalPolicyProvider(true);
        txtCedula2.setFont(new java.awt.Font("Ubuntu Mono", 1, 16)); // NOI18N
        txtCedula2.setPreferredSize(new java.awt.Dimension(52, 21));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Deuda#:");
        jLabel3.setFocusable(false);
        jLabel3.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel3.setRequestFocusEnabled(false);
        jLabel3.setVerifyInputWhenFocusTarget(false);

        txtPNombre1.setEditable(false);
        txtPNombre1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtPNombre1.setDoubleBuffered(true);
        txtPNombre1.setFocusTraversalPolicyProvider(true);
        txtPNombre1.setPreferredSize(new java.awt.Dimension(52, 21));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Apellidos:");
        jLabel4.setFocusable(false);
        jLabel4.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel4.setRequestFocusEnabled(false);
        jLabel4.setVerifyInputWhenFocusTarget(false);

        txtApellidos1.setEditable(false);
        txtApellidos1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtApellidos1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellidos1.setDoubleBuffered(true);
        txtApellidos1.setFocusTraversalPolicyProvider(true);
        txtApellidos1.setPreferredSize(new java.awt.Dimension(52, 21));

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Monto:");
        jLabel11.setFocusable(false);
        jLabel11.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel11.setRequestFocusEnabled(false);
        jLabel11.setVerifyInputWhenFocusTarget(false);

        txtMonto1.setEditable(false);
        txtMonto1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        txtMonto1.setToolTipText("Indique el limite de credito del Cliente");
        txtMonto1.setDoubleBuffered(true);
        txtMonto1.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtMonto1.setFocusTraversalPolicyProvider(true);
        txtMonto1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtMonto1.setPreferredSize(new java.awt.Dimension(52, 21));
        txtMonto1.setValue(0);

        txtMontoPagado.setEditable(false);
        txtMontoPagado.setForeground(new java.awt.Color(0, 0, 255));
        txtMontoPagado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        txtMontoPagado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMontoPagado.setToolTipText("Indique el limite de credito del Cliente");
        txtMontoPagado.setDoubleBuffered(true);
        txtMontoPagado.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtMontoPagado.setFocusTraversalPolicyProvider(true);
        txtMontoPagado.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtMontoPagado.setPreferredSize(new java.awt.Dimension(52, 21));
        txtMontoPagado.setValue(0);

        jLabel12.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Monto Pagado:");
        jLabel12.setFocusable(false);
        jLabel12.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel12.setRequestFocusEnabled(false);
        jLabel12.setVerifyInputWhenFocusTarget(false);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nombres:");
        jLabel5.setFocusable(false);
        jLabel5.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel5.setRequestFocusEnabled(false);
        jLabel5.setVerifyInputWhenFocusTarget(false);

        txtIdDeuda.setEditable(false);
        txtIdDeuda.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtIdDeuda.setDoubleBuffered(true);
        txtIdDeuda.setFocusTraversalPolicyProvider(true);
        txtIdDeuda.setPreferredSize(new java.awt.Dimension(52, 21));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nombres:");
        jLabel6.setFocusable(false);
        jLabel6.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel6.setRequestFocusEnabled(false);
        jLabel6.setVerifyInputWhenFocusTarget(false);

        txtSNombre1.setEditable(false);
        txtSNombre1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtSNombre1.setDoubleBuffered(true);
        txtSNombre1.setFocusTraversalPolicyProvider(true);
        txtSNombre1.setPreferredSize(new java.awt.Dimension(52, 21));

        javax.swing.GroupLayout jpPagosDeudaLayout = new javax.swing.GroupLayout(jpPagosDeuda);
        jpPagosDeuda.setLayout(jpPagosDeudaLayout);
        jpPagosDeudaLayout.setHorizontalGroup(
            jpPagosDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPagosDeudaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPagosDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
                    .addGroup(jpPagosDeudaLayout.createSequentialGroup()
                        .addGroup(jpPagosDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jpPagosDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtApellidos1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPNombre1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpPagosDeudaLayout.createSequentialGroup()
                                .addComponent(txtCedula2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPagosDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpPagosDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPagosDeudaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpPagosDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMonto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtIdDeuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jpPagosDeudaLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtSNombre1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jpPagosDeudaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMontoPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpPagosDeudaLayout.setVerticalGroup(
            jpPagosDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPagosDeudaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addGroup(jpPagosDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedula2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPagosDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jpPagosDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMonto1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPagosDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMontoPagado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jtpPrincipal.addTab("Pagos del Deudor", jpPagosDeuda);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 255)), "Botones de Acción"));
        jPanel2.setMaximumSize(new java.awt.Dimension(787, 81));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));

        jPanel6.setLayout(new java.awt.GridLayout(1, 5, 4, 5));

        btnNuevo.setText("Nuevo");
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel6.add(btnNuevo);

        btnModificar.setText("Modificar");
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel6.add(btnModificar);

        btnBorrar.setText("Borrar");
        btnBorrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel6.add(btnBorrar);

        btnBuscar.setText("Buscar");
        btnBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FIND_IN_PAGE);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel6.add(btnBuscar);

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel6.add(btnGuardar);

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel6.add(btnCancelar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        rSMenuBar1.setBorderPainted(false);
        rSMenuBar1.setPreferredSize(new java.awt.Dimension(0, 30));

        jmFiltros.setForeground(new java.awt.Color(255, 255, 255));
        jmFiltros.setText("Filtros");

        cbTodos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        buttonGroup1.add(cbTodos);
        cbTodos.setSelected(true);
        cbTodos.setText("Todos");
        cbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTodosActionPerformed(evt);
            }
        });
        jmFiltros.add(cbTodos);

        cbInicial.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        buttonGroup1.add(cbInicial);
        cbInicial.setText("Iniciadas");
        cbInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInicialActionPerformed(evt);
            }
        });
        jmFiltros.add(cbInicial);

        cbAbonada.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        buttonGroup1.add(cbAbonada);
        cbAbonada.setText("Abonadas");
        cbAbonada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAbonadaActionPerformed(evt);
            }
        });
        jmFiltros.add(cbAbonada);

        cbPagada.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        buttonGroup1.add(cbPagada);
        cbPagada.setText("Pagadas");
        cbPagada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPagadaActionPerformed(evt);
            }
        });
        jmFiltros.add(cbPagada);

        cbNula.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        buttonGroup1.add(cbNula);
        cbNula.setText("Nulas");
        cbNula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNulaActionPerformed(evt);
            }
        });
        jmFiltros.add(cbNula);

        rSMenuBar1.add(jmFiltros);

        jmOpcionesPagos.setForeground(new java.awt.Color(255, 255, 255));
        jmOpcionesPagos.setText("Opciones de pagos");
        jmOpcionesPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmOpcionesPagosActionPerformed(evt);
            }
        });

        jmiPagos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiPagos.setText("Pagos");
        jmiPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPagosActionPerformed(evt);
            }
        });
        jmOpcionesPagos.add(jmiPagos);

        rSMenuBar1.add(jmOpcionesPagos);

        setJMenuBar(rSMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtpPrincipal))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtpPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        if (!txtCedula.isEditValid()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Inserte una cedula Valida, Ej: 000-0000000-0",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            limpiarCampos();
            return;
        }
        
        Generales general = M_Generales.select(
                Generales
                        .builder()
                        .cedula(txtCedula.getText())
                        .build()
        ).getFirst();

        if (general.getIdPersona().equals(0)) {
            var resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                    Cedula no encontrada en el sistema.
                    Desea registrarla?
                    """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (resp == JOptionPane.NO_OPTION) {
                return;
            }

            VistaPrincipalFacturacion.mnuMantenimientoClientes.doClick();
        } else {
            mostrarRegistro(
                    M_Persona.select(
                            Cliente
                                    .builder()
                                    .idPersona(general.getIdPersona())
                                    .build()
                    ).getFirst()
            );
        }

    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtPNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPNombreActionPerformed

    }//GEN-LAST:event_txtPNombreActionPerformed

    private void txtPNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPNombreKeyReleased
        txtPNombre.setText(txtPNombre.getText().toUpperCase());
    }//GEN-LAST:event_txtPNombreKeyReleased

    private void txtConceptoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConceptoKeyReleased
        txtConcepto.setText(txtConcepto.getText().toUpperCase());
    }//GEN-LAST:event_txtConceptoKeyReleased

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed

        try {
            txtMonto.commitEdit();
        } catch (ParseException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }

        if (txtMontoField().compareTo(BigDecimal.ZERO) <= 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Solo valores mayores que cero.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        txtConcepto.requestFocus();
    }//GEN-LAST:event_txtMontoActionPerformed

    private void btnGetClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetClienteActionPerformed
        System.out.println(evt.getActionCommand());
        VistaBusquedaPersona miBusqueda = new VistaBusquedaPersona(
                null, true, new String[]{"Clientes"}
        );
        miBusqueda.setLocationRelativeTo(null);
        miBusqueda.setVisible(true);

        if (Objects.isNull(miBusqueda.getPersona())) {
            limpiarCampos();
            return;
        }

        mostrarRegistro(miBusqueda.getPersona());
    }//GEN-LAST:event_btnGetClienteActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        llenarTabla(Deuda.builder().build());
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo = true;

        jtpPrincipal.addTab("Registro de Deuda", jpRegistroDeuda);
        jtpPrincipal.setSelectedComponent(jpRegistroDeuda);

        botones(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //Debe existir registros en la tabla de clientes.
        if (validarTablaPersonas()) {
            return;
        }

        //Columna cedula seleccionada.
        mostrarRegistro(
                (Persona) tblPersonas.getValueAt(
                        tblPersonas.getSelectedRow(),
                        1
                )
        );
        nuevo = false;
        botones(true);
        txtMonto.requestFocus();
    }//GEN-LAST:event_btnModificarActionPerformed

    /**
     * TODO 28/11/2024 probar los metodos de la clase de prueba.
     *
     * @param evt
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (jtpPrincipal.getSelectedComponent().equals(jpRegistroDeuda)) {
            if (txtCedula.getText().trim().isBlank()) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Debe digitar una cedula del Cliente...",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                limpiarCampos();
                return;
            }

            try {
                txtMonto.commitEdit();
            } catch (ParseException ex) {
                LOG.log(
                        Level.SEVERE,
                        ex.getMessage(),
                        ex
                );
                return;
            }

            if (txtMontoField().compareTo(BigDecimal.ZERO) <= 0) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Ingrese una cantidad mayor que cero",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                txtMonto.setValue(0);
                txtMonto.requestFocus();
                return;
            }

            if (txtConcepto.getText().isEmpty()) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Debe ingresar un concepto detallado de la deuda",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                txtConcepto.requestFocus();
                return;
            }

            if (txtConcepto.getText().length() < 20 || txtConcepto.getText().length() > 199) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Ingrese concepto de un minimo "
                        + "de 20 caracteres y un Maximo 200, Caracteres actuales de:"
                        + " " + txtConcepto.getText().length(),
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                txtConcepto.requestFocus();
                return;
            }

            //Creamos el Objeto Cliente y los agregamos a Datos
            var _idPersona = ((Generales) txtCedula.getValue()).getIdPersona();
            Deuda miDeuda = Deuda
                    .builder()
                    .id(nuevo ? null : deudaField.getId())
                    .idPersona(_idPersona)
                    .concepto(txtConcepto.getText())
                    .monto(txtMontoField())
                    .build();

//                new VistaDeudas(idCliente, getIdUsuario(),
//                txtConcepto.getText(), monto);
            String accion = "editar";
            if (nuevo) {
                accion = "inserta";
            }

            Persona persona = M_Persona.select(
                    Cliente
                            .builder()
                            .idPersona(_idPersona)
                            .build()
            ).getFirst();

            Generales generales = M_Generales.select(
                    Generales
                            .builder()
                            .idPersona(_idPersona)
                            .build()
            ).getFirst();

            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                <html>
                    <b><big>Se va a %s deuda a: </big></b> <big> %s </big><br/>
                    <b><big>Cedula no.: </big></b> <big> %s </big><br/>
                    <b><big>Monto de deuda es: </big></b><big>%s</big><br/>
                    <b><big>Por Concepto de: </big></b><big>%s</big><br/>
                    <big>De fecha : </big></b><big>%s</big><br/>
                    <b><big>Desea continuar? </big></b>
                </html>
                """.formatted(
                            accion,
                            persona.toString(),
                            generales.toString(),
                            txtMonto.getText(),
                            txtConcepto.getText(),
                            Utilidades.formatDate(new Date(), "dd.MM.yyyy")
                    ),
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (resp == JOptionPane.NO_OPTION) {
                return;
            }

            Resultado resultado;

            if (nuevo) {
                resultado = M_Deuda.insert(miDeuda);
            } else {
                resultado = M_Deuda.update(miDeuda);
            }

            JOptionPane.showInternalMessageDialog(
                    this,
                    resultado.getMensaje(),
                    "",
                    resultado.getIcono()
            );

        }

        if (jtpPrincipal.getSelectedComponent().equals(jpPagosDeuda)) {
            if (tblDeudasPagas.getRowCount() == 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "No existen pagos",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            Map<String, Object> parametros = new HashMap<>();
            parametros.put("idFactura", 1);

            HiloImpresionFactura miHilo = new HiloImpresionFactura(
                    true, //Mostrar Reporte
                    false, //Con Copia
                    new File("/Reportes/DetalleDeuda.jasper").getAbsolutePath(),
                    parametros,
                    VistaPrincipalFacturacion.jPanelImpresion,
                    VistaPrincipalFacturacion.jprImpresion
            );
            miHilo.start();
        }
        btnCancelarActionPerformed(evt);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        botones(false);
        jtpPrincipal.setSelectedComponent(jpListaDeuda);
        jtpPrincipal.remove(jpRegistroDeuda);
        jtpPrincipal.remove(jpPagosDeuda);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (validarTablaPersonas()) {
            return;
        }

        String idDeuda = tblPersonas.getValueAt(
                tblPersonas.getSelectedRow(),
                0
        ).toString();

        int rta = JOptionPane.showInternalConfirmDialog(
                this,
                "¿Esta Seguro de Eliminar Deuda #" + idDeuda,
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (rta == JOptionPane.NO_OPTION) {
            return;
        }

        M_Deuda.delete(
                (Deuda) tblPersonas.getValueAt(tblPersonas.getSelectedRow(), 0)
        );
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (validarTablaPersonas()) {
            return;
        }

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

        jsPaginas.setValue(1);

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

        llenarTabla(
                Deuda
                        .builder()
                        .idPersona(generales.getIdPersona())
                        .build()
        );
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyReleased
        txtApellidos.setText(txtApellidos.getText().toUpperCase());
    }//GEN-LAST:event_txtApellidosKeyReleased

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        txtMonto.requestFocus();
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtSNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSNombreActionPerformed
        txtApellidos.requestFocus();
    }//GEN-LAST:event_txtSNombreActionPerformed

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
                        Utilidades.validarCampo(txtCedula);
                    }
                }
            }
        }
    }//GEN-LAST:event_txtCedulaKeyPressed

    private void cbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTodosActionPerformed
        llenarTabla(
                Deuda
                        .builder()
                        .build()
        );
    }//GEN-LAST:event_cbTodosActionPerformed

    private void cbInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInicialActionPerformed
        llenarTabla(
                Deuda
                        .builder()
                        .estadoDeuda('i')
                        .build()
        );
    }//GEN-LAST:event_cbInicialActionPerformed

    private void cbAbonadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAbonadaActionPerformed
        llenarTabla(
                Deuda
                        .builder()
                        .estadoDeuda('a')
                        .build()
        );
    }//GEN-LAST:event_cbAbonadaActionPerformed

    private void cbPagadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPagadaActionPerformed
        llenarTabla(
                Deuda
                        .builder()
                        .estadoDeuda('p')
                        .build()
        );
    }//GEN-LAST:event_cbPagadaActionPerformed

    private void cbNulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNulaActionPerformed
        llenarTabla(
                Deuda
                        .builder()
                        .estadoDeuda('n')
                        .build()
        );
    }//GEN-LAST:event_cbNulaActionPerformed

    private void jmiPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPagosActionPerformed
        if (validarTablaPersonas()) {
            return;
        }
        botones(true);
        mostrarDeudas();
        
        jtpPrincipal.addTab("Pagos del Deudor", jpPagosDeuda);
        jtpPrincipal.setSelectedComponent(jpPagosDeuda);
    }//GEN-LAST:event_jmiPagosActionPerformed

    private void jmOpcionesPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmOpcionesPagosActionPerformed
        if (validarTablaPersonas()) {
            return;
        }

        Resultado resultado = M_Deuda.update(
                Deuda
                        .builder()
                        .id(
                                ((Deuda) tblPersonas.getValueAt(
                                        tblPersonas.getSelectedRow(),
                                        0
                                )).getId()
                        )
                        .concepto(txtConcepto.getText())
                        .monto(
                                new BigDecimal(txtMonto.getText())
                        )
                        .build()
        );

        JOptionPane.showInternalMessageDialog(
                this,
                resultado.getMensaje(),
                "",
                resultado.getIcono()
        );
    }//GEN-LAST:event_jmOpcionesPagosActionPerformed

    private void botones(Boolean valor) {
        //Botones Para Deshabilitar:
        btnNuevo.setEnabled(!valor);
        btnModificar.setEnabled(!valor);
        btnBorrar.setEnabled(!valor);
        btnBuscar.setEnabled(!valor);
        tblPersonas.setEnabled(!valor);

        btnGuardar.setEnabled(valor);
        btnCancelar.setEnabled(valor);

        if (nuevo) {
            limpiarCampos();
        }

        txtCedula.setEditable(nuevo);
        btnGetCliente.setEnabled(nuevo);
    }

    public synchronized static void llenarTabla(Deuda deuda) {
        String titulos[] = {
            "Cod.#", "Nombre completo", "Cedula persona", "Concepto", "Monto",
            "Fecha", "Estado"
        };

        Object registro[] = new Object[titulos.length];
        DefaultTableModel miTabla = new DefaultTableModel(null, titulos);

        M_Deuda.select(
                Deuda
                        .builder()
                        .idPersona(deuda.getIdPersona())
                        .estadoDeuda(deuda.getEstadoDeuda())
                        .pagina(
                                Paginas
                                        .builder()
                                        .nPaginaNro(1)
                                        .nCantidadFilas(20)
                                        .build()
                        )
                        .build()
        ).stream().forEach(
                deudaR -> {
                    registro[0] = deudaR;
                    registro[1] = M_Persona.select(
                            Cliente
                                    .builder()
                                    .idPersona(
                                            deudaR.getIdPersona()
                                    ).build()
                    ).getFirst();
                    registro[2] = M_Generales.select(
                            Generales
                                    .builder()
                                    .idPersona(deudaR.getIdPersona())
                                    .build()
                    ).getFirst();
                    registro[3] = deudaR.getConcepto();
                    registro[4] = deudaR.getMonto();
                    registro[5] = deudaR.getFecha();
                    registro[6] = estadoDeuda(deudaR.getEstadoDeuda());
                    miTabla.addRow(registro);
                }
        );

        tblPersonas.setModel(miTabla);

        if (miTabla.getRowCount() != 0) {//La tabla esta llena
            tblPersonas.setRowSelectionInterval(0, 0);
        }

        DefaultTableCellRenderer tcr = new DefaultTableCellHeaderRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);//Estado
        tblPersonas.getColumnModel().getColumn(4).setCellRenderer(tcr);

        TableColumn miTableColumn;
        int[] ancho = {20, 180, 50, 620, 30, 20, 20};
        for (int i = 0; i < titulos.length; i++) {
            miTableColumn = tblPersonas.getColumnModel().getColumn(i);
            miTableColumn.setPreferredWidth(ancho[i]);
        }
    }

    private static String estadoDeuda(Character caracter) {
        return switch (caracter) {
            case 'i' ->
                "INICIAL";
            case 'p' ->
                "PAGADA";
            case 'a' ->
                "Abonada";
            default ->
                "NULA";
        };
    }

    private void limpiarCampos() {
        txtPNombre.setText("");
        txtSNombre.setText("");
        txtApellidos.setText("");
        txtMonto.setValue(0);
        txtConcepto.setText("");

        txtCedula.setValue("");
        txtCedula.requestFocus();
    }

    /**
     * Metodo encargado de mostrar la informacion del deudor en el
     * mantenimiento. Cedula de ejemplo: 425-0243748-0 121-0127731-2
     */
    private void mostrarRegistro(
            Persona persona
    ) {
        //No puede ser el cliente generico del sistema.
        if (persona.getIdPersona() <= 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Cliente no encontrado",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            limpiarCampos();
            return;
        }

        txtPNombre.setText(persona.getPnombre());
        txtSNombre.setText(persona.getSnombre());
        txtApellidos.setText(persona.getApellidos());
        txtCedula.setValue(
                M_Generales.select(
                        Generales
                                .builder()
                                .idPersona(persona.getIdPersona())
                                .build()
                ).getFirst()
        );

        if (!nuevo) {
            deudaField = ((Deuda) tblPersonas.getValueAt(
                    tblPersonas.getSelectedRow(),
                    0
            ));
            txtMonto.setValue(deudaField.getMonto());
            txtConcepto.setText(deudaField.getConcepto());
            txtCedula.setEditable(false);
        }
        txtMonto.requestFocus();
    }

    private BigDecimal txtMontoField() {
        try {
            txtMonto.commitEdit();
        } catch (ParseException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
        return new BigDecimal(txtMonto.getValue().toString());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBuscar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private javax.swing.JButton btnGetCliente;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBoxMenuItem cbAbonada;
    private javax.swing.JCheckBoxMenuItem cbInicial;
    private javax.swing.JCheckBoxMenuItem cbNula;
    private javax.swing.JCheckBoxMenuItem cbPagada;
    private javax.swing.JCheckBoxMenuItem cbTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel jlFoto;
    private javax.swing.JMenu jmFiltros;
    private javax.swing.JMenu jmOpcionesPagos;
    private javax.swing.JMenuItem jmiPagos;
    private javax.swing.JPanel jpListaDeuda;
    private javax.swing.JPanel jpPagosDeuda;
    private javax.swing.JPanel jpRegistroDeuda;
    private javax.swing.JSpinner jsPaginas;
    private javax.swing.JSpinner jsRegistros;
    private javax.swing.JTabbedPane jtpPrincipal;
    private rojerusan.RSMenuBar rSMenuBar1;
    private javax.swing.JTable tblDeudasPagas;
    private static javax.swing.JTable tblPersonas;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtApellidos1;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JFormattedTextField txtCedula1;
    private javax.swing.JFormattedTextField txtCedula2;
    private javax.swing.JTextArea txtConcepto;
    private javax.swing.JTextField txtIdDeuda;
    private javax.swing.JFormattedTextField txtMonto;
    private javax.swing.JFormattedTextField txtMonto1;
    private javax.swing.JFormattedTextField txtMontoPagado;
    private javax.swing.JTextField txtPNombre;
    private javax.swing.JTextField txtPNombre1;
    private javax.swing.JTextField txtSNombre;
    private javax.swing.JTextField txtSNombre1;
    // End of variables declaration//GEN-END:variables

    /**
     * Realiza la siguiente validaciones: 1) Valida que la tabla contenga
     * registros en el sistema. 2) Valida que haya un cliente seleccionado. 3)
     * valida que la deuda tenga estado inicial i.
     *
     * @return
     */
    private boolean validarTablaPersonas() {
        if (tblPersonas.getRowCount() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "No existe registro para la operacion.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }

        if (tblPersonas.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar un registro de la tabla...!!!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }

        //Verificamos que la deuda tenga el estado de iniciada. 
        if (!tblPersonas.getValueAt(
                tblPersonas.getSelectedRow(),
                6
        ).toString().equalsIgnoreCase(estadoDeuda('i'))) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "No se permite modificar deudas cuando el estado es diferente de iniciada.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }

        return false;
    }

    public void mostrarDeudas() {
        
        var deuda = (Deuda) tblPersonas.getValueAt(
                tblPersonas.getSelectedRow(), 
                0
        );
        var persona = (Persona) tblPersonas.getValueAt(
                tblPersonas.getSelectedRow(), 
                1
        );
        var cedula = (Generales) tblPersonas.getValueAt(
                tblPersonas.getSelectedRow(), 
                2
        );
        
        deuda = M_Deuda.select(deuda).getFirst();
        persona = M_Persona.select(persona).getFirst();
        cedula = M_Generales.select(cedula).getFirst();
        
        txtCedula1.setValue(cedula);
        txtIdDeuda.setText(deuda.getId().toString());
        txtPNombre1.setText(persona.getPnombre());
        txtSNombre1.setText(persona.getSnombre());
        txtApellidos1.setText(persona.getApellidos());
        txtMonto1.setText(deuda.getMonto().toString());
    }
}
