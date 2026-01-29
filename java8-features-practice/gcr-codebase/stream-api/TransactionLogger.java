import java.time.LocalDateTime;
import java.util.*;

public class TransactionLogger {
    public static void main(String[] args) {

        // list of Ids
        List<String> transactionIds = List.of("TXN1001", "TXN1002", "TXN1003");
        transactionIds.forEach(id-> System.out.println(LocalDateTime.now() + " , Transaction: " + id));
    }
}
