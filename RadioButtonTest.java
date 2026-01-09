// Creating radio buttons using ButtonGroup and JRadtioButton

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemListener;
import javax.swing.*;

public class RadioButtonTest extends JFrame{
    private JTextField field;
    private Font plainFont, boldFont, italicFont, boldItalicFont;
    private JRadioButton plainButton, boldButton, italicButton, boldItalicButton;
    private ButtonGroup radioGroup;

    // Set up GUI
    public RadioButtonTest(){
        super("RadioButton Test");

        // Get content pane and set its layout
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        
        // Set up JTextField
        field = new JTextField("Watch the font style change", 25);
        container.add(field);

        // Create the radio buttons
        plainButton = new JRadioButton("Plain", true);
        container.add(plainButton);
        
        boldButton = new JRadioButton("Bold", false);
        container.add(boldButton);

        italicButton = new JRadioButton("Italic", false);
        container.add(italicButton);

        
        boldItalicButton = new JRadioButton("Bold/Italic", false);
        container.add(boldItalicButton);

        // Create logical relationship between JRadioButtons
        radioGroup = new ButtonGroup();
        radioGroup.add(plainButton);
        radioGroup.add(boldButton);
        radioGroup.add(italicButton);
        radioGroup.add(boldItalicButton);

        // Create font objects
        plainFont = new Font("Serif", Font.PLAIN, 14);
        boldFont = new Font("Serif", Font.BOLD, 14);
        italicFont = new Font("Serif", Font.ITALIC, 14);
        boldItalicFont = new Font("Serif",  Font.BOLD +  Font.ITALIC, 14);
        field.setFont(plainFont); // Initial font

        // Register events for JRadioButtons
        // TO DO: ASk GPT kung bakit may new sa pag-invoke ng handler method
        plainButton.addItemListener(new RadioButtonHandler(plainFont));
        boldButton.addItemListener(new RadioButtonHandler(boldFont));
        italicButton.addItemListener(new RadioButtonHandler(italicFont));
        boldItalicButton.addItemListener(new RadioButtonHandler(boldItalicFont));

        setSize(300,100);
        setVisible(true);
    }

    // Private inner class to handle radio button events
    private class RadioButtonHandler implements ItemListener{
        private Font font;

        // When user selects JRadioButton, RBH invokes method itemStateChanged of all registered listeners

        public RadioButtonHandler(Font f){
            font = f;
        }

        // Handle radio button events 
        public void itemStateChanged(ItemEvent event){
            field.setFont(font); // Changes the font based on event/user click
        }
    }

    public static void main(String[] args){
        RadioButtonTest application = new RadioButtonTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}