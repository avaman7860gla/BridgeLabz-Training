public class ValidateLicensePlate {
    // method to check license plate is valid or not
    public static boolean isValidLicensePlate(String plate) {
        return plate.matches("^[A-Z]{2}\\d{4}$");
    }

    public static void main(String[] args) {
        // input string
        String plate = "AB1234";
        System.out.println("Is plate valid = "+isValidLicensePlate(plate));
    }
}