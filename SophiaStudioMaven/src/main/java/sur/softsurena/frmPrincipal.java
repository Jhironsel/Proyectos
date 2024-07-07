package sur.softsurena;

import Clases.Sonido;
import Clases.SophiaStudio;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.utilidades.DesktopConFondo;
import sur.softsurena.utilidades.Opcion;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class frmPrincipal extends javax.swing.JFrame implements Runnable {

    private int id;
    private int[] idPerfiles = new int[getId()];
    private String Usuario;
    private final String logotipo = "/Reportes/Logo.jpg";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getIdPerfiles() {
        return idPerfiles;
    }

    public void setIdPerfiles(int[] idPerfiles) {
        this.idPerfiles = idPerfiles;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    //Instanciando Formularios
    frmRegistroPadre miPadre = new frmRegistroPadre();
    frmModificarPadre miPadreModificar = new frmModificarPadre();
    frmRegistroEstudiante miEstudiante = new frmRegistroEstudiante();
    frmModificarEstudiante miMEstudiante = new frmModificarEstudiante();
    frmConsultaEstudiante miCEstudiante = new frmConsultaEstudiante();
    frmRegistroUsuarios miUsuarios = new frmRegistroUsuarios();
    frmModificarUsuarios miUsuarioModificar = new frmModificarUsuarios();
    frmPagos miPago = new frmPagos();
    frmAbonos miAbono = new frmAbonos();
    frmReporteEstudiante miReporte = new frmReporteEstudiante();
    frmAjusteTandas miAjuste = new frmAjusteTandas();
    frmAjustePerfil miPerfil = new frmAjustePerfil();
    frmInscripcion miInscripcion = new frmInscripcion();
    frmUbicacionReportes miUbicacion = new frmUbicacionReportes();

    private void cerrarFormularios() {
        dpnEscritorio.getDesktopManager().closeFrame(miPadre);
        dpnEscritorio.getDesktopManager().closeFrame(miPadreModificar);
        dpnEscritorio.getDesktopManager().closeFrame(miEstudiante);
        dpnEscritorio.getDesktopManager().closeFrame(miMEstudiante);
        dpnEscritorio.getDesktopManager().closeFrame(miCEstudiante);
        dpnEscritorio.getDesktopManager().closeFrame(miUsuarios);
        dpnEscritorio.getDesktopManager().closeFrame(miUsuarioModificar);
        dpnEscritorio.getDesktopManager().closeFrame(miPago);
        dpnEscritorio.getDesktopManager().closeFrame(miReporte);
        dpnEscritorio.getDesktopManager().closeFrame(miAjuste);
        dpnEscritorio.getDesktopManager().closeFrame(miPerfil);
        dpnEscritorio.getDesktopManager().closeFrame(miAbono);
        //dpnEscritorio.getDesktopManager().closeFrame(miInscripcion);
        dpnEscritorio.getDesktopManager().closeFrame(miUbicacion);
    }

    public frmPrincipal() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpnEscritorio = new DesktopConFondo();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArchivos = new javax.swing.JMenu();
        mnuPadres = new javax.swing.JMenu();
        mnuRegistroPadre = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuModificarPadre = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        mnuEstudiantes = new javax.swing.JMenu();
        mnuRegistroEstudiantes = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuModificarEstudiantes = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuConsultarEstudiantes = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        mnuUsuarios = new javax.swing.JMenu();
        mnuAgregarUsuarios = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnuModificarUsuarios = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnuBorrarUsuarios = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mnuCambiarUsuario = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        mnuSalir = new javax.swing.JMenuItem();
        mnuREstudiantes = new javax.swing.JMenu();
        mnuInscribir = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        mnuPago = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        mnuReporteEstudianteFull = new javax.swing.JMenuItem();
        mnuParamentros = new javax.swing.JMenu();
        mnuAjusteTanda = new javax.swing.JMenuItem();
        mnuAjustePerfil = new javax.swing.JMenuItem();
        mnuUbucacionReportes = new javax.swing.JMenuItem();
        mnuAcerca = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuContactar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Ballet [Sophia's Studio]");
        setName("frmPrincipal"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        dpnEscritorio.setBackground(new java.awt.Color(255, 102, 204));
        dpnEscritorio.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(1, 1, 1), new java.awt.Color(87, 87, 87)));

        javax.swing.GroupLayout dpnEscritorioLayout = new javax.swing.GroupLayout(dpnEscritorio);
        dpnEscritorio.setLayout(dpnEscritorioLayout);
        dpnEscritorioLayout.setHorizontalGroup(
            dpnEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );
        dpnEscritorioLayout.setVerticalGroup(
            dpnEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        mnuArchivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Archivos.png"))); // NOI18N
        mnuArchivos.setText("Archivos");
        mnuArchivos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        mnuPadres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/parents-icon2.png"))); // NOI18N
        mnuPadres.setText("Padres");
        mnuPadres.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        mnuRegistroPadre.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mnuRegistroPadre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AgregarPadre.png"))); // NOI18N
        mnuRegistroPadre.setText("Registro Padre");
        mnuRegistroPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegistroPadreActionPerformed(evt);
            }
        });
        mnuPadres.add(mnuRegistroPadre);
        mnuPadres.add(jSeparator3);

        mnuModificarPadre.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mnuModificarPadre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/parents-Modificar.png"))); // NOI18N
        mnuModificarPadre.setText("Modificar Padre");
        mnuModificarPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModificarPadreActionPerformed(evt);
            }
        });
        mnuPadres.add(mnuModificarPadre);

        mnuArchivos.add(mnuPadres);
        mnuArchivos.add(jSeparator9);

        mnuEstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Estudiante64.png"))); // NOI18N
        mnuEstudiantes.setText("Alumnos");
        mnuEstudiantes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        mnuRegistroEstudiantes.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mnuRegistroEstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BalletAdd.png"))); // NOI18N
        mnuRegistroEstudiantes.setText("Registro Alumno");
        mnuRegistroEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegistroEstudiantesActionPerformed(evt);
            }
        });
        mnuEstudiantes.add(mnuRegistroEstudiantes);
        mnuEstudiantes.add(jSeparator1);

        mnuModificarEstudiantes.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mnuModificarEstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BalletEditar.png"))); // NOI18N
        mnuModificarEstudiantes.setText("Modificar Alumno");
        mnuModificarEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModificarEstudiantesActionPerformed(evt);
            }
        });
        mnuEstudiantes.add(mnuModificarEstudiantes);
        mnuEstudiantes.add(jSeparator2);

        mnuConsultarEstudiantes.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mnuConsultarEstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BalletFind.png"))); // NOI18N
        mnuConsultarEstudiantes.setText("Consulta de Alumno");
        mnuConsultarEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConsultarEstudiantesActionPerformed(evt);
            }
        });
        mnuEstudiantes.add(mnuConsultarEstudiantes);

        mnuArchivos.add(mnuEstudiantes);
        mnuArchivos.add(jSeparator10);

        mnuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Usuario.png"))); // NOI18N
        mnuUsuarios.setText("Usuarios");
        mnuUsuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        mnuAgregarUsuarios.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mnuAgregarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AgregarUsuario.png"))); // NOI18N
        mnuAgregarUsuarios.setText("Registro Usuarios");
        mnuAgregarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAgregarUsuariosActionPerformed(evt);
            }
        });
        mnuUsuarios.add(mnuAgregarUsuarios);
        mnuUsuarios.add(jSeparator5);

        mnuModificarUsuarios.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mnuModificarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ModificarUsuario.png"))); // NOI18N
        mnuModificarUsuarios.setText("Modificar Usuarios");
        mnuModificarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModificarUsuariosActionPerformed(evt);
            }
        });
        mnuUsuarios.add(mnuModificarUsuarios);
        mnuUsuarios.add(jSeparator4);

        mnuBorrarUsuarios.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mnuBorrarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/EliminarUsuario.png"))); // NOI18N
        mnuBorrarUsuarios.setText("Borrar Usuarios");
        mnuBorrarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBorrarUsuariosActionPerformed(evt);
            }
        });
        mnuUsuarios.add(mnuBorrarUsuarios);

        mnuArchivos.add(mnuUsuarios);
        mnuArchivos.add(jSeparator6);

        mnuCambiarUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        mnuCambiarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CambioUsuario.png"))); // NOI18N
        mnuCambiarUsuario.setText("Cambiar Usuarios");
        mnuCambiarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCambiarUsuarioActionPerformed(evt);
            }
        });
        mnuArchivos.add(mnuCambiarUsuario);
        mnuArchivos.add(jSeparator12);

        mnuSalir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Salir.png"))); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        mnuArchivos.add(mnuSalir);

        jMenuBar1.add(mnuArchivos);

        mnuREstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Movimiento 72 x 72.png"))); // NOI18N
        mnuREstudiantes.setText("Movimientos");
        mnuREstudiantes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        mnuInscribir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        mnuInscribir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Inscripcion.png"))); // NOI18N
        mnuInscribir.setText("Inscripcion");
        mnuInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInscribirActionPerformed(evt);
            }
        });
        mnuREstudiantes.add(mnuInscribir);
        mnuREstudiantes.add(jSeparator13);

        mnuPago.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        mnuPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PagosMensualidad.png"))); // NOI18N
        mnuPago.setText("Pagos Mensualidad");
        mnuPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPagoActionPerformed(evt);
            }
        });
        mnuREstudiantes.add(mnuPago);
        mnuREstudiantes.add(jSeparator8);

        mnuReporteEstudianteFull.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        mnuReporteEstudianteFull.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Factura.png"))); // NOI18N
        mnuReporteEstudianteFull.setText("Reporte de Estudiantes");
        mnuReporteEstudianteFull.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuReporteEstudianteFullActionPerformed(evt);
            }
        });
        mnuREstudiantes.add(mnuReporteEstudianteFull);

        jMenuBar1.add(mnuREstudiantes);

        mnuParamentros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Parametros72.png"))); // NOI18N
        mnuParamentros.setText("Parametros");
        mnuParamentros.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        mnuAjusteTanda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        mnuAjusteTanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clock72.png"))); // NOI18N
        mnuAjusteTanda.setText("Ajuste de Tandas");
        mnuAjusteTanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAjusteTandaActionPerformed(evt);
            }
        });
        mnuParamentros.add(mnuAjusteTanda);

        mnuAjustePerfil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        mnuAjustePerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ModificarUsuario.png"))); // NOI18N
        mnuAjustePerfil.setText("Ajuste de Perfil de Usuarios");
        mnuAjustePerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAjustePerfilActionPerformed(evt);
            }
        });
        mnuParamentros.add(mnuAjustePerfil);

        mnuUbucacionReportes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        mnuUbucacionReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Reportes.png"))); // NOI18N
        mnuUbucacionReportes.setText("Ubicaciones de Reportes Y Otros");
        mnuUbucacionReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUbucacionReportesActionPerformed(evt);
            }
        });
        mnuParamentros.add(mnuUbucacionReportes);

        jMenuBar1.add(mnuParamentros);

        mnuAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo.png"))); // NOI18N
        mnuAcerca.setText("Acerca de...");
        mnuAcerca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ayuda64x64.png"))); // NOI18N
        jMenuItem1.setText("Ayuda...");
        mnuAcerca.add(jMenuItem1);

        mnuContactar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        mnuContactar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Programador64x64.png"))); // NOI18N
        mnuContactar.setText("Contactos...");
        mnuContactar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuContactarActionPerformed(evt);
            }
        });
        mnuAcerca.add(mnuContactar);

        jMenuBar1.add(mnuAcerca);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpnEscritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpnEscritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuSalirActionPerformed
    private void mnuRegistroEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistroEstudiantesActionPerformed
        cerrarFormularios();
        try {
            //Listo
            dpnEscritorio.add(miEstudiante);
            miEstudiante.show();
            miEstudiante.setMaximum(true);
        } catch (PropertyVetoException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }//GEN-LAST:event_mnuRegistroEstudiantesActionPerformed
    private void mnuConsultarEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultarEstudiantesActionPerformed
        cerrarFormularios();
        try {
            dpnEscritorio.add(miCEstudiante);
            miCEstudiante.jpReporte.removeAll();
            miCEstudiante.show();
            miCEstudiante.setMaximum(true);
            miCEstudiante.setAncho(this.getWidth());
            miCEstudiante.setLargo(this.getHeight());
        } catch (PropertyVetoException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }//GEN-LAST:event_mnuConsultarEstudiantesActionPerformed
    private void mnuModificarEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModificarEstudiantesActionPerformed
        cerrarFormularios();

        String resp = JOptionPane.showInputDialog(
                null,
                "Inserte matricula del estudiante: ",
                "Buscando estudiante.",
                JOptionPane.QUESTION_MESSAGE
        );

        if (resp == null) {
            return;
        }

