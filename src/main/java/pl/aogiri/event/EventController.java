package pl.aogiri.event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import pl.aogiri.results.Result;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/api")
public class EventController {

	@Autowired
	EventService eventService;

	@RequestMapping(method = RequestMethod.GET, path="events")
	public @ResponseBody List<Event> getAllEvents(HttpServletResponse response){
		List<Event> events = eventService.getAllEvents();
		if(events.size()==0)
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		return events;
	}


	@RequestMapping(method = RequestMethod.GET, path="events/{id}")
	public @ResponseBody Event getEventById(@PathVariable Integer id, HttpServletResponse response) {
		Event event = eventService.getEventById(id);
		if(event.getId()==null)
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		return event;
	}

	//TODO need check how create event with user one-to-one
	@RequestMapping(method = RequestMethod.POST, path="events/create")
	public @ResponseBody
	HttpStatus addNewEvent(@RequestBody Event event){
		System.out.println(event.getOrganizer());
		return eventService.addNewEvent(event);
	}

	@RequestMapping(method = RequestMethod.GET, path="events/box")
	public @ResponseBody List<Event> getBoxEvents(@RequestParam(value = "N", required = true) double N,@RequestParam(value = "S", required = true) double S,@RequestParam(value = "W", required = true) double W,@RequestParam(value = "E", required = true) double E, String date, HttpServletResponse response) throws ParseException {
		List<Event> events = eventService.getBoxEvents(N, S, W, E, date);
		if(events.size()==0)
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		return events;
	}


	//TODO update event after create any event :V
	@RequestMapping(method = RequestMethod.PUT, path="events")
	public @ResponseBody Result updateEvent(@RequestBody Map<String,String> body){
		return eventService.updateEvent(body);
	}


}
