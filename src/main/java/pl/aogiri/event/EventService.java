package pl.aogiri.event;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.aogiri.results.Result;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepository;
	
	public List<Event> getAllEvents(){
		return eventRepository.findAllByOrderByDateBeg();
	}

	public Event getEventById(long id) {
		return eventRepository.findById(id).get();
	}

	public Result addNewEvent(Map<String,String> body) {
		Event event = new Event();
		event.setName(body.get("name"));
		event.setDateBeg(Timestamp.valueOf(body.get("dateBeg")));
		event.setDateEnd(Timestamp.valueOf(body.get("dateEnd")));
		event.setLat(Double.valueOf(body.get("lat")));
		event.setLng(Double.valueOf(body.get("lng")));
		eventRepository.saveAndFlush(event);
		if(event.getId() != 0) return new Result("success", String.valueOf(event.getId()));
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
	
	public List<Event> getBoxDateEvents(double n, double e, double s, double w, Timestamp date) {
		List<Event> events = this.getAllEvents();
		List<Event> toR = new ArrayList<>();
		events.forEach(event ->{
			double lat = event.getLat();
			double lng = event.getLng();
			Timestamp date_beg = event.getDateBeg();
			Timestamp date_end = event.getDateEnd();
			
			if(lat>s && lat<n && lng>w && lng<e && ((date_beg.before(date) && date_end.after(date)) || compareDates(date_beg,date) || compareDates(date_end,date)))
				toR.add(event);
		});
		return toR;
	}

	public Object generateRandom() {
		double mina = 50.015348;
		double maxa = 50.109058;
		double minb = 19.817511;
		double maxb = 20.061383;
		long offset = Timestamp.valueOf("2018-09-07 00:00:00").getTime();
		long end = Timestamp.valueOf("2020-12-30 00:00:00").getTime();
		long diff = end - offset + 1;
		for (int n = 0; n < 100; n++) {
			Event event = new Event();
			event.setLat(mina + Math.random() * (maxa - mina));
			event.setLng(minb + Math.random() * (maxb - minb));
			event.setDateBeg(new Timestamp(offset + (long)(Math.random() * diff)));
			event.setDateEnd(new Timestamp(offset + (long)(Math.random() * diff)));
			event.setName("Test event #" + String.valueOf(n));
			eventRepository.save(event);
		}
		return null;
	}
	
	private boolean compareDates(Timestamp date1, Timestamp date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
		                  cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
		return sameDay;
	}


}
