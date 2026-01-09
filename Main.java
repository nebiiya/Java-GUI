import javax.swing.JOptionPane;

public class Main{
    public static void main(String[] args){
        String name = JOptionPane.showInputDialog("Enter your name"); // returns a string
        JOptionPane.showMessageDialog(null, "Hello " + name);
        

        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age")); 
        JOptionPane.showMessageDialog(null, "You are " + age + " years old");

        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height")); 
        JOptionPane.showMessageDialog(null, "You are " + height + " cm tall");

        int choice = JOptionPane.showConfirmDialog(null, "Do you want to continue?");
        if(choice == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "You chose yes");
        } else {
            JOptionPane.showMessageDialog(null, "You chose no");
        }

        String[] actions = {"Save", "Don't Save", "Cancel"};

        int result = JOptionPane.showOptionDialog(
            null, 
            "What do you want to do?", 
            "Choose an action", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            actions, 
            actions[0]
        );
        if(result ==0 ){
            JOptionPane.showMessageDialog(null, "You chose Save");
        } else if(result == 1) {
            JOptionPane.showMessageDialog(null, "You chose Don't Save");
        } else{
            JOptionPane.showMessageDialog(null,"You closed the dialog");
        }
    }
}   