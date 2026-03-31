// abstract class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // constructor, getters, and setters
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    public int getProductId() { 
        return productId; 
    }
    public String getName() { 
        return name; 
    }
    public double getPrice() { 
        return price; 
    }
    public void setPrice(double price) { 
        this.price = price; 
    }
    // abstract method
    public abstract double calculateDiscount();
}

// interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// subclasses
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }
    // implement abstract method
    public double calculateDiscount() { 
        return getPrice() * 0.1; 
    }
    public double calculateTax() { 
        return getPrice() * 0.18; 
    }
    public String getTaxDetails() { 
        return "GST 18%"; 
    }
}

// subclass
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    // implement abstract method
    public double calculateDiscount() { 
        return getPrice() * 0.2; 
    }
    public double calculateTax() { 
        return getPrice() * 0.05; 
    }
    public String getTaxDetails() { 
        return "GST 5%"; 
    }
}

// subclass
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() { 
        return getPrice() * 0.05; 
    }
}

// utility class
class ECommercePlatform {
    public static void printFinalPrices(Product[] products) {

        // polymorphism 
        for (Product p : products) {
            double tax = (p instanceof Taxable) ? ((Taxable)p).calculateTax() : 0;
            double discount = p.calculateDiscount();

            double finalPrice = p.getPrice() + tax - discount;
            System.out.println(p.getName() + " Final Price: " + finalPrice);
        }
    }
}

// main class
public class ECommPlatform {
    public static void main(String[] args) {

        // create products
        Product[] products = {
            new Electronics(1, "Laptop", 50000),
            new Clothing(2, "Shirt", 2000),
            new Groceries(3, "Rice", 1000)
        };

        // print final prices
        System.out.println("E-Commerce Platform:");
        ECommercePlatform.printFinalPrices(products);
    }
}
