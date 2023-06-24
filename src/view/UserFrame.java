package view;

import javax.swing.*;

import control.ItineraryDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class UserFrame extends JFrame {
	@SuppressWarnings("unused")
	private ItineraryDAO itineraryDao;
	
    public UserFrame(ItineraryDAO itineraryDao) {
        setTitle("User Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a button
        JButton userButton = new JButton("I'm a User");
        
        // Add an action listener to the button
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("I'm a User");
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
        panel.add(userButton);
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
