public class Cart {
    public static void main(String[] args) {

        String[] prices = {"250", "499", "abc", "99"};
        int total = 0;

        for (String p : prices) {
            try {
                total += Integer.parseInt(p);
            } catch (NumberFormatException e) {
                System.out.println("Invalid price: " + p);
            }
        }

        System.out.println("Total = " + total);
    }
}