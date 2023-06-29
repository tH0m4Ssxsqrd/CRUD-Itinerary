package view;

import javax.swing.*;

import control.ItineraryDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AdminFrame extends JFrame {
	@SuppressWarnings("unused")
	private ItineraryDAO itineraryDao;
	private boolean isAdmin = true;
	
    public AdminFrame(ItineraryDAO itineraryDao) {

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
		
		JLabel panelTitle = new JLabel("What would you like to do?");
		panelTitle.setBounds(70, 30, 400, 40);
		panelTitle.setFont(fontTitle);
		
		JLabel cuteLabel = new JLabel();
		cuteLabel.setBounds(0, 200, 200, 200);
		RandomImageLabel.setImageIconFromRandomFile(cuteLabel, "src/cute_images");
        
        JButton addButton = new JButton("Add Itinerary");
        addButton.setBounds(30,90,200,40);
        addButton.setFont(fontButtons);
        
        JButton updateButton = new JButton("Update Itinerary");
        updateButton.setBounds(270,90,200,40);
        updateButton.setFont(fontButtons);
        
        JButton removeButton = new JButton("Remove Itinerary");
        removeButton.setBounds(30,150,200,40);
        removeButton.setFont(fontButtons);
        
        JButton queryButton = new JButton("Query all");
        queryButton.setBounds(270,150,200,40);
        queryButton.setFont(fontButtons);
        
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(270,210,200,40);
        searchButton.setFont(fontButtons);
        
        JButton backButton = new JButton("Back");
        backButton.setBounds(370,330,100,40);
        backButton.setFont(fontButtons);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
                new AddItineraryFrame(itineraryDao);
            }
        });
        
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
                new UpdateItineraryFrame(itineraryDao);
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
                new DeleteItineraryFrame(itineraryDao);
            }
        });
        
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
                new QueryItineraryFrame(itineraryDao, isAdmin);
            }
        });
        
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
                new SearchItineraryFrame(itineraryDao, isAdmin);
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainFrame(itineraryDao);
            }
        });
        frame.add(backButton);
        frame.add(addButton);
        frame.add(updateButton);
        frame.add(removeButton);
        frame.add(queryButton);
        frame.add(searchButton);
        
        frame.add(panelTitle);
        frame.add(cuteLabel);
    }
}
