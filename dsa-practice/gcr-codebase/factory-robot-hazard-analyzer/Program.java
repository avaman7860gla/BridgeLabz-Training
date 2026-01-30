import java.util.Scanner;

public class Program{
    public static void main(String[] args) throws RobotSafetyException{

        // Object creation
        RobortHazardAuditor risk=new RobortHazardAuditor();

        Scanner sc=new Scanner(System.in);
        try{
            // Input of arm precision and validates
            System.out.println("Enter Arm Precision (0.0 - 1.0): ");
            double armPrecision=sc.nextDouble();
            risk.validateArmPrecision(armPrecision);

            // Input of work density and validates
            System.out.println("Enter Worker Density (1 - 20): ");
            int workDensity=sc.nextInt();
            risk.validateWorkDensity(workDensity);

            // Input of machinery state and validates
            System.out.println("Enter Machinery State (Worn/Faulty/Critical): ");
            String machineryState=sc.next();
            risk.validateMachineryState(machineryState);

            // print risk
            System.out.println("Robot Hazard Risk Score: "+ risk.calculateHazardRisk(armPrecision, workDensity, machineryState));
        }
        catch(RobotSafetyException e){
            System.out.println(e.getMessage());
        }

    }
    
}
