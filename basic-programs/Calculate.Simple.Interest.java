import java.util.Scanner;

public class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the Principal amount: ");
        double principal = input.nextDouble();

        System.out.print("Enter the Rate of interest (per year): ");
        double rate = input.nextDouble();

        System.out.print("Enter the Time (in years): ");
        double time = input.nextDouble();

        double simpleInterest = (principal * rate * time) / 100;

        System.out.println("\n--- Results ---");
        System.out.println("Principal: " + principal);
        System.out.println("Interest Rate: " + rate + "%");
        System.out.println("Time: " + time + " years");
        System.out.println("Simple Interest calculated: " + simpleInterest);
        
        double totalAmount = principal + simpleInterest;
        System.out.println("Total Amount (P + SI): " + totalAmount);

        input.close();
    }
}