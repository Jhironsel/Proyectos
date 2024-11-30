package Formularios;

import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sur.softsurena.entidades.Categoria;
import sur.softsurena.utilidades.DefaultTableCellHeaderRenderer;
import sur.softsurena.utilidades.Utilidades;

public class frmCajeros extends javax.swing.JFrame implements Runnable {

    private DefaultTableModel miTabla;
    private String hora, minutos, segundos, ampm;
    private final Thread h1;
    private frmAutorizacion miAut;
    private TextAutoCompleter textAutoCompleter;

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calculaHora();
            txtHora.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            
//            Debe crearse o analizarse si es necesario obtener el numero de 
//            factura siguiente.
//            txtIdFactura.setText("" + (Datos.getNumFac() + 1));
        }
    }

    public frmCajeros() {
        initComponents();

        h1 = new Thread(this);
        h1.start();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                txtBuscarCodigo.requestFocus();
            }
        });

        textAutoCompleter = new TextAutoCompleter(txtBuscarCodigo,
                new AutoCompleterCallback() {
            @Override
            public void callback(Object selectedItem) {
//                txtBuscarCodigo.setText();
                buscarCodigo(
                        ((Categoria) textAutoCompleter.findItem(
                                selectedItem.toString())).getDescripcion()
                );
                if (cmbProducto.getSelectedIndex() != 0) {
                    txtCantidad.requestFocus();
                }
            }
        });
        textAutoCompleter.setMode(0);
        textAutoCompleter.setCaseSensitive(false);
        txtBuscarCodigo.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        JlCantidad1 = new javax.swing.JLabel();
        JlCantidad = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtBuscarCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        jPanel9 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnAdicionar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEliminarTodo = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnGrabar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtIdFactura = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtUsuarioActual = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTotalCantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotalValor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Encabezado"));

        JlCantidad1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        JlCantidad1.setForeground(new java.awt.Color(1, 1, 1));

        JlCantidad.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        JlCantidad.setForeground(new java.awt.Color(1, 1, 1));

        cmbCliente.setFont(new java.awt.Font("FreeMono", 0, 20)); // NOI18N
        cmbCliente.setForeground(new java.awt.Color(0, 0, 255));
        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 1, 1));
        jLabel8.setText("Hora:");

        txtFecha.setBackground(new java.awt.Color(254, 254, 254));
        txtFecha.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(0, 0, 255));
        txtFecha.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtFecha.setEnabled(false);

        txtHora.setBackground(new java.awt.Color(254, 254, 254));
        txtHora.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txtHora.setForeground(new java.awt.Color(0, 0, 255));
        txtHora.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtHora.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Cliente:");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("Fecha:");

        btnBuscarCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Buscar3 32 x 32.png"))); // NOI18N
        btnBuscarCliente.setMnemonic('c');
        btnBuscarCliente.setText("Cliente");
        btnBuscarCliente.setToolTipText("Busca un Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFecha)
                            .addComponent(txtHora))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlCantidad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JlCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cmbCliente, 0, 524, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarCliente))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(JlCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(JlCantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBuscarCliente, cmbCliente});

        jScrollPane2.setViewportView(jPanel4);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Insertar y Buscar producto"));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Producto:");

        cmbProducto.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        cmbProducto.setForeground(new java.awt.Color(0, 0, 255));
        cmbProducto.setMinimumSize(new java.awt.Dimension(0, 0));
        cmbProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProductoItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(1, 1, 1));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Cod. Producto:");

        txtBuscarCodigo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtBuscarCodigo.setForeground(new java.awt.Color(0, 0, 255));
        txtBuscarCodigo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBuscarCodigo.setAutoscrolls(false);
        txtBuscarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarCodigoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad:");

        txtCantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCantidad.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtCantidad.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(1, 1, 1));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Precio:");

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(0, 0, 153));
        txtPrecio.setDisabledTextColor(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarCodigo)
                    .addComponent(cmbProducto, 0, 341, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel11, jLabel4});

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel7});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbProducto, jLabel11, jLabel3, txtPrecio});

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel4, jLabel7, txtBuscarCodigo, txtCantidad});

        jScrollPane3.setViewportView(jPanel6);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de Factura"));
        jPanel5.setAutoscrolls(true);

        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Producto", "Descripcion", "Precio", "Cantidad", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetalle.setFocusable(false);
        tblDetalle.getTableHeader().setReorderingAllowed(false);
        tblDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetalleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDetalle);

        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnAdicionar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnAdicionar.setForeground(new java.awt.Color(1, 1, 1));
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Agregar 32 x 32.png"))); // NOI18N
        btnAdicionar.setMnemonic('a');
        btnAdicionar.setText("Agregar");
        btnAdicionar.setToolTipText("Adicionar Producto a la Factura");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        jPanel7.add(btnAdicionar);

        btnEliminar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(1, 1, 1));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Eliminar 32 x 32.png"))); // NOI18N
        btnEliminar.setMnemonic('q');
        btnEliminar.setText("Quitar");
        btnEliminar.setToolTipText("Elimina Producto de la Factura");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel7.add(btnEliminar);

        btnEliminarTodo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnEliminarTodo.setForeground(new java.awt.Color(1, 1, 1));
        btnEliminarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Borrar 32 x 32.png"))); // NOI18N
        btnEliminarTodo.setMnemonic('b');
        btnEliminarTodo.setText("Borrar");
        btnEliminarTodo.setToolTipText("Boorar Factura Completa");
        btnEliminarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTodoActionPerformed(evt);
            }
        });
        jPanel7.add(btnEliminarTodo);

        jPanel9.add(jPanel7);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnGrabar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnGrabar.setForeground(new java.awt.Color(1, 1, 1));
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Aceptar 32 x 32.png"))); // NOI18N
        btnGrabar.setMnemonic('t');
        btnGrabar.setText("Terminar");
        btnGrabar.setToolTipText("Confirmar Factura");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });
        jPanel8.add(btnGrabar);

        jPanel9.add(jPanel8);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Totales y Usuario"));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Factura No:");
        jPanel3.add(jLabel10);

        txtIdFactura.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        txtIdFactura.setForeground(new java.awt.Color(255, 0, 0));
        txtIdFactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdFactura.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtIdFactura.setEnabled(false);
        txtIdFactura.setPreferredSize(new java.awt.Dimension(100, 24));
        jPanel3.add(txtIdFactura);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Usuario:");
        jPanel3.add(jLabel9);

        txtUsuarioActual.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        txtUsuarioActual.setForeground(new java.awt.Color(255, 0, 0));
        txtUsuarioActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuarioActual.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtUsuarioActual.setEnabled(false);
        txtUsuarioActual.setPreferredSize(new java.awt.Dimension(100, 24));
        jPanel3.add(txtUsuarioActual);

        jPanel1.add(jPanel3);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Tot Cant:");
        jPanel2.add(jLabel5);

        txtTotalCantidad.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        txtTotalCantidad.setForeground(new java.awt.Color(255, 0, 0));
        txtTotalCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalCantidad.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtTotalCantidad.setEnabled(false);
        txtTotalCantidad.setPreferredSize(new java.awt.Dimension(100, 24));
        jPanel2.add(txtTotalCantidad);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Tots Net:");
        jPanel2.add(jLabel6);

        txtTotalValor.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        txtTotalValor.setForeground(new java.awt.Color(255, 0, 0));
        txtTotalValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalValor.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtTotalValor.setEnabled(false);
        txtTotalValor.setPreferredSize(new java.awt.Dimension(100, 24));
        jPanel2.add(txtTotalValor);

        jPanel1.add(jPanel2);

        jScrollPane6.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jScrollPane6)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void cmbProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProductoItemStateChanged
        if (cmbProducto.getSelectedIndex() == -1) {
            return;
        }
        if ((((Categoria) cmbProducto.getSelectedItem()).getId_categoria() == -1)) {
            txtBuscarCodigo.setText("");
            txtPrecio.setText("RD$0.00");
        } else {
            txtBuscarCodigo.setText(((Categoria) cmbProducto.getSelectedItem()).getDescripcion());
//            txtPrecio.setText(((Categoria) cmbProducto.getSelectedItem()).getPrecio().toString());
        }
        txtCantidad.requestFocus();
    }//GEN-LAST:event_cmbProductoItemStateChanged
    private void txtBuscarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarCodigoActionPerformed
        buscarCodigo(txtBuscarCodigo.getText());
        if (cmbProducto.getSelectedIndex() != 0) {
            txtCantidad.requestFocus();
        }
    }//GEN-LAST:event_txtBuscarCodigoActionPerformed
    private void buscarCodigo(String idProducto) {
        for (int i = 0; i < cmbProducto.getItemCount(); i++) {
//            if (((Categoria) cmbProducto.getSelectedObjects(i)).
//                    getDescripcion().equals(idProducto)) {
//                cmbProducto.setSelectedIndex(i);
//                break;
//            }
        }
    }
    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        btnAdicionarActionPerformed(evt);
    }//GEN-LAST:event_txtCantidadActionPerformed
    private void btnEliminarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTodoActionPerformed
        int rta = JOptionPane.showConfirmDialog(null,
                "¿Esta Seguro de Borrar el detalle de la Factura?");
        if (rta != 0) {
            return;
        }
        limpiarTabla();
        totales();
    }//GEN-LAST:event_btnEliminarTodoActionPerformed
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        insertarProducto();
    }//GEN-LAST:event_btnAdicionarActionPerformed
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (cmbProducto.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Debe Seleccinar un Producto...");
            cmbProducto.requestFocus();
            return;
        }
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblDetalle.getModel();
            int filas = tblDetalle.getRowCount();
            for (int i = 0; filas > i; i++) {
                String idTabla = tblDetalle.getValueAt(i, 0).toString();

                if (idTabla.equals(
                        ((Categoria) cmbProducto.getSelectedItem())
                                .getDescripcion())) {
                    modelo.removeRow(i);
                    //Actualizamos Totales
                    totales();
                    txtBuscarCodigo.setText("");
                    cmbProducto.setSelectedIndex(0);
                    txtBuscarCodigo.requestFocus();
                    return;
                }
            }

        } catch (Exception e) {
            //Instalar Logger
        }
        totales();
    }//GEN-LAST:event_btnEliminarActionPerformed
    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if (tblDetalle.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Debe Ingresar Detalle de la Factura...");
            txtBuscarCodigo.requestFocus();
        } else {
            grabarFactura();
        }
    }//GEN-LAST:event_btnGrabarActionPerformed
    private void tblDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalleMouseClicked
        String producto = tblDetalle.getValueAt(tblDetalle.getSelectedRow(), 0).toString();
        
        for (int i = 0; i <= cmbProducto.getItemCount() - 1; i++) {
//            String producto2 = ((Categoria) cmbProducto.getSelectedObjects(i)).getDescripcion();
//            if (producto2.equals(producto)) {
//                cmbProducto.setSelectedIndex(i);
//                break;
//            }
        }
    }//GEN-LAST:event_tblDetalleMouseClicked
    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        frmBusquedaCliente miBusqueda = new frmBusquedaCliente(this, true);
        miBusqueda.setLocationRelativeTo(null);
        miBusqueda.setVisible(true);

        String rta = miBusqueda.getRespuesta();

        if (rta.equals("")) {
            miBusqueda.dispose();
            return;
        }

        for (int i = 0; i < cmbCliente.getItemCount(); i++) {
//            if (((Categoria) cmbCliente.getSelectedObjects(i)).getDescripcion().equals(rta)) {
//                cmbCliente.setSelectedIndex(i);
//                break;
//            }
        }

        miBusqueda.dispose();
    }//GEN-LAST:event_btnBuscarClienteActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        txtFecha.setText(date.format(now));

        clientes();
        cmProductos();

        llenarTabla();
        repararRegistro();
    }//GEN-LAST:event_formWindowOpened
    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        estadoCliente();
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if (caracter == '.') {
            return;
        }
        if (caracter < '0' || (caracter > '9')) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private synchronized void clientes() {
        cmbCliente.removeAllItems();
        cmbCliente.repaint();
        Categoria opc;
//        try {
            //Cargamos Clientes
//            ResultSet rsCli = getClientes();
//
//            while (rsCli.next()) {
//                opc = new Categoria(
//                        rsCli.getString("idCliente"),
//                        rsCli.getString("nombres")
//                        + " "
//                        + rsCli.getString("apellidos"));
//                cmbCliente.addItem(opc);
//            }//fin
            cmbCliente.setSelectedIndex(0);
//        } catch (SQLException ex) {
//            //Instalar Logger
//        }
    }

    private synchronized void cmProductos() {
        cmbProducto.removeAllItems();
        textAutoCompleter.removeAllItems();
//        Categoria opc = new Categoria(-1, "Seleccione un Producto...");
//        cmbProducto.addItem(opc);
//        try {
//            ResultSet rs = getConsulta(
//                    "SELECT p.idProducto, p.codigo ,p.descripcion, e.precio "
//                    + "from tabla_productos p "
//                    + "INNER JOIN tabla_entradas_producto e ON e.idProducto = p.idProducto "
//                    + "where p.estado"
//            );
//            while (rs.next()) {
//                opc = new Categoria(
//                        rs.getString("codigo"),
//                        rs.getString("descripcion"),
//                        rs.getBigDecimal("precio"));
//                
//                cmbProducto.addItem(opc);
//                
//                opc = new Categoria(
//                        rs.getString("codigo"),
//                        rs.getString("descripcion"));
//                
//                textAutoCompleter.addItem(opc);
//            }
//        } catch (SQLException ex) {
//            //Instalar Logger
//        }
    }

    /**
     * TODO Trabajando en este metodo.
     */
    private void estadoCliente() {
        if (cmbCliente.getSelectedIndex() == -1) {
            return;
        }
//        try {
//            ResultSet rsCli = getClientes(((Categoria) cmbCliente.getSelectedItem()).getDescripcion());
//            while (rsCli.next()) {
//                //Pantalla Arriba
//                JlCantidad.setText("Estado del Cliente: " + rsCli.getString("NombreCompleto"));
//                JlCantidad1.setText("Limite de Credito: $"
//                        + "                 "
//                        + " Deuda Actual: ");
//            }//Fin del While////////////////////////////////////////////////////
//        } catch (SQLException ex) {
//            //Instalar Logger
//        }
    }

    private void calculaHora() {
        Calendar calendario2 = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        calendario2.setTime(fechaHoraActual);
        ampm = calendario2.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
        if (ampm.equals("PM")) {
            int h = calendario2.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = calendario2.get(Calendar.HOUR_OF_DAY) > 9 ? ""
                    + calendario2.get(Calendar.HOUR_OF_DAY) : "0"
                    + calendario2.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario2.get(Calendar.MINUTE) > 9 ? ""
                + calendario2.get(Calendar.MINUTE) : "0"
                + calendario2.get(Calendar.MINUTE);
        segundos = calendario2.get(Calendar.SECOND) > 9 ? ""
                + calendario2.get(Calendar.SECOND) : "0"
                + calendario2.get(Calendar.SECOND);
    }

    private void grabarFactura() {
        //Fin de Validaciones
        //Adicionamos un consecutivo a la Factura oh numero d Factura proxima
        int idTurno = 0;//idTurnoActivo();
        String nombre;
        boolean dime = true;
        if (cmbCliente.getSelectedIndex() == 0) {
            do {
                nombre = JOptionPane.showInputDialog(null,
                        "Inserte nombre de Cliente: ",
                        "Nombre de usuario...", JOptionPane.QUESTION_MESSAGE);
                if ("".equals(nombre)) {
                    dime = true;
                    JOptionPane.showMessageDialog(null, "Inserte un nombre!!");
                }
                if (nombre == null) {
                    nombre = "";
                    dime = true;
                }
                if (!"".equals(nombre)) {
                    dime = false;
                }
            } while (dime);
        } else {
            nombre = ((Categoria) cmbCliente.getSelectedItem()).getDescripcion();
        }
        //Encabezado de Factura
//        if (!agregarFacturaNombre(
//                null
////                new Factura(
////                        Integer.valueOf(txtIdFactura.getText()),
////                        ((Categoria) cmbCliente.getSelectedItem()).getIdUsuario(),
////                        null,
////                        null,
////                        null,
////                        false,
////                        idTurno,
////                        null,
////                        null,
////                        't',
////                        nombre)
//        )) {
//            JOptionPane.showMessageDialog(null, "Esta compra no se ha registrado...");
//        } else {
//            //Detalle de Factura
//            int num = tblDetalle.getRowCount();
//            for (int i = 0; i < num; i++) {
//                if (!agregarDetalleFactura(
//                        new DetalleFactura(
//                                Integer.valueOf(txtIdFactura.getText()),
//                                i + 1,
//                                Integer.valueOf(tblDetalle.getValueAt(i, 0).toString()),
//                                null,
//                                new BigDecimal(tblDetalle.getValueAt(i, 2).toString()),
//                                new BigDecimal(tblDetalle.getValueAt(i, 3).toString())))) {
//                    borrarFactura(Integer.valueOf(txtIdFactura.getText()));
//                    JOptionPane.showMessageDialog(null, "Esta compra no se ha registrado...");
//                    return;
//                }
//            }
//        }
        //Inicialiamos Cambios
        cmbCliente.setSelectedIndex(0);
        JlCantidad.setText("");
        JlCantidad1.setText("");
        limpiarTabla();
        totales();
        txtBuscarCodigo.requestFocus();
    }

    private void limpiarCampitos() {
        cmbProducto.setSelectedIndex(0);
        cmbCliente.setSelectedIndex(0);
        txtBuscarCodigo.setText("");
        txtCantidad.setText("");
        txtBuscarCodigo.requestFocus();
    }

    private void limpiarTabla() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblDetalle.getModel();
            int filas = tblDetalle.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            //Instalar Logger
        }
        cmbCliente.setSelectedIndex(0);
    }

    private void totales() {
        int num = tblDetalle.getRowCount();
        double sumCan = 0;
        double sumVal = 0;
        for (int i = 0; i < num; i++) {
            sumCan += Utilidades.objectToDouble(tblDetalle.getValueAt(i, 3));
            sumVal += Utilidades.objectToDouble(tblDetalle.getValueAt(i, 4));
        }
        txtTotalCantidad.setText("" + Utilidades.priceWithDecimal(sumCan));
        txtTotalValor.setText("$ " + Utilidades.priceWithDecimal(sumVal));
    }

    private void insertarProducto() {
        if (cmbProducto.getSelectedIndex() == 0 || 
                txtBuscarCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Debe Seleccinar un Producto o Buscarlo por Codigo...");
            txtBuscarCodigo.requestFocus();
            return;
        }

        if (txtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Debe Ingresar Cantidad...");
            txtCantidad.requestFocus();
            return;
        }
        
        double cantidad = Utilidades.objectToDouble(txtCantidad.getValue());
        
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Debe Digitar un Valor Mayor a Cero...");
            txtCantidad.setText("");
            txtCantidad.requestFocus();
            return;
        }//Fin Validaciones
