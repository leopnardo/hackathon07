package leonardo.barbosa.model;

public class AlunoEventos {

    private Long evento_id;
    private int totalAlunos;

    public AlunoEventos(Long evento_id, int totalAlunos) {
        this.evento_id = evento_id;
        this.totalAlunos = totalAlunos;
    }

    public Long getEvento_id() {
        return evento_id;
    }

    public void setEvento_id(Long evento_id) {
        this.evento_id = evento_id;
    }

    public int getTotalAlunos() {
        return totalAlunos;
    }

    public void setTotalAlunos(int totalAlunos) {
        this.totalAlunos = totalAlunos;
    }


}
