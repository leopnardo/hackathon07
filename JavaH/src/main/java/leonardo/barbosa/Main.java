package leonardo.barbosa;

import leonardo.barbosa.gui.PrincipalGui;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(Main::executar);
    }

    private static void executar() {
        var gui = new PrincipalGui();
        gui.setVisible(true);
    }

}
