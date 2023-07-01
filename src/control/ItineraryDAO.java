package control;

import java.util.Date;
import java.util.List;

import model.Itinerary;

/**
 * Interface for managing the storage and retrieval of itineraries.
 */
public interface ItineraryDAO {

    /**
     * Adds an itinerary to the storage.
     *
     * @param itinerary The itinerary to be added.
     */
    void addItinerary(Itinerary itinerary);

    /**
     * Updates an existing itinerary with the provided itinerary's information.
     *
     * @param itinerary The updated itinerary.
     */
    void updateItinerary(Itinerary itinerary);

    /**
     * Deletes the itinerary with the specified date from the storage.
     *
     * @param date The date of the itinerary to be deleted.
     */
    void deleteItinerary(Date date);

    /**
     * Retrieves all the itineraries stored.
     *
     * @return A list containing all the itineraries.
     */
    List<Itinerary> getAllItinerary();

    /**
     * Retrieves the itinerary with the specified date from the storage.
     *
     * @param date The date of the itinerary to retrieve.
     * @return The itinerary with the specified date, or null if not found.
     */
    Itinerary getItineraryByDate(Date date);
}
