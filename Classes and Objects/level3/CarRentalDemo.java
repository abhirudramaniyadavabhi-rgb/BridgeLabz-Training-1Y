class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    static final int costPerDay = 1000;

    CarRental(String c, String m, int d) {
        customerName = c;
        carModel = m;
        rentalDays = d;
    }

    int calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    void display() {
        System.out.println(customerName + " | " + carModel);
        System.out.println("Total Cost: " + calculateTotalCost());
    }
}

public class CarRentalDemo {
    public static void main(String[] args) {
        CarRental r = new CarRental("Aryan", "Creta", 3);
        r.display();
    }
}