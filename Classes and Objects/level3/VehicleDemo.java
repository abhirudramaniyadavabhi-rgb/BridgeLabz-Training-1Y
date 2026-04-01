class Vehicle {
    String ownerName;
    String vehicleType;

    static double registrationFee = 5000;

    Vehicle(String owner, String type) {
        this.ownerName = owner;
        this.vehicleType = type;
    }

    void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Aryan", "Car");
        v1.displayVehicleDetails();

        Vehicle.updateRegistrationFee(7000);
        System.out.println("\nAfter Update:");
        v1.displayVehicleDetails();
    }
}