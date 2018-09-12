package pl.aogiri.user;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class User {
	
	@Id
	private String id;
	
	private String email;
	
	private String password;
	
	private String pseudonym;
	
	private String gender;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Instant birthday;
	
	public User() {
	}

	public User(String id, String email, String password, String pseudonym, String gender, Instant birthday) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.pseudonym = pseudonym;
		this.gender = gender;
		this.birthday = birthday;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	
	

}
