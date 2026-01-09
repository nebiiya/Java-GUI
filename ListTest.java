// Selecting colors from a JList

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListTest extends JFrame{
    private JList colorList;
    private Container container;

    private final String colorNames[] = {
        "Black", "Blue", "Cyan", "Dark Gray", "Green", 
        "Light Gray", "Magenta", "Orange", "Pink", "Red",
        "White", "Yellow"
    };

    private final Color colors[] ={
        Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GREEN,
        Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED,
        Color.WHITE, Color.YELLOW
    };

    // Set up GUI
    public ListTest(){
        super("JList Test");

        // Get content pane and set layout
        container = getContentPane();
        container.setLayout(new FlowLayout());

        // Create a list with items inn colorNames array 
        // Use colorNames array to populate JList
        colorList = new JList(colorNames);
        colorList.setVisibleRowCount(5); // Kung ilan ung initial na makikita

        // Don't allow multiple selections 
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add a JScrollPane containing JList to content pane
        container.add(new JScrollPane(colorList)); 
        
        // Register JList to receive events from anonymous ListSelectionListener
        colorList.addListSelectionListener(
            // Anon inner class 
            new ListSelectionListener(){
                // Handle list selection events
                public void valueChanged (ListSelectionEvent event){
                    container.setBackground(
                        colors[colorList.getSelectedIndex()]
                    );
                }
            }
        );

        setSize(350, 150);
        setVisible(true);
    }

    public static void main(String args[]){
        ListTest application = new ListTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}