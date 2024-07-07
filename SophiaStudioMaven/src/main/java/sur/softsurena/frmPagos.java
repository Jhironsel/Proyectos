package sur.softsurena;

import Clases.FormatoTabla;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static sur.softsurena.conexion.Conexion.getCnn;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class frmPagos extends javax.swing.JInternalFrame {

    private int largo;
    private int ancho;

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public frmPagos() {
        initComponents();
        jtAlumno.setAutoscrolls(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lSugerencia = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jlNombreAlumno = new javax.swing.JLabel();
        jlApellidosAlumno = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jlNombrePadre = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jlDocumento = new javax.swing.JLabel();
        jlTandaAlumno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAlumno = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        btnPago = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtAnoInicial = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAnoFinal = new javax.swing.JTextField();
        chbPeriodo = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        txtMatricula = new javax.swing.JTextField();
        btnBuscarEstudiante = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pagos de Estudiante");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
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
            }
        });

        lSugerencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Alumno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nombre: ");

        jlNombreAlumno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jlApellidosAlumno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Apellidos:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlNombreAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlApellidosAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jlNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jlApellidosAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Alumno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Nombre: ");

        jlNombrePadre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Cedula: ");

        jlDocumento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlNombrePadre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jlNombrePadre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jlDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jlTandaAlumno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tanda del Alumno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jtAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtAlumno.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtAlumno);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Monto Pago: ");

        txtPago.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPago.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPago.setName(""); // NOI18N
        txtPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagoKeyTyped(evt);
            }
        });

        btnPago.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Money48x48.png"))); // NOI18N
        btnPago.setText("Pago");
        btnPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Periodo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        txtAnoInicial.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtAnoInicial.setText("2014");
        txtAnoInicial.setEnabled(false);
        txtAnoInicial.setName(""); // NOI18N
        txtAnoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnoInicialKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("/");

        txtAnoFinal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtAnoFinal.setText("2015");
        txtAnoFinal.setEnabled(false);
        txtAnoFinal.setName(""); // NOI18N
        txtAnoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnoFinalKeyTyped(evt);
            }
        });

        chbPeriodo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chbPeriodo.setText("Periodo Definido");
        chbPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbPeriodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbPeriodo)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtAnoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAnoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbPeriodo)
                .addGap(0, 0, 0))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matricula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        txtMatricula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtMatricula.setName(""); // NOI18N
        txtMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMatriculaKeyTyped(evt);
            }
        });

        btnBuscarEstudiante.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscarEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buscar3 32 x 32.png"))); // NOI18N
        btnBuscarEstudiante.setText("Buscar");
        btnBuscarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEstudianteActionPerformed(evt);
            }
        });
        btnBuscarEstudiante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnBuscarEstudianteKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscarEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lSugerencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jlTandaAlumno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPago))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(lSugerencia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlTandaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPago, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatriculaKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 48 && k <= 57 || k == 8) {
            lSugerencia.setText("");
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugerencia.setText("No puede ingresar letras!!!");
        }
    }//GEN-LAST:event_txtMatriculaKeyTyped
    int id_Tanda;
    String periodo;
    private DefaultTableModel miTabla;
    private void btnBuscarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEstudianteActionPerformed
//            ResultSet rs = misFb.getEstudiante(txtMatricula.getText());
        ResultSet rs = null;
        try {
            if (rs.next()) {
                jlNombreAlumno.setText(rs.getString("NOMBRES"));
                jlApellidosAlumno.setText(rs.getString("Apellidos"));
                jlNombrePadre.setText(rs.getString("NombrePadre"));
                jlTandaAlumno.setText(rs.getString("dias"));
                jlDocumento.setText(rs.getString("CEDULA_PADREMADRE"));
                id_Tanda = rs.getInt("Id_Tanda");
                periodo = rs.getString("PERIODO_ACTUAL");
            } else {
                JOptionPane.showMessageDialog(this, "Alumno no encontrado...!");
                return;
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE, 
                    ex.getMessage(), 
                    ex
            );
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        if (chbPeriodo.isSelected()) {
            periodo = txtAnoInicial.getText() + "/" + txtAnoFinal.getText();
        }

//        rs = misFb.getMensualidad(txtMatricula.getText(), periodo);
        try {
            String titulos[] = {"# Mensualidad",
                "Fecha de Pago",
                "Estado",
                "Monto",
                "Pagado",
                "Total",
                "Fecha Pagado",
                "Fecha Abono",
                "Periodo"};
            String registro[] = new String[titulos.length];
            miTabla = new DefaultTableModel(null, titulos);
            while (rs.next()) {
                registro[0] = rs.getString("Consecutivo");
                registro[1] = rs.getString("Fecha_Pago");
                registro[2] = rs.getString("Estado");
                registro[3] = rs.getString("Monto");
                registro[4] = rs.getString("Pagado");
                registro[5] = rs.getString("Total");
                registro[6] = rs.getString("Fecha_Pagado");
                registro[7] = rs.getString("Fecha_Abono");
                registro[8] = rs.getString("Periodo");
                miTabla.addRow(registro);
            }

            jtAlumno.setModel(miTabla);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        FormatoTabla ft = new FormatoTabla(2);
        jtAlumno.setDefaultRenderer(Object.class, ft);

        jtAlumno.getColumnModel().getColumn(0).setMaxWidth(90);
        jtAlumno.getColumnModel().getColumn(0).setMinWidth(90);
        jtAlumno.getColumnModel().getColumn(1).setMaxWidth(95);
        jtAlumno.getColumnModel().getColumn(1).setMinWidth(95);
        jtAlumno.getColumnModel().getColumn(2).setMaxWidth(90);
        jtAlumno.getColumnModel().getColumn(2).setMinWidth(90);
        jtAlumno.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(100);
        jtAlumno.getTableHeader().getColumnModel().getColumn(2).setMinWidth(100);
    }//GEN-LAST:event_btnBuscarEstudianteActionPerformed

    private void txtPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 48 && k <= 57 || k == 8) {
            lSugerencia.setText("");
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugerencia.setText("No puede ingresar letras!!!");
        }
    }//GEN-LAST:event_txtPagoKeyTyped
    private void cerrar() {
        frmPrincipal miPrincipal = new frmPrincipal();
        miPrincipal.dpnEscritorio.getDesktopManager().closeFrame(this);
    }
    private final String logotipo = "/Reportes/Logo.jpg";
    private void btnPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoActionPerformed
        if (txtPago.getText().equals("")) {
            lSugerencia.setText("Inserte una Cantidad");
            return;
        }

