package sur.softsurena.formularios;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.entidades.Deuda;
import sur.softsurena.entidades.Generales;
import sur.softsurena.metodos.M_Cliente;
import sur.softsurena.metodos.M_Deuda;
import sur.softsurena.metodos.M_Generales;
import sur.softsurena.utilidades.DefaultTableCellHeaderRenderer;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 * TODO 29/11/2024 buscar la foto del cliente o deudor.
 *
 * @author jhironsel
 */
public class frmDeudas extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    private static boolean nuevo;
    private static DefaultTableModel miTabla;
    private static DefaultTableCellRenderer tcr;
    private static Deuda deuda;

    public static frmDeudas getInstance() {
        return NewSingletonHolder.INSTANCE;
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

    private static class NewSingletonHolder {

        private static final frmDeudas INSTANCE = new frmDeudas();
    }

    private frmDeudas() {

        initComponents();
        tcr = new DefaultTableCellHeaderRenderer();
        txtMonto.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(() -> {
                    txtMonto.setSelectionStart(3);
                    txtMonto.setSelectionEnd(txtMonto.getText().length());
                });
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jtpPrincipal = new javax.swing.JTabbedPane();
        jpListaDeuda = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jPanel9 = new javax.swing.JPanel();
        cbTodos = new javax.swing.JCheckBox();
        cbInicial = new javax.swing.JCheckBox();
        cbPagada = new javax.swing.JCheckBox();
        cbAbonada = new javax.swing.JCheckBox();
        cbNula = new javax.swing.JCheckBox();
        btnGetTotal = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnReiniciar = new javax.swing.JButton();
        btnVerPagos = new javax.swing.JButton();
        btnAbonar = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        jpRegistroDeuda = new javax.swing.JPanel();
        rSPanelMaterialGradient1 = new RSMaterialComponent.RSPanelMaterialGradient();
        txtCedula = new javax.swing.JFormattedTextField();
        btnGetCliente = new javax.swing.JButton();
        txtPNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtMonto = new javax.swing.JFormattedTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtConcepto = new javax.swing.JTextArea();
        jlFoto = new javax.swing.JLabel();
        txtSNombre = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBuscar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();

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

        jpListaDeuda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de Deuda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class<?>[] types = new Class<?>[] {
                Deuda.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class<?> getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 12))); // NOI18N
        jPanel9.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel9.setLayout(new java.awt.GridLayout(2, 3));

        buttonGroup1.add(cbTodos);
        cbTodos.setSelected(true);
        cbTodos.setText("Todos");
        cbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTodosActionPerformed(evt);
            }
        });
        jPanel9.add(cbTodos);

        buttonGroup1.add(cbInicial);
        cbInicial.setText("Iniciadas");
        cbInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInicialActionPerformed(evt);
            }
        });
        jPanel9.add(cbInicial);

        buttonGroup1.add(cbPagada);
        cbPagada.setText("Pagadas");
        cbPagada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPagadaActionPerformed(evt);
            }
        });
        jPanel9.add(cbPagada);

        buttonGroup1.add(cbAbonada);
        cbAbonada.setText("Abonadas");
        cbAbonada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAbonadaActionPerformed(evt);
            }
        });
        jPanel9.add(cbAbonada);

        buttonGroup1.add(cbNula);
        cbNula.setText("Nulas");
        cbNula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNulaActionPerformed(evt);
            }
        });
        jPanel9.add(cbNula);

        btnGetTotal.setText("Sumar");
        btnGetTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetTotalActionPerformed(evt);
            }
        });
        jPanel9.add(btnGetTotal);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cambiar Estado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 12))); // NOI18N
        jPanel7.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel7.setLayout(new java.awt.GridLayout(2, 2, 8, 5));

        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        jPanel7.add(btnReiniciar);

        btnVerPagos.setText("Ver pagos");
        btnVerPagos.setToolTipText("");
        btnVerPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPagosActionPerformed(evt);
            }
        });
        jPanel7.add(btnVerPagos);

        btnAbonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbonarActionPerformed(evt);
            }
        });
        jPanel7.add(btnAbonar);

        btnAnular.setText("Anular");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });
        jPanel7.add(btnAnular);

        javax.swing.GroupLayout jpListaDeudaLayout = new javax.swing.GroupLayout(jpListaDeuda);
        jpListaDeuda.setLayout(jpListaDeudaLayout);
        jpListaDeudaLayout.setHorizontalGroup(
            jpListaDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListaDeudaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpListaDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jpListaDeudaLayout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jpListaDeudaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel7, jPanel9});

        jpListaDeudaLayout.setVerticalGroup(
            jpListaDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListaDeudaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpListaDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jpListaDeudaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel7, jPanel9});

        jtpPrincipal.addTab("Listado", jpListaDeuda);

        jpRegistroDeuda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Deudor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N

        txtCedula.setEditable(false);
        txtCedula.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), " Cedula ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 255))); // NOI18N
        try {
            txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula.setToolTipText("Cedula del Cliente");
        txtCedula.setDoubleBuffered(true);
        txtCedula.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtCedula.setFocusTraversalPolicyProvider(true);
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

        btnGetCliente.setText("Clientes");
        btnGetCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));
        btnGetCliente.setEnabled(false);
        btnGetCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetClienteActionPerformed(evt);
            }
        });

        txtPNombre.setEditable(false);
        txtPNombre.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
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

        javax.swing.GroupLayout rSPanelMaterialGradient1Layout = new javax.swing.GroupLayout(rSPanelMaterialGradient1);
        rSPanelMaterialGradient1.setLayout(rSPanelMaterialGradient1Layout);
        rSPanelMaterialGradient1Layout.setHorizontalGroup(
            rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelMaterialGradient1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rSPanelMaterialGradient1Layout.createSequentialGroup()
                        .addGroup(rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGetCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(txtSNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        rSPanelMaterialGradient1Layout.setVerticalGroup(
            rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelMaterialGradient1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelMaterialGradient1Layout.createSequentialGroup()
                        .addComponent(jlFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(121, 121, 121))
                    .addGroup(rSPanelMaterialGradient1Layout.createSequentialGroup()
                        .addGroup(rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGetCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout jpRegistroDeudaLayout = new javax.swing.GroupLayout(jpRegistroDeuda);
        jpRegistroDeuda.setLayout(jpRegistroDeudaLayout);
        jpRegistroDeudaLayout.setHorizontalGroup(
            jpRegistroDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistroDeudaLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(rSPanelMaterialGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jpRegistroDeudaLayout.setVerticalGroup(
            jpRegistroDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistroDeudaLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(rSPanelMaterialGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Registro de Deuda", jpRegistroDeuda);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Botones de Acción"));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtpPrincipal)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtpPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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
            limpiarCedula();
            return;
        }
        mostrarRegistro(
                Cliente
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .generales(
                                                Generales
                                                        .builder()
                                                        .cedula(txtCedula.getText())
                                                        .build()
                                        )
                                        .pnombre("")
                                        .snombre("")
                                        .apellidos("")
                                        .build()
                        )
                        .build()
        );
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
        frmBusquedaCliente miBusqueda = new frmBusquedaCliente(null, true);
        miBusqueda.setLocationRelativeTo(null);
        miBusqueda.setVisible(true);

        if (miBusqueda.getCliente() == null) {
            return;
        }

        mostrarRegistro(
                Cliente
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .generales(
                                                miBusqueda
                                                        .getCliente()
                                                        .getPersona()
                                                        .getGenerales()
                                        )
                                        .pnombre("")
                                        .snombre("")
                                        .apellidos("")
                                        .build()
                        )
                        .build()
        );
    }//GEN-LAST:event_btnGetClienteActionPerformed

    /**
     * Metodo encargado de mostrar la informacion del deudor en el
     * mantenimiento. Cedula de ejemplo: 425-0243748-0 121-0127731-2
     */
    private void mostrarRegistro(Cliente cliente) {
        var listaClientes = M_Cliente.select(cliente);

        //Si la lista no esta vacia entonces.
        if (!listaClientes.isEmpty()) {
            //Obtenemos el primer registro de la consulta.
            Cliente clienteF = listaClientes.getFirst();

            //No puede ser el cliente generico del sistema.
            if (clienteF.getPersona().getId_persona() <= 0) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Cliente generico no puede crear deuda.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                limpiarCedula();
                return;
            }

            txtCedula.setValue(clienteF.getPersona().getGenerales().getCedula());
            txtPNombre.setText(clienteF.getPersona().getPnombre());
            txtSNombre.setText(clienteF.getPersona().getSnombre());
            txtApellidos.setText(clienteF.getPersona().getApellidos());

            //Si no es nuevo. Es Modificando.
            if (!nuevo) {
                deuda = M_Deuda.select(
                        Deuda
                                .builder()
                                .id_deuda(
                                        ((Deuda) tblClientes.getValueAt(
                                                tblClientes.getSelectedRow(),
                                                0
                                        )).getId_deuda()//Columna idDeuda.
                                )
                                .build()
                ).getFirst();

                txtMonto.setValue(deuda.getMonto());
                txtConcepto.setText(deuda.getConcepto());
            }

            txtCedula.setEditable(false);
            txtMonto.requestFocus();
        } else {//Si la lista esta vacia, entonces.

            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    "Desea registrar este usuario al sistema?",
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (resp == JOptionPane.YES_OPTION) {
                frmPrincipal.mnuMantenimientoClientes.doClick();
            } else {
                limpiarCedula();
            }
        }
    }

    private void cbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTodosActionPerformed
        llenarTabla();
    }//GEN-LAST:event_cbTodosActionPerformed

    private void cbInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInicialActionPerformed
        llenarTabla();
    }//GEN-LAST:event_cbInicialActionPerformed

    private void cbPagadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPagadaActionPerformed
        llenarTabla();
    }//GEN-LAST:event_cbPagadaActionPerformed

    private void cbAbonadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAbonadaActionPerformed
        llenarTabla();
    }//GEN-LAST:event_cbAbonadaActionPerformed

    private void cbNulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNulaActionPerformed
        llenarTabla();
    }//GEN-LAST:event_cbNulaActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        if (tblClientes.getRowCount() < 1) {
            return;
        }

        if (btnCancelar.isEnabled()) {
            txtCedula.requestFocus();
            return;
        }

        frmAutorizacion miAut = new frmAutorizacion(null, true);
        miAut.setLocationRelativeTo(null);
        miAut.setVisible(true);

        if (!miAut.isAceptado()) {
            return;
        }

        int valor = JOptionPane.showInternalConfirmDialog(
                this,
                "Se procederá a eliminar los pagos tambien!",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (valor == JOptionPane.NO_OPTION) {
            return;
        }

        //TODO Sacar el Metodo de modificar la deuda y hacer que devuelva un Resultados.
//        JOptionPane.showInternalMessageDialog(
//                this,
//                modificarDeuda(
//                        Integer.parseInt(tblClientes.getValueAt(cliAct, 0).toString()),
//                        "i"
//                ),
//                "",
//                JOptionPane.INFORMATION_MESSAGE
//        );
        llenarTabla();
//        mostrarRegistro();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnVerPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPagosActionPerformed
        if (tblClientes.getRowCount() == 0) {
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
        }

        frmPagosDeudas miPagos = new frmPagosDeudas(
                null,
                true,
                ((Deuda) tblClientes.getValueAt(
                        tblClientes.getSelectedRow(),
                        0
                )).getId_deuda(),
                txtCedula.getText().trim(),
                txtPNombre,
                txtApellidos,
                txtMontoField()
        );
        miPagos.setLocationRelativeTo(null);
        miPagos.setVisible(true);
    }//GEN-LAST:event_btnVerPagosActionPerformed

    /**
     * Metodo que permite abonar a una deuda.
     *
     * TODO Analizar y Descomentar.
     *
     * @param evt No utilizado por el momento.
     */
    private void btnAbonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonarActionPerformed
        if (tblClientes.getRowCount() < 1) {
            return;
        }

        if (btnCancelar.isEnabled()) {
            txtCedula.requestFocus();
            return;
        }

