interface TransportService {
    String getServiceName();
    String getRoute();
    double getFare();
    String getDepartureTime();

    default void printServiceDetails(){
        System.out.println(getServiceName()+", Route: "+getRoute()+", Fare: "+getFare()+", Departure time: "+getDepartureTime());

    }
}
