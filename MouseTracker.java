// Demonstrating mouse events

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseTracker extends JFrame implements MouseListener, MouseMotionListener{
    private JLabel statusBar;

    // Set up GUI
    public MouseTracker(){
        super("Demonstrating Mouse Events");

        statusBar = new JLabel();
        getContentPane().add(statusBar, BorderLayout.SOUTH);

        // Register JFrame to receive mouse events
        addMouseListener(this); // listens for own mouse and
        addMouseMotionListener(this); // mouse-motion events
        
        setSize(275, 100);
        setVisible(true);
    }

    // ---- MouseListener event handlers ---- 
    // Handle event when mouse released immediately after press
    // Invoked when user presses and releases mouse button
    public void mouseClicked(MouseEvent event){
        statusBar.setText("Clicked at [" + event.getX() + "," + event.getY() + "]");
    }
    // Handle event when mouse is pressed
    // Invoked when user pressed mouse button
    public void mousePressed(MouseEvent event){
        statusBar.setText("Pressed at [" + event.getX() + "," + event.getY() + "]");
    }
    // Handle event when mouse is released AFTER DRAGGING
    // Invoked when user released mouse button
    public void mouseReleased(MouseEvent event){
        statusBar.setText("Released at [" + event.getX() + "," + event.getY() + "]");
    }
    // Handle event when mouse enter an area
    // Invoked when mouse cursor enters JFrame
    public void mouseEntered(MouseEvent event){
        statusBar.setText("Mouse entered at [" + event.getX() + "," + event.getY() + "]");
        getContentPane().setBackground(Color.GREEN);
    }

    // Handle event when mouse exits area
    // Inboked when mouse cursor exits JFrame
    public void mouseExited(MouseEvent event){
        statusBar.setText("Mouse outside window");
        getContentPane().setBackground(Color.WHITE);
    }

    // ---- MouseMotionListener event handlers ----
    // Handle event when user drags mouse with button pressed 
    // Invoked when user drags mouse cursor
    public void mouseDragged(MouseEvent event){
        statusBar.setText("Dragged at [" + event.getX() + "," + event.getY() + "]");
    }
    // Handle evenr when user moves mouse
    // Invoked when user moves mouse cursor
    public void mouseMoved(MouseEvent event){
        statusBar.setText("Moved at [" + event.getX() + "," + event.getY() + "]");
    }

    public static void main(String args[]){
        MouseTracker application = new MouseTracker();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
