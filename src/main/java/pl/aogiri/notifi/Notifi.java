package pl.aogiri.notifi;

import pl.aogiri.user.User;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Notifi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private Instant date;

    private boolean showed;

    private String category;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userNotfi;

    public Notifi() {
    }

    public Notifi(String title, Instant date, boolean showed, String category) {
        this.title = title;
        this.date = date;
        this.showed = showed;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public boolean isShowed() {
        return showed;
    }

    public void setShowed(boolean showed) {
        this.showed = showed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
