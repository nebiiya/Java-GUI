// Using a customized Panel object
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomPanelTest extends JFrame{
    private JPanel buttonPanel;
    private JButton circleButton, squareButton;
    private CustomPanel myPanel;

    public CustomPanelTest(){
        super("CustomPanel Test");

        // Set up drawing area
        myPanel = new CustomPanel();
        myPanel.setBackground(Color.GREEN);

        //  Set up square button
        squareButton = new JButton("Square");
        squareButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    // Draw a square
                    myPanel.draw(CustomPanel.SQUARE);
                }
            }
        );

        circleButton = new JButton("Circle");
        circleButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    myPanel.draw(CustomPanel.CIRCLE);
                }
            }
        );
        
        // Set up panel containing the buttons
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2));
        buttonPanel.add(circleButton);
        buttonPanel.add(squareButton);

        // Attach the panel and custom drawing area to the content pane
        Container container = getContentPane();
        container.add(buttonPanel, BorderLayout.SOUTH);
        container.add(myPanel, BorderLayout.CENTER);

        setSize(300, 150);
        setVisible(true);
    }

    public static void main(String[] args){
        CustomPanelTest application = new CustomPanelTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