//        misFb.pPagoMensualidad("" + getIdUsuario(), txtPago.getText(),
//                txtMatricula.getText(), jtAlumno.getValueAt(jtAlumno.getSelectedRow(), 1).toString());

//        String archivo = misFb.getPatch("Recibo");
        String archivo = "";

        JasperReport masterReporte = null;

        try {
            JDialog viewer = new JDialog(new javax.swing.JFrame(),
                    "Este Mensaje nunca lo he visto", true);
            viewer.setSize(getAncho() - 200, getLargo() - 200);
            viewer.setLocationRelativeTo(null);

            Map parametros = new HashMap();
            parametros.clear();
            parametros.put("matricula", Integer.parseInt(txtMatricula.getText()));
            parametros.put("fecha", Date.valueOf(jtAlumno.getValueAt(jtAlumno.getSelectedRow(), 1).toString()));
            parametros.put("periodo", periodo);
            parametros.put("pago", Double.parseDouble(txtPago.getText()));
            parametros.put("logo", this.getClass().getResourceAsStream(logotipo));

            masterReporte = (JasperReport) JRLoader.loadObjectFromFile(archivo);
            JasperPrint jp = JasperFillManager.fillReport(masterReporte, parametros, getCnn());
            JasperViewer jviewer = new JasperViewer(jp, false);

            viewer.getContentPane().add(jviewer.getContentPane());
            viewer.setTitle("Reporte por Grupo de Estudiantes por dia de clase");
            viewer.setVisible(true);
        } catch (JRException ex) {
            LOG.log(
                    Level.SEVERE, 
                    ex.getMessage(), 
                    ex
            );
        }
        cerrar();
    }//GEN-LAST:event_btnPagoActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        Calendar c = Calendar.getInstance();

        int ano_Inicial = c.get(Calendar.YEAR) - 1;
        int ano_Final = c.get(Calendar.YEAR);

        txtAnoInicial.setText("" + ano_Inicial);
        txtAnoFinal.setText("" + ano_Final);

        txtMatricula.setText("");
        jlNombreAlumno.setText("");
        jlApellidosAlumno.setText("");
        jlNombrePadre.setText("");
        jlDocumento.setText("");
        jlTandaAlumno.setText("");
        chbPeriodo.setSelected(false);
        txtPago.setText("");
        txtAnoInicial.setEnabled(false);
        txtAnoFinal.setEnabled(false);
        String titulos[] = {"# Mensualidad",
            "Fecha de Pago",
            "Dias Faltante",
            "Caso",
            "Estado",
            "Monto",
            "Pagado",
            "Total",
            "Fecha Pagado",
            "Fecha Abono",
            "Periodo"};
        String registro[] = new String[titulos.length];
        miTabla = new DefaultTableModel(null, titulos);
        jtAlumno.setModel(miTabla);
    }//GEN-LAST:event_formInternalFrameActivated

    private void txtAnoFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoFinalKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 48 && k <= 57 || k == 8) {
            lSugerencia.setText("");
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugerencia.setText("No puede ingresar letras!!!");
        }
    }//GEN-LAST:event_txtAnoFinalKeyTyped

    private void txtAnoInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoInicialKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 48 && k <= 57 || k == 8) {
            lSugerencia.setText("");
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugerencia.setText("No puede ingresar letras!!!");
        }
    }//GEN-LAST:event_txtAnoInicialKeyTyped

    private void chbPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbPeriodoActionPerformed
        if (chbPeriodo.isSelected()) {
            txtAnoInicial.setEnabled(true);
            txtAnoFinal.setEnabled(true);
        } else {
            txtAnoInicial.setEnabled(false);
            txtAnoFinal.setEnabled(false);
        }
    }//GEN-LAST:event_chbPeriodoActionPerformed

    private void btnBuscarEstudianteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarEstudianteKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 48 && k <= 57 || k == 8) {
            lSugerencia.setText("");
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugerencia.setText("No puede ingresar letras!!!");
        }
    }//GEN-LAST:event_btnBuscarEstudianteKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarEstudiante;
    private javax.swing.JButton btnPago;
    private javax.swing.JCheckBox chbPeriodo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlApellidosAlumno;
    private javax.swing.JLabel jlDocumento;
    private javax.swing.JLabel jlNombreAlumno;
    private javax.swing.JLabel jlNombrePadre;
    private javax.swing.JLabel jlTandaAlumno;
    private javax.swing.JTable jtAlumno;
    private javax.swing.JLabel lSugerencia;
    private javax.swing.JTextField txtAnoFinal;
    private javax.swing.JTextField txtAnoInicial;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtPago;
    // End of variables declaration//GEN-END:variables
}
