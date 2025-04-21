package sur.softsurena.formularios;

import sur.softsurena.modulo_comun.frmAcercaDe;
import sur.softsurena.modulo_comun.frmImpresoras2;
import sur.softsurena.modulo_comun.frmUsuarios;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import sur.softsurena.archivos.frmLogin;
import sur.softsurena.archivos.frmPaciente;
import sur.softsurena.archivos.frmPadres;
import sur.softsurena.control.frmHorario;
import sur.softsurena.control.frmMedicamentos;
import sur.softsurena.control.frmSeguros;
import sur.softsurena.gestion.frmConsultas2;
import sur.softsurena.gestion.frmGestionConsultas;
import sur.softsurena.metodos.Imagenes;
import sur.softsurena.utilidades.DesktopConFondo;
import static sur.softsurena.conexion.Conexion.*;
import static sur.softsurena.utilidades.Utilidades.LOG;

public final class frmPrincipal extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    public frmPrincipal() {

        //Inicializamos las variables del formulario
        initComponents();//Inicializamos todos los componente del formulario.
        //Insertamos Informacion del usuario que tenemos activo en la ventana
        //principal
//        txtUsuario.setText(
//                "Usuario: " + frmLogin.txtUsuario.getText() + "\n Rol: "
//        );

        mbMenu.add(relleno);
        mbMenu.add(jpEstado);
        mbMenu.add(txtUsuario);

        if (txtUsuario.getText().contains("SECRETARIA")) {
            mnuConsultas.setVisible(false);
        } else {
            mnuConsultas.setVisible(true);
        }

        jpEstado.setVisible(false);

