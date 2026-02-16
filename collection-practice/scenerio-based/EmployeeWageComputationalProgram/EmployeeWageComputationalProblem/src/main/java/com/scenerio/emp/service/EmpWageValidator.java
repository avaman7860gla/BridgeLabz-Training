package com.scenerio.emp.service;

import java.util.regex.Pattern;

// Input validation using regex
public class EmpWageValidator {
    private static final String companyRegex = "^[A-Z][a-zA-Z ]{2,20}$";
    private static final String numberRegex = "^[1-9][0-9]*$";

    public static boolean validateCompany(String name){
        return Pattern.matches(companyRegex, name);
    }
    public static boolean validateNumber(int num){
        return Pattern.matches(numberRegex, String.valueOf(num));
    }
}
