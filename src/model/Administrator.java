package model;

import java.util.Date;

import control.ItineraryDAO;

/**
 * Represents an administrator user who can perform itinerary management operations.
 */
public class Administrator extends User {

    /**
     * Constructs a new Administrator instance with the specified itinerary DAO.
     *
     * @param itineraryDao The itinerary DAO implementation to be used for data access.
     */
    public Administrator(ItineraryDAO itineraryDao) {
        super(itineraryDao);
    }

    /**
     * Adds an itinerary using the underlying itinerary DAO.
     *
     * @param itinerary The itinerary to be added.
     */
    public void addItinerary(Itinerary itinerary) {
        getItineraryDao().addItinerary(itinerary);
    }

    /**
     * Updates an existing itinerary using the underlying itinerary DAO.
     *
     * @param itinerary The updated itinerary.
     */
    public void updateItinerary(Itinerary itinerary) {
        getItineraryDao().updateItinerary(itinerary);
    }

    /**
     * Deletes an itinerary with the specified date using the underlying itinerary DAO.
     *
     * @param date The date of the itinerary to be deleted.
     */
    public void deleteItinerary(Date date) {
        getItineraryDao().deleteItinerary(date);
    }
}