        //Centralizamos ventana y ponemos visible        
        setLocationRelativeTo(null);
        setVisible(true);

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
        jMenu1 = new javax.swing.JMenu();
        mnuArchivosPadres = new javax.swing.JMenuItem();
        mnuArchivosPacientes = new javax.swing.JMenuItem();
        mnuArchivosUsuarios = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuArchivosImpresoras = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuArchivoCerrarSeccion = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuArchivosSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuControlCitas = new javax.swing.JMenuItem();
        mnuControlSeguros = new javax.swing.JMenuItem();
        mnuControlMedicamentos = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        mnuGestionConsultas = new javax.swing.JMenuItem();
        mnuConsultas = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        mnuAyudaAcercaDe = new javax.swing.JMenuItem();
        mnuAyudaAyuda = new javax.swing.JMenuItem();

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(254, 254, 254));

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

        dpnEscritorio.setPreferredSize(new java.awt.Dimension(510, 531));
        jScrollPane4.setViewportView(dpnEscritorio);

        mbMenu.setMinimumSize(new java.awt.Dimension(0, 0));

        jMenu1.setIcon(new Imagenes("Windows 8/MenuInicio 42 x 42.png").getIcono());
        jMenu1.setText("Archivos");
        jMenu1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        mnuArchivosPadres.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnuArchivosPadres.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuArchivosPadres.setIcon(new Imagenes("Windows 8/Family 42 x 42.png").getIcono());
        mnuArchivosPadres.setText("Padres");
        mnuArchivosPadres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivosPadresActionPerformed(evt);
            }
        });
        jMenu1.add(mnuArchivosPadres);

        mnuArchivosPacientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnuArchivosPacientes.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuArchivosPacientes.setIcon(new Imagenes("Windows 8/CryingBaby 42 x 42.png").getIcono());
        mnuArchivosPacientes.setText("Pacientes");
        mnuArchivosPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivosPacientesActionPerformed(evt);
            }
        });
        jMenu1.add(mnuArchivosPacientes);

        mnuArchivosUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnuArchivosUsuarios.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuArchivosUsuarios.setIcon(new Imagenes("Windows 8/User 42 x 42.png").getIcono());
        mnuArchivosUsuarios.setText("Usuarios");
        mnuArchivosUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivosUsuariosActionPerformed(evt);
            }
        });
        jMenu1.add(mnuArchivosUsuarios);
        jMenu1.add(jSeparator2);

        mnuArchivosImpresoras.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnuArchivosImpresoras.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuArchivosImpresoras.setIcon(new Imagenes("Windows 8/Printer 42 x 42.png").getIcono());
        mnuArchivosImpresoras.setText("Impresoras");
        mnuArchivosImpresoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivosImpresorasActionPerformed(evt);
            }
        });
        jMenu1.add(mnuArchivosImpresoras);
        jMenu1.add(jSeparator1);

        mnuArchivoCerrarSeccion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnuArchivoCerrarSeccion.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuArchivoCerrarSeccion.setIcon(new Imagenes("Windows 8/Salida 42 x 42.png").getIcono());
        mnuArchivoCerrarSeccion.setText("Cerrar Seccion");
        mnuArchivoCerrarSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivoCerrarSeccionActionPerformed(evt);
            }
        });
        jMenu1.add(mnuArchivoCerrarSeccion);
        jMenu1.add(jSeparator3);

        mnuArchivosSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnuArchivosSalir.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuArchivosSalir.setIcon(new Imagenes("Windows 8/Salida 42 x 42.png").getIcono());
        mnuArchivosSalir.setText("Salir");
        mnuArchivosSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivosSalirActionPerformed(evt);
            }
        });
        jMenu1.add(mnuArchivosSalir);

        mbMenu.add(jMenu1);

        jMenu2.setIcon(new Imagenes("Windows 8/PanelControl 42 x 42.png").getIcono());
        jMenu2.setText("Control de...");
        jMenu2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        mnuControlCitas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuControlCitas.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuControlCitas.setIcon(new Imagenes("Windows 8/Calendario 42 x 42.png").getIcono());
        mnuControlCitas.setText("Horarios");
        mnuControlCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuControlCitasActionPerformed(evt);
            }
        });
        jMenu2.add(mnuControlCitas);

        mnuControlSeguros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuControlSeguros.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuControlSeguros.setIcon(new Imagenes("Windows 8/TarjetasBancarias 42 x 42.png").getIcono());
        mnuControlSeguros.setText("Seguros");
        mnuControlSeguros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuControlSegurosActionPerformed(evt);
            }
        });
        jMenu2.add(mnuControlSeguros);

        mnuControlMedicamentos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuControlMedicamentos.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuControlMedicamentos.setIcon(new Imagenes("Windows 8/Pildora 42 x 42.png").getIcono());
        mnuControlMedicamentos.setText("Medicamentos");
        mnuControlMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuControlMedicamentosActionPerformed(evt);
            }
        });
        jMenu2.add(mnuControlMedicamentos);

        mbMenu.add(jMenu2);

        jMenu5.setIcon(new Imagenes("Windows 8/BoletaCalificaciones 32 x 32.png").getIcono());
        jMenu5.setText("Gestión...");
        jMenu5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        mnuGestionConsultas.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuGestionConsultas.setIcon(new Imagenes("Windows 8/Calendario 42 x 42.png").getIcono());
        mnuGestionConsultas.setText("Consultas");
        mnuGestionConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGestionConsultasActionPerformed(evt);
            }
        });
        jMenu5.add(mnuGestionConsultas);

        mnuConsultas.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        mnuConsultas.setText("Consultas Medicas");
        mnuConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConsultasActionPerformed(evt);
            }
        });
        jMenu5.add(mnuConsultas);

        mbMenu.add(jMenu5);

        mnuAyuda.setMnemonic('y');
        mnuAyuda.setText("Ayuda");
        mnuAyuda.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N

        mnuAyudaAcercaDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuAyudaAcercaDe.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        mnuAyudaAcercaDe.setText("Acerca de...");
        mnuAyudaAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAyudaAcercaDeActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuAyudaAcercaDe);

        mnuAyudaAyuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mnuAyudaAyuda.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        mnuAyudaAyuda.setText("Ayuda...");
        mnuAyudaAyuda.setToolTipText("");
        mnuAyudaAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAyudaAyudaActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuAyudaAyuda);

        mbMenu.add(mnuAyuda);

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
        final SwingWorker<?, ?> w = new SwingWorker<>() {
            @Override
            protected Object doInBackground() throws Exception {

                ((DesktopConFondo) dpnEscritorio).setImagen("/imagenes/Principal 800 x 600.jpg");
                return null;
            }
        };
        w.execute();
    }//GEN-LAST:event_formWindowOpened

    private void mnuArchivosSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivosSalirActionPerformed

        System.exit(0);
    }//GEN-LAST:event_mnuArchivosSalirActionPerformed

    private void mnuArchivosImpresorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivosImpresorasActionPerformed

        //TODO 13/12/2024 Testear esta opcion.
        new frmImpresoras2(this, true).setVisible(true);
    }//GEN-LAST:event_mnuArchivosImpresorasActionPerformed

    private void mnuArchivosPadresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivosPadresActionPerformed
