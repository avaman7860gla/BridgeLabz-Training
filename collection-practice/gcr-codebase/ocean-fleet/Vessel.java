class Vessel{
    private String vesselId;
    private String vesselName;
    private double averageSpeed;
    private String vesselType;

    // Constructor
    public Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType){
        this.vesselId=vesselId;
        this.vesselName=vesselName;
        this.averageSpeed=averageSpeed;
        this.vesselType=vesselType;
    }

    // Getters
    public String getVesselId() {
        return vesselId;
    }

    public String getVesselName() {
        return vesselName;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public String getVesselType() {
        return vesselType;
    }
}