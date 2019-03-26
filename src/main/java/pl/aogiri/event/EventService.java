package pl.aogiri.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.aogiri.results.Result;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepository;
	
	public List<Event> getAllEvents(){
		return eventRepository.findAllByOrderByDateBeg();
	}

	public Event getEventById(Integer id) {
		return eventRepository.findById(id).get();
	}

	public HttpStatus addNewEvent(Event body) {
		try {
			Event e = eventRepository.save(body);
			if(e.getId() != null)
				return HttpStatus.CREATED;
		}catch (NoSuchElementException e){
			return HttpStatus.CONFLICT;
		}
		return HttpStatus.CONFLICT;
	}

	public List<Event> getBoxEvents(double N, double S, double W, double E, String date) throws ParseException {
		List<Event> events = this.getAllEvents();
		List<Event> toR = new ArrayList<>();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Instant date_check = simpleDateFormat.parse(date).toInstant();
		events.forEach(event ->{
			double lat = event.getLat();
			double lng = event.getLng();
			Instant date_eventBeg = event.getDateBeg();
			Instant date_eventEnd = event.getDateEnd();
			if((lng>N && lng<S && lat>W && lat<E) & (date_eventBeg.isBefore(date_check) && date_eventEnd.isAfter(date_check)) )
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


}
