import java.util.*;
import java.util.stream.Collectors;

class Order {
    private String customerName;
    private double amount;

    // constructor
    public Order(String customerName, double amount) {
        this.customerName = customerName;
        this.amount = amount;
    }

    // getters
    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }
}

public class OrderRevenue {
    public static void main(String[] args) {

        // list of orders
        List<Order> orders = List.of(
                new Order("Ravi", 2500),
                new Order("Ravi", 1500),
                new Order("Anita", 3000),
                new Order("Anita", 2000),
                new Order("Suresh", 1800)
        );

        Map<String, Double> revenueByCustomer =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getCustomerName,
                                Collectors.summingDouble(Order::getAmount)
                        ));

        revenueByCustomer.forEach((customer, total) ->
                System.out.println(customer + " - " + total)
        );
    }
}
