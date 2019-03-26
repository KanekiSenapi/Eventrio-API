package pl.aogiri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.aogiri.event.EventController;

@SpringBootApplication
public class EventrioApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventrioApplication.class, args);
	}
}
