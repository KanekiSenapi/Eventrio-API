package pl.aogiri.event;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends CrudRepository<Event, Long> {
	
	public List<Event> findAllByOrderByDateBeg();

	public void saveAndFlush(Event event);
	

}
