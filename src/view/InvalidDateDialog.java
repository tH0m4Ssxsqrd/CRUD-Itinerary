package view;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
public class InvalidDateDialog {  
    private static JDialog dialog;  
    InvalidDateDialog() {
    	Font fontButtons = new Font("sans serif", Font.PLAIN, 20);
        JFrame frame= new JFrame();  
        dialog = new JDialog(frame , "Itinerary-CRUD", true);  
        dialog.setLayout( new FlowLayout() );  
        JLabel label = new JLabel("Invalid date format.");
        label.setFont(fontButtons);
        JButton button = new JButton ("OK");  
        button.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
                InvalidDateDialog.dialog.dispose();
            }  
        });  
        dialog.add(label);  
        dialog.add(button);   
        dialog.setSize(300,100);    
        dialog.setVisible(true);  
    }  
    public static void main(String args[])  
    {  
        new InvalidDateDialog();  
    }  
}