package view;

import control.ItineraryDAO;
import control.ItineraryDAOImpl;

/**
 * The main entry point of the application.
 */
public class Program {
    /**
     * The main method that starts the application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create the itinerary DAO
        ItineraryDAO itineraryDao = new ItineraryDAOImpl();

        // Create and display the main frame of the application
        new MainFrame(itineraryDao);
    }
}
