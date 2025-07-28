package sur.softsurena.vistas;

import sur.softsurena.vista.VistaBusquedaPersona;
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
import sur.softsurena.entidades.Deuda;
import sur.softsurena.entidades.Generales;
import sur.softsurena.entidades.Paginas;
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
    private static Deuda deuda;

    public VistaDeudas() {
        initComponents();
        jtpPrincipal.remove(jpRegistroDeuda);

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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jtpPrincipal = new javax.swing.JTabbedPane();
        jpListaDeuda = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonas = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
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
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBuscar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();
        rSMenuBar1 = new rojerusan.RSMenuBar();
        jmArchivos = new javax.swing.JMenu();
        jmiNuevo = new javax.swing.JMenuItem();
        jmiModificar = new javax.swing.JMenuItem();
        jmiBorrar = new javax.swing.JMenuItem();
        jmEditar = new javax.swing.JMenu();
        jmiBuscar = new javax.swing.JMenuItem();
        jmFiltros = new javax.swing.JMenu();
        cbTodos = new javax.swing.JCheckBoxMenuItem();
        cbInicial = new javax.swing.JCheckBoxMenuItem();
        cbAbonada = new javax.swing.JCheckBoxMenuItem();
        cbPagada = new javax.swing.JCheckBoxMenuItem();
        cbNula = new javax.swing.JCheckBoxMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jmOpcionesPagos = new javax.swing.JMenu();
        jmiVerPagos = new javax.swing.JMenuItem();
        jmiAbonar = new javax.swing.JMenuItem();

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

        javax.swing.GroupLayout jpListaDeudaLayout = new javax.swing.GroupLayout(jpListaDeuda);
        jpListaDeuda.setLayout(jpListaDeudaLayout);
        jpListaDeudaLayout.setHorizontalGroup(
            jpListaDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListaDeudaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpListaDeudaLayout.setVerticalGroup(
            jpListaDeudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListaDeudaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
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
                            .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGetCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

        rSMenuBar1.setBorderPainted(false);
        rSMenuBar1.setPreferredSize(new java.awt.Dimension(0, 30));

        jmArchivos.setForeground(new java.awt.Color(255, 255, 255));
        jmArchivos.setText("Archivos");

        jmiNuevo.setText("Nuevo");
        jmArchivos.add(jmiNuevo);

        jmiModificar.setText("Modificar");
        jmArchivos.add(jmiModificar);

        jmiBorrar.setText("Borrar");
        jmArchivos.add(jmiBorrar);

        rSMenuBar1.add(jmArchivos);

        jmEditar.setForeground(new java.awt.Color(255, 255, 255));
        jmEditar.setText("Editar");

        jmiBuscar.setText("Buscar");
        jmEditar.add(jmiBuscar);

        rSMenuBar1.add(jmEditar);

        jmFiltros.setForeground(new java.awt.Color(255, 255, 255));
        jmFiltros.setText("Filtros");

        buttonGroup1.add(cbTodos);
        cbTodos.setSelected(true);
        cbTodos.setText("Todos");
        cbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTodosActionPerformed(evt);
            }
        });
        jmFiltros.add(cbTodos);

        buttonGroup1.add(cbInicial);
        cbInicial.setText("Iniciadas");
        cbInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInicialActionPerformed(evt);
            }
        });
        jmFiltros.add(cbInicial);

        buttonGroup1.add(cbAbonada);
        cbAbonada.setText("Abonadas");
        cbAbonada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAbonadaActionPerformed(evt);
            }
        });
        jmFiltros.add(cbAbonada);

        buttonGroup1.add(cbPagada);
        cbPagada.setText("Pagadas");
        cbPagada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPagadaActionPerformed(evt);
            }
        });
        jmFiltros.add(cbPagada);

        buttonGroup1.add(cbNula);
        cbNula.setText("Nulas");
        cbNula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNulaActionPerformed(evt);
            }
        });
        jmFiltros.add(cbNula);
        jmFiltros.add(jSeparator1);

        jMenuItem1.setText("Sumar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmFiltros.add(jMenuItem1);

        rSMenuBar1.add(jmFiltros);

        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Estados");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Reiniciar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem4.setText("Anular");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        rSMenuBar1.add(jMenu3);

        jmOpcionesPagos.setForeground(new java.awt.Color(255, 255, 255));
        jmOpcionesPagos.setText("Opciones de pagos");
        jmOpcionesPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmOpcionesPagosActionPerformed(evt);
            }
        });

        jmiVerPagos.setText("Ver pagos");
        jmiVerPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVerPagosActionPerformed(evt);
            }
        });
        jmOpcionesPagos.add(jmiVerPagos);

        jmiAbonar.setText("Abonar");
        jmiAbonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAbonarActionPerformed(evt);
            }
        });
        jmOpcionesPagos.add(jmiAbonar);

        rSMenuBar1.add(jmOpcionesPagos);

        setJMenuBar(rSMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtpPrincipal)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtpPrincipal)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

            VistaPrincipal.mnuMantenimientoClientes.doClick();
        } else {
            mostrarRegistro(
                    M_Persona.select(
                            Persona
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
            limpiarCedula();
            return;
        }

        mostrarRegistro(miBusqueda.getPersona());
    }//GEN-LAST:event_btnGetClienteActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        llenarTabla();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo = true;
        botones(false);
        txtCedula.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //Debe existir registros en la tabla de clientes.
        if (tblPersonas.getRowCount() == 0) {
            return;
        }

        //Debe de tener un cliente seleccionado.
        if (tblPersonas.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar cliente...!!!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        //Verificamos que la deuda tenga el estado de iniciada. 
        if (!tblPersonas.getValueAt(
                tblPersonas.getSelectedRow(),
                6
        ).toString().equals("i")) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "No se permite modificar deudas cuando el estado es diferente de iniciada.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
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
        botones(false);
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
        var _idPersona = ((Generales) txtCedula.getValue()).getIdPersona();
        Deuda miDeuda = Deuda
                .builder()
                .id(nuevo ? null : deuda.getId())
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
                Persona
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

        llenarTabla();
        btnCancelarActionPerformed(evt);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        nuevo = false;
        botones(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (tblPersonas.getRowCount() == 0) {
            return;
        }

        String idDeuda = tblPersonas.getValueAt(tblPersonas.getSelectedRow(), 0).toString();

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
        if (tblPersonas.getRowCount() == 0) {
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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //TODO Estudiar este metodo o btn para que se utiliza.
        String estado = "", msg = "Nada para mostrar";

        if (cbTodos.isSelected()) {
            estado = "GROUP BY r.estado";
        }
        if (cbInicial.isSelected()) {
            estado = "WHERE r.ESTADO like 'i' GROUP BY r.estado";
        }
        if (cbAbonada.isSelected()) {
            estado = "WHERE r.ESTADO like 'a' GROUP BY r.estado";
        }
        if (cbPagada.isSelected()) {
            estado = "WHERE r.ESTADO like 'p' GROUP BY r.estado";
        }
        if (cbNula.isSelected()) {
            estado = "WHERE r.ESTADO like 'n' GROUP BY r.estado";
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
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void cbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTodosActionPerformed
        llenarTabla();
    }//GEN-LAST:event_cbTodosActionPerformed

    private void cbInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInicialActionPerformed
        llenarTabla();
    }//GEN-LAST:event_cbInicialActionPerformed

    private void cbAbonadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAbonadaActionPerformed
        llenarTabla();
    }//GEN-LAST:event_cbAbonadaActionPerformed

    private void cbPagadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPagadaActionPerformed
        llenarTabla();
    }//GEN-LAST:event_cbPagadaActionPerformed

    private void cbNulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNulaActionPerformed
        llenarTabla();
    }//GEN-LAST:event_cbNulaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        if (tblPersonas.getRowCount() < 1) {
            return;
        }

        if (btnCancelar.isEnabled()) {
            txtCedula.requestFocus();
            return;
        }

        VistaAutorizacion miAut = new VistaAutorizacion(null, true);
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
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (tblPersonas.getRowCount() < 1) {
            return;
        }
        if (btnCancelar.isEnabled()) {
            txtCedula.requestFocus();
            return;
        }

        VistaAutorizacion miAut = new VistaAutorizacion(null, true);
        miAut.setLocationRelativeTo(null);
        miAut.setVisible(true);

        if (!miAut.isAceptado()) {
            return;
        }

        //TODO Analizar y Testear este metodo de modificarDeuda()
        //Hacer que ese metodo Devuelva un resultados.
