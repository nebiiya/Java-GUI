// Demonstrating the JTextField class

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class TextFieldTest extends JFrame{
    private JTextField textField1, textField2, textField3;
    private JPasswordField passwordField;

    // Set up GUI
    public TextFieldTest(){
        super("TestingJTextField and JPasswordField");

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        // Construct textfield with default sizing
        textField1 = new JTextField(10); // Contains empty string
        container.add(textField1);

        // Construct textfield with default text
        textField2 = new JTextField("Enter text here: ");
        container.add(textField2);

        // Construct textfield with default text, 20 visible elements and no event handler
        textField3 = new JTextField("Uneditable text field", 20);
        textField3.setEditable(false);
        container.add(textField3);

        // Construct password field with default text
        passwordField = new JPasswordField("Hidden text"); // Contains this text but appears a series of *
        container.add(passwordField);

        // Register event handlers
        TextFieldHandler  handler = new TextFieldHandler(); // Register for ActionEvents
        textField1.addActionListener(handler);
        textField2.addActionListener(handler);
        textField3.addActionListener(handler);
        passwordField.addActionListener(handler);

        setSize(325,100);
        setVisible(true);
    }

    public static void main(String[] args){
        TextFieldTest application = new TextFieldTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Private inner class for event handling
    private class TextFieldHandler implements ActionListener{

        // Process textfield events
        public void actionPerformed(ActionEvent event){
            String string = ""; 

            // User pressed Enter in JTextField textField1
            if(event.getSource() == textField1){ // returns object that generated event
                string = "textField1: " + event.getActionCommand(); // returns text in textfield
            }

            // User pressed Enter in JTextField textField2
            else if(event.getSource() == textField2){
                string = "textField2: " + event.getActionCommand();
            }

            // User pressed Enter in JTextField textField3
            else if(event.getSource() == textField3){
                string = "textField3: " + event.getActionCommand();
            }

            // User preessed Enter in JPasswordField passwordField
            else if(event.getSource() == passwordField){
                string = "passwordField: " +  new String(passwordField.getPassword());
            }

            JOptionPane.showMessageDialog(null, string);
        }
    }
}