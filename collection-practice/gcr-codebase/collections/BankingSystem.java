import java.util.*;

public class BankingSystem {
    public static void main(String[] args) {

        // hashmap
        HashMap<String, Double> accounts = new HashMap<>();
        accounts.put("101", 20000.0);
        accounts.put("102", 10000.0);
        accounts.put("103", 15000.0);

        // use tree map for sort
        TreeMap<Double, String> sortedByBalance = new TreeMap<>();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            sortedByBalance.put(entry.getValue(), entry.getKey());
        }

        // queue
        Queue<String> withdrawalQueue = new LinkedList<>();
        withdrawalQueue.add("101");
        withdrawalQueue.add("103");
 
        // display sorted balance
        System.out.println("Sorted by Balance:");
        sortedByBalance.forEach((bal, acc) -> System.out.println(acc + " : " + bal));

        // display withdrawl
        System.out.println("Withdrawals:");
        while (!withdrawalQueue.isEmpty()) {
            String acc = withdrawalQueue.poll();
            System.out.println("withdrawal for account " + acc);
        }
    }
}