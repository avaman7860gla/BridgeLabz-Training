// Interface
interface TransportService {
    String getServiceName();
    String getRoute();
    double getFare();
    String getDepartureTime();

    // Default method to print details
    default void printServiceDetails(){
        System.out.println(getServiceName()+", Route: "+getRoute()+", Fare: "+getFare()+", Departure time: "+getDepartureTime());

    }
}
