package sur.softsurena.control;

import static sur.softsurena.formularios.frmPrincipal.dpnEscritorio;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.entidades.ARS;
import sur.softsurena.metodos.M_ARS;
import sur.softsurena.utilidades.FiltroBusqueda;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;

public class frmSeguros extends javax.swing.JInternalFrame {

    private static frmSeguros seguros;
    private static final long serialVersionUID = 1L;
    private boolean nuevo;

    public frmSeguros() {
        initComponents();
    }

    public synchronized static frmSeguros getSeguros() {
        if (seguros == null) {
            seguros = new frmSeguros();
        }
        return seguros;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCovertura = new javax.swing.JFormattedTextField();
        chbEstado = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtConsulta = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };

        setClosable(true);
        setIconifiable(true);
        setTitle("Administrador de seguro");
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

        jPanel6.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        btnNuevo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(1, 1, 1));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Documento nuevo 32 x 32.png"))); // NOI18N
        btnNuevo.setMnemonic('n');
        btnNuevo.setText("Agregar");
        btnNuevo.setToolTipText("Crear un nuevo Registro");
        btnNuevo.setMaximumSize(new java.awt.Dimension(104, 44));
        btnNuevo.setMinimumSize(new java.awt.Dimension(104, 44));
        btnNuevo.setPreferredSize(new java.awt.Dimension(104, 44));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel6.add(btnNuevo);

        btnModificar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(1, 1, 1));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Editar Documento 32 x 32.png"))); // NOI18N
        btnModificar.setMnemonic('m');
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Modificar Registro Actual");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel6.add(btnModificar);

        btnGuardar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(1, 1, 1));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Guardar 32 x 32.png"))); // NOI18N
        btnGuardar.setMnemonic('g');
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Guardar Registro Actual");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel6.add(btnGuardar);

        btnCancelar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(1, 1, 1));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setMnemonic('c');
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancela la Operacion del Registro");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel6.add(btnCancelar);

        btnBorrar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(1, 1, 1));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Borrar 32 x 32.png"))); // NOI18N
        btnBorrar.setMnemonic('c');
        btnBorrar.setText("Borrar");
        btnBorrar.setToolTipText("Cancela la Operacion del Registro");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel6.add(btnBorrar);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Administración de Seguro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        txtNombre.setEditable(false);

        jLabel1.setText("Nombre de la ARS");

        jLabel2.setText("Porcentaje de Covertura");

        txtCovertura.setEditable(false);
        txtCovertura.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtCovertura.setValue(0.00);

        chbEstado.setSelected(true);
        chbEstado.setText("Activo");
        chbEstado.setEnabled(false);
        chbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbEstadoItemStateChanged(evt);
            }
        });
        chbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCovertura, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCovertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbEstado))
                .addGap(0, 0, 0))
        );

        jtConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Descripcion ARS", "Covertura", "Numero Afiliados", "Estado"
            }
        ));
        jtConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtConsultaMouseClicked(evt);
            }
        });
        jtConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtConsultaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo = true;
        navegador(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jtConsulta.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe seleccionar un registro de la tabla");
            return;
        }

        nuevo = false;
        navegador(false);

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (jtConsulta.getSelectedRow() < 0) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe seleccionar un registro de la tabla!");
            return;
        }

        if (((ARS) jtConsulta.getValueAt(jtConsulta.getSelectedRow(), 0)).getId() == 0) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "No se puede eliminar este registro!",
                    "Proceso de validación.",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if ((int) jtConsulta.getValueAt(jtConsulta.getSelectedRow(), 1) != 0) {
            JOptionPane.showInternalMessageDialog(this,
                    "No se puede eliminar este registro!");

            int resp = JOptionPane.showInternalConfirmDialog(this,
                    "Le gustaria desactivar este registro en la organizacion",
                    "Proceso de cancelacion de seguro",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.NO_OPTION) {
                return;
            }

            return;
        }

        int resp = JOptionPane.showInternalConfirmDialog(this,
                "Desea eliminar la ARS " + txtNombre.getText(),
                "Proceso de eliminar Seguro",
                JOptionPane.YES_NO_OPTION);

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        Resultado resultado = M_ARS.delete(((ARS) jtConsulta.getValueAt(jtConsulta.getSelectedRow(), 0)).getId());


        JOptionPane.showInternalMessageDialog(
                this,
                resultado.getMensaje(),
                "",
                resultado.getIcono()
        );

        llenarTabla();
        btnCancelarActionPerformed(null);
        jtConsultaKeyReleased(null);
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void chbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbEstadoActionPerformed
        if (chbEstado.getText().equals("Activo")) {
            chbEstado.setText("Inactivo");
        } else {
            chbEstado.setText("Activo");
        }

    }//GEN-LAST:event_chbEstadoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Validacciones
        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this, "Debe digitar un nombre!");
            txtNombre.requestFocus();
            return;
        }
        if (Utilidades.objectToDouble(txtCovertura.getValue()) == 0.00) {
            JOptionPane.showInternalMessageDialog(this,
                    "Indique el monto en porciento de la covertura");
            txtCovertura.requestFocus();
            return;
        }

        if (!chbEstado.isSelected()) {
            int num = JOptionPane.showInternalConfirmDialog(this,
                    "Seguro de deshabilitar ARS " + txtNombre.getText(),
                    "Proceso de inabilitar ARS",
                    JOptionPane.YES_NO_OPTION);
        }

        ARS ars
                = ARS
                        .builder()
                        .id(
                                jtConsulta.getSelectedRow() == -1 ?
                                        -1:
                                ((ARS) jtConsulta.getValueAt(
                                        jtConsulta.getSelectedRow(),
                                        0
                                )).getId()
                        )
                        .descripcion(txtNombre.getText())
                        .covertura(new BigDecimal(txtCovertura.getValue().toString()))
                        .estado(chbEstado.isSelected())
                        .build();
        if (nuevo) {
            M_ARS.insert(ars);
        } else {
            M_ARS.update(ars);
        }

        llenarTabla();
        btnCancelarActionPerformed(null);
        jtConsultaKeyReleased(null);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        navegador(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        llenarTabla();
    }//GEN-LAST:event_formInternalFrameOpened

    private void jtConsultaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtConsultaKeyReleased
        txtNombre.setText(
                jtConsulta.getValueAt(jtConsulta.getSelectedRow(), 0).toString());
        txtCovertura.setValue((double) jtConsulta.getValueAt(jtConsulta.getSelectedRow(), 2));
        chbEstado.setSelected(
                jtConsulta.getValueAt(
                        jtConsulta.getSelectedRow(), 3).toString().equals("Activo"));
    }//GEN-LAST:event_jtConsultaKeyReleased

    private void jtConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtConsultaMouseClicked
        jtConsultaKeyReleased(null);
    }//GEN-LAST:event_jtConsultaMouseClicked

    private void chbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbEstadoItemStateChanged
        chbEstadoActionPerformed(null);
    }//GEN-LAST:event_chbEstadoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JCheckBox chbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtConsulta;
    private javax.swing.JFormattedTextField txtCovertura;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    public void centralizar() {
        setBounds((dpnEscritorio.getWidth() - this.getWidth()) / 2,
                (dpnEscritorio.getHeight() - this.getHeight()) / 2,
                720,
                500);
        pack();
        seguros.setVisible(true);
    }

    private void llenarTabla() {
        jtConsulta.removeAll();

        String titulos[] = {"Descripcion", "Cantidad", "Porciento Covertura",
            "Estado"};

        List<ARS> arsList = M_ARS.select(
                FiltroBusqueda
                        .builder()
                        .build()
        );

        DefaultTableModel miTabla = new DefaultTableModel(null, titulos);

        Object registro[] = new Object[4];
        arsList.stream().forEach(ars -> {
            registro[0] = ARS.builder().
                    id(ars.getId()).
                    descripcion(ars.getDescripcion()).build();
            registro[1] = ars.getCantidad_registro();
            registro[2] = ars.getCovertura();
            registro[3] = ars.getEstado() ? "Activo" : "Inactivo";
        });

        miTabla.addRow(registro);

        jtConsulta.setModel(miTabla);
        jtConsulta.setRowSelectionInterval(0, 0);
        jtConsultaMouseClicked(null);

    }

    private void navegador(boolean navegador) {
        btnGuardar.setEnabled(!navegador);
        btnCancelar.setEnabled(!navegador);
        txtNombre.setEditable(!navegador);
        txtCovertura.setEditable(!navegador);
        chbEstado.setEnabled(!navegador);

        if (!navegador && nuevo) {
            txtCovertura.setValue(0.00);
            txtNombre.setText("");
            chbEstado.setSelected(navegador);
        }

        btnBorrar.setEnabled(navegador);
        btnModificar.setEnabled(navegador);
        btnNuevo.setEnabled(navegador);

    }

}
