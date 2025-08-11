package sur.softsurena.vista;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import sur.softsurena.entidades.Tanda;
import static sur.softsurena.metodos.M_Tanda.agregarTanda;
import static sur.softsurena.metodos.M_Tanda.modificarTanda;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.LOG;
import static sur.softsurena.utilidades.Utilidades.objectToDate;

public class VistaAjusteTandas extends javax.swing.JInternalFrame {

    public VistaAjusteTandas() {
        initComponents();

    }

    private Boolean validar(String Dato) {
        switch (Dato) {
            case "1":
                return true;
            case "0":
                return false;
            default:
                return false;
        }
    }

    Integer ent[] = null;

    private void llenarTabla() {
        tblTandas.setRowHeight(22);
        Object obj[][] = null;

        try {
            int i = 0;
//            obj = new Object[valorMaxTanda()][11];
//            ent = new Integer[valorMaxTanda()];
//            ResultSet rs = getHorario();
            ResultSet rs = null;
            while (rs.next()) {
                ent[i] = rs.getInt(1);
                obj[i][0] = "" + rs.getDate(2);
                obj[i][1] = "" + rs.getDate(3);
                obj[i][2] = "" + rs.getTime(4);
                obj[i][3] = "" + rs.getTime(5);
                obj[i][4] = validar(rs.getString(6));
                obj[i][5] = validar(rs.getString(7));
                obj[i][6] = validar(rs.getString(8));
                obj[i][7] = validar(rs.getString(9));
                obj[i][8] = validar(rs.getString(10));
                obj[i][9] = validar(rs.getString(11));
                obj[i][10] = validar(rs.getString(12));
                i++;
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        tblTandas.setModel(new javax.swing.table.DefaultTableModel(
                obj, new String[]{
                    "Fecha Inicio", "Fecha Final", "Hora Inicio",
                    "Hora Final", "Lunes", "Martes", "Miercoles",
                    "Jueves", "Viernes", "Sabado", "Domingo"
                }
        ) {
            Class<?>[] types = new Class<?>[]{
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Boolean.class,
                java.lang.Boolean.class,
                java.lang.Boolean.class,
                java.lang.Boolean.class,
                java.lang.Boolean.class,
                java.lang.Boolean.class,
                java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false,
                false, false
            };

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTandas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnInsertar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dchFechaInicial = new com.toedter.calendar.JDateChooser();
        dchFechaFinal = new com.toedter.calendar.JDateChooser();
        horaInicial = new lu.tudor.santec.jtimechooser.JTimeChooser();
        horaFinal = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jPanel1 = new javax.swing.JPanel();
        chLunes = new javax.swing.JCheckBox();
        chMartes = new javax.swing.JCheckBox();
        chMiercoles = new javax.swing.JCheckBox();
        chJueves = new javax.swing.JCheckBox();
        chViernes = new javax.swing.JCheckBox();
        chSabado = new javax.swing.JCheckBox();
        chDomingo = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        cbEdadMinimaMaxima = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        txtEdadMinima = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEdadMaxima = new javax.swing.JTextField();
        lSugerencia = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ajusto y Creacion de Tandas");
        setPreferredSize(new java.awt.Dimension(800, 500));
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

        tblTandas.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        tblTandas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Hora Inicio", "Hora Final", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTandas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTandasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTandas);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Botones de Acción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        btnInsertar.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Agregar 32 x 32.png"))); // NOI18N
        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Editar Documento 32 x 32.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Borrar 32 x 32.png"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Guardar 32 x 32.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(135, 135, 135)
                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsertar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles de Tandas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Fecha de Inicio: ");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Fecha de Final: ");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Hora de Inicio: ");

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Hora de Final: ");

        dchFechaInicial.setDateFormatString("yyyy-MM-dd");
        dchFechaInicial.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        dchFechaFinal.setDateFormatString("yyyy-MM-dd");
        dchFechaFinal.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        horaInicial.setDoubleBuffered(true);

        horaFinal.setDoubleBuffered(true);
        horaFinal.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecciones Dias de la Semana", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        chLunes.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        chLunes.setText("Lunes");

        chMartes.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        chMartes.setText("Martes");

        chMiercoles.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        chMiercoles.setText("Miercoles");

        chJueves.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        chJueves.setText("Jueves");

        chViernes.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        chViernes.setText("Viernes");

        chSabado.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        chSabado.setText("Sabado");

        chDomingo.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        chDomingo.setText("Domingo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chLunes)
                            .addComponent(chJueves))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chMartes)
                            .addComponent(chViernes))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chSabado)
                            .addComponent(chMiercoles)))
                    .addComponent(chDomingo)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chLunes)
                    .addComponent(chMartes)
                    .addComponent(chMiercoles))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chJueves)
                    .addComponent(chViernes)
                    .addComponent(chSabado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chDomingo))
        );

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Cantidad de Estudiantes:");

        txtCantidad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        cbEdadMinimaMaxima.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        cbEdadMinimaMaxima.setText("Con Edades Minima y Maxima");
        cbEdadMinimaMaxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEdadMinimaMaximaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Edad Minima:");

        txtEdadMinima.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtEdadMinima.setEnabled(false);
        txtEdadMinima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadMinimaKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Edad Maxima:");

        txtEdadMaxima.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtEdadMaxima.setEnabled(false);
        txtEdadMaxima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadMaximaKeyTyped(evt);
            }
        });

        lSugerencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lSugerencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(horaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dchFechaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dchFechaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(horaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEdadMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdadMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cbEdadMinimaMaxima)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCantidad, txtEdadMaxima, txtEdadMinima});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cbEdadMinimaMaxima)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdadMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdadMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(dchFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dchFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(horaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(horaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lSugerencia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCantidad, txtEdadMaxima, txtEdadMinima});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel11, jLabel12, jLabel9});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dchFechaFinal, dchFechaInicial, horaFinal, horaInicial});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        Limpiar();
    }//GEN-LAST:event_formInternalFrameActivated

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        encender();
        gre.set(0, 0, 0, 0, 0, 0);
        horaInicial.setTime(gre.getTime());
        horaFinal.setTime(gre.getTime());
        dchFechaInicial.setDate(null);
        dchFechaFinal.setDate(null);
        chLunes.setSelected(false);
        chMartes.setSelected(false);
        chMiercoles.setSelected(false);
        chJueves.setSelected(false);
        chViernes.setSelected(false);
        chSabado.setSelected(false);
        chDomingo.setSelected(false);
        cbEdadMinimaMaxima.setSelected(false);
        txtCantidad.setText("");
        txtEdadMaxima.setText("");
        txtEdadMinima.setText("");

        btnGuardar.setEnabled(true);
        btnInsertar.setEnabled(false);
        btnModificar.setEnabled(false);
        v_nuevo = true;
    }//GEN-LAST:event_btnInsertarActionPerformed

    GregorianCalendar gre = new GregorianCalendar();

    private void encender() {
        dchFechaInicial.setEnabled(true);
        dchFechaFinal.setEnabled(true);
        horaInicial.setEnabled(true);
        horaFinal.setEnabled(true);
        chLunes.setEnabled(true);
        chMartes.setEnabled(true);
        chMiercoles.setEnabled(true);
        chJueves.setEnabled(true);
        chViernes.setEnabled(true);
        chSabado.setEnabled(true);
        chDomingo.setEnabled(true);
    }

    private void apagar() {
        gre.set(0, 0, 0, 0, 0, 0);
        horaInicial.setTime(gre.getTime());
        horaFinal.setTime(gre.getTime());

        dchFechaInicial.setEnabled(false);
        dchFechaFinal.setEnabled(false);
        horaInicial.setEnabled(false);
        horaFinal.setEnabled(false);
        chLunes.setEnabled(false);
        chMartes.setEnabled(false);
        chMiercoles.setEnabled(false);
        chJueves.setEnabled(false);
        chViernes.setEnabled(false);
        chSabado.setEnabled(false);
        chDomingo.setEnabled(false);
    }

    private void cerrar() {
        VistaPrincipal miPrincipal = new VistaPrincipal();
        miPrincipal.dpnEscritorio.getDesktopManager().closeFrame(this);
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cerrar();
        apagar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        if (txtCantidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Selecionar una Tanda");
            return;
        }
        encender();
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnInsertar.setEnabled(false);
        v_nuevo = false;
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tblTandasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTandasMouseClicked
        dchFechaInicial.setDate(objectToDate(tblTandas.getValueAt(
                tblTandas.getSelectedRow(), 0)));
        dchFechaFinal.setDate(objectToDate(tblTandas.getValueAt(
                tblTandas.getSelectedRow(), 1)));
        horaInicial.setTime(Utilidades.objectToTime(tblTandas.getValueAt(
                tblTandas.getSelectedRow(), 2)));
        horaFinal.setTime(Utilidades.objectToTime(tblTandas.getValueAt(
                tblTandas.getSelectedRow(), 3)));
        chLunes.setSelected((boolean) tblTandas.getValueAt(
                tblTandas.getSelectedRow(), 4));
        chMartes.setSelected((boolean) tblTandas.getValueAt(
                tblTandas.getSelectedRow(), 5));
        chMiercoles.setSelected((boolean) tblTandas.getValueAt(
                tblTandas.getSelectedRow(), 6));
        chJueves.setSelected((boolean) tblTandas.getValueAt(
                tblTandas.getSelectedRow(), 7));
        chViernes.setSelected((boolean) tblTandas.getValueAt(
                tblTandas.getSelectedRow(), 8));
        chSabado.setSelected((boolean) tblTandas.getValueAt(
                tblTandas.getSelectedRow(), 9));
        chDomingo.setSelected((boolean) tblTandas.getValueAt(
                tblTandas.getSelectedRow(), 10));
//        ResultSet rs = getTandas(ent[tblTabla.getSelectedRow()]);
        ResultSet rs = null;
        try {
            while (rs.next()) {
                txtCantidad.setText(rs.getString("cantidad_estudiantes"));
                txtEdadMinima.setText(rs.getString("edad_minima"));
                txtEdadMaxima.setText(rs.getString("edad_maxima"));
                cbEdadMinimaMaxima.setSelected(rs.getBoolean("con_edad"));
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }//GEN-LAST:event_tblTandasMouseClicked
    boolean v_nuevo = false;
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (cbEdadMinimaMaxima.isSelected()) {
            if (txtEdadMinima.getText().isBlank()) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Edad minima Vacia debe de inserta edad!",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                txtEdadMinima.requestFocus();
                return;
            }
            if (txtEdadMaxima.getText().isBlank()) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Edad maxima Vacia debe de inserta edad!",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                txtEdadMaxima.requestFocus();
                return;
            }
        }

        Tanda miTanda = Tanda
                .builder()
                .id_tanda(
                        ((Tanda) tblTandas.getValueAt(tblTandas.getSelectedRow(), 0)).getId_tanda()
                )
                .anno_inicial(
                        new java.sql.Date(
                                dchFechaInicial.getCalendar().getTimeInMillis()
                        )
                )
                .anno_final(
                        new java.sql.Date(
                                dchFechaFinal.getCalendar().getTimeInMillis()
                        )
                )
                .hora_inicial(
                        new java.sql.Time(
                                horaInicial.getCalendarWithTime(
                                        new Calendar.Builder().build()
                                ).getTimeInMillis()
                        )
                )
                .hora_final(
                        new java.sql.Time(
                                horaFinal.getCalendarWithTime(
                                        new Calendar.Builder().build()
                                ).getTimeInMillis()
                        )
                )
                .lunes(chLunes.isSelected())
                .martes(chMartes.isSelected())
                .miercoles(chMiercoles.isSelected())
                .jueves(chJueves.isSelected())
                .viernes(chViernes.isSelected())
                .sabados(chSabado.isSelected())
                .domingos(chDomingo.isSelected())
                .cantidad_estudiantes(
                        Integer.valueOf(
                                txtCantidad.getText()
                        )
                )
                .edad_minima(Integer.valueOf(txtEdadMinima.getText()))
                .edad_maxima(Integer.valueOf(txtEdadMaxima.getText()))
                .con_edad(cbEdadMinimaMaxima.isSelected())
                .build();
        
        Resultado resultado = (
                v_nuevo ? 
                agregarTanda(miTanda) : modificarTanda(miTanda)
                );
        
        JOptionPane.showInternalMessageDialog(
                this, 
                resultado.getMensaje(),
                "",
                resultado.getIcono()
        );
        
        btnGuardar.setEnabled(false);
        btnInsertar.setEnabled(true);
        btnModificar.setEnabled(true);
        Limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed
    private void Limpiar() {
        Calendar c2 = new GregorianCalendar();
        dchFechaInicial.setDate(c2.getTime());

        c2.set(dchFechaInicial.getCalendar().get(1) + 1,
                dchFechaInicial.getCalendar().get(2),
                dchFechaInicial.getCalendar().get(5));

        dchFechaFinal.setDate(c2.getTime());

        gre.set(0, 0, 0, 0, 0, 0);
        horaInicial.setTime(gre.getTime());
        horaFinal.setTime(gre.getTime());

        chLunes.setSelected(false);
        chMartes.setSelected(false);
        chMiercoles.setSelected(false);
        chJueves.setSelected(false);
        chViernes.setSelected(false);
        chSabado.setSelected(false);
        chDomingo.setSelected(false);

        txtCantidad.setText("");
        txtEdadMinima.setText("");
        txtEdadMaxima.setText("");

        cbEdadMinimaMaxima.setSelected(false);

        llenarTabla();
        apagar();
    }

    private void cbEdadMinimaMaximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEdadMinimaMaximaActionPerformed
        if (cbEdadMinimaMaxima.isSelected()) {
            txtEdadMaxima.setEnabled(true);
            txtEdadMinima.setEnabled(true);
        } else {
            txtEdadMaxima.setEnabled(false);
            txtEdadMinima.setEnabled(false);
        }
    }//GEN-LAST:event_cbEdadMinimaMaximaActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 48 && k <= 57 || k == 8) {
            lSugerencia.setText("");
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugerencia.setText("No puede ingresar letras!!!");
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtEdadMinimaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadMinimaKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 48 && k <= 57 || k == 8) {
            lSugerencia.setText("");
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugerencia.setText("No puede ingresar letras!!!");
        }
    }//GEN-LAST:event_txtEdadMinimaKeyTyped

    private void txtEdadMaximaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadMaximaKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 48 && k <= 57 || k == 8) {
            lSugerencia.setText("");
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            lSugerencia.setText("No puede ingresar letras!!!");
        }
    }//GEN-LAST:event_txtEdadMaximaKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JCheckBox cbEdadMinimaMaxima;
    private javax.swing.JCheckBox chDomingo;
    private javax.swing.JCheckBox chJueves;
    private javax.swing.JCheckBox chLunes;
    private javax.swing.JCheckBox chMartes;
    private javax.swing.JCheckBox chMiercoles;
    private javax.swing.JCheckBox chSabado;
    private javax.swing.JCheckBox chViernes;
    private com.toedter.calendar.JDateChooser dchFechaFinal;
    private com.toedter.calendar.JDateChooser dchFechaInicial;
    private lu.tudor.santec.jtimechooser.JTimeChooser horaFinal;
    private lu.tudor.santec.jtimechooser.JTimeChooser horaInicial;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lSugerencia;
    private javax.swing.JTable tblTandas;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtEdadMaxima;
    private javax.swing.JTextField txtEdadMinima;
    // End of variables declaration//GEN-END:variables
}
