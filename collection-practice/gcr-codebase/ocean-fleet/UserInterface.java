import java.util.*;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        VesselUtil v=new VesselUtil();

        System.out.println("Enter number of vessels to added: ");
        int n=sc.nextInt();
        sc.nextLine();

        System.out.println("Enter vessel details:");
        while(n-->0) {
            String input = sc.nextLine().trim();
            String[] parts = input.split(":");
            String vesselId = parts[0];
            String vesselName = parts[1];
            String averageSpeed = parts[2];
            String vesselType = parts[3];

            double avgSpeed = Double.parseDouble(averageSpeed);

            // Add vessels
            v.addVesselPerformance(new Vessel(vesselId, vesselName, avgSpeed, vesselType));
        }
        
        System.out.println("\nEnter the vessel Id to check speed");
        String vId=sc.next();
        Vessel found=v.getVesselById(vId);
        if(found!=null){
            System.out.println(found.getVesselId()+" | "+found.getVesselName()+
                    " | "+found.getVesselType()+" | "+found.getAverageSpeed()+" knots");
        }
        else{
            System.out.println("Vessel Id "+vId+" not found");
        }

        System.out.println("\nHigh performance vessels are ");
        for(Vessel vessel:v.getHighPerformanceVessels()){
            System.out.println(vessel.getVesselId()+" | "+vessel.getVesselName()+
                    " | "+vessel.getVesselType()+" | "
                    +vessel.getAverageSpeed()+" knots");
        }
    }
}