import javax.swing.*;
import java.awt.Image;
import java.awt.BorderLayout;

public class PixelArtFrame{

    public static void main(String[] args){
        // Load and resize png
        ImageIcon icon = new ImageIcon("20x20-junimo-bg.png");

        Image scaledImage = icon.getImage().getScaledInstance(
            120, 120, java.awt.Image.SCALE_SMOOTH // keep pixel-art crisp
        );
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledIcon);

        // Ad a margin around the image
        imageLabel.setBorder(BorderFactory.createEmptyBorder(10,20,10,10));

        // Description
        JLabel textLabel = new JLabel("<html>" + 
            "Junimo Art<br>" +
            "This is a 20x20 PNG<br>" + 
            "Inserted using ImageIcon<br>" + 
            "Resized inside JOptionPane<br>" + 
            "</html>"
        );

        // Add a spacing around the text
        textLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));

        // Panel for layout
        JPanel panel = new JPanel(new BorderLayout(15,0));
        panel.add(textLabel, BorderLayout.WEST);
        panel.add(imageLabel, BorderLayout.EAST);
        
        // Show in message dialog
        JOptionPane.showMessageDialog(
            null, 
            panel, 
            "Pixel Art Viewer", // title of the frame
            JOptionPane.PLAIN_MESSAGE
        );
    }

}