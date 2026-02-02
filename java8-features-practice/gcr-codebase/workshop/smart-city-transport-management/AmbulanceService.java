class AmbulanceService implements EmergencyService, TransportService{
    public String getServiceName(){
        return "Ambulance";
    }

    public String getRoute(){
        return "Emergency route";
    }

    public double getFare(){
        return 0;
    }

    public String getDepartureTime(){
        return "Immediate";
    }
}
