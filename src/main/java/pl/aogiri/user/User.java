package pl.aogiri.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.aogiri.comment.Comment;
import pl.aogiri.event.Event;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String email;
	
	private String password;
	
	private String pseudonym;
	
	private String gender;
	
	private String fbid;

	private String picture;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Warsaw")
	private Instant birthday;

	@OneToOne(mappedBy = "organizer")
	private Event event;

	@OneToOne(mappedBy = "commentator")
	private Comment comment;

	public User() {
	}

	public User(String email, String password, String pseudonym, String gender, String fbid,String picture, Instant birthday) {
		this.email = email;
		this.password = password;
		this.pseudonym = pseudonym;
		this.gender = gender;
		this.fbid = fbid;
		this.birthday = birthday;
		this.picture = picture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPseudonym() {
		return pseudonym;
	}

	public void setPseudonym(String pseudonym) {
		this.pseudonym = pseudonym;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Instant getBirthday() {
		return birthday;
	}

	public void setBirthday(Instant birthday) {
		this.birthday = birthday;
	}

	public String getFbid() {
		return fbid;
	}

	public void setFbid(String fbid) {
		this.fbid = fbid;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}


}
