package view;

import control.ItineraryDAO;
import control.ItineraryDAOImpl;

public class Program {
	public String phrase = "abcd";
	public static void main(String[] args) {
		ItineraryDAO itineraryDao = new ItineraryDAOImpl();
		new MainFrame(itineraryDao);
	}

}
