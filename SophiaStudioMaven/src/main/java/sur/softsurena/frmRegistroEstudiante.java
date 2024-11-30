package sur.softsurena;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import sur.softsurena.entidades.Estudiante;
import static sur.softsurena.metodos.M_Padre.validarPadreMadre;
import static sur.softsurena.utilidades.Utilidades.LOG;
//import sur.softsurena.entidades.Estudiantes;

public class frmRegistroEstudiante extends javax.swing.JInternalFrame {

    private Integer edad;
    private String edad2;
    private ResultSet rs;

    public frmRegistroEstudiante() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtCedula = new javax.swing.JFormattedTextField();
        btnAplicarPadre = new javax.swing.JButton();
        jcbParentesco = new javax.swing.JComboBox<>();
        txtPNombrePadre = new javax.swing.JTextField();
        txtSNombrePadre = new javax.swing.JTextField();
        txtApellidosPadres = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jcbSexo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtPNombre = new javax.swing.JTextField();
        txtSNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        dchFecha = new com.toedter.calendar.JDateChooser();
        cbTanda = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnInscribir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ingresar Estudiantes al Sistema de Ballet");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Datos del Tutor ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        try {
            txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula.setFont(new java.awt.Font("FreeMono", 0, 14)); // NOI18N

        btnAplicarPadre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAplicarPadre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buscar3 32 x 32.png"))); // NOI18N
        btnAplicarPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarPadreActionPerformed(evt);
            }
        });

        jcbParentesco.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jcbParentesco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Parentesco", "PADRE", "MADRE", "TUTOR" }));

        txtPNombrePadre.setEditable(false);
        txtPNombrePadre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtSNombrePadre.setEditable(false);
        txtSNombrePadre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtApellidosPadres.setEditable(false);
        txtApellidosPadres.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtDireccion.setEditable(false);
        txtDireccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jcbSexo.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contactos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 14))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tipo", "Tel / Email"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel8.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jLabel8.setText("Apellidos:");

        jLabel7.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jLabel7.setText("Primer Nombre:");

        jLabel3.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jLabel3.setText("Cedula Padre:");

        jLabel9.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jLabel9.setText("Sexo:");

        jLabel12.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jLabel12.setText("Direccion:");

        jLabel13.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jLabel13.setText("Segundo Nombre:");

        jLabel14.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        jLabel14.setText("Parentesco:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtDireccion)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPNombrePadre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSNombrePadre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAplicarPadre)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9)
                                .addComponent(txtApellidosPadres)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcbParentesco, javax.swing.GroupLayout.Alignment.TRAILING, 0, 200, Short.MAX_VALUE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jcbSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAplicarPadre))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, 0)
                        .addComponent(txtApellidosPadres, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(0, 0, 0)
                            .addComponent(txtPNombrePadre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(0, 0, 0)
                            .addComponent(txtSNombrePadre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSexo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Datos del Estudiante ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        txtPNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPNombre.setEnabled(false);

        txtSNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtSNombre.setEnabled(false);

        txtApellidos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtApellidos.setEnabled(false);

        dchFecha.setDateFormatString("dd-MM-yyyy");
        dchFecha.setEnabled(false);
        dchFecha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cbTanda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbTanda.setAutoscrolls(true);
        cbTanda.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Primer Nombre:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Fecha de Nacimiento: ");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Tanda: ");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Apellidos:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Segundo Nombre:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPNombre)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dchFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbTanda, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtApellidos, txtPNombre, txtSNombre});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dchFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTanda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtApellidos, txtPNombre, txtSNombre});

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnInscribir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnInscribir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Agregar.png"))); // NOI18N
        btnInscribir.setText("Registrar");
        btnInscribir.setEnabled(false);
        btnInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscribirActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnConsultar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buscar32x32.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setEnabled(false);
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConsultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnInscribir)
                    .addComponent(btnCancelar)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelar, btnConsultar, btnInscribir});

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnAplicarPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarPadreActionPerformed
        if (txtCedula.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Digitar la Cedula del Padre del Alumno!!!",
                    "Error Validacion", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (txtCedula.getText().length() != 11) {
            JOptionPane.showMessageDialog(this,
                    "Cedula Incorrecta, Digite 11 Numeros...!",
                    "Error Validacion", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!validarPadreMadre(txtCedula.getText().trim())) {
            JOptionPane.showMessageDialog(this,
                    "Padre no encontrado!!!",
                    "Identificacion Invalida...!", JOptionPane.ERROR_MESSAGE);
            limpiearCampos();
            txtCedula.requestFocus();
            btnInscribir.setEnabled(false);
            return;
        }
        
        //TODO Crear este metodo.
        //rs = getPadreMadres(txtCedula.getText().trim());
        
        try {
            rs.next();
            if (rs.getString("Estado").equals("0")) {
                JOptionPane.showMessageDialog(this,
                        "Padre Inactivo, revisar Deudas y Suspensiones...",
                        "Padre Actualmente Inactivo", JOptionPane.ERROR_MESSAGE);
                limpiearCampos();
                txtCedula.requestFocus();
                btnInscribir.setEnabled(false);
                return;
            }
            txtPNombrePadre.setText(rs.getString("Nombres"));
            txtApellidosPadres.setText(rs.getString("Apellidos"));
            jcbSexo.addItem(rs.getString("Sexo"));
            txtDireccion.setText(rs.getString("Direccion"));
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        txtPNombre.setEnabled(true);
        txtApellidos.setEnabled(true);
        cbTanda.setEnabled(true);
        dchFecha.setEnabled(true);
        btnInscribir.setEnabled(true);
        btnConsultar.setEnabled(true);
    }//GEN-LAST:event_btnAplicarPadreActionPerformed
    public void limpiearCampos() {
        txtCedula.setText("");
        txtPNombrePadre.setText("");
        txtApellidosPadres.setText("");
        jcbSexo.setSelectedIndex(0);
        txtDireccion.setText("");
        txtPNombre.setText("");
        txtApellidos.setText("");
        cbTanda.setSelectedIndex(-1);
        dchFecha.setDate(null);
        txtPNombre.setEnabled(false);
        txtApellidos.setEnabled(false);
        cbTanda.setEnabled(false);
        dchFecha.setEnabled(false);
        btnInscribir.setEnabled(false);
        btnConsultar.setEnabled(false);
    }
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        limpiearCampos();
    }//GEN-LAST:event_formInternalFrameActivated

    int[] idTanda = new int[1000];
    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed
        if (txtPNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nombre de Estudiante en Blanco...!!!");
            return;
        }
        if (txtApellidos.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Apellido de Estudiante en Blanco...!!!!");
            return;
        }
        if (dchFecha.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Fecha en Blanco");
            return;
        }
        if(cbTanda.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(this, "Seleccione una Tanda...");
            return;
        }
        //int mes = dchFecha.getCalendar().get(Calendar.MONTH) + 1;
        //mes+"/"+ dchFecha.getCalendar().get(Calendar.DAY_OF_MONTH)+"/"+ dchFecha.getCalendar().get(Calendar.YEAR)
        Estudiante miEstudiante 
                = Estudiante
                        .builder()
                        .pnombre(txtPNombre.getText().strip())
                        .apellidos(txtApellidos.getText().strip())
                        //.Tanda(idTanda[cbTanda.getSelectedIndex()])
                        .fecha_nacimiento(new java.sql.Date(dchFecha.getDate().getTime()))
                        .estado(Boolean.TRUE)
                        .build();
        
        //String dime = agregarEstudiante(miEstudiante);
        
//        String dime = insertarEstudiante(miEstudiante);
        String dime = "";
        
        JOptionPane.showMessageDialog(this, dime);

        if (dime.equals("Estudiante Agregado Correctamente")) {
            
            frmPrincipal miFrm = new frmPrincipal();
            
            JDImprimir miJD = new JDImprimir(miFrm, true);
            
            Calendar c1 = Calendar.getInstance();
            String di = Integer.toString(c1.get(Calendar.DATE));
            String me = Integer.toString(c1.get(Calendar.MONTH)+1);
            String an = Integer.toString(c1.get(Calendar.YEAR));
            
            //35 Columnas
            //Integer Matricula = getMaxMatricula();
            Integer Matricula = 0;
            
            miJD.txtArea.setText("<p align=center> Bienvenido a Sophia Estudio</p>"
                    + "<p align=right> Fecha de Ingreso:<b>" + di + "/" + me + "/" + an+"</b></p>"
                    + "<p align=justify>"+(jcbSexo.getSelectedItem().toString().equals("F") ? "Sra. " : "Sr. ")
                    + "<b>" +txtApellidosPadres.getText().trim()+", "
                    + " " + txtPNombrePadre.getText().trim()+"</b>"
                    + " en nuestro Sistema tenemos registrado el niño/a "
                    + "<b>" +txtPNombre.getText().trim()
                    + " "
                    + txtApellidos.getText().trim()+"</b>"
                    + ", Dicho alumno/a cuenta con una "
                    +"Matricula para facilitar el pago mensual la cual debe "
                    +"ser proporcionada al momento de pagar la mensualidad: "
                    + "<b>" +Matricula+".</b></p>"
                    + "<p align=justify>Dicho pagos se realizaran los dias corresponidiente al inicio de la primera clase."
                    + " Los dias que el niño/a recibira clase sera: <b>"
                    + cbTanda.getSelectedItem().toString()+".</b></p>"
            );            
            miJD.setVisible(true);
            miJD.setLocationRelativeTo(null);
            cerrar();
        }
        cerrar();
    }//GEN-LAST:event_btnInscribirActionPerformed
    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        cbTanda.removeAllItems();
        if (dchFecha.getDate() == null){
            JOptionPane.showMessageDialog(this, "Fecha de nacimiento Vacia... Selecionar Fecha!!!");
            return;
        }
        try {
            Calendar c = Calendar.getInstance();
            edad = c.get(Calendar.YEAR) - dchFecha.getCalendar().get(Calendar.YEAR);
            edad2 = "" + edad;
            
//            rs = getTandas(edad2);
            
            int i = 0;
            
            while (rs.next()) {
                idTanda[i] = rs.getInt(1);
                cbTanda.addItem(rs.getObject(2));
                i++;
            }
            if (cbTanda.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "No se encuentra una Tanda para Dicho Estudiante....");
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cerrar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cerrar() {
        frmPrincipal miPrincipal = new frmPrincipal();
        miPrincipal.dpnEscritorio.getDesktopManager().closeFrame(this);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicarPadre;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnInscribir;
    private javax.swing.JComboBox cbTanda;
    private com.toedter.calendar.JDateChooser dchFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcbParentesco;
    private javax.swing.JComboBox<String> jcbSexo;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtApellidosPadres;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtPNombre;
    private javax.swing.JTextField txtPNombrePadre;
    private javax.swing.JTextField txtSNombre;
    private javax.swing.JTextField txtSNombrePadre;
    // End of variables declaration//GEN-END:variables
}