//
//        Producto miProducto = getProducto(
//                ((Categoria) cmbProducto.getSelectedItem()).getId_categoria());
//
//        if (cantidad > miProducto.getEntrada()) {//Verificar la existencia de mercancia...
//            int resp = JOptionPane.showConfirmDialog(null,
//                    "Producto : " + miProducto.getDescripcion()
//                    + "\nSolo existen: " + miProducto.getEntrada() + " Unidad o Peso"
//                    + "\nDesea Continuar?",
//                    "Limite Excedido de Existencia", JOptionPane.YES_NO_OPTION);
//            if (resp == JOptionPane.NO_OPTION) {
//                limpiarCampitos();
//                return;
//            } else {
//
//            }
//        }
//
//        //Adicionamos Productos a la Tabla
//        ///////////////////////////////////////////////////////////////////////////////////
//        Object registro[] = new Object[5];
//        registro[0] = miProducto.getIdProducto();
//        registro[1] = miProducto.getDescripcion();
//        registro[2] = "" + miProducto.getPrecio();
//        registro[3] = "" + Utilidades.priceWithDecimal(
//                Double.parseDouble(txtCantidad.getText()));
//        registro[4] = "" + Utilidades.priceWithDecimal(
//                Double.parseDouble(txtCantidad.getText()) * miProducto.getPrecio());

