// Creating JButtons

import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;

public class ButtonTest extends JFrame{
    private JButton plainButton, fancyButton;

    // Set up GUI
    public ButtonTest(){
        super("Testing Buttons");
        
        // Get content pane and set its layout
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        // Create buttons
        plainButton = new JButton("Plain Button"); // JButton with text
        container.add(plainButton);

        ImageIcon stardrop = new ImageIcon("20x20-stardrop-bg.png");
        Image originalStardrop = stardrop.getImage();
        Image resizedS = originalStardrop.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Icon resizedStardrop = new ImageIcon(resizedS);

        ImageIcon junimo = new ImageIcon("20x20-junimo-bg.png");
        Image originalJunimo = junimo.getImage();
        Image resizedJ = originalJunimo.getScaledInstance(50,50, Image.SCALE_SMOOTH);
        Icon resizedJunimo = new ImageIcon(resizedJ);

        fancyButton = new JButton("FancyButton", resizedStardrop); // JButton with image
        fancyButton.setRolloverIcon(resizedJunimo); // Jbutton with rollover image
        container.add(fancyButton);
    
        // Create an instance of inner class ButtonHandler for button event handling
        ButtonHandler handler = new ButtonHandler();
        fancyButton.addActionListener(handler);
        plainButton.addActionListener(handler);

        setSize(300,200);
        setVisible(true);
    }

    public static void main(String[] args){
        ButtonTest application = new ButtonTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Inner class for button event handling
    private class ButtonHandler implements ActionListener{
        
        // When user clicks JButton, ButtonHandler invokes method actionPerformed of all registered listeners
        // Handle button event
        public void actionPerformed(ActionEvent event){
            JOptionPane.showMessageDialog(
                ButtonTest.this,
                "You pressed:" + event.getActionCommand()
            );
        }
    }
}