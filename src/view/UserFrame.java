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
    private boolean isAdmin = false;

    /**
     * Constructs a new instance of the UserFrame class.
     *
     * @param itineraryDao The ItineraryDAO instance used for data access.
     */
    public UserFrame(ItineraryDAO itineraryDao) {
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

        JLabel panelTitle = new JLabel("What would you like to do?");
        panelTitle.setBounds(70, 30, 400, 40);
        panelTitle.setFont(fontTitle);

        JLabel cuteLabel = new JLabel();
        cuteLabel.setBounds(0, 200, 200, 200);
        RandomImageLabel.setImageIconFromRandomFile(cuteLabel, "src/cute_images");

        JButton listButton = new JButton("List all Itineraries");
        listButton.setBounds(30, 90, 200, 40);
        listButton.setFont(fontButtons);

        JButton searchButton = new JButton("Search by date");
        searchButton.setBounds(270, 90, 200, 40);
        searchButton.setFont(fontButtons);

        JButton backButton = new JButton("Back");
        backButton.setBounds(370, 330, 100, 40);
        backButton.setFont(fontButtons);

        listButton.addActionListener(new ActionListener() {
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

        // Adds components to frame
        frame.add(backButton);
        frame.add(listButton);
        frame.add(searchButton);
        frame.add(panelTitle);
        frame.add(cuteLabel);
    }
}
