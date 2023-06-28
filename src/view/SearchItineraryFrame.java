package view;

import control.ItineraryDAO;
import model.Administrator;
import model.User;
import model.Itinerary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class SearchItineraryFrame extends JFrame {
	@SuppressWarnings("unused")
	private ItineraryDAO itineraryDao;
	@SuppressWarnings("unused")
	private boolean isAdmin;
	
    public SearchItineraryFrame(ItineraryDAO itineraryDao, boolean isAdmin) {
        this.itineraryDao = itineraryDao;
        this.isAdmin = isAdmin;

    	//Overrides the default font sizes and styles.
    	Font fontTitle = new Font("sans serif", Font.PLAIN, 30);
    	Font fontButtons = new Font("sans serif", Font.PLAIN, 20);
    	
    	//Declares default window parameters.
    	JFrame frame=new JFrame("Itinerary-CRUD");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(625,500);
		frame.setLayout(null);  
		frame.setVisible(true);
		frame.setResizable(false);

    	JLabel panelTitle = new JLabel("Search Itinerary by date");
		panelTitle.setBounds(180, 30, 400, 40);
		panelTitle.setFont(fontTitle);

		//Labels each TextField
		JLabel itineraryLabel = new JLabel("Itineraries in the form origin/destination/date");
		itineraryLabel.setBounds(30, 65, 300, 40);
		
		JLabel dateLabel = new JLabel("Enter date to be searched:");
		dateLabel.setBounds(385,355,200,40);

		//Creates data fields for searching and displaying an Itinerary 
		JTextArea textArea = new JTextArea();
		textArea.setBounds(30, 90, 565, 200);
		textArea.setFont(fontButtons);
		
		JTextField textField = new JTextField();
		textField.setBounds(385, 380, 220, 40);
		textField.setFont(fontButtons);

		//Draws a Label with a random anime girl at the bottom of the screen.
		JLabel cuteLabel = new JLabel();
		cuteLabel.setBounds(0, 300, 200, 200);
		RandomImageLabel.setImageIconFromRandomFile(cuteLabel, "src/cute_images");

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(385,440,100,40);
        searchButton.setFont(fontButtons);

        JButton backButton = new JButton("Back");
        backButton.setBounds(505,440,100,40);
        backButton.setFont(fontButtons);

        // Add action listeners to the buttons
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	if (isAdmin) {
            	Administrator admin = new Administrator(itineraryDao);
            	
            	for (Itinerary itinerary : admin.getAllItinerary()) {
            	    String output = itinerary.getOrigin() + ", " + itinerary.getDestination() + " in " + itinerary.getDate();
            	    textArea.append(output + "\n");}
            	} else {
            	User user =  new User(itineraryDao);
            	
            	for (Itinerary itinerary : user.getAllItinerary()) {
            	    String output = itinerary.getOrigin() + ", " + itinerary.getDestination() + " in " + itinerary.getDate();
            	    textArea.append(output + "\n");}
            	}
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isAdmin) {
                	frame.dispose();
                	new AdminFrame(itineraryDao);
                } else {
                	frame.dispose();
                	new UserFrame(itineraryDao);
                }
            }
        });

        // Adds components to frame
        frame.add(panelTitle);
		frame.add(cuteLabel);
		
		frame.add(searchButton);
		frame.add(backButton);
		
		frame.add(textArea);
		frame.add(textField);
		
		frame.add(itineraryLabel);
		frame.add(dateLabel);

    }
}
