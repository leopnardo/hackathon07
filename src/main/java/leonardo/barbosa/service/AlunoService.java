package leonardo.barbosa.service;

import leonardo.barbosa.dao.AlunoDao;
import leonardo.barbosa.model.Aluno;
import leonardo.barbosa.model.AlunoEventos;

import java.util.ArrayList;
import java.util.List;

public class AlunoService {

    private final AlunoDao dao = new AlunoDao();

    public Boolean Salvar(Aluno aluno) {
        return aluno.getId() == null
                ? dao.salvar(aluno)
                : dao.atualizar(aluno);
    }

    public List<Aluno> listar() {
        List<Aluno> alunos = new ArrayList<>();
        dao.listar().forEach(object -> alunos.add((Aluno) object));
        return alunos;
    }

    public List<AlunoEventos> contarAlunosEvento() {
        return dao.contarAlunosPorEvento();
    }


}
