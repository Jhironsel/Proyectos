package sur.softsurena.slidePanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.Timer;

public final class SlideAnimator extends Object {

    protected static final int ANIMATION_TIME = 500;
    protected static final int DISPOSE_TIME = 10000;
    protected static final float ANIMATION_TIME_F =
            (float) ANIMATION_TIME;
    protected static final int ANIMATION_DELAY = 50;

    JPanel container;
    JComponent contents;
    AnimatingSheet animatingSheet;
    Dimension tempWindowSize;
    Timer animationTimer;
    long animationStart;

    public SlideAnimator() {
        initDesktopBounds();
    }

    public SlideAnimator(JPanel panel, JComponent contents) {
        this();
        this.container = panel;
        this.contents = contents;
        animatingSheet = new AnimatingSheet();
    }

    public void Dispose() {}

    protected void initDesktopBounds() {}

    public void setContents() {
        JWindow tempWindow = new JWindow();
        tempWindow.getContentPane().add(contents);
        tempWindow.pack();
        tempWindowSize = tempWindow.getSize();
        tempWindow.getContentPane().removeAll();
        animatingSheet.setSource(contents);
        container.removeAll();
        container.add(animatingSheet);
    }

    public void showAt() {
        setContents();
        ActionListener animationLogic = (ActionEvent e) -> {
            long elapsed =
                    System.currentTimeMillis() - animationStart;
            if (elapsed > ANIMATION_TIME) {
                container.removeAll();
                container.add(contents);
                container.revalidate();
                animationTimer.stop();
            } else {
                float progress =
                        (float) elapsed / ANIMATION_TIME_F;
                int animatingHeight =
                        (int) (progress * tempWindowSize.getHeight());
                animatingHeight = Math.max(animatingHeight, 1);
                animatingSheet.setAnimatingHeight(animatingHeight);
                container.setVisible(true);
                container.repaint();
                container.revalidate();
            }
        };
        animationTimer =
                new Timer(ANIMATION_DELAY, animationLogic);
        animationStart = System.currentTimeMillis();
        animationTimer.start();
    }

    @SuppressWarnings("serial")
    class AnimatingSheet extends JPanel {

        Dimension animatingSize = new Dimension(0, 1);
        JComponent source;
        BufferedImage offscreenImage;

        public AnimatingSheet() {
            super();
            setOpaque(true);
        }

        public void setSource(JComponent source) {
            this.source = source;
            animatingSize.width = source.getWidth();
            makeOffscreenImage(source);
        }

        public void setAnimatingHeight(int height) {
            animatingSize.height = height;
            setSize(animatingSize);
        }

        private void makeOffscreenImage(JComponent source) {
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsConfiguration gfxConfig =
                    ge.getDefaultScreenDevice().getDefaultConfiguration();
            offscreenImage =
                    gfxConfig.createCompatibleImage(source.getWidth(),
                    source.getHeight());
            Graphics2D offscreenGraphics =
                    (Graphics2D) offscreenImage.getGraphics();
            // windows workaround
            offscreenGraphics.setColor(source.getBackground());
            offscreenGraphics.fillRect(0, 0,
                    source.getWidth(), source.getHeight());
            // paint from source to offscreen buffer
            source.paint(offscreenGraphics);
        }

        @Override
        public Dimension getPreferredSize() {
            return animatingSize;
        }

        @Override
        public Dimension getMinimumSize() {
            return animatingSize;
        }

        @Override
        public Dimension getMaximumSize() {
            return animatingSize;
        }

        @Override
        public void update(Graphics g) {
            // override to eliminate flicker from
            // unneccessary clear
            paint(g);
        }

        @Override
        public void paint(Graphics g) {
            // get the top-most n pixels of source and
            // paint them into g, where n is height
            // (different from sheet example, which used bottom-most)
            BufferedImage fragment =
                    offscreenImage.getSubimage(0,
                    0,
                    source.getWidth(),
                    animatingSize.height);
            g.drawImage(fragment, 0, 0, this);
        }
    }
}