//        miTabla.addRow(registro);

        tblDetalle.setModel(miTabla);

        //Inicializamos campos
        limpiarCampitos();
        //Actualizamos Totales
        totales();
        tblDetalle.changeSelection(tblDetalle.getRowCount() - 1, 0, false, false);
    }

    private void llenarTabla() {
        String titulos[] = {"ID Producto", "Descripcion", "Precio", "Cantidad",
            "Valor"};
        miTabla = new DefaultTableModel(null, titulos);

        tblDetalle.setModel(miTabla);

        //Aliniar Campos a la Derecha
        DefaultTableCellRenderer tcr;
        tcr = new DefaultTableCellHeaderRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tcr.setFont(new java.awt.Font("Tahoma", 50, 80));
        tcr.setBackground(Color.yellow);
        tblDetalle.getColumnModel().getColumn(2).setCellRenderer(tcr);
        tblDetalle.getColumnModel().getColumn(3).setCellRenderer(tcr);
        tblDetalle.getColumnModel().getColumn(4).setCellRenderer(tcr);
    }

    private void repararRegistro() {
        TableColumn miTableColumn;
        for (int i = 0; i < tblDetalle.getColumnCount(); i++) {
            miTableColumn = tblDetalle.getColumnModel().getColumn(i);
            if (i == 0) {
                miTableColumn.setPreferredWidth(100);
            }
            if (i == 1) {
                miTableColumn.setPreferredWidth(500);
            }
            if (i == 2) {
                miTableColumn.setPreferredWidth(100);
            }
            if (i == 3) {
                miTableColumn.setPreferredWidth(100);
            }
            if (i == 4) {
                miTableColumn.setPreferredWidth(100);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlCantidad;
    private javax.swing.JLabel JlCantidad1;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarTodo;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JComboBox<Categoria> cmbCliente;
    private javax.swing.JComboBox<Categoria> cmbProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tblDetalle;
    private javax.swing.JTextField txtBuscarCodigo;
    private javax.swing.JFormattedTextField txtCantidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtIdFactura;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTotalCantidad;
    private javax.swing.JTextField txtTotalValor;
    private javax.swing.JTextField txtUsuarioActual;
    // End of variables declaration//GEN-END:variables
}
