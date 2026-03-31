package com.unit.demo.files;

public class PasswordValidator {

    // check password is valid or not
    public boolean isValid(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasDigit = false;

        // check for at least one uppercase letter and one digit
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        return hasUppercase && hasDigit;
    }
}
