package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import control.ItineraryDAO;
import control.ItineraryDAOImpl;
import model.Itinerary;
import model.Administrator;

import java.util.List;
import java.util.ArrayList;

/**
 * The AddItineraryFrameTest class contains unit tests for the AddItineraryFrame functionality.
 */
class AddItineraryFrameTest {

    @Test
    void test() {
        // Instantiates DAO and Administrator.

        ItineraryDAO itineraryDao = new ItineraryDAOImpl();
        Administrator admin = new Administrator(itineraryDao);

        // Instantiates 3 itineraries, one of them with a wrong date format.

        String origin = "São Paulo";
        String destination = "Porto Alegre";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse("13/05/2023");
        } catch (ParseException e) {
            date = null; // Set the date to null if an exception occurs
        }
        Itinerary itinerary = new Itinerary(origin, destination, date);
        admin.addItinerary(itinerary);

        String origin1 = "Cuiabá";
        String destination1 = "Recife";
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = null;
        try {
            date1 = dateFormat1.parse("10/03/2022");
        } catch (ParseException e) {
            date1 = null; // Set the date to null if an exception occurs
        }
        Itinerary itinerary1 = new Itinerary(origin1, destination1, date1);
        admin.addItinerary(itinerary1);

        String origin11 = "Rio de Janeiro";
        String destination11 = "Belo Horizonte";
        SimpleDateFormat dateFormat11 = new SimpleDateFormat("dd/MM/yyyy");
        Date date11 = null;
        try {
            date11 = dateFormat11.parse("103/2025");
        } catch (ParseException e) {
            date11 = null; // Set the date to null if an exception occurs
        }
        Itinerary itinerary11 = new Itinerary(origin11, destination11, date11);
        admin.addItinerary(itinerary11);

        // Creates a new ArrayList containing only variables previously known to be correct
        List<Itinerary> itinerariesLocal = new ArrayList<>();
        itinerariesLocal.add(itinerary);
        itinerariesLocal.add(itinerary1);

        // Gets the generated ArrayList made with DAO methods
        List<Itinerary> itinerariesDao = admin.getAllItinerary();

        // Compares the ArrayLists. The test should succeed if the DAO methods are robust enough
        assertEquals(itinerariesLocal, itinerariesDao);
    }
}
