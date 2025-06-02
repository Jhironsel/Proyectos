package sur.softsurena.estancia.vista;

import static clases.Datos.getDatos;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import javax.swing.SwingWorker;
import sur.softsurena.metodos.Imagenes;
import sur.softsurena.metodos.M_Usuario;
import sur.softsurena.modulo_comun.frmImpresoras2;
import sur.softsurena.modulo_comun.frmPersonas;
import sur.softsurena.utilidades.DesktopConFondo;
import static sur.softsurena.utilidades.Utilidades.LOG;

public final class frmPrincipal extends javax.swing.JFrame {

    public frmPrincipal() {
        //Inicializamos las variables del formulario
        initComponents();//Inicializamos todos los componente del formulario.

        //Insertamos Informacion del usuario que tenemos activo en la ventana
        //principal
        var usuario = M_Usuario.getUsuarioActual();
        txtUsuario.setText("Usuario: %s %s.".formatted(
                usuario.getUserName(),
                usuario.getPersona().getRol()
        ));

        mbMenu.add(relleno);
        mbMenu.add(jpEstado);
        mbMenu.add(txtUsuario);

        jpEstado.setVisible(false);

        mnuArchivos.setVisible(true);
        mnuArchivosEmpleados.setVisible(true);
        mnuArchivosImpresoras.setVisible(true);
        mnuArchivoCerrarSeccion.setVisible(true);
        mnuArchivosSalir.setVisible(true);

        mnuControlDe.setVisible(true);
        mnuControlHorarios.setVisible(true);
        mnuControlPermisos.setVisible(true);

        mnuGestion.setVisible(true);
   
        setVisible(true);
        System.out.println("Debes verlas...");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JLabel();
        relleno = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jpEstado = new javax.swing.JPanel();
        jLabelImpresion = new javax.swing.JLabel();
        jpbEstado = new javax.swing.JProgressBar();
        jScrollPane4 = new javax.swing.JScrollPane();
        dpnEscritorio = new DesktopConFondo();
        mbMenu = new javax.swing.JMenuBar();
        mnuArchivos = new javax.swing.JMenu();
        mnuArchivosEmpleados = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuArchivosImpresoras = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuArchivoCerrarSeccion = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuArchivosSalir = new javax.swing.JMenuItem();
        mnuControlDe = new javax.swing.JMenu();
        mnuControlHorarios = new javax.swing.JMenuItem();
        mnuControlAsignacionHorario = new javax.swing.JMenuItem();
        mnuControlPermisos = new javax.swing.JMenuItem();
        mnuGestion = new javax.swing.JMenu();
        mnuGestionEntrada = new javax.swing.JMenuItem();
        mnuGestionSalida = new javax.swing.JMenuItem();

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jpEstado.setMaximumSize(new java.awt.Dimension(400, 30));
        jpEstado.setMinimumSize(new java.awt.Dimension(90, 30));
        jpEstado.setPreferredSize(new java.awt.Dimension(300, 30));
        jpEstado.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        jLabelImpresion.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelImpresion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelImpresion.setText("Proceso en curso");
        jLabelImpresion.setMaximumSize(new java.awt.Dimension(120, 25));
        jLabelImpresion.setMinimumSize(new java.awt.Dimension(59, 25));
        jpEstado.add(jLabelImpresion);

        jpbEstado.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jpbEstado.setDoubleBuffered(true);
        jpbEstado.setMaximumSize(new java.awt.Dimension(32767, 30));
        jpbEstado.setMinimumSize(new java.awt.Dimension(0, 30));
        jpbEstado.setStringPainted(true);
        jpEstado.add(jpbEstado);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventana principal del sistema");
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        setMinimumSize(new java.awt.Dimension(640, 480));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        dpnEscritorio.setBackground(new java.awt.Color(0, 102, 102));
        dpnEscritorio.setPreferredSize(new java.awt.Dimension(510, 531));
        jScrollPane4.setViewportView(dpnEscritorio);

        mbMenu.setBackground(new java.awt.Color(195, 226, 252));
        mbMenu.setForeground(new java.awt.Color(1, 1, 1));
        mbMenu.setMinimumSize(new java.awt.Dimension(0, 0));

        mnuArchivos.setIcon(new Imagenes("Menu Inicio 42 x 42.png").getIcono());
        mnuArchivos.setText("Archivos");
        mnuArchivos.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        mnuArchivosEmpleados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnuArchivosEmpleados.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuArchivosEmpleados.setForeground(new java.awt.Color(1, 1, 1));
        mnuArchivosEmpleados.setIcon(new Imagenes("Empleado 42 x 42.png").getIcono());
        mnuArchivosEmpleados.setText("Empleados");
        mnuArchivosEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivosEmpleadosActionPerformed(evt);
            }
        });
        mnuArchivos.add(mnuArchivosEmpleados);
        mnuArchivos.add(jSeparator2);

        mnuArchivosImpresoras.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnuArchivosImpresoras.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuArchivosImpresoras.setForeground(new java.awt.Color(1, 1, 1));
        mnuArchivosImpresoras.setIcon(new Imagenes("Impresora 42 x 42.png").getIcono());
        mnuArchivosImpresoras.setText("Impresoras");
        mnuArchivosImpresoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivosImpresorasActionPerformed(evt);
            }
        });
        mnuArchivos.add(mnuArchivosImpresoras);
        mnuArchivos.add(jSeparator1);

        mnuArchivoCerrarSeccion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnuArchivoCerrarSeccion.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuArchivoCerrarSeccion.setForeground(new java.awt.Color(1, 1, 1));
        mnuArchivoCerrarSeccion.setIcon(new Imagenes("Cerrar session 42 x 42.png").getIcono());
        mnuArchivoCerrarSeccion.setText("Cerrar Seccion");
        mnuArchivoCerrarSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivoCerrarSeccionActionPerformed(evt);
            }
        });
        mnuArchivos.add(mnuArchivoCerrarSeccion);
        mnuArchivos.add(jSeparator3);

        mnuArchivosSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnuArchivosSalir.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuArchivosSalir.setForeground(new java.awt.Color(1, 1, 1));
        mnuArchivosSalir.setIcon(new Imagenes("Cerrar 920 x 920.png").getIcono(42, 42));
        mnuArchivosSalir.setText("Salir");
        mnuArchivosSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivosSalirActionPerformed(evt);
            }
        });
        mnuArchivos.add(mnuArchivosSalir);

        mbMenu.add(mnuArchivos);

        mnuControlDe.setIcon(new Imagenes("icons8-panel-de-control-42.png").getIcono());
        mnuControlDe.setText("Control de...");
        mnuControlDe.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        mnuControlHorarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuControlHorarios.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuControlHorarios.setForeground(new java.awt.Color(1, 1, 1));
        mnuControlHorarios.setIcon(new Imagenes("icons8-intervalo-de-tiempo-42.png").getIcono());
        mnuControlHorarios.setText("Horarios");
        mnuControlHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuControlHorariosActionPerformed(evt);
            }
        });
        mnuControlDe.add(mnuControlHorarios);

        mnuControlAsignacionHorario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuControlAsignacionHorario.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuControlAsignacionHorario.setForeground(new java.awt.Color(1, 1, 1));
        mnuControlAsignacionHorario.setIcon(new Imagenes("AsignacionHorario 42.png").getIcono());
        mnuControlAsignacionHorario.setText("Asignacion Horario");
        mnuControlAsignacionHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuControlAsignacionHorarioActionPerformed(evt);
            }
        });
        mnuControlDe.add(mnuControlAsignacionHorario);

        mnuControlPermisos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuControlPermisos.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuControlPermisos.setForeground(new java.awt.Color(1, 1, 1));
        mnuControlPermisos.setIcon(new Imagenes("icons8-robo-de-identidad-42.png").getIcono());
        mnuControlPermisos.setText("Permisos");
        mnuControlPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuControlPermisosActionPerformed(evt);
            }
        });
        mnuControlDe.add(mnuControlPermisos);

        mbMenu.add(mnuControlDe);

        mnuGestion.setIcon(new Imagenes("icons8-boleta-de-calificaciones-32.png").getIcono());
        mnuGestion.setText("Gestión...");
        mnuGestion.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        mnuGestionEntrada.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuGestionEntrada.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuGestionEntrada.setForeground(new java.awt.Color(1, 1, 1));
        mnuGestionEntrada.setIcon(new Imagenes("Entrada.png").getIcono());
        mnuGestionEntrada.setText("Entradas");
        mnuGestionEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGestionEntradaActionPerformed(evt);
            }
        });
        mnuGestion.add(mnuGestionEntrada);

        mnuGestionSalida.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuGestionSalida.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuGestionSalida.setForeground(new java.awt.Color(1, 1, 1));
        mnuGestionSalida.setIcon(new Imagenes("Salida.png").getIcono());
        mnuGestionSalida.setText("Salidas");
        mnuGestionSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGestionSalidaActionPerformed(evt);
            }
        });
        mnuGestion.add(mnuGestionSalida);

        mbMenu.add(mnuGestion);

        setJMenuBar(mbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        final SwingWorker w = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                ((DesktopConFondo) dpnEscritorio).setImagen("Principal 800 x 600.jpg");
                return null;
            }
        };
        w.execute();
    }//GEN-LAST:event_formWindowOpened

    private void mnuArchivosSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivosSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuArchivosSalirActionPerformed

    private void mnuArchivosImpresorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivosImpresorasActionPerformed
        new frmImpresoras2(this, true).setVisible(true);
    }//GEN-LAST:event_mnuArchivosImpresorasActionPerformed

    private void mnuArchivoCerrarSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivoCerrarSeccionActionPerformed
        final SwingWorker w = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {

                frmLogin l = new frmLogin();
                l.setLocationRelativeTo(null);
                l.setVisible(true);
                getDatos("Cerrando la conexion").cerrarConexion();
                getDatos("Nulando la conexion").setConn(null);
                dispose();
                System.gc();
                return null;
            }
        };
        w.execute();
    }//GEN-LAST:event_mnuArchivoCerrarSeccionActionPerformed

    private void mnuArchivosEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivosEmpleadosActionPerformed
