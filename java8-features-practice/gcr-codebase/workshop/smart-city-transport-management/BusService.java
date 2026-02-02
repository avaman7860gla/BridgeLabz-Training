class BusService implements TransportService {
    private String route;
    private double fare;
    private String time;

    public BusService(String route, double fare, String time){
        this.route=route;
        this.fare=fare;
        this.time=time;
    }

    public String getServiceName(){
        return "Bus";
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
