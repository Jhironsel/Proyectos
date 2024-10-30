package sur.softsurena.archivos;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static sur.softsurena.datos.delete.DeleteMetodos.borrarAntecedente;
import static sur.softsurena.datos.insert.InsertMetodos.agregarAntecedente;
import static sur.softsurena.datos.select.SelectMetodos.*;
import sur.softsurena.entidades.Antecedentes;

public class frmPacientesAntecedentes extends javax.swing.JDialog {
    private final int idPaciente;
    
    public frmPacientesAntecedentes(java.awt.Frame parent, boolean modal, int idPadre) {
        super(parent, modal);
        
        initComponents();
        this.idPaciente = idPadre;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSeguro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNoSeguro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPadres = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Antecendetes de los padres");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(79, 125, 197));
        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Antecedentes de Paciente");
        jLabel1.setOpaque(true);

        jLabel2.setText("Nombre: ");

        txtNombres.setEditable(false);

        txtApellidos.setEditable(false);

        jLabel3.setText("Apellidos: ");

        txtSeguro.setEditable(false);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Seguro: ");

        txtNoSeguro.setEditable(false);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("No. Seguro: ");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Antecedentes de padres"));

        jtPadres.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtPadres);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles"));
        jPanel3.setPreferredSize(new java.awt.Dimension(600, 111));

        jPanel8.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

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
        jPanel8.add(btnNuevo);

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
        jPanel8.add(btnModificar);

        btnBorrar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(1, 1, 1));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Borrar 32 x 32.png"))); // NOI18N
        btnBorrar.setMnemonic('b');
        btnBorrar.setText("Borrar");
        btnBorrar.setToolTipText("Borrar Registro Actual");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel8.add(btnBorrar);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(txtApellidos))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNoSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(txtNoSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel4, txtNombres, txtSeguro});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel5, txtApellidos, txtNoSeguro});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        
        String ant = JOptionPane.showInputDialog(this, "Inserte un antecedente", 
                "Ingreso de antecedentes", JOptionPane.QUESTION_MESSAGE);
        if(ant == null || ant.isEmpty()){
            return;
        }
        JOptionPane.showMessageDialog(this, agregarAntecedente(idPaciente, ant));
        llenarTabla();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        if (jtPadres.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this,
                    "Debe seleccionar un antecedente!");
            return;
        }

        String ant = JOptionPane.showInputDialog(this,
                "Actualizando antecedente",
                jtPadres.getValueAt(jtPadres.getSelectedRow(), 0));

        if (ant == null || ant.isEmpty()) {
            return;
        }
        
//        JOptionPane.showMessageDialog(this, 
//                getDatos("Modificar antecedente del paciente").modificarAntecedentePaciente(
//                        ((Antecedente)jtPadres.getValueAt(
//                                jtPadres.getSelectedRow(), 0)).getIdAntecedente(), 
//                        ant));
        llenarTabla();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        
        if (jtPadres.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this,
                    "Debe seleccionar un antecedente!");
            return;
        }
        JOptionPane.showMessageDialog(this, 
                borrarAntecedente(((Antecedentes)jtPadres.getValueAt(
                                jtPadres.getSelectedRow(), 0)).getIdAntecedente()));
        llenarTabla();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ResultSet rs = getPacienteActivoID(idPaciente);
        try {
            rs.next();
            txtNombres.setText(rs.getString("NOMBRES"));
            txtApellidos.setText(rs.getString("APELLIDOS"));
            txtSeguro.setText(rs.getString("IDARS"));
            txtNoSeguro.setText(rs.getString("NONSS"));
        } catch (SQLException ex) {
            //Instalar Logger
        }
        llenarTabla();
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPadres;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtNoSeguro;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtSeguro;
    // End of variables declaration//GEN-END:variables

    public synchronized void llenarTabla() {
        
        String titulos[] = {"Descripcion del Antecedente"};
        Object registro[] = new Object[1];
        jtPadres.removeAll();
        try {
            ResultSet rs = getAntecedentes(idPaciente);
            DefaultTableModel miTabla = new DefaultTableModel(null, titulos);
            while (rs.next()) {
                registro[0] = new Antecedentes(rs.getInt("idAntecedente"), 
                        rs.getString("DESCRIPCION"));
                miTabla.addRow(registro);
            }
            jtPadres.setModel(miTabla);
        } catch (SQLException ex) {
            //Instalar Logger
        }
    }
}
