package sur.softsurena.vistas;

import sur.softsurena.vista.VistaBusquedaPersona;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.function.Predicate;
import java.util.logging.Level;
import javax.swing.*;
import javax.swing.table.*;
import lombok.NonNull;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.entidades.*;
import static sur.softsurena.vistas.VistaPrincipal.mnuMovimientosNuevaFactura;
import sur.softsurena.hilos.VistaPrintFacturaConReporte2;
import sur.softsurena.hilos.hiloImpresionFactura;
import sur.softsurena.metodos.Imagenes;
import sur.softsurena.metodos.*;
import static sur.softsurena.metodos.M_Usuario.getUsuarioActual;
import sur.softsurena.utilidades.*;
import static sur.softsurena.utilidades.Utilidades.*;

public final class VistaFacturas extends javax.swing.JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private Integer idCliente;

    private String nombreCliente = "";

    private JButton btn, boton;

    private static Factura factura;

    private final static String titulos[]
            = {"Descripcion", "Precio", "Cantidad", "Montos"};

    private DefaultTableModel miTabla = new DefaultTableModel(null, titulos);

    private final static Object[] registro = new Object[titulos.length];

    private final Properties propiedad;

    private final DefaultTableCellRenderer tcr;

    private static Turno turno;

    private Properties getPropiedad() {
        return propiedad;
    }

//------------------------------------------------------------------------------
    private void setPropiedad() {
        File file = new File("../properties/proFacturas.prop");
        try (InputStream is = new FileInputStream(file);) {
            getPropiedad().load(is);
        } catch (FileNotFoundException ex) {
            LOG.log(
                    Level.SEVERE,
                    ARCHIVO_PRO_FACTURASPROP_NO_HA_SIDO_ENCONT,
                    ex
            );
        } catch (IOException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_CARGAR_EL_ARCHIVOS_DE_PROPIEDADE,
                    ex
            );
        }
    }
    public static final String ERROR_AL_CARGAR_EL_ARCHIVOS_DE_PROPIEDADE
            = "Error al cargar el archivos de propiedades proFacturas.prop";
    public static final String ARCHIVO_PRO_FACTURASPROP_NO_HA_SIDO_ENCONT
            = "Archivo proFacturas.prop no ha sido encontrado.";
//------------------------------------------------------------------------------

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
//------------------------------------------------------------------------------

    public VistaFacturas() {
        initComponents();

        txtCriterio.requestFocus();

        tcr = new DefaultTableCellHeaderRenderer();

        propiedad = new Properties();
        setPropiedad();

        btnGrupoPago.add(rbtContado);
        btnGrupoPago.add(rbtCredito);

        jlAlmacen.setIcon(new Imagenes("Almacen 32 x 32.png").getIcono());

        categoriaR();

    }
