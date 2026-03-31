import java.util.*;
import java.util.stream.*;

public class SmartCitySystem {
    public static void main(String[] args) {

        List<TransportService> services = Arrays.asList(
            new BusService("A-B", 25, "08:30"),
            new MetroService("A-C", 40, "09:00"),
            new TaxiService("B-D", 120, "08:15"),
            new AmbulanceService());

        System.out.println("Affordable services(Fare<50):");
        services.stream()
                .filter(s->s.getFare()<50)
                .sorted(Comparator.comparingDouble(TransportService::getFare))
                .forEach(TransportService::printServiceDetails);

        System.out.println("Live dashboard:");
        services.forEach(TransportService::printServiceDetails);

        System.out.println("Emergency priority:");
        services.stream()
                .filter(s->s instanceof EmergencyService)
                .forEach(s->System.out.println(s.getServiceName() + " gets highest priority"));

        List<Passenger> passengers = Arrays.asList(
            new Passenger("Aman", "A-B", 25, true),
            new Passenger("Neha", "A-B", 25, false),
            new Passenger("Raj", "A-C", 40, true),
            new Passenger("Riya", "B-D", 120, true)
        );

        Map<String, List<Passenger>> passengersByRoute =passengers.stream().collect(Collectors.groupingBy(p ->p.route));

        System.out.println("Passengers by route:");
        passengersByRoute.forEach((r, p)-> System.out.println(r +" - "+ p.size()+" passengers"));

        Map<Boolean, List<Passenger>> peakPartition=passengers.stream().collect(Collectors.partitioningBy(p->p.peakTime));

        System.out.println("Peak trips: " + peakPartition.get(true).size());
        System.out.println("Non-peak trips: " + peakPartition.get(false).size());

        DoubleSummaryStatistics revenueStats = passengers.stream().collect(Collectors.summarizingDouble(p -> p.fare));

        System.out.println("Revenue report:");
        System.out.println("Total revenue: "+revenueStats.getSum());
        System.out.println("Average fare: " +revenueStats.getAverage());

        FareCalculator calculator= (distance, rate)->distance * rate;
        double distance =GeoUtils.calculateDistance(12.9, 77.5, 13.0, 77.6);
        System.out.println("Calculated fare: "+calculator.calculateFare(distance, 10));
    }
}
