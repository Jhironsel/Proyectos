package sur.softsurena.formularios;

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
import static sur.softsurena.formularios.frmPrincipal.mnuMovimientosNuevaFactura;
import sur.softsurena.hilos.hiloImpresionFactura;
import sur.softsurena.metodos.Imagenes;
import sur.softsurena.metodos.*;
import static sur.softsurena.metodos.M_Usuario.getUsuarioActual;
import sur.softsurena.utilidades.*;
import static sur.softsurena.utilidades.Utilidades.*;

public final class frmFacturas extends javax.swing.JInternalFrame implements ActionListener {

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
        File file = new File("properties/proFacturas.prop");
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

    public static frmFacturas getInstance() {
        return NewSingletonHolder.INSTANCE;
    }

    private void setLayout() {
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout();
        flowLayout1.setAlignOnBaseline(true);
        jpProductos.setLayout(flowLayout1);
    }

    private static class NewSingletonHolder {
        private static final frmFacturas INSTANCE = new frmFacturas();
    }

    private frmFacturas() {
        initComponents();

        txtCriterio.requestFocus();

        tcr = new DefaultTableCellHeaderRenderer();

        propiedad = new Properties();
        setPropiedad();

        btnGrupoPago.add(rbtContado);
        btnGrupoPago.add(rbtCredito);

        Utilidades.clickOnKey(btnPonerTemporal, "temporar", KeyEvent.VK_F5);
        Utilidades.clickOnKey(btnBuscarTemporal, "temporarBuscar", KeyEvent.VK_F6);
        Utilidades.clickOnKey(btnGastos, "gastos", KeyEvent.VK_F7);
        Utilidades.clickOnKey(btnPagoDeuda, "pagoDeuda", KeyEvent.VK_F8);
        Utilidades.clickOnKey(btnImpresionUltima, "impresionUltima", KeyEvent.VK_F9);
        Utilidades.clickOnKey(btnGrabar, "factura", KeyEvent.VK_F10);
        Utilidades.clickOnKey(btnLimpiarF12, "cancelar", KeyEvent.VK_F12);

        jlAlmacen.setIcon(new Imagenes("Almacen 32 x 32.png").getIcono());

        categoriaR();

    }
//------------------------------------------------------------------------------

    @SuppressWarnings("unchecked")
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
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnPonerTemporal = new newscomponents.RSButtonGradientIcon_new();
        btnBuscarTemporal = new newscomponents.RSButtonGradientIcon_new();
        btnGastos = new newscomponents.RSButtonGradientIcon_new();
        btnPagoDeuda = new newscomponents.RSButtonGradientIcon_new();
        btnImpresionUltima = new newscomponents.RSButtonGradientIcon_new();
        btnGrabar = new newscomponents.RSButtonGradientIcon_new();
        btnLimpiarF12 = new newscomponents.RSButtonGradientIcon_new();
        jPanel6 = new javax.swing.JPanel();
        cbTodos = new javax.swing.JCheckBox();
        cbTodosProductos = new javax.swing.JCheckBox();
        cbPrevista = new javax.swing.JCheckBox();
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
        btnPonerTemporal1 = new newscomponents.RSButtonGradientIcon_new();
        btnPonerTemporal2 = new newscomponents.RSButtonGradientIcon_new();
        btnPonerTemporal3 = new newscomponents.RSButtonGradientIcon_new();
        btnPonerTemporal4 = new newscomponents.RSButtonGradientIcon_new();
        btnPonerTemporal5 = new newscomponents.RSButtonGradientIcon_new();
        btnPonerTemporal6 = new newscomponents.RSButtonGradientIcon_new();

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

        jPanel5.setAutoscrolls(true);
        jPanel5.setMinimumSize(new java.awt.Dimension(250, 68));
        jPanel5.setLayout(new java.awt.GridLayout(1, 7, 3, 3));

