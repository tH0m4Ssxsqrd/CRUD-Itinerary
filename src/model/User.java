package model;

import java.util.Date;
import java.util.List;

import control.ItineraryDAO;

/**
 * Represents a user who can interact with itineraries.
 */
public class User {
    private ItineraryDAO itineraryDao;

    /**
     * Constructs a new User instance with the specified itinerary DAO.
     *
     * @param itineraryDao The itinerary DAO implementation to be used for data access.
     */
    public User(ItineraryDAO itineraryDao) {
        this.setItineraryDao(itineraryDao);
    }

    /**
     * Retrieves all the itineraries stored in the system.
     *
     * @return A list containing all the itineraries.
     */
    public List<Itinerary> getAllItinerary() {
        return getItineraryDao().getAllItinerary();
    }

    /**
     * Retrieves the itinerary with the specified date from the system.
     *
     * @param date The date of the itinerary to retrieve.
     * @return The itinerary with the specified date, or null if not found.
     */
    public Itinerary getItineraryByDate(Date date) {
        return getItineraryDao().getItineraryByDate(date);
    }

    /**
     * Gets the itinerary DAO associated with the user.
     *
     * @return The itinerary DAO implementation.
     */
    public ItineraryDAO getItineraryDao() {
        return itineraryDao;
    }

    /**
     * Sets the itinerary DAO to be associated with the user.
     *
     * @param itineraryDao The itinerary DAO implementation to be set.
     */
    public void setItineraryDao(ItineraryDAO itineraryDao) {
        this.itineraryDao = itineraryDao;
    }
}

