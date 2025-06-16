package leonardo.barbosa.gui;

import leonardo.barbosa.model.Aluno;
import leonardo.barbosa.model.AlunoEventos;
import leonardo.barbosa.service.AlunoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class AlunoGui extends JFrame implements GuiUtil {

    private final AlunoService service = new AlunoService();

    public AlunoGui() {
        setTitle("Alunos por eventos");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        int y = 0;

        JButton btlistar = new JButton("Listar Alunos");
        btlistar.addActionListener(this::listarAlunos);
        painel.add(btlistar, montarGrid(0, y++, 1, 1));

        JButton btEvento = new JButton("Alunos Por Evento");
        btEvento.addActionListener(this::listarAlunosPorEvento);
        painel.add(btEvento, montarGrid(0, y++, 1, 1));

        getContentPane().add(painel);
    }

    private void listarAlunos(ActionEvent actionEvent) {
        List<Aluno> alunos = service.listar();
        if (alunos.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum aluno cadastrado.",
                    "Lista de Alunos",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String[] col = {"ID", "RA", "Nome", "CPF", "Evento ID"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        for (Aluno a : alunos) {
            model.addRow(new Object[]{
                    a.getId(), a.getRa(), a.getName(),
                    a.getCpf(), a.getEvento_id()
            });
        }

        JTable table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(700, 200));
        JOptionPane.showMessageDialog(this,
                scroll,
                "Lista de Alunos",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void listarAlunosPorEvento(ActionEvent actionEvent) {
        List<AlunoEventos> dados = service.contarAlunosEvento();
        if (dados.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum dado disponível.",
                    "Alunos por Evento",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String[] col = {"Evento ID", "Total Alunos"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        for (AlunoEventos c : dados) {
            model.addRow(new Object[]{
                    c.getEvento_id(),
                    c.getTotalAlunos()
            });
        }

        JTable table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(400, 200));
        JOptionPane.showMessageDialog(this,
                scroll,
                "Alunos por Evento",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AlunoGui::new);
    }

}