//        JOptionPane.showInternalMessageDialog(
//                this,
//                modificarDeuda(
//                        Integer.parseInt(tblClientes.getValueAt(
//                                tblClientes.getSelectedRow(), 
//                                0
//                        ).toString()),
//                        "n"
//                ),
//                "",
//                JOptionPane.INFORMATION_MESSAGE
//        );
        llenarTabla();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jmiVerPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVerPagosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiVerPagosActionPerformed

    private void jmiAbonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAbonarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiAbonarActionPerformed

    private void jmOpcionesPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmOpcionesPagosActionPerformed
        if (tblPersonas.getRowCount() == -1) {
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
        tblPersonas.setEnabled(valor);

        btnGuardar.setEnabled(!valor);
        btnCancelar.setEnabled(!valor);

        if (nuevo) {
            limpiarCedula();
        }

        txtCedula.setEditable(nuevo);
        btnGetCliente.setEnabled(nuevo);
    }

    /**
     *
     */
    public static void llenarTabla() {
        String titulos[] = {
            "Cod.#", "Nombre completo", "Cedula persona", "Concepto", "Monto",
            "Fecha", "Estado"
        };

        Object registro[] = new Object[titulos.length];
        DefaultTableModel miTabla = new DefaultTableModel(null, titulos);

        M_Deuda.select(
                Deuda
                        .builder()
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
                            Persona
                                    .builder()
                                    .idPersona(
                                            deudaR.getIdPersona()
                                    ).build()
                    );
                    registro[2] = M_Generales.select(
                            Generales
                                    .builder()
                                    .idPersona(deudaR.getIdPersona())
                                    .build()
                    ).getFirst();
                    registro[3] = deudaR.getConcepto();
                    registro[4] = deudaR.getMonto();
                    registro[5] = deudaR.getFecha();
                    registro[6] = deudaR.getEstadoDeuda();
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
        int[] ancho = {50, 100, 50, 600, 100, 50, 50};
        for (int i = 0; i < titulos.length; i++) {
            miTableColumn = tblPersonas.getColumnModel().getColumn(i);
            miTableColumn.setPreferredWidth(ancho[i]);
        }
    }

    private void limpiarCedula() {
        txtPNombre.setText("");
        txtSNombre.setText("");
        txtApellidos.setText("");
        txtMonto.setValue(0);
        txtConcepto.setText("");

        txtCedula.setValue(null);
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
            limpiarCedula();
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
            deuda = ((Deuda) tblPersonas.getValueAt(
                    tblPersonas.getSelectedRow(),
                    0
            ));
            txtMonto.setValue(deuda.getMonto());
            txtConcepto.setText(deuda.getConcepto());
            txtCedula.setEditable(false);
            txtMonto.requestFocus();
        }
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
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel jlFoto;
    private javax.swing.JMenu jmArchivos;
    private javax.swing.JMenu jmEditar;
    private javax.swing.JMenu jmFiltros;
    private javax.swing.JMenu jmOpcionesPagos;
    private javax.swing.JMenuItem jmiAbonar;
    private javax.swing.JMenuItem jmiBorrar;
    private javax.swing.JMenuItem jmiBuscar;
    private javax.swing.JMenuItem jmiModificar;
    private javax.swing.JMenuItem jmiNuevo;
    private javax.swing.JMenuItem jmiVerPagos;
    private javax.swing.JPanel jpListaDeuda;
    private javax.swing.JPanel jpRegistroDeuda;
    private javax.swing.JTabbedPane jtpPrincipal;
    private rojerusan.RSMenuBar rSMenuBar1;
    private static javax.swing.JTable tblPersonas;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JTextArea txtConcepto;
    private javax.swing.JFormattedTextField txtMonto;
    private javax.swing.JTextField txtPNombre;
    private javax.swing.JTextField txtSNombre;
    // End of variables declaration//GEN-END:variables
}
