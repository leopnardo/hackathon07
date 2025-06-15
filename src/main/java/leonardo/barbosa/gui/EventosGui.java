package leonardo.barbosa.gui;

import leonardo.barbosa.model.Eventos;
import leonardo.barbosa.service.EventoService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EventosGui extends JFrame implements GuiUtil {

    private final EventoService eventoService = new EventoService();
    private Long eventoSelecionadoId = null;

    private JTextField tfTitulo;
    private JTextField tfDataInicio;
    private JTextField tfDataFim;
    private JTextField tfPalestrante;
    private JTextField tfCurriculo;
    private JTextField tfTema;
    private JTextField tfImagemPath;

    private JButton btSalvar;
    private JButton btListar;
    private JButton btExcluir;
    private JButton btEditar;
    private JButton btSelecionarImagem;
    private JButton btLimpar;

    private JTable tabela;

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public EventosGui() {
        super("Cadastro de Eventos");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(montarPainelEntrada(), BorderLayout.NORTH);
        add(montarPainelSaida(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel montarPainelEntrada() {
        JPanel jPanel = new JPanel(new GridBagLayout());
        int y = 0;


        jPanel.add(new JLabel("Título:"), montarGrid(0, y, 1, 1));
        tfTitulo = new JTextField(20);
        jPanel.add(tfTitulo, montarGrid(1, y++, 3, 1));

        jPanel.add(new JLabel("Data Início (yyyy-MM-dd HH:mm):"), montarGrid(0, y, 1, 1));
        tfDataInicio = new JTextField(20);
        jPanel.add(tfDataInicio, montarGrid(1, y++, 3, 1));

        jPanel.add(new JLabel("Data Fim (yyyy-MM-dd HH:mm):"), montarGrid(0, y, 1, 1));
        tfDataFim = new JTextField(20);
        jPanel.add(tfDataFim, montarGrid(1, y++, 3, 1));

        jPanel.add(new JLabel("Palestrante:"), montarGrid(0, y, 1, 1));
        tfPalestrante = new JTextField(20);
        jPanel.add(tfPalestrante, montarGrid(1, y++, 3, 1));

        jPanel.add(new JLabel("Currículo:"), montarGrid(0, y, 1, 1));
        tfCurriculo = new JTextField(20);
        jPanel.add(tfCurriculo, montarGrid(1, y++, 3, 1));


        jPanel.add(new JLabel("Tema:"), montarGrid(0, y, 1, 1));
        tfTema = new JTextField(20);
        jPanel.add(tfTema, montarGrid(1, y++, 3, 1));


        jPanel.add(new JLabel("Imagem:"), montarGrid(0, y, 1, 1));
        tfImagemPath = new JTextField(20);
        tfImagemPath.setEditable(false);
        jPanel.add(tfImagemPath, montarGrid(1, y, 2, 1));
        btSelecionarImagem = new JButton("Selecionar Imagem");
        btSelecionarImagem.addActionListener(this::selecionarImagem);
        jPanel.add(btSelecionarImagem, montarGrid(3, y++, 1, 1));


        btSalvar = new JButton("Salvar");
        btSalvar.addActionListener(this::salvarEvento);
        jPanel.add(btSalvar, montarGrid(0, y, 1, 1));

        btListar = new JButton("Listar");
        btListar.addActionListener(this::listarEventos);
        jPanel.add(btListar, montarGrid(1, y, 1, 1));

        btExcluir = new JButton("Excluir");
        btExcluir.addActionListener(this::deletarEvento);
        jPanel.add(btExcluir, montarGrid(2, y, 1, 1));

        btEditar = new JButton("Editar");
        btEditar.addActionListener(this::editarEvento);
        jPanel.add(btEditar, montarGrid(3, y, 1, 1));

        btLimpar = new JButton("Novo");
        btLimpar.addActionListener(this::limparCampos);
        jPanel.add(btLimpar, montarGrid(4, y, 1, 1));



        return jPanel;
    }

    private JPanel montarPainelSaida() {
        JPanel jPanel = new JPanel(new BorderLayout());
        tabela = new JTable();
        tabela.setModel(carregarEventos());
        tabela.getSelectionModel().addListSelectionListener(this::selecionarEvento);
        jPanel.add(new JScrollPane(tabela), BorderLayout.CENTER);
        return jPanel;
    }

    private DefaultTableModel carregarEventos() {
        var model = new DefaultTableModel(
                new String[]{"ID", "Título", "Início", "Fim", "Palestrante", "Currículo", "Tema", "Imagem"},
                0
        );
        List<Eventos> eventos = eventoService.listarBD();
        for (Eventos ev : eventos) {
            String inicio = ev.getStart() != null
                    ? ev.getStart().format(FORMATTER)
                    : "";
            String fim = ev.getEnd() != null
                    ? ev.getEnd().format(FORMATTER)
                    : "";
            model.addRow(new Object[]{
                    ev.getId(),
                    ev.getTitle(),
                    inicio,
                    fim,
                    ev.getSpeaker(),
                    ev.getCurriculum(),
                    ev.getTheme(),
                    ev.getPhoto()
            });
        }
        return model;
    }

    private void selecionarEvento(ListSelectionEvent ev) {
        int row = tabela.getSelectedRow();
        if (row < 0) return;
        eventoSelecionadoId = (Long) tabela.getValueAt(row, 0);
        tfTitulo.setText((String) tabela.getValueAt(row, 1));
        tfDataInicio.setText((String) tabela.getValueAt(row, 2));
        tfDataFim.setText((String) tabela.getValueAt(row, 3));
        tfPalestrante.setText((String) tabela.getValueAt(row, 4));
        tfCurriculo.setText((String) tabela.getValueAt(row, 5));
        tfTema.setText((String) tabela.getValueAt(row, 6));
        tfImagemPath.setText((String) tabela.getValueAt(row, 7));
    }

    private void salvarEvento(ActionEvent actionEvent) {
        if (tfTitulo.getText().isBlank() ||
                tfDataInicio.getText().isBlank() ||
                tfDataFim.getText().isBlank() ||
                tfPalestrante.getText().isBlank() ||
                tfCurriculo.getText().isBlank() ||
                tfTema.getText().isBlank() ||
                tfImagemPath.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            LocalDateTime inicio = LocalDateTime.parse(tfDataInicio.getText(), FORMATTER);
            LocalDateTime fim = LocalDateTime.parse(tfDataFim.getText(), FORMATTER);
            Eventos ev = new Eventos(
                    eventoSelecionadoId,
                    tfTitulo.getText(),
                    inicio,
                    fim,
                    tfPalestrante.getText(),
                    tfCurriculo.getText(),
                    tfTema.getText(),
                    tfImagemPath.getText()
            );

            boolean ok = (eventoSelecionadoId == null)
                    ? eventoService.salvarBD(ev)
                    : eventoService.atualizarBD(ev);

            if (ok) {
                JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
                limparCampos(actionEvent);
                tabela.setModel(carregarEventos());
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao salvar.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Formato de data inválido.\nUse yyyy-MM-dd HH:mm",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarEvento(ActionEvent actionEvent) {
        salvarEvento(actionEvent);
    }

    private void deletarEvento(ActionEvent actionEvent) {
        if (eventoSelecionadoId == null) {
            JOptionPane.showMessageDialog(this, "Selecione um evento na tabela.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "Excluir este evento?", "Confirmação",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            boolean ok = eventoService.deletarEvento(eventoSelecionadoId);
            if (ok) {
                JOptionPane.showMessageDialog(this, "Evento excluído!");
                limparCampos(actionEvent);
                tabela.setModel(carregarEventos());
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    private void limparCampos(ActionEvent actionEvent) {
        eventoSelecionadoId = null;
        tfTitulo.setText("");
        tfDataInicio.setText("");
        tfDataFim.setText("");
        tfPalestrante.setText("");
        tfCurriculo.setText("");
        tfTema.setText("");
        tfImagemPath.setText("");
    }

    private void selecionarImagem(ActionEvent actionEvent) {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            tfImagemPath.setText(chooser.getSelectedFile().getName());
        }
    }

    private void listarEventos(ActionEvent actionEvent){
        List<Eventos> eventos = eventoService.listarBD();
        if (eventos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum evento encontrado.",
                    "Lista de Eventos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Defina as colunas que quer mostrar
        String[] colunas = {
                "ID", "Título", "Data Início", "Data Fim",
                "Palestrante", "Currículo", "Tema", "Imagem"
        };

        // Crie o modelo da tabela e adicione as linhas
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (Eventos e : eventos) {
            model.addRow(new Object[] {
                    e.getId(),
                    e.getTitle(),
                    e.getStart().format(fmt),
                    e.getEnd() != null ? e.getEnd().format(fmt) : "",
                    e.getSpeaker(),
                    e.getCurriculum(),
                    e.getTheme(),
                    e.getPhoto()
            });
        }

        // Crie a JTable e coloque num JScrollPane
        JTable tabela = new JTable(model);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (int i = 0; i < colunas.length; i++) {
            tabela.getColumnModel().getColumn(i).setPreferredWidth(120);
        }
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setPreferredSize(new Dimension(800, 300));

        // Mostra num dialog mais amigável
        JOptionPane.showMessageDialog(this, scroll,
                "Lista de Eventos", JOptionPane.INFORMATION_MESSAGE);
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(EventosGui::new);
    }
}
