package leonardo.barbosa.service;

import leonardo.barbosa.dao.AlunoDao;
import leonardo.barbosa.dao.EventosDao;
import leonardo.barbosa.model.Aluno;
import leonardo.barbosa.model.Eventos;

import java.util.ArrayList;
import java.util.List;

public class EventoService {

    public boolean salvarBD(Eventos eventos){
        var dao = new EventosDao();
        return dao.salvar(eventos);
    }

    public List<Eventos> listarBD() {
        List<Eventos> evento = new ArrayList<>();
        var dao = new EventosDao();

        dao.listar().forEach(object -> evento.add((Eventos) object));
        return evento;
    }

    public boolean atualizarBD(Eventos eventos) {
        var dao = new EventosDao();
        return dao.atualizar(eventos);
    }

    public Boolean deletarEvento(Long id) {
        if (id == null) return false;
        var dao = new EventosDao();
        return dao.deletar(id);
    }

    public String listar() {
        var dao = new EventosDao();

        StringBuilder result = new StringBuilder();
        for (Object evento : dao.listar()) {
            result.append("\n").append(evento);
        }
        return result.toString();
    }

    public List<Aluno> listarAlunoPorEvento(){
        AlunoDao AlunoDao = new AlunoDao();
        List<Aluno> alunos = new ArrayList<>();
        AlunoDao.listar().forEach(obj -> alunos.add((Aluno)obj));
        return alunos;
    }



}
