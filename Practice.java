import javax.swing.JOptionPane;
import java.lang.String;

public class Practice{
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Enter your name: ");
        String age = JOptionPane.showInputDialog(null, "Enter your age: ", "Age Input", JOptionPane.QUESTION_MESSAGE);
        int choice = JOptionPane.showConfirmDialog(null, "Save changes before exiting?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        String[] options = {"Save", "Don't Save", "Cancel"};

        int result = JOptionPane.showOptionDialog(
            null, 
            "What do you want to do?",
            "Choose Action", 
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
        );
        JOptionPane.showMessageDialog(null, "Operation completed successfully!", "Status", JOptionPane.INFORMATION_MESSAGE);

    }
}