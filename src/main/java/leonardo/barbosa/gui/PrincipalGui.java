package leonardo.barbosa.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PrincipalGui extends JFrame implements GuiUtil {

    private JPanel telaInicialPanel;
    private JMenuBar menuBar;

    public PrincipalGui() {
        setTitle("Sistema UniALFA - Eventos");
        setSize(850, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        exibirTelaInicial();

        setVisible(true);
    }

    private void exibirTelaInicial() {
        telaInicialPanel = new JPanel(new GridBagLayout());
        telaInicialPanel.setBackground(Color.WHITE);

        // Título
        JLabel titulo = new JLabel("Bem-vindo ao Sistema UniALFA", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setForeground(new Color(33, 102, 153));

        // Botão Entrar
        JButton btnEntrar = new JButton("Entrar no Sistema");
        btnEntrar.setFont(new Font("Arial", Font.PLAIN, 16));
        btnEntrar.setBackground(new Color(33, 102, 153));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setOpaque(true);
        btnEntrar.setBorderPainted(false);
        btnEntrar.addActionListener(e -> iniciarSistema());

        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) { btnEntrar.setBackground(new Color(21, 71, 107)); }
            public void mouseExited (java.awt.event.MouseEvent e) { btnEntrar.setBackground(new Color(33, 102, 153)); }
        });

        // Botão Sair
        JButton btnSair = new JButton("Sair");
        btnSair.setFont(new Font("Arial", Font.PLAIN, 16));
        btnSair.setBackground(new Color(237, 40, 57));
        btnSair.setForeground(Color.WHITE);
        btnSair.setOpaque(true);
        btnSair.setBorderPainted(false);
        btnSair.addActionListener(e -> System.exit(0));

        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) { btnSair.setBackground(new Color(180, 30, 40)); }
            public void mouseExited (java.awt.event.MouseEvent e) { btnSair.setBackground(new Color(237, 40, 57)); }
        });

        // Logo (agora só pra exibir na tela inicial, mas depois ocuparemos todo fundo)
        ImageIcon logo = new ImageIcon(getClass().getResource("/imagem/unialfa.png"));
        JLabel logoLabel = new JLabel(logo);

        telaInicialPanel.add(titulo,     montarGrid(0, 0, 1, 1));
        telaInicialPanel.add(btnEntrar,  montarGrid(0, 1, 1, 1));
        telaInicialPanel.add(btnSair,    montarGrid(0, 2, 1, 1));
        telaInicialPanel.add(logoLabel,  montarGrid(0, 3, 1, 1));

        add(telaInicialPanel, BorderLayout.CENTER);
    }

    private void iniciarSistema() {
        // 1) remove a tela inicial
        remove(telaInicialPanel);
        telaInicialPanel = null;

        // 2) cria um painel que desenha a imagem esticada em TODO o fundo
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagem/unialfa.png"));
        BackgroundPanel bg = new BackgroundPanel(icon.getImage());
        bg.setLayout(new BorderLayout());

        // 3) troca o content pane
        setContentPane(bg);

        // 4) monta a barra de menus normalmente
        menuBar = montarMenuBar();
        setJMenuBar(menuBar);

        // 5) se você tiver um painel central do sistema, adicione aqui:
        //    bg.add(seuPainelPrincipal, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    // --- Métodos de menu (sem alteração) --- //

    private JMenuBar montarMenuBar() {
        var mb = new JMenuBar();
        mb.add(montarMenuCad());
        mb.add(montarMenuRel());
        mb.add(montarMenuConfig());
        return mb;
    }

    private JMenu montarMenuConfig() {
        var menu = new JMenu("Config.");
        var miSobre   = new JMenuItem("Sobre");
        var miEquipe  = new JMenuItem("Equipe");
        var miSair    = new JMenuItem("Sair");

        menu.add(miSobre);
        menu.add(miEquipe);
        menu.addSeparator();
        menu.add(miSair);

        miSair.addActionListener(this::exit);
        miEquipe.addActionListener(this::exibirEquipe);
        miSobre.addActionListener(this::exibirSobre);

        menu.setFont(new Font("Arial", Font.PLAIN, 16));
        miSobre.setFont(new Font("Arial", Font.PLAIN, 14));
        miEquipe.setFont(new Font("Arial", Font.PLAIN, 14));
        miSair.setFont(new Font("Arial", Font.PLAIN, 14));
        return menu;
    }

    private static JMenu montarMenuRel() {
        var menu = new JMenu("Relatórios");
        var mi = new JMenuItem("Alunos por Evento");
        menu.add(mi);
        menu.setFont(new Font("Arial", Font.PLAIN, 16));
        mi.setFont(new Font("Arial", Font.PLAIN, 14));
        return menu;
    }

    private JMenu montarMenuCad() {
        var menu = new JMenu("Cadastros");
        var miEvento      = new JMenuItem("Cadastrar eventos");
        var miPalestrante = new JMenuItem("Palestrantes");
        var miAluno       = new JMenuItem("Alunos");

        menu.add(miEvento);
        menu.add(miPalestrante);
        menu.add(miAluno);

        menu.setFont(new Font("Arial", Font.PLAIN, 16));
        miEvento.setFont(new Font("Arial", Font.PLAIN, 14));
        miPalestrante.setFont(new Font("Arial", Font.PLAIN, 14));
        miAluno.setFont(new Font("Arial", Font.PLAIN, 14));
        return menu;
    }

    private void exibirSobre(ActionEvent e) {
        JOptionPane.showMessageDialog(this, """
            Equipe Hackathon
            Somos a Equipe 7 do hackathon Unialfa! Decidimos solucionar o verdadeiro problema da faculdade...
        """);
    }

    private void exibirEquipe(ActionEvent e) {
        JOptionPane.showMessageDialog(this, """
            Equipe Hackathon
            Leonardo Dos Santos Barbosa
            Claudio Roberto Vieira Filho 
            Isabely Novais Dalava
            Gabriel De Abreu da Silva
        """);
    }

    private void exit(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente sair?",
                "Finalizar Aplicação",
                JOptionPane.YES_NO_OPTION
        );
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
