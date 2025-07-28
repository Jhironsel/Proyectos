package sur.softsurena.vistas;

import java.awt.Frame;
import javax.swing.JFileChooser;
import lombok.Getter;

/**
 * 
 * @author jhironsel
 */
@Getter
public final class VistaSelectorArchivo extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;
    private String archivo = "";
    
    public VistaSelectorArchivo(Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fchSelector = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccione un Archivo");

        fchSelector.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        fchSelector.setApproveButtonText("Guardar");
        fchSelector.setForeground(new java.awt.Color(1, 1, 1));
        fchSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fchSelectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fchSelector, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fchSelector, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fchSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fchSelectorActionPerformed
        String comando = evt.getActionCommand();        
        if(comando.equals(JFileChooser.APPROVE_SELECTION)){
            archivo = fchSelector.getSelectedFile().toString();
        } 
        dispose();
    }//GEN-LAST:event_fchSelectorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fchSelector;
    // End of variables declaration//GEN-END:variables
}
