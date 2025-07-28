package sur.softsurena.vistas;

import java.util.Objects;
import sur.softsurena.entidades.Almacen;
import sur.softsurena.entidades.EntradaProducto;
import sur.softsurena.entidades.Proveedor;
import sur.softsurena.metodos.M_Almacen;
import sur.softsurena.metodos.M_Proveedor;
import sur.softsurena.utilidades.Utilidades;

public final class VistaDetalleEntradasProductos extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;


    public VistaDetalleEntradasProductos(
            java.awt.Frame parent, boolean modal, EntradaProducto entradaProducto
    ) {
        super(parent, modal);
        initComponents();

        if (Objects.nonNull(entradaProducto)) {
            jlProveedor.setText(
                    M_Proveedor.select(
                            Proveedor
                                    .builder()
                                    .id(entradaProducto.getIdProveedor())
                                    .build()
                    ).stream().findFirst().orElse(
                            Proveedor
                                    .builder()
                                    .id(entradaProducto.getIdProveedor())
                                    .build()
                    ).toString()
            );
            jlAlmacen.setText(
                    M_Almacen.select(
                            Almacen
                                    .builder()
                                    .id(entradaProducto.getIdAlmacen())
                                    .build()
                    ).stream().findFirst().orElse(
                            Almacen
                                    .builder()
                                    .nombre("No disponible...")
                                    .build()
                    ).toString()
            );
            jlCodigoFactura.setText(entradaProducto.getCod_factura());
            jlFechaCreaccion.setText(
                    Utilidades.formatDate(
                            entradaProducto.getFechaEntrada(), 
                            "dd.MM.yyyy"
                    )
            );
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSLabelAnimated1 = new rojeru_san.rslabel.RSLabelAnimated();
        jLabel1 = new javax.swing.JLabel();
        jlProveedor = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlAlmacen = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlCodigoFactura = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlFechaCreaccion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        rSLabelAnimated1.setText("Registros de Detalle de Entradas al Sistema");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Proveedor: ");

        jlProveedor.setText("Proveedor");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Almacen: ");

        jlAlmacen.setText("Almacen");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Codigo de factura: ");

        jlCodigoFactura.setText("Codigo de factura");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Fecha de Creacción: ");

        jlFechaCreaccion.setText("Fecha de Creacción");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlFechaCreaccion, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                    .addComponent(jlProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlCodigoFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(rSLabelAnimated1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel3, jLabel5, jLabel7});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelAnimated1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jlAlmacen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jlCodigoFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jlFechaCreaccion))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jlAlmacen;
    private javax.swing.JLabel jlCodigoFactura;
    private javax.swing.JLabel jlFechaCreaccion;
    private javax.swing.JLabel jlProveedor;
    private rojeru_san.rslabel.RSLabelAnimated rSLabelAnimated1;
    // End of variables declaration//GEN-END:variables
}
