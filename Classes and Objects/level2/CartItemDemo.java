class CartItem {
    String itemName;
    double price;
    int quantity;

    void addItem(String name, double p, int q) {
        itemName = name;
        price = p;
        quantity += q;
        System.out.println("Item Added!");
    }

    void removeItem(int q) {
        if (q <= quantity) {
            quantity -= q;
            System.out.println("Item Removed!");
        } else {
            System.out.println("Not enough quantity to remove.");
        }
    }

    void displayTotalCost() {
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + (price * quantity));
    }
}

public class CartItemDemo {
    public static void main(String[] args) {
        CartItem cart = new CartItem();
        cart.addItem("Laptop", 50000, 2);
        cart.removeItem(1);
        cart.displayTotalCost();
    }
}