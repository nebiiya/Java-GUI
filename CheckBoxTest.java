// Creating JCheckBox butons

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxTest extends JFrame{
    private JTextField field;
    private JCheckBox bold, italic;

    // Set up GUI
    public CheckBoxTest(){
        super("JCheckBox Test");

        // Get content pane and set its layout
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        // Set up JTextField and set its font
        field = new JTextField("Watch the font style change", 20);
        field.setFont(new Font("Serif", Font.PLAIN, 14));
        container.add(field);

        // Create checkbox objects
        bold = new JCheckBox("Bold");
        container.add(bold);

        italic = new JCheckBox("Italic");
        container.add(italic);

        // Register listeners for JCheckBoxes
        CheckBoxHandler  handler = new CheckBoxHandler();
        bold.addItemListener(handler);
        italic.addItemListener(handler);

        setSize(275, 200);
        setVisible(true);
    }

    public static void main(String[] args){
        CheckBoxTest application = new CheckBoxTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Private inner class for ItemListener event handling
    private class CheckBoxHandler implements ItemListener{
        private int valBold = Font.PLAIN;
        private int valItalic = Font.PLAIN;

        // When user selects JCheckBox, it invokes this method of all registered listeners
        // Respond to checkbox events
        public void itemStateChanged(ItemEvent event){

            // Process bold checkbox events
            if(event.getSource() == bold){
                valBold = bold.isSelected()? Font.BOLD : Font.PLAIN;
            }

            // Process italic checkbox events
            if(event.getSource() == italic){
                valItalic = italic.isSelected() ? Font.ITALIC : Font.PLAIN;
            }

            // Set text field font
            field.setFont(new Font("Serif", valBold + valItalic, 14)); // Change the JTextField font depending on which checkbox was selected
        }
    }
}