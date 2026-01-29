import java.util.*;

public class StockPriceLogger {
    public static void main(String[] args) {

        // list of prices
        List<Double> stockPrices = List.of(2450.75, 2461.30, 2448.90, 2470.10);

        stockPrices.forEach(price-> System.out.println("Live Stock Price: " + price));
    }
}
