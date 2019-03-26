package pl.aogiri.comment;

import pl.aogiri.event.Event;
import pl.aogiri.user.User;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String content;

    private Instant date;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event eventToComments;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User commentator;

    public Comment() {
    }

    public Comment(String content, Instant date, User commentator) {
        this.content = content;
        this.date = date;
        this.commentator = commentator;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public User getCommentator() {
        return commentator;
    }

    public void setCommentator(User user) {
        this.commentator = commentator;
    }
}
