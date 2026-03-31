class BrickTransport extends GoodsTransport{
    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    // constructor
    public BrickTransport(String transportId, String transportDate, int transportRating, float brickSize, int brickQuantity, float brickPrice) {
        super(transportId, transportDate, transportRating);
        this.brickSize=brickSize;
        this.brickQuantity=brickQuantity;
        this.brickPrice=brickPrice;
    }

    // getters
    public float getBrickSize() {
        return brickSize;
    }

    public int getBrickQuantity() {
        return brickQuantity;
    }

    public float getBrickPrice() {
        return brickPrice;
    }

    // To vehicle selection
    @Override
    public String vehicleSelection() {
        int brickQuantity=getBrickQuantity();
        if(brickQuantity<300){
            return "Truck";
        }
        else if(brickQuantity>=300 && brickQuantity<=500){
            return "Lorry";
        }
        else{
            return "MonsterLorry";
        }
    }

    // To calculate total charge
    @Override
    public float calculateTotalCharge() {
        float price=brickPrice*brickQuantity;

        String vehicle=vehicleSelection();
        float vehiclePrice=0;
        if(vehicle.equalsIgnoreCase("Truck")) vehiclePrice=1000;
        else if(vehicle.equalsIgnoreCase("Lorry")) vehiclePrice=1700;
        else if(vehicle.equalsIgnoreCase("MonsterLorry")) vehiclePrice=3000;

        float tax= (float) (0.3*price);

        int rating=getTransportRating();
        float discount=0;
        if(rating==5){
            discount=(float)(0.2*price);
        }
        else if(rating==3 && rating==4){
            discount=(float)(0.1*price);
        }
        else{
            discount=(float)(0);
        }

        float totalCharge=(price+vehiclePrice+tax)-discount;
        return totalCharge;
    }
}