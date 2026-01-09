import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

class MyDrawPanel extends JPanel{
    private int x = -100, y= -100; // State coordinates.

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.orange);
        g.fillRect(x,y,100,100);
    }

    // Set up GUI
    public MyDrawPanel(){
        addMouseListener(
            // Anon inner class
            new MouseAdapter() {
                public void mousePressed(MouseEvent event){
                    x = event.getX();
                    y = event.getY();
                    repaint();                
                }
            }
        );
    }

    public static void main(String[] args){
        // Since I extended JPanel, create Frame in main
        JFrame frame = new JFrame("Drawing");
        MyDrawPanel panel = new MyDrawPanel();
        
        frame.add(panel);
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
