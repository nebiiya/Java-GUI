import java.awt.*;
import javax.swing.*;

public class PanelDemo extends JFrame{
    private JPanel buttonPanel;
    private JButton buttons[];

    public PanelDemo(){
        super("Panel Demo");

        buttons = new JButton[5];

        Container container = getContentPane();

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, buttons.length));
        for(int count = 0; count < buttons.length; count++){
            buttons[count] = new JButton("Button " + (count + 1));
            buttonPanel.add(buttons[count]);
        }

        container.add(buttonPanel, BorderLayout.SOUTH);

        setSize(450, 150);
        setVisible(true);
    }

    public static void main(String[] args){
        PanelDemo application = new PanelDemo();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}