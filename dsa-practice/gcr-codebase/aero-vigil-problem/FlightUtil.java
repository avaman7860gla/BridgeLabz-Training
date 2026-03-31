class FlightUtil {
    // to validate flight number
    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException{
        if(!flightNumber.matches("FL-[0-9]{4}")){
            throw new InvalidFlightException("Invalid flight number: " + flightNumber);
        }
        return true;
    }

    // to validate flight name
    public boolean validateFlightName(String flightName) throws InvalidFlightException{
        if (!(flightName.equalsIgnoreCase("SpiceJet")
                || flightName.equalsIgnoreCase("Vistara")
                || flightName.equalsIgnoreCase("IndiGo")
                || flightName.equalsIgnoreCase("Air Arabia"))) {

            throw new InvalidFlightException("Invalid flight name " + flightName);
        }
        return true;
    }

    // to validate passenger count
    public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException{
        int maxCapacity = 0;
        switch (flightName) {
            case "SpiceJet":
                maxCapacity=396;
                break;
            case "Vistara":
                maxCapacity=615;
                break;
            case "IndiGo":
                maxCapacity=230;
                break;
            case "Air Arabia":
                maxCapacity=130;
                break;
        }
        if (passengerCount<=0 || passengerCount>maxCapacity) {
            throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);
        }
        return true;
    }

    // to calculate fuel to fill tank
    public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException{
        double tankCapacity = 0;
        switch (flightName){
            case "SpiceJet":
                tankCapacity=200000;
                break;
            case "Vistara":
                tankCapacity=300000;
                break;
            case "IndiGo":
                tankCapacity=250000;
                break;
            case "Air Arabia":
                tankCapacity=150000;
                break;
        }
        if(currentFuelLevel<0 || currentFuelLevel>tankCapacity){
            throw new InvalidFlightException("Invalid fuel level for " + flightName);
        }
        return tankCapacity-currentFuelLevel;
    }
}
