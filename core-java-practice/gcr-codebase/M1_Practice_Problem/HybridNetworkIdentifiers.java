package M1_Practice_Problem;

import java.util.*;

class NetworkValidator {

    public String validateIdentifier(String input) {
        if(input.contains(" ")){
            return "REJECTED DEVICE";
        }

        if(input.indexOf("::")==-1 || input.indexOf("::")!=input.lastIndexOf("::")){
            return "REJECTED DEVICE";
        }

        String []parts=input.split("::");
        if(parts.length!=2){
            return "REJECTED DEVICE";
        }

        String ipv6=parts[0];
        String mac=parts[1];

        String []ipParts=ipv6.split(":");
        if(ipParts.length!=8){
            return "REJECTED DEVICE";
        }

        for(String group:ipParts){
            if(group.length()<1 || group.length()>4){
                return "REJECTED DEVICE";
            }

            if(!group.matches("[0-9a-fA-F]+")){
                return "REJECTED DEVICE";
            }
        }

        String []macParts=mac.split(":");
        if(macParts.length!=6){
            return "REJECTED DEVICE";
        }

        for(String group:macParts){
            if(group.length()!=2){
                return "REJECTED DEVICE";
            }

            if(!group.matches("[0-9A-F]{2}")){
                return "REJECTED DEVICE";
            }
        }
        return "AUTHENTIC DEVICE";
    }
}

public class HybridNetworkIdentifiers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NetworkValidator validator = new NetworkValidator();

        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String input = sc.nextLine().trim();
            System.out.println(validator.validateIdentifier(input));
        }
    }
}