//        final SwingWorker<?, ?> w = new SwingWorker<>() {
//            @Override
//            protected Object doInBackground() throws Exception {
//                frmPadres padres = frmPadres.getPadres();
//                dpnEscritorio.remove(padres);
//                dpnEscritorio.add(padres);
        ////                padres.limpiarCampos();
////                padres.llenarCombos();
////                padres.llenarTabla(true);
//                try {
//                    padres.setMaximum(true);
//                } catch (PropertyVetoException ex) {
//                    LOG.log(
//                            Level.SEVERE,
//                            "No puede maximizarse la ventana.!",
//                            ex
//                    );
//                }
//                padres.setVisible(true);
//                return padres;
//            }
//        };
//        w.execute();
        frmPadres padres = frmPadres.getPadres();
        dpnEscritorio.remove(padres);
        dpnEscritorio.add(padres);
        try {
            padres.setMaximum(true);
        } catch (PropertyVetoException ex) {
            LOG.log(
                    Level.SEVERE,
                    "No puede maximizarse la ventana.!",
                    ex
            );
        }
        padres.setVisible(true);
    }//GEN-LAST:event_mnuArchivosPadresActionPerformed

    private void mnuArchivosPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivosPacientesActionPerformed

        final SwingWorker<?, ?> w = new SwingWorker<>() {
            @Override
            protected Object doInBackground() throws PropertyVetoException {
                frmPaciente paciente = frmPaciente.getPadres();
                dpnEscritorio.remove(paciente);
                dpnEscritorio.add(paciente);
                paciente.llenarCombox();
                paciente.llenarTabla();
                paciente.centralizar();
                paciente.setMaximum(true);
                paciente.setVisible(true);
                return paciente;
            }
        };
        w.execute();
    }//GEN-LAST:event_mnuArchivosPacientesActionPerformed

    private void mnuArchivosUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivosUsuariosActionPerformed
        final SwingWorker<?, ?> w = new SwingWorker<>() {
            @Override
            protected Object doInBackground() throws PropertyVetoException {

                //frmUsuarios usuarios = frmUsuarios.getUsuarios();
                frmUsuarios usuarios = frmUsuarios.getInstance();
                dpnEscritorio.remove(usuarios);
                dpnEscritorio.add(usuarios);
//                u.centralizar();
//                u.llenarTabla(true,
//                        "Llenando la tabla de usuario desde el inicio");
//
                usuarios.setMaximum(true);
                usuarios.setVisible(true);
                return usuarios;
            }
        };
        w.execute();
    }//GEN-LAST:event_mnuArchivosUsuariosActionPerformed

    private void mnuArchivoCerrarSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivoCerrarSeccionActionPerformed
        final SwingWorker<?, ?> w = new SwingWorker<>() {
            @Override
            protected Object doInBackground() throws Exception {

                frmLogin l = new frmLogin();
                l.setLocationRelativeTo(null);
                l.setVisible(true);
                setCnn(null);
                dispose();
                System.gc();
                return null;
            }
        };
        w.execute();
    }//GEN-LAST:event_mnuArchivoCerrarSeccionActionPerformed

    private void mnuControlCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuControlCitasActionPerformed
        final SwingWorker<?, ?> w = new SwingWorker<>() {
            @Override
            protected Object doInBackground() throws Exception {

                frmHorario c = frmHorario.getControlCita();
                dpnEscritorio.remove(c);
                dpnEscritorio.add(c);

                c.centralizar();

                try {
                    c.setClosed(false);
                } catch (PropertyVetoException ex) {
                    //Instalar Logger
                }
                c.show();

                return c;
            }
        };

        w.execute();

    }//GEN-LAST:event_mnuControlCitasActionPerformed

    private void mnuControlSegurosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuControlSegurosActionPerformed
        SwingWorker<?, ?> w = new SwingWorker<>() {
            @Override
            protected Object doInBackground() throws Exception {

                frmSeguros s = frmSeguros.getSeguros();
                dpnEscritorio.remove(s);
                dpnEscritorio.add(s);
                s.centralizar();
                return null;
            }
        };
        w.execute();
    }//GEN-LAST:event_mnuControlSegurosActionPerformed

    private void mnuControlMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuControlMedicamentosActionPerformed

        frmMedicamentos m = frmMedicamentos.getMedicamentos();
        dpnEscritorio.remove(m);
        dpnEscritorio.add(m);
        m.centralizar();
    }//GEN-LAST:event_mnuControlMedicamentosActionPerformed

    private void mnuGestionConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGestionConsultasActionPerformed
        final SwingWorker<?, ?> w = new SwingWorker<>() {
            @Override
            protected Object doInBackground() throws Exception {

                frmGestionConsultas c = frmGestionConsultas.getCitas();
                dpnEscritorio.remove(c);
                dpnEscritorio.add(c);
                c.setVisible(true);
                c.centralizar();
                return c;
            }

        };
        w.execute();
    }//GEN-LAST:event_mnuGestionConsultasActionPerformed

    private void mnuConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultasActionPerformed
        final SwingWorker<?, ?> w = new SwingWorker<>() {
            @Override
            protected Object doInBackground() throws Exception {

                frmConsultas2 consultas = frmConsultas2.getConsultas2();

                dpnEscritorio.remove(consultas);
                dpnEscritorio.add(consultas);

                consultas.setMaximum(true);

                consultas.setVisible(true);
                return consultas;
            }
        };
        w.execute();
    }//GEN-LAST:event_mnuConsultasActionPerformed

    private void mnuAyudaAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAyudaAcercaDeActionPerformed
        frmAcercaDe acerca = frmAcercaDe.getInstance(null, true);
        acerca.setLocationRelativeTo(this);
        acerca.setVisible(true);
    }//GEN-LAST:event_mnuAyudaAcercaDeActionPerformed

    private void mnuAyudaAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAyudaAyudaActionPerformed

    }//GEN-LAST:event_mnuAyudaAyudaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane dpnEscritorio;
    public static javax.swing.JLabel jLabelImpresion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    public static javax.swing.JPanel jpEstado;
    public static javax.swing.JProgressBar jpbEstado;
    private javax.swing.JMenuBar mbMenu;
    private javax.swing.JMenuItem mnuArchivoCerrarSeccion;
    private javax.swing.JMenuItem mnuArchivosImpresoras;
    private javax.swing.JMenuItem mnuArchivosPacientes;
    private javax.swing.JMenuItem mnuArchivosPadres;
    private javax.swing.JMenuItem mnuArchivosSalir;
    private javax.swing.JMenuItem mnuArchivosUsuarios;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenuItem mnuAyudaAcercaDe;
    private javax.swing.JMenuItem mnuAyudaAyuda;
    private javax.swing.JMenuItem mnuConsultas;
    private javax.swing.JMenuItem mnuControlCitas;
    private javax.swing.JMenuItem mnuControlMedicamentos;
    private javax.swing.JMenuItem mnuControlSeguros;
    private javax.swing.JMenuItem mnuGestionConsultas;
    private javax.swing.Box.Filler relleno;
    public static javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
