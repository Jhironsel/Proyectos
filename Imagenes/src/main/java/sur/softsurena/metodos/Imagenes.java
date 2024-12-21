package sur.softsurena.metodos;

import java.awt.Image;
import javax.swing.ImageIcon;
import lombok.NonNull;

public class Imagenes {

    private String ruta = "";

    public Imagenes(
            @NonNull String archivoExtension
    ) {

        if (archivoExtension.isBlank()) {
            archivoExtension = "NoImageTransp 96 x 96.png";
        }

        ruta = "/sur/softsurena/imagenes/".concat(archivoExtension);
    }

    private Imagenes(){}

    public ImageIcon getIcono() {
        return new ImageIcon(getClass().getResource(ruta));
    }

    public ImageIcon getIcono(int ancho, int alto) {
        Image scaledInstance = new ImageIcon(
                getClass().getResource(ruta)
        ).getImage().getScaledInstance(
                ancho,
                alto,
                Image.SCALE_DEFAULT
        );
        
        return new ImageIcon(scaledInstance);
    }

//    /**
//     * Metodo utilizado para cambiar los fondos de los anchorPane.
//     *
//     * Luego lo pondré en prueba con otro tipo de componente de la JAVAFX.
//     *
//     * @param anchorPane Es un objecto de la clase AnchorPane.
//     * @param ruta Es la ruta de la imagen. Este es un ejemplo:
//     * "Imagenes/Usuario.png".
//     * @param br Permite definir si la imagen se repite en el eje x.
//     * @param br2 Permite definir si la imagen se repite en el eje y.
//     * @param bp Define si la posicion en la imagen en el anchorPane.
//     */
//    public static void cambiarBackGroundAnchorPane(AnchorPane anchorPane,
//            String ruta, BackgroundRepeat br, BackgroundRepeat br2,
//            BackgroundPosition bp) {
//
//        BackgroundSize bs = new BackgroundSize(1, 1, true, true, false, false);
//
//        Image image = new Image(new Imagenes().dame(ruta));
//
//        BackgroundImage backgroundImage
//                = new BackgroundImage(image, br, br2, bp, bs);
//
//        Background background = new Background(backgroundImage);
//        anchorPane.setBackground(background);
//    }
//    private InputStream dame(String ruta) {
//        return getClass().getResourceAsStream(ruta);
//    }

//    public static Image convertToFxImage(String nombreImagenConExtension) throws IOException {
//        
//        BufferedImage image = ImageIO.read(new Imagenes().dame(nombreImagenConExtension));
//
//        WritableImage wr = null;
//        if (image != null) {
//            wr = new WritableImage(image.getWidth(), image.getHeight());
//            PixelWriter pw = wr.getPixelWriter();
//            for (int x = 0; x < image.getWidth(); x++) {
//                for (int y = 0; y < image.getHeight(); y++) {
//                    pw.setArgb(x, y, image.getRGB(x, y));
//                }
//            }
//        }
//
//        return new ImageView(wr).getImage();
//    }
}
