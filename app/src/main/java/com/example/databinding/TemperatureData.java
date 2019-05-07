package com.example.databinding;

public class TemperatureData {
    private double celsius;
    private String location;

    TemperatureData(String location, double celsius) {
        this.location = location;
        this.celsius = celsius;
    }

    double getCelsius() {
        return celsius;
    }

    void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    String getLocation() {
        return location;
    }

    void setLocation(String location) {
        this.location = location;
    }
}
