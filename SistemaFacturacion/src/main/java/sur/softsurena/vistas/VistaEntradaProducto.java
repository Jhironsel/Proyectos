package sur.softsurena.vistas;

import sur.softsurena.vista.VistaBusquedaProducto;
import java.awt.Frame;
import javax.swing.table.DefaultTableModel;
import lombok.Getter;
import sur.softsurena.abstracta.Persona;
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
        jlTitulo.timer.setDelay(500);
        jTabbedPane1.remove(jpRegistrarEntradas);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpRegistrosEntradas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEntradaProducto = new RSMaterialComponent.RSTableMetro();
        jpRegistrarEntradas = new javax.swing.JPanel();
        jlTitulo = new rojeru_san.rslabel.RSLabelAnimated();
        jPanel4 = new javax.swing.JPanel();
        jcbProveedor = new javax.swing.JComboBox<>();
        rSLabelFecha1 = new rojeru_san.rsdate.RSLabelFecha();
        jcbAlmacen = new javax.swing.JComboBox<>();
        rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        btnAgregar1 = new newscomponents.RSButtonGradientIcon_new();
        btnAlmacen = new newscomponents.RSButtonGradientIcon_new();
        btnProveedor = new newscomponents.RSButtonGradientIcon_new();
        txtCodigoFactura = new necesario.TextField();
        jPanel3 = new javax.swing.JPanel();
        btnAgregar = new newscomponents.RSButtonGradientIcon_new();
        btnCancelar = new newscomponents.RSButtonGradientIcon_new();
        btnFinalizar = new newscomponents.RSButtonGradientIcon_new();
        btnModificar = new newscomponents.RSButtonGradientIcon_new();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Entrada de producto del sistema");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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
        jScrollPane2.setViewportView(tblEntradaProducto);

        javax.swing.GroupLayout jpRegistrosEntradasLayout = new javax.swing.GroupLayout(jpRegistrosEntradas);
        jpRegistrosEntradas.setLayout(jpRegistrosEntradasLayout);
        jpRegistrosEntradasLayout.setHorizontalGroup(
            jpRegistrosEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistrosEntradasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jpRegistrosEntradasLayout.setVerticalGroup(
            jpRegistrosEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistrosEntradasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Registros de entradas", jpRegistrosEntradas);

        jlTitulo.setText("Registrar entradas de productos al sistema.");
        jlTitulo.setFont(new java.awt.Font("FreeMono", 1, 24)); // NOI18N

        jcbProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Seleccione Proveedor"));

        jcbAlmacen.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Almacen"));
        jcbAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlmacenActionPerformed(evt);
            }
        });

        btnAgregar1.setText("Agregar detalle");
        btnAgregar1.setColorPrimario(new java.awt.Color(0, 255, 73));
        btnAgregar1.setColorPrimarioHover(new java.awt.Color(63, 186, 68));
        btnAgregar1.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnAgregar1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });

        btnAlmacen.setColorPrimario(new java.awt.Color(0, 255, 73));
        btnAlmacen.setColorPrimarioHover(new java.awt.Color(63, 186, 68));
        btnAlmacen.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnAlmacen.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlmacenActionPerformed(evt);
            }
        });

        btnProveedor.setColorPrimario(new java.awt.Color(0, 255, 73));
        btnProveedor.setColorPrimarioHover(new java.awt.Color(63, 186, 68));
        btnProveedor.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnProveedor.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        txtCodigoFactura.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));
        txtCodigoFactura.setMayusculas(true);
        txtCodigoFactura.setOpaque(true);
        txtCodigoFactura.setPlaceholder("Ingrese Numero / Codigo de factura");
        txtCodigoFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoFacturaFocusGained(evt);
            }
        });
        txtCodigoFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoFacturaActionPerformed(evt);
            }
        });
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
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jcbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jcbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtCodigoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jcbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSLabelHora1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(rSLabelFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {rSLabelFecha1, rSLabelHora1, txtCodigoFactura});

        javax.swing.GroupLayout jpRegistrarEntradasLayout = new javax.swing.GroupLayout(jpRegistrarEntradas);
        jpRegistrarEntradas.setLayout(jpRegistrarEntradasLayout);
        jpRegistrarEntradasLayout.setHorizontalGroup(
            jpRegistrarEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistrarEntradasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpRegistrarEntradasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpRegistrarEntradasLayout.setVerticalGroup(
            jpRegistrarEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistrarEntradasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registrar Entradas", jpRegistrarEntradas);

        btnAgregar.setText("Agregar");
        btnAgregar.setColorPrimario(new java.awt.Color(0, 255, 73));
        btnAgregar.setColorPrimarioHover(new java.awt.Color(63, 186, 68));
        btnAgregar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnAgregar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setColorPrimario(new java.awt.Color(237, 16, 37));
        btnCancelar.setColorPrimarioHover(new java.awt.Color(234, 70, 75));
        btnCancelar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnFinalizar.setText("Finalizar");
        btnFinalizar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnFinalizar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DONE);
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setColorPrimario(new java.awt.Color(0, 255, 73));
        btnModificar.setColorPrimarioHover(new java.awt.Color(63, 186, 68));
        btnModificar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnFinalizar});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarTabla();
        llenarAlmacen();
        llenarProveedores();
    }//GEN-LAST:event_formWindowOpened

    private void txtCodigoFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoFacturaActionPerformed

    }//GEN-LAST:event_txtCodigoFacturaActionPerformed

    private void txtCodigoFacturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoFacturaKeyReleased
        //txtNumeroFactura.setText(txtNumeroFactura.getText().toUpperCase());
    }//GEN-LAST:event_txtCodigoFacturaKeyReleased

    private void txtCodigoFacturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoFacturaFocusGained
        txtCodigoFactura.selectAll();
    }//GEN-LAST:event_txtCodigoFacturaFocusGained

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        jTabbedPane1.add(jpRegistrarEntradas, 1);
        jTabbedPane1.setTitleAt(1, "Registros de entradas");
        jTabbedPane1.setSelectedComponent(jpRegistrarEntradas);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        for (int i = 0; i < tblEntradaProducto.getRowCount(); i++) {
//            if (!agregarProductoEntrada(
//                new VistaEntradaProducto(
//                    Integer.valueOf(txtNumero.getText()),
//                    ((Categoria) tbArticulos.getValueAt(i, 0)).getIdProducto(),
//                    null,
//                    (i + 1),
//                    txtNumeroFactura.getText(),
//                    "N/A",
//                    new BigDecimal(tbArticulos.getValueAt(i, 2).toString()),
//                    null,
//                    null,
//                    '+',
//                    new BigDecimal(tbArticulos.getValueAt(i, 3).toString()),
//                    new BigDecimal(tbArticulos.getValueAt(i, 4).toString()),
//                    Boolean.valueOf(tbArticulos.getValueAt(i, 5).toString()),
//                    new BigDecimal(tbArticulos.getValueAt(i, 6).toString())
//                )
//            )) {
//                JOptionPane.showMessageDialog(this, "No se pudo registrar producto");
//                return;
//            }
        }

        //        Map<String, Object> parametros = new HashMap<>();
        //        parametros.put("operacion", Integer.parseInt(txtNumero.getText()));
        //        hiloImpresionFactura miHilo = new hiloImpresionFactura(
        //                true, //Mostrar Reporte
        //                false, //Con Copia
        //                "Reportes/entrada.jasper",
        //                parametros);
        //        miHilo.start();
        btnCancelar.doClick();

    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed

        if (nuevo) {

        } else {
            if (tblEntradaProducto.getSelectedRow() == -1) {
                return;
            }
            entradaProducto = ((EntradaProducto) tblEntradaProducto.getValueAt(
                    tblEntradaProducto.getSelectedRow(),
                    0
            ));
            VistaDetalleEntradasProductos dep
                    = new VistaDetalleEntradasProductos(null, true, entradaProducto);
            dep.setVisible(true);
            dep.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlmacenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlmacenActionPerformed

    private void jcbAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlmacenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbAlmacenActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

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
                            Persona
                                    .builder()
                                    .idPersona($entradaProducto.getIdProveedor())
                                    .build()
                    ).stream().findFirst().orElse(
                            Persona
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
    private newscomponents.RSButtonGradientIcon_new btnAgregar;
    private newscomponents.RSButtonGradientIcon_new btnAgregar1;
    private newscomponents.RSButtonGradientIcon_new btnAlmacen;
    private newscomponents.RSButtonGradientIcon_new btnCancelar;
    private newscomponents.RSButtonGradientIcon_new btnFinalizar;
    private newscomponents.RSButtonGradientIcon_new btnModificar;
    private newscomponents.RSButtonGradientIcon_new btnProveedor;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<Almacen> jcbAlmacen;
    private javax.swing.JComboBox<Proveedor> jcbProveedor;
    private rojeru_san.rslabel.RSLabelAnimated jlTitulo;
    private javax.swing.JPanel jpRegistrarEntradas;
    private javax.swing.JPanel jpRegistrosEntradas;
    private rojeru_san.rsdate.RSLabelFecha rSLabelFecha1;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    private RSMaterialComponent.RSTableMetro tblEntradaProducto;
    private necesario.TextField txtCodigoFactura;
    // End of variables declaration//GEN-END:variables
}
