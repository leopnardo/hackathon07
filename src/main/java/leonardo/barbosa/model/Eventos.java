package leonardo.barbosa.model;

import java.time.LocalDateTime;

public class Eventos {

    private Long id;
    private String title;
    private LocalDateTime start;
    private LocalDateTime end;
    private String speaker;
    private String curriculum;
    private String theme;
    private String photo;

    public Eventos() {}

    public Eventos(Long id, String title, LocalDateTime start, LocalDateTime end, String speaker, String curriculum, String theme, String photo) {
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;
        this.speaker = speaker;
        this.curriculum = curriculum;
        this.theme = theme;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
