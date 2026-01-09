// Creating JCheckBox Buttons
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxTest extends JFrame{
    private JComboBox imagesComboBox;
    private JLabel label;

    private String names[] = {
        "chicken.png", "junimo.png", "stardrop.png"
    };

    private Icon icons[] = { 
        new ImageIcon(names[0]),
        new ImageIcon(names[1]),
        new ImageIcon(names[2]),
    };

    // Set up GUI
    public ComboBoxTest(){
        super("JComboBox Testing");

        // Get content pane and set up layout
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        // Set up JComboBox
        // Instatiate JComboBox to show the strinsg from names array
        imagesComboBox = new JComboBox(names); 
        imagesComboBox.setMaximumRowCount(2);

        // Register to receive events from anon ItemListener
        imagesComboBox.addItemListener(
            // Anon inner class (hindi na naka-separate since isa lang naman)
            new ItemListener(){
                // Handle JCombo event
                public void itemStateChanged(ItemEvent event){
                    // Determine whether checkbox selected
                    if(event.getStateChange() == ItemEvent.SELECTED){
                        label.setIcon(icons[imagesComboBox.getSelectedIndex()]);
                    }
                }
            }
        );

        container.add(imagesComboBox);

        // Set up  Jlabel to display the ImageIcons
        label = new JLabel(icons[0]);
        container.add(label);

        setSize(350,100);
        setVisible(true);
    }

    public static void main(String args[]){
        ComboBoxTest application = new ComboBoxTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}