package leonardo.barbosa.gui;

import java.awt.*;

public interface GuiUtil {

    default GridBagConstraints montarGrid(int x, int y, int w, int h) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = w;
        constraints.gridheight = h;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        return constraints;
    }
}
