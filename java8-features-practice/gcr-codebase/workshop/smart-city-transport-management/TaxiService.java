class TaxiService implements TransportService {
    private String route;
    private double fare;
    private String time;

    // Constructor
    public TaxiService(String route, double fare, String time){
        this.route=route;
        this.fare=fare;
        this.time=time;
    }

    // Getters
    public String getServiceName(){
        return "Taxi";
    }

    public double getFare() {
        return fare;
    }

    public String getDepartureTime() {
        return time;
    }

    public String getRoute() {
        return route;
    }
}

