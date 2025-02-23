package sur.softsurena.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sur.softsurena.entidades.ControlConsulta;
import sur.softsurena.entidades.Doctor;
import static sur.softsurena.formularios.frmPrincipal.dpnEscritorio;
import sur.softsurena.metodos.M_ControlConsulta;

public class frmHorario extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    private static frmHorario controlCita;
    private static TableRowSorter<TableModel> modeloOrdenado;

    public frmHorario() {

        initComponents();
    }

    public synchronized static frmHorario getControlCita() {

        if (controlCita == null) {
            controlCita = new frmHorario();
        }
        return controlCita;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        cbDoctores = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtConsulta = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Control de horario");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuración Consulta"));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros por doctores"));

        cbDoctores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Doctor" }));
        cbDoctores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDoctoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(cbDoctores, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(cbDoctores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jScrollPane4.setViewportView(jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de consultas"));

        jtConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuarios", "Fecha", "Cantidad Paciente", "Hora Inicio", "Hora Final", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtConsultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtConsulta);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles"));
        jPanel6.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        btnNuevo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(1, 1, 1));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Documento nuevo 32 x 32.png"))); // NOI18N
        btnNuevo.setMnemonic('n');
        btnNuevo.setText("Nuevo");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        if (cbDoctores.getSelectedIndex() == 0) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe seleccionar un doctor de la lista",
                    "Validacion de proceso", JOptionPane.INFORMATION_MESSAGE);
            cbDoctores.requestFocus();
            cbDoctores.showPopup();
            return;
        }
        frmDiasConsultas dc = new frmDiasConsultas(
                null,
                true,
                cbDoctores.getSelectedItem().toString()
        );
        dc.setLocationRelativeTo(null);
        dc.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed

        if (jtConsulta.getSelectedRow() < 0) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe seleccionar una consulta de la tabla!");
            return;
        }
        int resp = JOptionPane.showInternalConfirmDialog(this,
                "Desea eliminar Horario",
                "Proceso de eliminar citas",
                JOptionPane.YES_NO_OPTION);

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        JOptionPane.showInternalMessageDialog(this,
                borrarControlConsulta(
                        ((Categorias) jtConsulta.getValueAt(
                                jtConsulta.getSelectedRow(),
                                0
                        )).getId()));

        llenarTabla();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

        llenarCombox();
        llenarTabla();
    }//GEN-LAST:event_formInternalFrameOpened

    private void jtConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtConsultaMouseClicked

        for (int i = 0; i < cbDoctores.getItemCount(); i++) {
            if (((Categorias) cbDoctores.getItemAt(i)).getDescripcion().trim().equals(((Categorias) jtConsulta.getValueAt(jtConsulta.getSelectedRow(), 0)).getDescripcion().trim())) {
                cbDoctores.setSelectedIndex(i);
            }
        }
    }//GEN-LAST:event_jtConsultaMouseClicked

    private void cbDoctoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDoctoresActionPerformed
        if (!isShowing()) {
            return;
        }

        llenarTabla();
    }//GEN-LAST:event_cbDoctoresActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnNuevo;
    private static javax.swing.JComboBox<Doctor> cbDoctores;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    protected static javax.swing.JTable jtConsulta;
    // End of variables declaration//GEN-END:variables

    public static synchronized void llenarTabla() {

        String titulos[] = {"Dia", "Cantidad Paciente", "Hora Inicial",
            "Hora Final"};

        DefaultTableModel miTabla = new DefaultTableModel(null, titulos);

        jtConsulta.revalidate();
        jtConsulta.validate();

        Integer doctores = cbDoctores.getSelectedIndex();

        if (doctores == 0) {
            jtConsulta.setModel(new DefaultTableModel());
            return;
        }

        String idUsuario = ((Doctor) cbDoctores.getSelectedItem()).
                getDescripcion().trim();

        Object registro[] = new Object[4];

        M_ControlConsulta.getHorario(idUsuario.trim()).stream().forEach(
                horario ->{
                
                }
        );

        while (rs.next()) {
            registro[0] = new Categorias(rs.getInt("IDCONTROLCONSULTA"),
                    dia(rs.getString("DIA")));
            registro[1] = rs.getInt("CANTIDADPACIENTE");
            registro[2] = rs.getTime("INICIAL");
            registro[3] = rs.getTime("FINAL");

            miTabla.addRow(registro);
        }
        modeloOrdenado = new TableRowSorter<TableModel>(miTabla);
        jtConsulta.setRowSorter(modeloOrdenado);
        jtConsulta.setModel(miTabla);
    }

    public static String dia(String dia) {

        switch (dia) {
            case "Lu":
                return "Lunes";
            case "Ma":
                return "Martes";
            case "Mi":
                return "Miercoles";
            case "Ju":
                return "Jueves";
            case "Vi":
                return "Viernes";
            case "Sa":
                return "Sabados";
            case "Do":
                return "Domingo";
            default:
                return "Lunes";
        }
    }

    private synchronized void llenarCombox() {
        cbDoctores.removeAllItems();

        ResultSet rs = getUsuarioDoctor();

        cbDoctores.addItem(new Categorias("Seleccione un Doctor", "N/A"));

        try {
            while (rs.next()) {
                cbDoctores.addItem(
                        new Categorias(
                                rs.getString("LoginUser").trim(), rs.getString("P_Nombre")
                                + " "
                                + rs.getString("S_Nombre").replace("-", "")
                                + " "
                                + rs.getString("Apellidos")
                        )
                );
            }
        } catch (SQLException ex) {
            //Instalar Logger
        }
    }

    public void centralizar() {
        setBounds(
                (dpnEscritorio.getWidth() - this.getWidth()) / 2,
                (dpnEscritorio.getHeight() - this.getHeight()) / 2,
                730,
                480
        );
        pack();
    }
}