//------------------------------------------------------------------------------

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupoPago = new javax.swing.ButtonGroup();
        rSMenuBar2 = new rojerusan.RSMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jpInfoFactura = new javax.swing.JPanel();
        jlFacturaNo = new javax.swing.JLabel();
        txtIdFactura = new javax.swing.JTextField();
        txtTurno = new javax.swing.JTextField();
        jlAlmacen = new rojeru_san.rslabel.RSLabelAnimated();
        jPanel8 = new javax.swing.JPanel();
        jpFacturas = new javax.swing.JPanel();
        jpCliente = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        rbtContado = new javax.swing.JRadioButton();
        rbtCredito = new javax.swing.JRadioButton();
        btnBuscarCliente = new newscomponents.RSButtonGradientIcon_new();
        cmbClientes = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDetalle = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTotalValor = new javax.swing.JFormattedTextField();
        jPanel10 = new javax.swing.JPanel();
        jpBusqueda = new javax.swing.JPanel();
        txtCriterio = new javax.swing.JTextField();
        cbCriterio = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jspCategoria = new javax.swing.JScrollPane();
        jpCategoria = new javax.swing.JPanel();
        jspProductos = new javax.swing.JScrollPane();
        jpProductos = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        cbTodasCategorias = new javax.swing.JCheckBoxMenuItem();
        cbTodosProductos = new javax.swing.JCheckBoxMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        cbPrevistaMenu = new javax.swing.JMenu();
        cbPrevista = new javax.swing.JCheckBoxMenuItem();

        jMenu3.setText("File");
        rSMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        rSMenuBar2.add(jMenu4);

        jMenuItem1.setText("jMenuItem1");

        jpInfoFactura.setMinimumSize(new java.awt.Dimension(0, 35));
        jpInfoFactura.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jlFacturaNo.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jlFacturaNo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlFacturaNo.setText("Fact. no.:");
        jlFacturaNo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlFacturaNo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jlFacturaNo.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jpInfoFactura.add(jlFacturaNo);

        txtIdFactura.setEditable(false);
        txtIdFactura.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        txtIdFactura.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIdFactura.setAutoscrolls(false);
        txtIdFactura.setDoubleBuffered(true);
        txtIdFactura.setFocusCycleRoot(true);
        txtIdFactura.setFocusTraversalPolicyProvider(true);
        txtIdFactura.setName(""); // NOI18N
        jpInfoFactura.add(txtIdFactura);

        txtTurno.setEditable(false);
        txtTurno.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        txtTurno.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTurno.setAutoscrolls(false);
        txtTurno.setDoubleBuffered(true);
        txtTurno.setFocusCycleRoot(true);
        txtTurno.setFocusTraversalPolicyProvider(true);
        jpInfoFactura.add(txtTurno);

        jlAlmacen.setToolTipText("Indica que el cajero actual, esta realizando facturas desde este almacen.");
        jlAlmacen.setFont(new java.awt.Font("FreeMono", 1, 24)); // NOI18N
        jlAlmacen.setMaximumSize(new java.awt.Dimension(500, 40));
        jlAlmacen.setMinimumSize(new java.awt.Dimension(100, 40));
        jlAlmacen.setPreferredSize(new java.awt.Dimension(400, 40));
        jpInfoFactura.add(jlAlmacen);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Facturacion Sophia & Sophie");
        setToolTipText("");
        setAutoscrolls(true);
        setDoubleBuffered(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameDeiconified(evt);
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameIconified(evt);
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        jpCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
        jpCliente.setAlignmentX(0.0F);
        jpCliente.setAlignmentY(0.0F);
        jpCliente.setMinimumSize(new java.awt.Dimension(265, 135));
        jpCliente.setPreferredSize(new java.awt.Dimension(265, 135));
        org.jdesktop.swingx.VerticalLayout verticalLayout1 = new org.jdesktop.swingx.VerticalLayout();
        verticalLayout1.setGap(10);
        jpCliente.setLayout(verticalLayout1);

        jPanel9.setMaximumSize(new java.awt.Dimension(153, 100));
        jPanel9.setMinimumSize(new java.awt.Dimension(153, 50));
        jPanel9.setName(""); // NOI18N
        jPanel9.setPreferredSize(new java.awt.Dimension(153, 50));
        jPanel9.setLayout(new org.jdesktop.swingx.HorizontalLayout());

        jPanel4.setMinimumSize(new java.awt.Dimension(32767, 32767));
        jPanel4.setName(""); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 10));
        jPanel4.setLayout(new org.jdesktop.swingx.VerticalLayout());

        btnGrupoPago.add(rbtContado);
        rbtContado.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        rbtContado.setSelected(true);
        rbtContado.setText("Contado");
        rbtContado.setBorder(null);
        rbtContado.setFocusPainted(false);
        rbtContado.setFocusable(false);
        rbtContado.setMaximumSize(new java.awt.Dimension(363, 26));
        rbtContado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtContadoActionPerformed(evt);
            }
        });
        jPanel4.add(rbtContado);

        btnGrupoPago.add(rbtCredito);
        rbtCredito.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        rbtCredito.setText("Credito");
        rbtCredito.setBorder(null);
        rbtCredito.setFocusPainted(false);
        rbtCredito.setFocusable(false);
        rbtCredito.setMaximumSize(new java.awt.Dimension(363, 26));
        rbtCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtCreditoActionPerformed(evt);
            }
        });
        jPanel4.add(rbtCredito);

        jPanel9.add(jPanel4);

        btnBuscarCliente.setText("Clientes");
        btnBuscarCliente.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnBuscarCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBuscarCliente.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PEOPLE);
        btnBuscarCliente.setPreferredSize(new java.awt.Dimension(150, 40));
        btnBuscarCliente.setRound(30);
        btnBuscarCliente.setSizeIcon(40.0F);
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        jPanel9.add(btnBuscarCliente);

        jpCliente.add(jPanel9);

        cmbClientes.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        cmbClientes.setForeground(new java.awt.Color(0, 0, 255));
        cmbClientes.setEnabled(false);
        cmbClientes.setLightWeightPopupEnabled(false);
        cmbClientes.setMaximumSize(new java.awt.Dimension(363, 26));
        cmbClientes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClientesItemStateChanged(evt);
            }
        });
        cmbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClientesActionPerformed(evt);
            }
        });
        jpCliente.add(cmbClientes);

        jScrollPane5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane5.setMaximumSize(new java.awt.Dimension(452, 300));
        jScrollPane5.setPreferredSize(new java.awt.Dimension(452, 200));

        tblDetalle.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tblDetalle.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tblDetalle);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2, 2, 6));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Total Neto:");
        jPanel3.add(jLabel6);

        txtTotalValor.setEditable(false);
        txtTotalValor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtTotalValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        txtTotalValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalValor.setToolTipText("Total Neto de la factura actual");
        txtTotalValor.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jPanel3.add(txtTotalValor);

        javax.swing.GroupLayout jpFacturasLayout = new javax.swing.GroupLayout(jpFacturas);
        jpFacturas.setLayout(jpFacturasLayout);
        jpFacturasLayout.setHorizontalGroup(
            jpFacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFacturasLayout.createSequentialGroup()
                .addGroup(jpFacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                    .addComponent(jpCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jpFacturasLayout.setVerticalGroup(
            jpFacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFacturasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpBusqueda.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones de busqueda"));
        jpBusqueda.setMinimumSize(new java.awt.Dimension(0, 45));
        jpBusqueda.setPreferredSize(new java.awt.Dimension(360, 45));
        java.awt.FlowLayout flowLayout5 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0);
        flowLayout5.setAlignOnBaseline(true);
        jpBusqueda.setLayout(flowLayout5);

        txtCriterio.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtCriterio.setAutoscrolls(false);
        txtCriterio.setBorder(null);
        txtCriterio.setDoubleBuffered(true);
        txtCriterio.setFocusCycleRoot(true);
        txtCriterio.setFocusTraversalPolicy(null);
        txtCriterio.setFocusTraversalPolicyProvider(true);
        txtCriterio.setMinimumSize(new java.awt.Dimension(0, 25));
        txtCriterio.setPreferredSize(new java.awt.Dimension(300, 25));
        txtCriterio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCriterioActionPerformed(evt);
            }
        });
        jpBusqueda.add(txtCriterio);

        cbCriterio.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Opcion Busqueda", "Codigo", "Descripcion", "En Detalle" }));
        cbCriterio.setSelectedIndex(1);
        cbCriterio.setFocusable(false);
        cbCriterio.setPreferredSize(new java.awt.Dimension(160, 25));
        jpBusqueda.add(cbCriterio);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setText("\",\" Codigo \".\" Descripcion \"-\" Detalle Factura");
        jLabel4.setMinimumSize(new java.awt.Dimension(0, 16));
        jpBusqueda.add(jLabel4);

        jspCategoria.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jpCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria"));
        jpCategoria.setToolTipText("Areas de la categorias registradas en el sistema.");
        jpCategoria.setAutoscrolls(true);
        jpCategoria.setMinimumSize(new java.awt.Dimension(0, 32));
        jpCategoria.setName("jpCategoria"); // NOI18N
        jpCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpCategoriaMouseClicked(evt);
            }
        });
        jspCategoria.setViewportView(jpCategoria);

        jspProductos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jspProductos.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jspProductos.setAutoscrolls(true);
        jspProductos.setDoubleBuffered(true);
        jspProductos.setMaximumSize(new java.awt.Dimension(0, 0));
        jspProductos.setMinimumSize(new java.awt.Dimension(0, 0));
        jspProductos.setPreferredSize(new java.awt.Dimension(0, 1000));

        jpProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N
        jpProductos.setPreferredSize(new java.awt.Dimension(0, 1000));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout();
        flowLayout1.setAlignOnBaseline(true);
        jpProductos.setLayout(flowLayout1);
        jspProductos.setViewportView(jpProductos);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpBusqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jspCategoria)
                    .addComponent(jspProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jpFacturas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("Archivos");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Nueva factura");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem8.setText("Grabar factura");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem9.setText("Limpiar");
        jMenu1.add(jMenuItem9);

        jMenuBar1.add(jMenu1);

        jMenu9.setText("Facturas");
        jMenu9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu9ActionPerformed(evt);
            }
        });

        jMenuItem7.setText("Ultimas Facturas");
        jMenu9.add(jMenuItem7);

        jMenuBar1.add(jMenu9);

        jMenu2.setText("Temporal");

        jMenuItem3.setText("Gestion de Facturas en Temporales");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Buscar Facturas en Temporales");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Filtros");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });

        cbTodasCategorias.setText("Todas las Categorias");
        cbTodasCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbTodasCategoriasMouseClicked(evt);
            }
        });
        jMenu5.add(cbTodasCategorias);

        cbTodosProductos.setText("Todos los Productos");
        cbTodosProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbTodosProductosMouseClicked(evt);
            }
        });
        jMenu5.add(cbTodosProductos);

        jMenuBar1.add(jMenu5);

        jMenu8.setText("Getiones");

        jMenu6.setText("Gastos");

        jMenuItem5.setText("Gestion de Gastos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenu8.add(jMenu6);

        jMenu7.setText("Deudas");

        jMenuItem6.setText("Gestion de Deudas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem6);

        jMenu8.add(jMenu7);

        jMenuBar1.add(jMenu8);

        cbPrevistaMenu.setText("Prevista");

        cbPrevista.setSelected(true);
        cbPrevista.setText("Activado");
        cbPrevista.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbPrevistaStateChanged(evt);
            }
        });
        cbPrevistaMenu.add(cbPrevista);

        jMenuBar1.add(cbPrevistaMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        turno = M_Turno.select(
                Turno
                        .builder()
                        .turno_usuario(
                                getUsuarioActual().getUserName()
                        )
                        .estado(true)
                        .build()
        ).getFirst();
        txtTurno.setText("Turno: " + turno.getId());
        //TODO 24/11/2024 Obtener los valores de los siguiente componente.
//        jlAlmacen.setText("Almacen: " + turno.getAlmacen().getNombre());

        txtIdFactura.setText(
                M_M_Factura.getIDFacturaNueva(
                        turno.getId()
                ).toString()
        );

        txtCriterio.requestFocus();
    }//GEN-LAST:event_formInternalFrameActivated
