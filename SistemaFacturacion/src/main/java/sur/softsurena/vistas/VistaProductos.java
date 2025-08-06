package sur.softsurena.vistas;

import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.util.Objects;
import java.util.logging.Level;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Categoria;
import sur.softsurena.entidades.Privilegio;
import sur.softsurena.entidades.Producto;
import sur.softsurena.entidades.Paginas;
import sur.softsurena.metodos.M_Categoria;
import sur.softsurena.metodos.M_Privilegio;
import sur.softsurena.metodos.M_Producto;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public final class VistaProductos extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    private Boolean v_nuevo = null;
    private static JFileChooser file = null;
    private static FileNameExtensionFilter filter = null;
    private static String criterioBusqueda = "";
    private static VistaPrincipal principal;

    public VistaProductos() {
        initComponents();

        /*
            Si un permiso a las vistas consultada anteriormente es negado, se 
        lanza una excepcion y la venta no se iniciará.
         */
        if (!M_Privilegio.privilegio(
                Privilegio
                        .builder()
                        .privilegio(Privilegio.PRIVILEGIO_SELECT)
                        .nombre_relacion("V_PRODUCTOS")
                        .nombre_campo("^")
                        .build()
        )) {
            final String mensaje = "No cuenta con permisos para ver la información de este módulo.";

            JOptionPane.showInternalMessageDialog(
                    null,
                    mensaje,
                    "",
                    JOptionPane.WARNING_MESSAGE
            );

            LOG.log(
                    Level.SEVERE,
                    mensaje
            );

            throw new ExceptionInInitializerError(mensaje);
        }

        //Se llena la tabla de producto por primera vez. 
        llenarTablaProductos("");
        reOrdenar();
        updateCategoria();
        file = new JFileChooser();

        filter = new FileNameExtensionFilter(
                "Imagenes", "jpg", "png", "PNG", "JPG"
        );

        file.setFileFilter(filter);

        cancelar(true, true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBuscarProducto = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();
        jtpPrincipal = new javax.swing.JTabbedPane();
        jpProductos = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jsCantidadFilas = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jsPaginaNro = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new RSMaterialComponent.RSTableMetro() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jpMantenimiento = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNotas = new javax.swing.JTextArea();
        jlImagenProducto = new javax.swing.JLabel();
        txtCodigoBarra = new javax.swing.JTextField();
        cbCategoria = new javax.swing.JComboBox<>();
        txtDescripcion = new javax.swing.JTextField();
        btnAgregarFoto = new newscomponents.RSButtonGradientIcon_new();
        btnEliminarFoto = new newscomponents.RSButtonGradientIcon_new();
        cbActivo = new RSMaterialComponent.RSCheckBoxMaterial();
        jpESProductos = new javax.swing.JPanel();
        jpESHistorial = new javax.swing.JPanel();
        jpESHistorial1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmiHistorial = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiActualizarProductos = new javax.swing.JMenuItem();
        jmCategorias = new javax.swing.JMenu();
        jmiCategoriasMantenimiento = new javax.swing.JMenuItem();
        jmEntradaSalidaProductos = new javax.swing.JMenu();
        jmiEntrada = new javax.swing.JMenuItem();
        jmiSalida = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(37, 45, 223)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Productos 05.04.2025");

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Navegacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        jScrollPane3.setToolTipText("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 6, 12));

        btnNuevo.setText("Nuevo");
        btnNuevo.setIconTextGap(0);
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.INPUT);
        btnNuevo.setMaximumSize(new java.awt.Dimension(50, 17));
        btnNuevo.setMinimumSize(new java.awt.Dimension(50, 17));
        btnNuevo.setName("btnNuevo"); // NOI18N
        btnNuevo.setPreferredSize(new java.awt.Dimension(100, 30));
        btnNuevo.setRound(30);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevo);

        btnModificar.setText("Modificar");
        btnModificar.setIconTextGap(0);
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnModificar.setName("btnModificar"); // NOI18N
        btnModificar.setPreferredSize(new java.awt.Dimension(100, 30));
        btnModificar.setRound(30);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar);

        btnBorrar.setText("Borrar");
        btnBorrar.setIconTextGap(0);
        btnBorrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrar.setName("btnBorrar"); // NOI18N
        btnBorrar.setPreferredSize(new java.awt.Dimension(100, 30));
        btnBorrar.setRound(30);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar);

        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.setIconTextGap(0);
        btnBuscarProducto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FIND_IN_PAGE);
        btnBuscarProducto.setName("btnBuscar"); // NOI18N
        btnBuscarProducto.setPreferredSize(new java.awt.Dimension(100, 30));
        btnBuscarProducto.setRound(30);
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarProducto);

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setIconTextGap(0);
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.setName("btnGuardar"); // NOI18N
        btnGuardar.setPreferredSize(new java.awt.Dimension(100, 30));
        btnGuardar.setRound(30);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar);

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setIconTextGap(0);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setName("btnCancelar"); // NOI18N
        btnCancelar.setPreferredSize(new java.awt.Dimension(100, 30));
        btnCancelar.setRound(30);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar);

        jScrollPane3.setViewportView(jPanel2);

        jtpPrincipal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));
        jtpPrincipal.setName("jtpPrincipal"); // NOI18N

        jLabel1.setText("Cantidad Reg.");

        jsCantidadFilas.setModel(new javax.swing.SpinnerNumberModel(20, 10, null, 1));
        jsCantidadFilas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsCantidadFilasStateChanged(evt);
            }
        });

        jLabel2.setText("Pagina No.");

        jsPaginaNro.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jsPaginaNro.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsPaginaNroStateChanged(evt);
            }
        });

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProducto.setName("tblProducto"); // NOI18N
        tblProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblProductoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducto);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 593, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(jsCantidadFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(jsPaginaNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(0, 0, 0))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jsCantidadFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jsPaginaNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout jpProductosLayout = new javax.swing.GroupLayout(jpProductos);
        jpProductos.setLayout(jpProductosLayout);
        jpProductosLayout.setHorizontalGroup(
            jpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jpProductosLayout.setVerticalGroup(
            jpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jtpPrincipal.addTab("Productos", jpProductos);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Detalle del Producto"));

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel7.setText("* Campos Obligatorios");
        jLabel7.setToolTipText("");

        txtNotas.setColumns(20);
        txtNotas.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtNotas.setLineWrap(true);
        txtNotas.setWrapStyleWord(true);
        txtNotas.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Nota:"));
        txtNotas.setName("txtNotas"); // NOI18N
        txtNotas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNotasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNotasKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtNotas);

        jlImagenProducto.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jlImagenProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImagenProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sur/softsurena/imagenes/NoImageTransp 96 x 96.png"))); // NOI18N
        jlImagenProducto.setToolTipText("Doble click para buscar la imagen.");
        jlImagenProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Seleccione Imagen"));
        jlImagenProducto.setName("jlImagenProducto"); // NOI18N
        jlImagenProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlImagenProductoMouseClicked(evt);
            }
        });

        txtCodigoBarra.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtCodigoBarra.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "*Codigo de barra"));
        txtCodigoBarra.setName("txtCodigoBarra"); // NOI18N
        txtCodigoBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoBarraActionPerformed(evt);
            }
        });
        txtCodigoBarra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoBarraKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoBarraKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoBarraKeyTyped(evt);
            }
        });

        cbCategoria.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbCategoria.setForeground(java.awt.SystemColor.textText);
        cbCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Categorias"));
        cbCategoria.setName("cbCategoria"); // NOI18N
        cbCategoria.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbCategoriaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });
        cbCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbCategoriaKeyPressed(evt);
            }
        });

        txtDescripcion.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "*Descripcion el producto"));
        txtDescripcion.setName("txtDescripcion"); // NOI18N
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });

        btnAgregarFoto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PHOTO_SIZE_SELECT_ACTUAL);
        btnAgregarFoto.setName("btnAgregarFoto"); // NOI18N
        btnAgregarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFotoActionPerformed(evt);
            }
        });

        btnEliminarFoto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnEliminarFoto.setName("btnEliminarFoto"); // NOI18N
        btnEliminarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFotoActionPerformed(evt);
            }
        });

        cbActivo.setText("Activo");
        cbActivo.setDoubleBuffered(true);
        cbActivo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cbActivo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        cbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                            .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodigoBarra, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEliminarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jlImagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cbActivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAgregarFoto, btnEliminarFoto});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodigoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlImagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jScrollPane4.setViewportView(jPanel1);

        javax.swing.GroupLayout jpMantenimientoLayout = new javax.swing.GroupLayout(jpMantenimiento);
        jpMantenimiento.setLayout(jpMantenimientoLayout);
        jpMantenimientoLayout.setHorizontalGroup(
            jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMantenimientoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpMantenimientoLayout.setVerticalGroup(
            jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMantenimientoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Mantenimiento", jpMantenimiento);

        javax.swing.GroupLayout jpESProductosLayout = new javax.swing.GroupLayout(jpESProductos);
        jpESProductos.setLayout(jpESProductosLayout);
        jpESProductosLayout.setHorizontalGroup(
            jpESProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 888, Short.MAX_VALUE)
        );
        jpESProductosLayout.setVerticalGroup(
            jpESProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );

        jtpPrincipal.addTab("E/S Productos", jpESProductos);

        javax.swing.GroupLayout jpESHistorialLayout = new javax.swing.GroupLayout(jpESHistorial);
        jpESHistorial.setLayout(jpESHistorialLayout);
        jpESHistorialLayout.setHorizontalGroup(
            jpESHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 888, Short.MAX_VALUE)
        );
        jpESHistorialLayout.setVerticalGroup(
            jpESHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );

        jtpPrincipal.addTab("E/S Historial", jpESHistorial);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Nombre Producto:");

        txtProducto.setEditable(false);

        javax.swing.GroupLayout jpESHistorial1Layout = new javax.swing.GroupLayout(jpESHistorial1);
        jpESHistorial1.setLayout(jpESHistorial1Layout);
        jpESHistorial1Layout.setHorizontalGroup(
            jpESHistorial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpESHistorial1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jpESHistorial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(461, Short.MAX_VALUE))
        );
        jpESHistorial1Layout.setVerticalGroup(
            jpESHistorial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpESHistorial1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(447, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Control de precio", jpESHistorial1);

        jMenu1.setText("File");

        jMenu5.setText("Impreciones");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Listado de productos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jmiHistorial.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiHistorial.setText("Historial E/S");
        jmiHistorial.setName("jmiHistorial"); // NOI18N
        jmiHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiHistorialActionPerformed(evt);
            }
        });
        jMenu5.add(jmiHistorial);

        jMenu1.add(jMenu5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Opciones");

        jmiActualizarProductos.setText("Actualizar lista de productos");
        jmiActualizarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiActualizarProductosActionPerformed(evt);
            }
        });
        jMenu2.add(jmiActualizarProductos);

        jMenuBar1.add(jMenu2);

        jmCategorias.setText("Categorias");

        jmiCategoriasMantenimiento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiCategoriasMantenimiento.setText("Mantenimiento");
        jmiCategoriasMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCategoriasMantenimientoActionPerformed(evt);
            }
        });
        jmCategorias.add(jmiCategoriasMantenimiento);

        jMenuBar1.add(jmCategorias);

        jmEntradaSalidaProductos.setText("Entrada/Salida Productos");
        jmEntradaSalidaProductos.setName("jmEntradaSalidaProductos"); // NOI18N

        jmiEntrada.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiEntrada.setText("Entrada");
        jmiEntrada.setName("jmiEntrada"); // NOI18N
        jmiEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEntradaActionPerformed(evt);
            }
        });
        jmEntradaSalidaProductos.add(jmiEntrada);

        jmiSalida.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiSalida.setText("Salida");
        jmiSalida.setName("jmiSalida"); // NOI18N
        jmiSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalidaActionPerformed(evt);
            }
        });
        jmEntradaSalidaProductos.add(jmiSalida);

        jMenuBar1.add(jmEntradaSalidaProductos);

        jMenu3.setText("Control de precios");

        jMenuItem3.setText("Precios productos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtpPrincipal)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jtpPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void txtCodigoBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoBarraActionPerformed
        cbCategoria.requestFocus();
        cbCategoria.showPopup();
    }//GEN-LAST:event_txtCodigoBarraActionPerformed
    private void txtCodigoBarraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBarraKeyReleased
        String replaceAll = txtCodigoBarra.getText();
        replaceAll = replaceAll.toUpperCase();
        txtCodigoBarra.setText(replaceAll);
    }//GEN-LAST:event_txtCodigoBarraKeyReleased
    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        txtCodigoBarra.requestFocus();
    }//GEN-LAST:event_txtDescripcionActionPerformed
    private void jlImagenProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlImagenProductoMouseClicked


    }//GEN-LAST:event_jlImagenProductoMouseClicked
    private void txtCodigoBarraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBarraKeyTyped
        //TODO Debo de validar la cantidad de caracteres de todos los campos. Ejemplo
        if (txtCodigoBarra.getText().length() >= 25) {
            evt.consume();
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Este codigo debe ser menor a 25 caracteres!!!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_txtCodigoBarraKeyTyped
    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        txtDescripcion.setText(txtDescripcion.getText().toUpperCase());
    }//GEN-LAST:event_txtDescripcionKeyReleased
    private void txtNotasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNotasKeyReleased
        txtNotas.setText(txtNotas.getText().toUpperCase());
    }//GEN-LAST:event_txtNotasKeyReleased

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        txtNotas.requestFocus();
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void cbCategoriaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbCategoriaPopupMenuWillBecomeInvisible
        if (!txtDescripcion.isEditable()) {
            for (int i = 0; i < cbCategoria.getItemCount(); i++) {
                if (tblProducto.getRowCount() == 0) {
                    cbCategoria.setSelectedIndex(-1);
                    break;
                }
                if (tblProducto.getValueAt(tblProducto.getSelectedRow(), 9)
                        .toString()
                        .equals(
                                cbCategoria.getItemAt(i).getDescripcion()
                        )) {
                    cbCategoria.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_cbCategoriaPopupMenuWillBecomeInvisible

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        if (jtpPrincipal.getSelectedComponent() == jpProductos) {
            v_nuevo = true;

            jtpPrincipal.addTab("Mantenimiento", jpMantenimiento);

            cancelar(false, false);

            jtpPrincipal.setSelectedIndex(jtpPrincipal.indexOfComponent(jpMantenimiento));

            /*
            Investigamos primero si existe por lo menos una categoria registrada.
             */
            if (cbCategoria.getItemCount() <= 0) {
                updateCategoria();
                if (cbCategoria.getItemCount() <= 0) {
                    JOptionPane.showInternalMessageDialog(
                            this,
                            "Debe agregar una categoria de producto al sistema",
                            "",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
            }

            ponerImagenProducto("imagenes/NoImageTransp 96 x 96.png");

            jlImagenProducto.validate();

            cbActivo.setSelected(true);
            cbActivo.setText("Activo");

            //Vacear los txt
            txtDescripcion.setText("");
            txtCodigoBarra.setText("");
            txtNotas.setText("");

            if (cbCategoria.getItemCount() > 0) {
                cbCategoria.setSelectedIndex(0);
            }

            txtDescripcion.requestFocus();
        } else if (jtpPrincipal.getSelectedComponent() == jpMantenimiento) {

        } else if (jtpPrincipal.getSelectedComponent() == jpESProductos) {

        } else if (jtpPrincipal.getSelectedComponent() == jpESHistorial) {

        }

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jtpPrincipal.getSelectedComponent() == jpProductos) {
            //Validamos que exista un producto seleccionar.
            if (tblProducto.getSelectedRow() <= -1) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Debe seleccionar un producto.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            //Se actualiza el combo box de la categoria. 
            updateCategoria();

            //Pasamos false para habilitar los botones guardar y cancelar.
            cancelar(false, false);

            //Agregamos el jpMantenimiento y seleccionamos jTapPane de Mantenimiento
            jtpPrincipal.addTab("Mantenimiento", jpMantenimiento);

            jtpPrincipal.setSelectedIndex(jtpPrincipal.indexOfComponent(jpMantenimiento));

            jtpPrincipal.setEnabledAt(jtpPrincipal.indexOfComponent(jpProductos), false);

            //Desactivamos el Flag de registro Nuevo para realizar actualizaciones.
            v_nuevo = false;

            //Metodo utilizado para mostrar el registro del usuario seleccionado 
            //en la tabla. 
            mostrarRegistro();

            txtDescripcion.requestFocus();
        } else if (jtpPrincipal.getSelectedComponent() == jpMantenimiento) {

        } else if (jtpPrincipal.getSelectedComponent() == jpESProductos) {

        } else if (jtpPrincipal.getSelectedComponent() == jpESHistorial) {

        }


    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (jtpPrincipal.getSelectedComponent() == jpProductos) {
            Integer id = ((Producto) tblProducto.getValueAt(tblProducto.getSelectedRow(), 2)).getId();
            String descripcion = ((Producto) tblProducto.getValueAt(tblProducto.getSelectedRow(), 2)).getDescripcion();

            if (Objects.isNull(id)) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Debe seleccionar un producto.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            int rta = JOptionPane.showInternalConfirmDialog(
                    this,
                    "Esta Seguro de Eliminar el Producto {" + descripcion + "} de los Registro?",
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (rta == JOptionPane.NO_OPTION) {
                return;
            }

            Resultado resultados = M_Producto.delete(id);

            JOptionPane.showInternalMessageDialog(
                    this,
                    resultados,
                    "",
                    resultados.getIcono()
            );
            reOrdenar();
        } else if (jtpPrincipal.getSelectedComponent() == jpMantenimiento) {

        } else if (jtpPrincipal.getSelectedComponent() == jpESProductos) {

        } else if (jtpPrincipal.getSelectedComponent() == jpESHistorial) {

        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    /**
     * Este metodo se encarga de buscar un registro en la tabla de producto.
     *
     * Si nos encontramos en la session de productos, mostrando el panel de
     * jpProductos, realizamos lo siguiente.
     *
     * 1) Mandamos a actualizar la tabla. 2)
     *
     * @param evt No utilizado por el momento.
     */
    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        if (jtpPrincipal.getSelectedComponent() == jpProductos) {
            jmiActualizarProductosActionPerformed(evt);

            if (tblProducto.getRowCount() == 0) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "No hay producto registrado.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            String producto = JOptionPane.showInternalInputDialog(
                    this,
                    "Ingrese el criterio de busqueda.\n[Codigo de Barra, Descripcion, Categoria]",
                    "",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (!Objects.isNull(producto)) {
                jsPaginaNro.setValue(1);
                criterioBusqueda = producto.strip();
                llenarTablaProductos(criterioBusqueda);
                reOrdenar();
            }
        } else if (jtpPrincipal.getSelectedComponent() == jpMantenimiento) {

        } else if (jtpPrincipal.getSelectedComponent() == jpESProductos) {

        } else if (jtpPrincipal.getSelectedComponent() == jpESHistorial) {

        }


    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        System.out.println(evt.getActionCommand());

        if (jtpPrincipal.getSelectedComponent() == jpProductos) {

        } else if (jtpPrincipal.getSelectedComponent() == jpMantenimiento) {
            if (txtDescripcion.getText().isBlank()) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Debe Digitar una Descripcion...",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                txtDescripcion.requestFocus();
                return;
            }

            if (txtCodigoBarra.getText().isBlank()) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Debe Digitar un codigo",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                txtCodigoBarra.requestFocus();
                return;
            }

            //Validamos que sea proporcionada una categoria del producto
            if (cbCategoria.getSelectedIndex() <= 0) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Seleccione una categoria",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                cbCategoria.requestFocus();
                return;
            }

            // Si es nuevo validamos que el Producto no exista por su codigo de 
            //barra.
            int id = -1;

            if (v_nuevo) {
                if (!M_Producto.select(
                        Producto
                                .builder()
                                .codigo(txtCodigoBarra.getText())
                                .build()
                ).isEmpty()) {
                    JOptionPane.showInternalMessageDialog(
                            this,
                            "Codigo de barra existente en el sistema",
                            "",
                            JOptionPane.ERROR_MESSAGE
                    );
                    txtCodigoBarra.setText("");
                    txtCodigoBarra.requestFocus();
                    return;
                }
            } else {
                id = ((Producto) tblProducto.getValueAt(
                        tblProducto.getSelectedRow(),
                        2)).getId();
            }

//                    .imagen(
//                            Imagen
//                                    .builder()
//                                    .imagen64(
//                                            Utilidades
//                                                    .imagenEncode64(
//                                                            file.getSelectedFile()
//                                                    )
//                                    )
//                                    .build()
//                    )
            //Creando el objecto producto.
            Producto producto = Producto
                    .builder()
                    .id(id)
                    .idCategoria(((Categoria) cbCategoria.getSelectedItem()).getId_categoria())
                    .codigo(txtCodigoBarra.getText().strip())
                    .descripcion(txtDescripcion.getText().strip())
                    .estado(cbActivo.isSelected())
                    .nota(txtNotas.getText().strip())
                    .build();
            /*
         * La variable msg es llamada mensaje la cual servirá para dos cosa,
         * la primera es que para recoger la nota del producto, para mostrarlo 
         * en el proximo JOpcionPane y luego para almacenar el resultado de la
         * Operacion de insertar o actualizar el producto.
         * La variable editar es utilizada para ser utilizada en el siguiente 
         * JopcionPane para dar a conocer al usuario que hara una insersion o 
         * modificación.
             */
            String msg, accion = "editar";

            if (v_nuevo) {
                accion = "crear";
            }

            if (txtNotas.getText().length() >= 51) {
                msg = txtNotas.getText().substring(0, 49) + "...";
            } else {
                msg = txtNotas.getText();
            }

            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                    <html>
                        <b><big>Se va a %s el Producto: </big></b><big>%s</big> <br/>
                        <b><big>Codigo no: </big></b><big>%s</big><br/>
                        <b><big>Categoria: </big></b><big>%s</big><br/>
                        <b><big>Estado: </big></b><big>%s</big><br/>
                        <b><big>Notas: </big></b><big>%s</big><br/>
                        <b><big>Desea continuar? </big></b>
                    </html>
                    """.formatted(
                            accion,
                            txtDescripcion.getText(),
                            txtCodigoBarra.getText(),
                            ((Categoria) cbCategoria.getSelectedItem()).getDescripcion(),
                            (cbActivo.isSelected() ? "Activo" : "Inactivo"),
                            msg
                    ),
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    jlImagenProducto.getIcon());

            if (resp == JOptionPane.NO_OPTION) {
                return;
            }

            var resultados = (v_nuevo ? M_Producto.insert(producto) : M_Producto.update(producto));

            JOptionPane.showInternalMessageDialog(
                    this,
                    resultados,
                    "",
                    resultados.getIcono()
            );

            //Removemos el jpMantenimiento de la vista del usuario.
            jtpPrincipal.remove(jpMantenimiento);

            //Para inhabilitar los botones de Guardar y Cancelar. 
            cancelar(true, true);
        } else if (jtpPrincipal.getSelectedComponent() == jpESProductos) {

        } else if (jtpPrincipal.getSelectedComponent() == jpESHistorial) {

        }

    }//GEN-LAST:event_btnGuardarActionPerformed


    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (jtpPrincipal.getSelectedComponent() == jpProductos) {

        } else if (jtpPrincipal.getSelectedComponent() == jpMantenimiento) {

        } else if (jtpPrincipal.getSelectedComponent() == jpESProductos) {

        } else if (jtpPrincipal.getSelectedComponent() == jpESHistorial) {

        }
        cancelar(true, true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        txtDescripcion.setText(
                                M_Producto.generarProducto()
                        );
                    }
                }
            }
        }
    }//GEN-LAST:event_txtDescripcionKeyPressed

    private void txtCodigoBarraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBarraKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        txtCodigoBarra.setText(
                                M_Producto.generarCodigoBarra()
                        );
                    }
                }
            }
        }
    }//GEN-LAST:event_txtCodigoBarraKeyPressed

    private void cbCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCategoriaKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        int num1 = (int) (Math.random() * cbCategoria.getItemCount());
                        cbCategoria.setSelectedIndex(num1);

                        cbActivo.setSelected(((num1 % 2) == 0));

                        StringBuilder string = new StringBuilder();
                        string.append("El producto ").
                                append(txtDescripcion.getText()).
                                append(" Con el codigo de barra ").
                                append(txtCodigoBarra.getText()).
                                append(" pertenece a la categoria de producto llamado ").
                                append(((Categoria) cbCategoria.getSelectedItem()).getDescripcion()).
                                append(" con el estado actual ").
                                append((cbActivo.isSelected() ? "Activo" : "Inactivo"));

                        txtNotas.setText(string.toString());

                        ponerImagenProducto("imagenes/NoImageTransp 96 x 96.png");
                    }
                }
            }
        }
    }//GEN-LAST:event_cbCategoriaKeyPressed

    private void btnAgregarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFotoActionPerformed
        //Abrimos un dialogo para obtener la imagen del producto.
        int respuesta = file.showOpenDialog(this);

        //Cargamos la imagen en el jlImagenProducto.
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            ponerImagenProducto(file.getSelectedFile().getAbsolutePath());

        }
    }//GEN-LAST:event_btnAgregarFotoActionPerformed

    private void btnEliminarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarFotoActionPerformed

    }//GEN-LAST:event_btnEliminarFotoActionPerformed

    private void txtNotasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNotasKeyTyped
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_TAB)
            btnAgregarFoto.requestFocus();
    }//GEN-LAST:event_txtNotasKeyTyped

    private void jsCantidadFilasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsCantidadFilasStateChanged
        llenarTablaProductos(criterioBusqueda);
    }//GEN-LAST:event_jsCantidadFilasStateChanged

    private void jsPaginaNroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsPaginaNroStateChanged
        llenarTablaProductos(criterioBusqueda);
    }//GEN-LAST:event_jsPaginaNroStateChanged

    private void cbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActivoActionPerformed
        if (!txtDescripcion.isEditable()) {
            cbActivo.setSelected(!cbActivo.isSelected());
            return;
        }

        if (cbActivo.isSelected()) {
            cbActivo.setText("Activo");
        } else {
            cbActivo.setText("Inactivo");
        }
    }//GEN-LAST:event_cbActivoActionPerformed

    private void tblProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductoKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        int num1 = (int) (Math.random() * tblProducto.getRowCount());
                        if (num1 == 0) {
                            num1 = 1;
                        }
                        tblProducto.setRowSelectionInterval(num1, num1);
                    }
                }
            }
        }
    }//GEN-LAST:event_tblProductoKeyPressed

    private void jmiSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalidaActionPerformed
        if (tblProducto.getRowCount() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "No hay producto registrado",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        VistaSalidaProducto miSalida = new VistaSalidaProducto(
                null, true
        );
        miSalida.setLocationRelativeTo(this);
        miSalida.setVisible(true);
    }//GEN-LAST:event_jmiSalidaActionPerformed

    private void jmiEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEntradaActionPerformed
        if (tblProducto.getRowCount() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "No hay producto registrado",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        var miEntrada = new VistaEntradaProducto(null, true);
        miEntrada.setLocationRelativeTo(this);
        miEntrada.setVisible(true);
    }//GEN-LAST:event_jmiEntradaActionPerformed

    private void jmiHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiHistorialActionPerformed
        //TODO 02/12/2024 Se necesita mostrar el registros del historial de las
        //entradas y salidas de los productos del sistema.
    }//GEN-LAST:event_jmiHistorialActionPerformed

    private void jmiCategoriasMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCategoriasMantenimientoActionPerformed
        VistaCategorias miCategoria = new VistaCategorias(
                principal,
                true
        );

        miCategoria.setLocationRelativeTo(this);
        miCategoria.setVisible(true);

        updateCategoria();
    }//GEN-LAST:event_jmiCategoriasMantenimientoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (tblProducto.getRowCount() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "No hay producto registrado",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        try {

            JasperReport masterReporte = (JasperReport) JRLoader.loadObjectFromFile(
                    new File("reportes/productos.jasper").getPath()
            );

            JasperPrint jp = JasperFillManager.fillReport(
                    masterReporte,
                    null,
                    Conexion.getCnn()
            );

            JasperViewer miView = new JasperViewer(jp, false);
            miView.setTitle("Lista de productos del sistema actual...");
            miView.setLocationRelativeTo(this);
            miView.setVisible(true);
        } catch (JRException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmiActualizarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiActualizarProductosActionPerformed
        criterioBusqueda = "";
        llenarTablaProductos(criterioBusqueda);
        reOrdenar();
    }//GEN-LAST:event_jmiActualizarProductosActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        //TODO 01/12/2024 se necesita implementa este metodo. 
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private static void btnBotonesPrivilegios() {
        btnNuevo.setEnabled(
                M_Privilegio.privilegio(
                        Privilegio
                                .builder()
                                .privilegio(
                                        Privilegio.PRIVILEGIO_EXECUTE
                                )
                                .nombre_relacion("SP_I_PRODUCTO")
                                .nombre_campo("^")
                                .build()
                )
        );

        btnModificar.setEnabled(
                M_Privilegio.privilegio(
                        Privilegio
                                .builder()
                                .privilegio(
                                        Privilegio.PRIVILEGIO_EXECUTE
                                )
                                .nombre_relacion("SP_U_PRODUCTO")
                                .nombre_campo("^")
                                .build()
                )
        );

        btnBorrar.setEnabled(
                M_Privilegio.privilegio(
                        Privilegio
                                .builder()
                                .privilegio(
                                        Privilegio.PRIVILEGIO_EXECUTE
                                )
                                .nombre_relacion("SP_D_PRODUCTO")
                                .nombre_campo("^")
                                .build()
                )
        );

        jmiCategoriasMantenimiento.setVisible(
                M_Privilegio.privilegio(
                        Privilegio
                                .builder()
                                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
                                .nombre_relacion("SP_I_CATEGORIA")
                                .nombre_campo("^")
                                .build()
                )
        );
    }

    /**
     * Metodo utilizado para controla el comportamiento de los botones del
     * formulario.
     *
     * Dichos botones son btnNuevo, btnModificar, btnBuscarProducto, btnBorrar
     * btnGuardar, btnCancelar.
     *
     * Si este metodo es ejecutado y desea seleccionar otro JPane se debe
     * ejecutar
     * jtpUnico.setSelectedIndex(jtpUnico.indexOfComponent(NOMBRE_JPANE));
     *
     * Este metodo siempre seleccionara el jpProductos.
     *
     * @param botones
     */
    private static void cancelar(boolean botones, boolean cerrar) {
        //Botones Para habilitar:
        btnNuevo.setEnabled(botones);
        btnModificar.setEnabled(botones);
        btnBuscarProducto.setEnabled(botones);
        btnBorrar.setEnabled(botones);

        //Botones Para Deshabitar
        btnGuardar.setEnabled(!botones);
        btnCancelar.setEnabled(!botones);

        if (cerrar) {
            for (Component component : jtpPrincipal.getComponents()) {
                if (component != jpProductos) {
                    jtpPrincipal.remove(component);
                }
            }
        }

        jtpPrincipal.setSelectedIndex(jtpPrincipal.indexOfComponent(jpProductos));
        jtpPrincipal.setEnabledAt(jtpPrincipal.indexOfComponent(jpProductos), true);
    }

    /**
     * Es el metodo encargado de llenar la lista de producto del sistema. Este
     * metodo es llamado por los evento que ocurren cuando se inserta actualizan
     * o elimina un producto del sistema.
     *
     * Es llamado tambien cuando el modulo de producto se abre por primera vez.
     *
     * @param criterioBusqueda
     * @return
     */
    public static JTable llenarTablaProductos(String criterioBusqueda) {
        Objects.requireNonNull(criterioBusqueda, "No se permite nulo en el parametro.");

        // Array de String que dan nombre a las columnas de la tabla.
        String titulos[] = {
            "Codigo Producto", "Categoria", "Descripcion", "Fecha creación",
            "Estado", "Nota"
        };

        //Limpiamos todos los registro de la tabla. 
        tblProducto.removeAll();

        //Creamos un array de objectos con la longitud de los titulos de la 
        //columnas.
        Object registro[] = new Object[titulos.length];

        //Modelo que se pasará a la tablas de productos.
        DefaultTableModel miTabla = new DefaultTableModel(null, titulos);

        M_Producto.select(
                Producto
                        .builder()
                        .pagina(
                                Paginas
                                        .builder()
                                        .nCantidadFilas(
                                                Integer.valueOf(
                                                        jsCantidadFilas.getValue().toString()
                                                )
                                        )
                                        .nPaginaNro(
                                                Integer.valueOf(
                                                        jsPaginaNro.getValue().toString()
                                                )
                                        )
                                        .build()
                        )
                        .codigo(criterioBusqueda)
                        .descripcion(criterioBusqueda)
                        .build()
        ).stream().forEach(
                producto -> {
                    registro[0] = producto.getCodigo();
                    registro[1] = M_Categoria.select(
                            Categoria
                                    .builder()
                                    .id_categoria(producto.getIdCategoria())
                                    .build()
                    ).getLast();
                    registro[2] = Producto
                            .builder()
                            .id(producto.getId())
                            .descripcion(producto.getDescripcion())
                            .build();
                    registro[3] = producto.getFechaCreacion();
                    registro[4] = producto.getEstado();
                    registro[5] = producto.getNota();

                    miTabla.addRow(registro);
                }
        );

        tblProducto.setModel(miTabla);

        Utilidades.repararColumnaTable(tblProducto);

        int[] indices = {4};

        Utilidades.columnasCheckBox(tblProducto, indices);

        return tblProducto;
    }

    /**
     * Es el metodo encargado de mostrar el modulo de mantenimiento de producto
     * o registro a actualizar.
     *
     * Este metodo es llamado desde: 1) btnModificarActionPerformed
     */
    private void mostrarRegistro() {
        //Si la tabla no cuenta con registro se envian valores por defecto.
        if (tblProducto.getRowCount() <= 0) {
            return;
        }

        int id = ((Producto) tblProducto.getValueAt(
                tblProducto.getSelectedRow(),
                2
        )).getId();

        Producto producto = M_Producto.select(
                Producto
                        .builder()
                        .id(id)
                        .build()
        ).getFirst();

        txtCodigoBarra.setText(producto.getCodigo());

        txtDescripcion.setText(producto.getDescripcion());

        txtNotas.setText(producto.getNota());

        cbActivo.setSelected(producto.getEstado());

        //TODO 04/01/2024 Buscar la foto del producto.
//        jlImagenProducto.setIcon(
//                Utilidades.imagenDecode64(
//                        producto.getImagen().getImagen64(),
//                        155,
//                        155
//                )
//        );
        for (int i = 0; i < cbCategoria.getItemCount(); i++) {
            int idCategoria = cbCategoria.getItemAt(i).getId_categoria();
            if (idCategoria == producto.getIdCategoria()) {
                cbCategoria.setSelectedIndex(i);
            }
        }

    }

    /**
     * Metodo utilizado para modicar el ancho de cada columna del modulo
     * producto.
     *
     * Este metodo es llamado desde: 1) btnBorrarActionPerformed 2)
     * btnBuscarProductoActionPerformed 3) formInternalFrameOpened
     */
    private static void reOrdenar() {
        if (tblProducto.getRowCount() <= 0) {
            return;
        }

        TableColumn miTableColumn;
        int[] preAncho = {150, 300, 500, 200, 100, 300};
        int[] maxAncho = {200, 400, 800, 300, 100, 800};
        int[] minAncho = {120, 200, 100, 100, 100, 100};
        for (int i = 0; i < tblProducto.getColumnCount(); i++) {
            miTableColumn = tblProducto.getColumnModel().getColumn(i);
            miTableColumn.setPreferredWidth(preAncho[i]);
            miTableColumn.setMaxWidth(maxAncho[i]);
            miTableColumn.setMinWidth(minAncho[i]);
        }

        tblProducto.setRowSelectionInterval(0, 0);
    }

    /**
     * Metodo utilizado para actualizar el jComboBox de categorias del sistema.
     *
     * Este metodo es llamado desde: 1) btnNuevoActionPerformed 2)
     * btnModificarActionPerformed 3) btnAdmCategoriasActionPerformed 4)
     * formInternalFrameOpened
     */
    private static void updateCategoria() {
        //Elimina registros previos.
        cbCategoria.removeAllItems();

        //Agregar primer elemento con id negativo
        //Lo agregamos al comboBox.
        cbCategoria.addItem(
                Categoria
                        .builder()
                        .id_categoria(-1)
                        .descripcion("Seleccione categoria")
                        .build()
        );

        M_Categoria.select(
                Categoria
                        .builder()
                        .estado(Boolean.TRUE)
                        .build()
        ).stream().forEach(
                categoria -> {
                    cbCategoria.addItem(
                            Categoria
                                    .builder()
                                    .id_categoria(categoria.getId_categoria())
                                    .descripcion(categoria.getDescripcion())
                                    .fecha_creacion(categoria.getFecha_creacion())
                                    .build()
                    );
                }
        );
    }

    /**
     * Metodo que permite colocar una imagen en el jlImagenProducto, la cual
     * debe pasarsele por parametros un String con el path de la imagen.
     *
     * Este metodo es llamado desde: 1) btnNuevoActionPerformed 2)
     * cbCategoriaKeyPressed: solo es utilizado para pruebas del sistema. 3)
     * btnAgregarFotoActionPerformed
     *
     * @param file representa la ruta de la imagen en el sistema.
     */
    private void ponerImagenProducto(String file) {
        ImageIcon imagen = new ImageIcon(file);

        Icon icon = new ImageIcon(
                imagen.getImage().getScaledInstance(
                        155, 155, Image.SCALE_SMOOTH
                )
        );

        imagen.getImage().flush();

        jlImagenProducto.setIcon(icon);

        jlImagenProducto.validate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonGradientIcon_new btnAgregarFoto;
    private static RSMaterialComponent.RSButtonMaterialIconOne btnBorrar;
    private static RSMaterialComponent.RSButtonMaterialIconOne btnBuscarProducto;
    public static RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private newscomponents.RSButtonGradientIcon_new btnEliminarFoto;
    private static RSMaterialComponent.RSButtonMaterialIconOne btnGuardar;
    private static RSMaterialComponent.RSButtonMaterialIconOne btnModificar;
    private static RSMaterialComponent.RSButtonMaterialIconOne btnNuevo;
    private RSMaterialComponent.RSCheckBoxMaterial cbActivo;
    private static javax.swing.JComboBox<Categoria> cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jlImagenProducto;
    private javax.swing.JMenu jmCategorias;
    private javax.swing.JMenu jmEntradaSalidaProductos;
    private javax.swing.JMenuItem jmiActualizarProductos;
    private static javax.swing.JMenuItem jmiCategoriasMantenimiento;
    private javax.swing.JMenuItem jmiEntrada;
    private javax.swing.JMenuItem jmiHistorial;
    private javax.swing.JMenuItem jmiSalida;
    private javax.swing.JPanel jpESHistorial;
    private javax.swing.JPanel jpESHistorial1;
    private javax.swing.JPanel jpESProductos;
    private javax.swing.JPanel jpMantenimiento;
    private static javax.swing.JPanel jpProductos;
    private static javax.swing.JSpinner jsCantidadFilas;
    private static javax.swing.JSpinner jsPaginaNro;
    private static javax.swing.JTabbedPane jtpPrincipal;
    public static javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtCodigoBarra;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextArea txtNotas;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables

}

/**
 * btnNuevoActionPerformed tenemos las siguiente logica: <br>
 * 1) Cambiamos a true el flag nuevo. X<br>
 * 2) En el jtpPrincipal agrega el jpMantenimiento enseguida cambia a este.
 * X<br>
 * 3) El metodo cancelar inhabilita los botones Nuevo, Editar, Borrar y Buscar.
 * X<br>
 * Y habilita los botones de guardar y cancelar. X<br>
 * 4) Luego el jtpPrincipal selecciona el jpMantenimiento para mostrar. X<br>
 * 5) Se valida que existan categorias en el sistema. X<br>
 * 6) Se coloca la imagen predeterminada. X<br>
 * 7) Se coloca el estado del producto true de forma predeterminada. X<br>
 * 8) Se limpian los campos descripcion, codigo de barra, nota. X<br>
 * 9) El campo de la categoria se coloca en el index cero. X<br>
 *
 *
 * btnModificarActionPerformed tenemos las siguiente logica:<br>
 * 1) Se valida que se tenga un registro seleccionado, en caso contrario <br>
 * Muestra un mensaje de error. X<br>
 * 2) Guardamos la fila seleccionada en la variable v_fila. X<br>
 * 3) Actualizamos las categorias registradas en el sistema. X <br>
 * 4) Del punto 3 anterior es aplicado aqui.X <br>
 * 5) Se agrega el jpMantenimiento y de inmediato se selecciona. X <br>
 * 6) La variable v_nueva se le da valor de false. X <br>
 * 7) Se manda a llamar el metodo mostrarRegistro(). X <br>
 * 8) El campo descripcion hace la peticion de focus. X <br>
 *
 * Nota:
 *
 */
