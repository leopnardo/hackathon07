package leonardo.barbosa.gui;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {

    private final Image background;

    public BackgroundPanel(Image background) {
        this.background = background;
        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            Graphics2D g2 = (Graphics2D) g.create();

            // interpolação suave
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            g2.dispose();
        }
    }


}
