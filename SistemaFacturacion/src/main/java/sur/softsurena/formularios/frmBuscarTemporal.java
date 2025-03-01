package sur.softsurena.formularios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sur.softsurena.entidades.M_Factura;
import sur.softsurena.hilos.hiloImpresionFactura;
import sur.softsurena.metodos.M_M_Factura;
import sur.softsurena.utilidades.DefaultTableCellHeaderRenderer;

public final class frmBuscarTemporal extends java.awt.Dialog {

    private static final long serialVersionUID = 1L;

    private DefaultTableModel miTabla;
    private boolean aceptar;
    private String factura;
    private final DefaultTableCellRenderer tcr;

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public boolean isAceptar() {
        return aceptar;
    }

    public void setAceptar(boolean aceptar) {
        this.aceptar = aceptar;
    }

    public frmBuscarTemporal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tcr = new DefaultTableCellHeaderRenderer();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jPanel1 = new javax.swing.JPanel();
        btnAceptar = new newscomponents.RSButtonGradientIcon_new();
        btnImprimirCuenta = new newscomponents.RSButtonGradientIcon_new();
        btnCancelar = new newscomponents.RSButtonGradientIcon_new();

        setMinimumSize(new java.awt.Dimension(668, 258));
        setResizable(false);
        setTitle("Facturas en Temporales");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblDetalle.setAutoCreateRowSorter(true);
        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N° Factura", "Nombre Cliente", "Fecha", "Hora", "Cajero", "Monto"
            }
        ));
        tblDetalle.setName("tblDetalle"); // NOI18N
        jScrollPane1.setViewportView(tblDetalle);

        btnAceptar.setText("Aceptar");
        btnAceptar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DONE);
        btnAceptar.setName("btnAceptar"); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnImprimirCuenta.setText("Imprimir Cuenta");
        btnImprimirCuenta.setColorPrimario(new java.awt.Color(51, 255, 51));
        btnImprimirCuenta.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PRINT);
        btnImprimirCuenta.setName("btnImprimirCuenta"); // NOI18N
        btnImprimirCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirCuentaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setColorPrimario(new java.awt.Color(255, 0, 0));
        btnCancelar.setColorPrimarioHover(new java.awt.Color(255, 51, 102));
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setName("btnCancelar"); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnImprimirCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimirCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (tblDetalle.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe selecionar una Factura...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        setAceptar(true);
        setFactura(
                tblDetalle.getValueAt(
                        tblDetalle.getSelectedRow(),
                        0
                ).toString()
        );
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setAceptar(false);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnImprimirCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirCuentaActionPerformed
        //Debe haber una factura selecciona
        if (tblDetalle.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "No ha seleccionado Factura",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        //Creamos un mapa de los valores de la factura, la cual se requiere el
        //identificador de la factura.
        Map<String, Object> parametros = new HashMap<>();

        parametros.put("idFactura", Integer.valueOf(
                miTabla.getValueAt(
                        tblDetalle.getSelectedRow(), 0
                ).toString()));

        hiloImpresionFactura miFactura
                = new hiloImpresionFactura(
                        true, //Mostrar Reporte
                        false, //No se requiere copia del documento
                        "/Reportes/factura.jasper",
                        parametros,
                        frmPrincipal.jPanelImpresion,
                        frmPrincipal.jprImpresion);
        miFactura.start();
    }//GEN-LAST:event_btnImprimirCuentaActionPerformed
    /**
     * Metodo utilizado para llenar las tablas de las facturas que existen en
     * temporal.
     *
     * TODO Testear las verdadera factura temporales.
     *
     */
    private void llenarTabla() {
        String titulos[] = {
            "N° Factura", "Nombre Cliente", "Fecha/Hora", "Cajero"
        };
        miTabla = new DefaultTableModel(null, titulos);

        List<M_Factura> temporalesList = M_M_Factura.select(
                M_Factura
                        .builder()
                        .estadoFactura('t')
                        .build()
        );

        Object registro[] = new Object[titulos.length];

        temporalesList.stream().forEach(
                temporal -> {
                    registro[0] = temporal.getId();

                    if (temporal.getIdCliente() == 0) {
                        registro[1] = temporal.getNombreTemporal();
                    } else {
                        //TODO 10/01/2025 Traer el nombre de la persona.
                        registro[1] = temporal.getIdCliente();
                    }

                    registro[2] = temporal.getFechaHora();
                    //TODO 10/01/2025 Traer el nombre del cajero de la tabla de turno.
                    registro[3] = temporal.getIdTurno();

                    miTabla.addRow(registro);//Se van insertando los registros.

                }
        );
        //Se agrega el modelo a la tabla.
        tblDetalle.setModel(miTabla);

        //Para Alinear el Texto de la Table a la Derecha...
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tblDetalle.getColumnModel().getColumn(0).setCellRenderer(tcr);

        //Ordenando las columnas
        int columnWidth[] = {10, 50, 20, 20};
        TableColumn miTableColumn;
        for (int i = 0; i < titulos.length; i++) {
            miTableColumn = tblDetalle.getColumnModel().getColumn(i);
            miTableColumn.setPreferredWidth(columnWidth[i]);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonGradientIcon_new btnAceptar;
    private newscomponents.RSButtonGradientIcon_new btnCancelar;
    private newscomponents.RSButtonGradientIcon_new btnImprimirCuenta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblDetalle;
    // End of variables declaration//GEN-END:variables
}
