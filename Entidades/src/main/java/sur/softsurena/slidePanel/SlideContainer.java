package sur.softsurena.slidePanel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;

public final class SlideContainer extends JPanel {

    private static final long serialVersionUID = 1L;

    @Override
    public Insets getInsets() {
        return new Insets(0, 1, 1, 1);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        int h = getHeight();
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        /**
         * Top Polygon
         */
        GeneralPath path = new GeneralPath();
        path.moveTo(70F, 0F);
        path.lineTo(8F, 0F);
        path.quadTo(0F, 0F, 0F, 7F);
        path.lineTo(0F, 55F);
        path.lineTo(getWidth() - 1F, 55F);
        path.lineTo(getWidth() - 1F, 7F);
        path.quadTo(getWidth() - 1F, 0F, getWidth() - 8F, 0F);
        path.lineTo(30F, 0F);

        Rectangle bounds1 = path.getBounds();
        GradientPaint painter = new GradientPaint(
                0.0f,
                (float) path.getBounds().y,
                new Color(240, 240, 240), 
                0.0f,
                (float) bounds1.y + (float) bounds1.height - 1F, 
                new Color(240, 240, 240)
        );
        g2d.setPaint(painter);
        g2d.fill(path);

        Rectangle rectangle = new Rectangle(0, 40, getWidth(), 20);
        g2d.fill(rectangle);
        g2d.setColor(new Color(128, 128, 128));
        g2d.draw(path);

        /**
         * Middle Rectangle
         */
        g2d.setColor(new Color(128, 128, 128));
        g2d.drawLine(12, 0, getWidth() - 10, 0);
        g2d.drawRect(0, 30, getWidth() - 1, h - 40);
        g2d.setPaint(new Color(240, 240, 240));
        g2d.fillRect(1, 29, getWidth() - 2, h - 80);

        /**
         * Bottom Polygon
         */
        h = h - 30;
        path = new GeneralPath();
        path.moveTo(0f, h);
        path.lineTo(0f, h + 22f);
        path.quadTo(0f, h + 29f, 8f, h + 29f);
        path.lineTo(getWidth() - 8f, h + 29f);
        path.quadTo(getWidth() - 1f, h + 29f, getWidth() - 1f, h + 22f);
        path.lineTo(getWidth() - 1f, h);
        g2d.fill(path);
        g2d.setColor(new Color(128, 128, 128));
        g2d.draw(path);
        g2d.setColor(new Color(128, 128, 128));
    }
}
