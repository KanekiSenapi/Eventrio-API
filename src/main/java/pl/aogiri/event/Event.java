package pl.aogiri.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.aogiri.comment.Comment;
import pl.aogiri.tag.Tag;
import pl.aogiri.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	private double lat;

	private double lng;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Warsaw")
	private Instant dateBeg;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Warsaw")
	private Instant dateEnd;

	private String address;

	private int status;

	private String description;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User organizer;

	@ManyToMany
	@JoinTable(
			name = "eventToTag",
			joinColumns = @JoinColumn(name = "event_id"),
			inverseJoinColumns = @JoinColumn(name = "tag_id")
	)
	private Set<Tag> tags;

	@OneToMany(mappedBy = "eventToComments")
	@OrderBy("date DESC")
	private Set<Comment> comments;

	public Event() {
	}

	public Event(Map<String, String> body) {
		this.name = (body.get("name"));
		this.dateBeg = (Instant.parse(body.get("dateBeg")));
		this.dateEnd = (Instant.parse(String.valueOf(body.get("dateEnd"))));
		this.lat = (Double.valueOf(body.get("lat")));
		this.lng = (Double.valueOf(body.get("lng")));
		this.address = (String.valueOf(body.get("address")));
		this.status = (Integer.valueOf(body.get("status")));
		this.description = (String.valueOf(body.get("description")));
	}

	public Event(String name, double lat, double lng, Instant dateBeg, Instant dateEnd, String address, int status, String description, User organizer, Set<Tag> tags, Set<Comment> comments) {
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.dateBeg = dateBeg;
		this.dateEnd = dateEnd;
		this.address = address;
		this.status = status;
		this.description = description;
		this.organizer = organizer;
		this.tags = tags;
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public Instant getDateBeg() {
		return dateBeg;
	}

	public void setDateBeg(Instant dateBeg) {
		this.dateBeg = dateBeg;
	}

	public Instant getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Instant dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getOrganizer() {
		return organizer;
	}

	public void setOrganizer(User organizer) {
		this.organizer = organizer;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}
