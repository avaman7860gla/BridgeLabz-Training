import java.util.Scanner;

interface SecurityUtils {

    // check password is strong or not
    public static boolean isStrongPassword(String password) {
        if (password.length() < 8){
            return false;
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch))
                hasUpper = true;
            else if (Character.isLowerCase(ch))
                hasLower = true;
            else if (Character.isDigit(ch))
                hasDigit = true;
            else
                hasSpecial = true;
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}

public class PasswordValidatorDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        if (SecurityUtils.isStrongPassword(password)) {
            System.out.println("Password is strong");
        } 
        else {
            System.out.println("Password is weak");
        }
    }
}
