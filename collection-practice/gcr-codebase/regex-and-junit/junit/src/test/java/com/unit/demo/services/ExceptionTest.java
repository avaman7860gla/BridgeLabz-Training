package com.unit.demo.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.unit.demo.files.Calculator;

public class ExceptionTest {

    // object creation of calculator class
    Calculator calculator = new Calculator();

    @Test
    void testArithmeticException() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(15, 0);
        });
    }
}
