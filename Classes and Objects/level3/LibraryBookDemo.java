class LibraryBook {
    String title;
    String author;
    double price;
    boolean availability = true;

    void borrowBook() {
        if (availability) {
            availability = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book not available.");
        }
    }

    void display() {
        System.out.println(title + " | Available: " + availability);
    }
}

public class LibraryBookDemo {
    public static void main(String[] args) {
        LibraryBook b = new LibraryBook();
        b.title = "Java";
        b.borrowBook();
        b.display();
    }
}