//        modificarDeuda(
//                        tblClientes.getValueAt(cliAct, 0)),
//                "a");
        M_Deuda.update(
                Deuda.builder().build()
        );

        JOptionPane.showInternalMessageDialog(
                this,
                "",
                "",
                -1
        );

        llenarTabla();

        mostrarRegistro(
                Cliente
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .build()
                        )
                        .build()
        );
    }//GEN-LAST:event_btnAbonarActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        if (tblClientes.getRowCount() < 1) {
            return;
        }
        if (btnCancelar.isEnabled()) {
            txtCedula.requestFocus();
            return;
        }

        frmAutorizacion miAut = new frmAutorizacion(null, true);
        miAut.setLocationRelativeTo(null);
        miAut.setVisible(true);

        if (!miAut.isAceptado()) {
            return;
        }

        //TODO Analizar y Testear este metodo de modificarDeuda()
        //Hacer que ese metodo revuelva un resultados.
//        JOptionPane.showInternalMessageDialog(
//                this,
//                modificarDeuda(
//                        Integer.parseInt(tblClientes.getValueAt(cliAct, 0).toString()),
//                        "n"),
//                "",
//                JOptionPane.INFORMATION_MESSAGE
//        );
        llenarTabla();
//        mostrarRegistro();
    }//GEN-LAST:event_btnAnularActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        jtpPrincipal.remove(jpRegistroDeuda);
        llenarTabla();
