package sur.softsurena.vistas;

import javax.swing.ImageIcon;

public final class VistaImagen extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;
    
    public VistaImagen(java.awt.Frame parent, boolean modal, ImageIcon imageIcon ) {
        super(parent, modal);
        initComponents();
//        this.idPaciente = idPaciente;
//        this.datos = datos;
//        int idPaciente, Datos datos
        jlImagen.setIcon(imageIcon);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visor de imagen de Paciente");
        setAlwaysOnTop(true);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlImagen;
    // End of variables declaration//GEN-END:variables
}
