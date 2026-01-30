abstract class GoodsTransport{
    protected String transportId;
    protected String transportDate;
    protected int transportRating;

    // Abstract methods
    abstract public String vehicleSelection();
    abstract public float calculateTotalCharge();

    // Constructor
    public GoodsTransport(String transportId, String transportDate, int transportRating){
        this.transportId=transportId;
        this.transportDate=transportDate;
        this.transportRating=transportRating;
    }

    // getters
    public String getTransportId() {
        return transportId;
    }

    public String getTransportDate() {
        return transportDate;
    }

    public int getTransportRating() {
        return transportRating;
    }
}