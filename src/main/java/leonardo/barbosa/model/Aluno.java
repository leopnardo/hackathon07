package leonardo.barbosa.model;

public class Aluno {

    private int id;
    private int ra;
    private String name;
    private String cpf;
    private int evento_id;

    public Aluno(){}

    public Aluno(int id, int ra, String name, String cpf, int evento_id) {
        this.id = id;
        this.ra = ra;
        this.name = name;
        this.cpf = cpf;
        this.evento_id = evento_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getEvento_id() {
        return evento_id;
    }

    public void setEvento_id(int evento_id) {
        this.evento_id = evento_id;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", ra=" + ra +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", evento_id=" + evento_id +
                '}';
    }

}
