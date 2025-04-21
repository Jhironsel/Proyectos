package sur.softsurena.control;

import static sur.softsurena.formularios.frmPrincipal.dpnEscritorio;

public class frmRecetas extends javax.swing.JInternalFrame {
    private static final long serialVersionUID = 1L;
    
    private static frmRecetas recetas;
    
    static{
    }
    
    public frmRecetas(String saludo){
        frmRecetas aqui = new frmRecetas();
        aqui.centralizar();
        System.out.println(saludo);
    }
    
    private frmRecetas() {
        initComponents();
    }
    public synchronized static frmRecetas getRecetas(){
        if(recetas == null){
            recetas = new frmRecetas();
        }
        return recetas;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void centralizar() {
        setBounds((dpnEscritorio.getWidth() - this.getWidth()) / 2,
                (dpnEscritorio.getHeight() - this.getHeight()) / 2,
                720,
                500);
        pack();
        recetas.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