//------------------------------------------------------------------------------

    /**
     * Este metodo permite hacer busqueda de productos en la base de datos y en
     * la tabla de la factura que se esta realizando.
     *
     * 1) Permite cambiar la forma de buscar un producto por codigo.
     *
     * 2) Permite cambiar la forma de buscar un producto por descripcion.
     *
     * 3) Permite cambiar la forma de buscar un producto en la lista de detalle
     * de la factura.
     *
     * 4) Limpia los resultados de la busqueda del sistema, cuando el comboBox
     * de criterio esta en el index 0.
     *
     *
     * @param evt No se esta utilizado en el sistema.
     */
    private void txtCriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriterioActionPerformed
        if (opcionesCriterio()) {
            return;
        }

        if (cbCriterio.getSelectedIndex() == 1
                || cbCriterio.getSelectedIndex() == 2) {

            List<Producto> listaProductos = M_Producto.select(
                    Producto
                            .builder()
                            .build()
            );

            Predicate<Producto> predicado = null;

            jpProductos.removeAll();
            jpProductos.repaint();

            if (cbCriterio.getSelectedIndex() == 1) {
                predicado = (f) -> f.getCodigo().contains(
                        txtCriterio.getText().trim()
                );
            }

            if (cbCriterio.getSelectedIndex() == 2) {
                predicado = (f) -> f.getDescripcion().contains(
                        txtCriterio.getText().trim()
                );
            }

            listaProductos.stream().filter(predicado).forEach(
                    producto -> {
                        boton = new JButton(
                                producto
                                        .getDescripcion()
                                        .concat("                   ")
                                        .substring(0, 17)
                        );
                        boton.setToolTipText(producto.getId().toString());
                        boton.setMnemonic('p');

                        List<FotoProducto> fotos = M_Foto_Producto.select(
                                FotoProducto
                                        .builder()
                                        .idProducto(producto.getId())
                                        .actual(Boolean.TRUE)
                                        .build()
                        );

                        ImageIcon imagen = new ImageIcon(
                                "sur/softsurena/imagenes/NoImageTransp 96 x 96.png"
                        );

                        if (!fotos.isEmpty()) {
                            imagen = new ImageIcon(
                                    Utilidades.imagenDecode64(
                                            fotos.getLast().getFoto(),
                                            64,
                                            64
                                    ).getImage()
                            );
                        }

                        Icon icon = new ImageIcon(imagen.getImage());

                        imagen.getImage().flush();

                        boton.setIcon(icon);

                        boton.addActionListener(this);

                        boton.setIconTextGap(2);
                        boton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        boton.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                        boton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                        boton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

                        int ancho = 170, alto = 100;
                        boton.setPreferredSize(new java.awt.Dimension(ancho, alto));
                        boton.setMinimumSize(new java.awt.Dimension(ancho, alto));
                        boton.setMaximumSize(new java.awt.Dimension(ancho, alto));

                        boton.setLayout(new BorderLayout(8, 8));
                        boton.requestFocus();

                        jpProductos.add(boton);
                        jpProductos.repaint();
                        jpProductos.validate();

                        boton.requestFocus();
                    }
            );
        }

