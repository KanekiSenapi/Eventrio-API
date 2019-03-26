package pl.aogiri.event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import pl.aogiri.results.Result;

@RestController
@RequestMapping(path = "/api")
public class EventController {
		
	@Autowired
	EventService eventService;
	
	@RequestMapping(method = RequestMethod.GET, path="events")
	public @ResponseBody List<Event> getAllEvents(){		
		return eventService.getAllEvents();		
	}

	
	@RequestMapping(method = RequestMethod.GET, path="events/{id}")
	public @ResponseBody Event getEventById(@PathVariable Integer id) {
		return eventService.getEventById(id);
	}

	//TODO need check how create event with user one-to-one
	@RequestMapping(method = RequestMethod.POST, path="events/create")
	public @ResponseBody
	HttpStatus addNewEvent(@RequestBody Event event){
		System.out.println(event.getOrganizer());
		return eventService.addNewEvent(event);
	}

	@RequestMapping(method = RequestMethod.GET, path="events/box")
	public @ResponseBody List<Event> getBoxEvents(@RequestParam(value = "N", required = true) double N,@RequestParam(value = "S", required = true) double S,@RequestParam(value = "W", required = true) double W,@RequestParam(value = "E", required = true) double E, String date) throws ParseException {
		return eventService.getBoxEvents(N, S, W, E, date);
	}


	//TODO update event after create any event :V
	@RequestMapping(method = RequestMethod.PUT, path="events")
	public @ResponseBody Result updateEvent(@RequestBody Map<String,String> body){		
		return eventService.updateEvent(body);		
	}
	

}