//        if (!existeEstudiante(resp)) {
//            JOptionPane.showMessageDialog(
//                    null,
//                    "Estudiante no Encontrado",
//                    "Proceso de validación.",
//                    JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//
//        if (!estadoEstudiante(resp)) {
//            JOptionPane.showMessageDialog(this,
//                    "Estado de estudiantes Inactivo, no puede ser Modificado, "
//                    + "Modificar Padre...!!!");
//            return;
//        }//Arriba Bien....

        try {
            dpnEscritorio.add(miMEstudiante);
            miMEstudiante.setMatriculaEstudiante(resp);
            miMEstudiante.setMaximum(true);
            miMEstudiante.show();
        } catch (PropertyVetoException ex) {
            //miMEstudiante.setVisible(true);
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }//GEN-LAST:event_mnuModificarEstudiantesActionPerformed
    private void mnuPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPagoActionPerformed
        cerrarFormularios();

        new Thread(new frmPrincipal(), "AbriendoPagos").start();
//        try {
        dpnEscritorio.add(miPago);
        //miPago.setLargo(this.getHeight());
        //miPago.setAncho(this.getWidth());
        miPago.show();
        //miPago.setMaximum(true);
//        } catch (PropertyVetoException ex) {
//            LOG.log(Level.SEVERE, ex.getMessage(), ex);
//        }
    }//GEN-LAST:event_mnuPagoActionPerformed

    private void mnuReporteEstudianteFullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuReporteEstudianteFullActionPerformed
        //String archivo = getPatch("Deuda");
        String archivo = "";
        JasperReport mr;
        try {
            JDialog viewer = new JDialog(new javax.swing.JFrame(),
                    "Nunca he visto esto", true);
            viewer.setSize(this.getWidth() - 50, this.getHeight() - 50);
            viewer.setLocationRelativeTo(null);

            //MasterReport
            mr = (JasperReport) JRLoader.loadObjectFromFile(archivo);

            Map<String, Object> p;
            p = new HashMap<String, Object>();
            p.clear();
            p.put("logo", this.getClass().getResourceAsStream(logotipo));

            JasperPrint jp = JasperFillManager.fillReport(mr, p, Conexion.getCnn());
            JasperViewer jviewer = new JasperViewer(jp, false);

            viewer.getContentPane().add(jviewer.getContentPane());
            viewer.setTitle("Reporte de Estudiantes");
            viewer.setVisible(true);
        } catch (JRException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
    }//GEN-LAST:event_mnuReporteEstudianteFullActionPerformed
    private void mnuAjusteTandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAjusteTandaActionPerformed
        cerrarFormularios();
        try {
            dpnEscritorio.add(miAjuste);
            miAjuste.show();
            miAjuste.setMaximum(true);

        } catch (PropertyVetoException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
    }//GEN-LAST:event_mnuAjusteTandaActionPerformed
    private void mnuRegistroPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistroPadreActionPerformed
        cerrarFormularios();
        dpnEscritorio.add(miPadre);
        miPadre.show();
        miPadre.txtCedula.setEnabled(true);
        miPadre.txtCedula.requestFocusInWindow();
    }//GEN-LAST:event_mnuRegistroPadreActionPerformed
    private void mnuModificarPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModificarPadreActionPerformed
        cerrarFormularios();
        String padreMadre;
        padreMadre = JOptionPane.showInputDialog(this,
                "Inserte la cedula del Padre:",
                "Buscando Padre...!",
                JOptionPane.QUESTION_MESSAGE);
        if (padreMadre == null) {
            return;
        }
        try {
            ResultSet rs = null;
            //rs = misFb.getPadreMadres(padreMadre);
            if (rs.next()) {
                miPadreModificar.setIdPadre(rs.getInt("ID_PadreMadres"));
                miPadreModificar.txtCedula.setText(rs.getString("Documento"));
                miPadreModificar.txtNombre.setText(rs.getString("Nombres"));
                miPadreModificar.txtApellidos.setText(rs.getString("Apellidos"));
                miPadreModificar.txtDireccion.setText(rs.getString("Direccion"));
                miPadreModificar.jcbSexo.setSelectedItem(rs.getString("Sexo"));
                miPadreModificar.txtTelefono.setText(rs.getString("Telefono"));
                miPadreModificar.txtMovil.setText(rs.getString("Telefono2"));
                miPadreModificar.jcbEstado.setSelectedIndex(rs.getInt("Estado"));
                miPadreModificar.txtCorreo.setText(rs.getString("Correo"));
                miPadreModificar.txtNombre.requestFocusInWindow();
                miPadreModificar.txtCedula.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Padre no Encontrado.");
                return;
            }
            dpnEscritorio.add(miPadreModificar);
            miPadreModificar.show();
            miPadreModificar.setMaximum(true);
        } catch (PropertyVetoException | SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
    }//GEN-LAST:event_mnuModificarPadreActionPerformed
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed
    private void mnuAgregarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAgregarUsuariosActionPerformed
        cerrarFormularios();
        try {
            dpnEscritorio.add(miUsuarios);
            miUsuarios.show();
            miUsuarios.setMaximum(true);
        } catch (PropertyVetoException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }//GEN-LAST:event_mnuAgregarUsuariosActionPerformed
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            ResultSet rs = null;
            //rs = misFb.getPerfiles(misFb.getPerfil(Usuario));
            if (!rs.next()) {
                return;
            }
            mnuPadres.setEnabled(rs.getBoolean(3));
            mnuRegistroPadre.setEnabled(rs.getBoolean(4));
            mnuModificarPadre.setEnabled(rs.getBoolean(5));
            mnuEstudiantes.setEnabled(rs.getBoolean(7));
            mnuRegistroEstudiantes.setEnabled(rs.getBoolean(8));
            mnuModificarEstudiantes.setEnabled(rs.getBoolean(9));
            mnuConsultarEstudiantes.setEnabled(rs.getBoolean(10));
            mnuUsuarios.setEnabled(rs.getBoolean(11));
            mnuAgregarUsuarios.setEnabled(rs.getBoolean(12));
            mnuModificarUsuarios.setEnabled(rs.getBoolean(13));
            mnuBorrarUsuarios.setEnabled(rs.getBoolean(14));
            mnuPago.setEnabled(rs.getBoolean(15));
            mnuReporteEstudianteFull.setEnabled(rs.getBoolean(17));
            mnuAjusteTanda.setEnabled(rs.getBoolean(18));
            mnuAjustePerfil.setEnabled(rs.getBoolean(19));

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            JOptionPane.showMessageDialog(
                    null, "Perfil Contiene un Error...!");
            this.dispose();
        }

    }//GEN-LAST:event_formWindowActivated
    private void mnuModificarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModificarUsuariosActionPerformed
        cerrarFormularios();//Cerramos Formularios

        String resp = JOptionPane.showInputDialog("Ingrese el Nombre de usuario:");
        if (resp.equals("")) {
            return;
        }//Pedimos nombre del Usuario

        miUsuarioModificar.txtNombre.setText("");
        miUsuarioModificar.txtApellidos.setText("");
        miUsuarioModificar.txtClave.setText("");
        miUsuarioModificar.jcbPerfil.removeAllItems();
        //miUsuarioModificar.jcbEstado.setSelected(false);        

        int i = 0;//Contador que tenemos en el While()
        //setId(misFb.valorMaxPerfiles());//Obtenemos el numero de Perfiles en el sistema
        int[] idPerfiles2 = new int[getId()];//El GetId Perfil Creamos el Array Con el tamaño Requerido

        miUsuarioModificar.setId(getId());

        ResultSet rs = null;
        //rs = misFb.getPerfiles();

        try {
            while (rs.next()) {
                Opcion miOpcion
                        = Opcion
                                .builder()
                                .id(rs.getInt(1))
                                .descripcion(rs.getString(2))
                                .build();

                idPerfiles2[i] = rs.getInt(1);//Aqui Tenemos el Codigo del Perfil
                //miUsuarioModificar.jcbPerfil.addItem(rs.getString(2));//Aqui la descricion
                miUsuarioModificar.jcbPerfil.addItem(miOpcion);//Aqui la descricion
                i++;//Ir aumentando a I
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }

        miUsuarioModificar.setIdPerfiles2(idPerfiles2);
        //rs = getUsuarios(resp);

        try {
            if (rs.next()) {
                dpnEscritorio.add(miUsuarioModificar);
                miUsuarioModificar.txtNombre.setText(rs.getString(2));
                miUsuarioModificar.txtApellidos.setText(rs.getString(3));
                miUsuarioModificar.txtClave.setText(rs.getString(4));
                for (int j = 0; j < getId(); j++) {
                    if (idPerfiles2[j] == rs.getInt(5)) {
                        miUsuarioModificar.jcbPerfil.setSelectedIndex(j);
                        break;
                    }
                }
                //miUsuarioModificar.jcbEstado.setSelectedIndex(rs.getInt(6));
                miUsuarioModificar.show();
                //miUsuarioModificar.setMaximum(true);
            } else {
                JOptionPane.showMessageDialog(this, "Usuarios no Encontrado.");
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }//GEN-LAST:event_mnuModificarUsuariosActionPerformed
    private void mnuBorrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBorrarUsuariosActionPerformed
//        cerrarFormularios();
//        String resp = JOptionPane.showInputDialog("Ingrese el Nombre de usuario:");
//        
//        if (resp == "") {
//            return;
//        }
//        
//        rs = misFb.getUsuarios(resp);
//        
//        try {
//            
//            if (rs.next()) {
//                int c = JOptionPane.showConfirmDialog(this,
//                        "Desea Realmente Borrar Usuario?",
//                        "Confirmacion de Borrado",
//                        JOptionPane.YES_NO_OPTION);
//                if (c != 0) {
//                    return;
//                }
//                JOptionPane.showMessageDialog(this, misFb.borrarUsuario(resp));
//            } else {
//                JOptionPane.showMessageDialog(this, "Usuario no Encontrado...");
//            }
//            
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, ex.getMessage(), ex);
//        }
    }//GEN-LAST:event_mnuBorrarUsuariosActionPerformed
    private void mnuAjustePerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAjustePerfilActionPerformed
        cerrarFormularios();
        try {
            dpnEscritorio.add(miPerfil);
            miPerfil.show();
            miPerfil.setMaximum(true);

        } catch (PropertyVetoException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }//GEN-LAST:event_mnuAjustePerfilActionPerformed
    private void mnuContactarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuContactarActionPerformed
        JDPresentacion miJD = new JDPresentacion(this, rootPaneCheckingEnabled);
        miJD.setLocationRelativeTo(null);
        miJD.setVisible(true);
    }//GEN-LAST:event_mnuContactarActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //((DesktopConFondo) dpnEscritorio).setImagen("/images/Portal.png");
    }//GEN-LAST:event_formWindowOpened

    private void mnuCambiarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCambiarUsuarioActionPerformed
        SophiaStudio miSop = new SophiaStudio();
        this.setVisible(false);
    }//GEN-LAST:event_mnuCambiarUsuarioActionPerformed

    private void mnuInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInscribirActionPerformed
        cerrarFormularios();
        try {
            dpnEscritorio.add(miInscripcion);
            miInscripcion.show();
            miInscripcion.setMaximum(true);
        } catch (PropertyVetoException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }

    }//GEN-LAST:event_mnuInscribirActionPerformed

    private void mnuUbucacionReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUbucacionReportesActionPerformed
        cerrarFormularios();
        try {
            dpnEscritorio.add(miUbicacion);
            miUbicacion.show();
            miUbicacion.setMaximum(true);
        } catch (PropertyVetoException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
    }//GEN-LAST:event_mnuUbucacionReportesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane dpnEscritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenu mnuAcerca;
    private javax.swing.JMenuItem mnuAgregarUsuarios;
    private javax.swing.JMenuItem mnuAjustePerfil;
    private javax.swing.JMenuItem mnuAjusteTanda;
    private javax.swing.JMenu mnuArchivos;
    private javax.swing.JMenuItem mnuBorrarUsuarios;
    private javax.swing.JMenuItem mnuCambiarUsuario;
    private javax.swing.JMenuItem mnuConsultarEstudiantes;
    private javax.swing.JMenuItem mnuContactar;
    private javax.swing.JMenu mnuEstudiantes;
    private javax.swing.JMenuItem mnuInscribir;
    private javax.swing.JMenuItem mnuModificarEstudiantes;
    private javax.swing.JMenuItem mnuModificarPadre;
    private javax.swing.JMenuItem mnuModificarUsuarios;
    private javax.swing.JMenu mnuPadres;
    private javax.swing.JMenuItem mnuPago;
    private javax.swing.JMenu mnuParamentros;
    private javax.swing.JMenu mnuREstudiantes;
    private javax.swing.JMenuItem mnuRegistroEstudiantes;
    public javax.swing.JMenuItem mnuRegistroPadre;
    private javax.swing.JMenuItem mnuReporteEstudianteFull;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenuItem mnuUbucacionReportes;
    private javax.swing.JMenu mnuUsuarios;
    // End of variables declaration//GEN-END:variables
    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("AbriendoAbonos")) {
            Sonido sonido = new Sonido();
            sonido.reproducirAudio("/Sonido/AbriendoAbonos.mp3");
        }

        if (Thread.currentThread().getName().equals("AbriendoPagos")) {
            Sonido sonido = new Sonido();
            sonido.reproducirAudio("/Sonido/AbriendoPagos.mp3");
        }
    }
}
