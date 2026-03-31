public class ValidateCreditCard {
    // method to check valid visa card
    public static boolean isValidVisa(String card) {
        return card.matches("^4\\d{15}$");
    }
    // method to check valid master card
    public static boolean isValidMasterCard(String card) {
        return card.matches("^5\\d{15}$");
    }

    public static void main(String[] args) {

        // input card numbers
        String visa = "4123456789012345";
        String masterCard = "5123456789012345";

        // method calling and display result
        System.out.println("Is visa valid = "+isValidVisa(visa));
        System.out.println("Is master card valid = "+isValidMasterCard(masterCard));

    }
}