package leonardo.barbosa.gui;

import leonardo.barbosa.service.AlunoService;
import leonardo.barbosa.service.EventoService;

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

        JLabel titulo = new JLabel("Bem-vindo ao Sistema UniALFA", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setForeground(new Color(33, 102, 153));


        JButton btnEntrar = new JButton("Entrar no Sistema");
        btnEntrar.setFont(new Font("Arial", Font.PLAIN, 16));
        btnEntrar.setBackground(new Color(33, 102, 153));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setOpaque(true);
        btnEntrar.setBorderPainted(false);
        btnEntrar.addActionListener(e -> iniciarSistema());

        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnEntrar.setBackground(new Color(21, 71, 107));
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                btnEntrar.setBackground(new Color(33, 102, 153));
            }
        });


        JButton btnSair = new JButton("Sair");
        btnSair.setFont(new Font("Arial", Font.PLAIN, 16));
        btnSair.setBackground(new Color(237, 40, 57));
        btnSair.setForeground(Color.WHITE);
        btnSair.setOpaque(true);
        btnSair.setBorderPainted(false);
        btnSair.addActionListener(e -> System.exit(0));

        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnSair.setBackground(new Color(180, 30, 40));
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                btnSair.setBackground(new Color(237, 40, 57));
            }
        });


        ImageIcon imagem = new ImageIcon(getClass().getResource("/imagem/unialfa.png"));
        JLabel logoLabel = new JLabel(imagem);

        telaInicialPanel.add(titulo, montarGrid(0, 0, 1, 1));
        telaInicialPanel.add(btnEntrar, montarGrid(0, 1, 1, 1));
        telaInicialPanel.add(btnSair, montarGrid(0, 2, 1, 1));
        telaInicialPanel.add(logoLabel, montarGrid(0, 3, 1, 1));

        add(telaInicialPanel, BorderLayout.CENTER);
    }

    private void iniciarSistema() {
        remove(telaInicialPanel);
        telaInicialPanel = null;


        ImageIcon icon = new ImageIcon(getClass().getResource("/imagem/unialfa.png"));
        BackgroundPanel bg = new BackgroundPanel(icon.getImage());
        bg.setLayout(new BorderLayout());

        setContentPane(bg);

        menuBar = montarMenuBar();
        setJMenuBar(menuBar);
        revalidate();
        repaint();
    }

    private JMenuBar montarMenuBar() {
        var menuConfig = new JMenuBar();
        menuConfig.add(montarMenuCad());
        menuConfig.add(montarMenuRel());
        menuConfig.add(montarMenuConfig());
        return menuConfig;
    }

    private JMenu montarMenuConfig() {
        var menu = new JMenu("Config.");
        var miSobre = new JMenuItem("Sobre");
        var miEquipe = new JMenuItem("Equipe");
        var miSair = new JMenuItem("Sair");

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

    private JMenu montarMenuRel() {
        JMenu menu = new JMenu("Relatórios");
        menu.setFont(new Font("Arial", Font.PLAIN, 16));

        JMenuItem alunoEvento = new JMenuItem("Alunos por Evento");
        alunoEvento.setFont(new Font("Arial", Font.PLAIN, 14));
        alunoEvento.addActionListener(this::abrirAlunosGui);

        menu.add(alunoEvento);
        return menu;


    }

    private JMenu montarMenuCad() {
        var menu = new JMenu("Cadastros");
        var miEvento = new JMenuItem("Cadastrar eventos");

        menu.add(miEvento);


        menu.setFont(new Font("Arial", Font.PLAIN, 16));
        miEvento.setFont(new Font("Arial", Font.PLAIN, 14));

        miEvento.addActionListener(this::abrirEventosGui);

        return menu;
    }

    private void exibirSobre(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(this, """
                    Equipe Hackathon
                    "Somos a Equipe 7 do hackathon Unialfa! Decidimos solucionar o verdadeiro problema da faculdade, trazendo a melhor solução possível para atender a instituição! 
                    Assim sentamos e fizemos todo o planejamento para nos alinharmos e entendermos cada ponto.
                    Identificamos diversas falhas no sistema! Estamos propondo possíveis melhorias para proporcionar a melhor experiência possível. 
                    Cada ponto foi pensado na usabilidade, desde o back office até o front end.
                """);
    }

    private void exibirEquipe(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(this, """
                    Equipe Hackathon
                    Leonardo Dos Santos Barbosa
                    Claudio Roberto Vieira Filho 
                    Isabely Novais Dalava
                    Gabriel De Abreu da Silva
                """);
    }

    private void exit(ActionEvent actionEvent) {
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

    private void abrirEventosGui(ActionEvent actionEvent) {
        var gui = new EventosGui();
        gui.setVisible(true);
    }

    private void abrirAlunosGui(ActionEvent actionEvent) {
        var gui = new AlunoGui();
        gui.setVisible(true);
    }

}
