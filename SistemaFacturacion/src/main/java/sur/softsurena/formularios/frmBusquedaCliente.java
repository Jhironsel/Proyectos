package sur.softsurena.formularios;

import java.awt.Frame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import lombok.Getter;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.entidades.Generales;
import sur.softsurena.metodos.M_Cliente;
import sur.softsurena.metodos.M_Generales;
import sur.softsurena.metodos.M_Persona;

/**
 *
 * @author jhironsel
 */
@Getter
public class frmBusquedaCliente extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;

    private DefaultTableModel miTabla;
    private transient Cliente cliente;

    private static Frame parent;
    private static boolean modal;

    public static frmBusquedaCliente getInstance(Frame parent, boolean modal) {
        frmBusquedaCliente.parent = parent;
        frmBusquedaCliente.modal = modal;
        return NewSingletonHolder.INSTANCE;
    }

    private static class NewSingletonHolder {

        private static final frmBusquedaCliente INSTANCE
                = new frmBusquedaCliente(
                        frmBusquedaCliente.parent,
                        frmBusquedaCliente.modal
                );
    }

    private frmBusquedaCliente(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        btnCancelar = new newscomponents.RSButtonGradientIcon_new();
        btnAceptar = new newscomponents.RSButtonGradientIcon_new();
        txtCriterio = new rojeru_san.RSMTextFull();
        jPanel1 = new javax.swing.JPanel();
        rbCedula = new javax.swing.JRadioButton();
        rbNombresApellidos = new javax.swing.JRadioButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busqueda de Clientes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblTabla.setForeground(new java.awt.Color(1, 1, 1));
        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTabla.setAutoscrolls(false);
        tblTabla.setGridColor(new java.awt.Color(1, 1, 1));
        jScrollPane1.setViewportView(tblTabla);

        btnCancelar.setText("Cancelar");
        btnCancelar.setColorPrimario(new java.awt.Color(153, 0, 0));
        btnCancelar.setColorPrimarioHover(new java.awt.Color(255, 51, 51));
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DONE);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        txtCriterio.setToolTipText("");
        txtCriterio.setPlaceholder("Ingrese criterio de busqueda ya sea Identificador de cliente, nombres o apellidos.");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Filtrado por:"));
        jPanel1.setLayout(new java.awt.GridLayout(1, 8, 10, 0));

        buttonGroup1.add(rbCedula);
        rbCedula.setSelected(true);
        rbCedula.setText("Cedula");
        jPanel1.add(rbCedula);

        buttonGroup1.add(rbNombresApellidos);
        rbNombresApellidos.setText("Nombres o Apellidos");
        jPanel1.add(rbNombresApellidos);

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Activos");
        jCheckBox1.setEnabled(false);
        jPanel1.add(jCheckBox1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCriterio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarTabla();
        txtCriterio.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (tblTabla.getSelectedRow() == -1) {
            dispose();
            return;
        }

        cliente = (Cliente) tblTabla.getValueAt(tblTabla.getSelectedRow(), 0);
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtCriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriterioActionPerformed
        llenarTabla();
        btnAceptarActionPerformed(null);
    }//GEN-LAST:event_txtCriterioActionPerformed

    private void txtCriterioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioKeyReleased
        llenarTabla();
    }//GEN-LAST:event_txtCriterioKeyReleased

    /**
     * Permite obtener la lista de clietne que cumplan con el criterio de
     * busqueda, dichos criterios seran la cedula, nombres o apellidos.
     *
     * TODO 24/11/2024 Analizar este metodo si esta funcionado.
     *
     */
    private void llenarTabla() {
        String titulos[] = {"Lista de Clientes"};
        miTabla = new DefaultTableModel(null, titulos);

        Object registro[] = new Object[1];

        if (rbCedula.isSelected()) {
            M_Generales.select(
                    Generales
                            .builder()
                            .cedula(txtCriterio.getText().strip())
                            .build()
            ).stream().forEach(
                    general -> {
                        M_Cliente.select(
                                Cliente
                                        .builder()
                                        .id(general.getIdPersona())
                                        .build()
                        ).stream().forEach(
                                cliente2 -> {
                                    M_Persona.select(
                                            Persona
                                                    .builder()
                                                    .idPersona(cliente2.getId())
                                                    .build()
                                    ).stream().forEach(
                                            persona -> {
                                                registro[0] = persona;
                                                miTabla.addRow(registro);
                                            }
                                    );
                                }
                        );

                    }
            );
        }

        if (rbNombresApellidos.isSelected()) {
            M_Cliente.select(
                    Cliente
                            .builder()
                            .build()
            );

            M_Persona.select(
                    Persona
                            .builder()
                            .idPersona(-1)
                            .pnombre(txtCriterio.getText().strip())
                            .snombre(txtCriterio.getText().strip())
                            .apellidos(txtCriterio.getText().strip())
                            .build()
            ).stream().forEach(
                    persona -> {
                        registro[0] = persona;
                        miTabla.addRow(registro);
                    }
            );

        }

        tblTabla.setModel(miTabla);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonGradientIcon_new btnAceptar;
    private newscomponents.RSButtonGradientIcon_new btnCancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbCedula;
    private javax.swing.JRadioButton rbNombresApellidos;
    private javax.swing.JTable tblTabla;
    private rojeru_san.RSMTextFull txtCriterio;
    // End of variables declaration//GEN-END:variables
}
