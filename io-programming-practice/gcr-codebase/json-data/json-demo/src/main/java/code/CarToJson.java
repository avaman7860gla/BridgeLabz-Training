package code;

import org.json.JSONObject;

class Car {

    String brand;
    String model;
    int year;

    // constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}

public class CarToJson {

    public static void main(String[] args) {

        // create object
        Car car = new Car("Toyota", "Fortuner", 2023);

        // convert java object to json
        JSONObject carJson = new JSONObject();
        carJson.put("brand", car.brand);
        carJson.put("model", car.model);
        carJson.put("year", car.year);

        // print json
        System.out.println(carJson.toString(4));
    }
}

