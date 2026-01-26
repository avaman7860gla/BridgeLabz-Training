// ECommerceSorting.java
// Demonstrates custom sorting using lambda expressions and Comparator

import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }
}

public class CustomSortingEcommerce {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 60000, 4.5, 10));
        products.add(new Product("Mobile", 30000, 4.2, 15));
        products.add(new Product("Headphones", 2000, 4.8, 25));
        products.add(new Product("Smart Watch", 8000, 4.0, 20));

        System.out.println("---- Original Product List ----");
        displayProducts(products);

        // Sort by price
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        System.out.println("\n---- Sorted by Price ----");
        displayProducts(products);

        // Sort by rating
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        System.out.println("\n---- Sorted by Rating ----");
        displayProducts(products);

        // Sort by discount
        products.sort((p1, p2) -> Double.compare(p2.discount, p1.discount));
        System.out.println("\n---- Sorted by Discount ----");
        displayProducts(products);
    }

    static void displayProducts(List<Product> products) {
        for (Product p : products) {
            System.out.println(
                p.name + " | Price: " + p.price +
                " | Rating: " + p.rating +
                " | Discount: " + p.discount + "%"
            );
        }
    }
}
