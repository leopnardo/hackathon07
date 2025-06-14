package leonardo.barbosa.dao;

import leonardo.barbosa.model.Aluno;
import leonardo.barbosa.model.Eventos;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EventosDao extends Dao implements DaoInterface {


    @Override
    public boolean salvar(Object entity) {
        try {
            var evento = (Eventos) entity;

            String sqlInsert = "insert into evento(title, start, end, speaker, curriculum, theme, photo) values(?, ?, ?, ?, ?, ?, ?)";

            var ps = getConnection().prepareStatement(sqlInsert);
            ps.setString(1, evento.getTitle());
            ps.setTimestamp(2, Timestamp.valueOf(evento.getStart()));
            System.out.println("Data Início: " + evento.getStart());
            ps.setTimestamp(3, Timestamp.valueOf(evento.getEnd()));
            System.out.println("Data Fim: " + evento.getStart());
            ps.setString(4, evento.getSpeaker());
            ps.setString(5, evento.getCurriculum());
            ps.setString(6, evento.getPhoto());
            ps.execute();

            return true;
        }catch (Exception e) {
            System.out.println("Erro ao salvar evento" + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean atualizar(Object entity) {
        try {
            var evento  = (Eventos) entity;

            String sqlUpdate = "UPDATE eventos SET title=?, start=?, end=?, speaker=?, curriculum=?, theme=?, photo=? WHERE id=?";

            var ps = getConnection().prepareStatement(sqlUpdate);
            ps.setString(1,evento.getTitle());
            ps.setTimestamp(2,Timestamp.valueOf(evento.getStart()));
            ps.setTimestamp(3,Timestamp.valueOf(evento.getStart()));
            ps.setString(4, evento.getSpeaker());
            ps.setString(5, evento.getCurriculum());
            ps.setString(6, evento.getTheme());
            ps.setString(7, evento.getPhoto());
            ps.execute();

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar evento" + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Eventos> eventos = new ArrayList<>();

        try {
            var resultSet = getConnection()
                    .prepareStatement("SELECT * FROM eventos")
                    .executeQuery();

            while (resultSet.next()) {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                var evento = new Eventos(
                        resultSet.getLong("id"),
                        resultSet.getString("titulo"),
                        LocalDateTime.parse(resultSet.getString("data_inicio"), formatter),
                        LocalDateTime.parse(resultSet.getString("data_fim"), formatter),
                        resultSet.getString("palestrante"),
                        resultSet.getString("curriculo"),
                        resultSet.getString("tema"),
                        resultSet.getString("imagem")
                );

                eventos.add(evento);
            }

            resultSet.close();

        } catch (Exception e) {
            System.out.println("Erro ao listar eventos: " + e.getMessage());
        }
        return new ArrayList<>(eventos);

    }

    @Override
    public Object buscarPorId(Long id) {
        var evento = new Eventos();

        try {
            String sql = "SELECT * FROM eventos WHERE id = ?";
            var ps = getConnection().prepareStatement(sql);
            ps.setLong(1, id);
            var rs = ps.executeQuery();

            if (rs.next()) {
                evento.setId(rs.getLong("id"));
                evento.setTitle(rs.getString("titulo"));
                evento.setStart(rs.getTimestamp("data_inicio").toLocalDateTime());
                evento.setEnd(rs.getTimestamp("data_fim").toLocalDateTime());
                evento.setSpeaker(rs.getString("palestrante"));
                evento.setCurriculum(rs.getString("curriculo"));
                evento.setTheme(rs.getString("tema"));
                evento.setPhoto(rs.getString("imagem"));
            }

            rs.close();

        } catch (Exception e) {
            System.out.println("Erro ao buscar evento por ID: " + e.getMessage());
        }

        return evento;
    }

    @Override
    public boolean deletar(Long id) {
        try {
            String sqlDelete = "DELETE FROM eventos WHERE id = ?";
            var ps = getConnection().prepareStatement(sqlDelete);
            ps.setLong(1, id);
            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao deletar evento: " + e.getMessage());
            return false;
        }
    }
}
