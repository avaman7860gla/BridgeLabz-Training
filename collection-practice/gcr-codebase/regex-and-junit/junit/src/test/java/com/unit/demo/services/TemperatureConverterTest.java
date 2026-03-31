package com.unit.demo.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.unit.demo.files.TemperatureConverter;

// class to test temperature conversion class
public class TemperatureConverterTest {

    TemperatureConverter converter = new TemperatureConverter();

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(98.6, converter.celsiusToFahrenheit(37), 0.1);
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0, converter.fahrenheitToCelsius(32), 0.1);
    }
}
