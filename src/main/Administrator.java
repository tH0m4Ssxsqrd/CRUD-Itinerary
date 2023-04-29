package main;

import java.util.Date;

public class Administrator extends User{
	public Administrator(ItineraryDAO itineraryDao) {
        super(itineraryDao);
    }

    public void addItinerary(Itinerary itinerary) {
        getItineraryDao().addItinerary(itinerary);
    }

    public void updateItinerary(Itinerary itinerary) {
        getItineraryDao().updateItinerary(itinerary);
    }

    public void deleteItinerary(Date date) {
        getItineraryDao().deleteItinerary(date);
    }

}
