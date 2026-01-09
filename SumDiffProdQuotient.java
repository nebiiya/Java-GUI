import java.util.*;

public class SumDiffProdQuotient {
    public static void sum(int firstNum, int secondNum){
        int sum = 0;
        sum = firstNum + secondNum;
        System.out.println("The sum is " + sum);
    }

    public static void difference(int firstNum, int secondNum){
    int difference = 0;
    difference = firstNum - secondNum;
    System.out.println("The difference is " + difference);
    }

    public static void product(int firstNum, int secondNum){
        int product = 0;
        product = firstNum * secondNum;
        System.out.println("The product is " + product);
    }

    public static void quotient(int firstNum, int secondNum){
        int quotient = 0;
        quotient = firstNum / secondNum;
        System.out.println("The sum is " + quotient);
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter 1st number: ");
        int firstNum = scan.nextInt();

        System.out.print("Enter 2nd number: ");
        int secondNum = scan.nextInt();

        scan.close();

        sum(firstNum, secondNum);

        difference(firstNum, secondNum);

        product(firstNum, secondNum);

        quotient(firstNum, secondNum);
    }
}