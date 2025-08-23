package sur.softsurena.clases;

import sur.softsurena.vistas.VistaLoginSophiae;

public class SophiaStudio {
    public static void main(String[] args) {
        //Instanciamos el El Formulario de Logeado... para Arrancar....
        VistaLoginSophiae f = new VistaLoginSophiae(null, true);
        f.setLocationRelativeTo(null);
        //Hacemos el Formulario Visible y Centralizado...
        f.setVisible(true);
    }
}
