package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The InvalidDateDialog class represents a dialog box that displays an invalid date format message.
 */
public class InvalidDateDialog {
    private static JDialog dialog;

    /**
     * Creates a new instance of InvalidDateDialog and displays the dialog box.
     */
    InvalidDateDialog() {
        Font fontButtons = new Font("sans serif", Font.PLAIN, 20);
        JFrame frame = new JFrame();
        dialog = new JDialog(frame, "Itinerary-CRUD", true);
        dialog.setLayout(new FlowLayout());
        JLabel label = new JLabel("Invalid date format.");
        label.setFont(fontButtons);
        JButton button = new JButton("OK");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InvalidDateDialog.dialog.dispose();
            }
        });
        dialog.add(label);
        dialog.add(button);
        dialog.setSize(300, 100);
        dialog.setVisible(true);
    }

    /**
     * The main method to run the InvalidDateDialog as a standalone application.
     *
     * @param args the command-line arguments
     */
    public static void main(String args[]) {
        new InvalidDateDialog();
    }
}
