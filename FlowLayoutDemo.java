import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlowLayoutDemo extends JFrame {
    private JButton leftButton, centerButton, rightButton;
    private Container container;
    private FlowLayout layout;

    // Set up GUI
    public FlowLayoutDemo(){
        super("FlowLayout Demo");

        layout = new FlowLayout();

        container = getContentPane();
        container.setLayout(layout);

        leftButton = new JButton("Left");
        container.add(leftButton);

        centerButton = new JButton("Center");
        container.add(centerButton);

        rightButton = new JButton("Right");
        container.add(rightButton);

        // Register event listeners 
        // When user pressed left button, left align components
        leftButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    // tells how you want it aligned
                    layout.setAlignment(FlowLayout.LEFT); 

                    // realign attached components (executes movement)
                    container.validate();
                    container.invalidate();
                }
            }
        );
        
        centerButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    layout.setAlignment(FlowLayout.CENTER);
                    layout.layoutContainer(container);
                }
            }
        );

        rightButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    layout.setAlignment(FlowLayout.RIGHT); 
                    layout.layoutContainer(container);
                }
            }
        );

        setSize(300, 75);
        setVisible(true);
    }

    public static void main(String[] args){
        FlowLayoutDemo application = new FlowLayoutDemo();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