//        final SwingWorker w = new SwingWorker() {
//            @Override
//            protected Object doInBackground() throws PropertyVetoException {
//                
//                return e;
//            }
//        };
//        w.execute();

        var e = frmPersonas.getInstance();
        dpnEscritorio.remove(e);
        dpnEscritorio.add(e);
        try {
            e.setMaximum(true);
        } catch (PropertyVetoException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        e.setVisible(true);
    }//GEN-LAST:event_mnuArchivosEmpleadosActionPerformed

    private void mnuControlHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuControlHorariosActionPerformed
        final SwingWorker w = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                frmHorarios h = frmHorarios.getHorarios();
                dpnEscritorio.remove(h);
                dpnEscritorio.add(h);
                h.setMaximum(true);
                h.setVisible(true);
                return h;
            }
        };
        w.execute();
    }//GEN-LAST:event_mnuControlHorariosActionPerformed

    private void mnuGestionEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGestionEntradaActionPerformed
        // TODO 19.04.2025 Crear formulario de entrada.
    }//GEN-LAST:event_mnuGestionEntradaActionPerformed

    private void mnuGestionSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGestionSalidaActionPerformed
        // TODO 19.04.2025 Crear formulario de salida.
    }//GEN-LAST:event_mnuGestionSalidaActionPerformed

    private void mnuControlPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuControlPermisosActionPerformed
        // TODO 19.04.2025 Crear formulario de permisos.
    }//GEN-LAST:event_mnuControlPermisosActionPerformed

    private void mnuControlAsignacionHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuControlAsignacionHorarioActionPerformed
        final SwingWorker w = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                frmAsignacionHorario h = frmAsignacionHorario.getAsignacionHorario();
                dpnEscritorio.remove(h);
                dpnEscritorio.add(h);
                h.setMaximum(true);
                h.setVisible(true);
                return h;
            }
        };
        w.execute();
    }//GEN-LAST:event_mnuControlAsignacionHorarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane dpnEscritorio;
    public static javax.swing.JLabel jLabelImpresion;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    public static javax.swing.JPanel jpEstado;
    public static javax.swing.JProgressBar jpbEstado;
    private javax.swing.JMenuBar mbMenu;
    private javax.swing.JMenuItem mnuArchivoCerrarSeccion;
    private javax.swing.JMenu mnuArchivos;
    private javax.swing.JMenuItem mnuArchivosEmpleados;
    private javax.swing.JMenuItem mnuArchivosImpresoras;
    private javax.swing.JMenuItem mnuArchivosSalir;
    private javax.swing.JMenuItem mnuControlAsignacionHorario;
    private javax.swing.JMenu mnuControlDe;
    private javax.swing.JMenuItem mnuControlHorarios;
    private javax.swing.JMenuItem mnuControlPermisos;
    private javax.swing.JMenu mnuGestion;
    private javax.swing.JMenuItem mnuGestionEntrada;
    private javax.swing.JMenuItem mnuGestionSalida;
    private javax.swing.Box.Filler relleno;
    public static javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
