package leonardo.barbosa.gui;

import java.awt.*;

public interface GuiUtil {

    default GridBagConstraints montarGrid(int x, int y, int w, int h) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx      = x;
        gbc.gridy      = y;
        gbc.gridwidth  = w;
        gbc.gridheight = h;
        gbc.insets     = new Insets(5, 5, 5, 5);
        gbc.anchor     = GridBagConstraints.CENTER;
        return gbc;
    }
}
