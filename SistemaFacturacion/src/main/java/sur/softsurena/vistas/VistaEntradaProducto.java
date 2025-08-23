package sur.softsurena.vistas;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lombok.Getter;
import sur.softsurena.entidades.Almacen;
import sur.softsurena.entidades.EntradaProducto;
import sur.softsurena.entidades.Proveedor;
import sur.softsurena.metodos.M_Almacen;
import sur.softsurena.metodos.M_Entrada_Producto;
import sur.softsurena.metodos.M_Persona;
import sur.softsurena.metodos.M_Proveedor;

@Getter
public final class VistaEntradaProducto extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;

    private VistaBusquedaProducto miBusqueda;
    private final Boolean impuesto = false;
    private transient EntradaProducto entradaProducto;
    private boolean nuevo;

    public VistaEntradaProducto(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        btnCancelar.setVisible(false);
        jtpGeneral.remove(jpRegistrarEntradas);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtpGeneral = new javax.swing.JTabbedPane();
        javax.swing.JPanel jpRegistrosEntradas = new javax.swing.JPanel();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        tblEntradaProducto = new RSMaterialComponent.RSTableMetro();
        jpRegistrarEntradas = new javax.swing.JPanel();
        rojeru_san.rslabel.RSLabelAnimated jlTitulo = new rojeru_san.rslabel.RSLabelAnimated();
        javax.swing.JPanel jPanel4 = new javax.swing.JPanel();
        jcbProveedor = new javax.swing.JComboBox<>();
        rojeru_san.rsdate.RSLabelFecha rSLabelFecha1 = new rojeru_san.rsdate.RSLabelFecha();
        jcbAlmacen = new javax.swing.JComboBox<>();
        rojeru_san.rsdate.RSLabelHora rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        newscomponents.RSButtonGradientIcon_new btnAgregarDetalles = new newscomponents.RSButtonGradientIcon_new();
        btnAlmacen = new newscomponents.RSButtonGradientIcon_new();
        btnProveedor = new newscomponents.RSButtonGradientIcon_new();
        txtCodigoFactura = new necesario.TextField();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        rojeru_san.complementos.TableMetro tableMetro1 = new rojeru_san.complementos.TableMetro();
        javax.swing.JPanel jpBotones = new javax.swing.JPanel();
        newscomponents.RSButtonGradientIcon_new btnNuevaEntrada = new newscomponents.RSButtonGradientIcon_new();
        newscomponents.RSButtonGradientIcon_new btnModificarEntrada = new newscomponents.RSButtonGradientIcon_new();
        btnCancelar = new newscomponents.RSButtonGradientIcon_new();
        newscomponents.RSButtonGradientIcon_new btnFinalizar = new newscomponents.RSButtonGradientIcon_new();
        newscomponents.RSButtonGradientIcon_new btnModificarEntrada1 = new newscomponents.RSButtonGradientIcon_new();
        newscomponents.RSButtonGradientIcon_new btnModificarEntrada2 = new newscomponents.RSButtonGradientIcon_new();
        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        javax.swing.JMenu jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Entrada de producto del sistema");
        setName("Form"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jtpGeneral.setName("jtpGeneral"); // NOI18N

        jpRegistrosEntradas.setName("jpRegistrosEntradas"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        tblEntradaProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEntradaProducto.setName("tblEntradaProducto"); // NOI18N
        jScrollPane2.setViewportView(tblEntradaProducto);

        javax.swing.GroupLayout jpRegistrosEntradasLayout = new javax.swing.GroupLayout(jpRegistrosEntradas);
        jpRegistrosEntradas.setLayout(jpRegistrosEntradasLayout);
        jpRegistrosEntradasLayout.setHorizontalGroup(
            jpRegistrosEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistrosEntradasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jpRegistrosEntradasLayout.setVerticalGroup(
            jpRegistrosEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistrosEntradasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpGeneral.addTab("Registros de entradas", jpRegistrosEntradas);

        jpRegistrarEntradas.setName("jpRegistrarEntradas"); // NOI18N

        jlTitulo.setText("Registrar entradas de productos al sistema.");
        jlTitulo.setFont(new java.awt.Font("FreeMono", 1, 24)); // NOI18N
        jlTitulo.setName("jlTitulo"); // NOI18N

        jPanel4.setName("jPanel4"); // NOI18N

        jcbProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Seleccione Proveedor"));
        jcbProveedor.setName("jcbProveedor"); // NOI18N

        rSLabelFecha1.setName("rSLabelFecha1"); // NOI18N

        jcbAlmacen.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Almacen"));
        jcbAlmacen.setName("jcbAlmacen"); // NOI18N
        jcbAlmacen.addActionListener(this::jcbAlmacenActionPerformed);

        rSLabelHora1.setName("rSLabelHora1"); // NOI18N

        btnAgregarDetalles.setText("Agregar detalle");
        btnAgregarDetalles.setColorPrimario(new java.awt.Color(0, 255, 73));
        btnAgregarDetalles.setColorPrimarioHover(new java.awt.Color(63, 186, 68));
        btnAgregarDetalles.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnAgregarDetalles.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAgregarDetalles.setName("btnAgregarDetalles"); // NOI18N
        btnAgregarDetalles.addActionListener(this::btnAgregarDetallesActionPerformed);

        btnAlmacen.setColorPrimario(new java.awt.Color(0, 255, 73));
        btnAlmacen.setColorPrimarioHover(new java.awt.Color(63, 186, 68));
        btnAlmacen.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnAlmacen.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnAlmacen.setName("btnAlmacen"); // NOI18N
        btnAlmacen.addActionListener(this::btnAlmacenActionPerformed);

        btnProveedor.setColorPrimario(new java.awt.Color(0, 255, 73));
        btnProveedor.setColorPrimarioHover(new java.awt.Color(63, 186, 68));
        btnProveedor.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnProveedor.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnProveedor.setName("btnProveedor"); // NOI18N
        btnProveedor.addActionListener(this::btnProveedorActionPerformed);

        txtCodigoFactura.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));
        txtCodigoFactura.setMayusculas(true);
        txtCodigoFactura.setName("txtCodigoFactura"); // NOI18N
        txtCodigoFactura.setOpaque(true);
        txtCodigoFactura.setPlaceholder("Ingrese Numero / Codigo de factura");
        txtCodigoFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoFacturaFocusGained(evt);
            }
        });
        txtCodigoFactura.addActionListener(this::txtCodigoFacturaActionPerformed);
        txtCodigoFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoFacturaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jcbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCodigoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAgregarDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jcbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {rSLabelFecha1, rSLabelHora1, txtCodigoFactura});

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tableMetro1.setModel(new javax.swing.table.DefaultTableModel(
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
        tableMetro1.setName("tableMetro1"); // NOI18N
        jScrollPane1.setViewportView(tableMetro1);

        javax.swing.GroupLayout jpRegistrarEntradasLayout = new javax.swing.GroupLayout(jpRegistrarEntradas);
        jpRegistrarEntradas.setLayout(jpRegistrarEntradasLayout);
        jpRegistrarEntradasLayout.setHorizontalGroup(
            jpRegistrarEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistrarEntradasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpRegistrarEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
                    .addGroup(jpRegistrarEntradasLayout.createSequentialGroup()
                        .addGroup(jpRegistrarEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        jpRegistrarEntradasLayout.setVerticalGroup(
            jpRegistrarEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistrarEntradasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );

        jlTitulo.timer.setDelay(500);

        jtpGeneral.addTab("Registrar Entradas", jpRegistrarEntradas);

        jpBotones.setName("jpBotones"); // NOI18N

        btnNuevaEntrada.setText("Nuevo");
        btnNuevaEntrada.setColorPrimario(new java.awt.Color(0, 255, 73));
        btnNuevaEntrada.setColorPrimarioHover(new java.awt.Color(63, 186, 68));
        btnNuevaEntrada.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnNuevaEntrada.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevaEntrada.setName("btnNuevaEntrada"); // NOI18N
        btnNuevaEntrada.addActionListener(this::btnNuevaEntradaActionPerformed);

        btnModificarEntrada.setText("Modificar");
        btnModificarEntrada.setColorPrimario(new java.awt.Color(0, 255, 73));
        btnModificarEntrada.setColorPrimarioHover(new java.awt.Color(63, 186, 68));
        btnModificarEntrada.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnModificarEntrada.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
        btnModificarEntrada.setName("btnModificarEntrada"); // NOI18N
        btnModificarEntrada.addActionListener(this::btnModificarEntradaActionPerformed);

        btnCancelar.setText("Cancelar");
        btnCancelar.setColorPrimario(new java.awt.Color(237, 16, 37));
        btnCancelar.setColorPrimarioHover(new java.awt.Color(234, 70, 75));
        btnCancelar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setName("btnCancelar"); // NOI18N
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        btnFinalizar.setText("Finalizar");
        btnFinalizar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnFinalizar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DONE);
        btnFinalizar.setName("btnFinalizar"); // NOI18N
        btnFinalizar.addActionListener(this::btnFinalizarActionPerformed);

        btnModificarEntrada1.setText("Borrar");
        btnModificarEntrada1.setColorPrimario(new java.awt.Color(0, 255, 73));
        btnModificarEntrada1.setColorPrimarioHover(new java.awt.Color(63, 186, 68));
        btnModificarEntrada1.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnModificarEntrada1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnModificarEntrada1.setName("btnModificarEntrada1"); // NOI18N
        btnModificarEntrada1.addActionListener(this::btnModificarEntrada1ActionPerformed);

        btnModificarEntrada2.setText("Buscar");
        btnModificarEntrada2.setColorPrimario(new java.awt.Color(0, 255, 73));
        btnModificarEntrada2.setColorPrimarioHover(new java.awt.Color(63, 186, 68));
        btnModificarEntrada2.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnModificarEntrada2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnModificarEntrada2.setName("btnModificarEntrada2"); // NOI18N
        btnModificarEntrada2.addActionListener(this::btnModificarEntrada2ActionPerformed);

        javax.swing.GroupLayout jpBotonesLayout = new javax.swing.GroupLayout(jpBotones);
        jpBotones.setLayout(jpBotonesLayout);
        jpBotonesLayout.setHorizontalGroup(
            jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificarEntrada1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificarEntrada2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpBotonesLayout.setVerticalGroup(
            jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarEntrada1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarEntrada2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jMenuBar1.setName("jMenuBar1"); // NOI18N

        jMenu1.setText("[...]");
        jMenu1.setName("jMenu1"); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setText("[ ... ]");
        jMenu2.setName("jMenu2"); // NOI18N
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtpGeneral)
                    .addComponent(jpBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtpGeneral)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarTabla();
        llenarAlmacen();
        llenarProveedores();
    }//GEN-LAST:event_formWindowOpened

    private void txtCodigoFacturaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txtCodigoFacturaActionPerformed

    }//GEN-LAST:event_txtCodigoFacturaActionPerformed

    private void txtCodigoFacturaKeyReleased(KeyEvent evt) {//GEN-FIRST:event_txtCodigoFacturaKeyReleased
        //txtNumeroFactura.setText(txtNumeroFactura.getText().toUpperCase());
    }//GEN-LAST:event_txtCodigoFacturaKeyReleased

    private void txtCodigoFacturaFocusGained(FocusEvent evt) {//GEN-FIRST:event_txtCodigoFacturaFocusGained
        txtCodigoFactura.selectAll();
    }//GEN-LAST:event_txtCodigoFacturaFocusGained

    private void btnNuevaEntradaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNuevaEntradaActionPerformed
        mostrarRegistroEntrada();
        
        estadoComponentes(true);
        btnCancelar.setVisible(true);
    }//GEN-LAST:event_btnNuevaEntradaActionPerformed

    private void btnCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        jtpGeneral.remove(jpRegistrarEntradas);
        btnCancelar.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnProveedorActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnAlmacenActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnAlmacenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlmacenActionPerformed

    private void jcbAlmacenActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jcbAlmacenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbAlmacenActionPerformed

    private void btnModificarEntradaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnModificarEntradaActionPerformed
        if (tblEntradaProducto.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe seleccionar registro de la tabla",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        estadoComponentes(false);
        
        mostrarRegistroEntrada();
        entradaProducto = ((EntradaProducto) tblEntradaProducto.getValueAt(
                tblEntradaProducto.getSelectedRow(),
                0
        ));
        

        btnCancelar.setVisible(true);
    }//GEN-LAST:event_btnModificarEntradaActionPerformed

    private void btnFinalizarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        dispose();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnAgregarDetallesActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnAgregarDetallesActionPerformed

    }//GEN-LAST:event_btnAgregarDetallesActionPerformed

    private void btnModificarEntrada1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnModificarEntrada1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarEntrada1ActionPerformed

    private void btnModificarEntrada2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnModificarEntrada2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarEntrada2ActionPerformed

    /*
    private void quitarImagen() {
        ImageIcon imagen = new ImageIcon("sur/softsurena/imagenes/NoImageTransp 96 x 96.png");
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(72, 72,
                Image.SCALE_DEFAULT));
        imagen.getImage().flush();

    }*/
    private void llenarProveedores() {
        jcbProveedor.removeAllItems();
        M_Proveedor.select(
                Proveedor
                        .builder()
                        .build()
        ).stream().forEach(
                proveedor -> {
                    jcbProveedor.addItem(proveedor);
                }
        );
    }

    private void llenarAlmacen() {
        jcbAlmacen.removeAllItems();
        M_Almacen.select(
                Almacen
                        .builder()
                        .build()
        ).stream().forEach(
                almacen -> {
                    jcbAlmacen.addItem(almacen);
                }
        );
    }

    private void llenarTabla() {

        String titulos[] = {
            "Codigo Entrada", "Proveedor", "Almacen", "Fecha Entrada"
        };
        Object registro[] = new Object[titulos.length];
        DefaultTableModel dtmEntradaProducto = new DefaultTableModel(null, titulos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        M_Entrada_Producto.select(
                EntradaProducto.builder().build()
        ).stream().forEach(
                $entradaProducto -> {
                    registro[0] = $entradaProducto;
                    registro[1] = M_Persona.select(
                            Proveedor
                                    .builder()
                                    .idPersona($entradaProducto.getIdProveedor())
                                    .build()
                    ).stream().findFirst().orElse(
                            Proveedor
                                    .builder()
                                    .pnombre("Persona No encontrada.")
                                    .snombre("")
                                    .apellidos("")
                                    .build()
                    );
                    registro[2] = M_Almacen.select(
                            Almacen
                                    .builder()
                                    .id($entradaProducto.getIdAlmacen())
                                    .build()
                    ).stream().findFirst().orElse(
                            Almacen
                                    .builder()
                                    .nombre("Almacen no encontrado.")
                                    .build()
                    );
                    registro[3] = $entradaProducto.getFechaEntrada();

                    dtmEntradaProducto.addRow(registro);
                }
        );
        tblEntradaProducto.setModel(dtmEntradaProducto);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    newscomponents.RSButtonGradientIcon_new btnAlmacen;
    newscomponents.RSButtonGradientIcon_new btnCancelar;
    newscomponents.RSButtonGradientIcon_new btnProveedor;
    javax.swing.JComboBox<Almacen> jcbAlmacen;
    javax.swing.JComboBox<Proveedor> jcbProveedor;
    javax.swing.JPanel jpRegistrarEntradas;
    javax.swing.JTabbedPane jtpGeneral;
    RSMaterialComponent.RSTableMetro tblEntradaProducto;
    necesario.TextField txtCodigoFactura;
    // End of variables declaration//GEN-END:variables

    private void mostrarRegistroEntrada() {
        jtpGeneral.add(jpRegistrarEntradas, 1);
        jtpGeneral.setTitleAt(1, "Registros de entradas");
        jtpGeneral.setSelectedComponent(jpRegistrarEntradas);
    }

    private void estadoComponentes(boolean estado) {
        btnProveedor.setEnabled(estado);
        btnAlmacen.setEnabled(estado);
        jcbAlmacen.setEnabled(estado);
        jcbProveedor.setEnabled(estado);
    }
}
