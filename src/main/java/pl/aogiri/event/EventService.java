package pl.aogiri.event;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.synchronoss.cloud.nio.multipart.Multipart;

import pl.aogiri.results.Result;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepository;
	
	public List<Event> getAllEvents(){
		return eventRepository.findAllByOrderByDateBeg();
	}

	public Event getEventById(String id) {
		return eventRepository.findById(id).get();
	}

	public Result addNewEvent(Map<String,String> body, MultipartFile image) {
		Event event = new Event(body);
		try {
			event.setImage(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		eventRepository.save(event);
		if(event.getId() != null) 
			return new Result("success", String.valueOf(event.getId()));
		return new Result("failed","");
	}

	public List<Event> getBoxEvents(double N, double E,double S, double W) {
		List<Event> events = this.getAllEvents();
		List<Event> toR = new ArrayList<>();
		events.forEach(event ->{
			double lat = event.getLat();
			double lng = event.getLng();
			if(lat>S && lat<N && lng>W && lng<E)
				toR.add(event);
		});
		return toR;
	}
	
	public List<Event> getBoxDateEvents(double n, double e, double s, double w, String datex) {
		List<Event> events = this.getAllEvents();
		List<Event> toR = new ArrayList<>();
		Instant date = Instant.parse(datex);
		events.forEach(event ->{
			double lat = event.getLat();
			double lng = event.getLng();
			Instant date_beg = event.getDateBeg();
			Instant date_end = event.getDateEnd();
			
			if(lat>s && lat<n && lng>w && lng<e && ((date_beg.isBefore(date) && date_end.isAfter(date)) || compareDates(date_beg,date) || compareDates(date_end,date)))
				toR.add(event);
		});
		return toR;
	}

	public Object generateRandom() {
//		double mina = 50.015348;
//		double maxa = 50.109058;
//		double minb = 19.817511;
//		double maxb = 20.061383;
//		long offset = Timestamp.valueOf("2018-09-07 00:00:00").getTime();
//		long end = Timestamp.valueOf("2020-12-30 00:00:00").getTime();
//		long diff = end - offset + 1;
//		for (int n = 0; n < 100; n++) {
//			Event event = new Event();
//			event.setLat(mina + Math.random() * (maxa - mina));
//			event.setLng(minb + Math.random() * (maxb - minb));
//			event.setName("Test event #" + String.valueOf(n));
////			eventRepository.save(event);
//		}
		return null;
	}
	
	private boolean compareDates(Instant date1, Instant date2) {

		ZonedDateTime zdt = ZonedDateTime.ofInstant(date1, ZoneId.systemDefault());
		ZonedDateTime zdt2 = ZonedDateTime.ofInstant(date2, ZoneId.systemDefault());
		Calendar cal1 = GregorianCalendar.from(zdt);
		Calendar cal2 = GregorianCalendar.from(zdt2);
		boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
		                  cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
		return sameDay;
	}

	public Result updateEvent(Map<String, String> body) {
		
		return null;
	}

	public Result addNewEvent(Event event, MultipartFile image) {
		try {
			event.setImage(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		eventRepository.save(event);
		if(event.getId() != null) 
			return new Result("success", String.valueOf(event.getId()));
		return new Result("failed","");
	}
	


}
