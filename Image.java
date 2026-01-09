import javax.swing.*;

public class Image{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Image in Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       ImageIcon icon = new ImageIcon("20x20-chicken-bg.png");
       JLabel label = new JLabel(icon);  // JLabel can hold images!
       
       frame.add(label);
       frame.pack(); // Automatically size the window to fit the image
       frame.setLocationRelativeTo(null); // Center on screen
       frame.setVisible(true);
    }
}