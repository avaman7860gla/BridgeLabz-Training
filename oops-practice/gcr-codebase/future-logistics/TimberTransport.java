class TimberTransport extends GoodsTransport{
    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    // constructor
    public TimberTransport(String transportId, String transportDate, int transportRating, float timberLength, float timberRadius, String timberType, float timberPrice) {
        super(transportId, transportDate, transportRating);
        this.timberLength=timberLength;
        this.timberRadius=timberRadius;
        this.timberType=timberType;
        this.timberPrice=timberPrice;
    }

    // getters
    public float getTimberLength() {
        return timberLength;
    }

    public float getTimberRadius() {
        return timberRadius;
    }

    public String getTimberType() {
        return timberType;
    }

    public float getTimberPrice() {
        return timberPrice;
    }

    // Vehicle selection method
    @Override
    public String vehicleSelection() {
        float area=(float)(2*3.147*timberRadius*timberLength);
        if(area<250){
            return "Truck";
        }
        else if(area>=250 && area<=400){
            return "Lorry";
        }
        else{
            return "MonsterLorry";
        }
    }

    // Calculate total charge
    @Override
    public float calculateTotalCharge() {
        float volume=(float)(3.147*timberRadius*timberRadius*timberLength);

        float timberTypeFactor=0;
        if(timberType.equalsIgnoreCase("Premium")){
            timberTypeFactor=(float)0.25;
        }
        else{
            timberTypeFactor=(float)0.15;
        }

        float price=volume*timberPrice*timberTypeFactor;

        float tax=(float)0.3*price;

        // Find discount as per rating
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

        String vehicle=vehicleSelection();
        float vehiclePrice=0;
        if(vehicle.equalsIgnoreCase("Truck")) vehiclePrice=1000;
        else if(vehicle.equalsIgnoreCase("Lorry")) vehiclePrice=1700;
        else if(vehicle.equalsIgnoreCase("MonsterLorry")) vehiclePrice=3000;

        float totalCharge=(price+vehiclePrice+tax)-discount;
        return totalCharge;
    }
}