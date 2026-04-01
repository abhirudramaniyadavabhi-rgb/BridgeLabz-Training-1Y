import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for insurable vehicles
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract Vehicle class
abstract class Vehicle implements Insurable {
    private String vehicleNumber;
    private String type;
    private double rentalRate;  // rate per day
    private String insurancePolicyNumber;

    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    // Encapsulation: getters and setters
    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    public void setType(String type) { this.type = type; }
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }

    public void setInsurancePolicyNumber(String policy) { this.insurancePolicyNumber = policy; }
    public String getInsurancePolicyNumber() { return insurancePolicyNumber; }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    // Concrete methods from Insurable
    public double calculateInsurance() {
        // Default insurance calculation: 5% of rentalRate per day * 30 days
        return rentalRate * 30 * 0.05;
    }

    public String getInsuranceDetails() {
        return "Insurance Policy: " + insurancePolicyNumber;
    }

    public void displayVehicleDetails(int days) {
        System.out.println("\nVehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per day: " + rentalRate);
        System.out.println("Rental Cost for " + days + " days: " + calculateRentalCost(days));
        System.out.println("Insurance Cost: " + calculateInsurance());
        System.out.println(getInsuranceDetails());
        System.out.println("----------------------------");
    }
}

// Car subclass
class Car extends Vehicle {
    public Car(String number, double rate, String policy) {
        super(number, "Car", rate, policy);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        // Car insurance: 8% of monthly rental rate
        return getRentalRate() * 30 * 0.08;
    }
}

// Bike subclass
class Bike extends Vehicle {
    public Bike(String number, double rate, String policy) {
        super(number, "Bike", rate, policy);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        // Bike insurance: 3% of monthly rental rate
        return getRentalRate() * 30 * 0.03;
    }
}

// Truck subclass
class Truck extends Vehicle {
    public Truck(String number, double rate, String policy) {
        super(number, "Truck", rate, policy);
    }

    @Override
    public double calculateRentalCost(int days) {
        // Trucks may have extra charges: 10% extra for heavy vehicles
        return getRentalRate() * days * 1.10;
    }

    @Override
    public double calculateInsurance() {
        // Truck insurance: 12% of monthly rental rate
        return getRentalRate() * 30 * 0.12;
    }
}

// Main Rental System
public class VehicleRentalSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();

        System.out.print("Enter number of vehicles to register: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nVehicle " + (i + 1));
            System.out.print("Enter Vehicle Number: ");
            String number = sc.nextLine();

            System.out.print("Enter Vehicle Type (Car/Bike/Truck): ");
            String type = sc.nextLine();

            System.out.print("Enter Rental Rate per day: ");
            double rate = sc.nextDouble();
            sc.nextLine(); // consume newline

            System.out.print("Enter Insurance Policy Number: ");
            String policy = sc.nextLine();

            Vehicle v;
            switch (type.toLowerCase()) {
                case "car":
                    v = new Car(number, rate, policy);
                    break;
                case "bike":
                    v = new Bike(number, rate, policy);
                    break;
                case "truck":
                    v = new Truck(number, rate, policy);
                    break;
                default:
                    System.out.println("Invalid type, defaulting to Car");
                    v = new Car(number, rate, policy);
            }

            vehicles.add(v);
        }

        System.out.print("\nEnter rental duration (days) for all vehicles: ");
        int days = sc.nextInt();

        System.out.println("\n===== Vehicle Rental Details =====");

        for (Vehicle v : vehicles) {
            v.displayVehicleDetails(days); // Polymorphism in action
        }

        sc.close();
    }
}
