import java.util.*;
import java.util.stream.*;

class InsuranceClaim {
    String claimType;
    double amount;

    // constructor
    InsuranceClaim(String claimType, double amount) {
        this.claimType = claimType;
        this.amount = amount;
    }
}

public class InsuranceAnalysis {
    public static void main(String[] args) {

        // list of insurance claims
        List<InsuranceClaim> claims = List.of(
                new InsuranceClaim("Health", 5000),
                new InsuranceClaim("Health", 7000),
                new InsuranceClaim("Vehicle", 12000),
                new InsuranceClaim("Vehicle", 8000),
                new InsuranceClaim("Life", 20000)
        );

        // use streams 
        Map<String, Double> avgClaims =claims.stream()
                                        .collect(Collectors.groupingBy(
                                            c -> c.claimType,
                                            Collectors.averagingDouble(c -> c.amount)
                                        ));

        avgClaims.forEach((type, avg) -> System.out.println(type + " , Average Claim: " + avg));
    }
}
