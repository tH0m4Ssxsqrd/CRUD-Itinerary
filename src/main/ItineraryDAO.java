package main;

import java.util.Date;
import java.util.List;

public interface ItineraryDAO {
	void addItinerary(Itinerary itinerary);
    void updateItinerary(Itinerary itinerary);
    void deleteItinerary(Date date);
    List<Itinerary> getAllItinerary();
	Itinerary getItineraryByDate(Date date);

}
