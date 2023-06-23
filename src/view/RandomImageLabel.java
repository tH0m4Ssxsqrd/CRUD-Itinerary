package view;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class RandomImageLabel {
    public static void setImageIconFromRandomFile(JLabel label, String folderPath) {
        // Get a list of image files in the folder
    	
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png") || name.toLowerCase().endsWith(".jpg"));

        // Return if no image files are found in the folder
        
        if (files == null || files.length == 0) {
            System.out.println("No image files found in the folder.");
            return;
        }

        // Select a random image file
        
        int randomNum = ThreadLocalRandom.current().nextInt(0, files.length);
        File randomFile = files[randomNum];

        ImageIcon originalIcon = new ImageIcon(randomFile.getAbsolutePath());
        
        // Scale Icon to button size
        
        double widthScale = (double) label.getWidth() / originalIcon.getIconWidth();
        double heightScale = (double) label.getHeight() / originalIcon.getIconHeight();
        
        double scale = Math.min(widthScale, heightScale);
        int scaledWidth = (int) (originalIcon.getIconWidth() * scale);
        int scaledHeight = (int) (originalIcon.getIconHeight() * scale);
        
        Image scaledImage = originalIcon.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        // Set label icon to scaled image
        
        label.setIcon(scaledIcon);
    }
}
