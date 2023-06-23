package model;

import java.util.Date;

public class Itinerary {
	private String origin;
    private String destination;
    private Date date;
    
	public Itinerary(String origin, String destination, Date date) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.date = date;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

    
}
