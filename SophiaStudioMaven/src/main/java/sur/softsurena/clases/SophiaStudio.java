package sur.softsurena.clases;

import sur.softsurena.vista.VistaLogin;

public class SophiaStudio {
    public static void main(String[] args) {
        //Instanciamos el El Formulario de Logeado... para Arrancar....
        VistaLogin f = new VistaLogin(null, true);
        f.setLocationRelativeTo(null);
        //Hacemos el Formulario Visible y Centralizado...
        f.setVisible(true);
    }
}