        btnPonerTemporal.setText("<html><center>Getion<br>Temporal F5</center></html>");
        btnPonerTemporal.setToolTipText("<html><center>Temporal<br>F5</center></html>");
        btnPonerTemporal.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnPonerTemporal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPonerTemporal.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.HOURGLASS_FULL);
        btnPonerTemporal.setName("btnTemporal"); // NOI18N
        btnPonerTemporal.setRound(30);
        btnPonerTemporal.setSizeIcon(40.0F);
        btnPonerTemporal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPonerTemporal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonerTemporalActionPerformed(evt);
            }
        });
        jPanel5.add(btnPonerTemporal);

        btnBuscarTemporal.setText("<html><center>Buscar<br>Temporal F6</center></html>");
        btnBuscarTemporal.setToolTipText("<html><center>Temporal<br>F6</center></html>");
        btnBuscarTemporal.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnBuscarTemporal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarTemporal.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnBuscarTemporal.setName("btnTemporal"); // NOI18N
        btnBuscarTemporal.setRound(30);
        btnBuscarTemporal.setSizeIcon(40.0F);
        btnBuscarTemporal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarTemporal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTemporalActionPerformed(evt);
            }
        });
        jPanel5.add(btnBuscarTemporal);

        btnGastos.setText("<html><center>Gestion<br>Gastos F7</center></html>");
        btnGastos.setToolTipText("<html><center>Gasto<br>F7</center></html>");
        btnGastos.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnGastos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGastos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LOCAL_ATM);
        btnGastos.setName("btnTemporal"); // NOI18N
        btnGastos.setRound(30);
        btnGastos.setSizeIcon(40.0F);
        btnGastos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGastosActionPerformed(evt);
            }
        });
        jPanel5.add(btnGastos);

        btnPagoDeuda.setText("<html><center>Gestion<br>Deudas F8</center></html>");
        btnPagoDeuda.setToolTipText("<html><center>Gasto<br>F7</center></html>");
        btnPagoDeuda.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnPagoDeuda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPagoDeuda.setName("btnTemporal"); // NOI18N
        btnPagoDeuda.setRound(30);
        btnPagoDeuda.setSizeIcon(40.0F);
        btnPagoDeuda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPagoDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoDeudaActionPerformed(evt);
            }
        });
        jPanel5.add(btnPagoDeuda);

        btnImpresionUltima.setText("<html><center>Ultimas<br>Facturas F9</center></html>");
        btnImpresionUltima.setToolTipText("<html><center>Gasto<br>F7</center></html>");
        btnImpresionUltima.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnImpresionUltima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImpresionUltima.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.YOUTUBE_SEARCHED_FOR);
        btnImpresionUltima.setName("btnTemporal"); // NOI18N
        btnImpresionUltima.setRound(30);
        btnImpresionUltima.setSizeIcon(40.0F);
        btnImpresionUltima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImpresionUltima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImpresionUltimaActionPerformed(evt);
            }
        });
        jPanel5.add(btnImpresionUltima);

        btnGrabar.setText("<html>\n<center>\nTerminar<br>\nF10\n</center>\n</html>");
        btnGrabar.setToolTipText("<html><center>Gasto<br>F7</center></html>");
        btnGrabar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnGrabar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGrabar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DONE_ALL);
        btnGrabar.setName("btnTemporal"); // NOI18N
        btnGrabar.setRound(30);
        btnGrabar.setSizeIcon(40.0F);
        btnGrabar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });
        jPanel5.add(btnGrabar);

        btnLimpiarF12.setText("<html>\n<center>\nLimpiar<br>\nF12\n</center>\n</html>");
        btnLimpiarF12.setToolTipText("<html><center>Gasto<br>F7</center></html>");
        btnLimpiarF12.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnLimpiarF12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLimpiarF12.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLEAR_ALL);
        btnLimpiarF12.setName("btnTemporal"); // NOI18N
        btnLimpiarF12.setRound(30);
        btnLimpiarF12.setSizeIcon(40.0F);
        btnLimpiarF12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLimpiarF12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarF12ActionPerformed(evt);
            }
        });
        jPanel5.add(btnLimpiarF12);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones de busqueda"));
        jPanel6.setAutoscrolls(true);
        jPanel6.setMinimumSize(new java.awt.Dimension(0, 54));
        jPanel6.setLayout(new java.awt.GridLayout(2, 0, 10, 10));

        cbTodos.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbTodos.setText("Todas las Categorias");
        cbTodos.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));
        cbTodos.setBorderPainted(true);
        cbTodos.setBorderPaintedFlat(true);
        cbTodos.setFocusPainted(false);
        cbTodos.setFocusable(false);
        cbTodos.setMaximumSize(new java.awt.Dimension(50, 21));
        cbTodos.setMinimumSize(new java.awt.Dimension(0, 16));
        cbTodos.setPreferredSize(new java.awt.Dimension(0, 16));
        cbTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbTodosMouseClicked(evt);
            }
        });
        jPanel6.add(cbTodos);

        cbTodosProductos.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbTodosProductos.setText("Todos los Productos");
        cbTodosProductos.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));
        cbTodosProductos.setBorderPainted(true);
        cbTodosProductos.setBorderPaintedFlat(true);
        cbTodosProductos.setFocusPainted(false);
        cbTodosProductos.setFocusable(false);
        cbTodosProductos.setMinimumSize(new java.awt.Dimension(0, 16));
        cbTodosProductos.setPreferredSize(new java.awt.Dimension(0, 16));
        cbTodosProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTodosProductosActionPerformed(evt);
            }
        });
        jPanel6.add(cbTodosProductos);

        cbPrevista.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbPrevista.setSelected(true);
        cbPrevista.setText("Prevista");
        cbPrevista.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));
        cbPrevista.setBorderPainted(true);
        cbPrevista.setBorderPaintedFlat(true);
        cbPrevista.setMinimumSize(new java.awt.Dimension(0, 16));
        cbPrevista.setPreferredSize(new java.awt.Dimension(0, 16));
        jPanel6.add(cbPrevista);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

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
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jpProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N
        jpProductos.setAutoscrolls(true);
        jpProductos.setFocusCycleRoot(true);

        btnPonerTemporal1.setText("<html><center>Getion<br>Temporal F5</center></html>");
        btnPonerTemporal1.setToolTipText("<html><center>Temporal<br>F5</center></html>");
        btnPonerTemporal1.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnPonerTemporal1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPonerTemporal1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.HOURGLASS_FULL);
        btnPonerTemporal1.setName("btnTemporal"); // NOI18N
        btnPonerTemporal1.setRound(30);
        btnPonerTemporal1.setSizeIcon(40.0F);
        btnPonerTemporal1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPonerTemporal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonerTemporal1ActionPerformed(evt);
            }
        });
        jpProductos.add(btnPonerTemporal1);

        btnPonerTemporal2.setText("<html><center>Getion<br>Temporal F5</center></html>");
        btnPonerTemporal2.setToolTipText("<html><center>Temporal<br>F5</center></html>");
        btnPonerTemporal2.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnPonerTemporal2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPonerTemporal2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.HOURGLASS_FULL);
        btnPonerTemporal2.setName("btnTemporal"); // NOI18N
        btnPonerTemporal2.setRound(30);
        btnPonerTemporal2.setSizeIcon(40.0F);
        btnPonerTemporal2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPonerTemporal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonerTemporal2ActionPerformed(evt);
            }
        });
        jpProductos.add(btnPonerTemporal2);

        btnPonerTemporal3.setText("<html><center>Getion<br>Temporal F5</center></html>");
        btnPonerTemporal3.setToolTipText("<html><center>Temporal<br>F5</center></html>");
        btnPonerTemporal3.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnPonerTemporal3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPonerTemporal3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.HOURGLASS_FULL);
        btnPonerTemporal3.setName("btnTemporal"); // NOI18N
        btnPonerTemporal3.setRound(30);
        btnPonerTemporal3.setSizeIcon(40.0F);
        btnPonerTemporal3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPonerTemporal3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonerTemporal3ActionPerformed(evt);
            }
        });
        jpProductos.add(btnPonerTemporal3);

        btnPonerTemporal4.setText("<html><center>Getion<br>Temporal F5</center></html>");
        btnPonerTemporal4.setToolTipText("<html><center>Temporal<br>F5</center></html>");
        btnPonerTemporal4.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnPonerTemporal4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPonerTemporal4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.HOURGLASS_FULL);
        btnPonerTemporal4.setName("btnTemporal"); // NOI18N
        btnPonerTemporal4.setRound(30);
        btnPonerTemporal4.setSizeIcon(40.0F);
        btnPonerTemporal4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPonerTemporal4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonerTemporal4ActionPerformed(evt);
            }
        });
        jpProductos.add(btnPonerTemporal4);

        btnPonerTemporal5.setText("<html><center>Getion<br>Temporal F5</center></html>");
        btnPonerTemporal5.setToolTipText("<html><center>Temporal<br>F5</center></html>");
        btnPonerTemporal5.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnPonerTemporal5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPonerTemporal5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.HOURGLASS_FULL);
        btnPonerTemporal5.setName("btnTemporal"); // NOI18N
        btnPonerTemporal5.setRound(30);
        btnPonerTemporal5.setSizeIcon(40.0F);
        btnPonerTemporal5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPonerTemporal5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonerTemporal5ActionPerformed(evt);
            }
        });
        jpProductos.add(btnPonerTemporal5);

        btnPonerTemporal6.setText("<html><center>Getion<br>Temporal F5</center></html>");
        btnPonerTemporal6.setToolTipText("<html><center>Temporal<br>F5</center></html>");
        btnPonerTemporal6.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnPonerTemporal6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPonerTemporal6.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.HOURGLASS_FULL);
        btnPonerTemporal6.setName("btnTemporal"); // NOI18N
        btnPonerTemporal6.setRound(30);
        btnPonerTemporal6.setSizeIcon(40.0F);
        btnPonerTemporal6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPonerTemporal6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonerTemporal6ActionPerformed(evt);
            }
        });
        jpProductos.add(btnPonerTemporal6);

        jspProductos.setViewportView(jpProductos);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpBusqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addComponent(jspCategoria)
                    .addComponent(jspProductos))
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
                .addComponent(jspProductos)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                                getUsuarioActual().getPersona().getUser_name()
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
            setLayout();

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

            if (!M_Producto.existeProducto(
                    txtCriterio.getText().trim()
            )) {
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

    private void cbTodosProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTodosProductosActionPerformed
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
    }//GEN-LAST:event_cbTodosProductosActionPerformed


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

    private void btnPonerTemporalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonerTemporalActionPerformed
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
        frmPonerTemporal miTemporal = frmPonerTemporal.getInstance(
                null,
                true
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
    }//GEN-LAST:event_btnPonerTemporalActionPerformed

    private void btnBuscarTemporalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTemporalActionPerformed
        frmBuscarTemporal miTempo = new frmBuscarTemporal(null, true);
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
    }//GEN-LAST:event_btnBuscarTemporalActionPerformed

    private void btnGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGastosActionPerformed
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
            frmAutorizacion miAut = frmAutorizacion.getInstance(null, true);
            miAut.setLocationRelativeTo(null);
            miAut.setVisible(true);

            if (!miAut.isAceptado()) {
                return;
            }

            frmGasto miGasto = frmGasto.getInstance(null, true);
            miGasto.setLocationRelativeTo(null);
            miGasto.setVisible(true);

        }

        if (resp == 1) {
        }
    }//GEN-LAST:event_btnGastosActionPerformed

    private void btnPagoDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoDeudaActionPerformed
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
            frmCobrosClientes miPagoCliente
                    = frmCobrosClientes.getInstance(null, closable);
            miPagoCliente.setIdTurno(turno.getId());
            miPagoCliente.setLocationRelativeTo(null);
            miPagoCliente.setVisible(true);

            return;
        }
        if (resp == 1) {

            frmCobrosDeudas miPagoDeuda
                    = frmCobrosDeudas.getInstance(null, closable);
//            miPagoDeuda.setNombreCajero(usuario.getUser_name());
//            miPagoDeuda.setIdTurno(turno.getId());
            miPagoDeuda.setLocationRelativeTo(null);
            miPagoDeuda.setVisible(true);

        }
    }//GEN-LAST:event_btnPagoDeudaActionPerformed

    private void btnImpresionUltimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImpresionUltimaActionPerformed
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

        frmPrintFacturaConReporte2 miPrint = new frmPrintFacturaConReporte2(null, true);
        miPrint.setCopia(false);
        miPrint.setLocationRelativeTo(null);
        miPrint.setVisible(true);
    }//GEN-LAST:event_btnImpresionUltimaActionPerformed

    /**
     * Metodo encargado de grabar la factura en el sistema.
     *
     * 1) Obtenemos el numero de la factura en el sistema.
     *
     * 2) Verificamos si la factura es acredito y haya un cliente seleccionado.
     * Si esto se cumple hacemos que cajero seleccione un cliente.
     *
     * 3) TODO esta parte debe de verificar si la factura se encuentra en la bd.
     * La factura debe de ir creandose en la base de datos.
     *
     * @param evt No utilizado en este metodo.
     */
    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        Integer idFactura = Integer.valueOf(txtIdFactura.getText());
