package leonardo.barbosa.dao;

import leonardo.barbosa.model.Aluno;
import leonardo.barbosa.model.AlunoEventos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao extends Dao implements DaoInterface {


    @Override
    public boolean salvar(Object entity) {
        try {
            var aluno = (Aluno) entity;

            String sqlInsert = "insert into aluno(ra, name, cpf, evento_id) values(?,?,?,?)";

            var ps = getConnection().prepareStatement(sqlInsert);
            ps.setLong(1, aluno.getRa());
            ps.setString(2, aluno.getName());
            ps.setString(3, aluno.getCpf());
            ps.setLong(4, aluno.getEvento_id());
            ps.execute();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean atualizar(Object entity) {
        return false;
    }

    @Override
    public List<Object> listar() {
        List<Aluno> alunos = new ArrayList<>();
        try {
            var resultSet = getConnection()
                    .prepareStatement("select * from aluno")
                    .executeQuery();

            while (resultSet.next()) {
                var aluno = new Aluno(
                        resultSet.getLong("id"),
                        resultSet.getLong("ra"),
                        resultSet.getString("name"),
                        resultSet.getString("cpf"),
                        resultSet.getLong("evento_id")
                );
                alunos.add(aluno);
            }

            resultSet.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new ArrayList<>(alunos);
    }

    @Override
    public Object buscarPorId(Long id) {
        var aluno = new Aluno();
        try {
            var sqlRequest = "select * from aluno where id = ?"; // <- Atualização neste sql
            var ps = getConnection().prepareStatement(sqlRequest);
            ps.setLong(1, id);
            var rs = ps.executeQuery();

            while (rs.next()) {
                aluno.setId(rs.getLong("ra"));
                aluno.setName(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setEvento_id(rs.getLong("evento"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return aluno;
    }

    public List<AlunoEventos> contarAlunosPorEvento() {

        var sqlRequest = """
                    SELECT evento_id,
                           COUNT(*) AS total
                      FROM aluno
                     GROUP BY evento_id
                     ORDER BY evento_id
                """;

        List<AlunoEventos> lista = new ArrayList<>();
        try (var conn = getConnection();
             var ps = conn.prepareStatement(sqlRequest);
             var rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new AlunoEventos(
                        rs.getLong("evento_id"),
                        rs.getInt("total")
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao contar alunos por evento", e);
        }
        return lista;
    }


    @Override
    public boolean deletar(Long id) {
        return false;
    }
}
