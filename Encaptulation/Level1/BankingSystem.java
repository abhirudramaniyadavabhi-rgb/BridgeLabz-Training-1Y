import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for loanable accounts
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract BankAccount class
abstract class BankAccount implements Loanable {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void setHolderName(String name) { this.holderName = name; }
    public void setBalance(double balance) { this.balance = balance; }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Abstract method for interest
    public abstract double calculateInterest();

    // Display details
    public void displayAccountDetails() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
        System.out.println("Interest: " + calculateInterest());
        System.out.println("-----------------------------");
    }
}

// Savings Account
class SavingsAccount extends BankAccount {

    private double interestRate = 0.04; // 4% annual

    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan of " + amount + " approved for Savings Account.");
        } else {
            System.out.println("Loan not eligible for Savings Account.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000; // eligible if balance >= 5000
    }
}

// Current Account
class CurrentAccount extends BankAccount {

    private double interestRate = 0.02; // 2% annual

    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan of " + amount + " approved for Current Account.");
        } else {
            System.out.println("Loan not eligible for Current Account.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000; // eligible if balance >= 10000
    }
}

// Main Banking System
public class BankingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        System.out.print("Enter number of accounts to create: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {

            System.out.println("\nAccount " + (i + 1));
            System.out.print("Enter Account Number: ");
            String accNo = sc.nextLine();

            System.out.print("Enter Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();
            sc.nextLine(); // consume newline

            System.out.print("Enter Type (1=Savings, 2=Current): ");
            int type = sc.nextInt();
            sc.nextLine();

            BankAccount acc;
            if (type == 1) {
                acc = new SavingsAccount(accNo, name, balance);
            } else {
                acc = new CurrentAccount(accNo, name, balance);
            }

            accounts.add(acc);
        }

        System.out.println("\n===== Account Details & Interest =====");

        for (BankAccount acc : accounts) {
            acc.displayAccountDetails();
        }

        System.out.println("\n===== Loan Application =====");

        for (BankAccount acc : accounts) {
            System.out.print("Enter loan amount for account " + acc.getAccountNumber() + ": ");
            double loan = sc.nextDouble();
            acc.applyForLoan(loan);
        }

        sc.close();
    }
}
