package view;

import control.ItineraryDAO;
import model.Itinerary;
import model.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class AddItineraryFrame extends JFrame {
	@SuppressWarnings("unused")
	private ItineraryDAO itineraryDao;

    public AddItineraryFrame(ItineraryDAO itineraryDao) {
        this.itineraryDao = itineraryDao;

    	//Overrides the default font sizes and styles.
    	Font fontTitle = new Font("sans serif", Font.PLAIN, 30);
    	Font fontButtons = new Font("sans serif", Font.PLAIN, 20);
    	
    	//Declares default window parameters.
    	JFrame frame=new JFrame("Itinerary-CRUD");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,400);
		frame.setLayout(null);  
		frame.setVisible(true);
		frame.setResizable(false);

    	JLabel titlePanel = new JLabel("Add a new Itinerary");
		titlePanel.setBounds(120, 30, 400, 40);
		titlePanel.setFont(fontTitle);

		//Labels each TextField
		JLabel originLabel = new JLabel("from:");
		originLabel.setBounds(30, 65, 200, 40);

		JLabel destinationLabel = new JLabel("to:");
		destinationLabel.setBounds(30, 125, 200, 40);

		JLabel dateLabel = new JLabel("On the day (dd/mm/yyyy):");
		dateLabel.setBounds(270, 65, 200, 40);

		//Creates data fields for instantiating an Itinerary 
		JTextField originField = new JTextField();
		originField.setBounds(30, 90, 200, 40);
		originField.setFont(fontButtons);

		JTextField destinationField = new JTextField();
		destinationField.setBounds(30, 150, 200, 40);
		destinationField.setFont(fontButtons);

		JTextField dateField = new JTextField();
		dateField.setBounds(270, 90, 200, 40);
		dateField.setFont(fontButtons);

		//Draws a Label with a random anime girl at the bottom of the screen.
		JLabel titleLabel = new JLabel();
		titleLabel.setBounds(0, 200, 200, 200);
		RandomImageLabel.setImageIconFromRandomFile(titleLabel, "src/cute_images");

        JButton addButton = new JButton("Add");
        addButton.setBounds(270,150,200,40);
        addButton.setFont(fontButtons);

        JButton backButton = new JButton("Back");
        backButton.setBounds(370,330,100,40);
        backButton.setFont(fontButtons);

        // Add action listeners to the buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Administrator admin = new Administrator(itineraryDao);
            	System.out.println("New Itinerary");
            	String origin = originField.getText();
            	String destination = destinationField.getText();
            	Date date = null;
            	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    date = dateFormat.parse(dateField.getText());
                    System.out.println("Data inserida: " + date);
                    Itinerary itinerary = new Itinerary(origin, destination, date);
                    admin.addItinerary(itinerary);
                    System.out.println("Itinerario adicionado com sucesso.");
                    
                    originField.setText("");
                    destinationField.setText("");
                    dateField.setText("");
                } catch (ParseException exception) {
                	new InvalidDateDialog();
                    System.out.println("Formato de data inválido.");
                    
                    dateField.setText("");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AdminFrame(itineraryDao);
            }
        });

        // Adds components to frame
        frame.add(titlePanel);
		frame.add(titleLabel);

		frame.add(addButton);
		frame.add(backButton);

		frame.add(originField);
		frame.add(destinationField);
		frame.add(dateField);

		frame.add(originLabel);
		frame.add(destinationLabel);
		frame.add(dateLabel);

    }
}