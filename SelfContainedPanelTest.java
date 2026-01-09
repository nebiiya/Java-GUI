import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelfContainedPanelTest extends JFrame{
    private SelfContainedPanel myPanel;

    // GUI
    public SelfContainedPanelTest(){
        super("SelfContainedPanel Test");

        myPanel = new SelfContainedPanel();
        myPanel.setBackground(Color.YELLOW);

        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        container.add(myPanel);

        // Add mouse motion event handling
        addMouseMotionListener(
            new MouseMotionListener(){
                // Handles mouse drag event
                public void mouseDragged(MouseEvent event){
                    setTitle("Dragging: x= " + event.getX() + ",y = " + event.getY());
                }
                // Handles mouse move event
                public void mouseMoved(MouseEvent event){
                    setTitle("Moving: x= " + event.getX() + ",y= " + event.getY());
                }
            }
        );

        setSize(300, 150);
        setVisible(true);
    }

    public static void main(String[] args){
        SelfContainedPanelTest application = new SelfContainedPanelTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}