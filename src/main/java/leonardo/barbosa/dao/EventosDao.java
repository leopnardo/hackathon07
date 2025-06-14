package leonardo.barbosa.dao;

import leonardo.barbosa.model.Aluno;
import leonardo.barbosa.model.Eventos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EventosDao extends Dao implements DaoInterface {


    @Override
    public boolean salvar(Object entity) {
        try {
            Eventos evento = (Eventos) entity;

            String sqlInsert = """
            INSERT INTO eventos(title, start, end, speaker, curriculum, theme, photo)
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

            try (PreparedStatement ps = getConnection().prepareStatement(sqlInsert)) {
                ps.setString(1, evento.getTitle());
                ps.setTimestamp(2, Timestamp.valueOf(evento.getStart()));
                System.out.println("Data Início: " + evento.getStart());
                ps.setTimestamp(3, Timestamp.valueOf(evento.getEnd()));
                System.out.println("Data Fim: " + evento.getEnd());
                ps.setString(4, evento.getSpeaker());
                ps.setString(5, evento.getCurriculum());
                ps.setString(6, evento.getTheme());
                ps.setString(7, evento.getPhoto());
                ps.execute();
                return true;
            }
        } catch (Exception e) {
            System.err.println("Erro ao salvar evento: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean atualizar(Object entity) {
        try {
            Eventos evento = (Eventos) entity;

            String sqlUpdate = """
            UPDATE eventos
            SET title = ?, start = ?, end = ?, speaker = ?, curriculum = ?, theme = ?, photo = ?
            WHERE id = ?
        """;
            try (PreparedStatement ps = getConnection().prepareStatement(sqlUpdate)) {
                ps.setString(1, evento.getTitle());
                ps.setTimestamp(2, Timestamp.valueOf(evento.getStart()));
                ps.setTimestamp(3, evento.getEnd() != null ? Timestamp.valueOf(evento.getEnd()) : null);
                ps.setString(4, evento.getSpeaker());
                ps.setString(5, evento.getCurriculum());
                ps.setString(6, evento.getTheme());
                ps.setString(7, evento.getPhoto());
                ps.setLong(8, evento.getId());

                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            }

        } catch (Exception e) {
            System.err.println("Erro ao atualizar evento: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> eventos = new ArrayList<>();

        String sql = "SELECT * FROM eventos";

        try (PreparedStatement ps = getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Eventos evento = new Eventos(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getTimestamp("start").toLocalDateTime(),
                        rs.getTimestamp("end") != null ? rs.getTimestamp("end").toLocalDateTime() : null,
                        rs.getString("speaker"),
                        rs.getString("curriculum"),
                        rs.getString("theme"),
                        rs.getString("photo")
                );

                eventos.add(evento);
            }
        } catch (Exception e) {
            System.err.println("Erro ao listar eventos: " + e.getMessage());
            e.printStackTrace();
        }
        return eventos;

    }

    @Override
    public Object buscarPorId(Long id) {
        Eventos evento = null;

        String sql = "SELECT * FROM eventos WHERE id = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    evento = new Eventos();
                    evento.setId(rs.getLong("id"));
                    evento.setTitle(rs.getString("title"));
                    evento.setStart(rs.getTimestamp("start").toLocalDateTime());

                    if (rs.getTimestamp("end") != null) {
                        evento.setEnd(rs.getTimestamp("end").toLocalDateTime());
                    } else {
                        evento.setEnd(null);
                    }

                    evento.setSpeaker(rs.getString("speaker"));
                    evento.setCurriculum(rs.getString("curriculum"));
                    evento.setTheme(rs.getString("theme"));
                    evento.setPhoto(rs.getString("photo"));
                }
            }

        } catch (Exception e) {
            System.err.println("Erro ao buscar evento por ID: " + e.getMessage());
            e.printStackTrace();
        }

        return evento;
    }

    @Override
    public boolean deletar(Long id) {
        try {
            String sqlDelete = "DELETE FROM eventos WHERE id = ?";
            var ps = getConnection().prepareStatement(sqlDelete);
            ps.setLong(1, id);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao deletar evento: " + e.getMessage());
            return false;
        }
    }
}
