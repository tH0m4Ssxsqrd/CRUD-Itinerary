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

    public AdminFrame(ItineraryDAO itineraryDao) {
        this.itineraryDao = itineraryDao;
        
        setTitle("Admin Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a button
        JButton adminButton = new JButton("Add Itinerary");
        
        // Add an action listener to the button
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UpdateItineraryFrame(itineraryDao);
            }
        });
        
     // Create a button to go back to the MainFrame
        JButton backButton = new JButton("Back to Main");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainFrame(itineraryDao);
            }
        });
        
        // Create a panel to hold the button
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(adminButton);
        panel.add(backButton);
        
        // Add the panel to the frame
        getContentPane().add(panel);
        
        // Set the frame size to 600x500 pixels
        setSize(600, 500);
        setResizable(false); // Prevent resizing
        setLocationRelativeTo(null);
        
        // Make the frame visible
        setVisible(true);
    }
}

