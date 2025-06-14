package leonardo.barbosa.model;

public class Aluno {

    private Long id;
    private Long ra;
    private String name;
    private String cpf;
    private Long evento_id;

    public Aluno(){}

    public Aluno(Long id, Long ra, String name, String cpf, Long evento_id) {
        this.id = id;
        this.ra = ra;
        this.name = name;
        this.cpf = cpf;
        this.evento_id = evento_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRa() {
        return ra;
    }

    public void setRa(Long ra) {
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

    public Long getEvento_id() {
        return evento_id;
    }

    public void setEvento_id(Long evento_id) {
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
