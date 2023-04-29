package main;

import java.util.Date;
import java.util.List;

public class User {
	private ItineraryDAO itineraryDao;

    public User(ItineraryDAO itineraryDao) {
        this.setItineraryDao(itineraryDao);
    }

    public List<Itinerary> getAllItinerary() {
        return getItineraryDao().getAllItinerary();
    }

    public Itinerary getItineraryByDate(Date date) {
        return getItineraryDao().getItineraryByDate(date);
    }

	public ItineraryDAO getItineraryDao() {
		return itineraryDao;
	}

	public void setItineraryDao(ItineraryDAO itineraryDao) {
		this.itineraryDao = itineraryDao;
	}
}
