package sur.softsurena.vistas;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sur.softsurena.abstractas.Persona;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.metodos.M_Cliente;
import sur.softsurena.metodos.M_Persona;
import sur.softsurena.utilidades.Utilidades;

public final class VistaReporteFacturas extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    public VistaReporteFacturas() {
        initComponents();

        JTextField editorFecha = (JTextField) dchFechaInicial.getDateEditor();

        editorFecha.setBorder(
                javax.swing.BorderFactory.createTitledBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                new java.awt.Color(0, 0, 255)), "Fecha inicial"));

        editorFecha = (JTextField) dchFechaFinal.getDateEditor();

        editorFecha.setBorder(
                javax.swing.BorderFactory.createTitledBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                new java.awt.Color(0, 0, 255)), "Fecha final"));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtArchivo = new javax.swing.JTextField();
        btnSeleccionArchivo = new javax.swing.JButton();
        btnGenerar = new RSMaterialComponent.RSButtonMaterialIconOne();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        dchFechaInicial = new com.toedter.calendar.JDateChooser();
        dchFechaFinal = new com.toedter.calendar.JDateChooser();
        cmbCliente = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Reporte de Facturas");
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

        txtArchivo.setText("Reporte");
        txtArchivo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)), "Nombre archivo"));

        btnSeleccionArchivo.setText("...");
        btnSeleccionArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionArchivoActionPerformed(evt);
            }
        });

        btnGenerar.setText("Generar reporte");
        btnGenerar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGenerar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PUBLISH);
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dchFechaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                    .addComponent(dchFechaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dchFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dchFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Por Fecha", jPanel1);

        cmbCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)), "Listado de clientes"));

        jCheckBox1.setText("Parametrizada");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmbCliente, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(txtArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSeleccionArchivo))
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSeleccionArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        //Cargamos Clientes
        cmbCliente.removeAllItems();

        M_Cliente.select(
                Cliente
                        .builder()
                        .build()
        ).stream().forEach(
                cliente -> {
                    M_Persona.select(
                            Cliente
                                    .builder()
                                    .idPersona(cliente.getIdPersona())
                                    .estado(true)
                                    .build()
                    ).stream().forEach(
                            persona -> {
                                cmbCliente.addItem(persona);
                            }
                    );

                }
        );
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnSeleccionArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionArchivoActionPerformed
        VistaSelectorArchivo miArchivo = new VistaSelectorArchivo(
                null, true
        );
        miArchivo.setLocationRelativeTo(null);
        miArchivo.setVisible(true);
        String archivo = miArchivo.getArchivo();
        if (!archivo.isBlank()) {
            txtArchivo.setText(archivo);
        }
    }//GEN-LAST:event_btnSeleccionArchivoActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        if (txtArchivo.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe ingresar o Selecionar un Nombre de Archivo...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        //TODO 02/12/2024 Trabajo aqui.
        String sql = """
                     SELECT factura.idFactura, factura.idCliente, (nombres||' '||apellidos) AS nombreFull,
                            fecha, idLinea, idProducto, (select descripcion
                                                            from productos
                                                            where idProducto like detalleFactura.idProducto) as descripcion,
                            precio, cantidad, precio * cantidad AS Valor
                     FROM factura
                     INNER JOIN cliente ON factura.idCliente = cliente.idCliente
                     INNER JOIN detalleFactura ON factura.idFactura = detalleFactura.idFactura;
                     """;

        if (cmbCliente.getSelectedIndex() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe Selecionar un Cliente.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            cmbCliente.requestFocus();
            return;
        }

        String filtro = "WHERE factura.idCliente = '"
                + ((Cliente) cmbCliente.getSelectedItem()).getIdPersona()+ "'";

        //Para Realizar la Consulta por Fecha...
        //Si la fecha es seleccionada.
        if (dchFechaInicial.getDate() == null) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe Selecionar una Fecha Inicial...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            dchFechaInicial.requestFocus();
            return;
        }
        if (dchFechaFinal.getDate() == null) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe Selecionar una Fecha Final...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            dchFechaFinal.requestFocus();
            return;
        }

        filtro = "WHERE fecha >= '"
                + Utilidades.formatDate(dchFechaInicial.getDate(), "MM-dd-yyyy")
                + "' and fecha <= '"
                + Utilidades.formatDate(dchFechaFinal.getDate(), "MM-dd-yyyy") + "'";

        //Adicionamos el fitro a la Consulta....
        sql = sql + filtro;

//            Reporte.reporteFacturas(archivo, getConsulta(sql));
        JOptionPane.showInternalMessageDialog(
                this,
                "Reporte Generado...",
                "",
                JOptionPane.INFORMATION_MESSAGE
        );
        dispose();

    }//GEN-LAST:event_btnGenerarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnGenerar;
    private javax.swing.JButton btnSeleccionArchivo;
    private javax.swing.JComboBox<Persona> cmbCliente;
    private com.toedter.calendar.JDateChooser dchFechaFinal;
    private com.toedter.calendar.JDateChooser dchFechaInicial;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtArchivo;
    // End of variables declaration//GEN-END:variables
}
