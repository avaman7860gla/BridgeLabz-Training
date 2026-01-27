import java.util.*;
import java.util.function.Function;

class Invoice {
    int transactionId;

    // constructor
    Invoice(int transactionId) {
        this.transactionId = transactionId;
    }

    // display 
    void display() {
        System.out.println("Invoice created for Transaction ID: " + transactionId);
    }
}

public class InvoiceCreation {
    public static void main(String[] args) {
        // list of IDs
        List<Integer> transactionIds = Arrays.asList(501, 502, 503, 504);

        // constructor reference to create invoice objects
        Function<Integer, Invoice> invoiceCreator = Invoice::new;

        System.out.println("Generating Invoices:");

        for (int id : transactionIds) {
            Invoice invoice = invoiceCreator.apply(id);
            invoice.display();
        }
    }
}
