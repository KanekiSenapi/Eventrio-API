package pl.aogiri.comment;

import pl.aogiri.event.Event;
import pl.aogiri.user.User;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;


    private String content;

    private Instant date;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    public Comment() {
    }

    public Comment(User user, String content, Instant date) {
        this.content = content;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

}
