package sur.softsurena.vistas;

import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.entidades.ARS;
import sur.softsurena.entidades.Antecedente;
import sur.softsurena.entidades.Asegurado;
import sur.softsurena.entidades.Consulta;
import sur.softsurena.entidades.Paciente;
import sur.softsurena.metodos.M_ARS;
import sur.softsurena.metodos.M_Antecedente;
import sur.softsurena.metodos.M_Asegurado;
import sur.softsurena.metodos.M_Consulta;
import sur.softsurena.utilidades.Resultado;

public final class VistaPacientesAntecedentes extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;
    private final int idPaciente;

    public VistaPacientesAntecedentes(Frame parent, boolean modal, int idPadre) {
        super(parent, modal);

        initComponents();
        this.idPaciente = idPadre;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
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

        jLabel2.setText("Nombres y Apellidos: ");

        txtNombres.setEditable(false);

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
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSeguro, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNoSeguro, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                            .addComponent(txtNombres))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtNoSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel4, txtNombres, txtSeguro});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel5, txtNoSeguro});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        String ant = JOptionPane.showInputDialog(this, "Inserte un antecedente",
                "Ingreso de antecedentes", JOptionPane.QUESTION_MESSAGE);
        if (ant == null || ant.isEmpty()) {
            return;
        }
        Resultado resultado = M_Antecedente.insert(
                Antecedente
                        .builder()
                        .descripcion(ant)
                        .build()
        );
        JOptionPane.showMessageDialog(
                this,
                resultado.getMensaje(),
                "",
                resultado.getIcono()
        );
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

        Resultado resultado = M_Antecedente.delete(
                ((Antecedente) jtPadres.getValueAt(
                        jtPadres.getSelectedRow(),
                        0
                ))
        );

        JOptionPane.showMessageDialog(
                this,
                resultado.getMensaje(),
                "",
                resultado.getIcono()
        );
        llenarTabla();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Paciente paciente = Paciente
                .builder()
                .id(idPaciente)
                .build();

        Asegurado asegurado = M_Asegurado.select(
                Asegurado
                        .builder()
                        .idPersona(idPaciente)
                        .build()
        ).getFirst();

        ARS ars = M_ARS.select(
                ARS
                        .builder()
                        .id(asegurado.getIdArs())
                        .build()
        ).getFirst();

        txtNombres.setText(paciente.toString());
        txtSeguro.setText(ars.getDescripcion());
        txtNoSeguro.setText(asegurado.getNo_nss());

        llenarTabla();
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPadres;
    private javax.swing.JTextField txtNoSeguro;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtSeguro;
    // End of variables declaration//GEN-END:variables

    public synchronized void llenarTabla() {

        String titulos[] = {"Descripcion del Antecedente"};
        Object registro[] = new Object[1];
        jtPadres.removeAll();

        DefaultTableModel miTabla = new DefaultTableModel(null, titulos);
        
        M_Consulta.select(
                Consulta
                        .builder()
                        .idPaciente(idPaciente)
                        .build()
        ).stream().forEach(
                consulta -> {
                    M_Antecedente.select(
                            Antecedente
                                    .builder()
                                    .idConsulta(consulta.getId())
                                    .build()
                    ).stream().forEach(
                            antecedente -> {
                                registro[0] = antecedente;
                                miTabla.addRow(registro);
                            }
                    );
                }
        );
        jtPadres.setModel(miTabla);
    }
}
