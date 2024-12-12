package sur.softsurena.archivos;

import com.toedter.calendar.JTextFieldDateEditor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.entidades.ARS;
import sur.softsurena.entidades.Generales;
import sur.softsurena.entidades.Padre;
import sur.softsurena.entidades.TipoSangre;
import sur.softsurena.formularios.frmPrincipal;
import sur.softsurena.metodos.M_Padre;
import sur.softsurena.utilidades.FiltroBusqueda;
import sur.softsurena.utilidades.Utilidades;

public class frmPadres extends javax.swing.JInternalFrame {

    private static frmPadres padres;
    private static String cliente;
    private static int cliPadre;
    private static boolean nuevo;
    private static DefaultTableModel miTabla;
    private static JTextFieldDateEditor editor;
    private static JButton button;

    public frmPadres() {
        initComponents();

        //dchFechaNamiento Personalizar
        editor = (JTextFieldDateEditor) dchFechaNacimiento.getDateEditor();

        button = dchFechaNacimiento.getCalendarButton();

        editor.setEditable(false);
        button.setEnabled(false);

        //jtPadres.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        dchFechaNacimiento.getDateEditor().addPropertyChangeListener(
                (java.beans.PropertyChangeEvent evt) -> {
                    if (evt.getPropertyName().equals("date")
                    && cbSeguro.isShowing() && cbSeguro.isEnabled()
                    && editor.isEditable()) {
                        cbSeguro.requestFocus();
                        cbSeguro.showPopup();
                    }
                });

    }

    public synchronized static frmPadres getPadres() {

        if (padres == null) {
            padres = new frmPadres();
        }

        if (frmPrincipal.txtUsuario.getText().contains("SECRETARIA")) {
            btnAntecedentes.setVisible(false);
            btnBorrar.setVisible(false);
        } else {
            btnAntecedentes.setVisible(true);
            btnBorrar.setVisible(true);
        }

        return padres;
    }

    public void setCliPadre(int cliPadre) {
        frmPadres.cliPadre = cliPadre;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupo = new javax.swing.ButtonGroup();
        jpmCedula = new javax.swing.JPopupMenu();
        jmSeleccionarTodo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmCopia = new javax.swing.JMenuItem();
        jmCortar = new javax.swing.JMenuItem();
        jmPegar = new javax.swing.JMenuItem();
        jpNombre = new javax.swing.JPopupMenu();
        jmSeleccionarTodo1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmCopia1 = new javax.swing.JMenuItem();
        jmCortar1 = new javax.swing.JMenuItem();
        jmPegar1 = new javax.swing.JMenuItem();
        jpNombre1 = new javax.swing.JPopupMenu();
        jmSeleccionarTodo4 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jmCopia4 = new javax.swing.JMenuItem();
        jmCortar4 = new javax.swing.JMenuItem();
        jmPegar4 = new javax.swing.JMenuItem();
        jpNombre2 = new javax.swing.JPopupMenu();
        jmSeleccionarTodo5 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jmCopia5 = new javax.swing.JMenuItem();
        jmCortar5 = new javax.swing.JMenuItem();
        jmPegar5 = new javax.swing.JMenuItem();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpDetalles = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPadres = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        jpFiltro = new javax.swing.JPanel();
        cbCorreo = new javax.swing.JCheckBox();
        cbPadresActivos = new javax.swing.JCheckBox();
        cbTodos = new javax.swing.JCheckBox();
        cbCiudad = new javax.swing.JCheckBox();
        cbDireccion = new javax.swing.JCheckBox();
        cbFechaNacimiento = new javax.swing.JCheckBox();
        jpDatos = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jpCedula = new javax.swing.JPanel();
        txtCedula = new javax.swing.JFormattedTextField();
        btnValidaCedulaPadre = new javax.swing.JButton();
        btnAntecedentes = new javax.swing.JButton();
        cbEstado = new javax.swing.JCheckBox();
        txtPNombre = new javax.swing.JTextField();
        txtSNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        dchFechaNacimiento = new com.toedter.calendar.JDateChooser();
        cbSexo = new javax.swing.JComboBox();
        cbSangre = new javax.swing.JComboBox();
        cbSeguro = new javax.swing.JComboBox();
        txtNoSeguro = new javax.swing.JFormattedTextField();
        lbCedula = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        jlApellidos = new javax.swing.JLabel();
        lbNombre1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtContactos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        jmSeleccionarTodo.setText("Seleccionar Todo");
        jmSeleccionarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSeleccionarTodoActionPerformed(evt);
            }
        });
        jpmCedula.add(jmSeleccionarTodo);
        jpmCedula.add(jSeparator1);

        jmCopia.setText("Copiar");
        jmCopia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCopiaActionPerformed(evt);
            }
        });
        jpmCedula.add(jmCopia);

        jmCortar.setText("Cortar");
        jmCortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCortarActionPerformed(evt);
            }
        });
        jpmCedula.add(jmCortar);

        jmPegar.setText("Pegar");
        jmPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPegarActionPerformed(evt);
            }
        });
        jpmCedula.add(jmPegar);

        jmSeleccionarTodo1.setText("Seleccionar Todo");
        jmSeleccionarTodo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSeleccionarTodo1ActionPerformed(evt);
            }
        });
        jpNombre.add(jmSeleccionarTodo1);
        jpNombre.add(jSeparator2);

        jmCopia1.setText("Copiar");
        jmCopia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCopia1ActionPerformed(evt);
            }
        });
        jpNombre.add(jmCopia1);

        jmCortar1.setText("Cortar");
        jmCortar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCortar1ActionPerformed(evt);
            }
        });
        jpNombre.add(jmCortar1);

        jmPegar1.setText("Pegar");
        jmPegar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPegar1ActionPerformed(evt);
            }
        });
        jpNombre.add(jmPegar1);

        jmSeleccionarTodo4.setText("Seleccionar Todo");
        jmSeleccionarTodo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSeleccionarTodo4ActionPerformed(evt);
            }
        });
        jpNombre1.add(jmSeleccionarTodo4);
        jpNombre1.add(jSeparator5);

        jmCopia4.setText("Copiar");
        jmCopia4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCopia4ActionPerformed(evt);
            }
        });
        jpNombre1.add(jmCopia4);

        jmCortar4.setText("Cortar");
        jmCortar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCortar4ActionPerformed(evt);
            }
        });
        jpNombre1.add(jmCortar4);

        jmPegar4.setText("Pegar");
        jmPegar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPegar4ActionPerformed(evt);
            }
        });
        jpNombre1.add(jmPegar4);

        jmSeleccionarTodo5.setText("Seleccionar Todo");
        jmSeleccionarTodo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSeleccionarTodo5ActionPerformed(evt);
            }
        });
        jpNombre2.add(jmSeleccionarTodo5);
        jpNombre2.add(jSeparator6);

        jmCopia5.setText("Copiar");
        jmCopia5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCopia5ActionPerformed(evt);
            }
        });
        jpNombre2.add(jmCopia5);

        jmCortar5.setText("Cortar");
        jmCortar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCortar5ActionPerformed(evt);
            }
        });
        jpNombre2.add(jmCortar5);

        jmPegar5.setText("Pegar");
        jmPegar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPegar5ActionPerformed(evt);
            }
        });
        jpNombre2.add(jmPegar5);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento de Padres");
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(720, 480));
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
                formInternalFrameOpened(evt);
            }
        });

        jpDetalles.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
        jpDetalles.setMinimumSize(new java.awt.Dimension(300, 250));

        jtPadres.setAutoCreateRowSorter(true);
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
        jtPadres.setPreferredSize(null);
        jtPadres.getTableHeader().setReorderingAllowed(false);
        jtPadres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPadresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtPadres);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );

        btnGrupo.add(cbCorreo);
        cbCorreo.setText("Correo");
        cbCorreo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCorreoItemStateChanged(evt);
            }
        });

        cbPadresActivos.setSelected(true);
        cbPadresActivos.setText("Padres Activos");
        cbPadresActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPadresActivosActionPerformed(evt);
            }
        });

        btnGrupo.add(cbTodos);
        cbTodos.setSelected(true);
        cbTodos.setText("Ocultar Todas");

        btnGrupo.add(cbCiudad);
        cbCiudad.setText("Ciudad");
        cbCiudad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCiudadItemStateChanged(evt);
            }
        });

        btnGrupo.add(cbDireccion);
        cbDireccion.setText("Dirección");
        cbDireccion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDireccionItemStateChanged(evt);
            }
        });

        btnGrupo.add(cbFechaNacimiento);
        cbFechaNacimiento.setText("Fecha Nacimientos");
        cbFechaNacimiento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFechaNacimientoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jpFiltroLayout = new javax.swing.GroupLayout(jpFiltro);
        jpFiltro.setLayout(jpFiltroLayout);
        jpFiltroLayout.setHorizontalGroup(
            jpFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFiltroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbCorreo)
                .addGap(0, 0, 0)
                .addComponent(cbCiudad)
                .addGap(0, 0, 0)
                .addComponent(cbFechaNacimiento)
                .addGap(0, 0, 0)
                .addComponent(cbDireccion)
                .addGap(0, 0, 0)
                .addComponent(cbTodos)
                .addGap(0, 0, 0)
                .addComponent(cbPadresActivos)
                .addGap(0, 0, 0))
        );
        jpFiltroLayout.setVerticalGroup(
            jpFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFiltroLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jpFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFechaNacimiento)
                    .addComponent(cbCiudad)
                    .addComponent(cbDireccion)
                    .addComponent(cbCorreo)
                    .addComponent(cbPadresActivos)
                    .addComponent(cbTodos))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jpDetallesLayout = new javax.swing.GroupLayout(jpDetalles);
        jpDetalles.setLayout(jpDetallesLayout);
        jpDetallesLayout.setHorizontalGroup(
            jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDetallesLayout.createSequentialGroup()
                .addGroup(jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jpDetallesLayout.setVerticalGroup(
            jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDetallesLayout.createSequentialGroup()
                .addComponent(jpFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Detalles", jpDetalles);

        jpDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));
        jpDatos.setMaximumSize(null);
        jpDatos.setName(""); // NOI18N

        txtCedula.setEditable(false);
        try {
            txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula.setText("000-0000000-0");
        txtCedula.setToolTipText("Inserte el numero de documento del Padre, Este debe ser el numero de cedula.");
        txtCedula.setComponentPopupMenu(jpmCedula);
        txtCedula.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        txtCedula.setMaximumSize(new java.awt.Dimension(120, 27));
        txtCedula.setMinimumSize(new java.awt.Dimension(120, 27));
        txtCedula.setPreferredSize(new java.awt.Dimension(120, 27));
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        btnValidaCedulaPadre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-casilla-de-verificación-2-32.png"))); // NOI18N
        btnValidaCedulaPadre.setEnabled(false);
        btnValidaCedulaPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidaCedulaPadreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpCedulaLayout = new javax.swing.GroupLayout(jpCedula);
        jpCedula.setLayout(jpCedulaLayout);
        jpCedulaLayout.setHorizontalGroup(
            jpCedulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCedulaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnValidaCedulaPadre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jpCedulaLayout.setVerticalGroup(
            jpCedulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCedulaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jpCedulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnValidaCedulaPadre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        btnAntecedentes.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnAntecedentes.setForeground(new java.awt.Color(1, 1, 1));
        btnAntecedentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Salud32x32.png"))); // NOI18N
        btnAntecedentes.setToolTipText("Antecedentes");
        btnAntecedentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAntecedentesActionPerformed(evt);
            }
        });

        cbEstado.setSelected(true);
        cbEstado.setText("Activo");

        txtPNombre.setEditable(false);
        txtPNombre.setToolTipText("Inserte el nombre del Padre o Madre del Paciente");
        txtPNombre.setComponentPopupMenu(jpNombre);
        txtPNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPNombreActionPerformed(evt);
            }
        });

        txtSNombre.setEditable(false);
        txtSNombre.setToolTipText("Inserte el nombre del Padre o Madre del Paciente");
        txtSNombre.setComponentPopupMenu(jpNombre);
        txtSNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSNombreActionPerformed(evt);
            }
        });

        txtApellidos.setEditable(false);
        txtApellidos.setToolTipText("Inserte los apellidos");
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecccione Sexo", "Masculino", "Femenina" }));
        cbSexo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSexoItemStateChanged(evt);
            }
        });
        cbSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSexoActionPerformed(evt);
            }
        });

        cbSangre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Autollena" }));
        cbSangre.setPreferredSize(new java.awt.Dimension(0, 0));
        cbSangre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSangreActionPerformed(evt);
            }
        });

        cbSeguro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Autollena" }));
        cbSeguro.setToolTipText("Seleccione el tipo de seguro del Padre.");
        cbSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSeguroActionPerformed(evt);
            }
        });

        txtNoSeguro.setEditable(false);
        try {
            txtNoSeguro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("********************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNoSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoSeguroActionPerformed(evt);
            }
        });

        lbCedula.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbCedula.setText("Cedula");

        lbNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNombre.setText("Primer Nombre");

        jlApellidos.setText("Apellidos");

        lbNombre1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNombre1.setText("Segundo Nombre");

        jLabel14.setText("Estado");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Nacimiento");

        jLabel4.setText("Sexo");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Seguro");

        jLabel13.setText("Numero");

        jLabel5.setText("Sangre");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lbCedula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jpCedula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnAntecedentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jlApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNoSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dchFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbSangre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtApellidos, txtPNombre});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(lbCedula)
                            .addGap(0, 0, 0)
                            .addComponent(jpCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addGap(0, 0, 0)
                            .addComponent(cbEstado)))
                    .addComponent(btnAntecedentes, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbNombre)
                        .addGap(0, 0, 0)
                        .addComponent(txtPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbNombre1)
                        .addGap(0, 0, 0)
                        .addComponent(txtSNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jlApellidos)
                        .addGap(0, 0, 0)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, 0)
                        .addComponent(dchFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, 0)
                        .addComponent(cbSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, 0)
                        .addComponent(txtNoSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, 0)
                        .addComponent(cbSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbSangre, cbSexo, dchFechaNacimiento, txtApellidos, txtPNombre, txtSNombre});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbSeguro, txtNoSeguro});

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Contactos"));

        jtContactos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtContactos);

        javax.swing.GroupLayout jpDatosLayout = new javax.swing.GroupLayout(jpDatos);
        jpDatos.setLayout(jpDatosLayout);
        jpDatosLayout.setHorizontalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpDatosLayout.setVerticalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mantenimiento", jpDatos);

        jScrollPane3.setViewportView(jTabbedPane1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles"));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 111));

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
        btnBorrar.setMnemonic('b');
        btnBorrar.setText("Borrar");
        btnBorrar.setToolTipText("Borrar Registro Actual");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel6.add(btnBorrar);

        btnBuscar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(1, 1, 1));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Buscar3 32 x 32.png"))); // NOI18N
        btnBuscar.setMnemonic('r');
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Buscar el Registro");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel6.add(btnBuscar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //Activamos el Flag de registro Nuevo        
        nuevo = true;
        cbPadresActivos.setSelected(true);
        cbPadresActivosActionPerformed(null);

        limpiarCampos();

        navegador(false);

        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(false);

        btnValidaCedulaPadre.setEnabled(true);

        txtCedula.setEditable(true);
        txtCedula.requestFocus();
        txtCedula.setValue(null);
        Utilidades.showTooltip(txtCedula);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jtPadres.getRowCount() == 0) {
            JOptionPane.showInternalMessageDialog(this,
                    "No se encuentra datos en la tabla. Registre un padre",
                    "Proceso de validacion de datos",
                    JOptionPane.DEFAULT_OPTION);
            return;
        }
        if (jtPadres.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe seleccionar un registro de la tabla",
                    "Proceso de validacion de datos",
                    JOptionPane.DEFAULT_OPTION);
            jtPadres.requestFocus();
            return;
        }

        nuevo = false;
        navegador(false);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Validaciones de datos...
        if (txtCedula.getValue() == null) {
            JOptionPane.showInternalConfirmDialog(this,
                    "Inserte la cedula!!!", "Olvida algo!",
                    JOptionPane.DEFAULT_OPTION);
            txtCedula.requestFocus();
            return;
        }

        if (txtPNombre.getText().equals("")) {
            JOptionPane.showInternalConfirmDialog(this,
                    "Inserte el Nombre!!!", "Olvida algo!",
                    JOptionPane.DEFAULT_OPTION);
            txtPNombre.requestFocus();
            return;
        }

        if (txtApellidos.getText().equals("")) {
            JOptionPane.showInternalConfirmDialog(this,
                    "Inserte el Apellido...", "Olvida algo!",
                    JOptionPane.DEFAULT_OPTION);
            txtApellidos.requestFocus();
            return;
        }

        if (cbSeguro.getSelectedIndex() <= 0) {
            int opc = JOptionPane.showInternalConfirmDialog(this,
                    "¿Desea continuar sin seguro?",
                    "Confirmacion de procedimiento",
                    JOptionPane.YES_NO_OPTION);
            if (opc == JOptionPane.NO_OPTION) {
                cbSeguro.requestFocus();
                return;
            }
        } else if (txtNoSeguro.getText().isEmpty()) {
            JOptionPane.showInternalConfirmDialog(this,
                    "Inserte el No. de Ars...", "Olvida algo!",
                    JOptionPane.DEFAULT_OPTION);
            txtNoSeguro.requestFocus();
            return;
        }

        if (dchFechaNacimiento.getDate() == null) {
            JOptionPane.showInternalConfirmDialog(this,
                    "Debe indicar una fecha de nacimiento...",
                    "Olvida algo!", JOptionPane.DEFAULT_OPTION);
            dchFechaNacimiento.requestFocus();
            return;
        }

        if (dchFechaNacimiento.getDate().after(new Date())) {
            JOptionPane.showInternalConfirmDialog(this,
                    "La Fecha de Nacimiento debe ser Anterior a la Fecha Actual",
                    "Olvida algo!", JOptionPane.DEFAULT_OPTION);
            dchFechaNacimiento.requestFocus();
            return;
        }//FIN de las Validaciones..........................

        Padre p = Padre
                .builder()
                .persona(
                        Persona
                                .builder()
                                .id_persona(
                                        nuevo
                                                ? -1
                                                : ((Padre) jtPadres.getValueAt(cliPadre, 0)).getPersona().getId_persona())
                                .pnombre(txtPNombre.getText())
                                .snombre(txtSNombre.getText())
                                .apellidos(txtApellidos.getText())
                                .sexo((cbSexo.getSelectedIndex() == 1 ? 'm' : 'f'))
                                .generales(
                                        Generales
                                                .builder()
                                                .cedula((String) txtCedula.getValue())
                                                .tipoSangre(((TipoSangre) cbSangre.getSelectedItem()))
                                                .build()
                                )
                                .estado(cbEstado.isSelected())
                                .build()
                )
                .build();
        id_Ars(((ARS) cbSeguro.getSelectedItem()).getId()).
                noNSS(txtNoSeguro.getValue().toString()).
                direccion(txtDireccion.getText()).
                fecha_Nacimiento(new java.sql.Date(dchFechaNacimiento.getDate().getTime())).;

        if (nuevo) {
            //Insertar el Padre
            JOptionPane.showInternalConfirmDialog(this,
                    agregarPadre(p),
                    "Error inesperado",
                    JOptionPane.DEFAULT_OPTION);
        } else {
            //Modificar un Padre
            JOptionPane.showInternalMessageDialog(this,
                    modificarPadre(p),
                    "Proceso de modificación",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        llenarTabla(cbPadresActivos.isSelected());

        ordenarTabla(true);

        btnCancelarActionPerformed(null);

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //Desactivamos el Flag de registro Nuevo
        nuevo = false;
        navegador(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (!cbPadresActivos.isSelected()) {
            JOptionPane.showInternalMessageDialog(this,
                    "No puede ser borrado.",
                    "Proceso de validación",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (jtPadres.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe de seleccionar un registro de la tabla!!!",
                    "Proceso de validación",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int resp = JOptionPane.showInternalConfirmDialog(this,
                "Los registros no pueden ser eliminado de la base de datos\n"
                + "Ellos cambian de estado a Inactivo.\n"
                + "Desea Continuar?",
                "Proceso de validacion de registros",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        borrarPadre(((Padre) jtPadres.getValueAt(cliPadre, 0)).getCedula().trim());

        cliPadre = 0;
        //Actualizamos los cambios en la Tabla
        llenarTabla(cbPadresActivos.isSelected());
        mostrarRegistro();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int num = 0;
        do {
            if (cliente == null || cliente.equals("") || cliente.equals("null")) {

                cliente = JOptionPane.showInternalInputDialog(this,
                        "Ingrese la Cedula, Nombre o Apellido del Padre",
                        "Busqueda de información",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            } else {
                int opc = JOptionPane.showInternalConfirmDialog(this,
                        "Desea realizar nueva busqueda? \nEn Memoria tenemos {" + cliente + "}",
                        "Confirmacion de Busqueda", JOptionPane.YES_NO_OPTION);
                if (opc == JOptionPane.YES_OPTION) {
                    cliente = null;
                    btnBuscarActionPerformed(null);
                    break;
                } else {
                    num = jtPadres.getSelectedRow() + 1;
                    break;
                }
            }
        } while (true);

        if (cliente == null || cliente.equals("") || cliente.equals("null")) {
            return;
        }

        for (int i = num; i < jtPadres.getRowCount(); i++) {
            if (jtPadres.getValueAt(i, 0).toString().toLowerCase().
                    contains(cliente.toLowerCase())) {
                cliPadre = i;
                break;
            }
            if (jtPadres.getValueAt(i, 1).toString().toLowerCase().
                    contains(cliente.toLowerCase())) {
                cliPadre = i;
                break;
            }
            if (jtPadres.getValueAt(i, 2).toString().toLowerCase().
                    contains(cliente.toLowerCase())) {
                cliPadre = i;
                break;
            }
        }
        mostrarRegistro();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jtPadresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPadresMouseClicked
        if (!jtPadres.isEnabled()) {
            return;
        }
        cliPadre = jtPadres.getSelectedRow();
        mostrarRegistro();
    }//GEN-LAST:event_jtPadresMouseClicked

    private void jmSeleccionarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSeleccionarTodoActionPerformed
        txtCedula.setSelectionStart(0);
        txtCedula.setSelectionEnd(txtCedula.getText().length());
    }//GEN-LAST:event_jmSeleccionarTodoActionPerformed

    private void jmCopiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCopiaActionPerformed

        txtCedula.copy();
    }//GEN-LAST:event_jmCopiaActionPerformed

    private void jmCortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCortarActionPerformed

        txtCedula.cut();
    }//GEN-LAST:event_jmCortarActionPerformed

    private void jmPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPegarActionPerformed

        txtCedula.paste();
    }//GEN-LAST:event_jmPegarActionPerformed

    private void jmSeleccionarTodo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSeleccionarTodo1ActionPerformed

        txtPNombre.setSelectionStart(0);
        txtPNombre.setSelectionEnd(txtPNombre.getText().length());
    }//GEN-LAST:event_jmSeleccionarTodo1ActionPerformed

    private void jmCopia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCopia1ActionPerformed

        txtPNombre.copy();
    }//GEN-LAST:event_jmCopia1ActionPerformed

    private void jmCortar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCortar1ActionPerformed

        txtPNombre.cut();
    }//GEN-LAST:event_jmCortar1ActionPerformed

    private void jmPegar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPegar1ActionPerformed

        txtPNombre.paste();
    }//GEN-LAST:event_jmPegar1ActionPerformed

    private void jmSeleccionarTodo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSeleccionarTodo4ActionPerformed

    }//GEN-LAST:event_jmSeleccionarTodo4ActionPerformed

    private void jmCopia4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCopia4ActionPerformed

    }//GEN-LAST:event_jmCopia4ActionPerformed

    private void jmCortar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCortar4ActionPerformed

    }//GEN-LAST:event_jmCortar4ActionPerformed

    private void jmPegar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPegar4ActionPerformed

    }//GEN-LAST:event_jmPegar4ActionPerformed

    private void jmSeleccionarTodo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSeleccionarTodo5ActionPerformed

    }//GEN-LAST:event_jmSeleccionarTodo5ActionPerformed

    private void jmCopia5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCopia5ActionPerformed

    }//GEN-LAST:event_jmCopia5ActionPerformed

    private void jmCortar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCortar5ActionPerformed

    }//GEN-LAST:event_jmCortar5ActionPerformed

    private void jmPegar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPegar5ActionPerformed

    }//GEN-LAST:event_jmPegar5ActionPerformed

    private void txtPNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPNombreActionPerformed

        txtApellidos.requestFocus();
        Utilidades.showTooltip(txtApellidos);
    }//GEN-LAST:event_txtPNombreActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed

        btnValidaCedulaPadre.requestFocus();
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed

        button.doClick();
        Utilidades.showTooltip(button);
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void btnAntecedentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAntecedentesActionPerformed
        final SwingWorker w = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {

                if (((Padres) jtPadres.getValueAt(cliPadre, 0)).getCedula().
                        equals("000-0000000-0")) {

                    JOptionPane.showInternalMessageDialog(null,
                            "No se permite antecedentes en genericos");
                    return null;
                }

                frmPadresAntecedentes frm = new frmPadresAntecedentes(
                        null,
                        true,
                        ((Padres) jtPadres.getValueAt(cliPadre, 0)).getId());
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);
                return null;
            }
        };
        w.execute();
    }//GEN-LAST:event_btnAntecedentesActionPerformed

    private void cbPadresActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPadresActivosActionPerformed
        if (!isShowing()) {
            return;
        }

        if (cbPadresActivos.isSelected()) {
            cbPadresActivos.setText("Padres Activos");
        } else {
            cbPadresActivos.setText("Padres Inactivos");
        }

        llenarTabla(cbPadresActivos.isSelected());
        mostrarRegistro();
        ordenarTabla(true);
    }//GEN-LAST:event_cbPadresActivosActionPerformed

    private void cbCorreoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCorreoItemStateChanged
        if (!jtPadres.getRowSelectionAllowed()) {
            return;
        }

        if (cbCorreo.isSelected()) {
            jtPadres.getColumn(jtPadres.getColumnName(9)).setMinWidth(100);
            jtPadres.getColumn(jtPadres.getColumnName(9)).setMaxWidth(200);
            jtPadres.getColumn(jtPadres.getColumnName(9)).setPreferredWidth(200);
        } else {
            jtPadres.getColumn(jtPadres.getColumnName(9)).setMinWidth(0);
            jtPadres.getColumn(jtPadres.getColumnName(9)).setMaxWidth(0);
            jtPadres.getColumn(jtPadres.getColumnName(9)).setPreferredWidth(0);
        }
        ordenarTabla(false);
    }//GEN-LAST:event_cbCorreoItemStateChanged

    private void cbCiudadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCiudadItemStateChanged
        if (!jtPadres.getRowSelectionAllowed()) {
            return;
        }

        if (cbCiudad.isSelected()) {
            jtPadres.getColumn(jtPadres.getColumnName(11)).setMinWidth(100);
            jtPadres.getColumn(jtPadres.getColumnName(11)).setMaxWidth(200);
            jtPadres.getColumn(jtPadres.getColumnName(11)).setPreferredWidth(200);
        } else {
            jtPadres.getColumn(jtPadres.getColumnName(11)).setMinWidth(0);
            jtPadres.getColumn(jtPadres.getColumnName(11)).setMaxWidth(0);
            jtPadres.getColumn(jtPadres.getColumnName(11)).setPreferredWidth(0);
        }
        ordenarTabla(false);
    }//GEN-LAST:event_cbCiudadItemStateChanged

    private void cbFechaNacimientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFechaNacimientoItemStateChanged
        if (!jtPadres.getRowSelectionAllowed()) {
            return;
        }

        if (cbFechaNacimiento.isSelected()) {
            jtPadres.getColumn(jtPadres.getColumnName(12)).setMinWidth(100);
            jtPadres.getColumn(jtPadres.getColumnName(12)).setMaxWidth(140);
            jtPadres.getColumn(jtPadres.getColumnName(12)).setPreferredWidth(140);
        } else {
            jtPadres.getColumn(jtPadres.getColumnName(12)).setMinWidth(0);
            jtPadres.getColumn(jtPadres.getColumnName(12)).setMaxWidth(0);
            jtPadres.getColumn(jtPadres.getColumnName(12)).setPreferredWidth(0);
        }
        ordenarTabla(false);
    }//GEN-LAST:event_cbFechaNacimientoItemStateChanged

    private void cbDireccionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDireccionItemStateChanged
        if (!jtPadres.getRowSelectionAllowed()) {
            return;
        }

        if (cbDireccion.isSelected()) {
            jtPadres.getColumn(jtPadres.getColumnName(10)).setMinWidth(100);
            jtPadres.getColumn(jtPadres.getColumnName(10)).setMaxWidth(300);
            jtPadres.getColumn(jtPadres.getColumnName(10)).setPreferredWidth(300);
        } else {
            jtPadres.getColumn(jtPadres.getColumnName(10)).setMinWidth(0);
            jtPadres.getColumn(jtPadres.getColumnName(10)).setMaxWidth(0);
            jtPadres.getColumn(jtPadres.getColumnName(10)).setPreferredWidth(0);
        }
        ordenarTabla(false);
    }//GEN-LAST:event_cbDireccionItemStateChanged

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

        ordenarTabla(true);
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        if (btnGuardar.isEnabled()) {
            //sangre: Guardar la posicion de la sangre
            int sangre = cbSangre.getSelectedIndex();

            //seguro: Guardar la posicion del segugo
            int seguro = cbSeguro.getSelectedIndex();

            llenarCombos();
            //volvemos a poner el sexo en la posicion que tenia
            cbSangre.setSelectedIndex(sangre);
            //volvemos a poner el seguro en la posicion que tenia
            cbSeguro.setSelectedIndex(seguro);
        }
    }//GEN-LAST:event_formInternalFrameActivated

    private void cbSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSexoActionPerformed

    }//GEN-LAST:event_cbSexoActionPerformed

    private void cbSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSeguroActionPerformed

        if (cbSeguro.getSelectedIndex() == 0 & cbSeguro.isEnabled()) {

            txtNoSeguro.setValue(null);
            cbSexo.requestFocus();
            cbSexo.showPopup();
        }
        if (cbSeguro.getSelectedIndex() != 0 & cbSeguro.isEnabled()) {
            txtNoSeguro.requestFocus();
            Utilidades.showTooltip(txtNoSeguro);
        }
    }//GEN-LAST:event_cbSeguroActionPerformed

    private void cbSangreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSangreActionPerformed

    }//GEN-LAST:event_cbSangreActionPerformed

    private void txtNoSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoSeguroActionPerformed

        cbSexo.requestFocus();
        cbSexo.showPopup();
        Utilidades.showTooltip(cbSexo);
    }//GEN-LAST:event_txtNoSeguroActionPerformed

    private void btnValidaCedulaPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidaCedulaPadreActionPerformed

        Object cedula = txtCedula.getValue();

        if (cedula == null) {
            JOptionPane.showInternalMessageDialog(this, "Cedula no valida");
            txtCedula.setValue(null);
            txtCedula.requestFocus();
            return;
        }

        for (int i = 0; i < jtPadres.getRowCount(); i++) {
            if (cedula.toString().equals(((Padres) jtPadres.getValueAt(i, 0)).getCedula())) {
                JOptionPane.showMessageDialog(null,
                        "La cedula se encuentra registrada y activa",
                        "Procedo de validación",
                        JOptionPane.WARNING_MESSAGE);

                txtCedula.setValue(null);
                txtCedula.requestFocus();
                return;
            }
        }

        //TODO 11/12/2024 Testear este metodo si funciona bien.
        final SwingWorker w = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {

                if (existePadre(cedula.toString(), false)) {
                    int opc = JOptionPane.showConfirmDialog(
                            null,
                            """
                            Este numero de cedula existe en el sistema.
                            \u00bfDesea recuperarlo?""",
                            "",
                            JOptionPane.YES_NO_OPTION);

                    if (opc == JOptionPane.YES_OPTION) {
                        List<Padre> listaPadres = M_Padre.getPadres(
                                FiltroBusqueda
                                        .builder()
                                        .criterioBusqueda(cedula.toString())
                                        .build()
                        );
                        
                        Padre padre = listaPadres.getFirst();
                        txtPNombre.setText(padre.getPersona().getPnombre());
                        txtApellidos.setText(padre.getPersona().getApellidos());

                        txtNoSeguro.setValue(
                                padre.getAsegurado().getNo_nss()
                        );

                        dchFechaNacimiento.setDate(
                                padre.getPersona().getFecha_nacimiento()
                        );

                        String sexo = padre.getPersona().getSexo().toString();
                        int sangre = padre.getGenerales().getTipoSangre().getId();
                        int ars = padre.getAsegurado().getArs().getId();

                        for (int i = 0; i < cbSexo.getItemCount(); i++) {
                            cbSexo.setSelectedIndex(i);
                            if (((String) cbSexo.getSelectedItem()).equals(sexo)) {
                                break;
                            }
                        }

                        for (int i = 0; i < cbSangre.getItemCount(); i++) {
                            cbSangre.setSelectedIndex(i);
                            if (((TipoSangre) cbSangre.getSelectedItem()).
                                    getId() == sangre) {
                                break;
                            }
                        }

                        for (int i = 0; i < cbSeguro.getItemCount(); i++) {
                            cbSeguro.setSelectedIndex(i);
                            if (((ARS) cbSeguro.getSelectedItem()).
                                    getId() == ars) {
                                break;
                            }
                        }

                        txtCedula.setEditable(false);

                        return true;
                    } else {//De lo contrario limpio el campo y intento de nuevo.
                        txtCedula.setValue(null);
                        txtCedula.requestFocus();
                        return false;
                    }

                } else {
                    controlesEditable(false);
                    btnGuardar.setEnabled(true);
                    txtPNombre.requestFocus();
                    navegador(!nuevo);
                }
                return true;
            }
        };
        w.execute();
    }//GEN-LAST:event_btnValidaCedulaPadreActionPerformed

    private void cbSexoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSexoItemStateChanged

        cbSangre.requestFocus();
        cbSangre.showPopup();
        Utilidades.showTooltip(cbSangre);
    }//GEN-LAST:event_cbSexoItemStateChanged

    private void txtSNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSNombreActionPerformed
        txtApellidos.requestFocus();
    }//GEN-LAST:event_txtSNombreActionPerformed

    private synchronized void mostrarRegistro() {

        if (jtPadres.getRowCount() == 0) {
            limpiarCampos();
            return;
        }

        Padres p = Padres.builder().
                id(((Padres) jtPadres.getValueAt(cliPadre, 0)).getId()).
                cedula(((Padres) jtPadres.getValueAt(cliPadre, 0)).getCedula()).build();

        txtCedula.setValue(p);

        txtPNombre.setText((String) jtPadres.getValueAt(cliPadre, 1));

        txtApellidos.setText((String) jtPadres.getValueAt(cliPadre, 2));

        for (int i = 0; i < cbSexo.getItemCount(); i++) {
            cbSexo.setSelectedIndex(i);
            if (((String) cbSexo.getSelectedItem()).equals(((String) jtPadres.getValueAt(cliPadre, 3)))) {
                break;
            }
        }

        for (int i = 0; i < cbSangre.getItemCount(); i++) {
            cbSangre.setSelectedIndex(i);
            if (((TipoSangre) cbSangre.getSelectedItem()).getId()
                    == ((TipoSangre) jtPadres.getValueAt(cliPadre, 4)).getId()) {
                break;
            }
        }

        for (int i = 0; i < cbSeguro.getItemCount(); i++) {
            cbSeguro.setSelectedIndex(i);
            if (((ARS) cbSeguro.getSelectedItem()).getId()
                    == ((ARS) jtPadres.getValueAt(cliPadre, 5)).getId()) {
                break;
            }
        }

        txtNoSeguro.setValue(jtPadres.getValueAt(cliPadre, 6));

        txtDireccion.setText((String) jtPadres.getValueAt(cliPadre, 10));

        dchFechaNacimiento.setDate(((Padres) jtPadres.getValueAt(cliPadre, 12)).getFecha_Nacimiento()
        );

        cbEstado.setSelected((Boolean) jtPadres.getValueAt(cliPadre, 13)
                .equals("Activo"));

        //Mover Cursor
        jtPadres.setRowSelectionInterval(cliPadre, cliPadre);
    }

    public synchronized void llenarTabla(boolean estado) {

        cliPadre = 0;
        jtPadres.removeAll();
        String titulos[] = {
            "<html><b>Cedula</b></html>",
            "<html><b>Nombres</b></html>",
            "<html><b>Apellidos</b></html>",
            "<html><b>Sexo</b></html>",
            "<html><b>Tipo Sangre</b></html>",
            "<html><b>Ars</b></html>",
            "<html><b>Noº Seguro</b></html>",
            "<html><b>Telefono</b></html>",
            "<html><b>Movil</b></html>",
            "<html><b>Correo</b></html>",
            "<html><b>Direccion</b></html>",
            "<html><b>Ciudad</b></html>",
            "<html><b>Fecha Nacimiento</b></html>",
            "<html><b>Estado</b></html>"};
        Object registro[] = new Object[14];
        try {
            ResultSet rs = getPadresActivo(estado);
            miTabla = new DefaultTableModel(null, titulos);
            while (rs.next()) {

                registro[0] = Padres.builder().id(rs.getInt("IDPADRE")).
                        cedula(rs.getString("CEDULA").trim()).build();
                registro[1] = rs.getString("NOMBRES").trim();
                registro[2] = rs.getString("APELLIDOS").trim();
                registro[3] = rs.getString("SEXO").trim().equals("m") ? "Masculino" : "Femenina";
                registro[4] = new TipoSangre(rs.getInt("IDTIPOSANGRE"), rs.getString("TIPOSANGRE").trim());
                registro[5] = new ARS(rs.getInt("IDARS"), rs.getString("ARS").trim());;
                registro[6] = rs.getString("NONSS").trim();
                registro[7] = rs.getString("TELEFONO").trim();
                registro[8] = rs.getString("MOVIL").trim();
                registro[9] = rs.getString("CORREO").trim();
                registro[10] = rs.getString("DIRECCION").trim();
                registro[11] = rs.getString("CIUDAD").trim();
                registro[12] = Utilidades.formatDate(rs.getDate("FECHANACIMIENTO"), "");
                registro[13] = (rs.getBoolean("Estado") ? "Activo" : "Inactivo");
                miTabla.addRow(registro);
            }
            jtPadres.setModel(miTabla);
        } catch (SQLException ex) {
            //Instalar Logger
        } finally {
            mostrarRegistro();
        }
    }

    public synchronized void ordenarTabla(boolean valor) {

        //Invocar los metodos que ocultan ciertas columnas
        if (valor) {
            cbCiudadItemStateChanged(null);
            cbCorreoItemStateChanged(null);
            cbDireccionItemStateChanged(null);
            cbFechaNacimientoItemStateChanged(null);
            return;
        }
        //Establecer un tamaNo fijo a cierta columna...
        //Cedula
        jtPadres.setEnabled(false);
        jtPadres.getColumn(jtPadres.getColumnName(0)).setMinWidth(115);
        jtPadres.getColumn(jtPadres.getColumnName(0)).setMaxWidth(115);
        jtPadres.getColumn(jtPadres.getColumnName(0)).setPreferredWidth(115);
        //Nombre
        jtPadres.getColumn(jtPadres.getColumnName(1)).setMinWidth(175);
        jtPadres.getColumn(jtPadres.getColumnName(1)).setMaxWidth(220);
        jtPadres.getColumn(jtPadres.getColumnName(1)).setPreferredWidth(175);
        //Apellidos
        jtPadres.getColumn(jtPadres.getColumnName(2)).setMinWidth(175);
        jtPadres.getColumn(jtPadres.getColumnName(2)).setMaxWidth(220);
        jtPadres.getColumn(jtPadres.getColumnName(2)).setPreferredWidth(175);
        //Sexo
        jtPadres.getColumn(jtPadres.getColumnName(3)).setMinWidth(80);
        jtPadres.getColumn(jtPadres.getColumnName(3)).setMaxWidth(80);
        jtPadres.getColumn(jtPadres.getColumnName(3)).setPreferredWidth(80);
        //Tipo de sangre
        jtPadres.getColumn(jtPadres.getColumnName(4)).setMinWidth(100);
        jtPadres.getColumn(jtPadres.getColumnName(4)).setMaxWidth(100);
        jtPadres.getColumn(jtPadres.getColumnName(4)).setPreferredWidth(100);
        //Tipo de sangre
        jtPadres.getColumn(jtPadres.getColumnName(5)).setMinWidth(100);
        jtPadres.getColumn(jtPadres.getColumnName(5)).setMaxWidth(100);
        jtPadres.getColumn(jtPadres.getColumnName(5)).setPreferredWidth(100);
        //No Seguro
        jtPadres.getColumn(jtPadres.getColumnName(6)).setMinWidth(120);
        jtPadres.getColumn(jtPadres.getColumnName(6)).setMaxWidth(120);
        jtPadres.getColumn(jtPadres.getColumnName(6)).setPreferredWidth(120);
        //Telefono
        jtPadres.getColumn(jtPadres.getColumnName(7)).setMinWidth(110);
        jtPadres.getColumn(jtPadres.getColumnName(7)).setMaxWidth(110);
        jtPadres.getColumn(jtPadres.getColumnName(7)).setPreferredWidth(110);
        //Movil
        jtPadres.getColumn(jtPadres.getColumnName(8)).setMinWidth(110);
        jtPadres.getColumn(jtPadres.getColumnName(8)).setMaxWidth(110);
        jtPadres.getColumn(jtPadres.getColumnName(8)).setPreferredWidth(110);
        //Estado
        jtPadres.getColumn(jtPadres.getColumnName(13)).setMinWidth(60);
        jtPadres.getColumn(jtPadres.getColumnName(13)).setMaxWidth(60);
        jtPadres.getColumn(jtPadres.getColumnName(13)).setPreferredWidth(60);
        jtPadres.setEnabled(true);
    }

    public void limpiarCampos() {
        if (!isShowing()) {
            return;
        }

        txtPNombre.setText("");
        txtApellidos.setText("");
        dchFechaNacimiento.setDate(null);
        cbSexo.setSelectedIndex(0);
        cbSangre.setSelectedIndex(0);
        cbSeguro.setSelectedIndex(0);
        txtNoSeguro.setValue(null);
        txtDireccion.setText("");
        cbTodos.setSelected(true);
    }

    private void navegador(boolean b) {

        if (!nuevo) {
            txtCedula.setEditable(false);
            txtPNombre.requestFocus();
        }

        btnNuevo.setEnabled(b);
        btnModificar.setEnabled(b);
        btnBorrar.setEnabled(b);
        btnBuscar.setEnabled(b);
        btnAntecedentes.setEnabled(b);
        jtPadres.setEnabled(b);
        jpFiltro.setVisible(b);
        btnValidaCedulaPadre.setEnabled(b);

        controlesEditable(!b);

        //Caja de Texto Habilitado
        btnGuardar.setEnabled(!b);
        btnCancelar.setEnabled(!b);
    }

    private synchronized void controlesEditable(boolean b) {
        //Caja de Textos permitir Ediccion
        txtPNombre.setEditable(b);
        txtApellidos.setEditable(b);
        button.setEnabled(b);
        cbSeguro.setEnabled(b);
        txtNoSeguro.setEditable(b);
        cbSexo.setEnabled(b);
        cbSangre.setEnabled(b);
        editor.setEditable(b);
        txtDireccion.setEditable(b);
        cbEstado.setEnabled(b);
    }

    private synchronized void controlesEnabled(boolean valor) {

        txtCedula.setEnabled(valor);
        txtPNombre.setEnabled(valor);
        txtApellidos.setEnabled(valor);
        dchFechaNacimiento.setEnabled(valor);
        cbSeguro.setEnabled(valor);
        txtNoSeguro.setEnabled(valor);
        cbSexo.setEnabled(valor);
        cbSangre.setEnabled(valor);
        cbEstado.setEnabled(valor);
        txtDireccion.setEnabled(valor);
    }

    public synchronized void llenarCombos() {

        ResultSet obj = getTipoSeguro();
        ARS ars;
        cbSeguro.removeAllItems();
        try {
            while (obj.next()) {
                ars = new ARS(obj.getInt("IDARS"), obj.getString("DESCRIPCION"));
                cbSeguro.addItem(ars);
            }
        } catch (SQLException ex) {
            //Instalar Logger
        }

        obj = getTipoSangre();
        TipoSangre ts;
        cbSangre.removeAllItems();
        try {
            while (obj.next()) {
                ts = new TipoSangre(obj.getInt("IDTIPOSANGRE"), obj.getString("DESCRIPCION"));
                cbSangre.addItem(ts);
            }
        } catch (SQLException ex) {
            //Instalar Logger
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton btnAntecedentes;
    private static javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup btnGrupo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnValidaCedulaPadre;
    private javax.swing.JCheckBox cbCiudad;
    private javax.swing.JCheckBox cbCorreo;
    private javax.swing.JCheckBox cbDireccion;
    private javax.swing.JCheckBox cbEstado;
    private javax.swing.JCheckBox cbFechaNacimiento;
    private javax.swing.JCheckBox cbPadresActivos;
    private javax.swing.JComboBox cbSangre;
    private javax.swing.JComboBox cbSeguro;
    private javax.swing.JComboBox cbSexo;
    private javax.swing.JCheckBox cbTodos;
    private com.toedter.calendar.JDateChooser dchFechaNacimiento;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlApellidos;
    private javax.swing.JMenuItem jmCopia;
    private javax.swing.JMenuItem jmCopia1;
    private javax.swing.JMenuItem jmCopia4;
    private javax.swing.JMenuItem jmCopia5;
    private javax.swing.JMenuItem jmCortar;
    private javax.swing.JMenuItem jmCortar1;
    private javax.swing.JMenuItem jmCortar4;
    private javax.swing.JMenuItem jmCortar5;
    private javax.swing.JMenuItem jmPegar;
    private javax.swing.JMenuItem jmPegar1;
    private javax.swing.JMenuItem jmPegar4;
    private javax.swing.JMenuItem jmPegar5;
    private javax.swing.JMenuItem jmSeleccionarTodo;
    private javax.swing.JMenuItem jmSeleccionarTodo1;
    private javax.swing.JMenuItem jmSeleccionarTodo4;
    private javax.swing.JMenuItem jmSeleccionarTodo5;
    private javax.swing.JPanel jpCedula;
    private javax.swing.JPanel jpDatos;
    private javax.swing.JPanel jpDetalles;
    private javax.swing.JPanel jpFiltro;
    private javax.swing.JPopupMenu jpNombre;
    private javax.swing.JPopupMenu jpNombre1;
    private javax.swing.JPopupMenu jpNombre2;
    private javax.swing.JPopupMenu jpmCedula;
    private javax.swing.JTable jtContactos;
    private javax.swing.JTable jtPadres;
    private javax.swing.JLabel lbCedula;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNombre1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JFormattedTextField txtNoSeguro;
    private javax.swing.JTextField txtPNombre;
    private javax.swing.JTextField txtSNombre;
    // End of variables declaration//GEN-END:variables
}
