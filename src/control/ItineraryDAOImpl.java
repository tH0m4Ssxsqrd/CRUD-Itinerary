package control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Itinerary;

/**
 * Implementation of the {@link ItineraryDAO} interface that manages the storage and retrieval
 * of itineraries in an in-memory list.
 */
public class ItineraryDAOImpl implements ItineraryDAO {

    /**
     * List to store the itineraries.
     */
    private List<Itinerary> itineraries = new ArrayList<>();

    /**
     * Adds an itinerary to the list if the itinerary's date is not null.
     *
     * @param itinerary The itinerary to be added.
     */
    @Override
    public void addItinerary(Itinerary itinerary) {
        if (itinerary.getDate() != null) {
            itineraries.add(itinerary);
        }
    }

    /**
     * Updates an existing itinerary with the provided itinerary's information.
     * The existing itinerary is identified by its date.
     *
     * @param itinerary The updated itinerary.
     */
    @Override
    public void updateItinerary(Itinerary itinerary) {
        Itinerary existingItinerary = getItineraryByDate(itinerary.getDate());
        if (existingItinerary != null) {
            existingItinerary.setOrigin(itinerary.getOrigin());
            existingItinerary.setDestination(itinerary.getDestination());
        }
    }

    /**
     * Deletes the itinerary with the specified date from the list.
     *
     * @param date The date of the itinerary to be deleted.
     */
    @Override
    public void deleteItinerary(Date date) {
        Itinerary existingItinerary = getItineraryByDate(date);
        if (existingItinerary != null) {
            itineraries.remove(existingItinerary);
        }
    }

    /**
     * Retrieves all the itineraries stored in the list.
     *
     * @return A list containing all the itineraries.
     */
    @Override
    public List<Itinerary> getAllItinerary() {
        return itineraries;
    }

    /**
     * Retrieves the itinerary with the specified date from the list.
     *
     * @param date The date of the itinerary to retrieve.
     * @return The itinerary with the specified date, or null if not found.
     */
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
