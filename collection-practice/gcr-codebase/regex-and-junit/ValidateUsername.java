public class ValidateUsername {
    // method to check username is vsalid or not
    public static boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
    }

    public static void main(String[] args) {

        // input username
        String username = "user_123";
        System.out.println("Is username valid = "+isValidUsername(username));
    }
}