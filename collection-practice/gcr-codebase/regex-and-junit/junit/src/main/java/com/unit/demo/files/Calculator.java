package com.unit.demo.files;

public class Calculator {

    // add method
    public int add(int a, int b) {
        return a + b;
    }

      // subtract method
    public int subtract(int a, int b) {
        return a - b;
    }

      // multiply method
    public int multiply(int a, int b) {
        return a * b;
    }

      // divide method
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Addition: " + calc.add(10, 5));
        System.out.println("Subtraction: " + calc.subtract(10, 5));
        System.out.println("Multiplication: " + calc.multiply(10, 5));

        // exception handling
        try {
            System.out.println("Division: " + calc.divide(10, 2));
            System.out.println("Division by zero: " + calc.divide(10, 0));
        } 
        catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
