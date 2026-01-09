import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuTest extends JFrame {
    private final Color colorValues[]={
        Color.BLACK, Color.BLUE, Color.RED, Color.GREEN
    }; // test what if hindi black ung ilagay ko sa unahan ng colors na ipapasa sa color items
    private JRadioButtonMenuItem colorItems[], fonts[]; 
    private JCheckBoxMenuItem styleItems[];
    private JLabel displayLabel;
    private ButtonGroup colorGroup, fontGroup;
    private int style;

    // GUI
    public MenuTest(){
        super("Using JMenus");

        // File menu and menu items
        JMenu fileMenu= new JMenu("File");
        fileMenu.setMnemonic('F');

        JMenuItem aboutItem= new JMenuItem("About");
        aboutItem.setMnemonic('A');

        fileMenu.add(aboutItem);
        aboutItem.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    JOptionPane.showMessageDialog(MenuTest.this,
                        "This is an example\nof using menus",
                        "About",
                        JOptionPane.PLAIN_MESSAGE
                    );
                }
            }
        );

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('x');
        fileMenu.add(exitItem);
        exitItem.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    System.exit(0);
                }
            }
        );

        // Create menu bar
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(fileMenu); // menu items -> file menu -> bar -> window

        // Format menu and menu items
        JMenu formatMenu = new JMenu("Format");
        formatMenu.setMnemonic('r');

        JMenu colorMenu = new JMenu("Color");
        colorMenu.setMnemonic('c');

        // Color submenu (follow thhe color values)
        String colors[] = {"Black", "Blue", "Red", "Green"};

        colorItems = new JRadioButtonMenuItem[colors.length]; // create object muna
        colorGroup = new ButtonGroup(); // create object muna
        ItemHandler itemHandler = new ItemHandler();

        // Color radio button menu items
        for(int count = 0; count < colorItems.length; count++){
            colorItems[count] = new JRadioButtonMenuItem(colors[count]);
            colorMenu.add(colorItems[count]);
            colorGroup.add(colorItems[count]);
            colorItems[count].addActionListener(itemHandler);
        }

        // Automatically selects first color
        colorItems[0].setSelected(true);

        formatMenu.add(colorMenu);
        formatMenu.addSeparator();

        JMenu fontMenu = new JMenu("Font");
        fontMenu.setMnemonic('n');

        // Font submenu
        String fontNames[] = {"Serif", "Monospaced", "SansSerif"};

        fonts = new JRadioButtonMenuItem[fontNames.length];
        fontGroup = new ButtonGroup();
        
        // Font radio button menu items
        for(int count = 0; count < fonts.length; count++){
            fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
            fontMenu.add(fonts[count]);
            fontGroup.add(fonts[count]);
            fonts[count].addActionListener(itemHandler);
        }

        //Automatically selects first font
        fonts[0].setSelected(true);

        // fontMenu.addSeparator(); // later para sa style

        // Style checkbox menu items
        String styleNames[] = {"Bold", "Italic"};
        styleItems = new JCheckBoxMenuItem[styleNames.length];
        StyleHandler styleHandler = new StyleHandler();

        for(int count = 0; count < styleItems.length; count++){
            styleItems[count] = new JCheckBoxMenuItem(styleNames[count]);
            fontMenu.add(styleItems[count]);
            styleItems[count].addItemListener(styleHandler);
        }

        formatMenu.add(fontMenu);

        // Finally, add formatMenu sa bar
        bar.add(formatMenu);

        // Display Text sa gitna
        displayLabel = new JLabel("Sample Text", SwingConstants.CENTER);
        displayLabel.setForeground(colorValues[0]);
        displayLabel.setFont(new Font("Serif", Font.PLAIN, 72));

        getContentPane().setBackground(Color.CYAN);
        getContentPane().add(displayLabel, BorderLayout.CENTER);

        setSize(500, 200);
        setVisible(true);
    }

    public static void main(String[] args){
        MenuTest application = new MenuTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Inner classes to handle radio button events
    private class ItemHandler implements ActionListener{
        // color and font
        public void actionPerformed (ActionEvent event){
            //color
            for(int count = 0; count < colorItems.length; count++){
                if(colorItems[count].isSelected()){
                    displayLabel.setForeground(colorValues[count]);
                    break;
                }
            }
            //font
            for(int count = 0; count < fonts.length; count++){
                if(event.getSource() == fonts[count]){
                    displayLabel.setFont(new Font(fonts[count].getText(), style, 72));
                    break;
                }
            }

            repaint();
        }
    };

    // Inner class to handle checkbox events
    private class StyleHandler implements ItemListener{
        // font style
        public void itemStateChanged(ItemEvent event){
            style = 0;

            if(styleItems[0].isSelected()){
                style += Font.BOLD; // 0 + 1 = 1 BOLD
            }

            if(styleItems[1].isSelected()){
                style += Font.ITALIC; // 0 + 2 = 2 ITALIC
            }
            
            displayLabel.setFont(new Font(displayLabel.getFont().getName(), style, 72));
            repaint();
        }
    }
}


