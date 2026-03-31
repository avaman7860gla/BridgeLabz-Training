package M1_Practice_Problem;
import java.util.Scanner;

public class GlobalShipmentManifestValidator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();

        while(n-->0){
            String input=sc.nextLine();
            String[] parts=input.split("\\|");

            if(parts.length!=5){
                System.out.println("NON-COMPLIANT RECORD");
                continue;
            }

            double weight;

            try{
                weight=Double.parseDouble(parts[3]);
            }
            catch(NumberFormatException e){
                System.out.println("NON-COMPLIANT RECORD");
                continue;
            }

            if(shipmentCode(parts[0]) && shipmentDate(parts[1]) && validateMode(parts[2]) &&
                    validateWeight(weight) && validateDeliveryStatus(parts[4])){
                System.out.println("COMPLIANT RECORD");
            }
            else{
                System.out.println("NON-COMPLIANT RECORD");
            }
        }
    }

    public static boolean shipmentCode(String code){
        return code.matches("^SHIP-(?!.*(\\d)\\1{3})[1-9]\\d{5}$");
    }

    public static boolean shipmentDate(String date){
        return date.matches("^(?:(?:20(?:0[48]|[2468][048]|[13579][26]))-02-29|20\\d{2}-(?:(?:01|03|05|07|08|10|12)-(?:0[1-9]|[12]\\d|3[01])|(?:04|06|09|11)-(?:0[1-9]|[12]\\d|30)|02-(?:0[1-9]|1\\d|2[0-8])))$");
    }

    public static boolean validateMode(String mode){
        return mode.equals("AIR") || mode.equals("SEA") || mode.equals("ROAD") || mode.equals("RAIL") ||
                mode.equals("EXPRESS") || mode.equals("FREIGHT");
    }

    public static boolean validateWeight(double weight){
        if(weight<0 || weight>999999.99) {
            return false;
        }
        String w=String.valueOf(weight);
        if(weight!=0 && w.startsWith("0") && !w.startsWith("0.")) {
            return false;
        }
        String[] wt=w.split("\\.");
        if(wt.length==2 && wt[1].length()>2) {
            return false;
        }
        return true;
    }

    public static boolean validateDeliveryStatus(String status){
        return status.equals("DELIVERED") || status.equals("CANCELLED") || status.equals("IN_TRANSIT");
    }
}