//        mostrarRegistro();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnGetTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetTotalActionPerformed
        //TODO Estudiar este metodo o btn para que se utiliza.
        String estado = "", msg = "Nada para mostrar";

        if (cbTodos.isSelected()) {
            estado = "GROUP BY r.estado";
        }
        if (cbInicial.isSelected()) {
            estado = "WHERE r.ESTADO like 'i' GROUP BY r.estado";
        }
        if (cbNula.isSelected()) {
            estado = "WHERE r.ESTADO like 'n' GROUP BY r.estado";
        }
        if (cbAbonada.isSelected()) {
            estado = "WHERE r.ESTADO like 'a' GROUP BY r.estado";
        }
        if (cbPagada.isSelected()) {
            estado = "WHERE r.ESTADO like 'p' GROUP BY r.estado";
        }

//        getConsulta(
//                "SELECT SUM(r.MONTO), case r.ESTADO "
//                + "when 'i' then 'Inicial:' "
//                + "when 'a' then 'Abonado:' "
//                + "when 'p' then 'Pagado:' "
//                + "when 'n' then 'Nulado:' "
//                + "end "
//                + "FROM GET_SUMA_DEUDA r "
//                + estado);
        //TODO Realizar proceso para consultar la deuda.
        ResultSet rs = null;

        try {
            while (rs.next()) {
                msg = msg.replaceAll("Nada para mostrar", "");
                msg = msg + (rs.getString(2)) + "       " + (rs.getString(1)) + " <BR>";
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error al cargar las sumas de las deudas.", ex);
        }
        msg = "<html><big>" + msg + "</big></html>";

        JOptionPane.showInternalMessageDialog(
                this,
                msg,
                "",
                JOptionPane.INFORMATION_MESSAGE
        );

    }//GEN-LAST:event_btnGetTotalActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo = true;

        nuevo(false);

        txtCedula.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //Debe existir registros en la tabla de clientes.
        if (tblClientes.getRowCount() == 0) {
            return;
        }

        //Debe de tener un cliente seleccionado.
        if (tblClientes.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar cliente...!!!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        //Verificamos que la deuda tenga el estado de iniciada. 
        if (!tblClientes.getValueAt(
                tblClientes.getSelectedRow(),
                5
        ).toString().equalsIgnoreCase("i")) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "No se permite modificar deudas cuando el estado es diferente de iniciada.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        //Mostrar el registro.
        mostrarRegistro(
                Cliente
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .generales(
                                                Generales
                                                        .builder()
                                                        .cedula(
                                                                tblClientes.getValueAt(
                                                                        tblClientes.getSelectedRow(),
                                                                        1
                                                                ).toString()//Columna cedula seleccionada.
                                                        )
                                                        .build()
                                        )
                                        .pnombre("")
                                        .snombre("")
                                        .apellidos("")
                                        .build()
                        )
                        .build()
        );

        nuevo = false;

        nuevo(false);
    }//GEN-LAST:event_btnModificarActionPerformed

    /**
     * TODO 28/11/2024 probar los metodos de la clase de prueba.
     *
     * @param evt
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtCedula.getText().trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar una cedula del Cliente...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            limpiarCedula();
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
        Deuda miDeuda = Deuda
                .builder()
                .id_deuda(nuevo ? null : deuda.getId_deuda())
                .cliente(
                        deuda.getCliente()
                )
                .concepto(txtConcepto.getText())
                .monto(txtMontoField())
                .build();

//                new Deudas(idCliente, getIdUsuario(),
//                txtConcepto.getText(), monto);
        String accion = "editar";
        if (nuevo) {
            accion = "inserta";
        }

        int resp = JOptionPane.showInternalConfirmDialog(
                this,
                """
                <html>
                    <b><big>Se va a %s deuda a: </big></b> <big> %s %s </big><br/>
                    <b><big>Cedula no.: </big></b> <big> %s </big><br/>
                    <b><big>Monto de deuda es: </big></b><big>%s</big><br/>
                    <b><big>Por Concepto de: </big></b><big>%s</big><br/>
                    <big>De fecha : </big></b><big>%s</big><br/>
                    <b><big>Desea continuar? </big></b>
                </html>
                """.formatted(
                        accion,
                        deuda.getCliente().getPersona()
                                .getPnombre()
                                .concat(" ")
                                .concat(
                                        deuda.getCliente().getPersona()
                                                .getSnombre()
                                ).trim().strip(),
                        deuda.getCliente().getPersona().getApellidos(),
                        deuda.getCliente().getPersona().getGenerales().getCedula(),
                        txtMonto.getText(),
                        txtConcepto.getText()
                                .concat(" ".repeat(50))
                                .substring(0, 49).trim().strip(),
                        Utilidades.formatDate(new Date(), "dd-MM-yyyy")
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

        llenarTabla();
        btnCancelarActionPerformed(evt);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        nuevo = false;

        nuevo(true);

//        mostrarRegistro();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (btnCancelar.isEnabled()) {
            txtCedula.requestFocus();
            return;
        }
        if (tblClientes.getRowCount() == 0) {
            return;
        }

        String idCliente = txtCedula.getText().trim();

        if (idCliente.isEmpty()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar cliente...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        String idDeuda = tblClientes.getValueAt(tblClientes.getSelectedRow(), 0).toString();
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

        //Actualizamos los cambios en la Tabla
        llenarTabla();
//        mostrarRegistro();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (btnCancelar.isEnabled()) {
            txtCedula.requestFocus();
            return;
        }
        if (tblClientes.getRowCount() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "No existe contenido que buscar...!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        String cliente = JOptionPane.showInternalInputDialog(
                this,
                "Ingrese la Cedula del Cliente: ",
                "",
                JOptionPane.PLAIN_MESSAGE
        );

        if (Objects.isNull(cliente)) {
            return;
        }

        int num = tblClientes.getRowCount();
        for (int i = 0; i < num; i++) {
            if (tblClientes.getValueAt(i, 1).toString().contains(cliente)) {
                break;
            }
            if (tblClientes.getValueAt(i, 2).toString().contains(cliente.toUpperCase())) {
                break;
            }
            if (tblClientes.getValueAt(i, 3).toString().contains(cliente.toUpperCase())) {
                break;
            }
        }
//        mostrarRegistro();
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

    private void nuevo(Boolean valor) {
        if (!valor) {
            jtpPrincipal.addTab("Mantenimiento", jpRegistroDeuda);
            jtpPrincipal.setSelectedComponent(jpRegistroDeuda);
        } else {
            jtpPrincipal.setSelectedComponent(jpListaDeuda);
            jtpPrincipal.remove(jpRegistroDeuda);
        }

        //Botones Para Deshabilitar:
        btnNuevo.setEnabled(valor);
        btnModificar.setEnabled(valor);
        btnBorrar.setEnabled(valor);
        btnBuscar.setEnabled(valor);
        tblClientes.setEnabled(valor);

        btnGuardar.setEnabled(!valor);
        btnCancelar.setEnabled(!valor);

        if (nuevo) {
            txtPNombre.setText("");
            txtSNombre.setText("");
            txtMonto.setValue(0);
            txtConcepto.setText("");
            limpiarCedula();
        }

        txtCedula.setEditable(!nuevo);

        btnGetCliente.setEnabled(nuevo);
    }

    public static void llenarTabla() {
        String titulos[] = {
            "Nombre completo", "Cedula Cliente", "Concepto", "Monto", "Fecha",
            "Estado"
        };
        Object registro[] = new Object[titulos.length];
        miTabla = new DefaultTableModel(null, titulos);

        M_Deuda.select(
                Deuda
                        .builder()
                        .cliente(
                                Cliente
                                        .builder()
                                        .persona(Persona.builder().build())
                                        .build()
                        )
                        .build()
        ).stream().forEach(
                deudaR -> {
                    registro[0] = deudaR;
                    registro[1] = deudaR.getCliente().getPersona().getGenerales();
                    registro[2] = deudaR.getConcepto();
                    registro[3] = deudaR.getMonto();
                    registro[4] = deudaR.getFecha();
                    registro[5] = deudaR.getEstadoDeuda();
                    miTabla.addRow(registro);
                }
        );

        tblClientes.setModel(miTabla);

        if (miTabla.getRowCount() != 0) {//La tabla esta llena
            tblClientes.setRowSelectionInterval(0, 0);
        }

        tcr.setHorizontalAlignment(SwingConstants.RIGHT);//Monto
        tblClientes.getColumnModel().getColumn(3).setCellRenderer(tcr);

        tcr.setHorizontalAlignment(SwingConstants.CENTER);//Estado
        tblClientes.getColumnModel().getColumn(5).setCellRenderer(tcr);

        TableColumn miTableColumn;
        for (int i = 0; i < titulos.length; i++) {
            miTableColumn = tblClientes.getColumnModel().getColumn(i);
            if (i == 0) {
                miTableColumn.setPreferredWidth(120);
            }
            if (i == 1) {
                miTableColumn.setPreferredWidth(25);
            }
            if (i == 2) {
                miTableColumn.setPreferredWidth(900);
            }
            if (i == 3) {
                miTableColumn.setPreferredWidth(30);
            }
            if (i == 4) {
                miTableColumn.setPreferredWidth(15);
            }
            if (i == 5) {
                miTableColumn.setPreferredWidth(10);
            }
        }
    }

    private void limpiarCedula() {
        txtCedula.setValue(null);
        txtCedula.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbonar;
    private javax.swing.JButton btnAnular;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBuscar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private javax.swing.JButton btnGetCliente;
    private javax.swing.JButton btnGetTotal;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevo;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnVerPagos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbAbonada;
    private javax.swing.JCheckBox cbInicial;
    private javax.swing.JCheckBox cbNula;
    private javax.swing.JCheckBox cbPagada;
    private javax.swing.JCheckBox cbTodos;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel jlFoto;
    private javax.swing.JPanel jpListaDeuda;
    private javax.swing.JPanel jpRegistroDeuda;
    private javax.swing.JTabbedPane jtpPrincipal;
    private RSMaterialComponent.RSPanelMaterialGradient rSPanelMaterialGradient1;
    private static javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JTextArea txtConcepto;
    private javax.swing.JFormattedTextField txtMonto;
    private javax.swing.JTextField txtPNombre;
    private javax.swing.JTextField txtSNombre;
    // End of variables declaration//GEN-END:variables
}
