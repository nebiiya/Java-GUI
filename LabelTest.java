// Demonstrating the JLabel class

import java.awt.*;
import java.awt.Image;
import javax.swing.*;

public class LabelTest extends JFrame{
    private JLabel label1, label2, label3;

    // Set up GUI 

    public LabelTest(){
        super("Testing JLabel");

        // Get content pane and set its layout
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        // JLabel constructor with a string argument
        label1 = new JLabel("Label with text");
        label1.setToolTipText("This is label1");
        container.add(label1);

        // JLabel constructor with string, Icon and alignment arguments
        ImageIcon stardrop = new ImageIcon("20x20-stardrop-bg.png");
        Image original = stardrop.getImage();
        Image resized = original.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Icon resizedIcon = new ImageIcon(resized);

        label2 = new JLabel(
            "Label with text and icon",
            resizedIcon,
            SwingConstants.LEFT
        );
        label2.setToolTipText("This is labell2");
        container.add(label2);

        // JLabel constructor without arguments (isa-isa)
        label3 = new JLabel();
        label3.setText("Label with icon and text at  the bottom");

        // ImageIcon stardropIcon = (ImageIcon) stardrop; // Cast Icon to ImageIcon instead of creating a new one);
        label3.setIcon(resizedIcon);
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setVerticalTextPosition(SwingConstants.BOTTOM);
        label3.setToolTipText("This is label3");
        container.add(label3);

        setSize(275,190);
        setVisible(true);
    }

    public static void main(String[] args){
        LabelTest application = new LabelTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}