package model;

import java.util.Date;

/**
 * Represents an itinerary with origin, destination, and date information.
 */
public class Itinerary {
    private String origin;
    private String destination;
    private Date date;

    /**
     * Constructs a new Itinerary instance with the specified origin, destination, and date.
     *
     * @param origin      The origin of the itinerary.
     * @param destination The destination of the itinerary.
     * @param date        The date of the itinerary.
     */
    public Itinerary(String origin, String destination, Date date) {
        this.origin = origin;
        this.destination = destination;
        this.date = date;
    }

    /**
     * Retrieves the origin of the itinerary.
     *
     * @return The origin of the itinerary.
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the origin of the itinerary.
     *
     * @param origin The origin of the itinerary to be set.
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Retrieves the destination of the itinerary.
     *
     * @return The destination of the itinerary.
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the destination of the itinerary.
     *
     * @param destination The destination of the itinerary to be set.
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Retrieves the date of the itinerary.
     *
     * @return The date of the itinerary.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the itinerary.
     *
     * @param date The date of the itinerary to be set.
     */
    public void setDate(Date date) {
        this.date = date;
    }
}

