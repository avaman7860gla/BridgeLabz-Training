public class Product {

    // Instance variables
    String productName;
    double price;

    // Static variable to keep track of total products created
    static int totalProducts = 0;

    // Constructor
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    // Method to display product details
    void displayProductDetails() {
        System.out.println("Product Name: " + productName + ", Price: ₹" + price);
    }

    // Static method to display total products created
    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    public static void main(String[] args) {
        // Creating product instances
        Product p1 = new Product("Laptop", 75000);
        Product p2 = new Product("Smartphone", 25000);

        // Displaying product details and total products
        p1.displayProductDetails();
        p2.displayProductDetails();
        Product.displayTotalProducts();
    }
}
