package sur.softsurena.vistas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.entidades.Generales;
import sur.softsurena.hilos.hiloImpresionFactura;
import sur.softsurena.metodos.M_Cliente;
import sur.softsurena.metodos.M_Generales;
import sur.softsurena.utilidades.DefaultTableCellHeaderRenderer;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.LOG;

public final class VistaDetalleFacturaClientes extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    private DefaultTableModel miTabla, miTabla2, miTabla3;
    private TableColumn miTableColumn = null;
    private final DefaultTableCellRenderer tcr;
    
    public VistaDetalleFacturaClientes() {
        initComponents();
        tcr = new DefaultTableCellHeaderRenderer();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgrTipoBusqueda = new javax.swing.ButtonGroup();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDetalleFactura = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        jPanel3 = new javax.swing.JPanel();
        btnSalir = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnImprimir = new RSMaterialComponent.RSButtonMaterialIconOne();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtCriterio = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        jScrollPane7 = new javax.swing.JScrollPane();
        tblFactura = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Detalle de los Clientes");
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

        jScrollPane4.setBorder(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles de Factura Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        tblDetalleFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDetalleFactura.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDetalleFactura.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblDetalleFactura);

        jPanel3.setLayout(new java.awt.GridLayout(1, 4, 8, 0));

        btnSalir.setText("Salir");
        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXIT_TO_APP);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalir);

        btnImprimir.setText("Imprimir");
        btnImprimir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnImprimir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PRINT);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel3.add(btnImprimir);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Total:");
        jPanel3.add(jLabel4);

        txtTotal.setEditable(false);
        txtTotal.setForeground(new java.awt.Color(0, 0, 255));
        txtTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        txtTotal.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtTotal.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jPanel3.add(txtTotal);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane4.setViewportView(jPanel1);

        jPanel5.setLayout(new java.awt.GridLayout(1, 1));

        txtCriterio.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Campo de busqueda"));
        txtCriterio.setOpaque(true);
        txtCriterio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCriterioActionPerformed(evt);
            }
        });
        txtCriterio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioKeyReleased(evt);
            }
        });
        jPanel5.add(txtCriterio);

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblClientes.setToolTipText("Doble click para buscar factura");
        tblClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblClientes.getTableHeader().setReorderingAllowed(false);
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblClientes);

        tblFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFactura.setToolTipText("Doble Click para imprimir la factura");
        tblFactura.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblFactura.getTableHeader().setReorderingAllowed(false);
        tblFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFacturaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblFactura);

        jRadioButton1.setText("Cedula");
        jRadioButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));
        jRadioButton1.setBorderPainted(true);

        jRadioButton2.setText("Nombres y Apellidos");
        jRadioButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));
        jRadioButton2.setBorderPainted(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jRadioButton1, jRadioButton2});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        tablaClientes();
    }//GEN-LAST:event_formInternalFrameOpened

    private void tblFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFacturaMouseClicked
        String idFactura = tblFactura.getValueAt(tblFactura.getSelectedRow(), 0).toString();
        DefaultTableModel modelo = (DefaultTableModel) tblDetalleFactura.getModel();
        int filas = tblDetalleFactura.getRowCount();
        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }
        String sql = """
                     SELECT factura.idFactura, factura.idCliente, nombres||' '||apellidos AS nombreFull,
                     fecha, idLinea, (select p.Descripcion
                                        from PRODUCTOS p
                                        where p.idProducto = DETALLEFACTURA.IDPRODUCTO ) as Descripcion,
                     idProducto, precio, cantidad, precio * cantidad AS Valor
                     FROM factura
                     INNER JOIN cliente ON factura.idCliente = cliente.idCliente
                     INNER JOIN detalleFactura ON factura.idFactura = detalleFactura.idFactura
                     WHERE factura.idFactura ='idFactura';
                     """;
        try {
            ResultSet rs = null;

            String registro[] = new String[5];

            double suma = 0;

            while (rs.next()) {
                registro[0] = rs.getString("idProducto");
                registro[1] = rs.getString("descripcion");
                registro[2] = "$ " + Utilidades.priceWithDecimal(
                        Double.parseDouble(Utilidades.priceWithDecimal(
                                rs.getDouble("precio"))));
                registro[3] = rs.getString("cantidad");
                suma += Double.parseDouble(Utilidades.priceWithDecimal(
                        rs.getDouble("Valor")));
                registro[4] = "$ " + Utilidades.priceWithDecimal(
                        Double.parseDouble(Utilidades.priceWithDecimal(
                                rs.getDouble("Valor"))));
                miTabla3.addRow(registro);
            }
            txtTotal.setValue(suma);
            tblDetalleFactura.setModel(miTabla3);
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error al obtener facturas del cliente.",
                    ex
            );
        }

        if (evt.getClickCount() == 2) {
            btnImprimirActionPerformed(null);
        }
    }//GEN-LAST:event_tblFacturaMouseClicked

    private void txtCriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriterioActionPerformed
        tablaClientes();
    }//GEN-LAST:event_txtCriterioActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        if (evt.getClickCount() == 1) {
            return;
        }
        //TODO Se obtiene un error al dar doble click en la tabla de cliente.
        VistaSolicitudFecha miFecha = new VistaSolicitudFecha(null, true);
        miFecha.setLocationRelativeTo(null);
        miFecha.setVisible(true);

        tblFactura.repaint();

        ajusteDetalle();

        String idCliente = tblClientes.getValueAt(tblClientes.getSelectedRow(), 0).toString();

        try {
            DefaultTableModel modelo = (DefaultTableModel) tblFactura.getModel();
            int filas = tblFactura.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }

            ResultSet rs = null;
            String registro[] = new String[4];

            while (rs.next()) {
                registro[0] = rs.getString("idFactura");
                registro[1] = rs.getString("fecha");
                registro[2] = "RD$ " + Utilidades.priceWithDecimal(rs.getDouble("Valor"));
                String estado = rs.getString("Estado");
                if (estado.equals("p")) {
                    estado = "Pagada";
                }
                if (estado.equals("a")) {
                    estado = "Abonada";
                }
                if (estado.equals("c")) {
                    estado = "Credito";
                }
                if (estado.equals("t")) {
                    estado = "Temporal";
                }
                if (estado.equals("x")) {
                    estado = "Asignada: " + rs.getString("Usuario");
                }

                registro[3] = estado;

                miTabla2.addRow(registro);
            }
            tblFactura.setModel(miTabla2);
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error al obtener los detalles del cliente.",
                    ex
            );
        }
    }//GEN-LAST:event_tblClientesMouseClicked

    private void txtCriterioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioKeyReleased
        tablaClientes();
    }//GEN-LAST:event_txtCriterioKeyReleased

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        if (tblDetalleFactura.getRowCount() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "No ha seleccionado Factura",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("idFactura", Integer.valueOf(
                tblFactura.getValueAt(
                        tblFactura.getSelectedRow(), 0).toString()));
        hiloImpresionFactura impresionFactura = new hiloImpresionFactura(
                true,
                false,
                "/Reportes/factura(copia).jasper",
                parametros,
                VistaPrincipal.jPanelImpresion,
                VistaPrincipal.jprImpresion);

        impresionFactura.start();
    }//GEN-LAST:event_btnImprimirActionPerformed
    void tablaClientes() {
        String titulos[] = {"Nombres y Apellidos", "Cedula"};

        Object registro[] = new Object[titulos.length];

        miTabla = new DefaultTableModel(null, titulos);

        M_Cliente.select(
                Cliente
                        .builder()
                        .build()
        ).stream().forEach(
                cliente -> {
                    
                    registro[0] = cliente;
                    registro[1] = M_Generales.select(
                            Generales
                                    .builder()
                                    .idPersona(cliente.getId())
                                    .build()
                    ).getFirst();
                    miTabla.addRow(registro);
                }
        );
        tblClientes.setModel(miTabla);

        /*Ancho de Columnas de Clientes*/
        Utilidades.repararColumnaTable(tblClientes);

        ajusteFactura();
        ajusteDetalle();
        txtTotal.setValue(0);
    }

    private void ajusteFactura() {
        //Segunda Tabla....=_=_=_=_=_=_=_=_=_=_=_=_=_
        String titulos2[] = {"ID Factura", "Fecha", "Valor", "Estado"};
        miTabla2 = new DefaultTableModel(null, titulos2);
        tblFactura.setModel(miTabla2);

        //Para Alinear Columnas 2 en Factuas Clientes
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tblFactura.getColumnModel().getColumn(2).setCellRenderer(tcr);
    }

    private void ajusteDetalle() {
        //Tercera Tabla....=_=_=_=_=_=_=_=_=_=_=_=_=_
        String titulos3[] = {"ID Producto", "Descripcion", "Precio", "Cantidad", "Valor"};
        miTabla3 = new DefaultTableModel(null, titulos3);
        tblDetalleFactura.setModel(miTabla3);

        //Para Alinear Columnas 2 y 4 en Factura
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tblDetalleFactura.getColumnModel().getColumn(2).setCellRenderer(tcr);
        tblDetalleFactura.getColumnModel().getColumn(4).setCellRenderer(tcr);

        /*Ancho de Columnas de Facturas*/
        miTableColumn = null;
        for (int i = 0; i <= 4; i++) {
            miTableColumn = tblDetalleFactura.getColumnModel().getColumn(i);
            if (i == 0) {
                miTableColumn.setPreferredWidth(150);
                //JTable tabla = new JTable(modelo.isCellEditable(proAct, WIDTH));
            }
            if (i == 1) {
                miTableColumn.setPreferredWidth(500);
            }
            if (i == 2) {
                miTableColumn.setPreferredWidth(110);
            }
            if (i == 3) {
                miTableColumn.setPreferredWidth(110);
            }
            if (i == 4) {
                miTableColumn.setPreferredWidth(140);
            }
        }/////FIN
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgrTipoBusqueda;
    private RSMaterialComponent.RSButtonMaterialIconOne btnImprimir;
    private RSMaterialComponent.RSButtonMaterialIconOne btnSalir;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblDetalleFactura;
    private javax.swing.JTable tblFactura;
    private javax.swing.JTextField txtCriterio;
    private javax.swing.JFormattedTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
