class Book {
    public String ISBN;
    protected String title;
    private String author;

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

class EBook extends Book {
    void displayDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + getAuthor());
    }
}

public class BookDemo {
    public static void main(String[] args) {
        EBook ebook = new EBook();
        ebook.ISBN = "12345";
        ebook.title = "Java Basics";
        ebook.setAuthor("James");

        ebook.displayDetails();
    }
}