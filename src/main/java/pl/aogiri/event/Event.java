package pl.aogiri.event;

import java.time.Instant;
import java.util.Map;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Event {
	
	@Id
	private String id;
	
	
//	@NotNull
	private String name;
		
//	@NotNull
	private double lat;
	
//	@NotNull
	private double lng;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Warsaw")
//	@NotNull
	private Instant dateBeg;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Warsaw")
//	@NotNull
	private Instant dateEnd;
	
//	@NotNull
	private Binary image;
	
	private String address;
	
	private int status;
	
	public Event() {
	}

	public Event( String id,  String name,  double lat,  double lng,  Instant dateBeg,
			Instant dateEnd,  Binary image, String address, int status) {
		super();
		this.id = id;
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.dateBeg = dateBeg;
		this.dateEnd = dateEnd;
		this.image = image;
		this.address = address;
		this.status = status;
		this.image = image;
	}

	public Event(Map<String, String> body) {
		this.name = (body.get("name"));
		this.dateBeg = (Instant.parse(body.get("dateBeg")));
		this.dateEnd = (Instant.parse(String.valueOf(body.get("dateEnd"))));
		this.lat = (Double.valueOf(body.get("lat")));
		this.lng = (Double.valueOf(body.get("lng")));
		this.address = (String.valueOf(body.get("address")));
		this.status = (Integer.valueOf(body.get("status")));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Binary getImage() {
		return image;
	}

	public void setImage(Binary image) {
		this.image = image;
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
	
	
	
	
	
	

}
