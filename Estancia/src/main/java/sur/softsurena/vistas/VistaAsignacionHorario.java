package sur.softsurena.vistas;

import static sur.softsurena.clases.Datos.getDatos;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sur.softsurena.entidades.Horario;
import sur.softsurena.metodos.M_Horario;

public final class VistaAsignacionHorario extends javax.swing.JInternalFrame {

    private static VistaAsignacionHorario asigHorario;
    private static final long serialVersionUID = 1L;

    public synchronized static VistaAsignacionHorario getAsignacionHorario() {
        if (asigHorario == null) {
            asigHorario = new VistaAsignacionHorario();
        }
        return asigHorario;
    }
    private DefaultTableModel dtmEmpleado;
    private TableRowSorter<TableModel> modeloOrdenado;

    public VistaAsignacionHorario() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcbHorarios = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEmpleadoDisponible = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                if(colIndex == 0) return true;
                return false; //Las celdas no son editables. 
            }
        };
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtEmpleadoIncluido = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                if(colIndex == 0) return true; 
                return false; //Las celdas no son editables. 
            }
        };

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Control de asignación");
        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(500, 500));
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Horarios del sistema"));

        jcbHorarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un horario" }));
        jcbHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbHorariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jcbHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleado disponible para este horario"));
        jPanel2.setMaximumSize(new java.awt.Dimension(300, 200));
        jPanel2.setMinimumSize(new java.awt.Dimension(200, 200));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 200));

        jtEmpleadoDisponible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEmpleadoDisponibleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtEmpleadoDisponible);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleados incluido en el horario "));
        jPanel3.setMaximumSize(new java.awt.Dimension(300, 200));
        jPanel3.setMinimumSize(new java.awt.Dimension(200, 200));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 200));

        jtEmpleadoIncluido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEmpleadoIncluidoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtEmpleadoIncluido);
        if (jtEmpleadoIncluido.getColumnModel().getColumnCount() > 0) {
            jtEmpleadoIncluido.getColumnModel().getColumn(0).setHeaderValue("Seleccione");
            jtEmpleadoIncluido.getColumnModel().getColumn(1).setHeaderValue("Nombre");
            jtEmpleadoIncluido.getColumnModel().getColumn(2).setHeaderValue("Ocupacion");
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        ResultSet h = getDatos("Obteniendo horarios").getHorarios(true);
        jcbHorarios.removeAllItems();
        jcbHorarios.addItem(
                Horario
                        .builder()
                        .descripcion("Seleccione un horario")
                        .build()
        );
        
        M_Horario.select(
                Horario
                        .builder()
                        .build()
        ).stream().forEach(
                horario -> {
                    jcbHorarios.addItem(horario);
                }
        );
        
        llenarTabla();
    }//GEN-LAST:event_formInternalFrameOpened

    private void jcbHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbHorariosActionPerformed
        if (!isShowing()) {
            return;
        }
        llenarTabla();
    }//GEN-LAST:event_jcbHorariosActionPerformed

    private void jtEmpleadoDisponibleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEmpleadoDisponibleMouseClicked
        int col = jtEmpleadoDisponible.columnAtPoint(evt.getPoint());
        if (col == 0) {
//            getDatos("Agregar o actualizar asignacion horario. ").
//                    agregarAsignacionHorario(
//                            ((Categoria) jtEmpleadoDisponible.getValueAt(
//                            jtEmpleadoDisponible.getSelectedRow(), 1)).getIdCategoria(), 
//                            ((Categoria) jcbHorarios.getSelectedItem()).getIdCategoria());
            llenarTabla();
        }
        
    }//GEN-LAST:event_jtEmpleadoDisponibleMouseClicked

    private void jtEmpleadoIncluidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEmpleadoIncluidoMouseClicked
        int col = jtEmpleadoIncluido.columnAtPoint(evt.getPoint());
        if (col == 0) {
//            getDatos("borrar asignacion horario. ").
//                    borrarAsignacionEmpleado(
//                            ((Categoria) jtEmpleadoIncluido.getValueAt(
//                            jtEmpleadoIncluido.getSelectedRow(), 1)).getIdCategoria()     );
            llenarTabla();
        }
    }//GEN-LAST:event_jtEmpleadoIncluidoMouseClicked
    public synchronized void llenarTabla() {
//        //cliEmpleados = 0;
//        jtEmpleadoIncluido.setModel(new DefaultTableModel());
//        jtEmpleadoDisponible.setModel(new DefaultTableModel());
//        if (jcbHorarios.getSelectedIndex() == 0) {
//            return;
//        }
//        String titulos[] = {
//            "<html><b>Seleccione</b></html>",
//            "<html><b>Nombres y Apellidos</b></html>",
//            "<html><b>Ocupación</b></html>"};
//        Object registro[] = new Object[3];
//        //Tabla de los disponibles
//        try {
//            ResultSet rs = getDatos("Llenar la tabla de los horarios").getHorariosDisponibles(
//                    ((Categoria) jcbHorarios.getSelectedItem()).getIdCategoria());
//            dtmEmpleado = new DefaultTableModel(null, titulos) {
//                Class[] types = new Class[]{
//                    java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
//                };
//
//                @Override
//                public Class getColumnClass(int columnIndex) {
//                    return types[columnIndex];
//                }
//            };
//            while (rs.next()) {
//                registro[0] = Boolean.FALSE;
//                registro[1] = new Categoria(rs.getInt("idEmpleado"), 
//                        rs.getString("fullName").trim());
//                registro[2] = rs.getString("cargo").trim();
//                dtmEmpleado.addRow(registro);
//            }
//            jtEmpleadoDisponible.setModel(dtmEmpleado);
//            modeloOrdenado = new TableRowSorter<>(dtmEmpleado);
//            jtEmpleadoDisponible.setRowSorter(modeloOrdenado);
//        } catch (SQLException ex) {
//            LOG.log(
//                    Level.SEVERE, 
//                    null, 
//                    ex
//            );
//        }
//        //adjustColumnPreferredWidths(jtEmpleadoIncluido);//Fin de la tabla disponible...
//        
//        //Tabla de los incluidos
//        try {
//            ResultSet rs = getDatos("Llenar la tabla de los horarios").getHorariosIncluidos(
//                    ((Categoria) jcbHorarios.getSelectedItem()).getIdCategoria());
//            dtmEmpleado = new DefaultTableModel(null, titulos) {
//                Class[] types = new Class[]{
//                    java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
//                };
//
//                @Override
//                public Class getColumnClass(int columnIndex) {
//                    return types[columnIndex];
//                }
//            };
//            while (rs.next()) {
//                registro[0] = Boolean.TRUE;
//                registro[1] = new Categoria(rs.getInt("idEmpleado"),
//                        rs.getString("fullName").trim());
//                registro[2] = rs.getString("cargo").trim();
//                dtmEmpleado.addRow(registro);
//            }
//            jtEmpleadoIncluido.setModel(dtmEmpleado);
//            modeloOrdenado = new TableRowSorter<>(dtmEmpleado);
//            jtEmpleadoIncluido.setRowSorter(modeloOrdenado);
//        } catch (SQLException ex) {
//            LOG.log(
//                    Level.SEVERE, 
//                    null, 
//                    ex
//            );
//        }//Fin tabla de los disponible
//        //adjustColumnPreferredWidths(jtEmpleadoIncluido);        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox jcbHorarios;
    private javax.swing.JTable jtEmpleadoDisponible;
    private javax.swing.JTable jtEmpleadoIncluido;
    // End of variables declaration//GEN-END:variables
}
