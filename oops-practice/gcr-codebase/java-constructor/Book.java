public class Book {

    // Attributes
    String title;
    String author;
    double price;

    // Default Constructor
    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Parameterized Constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: ₹" + price);
    }

    public static void main(String[] args) {

        // Testing the Book class
        Book b1 = new Book();

        Book b2 = new Book("Java Programming", "James Gosling", 500.0);

        // Displaying book details
        b1.display();
        b2.display();
    }
}
