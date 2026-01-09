// Demonstrating keystroke events

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyDemo extends JFrame implements KeyListener{
    private String line1 ="", line2 ="", line3="";
    private JTextArea textArea;

    // Set up GUI
    public KeyDemo(){
        super("Demonstrating Keystroke Events");

        // Set up JTextArea
        textArea = new JTextArea(10, 15);
        textArea.setText("Press any key on the keyboard...");
        textArea.setEnabled(false);
        requestFocus();
        textArea.setDisabledTextColor(Color.BLACK);
        getContentPane().add(textArea);

        // Register JFrame for key events
        addKeyListener(this); // Allow frame to procesS Key events

        setSize(350,100);
        setVisible(true);
    }

    // Handle press of any ACTION key
    // Called when user presses key
    public void keyPressed(KeyEvent event){
        line1 = "Key pressed: " + event.getKeyText(event.getKeyCode()); // Return virtual keyy code
        setLines2and3(event);
    }

    // Handles release of ANY key
    // Called when use releases key
    public void keyReleased(KeyEvent event){
        line1 = "Key released: " + event.getKeyText(event.getKeyCode()); // Return virtual key code
        setLines2and3(event);
    }

    // Handles press of any NON-ACTION key 
    public void keyTyped(KeyEvent event){
        line1 = "Key typed: " + event.getKeyChar();
        setLines2and3(event);
    }

    // Set second and third lines of output
    private void setLines2and3(KeyEvent event){
        line2 = "This key is " + (event.isActionKey() ? "" : "not") + " an action key";

        // Determine if modifier keys (e.g. Alt, Ctrl, Meta, and Shift) were used
        int mods = event.getModifiersEx();
        String temp = KeyEvent.getModifiersExText(mods);

        line3 = "Modifiers key pressed: " + (temp.equals("")? "none" : temp);

        textArea.setText(line1 + "\n" + line2 + "\n" + line3 + "\n");
    }

    public static void main(String args[]){
        KeyDemo application = new KeyDemo();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}