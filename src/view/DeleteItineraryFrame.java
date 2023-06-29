package view;

import control.ItineraryDAO;
import model.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class DeleteItineraryFrame extends JFrame {
	@SuppressWarnings("unused")
	private ItineraryDAO itineraryDao;

    public DeleteItineraryFrame(ItineraryDAO itineraryDao) {
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

    	JLabel panelTitle = new JLabel("Delete Itinerary");
		panelTitle.setBounds(120, 30, 400, 40);
		panelTitle.setFont(fontTitle);

		//Labels each TextField
		JLabel dateLabel = new JLabel("Delete Itinerary on (dd/mm/yyyy):");
		dateLabel.setBounds(30, 65, 250, 40);

		//Creates data fields for instantiating an Itinerary 
		JTextField dateField = new JTextField();
		dateField.setBounds(30, 90, 200, 40);
		dateField.setFont(fontButtons);

		//Draws a Label with a random anime girl at the bottom of the screen.
		JLabel titleLabel = new JLabel();
		titleLabel.setBounds(0, 200, 200, 200);
		RandomImageLabel.setImageIconFromRandomFile(titleLabel, "src/cute_images");

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(270,90,200,40);
        deleteButton.setFont(fontButtons);

        JButton backButton = new JButton("Back");
        backButton.setBounds(370,330,100,40);
        backButton.setFont(fontButtons);

        // Add action listeners to the buttons
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Administrator admin = new Administrator(itineraryDao);
            	Date date = null;
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    date = dateFormat.parse(dateField.getText());
                    System.out.println("Date inserted: " + date);
                    admin.deleteItinerary(date);
                    System.out.println("Itinerario adicionado com sucesso.");

                    dateField.setText("");
                } catch (ParseException exeption) {
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
        frame.add(panelTitle);
		frame.add(titleLabel);
		
		frame.add(deleteButton);
		frame.add(backButton);
		
		frame.add(dateField);
		
		frame.add(dateLabel);

    }
}