//-----------------------------------------------------------------------------5
        if (cbCriterio.getSelectedIndex() == 3) {

            if (txtCriterio.getText().isBlank()) {
                return;
            }

            if (!M_Producto.select(
                    Producto
                            .builder()
                            .codigo(txtCriterio.getText().trim())
                            .descripcion(txtCriterio.getText().trim())
                            .pagina(
                                    Paginas
                                            .builder()
                                            .nPaginaNro(1)
                                            .nCantidadFilas(20)
                                            .build()
                            )
                            .build()
            ).isEmpty()) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "El Producto No Existe...",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );

                txtCriterio.setText("");
                return;
            }

            //Detalle de Factura
            int num = tblDetalle.getRowCount();
            if (num == 0) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "No existe producto en detalle!!!",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                txtCriterio.setText("");
                return;
            }
            boolean dime = true;
            for (int i = 0; i < num; i++) {
                //TODO Esto no tiene sentido.
                if (factura.getId().toString().equals(
                        txtCriterio.getText().trim()
                )) {
                    tblDetalle.setRowSelectionInterval(i, i);
                    dime = false;
                    txtCriterio.setText("");
                    break;
                }
            }

            if (dime) {
                txtCriterio.setText("");
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Producto no encontrado",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_txtCriterioActionPerformed

    /**
     *
     * @param evt
     */
    private void rbtCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtCreditoActionPerformed

        if (evt == null) {
            rbtCredito.doClick();
        }

        //Si la venta sera a credito, debe seleccionarse un cliente.
        cmbClientes.setEnabled(true);

        //Se habilita el boton que permite obtener los clientes.
        btnBuscarCliente.setEnabled(true);

        //Se seleccionan el primero Item del comboBox.
        if (cmbClientes.getItemCount() > 0) {
            cmbClientes.setSelectedIndex(0);
        }
    }//GEN-LAST:event_rbtCreditoActionPerformed

    private void rbtContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtContadoActionPerformed

        if (evt == null) {
            rbtContado.doClick();
        }

        cmbClientes.setEnabled(false);

        if (cmbClientes.getItemCount() > 0) {
            cmbClientes.setSelectedIndex(0);
        }
    }//GEN-LAST:event_rbtContadoActionPerformed


    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        getClientesCombo();
        repararRegistro();
        totales();
        formInternalFrameDeiconified(evt);
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        if (tblDetalle.getRowCount() != 0) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    "Existe una factura, Desea Salir?",
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (resp == JOptionPane.YES_OPTION) {
                dispose();
            }
        } else {
            dispose();
        }
        formInternalFrameIconified(evt);
    }//GEN-LAST:event_formInternalFrameClosing

    private void cmbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClientesActionPerformed
        if (!cmbClientes.isEnabled()) {
            return;
        }
    }//GEN-LAST:event_cmbClientesActionPerformed

    private void cmbClientesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClientesItemStateChanged
        if (cmbClientes.getSelectedIndex() == 0) {
            jpCliente.setSize(265, 86);
            jpCliente.setPreferredSize(new Dimension(265, 86));
            jpCliente.setMinimumSize(new Dimension(265, 86));
            jpCliente.setMaximumSize(new Dimension(265, 86));

        } else {
            jpCliente.setSize(265, 135);
            jpCliente.setPreferredSize(new Dimension(265, 135));
            jpCliente.setMinimumSize(new Dimension(265, 135));
            jpCliente.setMaximumSize(new Dimension(265, 135));
        }
    }//GEN-LAST:event_cmbClientesItemStateChanged

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        VistaBusquedaPersona miBusqueda = new VistaBusquedaPersona(
                null, true, new String[]{"Clientes"}
        );
        miBusqueda.setLocationRelativeTo(null);
        miBusqueda.setVisible(true);

        Persona cliente = miBusqueda.getPersona();

        if (cliente == null) {
            return;
        }
        getClientesCombo();

        for (int i = 0; i < cmbClientes.getItemCount(); i++) {
            if (cmbClientes.getItemAt(i).getIdPersona().equals(
                    cliente.getIdPersona()
            )) {
                cmbClientes.setSelectedIndex(i);
                break;
            }
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void formInternalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeiconified
        if (VistaPrincipal.jpEstados.getComponent(0) != jpInfoFactura)
            VistaPrincipal.jpEstados.add(jpInfoFactura, 0);
    }//GEN-LAST:event_formInternalFrameDeiconified

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
        if (VistaPrincipal.jpEstados.getComponent(0) == jpInfoFactura)
            VistaPrincipal.jpEstados.remove(jpInfoFactura);
    }//GEN-LAST:event_formInternalFrameIconified

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        formInternalFrameIconified(evt);
    }//GEN-LAST:event_formInternalFrameClosed

    private void jpCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCategoriaMouseClicked
        if (evt.getClickCount() == 2)
            categoriaR();
    }//GEN-LAST:event_jpCategoriaMouseClicked

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_formPropertyChange

    private void cbTodasCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTodasCategoriasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTodasCategoriasMouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        categoriaR();

        //TODO Hacer que el cbTodos lea la siguiente propiedad al iniciar este frmFactura.
        getPropiedad().setProperty("cbTodosUsuario", "" + cbTodasCategorias.isSelected());

        try {
            getPropiedad().store(
                    new FileWriter(
                            new File(
                                    "../properties/frmFacturaPropiedades.properties"
                            )
                    ),
                    "Valor que permite obtener las categorias.");
        } catch (IOException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error al cargar la URI de archivo properties frmFacturaPropiedades.properties",
                    ex
            );
        }
    }//GEN-LAST:event_jMenu5MouseClicked

    private void cbTodosProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTodosProductosMouseClicked
//      TODO 11/07/2025 analizar el codigo.
//        jpProductos = new javax.swing.JPanel();
//
//        jpProductos.setAutoscrolls(true);
//
//        jpProductos.setBackground(new java.awt.Color(255, 102, 51));
//
//        jpProductos.setBorder(
//                javax.swing.BorderFactory.createTitledBorder(
//                        null,
//                        "Productos",
//                        javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
//                        javax.swing.border.TitledBorder.DEFAULT_POSITION,
//                        new java.awt.Font(
//                                "Ubuntu",
//                                0,
//                                14
//                        )
//                )
//        );
//        setLayout();
//        jpProductos.setMaximumSize(new java.awt.Dimension(350, 1500));
//        jpProductos.setMinimumSize(new java.awt.Dimension(350, 1500));
//        jpProductos.setPreferredSize(new java.awt.Dimension(350, 1500));
        jpProductos.removeAll();
        jpProductos.repaint();
        jpProductos.validate();
    }//GEN-LAST:event_cbTodosProductosMouseClicked

    private void cbPrevistaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbPrevistaStateChanged

    }//GEN-LAST:event_cbPrevistaStateChanged

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (tblDetalle.getRowCount() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Factura Vacia...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (factura.getD_factura().get(0) == null) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Ha ocurrido un error de factura realice de nuevo...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (cmbClientes.getSelectedIndex() > 0) {
            nombreCliente = ((Cliente) cmbClientes.getSelectedItem()).toString();
        } else {

            if (Objects.isNull(nombreCliente) || nombreCliente.isBlank()) {

                nombreCliente = JOptionPane.showInternalInputDialog(
                        this,
                        "Cual es el nombre del cliente?: ",
                        "",
                        JOptionPane.QUESTION_MESSAGE
                );

                if (Objects.isNull(nombreCliente) || nombreCliente.isBlank()) {
                    JOptionPane.showInternalMessageDialog(
                            this,
                            "Seleccione un cliente para guardarla en temporal... ",
                            "",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
            }

        }

        //TODO 02/01/2025 trabajar en la siguiente variable.
        VistaPonerTemporal miTemporal = new VistaPonerTemporal(
                null, true
        );

//        miTemporal.setFactura(Integer.parseInt(txtIdFactura.getText()));
//        miTemporal.setMiTabla(miTabla);
//        miTemporal.setFacturas(facturas);
//        miTemporal.setCredicto(rbtCredito.isSelected());
//        miTemporal.setIdTurno(getTurno());
//        miTemporal.setIdCliente(idClienteTemporal);
//        miTemporal.setNombreCliente(nombreCliente);
//        miTemporal.setIdUsuario(getIdUsuario());
//        miTemporal.setAceptar(false);
//
//        miTemporal.setLocationRelativeTo(null);
//        miTemporal.setVisible(true);
//
//        if (miTemporal.isAceptar()) {
//            nueva();
//        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        VistaBuscarTemporal miTempo = new VistaBuscarTemporal(null, true);
        miTempo.setLocationRelativeTo(null);
        miTempo.setVisible(true);

        if (miTempo.isAceptar()) {

            if (miTempo.getFactura().equals(txtIdFactura.getText())) {
                return;
            }

            btnBuscarCliente.setEnabled(false);

            setTitle("[Nueva Factura: " + miTempo.getFactura()
                    + "] - [Turno No.: " + turno.getId()
                    + "] - [Factura Temporarl activa, Cliente: " + nombreCliente + "]");

            txtIdFactura.setText("" + miTempo.getFactura());

            String sql = "SELECT d.IDFACTURA, d.IDLINEA, d.IDPRODUCTO, "
                    + "          p.DESCRIPCION, d.CANTIDAD, d.PRECIO "
                    + "FROM DETALLEFACTURA d "
                    + "    LEFT JOIN PRODUCTOS p "
                    + "        on p.IDPRODUCTO = d.IDPRODUCTO "
                    + "where d.IDFACTURA = " + miTempo.getFactura() + " "
                    + "order by 2";

//            ResultSet rs = getConsulta(sql);
            ResultSet rs = null;

            try {
                while (rs.next()) {
//                    facturas.(
//                            rs.getInt("idLinea") - 1,
//                            new Factura(
//                                    Integer.parseInt(miTempo.getFactura()),
//                                    rs.getShort("idLinea"),
//                                    rs.getString("idProducto"),
//                                    rs.getString("descripcion"),
//                                    rs.getDouble("precio"),
//                                    rs.getDouble("cantidad")
//                            )
//                            null
//                    );

                    registro[0] = rs.getDouble("cantidad");
                    registro[1] = rs.getString("descripcion");
                    registro[2] = rs.getDouble("precio");
                    registro[3] = Utilidades.priceWithDecimal(
                            rs.getDouble("precio") * rs.getDouble("cantidad"));

                    miTabla.addRow(registro);

                    tblDetalle.setModel(miTabla);
                    tblDetalle.setRowSelectionInterval(rs.getInt("idLinea") - 1, rs.getInt("idLinea") - 1);
                }
            } catch (SQLException ex) {
                LOG.log(
                        Level.SEVERE,
                        "Error al leer los detalles de la factura.",
                        ex
                );
            }

            sql = "SELECT r.IDCLIENTE, nombreCliente "
                    + "FROM FACTURA r "
                    + "where r.IDFACTURA = " + miTempo.getFactura() + " ";

//            rs = getConsulta(sql);
            try {
                rs.next();
                setIdCliente(rs.getInt(1));
                nombreCliente = rs.getString(2);
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, "Error al cargar la factura.", ex);
            }

            for (int i = 0; i <= cmbClientes.getItemCount() + 1; i++) {

                if (cmbClientes.getItemAt(i).getIdPersona().equals(
                        getIdCliente()
                )) {
                    cmbClientes.setSelectedIndex(i);
                    totales();
                    break;
                }
            }
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        int resp = JOptionPane.showInternalOptionDialog(
                this,
                "<html><big>Que desea registrar?</big></html>",
                "",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"<html><big>Gasto</big></html>", "<html><big>Deuda</big></html", "<html><big>Cancelar</big></html"},
                0
        );

        if (resp == 0) {
            VistaAutorizacion miAut = new VistaAutorizacion(null, true);
            miAut.setLocationRelativeTo(null);
            miAut.setVisible(true);

            if (!miAut.isAceptado()) {
                return;
            }

            VistaGasto miGasto = new VistaGasto(null, true);
            miGasto.setLocationRelativeTo(null);
            miGasto.setVisible(true);

        }

        if (resp == 1) {
        }

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        int resp = JOptionPane.showInternalOptionDialog(
                this,
                "<html><big>Tipo de Deuda?</big></html",
                "",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{
                    "<html><big>Credito</big></html>",
                    "<html><big>Externa</big></html",
                    "<html><big>Cancelar</big></html"
                },
                0
        );

        if (resp == 0) {
            VistaCobrosClientes miPagoCliente = new VistaCobrosClientes(
                    null, true
            );
            miPagoCliente.setIdTurno(turno.getId());
            miPagoCliente.setLocationRelativeTo(null);
            miPagoCliente.setVisible(true);

            return;
        }
        if (resp == 1) {

            VistaCobrosDeudas miPagoDeuda = new VistaCobrosDeudas(null, true);
//            miPagoDeuda.setNombreCajero(usuario.getUser_name());
//            miPagoDeuda.setIdTurno(turno.getId());
            miPagoDeuda.setLocationRelativeTo(null);
            miPagoDeuda.setVisible(true);

        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenu9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu9ActionPerformed
        int resp = JOptionPane.showInternalConfirmDialog(
                this,
                "Desea Imprimir la Ultima Factura?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE
        );

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        VistaPrintFacturaConReporte2 miPrint = new VistaPrintFacturaConReporte2(null, true);
        miPrint.setCopia(false);
        miPrint.setLocationRelativeTo(null);
        miPrint.setVisible(true);
    }//GEN-LAST:event_jMenu9ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed

        //Verificamos si la factura es acredito y haya un cliente seleccionado.
        //Si esto se cumple hacemos que cajero seleccione un cliente.
        if (rbtCredito.isSelected() && cmbClientes.getSelectedIndex() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    """
                    Debe Seleccinar un cliente.!!!
                    """,
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            cmbClientes.requestFocus();
            cmbClientes.showPopup();
            return;
        }

        double total = Utilidades.controlDouble(txtTotalValor.getValue());

        VistaCalculoEfectivo miEfe = new VistaCalculoEfectivo(
                null,
                true,
                total,
                rbtCredito.isSelected()
        );

        miEfe.setLocationRelativeTo(null);
        miEfe.setVisible(true);

        if (miEfe.getResp() == 0) {
            return;
        }

        char estado = rbtCredito.isSelected() ? 'c' : 'p';
//
//        if (factura.getHeaderFactura().getEstado() == 'T') {
//            //Preparar Factura Temporal
//            HeaderFactura hf = HeaderFactura.builder().
//                    estado(estado).build();
//
//            Factura f = Factura.builder().id(idFactura).headerFactura(hf).build();
//
//            if (!modificarFactura(f)) {
//                JOptionPane.showInternalMessageDialog(
//                        this,
//                        "Ocurrio un error factura Temporal",
//                        "",
//                        JOptionPane.ERROR_MESSAGE
//                );
//                return;
//            } else {
//                for (int i = 1; i <= factura.getDetalleFactura().size(); i++) {
//                    if (!agregarOrInsertarDetalleFactura(
//                            facturas.getId(),
//                            i,
//                            facturas.getDetalleFactura().get(i).getIdProducto(),
//                            facturas.getDetalleFactura().get(i).getPrecio(),
//                            facturas.getDetalleFactura().get(i).getCantidad())) {
//
//                        borrarFactura(idFactura);
//
//                        JOptionPane.showInternalMessageDialog(
//                              this,
//                              "Ocurrio un error Temporal Detallle"
//                        );
//                        return;
//                    }
//                }
//            }
//        } else {
//
//            HeaderFactura hf = HeaderFactura
//                    .builder()
//                    .id_persona(((Cliente) cmbCliente.getSelectedItem()).getId_persona())
//                    .idTurno(turno.getId())
//                    .efectivo(new BigDecimal(miEfe.txtEfectivo.getValue().toString()))
//                    //.cambio(new BigDecimal(miEfe.txtDevuelta.getValue().toString()))
//                    //.credito(rbtCredito.isSelected())
//                    .build();
//
//            D_Factura objDF = null;
//
//            detalleFacturaList = new ArrayList<D_Factura>();
//
//            detalleFacturaList.add(objDF);
//
//            Factura factura = Factura.builder().
//                    id(idFactura).headerFactura(hf).detalleFactura(detalleFacturaList).build();
//
//            if (agregarFacturaNombre(factura) < 1) {
//                JOptionPane.showInternalMessageDialog(
//                        this,
//                        "Esta compra no se ha registrado...",
//                        "",
//                        JOptionPane.ERROR_MESSAGE
//                );
//            } else {
//                for (int i = 0; i < factura.getDetalleFactura().size(); i++) {
//                    if (agregarDetalleFactura(factura) < 1) {
//                        JOptionPane.showInternalMessageDialog(
//                                this,
//                                "Esta compra no se ha registrado...",
//                                "",
//                                JOptionPane.ERROR_MESSAGE
//                        );
//                        return;
//                    }
//                }
//            }
//        }
        txtIdFactura.setText(
                M_M_Factura.getIDFacturaNueva(
                        turno.getId()
                ).toString()
        );

//-----------------------------------------------------------------------------1
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("idFactura", Integer.valueOf(txtIdFactura.getText()));
        new hiloImpresionFactura(
                cbPrevistaMenu.isSelected(),
                rbtCredito.isSelected(),
                "/Reportes/factura.jasper",
                parametros,
                VistaPrincipal.jPanelImpresion,
                VistaPrincipal.jprImpresion
        ).start();
//----------------------------------------------------------------------------
        totales();

        rbtContado.doClick();
        factura.getD_factura().clear();
        nombreCliente = "";
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        VistaDetalleQuitarEliminar miForm = new VistaDetalleQuitarEliminar(
                null, true
        );

        miForm.setLocationRelativeTo(null);
        miForm.setVisible(true);

        if (miForm.getOpcion() == 1) {
            opcion1();
        }
        if (miForm.getOpcion() == 2) {
            opcion2();
        }
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * Es el metodo Sobre escrito que me permite hacer varias acciones en el.
     *
     * Este metodo detecta varias acciones que realiza el usuario al crear una
     * factura.
     *
     * 1) Validamos que el parametro del metodo no sea nulo.
     *
     * 2) Obtenemos las propiedades del boton pulsado.
     *
     * 3) Condicional que se cumple cuando Mnemonic es P
     *
     * 4) Condicional que se cumple cuando Mnemonic es C
     *
     *
     * @param actionEvent este parametro no puede ser nulo y es utilizado para
     * obtener informacion del boton pulsado en los productos consultados.
     *
     */
    @Override
    public void actionPerformed(
            @NonNull ActionEvent actionEvent
    ) {
//-----------------------------------------------------------------------------1
        try {
            btn = (JButton) actionEvent.getSource();
        } catch (Exception eb) {
            LOG.log(
                    Level.SEVERE,
                    """
                    Error al obtener informacion del producto.
                    No pulso' un boton.
                    """,
                    eb
            );
            return;
        }
//-----------------------------------------------------------------------------2
        /*
         * La siguiente condicional es utilizada para obtener el producto a 
         * facturar. 
         */
        if (btn.getMnemonic() == 80) { //Para cuando btn en su Mnemonic es P
            Resultado validarCantidad = validarCantidad();
            if (validarCantidad.getEstado()) {
                return;
            }

            List<Precio> listaPrecio = M_Precio.select(
                    Precio
                            .builder()
                            .idProducto(
                                    Integer.valueOf(
                                            btn.getToolTipText()
                                    )
                            )
                            .build()
            );

            if (listaPrecio.isEmpty()) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Producto no cuenta con precio registrados",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
//            facturas.add(
//                    tblDetalle.getRowCount(),
//                    new Factura(
//                            Integer.parseInt(txtIdFactura.getText()),//IdFactura
//                            (short) tblDetalle.getRowCount(),//IdLinea
//                            btn.getToolTipText(),//IdProducto
//                            btn.getText(),//Descripcion del producto
//                            precio,//Precio del producto
//                            cantidad
//                    )
//                    null
//            );//Cantidad

            Precio precio;
            if (listaPrecio.size() > 1) {
                precio = (Precio) JOptionPane.showInternalInputDialog(
                        this,
                        "Cual es el precio del articulo.!!!",
                        "",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        listaPrecio.toArray(),
                        listaPrecio.get(0)
                );
            } else {
                precio = listaPrecio.getFirst();
            }

            if (Objects.isNull(precio)) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Seleccione un precio para el articulo.!!!",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            registro[0] = btn.getText();
            registro[1] = precio.getPrecio().doubleValue();
            registro[2] = validarCantidad.getCantidadDecimal();
            registro[3] = Utilidades.priceWithDecimal(
                    precio.getPrecio().doubleValue() * validarCantidad.getCantidadDecimal()
            );

            miTabla.addRow(registro);
            tblDetalle.setModel(miTabla);

            jpProductos.removeAll();
            jpProductos.repaint();

            //Seleccionar ultimo elemento
            tblDetalle.changeSelection(tblDetalle.getRowCount() - 1, 0, false, false);
            tblDetalle.requestFocus();

            totales();
            txtCriterio.setText("");
            txtCriterio.requestFocus();
            return;
        }//Fin de la inclusion de producto....

//-----------------------------------------------------------------------------3
        if (btn.getMnemonic() == 67) {//Para cuando btn en su Mnemonic es C
            int idCategoria = Integer.parseInt(btn.getToolTipText());

            jpProductos.removeAll();
            jpProductos.repaint();

            M_Producto.select(
                    Producto
                            .builder()
                            .idCategoria(idCategoria)
                            .build()
            ).stream().forEach(
                    producto -> {

                        boton = new JButton(producto.getDescripcion());
                        boton.setToolTipText(producto.getId().toString());

                        boton.setMnemonic('P');

                        ImageIcon imagen;

                        producto.getId();

                        List<FotoProducto> fotos = M_Foto_Producto.select(
                                FotoProducto
                                        .builder()
                                        .idProducto(producto.getId())
                                        .actual(Boolean.TRUE)
                                        .build()
                        );

                        if (fotos.isEmpty()) {
                            imagen = new ImageIcon("sur/softsurena/imagenes/NoImageTransp 96 x 96.png");
                        } else {
                            FotoProducto fotoProducto = fotos.getLast();
                            imagen = imagenDecode64(fotoProducto.getFoto(), 96, 96);
                        }

                        Icon icon = new ImageIcon(
                                imagen.getImage().getScaledInstance(
                                        64,
                                        64,
                                        Image.SCALE_DEFAULT
                                )
                        );

                        imagen.getImage().flush();

                        boton.setIcon(icon);

                        boton.addActionListener(this);

                        boton.setIconTextGap(2);
                        boton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        boton.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                        boton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                        boton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

                        int ancho = 170, alto = 100;

                        boton.setPreferredSize(new java.awt.Dimension(ancho, alto));
                        boton.setMinimumSize(new java.awt.Dimension(ancho, alto));
                        boton.setMaximumSize(new java.awt.Dimension(ancho, alto));

                        boton.setLayout(new BorderLayout(8, 8));

                        jpProductos.add(boton);
                        jpProductos.repaint();
                        jpProductos.validate();

                    }
            );
        }
    }//Fin de actionPerformed

    private void repararRegistro() {
        miTabla = new DefaultTableModel(null, titulos);
        tblDetalle.setModel(miTabla);
        TableColumn miTableColumn;
        for (int i = 0; i < titulos.length; i++) {
            miTableColumn = tblDetalle.getColumnModel().getColumn(i);
            if (i == 0) {
                miTableColumn.setPreferredWidth(100); // la tercera columna sera la mas grande
            }
            if (i == 1) {
                miTableColumn.setPreferredWidth(40); // la tercera columna sera la mas grande
            }
            if (i == 2) {
                miTableColumn.setPreferredWidth(40); // la tercera columna sera la mas grande
            }
            if (i == 3) {
                miTableColumn.setPreferredWidth(15); // la tercera columna sera la mas grande
            }
        }

        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tcr.setFont(new java.awt.Font("Ubuntu", 50, 80));
        tcr.setBackground(Color.yellow);
        tblDetalle.getColumnModel().getColumn(2).setCellRenderer(tcr);
    }

    /**
     * Este metodo realiza lo siguiente:
     *
     * 1) Crea una lista llamada categoriasList, el cual contendrá todas las
     * categorias del sistema.
     *
     * 2) Dependiendo del componente checkbox llamado cbTodos, llamara el metodo
     * que devuelva las categorias del sistema, que se necesite consultar.
     *
     * 3) Se eliminan los componente que existan dentro del panel jpCategoria.
     *
     *
     */
    private void categoriaR() {
        //jpCategoria = new javax.swing.JPanel();
//        jpCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria"));
//        jpCategoria.setToolTipText("Areas de la categorias registradas en el sistema.");
//        jpCategoria.setAutoscrolls(true);
//        jpCategoria.setMaximumSize(new java.awt.Dimension(64, 64));
//        jpCategoria.setMinimumSize(new java.awt.Dimension(64, 64));
//        jpCategoria.setName("jpCategoria");

        //Limpiamos el jPanel de las categorias.
        jpCategoria.removeAll();
        jpCategoria.repaint();
        jpCategoria.setLayout(new FlowLayout());

        //TODO No se está obteniendo todas las categorias.
        M_Categoria.select(
                Categoria
                        .builder()
                        .estado(cbTodasCategorias.isSelected())
                        .build()
        ).stream().forEach(
                categoria -> {
                    //Obteniendo la imagen de la categoria.
                    var listaFoto = M_Foto_Categoria.select(
                            FotoCategoria
                                    .builder()
                                    .id(categoria.getId_categoria())
                                    .build()
                    ).stream().filter(foto -> foto.getActual() == true).findFirst();

                    String foto = "";

                    if (listaFoto.isPresent()) {
                        foto = listaFoto.get().getFoto();
                    }

                    ImageIcon imagen = Utilidades.imagenDecode64(
                            foto,
                            64,
                            64
                    );

                    if (imagen.getIconHeight() == -1) {
                        imagen = new Imagenes("NoImageTransp 96 x 96.png").getIcono();
                    }

                    Icon icon = new ImageIcon(
                            imagen.getImage().getScaledInstance(
                                    64, 64, Image.SCALE_DEFAULT));

                    //Nombre de la categoria.
                    boton = new JButton(categoria.getDescripcion(), icon);

                    //ID de la categoria.
                    boton.setToolTipText("" + categoria.getId_categoria());

                    //Una constante del boton que indica que es una categoria.
                    boton.setMnemonic('c');

                    //imagen.getImage().flush();
                    //Personalizamos el boton. 
                    boton.addActionListener(this);

                    boton.validate();
                    boton.setIconTextGap(2);
                    boton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    boton.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                    boton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                    boton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

                    final int ancho = 120, alto = 95;
                    boton.setPreferredSize(new java.awt.Dimension(ancho, alto));
                    boton.setMinimumSize(new java.awt.Dimension(ancho, alto));
                    boton.setMaximumSize(new java.awt.Dimension(ancho, alto));

                    boton.setLayout(new FlowLayout());
                    jpCategoria.add(boton);
                    jpCategoria.repaint();
                    jpCategoria.validate();
                }
        );
    }

    /**
     * Este metodo se esta ejecutando en dos metodos, son:
     * formInternalFrameOpened: Permite cargar la lista de los clientes en el
     * JComboBox al abrirse el Formulario.
     *
     * btnBuscarClienteActionPerformed: Actualiza el combo para que un bucl
     * busque si un cliente existe.
     *
     */
    private void getClientesCombo() {
        cmbClientes.removeAllItems();
        cmbClientes.repaint();

        M_Cliente.select(
                Cliente
                        .builder()
                        .build()
        ).stream().forEach(
                cliente -> {
                    M_Persona.select(
                            Persona
                                    .builder()
                                    .idPersona(cliente.getId())
                                    .build()
                    ).stream().filter(filtro -> filtro.getEstado()).forEach(
                            persona -> {
                                cmbClientes.addItem(persona);
                            }
                    );
                }
        );

        if (cmbClientes.getItemCount() > 0) {
            cmbClientes.setSelectedIndex(0);
        }
    }

    private void totales() {
        int num = tblDetalle.getRowCount();
        double sumVal = 0;

        if (num != 0) {
            for (int i = 0; i < num; i++) {
                sumVal += Utilidades.objectToDouble(tblDetalle.getValueAt(i, 3));
            }
        } else {
            txtTotalValor.setValue(0);
            return;
        }
        txtTotalValor.setValue(sumVal);
    }

    private void nueva() {
        mnuMovimientosNuevaFactura.doClick();
        nombreCliente = "";
        factura.getD_factura().clear();
    }

    /**
     * Metodo que vigila el campo criterio del formulario. Si txtCriterio es
     * igual a , entonces el jComBox Criterio cambia a la posicion 1.
     *
     * Si txtCriterio es igual a . entonces el jComBox Criterio cambia a la
     * posicion 2.
     *
     * Si txtCriterio es igual a - entonces el jComBox Criterio cambia a la
     * posicion 3.
     *
     * En los tres caso devuelve true. En caso contario devuelve False.
     *
     * @return
     */
    private boolean opcionesCriterio() {
        if (txtCriterio.getText().trim().equals(",")) {
            cbCriterio.setSelectedIndex(1);
            return true;
        }
//-----------------------------------------------------------------------------1
        if (txtCriterio.getText().trim().equals(".")) {
            cbCriterio.setSelectedIndex(2);
            return true;
        }
//-----------------------------------------------------------------------------2
        if (txtCriterio.getText().trim().equals("-")) {
            cbCriterio.setSelectedIndex(3);
            return true;
        }
//-----------------------------------------------------------------------------3
        if (cbCriterio.getSelectedIndex() == 0) {
            jpProductos.removeAll();
            jpProductos.repaint();
            return true;
        }
        txtCriterio.setText("");
        return false;
    }

    /**
     * Este metodo nos permite validar las cantidades registradas al sistema,
     * esta solo permite ingresar valores positivos mayores que 0, no permite
     * que letras o caracteres que no puedan convertirse a numero.
     *
     * @return retorna un objecto de la clase Resultados, la cual lleva consigo
     * el estado de la validacion true o false y la cantidad valida.
     */
    private Resultado validarCantidad() {
        Float cantidad = 0.0f;
        boolean bandera;
        do {
            bandera = false;
            try {
                String cantidadPro = JOptionPane.showInternalInputDialog(
                        this,
                        "Cantidad: ",
                        "",
                        JOptionPane.QUESTION_MESSAGE
                );

                if (Objects.isNull(cantidadPro)) {
                    bandera = true;
                    break;
                }

                cantidad = Float.valueOf(cantidadPro);

            } catch (NumberFormatException ex) {
                javax.swing.JOptionPane.showInternalMessageDialog(
                        this,
                        "Ingrese una cantidad numerica: ",
                        "",
                        JOptionPane.WARNING_MESSAGE
                );

                bandera = true;
                continue;
            }

            if (cantidad <= 0) {
                javax.swing.JOptionPane.showInternalMessageDialog(
                        this,
                        "Ingrese una cantidad positiva y diferente de cero: ",
                        "",
                        JOptionPane.WARNING_MESSAGE);
                bandera = true;
            }

        } while (bandera);//Fin del bucle.

        return Resultado
                .builder()
                .cantidadDecimal(cantidad)
                .estado(bandera)
                .build();
    }

    private void opcion1() {
        int rta = JOptionPane.showInternalConfirmDialog(
                this,
                "¿Esta Seguro de Borrar el detalle de la Factura?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (rta == JOptionPane.NO_OPTION) {
            return;
        }
        nueva();
    }

    private void opcion2() {
//        if (factura.getHeaderFactura().getEstado() == 'T') {
//            JOptionPane.showInternalMessageDialog(
//                    this,
//                    "Es una factura temporal no se permite eliminar",
//                    "",
//                    JOptionPane.ERROR_MESSAGE
//            );
//            return;
//        }
//
//        try {
//            DefaultTableModel modelo = (DefaultTableModel) tblDetalle.getModel();
//            int fila = tblDetalle.getSelectedRow();
//            if (fila == -1) {
//                JOptionPane.showInternalMessageDialog(
//                        this,
//                        "Debe seleccionar un articulo del detalle factura",
//                        "",
//                        JOptionPane.ERROR_MESSAGE
//                );
//                return;
//            }
//
//            factura.getDetalleFactura().remove(fila);
//
//            modelo.removeRow(fila);
//
//            totales();
//
//        } catch (HeadlessException ex) {
//            LOG.log(Level.SEVERE, "Error al remover articulo.", ex);
//        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonGradientIcon_new btnBuscarCliente;
    private javax.swing.ButtonGroup btnGrupoPago;
    private javax.swing.JComboBox<String> cbCriterio;
    private javax.swing.JCheckBoxMenuItem cbPrevista;
    private javax.swing.JMenu cbPrevistaMenu;
    private javax.swing.JCheckBoxMenuItem cbTodasCategorias;
    private javax.swing.JCheckBoxMenuItem cbTodosProductos;
    private javax.swing.JComboBox<Persona> cmbClientes;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane5;
    private rojeru_san.rslabel.RSLabelAnimated jlAlmacen;
    private javax.swing.JLabel jlFacturaNo;
    private javax.swing.JPanel jpBusqueda;
    private javax.swing.JPanel jpCategoria;
    private javax.swing.JPanel jpCliente;
    private javax.swing.JPanel jpFacturas;
    private static javax.swing.JPanel jpInfoFactura;
    private javax.swing.JPanel jpProductos;
    private javax.swing.JScrollPane jspCategoria;
    private javax.swing.JScrollPane jspProductos;
    private rojerusan.RSMenuBar rSMenuBar2;
    private javax.swing.JRadioButton rbtContado;
    public javax.swing.JRadioButton rbtCredito;
    public javax.swing.JTable tblDetalle;
    public javax.swing.JTextField txtCriterio;
    private javax.swing.JTextField txtIdFactura;
    private javax.swing.JFormattedTextField txtTotalValor;
    private javax.swing.JTextField txtTurno;
    // End of variables declaration//GEN-END:variables
}