//-----------------------------------------------------------------------------1

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
//-----------------------------------------------------------------------------3

        double total = Utilidades.controlDouble(txtTotalValor.getValue());

        if (total > 0 && rbtCredito.isSelected()) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    "Limite de credito Excedido! \nDesea continuar?",
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (resp == JOptionPane.NO_OPTION) {
                return;
            } else {
                frmAutorizacion miAut = frmAutorizacion.getInstance(null, true);
                miAut.setLocationRelativeTo(null);
                miAut.setVisible(true);
                if (!miAut.isAceptado()) {
                    return;
                }
            }
        }
//-----------------------------------------------------------------------------4

        frmCalculoEfectivo miEfe = frmCalculoEfectivo.getInstance(
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
//-----------------------------------------------------------------------------5

//        char estado = rbtCredito.isSelected() ? 'c' : 'p';
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

//----------------------------------------------------------------------------
        Map<String, Integer> parametros = new HashMap<>();

        parametros.put("idFactura", idFactura);

        new hiloImpresionFactura(
                cbPrevista.isSelected(),
                rbtCredito.isSelected(),
                "/Reportes/factura.jasper",
                parametros,
                frmPrincipal.jPanelImpresion,
                frmPrincipal.jprImpresion
        ).start();
//----------------------------------------------------------------------------
        totales();

        rbtContado.doClick();
        factura.getD_factura().clear();
        nombreCliente = "";
    }//GEN-LAST:event_btnGrabarActionPerformed

    /**
     *
     * @param evt No se esta utilizando en el metodo.
     */
    private void btnLimpiarF12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarF12ActionPerformed
        frmDetalleQuitarEliminar miForm
                = frmDetalleQuitarEliminar.getInstance(
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
    }//GEN-LAST:event_btnLimpiarF12ActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        frmBusquedaCliente miBusqueda = frmBusquedaCliente.getInstance(
                null,
                true
        );
        miBusqueda.setLocationRelativeTo(null);
        miBusqueda.setVisible(true);

        Cliente cliente = miBusqueda.getCliente();

        if (cliente == null) {
            return;
        }
        getClientesCombo();

        for (int i = 0; i < cmbClientes.getItemCount(); i++) {
            if (cmbClientes.getItemAt(i).getIdPersona().equals(
                    cliente.getId()
            )) {
                cmbClientes.setSelectedIndex(i);
                break;
            }
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void formInternalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeiconified
        if (frmPrincipal.jpEstados.getComponent(0) != jpInfoFactura)
            frmPrincipal.jpEstados.add(jpInfoFactura, 0);
    }//GEN-LAST:event_formInternalFrameDeiconified

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
        if (frmPrincipal.jpEstados.getComponent(0) == jpInfoFactura)
            frmPrincipal.jpEstados.remove(jpInfoFactura);
    }//GEN-LAST:event_formInternalFrameIconified

    private void cbTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTodosMouseClicked
        categoriaR();

        //TODO Hacer que el cbTodos lea la siguiente propiedad al iniciar este frmFactura.
        getPropiedad().setProperty("cbTodosUsuario", "" + cbTodos.isSelected());

        try {
            getPropiedad().store(
                    new FileWriter(
                            new File(
                                    "properties/frmFacturaPropiedades.properties"
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
    }//GEN-LAST:event_cbTodosMouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        formInternalFrameIconified(evt);
    }//GEN-LAST:event_formInternalFrameClosed

    private void jpCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCategoriaMouseClicked
        if (evt.getClickCount() == 2)
            categoriaR();
    }//GEN-LAST:event_jpCategoriaMouseClicked

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange

    }//GEN-LAST:event_formPropertyChange

    private void btnPonerTemporal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonerTemporal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPonerTemporal1ActionPerformed

    private void btnPonerTemporal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonerTemporal2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPonerTemporal2ActionPerformed

    private void btnPonerTemporal3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonerTemporal3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPonerTemporal3ActionPerformed

    private void btnPonerTemporal4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonerTemporal4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPonerTemporal4ActionPerformed

    private void btnPonerTemporal5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonerTemporal5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPonerTemporal5ActionPerformed

    private void btnPonerTemporal6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonerTemporal6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPonerTemporal6ActionPerformed

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
                            .producto(
                                    Producto
                                            .builder()
                                            .id(
                                                    Integer.valueOf(
                                                            btn.getToolTipText()
                                                    )
                                            )
                                            .build()
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
            setLayout();

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
            setLayout();

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
                        .estado(cbTodos.isSelected())
                        .build()
        ).stream().forEach(
                categoria -> {
                    //Obteniendo la imagen de la categoria.
                    ImageIcon imagen = Utilidades.imagenDecode64(
                            categoria.getImage_texto(),
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
                                    .estado(true)
                                    .build()
                    ).stream().forEach(
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
            setLayout();
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
    private newscomponents.RSButtonGradientIcon_new btnBuscarTemporal;
    private newscomponents.RSButtonGradientIcon_new btnGastos;
    private newscomponents.RSButtonGradientIcon_new btnGrabar;
    private javax.swing.ButtonGroup btnGrupoPago;
    private newscomponents.RSButtonGradientIcon_new btnImpresionUltima;
    private newscomponents.RSButtonGradientIcon_new btnLimpiarF12;
    private newscomponents.RSButtonGradientIcon_new btnPagoDeuda;
    private newscomponents.RSButtonGradientIcon_new btnPonerTemporal;
    private newscomponents.RSButtonGradientIcon_new btnPonerTemporal1;
    private newscomponents.RSButtonGradientIcon_new btnPonerTemporal2;
    private newscomponents.RSButtonGradientIcon_new btnPonerTemporal3;
    private newscomponents.RSButtonGradientIcon_new btnPonerTemporal4;
    private newscomponents.RSButtonGradientIcon_new btnPonerTemporal5;
    private newscomponents.RSButtonGradientIcon_new btnPonerTemporal6;
    private javax.swing.JComboBox<String> cbCriterio;
    private javax.swing.JCheckBox cbPrevista;
    private javax.swing.JCheckBox cbTodos;
    private javax.swing.JCheckBox cbTodosProductos;
    private javax.swing.JComboBox<Persona> cmbClientes;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
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
