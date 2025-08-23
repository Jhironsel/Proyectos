package sur.softsurena.vistas;

import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sur.softsurena.clases.Sonido;
import sur.softsurena.clases.SophiaStudio;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Entidades;
import sur.softsurena.utilidades.DesktopConFondo;
import static sur.softsurena.utilidades.Utilidades.LOG;

public final class VistaPrincipalSophiae extends javax.swing.JFrame implements Runnable {

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

    public VistaPrincipalSophiae() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpnEscritorio = new DesktopConFondo();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArchivos = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        mnuCambiarUsuario = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
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

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/parents-icon2.png"))); // NOI18N
        jMenuItem2.setText("Personas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuArchivos.add(jMenuItem2);
        mnuArchivos.add(jSeparator9);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Usuario.png"))); // NOI18N
        jMenuItem3.setText("Usuarios");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnuArchivos.add(jMenuItem3);
        mnuArchivos.add(jSeparator12);

        mnuCambiarUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        mnuCambiarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CambioUsuario.png"))); // NOI18N
        mnuCambiarUsuario.setText("Cambiar Usuarios");
        mnuCambiarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCambiarUsuarioActionPerformed(evt);
            }
        });
        mnuArchivos.add(mnuCambiarUsuario);
        mnuArchivos.add(jSeparator14);

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
    private void mnuPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPagoActionPerformed

        VistaPagos miPago = new VistaPagos();

        new Thread(new VistaPrincipalSophiae(), "AbriendoPagos").start();
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
        VistaAjusteTandas miAjuste = new VistaAjusteTandas();
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
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated
    private void mnuAjustePerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAjustePerfilActionPerformed
        VistaAjustePerfil miPerfil = new VistaAjustePerfil();
        try {
            dpnEscritorio.add(miPerfil);
            miPerfil.show();
            miPerfil.setMaximum(true);

        } catch (PropertyVetoException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }//GEN-LAST:event_mnuAjustePerfilActionPerformed
    private void mnuContactarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuContactarActionPerformed
        VistaAcercaDe miJD = new VistaAcercaDe(this, true);
        miJD.setLocationRelativeTo(null);
        miJD.setVisible(true);
    }//GEN-LAST:event_mnuContactarActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ((DesktopConFondo) dpnEscritorio).setImagen("SoftSurena 800 x 550.png");
    }//GEN-LAST:event_formWindowOpened

    private void mnuCambiarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCambiarUsuarioActionPerformed
        SophiaStudio miSop = new SophiaStudio();
        this.setVisible(false);
    }//GEN-LAST:event_mnuCambiarUsuarioActionPerformed

    private void mnuInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInscribirActionPerformed
        VistaInscripcion miInscripcion = new VistaInscripcion();
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
        var miUbicacion = new VistaUbicacionReportes();
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

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        var personas = new VistaPersonas(
                Entidades
                        .builder()
                        .estudiante(true)
                        .empleado(true)
                        .padre(true)
                        .build()
        );
        try {
            dpnEscritorio.add(personas);
            personas.show();
            personas.setMaximum(true);
        } catch (PropertyVetoException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        var usuarios = new VistaUsuarios();
        try {
            dpnEscritorio.add(usuarios);
            usuarios.show();
            usuarios.setMaximum(true);
        } catch (PropertyVetoException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane dpnEscritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenu mnuAcerca;
    private javax.swing.JMenuItem mnuAjustePerfil;
    private javax.swing.JMenuItem mnuAjusteTanda;
    private javax.swing.JMenu mnuArchivos;
    private javax.swing.JMenuItem mnuCambiarUsuario;
    private javax.swing.JMenuItem mnuContactar;
    private javax.swing.JMenuItem mnuInscribir;
    private javax.swing.JMenuItem mnuPago;
    private javax.swing.JMenu mnuParamentros;
    private javax.swing.JMenu mnuREstudiantes;
    private javax.swing.JMenuItem mnuReporteEstudianteFull;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenuItem mnuUbucacionReportes;
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
