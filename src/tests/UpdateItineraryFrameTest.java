package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import java.util.Date;



import java.text.ParseException;
import java.text.SimpleDateFormat;

import control.ItineraryDAOImpl;
import model.Itinerary;
import model.Administrator;


public class UpdateItineraryFrameTest {
    private Administrator admin;

    @Before
    public void setUp() {
        ItineraryDAOImpl itineraryDao = new ItineraryDAOImpl();
        admin = new Administrator(itineraryDao);
    }

    @Test
    public void test() {
        // Instantiates 2 valid itineraries, two of them being on the same date.
        // It is expected that if two itineraries are instantiated on the same date,
        // the user wants to edit the older ones first.

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date sharedDate = null;
        try {
            sharedDate = dateFormat.parse("13/05/2023");
        } catch (ParseException e) {
            sharedDate = null;
        }

        Itinerary itinerary1 = new Itinerary("Origin 1", "Destination 1", sharedDate);
        Itinerary itinerary2 = new Itinerary("Origin 2", "Destination 2", sharedDate);

        admin.addItinerary(itinerary1);
        admin.addItinerary(itinerary2);

        // Performs an update operation on the repeated date.
        Itinerary updatedItinerary = new Itinerary("Updated Origin", "Updated Destination", sharedDate);

        admin.updateItinerary(updatedItinerary);

        // Verifies that the first matching itinerary was changed.
        Itinerary firstMatchingItinerary = admin.getItineraryByDate(sharedDate);
        assertEquals(updatedItinerary.getOrigin(), firstMatchingItinerary.getOrigin());
        assertEquals(updatedItinerary.getDestination(), firstMatchingItinerary.getDestination());

        // Verifies that the first matching itinerary remained unchanged.
        Itinerary secondMatchingItinerary = admin.getAllItinerary().get(1);
        assertEquals(itinerary2.getOrigin(), secondMatchingItinerary.getOrigin());
        assertEquals(itinerary2.getDestination(), secondMatchingItinerary.getDestination());
    }
}