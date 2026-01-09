import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextAreaDemo extends JFrame{
    private JTextArea textArea1, textArea2;
    private JButton copyButton;

    public JTextAreaDemo(){
        super("JTextArea Demo");

        Box box = Box.createHorizontalBox();

        String string =" This is a demo string to\n" + 
        "illustrate copying text\nfrom one text area to\n" +
        "another textarea using an\nexternal event";

        textArea1 = new JTextArea(string, 10, 15);
        box.add(new JScrollPane(textArea1));

        // Set up copyButton
        copyButton = new JButton("Copy");
        box.add(copyButton);
        copyButton.addActionListener(
            // anon inner class
            new ActionListener(){
                // set text in textArea to selected text from 1
                public void actionPerformed(ActionEvent event){
                    textArea2.setText(textArea1.getSelectedText());
                }
            }
        );

        // Set u textArea2
        textArea2 = new JTextArea(10,15);
        textArea2.setEditable(false);
        box.add(new JScrollPane(textArea2));

        Container container = getContentPane();
        container.add(box, BorderLayout.CENTER);
        
        setSize(425, 200);
        setVisible(true);
    }

    public static void main(String[] args){
        JTextAreaDemo application= new JTextAreaDemo();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}