package M1_Practice_Problem;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Product{
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    double getTotalValue(){
        return price*quantity;
    }

    abstract void display();
}

class Electronics extends Product{
    int warranty;

    Electronics(String name, double price, int quantity, int warranty) {
        super(name, price, quantity);
        this.warranty=warranty;
    }

    @Override
    void display() {
        System.out.println(name+" - Price: "+price+", Quantity: "+quantity+", Warranty: "+warranty+" months");
    }
}

class Clothing extends Product{
    String size;

    Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size=size;
    }

    @Override
    void display() {
        System.out.println(name+" - Price: "+price+", Quantity: "+quantity+", Size: "+size);
    }
}

public class SupermarketStoreInventorySystem {
    static ArrayList<Product> inventory=new ArrayList<>();;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        sc.nextLine();

        while (num-->0){
            String input=sc.nextLine();
            process(input);
        }

        System.out.println("\nInventory:");
        for(Product p:inventory){
            p.display();
        }

        double total=0;
        for(Product p:inventory){
            total+=p.getTotalValue();
        }
        System.out.println("\nTotal value of the inventory: "+total);
    }

    public static void process(String input){
        String[] parts=input.split(", ");
        String productType=parts[0];

        switch (productType){
            case "Electronics":{
                Electronics e=new Electronics(parts[1], Double.parseDouble(parts[2]),
                        Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                inventory.add(e);
                System.out.println("Product added to inventory: "+parts[1]);
                break;
            }

            case "Clothing":{
                Clothing c=new Clothing(parts[1], Double.parseDouble(parts[2]),
                        Integer.parseInt(parts[3]), parts[4]);
                inventory.add(c);
                System.out.println("Product added to inventory: "+parts[1]);
                break;
            }
        }
    }
}
