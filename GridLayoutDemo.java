import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridLayoutDemo extends JFrame implements ActionListener{
    private JButton buttons[];
    private final String names[] = {
        "one", "two", "three", "four", "five", "six"
    };
    private boolean toggle = true;
    private GridLayout grid1, grid2;
    private Container container;

    public GridLayoutDemo(){
        super("GridLayout Demo");

        grid1 = new GridLayout(2, 3, 5, 5);
        grid2 = new GridLayout(3,2);

        container = getContentPane();
        container.setLayout(grid1);

        buttons = new JButton[names.length];

        for(int count = 0; count < buttons.length; count++){
            buttons[count] = new JButton(names[count]);
            buttons[count].addActionListener(this);
            container.add(buttons[count]);
        }

        setSize(300,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event){
        if(toggle){
            container.setLayout(grid2);
        } else{
            container.setLayout(grid1);
        }

        toggle = !toggle; // Set toggle to false
        container.validate();
    }

    public static void main(String[] args){
        GridLayoutDemo application = new GridLayoutDemo();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}