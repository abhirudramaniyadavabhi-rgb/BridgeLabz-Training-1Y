import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for reservable items
interface Reservable {
    void reserveItem(String borrower);
    boolean checkAvailability();
}

// Abstract LibraryItem class
abstract class LibraryItem implements Reservable {
    private String itemId;
    private String title;
    private String author;
    private boolean isReserved = false;
    private String borrowerName;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Encapsulation
    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean getIsReserved() { return isReserved; }
    public String getBorrowerName() { return borrowerName; }

    protected void setReserved(boolean reserved) { this.isReserved = reserved; }
    protected void setBorrowerName(String borrower) { this.borrowerName = borrower; }

    // Abstract method for loan duration
    public abstract int getLoanDuration();

    // Concrete method
    public void getItemDetails() {
        System.out.println("\nItem ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration (days): " + getLoanDuration());
        System.out.println("Reserved: " + isReserved);
        if (isReserved) {
            System.out.println("Borrower: " + borrowerName);
        }
        System.out.println("-----------------------------");
    }

    @Override
    public void reserveItem(String borrower) {
        if (!isReserved) {
            isReserved = true;
            borrowerName = borrower;
            System.out.println("Item " + title + " reserved by " + borrower);
        } else {
            System.out.println("Item " + title + " is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// Book subclass
class Book extends LibraryItem {

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21; // 3 weeks
    }
}

// Magazine subclass
class Magazine extends LibraryItem {

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 1 week
    }
}

// DVD subclass
class DVD extends LibraryItem {

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days
    }
}

// Main Library Management System
public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<LibraryItem> items = new ArrayList<>();

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nItem " + (i + 1));
            System.out.print("Enter Item Type (1=Book, 2=Magazine, 3=DVD): ");
            int type = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Item ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Title: ");
            String title = sc.nextLine();
            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            LibraryItem item;
            switch (type) {
                case 1:
                    item = new Book(id, title, author);
                    break;
                case 2:
                    item = new Magazine(id, title, author);
                    break;
                case 3:
                    item = new DVD(id, title, author);
                    break;
                default:
                    System.out.println("Invalid type, defaulting to Book");
                    item = new Book(id, title, author);
            }

            items.add(item);
        }

        System.out.println("\n===== Library Items =====");
        for (LibraryItem item : items) {
            item.getItemDetails();
        }

        // Reserve items
        System.out.println("\n===== Reserve Items =====");
        for (LibraryItem item : items) {
            System.out.print("Enter borrower's name to reserve " + item.getTitle() + ": ");
            String borrower = sc.nextLine();
            item.reserveItem(borrower);
        }

        System.out.println("\n===== Updated Item Details =====");
        for (LibraryItem item : items) {
            item.getItemDetails();
        }

        sc.close();
    }
}
