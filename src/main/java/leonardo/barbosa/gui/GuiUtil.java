package leonardo.barbosa.gui;

import java.awt.*;

public interface GuiUtil {

    default GridBagConstraints montarGrid(int coluna, int linha, int i, int i1) {
        var constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridx = coluna;
        constraints.gridy = linha;
        return constraints;
    }

}
