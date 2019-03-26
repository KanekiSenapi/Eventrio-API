package pl.aogiri.event;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import javax.servlet.MultipartConfigElement;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import pl.aogiri.results.Result;

@Controller
@RequestMapping(path = "/api")
public class EventController {
		
	@Autowired
	EventService eventService;
	
	@RequestMapping(method = RequestMethod.GET, path="events")
	public @ResponseBody List<Event> getAllEvents(){		
		return eventService.getAllEvents();		
	}
	
	@RequestMapping(method = RequestMethod.GET, path="events/{id}")
	public @ResponseBody Event getEventById(@PathVariable String id, @PathVariable String test) {
		return eventService.getEventById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, path="events")
	public @ResponseBody Result addNewEvent(@RequestPart("body") String body){
		System.out.println(body);
		return new Result("1","1");
	}
	
	@RequestMapping(method = RequestMethod.GET, path="events/box")
	public @ResponseBody List<Event> getBoxEvents(@RequestParam(value = "S", required = true) double S,@RequestParam(value = "W", required = true) double W,@RequestParam(value = "E", required = true) double E,@RequestParam(value = "N", required = true) double N){		
		return eventService.getBoxEvents(N,E,S,W);		
	}
	
	@RequestMapping(method = RequestMethod.GET, path="events/box/date")
	public @ResponseBody List<Event> getBoxEvents(@RequestParam(value = "S", required = true) double S,@RequestParam(value = "W", required = true) double W,@RequestParam(value = "E", required = true) double E,@RequestParam(value = "N", required = true) double N,String date){		
		SimpleDateFormat smth = new SimpleDateFormat ("yyyy-MM-dd");
			return eventService.getBoxDateEvents(N,E,S,W,date);		
	}

	@RequestMapping(method = RequestMethod.PUT, path="events")
	public @ResponseBody Result updateEvent(@RequestBody Map<String,String> body){		
		return eventService.updateEvent(body);		
	}
	

}
