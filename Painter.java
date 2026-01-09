// Using class MouseMotionAdapter

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Painter extends JFrame{
    private int pointCount = 0;

    // Array of 1000 java.awt.Point references
    private Point points[] = new Point[1000];

    // Set up GUI
    public Painter(){
        super("A simple paint program");

        // Create a labela and place it in SOUTH of BorderLayout
        getContentPane().add(new JLabel("Drag the mouse to draw"), BorderLayout.SOUTH);
        
        // Register MouseMotionListener to listen for window's mouse-motion events
        addMouseMotionListener(
             // Anon inner class
            new MouseMotionAdapter(){
                // Store drag coordinates and repaint
                // Ovveride method mouseDragged but not method mouseMoved
                public void mouseDragged(MouseEvent event){
                    if(pointCount < points.length){
                        // Stores coordinates where mouse was dragged, then repaint JFrame
                        points[pointCount] = event.getPoint();
                        ++pointCount;
                        repaint();
                    }
                }
            }
        );

        setSize(300, 150);
        setVisible(true);
    }

    // Draw oval in a 4-by-4 bounding box at specified location on window
    public void paint(Graphics g){
        // Draw circle of diametre 4 where user dragged cursor
        super.paint(g); // Clears drawing area
        for(int i = 0; i < points.length && points[i] != null; i++){
            g.fillOval(points[i].x, points[i].y, 4,4);
        }
    }
    public static void main(String args[]){
        Painter application = new Painter();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}