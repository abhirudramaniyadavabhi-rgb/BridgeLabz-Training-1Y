import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();
        
        System.out.print("Enter Second number: ");
        double num2 = input.nextDouble();
        
        System.out.print("Enter Third number: ");
        double num3 = input.nextDouble();

        double average = (num1 + num2 + num3) / 3;

        System.out.println("The average of the three numbers is: " + average);

        input.close();
    }
}