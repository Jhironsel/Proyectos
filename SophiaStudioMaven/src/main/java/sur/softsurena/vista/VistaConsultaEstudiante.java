package sur.softsurena.vista;

import java.awt.BorderLayout;
import java.util.*;
import java.util.logging.Level;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;
import static sur.softsurena.conexion.Conexion.getCnn;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class VistaConsultaEstudiante extends javax.swing.JInternalFrame {
    
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
    
    public VistaConsultaEstudiante() {
        initComponents();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpReporte = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnGrupoEstudiantes = new javax.swing.JButton();
        btnListaAlumno = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultar Estudiantes al Sistema de Ballet");

        jpReporte.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(52, 52, 52), new java.awt.Color(119, 119, 119)));

        javax.swing.GroupLayout jpReporteLayout = new javax.swing.GroupLayout(jpReporte);
        jpReporte.setLayout(jpReporteLayout);
        jpReporteLayout.setHorizontalGroup(
            jpReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );
        jpReporteLayout.setVerticalGroup(
            jpReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1447397240_AG_Girls.png"))); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnGrupoEstudiantes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGrupoEstudiantes.setText("Grupo de Alumnos");
        btnGrupoEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrupoEstudiantesActionPerformed(evt);
            }
        });

        btnListaAlumno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnListaAlumno.setText("Lista de Alumnos");
        btnListaAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaAlumnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(btnListaAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGrupoEstudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(btnListaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnGrupoEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGrupoEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrupoEstudiantesActionPerformed
        //String archivo = getPatch("ReporteAlumnosAgrupados");
        String archivo = "";
        
        //masterReporte
        JasperReport mr;
        
        try {
            mr = (JasperReport) JRLoader.loadObjectFromFile(archivo);
            
            Map<String, Object> p = new HashMap<String, Object>();
            p.clear();
            p.put("logo", this.getClass().getResourceAsStream(logotipo));
            
            JasperPrint jp = JasperFillManager.fillReport(mr, p, getCnn());
            JRViewer jviewer = new  JRViewer(jp);            
            jpReporte.removeAll();            
            jpReporte.setLayout(new BorderLayout());        
            jpReporte.add(jviewer, BorderLayout.CENTER);            
            jviewer.setVisible(true);
            jpReporte.repaint();
            jpReporte.revalidate();
        } catch (JRException ex) {
            LOG.log(
                    Level.SEVERE, 
                    ex.getMessage(), 
                    ex
            );
        }
    }//GEN-LAST:event_btnGrupoEstudiantesActionPerformed
    private final String logotipo = "/Reportes/Logo.jpg";
    private void btnListaAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaAlumnoActionPerformed
        String archivo = getClass().getResource("/Reportes/ReporteEstudiantes.jasper").getPath();
        //masterReporte
        JasperReport mr;
        try {
            mr = (JasperReport) JRLoader.loadObjectFromFile(archivo);
            Map<String, Object> p = new HashMap<>();
            p.clear();
            p.put("logo", this.getClass().getResourceAsStream(logotipo));
            
            JasperPrint jp = JasperFillManager.fillReport(mr, p, getCnn());
            JRViewer jviewer = new  JRViewer(jp);            
            jpReporte.removeAll();            
            jpReporte.setLayout(new BorderLayout());        
            jpReporte.add(jviewer, BorderLayout.CENTER);            
            jviewer.setVisible(true);
            jpReporte.repaint();
            jpReporte.revalidate();
            
        } catch (JRException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }//GEN-LAST:event_btnListaAlumnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGrupoEstudiantes;
    private javax.swing.JButton btnListaAlumno;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jpReporte;
    // End of variables declaration//GEN-END:variables
}
