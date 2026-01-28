import java.util.Scanner;

public class FutureLogistic {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Utility utility = new Utility();

        System.out.println("Enter the Goods Transport details:");
        String inputDetails=sc.nextLine();

        GoodsTransport transport=utility.parseDetails(inputDetails);

        // Validate Transport ID
        if(!utility.validateTransportId(transport.getTransportId())) {
            return;
        }

        // Common details
        System.out.println("Transporter id: " +transport.getTransportId());
        System.out.println("Date of transport: " +transport.getTransportDate());
        System.out.println("Rating of the transport: " +transport.getTransportRating());

        // Identify transport type
        String transportType = utility.findObjectType(transport);

        if (transportType.equals("BrickTransport")) {
            BrickTransport brick = (BrickTransport) transport;
            System.out.println("Quantity of bricks: " +brick.getBrickQuantity());
            System.out.println("Brick price: " +brick.getBrickPrice());
            System.out.println("Vehicle for transport: " +brick.vehicleSelection());
            System.out.println("Total charge: "+brick.calculateTotalCharge());

        }
        else if(transportType.equals("TimberTransport")){
            TimberTransport timber = (TimberTransport) transport;
            System.out.println("Timber type: "+timber.getTimberType());
            System.out.println("Vehicle for transport: " +timber.vehicleSelection());
            System.out.println("Total charge: " +timber.calculateTotalCharge());
        }
    }
}