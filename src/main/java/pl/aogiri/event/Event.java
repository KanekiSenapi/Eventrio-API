package pl.aogiri.event;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Event {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private long id;
	
	@NotNull
	private String name;
		
	@NotNull
	private double lat;
	
	@NotNull
	private double lng;
	
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Warsaw")
	@NotNull
	private Timestamp dateBeg;
	
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Warsaw")
	@NotNull
	private Timestamp dateEnd;
	
	@NotNull
	private byte[] image;
	
	public Event() {
	}

	public Event(@NotNull long id, @NotNull String name, @NotNull double lat, @NotNull double lng, @NotNull Timestamp dateBeg,
			@NotNull Timestamp dateEnd, @NotNull byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.dateBeg = dateBeg;
		this.dateEnd = dateEnd;
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Timestamp getDateBeg() {
		return dateBeg;
	}

	public void setDateBeg(Timestamp dateBeg) {
		this.dateBeg = dateBeg;
	}

	public Timestamp getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Timestamp dateEnd) {
		this.dateEnd = dateEnd;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
	
	
	

}
