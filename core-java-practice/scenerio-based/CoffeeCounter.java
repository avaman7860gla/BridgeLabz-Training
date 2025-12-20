import java.util.Scanner;

public class CoffeeCounter {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);


        // Display the menu
        System.out.println("Welcome to the Ravi's Coffee Counter");
        System.out.println("Which coffee would you like to order?");
        System.out.println("1. Espresso    99/-");
        System.out.println("2. Latte    129/-");
        System.out.println("3. Cappuccino    149/-");
        System.out.println("4. Americano    89/-");
        System.out.println("5. Exit");

        // Take user input
        System.out.print("Please enter your choice (1-5): ");
        int choice = scanner.nextInt();

        // Process the order
        int price = 0;
        

        // Loop to handle multiple customers
        while(true){
            // Determine the price based on the choice using switch-case
            switch(choice){
            case 1:
                System.out.println("You have ordered an Espresso");
                price = 99;
                break;
            case 2:
                System.out.println("You have ordered a Latte");
                price = 129;
                break;
            case 3:
                System.out.println("You have ordered a Cappuccino");
                price = 149;
                break;
            case 4:
                System.out.println("You have ordered an Americano");
                price = 89;
                break;
            case 5:
                System.out.println("Thank you for visiting. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
            }
    

            // If the choice is invalid or exit, break the loop
            if (choice < 1 || choice > 4) {
                return;
            }

            // Ask for quantity
            System.out.print("Enter the quantity you want to order: ");
            int quantity = scanner.nextInt();


            // Calculate total price and price with tax
            int totalPrice = price * quantity;
            System.out.println("Total price before tax: " + totalPrice + "/-");

            int priceWithTax = totalPrice + (totalPrice * 5 / 100);
            System.out.println("Total price after 5% tax: " + priceWithTax + "/-");

            // For the next customer
            System.out.println("\nNext customer:");
            // Display the menu again
            System.out.println("Which coffee would you like to order?");
            System.out.print("Please enter your choice (1-5): ");

            choice = scanner.nextInt();

            // If the choice is exit, break the loop
            if(choice == 5){
                System.out.println("Thank you for visiting. Goodbye!");
                break;
            }
        }

    }
    
}
