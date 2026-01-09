// Customized JPanel Class

import java.awt.*;
import javax.swing.*;

public class OvalPanel extends JPanel{
    private int diameter = 10;

    // Draw an oval of the diameter
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.fillOval(10,10, diameter, diameter);
    }

    // Validate and set diameter, then repaint
    public void setDiameter(int newDiameter){
        // If invalid, default to 10
        diameter = (newDiameter >= 0? newDiameter : 10);
        repaint();
    }

    // Used by layoutmanager to determine the preferred size
    public Dimension getPreferredSize(){
       return new Dimension(200,200);
    }
}