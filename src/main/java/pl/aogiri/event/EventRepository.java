package pl.aogiri.event;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {
	
	public List<Event> findAllByOrderByDateBeg();

//	public void saveAndFlush(Event event);
	

}
