package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ItineraryDAO;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
    @SuppressWarnings("unused")
	private ItineraryDAO itineraryDao;

    /**
     * Constructs a new instance of the MainFrame class.
     *
     * @param itineraryDao The ItineraryDAO instance used for data access.
     */
    public MainFrame(ItineraryDAO itineraryDao) {
        this.itineraryDao = itineraryDao;

        // Overrides the default font sizes and styles.
        Font fontTitle = new Font("sans serif", Font.PLAIN, 30);
        Font fontButtons = new Font("sans serif", Font.PLAIN, 20);

        // Declares default window parameters.
        JFrame frame = new JFrame("Itinerary-CRUD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

        JLabel panelTitle = new JLabel("Are you a User or Admin?");
        panelTitle.setBounds(70, 30, 400, 40);
        panelTitle.setFont(fontTitle);

        // Draws a Label with a random anime girl at the bottom of the screen.
        JLabel label = new JLabel();
        label.setBounds(0, 200, 200, 200);
        RandomImageLabel.setImageIconFromRandomFile(label, "src/cute_images");

        JButton adminButton = new JButton("Admin");
        adminButton.setBounds(30, 120, 200, 50);
        adminButton.setFont(fontButtons);

        JButton userButton = new JButton("User");
        userButton.setBounds(270, 120, 200, 50);
        userButton.setFont(fontButtons);

        // Add action listeners to the buttons
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AdminFrame(itineraryDao);
            }
        });

        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new UserFrame(itineraryDao);
            }
        });

        // Adds components to frame
        frame.add(panelTitle);
        frame.add(label);
        frame.add(adminButton);
        frame.add(userButton);
    }
}
