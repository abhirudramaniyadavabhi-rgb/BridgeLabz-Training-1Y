import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for taxable products
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract Product class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters & Setters (Encapsulation)
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }

    public abstract double calculateDiscount();

    public void displayProduct() {
        System.out.println("ID: " + productId + ", Name: " + name + ", Price: " + price);
    }
}

// Electronics class (Taxable)
class Electronics extends Product implements Taxable {

    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% tax
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18%";
    }
}

// Clothing class (Taxable)
class Clothing extends Product implements Taxable {

    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12; // 12% tax
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 12%";
    }
}

// Groceries class (No tax)
class Groceries extends Product {

    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.02; // 2% discount
    }
}

// Main platform class
public class ECommercePlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\nProduct " + (i + 1));
            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            System.out.print("Enter Type (1=Electronics, 2=Clothing, 3=Groceries): ");
            int type = sc.nextInt();

            Product p;
            switch (type) {
                case 1:
                    p = new Electronics(id, name, price);
                    break;
                case 2:
                    p = new Clothing(id, name, price);
                    break;
                default:
                    p = new Groceries(id, name, price);
            }

            products.add(p);
        }

        System.out.println("\n===== Product Details & Final Price =====");
        calculateFinalPrices(products);

        sc.close();
    }

    // Polymorphism: calculates final price for any product
    public static void calculateFinalPrices(List<Product> products) {

        for (Product p : products) {
            p.displayProduct();
            double discount = p.calculateDiscount();
            double tax = (p instanceof Taxable) ? ((Taxable) p).calculateTax() : 0;
            double finalPrice = p.getPrice() + tax - discount;

            System.out.printf("Discount: %.2f, Tax: %.2f, Final Price: %.2f%n", discount, tax, finalPrice);

            if (p instanceof Taxable) {
                System.out.println(((Taxable) p).getTaxDetails());
            }

            System.out.println("------------------------------");
        }
    }
}
