package pl.aogiri.event;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, String> {
	
	List<Event> findAllByOrderByDateBeg();



}
