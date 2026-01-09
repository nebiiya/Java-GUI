import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class OvalPanelTest extends JFrame{
    private JSlider diameterSlider;
    private OvalPanel myPanel;

    // GUI
    public OvalPanelTest(){
        super("OvalPanel Test");

        myPanel = new OvalPanel();
        myPanel.setBackground(Color.YELLOW);

        diameterSlider = new JSlider(SwingConstants.HORIZONTAL,0, 200, 10);
        diameterSlider.setMajorTickSpacing(10);
        diameterSlider.setPaintTicks(true);

        // Register JSlider event listener
        diameterSlider.addChangeListener(
            new ChangeListener() {
                public void stateChanged(ChangeEvent event){
                    myPanel.setDiameter(diameterSlider.getValue());
                }     
            }
        );

        Container container = getContentPane();
        container.add(myPanel, BorderLayout.CENTER);
        container.add(diameterSlider, BorderLayout.SOUTH);

        setSize(220,270);
        setVisible(true);
    }

    public static void main(String[] args){
        OvalPanelTest application = new OvalPanelTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}