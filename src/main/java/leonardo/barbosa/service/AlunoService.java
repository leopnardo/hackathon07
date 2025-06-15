package leonardo.barbosa.service;

import leonardo.barbosa.dao.AlunoDao;
import leonardo.barbosa.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoService {

    public Boolean salvar(Aluno aluno){
        var dao = new AlunoDao();
        return aluno.getId() == null
                ? dao.salvar(aluno)
                : dao.atualizar(aluno);
    }

    public List<Aluno> listar(){
        List<Aluno> alunos = new ArrayList<>();
        var dao = new AlunoDao();


        dao.listar().forEach(object -> alunos.add((Aluno) object));
        return alunos;
    }

    public String listarArquivos() {

        var dao = new AlunoDao();

        String result = "";
        for (Object aluno : dao.listar()) {
            result = result + "\n" + aluno;
        }

        return result;
    }




}
