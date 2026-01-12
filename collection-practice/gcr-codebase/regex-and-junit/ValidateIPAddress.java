public class ValidateIPAddress {
    // method to check ip is valid or not
    public static boolean isValidIPAddress(String ip) {
        return ip.matches("^((25[0-5]|2[0-4][0-9]|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?\\d\\d?)$");
    }

    public static void main(String[] args) {
        // input ip
        String ip = "0.0.255";
        // method call and display result
        System.out.println("Is IP valid = "+isValidIPAddress(ip));

    }
}