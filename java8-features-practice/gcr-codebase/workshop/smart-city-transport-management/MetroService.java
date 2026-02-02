class MetroService implements TransportService {
    private String route;
    private double fare;
    private String time;

    // Constructor
    public MetroService(String route, double fare, String time){
        this.route=route;
        this.fare=fare;
        this.time=time;
    }

    // getters
    public String getServiceName(){
        return "Metro";
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
