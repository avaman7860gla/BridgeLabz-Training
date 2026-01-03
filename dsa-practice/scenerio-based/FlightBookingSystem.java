import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// flight class
class Flight {
    String flightId;
    String source;
    String destination;
    double price;

    // constructor
    Flight(String flightId, String source, String destination, double price) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    // display method
    void displayFlight() {
        System.out.println(flightId + " , " + source + " , " + destination + " , " + price);
    }
}

public class FlightBookingSystem {

    // array to store available flights
    static Flight[] flights = {
        new Flight("101", "Agra", "Goa", 5500),
        new Flight("102", "Delhi", "Bangalore", 9500),
        new Flight("103", "Chennai", "Mumbai", 6500)
    };

    // list to store user bookings
    static List<Flight> bookings = new ArrayList<>();

    // method to search flights
    static void searchFlights(String source, String destination) {
        boolean found = false;
        System.out.println("Available Flights:");
        for (Flight flight : flights) {
            if (flight.source.equalsIgnoreCase(source) &&
                flight.destination.equalsIgnoreCase(destination)) {
                flight.displayFlight();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No flights found for given route.");
        }
    }

    // method to book flight
    static void bookFlight(String flightId) {
        for (Flight flight : flights) {
            if (flight.flightId.equalsIgnoreCase(flightId)) {
                bookings.add(flight);
                System.out.println("Flight booked");
                return;
            }
        }
        System.out.println("Invalid ID!");
    }

    // method to display bookings
    static void displayBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found");
            return;
        }
        System.out.println("Your Bookings:");
        for (Flight flight : bookings) {
            flight.displayFlight();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nFlight Booking System");
            System.out.println("1.Search Flights");
            System.out.println("2.Book Flight");
            System.out.println("3.View Bookings");
            System.out.println("4.Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            // using switch case
            switch (choice) {
                case 1:
                    System.out.print("Enter Source: ");
                    String source = sc.nextLine();
                    System.out.print("Enter Destination: ");
                    String destination = sc.nextLine();
                    searchFlights(source, destination);
                    break;

                case 2:
                    System.out.print("Enter Flight ID to book: ");
                    String flightId = sc.nextLine();
                    bookFlight(flightId);
                    break;

                case 3:
                    displayBookings();
                    break;

                case 4:
                    System.out.println("Thank you for using Flight Booking System");
                    break;

                default:
                    System.out.println("Invalid");
            }
        } 
        while (choice != 4);

    }
}
