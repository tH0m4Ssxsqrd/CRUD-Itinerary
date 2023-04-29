package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItineraryDAOImpl implements ItineraryDAO{
	private List<Itinerary> itineraries = new ArrayList<>();

    @Override
    public void addItinerary(Itinerary itinerary) {
        itineraries.add(itinerary);
    }

    @Override
    public void updateItinerary(Itinerary itinerary) {
        Itinerary existingItinerary = getItineraryByDate(itinerary.getDate());
        if (existingItinerary != null) {
        	existingItinerary.setOrigin(itinerary.getOrigin());
            existingItinerary.setDestination(itinerary.getDestination());
        }
    }

    @Override
    public void deleteItinerary(Date date) {
        Itinerary existingItinerary = getItineraryByDate(date);
        if (existingItinerary != null) {
            itineraries.remove(existingItinerary);
        }
    }

    @Override
    public List<Itinerary> getAllItinerary() {
        return itineraries;
    }

    @Override
    public Itinerary getItineraryByDate(Date date) {
        for (Itinerary itinerary : itineraries) {
            if (itinerary.getDate().equals(date)) {
                return itinerary;
            }
        }
        return null;
    }

}
