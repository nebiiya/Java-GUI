// Self-contained JPanel class handling own mouse events
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelfContainedPanel extends JPanel{
    private int x1, x2, y1, y2;

    public SelfContainedPanel(){
        // Set up mouse event handling
        addMouseListener(
            // Anon inner class
            new MouseAdapter(){ 
                // Handles mouse pressed
                public void mousePressed(MouseEvent event){
                    x1 = event.getX();
                    y1 = event.getY();
                }
                // Handles mouse release
                public void mouseReleased(MouseEvent event){
                    x2 = event.getX();
                    y2 = event.getY();
                }
            }
        );

        // Set up mouse motion listener
        addMouseMotionListener(
            new MouseAdapter(){
                public void mouseDragged(MouseEvent event){
                    x2 = event.getX();
                    y2 = event.getY();
                    repaint();
                }
            }
        );
    }

     // Return preffered width and heght of Self contained panel
    public Dimension getPreferredSize(){
        return new Dimension(150,100);
    }

    // Pain oval at specified coordinates
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
    }
}