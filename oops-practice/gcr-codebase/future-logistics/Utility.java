class Utility {
    public GoodsTransport parseDetails(String input) {
        String[] details=input.split(":");

        // Extract details from input string
        String transportId=details[0];
        String transportDate=details[1];
        int transportRating=Integer.parseInt(details[2]);
        String transportType=details[3];

        // Return accordingly
        if (transportType.equalsIgnoreCase("BrickTransport")) {
            float brickSize=Float.parseFloat(details[4]);
            int brickQuantity=Integer.parseInt(details[5]);
            float brickPrice=Float.parseFloat(details[6]);

            return new BrickTransport(transportId, transportDate, transportRating, brickSize, brickQuantity, brickPrice);
        }
        else if (transportType.equalsIgnoreCase("TimberTransport")) {
            float timberLength=Float.parseFloat(details[4]);
            float timberRadius=Float.parseFloat(details[5]);
            String timberType=details[6];
            float timberPrice=Float.parseFloat(details[7]);

            return new TimberTransport(transportId, transportDate, transportRating, timberLength, timberRadius, timberType, timberPrice);
        }
        return null;
    }

    // To validate transport id
    public boolean validateTransportId(String transportId) {
        if (transportId.matches("RTS[0-9]{3}[A-Z]")) {
            return true;
        }
        else {
            System.out.println("Invalid transport Id " + transportId);
            return false;
        }
    }

    // To find object type
    public String findObjectType(GoodsTransport goodsTransport) {
        if (goodsTransport instanceof TimberTransport) {
            return "TimberTransport";
        }
        else if (goodsTransport instanceof BrickTransport) {
            return "BrickTransport";
        }
        return null;
    }
}